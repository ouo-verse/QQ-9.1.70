package kh1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lkh1/a;", "", "", "d", "c", "", "toString", "", "hashCode", "other", "equals", "a", "I", "()I", "setCode", "(I)V", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String msg;

    public a(int i3, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.code = i3;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final boolean c() {
        if (this.code != 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.code == aVar.code && Intrinsics.areEqual(this.msg, aVar.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "code=" + this.code + " msg=" + this.msg;
    }
}
