package com.tencent.state.square.avatar;

import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquarePlayerPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/avatar/AvatarAnimConfig;", "", "isPlayerRecycleEnabled", "", "playerPool", "Lcom/tencent/state/square/media/SquarePlayerPool;", "playConfig", "Lcom/tencent/state/square/media/PlayConfig;", "autoShowStaticWhenError", "(ZLcom/tencent/state/square/media/SquarePlayerPool;Lcom/tencent/state/square/media/PlayConfig;Z)V", "getAutoShowStaticWhenError", "()Z", "setAutoShowStaticWhenError", "(Z)V", "getPlayConfig", "()Lcom/tencent/state/square/media/PlayConfig;", "getPlayerPool", "()Lcom/tencent/state/square/media/SquarePlayerPool;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class AvatarAnimConfig {
    private boolean autoShowStaticWhenError;
    private final boolean isPlayerRecycleEnabled;
    private final PlayConfig playConfig;
    private final SquarePlayerPool playerPool;

    public AvatarAnimConfig() {
        this(false, null, null, false, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsPlayerRecycleEnabled() {
        return this.isPlayerRecycleEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final SquarePlayerPool getPlayerPool() {
        return this.playerPool;
    }

    /* renamed from: component3, reason: from getter */
    public final PlayConfig getPlayConfig() {
        return this.playConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAutoShowStaticWhenError() {
        return this.autoShowStaticWhenError;
    }

    public final AvatarAnimConfig copy(boolean isPlayerRecycleEnabled, SquarePlayerPool playerPool, PlayConfig playConfig, boolean autoShowStaticWhenError) {
        Intrinsics.checkNotNullParameter(playConfig, "playConfig");
        return new AvatarAnimConfig(isPlayerRecycleEnabled, playerPool, playConfig, autoShowStaticWhenError);
    }

    public final boolean getAutoShowStaticWhenError() {
        return this.autoShowStaticWhenError;
    }

    public final PlayConfig getPlayConfig() {
        return this.playConfig;
    }

    public final SquarePlayerPool getPlayerPool() {
        return this.playerPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isPlayerRecycleEnabled;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        SquarePlayerPool squarePlayerPool = this.playerPool;
        int hashCode = (i3 + (squarePlayerPool != null ? squarePlayerPool.hashCode() : 0)) * 31;
        PlayConfig playConfig = this.playConfig;
        int hashCode2 = (hashCode + (playConfig != null ? playConfig.hashCode() : 0)) * 31;
        boolean z17 = this.autoShowStaticWhenError;
        return hashCode2 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isPlayerRecycleEnabled() {
        return this.isPlayerRecycleEnabled;
    }

    public final void setAutoShowStaticWhenError(boolean z16) {
        this.autoShowStaticWhenError = z16;
    }

    public String toString() {
        return "AvatarAnimConfig(isPlayerRecycleEnabled=" + this.isPlayerRecycleEnabled + ", playerPool=" + this.playerPool + ", playConfig=" + this.playConfig + ", autoShowStaticWhenError=" + this.autoShowStaticWhenError + ")";
    }

    public AvatarAnimConfig(boolean z16, SquarePlayerPool squarePlayerPool, PlayConfig playConfig, boolean z17) {
        Intrinsics.checkNotNullParameter(playConfig, "playConfig");
        this.isPlayerRecycleEnabled = z16;
        this.playerPool = squarePlayerPool;
        this.playConfig = playConfig;
        this.autoShowStaticWhenError = z17;
    }

    public /* synthetic */ AvatarAnimConfig(boolean z16, SquarePlayerPool squarePlayerPool, PlayConfig playConfig, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? null : squarePlayerPool, (i3 & 4) != 0 ? new PlayConfig(0, false, null, 7, null) : playConfig, (i3 & 8) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarAnimConfig)) {
            return false;
        }
        AvatarAnimConfig avatarAnimConfig = (AvatarAnimConfig) other;
        return this.isPlayerRecycleEnabled == avatarAnimConfig.isPlayerRecycleEnabled && Intrinsics.areEqual(this.playerPool, avatarAnimConfig.playerPool) && Intrinsics.areEqual(this.playConfig, avatarAnimConfig.playConfig) && this.autoShowStaticWhenError == avatarAnimConfig.autoShowStaticWhenError;
    }

    public static /* synthetic */ AvatarAnimConfig copy$default(AvatarAnimConfig avatarAnimConfig, boolean z16, SquarePlayerPool squarePlayerPool, PlayConfig playConfig, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = avatarAnimConfig.isPlayerRecycleEnabled;
        }
        if ((i3 & 2) != 0) {
            squarePlayerPool = avatarAnimConfig.playerPool;
        }
        if ((i3 & 4) != 0) {
            playConfig = avatarAnimConfig.playConfig;
        }
        if ((i3 & 8) != 0) {
            z17 = avatarAnimConfig.autoShowStaticWhenError;
        }
        return avatarAnimConfig.copy(z16, squarePlayerPool, playConfig, z17);
    }
}
