package com.qzone.widget.cardview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
class a implements c {
    private d k(b bVar) {
        return (d) bVar.getCardBackground();
    }

    @Override // com.qzone.widget.cardview.c
    public void a(b bVar, float f16) {
        k(bVar).f(f16, bVar.getUseCompatPadding(), bVar.getPreventCornerOverlap());
        j(bVar);
    }

    @Override // com.qzone.widget.cardview.c
    public void b(b bVar) {
        a(bVar, l(bVar));
    }

    @Override // com.qzone.widget.cardview.c
    public void c(b bVar, ColorStateList colorStateList) {
        k(bVar).e(colorStateList);
    }

    @Override // com.qzone.widget.cardview.c
    public void d(b bVar) {
        a(bVar, l(bVar));
    }

    @Override // com.qzone.widget.cardview.c
    public float e(b bVar) {
        return m(bVar) * 2.0f;
    }

    @Override // com.qzone.widget.cardview.c
    public void f(b bVar, float f16) {
        bVar.getCardView().setElevation(f16);
    }

    @Override // com.qzone.widget.cardview.c
    public void g(b bVar, Context context, ColorStateList colorStateList, float f16, float f17, float f18) {
        bVar.setCardBackground(new d(colorStateList, f16));
        View cardView = bVar.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f17);
        a(bVar, f18);
    }

    @Override // com.qzone.widget.cardview.c
    public float h(b bVar) {
        return m(bVar) * 2.0f;
    }

    @Override // com.qzone.widget.cardview.c
    public void i(b bVar, float f16) {
        k(bVar).g(f16);
    }

    @Override // com.qzone.widget.cardview.c
    public void j(b bVar) {
        if (!bVar.getUseCompatPadding()) {
            bVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float l3 = l(bVar);
        float m3 = m(bVar);
        int ceil = (int) Math.ceil(e.a(l3, m3, bVar.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(e.b(l3, m3, bVar.getPreventCornerOverlap()));
        bVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public float l(b bVar) {
        return k(bVar).b();
    }

    public float m(b bVar) {
        return k(bVar).c();
    }

    @Override // com.qzone.widget.cardview.c
    public void initStatic() {
    }
}
