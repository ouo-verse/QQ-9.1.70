package com.qzone.album.business.photolist.ui;

import android.view.View;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import s4.e;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ViewerModelController f43308a;

    /* renamed from: b, reason: collision with root package name */
    private e.a f43309b;

    public b(ViewerModelController viewerModelController) {
        this.f43308a = viewerModelController;
        if (viewerModelController != null) {
            b();
        }
    }

    private void b() {
        this.f43309b = new a();
    }

    public e.a c() {
        return this.f43309b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements e.a {
        a() {
        }

        @Override // s4.e.a
        public float a(int i3, int i16, int i17) {
            int i18 = i16 - ((BasePhotoModelController.f42936w2 / 2) * (-3));
            if (i17 == 0) {
                return 0.0f;
            }
            float f16 = (i3 - i18) / i17;
            double d16 = f16;
            if (d16 < 1.5d) {
                return 0.0f;
            }
            if (d16 >= 1.5d) {
                return 1.0f;
            }
            return f16;
        }

        @Override // s4.e.a
        public boolean b(int i3, int i16, int i17) {
            return true;
        }

        @Override // s4.e.a
        public void c(View view, float f16, int i3, float f17) {
            if (view == null || b.this.f43308a.f42970k0 != 0) {
                return;
            }
            if (b.this.f43308a.i3() || b.this.f43308a.e3()) {
                double d16 = f16;
                if (d16 == 0.0d) {
                    view.setVisibility(0);
                } else if (d16 == 1.0d) {
                    view.setVisibility(8);
                }
            }
        }
    }
}
