package com.tencent.mobileqq.guild.mainframe.create;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "d", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "secRet", "guildId", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.mainframe.create.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class CreateResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProSecurityResult secRet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String guildId;

    public CreateResult(int i3, @NotNull String errMsg, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable String str) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.result = i3;
        this.errMsg = errMsg;
        this.secRet = iGProSecurityResult;
        this.guildId = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IGProSecurityResult getSecRet() {
        return this.secRet;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateResult)) {
            return false;
        }
        CreateResult createResult = (CreateResult) other;
        if (this.result == createResult.result && Intrinsics.areEqual(this.errMsg, createResult.errMsg) && Intrinsics.areEqual(this.secRet, createResult.secRet) && Intrinsics.areEqual(this.guildId, createResult.guildId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.result * 31) + this.errMsg.hashCode()) * 31;
        IGProSecurityResult iGProSecurityResult = this.secRet;
        int i3 = 0;
        if (iGProSecurityResult == null) {
            hashCode = 0;
        } else {
            hashCode = iGProSecurityResult.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str = this.guildId;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "CreateResult(result=" + this.result + ", errMsg=" + this.errMsg + ", secRet=" + this.secRet + ", guildId=" + this.guildId + ")";
    }
}
