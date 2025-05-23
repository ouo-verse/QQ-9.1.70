package j23;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lj23/g;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "b", "left", "right", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String left;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String right;

    public g(@NotNull String title, @NotNull String left, @NotNull String right) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.title = title;
        this.left = left;
        this.right = right;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getLeft() {
        return this.left;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRight() {
        return this.right;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
