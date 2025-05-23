package com.tencent.filament.zplan.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/util/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "<init>", "(ILjava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.util.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class Result {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    public Result(int i3, @NotNull String message) {
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
        if (this != other) {
            if (other instanceof Result) {
                Result result = (Result) other;
                if (this.code != result.code || !Intrinsics.areEqual(this.message, result.message)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16 = this.code * 31;
        String str = this.message;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "Result(code=" + this.code + ", message=" + this.message + ")";
    }
}
