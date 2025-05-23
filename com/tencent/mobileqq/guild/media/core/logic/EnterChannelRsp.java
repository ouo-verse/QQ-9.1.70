package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u000e\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/k;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "msg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "igProSecurityResult", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "igProEnterAudioLiveChannelRsp", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.logic.k, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class EnterChannelRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProSecurityResult igProSecurityResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProEnterAudioLiveChannelRsp igProEnterAudioLiveChannelRsp;

    public EnterChannelRsp(int i3, @NotNull String msg2, @NotNull IGProSecurityResult igProSecurityResult, @NotNull IGProEnterAudioLiveChannelRsp igProEnterAudioLiveChannelRsp) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(igProSecurityResult, "igProSecurityResult");
        Intrinsics.checkNotNullParameter(igProEnterAudioLiveChannelRsp, "igProEnterAudioLiveChannelRsp");
        this.code = i3;
        this.msg = msg2;
        this.igProSecurityResult = igProSecurityResult;
        this.igProEnterAudioLiveChannelRsp = igProEnterAudioLiveChannelRsp;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IGProEnterAudioLiveChannelRsp getIgProEnterAudioLiveChannelRsp() {
        return this.igProEnterAudioLiveChannelRsp;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IGProSecurityResult getIgProSecurityResult() {
        return this.igProSecurityResult;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final boolean e() {
        if (this.code == 0 && ((int) this.igProSecurityResult.getActionCode()) == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterChannelRsp)) {
            return false;
        }
        EnterChannelRsp enterChannelRsp = (EnterChannelRsp) other;
        if (this.code == enterChannelRsp.code && Intrinsics.areEqual(this.msg, enterChannelRsp.msg) && Intrinsics.areEqual(this.igProSecurityResult, enterChannelRsp.igProSecurityResult) && Intrinsics.areEqual(this.igProEnterAudioLiveChannelRsp, enterChannelRsp.igProEnterAudioLiveChannelRsp)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.msg.hashCode()) * 31) + this.igProSecurityResult.hashCode()) * 31) + this.igProEnterAudioLiveChannelRsp.hashCode();
    }

    @NotNull
    public String toString() {
        return "EnterChannelRsp(code=" + this.code + ", msg=" + this.msg + ", igProSecurityResult=" + this.igProSecurityResult + ", igProEnterAudioLiveChannelRsp=" + this.igProEnterAudioLiveChannelRsp + ")";
    }
}
