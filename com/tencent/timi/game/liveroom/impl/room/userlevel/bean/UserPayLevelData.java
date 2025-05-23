package com.tencent.timi.game.liveroom.impl.room.userlevel.bean;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0019\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0018\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "", "", "f", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "uid", "", "b", "J", "()J", "curPayGoldCount", "c", "curPayLevel", "d", "curPayLevelIcon", "e", "nextLevelGoldDiff", "privilegeJumpUrl", "<init>", "(Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.userlevel.bean.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class UserPayLevelData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long curPayGoldCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long curPayLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String curPayLevelIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long nextLevelGoldDiff;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String privilegeJumpUrl;

    public UserPayLevelData(@NotNull String uid, long j3, long j16, @NotNull String curPayLevelIcon, long j17, @NotNull String privilegeJumpUrl) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(curPayLevelIcon, "curPayLevelIcon");
        Intrinsics.checkNotNullParameter(privilegeJumpUrl, "privilegeJumpUrl");
        this.uid = uid;
        this.curPayGoldCount = j3;
        this.curPayLevel = j16;
        this.curPayLevelIcon = curPayLevelIcon;
        this.nextLevelGoldDiff = j17;
        this.privilegeJumpUrl = privilegeJumpUrl;
    }

    /* renamed from: a, reason: from getter */
    public final long getCurPayGoldCount() {
        return this.curPayGoldCount;
    }

    /* renamed from: b, reason: from getter */
    public final long getCurPayLevel() {
        return this.curPayLevel;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCurPayLevelIcon() {
        return this.curPayLevelIcon;
    }

    /* renamed from: d, reason: from getter */
    public final long getNextLevelGoldDiff() {
        return this.nextLevelGoldDiff;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPrivilegeJumpUrl() {
        return this.privilegeJumpUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPayLevelData)) {
            return false;
        }
        UserPayLevelData userPayLevelData = (UserPayLevelData) other;
        if (Intrinsics.areEqual(this.uid, userPayLevelData.uid) && this.curPayGoldCount == userPayLevelData.curPayGoldCount && this.curPayLevel == userPayLevelData.curPayLevel && Intrinsics.areEqual(this.curPayLevelIcon, userPayLevelData.curPayLevelIcon) && this.nextLevelGoldDiff == userPayLevelData.nextLevelGoldDiff && Intrinsics.areEqual(this.privilegeJumpUrl, userPayLevelData.privilegeJumpUrl)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.curPayLevel >= 0 && !TextUtils.isEmpty(this.privilegeJumpUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.uid.hashCode() * 31) + androidx.fragment.app.a.a(this.curPayGoldCount)) * 31) + androidx.fragment.app.a.a(this.curPayLevel)) * 31) + this.curPayLevelIcon.hashCode()) * 31) + androidx.fragment.app.a.a(this.nextLevelGoldDiff)) * 31) + this.privilegeJumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserPayLevelData(uid=" + this.uid + ", curPayGoldCount=" + this.curPayGoldCount + ", curPayLevel=" + this.curPayLevel + ", curPayLevelIcon=" + this.curPayLevelIcon + ", nextLevelGoldDiff=" + this.nextLevelGoldDiff + ", privilegeJumpUrl=" + this.privilegeJumpUrl + ")";
    }
}
