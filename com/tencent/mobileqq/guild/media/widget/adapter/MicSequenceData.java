package com.tencent.mobileqq.guild.media.widget.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/adapter/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tinyId", "b", "c", "nickName", "I", "d", "()I", "seq", "getState", "state", "avatarMeta", "f", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.widget.adapter.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MicSequenceData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int seq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gender;

    public MicSequenceData(@NotNull String tinyId, @NotNull String nickName, int i3, int i16, @NotNull String avatarMeta, int i17) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.seq = i3;
        this.state = i16;
        this.avatarMeta = avatarMeta;
        this.gender = i17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarMeta() {
        return this.avatarMeta;
    }

    /* renamed from: b, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: d, reason: from getter */
    public final int getSeq() {
        return this.seq;
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
        if (!(other instanceof MicSequenceData)) {
            return false;
        }
        MicSequenceData micSequenceData = (MicSequenceData) other;
        if (Intrinsics.areEqual(this.tinyId, micSequenceData.tinyId) && Intrinsics.areEqual(this.nickName, micSequenceData.nickName) && this.seq == micSequenceData.seq && this.state == micSequenceData.state && Intrinsics.areEqual(this.avatarMeta, micSequenceData.avatarMeta) && this.gender == micSequenceData.gender) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.tinyId.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.seq) * 31) + this.state) * 31) + this.avatarMeta.hashCode()) * 31) + this.gender;
    }

    @NotNull
    public String toString() {
        return "MicSequenceData(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", seq=" + this.seq + ", state=" + this.state + ", avatarMeta=" + this.avatarMeta + ", gender=" + this.gender + ")";
    }
}
