package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.minigame.config.MiniGamePreDownloadConfig;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePreDownload;", "", "()V", "TAG", "", "checkAndPreloadMiniGame", "", "getPreDownloadTime", "", MiniGameKuiklyModule.METHOD_PRELOAD_MINI_GAME, "appId", "downloadConfig", "Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfig$DownloadConfig;", "setPreDownloadTime", "requestTime", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePreDownload {
    public static final MiniGamePreDownload INSTANCE = new MiniGamePreDownload();
    private static final String TAG = "MiniGameVAPreDownload";

    MiniGamePreDownload() {
    }

    private final long getPreDownloadTime() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        return fromV2.decodeLong(MiniGameVAMMKVKEY.MINIGAME_DOWNLOAD_APPID, 0L);
    }

    private final void preloadMiniGame(String appId, MiniGamePreDownloadConfig.DownloadConfig downloadConfig) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).preDownloadPkg(appId, "release", new IMiniCallback() { // from class: com.tencent.mobileqq.minigame.gpkg.a
            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
            public final void onCallbackResult(boolean z16, Bundle bundle) {
                MiniGamePreDownload.preloadMiniGame$lambda$1(z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadMiniGame$lambda$1(boolean z16, Bundle bundle) {
        QLog.i(TAG, 1, "checkAndPreloadMiniGame preDownloadPkg succ:" + z16);
    }

    private final void setPreDownloadTime(long requestTime) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeLong(MiniGameVAMMKVKEY.MINIGAME_DOWNLOAD_APPID, requestTime);
    }

    public final void checkAndPreloadMiniGame() {
        MiniGamePreDownloadConfig miniGamePreDownloadConfig = (MiniGamePreDownloadConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGamePreDownloadConfig.CONFIG_ID);
        if (miniGamePreDownloadConfig == null || miniGamePreDownloadConfig.getPreloadMap().isEmpty()) {
            return;
        }
        long currentTimeMillis = (System.currentTimeMillis() - getPreDownloadTime()) / 60000;
        QLog.i(TAG, 1, "checkAndPreloadMiniGame arrival interval:" + currentTimeMillis + ", and should:" + miniGamePreDownloadConfig.getCheckInterval());
        if (miniGamePreDownloadConfig.getCheckInterval() <= 0 || currentTimeMillis >= miniGamePreDownloadConfig.getCheckInterval()) {
            setPreDownloadTime(System.currentTimeMillis());
            for (Map.Entry<String, MiniGamePreDownloadConfig.DownloadConfig> entry : miniGamePreDownloadConfig.getPreloadMap().entrySet()) {
                INSTANCE.preloadMiniGame(entry.getKey(), entry.getValue());
            }
        }
    }
}
