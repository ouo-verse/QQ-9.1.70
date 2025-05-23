package com.tencent.mobileqq.search.rich;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichNodeController {

    /* renamed from: g, reason: collision with root package name */
    private static String f283731g = "RichNodeController";

    /* renamed from: h, reason: collision with root package name */
    private static final Set<WeakReference<f>> f283732h = Collections.synchronizedSet(new HashSet());

    /* renamed from: c, reason: collision with root package name */
    private int f283735c;

    /* renamed from: d, reason: collision with root package name */
    private int f283736d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f283737e;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, a> f283733a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f283734b = 0;

    /* renamed from: f, reason: collision with root package name */
    private Handler f283738f = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f283739a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<f> f283740b;

        public a(int i3, f fVar) {
            this.f283739a = i3;
            this.f283740b = new WeakReference<>(fVar);
        }
    }

    private void c() {
        if (this.f283733a.size() == 0) {
            return;
        }
        Iterator<Map.Entry<Integer, a>> it = this.f283733a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, a> next = it.next();
            a value = next.getValue();
            if (value == null) {
                it.remove();
            } else {
                WeakReference<f> weakReference = value.f283740b;
                if (weakReference == null) {
                    it.remove();
                } else {
                    f fVar = weakReference.get();
                    if (fVar == null) {
                        it.remove();
                    } else {
                        Integer key = next.getKey();
                        if (key == null) {
                            fVar.pause();
                            it.remove();
                        } else if (key.intValue() < this.f283735c || key.intValue() > this.f283736d) {
                            fVar.pause();
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    public static void e() {
        Set<WeakReference<f>> set = f283732h;
        synchronized (set) {
            Iterator<WeakReference<f>> it = set.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f283731g, 2, "onDestroy.(item == null");
                    }
                    it.remove();
                } else {
                    f fVar = next.get();
                    if (fVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f283731g, 2, "onDestroy.(node == null");
                        }
                        it.remove();
                    } else {
                        d(fVar);
                        fVar.destroy();
                    }
                }
            }
            f283732h.clear();
        }
    }

    public static void f() {
        h();
    }

    public static void g() {
        l();
    }

    public static void h() {
        Set<WeakReference<f>> set = f283732h;
        synchronized (set) {
            Iterator<WeakReference<f>> it = set.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f283731g, 2, "onPause item == null");
                    }
                    it.remove();
                } else {
                    f fVar = next.get();
                    if (fVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f283731g, 2, "onPause node == null");
                        }
                        it.remove();
                    } else {
                        fVar.pause();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16) {
        WeakReference<f> weakReference;
        f fVar;
        if (QLog.isColorLevel()) {
            QLog.d(f283731g, 2, "pauseAll, puase:" + z16 + " startPos:" + this.f283735c + " endPos:" + this.f283736d);
        }
        if (this.f283733a.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f283731g, 2, "pauseAll, map is empty");
                return;
            }
            return;
        }
        for (a aVar : this.f283733a.values()) {
            if (aVar != null && (weakReference = aVar.f283740b) != null && (fVar = weakReference.get()) != null) {
                if (z16) {
                    fVar.pause();
                } else {
                    fVar.resume();
                }
            }
        }
    }

    private void k(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(f283731g, 2, "restartPlayTimer:" + i3);
        }
        if (this.f283738f == null) {
            this.f283738f = new Handler(Looper.getMainLooper());
        }
        if (this.f283737e != null) {
            this.f283738f.removeCallbacksAndMessages(null);
        }
        if (i3 < 0) {
            return;
        }
        if (this.f283737e == null) {
            this.f283737e = new Runnable() { // from class: com.tencent.mobileqq.search.rich.RichNodeController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RichNodeController.this.f283734b == 0) {
                        RichNodeController.this.i(false);
                    }
                }
            };
        }
        this.f283738f.postDelayed(this.f283737e, i3);
    }

    private static void l() {
        Set<WeakReference<f>> set = f283732h;
        synchronized (set) {
            Iterator<WeakReference<f>> it = set.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f283731g, 2, "onPause item == null");
                    }
                    it.remove();
                } else {
                    f fVar = next.get();
                    if (fVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f283731g, 2, "onPause node == null");
                        }
                        it.remove();
                    } else {
                        fVar.resume();
                    }
                }
            }
        }
    }

    public void j(int i3, f fVar) {
        boolean z16;
        if (fVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f283731g, 2, "registerNode, nPos:" + i3);
        }
        this.f283733a.put(Integer.valueOf(i3), new a(i3, fVar));
        if (this.f283734b != 0) {
            fVar.pause();
        } else {
            fVar.resume();
        }
        Set<WeakReference<f>> set = f283732h;
        synchronized (set) {
            Iterator<WeakReference<f>> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    WeakReference<f> next = it.next();
                    if (next != null && next.get() == fVar) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f283731g, 2, "find in list:" + z16);
            }
            if (!z16) {
                f283732h.add(new WeakReference<>(fVar));
            }
        }
    }

    public void m(int i3, int i16, int i17) {
        if (i3 == this.f283735c && this.f283736d == i3 + i16) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f283731g, 2, "setScorllData, mStartPos:" + this.f283735c + " endPos:" + this.f283736d);
        }
        this.f283735c = i3;
        this.f283736d = i3 + i16;
        c();
    }

    public void n(int i3) {
        this.f283734b = i3;
        if (i3 == 0) {
            k(100);
        } else {
            k(-1);
            h();
        }
    }

    private static void d(f fVar) {
    }
}
