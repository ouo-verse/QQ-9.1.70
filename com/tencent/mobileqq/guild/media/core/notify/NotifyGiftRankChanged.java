package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/af;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tinyId", "a", "nickName", "", "f", "J", "()J", "roleColor", tl.h.F, "c", "rankType", "i", "I", "b", "()I", "rankNum", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.notify.af, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class NotifyGiftRankChanged implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roleColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String rankType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rankNum;

    public NotifyGiftRankChanged() {
        this(null, null, 0L, null, 0, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: b, reason: from getter */
    public final int getRankNum() {
        return this.rankNum;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRankType() {
        return this.rankType;
    }

    /* renamed from: d, reason: from getter */
    public final long getRoleColor() {
        return this.roleColor;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyGiftRankChanged)) {
            return false;
        }
        NotifyGiftRankChanged notifyGiftRankChanged = (NotifyGiftRankChanged) other;
        if (Intrinsics.areEqual(this.tinyId, notifyGiftRankChanged.tinyId) && Intrinsics.areEqual(this.nickName, notifyGiftRankChanged.nickName) && this.roleColor == notifyGiftRankChanged.roleColor && Intrinsics.areEqual(this.rankType, notifyGiftRankChanged.rankType) && this.rankNum == notifyGiftRankChanged.rankNum) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.tinyId.hashCode() * 31) + this.nickName.hashCode()) * 31) + androidx.fragment.app.a.a(this.roleColor)) * 31) + this.rankType.hashCode()) * 31) + this.rankNum;
    }

    @NotNull
    public String toString() {
        return "NotifyGiftRankChanged(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", roleColor=" + this.roleColor + ", rankType=" + this.rankType + ", rankNum=" + this.rankNum + ")";
    }

    public NotifyGiftRankChanged(@NotNull String tinyId, @NotNull String nickName, long j3, @NotNull String rankType, int i3) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(rankType, "rankType");
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.roleColor = j3;
        this.rankType = rankType;
        this.rankNum = i3;
    }

    public /* synthetic */ NotifyGiftRankChanged(String str, String str2, long j3, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) == 0 ? str3 : "", (i16 & 16) != 0 ? -1 : i3);
    }
}
