package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&J \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J<\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J$\u0010\u001c\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\bH&J\b\u0010\u001e\u001a\u00020\bH&J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\bH&J\b\u0010!\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\bH&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\bH&J\b\u0010)\u001a\u00020\u0003H&J\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020/H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\bH&\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVAManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "calculateMiniGameSpaceOccupy", "", "checkUpdateVAPlugin", "appId", "", "needPreload", "", "checkWifiAutoDownloadOrUpdate", "checkYunGameReady", "forceUpdate", "dailyReportVA", "getLoadingBgUrl", "Lkotlin/Pair;", "handleCrashInterceptUpdate", "initHardwareConfig", DownloadInfo.spKey_Config, "", "interceptLaunch", "context", "Landroid/content/Context;", "firstPage", "scene", "", "via", "callback", "Lcom/tencent/mobileqq/minigame/api/MiniGameVAInterceptCallback;", "isCrashProtectBlock", "needCheckLastedDex", "isInterceptDisable", "isModelLimitValid", "checkStorage", "isSupportVA", "onProcessStateChange", "isForeground", "registerMiniGameSpaceOccupyListener", "listener", "Lcom/tencent/mobileqq/minigame/api/MiniGameSpaceOccupyListener;", "setInterceptDisable", "disable", "setLebaGuideBubbleShown", "startMiniAIO", "action", "params", "Landroid/os/Bundle;", "startMiniGameDownloadManagerActivity", "Landroid/app/Activity;", "unRegisterMiniGameSpaceOccupyListener", "updateCrashProtect", "crashIntercept", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVAManager extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void checkYunGameReady$default(IMiniGameVAManager iMiniGameVAManager, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                iMiniGameVAManager.checkYunGameReady(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkYunGameReady");
        }

        public static /* synthetic */ boolean isModelLimitValid$default(IMiniGameVAManager iMiniGameVAManager, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iMiniGameVAManager.isModelLimitValid(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isModelLimitValid");
        }
    }

    void calculateMiniGameSpaceOccupy();

    void checkUpdateVAPlugin(@NotNull String appId, boolean needPreload);

    void checkWifiAutoDownloadOrUpdate();

    void checkYunGameReady(boolean forceUpdate);

    void dailyReportVA();

    @Nullable
    Pair<String, String> getLoadingBgUrl(@Nullable String appId);

    void handleCrashInterceptUpdate();

    void initHardwareConfig();

    void initHardwareConfig(@Nullable Object config);

    void interceptLaunch(@NotNull Context context, @NotNull String appId, @Nullable String firstPage, int scene, @Nullable String via, @NotNull MiniGameVAInterceptCallback callback);

    boolean isCrashProtectBlock(@Nullable Context context, @Nullable String appId, boolean needCheckLastedDex);

    boolean isInterceptDisable();

    boolean isModelLimitValid(@NotNull String appId, boolean checkStorage);

    boolean isSupportVA();

    void onProcessStateChange(boolean isForeground);

    void registerMiniGameSpaceOccupyListener(@NotNull MiniGameSpaceOccupyListener listener);

    void setInterceptDisable(boolean disable);

    void setLebaGuideBubbleShown();

    boolean startMiniAIO(@NotNull String action, @NotNull Bundle params);

    void startMiniGameDownloadManagerActivity(@NotNull Activity context);

    void unRegisterMiniGameSpaceOccupyListener(@NotNull MiniGameSpaceOccupyListener listener);

    void updateCrashProtect(boolean crashIntercept);
}
