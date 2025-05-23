package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a implements AdReporterForLinkEvent.Adapter {
    public static final String TAG = "AdLinkReporterAdapter";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ad.tangram.statistics.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0514a implements Runnable {
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ JSONObject val$jsonObject;

        RunnableC0514a(byte[] bArr, JSONObject jSONObject) {
            this.val$data = bArr;
            this.val$jsonObject = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdHttp.Params params = new AdHttp.Params();
            params.setUrl("https://sdkreport.e.qq.com/link_event");
            params.method = "POST";
            params.contentType = "application/json";
            params.requestData = this.val$data;
            if (!params.canSend()) {
                AdLog.e(a.TAG, "reportAsync to link event error");
            } else {
                AdHttp.send(params);
                AdLog.i(a.TAG, String.format(Locale.getDefault(), "reportAsync to link event responseCode:%d durationMillis:%d %s", Integer.valueOf(params.responseCode), Long.valueOf(params.durationMillis), this.val$jsonObject.toString()));
            }
        }
    }

    @NonNull
    private static JSONObject buildParams(@Nullable Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            link_report.LinkReport linkReport = new link_report.LinkReport();
            linkReport.f61326av = AdVersion.getInstance().getAppVersion();
            linkReport.f61327ct = AdNet.getType(context);
            linkReport.f61328os = 2;
            linkReport.f61329ov = Build.VERSION.RELEASE;
            if (context != null && context.getApplicationContext() != null) {
                str = context.getApplicationContext().getPackageName();
            } else {
                str = "";
            }
            linkReport.pkg = str;
            linkReport.sdk_st = 9;
            Object fromObject = AdJSON.fromObject(linkReport);
            if (fromObject instanceof JSONObject) {
                return (JSONObject) fromObject;
            }
            return jSONObject;
        } catch (Throwable th5) {
            AdLog.e(TAG, th5.getMessage());
            return jSONObject;
        }
    }

    @Override // com.tencent.ad.tangram.statistics.AdReporterForLinkEvent.Adapter
    public void reportAsync(Context context, int i3, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject buildParams = buildParams(context);
        try {
            link_report.LinkReport.ReportEvent reportEvent = new link_report.LinkReport.ReportEvent();
            reportEvent.seq = 1;
            reportEvent.f61332ts = System.currentTimeMillis();
            reportEvent.f61331ei = i3;
            JSONObject jSONObject3 = new JSONObject();
            Object fromObject = AdJSON.fromObject(reportEvent);
            if (fromObject instanceof JSONObject) {
                jSONObject3 = (JSONObject) fromObject;
            }
            jSONObject3.put("biz", jSONObject);
            jSONObject3.put("ext", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject3);
            buildParams.put(LinkReportConstant$GlobalKey.EVENTS, jSONArray);
        } catch (Throwable th5) {
            AdLog.e(TAG, "reportAsync buildParams", th5);
        }
        AdLog.i(TAG, "reportAsync " + buildParams.toString());
        reportAsync(buildParams);
    }

    private static void reportAsync(@NonNull JSONObject jSONObject) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject) || jSONObject.length() <= 0) {
            return;
        }
        AdThreadManager.getInstance().post(new RunnableC0514a(jSONObject.toString().getBytes(), jSONObject), 4);
    }
}
