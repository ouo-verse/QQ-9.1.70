package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameAutoUpdateService;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameListStatService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGamePCDNApi;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterStepCheckApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.video.interceptor.GameCenterPerfReportInterceptor;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J+\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0016*\u0004\u0018\u00010\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameCenterStepCheckApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameCenterStepCheckApi;", "", "updateGamePublicAccountKuikly", "checkIfCleanPCDNFiles", "", "dirPath", "", "overDueTime", "initGameVideoInterceptor", "checkIfShowDownloadBanner", "checkGameCenterConfigUpdate", "pullGamePubAdOrNoticeMsg", "", "isAutoDownloadSwitchOff", "registerObservers", "pullAutoDownloadTask", "preloadGameAioLittleTailConfig", "initGameVAconfig", "registerPreDownloadBroadcast", "registerGameListCallback", "Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "apiClazz", "getServiceInMain", "(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;", "Lmqq/app/AppRuntime;", "getApp", "doCommonStep", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterStepCheckApiImpl implements IGameCenterStepCheckApi {

    @NotNull
    private static final String TAG = "GameCenterStepCheckApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/api/impl/GameCenterStepCheckApiImpl$b", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$c;", "", "unreadCnt", "", "onSuccess", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IQQGamePubMsgApi.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f211855a;

        b(List<String> list) {
            this.f211855a = list;
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.c
        public void onSuccess(int unreadCnt) {
            if (unreadCnt > 0) {
                ((IQQGameKuiklyApi) QRoute.api(IQQGameKuiklyApi.class)).updateGamePubAccountKuikly(this.f211855a);
            }
        }
    }

    private final void checkGameCenterConfigUpdate() {
        ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) getServiceInMain(IGameMsgManagerService.class);
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.checkGameMsgTabConfigUpdate();
        }
    }

    private final void checkIfCleanPCDNFiles() {
        JSONObject pCDNConfig = ((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).getPCDNConfig();
        long optLong = (pCDNConfig != null ? Long.valueOf(pCDNConfig.optLong("filesOverdueTime")) : null) != null ? pCDNConfig.optLong("filesOverdueTime") : 259200000L;
        checkIfCleanPCDNFiles(((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).getPcdnBufferDirPath(), optLong);
        checkIfCleanPCDNFiles(((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).getPcdnLogPath(), optLong);
    }

    private final void checkIfShowDownloadBanner() {
        IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) getServiceInMain(IQQGameNoticeService.class);
        if (iQQGameNoticeService != null) {
            iQQGameNoticeService.onEvent(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doCommonStep$lambda$0(GameCenterStepCheckApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 2, "[doCommonStep]");
        this$0.pullGamePubAdOrNoticeMsg();
        this$0.checkGameCenterConfigUpdate();
        this$0.checkIfShowDownloadBanner();
        this$0.pullAutoDownloadTask();
        this$0.preloadGameAioLittleTailConfig();
        this$0.registerObservers();
        this$0.initGameVideoInterceptor();
        this$0.initGameVAconfig();
        this$0.updateGamePublicAccountKuikly();
        this$0.checkIfCleanPCDNFiles();
    }

    private final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final <T extends IRuntimeService> T getServiceInMain(Class<T> apiClazz) {
        AppRuntime app = getApp();
        if (app != null) {
            return (T) app.getRuntimeService(apiClazz, "");
        }
        return null;
    }

    private final void initGameVAconfig() {
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).initHardwareConfig();
    }

    private final void initGameVideoInterceptor() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(GameCenterPerfReportInterceptor.class);
            RFWPlayerManger.g(106).init(new RFWPlayerConfig.RFWPlayerInitBuilder().setInterceptor(arrayList).build());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private final boolean isAutoDownloadSwitchOff() {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar == null) {
            gVar = new com.tencent.gamecenter.wadl.biz.entity.g(IQQGameConfigService.KEY_CONF_COMM);
        }
        if (!gVar.f106807t && !gVar.f106808u) {
            QLog.w(TAG, 2, "GameCenterCheck switch is off");
            return true;
        }
        return false;
    }

    private final void preloadGameAioLittleTailConfig() {
        ((IGameAioLittleTailApi) QRoute.api(IGameAioLittleTailApi.class)).preloadLittleTailConfig();
    }

    private final void pullAutoDownloadTask() {
        if (isAutoDownloadSwitchOff()) {
            return;
        }
        IQQGameAutoDownloadService iQQGameAutoDownloadService = (IQQGameAutoDownloadService) getServiceInMain(IQQGameAutoDownloadService.class);
        if (iQQGameAutoDownloadService != null) {
            iQQGameAutoDownloadService.pullAutoDownloadTask();
        }
        IQQGameAutoUpdateService iQQGameAutoUpdateService = (IQQGameAutoUpdateService) getServiceInMain(IQQGameAutoUpdateService.class);
        if (iQQGameAutoUpdateService != null) {
            iQQGameAutoUpdateService.pullAutoUpdateTask(false);
        }
    }

    private final void pullGamePubAdOrNoticeMsg() {
        ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).pullAd(1);
        IGamePubAccountMsgService iGamePubAccountMsgService = (IGamePubAccountMsgService) getServiceInMain(IGamePubAccountMsgService.class);
        if (iGamePubAccountMsgService != null) {
            iGamePubAccountMsgService.reqGamePaNoticeByTianShu();
        }
    }

    private final void registerGameListCallback() {
        IQQGameListStatService iQQGameListStatService = (IQQGameListStatService) getServiceInMain(IQQGameListStatService.class);
        if (iQQGameListStatService != null) {
            iQQGameListStatService.statGameList();
        }
    }

    private final void registerObservers() {
        registerPreDownloadBroadcast();
        registerGameListCallback();
    }

    private final void registerPreDownloadBroadcast() {
        IQQGameCheckService iQQGameCheckService;
        if (!isAutoDownloadSwitchOff() && (iQQGameCheckService = (IQQGameCheckService) getServiceInMain(IQQGameCheckService.class)) != null && iQQGameCheckService.hasAppointTask()) {
            GameCenterBroadcastReceiver.c();
        }
    }

    private final void updateGamePublicAccountKuikly() {
        boolean z16;
        List<String> gamePubPreloadKuilyBundleList = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGamePubPreloadKuilyBundleList();
        List<String> list = gamePubPreloadKuilyBundleList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getUnreadCnt(new b(gamePubPreloadKuilyBundleList));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterStepCheckApi
    public void doCommonStep() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.w
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterStepCheckApiImpl.doCommonStep$lambda$0(GameCenterStepCheckApiImpl.this);
            }
        }, 16, null, false);
    }

    private final void checkIfCleanPCDNFiles(String dirPath, long overDueTime) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            File[] listFiles = new File(dirPath).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    long abs = Math.abs(System.currentTimeMillis() - file.lastModified());
                    QLog.i(TAG, 2, "name:" + file.getName() + ",lastModified:" + simpleDateFormat.format(Long.valueOf(file.lastModified())) + ",gap:" + abs);
                    if (overDueTime < abs) {
                        QLog.i(TAG, 2, "initPCDNSth timeOverDue,delete file:" + file);
                        FileUtils.deleteFile(file);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
