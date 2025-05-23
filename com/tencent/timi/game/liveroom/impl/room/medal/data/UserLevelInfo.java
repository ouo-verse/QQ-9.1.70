package com.tencent.timi.game.liveroom.impl.room.medal.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/data/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "b", "()I", "level", "Ljava/lang/String;", "()Ljava/lang/String;", "iconUrl", "<init>", "(ILjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.data.c, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class UserLevelInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int level;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    public UserLevelInfo(int i3, @NotNull String iconUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.level = i3;
        this.iconUrl = iconUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(UserLevelInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.medal.data.UserLevelInfo");
        UserLevelInfo userLevelInfo = (UserLevelInfo) other;
        if (this.level == userLevelInfo.level && Intrinsics.areEqual(this.iconUrl, userLevelInfo.iconUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.level * 31) + this.iconUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserLevelInfo(level=" + this.level + ", iconUrl=" + this.iconUrl + ")";
    }
}
