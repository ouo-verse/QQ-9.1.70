package com.tencent.magicbrush.ui;

import androidx.annotation.Keep;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b'\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0019J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0 j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/magicbrush/ui/MBViewManager;", "", "Lcom/tencent/magicbrush/ui/g$c;", "l", "", "addSurfaceListenerForAllViews", "Lcom/tencent/magicbrush/ui/MBViewManager$a;", "addListener", "removeListener", "", "virtualElementId", "Lcom/tencent/magicbrush/ui/g;", "findOrNull", "find", "view", "add$lib_magicbrush_nano_release", "(Lcom/tencent/magicbrush/ui/g;)V", "add", "fromId", "(Lcom/tencent/magicbrush/ui/g;I)V", "remove$lib_magicbrush_nano_release", "remove", "clear$lib_magicbrush_nano_release", "()V", QCircleLpReportDc05507.KEY_CLEAR, "Lkotlin/Function1;", "fn", "forEach", "", "toString", "idGenerator", "I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "viewContainer", "Ljava/util/HashMap;", "Lcom/tencent/luggage/wxa/w8/c;", "listeners", "Lcom/tencent/luggage/wxa/w8/c;", "<init>", "a", "lib-magicbrush-nano_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMBViewManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MBViewManager.kt\ncom/tencent/magicbrush/ui/MBViewManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1855#2,2:104\n*S KotlinDebug\n*F\n+ 1 MBViewManager.kt\ncom/tencent/magicbrush/ui/MBViewManager\n*L\n89#1:104,2\n*E\n"})
/* loaded from: classes9.dex */
public final class MBViewManager {
    static IPatchRedirector $redirector_;
    private int idGenerator;

    @NotNull
    private final com.tencent.luggage.wxa.w8.c listeners;

    @NotNull
    private final HashMap<Integer, g> viewContainer;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {

        /* compiled from: P */
        /* renamed from: com.tencent.magicbrush.ui.MBViewManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7013a {
            public static void a(a aVar, g v3) {
                Intrinsics.checkNotNullParameter(v3, "v");
            }
        }

        void a(g gVar);

        void b(g gVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f147475a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar) {
            super(1);
            this.f147475a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        public final void a(a it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147475a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((a) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f147476a;

        public c(g.c cVar) {
            this.f147476a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public void a(g v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                v3.a(this.f147476a);
            }
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public void b(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            } else {
                a.C7013a.a(this, gVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f147477a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar) {
            super(1);
            this.f147477a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        public final void a(a it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.b(this.f147477a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((a) obj);
            return Unit.INSTANCE;
        }
    }

    public MBViewManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewContainer = new HashMap<>();
            this.listeners = new com.tencent.luggage.wxa.w8.c();
        }
    }

    public final void add$lib_magicbrush_nano_release(@NotNull g view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            add$lib_magicbrush_nano_release(view, -1);
        }
    }

    public final void addListener(@NotNull a l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.listeners.a(l3);
        }
    }

    public final void addSurfaceListenerForAllViews(@NotNull g.c l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.listeners.a(new c(l3));
        }
    }

    public final synchronized void clear$lib_magicbrush_nano_release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.viewContainer.clear();
            this.listeners.a();
        }
    }

    @NotNull
    public final synchronized g find(int virtualElementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (g) iPatchRedirector.redirect((short) 6, (Object) this, virtualElementId);
        }
        g gVar = this.viewContainer.get(Integer.valueOf(virtualElementId));
        Intrinsics.checkNotNull(gVar);
        return gVar;
    }

    @Nullable
    public final synchronized g findOrNull(int virtualElementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g) iPatchRedirector.redirect((short) 5, (Object) this, virtualElementId);
        }
        return this.viewContainer.get(Integer.valueOf(virtualElementId));
    }

    public final void forEach(@NotNull Function1<? super g, Unit> fn5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fn5);
            return;
        }
        Intrinsics.checkNotNullParameter(fn5, "fn");
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            for (g v3 : this.viewContainer.values()) {
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                arrayList.add(v3);
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fn5.invoke(it.next());
        }
    }

    public final void remove$lib_magicbrush_nano_release(@NotNull g view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (this) {
            int virtualElementId = view.getVirtualElementId();
            if (this.viewContainer.containsKey(Integer.valueOf(virtualElementId))) {
                this.viewContainer.remove(Integer.valueOf(virtualElementId));
            } else {
                String format = String.format("VirtualElementId error. current [%s] request [%d]", Arrays.copyOf(new Object[]{toString(), Integer.valueOf(virtualElementId)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                throw new IllegalStateException(format.toString());
            }
        }
        this.listeners.a((Function1) new d(view));
    }

    public final void removeListener(@NotNull a l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.listeners.b(l3);
        }
    }

    @NotNull
    public String toString() {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ViewManager(");
        sb5.append(hashCode());
        sb5.append(")");
        synchronized (this) {
            Set<Integer> keySet = this.viewContainer.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "viewContainer.keys");
            intArray = CollectionsKt___CollectionsKt.toIntArray(keySet);
            sb5.append(intArray);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    public final void add$lib_magicbrush_nano_release(@NotNull g view, int fromId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, fromId);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (this) {
            if (fromId < 0) {
                fromId = this.idGenerator;
                this.idGenerator = fromId + 1;
            }
            this.viewContainer.put(Integer.valueOf(fromId), view);
            Unit unit = Unit.INSTANCE;
        }
        view.setVirtualElementId$lib_magicbrush_nano_release(fromId);
        this.listeners.a((Function1) new b(view));
    }
}
