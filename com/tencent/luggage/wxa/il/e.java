package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.luggage.wxa.kj.f0;
import com.tencent.luggage.wxa.kj.g1;
import com.tencent.luggage.wxa.tn.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends AbsoluteLayout implements g1, f0, com.tencent.luggage.wxa.hp.a {

    /* renamed from: a, reason: collision with root package name */
    public final AbsoluteLayout f130652a;

    /* renamed from: b, reason: collision with root package name */
    public final List f130653b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
    }

    public e(Context context) {
        super(context);
        this.f130653b = new LinkedList();
        this.f130652a = this;
        a();
    }

    public final void a() {
    }

    @Override // com.tencent.luggage.wxa.kj.g1
    public void b(g1.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f130653b.remove(aVar);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    @Override // com.tencent.luggage.wxa.kj.f0
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        w.g("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        if (this.f130652a != null) {
            a(false, view.getWidth(), view.getHeight());
            this.f130652a.scrollTo(i3, i16);
        }
        Iterator it = this.f130653b.iterator();
        while (it.hasNext()) {
            ((g1.a) it.next()).a(this, i3, i16, i17, i18);
        }
    }

    public void setCapsuleBarBackgroundRenderer(a aVar) {
        if (aVar == null) {
            return;
        }
        invalidate();
    }

    @Override // com.tencent.luggage.wxa.kj.g1
    public void a(g1.a aVar) {
        if (aVar == null || this.f130653b.contains(aVar)) {
            return;
        }
        this.f130653b.add(aVar);
    }

    public final boolean a(boolean z16, int i3, int i16) {
        AbsoluteLayout absoluteLayout = this.f130652a;
        if (absoluteLayout == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = absoluteLayout.getLayoutParams();
        if (layoutParams == null) {
            this.f130652a.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
            return true;
        }
        if (i3 == layoutParams.width && i16 == layoutParams.height) {
            return z16;
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f130652a.setLayoutParams(layoutParams);
        return true;
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        draw(canvas);
        return true;
    }
}
