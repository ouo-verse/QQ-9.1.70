package com.qzone.report;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.utils.d;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.open.adapter.a;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.QZLog;
import fo.c;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0007J0\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0007J*\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0006\u0010\u001c\u001a\u00020\u0004JD\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015J0\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u001e\u0010*\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'J\u0016\u0010-\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.J&\u00104\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004J.\u00107\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0006J\u0016\u00109\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004R\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010:R\u001b\u0010@\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/qzone/report/QZonePerfReporter;", "", "", "appType", "", "uid", "", "detailCode", "serverCode", "stepCode", "errMsg", "", DomainData.DOMAIN_NAME, "sessionId", "successCount", "fainCount", "o", "eventCode", "Lorg/json/JSONObject;", "eventValue", "curPage", "", "shouldSample", "g", "d", "b", "shouldReport", "f", "c", "pageName", "pageShowCost", "feedShowCost", "isWarmLaunch", "scene", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "requestName", "costTime", QzoneIPCModule.RESULT_CODE, ReportConstant.COSTREPORT_PREFIX, "", "smoothValue", "fps", "p", "reason", QCircleWeakNetReporter.KEY_COST, "i", "", "throwable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", "contentType", "businessType", "k", "isSuccess", "duration", "l", "codeName", "j", "Ljava/lang/String;", "mSessionId", "mChannel", "Lkotlin/Lazy;", "e", "()Z", "mShouldReport", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePerfReporter {

    /* renamed from: a, reason: collision with root package name */
    public static final QZonePerfReporter f59697a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String mSessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String mChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mShouldReport;

    static {
        Lazy lazy;
        QZonePerfReporter qZonePerfReporter = new QZonePerfReporter();
        f59697a = qZonePerfReporter;
        mChannel = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.qzone.report.QZonePerfReporter$mShouldReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean b16;
                b16 = QZonePerfReporter.f59697a.b();
                return Boolean.valueOf(b16);
            }
        });
        mShouldReport = lazy;
        mSessionId = qZonePerfReporter.c();
    }

    QZonePerfReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b() {
        int E0;
        g gVar = g.f53821a;
        if (gVar.b().b0() && LoginData.getInstance().getUin() != 0 && (E0 = gVar.b().E0()) > 0) {
            return E0 >= 100 || Random.INSTANCE.nextInt(100) <= E0;
        }
        return false;
    }

    private final String d() {
        String str = mChannel;
        if (str == null || str.length() == 0) {
            mChannel = "public";
        }
        String str2 = mChannel;
        return str2 == null ? "" : str2;
    }

    private final boolean e() {
        return ((Boolean) mShouldReport.getValue()).booleanValue();
    }

    private final void f(String eventCode, JSONObject eventValue, boolean shouldReport) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzonePerfReporter", 2, "report eventCode: " + eventCode + ", eventValue: " + eventValue + ", shouldReport: " + shouldReport);
        }
    }

    @JvmStatic
    public static final void g(String eventCode, JSONObject eventValue, String curPage, boolean shouldSample) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(eventValue, "eventValue");
        Intrinsics.checkNotNullParameter(curPage, "curPage");
        QZonePerfReporter qZonePerfReporter = f59697a;
        if (!qZonePerfReporter.e() && shouldSample) {
            QZLog.i("QzonePerfReporter", 2, "report should filter, return");
            return;
        }
        eventValue.put(WadlProxyConsts.CHANNEL, qZonePerfReporter.d());
        qZonePerfReporter.f(eventCode, eventValue, true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, eventCode);
        if (d.f54318a.b()) {
            linkedHashMap.put(QZoneDTLoginReporter.PAGE_STYLE, 1);
        } else {
            linkedHashMap.put(QZoneDTLoginReporter.PAGE_STYLE, 0);
        }
        linkedHashMap.put("now_page", curPage);
        String i3 = a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        String jSONObject = eventValue.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject);
        c.c("ev_qz_performance", linkedHashMap);
    }

    @JvmStatic
    public static final void n(int appType, String uid, long detailCode, long serverCode, int stepCode, String errMsg) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("upload_app_type", appType);
        jSONObject.put("uid", uid);
        jSONObject.put("step_code", stepCode);
        jSONObject.put("code", detailCode);
        jSONObject.put("srv_code", serverCode);
        jSONObject.put("err_msg", errMsg);
        h("file_upload", jSONObject, "", false, 8, null);
    }

    @JvmStatic
    public static final void o(int appType, String uid, String sessionId, int successCount, int fainCount) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("upload_app_type", appType);
        jSONObject.put("uid", uid);
        jSONObject.put("upload_session_id", sessionId);
        jSONObject.put("success_count", successCount);
        jSONObject.put("fail_count", fainCount);
        h("mission_upload", jSONObject, "", false, 8, null);
    }

    public final String c() {
        return Process.myUid() + "_" + System.currentTimeMillis();
    }

    public final void i(String reason, long cost) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reason", reason);
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, cost);
        h("block_reason", jSONObject, "", false, 8, null);
    }

    public final void j(String scene, String codeName) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(codeName, "codeName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", codeName);
        jSONObject.put("scene", scene);
        h("code_usage", jSONObject, "", false, 8, null);
    }

    public final void k(String url, String contentType, String businessType, String scene) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(scene, "scene");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", url);
        jSONObject.put("content_type", contentType);
        jSONObject.put("business_type", businessType);
        jSONObject.put("scene", scene);
        h("download_picture", jSONObject, "", false, 8, null);
    }

    public final void l(String url, boolean isSuccess, String businessType, String scene, long duration) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(scene, "scene");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", url);
        jSONObject.put(VRReportDefine$ReportParam.IS_SUCCESS, isSuccess);
        jSONObject.put("business_type", businessType);
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, duration);
        jSONObject.put("scene", scene);
        h(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, jSONObject, "", false, 8, null);
    }

    public final void m(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stack", Log.getStackTraceString(throwable));
        g("fatal_error", jSONObject, "", false);
    }

    public final void p(String pageName, float smoothValue, float fps) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_name", pageName);
        jSONObject.put("smooth_value", String.valueOf(smoothValue));
        jSONObject.put("fps", String.valueOf(fps));
        h("page_fluency", jSONObject, pageName, false, 8, null);
    }

    public final void q(String pageName, long pageShowCost, long feedShowCost, boolean isWarmLaunch, String sessionId, String scene, boolean shouldSample) {
        String str;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_name", pageName);
        jSONObject.put("page_show_cost", String.valueOf(pageShowCost));
        jSONObject.put("feed_show_cost", String.valueOf(feedShowCost));
        if (isWarmLaunch) {
            str = "1";
        } else {
            str = "0";
        }
        jSONObject.put("is_warm_launch", str);
        jSONObject.put(ServiceConst.PARA_SESSION_ID, sessionId);
        if (!TextUtils.isEmpty(scene)) {
            jSONObject.put("scene", scene);
        }
        g(BuglyMonitorName.PAGE_LAUNCH, jSONObject, pageName, shouldSample);
    }

    public final void s(String requestName, long costTime, int resultCode, String sessionId, boolean shouldSample) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", requestName);
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, costTime);
        jSONObject.put("code", resultCode);
        jSONObject.put(ServiceConst.PARA_SESSION_ID, sessionId);
        g("request_monitor", jSONObject, "", shouldSample);
    }

    public static /* synthetic */ void h(String str, JSONObject jSONObject, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        g(str, jSONObject, str2, z16);
    }
}
