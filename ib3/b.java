package ib3;

import android.content.pm.PackageInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mobileqq.wxapi.WXPayHelper;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaPerformanceMetrics;
import com.tencent.mobileqq.wxmini.impl.report.WxaStartupReportData;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import fb3.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.util;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0002J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001aJ*\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006%"}, d2 = {"Lib3/b;", "", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "", "wxAppid", "Lcom/tencent/mobileqq/wxmini/impl/launcher/r;", "metrics", "", "i", "Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "reportData", AdMetricTag.EVENT_NAME, "c", "data", "d", "qqUin", "", "a", QQCustomArkDialogUtil.META_DATA, "b", "g", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, h.F, "f", "", "authType", "Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;", "errCode", "errMsg", "e", "l", "j", "k", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f407378a = new b();

    b() {
    }

    private final Map<String, String> a(String qqUin, WxaStartupReportData data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(StartupReportKey.STARTUP_ID, data.getStartupId());
        linkedHashMap.put(StartupReportKey.USER_UIN, qqUin);
        linkedHashMap.put("meta_data", data.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String());
        linkedHashMap.put(StartupReportKey.META_TYPE, String.valueOf(data.getMetaType()));
        String A = i.w().A();
        Intrinsics.checkNotNullExpressionValue(A, "getInstance().sdkVersion");
        linkedHashMap.put(StartupReportKey.SDK_VERSION, A);
        linkedHashMap.put(StartupReportKey.PLATFORM_ID, "0");
        linkedHashMap.put("host_scene", String.valueOf(data.getStartupScene()));
        linkedHashMap.put("device_level", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        linkedHashMap.put("version_type", String.valueOf(data.getVersionType()));
        linkedHashMap.put(StartupReportKey.WXAPP_INSTALL_FLAG, String.valueOf(data.getWxappInstallFlag()));
        linkedHashMap.put(StartupReportKey.EVENT_TIME, String.valueOf(data.getEventTime()));
        linkedHashMap.put(StartupReportKey.DEBUG_FLAG, "0");
        linkedHashMap.put(StartupReportKey.TID_USERID, data.getTidUserId());
        d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        String f16 = bindingWeChatUserInfo != null ? bindingWeChatUserInfo.f() : null;
        if (f16 == null) {
            f16 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(f16, "QRoute.api(IWxMiniManage\u2026hatUserInfo?.openId ?: \"\"");
        }
        linkedHashMap.put(StartupReportKey.WX_OPENID, f16);
        linkedHashMap.put(StartupReportKey.SCENE_NOTE, data.getSceneNote());
        linkedHashMap.put(StartupReportKey.RELATIVE_RESULT, String.valueOf(data.getRelativeResult()));
        linkedHashMap.put(StartupReportKey.AUTH_TYPE, String.valueOf(data.getAuthType()));
        linkedHashMap.put("error_code", String.valueOf(data.getErrCode()));
        linkedHashMap.put("error_msg", data.getErrMsg());
        linkedHashMap.put("applet_appid", data.getWxAppId());
        linkedHashMap.put(StartupReportKey.COLD_LAUNCH, String.valueOf(data.getColdLaunch()));
        linkedHashMap.put(StartupReportKey.HIT_PRELOAD, String.valueOf(data.getHitPreload()));
        linkedHashMap.put(StartupReportKey.HIT_PKG_CACHE, String.valueOf(data.getHitPkgCache()));
        linkedHashMap.put(StartupReportKey.WX_VERSION, data.getWxVersion());
        return linkedHashMap;
    }

    private final String b(String metaData) {
        return System.currentTimeMillis() + util.base64_pad_url + ((int) (Math.random() * 1000)) + util.base64_pad_url + metaData;
    }

    private final WxaStartupReportData c(WxaStartupReportData reportData, String eventName) {
        WxaStartupReportData a16 = WxaStartupReportData.INSTANCE.a(reportData);
        a16.A(eventName);
        a16.B(System.currentTimeMillis());
        return a16;
    }

    private final void d(WxaStartupReportData data) {
        AppRuntime runtime;
        QLog.i("[wxa-q]WxaStartupReportUtil", 1, "start_up_report:" + data);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String currentUin = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getCurrentUin();
        if (currentUin == null) {
            return;
        }
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).reportStartup(data.getCom.tencent.ad.tangram.statistics.metric.AdMetricTag.EVENT_NAME java.lang.String(), a(currentUin, data));
    }

    private final void i(WxaInfo wxaInfo, String wxAppid, WxaPerformanceMetrics metrics) {
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        WxaStartupReportData c16 = c(startupReportData, "ev_applet_startup_launch_metrics_result");
        if (wxAppid == null) {
            wxAppid = "";
        }
        c16.b0(wxAppid);
        if (metrics != null) {
            c16.x(metrics.getIsColdLaunch() ? 1 : 2);
            c16.D(metrics.getIsHitPreload() ? 1 : 2);
            c16.C(metrics.getIsHitPkgCache() ? 1 : 2);
        }
        d(c16);
    }

    public final void e(WxaInfo wxaInfo, int authType, TdiAuthErrCode errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        WxaStartupReportData c16 = c(startupReportData, "ev_applet_startup_auth_result");
        c16.w(authType);
        c16.G(errCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK ? 1 : 2);
        c16.y(errCode.ordinal());
        String str = "";
        if (errMsg == null) {
            errMsg = "";
        }
        c16.z(errMsg);
        if (errCode == TdiAuthErrCode.WechatTdi_Auth_Err_WechatVersionTooLow) {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), "com.tencent.mm", 0);
                String str2 = packageInfo != null ? packageInfo.versionName : null;
                if (str2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "BaseApplication.getConte\u2026m\", 0)?.versionName ?: \"\"");
                    str = str2;
                }
            } catch (Throwable th5) {
                QLog.e("[wxa-q]WxaStartupReportUtil", 1, "get mm packageinfo failed", th5);
                str = "unknown";
            }
            c16.c0(str);
        }
        d(c16);
    }

    public final void f(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        d(c(startupReportData, "ev_applet_startup_auth_start"));
    }

    public final WxaStartupReportData g(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        if (wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String().length() == 0) {
            return null;
        }
        WxaStartupReportData wxaStartupReportData = new WxaStartupReportData();
        wxaStartupReportData.N(f407378a.b(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String()));
        wxaStartupReportData.A("ev_applet_startup_begin");
        wxaStartupReportData.E(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String());
        wxaStartupReportData.F(wxaInfo.getMetaType());
        wxaStartupReportData.V(wxaInfo.getScene());
        wxaStartupReportData.a0(wxaInfo.getVersionType());
        wxaStartupReportData.B(System.currentTimeMillis());
        Object obj = wxaInfo.a().get(StartupReportKey.SCENE_NOTE);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        wxaStartupReportData.M(str);
        try {
            wxaStartupReportData.d0(WXPayHelper.getInstance().isWXinstalled() ? 1 : 0);
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaStartupReportUtil", 1, e16, new Object[0]);
        }
        String B = i.w().B();
        Intrinsics.checkNotNullExpressionValue(B, "getInstance().tdiUserId");
        wxaStartupReportData.Z(B);
        d(wxaStartupReportData);
        return wxaStartupReportData;
    }

    public final void h(WxaInfo wxaInfo, boolean loadResult) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        WxaStartupReportData c16 = c(startupReportData, "ev_applet_startup_load_dynamic_package");
        c16.G(loadResult ? 1 : 2);
        d(c16);
    }

    public final void j(WxaInfo wxaInfo, String wxAppid, int errCode) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        k(wxaInfo, wxAppid, errCode, null);
    }

    public final void k(WxaInfo wxaInfo, String wxAppid, int errCode, WxaPerformanceMetrics metrics) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        WxaStartupReportData c16 = c(startupReportData, "ev_applet_startup_launch_result");
        c16.b0(wxAppid == null ? "" : wxAppid);
        c16.G(errCode == 0 ? 1 : 2);
        c16.y(errCode);
        String errMsg = c16.getErrMsg();
        c16.z(errMsg != null ? errMsg : "");
        d(c16);
        i(wxaInfo, wxAppid, metrics);
    }

    public final void l(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        if (startupReportData == null) {
            return;
        }
        d(c(startupReportData, "ev_applet_startup_launch_start"));
    }
}
