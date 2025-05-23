package ef1;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lef1/a;", "T", "", "source", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "Ljava/lang/Object;", "content", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "handled", "<init>", "(Ljava/lang/Object;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, Boolean> handled = new ConcurrentHashMap<>();

    public a(T t16) {
        this.content = t16;
    }

    public final T a() {
        return this.content;
    }

    @Nullable
    public final T b(@Nullable Object source) {
        int i3;
        if (source != null) {
            i3 = source.hashCode();
        } else {
            i3 = 0;
        }
        Boolean bool = this.handled.get(Integer.valueOf(i3));
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return null;
        }
        this.handled.put(Integer.valueOf(i3), bool2);
        return this.content;
    }
}
