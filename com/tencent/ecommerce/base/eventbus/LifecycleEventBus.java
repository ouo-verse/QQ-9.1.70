package com.tencent.ecommerce.base.eventbus;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J#\u0010\u000b\u001a\u00020\u0006\"\f\b\u0000\u0010\t*\u00060\u0001j\u0002`\b2\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0013\u001a\u00020\u0006\"\f\b\u0000\u0010\t*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J8\u0010\u0014\u001a\u00020\u0006\"\f\b\u0000\u0010\t*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\"\u0010\u0015\u001a\u00020\u0006\"\f\b\u0000\u0010\t*\u00060\u0001j\u0002`\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011R4\u0010\u001a\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u00040\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/LifecycleEventBus;", "", "Ljava/lang/Class;", "eventType", "Lcom/tencent/ecommerce/base/eventbus/LifecycleEventBus$a;", "observerWrapper", "", "b", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "T", "event", "f", "(Ljava/lang/Object;)V", "Lcom/tencent/ecommerce/base/eventbus/ThreadMode;", "threadMode", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "observer", "c", "d", "e", "", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/Map;", "observerMap", "<init>", "()V", "LifecycleBoundObserver", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class LifecycleEventBus {

    /* renamed from: b, reason: collision with root package name */
    public static final LifecycleEventBus f100688b = new LifecycleEventBus();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<Class<?>, ConcurrentHashMap<EventObserver<?>, a>> observerMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/LifecycleEventBus$LifecycleBoundObserver;", "Lcom/tencent/ecommerce/base/eventbus/LifecycleEventBus$a;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "a", "f", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "observer", "Lcom/tencent/ecommerce/base/eventbus/ThreadMode;", "threadMode", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/ecommerce/base/eventbus/EventObserver;Lcom/tencent/ecommerce/base/eventbus/ThreadMode;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class LifecycleBoundObserver extends a implements LifecycleEventObserver {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final LifecycleOwner owner;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, EventObserver<?> eventObserver, ThreadMode threadMode) {
            super(eventObserver, threadMode);
            this.owner = lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(this);
        }

        @Override // com.tencent.ecommerce.base.eventbus.LifecycleEventBus.a
        public void a() {
            super.a();
            this.owner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                LifecycleEventBus.f100688b.e(b());
            }
        }
    }

    LifecycleEventBus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Class<?> eventType, a observerWrapper) {
        Map<Class<?>, ConcurrentHashMap<EventObserver<?>, a>> map = observerMap;
        ConcurrentHashMap<EventObserver<?>, a> concurrentHashMap = map.get(eventType);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        if (map.get(eventType) == null) {
            map.put(eventType, concurrentHashMap);
        }
        concurrentHashMap.putIfAbsent(observerWrapper.b(), observerWrapper);
    }

    public final <T> void c(final ThreadMode threadMode, final LifecycleOwner owner, final Class<T> eventType, final EventObserver<T> observer) {
        ThreadManager.f100693b.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.eventbus.LifecycleEventBus$observe$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LifecycleEventBus.f100688b.b(eventType, new LifecycleEventBus.LifecycleBoundObserver(owner, observer, threadMode));
            }
        });
    }

    public final <T> void d(ThreadMode threadMode, Class<T> eventType, EventObserver<T> observer) {
        b(eventType, new a(observer, threadMode));
    }

    public final <T> void e(EventObserver<T> observer) {
        Iterator<Map.Entry<Class<?>, ConcurrentHashMap<EventObserver<?>, a>>> it = observerMap.entrySet().iterator();
        while (it.hasNext()) {
            a remove = it.next().getValue().remove(observer);
            if (remove != null) {
                remove.a();
            }
        }
    }

    public final <T> void f(T event) {
        ConcurrentHashMap<EventObserver<?>, a> concurrentHashMap = observerMap.get(event.getClass());
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<EventObserver<?>, a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                EventObserverKt.a(value.b(), event, value.threadMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0012\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/LifecycleEventBus$a;", "", "", "a", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "d", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "b", "()Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "observer", "Lcom/tencent/ecommerce/base/eventbus/ThreadMode;", "e", "Lcom/tencent/ecommerce/base/eventbus/ThreadMode;", "threadMode", "<init>", "(Lcom/tencent/ecommerce/base/eventbus/EventObserver;Lcom/tencent/ecommerce/base/eventbus/ThreadMode;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final EventObserver<?> observer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final ThreadMode threadMode;

        public a(EventObserver<?> eventObserver, ThreadMode threadMode) {
            this.observer = eventObserver;
            this.threadMode = threadMode;
        }

        public final EventObserver<?> b() {
            return this.observer;
        }

        public void a() {
        }
    }
}
