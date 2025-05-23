package com.tencent.mobileqq.mini.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.wxa.xd.t0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfig;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfigProcessor;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import com.tencent.mobileqq.mini.model.AppDetainConfig;
import com.tencent.mobileqq.mini.model.DetailConfigParseHelper;
import com.tencent.mobileqq.mini.model.DetainConfigMatchHelper;
import com.tencent.mobileqq.mini.model.OpenType;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.DateUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.RetainDialogModuleUtil;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\fJ$\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0004H\u0002J\"\u0010-\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J2\u0010/\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/mini/manager/MiniAppDetainManager;", "", "()V", "TAG", "", "gameConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "mMiniGameRetainInfo", "mRecordCached", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/mini/entity/AppDetainRecordEntity;", "usageGuideJson", "Lorg/json/JSONObject;", "checkInitMiniGameRetainInfo", "", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "getAppDetainFreqConfig", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "getDetainDialogConfig", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "miniRuntime", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "getFinalJumpLink", "curPageUrl", t0.NAME, "getOrCreateEntityManager", "Lcom/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager;", "getOrResetAppDetainRecord", "appId", "getUsageGuideRetainJson", "handleJumpForMiniApp", "openType", "handleOnCloseBtnClick", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onCloseClickedListener", "Landroid/content/DialogInterface$OnClickListener;", "preloadAppDetainRecord", "reportDialogExpose", "miniAppConfig", "contentText", "reportDialogLeftBtnClick", TuxUIConstants.POP_BTN_TEXT, "reportDialogRightBtnClick", "shouldShowCustomizeDetainment", "showDetainDialog", "detainConfig", "updateAppDetainRecord", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDetainManager {
    public static final String TAG = "MiniAppDetainManager";
    private static MiniAppConfig gameConfig;
    private static String mMiniGameRetainInfo;
    private static JSONObject usageGuideJson;
    public static final MiniAppDetainManager INSTANCE = new MiniAppDetainManager();
    private static final ConcurrentHashMap<String, AppDetainRecordEntity> mRecordCached = new ConcurrentHashMap<>();

    MiniAppDetainManager() {
    }

    private final AppDetainFreqConfig.ItemConfig getAppDetainFreqConfig(MiniAppInfo miniAppInfo) {
        AppDetainFreqConfig config;
        String str = miniAppInfo.appId;
        if ((str == null || str.length() == 0) || (config = AppDetainFreqConfigProcessor.INSTANCE.getConfig()) == null) {
            return null;
        }
        String str2 = miniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str2, "miniAppInfo.appId");
        return config.getItemConfig(str2);
    }

    private final AppDetainConfig getDetainDialogConfig(IMiniAppContext miniRuntime, MiniAppInfo miniAppInfo) {
        Object firstOrNull;
        ApkgBaseInfo apkgBaseInfo = miniAppInfo.apkgInfo;
        String str = apkgBaseInfo != null ? apkgBaseInfo.mConfigStr : null;
        if (str == null || str.length() == 0) {
            QLog.e(TAG, 1, "getDetailDialogConfig failed: empty configJson");
            return null;
        }
        List<AppDetainConfig> parse = new DetailConfigParseHelper().parse(str);
        if (miniRuntime.isMiniGame()) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) parse);
            return (AppDetainConfig) firstOrNull;
        }
        String curPageUrl = ActionBridge.PageActionBridge.getPageUrl(miniRuntime);
        if ((curPageUrl == null || curPageUrl.length() == 0) || parse.isEmpty()) {
            return null;
        }
        DetainConfigMatchHelper detainConfigMatchHelper = new DetainConfigMatchHelper();
        Intrinsics.checkNotNullExpressionValue(curPageUrl, "curPageUrl");
        return detainConfigMatchHelper.find(curPageUrl, parse);
    }

    private final synchronized MiniAppEntityManager getOrCreateEntityManager() {
        return MiniAppEntityManager.get();
    }

    private final AppDetainRecordEntity getOrResetAppDetainRecord(String appId) {
        ConcurrentHashMap<String, AppDetainRecordEntity> concurrentHashMap = mRecordCached;
        AppDetainRecordEntity appDetainRecordEntity = concurrentHashMap.get(appId);
        if (appDetainRecordEntity == null) {
            appDetainRecordEntity = new AppDetainRecordEntity();
            appDetainRecordEntity.appId = appId;
            appDetainRecordEntity.timestamp = System.currentTimeMillis();
            concurrentHashMap.put(appId, appDetainRecordEntity);
        }
        if (!DateUtils.INSTANCE.isToday(appDetainRecordEntity.timestamp)) {
            appDetainRecordEntity.timestamp = System.currentTimeMillis();
            appDetainRecordEntity.showTimes = 0;
        }
        return appDetainRecordEntity;
    }

    private final void handleJumpForMiniApp(IMiniAppContext miniRuntime, String openLink, String openType) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(OpenType.INSTANCE.getALL_TYPE(), openType);
        if (!contains) {
            QLog.e(TAG, 1, "invalid config: link=" + openLink + ", openType=" + openType);
            return;
        }
        IAppPageRouter iAppPageRouter = (IAppPageRouter) miniRuntime.performAction(ActionBridge.GetAppPageRouterActionBridge.obtain());
        String finalJumpLink = getFinalJumpLink(ActionBridge.PageActionBridge.getPageUrl(miniRuntime), openLink);
        if (iAppPageRouter == null || openType == null) {
            return;
        }
        switch (openType.hashCode()) {
            case -1470534714:
                if (openType.equals("reLaunch")) {
                    iAppPageRouter.reLaunch(finalJumpLink);
                    return;
                }
                return;
            case -983638536:
                if (openType.equals("navigateBack")) {
                    iAppPageRouter.navigateBack(1);
                    return;
                }
                return;
            case 1449032567:
                if (openType.equals("redirectTo")) {
                    iAppPageRouter.redirectTo(finalJumpLink);
                    return;
                }
                return;
            case 1651364801:
                if (openType.equals("switchTab")) {
                    iAppPageRouter.switchTab(finalJumpLink);
                    return;
                }
                return;
            case 1862662092:
                if (openType.equals("navigateTo")) {
                    iAppPageRouter.navigateTo(finalJumpLink);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadAppDetainRecord$lambda$1(String appId, MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        MiniAppEntityManager orCreateEntityManager = INSTANCE.getOrCreateEntityManager();
        Entity find = orCreateEntityManager != null ? orCreateEntityManager.find(AppDetainRecordEntity.class, "appId=?", new String[]{appId}) : null;
        if (find instanceof AppDetainRecordEntity) {
            mRecordCached.put(appId, find);
        }
        if (miniAppInfo.isEngineTypeMiniGame()) {
            MiniAppConfig h16 = aq.h(miniAppInfo);
            gameConfig = h16;
            if (h16 != null) {
                String str = h16.config.appId;
                Intrinsics.checkNotNullExpressionValue(str, "it.config.appId");
                LaunchParam launchParam = h16.launchParam;
                int i3 = launchParam != null ? launchParam.scene : 0;
                String str2 = h16.config.via;
                if (str2 == null) {
                    str2 = "";
                }
                String andRemoveRetainInfoCache = GameCloseManager.getAndRemoveRetainInfoCache(str, i3, str2);
                mMiniGameRetainInfo = andRemoveRetainInfoCache;
                QLog.d(TAG, 2, "preloadAppDetainRecord id:" + str + " mMiniGameRetainInfo\uff1a" + andRemoveRetainInfoCache);
            }
            usageGuideJson = RetainDialogModuleUtil.getFunctionRetainJson();
        }
    }

    private final void reportDialogExpose(MiniAppConfig miniAppConfig, String contentText) {
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, MiniProgramLpReportDC04239.DETAIN_DIALOG_ACTION_TYPE, "popup", "expo", contentText);
    }

    private final void reportDialogLeftBtnClick(MiniAppConfig miniAppConfig, String btnText) {
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, MiniProgramLpReportDC04239.DETAIN_DIALOG_ACTION_TYPE, MiniProgramLpReportDC04239.DETAIN_DIALOG_SUB_ACTION_CLICK_L, "click", btnText);
    }

    private final void reportDialogRightBtnClick(MiniAppConfig miniAppConfig, String btnText, String openLink) {
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, MiniProgramLpReportDC04239.DETAIN_DIALOG_ACTION_TYPE, MiniProgramLpReportDC04239.DETAIN_DIALOG_SUB_ACTION_CLICK_R, "click", btnText, openLink);
    }

    private final boolean shouldShowCustomizeDetainment(MiniAppInfo miniAppInfo) {
        AppDetainFreqConfig.ItemConfig appDetainFreqConfig = getAppDetainFreqConfig(miniAppInfo);
        if (appDetainFreqConfig == null) {
            return false;
        }
        String str = miniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo.appId");
        AppDetainRecordEntity orResetAppDetainRecord = getOrResetAppDetainRecord(str);
        QLog.d(TAG, 2, "hasShowedTimes=" + orResetAppDetainRecord.showTimes + ", limitTimes=" + appDetainFreqConfig.getLimitTimes());
        return orResetAppDetainRecord.showTimes < appDetainFreqConfig.getLimitTimes();
    }

    private final void showDetainDialog(Activity activity, final IMiniAppContext miniRuntime, MiniAppInfo miniAppInfo, final AppDetainConfig detainConfig, final DialogInterface.OnClickListener onCloseClickedListener) {
        final MiniAppConfig miniAppConfig = aq.h(miniAppInfo);
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle((String) null);
        qQCustomDialog.setMessageTextSize(17.0f);
        qQCustomDialog.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
        TextView messageTextView = qQCustomDialog.getMessageTextView();
        ViewGroup.LayoutParams layoutParams = qQCustomDialog.getMessageTextView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = DisplayUtil.dip2px(activity, 24.0f);
        messageTextView.setLayoutParams(marginLayoutParams);
        qQCustomDialog.setMessage(detainConfig.getContent());
        qQCustomDialog.setNegativeButton(detainConfig.getExitButton(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.manager.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniAppDetainManager.showDetainDialog$lambda$9$lambda$7(onCloseClickedListener, miniAppConfig, detainConfig, dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButton(detainConfig.getEnterButton(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.manager.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniAppDetainManager.showDetainDialog$lambda$9$lambda$8(IMiniAppContext.this, detainConfig, miniAppConfig, dialogInterface, i3);
            }
        });
        qQCustomDialog.show();
        Intrinsics.checkNotNullExpressionValue(miniAppConfig, "miniAppConfig");
        reportDialogExpose(miniAppConfig, detainConfig.getContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDetainDialog$lambda$9$lambda$7(DialogInterface.OnClickListener onClickListener, MiniAppConfig miniAppConfig, AppDetainConfig detainConfig, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(detainConfig, "$detainConfig");
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
        MiniAppDetainManager miniAppDetainManager = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppConfig, "miniAppConfig");
        miniAppDetainManager.reportDialogLeftBtnClick(miniAppConfig, detainConfig.getExitButton());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDetainDialog$lambda$9$lambda$8(IMiniAppContext miniRuntime, AppDetainConfig detainConfig, MiniAppConfig miniAppConfig, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(miniRuntime, "$miniRuntime");
        Intrinsics.checkNotNullParameter(detainConfig, "$detainConfig");
        if (!miniRuntime.isMiniGame()) {
            INSTANCE.handleJumpForMiniApp(miniRuntime, detainConfig.getOpenLink(), detainConfig.getOpenType());
        }
        dialogInterface.dismiss();
        MiniAppDetainManager miniAppDetainManager = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppConfig, "miniAppConfig");
        miniAppDetainManager.reportDialogRightBtnClick(miniAppConfig, detainConfig.getEnterButton(), detainConfig.getOpenLink());
    }

    private final void updateAppDetainRecord(String appId) {
        final AppDetainRecordEntity orResetAppDetainRecord = getOrResetAppDetainRecord(appId);
        orResetAppDetainRecord.showTimes++;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDetainManager.updateAppDetainRecord$lambda$4(AppDetainRecordEntity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAppDetainRecord$lambda$4(AppDetainRecordEntity record) {
        Intrinsics.checkNotNullParameter(record, "$record");
        MiniAppEntityManager orCreateEntityManager = INSTANCE.getOrCreateEntityManager();
        if (orCreateEntityManager != null) {
            orCreateEntityManager.insertOrReplaceEntity(record);
        }
    }

    public final void checkInitMiniGameRetainInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        if (miniAppInfo.isEngineTypeMiniGame()) {
            if (TextUtils.isEmpty(mMiniGameRetainInfo)) {
                MiniAppConfig h16 = aq.h(miniAppInfo);
                gameConfig = h16;
                if (h16 != null) {
                    String str = h16.config.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.config.appId");
                    LaunchParam launchParam = h16.launchParam;
                    int i3 = launchParam == null ? 0 : launchParam.scene;
                    String str2 = h16.config.via;
                    if (str2 == null) {
                        str2 = "";
                    }
                    mMiniGameRetainInfo = GameCloseManager.getAndRemoveRetainInfoCache(str, i3, str2);
                    JSONObject functionRetainJson = RetainDialogModuleUtil.getFunctionRetainJson();
                    usageGuideJson = functionRetainJson;
                    QLog.d(TAG, 2, "checkInitMiniGameRetainInfo id:" + str + " mMiniGameRetainInfo\uff1a" + mMiniGameRetainInfo + " usageGuideJson:" + functionRetainJson);
                    return;
                }
                return;
            }
            QLog.d(TAG, 2, "checkInitMiniGameRetainInfo mMiniGameRetainInfo is not empty");
        }
    }

    public final JSONObject getUsageGuideRetainJson() {
        return usageGuideJson;
    }

    public final boolean handleOnCloseBtnClick(Activity activity, IMiniAppContext miniRuntime, MiniAppInfo miniAppInfo, DialogInterface.OnClickListener onCloseClickedListener) {
        AppDetainConfig detainDialogConfig;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            if (shouldShowCustomizeDetainment(miniAppInfo) && (detainDialogConfig = getDetainDialogConfig(miniRuntime, miniAppInfo)) != null) {
                showDetainDialog(activity, miniRuntime, miniAppInfo, detainDialogConfig, onCloseClickedListener);
                String str = miniAppInfo.appId;
                Intrinsics.checkNotNullExpressionValue(str, "miniAppInfo.appId");
                updateAppDetainRecord(str);
                return true;
            }
            if (!miniRuntime.isMiniGame()) {
                QLog.d(TAG, 1, "GameCloseManager: miniApp do not need to show retainGuideDialog");
                return false;
            }
            if (aq.i(miniAppInfo)) {
                QLog.d(TAG, 1, "isWorldChannel do not show ");
                return false;
            }
            String str2 = mMiniGameRetainInfo;
            MiniAppConfig miniAppConfig = gameConfig;
            if (miniAppConfig == null) {
                miniAppConfig = aq.h(miniAppInfo);
            }
            if (GameCloseManager.handleRetainGuideDialog(activity, str2, miniAppConfig, miniAppInfo, onCloseClickedListener)) {
                QLog.d(TAG, 1, "GameCloseManager show retainGuideDialog");
                return true;
            }
            MiniAppConfig miniAppConfig2 = gameConfig;
            if (miniAppConfig2 == null) {
                miniAppConfig2 = aq.h(miniAppInfo);
            }
            if (!GameCloseManager.handleDropGuideDialog(activity, miniAppConfig2, onCloseClickedListener)) {
                return false;
            }
            QLog.d(TAG, 1, "GameCloseManager show dropGuideDialog");
            return true;
        }
        QLog.w(TAG, 1, "GameCloseManager: act is finished");
        return false;
    }

    public final void preloadAppDetainRecord(final MiniAppInfo miniAppInfo) {
        final String str = miniAppInfo != null ? miniAppInfo.appId : null;
        if (str == null) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDetainManager.preloadAppDetainRecord$lambda$1(str, miniAppInfo);
            }
        });
    }

    private final String getFinalJumpLink(String curPageUrl, String openLink) {
        boolean startsWith$default;
        if (!(openLink == null || openLink.length() == 0)) {
            if (!(curPageUrl == null || curPageUrl.length() == 0)) {
                startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) openLink, '.', false, 2, (Object) null);
                if (startsWith$default) {
                    try {
                        openLink = new URI(curPageUrl).resolve(openLink).toString();
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "parse absoluteLink failed", e16);
                    }
                    Intrinsics.checkNotNullExpressionValue(openLink, "{\n                try {\n\u2026          }\n            }");
                }
            }
        }
        return SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(openLink);
    }
}
