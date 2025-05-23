package com.tencent.mobileqq.mini.entry.expDesktop.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000eH\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J@\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniAppExpItemClickLaunchUtils;", "", "()V", "TAG", "", "clickReport", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "scene", "", "desktopItemInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "reportParamsMap", "", "createLaunchParam", "Lcom/tencent/mobileqq/mini/sdk/LaunchParam;", "appInfo", "slotId", "startMiniApp", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "desktopAppInfo", "subPage", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpItemClickLaunchUtils {
    public static final MiniAppExpItemClickLaunchUtils INSTANCE = new MiniAppExpItemClickLaunchUtils();
    private static final String TAG = "MiniAppExpItemClickLaunchUtils";

    MiniAppExpItemClickLaunchUtils() {
    }

    private final void clickReport(MiniAppInfo miniAppInfo, int scene, DesktopAppInfo desktopItemInfo, Map<String, String> reportParamsMap) {
        String str;
        String str2;
        String str3;
        String str4;
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = scene;
        if (desktopItemInfo.isRecommendBadgeShow()) {
            str = "1";
        } else {
            str = "0";
        }
        if (desktopItemInfo.isBubbleShown()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        MiniProgramLpReportDC04239.reportAsyncWithIcon(miniAppConfig, "page_view", "click_scene", null, null, null, null, str, str2);
        if (!TextUtils.isEmpty(miniAppInfo.amsAdInfo)) {
            try {
                String str5 = ((qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(miniAppInfo.amsAdInfo)))).report_info.click_url.get();
                MiniAppUtils.reportMiniAppAd(str5);
                QLog.d(TAG, 1, "--- click : " + str5);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "click ad exception: " + Log.getStackTraceString(e16));
            }
        }
        int i3 = miniAppInfo.tianshuAdId;
        if (i3 > 0) {
            MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(i3), 102);
        }
        int moduleType = desktopItemInfo.getModuleType();
        if (moduleType == 1 || moduleType == 3) {
            if (moduleType == 1) {
                str3 = MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_RECENT_APP;
            } else {
                str3 = MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_MY_APP;
            }
            MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "desktop", str3, "click", null);
        }
        if (reportParamsMap.containsKey("pgid")) {
            str4 = reportParamsMap.get("pgid");
        } else {
            str4 = "";
        }
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        Intrinsics.checkNotNull(str4);
        companion.miniAppDesktopCommonReport("qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET, reportParamsMap, str4);
    }

    private final LaunchParam createLaunchParam(MiniAppInfo appInfo, int scene, int slotId) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = appInfo.appId;
        String str = "";
        launchParam.envVersion = "";
        launchParam.entryPath = "";
        launchParam.navigateExtData = "";
        launchParam.reportData = appInfo.reportData;
        launchParam.scene = scene;
        launchParam.tianshuAdId = appInfo.tianshuAdId;
        launchParam.via = appInfo.via;
        if (slotId != 0) {
            str = String.valueOf(slotId);
        }
        launchParam.slotId = str;
        return launchParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMiniApp$lambda$0(MiniAppInfo miniAppInfo, DesktopAppInfo desktopAppInfo, Map reportParamsMap) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "$desktopAppInfo");
        Intrinsics.checkNotNullParameter(reportParamsMap, "$reportParamsMap");
        MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppInfo");
        miniAppExpItemClickLaunchUtils.clickReport(miniAppInfo, 3422, desktopAppInfo, reportParamsMap);
    }

    public final void startMiniApp(Activity activity, final DesktopAppInfo desktopAppInfo, int slotId, final Map<String, String> reportParamsMap, boolean subPage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        Intrinsics.checkNotNullParameter(reportParamsMap, "reportParamsMap");
        final MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo.isQQMiniApp()) {
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppInfo");
            startMiniApp(activity, miniAppInfo, 3422, slotId);
        } else if (miniAppInfo.isWxMiniApp()) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppInfo.appId, "", ((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).transformDropDownHostScene(desktopAppInfo.mModuleType, subPage, slotId));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpItemClickLaunchUtils.startMiniApp$lambda$0(MiniAppInfo.this, desktopAppInfo, reportParamsMap);
            }
        }, 16, null, true);
        QLog.d(TAG, 1, "--- click appid:" + miniAppInfo.appId + ", moduleType = " + desktopAppInfo.getModuleType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void clickReport$default(MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils, MiniAppInfo miniAppInfo, int i3, DesktopAppInfo desktopAppInfo, Map map, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            map = new HashMap();
        }
        miniAppExpItemClickLaunchUtils.clickReport(miniAppInfo, i3, desktopAppInfo, map);
    }

    public static /* synthetic */ void startMiniApp$default(MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils, Activity activity, DesktopAppInfo desktopAppInfo, int i3, Map map, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            map = new HashMap();
        }
        Map map2 = map;
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        miniAppExpItemClickLaunchUtils.startMiniApp(activity, desktopAppInfo, i3, map2, z16);
    }

    private final void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, int scene, int slotId) {
        try {
            if (TextUtils.isEmpty(miniAppInfo.downloadUrl)) {
                MiniAppLauncher.launchMiniAppById(activity, createLaunchParam(miniAppInfo, scene, slotId), null);
            } else {
                MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, scene, slotId);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startMiniApp exception: " + Log.getStackTraceString(e16));
        }
    }
}
