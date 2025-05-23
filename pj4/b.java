package pj4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u000f\fB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0004R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lpj4/b;", "", "Lpj4/b$b;", "listener", "", "c", "e", "", "roomId", "", "status", "f", "b", "d", "", "a", "Ljava/util/Map;", "equipStatusMap", "", "Ljava/util/Set;", "statusListenerSet", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final b f426353d = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> equipStatusMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<InterfaceC11024b> statusListenerSet = new LinkedHashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lpj4/b$a;", "", "Lpj4/b;", "stance", "Lpj4/b;", "a", "()Lpj4/b;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pj4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f426353d;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lpj4/b$b;", "", "", "roomId", "", "status", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pj4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC11024b {
        void a(long roomId, @NotNull String status);
    }

    @NotNull
    public final String b(long roomId) {
        String str = this.equipStatusMap.get(Long.valueOf(roomId));
        if (str == null) {
            return "0";
        }
        return str;
    }

    public final void c(@NotNull InterfaceC11024b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.statusListenerSet.add(listener);
    }

    public final void d() {
        this.equipStatusMap.clear();
        this.statusListenerSet.clear();
    }

    public final void e(@NotNull InterfaceC11024b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.statusListenerSet.remove(listener);
    }

    public final void f(long roomId, @NotNull String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        boolean z16 = !Intrinsics.areEqual(status, this.equipStatusMap.get(Long.valueOf(roomId)));
        this.equipStatusMap.put(Long.valueOf(roomId), status);
        if (z16) {
            Iterator<T> it = this.statusListenerSet.iterator();
            while (it.hasNext()) {
                ((InterfaceC11024b) it.next()).a(roomId, status);
            }
        }
    }
}
