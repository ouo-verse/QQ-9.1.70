package com.tencent.mobileqq.troop.troopsetting.report;

import SLICE_UPLOAD.cnst.appid_qun;
import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJH\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J>\u0010\u0019\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017JR\u0010!\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJH\u0010.\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ&\u00100\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0010\u00101\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ8\u00105\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u00010\t2\b\u00103\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u00010\tJ\u000e\u00106\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010;\u001a\u00020\u00112\u0006\u00108\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00109\u001a\u00020\t2\u0006\u0010 \u001a\u00020:J\u0016\u0010<\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010=\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010>\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\tJ8\u0010C\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\t0?j\b\u0012\u0004\u0012\u00020\t`@2\b\u0010B\u001a\u0004\u0018\u00010\tJ*\u0010E\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010\t2\b\u0010B\u001a\u0004\u0018\u00010\tJf\u0010O\u001a\u00020\u00112\u0006\u0010'\u001a\u00020F2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/report/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "view", "", "isClick", "", "appName", "", "rank", "", "appId", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "mTroopInfoData", "", "r", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "elementId", "", "param", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "troopInfo", "B", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Lcom/tencent/common/app/AppInterface;", "app", "opName", HippyTKDListViewAdapter.X, "isChecked", "w", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "troopClassExt", "k", "e", "subAction", "actionName", "r3", "j", "o", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$AppInfo;", "appInfo", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "f", "u", "y", "p", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportTabNames", "type", h.F, "name", "g", "Lmqq/app/AppRuntime;", "tag", "mainAction", "toUin", IProfileCardConst.KEY_FROM_TYPE, "result", "r2", "r4", "r5", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f301449a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            f301449a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AppRuntime app, String tag, String mainAction, String toUin, String subAction, String actionName, int i3, int i16, String r26, String r36, String r46, String r56) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(mainAction, "$mainAction");
        Intrinsics.checkNotNullParameter(toUin, "$toUin");
        Intrinsics.checkNotNullParameter(subAction, "$subAction");
        Intrinsics.checkNotNullParameter(actionName, "$actionName");
        Intrinsics.checkNotNullParameter(r26, "$r2");
        Intrinsics.checkNotNullParameter(r36, "$r3");
        Intrinsics.checkNotNullParameter(r46, "$r4");
        Intrinsics.checkNotNullParameter(r56, "$r5");
        ReportController.o(app, tag, mainAction, toUin, subAction, actionName, i3, i16, r26, r36, r46, r56);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, String> i(TroopInfoData mTroopInfoData) {
        Map<String, Object> f16 = com.tencent.mobileqq.troop.troopsetting.activity.c.f(mTroopInfoData);
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<T> it = f16.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private final void r(Activity activity, View rootView, View view, boolean isClick, String appName, int rank, long appId, TroopInfoData mTroopInfoData) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("app_name", appName);
        hashMap.put("rank", Integer.valueOf(rank));
        hashMap.put("appid", Long.valueOf(appId));
        com.tencent.mobileqq.troop.troopsetting.activity.c.b(activity, rootView, mTroopInfoData);
        VideoReport.setElementId(view, "em_group_plus_application");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, hashMap);
        if (isClick) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Activity activity, View rootView, View view, String appName, int i3, long j3, TroopInfoData mTroopInfoData) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(appName, "$appName");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        f301449a.r(activity, rootView, view, false, appName, i3, j3, mTroopInfoData);
    }

    public final void A(@Nullable View view, @Nullable String elementId, @Nullable TroopInfoData mTroopInfoData, @Nullable Map<String, Object> param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, elementId, mTroopInfoData, param);
        } else if (view != null && elementId != null) {
            B(view, elementId, param, ExposurePolicy.REPORT_ALL, ClickPolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, mTroopInfoData);
        }
    }

    public final void B(@NotNull View view, @NotNull String elementId, @Nullable Map<String, Object> param, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable TroopInfoData troopInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, elementId, param, exposurePolicy, clickPolicy, endExposurePolicy, troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        VideoReport.setElementId(view, elementId);
        if (param == null) {
            param = new HashMap<>();
        }
        if (troopInfo != null) {
            str = troopInfo.troopUin;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        param.put("group_id", str);
        VideoReport.setElementParams(view, param);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
    }

    public final void c(@NotNull final AppRuntime app, @NotNull final String tag, @NotNull final String mainAction, @NotNull final String toUin, @NotNull final String subAction, @NotNull final String actionName, final int fromType, final int result, @NotNull final String r26, @NotNull final String r36, @NotNull final String r46, @NotNull final String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, app, tag, mainAction, toUin, subAction, actionName, Integer.valueOf(fromType), Integer.valueOf(result), r26, r36, r46, r56);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mainAction, "mainAction");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.report.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(AppRuntime.this, tag, mainAction, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56);
            }
        }, 16, null, false);
    }

    public final void e(@Nullable TroopInfoData mTroopInfoData) {
        AppInterface appInterface;
        ITroopInfoService iTroopInfoService;
        TroopInfo findTroopInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) mTroopInfoData);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (mTroopInfoData != null) {
            if (mTroopInfoData.isOwnerOrAdim()) {
                str = "0";
            } else {
                str = "1";
            }
            j(appInterface, mTroopInfoData, "Grp_Admin_data", "Clk_data", str);
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).bnrReport(appInterface, 65);
        if (appInterface != null) {
            iTroopInfoService = (ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iTroopInfoService = null;
        }
        if (iTroopInfoService != null && mTroopInfoData != null && (findTroopInfo = iTroopInfoService.findTroopInfo(mTroopInfoData.troopUin)) != null && findTroopInfo.isGameBind()) {
            eu.g("Grp_game", "Grp_data", "data_exp", 0, 0, mTroopInfoData.troopUin);
        }
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        if (appInterface != null) {
            str2 = appInterface.getCurrentUin();
        }
        iChatSettingForTroopApi.reportCommercialDrainage(str2, "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
        ReportController.o(appInterface, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
        ReportController.o(appInterface, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
    }

    public final void f(@NotNull oidb_0xe83$AppInfo appInfo, long appId, @NotNull String troopUin, @NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appInfo, Long.valueOf(appId), troopUin, troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        if (appId == 0) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQQqunInfo(appid_qun.value, "qun_info", "expo_more", troopUin);
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(appInfo.url.get())) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).reportQunMiniApp(appInfo, "expo", troopUin);
        }
        if (appId == 1.01914115E8d) {
            z16 = true;
        }
        if (z16) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).reportClockTroopAppShowOrClick(troopInfo, true);
        }
    }

    public final void g(@NotNull AppInterface app, @NotNull TroopInfoData mTroopInfoData, @Nullable String name, @Nullable String type) {
        HashMap<String, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, app, mTroopInfoData, name, type);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        IProfileCardBlacklistService iProfileCardBlacklistService = (IProfileCardBlacklistService) app.getRuntimeService(IProfileCardBlacklistService.class, "all");
        HashMap<String, String> i3 = i(mTroopInfoData);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_popup_type", type), TuplesKt.to("tab_name", name));
        iProfileCardBlacklistService.reportItemEvent("clck", "pg_group_set", "em_group_popup", i3, hashMapOf);
    }

    public final void h(@NotNull AppInterface app, @NotNull TroopInfoData mTroopInfoData, @NotNull ArrayList<String> reportTabNames, @Nullable String type) {
        HashMap<String, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, app, mTroopInfoData, reportTabNames, type);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        Intrinsics.checkNotNullParameter(reportTabNames, "reportTabNames");
        Iterator<String> it = reportTabNames.iterator();
        while (it.hasNext()) {
            String next = it.next();
            IProfileCardBlacklistService iProfileCardBlacklistService = (IProfileCardBlacklistService) app.getRuntimeService(IProfileCardBlacklistService.class, "all");
            HashMap<String, String> i3 = i(mTroopInfoData);
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_popup_type", type), TuplesKt.to("tab_name", next));
            iProfileCardBlacklistService.reportItemEvent("imp", "pg_group_set", "em_group_popup", i3, hashMapOf);
        }
    }

    public final void j(@Nullable AppInterface app, @Nullable TroopInfoData mTroopInfoData, @Nullable String subAction, @Nullable String actionName, @Nullable String r36) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, app, mTroopInfoData, subAction, actionName, r36);
            return;
        }
        if (mTroopInfoData != null) {
            str = mTroopInfoData.troopUin;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        ReportController.o(app, "P_CliOper", "Grp_set", "", subAction, actionName, 0, 0, str, r36, "", "");
    }

    public final void k(@NotNull View view, @NotNull TroopInfoData mTroopInfoData, @NotNull String troopClassExt, @NotNull String appId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, view, mTroopInfoData, troopClassExt, appId);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        Intrinsics.checkNotNullParameter(troopClassExt, "troopClassExt");
        Intrinsics.checkNotNullParameter(appId, "appId");
        String str2 = mTroopInfoData.troopUin;
        if (view.getTag(-1) == null) {
            str = appId + "-0";
        } else {
            str = appId + "-" + view.getTag(-1);
        }
        ReportController.o(null, "dc00898", "", str2, "0X800AFC4", "0X800AFC4", 0, 0, troopClassExt, appId, str, "");
    }

    public final void l(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, mTroopInfoData.troopUin);
        }
    }

    public final void m(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, mTroopInfoData.troopUin);
        }
    }

    public final void n(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, mTroopInfoData.troopUin);
        }
    }

    public final void o(@NotNull TroopInfoData mTroopInfoData) {
        int i3;
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        if (mTroopInfoData.bOwner) {
            i3 = 1;
        } else if (mTroopInfoData.bAdmin) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).newReportTask(appInterface, mTroopInfoData.troopUin, i3);
    }

    public final void p(@Nullable AppInterface app, boolean isChecked, @Nullable String troopUin) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, app, Boolean.valueOf(isChecked), troopUin);
            return;
        }
        if (isChecked) {
            eu.g("Grp_set_new", "grpData_admin", "hideMessage_open", 0, 0, troopUin);
        } else {
            eu.g("Grp_set_new", "grpData_admin", "hideMessage_close", 0, 0, troopUin);
        }
        if (app == null) {
            return;
        }
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(app, "dc00898", "", "", "0X800A348", "0X800A348", 2, i3, "0", "0", "", "");
    }

    public final void q(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, mTroopInfoData.troopUin);
        }
    }

    public final void s(@Nullable final Activity activity, @NotNull final View rootView, @NotNull final View view, boolean isClick, @NotNull final String appName, final int rank, final long appId, @NotNull final TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, rootView, view, Boolean.valueOf(isClick), appName, Integer.valueOf(rank), Long.valueOf(appId), mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        if (activity == null) {
            return;
        }
        if (isClick) {
            r(activity, rootView, view, true, appName, rank, appId, mTroopInfoData);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.t(activity, rootView, view, appName, rank, appId, mTroopInfoData);
                }
            }, 500L);
        }
    }

    public final void u(@NotNull AppInterface app, @NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) app, (Object) mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        ReportController.o(app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, mTroopInfoData.troopUin, "", "", "");
        eu.g("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
        ReportController.o(app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
    }

    public final void v(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
        }
    }

    public final void w(@NotNull AppInterface app, boolean isChecked, @NotNull TroopInfoData mTroopInfoData) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, app, Boolean.valueOf(isChecked), mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        if (isChecked) {
            str = "msg_open";
        } else {
            str = "msg_close";
        }
        ReportController.o(app, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, mTroopInfoData.troopUin, "", "", "");
        if (isChecked) {
            str2 = "msg_open";
        } else {
            str2 = "msg_close";
        }
        eu.g("Grp_msg", "grpData_admin", str2, 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
    }

    public final void x(@NotNull AppInterface app, @NotNull String opName, @NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, app, opName, mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(opName, "opName");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        ReportController.o(app, "dc00899", "Grp_set", "", "Grp_data", opName, 0, 0, mTroopInfoData.troopUin, "", "", "");
        eu.g("Grp_set_new", "grpData_admin", opName, 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
    }

    public final void y(@NotNull AppInterface app, @NotNull TroopInfoData mTroopInfoData) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) app, (Object) mTroopInfoData);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
        eu.g("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
        String str2 = mTroopInfoData.troopUin;
        if (mTroopInfoData.bOwner) {
            str = "0";
        } else if (mTroopInfoData.bAdmin) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(app, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, str2, "0", str, "");
    }

    public final void z(@NotNull TroopInfoData mTroopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) mTroopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(mTroopInfoData, "mTroopInfoData");
            eu.g("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData), AppSetting.f99551k);
        }
    }
}
