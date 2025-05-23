package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errorCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMessage", "<init>", "(ILjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ErrorMessage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errorMessage;

    public ErrorMessage(int i3, String str) {
        this.errorCode = i3;
        this.errorMessage = str;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        int i3 = this.errorCode * 31;
        String str = this.errorMessage;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ErrorMessage(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorMessage)) {
            return false;
        }
        ErrorMessage errorMessage = (ErrorMessage) other;
        return this.errorCode == errorMessage.errorCode && Intrinsics.areEqual(this.errorMessage, errorMessage.errorMessage);
    }
}
