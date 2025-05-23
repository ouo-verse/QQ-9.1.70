package com.tencent.mm.sdk.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.jq.e;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class MvvmObserverOwner {

    /* renamed from: b, reason: collision with root package name */
    public static final a f152562b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f152563a = new ConcurrentHashMap(1);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0096\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mm/sdk/observer/MvvmObserverOwner$LifecycleBoundObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "a", "b", "", "eventList", "onLifecycleDestroy", "", "hashCode", "", "e", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "d", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/luggage/wxa/sn/a;", "c", "()Lcom/tencent/luggage/wxa/sn/a;", "observer", "", "Ljava/lang/String;", "getThreadTag", "()Ljava/lang/String;", "threadTag", "<init>", "(Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/luggage/wxa/sn/a;Ljava/lang/String;)V", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public class LifecycleBoundObserver implements LifecycleObserver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final LifecycleOwner owner;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final com.tencent.luggage.wxa.sn.a observer;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final String threadTag;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MvvmObserverOwner f152567d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MvvmObserverOwner f152569b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MvvmObserverOwner mvvmObserverOwner) {
                super(0);
                this.f152569b = mvvmObserverOwner;
            }

            public final void a() {
                if (LifecycleBoundObserver.this.e()) {
                    LifecycleBoundObserver.this.getOwner().getLifecycle().addObserver(LifecycleBoundObserver.this);
                    return;
                }
                w.b(this.f152569b.a(), "attachObserver fail, lifecycle is destroyed owner:" + LifecycleBoundObserver.this.getOwner().hashCode() + " observer:" + LifecycleBoundObserver.this.getObserver().hashCode());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b extends Lambda implements Function0 {
            public b() {
                super(0);
            }

            public final void a() {
                LifecycleBoundObserver.this.getOwner().getLifecycle().removeObserver(LifecycleBoundObserver.this);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class c extends Lambda implements Function0 {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f152572b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list) {
                super(0);
                this.f152572b = list;
            }

            public final void a() {
                if (LifecycleBoundObserver.this.e()) {
                    List list = this.f152572b;
                    LifecycleBoundObserver lifecycleBoundObserver = LifecycleBoundObserver.this;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        lifecycleBoundObserver.getObserver().onChanged(it.next());
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class d implements g, e {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f152574b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MvvmObserverOwner f152575c;

            public d(List list, MvvmObserverOwner mvvmObserverOwner) {
                this.f152574b = list;
                this.f152575c = mvvmObserverOwner;
            }

            @Override // com.tencent.luggage.wxa.jq.e
            public boolean a() {
                return false;
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return this.f152575c.a();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (LifecycleBoundObserver.this.e()) {
                    List list = this.f152574b;
                    LifecycleBoundObserver lifecycleBoundObserver = LifecycleBoundObserver.this;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        lifecycleBoundObserver.getObserver().onChanged(it.next());
                    }
                }
            }
        }

        public LifecycleBoundObserver(MvvmObserverOwner mvvmObserverOwner, LifecycleOwner owner, com.tencent.luggage.wxa.sn.a observer, String str) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.f152567d = mvvmObserverOwner;
            this.owner = owner;
            this.observer = observer;
            this.threadTag = str;
        }

        public final void b() {
            com.tencent.luggage.wxa.rn.a.a(new b());
        }

        /* renamed from: c, reason: from getter */
        public final com.tencent.luggage.wxa.sn.a getObserver() {
            return this.observer;
        }

        /* renamed from: d, reason: from getter */
        public final LifecycleOwner getOwner() {
            return this.owner;
        }

        public final boolean e() {
            if (this.owner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.observer.hashCode();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onLifecycleDestroy() {
            w.a(this.f152567d.a(), "onLifecycleDestroy owner:" + this.owner.hashCode() + " observer:" + this.observer.hashCode());
            this.f152567d.a(this.observer);
        }

        public final void a() {
            com.tencent.luggage.wxa.rn.a.a(new a(this.f152567d));
        }

        public final void a(List eventList) {
            Object obj;
            Intrinsics.checkNotNullParameter(eventList, "eventList");
            if (e()) {
                String str = this.threadTag;
                if (str != null) {
                    MvvmObserverOwner mvvmObserverOwner = this.f152567d;
                    if (Intrinsics.areEqual(str, "%MainThread%")) {
                        com.tencent.luggage.wxa.rn.a.a(new c(eventList));
                        obj = Unit.INSTANCE;
                    } else {
                        obj = h.f146825d.b(new d(eventList, mvvmObserverOwner), str);
                    }
                } else {
                    obj = null;
                }
                if (obj == null) {
                    Iterator it = eventList.iterator();
                    while (it.hasNext()) {
                        this.observer.onChanged(it.next());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract String a();

    public void a(LifecycleOwner lifecycleOwner, String threadTag, com.tencent.luggage.wxa.sn.a observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(threadTag, "threadTag");
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.f152563a) {
            LifecycleBoundObserver lifecycleBoundObserver = (LifecycleBoundObserver) this.f152563a.get(Integer.valueOf(observer.hashCode()));
            if (lifecycleBoundObserver != null) {
                LifecycleOwner owner = lifecycleBoundObserver.getOwner();
                if (!(!Intrinsics.areEqual(owner, lifecycleOwner))) {
                    owner = null;
                }
                if (owner != null) {
                    w.b(a(), "Cannot add the same observer with different lifecycles");
                    return;
                } else {
                    LifecycleBoundObserver lifecycleBoundObserver2 = (LifecycleBoundObserver) this.f152563a.remove(Integer.valueOf(observer.hashCode()));
                    if (lifecycleBoundObserver2 != null) {
                        lifecycleBoundObserver2.b();
                    }
                }
            }
            LifecycleBoundObserver a16 = a(lifecycleOwner, observer, threadTag);
            a16.a();
            this.f152563a.put(Integer.valueOf(observer.hashCode()), a16);
            w.a(a(), "observe: " + observer.hashCode());
            Unit unit = Unit.INSTANCE;
        }
    }

    public void b(List eventList) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        try {
            if ((!this.f152563a.isEmpty()) && (!eventList.isEmpty())) {
                ConcurrentHashMap concurrentHashMap = this.f152563a;
                ArrayList arrayList = new ArrayList(concurrentHashMap.size());
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((Map.Entry) it.next());
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    ((LifecycleBoundObserver) ((Map.Entry) it5.next()).getValue()).a(eventList);
                }
                w.a(a(), "doNotify notifyCount:" + arrayList.size());
            }
        } catch (Exception e16) {
            w.a(a(), e16, "doNotify", new Object[0]);
        }
    }

    public void a(LifecycleOwner lifecycleOwner, com.tencent.luggage.wxa.sn.a observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        a(lifecycleOwner, "%MainThread%", observer);
    }

    public void a(com.tencent.luggage.wxa.sn.a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.f152563a) {
            LifecycleBoundObserver lifecycleBoundObserver = (LifecycleBoundObserver) this.f152563a.remove(Integer.valueOf(observer.hashCode()));
            if (lifecycleBoundObserver != null) {
                lifecycleBoundObserver.b();
                w.a(a(), "removeObserver: " + observer.hashCode());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void a(Object event) {
        List listOf;
        Intrinsics.checkNotNullParameter(event, "event");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(event);
        b(listOf);
    }

    public LifecycleBoundObserver a(LifecycleOwner owner, com.tencent.luggage.wxa.sn.a observer, String str) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return new LifecycleBoundObserver(this, owner, observer, str);
    }
}
