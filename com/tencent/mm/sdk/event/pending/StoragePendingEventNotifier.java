package com.tencent.mm.sdk.event.pending;

import android.os.Message;
import androidx.lifecycle.LifecycleObserver;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\tB-\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0018\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\n\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\n\u0010\u0016R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0019\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mm/sdk/event/pending/StoragePendingEventNotifier;", "Lcom/tencent/luggage/wxa/xn/a;", "T", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/luggage/wxa/zn/b;", "event", "", "pending", "", "a", "b", "", "what", "", "J", "getDelay", "()J", "setDelay", "(J)V", "delay", "", "Ljava/lang/String;", "()Ljava/lang/String;", "handleThreadTag", "Lcom/tencent/luggage/wxa/pn/b;", "c", "Lcom/tencent/luggage/wxa/pn/b;", "getHandler", "()Lcom/tencent/luggage/wxa/pn/b;", "handler", "d", "Lcom/tencent/luggage/wxa/zn/b;", "pendingEvent", "Lcom/tencent/luggage/wxa/tn/b0;", "e", "Lkotlin/Lazy;", "()Lcom/tencent/luggage/wxa/tn/b0;", "pendingHandler", "<init>", "(JLjava/lang/String;Lcom/tencent/luggage/wxa/pn/b;)V", "f", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class StoragePendingEventNotifier<T extends a> implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long delay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String handleThreadTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.pn.b handler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.zn.b pendingEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Lazy pendingHandler;

    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {

        /* loaded from: classes9.dex */
        public static final class a implements b0.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ StoragePendingEventNotifier f152556a;

            public a(StoragePendingEventNotifier storagePendingEventNotifier) {
                this.f152556a = storagePendingEventNotifier;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message msg2) {
                boolean z16;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                int i3 = msg2.what;
                if (i3 == 0) {
                    this.f152556a.a();
                } else if (i3 == 1) {
                    if (msg2.arg1 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Object obj = msg2.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.sdk.storage.observer.StorageObserverEvent<T of com.tencent.mm.sdk.event.pending.StoragePendingEventNotifier>");
                    this.f152556a.b((com.tencent.luggage.wxa.zn.b) obj, z16);
                }
                return true;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 invoke() {
            a aVar = new a(StoragePendingEventNotifier.this);
            com.tencent.luggage.wxa.kq.a b16 = com.tencent.luggage.wxa.kq.a.b(StoragePendingEventNotifier.this.getHandleThreadTag());
            if (b16 == null) {
                b16 = com.tencent.luggage.wxa.kq.a.a(StoragePendingEventNotifier.this.getHandleThreadTag());
            }
            b0 b0Var = new b0(b16, aVar);
            b0Var.a(false);
            return b0Var;
        }
    }

    public StoragePendingEventNotifier(long j3, String handleThreadTag, com.tencent.luggage.wxa.pn.b handler) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(handleThreadTag, "handleThreadTag");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.delay = j3;
        this.handleThreadTag = handleThreadTag;
        this.handler = handler;
        if (j3 > 0) {
            com.tencent.luggage.wxa.zn.b bVar = new com.tencent.luggage.wxa.zn.b(com.tencent.luggage.wxa.zn.a.f146756b.a(), "BATCH_PENDING_KEY", "MicroMsg.Mvvm.StoragePendingEventNotifier");
            bVar.a(new HashMap());
            this.pendingEvent = bVar;
            lazy = LazyKt__LazyJVMKt.lazy(new b());
            this.pendingHandler = lazy;
            return;
        }
        throw new IllegalArgumentException("not allow use zero or smaller delay");
    }

    /* renamed from: b, reason: from getter */
    public final String getHandleThreadTag() {
        return this.handleThreadTag;
    }

    public final b0 c() {
        return (b0) this.pendingHandler.getValue();
    }

    public final void b(com.tencent.luggage.wxa.zn.b event, boolean pending) {
        com.tencent.luggage.wxa.pn.a a16 = this.pendingEvent.a(event);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.sdk.storage.observer.StorageObserverEvent<T of com.tencent.mm.sdk.event.pending.StoragePendingEventNotifier>");
        this.pendingEvent.a(((com.tencent.luggage.wxa.zn.b) a16).a());
        if (pending) {
            b(0);
        } else {
            a(0);
        }
    }

    public final void a() {
        HashMap a16 = this.pendingEvent.a();
        if (a16 != null) {
            if (!(!a16.isEmpty())) {
                a16 = null;
            }
            if (a16 != null) {
                ArrayList arrayList = new ArrayList(a16.size());
                Iterator it = a16.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.tencent.luggage.wxa.zn.b) ((Map.Entry) it.next()).getValue());
                }
                this.pendingEvent.a(new HashMap());
                if (!arrayList.isEmpty()) {
                    this.handler.a(arrayList);
                }
            }
        }
    }

    public final void b(int what) {
        if (!c().a(what)) {
            w.a("MicroMsg.Mvvm.StoragePendingEventNotifier", "send pending message " + what);
            c().a(what, this.delay);
            return;
        }
        w.a("MicroMsg.Mvvm.StoragePendingEventNotifier", "ignore pending message " + what);
    }

    public final void a(com.tencent.luggage.wxa.zn.b event, boolean pending) {
        Intrinsics.checkNotNullParameter(event, "event");
        c().a(c().a(1, pending ? 1 : 0, 0, event));
    }

    public final void a(int what) {
        w.a("MicroMsg.Mvvm.StoragePendingEventNotifier", "send message " + what);
        c().b(what);
    }
}
