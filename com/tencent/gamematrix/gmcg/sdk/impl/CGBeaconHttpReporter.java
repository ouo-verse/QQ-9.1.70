package com.tencent.gamematrix.gmcg.sdk.impl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGGsonBodyRequest;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSharedPrefUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.report.CGReporter;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.local_edit.andserver.util.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGBeaconHttpReporter implements CGReporter {
    private static final String BEACON_REPORT_URL = "https://otheve.beacon.qq.com/analytics/v2_upload";
    private static final Map<String, String> HEADER;
    private static final int MAX_RETRY_COUNT = 3;
    private static String UNIQUE_IDENTIFICATION;
    private final Map<String, Integer> failRetryRecord = new HashMap();
    private final Handler mHandler = new Handler();
    private final String mainAppKey;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes6.dex */
    public static class BeaconUploadBody {
        public final String appVersion;

        /* renamed from: common, reason: collision with root package name */
        public Map<String, Object> f107701common;
        public List<Map<String, Object>> events;
        public final String mainAppKey;
        public final String sdkId = "android";
        public final String sdkVersion = "1.0.0-android";
        public final int platformId = 3;

        public BeaconUploadBody(String str, String str2, String str3, Map<String, Object> map) {
            this.mainAppKey = str;
            this.appVersion = TextUtils.isEmpty(str3) ? "2.11.1" : str3;
            ArrayList arrayList = new ArrayList(1);
            this.events = arrayList;
            arrayList.add(map);
            HashMap hashMap = new HashMap(1);
            this.f107701common = hashMap;
            hashMap.put(NowProxyConstants.AccountInfoKey.A2, str2);
        }
    }

    static {
        HashMap hashMap = new HashMap(1);
        HEADER = hashMap;
        hashMap.put("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    public CGBeaconHttpReporter(String str) {
        this.mainAppKey = str;
    }

    private String getUniqueIdentification() {
        if (!isIdInvalid(UNIQUE_IDENTIFICATION)) {
            return UNIQUE_IDENTIFICATION;
        }
        if (initUniqueIdentification(CGGlbConfig.getXID())) {
            CGLog.i("Beacon unique identification use xid " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        if (initUniqueIdentification(CGGlbConfig.getQIMEI36())) {
            CGLog.i("Beacon unique identification use qimei36 " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        if (initUniqueIdentification(CGGlbConfig.getQIMEI())) {
            CGLog.i("Beacon unique identification use qimei " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        if (initUniqueIdentification(CGGlbConfig.getOAID())) {
            CGLog.i("Beacon unique identification use oaid " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        if (initUniqueIdentification(CGGlbConfig.getAndroidId())) {
            CGLog.i("Beacon unique identification use android id " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        Context appContext = CGGlbConfig.getAppContext();
        String str = (String) CGSharedPrefUtil.get(appContext, "UNIQUE_IDENTIFICATION", "");
        if (TextUtils.isEmpty(str)) {
            String uuid = UUID.randomUUID().toString();
            UNIQUE_IDENTIFICATION = uuid;
            CGSharedPrefUtil.put(appContext, "UNIQUE_IDENTIFICATION", uuid);
            CGLog.i("Beacon unique identification use generated uuid " + UNIQUE_IDENTIFICATION);
            return UNIQUE_IDENTIFICATION;
        }
        UNIQUE_IDENTIFICATION = str;
        CGLog.i("Beacon unique identification use stored uuid " + UNIQUE_IDENTIFICATION);
        return UNIQUE_IDENTIFICATION;
    }

    private boolean initUniqueIdentification(String str) {
        if (isIdInvalid(str)) {
            return false;
        }
        UNIQUE_IDENTIFICATION = str;
        return true;
    }

    private boolean isIdInvalid(String str) {
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !UploadVideoObject.VODEO_FORMAT_UNKNOW.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$report$1(final String str, final Map map, final long j3, VolleyError volleyError) {
        long j16;
        try {
            final Integer num = this.failRetryRecord.get(str);
            Handler handler = this.mHandler;
            Runnable runnable = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGBeaconHttpReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    Integer num2 = num;
                    if (num2 == null) {
                        CGBeaconHttpReporter.this.failRetryRecord.put(str, 0);
                        CGBeaconHttpReporter.this.report(map, str, j3);
                    } else if (num2.intValue() >= 3) {
                        CGBeaconHttpReporter.this.failRetryRecord.remove(str);
                    } else {
                        CGBeaconHttpReporter.this.failRetryRecord.put(str, Integer.valueOf(num.intValue() + 1));
                        CGBeaconHttpReporter.this.report(map, str, j3);
                    }
                }
            };
            if (num != null) {
                j16 = num.intValue() * 500;
            } else {
                j16 = 0;
            }
            handler.postDelayed(runnable, j16);
        } catch (Exception e16) {
            CGLog.i(e16.getMessage());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.report.CGReporter
    public void report(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        report(map, "CGBeaconHttpReport@" + currentTimeMillis, currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(final Map<String, String> map, final String str, final long j3) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eventCode", "client");
        hashMap.put("eventTime", String.valueOf(j3));
        hashMap.put("mapValue", map);
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, BEACON_REPORT_URL, Void.class, HEADER, null, CGJsonUtil.toJson(new BeaconUploadBody(this.mainAppKey, getUniqueIdentification(), map.get("sdkVersion"), hashMap)), new h.b() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.y
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGBeaconHttpReporter.lambda$report$0((Void) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.z
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGBeaconHttpReporter.this.lambda$report$1(str, map, j3, volleyError);
            }
        });
        cGGsonBodyRequest.setTag(str);
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$report$0(Void r06) {
    }
}
