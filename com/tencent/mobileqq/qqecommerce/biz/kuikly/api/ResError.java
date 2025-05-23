package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "<init>", "(ILjava/lang/String;)V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.k, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class ResError {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    public ResError(int i3, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i3;
        this.message = message;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResError)) {
            return false;
        }
        ResError resError = (ResError) other;
        if (this.code == resError.code && Intrinsics.areEqual(this.message, resError.message)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResError(code=" + this.code + ", message=" + this.message + ')';
    }
}
