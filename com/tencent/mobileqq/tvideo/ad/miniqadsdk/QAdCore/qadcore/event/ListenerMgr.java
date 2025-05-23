package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ListenerMgr<T> {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f303876b = false;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<T>> f303877a = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a<T> {
        void onNotify(T t16);
    }

    public void a(T t16) {
        if (t16 != null) {
            synchronized (this.f303877a) {
                Iterator<WeakReference<T>> it = this.f303877a.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    T t17 = it.next().get();
                    if (t17 == null) {
                        it.remove();
                    } else if (t17 == t16) {
                        z16 = true;
                    }
                }
                if (!z16) {
                    this.f303877a.add(new WeakReference<>(t16));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(a<T> aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (this.f303877a) {
            if (this.f303877a.size() > 0) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue(this.f303877a);
            } else {
                concurrentLinkedQueue = null;
            }
        }
        if (concurrentLinkedQueue != null) {
            try {
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    Object obj = ((WeakReference) it.next()).get();
                    if (obj != null) {
                        try {
                            aVar.onNotify(obj);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            Log.e("crash", th5.toString(), th5);
                            if (f303876b) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        throw new RuntimeException(th5);
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c(T t16) {
        if (t16 != null) {
            synchronized (this.f303877a) {
                Iterator<WeakReference<T>> it = this.f303877a.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == t16) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }
}
