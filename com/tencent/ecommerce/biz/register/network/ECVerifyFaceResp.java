package com.tencent.ecommerce.biz.register.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isResultSuccess", "b", "I", "verifyRspCode", "c", "Ljava/lang/String;", "sessionId", "<init>", "(ZILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.register.network.k, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECVerifyFaceResp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isResultSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int verifyRspCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sessionId;

    public ECVerifyFaceResp(boolean z16, int i3, String str) {
        this.isResultSuccess = z16;
        this.verifyRspCode = i3;
        this.sessionId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isResultSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.verifyRspCode) * 31;
        String str = this.sessionId;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECVerifyFaceResp(isResultSuccess=" + this.isResultSuccess + ", verifyRspCode=" + this.verifyRspCode + ", sessionId=" + this.sessionId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECVerifyFaceResp)) {
            return false;
        }
        ECVerifyFaceResp eCVerifyFaceResp = (ECVerifyFaceResp) other;
        return this.isResultSuccess == eCVerifyFaceResp.isResultSuccess && this.verifyRspCode == eCVerifyFaceResp.verifyRspCode && Intrinsics.areEqual(this.sessionId, eCVerifyFaceResp.sessionId);
    }
}
