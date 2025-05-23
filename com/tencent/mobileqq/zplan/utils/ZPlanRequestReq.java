package com.tencent.mobileqq.zplan.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/au;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "cmd", "", "b", "[B", "()[B", "reqBytes", "<init>", "(Ljava/lang/String;[B)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.utils.au, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanRequestReq {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final byte[] reqBytes;

    public ZPlanRequestReq(String cmd, byte[] bArr) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        this.cmd = cmd;
        this.reqBytes = bArr;
    }

    /* renamed from: a, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }

    /* renamed from: b, reason: from getter */
    public final byte[] getReqBytes() {
        return this.reqBytes;
    }

    public int hashCode() {
        int hashCode = this.cmd.hashCode() * 31;
        byte[] bArr = this.reqBytes;
        return hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "ZPlanRequestReq(cmd=" + this.cmd + ", reqBytes=" + Arrays.toString(this.reqBytes) + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanRequestReq)) {
            return false;
        }
        ZPlanRequestReq zPlanRequestReq = (ZPlanRequestReq) other;
        if (!Intrinsics.areEqual(this.cmd, zPlanRequestReq.cmd)) {
            return false;
        }
        byte[] bArr = this.reqBytes;
        if (bArr != null) {
            byte[] bArr2 = zPlanRequestReq.reqBytes;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (zPlanRequestReq.reqBytes != null) {
            return false;
        }
        return true;
    }
}
