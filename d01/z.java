package d01;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Ld01/z;", "", "", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "text", "<init>", "(Ljava/lang/CharSequence;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence text;

    public z(@NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }
}
