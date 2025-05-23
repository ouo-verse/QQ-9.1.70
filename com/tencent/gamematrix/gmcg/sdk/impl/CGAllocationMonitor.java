package com.tencent.gamematrix.gmcg.sdk.impl;

import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.report.CGReporter;
import com.tencent.gamematrix.gmcg.webrtc.SummaryLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAllocationMonitor {
    private final CGReporter bizStatusReporter = new CGBeaconHttpReporter("0AND06187752FLY8");
    private final CGAllocationCtx mAllocationCtx;

    public CGAllocationMonitor(@NonNull CGAllocationCtx cGAllocationCtx) {
        this.mAllocationCtx = cGAllocationCtx;
    }

    private void putBizStatusCommonData(Map<String, String> map) {
        String str;
        map.put(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, this.mAllocationCtx.pBizId);
        map.put("game_id", this.mAllocationCtx.pCgGameId);
        map.put("cgidentity", this.mAllocationCtx.pUserId);
        map.put("client_os_name", "Android");
        map.put("client_os_version", String.valueOf(Build.VERSION.SDK_INT));
        map.put("client_model", this.mAllocationCtx.pDeviceModel);
        map.put("client_brand", this.mAllocationCtx.pDeviceBrand);
        if (GmCgSdk.isAllTvBiz()) {
            str = "TV";
        } else {
            str = "phone";
        }
        map.put("client_platform", str);
        int i3 = this.mAllocationCtx.pServerType;
        if (i3 == 3) {
            i3 = 0;
        }
        map.put("server_env", String.valueOf(i3));
        map.put("event_timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("client_sdk_version", "3.0.0.241111110.3.9-SNAPSHOT");
        map.put("client_sdk_type", "AndroidNative");
        map.put("xid", this.mAllocationCtx.pXid);
        map.put("oaid", this.mAllocationCtx.pOaid);
        map.put("soc", this.mAllocationCtx.pSoc);
        map.put("net_type", CGNetworkUtil.getNetworkTypeSymbol(CGGlbConfig.getAppContext()));
        map.put("client_package_name", CGGlbConfig.getPackageName());
    }

    private void reportBizStatus(String str, @Nullable int[] iArr, @Nullable String[] strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", str);
        putBizStatusCommonData(hashMap);
        int i3 = 0;
        if (iArr != null) {
            int i16 = 0;
            while (i16 < iArr.length) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("int_ext");
                int i17 = i16 + 1;
                sb5.append(i17);
                hashMap.put(sb5.toString(), String.valueOf(iArr[i16]));
                i16 = i17;
            }
        }
        if (strArr != null) {
            while (i3 < strArr.length) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("str_ext");
                int i18 = i3 + 1;
                sb6.append(i18);
                hashMap.put(sb6.toString(), strArr[i3]);
                i3 = i18;
            }
        }
        this.bizStatusReporter.report(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportAllocDeviceCallback(int i3, boolean z16, boolean z17) {
        int[] iArr;
        if (i3 != 0) {
            iArr = new int[]{i3};
        } else if (z16) {
            SummaryLog.get().cancelDeviceAllocBegin();
            iArr = new int[]{i3, 2};
        } else {
            SummaryLog.get().markDeviceAllocEnd();
            CGSessionMonitor.allocEndTimeStamp = SystemClock.elapsedRealtime();
            iArr = new int[]{i3, 1, z17 ? 1 : 0};
        }
        reportBizStatus("AllocDeviceCallback", iArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallAllocDevice() {
        SummaryLog.get().markDeviceAllocBegin();
        reportBizStatus("CallAllocDevice", null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportQueueSuccessCallback(@NonNull CGAllocationCtx cGAllocationCtx) {
        reportBizStatus("QueueSuccessCallback", null, null);
    }
}
