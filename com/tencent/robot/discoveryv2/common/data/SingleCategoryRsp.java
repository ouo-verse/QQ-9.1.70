package com.tencent.robot.discoveryv2.common.data;

import com.tencent.qqnt.kernel.nativeinterface.ListRobotRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "rsp", "Lcom/tencent/robot/discoveryv2/common/data/f;", "Lcom/tencent/robot/discoveryv2/common/data/f;", "()Lcom/tencent/robot/discoveryv2/common/data/f;", "fetchArgs", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;Lcom/tencent/robot/discoveryv2/common/data/f;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.common.data.j, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SingleCategoryRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ListRobotRsp rsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SingleCategoryFetchArgs fetchArgs;

    public SingleCategoryRsp(int i3, @Nullable String str, @Nullable ListRobotRsp listRobotRsp, @NotNull SingleCategoryFetchArgs fetchArgs) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        this.result = i3;
        this.errorMsg = str;
        this.rsp = listRobotRsp;
        this.fetchArgs = fetchArgs;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final SingleCategoryFetchArgs getFetchArgs() {
        return this.fetchArgs;
    }

    /* renamed from: c, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ListRobotRsp getRsp() {
        return this.rsp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleCategoryRsp)) {
            return false;
        }
        SingleCategoryRsp singleCategoryRsp = (SingleCategoryRsp) other;
        if (this.result == singleCategoryRsp.result && Intrinsics.areEqual(this.errorMsg, singleCategoryRsp.errorMsg) && Intrinsics.areEqual(this.rsp, singleCategoryRsp.rsp) && Intrinsics.areEqual(this.fetchArgs, singleCategoryRsp.fetchArgs)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.result * 31;
        String str = this.errorMsg;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        ListRobotRsp listRobotRsp = this.rsp;
        if (listRobotRsp != null) {
            i16 = listRobotRsp.hashCode();
        }
        return ((i17 + i16) * 31) + this.fetchArgs.hashCode();
    }

    @NotNull
    public String toString() {
        return "SingleCategoryRsp(result=" + this.result + ", errorMsg=" + this.errorMsg + ", rsp=" + this.rsp + ", fetchArgs=" + this.fetchArgs + ")";
    }

    public /* synthetic */ SingleCategoryRsp(int i3, String str, ListRobotRsp listRobotRsp, SingleCategoryFetchArgs singleCategoryFetchArgs, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : listRobotRsp, singleCategoryFetchArgs);
    }
}
