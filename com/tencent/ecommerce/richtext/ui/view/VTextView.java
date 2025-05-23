package com.tencent.ecommerce.richtext.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.ecommerce.richtext.ui.dom.style.o;
import com.tencent.ecommerce.richtext.utils.a;
import com.tencent.ecommerce.richtext.utils.e;
import java.lang.ref.WeakReference;
import jk0.c;
import lk0.b;
import lk0.d;
import lk0.h;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    WeakReference<c> f105425d;

    /* renamed from: e, reason: collision with root package name */
    private Layout f105426e;

    /* renamed from: f, reason: collision with root package name */
    private int f105427f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f105428h;

    public VTextView(Context context) {
        super(context);
        setIncludeFontPadding(false);
    }

    private b c() {
        c b16 = b();
        if (b16 == null) {
            return null;
        }
        return b16.m();
    }

    private int e() {
        b c16 = c();
        if (c16 == null) {
            return -1;
        }
        h g06 = c16.g0();
        if (!g06.containsKey("textStrokeColor")) {
            return -1;
        }
        return a.c(e.p(g06.get("textStrokeColor"), ""));
    }

    private float f() {
        b c16 = c();
        if (c16 == null) {
            return 0.0f;
        }
        return e.k(c16.g0().get("textStrokeWidth"), Float.valueOf(0.0f));
    }

    private boolean g() {
        b c16 = c();
        if (c16 == null) {
            return false;
        }
        h g06 = c16.g0();
        if (!g06.containsKey("textStrokeWidth") && !g06.containsKey("textStrokeColor")) {
            return false;
        }
        return true;
    }

    private void h(Layout layout, Canvas canvas) {
        if (layout != null && canvas != null) {
            int e16 = e();
            if (e16 == -1) {
                e16 = -16777216;
            }
            float f16 = f();
            TextPaint paint = layout.getPaint();
            if (paint == null) {
                layout.draw(canvas);
                return;
            }
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            Paint.Style style = paint.getStyle();
            paint.setColor(e16);
            paint.setStrokeWidth(f16);
            paint.setStyle(Paint.Style.STROKE);
            layout.draw(canvas);
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
            paint.setStyle(style);
            layout.draw(canvas);
        }
    }

    public void a(c cVar) {
        this.f105425d = new WeakReference<>(cVar);
    }

    public c b() {
        WeakReference<c> weakReference = this.f105425d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Layout d() {
        return this.f105426e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f105428h) {
            return;
        }
        canvas.save();
        if (b() != null && b().m() != null) {
            o m3 = b().m().m();
            Layout d16 = d();
            if (d16 == null && b() != null && (b().m() instanceof d)) {
                ((d) b().m()).b1();
                ((d) b().m()).e1();
                b().O(b().m().e0());
                d16 = d();
            }
            if (d16 != null) {
                if (m3 != null) {
                    canvas.translate(m3.a(0), m3.a(1));
                }
                if (g()) {
                    h(d16, canvas);
                } else {
                    d16.draw(canvas);
                }
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f105428h) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    setHighlightColor(getResources().getColor(17170445));
                }
            } else {
                setHighlightColor(Color.parseColor("#22000000"));
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLayout(Layout layout) {
        this.f105426e = layout;
    }

    public void setRichText(boolean z16, int i3) {
        this.f105428h = z16;
        this.f105427f = i3;
    }

    public void setTextLayout(Layout layout, float f16, float f17) {
        setTextLayout(layout);
    }

    public void setTextLayout(Layout layout) {
        this.f105426e = layout;
        if (layout != null) {
            setContentDescription(layout.getText());
            if (this.f105428h) {
                setIncludeFontPadding(false);
                setLineSpacing(this.f105427f, 1.0f);
                setText(layout.getText());
                if (b() != null && b().m() != null && (b().m() instanceof d) && ((d) b().m()).f414918k0) {
                    setFocusable(false);
                    setMovementMethod(LinkMovementMethod.getInstance());
                }
                o m3 = b().m().m();
                if (m3 != null) {
                    setPadding((int) m3.a(0), (int) m3.a(1), (int) m3.a(2), (int) m3.a(3));
                }
                setHighlightColor(Color.parseColor("#22000000"));
            }
        }
        WeakReference<c> weakReference = this.f105425d;
        if (weakReference != null) {
            weakReference.get();
        }
    }

    public VTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
