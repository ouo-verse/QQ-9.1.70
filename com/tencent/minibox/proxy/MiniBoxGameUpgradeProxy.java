package com.tencent.minibox.proxy;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.fragment.app.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H&J0\u0010\u0015\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy;", "", "clearNetChangeReceiver", "", "callback", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "getDownloadView", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView;", "hostContext", "Landroid/content/Context;", "gameActivity", "Landroid/app/Activity;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "queryAndUpdateVASilence", "appId", "", "listener", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$QueryAndUpdateVAListener;", "registerUpdateListener", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$UpdateListener;", "restartVirtualApp", "versionCode", "setNetChangeReceiver", "context", "startUpdate", "stopUpdate", "unregisterUpdateListener", "IDownloadView", "MiniBoxGameUpdateState", "QueryAndUpdateVAListener", "UpdateListener", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface MiniBoxGameUpgradeProxy {

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001\u001cJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H&J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView;", "", "getProcess", "", "getVisibility", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "resetDownloadProcess", "setGameVersionCode", "versionCode", "", "setOperateClickListener", "clickListener", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView$VATipsOperateClickListener;", "showDownloadView", "isWifi", "", VirtualAppProxy.KEY_GAME_ID, "updateDownloadProcess", "process", "downloadedSize", "", VirtualAppProxy.KEY_PKG_SIZE, "updateState", "state", "updateVisibility", "visibility", "updateWifiState", "VATipsOperateClickListener", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public interface IDownloadView {

        @Keep
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView$VATipsOperateClickListener;", "", "onCancelClick", "", "onContinueClick", "onRestartClick", "onRetryClick", "onStartDownloadClick", "onStopClick", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes9.dex */
        public interface VATipsOperateClickListener {
            void onCancelClick();

            void onContinueClick();

            void onRestartClick();

            void onRetryClick();

            void onStartDownloadClick();

            void onStopClick();
        }

        int getProcess();

        int getVisibility();

        void onDestroy();

        void resetDownloadProcess();

        void setGameVersionCode(@Nullable String versionCode);

        void setOperateClickListener(@NotNull VATipsOperateClickListener clickListener);

        void showDownloadView(boolean isWifi, @Nullable String gameId);

        void updateDownloadProcess(int process);

        void updateDownloadProcess(int process, long downloadedSize, long pkgSize);

        void updateState(int state);

        void updateVisibility(int visibility);

        void updateWifiState(boolean isWifi);
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$MiniBoxGameUpdateState;", "", VirtualAppProxy.KEY_GAME_ID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", VirtualAppProxy.KEY_PKG_SIZE, "", "downloadSize", VirtualAppProxy.KEY_GAME_VERSION_CODE, "(Ljava/lang/String;IIJJLjava/lang/String;)V", "getDownloadSize", "()J", "getDownloadStatus", "()I", "getGameId", "()Ljava/lang/String;", "getGameVersionCode", "getPkgSize", HippyQQPagView.FunctionName.GET_PROGRESS, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final /* data */ class MiniBoxGameUpdateState {
        private final long downloadSize;
        private final int downloadStatus;

        @NotNull
        private final String gameId;

        @NotNull
        private final String gameVersionCode;
        private final long pkgSize;
        private final int progress;

        public MiniBoxGameUpdateState(@NotNull String gameId, int i3, int i16, long j3, long j16, @NotNull String gameVersionCode) {
            Intrinsics.checkParameterIsNotNull(gameId, "gameId");
            Intrinsics.checkParameterIsNotNull(gameVersionCode, "gameVersionCode");
            this.gameId = gameId;
            this.downloadStatus = i3;
            this.progress = i16;
            this.pkgSize = j3;
            this.downloadSize = j16;
            this.gameVersionCode = gameVersionCode;
        }

        public static /* synthetic */ MiniBoxGameUpdateState copy$default(MiniBoxGameUpdateState miniBoxGameUpdateState, String str, int i3, int i16, long j3, long j16, String str2, int i17, Object obj) {
            String str3;
            int i18;
            int i19;
            long j17;
            long j18;
            String str4;
            if ((i17 & 1) != 0) {
                str3 = miniBoxGameUpdateState.gameId;
            } else {
                str3 = str;
            }
            if ((i17 & 2) != 0) {
                i18 = miniBoxGameUpdateState.downloadStatus;
            } else {
                i18 = i3;
            }
            if ((i17 & 4) != 0) {
                i19 = miniBoxGameUpdateState.progress;
            } else {
                i19 = i16;
            }
            if ((i17 & 8) != 0) {
                j17 = miniBoxGameUpdateState.pkgSize;
            } else {
                j17 = j3;
            }
            if ((i17 & 16) != 0) {
                j18 = miniBoxGameUpdateState.downloadSize;
            } else {
                j18 = j16;
            }
            if ((i17 & 32) != 0) {
                str4 = miniBoxGameUpdateState.gameVersionCode;
            } else {
                str4 = str2;
            }
            return miniBoxGameUpdateState.copy(str3, i18, i19, j17, j18, str4);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGameId() {
            return this.gameId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDownloadStatus() {
            return this.downloadStatus;
        }

        /* renamed from: component3, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        /* renamed from: component4, reason: from getter */
        public final long getPkgSize() {
            return this.pkgSize;
        }

        /* renamed from: component5, reason: from getter */
        public final long getDownloadSize() {
            return this.downloadSize;
        }

        @NotNull
        /* renamed from: component6, reason: from getter */
        public final String getGameVersionCode() {
            return this.gameVersionCode;
        }

        @NotNull
        public final MiniBoxGameUpdateState copy(@NotNull String gameId, int downloadStatus, int progress, long pkgSize, long downloadSize, @NotNull String gameVersionCode) {
            Intrinsics.checkParameterIsNotNull(gameId, "gameId");
            Intrinsics.checkParameterIsNotNull(gameVersionCode, "gameVersionCode");
            return new MiniBoxGameUpdateState(gameId, downloadStatus, progress, pkgSize, downloadSize, gameVersionCode);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof MiniBoxGameUpdateState) {
                    MiniBoxGameUpdateState miniBoxGameUpdateState = (MiniBoxGameUpdateState) other;
                    if (!Intrinsics.areEqual(this.gameId, miniBoxGameUpdateState.gameId) || this.downloadStatus != miniBoxGameUpdateState.downloadStatus || this.progress != miniBoxGameUpdateState.progress || this.pkgSize != miniBoxGameUpdateState.pkgSize || this.downloadSize != miniBoxGameUpdateState.downloadSize || !Intrinsics.areEqual(this.gameVersionCode, miniBoxGameUpdateState.gameVersionCode)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final long getDownloadSize() {
            return this.downloadSize;
        }

        public final int getDownloadStatus() {
            return this.downloadStatus;
        }

        @NotNull
        public final String getGameId() {
            return this.gameId;
        }

        @NotNull
        public final String getGameVersionCode() {
            return this.gameVersionCode;
        }

        public final long getPkgSize() {
            return this.pkgSize;
        }

        public final int getProgress() {
            return this.progress;
        }

        public int hashCode() {
            int i3;
            String str = this.gameId;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((((((((i3 * 31) + this.downloadStatus) * 31) + this.progress) * 31) + a.a(this.pkgSize)) * 31) + a.a(this.downloadSize)) * 31;
            String str2 = this.gameVersionCode;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return a16 + i16;
        }

        @NotNull
        public String toString() {
            return "MiniBoxGameUpdateState(gameId=" + this.gameId + ", downloadStatus=" + this.downloadStatus + ", progress=" + this.progress + ", pkgSize=" + this.pkgSize + ", downloadSize=" + this.downloadSize + ", gameVersionCode=" + this.gameVersionCode + ")";
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$QueryAndUpdateVAListener;", "", "notingToUpdate", "", "onSilenceUpdate", VirtualAppProxy.KEY_GAME_ID, "", VirtualAppProxy.KEY_AUTO_DOWNLOAD, "", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public interface QueryAndUpdateVAListener {
        void notingToUpdate();

        void onSilenceUpdate(@Nullable String gameId, boolean autoDownload);
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$UpdateListener;", "", "onStatusChanged", "", "data", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$MiniBoxGameUpdateState;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public interface UpdateListener {
        void onStatusChanged(@Nullable MiniBoxGameUpdateState data);
    }

    void clearNetChangeReceiver(@NotNull HostNotifySimpleBooleanCallback callback);

    @Nullable
    IDownloadView getDownloadView(@NotNull Context hostContext, @Nullable Activity gameActivity);

    void onDestroy();

    void queryAndUpdateVASilence(@Nullable String appId, @Nullable QueryAndUpdateVAListener listener);

    void registerUpdateListener(@Nullable String gameId, @Nullable UpdateListener listener);

    void restartVirtualApp(@Nullable String appId, @Nullable String gameId, @Nullable String versionCode, @Nullable HostNotifySimpleBooleanCallback callback);

    void setNetChangeReceiver(@Nullable Context context, @NotNull HostNotifySimpleBooleanCallback callback);

    void startUpdate(@Nullable String gameId);

    void stopUpdate(@Nullable String gameId);

    void unregisterUpdateListener(@Nullable String gameId);
}
