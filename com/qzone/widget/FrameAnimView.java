package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.widget.util.AbCircleFrameAnimDirector;
import com.qzone.widget.util.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class FrameAnimView extends View implements c.d {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.widget.util.c f60410d;

    /* renamed from: e, reason: collision with root package name */
    private int f60411e;

    /* renamed from: f, reason: collision with root package name */
    private int f60412f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f60413h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60414i;

    /* renamed from: m, reason: collision with root package name */
    private c.d f60415m;

    public FrameAnimView(Context context) {
        super(context);
        c(null, 0, 0);
    }

    private void c(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.H2, i3, i16);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        String string = obtainStyledAttributes.getString(2);
        int i17 = obtainStyledAttributes.getInt(4, 1);
        int i18 = obtainStyledAttributes.getInt(0, 1);
        int i19 = obtainStyledAttributes.getInt(3, 16);
        this.f60414i = obtainStyledAttributes.getBoolean(5, false);
        Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
        if (bitmap != null) {
            d(bitmap, i17, i18, i19);
        } else {
            d(string, i17, i18, i19);
        }
        obtainStyledAttributes.recycle();
    }

    private void g() {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar == null) {
            return;
        }
        cVar.v();
        this.f60410d.n();
    }

    private void h(com.qzone.widget.util.c cVar) {
        this.f60410d = cVar;
        cVar.q(this.f60414i);
        this.f60410d.r(this);
    }

    @Override // com.qzone.widget.util.c.d
    public void a(int i3) {
        invalidate();
        c.d dVar = this.f60415m;
        if (dVar != null) {
            dVar.a(i3);
        }
    }

    public void b() {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar != null) {
            cVar.d();
        }
    }

    public boolean e() {
        com.qzone.widget.util.c cVar = this.f60410d;
        return cVar != null && cVar.l();
    }

    public void f(boolean z16) {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar == null) {
            return;
        }
        if (z16) {
            cVar.u();
        } else {
            cVar.s(0, cVar.j() - 1);
        }
    }

    public void i() {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar == null) {
            return;
        }
        cVar.e(canvas, this.f60413h);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60411e && height == this.f60412f) {
            return;
        }
        this.f60411e = width;
        this.f60412f = height;
        this.f60413h = new Rect(0, 0, this.f60411e, this.f60412f);
    }

    public void setAnimImage(Bitmap bitmap, int i3, int i16, int i17) {
        g();
        d(bitmap, i3, i16, i17);
    }

    public void setFrameListener(c.d dVar) {
        this.f60415m = dVar;
    }

    public void setOnEndListener(c.InterfaceC0506c interfaceC0506c) {
        com.qzone.widget.util.c cVar = this.f60410d;
        if (cVar != null) {
            cVar.p(interfaceC0506c);
        }
    }

    public FrameAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public void setAnimImage(List<String> list, c.b bVar, int i3) {
        g();
        if (list == null || list.isEmpty() || bVar == null) {
            return;
        }
        if (i3 < 1) {
            i3 = 16;
        }
        h(new com.qzone.widget.util.c(list, bVar, i3));
    }

    public FrameAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(attributeSet, i3, 0);
    }

    public void setAnimImage(List<String> list, c.b bVar, int i3, int i16, int i17) {
        g();
        if (list == null || list.isEmpty() || bVar == null) {
            return;
        }
        if (i3 < 1) {
            i3 = 16;
        }
        AbCircleFrameAnimDirector abCircleFrameAnimDirector = new AbCircleFrameAnimDirector(list, bVar, i3);
        abCircleFrameAnimDirector.H(i16, i17);
        h(abCircleFrameAnimDirector);
    }

    private void d(Object obj, int i3, int i16, int i17) {
        if (obj == null) {
            return;
        }
        int i18 = i3 < 1 ? 1 : i3;
        int i19 = i16 < 1 ? 1 : i16;
        if (i17 < 1) {
            i17 = 16;
        }
        int i26 = i17;
        if (obj instanceof Bitmap) {
            h(new com.qzone.widget.util.c((Bitmap) obj, i18, i19, i26));
        } else if (obj instanceof String) {
            h(new com.qzone.widget.util.c(getContext(), (String) obj, 1, i18, i19, i26));
        }
    }
}
