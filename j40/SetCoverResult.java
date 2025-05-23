package j40;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lj40/e;", "", "", "c", "d", "b", "", "toString", "", "hashCode", "other", "equals", "a", "I", "getCode", "()I", "code", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "<init>", "(ILjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: j40.e, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class SetCoverResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    public SetCoverResult(int i3, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i3;
        this.message = message;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final boolean b() {
        if (this.code == 3) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        if (this.code == 1) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (this.code == 2) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetCoverResult)) {
            return false;
        }
        SetCoverResult setCoverResult = (SetCoverResult) other;
        if (this.code == setCoverResult.code && Intrinsics.areEqual(this.message, setCoverResult.message)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "SetCoverResult(code=" + this.code + ", message=" + this.message + ")";
    }

    public /* synthetic */ SetCoverResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }
}
