package com.tencent.mobileqq.vas.vipicon.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.util.IVasNamePlateUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconClick;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0002J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipIconClickImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick;", "Landroid/view/View;", "v", "", "id", "", "uin", "from", "", "interceptForGame", "isGray", "", "reportClick", "Landroid/content/Context;", "context", "url", "openQQBrowserWithoutAD", "actionName", "report", "pageId", "moduleId", "isClick", "realReport04586", "getGameConfig", "Landroid/view/View$OnClickListener;", "newClickListener", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick$Info;", "info", "report04586", "Ljava/util/concurrent/ConcurrentHashMap;", "", "exposeHistory", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipIconClickImpl implements IVipIconClick {

    @NotNull
    public static final String DEFAULTURL = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_nameplate&bundle_name=vas_qqvip_nameplate&kr_turbo_display=1&enteranceId=moren";

    @NotNull
    public static final String TAG = "IVipIconClick";

    @NotNull
    private final ConcurrentHashMap<String, Long> exposeHistory = new ConcurrentHashMap<>();

    private final String getGameConfig(int id5) {
        String stringDataSet = VasLongToggle.GAME_NAMEPLATE_CONFIG.getStringDataSet(String.valueOf(id5), "");
        if (TextUtils.isEmpty(stringDataSet)) {
            return null;
        }
        try {
            String optString = new JSONObject(stringDataSet).optString("url");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return optString;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    private final boolean interceptForGame(View v3, int id5, String uin, String from) {
        String gameConfig = getGameConfig(id5);
        if (gameConfig != null) {
            report04586(id5, true, from);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                iVasHybridRoute.openBrowser(context, gameConfig);
            } else {
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                openQQBrowserWithoutAD(context2, gameConfig, uin);
            }
            return true;
        }
        return false;
    }

    private final void openQQBrowserWithoutAD(Context context, String url, String uin) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", uin);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(context, url, 256L, intent, false, -1);
    }

    private final void realReport04586(int id5, String pageId, String moduleId, boolean isClick) {
        int i3;
        IMobileReportManager iMobileReportManager = (IMobileReportManager) QRoute.api(IMobileReportManager.class);
        String valueOf = String.valueOf(id5);
        if (isClick) {
            i3 = 102;
        } else {
            i3 = 101;
        }
        iMobileReportManager.reportAction(valueOf, WadlProxyConsts.OPER_TYPE_APK_SIGN, SearchConstants.PLATFORM, pageId, moduleId, i3, 0, System.currentTimeMillis());
    }

    private final void report(String actionName, int id5, boolean isGray) {
        int i3;
        if (isGray) {
            i3 = 9;
        } else {
            i3 = 0;
        }
        ReportController.n(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, actionName, i3, 1, id5, "", "", "", "");
    }

    private final void reportClick(String from, int id5, boolean isGray) {
        if (Intrinsics.areEqual("VIA_SETTINGME", from)) {
            report("0X800AA9D", id5, isGray);
            return;
        }
        if (Intrinsics.areEqual("VIA_PROFILECARD", from)) {
            report("0X800AA9E", id5, isGray);
            return;
        }
        if (Intrinsics.areEqual("VIA_AIO_TITLE", from)) {
            report("0X800AA9F", id5, isGray);
        } else if (Intrinsics.areEqual("VIA_AIO_CHATSETTINGS", from)) {
            report("0X800AAA0", id5, isGray);
        } else if (Intrinsics.areEqual("VIA_TROOP_AIO_MSG", from)) {
            report("0X8009CAB", id5, isGray);
        }
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconClick
    @NotNull
    public View.OnClickListener newClickListener(@NotNull String uin, @NotNull String from) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(from, "from");
        View.OnClickListener newClickListener = VasInjectApi.getInstance().newClickListener(uin, from);
        Intrinsics.checkNotNullExpressionValue(newClickListener, "getInstance().newClickListener(uin, from)");
        return newClickListener;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconClick
    public boolean onClick(@NotNull View v3, @NotNull String uin, @NotNull String from) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(from, "from");
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin);
        return onClick(v3, new IVipIconClick.Info(uin, friendsVipData.getVipType(), friendsVipData.getNamePlateId(), friendsVipData.getGrayNameplateFlag(), false, 16, null), from);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconClick
    public void report04586(int id5, boolean isClick, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!isClick) {
            String str = id5 + "_" + from;
            Long l3 = this.exposeHistory.get(str);
            if (l3 == null) {
                l3 = 0L;
            }
            long longValue = l3.longValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis < longValue) {
                return;
            }
            if (getGameConfig(id5) == null) {
                this.exposeHistory.put(str, Long.MAX_VALUE);
                return;
            }
            this.exposeHistory.put(str, Long.valueOf(uptimeMillis + 1000));
        }
        if (QLog.isDebugVersion()) {
            QLog.e(TAG, 1, "id=" + id5 + " isClick=" + isClick + " from=" + from);
        }
        if (Intrinsics.areEqual("VIA_SETTINGME", from)) {
            realReport04586(id5, "drawer", "user_info", isClick);
            return;
        }
        if (Intrinsics.areEqual("VIA_PROFILECARD", from)) {
            realReport04586(id5, "data_card", ProfileVipReport.LEVEL_MODULE_ID, isClick);
            return;
        }
        if (Intrinsics.areEqual("VIA_AIO_TITLE", from)) {
            realReport04586(id5, "aio_personal", "user_avatar", isClick);
            return;
        }
        if (Intrinsics.areEqual("VIA_AIO_CHATSETTINGS", from)) {
            realReport04586(id5, "aio_set", QCircleAlphaUserReporter.KEY_USER, isClick);
        } else if (Intrinsics.areEqual("VIA_TROOP_AIO_MSG", from)) {
            realReport04586(id5, "aio_group", "user_avatar", isClick);
        } else if (Intrinsics.areEqual("VIA_TROOP_AIO_LIST", from)) {
            realReport04586(id5, "group_member", "user_list", isClick);
        }
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconClick
    public boolean onClick(@NotNull View v3, @NotNull IVipIconClick.Info info, @NotNull String from) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(from, "from");
        if (interceptForGame(v3, info.getNamePlateId(), info.getUin(), from)) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (Intrinsics.areEqual("VIA_TROOP_AIO_MSG", from)) {
            String onGetStringData = ar.INSTANCE.a("lianfang", "2025-03-27", "vas_group_setting_nameplate_widget").onGetStringData(DEFAULTURL);
            if (onGetStringData != null) {
                String buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(onGetStringData, new IVipTraceDetailReport.b(VasWebConstants.REPORT_ORIGIN, "1023", "", ""));
                QRouteApi api = QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IVasHybridRoute::class.java)");
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                IVasHybridRoute.b.a((IVasHybridRoute) api, context, buildTraceDetailUrl, null, 4, null);
            } else {
                QRouteApi api2 = QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(api2, "api(IVasHybridRoute::class.java)");
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                IVasHybridRoute.b.a((IVasHybridRoute) api2, context2, DEFAULTURL, null, 4, null);
            }
            reportClick(from, 0, false);
            return true;
        }
        IVasNamePlateUtil.VipIconClickConfig findConfig = ((IVasNamePlateUtil) QRoute.api(IVasNamePlateUtil.class)).findConfig(info.getVipType(), info.getNamePlateId(), info.getGrayNameplateFlag());
        reportClick(from, info.getNamePlateId(), info.getGrayNameplateFlag() != 0);
        if (from == "VIA_PROFILECARD") {
            VideoReport.reportEvent("clck", v3, null);
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        boolean areEqual = Intrinsics.areEqual(info.getUin(), currentAccountUin);
        if (findConfig != null && !TextUtils.isEmpty(info.getUin())) {
            if (Intrinsics.areEqual("VIA_SETTINGME", from)) {
                IVipTraceDetailReport iVipTraceDetailReport = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
                String str5 = findConfig.drawerUrl;
                Intrinsics.checkNotNullExpressionValue(str5, "config.drawerUrl");
                str = iVipTraceDetailReport.buildTraceDetailUrl(str5, IVipTraceDetailReport.FROM.QQSETTINGS_ICON);
            } else if (Intrinsics.areEqual("VIA_PROFILECARD", from)) {
                if (areEqual) {
                    IVipTraceDetailReport iVipTraceDetailReport2 = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
                    String str6 = findConfig.vaProfileUrl;
                    Intrinsics.checkNotNullExpressionValue(str6, "config.vaProfileUrl");
                    str = iVipTraceDetailReport2.buildTraceDetailUrl(str6, IVipTraceDetailReport.FROM.PROFILECARD_ICON);
                } else {
                    IVipTraceDetailReport iVipTraceDetailReport3 = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
                    String str7 = findConfig.vaProfileGuestUrl;
                    Intrinsics.checkNotNullExpressionValue(str7, "config.vaProfileGuestUrl");
                    str = iVipTraceDetailReport3.buildTraceDetailUrl(str7, IVipTraceDetailReport.FROM.PROFILECARD_ICON_GUEST);
                }
            } else if (Intrinsics.areEqual("VIA_AIO_TITLE", from)) {
                if (areEqual) {
                    str3 = findConfig.ctocUrl;
                    str4 = "config.ctocUrl";
                } else {
                    str3 = findConfig.ctocGuestUrl;
                    str4 = "config.ctocGuestUrl";
                }
                Intrinsics.checkNotNullExpressionValue(str3, str4);
                str = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(str3, IVipTraceDetailReport.FROM.AIO_DIALOG_TOP_NAMEPLATE);
            } else if (Intrinsics.areEqual("VIA_AIO_CHATSETTINGS", from)) {
                if (areEqual) {
                    str = findConfig.ctocSettingUrl;
                    str2 = "config.ctocSettingUrl";
                } else {
                    str = findConfig.ctocSettingGuestUrl;
                    str2 = "config.ctocSettingGuestUrl";
                }
                Intrinsics.checkNotNullExpressionValue(str, str2);
            } else {
                str = IVasNamePlateUtil.DEFAULT_URL;
            }
            String str8 = TextUtils.isEmpty(str) ? IVasNamePlateUtil.DEFAULT_URL : str;
            if (!areEqual) {
                str8 = StringsKt__StringsJVMKt.replace$default(str8, "{uin}", info.getUin(), false, 4, (Object) null);
            }
            String str9 = str8;
            Intent intent = new Intent(v3.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("portraitOnly", true);
            intent.putExtra("uin", currentAccountUin);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Context context3 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "v.getContext()");
                iVasHybridRoute.openBrowser(context3, str9);
            } else {
                VasWebviewUtil.openQQBrowserWithoutAD(v3.getContext(), str9, 256L, intent, false, -1);
            }
            return true;
        }
        IVasHybridRoute iVasHybridRoute2 = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
        Context context4 = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "v.context");
        iVasHybridRoute2.openBrowser(context4, IVasNamePlateUtil.DEFAULT_URL);
        return true;
    }
}
