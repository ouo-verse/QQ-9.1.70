package com.tencent.av.opengl.ui;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends com.tencent.av.opengl.ui.b {
    private ArrayList<com.tencent.av.opengl.ui.b> I;
    private com.tencent.av.opengl.ui.b J;
    private b.InterfaceC0740b K;
    private Comparator<com.tencent.av.opengl.ui.b> L;
    protected boolean M;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0740b {
        a() {
        }

        @Override // com.tencent.av.opengl.ui.b.InterfaceC0740b
        public void a(com.tencent.av.opengl.ui.b bVar, int i3, int i16) {
            try {
                Collections.sort(c.this.I, c.this.L);
            } catch (ConcurrentModificationException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnZOrderChanged", 2, "OnZOrderChanged FATAL EXCEPTION:", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class b implements Comparator<com.tencent.av.opengl.ui.b> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.av.opengl.ui.b bVar, com.tencent.av.opengl.ui.b bVar2) {
            if (bVar != null && bVar2 != null) {
                if (bVar.o() >= bVar2.o()) {
                    return 1;
                }
                return -1;
            }
            QLog.d("SortComparator", 1, "SortComparator has null element");
            return 1;
        }
    }

    public c(Context context) {
        super(context);
        this.K = new a();
        this.L = new b();
        this.M = false;
    }

    @Override // com.tencent.av.opengl.ui.b
    public void C(ov.a aVar) {
        aVar.e(n() / 2, h() / 2, 0.0f);
        D(aVar);
        aVar.e((-n()) / 2, (-h()) / 2, 0.0f);
        f0(aVar);
    }

    protected boolean W() {
        return false;
    }

    public void X(com.tencent.av.opengl.ui.b bVar) {
        if (bVar.f74125h == null) {
            if (this.I == null) {
                this.I = new ArrayList<>();
            }
            this.I.add(bVar);
            bVar.f74125h = this;
            bVar.N(this.K);
            Collections.sort(this.I, this.L);
            GLRootView gLRootView = this.f74124g;
            if (gLRootView != null) {
                bVar.r(gLRootView);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(int i3, int i16) {
        v(i3, i16);
        int e06 = e0();
        for (int i17 = 0; i17 < e06; i17++) {
            d0(i17).v(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        w();
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            d0(i3).w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        x();
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            d0(i3).x();
        }
    }

    protected boolean b0(MotionEvent motionEvent, int i3, int i16, com.tencent.av.opengl.ui.b bVar, boolean z16) {
        if (!z16 || bVar.f74121d.contains(i3, i16)) {
            if (bVar.d(motionEvent)) {
                return true;
            }
            b.a aVar = this.f74142y;
            if (aVar != null && aVar.a(bVar, motionEvent)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void c0() {
        ArrayList<com.tencent.av.opengl.ui.b> arrayList = this.I;
        if (arrayList != null) {
            Collections.sort(arrayList, this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public boolean d(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        com.tencent.av.opengl.ui.b bVar = this.J;
        if (bVar != null) {
            if (action == 0) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                b0(obtain, x16, y16, this.J, false);
                this.J = null;
            } else {
                b0(motionEvent, x16, y16, bVar, false);
                if (action == 3 || action == 1) {
                    this.J = null;
                }
                return true;
            }
        }
        if (action == 0) {
            for (int e06 = e0() - 1; e06 >= 0; e06--) {
                com.tencent.av.opengl.ui.b d06 = d0(e06);
                if (d06.m() == 0 && b0(motionEvent, x16, y16, d06, true)) {
                    this.J = d06;
                    return true;
                }
            }
        }
        return super.d(motionEvent);
    }

    public com.tencent.av.opengl.ui.b d0(int i3) {
        ArrayList<com.tencent.av.opengl.ui.b> arrayList = this.I;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            return this.I.get(i3);
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public int e0() {
        ArrayList<com.tencent.av.opengl.ui.b> arrayList = this.I;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0(ov.a aVar) {
        if (!this.M && !W()) {
            int e06 = e0();
            for (int i3 = 0; i3 < e06; i3++) {
                i0(aVar, d0(i3));
            }
        }
    }

    public void g0() {
        if (this.I == null) {
            return;
        }
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            com.tencent.av.opengl.ui.b bVar = this.I.get(i3);
            if (this.J == bVar) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                d(obtain);
                obtain.recycle();
            }
            bVar.s();
            bVar.f74125h = null;
            bVar.N(null);
        }
        this.I.clear();
    }

    public boolean h0(com.tencent.av.opengl.ui.b bVar) {
        ArrayList<com.tencent.av.opengl.ui.b> arrayList = this.I;
        if (arrayList == null || !arrayList.remove(bVar)) {
            return false;
        }
        if (this.J == bVar) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            d(obtain);
            obtain.recycle();
        }
        bVar.s();
        bVar.f74125h = null;
        bVar.N(null);
        Collections.sort(this.I, this.L);
        return true;
    }

    public void i0(ov.a aVar, com.tencent.av.opengl.ui.b bVar) {
        if (!bVar.b()) {
            return;
        }
        aVar.k(-this.f74132o, -this.f74131n);
        bVar.C(aVar);
        aVar.k(-r0, -r1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(boolean z16) {
        this.M = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void r(GLRootView gLRootView) {
        this.f74124g = gLRootView;
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            d0(i3).r(gLRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void s() {
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            d0(i3).s();
        }
        this.f74124g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void t() {
        int e06 = e0();
        for (int i3 = 0; i3 < e06; i3++) {
            d0(i3).t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void z(int i3) {
        int e06 = e0();
        for (int i16 = 0; i16 < e06; i16++) {
            com.tencent.av.opengl.ui.b d06 = d0(i16);
            if (d06.m() == 0) {
                d06.z(i3);
            }
        }
    }
}
