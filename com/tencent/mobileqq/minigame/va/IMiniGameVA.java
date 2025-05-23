package com.tencent.mobileqq.minigame.va;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J^\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072B\b\u0002\u0010\n\u001a<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\fH&J\u001c\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&JX\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052F\u0010\n\u001aB\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0019H&JX\u0010\u001a\u001a\u00020\u00032N\u0010\n\u001aJ\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b`\u0019H&JX\u0010\u001c\u001a\u00020\u00032N\u0010\n\u001aJ\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b`\u0019H&JT\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052B\u0010\n\u001a>\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0007`\u0019H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H&Jb\u0010!\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052@\u0010\n\u001a<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011H&J;\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\fH&\u00a2\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/IMiniGameVA;", "", "cancelDownload", "", VirtualAppProxy.KEY_GAME_ID, "", "getLastUpdateVA", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "installVA", "data", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "Lcom/tencent/mobileqq/minigame/va/MiniGameGeneralCallback;", "needCheckDiff", "launchVA", "uriData", "pauseDownload", "preloadVADownload", "queryCanUpdateVA", "appId", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "queryExistDownloadList", "", "queryExistVAList", "queryVAInfo", "registerStatusListener", "listener", "Lcom/tencent/mobileqq/minigame/va/StatusListener;", "restartAndInstallVA", "versionCode", "startDownload", "needInstall", "onlyWifi", "scene", "", "autoResume", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;IZ)V", "uninstallVA", "unregisterStatusListener", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IMiniGameVA {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void installVA$default(IMiniGameVA iMiniGameVA, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, Function2 function2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function2 = null;
                }
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                iMiniGameVA.installVA(miniGameDownloadDataWrapper, function2, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: installVA");
        }

        public static /* synthetic */ void launchVA$default(IMiniGameVA iMiniGameVA, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                iMiniGameVA.launchVA(miniGameDownloadDataWrapper, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchVA");
        }

        public static /* synthetic */ void startDownload$default(IMiniGameVA iMiniGameVA, String str, Boolean bool, Boolean bool2, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    z16 = true;
                }
                iMiniGameVA.startDownload(str, bool, bool2, i3, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDownload");
        }
    }

    void cancelDownload(@NotNull String gameId);

    @Nullable
    MiniGameDownloadDataWrapper getLastUpdateVA();

    void installVA(@NotNull MiniGameDownloadDataWrapper data, @Nullable Function2<? super Boolean, ? super String, Unit> callback, boolean needCheckDiff);

    void launchVA(@NotNull MiniGameDownloadDataWrapper data, @Nullable String uriData);

    void pauseDownload(@NotNull String gameId);

    void preloadVADownload();

    void queryCanUpdateVA(@NotNull String appId, @Nullable Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback);

    void queryExistDownloadList(@NotNull Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback);

    void queryExistVAList(@NotNull Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback);

    void queryVAInfo(@NotNull String appId, @NotNull Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback);

    void registerStatusListener(@NotNull String gameId, @NotNull StatusListener listener);

    void restartAndInstallVA(@NotNull String appId, @NotNull String gameId, @NotNull String versionCode, @Nullable Function2<? super Boolean, ? super String, Unit> callback);

    void startDownload(@NotNull String gameId, @Nullable Boolean needInstall, @Nullable Boolean onlyWifi, int scene, boolean autoResume);

    void uninstallVA(@NotNull String gameId);

    void unregisterStatusListener(@NotNull String gameId, @NotNull StatusListener listener);
}
