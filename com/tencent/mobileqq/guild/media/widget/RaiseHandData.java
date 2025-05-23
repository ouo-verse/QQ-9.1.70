package com.tencent.mobileqq.guild.media.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/be;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tinyId", "b", "nickName", "c", "I", "()I", "state", "avatarMeta", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.widget.be, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RaiseHandData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    public RaiseHandData(@NotNull String tinyId, @NotNull String nickName, int i3, @NotNull String avatarMeta) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.state = i3;
        this.avatarMeta = avatarMeta;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarMeta() {
        return this.avatarMeta;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: c, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RaiseHandData)) {
            return false;
        }
        RaiseHandData raiseHandData = (RaiseHandData) other;
        if (Intrinsics.areEqual(this.tinyId, raiseHandData.tinyId) && Intrinsics.areEqual(this.nickName, raiseHandData.nickName) && this.state == raiseHandData.state && Intrinsics.areEqual(this.avatarMeta, raiseHandData.avatarMeta)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.tinyId.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.state) * 31) + this.avatarMeta.hashCode();
    }

    @NotNull
    public String toString() {
        return "RaiseHandData(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", state=" + this.state + ", avatarMeta=" + this.avatarMeta + ")";
    }
}
