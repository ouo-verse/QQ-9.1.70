package com.tencent.luggage.wxa.v4;

import android.os.Parcelable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final Queue f143237a = new ConcurrentLinkedQueue();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f143238b;

        public a(f fVar) {
            this.f143238b = fVar;
        }

        @Override // com.tencent.luggage.wxa.v4.e
        public void a(Parcelable parcelable) {
            this.f143238b.a(parcelable);
        }
    }

    public abstract void a(Parcelable parcelable);

    public final void a(Runnable runnable) {
        if (runnable != null) {
            this.f143237a.offer(runnable);
        }
    }

    public void finalize() {
        while (!this.f143237a.isEmpty()) {
            try {
                ((Runnable) this.f143237a.poll()).run();
            } finally {
                super.finalize();
            }
        }
    }

    public static e a(f fVar) {
        return new a(fVar);
    }
}
