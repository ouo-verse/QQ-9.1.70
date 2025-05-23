package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kp {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f149021a;

    /* renamed from: b, reason: collision with root package name */
    private static c f149022b;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicInteger f149023c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f149024d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends BaseHandlerThread {

        /* renamed from: a, reason: collision with root package name */
        public static final String f149026a = "tms-dsp";

        /* renamed from: h, reason: collision with root package name */
        private static final int f149027h = 1;

        /* renamed from: i, reason: collision with root package name */
        private static final int f149028i = 300;

        /* renamed from: b, reason: collision with root package name */
        private boolean f149029b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f149030c;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f149031d;

        /* renamed from: e, reason: collision with root package name */
        private Handler f149032e;

        /* renamed from: f, reason: collision with root package name */
        private final ConcurrentLinkedQueue<a> f149033f;

        /* renamed from: g, reason: collision with root package name */
        private final ConcurrentLinkedQueue<a> f149034g;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a<T> {

            /* renamed from: a, reason: collision with root package name */
            static final int f149036a = 0;

            /* renamed from: b, reason: collision with root package name */
            static final int f149037b = 1;

            /* renamed from: c, reason: collision with root package name */
            static final int f149038c = 2;

            /* renamed from: d, reason: collision with root package name */
            static final int f149039d = 3;

            /* renamed from: e, reason: collision with root package name */
            static final int f149040e = 4;

            /* renamed from: f, reason: collision with root package name */
            boolean f149041f;

            /* renamed from: g, reason: collision with root package name */
            d<T> f149042g;

            /* renamed from: h, reason: collision with root package name */
            final g<T> f149043h;

            /* renamed from: i, reason: collision with root package name */
            a<T> f149044i;

            /* renamed from: j, reason: collision with root package name */
            Future<T> f149045j;

            /* renamed from: k, reason: collision with root package name */
            T f149046k;

            /* renamed from: l, reason: collision with root package name */
            int f149047l;

            /* renamed from: m, reason: collision with root package name */
            int f149048m;

            /* synthetic */ a(b bVar, g gVar, byte b16) {
                this(gVar);
            }

            private void b(d<T> dVar) {
                this.f149042g = dVar;
                g<T> gVar = this.f149043h;
                if (gVar != null) {
                    ((g) gVar).f149058a = new a<T>() { // from class: com.tencent.mapsdk.internal.kp.b.a.1
                        @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
                        public final void callback(T t16) {
                            a.this.f149046k = t16;
                        }
                    };
                }
            }

            private void c() {
                a((d) new e(null)).a();
            }

            private boolean d() {
                this.f149047l++;
                lc.a(ky.f149114t).a("try time:" + this.f149047l);
                if (this.f149047l >= 2) {
                    return false;
                }
                this.f149041f = false;
                a();
                return true;
            }

            private void e() {
                g<T> gVar;
                lc.a(ky.f149114t).a(new Object[0]);
                d<T> dVar = this.f149042g;
                if (dVar != null && (gVar = this.f149043h) != null) {
                    this.f149045j = dVar.a(gVar);
                }
                lc.a(ky.f149114t).a(new Object[0]);
                this.f149048m = 2;
            }

            private void f() {
                lc.a(ky.f149114t).a("result:" + this.f149046k, "userCallback:" + this.f149044i);
                a<T> aVar = this.f149044i;
                if (aVar != null) {
                    aVar.callback(this.f149046k);
                }
            }

            private void g() throws ExecutionException, InterruptedException {
                lc.a(ky.f149114t).a(new Object[0]);
                Future<T> future = this.f149045j;
                if (future != null && !this.f149041f) {
                    if (future.isDone()) {
                        this.f149048m = 3;
                    } else if (this.f149045j.isCancelled()) {
                        this.f149046k = this.f149045j.get();
                        b();
                    }
                }
            }

            a(g<T> gVar) {
                this.f149048m = 0;
                this.f149043h = gVar;
                if (gVar == null || b.this.f149031d) {
                    this.f149041f = true;
                }
            }

            public final a<T> a(d<T> dVar) {
                b.this.f149033f.add(this);
                lc.a(ky.f149114t).a("dispatchHandler:" + b.this.f149032e);
                b(dVar);
                return this;
            }

            public final void b(a<T> aVar) {
                this.f149044i = aVar;
                a();
            }

            final void b() {
                lc.a(ky.f149114t).a(new Object[0]);
                this.f149041f = true;
                Future<T> future = this.f149045j;
                if (future != null) {
                    future.cancel(false);
                }
                this.f149048m = 4;
            }

            public final void a(T t16) {
                if (b.this.f149031d) {
                    return;
                }
                a((d) new f(t16)).a();
            }

            public final void a(a<T> aVar) {
                if (b.this.f149031d) {
                    return;
                }
                a((d) new f(null)).b(aVar);
            }

            public final void a(T t16, a<T> aVar) {
                a((d) new e(t16)).b(aVar);
            }

            public final void a() {
                lc.a(ky.f149114t).a(new Object[0]);
                if (!this.f149041f && !b.this.f149031d) {
                    this.f149048m = 1;
                    if (b.this.f149032e != null) {
                        b.this.f149032e.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                lc.a(ky.f149114t).a("cancelled...");
            }
        }

        public b() {
            super(f149026a);
            this.f149033f = new ConcurrentLinkedQueue<>();
            this.f149034g = new ConcurrentLinkedQueue<>();
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
            this.f149029b = true;
            this.f149032e = new Handler(getLooper()) { // from class: com.tencent.mapsdk.internal.kp.b.1
                @Override // android.os.Handler
                public final void dispatchMessage(Message message) {
                    super.dispatchMessage(message);
                    if (message.what == 1) {
                        try {
                            if (b.this.a()) {
                                b.this.f149032e.sendEmptyMessageDelayed(1, 300L);
                            }
                        } catch (Throwable th5) {
                            LogUtil.b("MSG_SYNC_CHECK ERR:", th5);
                        }
                    }
                }
            };
            lc.a(ky.f149114t).a("looper is prepared...");
            this.f149032e.sendEmptyMessage(1);
        }

        @Override // android.os.HandlerThread
        public final boolean quit() {
            boolean quit = super.quit();
            if (quit) {
                b();
                this.f149031d = true;
            }
            return quit;
        }

        @Override // android.os.HandlerThread
        public final boolean quitSafely() {
            boolean quitSafely = super.quitSafely();
            if (quitSafely) {
                b();
                this.f149031d = true;
            }
            return quitSafely;
        }

        private void a(c cVar) {
            cVar.a(f149026a, this);
        }

        private void b() {
            Iterator<a> it = this.f149033f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.b();
                }
            }
            Iterator<a> it5 = this.f149034g.iterator();
            while (it5.hasNext()) {
                a next2 = it5.next();
                if (next2 != null) {
                    next2.b();
                }
            }
            this.f149033f.clear();
            this.f149034g.clear();
            lc.a(ky.f149114t).a("cancelAll...");
            Handler handler = this.f149032e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r6v17, types: [T, java.lang.Object] */
        public boolean a() {
            boolean z16;
            a poll;
            Callable callable;
            if (!this.f149033f.isEmpty() && (poll = this.f149033f.poll()) != null && poll.f149048m == 1) {
                lc.a(ky.f149114t).a(new Object[0]);
                d<T> dVar = poll.f149042g;
                if (dVar != 0 && (callable = poll.f149043h) != null) {
                    poll.f149045j = dVar.a(callable);
                }
                lc.a(ky.f149114t).a(new Object[0]);
                poll.f149048m = 2;
                this.f149034g.add(poll);
            }
            Iterator<a> it = this.f149034g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    int i3 = next.f149048m;
                    if (i3 == 2) {
                        try {
                            lc.a(ky.f149114t).a(new Object[0]);
                            Future<T> future = next.f149045j;
                            if (future != 0 && !next.f149041f) {
                                if (future.isDone()) {
                                    next.f149048m = 3;
                                } else if (next.f149045j.isCancelled()) {
                                    next.f149046k = next.f149045j.get();
                                    next.b();
                                }
                            }
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        } catch (ExecutionException e17) {
                            e17.printStackTrace();
                        }
                    } else if (i3 == 3) {
                        lc.a(ky.f149114t).a("result:" + next.f149046k, "userCallback:" + next.f149044i);
                        Callback callback = next.f149044i;
                        if (callback != null) {
                            callback.callback(next.f149046k);
                        }
                        it.remove();
                    } else if (i3 == 4) {
                        next.f149047l++;
                        lc.a(ky.f149114t).a("try time:" + next.f149047l);
                        if (next.f149047l < 2) {
                            next.f149041f = false;
                            next.a();
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            this.f149033f.offer(next);
                        }
                        it.remove();
                    }
                }
            }
            return !this.f149034g.isEmpty();
        }

        final synchronized <T> a<T> a(g<T> gVar) {
            byte b16;
            b16 = 0;
            lc.a(ky.f149114t).a("prepared:" + this.f149029b);
            if (!this.f149029b && !this.f149030c && !this.f149031d) {
                start();
                this.f149030c = true;
            }
            return new a<>(this, gVar, b16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final Map<String, HandlerThread> f149051a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final b f149052b = new b();

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.kp$c$1, reason: invalid class name */
        /* loaded from: classes9.dex */
        final class AnonymousClass1 extends a<Map.Entry<String, HandlerThread>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f149053a;

            AnonymousClass1(List list) {
                this.f149053a = list;
            }

            private void a(Map.Entry<String, HandlerThread> entry) {
                HandlerThread value;
                if (entry != null && (value = entry.getValue()) != null) {
                    value.quitSafely();
                    this.f149053a.add(entry.getKey());
                }
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(Object obj) {
                HandlerThread handlerThread;
                Map.Entry entry = (Map.Entry) obj;
                if (entry != null && (handlerThread = (HandlerThread) entry.getValue()) != null) {
                    handlerThread.quitSafely();
                    this.f149053a.add(entry.getKey());
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.kp$c$2, reason: invalid class name */
        /* loaded from: classes9.dex */
        final class AnonymousClass2 extends a<String> {
            AnonymousClass2() {
            }

            private void a(String str) {
                if (str != null) {
                    c.this.f149051a.remove(str);
                }
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(Object obj) {
                String str = (String) obj;
                if (str != null) {
                    c.this.f149051a.remove(str);
                }
            }
        }

        private b b() {
            return this.f149052b;
        }

        private void c() {
            if (!this.f149051a.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Util.foreach(this.f149051a.entrySet(), new AnonymousClass1(arrayList));
                Util.foreach(arrayList, new AnonymousClass2());
            }
        }

        private void a() {
            a(b.f149026a, this.f149052b);
        }

        public final void a(String str, HandlerThread handlerThread) {
            if (str == null || str.isEmpty()) {
                return;
            }
            this.f149051a.put(str, handlerThread);
        }

        private Looper a(String str) {
            String concat = "tms-".concat(String.valueOf(str));
            HandlerThread handlerThread = this.f149051a.get(concat);
            if (handlerThread == null || handlerThread.getThreadId() == -1) {
                handlerThread = new BaseHandlerThread(concat);
                handlerThread.start();
                a(concat, handlerThread);
            }
            return handlerThread.getLooper();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d<T> {
        Future<T> a(g<T> gVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        T f149056a;

        public e(T t16) {
            this.f149056a = t16;
        }

        @Override // com.tencent.mapsdk.internal.kp.d
        public final Future<T> a(g<T> gVar) {
            return hu.a().submit(gVar, this.f149056a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        T f149057a;

        public f(T t16) {
            this.f149057a = t16;
        }

        @Override // com.tencent.mapsdk.internal.kp.d
        public final Future<T> a(g<T> gVar) {
            return hu.b().submit(gVar, this.f149057a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class g<T> implements Runnable, Callable<T> {

        /* renamed from: a, reason: collision with root package name */
        private a<T> f149058a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                T call = call();
                a<T> aVar = this.f149058a;
                if (aVar != null) {
                    aVar.callback(call);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        lc.b(ky.f149114t);
        f149021a = new Handler(Looper.getMainLooper());
        f149023c = new AtomicInteger();
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f149021a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void b(final Runnable runnable) {
        a((g) new g<Void>() { // from class: com.tencent.mapsdk.internal.kp.1
            private Void a() throws Exception {
                runnable.run();
                return null;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                runnable.run();
                return null;
            }
        }).a((d) new e(null)).a();
    }

    public static void c() {
        f149023c.decrementAndGet();
    }

    public static void d() {
        if (f149023c.get() <= 0) {
            LogUtil.c(ky.f149114t, "sDispatcher clean quit finally curCnt: " + f149023c);
            c cVar = f149022b;
            if (cVar != null) {
                if (!cVar.f149051a.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Util.foreach(cVar.f149051a.entrySet(), new c.AnonymousClass1(arrayList));
                    Util.foreach(arrayList, new c.AnonymousClass2());
                }
                f149024d = true;
            }
            f149023c.set(0);
        } else {
            LogUtil.c(ky.f149114t, "sDispatcher clean quiting curCnt: " + f149023c);
        }
        f149021a.removeCallbacksAndMessages(null);
    }

    private static Looper e() {
        c cVar = f149022b;
        if (cVar == null) {
            return null;
        }
        return cVar.f149052b.getLooper();
    }

    public static void b() {
        f149023c.incrementAndGet();
    }

    public static void a(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        f149021a.postDelayed(runnable, j3);
    }

    public static Looper a(String str) {
        c cVar = f149022b;
        if (cVar == null) {
            return null;
        }
        String concat = "tms-".concat(String.valueOf(str));
        HandlerThread handlerThread = cVar.f149051a.get(concat);
        if (handlerThread == null || handlerThread.getThreadId() == -1) {
            handlerThread = new BaseHandlerThread(concat);
            handlerThread.start();
            cVar.a(concat, handlerThread);
        }
        return handlerThread.getLooper();
    }

    public static c a() {
        return new c();
    }

    public static void a(c cVar) {
        LogUtil.b(ky.f149114t, "sDispatcher registerDispatcher refCnt: " + f149023c.get());
        if (cVar == null || f149023c.get() > 1) {
            return;
        }
        c cVar2 = f149022b;
        if (cVar2 == null || (cVar2 != null && f149024d)) {
            f149022b = cVar;
            cVar.a(b.f149026a, cVar.f149052b);
            f149024d = false;
        }
        Looper looper = f149022b.f149052b.getLooper();
        if (looper != null) {
            looper.setMessageLogging(new Printer() { // from class: com.tencent.mapsdk.internal.kp.2
                @Override // android.util.Printer
                public final void println(String str) {
                    LogUtil.c(ky.f149114t, str);
                }
            });
        }
    }

    public static <T> b.a<T> a(g<T> gVar) {
        lc.a(ky.f149114t).a(gVar);
        return f149022b.f149052b.a(gVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class a<T> implements Callback<T>, Runnable {
        @Override // com.tencent.map.tools.Callback
        public abstract void callback(T t16);

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
