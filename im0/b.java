package im0;

import android.app.Activity;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hm0.WXMiniSessionData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b\u00a8\u0006#"}, d2 = {"Lim0/b;", "", "", "linkEventId", "Lhm0/a;", "sessionData", "errorCode", "", "c", "Lcom/tencent/ad/tangram/protocol/link_report$LinkReport$ReportBiz;", "a", "adErrorCode", "", "b", "k", "", "exist", "f", "loadSuccess", "g", "hasAuth", "d", "authSuccess", "e", "success", "j", h.F, "Lcom/tencent/ad/tangram/wechat/AdWXMINIProgram$Params;", "params", "Lcom/tencent/ad/tangram/AdError;", "adError", "i", "l", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407984a = new b();

    b() {
    }

    private final link_report.LinkReport.ReportBiz a(WXMiniSessionData sessionData, int errorCode) {
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.aid = sessionData.getAid();
        reportBiz.pid = sessionData.getPosId();
        reportBiz.traceid = sessionData.getTraceId();
        reportBiz.wx_sdk_method = 3;
        reportBiz.preload_status_code = 0;
        reportBiz.origin_error_code = errorCode;
        reportBiz.mini_program_open_type = sessionData.getFinalJumpType().getValue();
        return reportBiz;
    }

    private final int[] b(int adErrorCode) {
        int[] iArr = new int[0];
        if (adErrorCode != 0) {
            if (adErrorCode != 4) {
                if (adErrorCode != 12 && adErrorCode != 14) {
                    if (adErrorCode == 151) {
                        return new int[]{4006002, 4006006, 4006009};
                    }
                    return iArr;
                }
                return new int[]{4006002, 4006007};
            }
            return new int[]{4006003};
        }
        return new int[]{4006002, 4006006, 4006008};
    }

    private final void c(int linkEventId, WXMiniSessionData sessionData, int errorCode) {
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 2, "reportForLinkEvent, event: " + linkEventId + ", data: " + sessionData + ", errorCode: " + errorCode);
        }
        if (!sessionData.getReportForLink()) {
            return;
        }
        AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), linkEventId, null, a(sessionData, errorCode), null);
    }

    public final void d(boolean hasAuth, @NotNull WXMiniSessionData sessionData, int errorCode) {
        int i3;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (hasAuth) {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_AUTHORIZED;
        } else {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_UNAUTHORIZED;
        }
        c(i3, sessionData, errorCode);
    }

    public final void e(boolean authSuccess, @NotNull WXMiniSessionData sessionData, int errorCode) {
        int i3;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (authSuccess) {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_AUTHORIZE_SUCCESS;
        } else {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_AUTHORIZE_FAILED;
        }
        c(i3, sessionData, errorCode);
    }

    public final void f(boolean exist, @NotNull WXMiniSessionData sessionData) {
        int i3;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (exist) {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_DYNAMIC_PACKAGE_EXISTS;
        } else {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_DYNAMIC_PACKAGE_NOT_EXISTS;
        }
        c(i3, sessionData, 0);
    }

    public final void g(boolean loadSuccess, @NotNull WXMiniSessionData sessionData, int errorCode) {
        int i3;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (loadSuccess) {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_INITIALIZE_DYNAMIC_PACKAGE_SUCCESS;
        } else {
            i3 = sdk_event_log.SdkEventDimension.EVENT_WECHAT_LUGGAGE_INITIALIZE_DYNAMIC_PACKAGE_FAILED;
        }
        c(i3, sessionData, errorCode);
    }

    public final void h(@NotNull WXMiniSessionData sessionData, int errorCode) {
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (!sessionData.getReportForLink()) {
            QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 1, "[reportForLinkEventOnEndWithOpenSDKNewRoute] do nothing");
            return;
        }
        for (int i3 : b(errorCode)) {
            c(i3, sessionData, errorCode);
        }
    }

    public final void i(@NotNull AdWXMINIProgram.Params params, @NotNull AdError adError) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(adError, "adError");
        if (!params.reportForLinkEvent) {
            QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 1, "[reportForLinkEventOnEndWithOpenSDKOldRoute] do nothing");
            return;
        }
        QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 1, "[reportForLinkEventOnEndWithOpenSDK] errorCode:" + adError.getErrorCode());
        int[] b16 = b(adError.getErrorCode());
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.wx_sdk_method = 3;
        reportBiz.preload_status_code = 0;
        for (int i3 : b16) {
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), i3, params.f61351ad, reportBiz, null);
        }
    }

    public final void j(boolean success, @NotNull WXMiniSessionData sessionData, int errorCode) {
        int i3;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (success) {
            i3 = 4006008;
        } else {
            i3 = 4006009;
        }
        c(i3, sessionData, errorCode);
    }

    public final void k(@NotNull WXMiniSessionData sessionData) {
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        c(4006001, sessionData, 0);
    }

    public final void l(@NotNull AdWXMINIProgram.Params params) {
        Activity activity;
        Intrinsics.checkNotNullParameter(params, "params");
        if (!params.reportForLinkEvent) {
            QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 1, "[reportForLinkEventOnStartOld] do nothing");
            return;
        }
        QLog.i("GdtWXMINIProgramLinkedEventReportHelper", 1, "[reportForLinkEventOnStartOld]");
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.wx_sdk_method = 3;
        reportBiz.preload_status_code = 0;
        AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
        WeakReference<Activity> weakReference = params.weakActivity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        adReporterForLinkEvent.reportAsync(activity, 4006001, params.f61351ad, reportBiz, null);
    }
}
