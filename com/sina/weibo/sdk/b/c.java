package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c<Params, Progress, Result> {
    final d<Params, Result> S;
    public final FutureTask<Result> T;
    Params[] V;
    volatile int R = b.f61230aa;
    int U = 5;

    /* renamed from: y, reason: collision with root package name */
    Handler f61229y = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.b.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what == 1) {
                c.a(aVar.Y, aVar.Z[0]);
                message.obj = null;
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.sina.weibo.sdk.b.c$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] X;

        static {
            int[] iArr = new int[b.p().length];
            X = iArr;
            try {
                iArr[b.f61231ab - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                X[b.f61232ac - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a<Data> {
        final c Y;
        final Data[] Z;

        a(c cVar, Data... dataArr) {
            this.Y = cVar;
            this.Z = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: aa, reason: collision with root package name */
        public static final int f61230aa = 1;

        /* renamed from: ab, reason: collision with root package name */
        public static final int f61231ab = 2;

        /* renamed from: ac, reason: collision with root package name */
        public static final int f61232ac = 3;

        /* renamed from: ad, reason: collision with root package name */
        private static final /* synthetic */ int[] f61233ad = {1, 2, 3};

        public static int[] p() {
            return (int[]) f61233ad.clone();
        }
    }

    /* compiled from: P */
    /* renamed from: com.sina.weibo.sdk.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private abstract class AbstractC0510c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC0510c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    public c() {
        d<Params, Result> dVar = new d<Params, Result>() { // from class: com.sina.weibo.sdk.b.c.2
            @Override // java.util.concurrent.Callable
            public final Result call() {
                Process.setThreadPriority(c.this.U);
                return (Result) c.this.o();
            }
        };
        this.S = dVar;
        this.T = new c<Params, Progress, Result>.AbstractC0510c(dVar) { // from class: com.sina.weibo.sdk.b.c.3
            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return 0;
            }

            @Override // java.util.concurrent.FutureTask
            protected final void done() {
                try {
                    Result result = get();
                    c cVar = c.this;
                    cVar.f61229y.obtainMessage(1, new a(cVar, result)).sendToTarget();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (CancellationException unused2) {
                    c.this.f61229y.obtainMessage(3, new a(c.this, null)).sendToTarget();
                } catch (ExecutionException unused3) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                }
            }
        };
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.onPostExecute(obj);
        cVar.R = b.f61232ac;
    }

    protected abstract Result o();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class d<Params, Result> implements Callable<Result> {

        /* renamed from: ae, reason: collision with root package name */
        Params[] f61234ae;
        int priority;

        d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b16) {
            this();
        }
    }

    protected void onPostExecute(Result result) {
    }
}
