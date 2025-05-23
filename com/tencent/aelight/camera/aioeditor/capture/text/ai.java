package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ai {

    /* renamed from: b, reason: collision with root package name */
    private aj f66985b;

    /* renamed from: d, reason: collision with root package name */
    private c f66987d;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<aa> f66984a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f66986c = 0;

    /* renamed from: e, reason: collision with root package name */
    private float f66988e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f66989f = 0.0f;

    public ai(int i3) {
        if (i3 == 1) {
            this.f66985b = new z();
        } else if (i3 != 0) {
            throw new IllegalArgumentException("TextDrawImplement init failed");
        }
    }

    public void b(Canvas canvas, int i3, int i16) {
        c cVar;
        c cVar2;
        if (this.f66986c == 2 && (cVar2 = this.f66987d) != null) {
            cVar2.b(canvas, this.f66984a, i3, i16);
        }
        Iterator<aa> it = this.f66984a.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            if (this.f66986c == 1 && (cVar = this.f66987d) != null) {
                next.a(canvas, cVar, i3, i16);
            }
            next.b(canvas, i3, i16);
        }
    }

    public int c() {
        return this.f66984a.size();
    }

    public int d(int i3) {
        return this.f66984a.get(i3).f66921e.length();
    }

    public RectF e(int i3) {
        return this.f66984a.get(i3).f67006c;
    }

    public float g() {
        RectF rectF = new RectF();
        rectF.left = Float.MAX_VALUE;
        rectF.top = Float.MAX_VALUE;
        rectF.right = Float.MIN_VALUE;
        rectF.bottom = Float.MIN_VALUE;
        for (int i3 = 0; i3 < this.f66984a.size(); i3++) {
            aa aaVar = this.f66984a.get(i3);
            float f16 = rectF.left;
            RectF rectF2 = aaVar.f67006c;
            float f17 = rectF2.left;
            if (f16 > f17) {
                rectF.left = f17;
            }
            float f18 = rectF.right;
            float f19 = rectF2.right;
            if (f18 < f19) {
                rectF.right = f19;
            }
            float f26 = rectF.top;
            float f27 = rectF2.top;
            if (f26 > f27) {
                rectF.top = f27;
            }
            float f28 = rectF.bottom;
            float f29 = rectF2.bottom;
            if (f28 < f29) {
                rectF.bottom = f29;
            }
        }
        return rectF.height();
    }

    public float h() {
        RectF rectF = new RectF();
        rectF.left = Float.MAX_VALUE;
        rectF.top = Float.MAX_VALUE;
        rectF.right = Float.MIN_VALUE;
        rectF.bottom = Float.MIN_VALUE;
        for (int i3 = 0; i3 < this.f66984a.size(); i3++) {
            aa aaVar = this.f66984a.get(i3);
            float f16 = rectF.left;
            RectF rectF2 = aaVar.f67006c;
            float f17 = rectF2.left;
            if (f16 > f17) {
                rectF.left = f17;
            }
            float f18 = rectF.right;
            float f19 = rectF2.right;
            if (f18 < f19) {
                rectF.right = f19;
            }
            float f26 = rectF.top;
            float f27 = rectF2.top;
            if (f26 > f27) {
                rectF.top = f27;
            }
            float f28 = rectF.bottom;
            float f29 = rectF2.bottom;
            if (f28 < f29) {
                rectF.bottom = f29;
            }
        }
        return rectF.width();
    }

    public void a(d dVar) {
        for (int i3 = 0; i3 < this.f66984a.size(); i3++) {
            dVar.a(i3, this.f66984a.get(i3));
        }
    }

    public void j(c cVar) {
        this.f66986c = 1;
        this.f66987d = cVar;
    }

    public void k(c cVar) {
        this.f66986c = 2;
        this.f66987d = cVar;
    }

    public void i(CharSequence charSequence, int i3, int i16, TextPaint textPaint) {
        int i17;
        TextPaint textPaint2;
        if (textPaint == null) {
            textPaint2 = new TextPaint();
            i17 = i16;
        } else {
            i17 = i16;
            textPaint2 = textPaint;
        }
        textPaint2.setTextSize(i17);
        int i18 = 0;
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint2, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f66984a.clear();
        int i19 = 0;
        float f16 = 0.0f;
        while (i19 < staticLayout.getLineCount()) {
            RectF rectF = new RectF();
            String charSequence2 = charSequence.subSequence(staticLayout.getLineStart(i19), staticLayout.getLineEnd(i19)).toString();
            Paint.FontMetrics fontMetrics = textPaint2.getFontMetrics();
            float measureText = textPaint2.measureText(charSequence2, i18, charSequence2.length());
            float abs = Math.abs(fontMetrics.bottom - fontMetrics.top);
            float abs2 = Math.abs(fontMetrics.ascent);
            rectF.left = 0.0f;
            rectF.right = 0.0f + measureText;
            rectF.top = f16;
            float f17 = f16 + abs;
            rectF.bottom = f17;
            this.f66984a.add(new aa(0, 0, textPaint2, charSequence2, rectF, abs2));
            if (this.f66988e < measureText) {
                this.f66988e = measureText;
            }
            this.f66989f += abs;
            i19++;
            f16 = f17;
            i18 = 0;
        }
    }

    public RectF f(int i3, int i16) {
        int i17 = i3 - 1;
        int i18 = i16 - 1;
        if (i17 < 0 || i17 >= this.f66984a.size() || i18 < 0 || i18 >= this.f66984a.size() || i18 < i17) {
            return null;
        }
        RectF rectF = new RectF();
        rectF.left = Float.MAX_VALUE;
        rectF.top = Float.MAX_VALUE;
        rectF.right = Float.MIN_VALUE;
        rectF.bottom = Float.MIN_VALUE;
        while (i17 <= i18) {
            aa aaVar = this.f66984a.get(i17);
            float f16 = rectF.left;
            RectF rectF2 = aaVar.f67006c;
            float f17 = rectF2.left;
            if (f16 > f17) {
                rectF.left = f17;
            }
            float f18 = rectF.right;
            float f19 = rectF2.right;
            if (f18 < f19) {
                rectF.right = f19;
            }
            float f26 = rectF.top;
            float f27 = rectF2.top;
            if (f26 > f27) {
                rectF.top = f27;
            }
            float f28 = rectF.bottom;
            float f29 = rectF2.bottom;
            if (f28 < f29) {
                rectF.bottom = f29;
            }
            i17++;
        }
        return rectF;
    }
}
