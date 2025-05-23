package com.tencent.mobileqq.zplan.minihome;

import com.google.protobuf.nano.MessageNano;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B1\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/aq;", "Lcom/google/protobuf/nano/MessageNano;", "RSP", "", "a", "Lcom/google/protobuf/nano/MessageNano;", "()Lcom/google/protobuf/nano/MessageNano;", "rsp", "", "b", "I", "()I", "ssoResultCode", "c", "d", "trpcRspFuncRetCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "trpcRspErrorMsg", "<init>", "(Lcom/google/protobuf/nano/MessageNano;IILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aq<RSP extends MessageNano> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RSP rsp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int ssoResultCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int trpcRspFuncRetCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String trpcRspErrorMsg;

    public aq(RSP rsp, int i3, int i16, String str) {
        this.rsp = rsp;
        this.ssoResultCode = i3;
        this.trpcRspFuncRetCode = i16;
        this.trpcRspErrorMsg = str;
    }

    public final RSP a() {
        return this.rsp;
    }

    /* renamed from: b, reason: from getter */
    public final int getSsoResultCode() {
        return this.ssoResultCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getTrpcRspErrorMsg() {
        return this.trpcRspErrorMsg;
    }

    /* renamed from: d, reason: from getter */
    public final int getTrpcRspFuncRetCode() {
        return this.trpcRspFuncRetCode;
    }
}
