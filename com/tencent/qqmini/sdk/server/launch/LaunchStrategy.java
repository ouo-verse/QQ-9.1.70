package com.tencent.qqmini.sdk.server.launch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy;", "", "killAllProcess", "", "killMiniAppProcess", "", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "onAppBackground", "processName", "", "appConfig", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "bundle", "Landroid/os/Bundle;", "onAppForeground", "onAppStart", GameInfoManager.GAME_STOP, "onPreloaded", "onReceiveProcessRunningAppInfos", "runningApps", "", "preloadProcess", "registerProcessMessenger", "messenger", "Landroid/os/Messenger;", "sendMessageToMiniProcess", "message", "Landroid/os/Message;", "startMiniApp", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "LaunchData", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface LaunchStrategy {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "", "intent", "Landroid/content/Intent;", "processState", "Lcom/tencent/qqmini/sdk/server/launch/ProcessState;", "(Landroid/content/Intent;Lcom/tencent/qqmini/sdk/server/launch/ProcessState;)V", "getIntent", "()Landroid/content/Intent;", "getProcessState", "()Lcom/tencent/qqmini/sdk/server/launch/ProcessState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final /* data */ class LaunchData {

        @NotNull
        private final Intent intent;

        @NotNull
        private final ProcessState processState;

        public LaunchData(@NotNull Intent intent, @NotNull ProcessState processState) {
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            Intrinsics.checkParameterIsNotNull(processState, "processState");
            this.intent = intent;
            this.processState = processState;
        }

        public static /* synthetic */ LaunchData copy$default(LaunchData launchData, Intent intent, ProcessState processState, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                intent = launchData.intent;
            }
            if ((i3 & 2) != 0) {
                processState = launchData.processState;
            }
            return launchData.copy(intent, processState);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Intent getIntent() {
            return this.intent;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ProcessState getProcessState() {
            return this.processState;
        }

        @NotNull
        public final LaunchData copy(@NotNull Intent intent, @NotNull ProcessState processState) {
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            Intrinsics.checkParameterIsNotNull(processState, "processState");
            return new LaunchData(intent, processState);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof LaunchData) {
                    LaunchData launchData = (LaunchData) other;
                    if (!Intrinsics.areEqual(this.intent, launchData.intent) || !Intrinsics.areEqual(this.processState, launchData.processState)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final Intent getIntent() {
            return this.intent;
        }

        @NotNull
        public final ProcessState getProcessState() {
            return this.processState;
        }

        public int hashCode() {
            int i3;
            Intent intent = this.intent;
            int i16 = 0;
            if (intent != null) {
                i3 = intent.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            ProcessState processState = this.processState;
            if (processState != null) {
                i16 = processState.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "LaunchData(intent=" + this.intent + ", processState=" + this.processState + ")";
        }
    }

    void killAllProcess();

    boolean killMiniAppProcess(@NotNull MiniAppInfo miniAppInfo);

    void onAppBackground(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle);

    void onAppForeground(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle);

    void onAppStart(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @NotNull Bundle bundle);

    void onAppStop(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle);

    void onPreloaded(@NotNull String processName, @NotNull Bundle bundle);

    void onReceiveProcessRunningAppInfos(@NotNull String processName, @NotNull List<? extends MiniAppInfo> runningApps);

    boolean preloadProcess(@Nullable Bundle bundle);

    void registerProcessMessenger(@NotNull String processName, @NotNull Messenger messenger);

    void sendMessageToMiniProcess(@NotNull MiniAppInfo miniAppInfo, @NotNull Message message) throws RemoteException;

    @NotNull
    LaunchData startMiniApp(@NotNull MiniAppInfo appConfig) throws IllegalStateException;
}
