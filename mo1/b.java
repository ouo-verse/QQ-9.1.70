package mo1;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J(\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J'\u0010\r\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR4\u0010\u0014\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00110\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lmo1/b;", "", "T", "Ljava/lang/Class;", "eventClz", "Lmo1/d;", "listener", "", "b", "e", "event", "", "mustMainThread", "c", "(Ljava/lang/Object;Z)V", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "a", "Ljava/util/Map;", "eventMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, CopyOnWriteArrayList<WeakReference<d<?>>>> eventMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, Object event) {
        d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        CopyOnWriteArrayList<WeakReference<d<?>>> copyOnWriteArrayList = this$0.eventMap.get(event.getClass());
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Object obj = ((WeakReference) it.next()).get();
            if (obj instanceof d) {
                dVar = (d) obj;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.D0(event);
            }
        }
    }

    public final synchronized <T> void b(@NotNull Class<T> eventClz, @NotNull d<T> listener) {
        T t16;
        Intrinsics.checkNotNullParameter(eventClz, "eventClz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<Class<?>, CopyOnWriteArrayList<WeakReference<d<?>>>> map = this.eventMap;
        CopyOnWriteArrayList<WeakReference<d<?>>> copyOnWriteArrayList = map.get(eventClz);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            map.put(eventClz, copyOnWriteArrayList);
        }
        CopyOnWriteArrayList<WeakReference<d<?>>> copyOnWriteArrayList2 = copyOnWriteArrayList;
        Iterator<T> it = copyOnWriteArrayList2.iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                if (Intrinsics.areEqual(((WeakReference) t16).get(), listener)) {
                    break;
                }
            } else {
                t16 = (T) null;
                break;
            }
        }
        WeakReference weakReference = t16;
        if (weakReference != null) {
            copyOnWriteArrayList2.remove(weakReference);
        }
        copyOnWriteArrayList2.add(new WeakReference<>(listener));
    }

    public final <T> void c(@NotNull final T event, boolean mustMainThread) {
        Intrinsics.checkNotNullParameter(event, "event");
        Runnable runnable = new Runnable() { // from class: mo1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this, event);
            }
        };
        if (mustMainThread && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    public final synchronized <T> void e(@NotNull Class<T> eventClz, @NotNull d<T> listener) {
        T t16;
        Intrinsics.checkNotNullParameter(eventClz, "eventClz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<WeakReference<d<?>>> copyOnWriteArrayList = this.eventMap.get(eventClz);
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                if (Intrinsics.areEqual(((WeakReference) t16).get(), listener)) {
                    break;
                }
            } else {
                t16 = (T) null;
                break;
            }
        }
        copyOnWriteArrayList.remove(t16);
    }
}
