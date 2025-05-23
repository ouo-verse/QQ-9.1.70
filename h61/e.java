package h61;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lh61/e;", "", "Lh61/a;", "listener", "", "e", "g", "Lh61/b;", "onBackEvent", "f", h.F, "", "d", "c", "b", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onBackEventListeners", "listeners", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f404453a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<b> onBackEventListeners = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<a> listeners = new CopyOnWriteArrayList<>();

    e() {
    }

    public final void a() {
        listeners.clear();
        onBackEventListeners.clear();
    }

    public final void b() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m();
        }
    }

    public final void c() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).k();
        }
    }

    public final boolean d() {
        Iterator<T> it = onBackEventListeners.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    public final void e(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = listeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void f(@NotNull b onBackEvent) {
        Intrinsics.checkNotNullParameter(onBackEvent, "onBackEvent");
        CopyOnWriteArrayList<b> copyOnWriteArrayList = onBackEventListeners;
        if (copyOnWriteArrayList.contains(onBackEvent)) {
            return;
        }
        copyOnWriteArrayList.add(onBackEvent);
    }

    public final void g(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void h(@NotNull b onBackEvent) {
        Intrinsics.checkNotNullParameter(onBackEvent, "onBackEvent");
        onBackEventListeners.remove(onBackEvent);
    }
}
