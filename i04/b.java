package i04;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Li04/b;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "T", "", "", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "listener", "", "a", "(Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;)V", "e", "b", "()Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "Ljava/util/ArrayList;", "listenerList", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b<T extends IBaseListener> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<T> listenerList = new ArrayList<>();

    public final void a(@NotNull T listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        try {
            if (!this.listenerList.contains(listener)) {
                this.listenerList.add(listener);
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final T b() {
        Object last;
        if (!this.listenerList.isEmpty()) {
            try {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.listenerList);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (T) last;
    }

    @NotNull
    public final ArrayList<T> c() {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            arrayList.addAll(this.listenerList);
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public final boolean d() {
        return this.listenerList.isEmpty();
    }

    public final void e(@NotNull T listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        try {
            this.listenerList.remove(listener);
        } catch (Throwable unused) {
        }
    }
}
