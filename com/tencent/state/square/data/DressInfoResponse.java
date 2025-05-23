package com.tencent.state.square.data;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/data/DressInfoResponse;", "", IZplanHandleApi.BUSINESS_DRESS_INFO, "Lcom/tencent/state/square/data/DressInfo;", "errorCode", "", "errorMsg", "", "(Lcom/tencent/state/square/data/DressInfo;Ljava/lang/Integer;Ljava/lang/String;)V", "getDressInfo", "()Lcom/tencent/state/square/data/DressInfo;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/tencent/state/square/data/DressInfo;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tencent/state/square/data/DressInfoResponse;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class DressInfoResponse {
    private final DressInfo dressInfo;
    private final Integer errorCode;
    private final String errorMsg;

    public DressInfoResponse(DressInfo dressInfo, Integer num, String str) {
        this.dressInfo = dressInfo;
        this.errorCode = num;
        this.errorMsg = str;
    }

    /* renamed from: component1, reason: from getter */
    public final DressInfo getDressInfo() {
        return this.dressInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final DressInfoResponse copy(DressInfo dressInfo, Integer errorCode, String errorMsg) {
        return new DressInfoResponse(dressInfo, errorCode, errorMsg);
    }

    public final DressInfo getDressInfo() {
        return this.dressInfo;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public int hashCode() {
        DressInfo dressInfo = this.dressInfo;
        int hashCode = (dressInfo != null ? dressInfo.hashCode() : 0) * 31;
        Integer num = this.errorCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.errorMsg;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DressInfoResponse(dressInfo=" + this.dressInfo + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressInfoResponse)) {
            return false;
        }
        DressInfoResponse dressInfoResponse = (DressInfoResponse) other;
        return Intrinsics.areEqual(this.dressInfo, dressInfoResponse.dressInfo) && Intrinsics.areEqual(this.errorCode, dressInfoResponse.errorCode) && Intrinsics.areEqual(this.errorMsg, dressInfoResponse.errorMsg);
    }

    public static /* synthetic */ DressInfoResponse copy$default(DressInfoResponse dressInfoResponse, DressInfo dressInfo, Integer num, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dressInfo = dressInfoResponse.dressInfo;
        }
        if ((i3 & 2) != 0) {
            num = dressInfoResponse.errorCode;
        }
        if ((i3 & 4) != 0) {
            str = dressInfoResponse.errorMsg;
        }
        return dressInfoResponse.copy(dressInfo, num, str);
    }
}
