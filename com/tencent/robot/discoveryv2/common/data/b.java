package com.tencent.robot.discoveryv2.common.data;

import com.tencent.qqnt.kernel.nativeinterface.ListRobotRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/b;", "", "", "a", "I", "b", "()I", "result", "", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "()Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "rsp", "Lcom/tencent/robot/discoveryv2/common/data/a;", "d", "Lcom/tencent/robot/discoveryv2/common/data/a;", "getFetchArgs", "()Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;Lcom/tencent/robot/discoveryv2/common/data/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ListRobotRsp rsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FirstScreenFetchArgs fetchArgs;

    public b() {
        this(0, null, null, null, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: b, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final ListRobotRsp getRsp() {
        return this.rsp;
    }

    public b(int i3, @Nullable String str, @Nullable ListRobotRsp listRobotRsp, @Nullable FirstScreenFetchArgs firstScreenFetchArgs) {
        this.result = i3;
        this.errorMsg = str;
        this.rsp = listRobotRsp;
        this.fetchArgs = firstScreenFetchArgs;
    }

    public /* synthetic */ b(int i3, String str, ListRobotRsp listRobotRsp, FirstScreenFetchArgs firstScreenFetchArgs, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : listRobotRsp, (i16 & 8) != 0 ? null : firstScreenFetchArgs);
    }
}
