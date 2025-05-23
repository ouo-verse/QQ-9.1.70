package com.tencent.qqmini.sdk.server.launch;

import androidx.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "", "enableProcessReuse", "", "multiInstanceCount", "", "(ZI)V", "enableMultiInstance", "getEnableMultiInstance", "()Z", "getEnableProcessReuse", "getMultiInstanceCount", "()I", "setMultiInstanceCount", "(I)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class GameLaunchConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean enableProcessReuse;
    private int multiInstanceCount;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig$Companion;", "", "()V", "enableGameProcessReuse", "", "fromWnsConfig", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        
            r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r5, new char[]{'.'}, false, 0, 6, (java.lang.Object) null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean enableGameProcessReuse() {
            boolean z16;
            List split$default;
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_PROCESS_REUSE, 1) > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            String config = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_PROCESS_REUSE_BLACKLIST, "");
            if (config == null || split$default == null || !split$default.contains(DeviceInfoUtil.getPhoneModel())) {
                return true;
            }
            return false;
        }

        @JvmStatic
        @NotNull
        public final GameLaunchConfig fromWnsConfig() {
            int coerceAtLeast;
            int i3 = 1;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_MULTI_INSTANCE, 1), 1);
            boolean enableGameProcessReuse = enableGameProcessReuse();
            if (enableGameProcessReuse) {
                i3 = coerceAtLeast;
            }
            GameLaunchConfig gameLaunchConfig = new GameLaunchConfig(enableGameProcessReuse, i3);
            QMLog.i(GameLaunchStrategy.TAG, gameLaunchConfig.toString());
            return gameLaunchConfig;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @VisibleForTesting
    public GameLaunchConfig(boolean z16, int i3) {
        this.enableProcessReuse = z16;
        this.multiInstanceCount = i3;
    }

    public static /* synthetic */ GameLaunchConfig copy$default(GameLaunchConfig gameLaunchConfig, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = gameLaunchConfig.enableProcessReuse;
        }
        if ((i16 & 2) != 0) {
            i3 = gameLaunchConfig.multiInstanceCount;
        }
        return gameLaunchConfig.copy(z16, i3);
    }

    @JvmStatic
    @NotNull
    public static final GameLaunchConfig fromWnsConfig() {
        return INSTANCE.fromWnsConfig();
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableProcessReuse() {
        return this.enableProcessReuse;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMultiInstanceCount() {
        return this.multiInstanceCount;
    }

    @NotNull
    public final GameLaunchConfig copy(boolean enableProcessReuse, int multiInstanceCount) {
        return new GameLaunchConfig(enableProcessReuse, multiInstanceCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GameLaunchConfig) {
                GameLaunchConfig gameLaunchConfig = (GameLaunchConfig) other;
                if (this.enableProcessReuse != gameLaunchConfig.enableProcessReuse || this.multiInstanceCount != gameLaunchConfig.multiInstanceCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getEnableMultiInstance() {
        if (this.multiInstanceCount > 1) {
            return true;
        }
        return false;
    }

    public final boolean getEnableProcessReuse() {
        return this.enableProcessReuse;
    }

    public final int getMultiInstanceCount() {
        return this.multiInstanceCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enableProcessReuse;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.multiInstanceCount;
    }

    public final void setMultiInstanceCount(int i3) {
        this.multiInstanceCount = i3;
    }

    @NotNull
    public String toString() {
        return "GameLaunchConfig(enableProcessReuse=" + this.enableProcessReuse + ", multiInstanceCount=" + this.multiInstanceCount + ")";
    }
}
