package com.tencent.mobileqq.richmedia.particlesystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Pair;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.richmedia.particlesystem.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private final Context f281712b;

    /* renamed from: c, reason: collision with root package name */
    private final jm2.a f281713c;

    /* renamed from: f, reason: collision with root package name */
    private long f281716f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f281717g;

    /* renamed from: j, reason: collision with root package name */
    private km2.f f281720j;

    /* renamed from: k, reason: collision with root package name */
    private qm2.a f281721k;

    /* renamed from: m, reason: collision with root package name */
    private InterfaceC8518c f281723m;

    /* renamed from: a, reason: collision with root package name */
    private final Object f281711a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final LinkedList<b> f281714d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<Integer, LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a>> f281715e = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f281718h = false;

    /* renamed from: i, reason: collision with root package name */
    private final Choreographer.FrameCallback f281719i = new a();

    /* renamed from: l, reason: collision with root package name */
    private final pm2.b f281722l = new pm2.b();

    /* renamed from: n, reason: collision with root package name */
    private final Camera f281724n = new Camera();

    /* renamed from: o, reason: collision with root package name */
    private final Matrix f281725o = new Matrix();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Choreographer.FrameCallback {
        a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            c.this.v();
            if (c.this.f281717g && !c.this.f281718h) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        private static final AtomicInteger f281727c = new AtomicInteger(0);

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final ArrayList<nm2.a> f281728a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f281729b;

        public b(@NonNull List<nm2.a> list) {
            ArrayList<nm2.a> arrayList = new ArrayList<>();
            this.f281728a = arrayList;
            arrayList.addAll(list);
            this.f281729b = Integer.valueOf(f281727c.incrementAndGet());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.particlesystem.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8518c {
        void onAnimationEnd();

        void onStart();

        void onStop();

        void onUpdate();
    }

    public c(@NonNull Context context, @NonNull jm2.a aVar) {
        this.f281712b = context;
        this.f281713c = aVar;
    }

    @NonNull
    private ArrayList<nm2.a> A(int i3, ArrayList<Pair<Integer, nm2.a>> arrayList) {
        ArrayList<nm2.a> arrayList2 = new ArrayList<>();
        synchronized (this.f281715e) {
            Iterator<LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a>> it = this.f281715e.values().iterator();
            while (it.hasNext()) {
                ListIterator<com.tencent.mobileqq.richmedia.particlesystem.a> listIterator = it.next().listIterator();
                while (listIterator.hasNext()) {
                    com.tencent.mobileqq.richmedia.particlesystem.a next = listIterator.next();
                    next.f281703y.a(next, this.f281713c, i3);
                    if (!next.a()) {
                        listIterator.remove();
                    }
                }
            }
            Iterator<Pair<Integer, nm2.a>> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Pair<Integer, nm2.a> next2 = it5.next();
                Integer num = (Integer) next2.first;
                nm2.a aVar = (nm2.a) next2.second;
                if (!aVar.update(i3)) {
                    arrayList2.add(aVar);
                }
                g(num, aVar.a(num.intValue()));
            }
        }
        return arrayList2;
    }

    private void g(Integer num, List<com.tencent.mobileqq.richmedia.particlesystem.a> list) {
        LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a> linkedList = this.f281715e.get(num);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f281715e.put(num, linkedList);
        }
        linkedList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this.f281715e) {
            this.f281715e.clear();
        }
        synchronized (this.f281711a) {
            Iterator<b> it = this.f281714d.iterator();
            while (it.hasNext()) {
                it.next().f281728a.clear();
            }
        }
        this.f281722l.a();
        u();
    }

    @NonNull
    private ArrayList<Pair<Integer, nm2.a>> j() {
        ArrayList<Pair<Integer, nm2.a>> arrayList;
        synchronized (this.f281711a) {
            arrayList = new ArrayList<>();
            Iterator<b> it = this.f281714d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                Iterator<nm2.a> it5 = next.f281728a.iterator();
                while (it5.hasNext()) {
                    arrayList.add(new Pair<>(next.f281729b, it5.next()));
                }
            }
        }
        return arrayList;
    }

    private boolean r(int i3) {
        synchronized (this.f281715e) {
            LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a> linkedList = this.f281715e.get(Integer.valueOf(i3));
            if (linkedList == null) {
                return true;
            }
            if (linkedList.isEmpty()) {
                this.f281715e.remove(Integer.valueOf(i3));
                return true;
            }
            return false;
        }
    }

    private static boolean s(@NonNull com.tencent.mobileqq.richmedia.particlesystem.a aVar) {
        if (aVar.f281691m <= 0.0f || aVar.f281689k <= 0.0f || aVar.f281680b <= 0 || aVar.f281681c <= 0 || aVar.f281700v == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        synchronized (this.f281711a) {
            Choreographer.getInstance().postFrameCallback(this.f281719i);
            InterfaceC8518c interfaceC8518c = this.f281723m;
            if (interfaceC8518c != null) {
                interfaceC8518c.onStart();
            }
        }
    }

    private void u() {
        ArrayList arrayList;
        pm2.a i3;
        synchronized (this.f281715e) {
            ArrayList arrayList2 = new ArrayList(o());
            Iterator<LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a>> it = this.f281715e.values().iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next());
            }
            Collections.sort(arrayList2, a.C8516a.f281704d);
            arrayList = new ArrayList(arrayList2.size());
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.richmedia.particlesystem.a aVar = (com.tencent.mobileqq.richmedia.particlesystem.a) it5.next();
                if (s(aVar) && aVar.f281699u.b() && (i3 = i(aVar)) != null) {
                    arrayList.add(i3);
                }
            }
        }
        this.f281713c.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.f281716f == 0) {
            this.f281716f = currentTimeMillis2;
        }
        int min = (int) Math.min(1000L, Math.max(0L, currentTimeMillis2 - this.f281716f));
        this.f281716f = currentTimeMillis2;
        boolean w3 = w(A(min, j()));
        u();
        InterfaceC8518c interfaceC8518c = this.f281723m;
        if (interfaceC8518c != null) {
            interfaceC8518c.onUpdate();
        }
        if (w3) {
            lm2.c.a("ParticleSystem", "onUpdate, stop updating");
            z();
        }
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis3 > 30) {
            lm2.c.a("ParticleSystem", "onUpdate, delta=" + min + ",use-time=" + currentTimeMillis3);
        }
    }

    private boolean w(ArrayList<nm2.a> arrayList) {
        boolean z16;
        synchronized (this.f281711a) {
            Iterator<nm2.a> it = arrayList.iterator();
            while (it.hasNext()) {
                nm2.a next = it.next();
                Iterator<b> it5 = this.f281714d.iterator();
                while (it5.hasNext()) {
                    it5.next().f281728a.remove(next);
                }
            }
            Iterator<b> it6 = this.f281714d.iterator();
            while (it6.hasNext()) {
                b next2 = it6.next();
                if (next2.f281728a.isEmpty() && r(next2.f281729b.intValue())) {
                    it6.remove();
                    InterfaceC8518c interfaceC8518c = this.f281723m;
                    if (interfaceC8518c != null) {
                        interfaceC8518c.onAnimationEnd();
                    }
                }
            }
            if (this.f281714d.isEmpty() && this.f281715e.isEmpty()) {
                lm2.c.a("ParticleSystem", "none particles and emitters exist, stop updating");
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public void f(List<nm2.a> list) {
        if (list == null) {
            lm2.c.c("ParticleSystem", "add a null emitter");
            return;
        }
        lm2.c.b("ParticleSystem", "add emitter, size=" + list.size());
        synchronized (this.f281711a) {
            this.f281714d.add(new b(list));
        }
        y();
    }

    pm2.a i(com.tencent.mobileqq.richmedia.particlesystem.a aVar) {
        Bitmap bitmap = aVar.f281700v.getBitmap();
        if (bitmap == null) {
            return null;
        }
        pm2.a b16 = this.f281722l.b();
        b16.f426470a = aVar.f281689k;
        b16.f426471b = bitmap;
        int width = bitmap.getWidth();
        int height = b16.f426471b.getHeight();
        b16.f426472c.reset();
        b16.f426472c.preTranslate(-(width / 2), -(height / 2));
        Matrix matrix = b16.f426472c;
        float f16 = aVar.f281691m;
        matrix.postScale((aVar.f281680b * f16) / width, (f16 * aVar.f281681c) / height);
        b16.f426472c.postConcat(p(aVar));
        b16.f426472c.postTranslate(aVar.f281682d, aVar.f281683e);
        return b16;
    }

    public Context k() {
        return this.f281712b;
    }

    public int l() {
        int size;
        synchronized (this.f281711a) {
            size = this.f281714d.size();
        }
        return size;
    }

    public qm2.a m() {
        qm2.a aVar;
        synchronized (this.f281711a) {
            if (this.f281721k == null) {
                this.f281721k = new qm2.a(n());
            }
            this.f281721k.d();
            aVar = this.f281721k;
        }
        return aVar;
    }

    public km2.f n() {
        km2.f fVar;
        synchronized (this.f281711a) {
            if (this.f281720j == null) {
                this.f281720j = new km2.f(this.f281712b);
            }
            fVar = this.f281720j;
        }
        return fVar;
    }

    public int o() {
        int i3;
        synchronized (this.f281715e) {
            Iterator<LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a>> it = this.f281715e.values().iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += it.next().size();
            }
        }
        return i3;
    }

    Matrix p(com.tencent.mobileqq.richmedia.particlesystem.a aVar) {
        this.f281724n.save();
        try {
            this.f281724n.rotate(lm2.e.b(aVar.f281693o), lm2.e.b(aVar.f281694p), -lm2.e.b(aVar.f281695q));
            this.f281724n.setLocation(0.0f, 0.0f, -100.0f);
            this.f281725o.reset();
            this.f281724n.getMatrix(this.f281725o);
            return this.f281725o;
        } finally {
            this.f281724n.restore();
        }
    }

    public Object q(float f16, float f17) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            synchronized (this.f281715e) {
                Iterator<LinkedList<com.tencent.mobileqq.richmedia.particlesystem.a>> it = this.f281715e.values().iterator();
                while (it.hasNext()) {
                    for (com.tencent.mobileqq.richmedia.particlesystem.a aVar : it.next()) {
                        float f18 = aVar.f281691m;
                        float f19 = (aVar.f281680b / 2.0f) * f18;
                        float f26 = (aVar.f281681c / 2.0f) * f18;
                        float f27 = aVar.f281682d;
                        if (f16 >= f27 - f19 && f16 <= f27 + f19) {
                            float f28 = aVar.f281683e;
                            if (f17 >= f28 - f26 && f17 <= f28 + f26) {
                                return aVar.f281702x;
                            }
                        }
                    }
                }
                lm2.c.b("ParticleSystem", "hitTest, time=" + (System.currentTimeMillis() - currentTimeMillis));
                return null;
            }
        } finally {
            lm2.c.b("ParticleSystem", "hitTest, time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void x(InterfaceC8518c interfaceC8518c) {
        this.f281723m = interfaceC8518c;
    }

    void y() {
        synchronized (this.f281711a) {
            if (this.f281717g) {
                lm2.c.b("ParticleSystem", "already running");
                return;
            }
            lm2.c.b("ParticleSystem", "start animation, emitter=" + this.f281714d.size());
            this.f281717g = true;
            this.f281718h = false;
            this.f281716f = 0L;
            lm2.d.a(new Runnable() { // from class: jm2.d
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.richmedia.particlesystem.c.this.t();
                }
            });
        }
    }

    public void z() {
        lm2.c.b("ParticleSystem", "stop all animations");
        synchronized (this.f281711a) {
            if (!this.f281717g) {
                return;
            }
            this.f281717g = false;
            this.f281718h = false;
            this.f281716f = 0L;
            Choreographer.getInstance().removeFrameCallback(this.f281719i);
            lm2.d.a(new Runnable() { // from class: jm2.c
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.richmedia.particlesystem.c.this.h();
                }
            });
            qm2.a aVar = this.f281721k;
            if (aVar != null) {
                aVar.e();
                this.f281721k = null;
            }
            km2.f fVar = this.f281720j;
            if (fVar != null) {
                fVar.d();
                this.f281720j = null;
            }
            InterfaceC8518c interfaceC8518c = this.f281723m;
            if (interfaceC8518c != null) {
                interfaceC8518c.onStop();
            }
        }
    }
}
