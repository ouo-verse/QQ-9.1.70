package com.tencent.state.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/api/SquareErrorData;", "", "errCode", "", "errMsg", "", "prompt", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrMsg", "()Ljava/lang/String;", "getPrompt", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/state/api/SquareErrorData;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SquareErrorData {
    private final Integer errCode;
    private final String errMsg;
    private final String prompt;

    public SquareErrorData(Integer num, String str, String str2) {
        this.errCode = num;
        this.errMsg = str;
        this.prompt = str2;
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getErrCode() {
        return this.errCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public final SquareErrorData copy(Integer errCode, String errMsg, String prompt) {
        return new SquareErrorData(errCode, errMsg, prompt);
    }

    public final Integer getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public int hashCode() {
        Integer num = this.errCode;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.errMsg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.prompt;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SquareErrorData(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", prompt=" + this.prompt + ")";
    }

    public /* synthetic */ SquareErrorData(Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareErrorData)) {
            return false;
        }
        SquareErrorData squareErrorData = (SquareErrorData) other;
        return Intrinsics.areEqual(this.errCode, squareErrorData.errCode) && Intrinsics.areEqual(this.errMsg, squareErrorData.errMsg) && Intrinsics.areEqual(this.prompt, squareErrorData.prompt);
    }

    public static /* synthetic */ SquareErrorData copy$default(SquareErrorData squareErrorData, Integer num, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = squareErrorData.errCode;
        }
        if ((i3 & 2) != 0) {
            str = squareErrorData.errMsg;
        }
        if ((i3 & 4) != 0) {
            str2 = squareErrorData.prompt;
        }
        return squareErrorData.copy(num, str, str2);
    }
}
