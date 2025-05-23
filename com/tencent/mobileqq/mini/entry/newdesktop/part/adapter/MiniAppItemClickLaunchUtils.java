package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.AttaReporter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J2\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\nJ(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppItemClickLaunchUtils;", "", "()V", "TAG", "", "clickReport", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "scene", "", "desktopItemInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "miniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "createLaunchParam", "Lcom/tencent/mobileqq/mini/sdk/LaunchParam;", "appInfo", "slotId", "startMini", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "startMiniApp", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppItemClickLaunchUtils {
    public static final MiniAppItemClickLaunchUtils INSTANCE = new MiniAppItemClickLaunchUtils();
    private static final String TAG = "MiniAppDesktopPart.MiniAppLaunchUtils";

    MiniAppItemClickLaunchUtils() {
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
    public static final void startMini$lambda$0(MiniAppInfo miniAppInfo, Ref.IntRef scene, DesktopItemInfo desktopItemInfo, MiniAppDeskTopViewModel miniAppDeskTopViewModel, RecyclerView.ViewHolder vh5) {
        Intrinsics.checkNotNullParameter(scene, "$scene");
        Intrinsics.checkNotNullParameter(desktopItemInfo, "$desktopItemInfo");
        Intrinsics.checkNotNullParameter(vh5, "$vh");
        MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppInfo");
        miniAppItemClickLaunchUtils.clickReport(miniAppInfo, scene.element, (DesktopAppInfo) desktopItemInfo, miniAppDeskTopViewModel, vh5, vh5.getAdapterPosition());
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

    private final void clickReport(MiniAppInfo miniAppInfo, int scene, DesktopAppInfo desktopItemInfo, MiniAppDeskTopViewModel miniAppDesktopViewModel, RecyclerView.ViewHolder vh5, int position) {
        String str;
        String str2;
        String str3;
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
        MiniProgramLpReportDC04239.reportAsyncWithIcon(miniAppConfig, "page_view", "click_scene", null, null, String.valueOf(0), null, str, str2);
        if (desktopItemInfo.isBubbleShown() && miniAppDesktopViewModel != null) {
            String str4 = miniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str4, "miniAppInfo.appId");
            miniAppDesktopViewModel.miniAppBubbleUpdateAppBubbleRecord(str4, desktopItemInfo.getModuleType());
            String str5 = miniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str5, "miniAppInfo.appId");
            int moduleType = desktopItemInfo.getModuleType();
            String str6 = miniAppInfo.bubbleText;
            Intrinsics.checkNotNullExpressionValue(str6, "miniAppInfo.bubbleText");
            if (!miniAppDesktopViewModel.miniAppBubbleEnsureBubbleRecord(str5, moduleType, str6, miniAppInfo.bubbleClickCount).shouldShowAppBubble()) {
                try {
                    ((RelativeLayout) vh5.itemView.findViewById(R.id.z8y)).setVisibility(8);
                } catch (Exception e16) {
                    QLog.i(TAG, 1, "recommend_bubble gone fail", e16);
                }
            }
        }
        if (!TextUtils.isEmpty(miniAppInfo.amsAdInfo)) {
            try {
                String str7 = ((qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(miniAppInfo.amsAdInfo)))).report_info.click_url.get();
                MiniAppUtils.reportMiniAppAd(str7);
                QLog.d(TAG, 1, "--- click : " + str7);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "click ad exception: " + Log.getStackTraceString(e17));
            }
        }
        int i3 = miniAppInfo.tianshuAdId;
        if (i3 > 0) {
            MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(i3), 102);
        }
        int moduleType2 = desktopItemInfo.getModuleType();
        if (moduleType2 == 1 || moduleType2 == 3) {
            if (moduleType2 == 1) {
                str3 = MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_RECENT_APP;
            } else {
                str3 = MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_MY_APP;
            }
            MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "desktop", str3, "click", null);
            MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
            miniAppDesktopRvPartExpoHelper.reportRecentMiniAppToDc87(position, miniAppInfo, true);
            miniAppDesktopRvPartExpoHelper.reportRecentMiniAppToDc04239(miniAppConfig, true);
        }
    }

    public final void startMini(final DesktopItemInfo desktopItemInfo, final RecyclerView.ViewHolder vh5, Activity activity, final MiniAppDeskTopViewModel miniAppDesktopViewModel, int slotId) {
        Intrinsics.checkNotNullParameter(desktopItemInfo, "desktopItemInfo");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (desktopItemInfo instanceof DesktopAppInfo) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
            final MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 9999;
            int moduleType = desktopAppInfo.getModuleType();
            if (moduleType == 1) {
                intRef.element = 3001;
            } else if (moduleType == 2) {
                intRef.element = 3002;
            } else if (moduleType == 3) {
                intRef.element = 3003;
            }
            if (intRef.element == 3002 && miniAppInfo.getReportType() == 1) {
                AttaReporter.h("102", miniAppInfo.appId, miniAppInfo.reportData, "0");
            }
            QLog.d(TAG, 1, "--- click appid:" + miniAppInfo.appId + ", moduleType = " + desktopAppInfo.getModuleType());
            if (miniAppInfo.isGdtMiniAppAd) {
                miniAppInfo.isGdtMiniAppAd = false;
                DesktopDataMiniAppAdManager.getInstance().miniAppGdtAdClick(new WeakReference<>(activity), miniAppInfo.gdtAdInfo);
                DesktopDataMiniAppAdManager.getInstance().gdtAdExposureReport(miniAppInfo.gdtAdInfo);
                DesktopDataMiniAppAdManager.getInstance().setGdtAdInfo(null);
            } else {
                if (miniAppInfo.isQQMiniApp()) {
                    if (desktopAppInfo.getModuleType() == 2 && desktopAppInfo.fromBackup == 1) {
                        LaunchParam launchParam = new LaunchParam();
                        launchParam.miniAppId = miniAppInfo.appId;
                        launchParam.scene = intRef.element;
                        MiniAppLauncher.launchMiniAppById(activity, launchParam, null);
                        QLog.w(TAG, 1, "--- click appid:" + miniAppInfo.appId + ", moduleType = " + desktopAppInfo.getModuleType() + ", fromBackup: " + desktopAppInfo.fromBackup);
                    } else if (TextUtils.equals("1108291530", miniAppInfo.appId)) {
                        MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", "main");
                        MiniAppLauncher.launchMiniGameCenter(activity, "main");
                    } else {
                        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "miniAppInfo");
                        startMiniApp(activity, miniAppInfo, intRef.element, slotId);
                    }
                } else if (miniAppInfo.isWxMiniApp()) {
                    ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppInfo.appId, "", intRef.element);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppItemClickLaunchUtils.startMini$lambda$0(MiniAppInfo.this, intRef, desktopItemInfo, miniAppDesktopViewModel, vh5);
                    }
                }, 16, null, true);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.i
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppItemClickLaunchUtils.startMini$lambda$0(MiniAppInfo.this, intRef, desktopItemInfo, miniAppDesktopViewModel, vh5);
                }
            }, 16, null, true);
        }
    }

    public static /* synthetic */ void startMini$default(MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils, DesktopItemInfo desktopItemInfo, RecyclerView.ViewHolder viewHolder, Activity activity, MiniAppDeskTopViewModel miniAppDeskTopViewModel, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 0;
        }
        miniAppItemClickLaunchUtils.startMini(desktopItemInfo, viewHolder, activity, miniAppDeskTopViewModel, i3);
    }
}
