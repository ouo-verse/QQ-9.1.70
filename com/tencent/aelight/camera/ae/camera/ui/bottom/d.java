package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.graphics.Point;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        int a(int i3, int i16);

        void b(int i3, lf0.a aVar);

        float c(Point point, int i3, int i16);

        int d(int i3);

        int e(int i3);

        boolean f(Point point, int i3, int i16, int i17, int i18);

        int g(int i3, int i16);

        void h(com.tencent.aelight.camera.ae.camera.ui.b bVar, int i3, Point point);

        boolean i();

        void j(Point point, int i3, Point point2);

        int k(int i3, int i16);

        boolean l();

        boolean m(com.tencent.aelight.camera.ae.camera.ui.bottom.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b extends d {
        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d
        a a() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract a a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    protected static class c implements a {
        protected c() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public void b(int i3, lf0.a aVar) {
            aVar.o(i3);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public float c(Point point, int i3, int i16) {
            return i3 - point.x;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public int d(int i3) {
            return 0;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public boolean f(Point point, int i3, int i16, int i17, int i18) {
            int i19 = point.x;
            return i19 - i3 < i17 + i18 && i19 + i3 > (-i18);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public void h(com.tencent.aelight.camera.ae.camera.ui.b bVar, int i3, Point point) {
            point.set(point.x + bVar.a(i3), point.y);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public boolean i() {
            return true;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public void j(Point point, int i3, Point point2) {
            point2.set(point.x - i3, point.y);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public boolean l() {
            return false;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public boolean m(com.tencent.aelight.camera.ae.camera.ui.bottom.a aVar) {
            View l3 = aVar.l();
            View m3 = aVar.m();
            return (aVar.getDecoratedLeft(l3) > (-aVar.k()) && aVar.getPosition(l3) > 0) || (aVar.getDecoratedRight(m3) < aVar.getWidth() + aVar.k() && aVar.getPosition(m3) < aVar.getItemCount() - 1);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public int e(int i3) {
            return i3;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public int a(int i3, int i16) {
            return i3;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public int g(int i3, int i16) {
            return i3;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.d.a
        public int k(int i3, int i16) {
            return i3;
        }
    }
}
