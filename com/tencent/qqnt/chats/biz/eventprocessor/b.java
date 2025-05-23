package com.tencent.qqnt.chats.biz.eventprocessor;

import com.tencent.biz.pubaccount.recentcontact.d;
import com.tencent.biz.pubaccount.recentcontact.n;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountExpoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.base.publicaccount.ECPublicAccountExpoHandler;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.bizEvent.a;
import com.tencent.qqnt.chats.core.bizEvent.e;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import od1.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0002\n\fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/biz/eventprocessor/b;", "Lcom/tencent/qqnt/chats/core/bizEvent/e;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "d", "c", "e", "Lcom/tencent/qqnt/chats/core/bizEvent/a;", "a", "event", "b", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "Ljava/util/List;", "handlerList", "", "", "Ljava/util/Set;", "exposedSet", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ExpoEventProcessor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<InterfaceC9565b>> f354250d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<InterfaceC9565b> handlerList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Long> exposedSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/eventprocessor/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.eventprocessor.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "a", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.eventprocessor.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9565b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.chats.biz.eventprocessor.b$b$a */
        /* loaded from: classes24.dex */
        public static final class a {
            public static void a(@NotNull InterfaceC9565b interfaceC9565b, @NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
                Intrinsics.checkNotNullParameter(items, "items");
            }

            public static void b(@NotNull InterfaceC9565b interfaceC9565b, @NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
                Intrinsics.checkNotNullParameter(items, "items");
            }
        }

        void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items);

        void b(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<InterfaceC9565b>> arrayList = new ArrayList<>();
        f354250d = arrayList;
        arrayList.add(QCirclePublicAccountExpoHandler.class);
        arrayList.add(ECPublicAccountExpoHandler.class);
        arrayList.add(d.class);
        arrayList.add(n.class);
        arrayList.add(be1.b.class);
        arrayList.add(com.tencent.mobileqq.qqgamepub.nt.report.b.class);
        arrayList.add(od1.b.class);
        arrayList.add(c.class);
        arrayList.add(com.tencent.mobileqq.reminder.nt.report.d.class);
        arrayList.add(l43.a.class);
        arrayList.add(com.tencent.mobileqq.weather.chat.a.class);
        arrayList.add(com.tencent.mobileqq.qqshop.api.c.class);
    }

    public b() {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<InterfaceC9565b>> arrayList = f354250d;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.biz.eventprocessor.CommonExpoEventProcessor.ExpoHandler");
            arrayList2.add((InterfaceC9565b) newInstance);
        }
        this.handlerList = arrayList2;
        this.exposedSet = new LinkedHashSet();
    }

    private final void c(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        Iterator<T> it = this.handlerList.iterator();
        while (it.hasNext()) {
            ((InterfaceC9565b) it.next()).a(items);
        }
    }

    private final void d(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        if (items.isEmpty()) {
            if (QLog.isDebugVersion()) {
                QLog.d("CommonExpoEventHandler", 4, "CommonExpoEventHandler call empty");
                return;
            }
            return;
        }
        e(items);
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!this.exposedSet.contains(Long.valueOf(((com.tencent.qqnt.chats.core.bizEvent.b) obj).a()))) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.exposedSet.add(Long.valueOf(((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).a()));
        }
        Unit unit = Unit.INSTANCE;
        c(items);
    }

    private final void e(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        Iterator<T> it = this.handlerList.iterator();
        while (it.hasNext()) {
            ((InterfaceC9565b) it.next()).b(items);
        }
    }

    @Override // com.tencent.qqnt.chats.core.bizEvent.e
    @NotNull
    public List<com.tencent.qqnt.chats.core.bizEvent.a> a() {
        List<com.tencent.qqnt.chats.core.bizEvent.a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(a.c.f354762a);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.qqnt.chats.core.bizEvent.e
    public void b(@NotNull com.tencent.qqnt.chats.core.bizEvent.a event, @NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(items, "items");
        d(items);
    }
}
