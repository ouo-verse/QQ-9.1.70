package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;", "groupListRsp", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.logic.m, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class FetchUserGroupListResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProAVMemberGroupListRsp groupListRsp;

    public FetchUserGroupListResult(int i3, @NotNull String errMsg, @NotNull IGProAVMemberGroupListRsp groupListRsp) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(groupListRsp, "groupListRsp");
        this.result = i3;
        this.errMsg = errMsg;
        this.groupListRsp = groupListRsp;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IGProAVMemberGroupListRsp getGroupListRsp() {
        return this.groupListRsp;
    }

    /* renamed from: c, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FetchUserGroupListResult)) {
            return false;
        }
        FetchUserGroupListResult fetchUserGroupListResult = (FetchUserGroupListResult) other;
        if (this.result == fetchUserGroupListResult.result && Intrinsics.areEqual(this.errMsg, fetchUserGroupListResult.errMsg) && Intrinsics.areEqual(this.groupListRsp, fetchUserGroupListResult.groupListRsp)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.result * 31) + this.errMsg.hashCode()) * 31) + this.groupListRsp.hashCode();
    }

    @NotNull
    public String toString() {
        return "FetchUserGroupListResult(result=" + this.result + ", errMsg=" + this.errMsg + ", groupListRsp=" + this.groupListRsp + ")";
    }
}
