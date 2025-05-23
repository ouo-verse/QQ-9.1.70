package com.tencent.mobileqq.aio.input.sendmsg.robot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/input/sendmsg/robot/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "data", "b", "Z", "()Z", "isDisposable", "<init>", "(Ljava/lang/String;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.aio.input.sendmsg.robot.a, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class ExtData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDisposable;

    public ExtData(@NotNull String data, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isDisposable = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDisposable() {
        return this.isDisposable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtData)) {
            return false;
        }
        ExtData extData = (ExtData) other;
        if (Intrinsics.areEqual(this.data, extData.data) && this.isDisposable == extData.isDisposable) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.data.hashCode() * 31;
        boolean z16 = this.isDisposable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ExtData(data=" + this.data + ", isDisposable=" + this.isDisposable + ")";
    }
}
