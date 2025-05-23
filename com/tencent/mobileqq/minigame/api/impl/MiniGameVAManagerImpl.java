package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.Option;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.api.MiniGameSpaceOccupyListener;
import com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback;
import com.tencent.mobileqq.minigame.config.MiniGameCustomLoadingConfig;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePreDownload;
import com.tencent.mobileqq.minigame.leba.MiniGameMetaGuideBubbleRequest;
import com.tencent.mobileqq.minigame.ui.loading.MiniGameCustomLoadingView;
import com.tencent.mobileqq.minigame.utils.MiniGameTabTestConstants;
import com.tencent.mobileqq.minigame.va.DownloadScene;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadConstant;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.minigame.va.downloadui.MiniGameDownloadManagerFragment;
import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.intercept.MiniBoxLaunchIntercept;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.ClickIntervalInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.CrashProtectInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.DebugInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.DeviceInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.InstalledVAInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.VAPluginInterceptor;
import com.tencent.mobileqq.minigame.va.util.CommonUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qqmini.proxyimpl.WebRTCProxyImpl;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy;
import com.tencent.util.AppSetting;
import cooperation.qzone.panorama.util.PanoramaConfig;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 c2\u00020\u0001:\u0002cdB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eH\u0002J \u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010+2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0012\u0010-\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010.H\u0016J<\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u000e2\u0006\u00106\u001a\u000207H\u0016J$\u00108\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u00109\u001a\u00020\bH\u0016J\b\u0010:\u001a\u00020\bH\u0016J\u0012\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010=\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\bH\u0016J\u001a\u0010E\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u000e2\u0006\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J\u0010\u0010H\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0015H\u0016JF\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u0002042\b\b\u0002\u0010P\u001a\u0002042\b\b\u0002\u0010Q\u001a\u0002042\b\b\u0002\u0010R\u001a\u00020\bH\u0002J\u0010\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u000eH\u0002J\u0010\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\bH\u0016J\b\u0010W\u001a\u00020\u0018H\u0016J\u0010\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u000eH\u0002J\u0018\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u00182\u0006\u00100\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0010\u0010a\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAManagerImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAManager;", "()V", "crashReportInterceptor", "Lcom/tencent/mobileqq/minigame/va/intercept/interceptor/CrashProtectInterceptor;", "deviceInterceptor", "Lcom/tencent/mobileqq/minigame/va/intercept/interceptor/DeviceInterceptor;", "isAllLoadingResourceDownloaded", "", "isInitListener", "isLebaEntranceClick", "isLebaGuideBubbleReqOnce", "isLebaGuideBubbleShown", "lastBubbleFlagInitUin", "", "launchIntercept", "Lcom/tencent/mobileqq/minigame/va/intercept/MiniBoxLaunchIntercept;", "predownloadedLoadingResourceList", "", "spaceOccupyList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/minigame/api/MiniGameSpaceOccupyListener;", "Lkotlin/collections/ArrayList;", "calculateMiniGameSpaceOccupy", "", "checkSendGuideBubbleReq", "miniGameId", "checkUpdateMiniBoxPlugin", "appId", "checkUpdateVAPlugin", "needPreload", "checkWifiAutoDownloadOrUpdate", "checkYunGameReady", "forceUpdate", "clearLocalHardwareConfig", "createMiniGameInterceptChain", "Lcom/tencent/mobileqq/minigame/va/intercept/BaseInterceptor;", "dailyReportVA", "dailyReportVADownload", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "currentVersion", "getLoadingBgUrl", "Lkotlin/Pair;", "handleCrashInterceptUpdate", "initHardwareConfig", "", "interceptLaunch", "context", "Landroid/content/Context;", "firstPage", "scene", "", "via", "callback", "Lcom/tencent/mobileqq/minigame/api/MiniGameVAInterceptCallback;", "isCrashProtectBlock", "needCheckLastedDex", "isInterceptDisable", "isLoadingBgImgDownloaded", "url", "isModelLimitValid", "checkStorage", "isSupportVA", "notifySpaceOccupyListener", "totalSize", "", "onProcessStateChange", "isForeground", "predownloadLoadingBgImg", MiniChatConstants.MINI_APP_LANDSCAPE, "predownloadLoadingResource", "preloadVAEnv", "registerMiniGameSpaceOccupyListener", "listener", "reportForDaily", "gameAppId", "dexVersion", "isVA", "vaStatus", "vaVersionCode", "progress", "isAppInstalled", "saveSendGuideBubbleReqFlag", PanoramaConfig.KEY_CURRENT_UIN, "setInterceptDisable", "disable", "setLebaGuideBubbleShown", "showInterceptFailedReason", "tips", "startMiniAIO", "action", "params", "Landroid/os/Bundle;", "startMiniGameDownloadManagerActivity", "Landroid/app/Activity;", "unRegisterMiniGameSpaceOccupyListener", "updateCrashProtect", "crashIntercept", "Companion", "MiniGameVAHardwareConfigItem", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAManagerImpl implements IMiniGameVAManager {
    public static final String GUIDE_BUBBLE_CONFIG_ID = "103170";
    private static final String TAG = "MiniGameVAManagerImpl";
    private boolean isAllLoadingResourceDownloaded;
    private boolean isInitListener;
    private boolean isLebaEntranceClick;
    private boolean isLebaGuideBubbleReqOnce;
    private boolean isLebaGuideBubbleShown;
    private final ArrayList<MiniGameSpaceOccupyListener> spaceOccupyList = new ArrayList<>();
    private final List<String> predownloadedLoadingResourceList = new ArrayList();
    private String lastBubbleFlagInitUin = "";
    private final DeviceInterceptor deviceInterceptor = new DeviceInterceptor();
    private final CrashProtectInterceptor crashReportInterceptor = new CrashProtectInterceptor();
    private MiniBoxLaunchIntercept launchIntercept = new MiniBoxLaunchIntercept(new MiniBoxLaunchIntercept.IInterceptorChainBuilder() { // from class: com.tencent.mobileqq.minigame.api.impl.i
        @Override // com.tencent.mobileqq.minigame.va.intercept.MiniBoxLaunchIntercept.IInterceptorChainBuilder
        public final BaseInterceptor buildInterceptorChain() {
            BaseInterceptor launchIntercept$lambda$0;
            launchIntercept$lambda$0 = MiniGameVAManagerImpl.launchIntercept$lambda$0(MiniGameVAManagerImpl.this);
            return launchIntercept$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calculateMiniGameSpaceOccupy$lambda$5() {
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        long allCacheSize = iMiniBoxLauncher.getAllCacheSize(context);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        ((IMiniGameVAService) runtimeService).getSpaceLiveData().postValue(Long.valueOf(allCacheSize));
    }

    private final void checkSendGuideBubbleReq(String miniGameId) {
        if (Intrinsics.areEqual(MiniGameVAUtil.META_MINI_GAME_APPID, miniGameId)) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(GUIDE_BUBBLE_CONFIG_ID, false);
            QLog.d(TAG, 1, "checkSendGuideBubbleReq guideBubbleSwitch:" + isSwitchOn);
            ((IMiniGameMetaGuideBubbleApi) QRoute.api(IMiniGameMetaGuideBubbleApi.class)).clearSendGuideBubbleReqFlag();
            if (isSwitchOn) {
                final String currentUinFromAppRuntime = MiniGameVAUtil.getCurrentUinFromAppRuntime();
                if ((this.isLebaGuideBubbleShown || this.isLebaEntranceClick || this.isLebaGuideBubbleReqOnce) && Intrinsics.areEqual(currentUinFromAppRuntime, this.lastBubbleFlagInitUin)) {
                    QLog.d(TAG, 1, "checkSendGuideBubbleReq shown before");
                    return;
                }
                this.lastBubbleFlagInitUin = currentUinFromAppRuntime;
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
                Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
                String str = "_" + currentUinFromAppRuntime;
                this.isLebaGuideBubbleShown = fromV2.decodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SHOWN + str, false);
                this.isLebaEntranceClick = fromV2.decodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_CLICK + str, false);
                this.isLebaGuideBubbleReqOnce = fromV2.decodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SEND_REQ_ONCE + str, false);
                boolean hasGuideBubbleRedTouch = ((IMiniGameMetaGuideBubbleApi) QRoute.api(IMiniGameMetaGuideBubbleApi.class)).hasGuideBubbleRedTouch();
                QLog.d(TAG, 1, "checkSendGuideBubbleReq isLebaGuideBubbleShown:" + this.isLebaGuideBubbleShown + ", isLebaEntranceClick:" + this.isLebaEntranceClick + ", hasRedTouch:" + hasGuideBubbleRedTouch + ", reqOnce:" + this.isLebaGuideBubbleReqOnce);
                if (this.isLebaGuideBubbleShown || this.isLebaEntranceClick || this.isLebaGuideBubbleReqOnce || hasGuideBubbleRedTouch) {
                    return;
                }
                ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(MiniGameTabTestConstants.EXP_MINIGAME_BOTTOM_TAB_FARM_BUBBLE);
                Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026E_BOTTOM_TAB_FARM_BUBBLE)");
                expEntity.reportExpExposure();
                boolean isExperiment = expEntity.isExperiment();
                QLog.d(TAG, 1, "checkSendGuideBubbleReq isExperiment:" + isExperiment);
                if (isExperiment) {
                    final MiniGameMetaGuideBubbleRequest miniGameMetaGuideBubbleRequest = new MiniGameMetaGuideBubbleRequest();
                    miniGameMetaGuideBubbleRequest.setListener(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl$checkSendGuideBubbleReq$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                            invoke(bool.booleanValue(), str2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, String str2) {
                            QLog.d("MiniGameVAManagerImpl", 1, "checkSendGuideBubbleReq req isSuccess:" + z16);
                            if (z16) {
                                MiniGameVAManagerImpl.this.saveSendGuideBubbleReqFlag(currentUinFromAppRuntime);
                                MiniGameVAManagerImpl.this.showInterceptFailedReason("\u5df2\u8bf7\u6c42\u4e0b\u53d1\u6c14\u6ce1\u7ea2\u70b9");
                            }
                            miniGameMetaGuideBubbleRequest.setListener(null);
                            HashMap hashMap = new HashMap();
                            hashMap.put("ext7", z16 ? "1" : "0");
                            MiniAppUtils.reportMiniGameCenterDC00087("1", "1118", "9390", "939002", "989571", "18", "", hashMap);
                        }
                    });
                    miniGameMetaGuideBubbleRequest.reqSendBubble();
                }
            }
        }
    }

    private final void clearLocalHardwareConfig() {
        this.deviceInterceptor.clearLocalHardwareConfig();
        QLog.d(TAG, 2, "clearLocalHardwareConfig");
    }

    private final BaseInterceptor createMiniGameInterceptChain() {
        DebugInterceptor debugInterceptor = new DebugInterceptor();
        ClickIntervalInterceptor clickIntervalInterceptor = new ClickIntervalInterceptor();
        VAPluginInterceptor vAPluginInterceptor = new VAPluginInterceptor();
        InstalledVAInterceptor installedVAInterceptor = new InstalledVAInterceptor();
        debugInterceptor.setNextInterceptor(clickIntervalInterceptor);
        clickIntervalInterceptor.setNextInterceptor(vAPluginInterceptor);
        vAPluginInterceptor.setNextInterceptor(this.crashReportInterceptor);
        this.crashReportInterceptor.setNextInterceptor(this.deviceInterceptor);
        this.deviceInterceptor.setNextInterceptor(installedVAInterceptor);
        return debugInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dailyReportVA$lambda$6(MiniGameVAManagerImpl this$0, MiniGameVAInterceptConfig.VAInterceptConfig config, String currentVersion, MiniBoxAppInfo miniBoxAppInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        if (miniBoxAppInfo != null) {
            String gameAppId = config.getGameAppId();
            Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
            reportForDaily$default(this$0, gameAppId, currentVersion, true, 1, miniBoxAppInfo.getVersionCode(), 0, false, 96, null);
        } else {
            Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
            this$0.dailyReportVADownload(config, currentVersion);
        }
    }

    private final void dailyReportVADownload(final MiniGameVAInterceptConfig.VAInterceptConfig config, final String currentVersion) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IMiniGameVAService iMiniGameVAService = peekAppRuntime != null ? (IMiniGameVAService) peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "") : null;
        if (iMiniGameVAService != null) {
            iMiniGameVAService.queryExistDownloadList(new Function2<Boolean, List<? extends MiniGameDownloadDataWrapper>, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl$dailyReportVADownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MiniGameDownloadDataWrapper> list) {
                    invoke(bool.booleanValue(), (List<MiniGameDownloadDataWrapper>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, List<MiniGameDownloadDataWrapper> list) {
                    boolean equals$default;
                    MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = null;
                    if (z16 && list != null) {
                        MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = config;
                        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper2 = null;
                        for (MiniGameDownloadDataWrapper miniGameDownloadDataWrapper3 : list) {
                            equals$default = StringsKt__StringsJVMKt.equals$default(miniGameDownloadDataWrapper3.getData().getPkgName(), vAInterceptConfig.getGameAppPkgName(), false, 2, null);
                            if (equals$default) {
                                miniGameDownloadDataWrapper2 = miniGameDownloadDataWrapper3;
                            }
                        }
                        miniGameDownloadDataWrapper = miniGameDownloadDataWrapper2;
                    }
                    if (miniGameDownloadDataWrapper != null) {
                        MiniGameVAManagerImpl.reportForDaily$default(MiniGameVAManagerImpl.this, config.getGameAppId(), currentVersion, false, 2, 0, miniGameDownloadDataWrapper.getProgress(), false, 80, null);
                    } else {
                        MiniGameVAManagerImpl.reportForDaily$default(MiniGameVAManagerImpl.this, config.getGameAppId(), currentVersion, false, 4, 0, 0, PackageUtil.isAppInstalled(MobileQQ.sMobileQQ.getApplicationContext(), config.getGameAppPkgName()), 48, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseInterceptor launchIntercept$lambda$0(MiniGameVAManagerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.createMiniGameInterceptChain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySpaceOccupyListener(long totalSize) {
        QLog.i(TAG, 1, "notifySpaceOccupyListener totalSize:" + totalSize);
        Iterator<T> it = this.spaceOccupyList.iterator();
        while (it.hasNext()) {
            ((MiniGameSpaceOccupyListener) it.next()).totalOccupiedSpaceUpdate(totalSize);
        }
    }

    private final void predownloadLoadingResource() {
        if (this.isAllLoadingResourceDownloaded) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAManagerImpl.predownloadLoadingResource$lambda$12(MiniGameVAManagerImpl.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void predownloadLoadingResource$lambda$12(MiniGameVAManagerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniGameCustomLoadingConfig miniGameCustomLoadingConfig = (MiniGameCustomLoadingConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameCustomLoadingConfig.CONFIG_ID);
        if (miniGameCustomLoadingConfig == null || miniGameCustomLoadingConfig.getBgConfigMap().isEmpty()) {
            return;
        }
        int i3 = 0;
        for (Map.Entry<String, MiniGameCustomLoadingConfig.LoadingBgConfig> entry : miniGameCustomLoadingConfig.getBgConfigMap().entrySet()) {
            if ((entry.getValue().getLoadingBgImgUrl().length() > 0) && this$0.predownloadLoadingBgImg(entry.getValue().getLoadingBgImgUrl(), false)) {
                i3++;
            }
            if ((entry.getValue().getLandscapeLoadingBgImgUrl().length() > 0) && this$0.predownloadLoadingBgImg(entry.getValue().getLandscapeLoadingBgImgUrl(), true)) {
                i3++;
            }
        }
        if (i3 <= 0 || i3 != this$0.predownloadedLoadingResourceList.size()) {
            return;
        }
        this$0.isAllLoadingResourceDownloaded = true;
        QLog.d(TAG, 1, "predownloadLoadingResource all downloaded");
    }

    private final void preloadVAEnv(final boolean needPreload) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final IMiniGameVAService iMiniGameVAService = peekAppRuntime != null ? (IMiniGameVAService) peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "") : null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAManagerImpl.preloadVAEnv$lambda$14(needPreload, iMiniGameVAService);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerMiniGameSpaceOccupyListener$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveSendGuideBubbleReqFlag(String currentUin) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        String str = "_" + currentUin;
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SEND_REQ_FLAG + str, true);
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SEND_REQ_ONCE + str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInterceptFailedReason(final String tips) {
        if (AppSetting.isPublicVersion()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAManagerImpl.showInterceptFailedReason$lambda$13(tips);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInterceptFailedReason$lambda$13(String tips) {
        Intrinsics.checkNotNullParameter(tips, "$tips");
        try {
            QQToast.makeText(BaseApplication.getContext(), tips, 0).show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showInterceptFailedReason exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void calculateMiniGameSpaceOccupy() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAManagerImpl.calculateMiniGameSpaceOccupy$lambda$5();
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void checkUpdateVAPlugin(String appId, boolean needPreload) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        checkUpdateMiniBoxPlugin(appId);
        preloadVAEnv(needPreload);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void checkWifiAutoDownloadOrUpdate() {
        String joinToString$default;
        if (!NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ)) {
            QLog.i(TAG, 2, "ignore auto download or update check because no wifi connected");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final IMiniGameVAService iMiniGameVAService = peekAppRuntime != null ? (IMiniGameVAService) peekAppRuntime.getRuntimeService(IMiniGameVAService.class, "") : null;
        HashSet<String> wifiAutoDownloadVAAppIds = MiniGameVAUtil.getWifiAutoDownloadVAAppIds();
        HashSet<String> wifiAutoUpgradeVAFlagAppIds = MiniGameVAUtil.getWifiAutoUpgradeVAFlagAppIds();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        if (wifiAutoDownloadVAAppIds != null) {
            linkedHashSet.addAll(wifiAutoDownloadVAAppIds);
        }
        if (wifiAutoUpgradeVAFlagAppIds != null) {
            linkedHashSet.addAll(wifiAutoUpgradeVAFlagAppIds);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedHashSet, ",", null, null, 0, null, null, 62, null);
        QLog.d(TAG, 1, "checkWifiAutoDownloadOrUpdate appIds:" + joinToString$default);
        Function2<Boolean, MiniGameDownloadDataWrapper, Unit> function2 = new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl$checkWifiAutoDownloadOrUpdate$callback$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                invoke(bool.booleanValue(), miniGameDownloadDataWrapper);
                return Unit.INSTANCE;
            }

            public void invoke(boolean isSuccess, MiniGameDownloadDataWrapper data) {
                IMiniGameVAService iMiniGameVAService2;
                MiniGameDownloadData data2;
                String gameId;
                boolean isBlank;
                QLog.d("MiniGameVAManagerImpl", 4, "checkWifiAutoDownloadOrUpdate data:" + data);
                if (isSuccess) {
                    boolean z16 = false;
                    if (data != null && (data2 = data.getData()) != null && (gameId = data2.getGameId()) != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(gameId);
                        if (!isBlank) {
                            z16 = true;
                        }
                    }
                    if (z16 && MiniGameDownloadConstant.isNeedDownloadAndInstall(data) && (iMiniGameVAService2 = IMiniGameVAService.this) != null) {
                        iMiniGameVAService2.startDownload(data.getData().getGameId(), Boolean.FALSE, Boolean.TRUE, DownloadScene.SCENE_INSTALL_IN_LOADING.getScene(), true);
                    }
                }
            }
        };
        for (String str : linkedHashSet) {
            if (iMiniGameVAService != null) {
                iMiniGameVAService.queryVAInfo(str, function2);
            }
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void checkYunGameReady(boolean forceUpdate) {
        WebRtcProxy webRtcProxy = (WebRtcProxy) ProxyManager.get(WebRtcProxy.class);
        if (webRtcProxy instanceof WebRTCProxyImpl) {
            ((WebRTCProxyImpl) webRtcProxy).j(Boolean.valueOf(forceUpdate));
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void dailyReportVA() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig;
        final MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig;
        boolean lastEnterYunGame = MiniGameVAUtil.getLastEnterYunGame();
        QLog.i(TAG, 1, "reportForDaily dailyReportVA isLastDayEnter:" + lastEnterYunGame);
        if (lastEnterYunGame) {
            final String currentVersion = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
            if (TextUtils.isEmpty(currentVersion) || (miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID)) == null || !miniGameVAInterceptConfig.getInterceptConfigMap().containsKey(MiniGameVAUtil.META_MINI_GAME_APPID) || (vAInterceptConfig = miniGameVAInterceptConfig.getInterceptConfigMap().get(MiniGameVAUtil.META_MINI_GAME_APPID)) == null) {
                return;
            }
            this.deviceInterceptor.initHardwareConfigFromCache();
            if (IMiniGameVAManager.DefaultImpls.isModelLimitValid$default(this, MiniGameVAUtil.META_MINI_GAME_APPID, false, 2, null)) {
                MiniBoxSDK.getInstalledAppInfo(vAInterceptConfig.getGameAppPkgName(), new AsyncCallback() { // from class: com.tencent.mobileqq.minigame.api.impl.k
                    @Override // com.tencent.minibox.business.api.AsyncCallback
                    public final void onResult(Object obj) {
                        MiniGameVAManagerImpl.dailyReportVA$lambda$6(MiniGameVAManagerImpl.this, vAInterceptConfig, currentVersion, (MiniBoxAppInfo) obj);
                    }
                });
                return;
            }
            String gameAppId = vAInterceptConfig.getGameAppId();
            Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
            reportForDaily$default(this, gameAppId, currentVersion, false, 3, 0, 0, false, 112, null);
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void handleCrashInterceptUpdate() {
        this.crashReportInterceptor.updateCrashIntercept(true);
        clearLocalHardwareConfig();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void initHardwareConfig() {
        QLog.d(TAG, 1, "initHardwareConfig");
        initHardwareConfig((MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID));
        MiniGamePreDownload.INSTANCE.checkAndPreloadMiniGame();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void interceptLaunch(Context context, String appId, String firstPage, int scene, String via, MiniGameVAInterceptCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        predownloadLoadingResource();
        checkSendGuideBubbleReq(appId);
        InterceptRequest interceptRequest = new InterceptRequest(context, callback);
        interceptRequest.startInterceptTime = System.currentTimeMillis();
        interceptRequest.appId = appId;
        interceptRequest.firstPage = firstPage;
        interceptRequest.scene = scene;
        interceptRequest.via = via;
        if (!interceptRequest.checkVAConfig()) {
            MiniGameVAInterceptCallback.DefaultImpls.onInterceptResult$default(callback, false, false, 2, null);
            QLog.e(TAG, 1, "interceptLaunch interceptRequest vaConfig is invalid");
        } else {
            this.launchIntercept.launch(interceptRequest);
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public boolean isCrashProtectBlock(Context context, String appId, boolean needCheckLastedDex) {
        return this.crashReportInterceptor.isCrashProtectBlock(context, appId, needCheckLastedDex);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public boolean isInterceptDisable() {
        boolean isLocalInterceptDisable = CommonUtil.isLocalInterceptDisable();
        QLog.d(TAG, 1, "isInterceptDisable disable:" + isLocalInterceptDisable);
        return isLocalInterceptDisable;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public boolean isModelLimitValid(String appId, boolean checkStorage) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (!AppSetting.isPublicVersion() && !AppSetting.isGrayVersion() && isInterceptDisable()) {
            QLog.d(TAG, 1, "isModelLimitValid appId:" + appId + ", isInterceptDisable");
            return false;
        }
        return this.deviceInterceptor.isModelLimitValid(appId, checkStorage);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public boolean isSupportVA() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig == null || miniGameVAInterceptConfig.getInterceptConfigMap().isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig>> it = miniGameVAInterceptConfig.getInterceptConfigMap().entrySet().iterator();
        boolean z16 = false;
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> next = it.next();
                String key = next.getKey();
                MiniGameVAInterceptConfig.VAInterceptConfig value = next.getValue();
                if (value.getGameAppId().length() == 0) {
                    break;
                }
                if (value.getGameAppPkgName().length() == 0) {
                    break;
                }
                if (value.getConfigId().length() == 0) {
                    break;
                }
                z16 = IMiniGameVAManager.DefaultImpls.isModelLimitValid$default(this, key, false, 2, null);
            } else {
                QLog.w(TAG, 1, "isSupportVA:" + z16);
                return z16;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void onProcessStateChange(boolean isForeground) {
        String str;
        QLog.i(TAG, 1, "onProcessStateChange isForeground=" + isForeground);
        Bundle bundle = new Bundle();
        bundle.putString(MiniChatConstants.PARAM_PROC_NAME, BaseApplicationImpl.getApplication().getQQProcessName());
        bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, "minibox_qipc_module");
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        if (isForeground) {
            str = MiniChatConstants.CMD_PROC_FOREGROUND;
        } else {
            str = MiniChatConstants.CMD_PROC_BACKGROUND;
        }
        client.callServer("MiniMsgIPCServer", str, bundle, null);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void registerMiniGameSpaceOccupyListener(MiniGameSpaceOccupyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.isInitListener) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            IMiniGameVAService iMiniGameVAService = (IMiniGameVAService) runtimeService;
            MutableLiveData<Long> spaceLiveData = iMiniGameVAService.getSpaceLiveData();
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl$registerMiniGameSpaceOccupyListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long it) {
                    MiniGameVAManagerImpl miniGameVAManagerImpl = MiniGameVAManagerImpl.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    miniGameVAManagerImpl.notifySpaceOccupyListener(it.longValue());
                }
            };
            spaceLiveData.observeForever(new Observer() { // from class: com.tencent.mobileqq.minigame.api.impl.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniGameVAManagerImpl.registerMiniGameSpaceOccupyListener$lambda$3(Function1.this, obj);
                }
            });
            iMiniGameVAService.queryExistVAList(new Function2<Boolean, List<? extends MiniGameDownloadDataWrapper>, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl$registerMiniGameSpaceOccupyListener$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MiniGameDownloadDataWrapper> list) {
                    invoke(bool.booleanValue(), (List<MiniGameDownloadDataWrapper>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, List<MiniGameDownloadDataWrapper> list) {
                    QLog.i("MiniGameVAManagerImpl", 1, "queryExistVAList preload data:" + list);
                }
            });
            this.isInitListener = true;
        }
        this.spaceOccupyList.add(listener);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void setInterceptDisable(boolean disable) {
        QLog.d(TAG, 1, "setInterceptDisable disable:" + disable);
        CommonUtil.setLocalInterceptDisable(disable);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void setLebaGuideBubbleShown() {
        QLog.d(TAG, 1, "setLebaGuideBubbleShown");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_GUIDE_BUBBLE_SHOWN + ("_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()), true);
        this.isLebaGuideBubbleShown = true;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public boolean startMiniAIO(String action, Bundle params) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!Intrinsics.areEqual(action, MiniChatConstants.ACTION_MINI_START_MINI_AIO)) {
            return false;
        }
        MiniChatActivity.J2(params, true, true, true);
        return true;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void startMiniGameDownloadManagerActivity(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("tab", 1);
        intent.putExtras(bundle);
        QPublicFragmentActivity.start(context, intent, MiniGameDownloadManagerFragment.class);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void unRegisterMiniGameSpaceOccupyListener(MiniGameSpaceOccupyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.spaceOccupyList.remove(listener);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void updateCrashProtect(boolean crashIntercept) {
        this.crashReportInterceptor.updateCrashIntercept(crashIntercept);
    }

    private final void checkUpdateMiniBoxPlugin(String appId) {
        int lastIndexOf$default;
        int lastIndexOf$default2;
        MiniGameVAHardwareConfigItem hardwareConfigItem = this.deviceInterceptor.getHardwareConfigItem(appId);
        if (hardwareConfigItem == null || TextUtils.isEmpty(hardwareConfigItem.getMiniPluginVersion())) {
            return;
        }
        String miniPluginVersion = hardwareConfigItem.getMiniPluginVersion();
        if (((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMatchVAPlugin(miniPluginVersion)) {
            String currentVersion = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
            QLog.i(TAG, 1, "checkUpdateMiniBox availableVersion:" + miniPluginVersion + " currentVersion:" + currentVersion);
            if (TextUtils.isEmpty(currentVersion)) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) currentVersion, ".", 0, false, 6, (Object) null);
            if (lastIndexOf$default < 0) {
                return;
            }
            String substring = currentVersion.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) miniPluginVersion, ".", 0, false, 6, (Object) null);
            if (lastIndexOf$default2 < 0) {
                return;
            }
            String substring2 = miniPluginVersion.substring(lastIndexOf$default2 + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            try {
                if (Integer.parseInt(substring2) > Integer.parseInt(substring)) {
                    QLog.i(TAG, 1, "clean plugin start");
                    ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).updatePlugin(true);
                } else {
                    QLog.i(TAG, 1, "availableVersion not need update ");
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "checkUpdateMiniBox", e16);
                return;
            }
        }
        QLog.i(TAG, 1, "checkUpdateMiniBox isMatchVAPlugin is false.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadVAEnv$lambda$14(boolean z16, IMiniGameVAService iMiniGameVAService) {
        if (z16) {
            IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            iMiniBoxLauncher.preLaunchProcess(context);
        }
        if (iMiniGameVAService != null) {
            iMiniGameVAService.preloadVADownload();
        }
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public Pair<String, String> getLoadingBgUrl(String appId) {
        MiniGameCustomLoadingConfig miniGameCustomLoadingConfig;
        if ((appId == null || appId.length() == 0) || (miniGameCustomLoadingConfig = (MiniGameCustomLoadingConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameCustomLoadingConfig.CONFIG_ID)) == null || !miniGameCustomLoadingConfig.getBgConfigMap().containsKey(appId)) {
            return null;
        }
        MiniGameCustomLoadingConfig.LoadingBgConfig loadingBgConfig = miniGameCustomLoadingConfig.getBgConfigMap().get(appId);
        if (isLoadingBgImgDownloaded(loadingBgConfig != null ? loadingBgConfig.getLoadingBgImgUrl() : null)) {
            if (isLoadingBgImgDownloaded(loadingBgConfig != null ? loadingBgConfig.getLandscapeLoadingBgImgUrl() : null)) {
                Intrinsics.checkNotNull(loadingBgConfig);
                return new Pair<>(loadingBgConfig.getLoadingBgImgUrl(), loadingBgConfig.getLandscapeLoadingBgImgUrl());
            }
        }
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAManagerImpl$MiniGameVAHardwareConfigItem;", "", "appId", "", "isVAAvailable", "", "minRemainStorage", "", "miniPluginVersion", "failedReason", EmojiManagerServiceConstant.PARAMS_SWITCH_TAB, "useWifiAndXGSwitch", "(Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;ZZ)V", "getAppId", "()Ljava/lang/String;", "getFailedReason", "()Z", "getMinRemainStorage", "()J", "getMiniPluginVersion", "getUseWifiAndXGSwitch", "getWifiAutoDownload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class MiniGameVAHardwareConfigItem {
        private final String appId;
        private final String failedReason;
        private final boolean isVAAvailable;
        private final long minRemainStorage;
        private final String miniPluginVersion;
        private final boolean useWifiAndXGSwitch;
        private final boolean wifiAutoDownload;

        public MiniGameVAHardwareConfigItem(String appId, boolean z16, long j3, String miniPluginVersion, String failedReason, boolean z17, boolean z18) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(miniPluginVersion, "miniPluginVersion");
            Intrinsics.checkNotNullParameter(failedReason, "failedReason");
            this.appId = appId;
            this.isVAAvailable = z16;
            this.minRemainStorage = j3;
            this.miniPluginVersion = miniPluginVersion;
            this.failedReason = failedReason;
            this.wifiAutoDownload = z17;
            this.useWifiAndXGSwitch = z18;
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsVAAvailable() {
            return this.isVAAvailable;
        }

        /* renamed from: component3, reason: from getter */
        public final long getMinRemainStorage() {
            return this.minRemainStorage;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMiniPluginVersion() {
            return this.miniPluginVersion;
        }

        /* renamed from: component5, reason: from getter */
        public final String getFailedReason() {
            return this.failedReason;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getWifiAutoDownload() {
            return this.wifiAutoDownload;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getUseWifiAndXGSwitch() {
            return this.useWifiAndXGSwitch;
        }

        public final MiniGameVAHardwareConfigItem copy(String appId, boolean isVAAvailable, long minRemainStorage, String miniPluginVersion, String failedReason, boolean wifiAutoDownload, boolean useWifiAndXGSwitch) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(miniPluginVersion, "miniPluginVersion");
            Intrinsics.checkNotNullParameter(failedReason, "failedReason");
            return new MiniGameVAHardwareConfigItem(appId, isVAAvailable, minRemainStorage, miniPluginVersion, failedReason, wifiAutoDownload, useWifiAndXGSwitch);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getFailedReason() {
            return this.failedReason;
        }

        public final long getMinRemainStorage() {
            return this.minRemainStorage;
        }

        public final String getMiniPluginVersion() {
            return this.miniPluginVersion;
        }

        public final boolean getUseWifiAndXGSwitch() {
            return this.useWifiAndXGSwitch;
        }

        public final boolean getWifiAutoDownload() {
            return this.wifiAutoDownload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.appId.hashCode() * 31;
            boolean z16 = this.isVAAvailable;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int a16 = (((((((hashCode + i3) * 31) + com.tencent.mobileqq.mini.appbrand.utils.f.a(this.minRemainStorage)) * 31) + this.miniPluginVersion.hashCode()) * 31) + this.failedReason.hashCode()) * 31;
            boolean z17 = this.wifiAutoDownload;
            int i16 = z17;
            if (z17 != 0) {
                i16 = 1;
            }
            int i17 = (a16 + i16) * 31;
            boolean z18 = this.useWifiAndXGSwitch;
            return i17 + (z18 ? 1 : z18 ? 1 : 0);
        }

        public final boolean isVAAvailable() {
            return this.isVAAvailable;
        }

        public String toString() {
            return "MiniGameVAHardwareConfigItem(appId=" + this.appId + ", isVAAvailable=" + this.isVAAvailable + ", minRemainStorage=" + this.minRemainStorage + ", miniPluginVersion=" + this.miniPluginVersion + ", failedReason=" + this.failedReason + ", wifiAutoDownload=" + this.wifiAutoDownload + ", useWifiAndXGSwitch=" + this.useWifiAndXGSwitch + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MiniGameVAHardwareConfigItem)) {
                return false;
            }
            MiniGameVAHardwareConfigItem miniGameVAHardwareConfigItem = (MiniGameVAHardwareConfigItem) other;
            return Intrinsics.areEqual(this.appId, miniGameVAHardwareConfigItem.appId) && this.isVAAvailable == miniGameVAHardwareConfigItem.isVAAvailable && this.minRemainStorage == miniGameVAHardwareConfigItem.minRemainStorage && Intrinsics.areEqual(this.miniPluginVersion, miniGameVAHardwareConfigItem.miniPluginVersion) && Intrinsics.areEqual(this.failedReason, miniGameVAHardwareConfigItem.failedReason) && this.wifiAutoDownload == miniGameVAHardwareConfigItem.wifiAutoDownload && this.useWifiAndXGSwitch == miniGameVAHardwareConfigItem.useWifiAndXGSwitch;
        }

        public /* synthetic */ MiniGameVAHardwareConfigItem(String str, boolean z16, long j3, String str2, String str3, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z16, j3, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, z17, z18);
        }
    }

    private final boolean isLoadingBgImgDownloaded(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(QQPicLoader.f201806a.d().getPicLocalPath(Option.obtain().setUrl(url)));
        if (!fileExistsAndNotEmpty && this.isAllLoadingResourceDownloaded) {
            this.isAllLoadingResourceDownloaded = false;
            this.predownloadedLoadingResourceList.clear();
            QLog.d(TAG, 1, "isLoadingBgImgDownloaded reset flag");
        }
        return fileExistsAndNotEmpty;
    }

    private final boolean predownloadLoadingBgImg(String url, boolean isLandscape) {
        int decodeInt;
        int decodeInt2;
        boolean z16 = false;
        if (url == null || url.length() == 0) {
            return false;
        }
        Option url2 = Option.obtain().setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        String picLocalPath = qQPicLoader.d().getPicLocalPath(url2);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        if (isLandscape) {
            decodeInt = fromV2.decodeInt(MiniGameCustomLoadingView.MMKV_KEY_VIEW_LANDSCAPE_WIDTH, 0);
            decodeInt2 = fromV2.decodeInt(MiniGameCustomLoadingView.MMKV_KEY_VIEW_LANDSCAPE_HEIGHT, 0);
        } else {
            decodeInt = fromV2.decodeInt(MiniGameCustomLoadingView.MMKV_KEY_VIEW_WIDTH, 0);
            decodeInt2 = fromV2.decodeInt(MiniGameCustomLoadingView.MMKV_KEY_VIEW_HEIGHT, 0);
        }
        if (decodeInt != 0 && decodeInt2 != 0) {
            url2.setPredecode(true);
            url2.setRequestWidth(decodeInt);
            url2.setRequestHeight(decodeInt2);
            z16 = true;
        }
        boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(picLocalPath);
        QLog.d(TAG, 1, "predownloadLoadingBgImg isLandscape:" + isLandscape + ", isPredecode:" + z16 + ", isDownloaded:" + fileExistsAndNotEmpty + ", reqWidth:" + decodeInt + ", reqHeight:" + decodeInt2 + ", url:" + url);
        qQPicLoader.d().loadImage(url2, null);
        if (fileExistsAndNotEmpty && z16 && !this.predownloadedLoadingResourceList.contains(url)) {
            QLog.d(TAG, 1, "predownloadLoadingBgImg downloaded url:" + url);
            this.predownloadedLoadingResourceList.add(url);
        }
        return fileExistsAndNotEmpty;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAManager
    public void initHardwareConfig(Object config) {
        if (!(config instanceof MiniGameVAInterceptConfig)) {
            QLog.w(TAG, 1, "initHardwareConfig not MiniGameVAInterceptConfig: " + config);
            return;
        }
        this.deviceInterceptor.updateHardwareConfigFromServer((MiniGameVAInterceptConfig) config);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void reportForDaily(String gameAppId, String dexVersion, boolean isVA, int vaStatus, int vaVersionCode, int progress, boolean isAppInstalled) {
        String str;
        String str2;
        String str3;
        Map mapOf;
        String str4 = "1";
        if (MiniGameVAUtil.getUseWifiAndXGSwitch()) {
            str = "1";
        } else {
            str = "2";
        }
        if (((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        HashSet<String> wifiAutoDownloadVAAppIds = MiniGameVAUtil.getWifiAutoDownloadVAAppIds();
        HashSet<String> wifiAutoUpgradeVAFlagAppIds = MiniGameVAUtil.getWifiAutoUpgradeVAFlagAppIds();
        if (!(wifiAutoDownloadVAAppIds != null && wifiAutoDownloadVAAppIds.contains(MiniGameVAUtil.META_MINI_GAME_APPID))) {
            if (!(wifiAutoUpgradeVAFlagAppIds != null && wifiAutoUpgradeVAFlagAppIds.contains(MiniGameVAUtil.META_MINI_GAME_APPID))) {
                str3 = "2";
                QLog.i(TAG, 1, "reportForDaily isVA:" + isVA + ",vaStatus:" + vaStatus + ",vaVersionCode:" + vaVersionCode + ",progress:" + progress + ",dexVersion:" + dexVersion + " isAppInstalled:" + isAppInstalled + " wifiAndXGFlag:" + str + " kingCardFlag:" + str2 + " isAutoDownloadFlag:" + str3);
                Pair[] pairArr = new Pair[8];
                if (!isVA) {
                    str4 = "2";
                } else if (isAppInstalled) {
                    str4 = "3";
                }
                pairArr[0] = TuplesKt.to("ext7", str4);
                pairArr[1] = TuplesKt.to("ext8", String.valueOf(vaStatus));
                pairArr[2] = TuplesKt.to("ext2", dexVersion);
                pairArr[3] = TuplesKt.to("ext6", String.valueOf(vaVersionCode));
                pairArr[4] = TuplesKt.to("ext46", String.valueOf(progress));
                pairArr[5] = TuplesKt.to("ext45", str);
                pairArr[6] = TuplesKt.to("ext23", str2);
                pairArr[7] = TuplesKt.to("ext16", str3);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989407", "18", gameAppId, mapOf);
            }
        }
        str3 = "1";
        QLog.i(TAG, 1, "reportForDaily isVA:" + isVA + ",vaStatus:" + vaStatus + ",vaVersionCode:" + vaVersionCode + ",progress:" + progress + ",dexVersion:" + dexVersion + " isAppInstalled:" + isAppInstalled + " wifiAndXGFlag:" + str + " kingCardFlag:" + str2 + " isAutoDownloadFlag:" + str3);
        Pair[] pairArr2 = new Pair[8];
        if (!isVA) {
        }
        pairArr2[0] = TuplesKt.to("ext7", str4);
        pairArr2[1] = TuplesKt.to("ext8", String.valueOf(vaStatus));
        pairArr2[2] = TuplesKt.to("ext2", dexVersion);
        pairArr2[3] = TuplesKt.to("ext6", String.valueOf(vaVersionCode));
        pairArr2[4] = TuplesKt.to("ext46", String.valueOf(progress));
        pairArr2[5] = TuplesKt.to("ext45", str);
        pairArr2[6] = TuplesKt.to("ext23", str2);
        pairArr2[7] = TuplesKt.to("ext16", str3);
        mapOf = MapsKt__MapsKt.mapOf(pairArr2);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989407", "18", gameAppId, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportForDaily$default(MiniGameVAManagerImpl miniGameVAManagerImpl, String str, String str2, boolean z16, int i3, int i16, int i17, boolean z17, int i18, Object obj) {
        miniGameVAManagerImpl.reportForDaily(str, str2, z16, i3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) != 0 ? 0 : i17, (i18 & 64) != 0 ? false : z17);
    }
}
