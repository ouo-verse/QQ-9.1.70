package com.tencent.mobileqq.nearbypro.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "success", "", "b", "J", "()J", "code", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "d", "Ljava/lang/Object;", "getWhat", "()Ljava/lang/Object;", "what", "<init>", "(ZJLjava/lang/String;Ljava/lang/Object;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.base.h, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NearbyNetError {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long code;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object what;

    public NearbyNetError() {
        this(false, 0L, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NearbyNetError)) {
            return false;
        }
        NearbyNetError nearbyNetError = (NearbyNetError) other;
        if (this.success == nearbyNetError.success && this.code == nearbyNetError.code && Intrinsics.areEqual(this.message, nearbyNetError.message) && Intrinsics.areEqual(this.what, nearbyNetError.what)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.code)) * 31;
        String str = this.message;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        Object obj = this.what;
        if (obj != null) {
            i3 = obj.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "NearbyNetError(success=" + this.success + ", code=" + this.code + ", message=" + this.message + ", what=" + this.what + ")";
    }

    public NearbyNetError(boolean z16, long j3, @Nullable String str, @Nullable Object obj) {
        this.success = z16;
        this.code = j3;
        this.message = str;
        this.what = obj;
    }

    public /* synthetic */ NearbyNetError(boolean z16, long j3, String str, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : obj);
    }
}
