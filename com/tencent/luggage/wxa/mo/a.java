package com.tencent.luggage.wxa.mo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements LineBackgroundSpan {

    /* renamed from: a, reason: collision with root package name */
    public View f134782a;

    /* renamed from: b, reason: collision with root package name */
    public final int f134783b;

    /* renamed from: c, reason: collision with root package name */
    public int f134784c;

    /* renamed from: d, reason: collision with root package name */
    public int f134785d;

    /* renamed from: e, reason: collision with root package name */
    public Rect f134786e = new Rect();

    public a(View view, int i3, int i16, int i17) {
        this.f134782a = view;
        this.f134783b = i3;
        this.f134784c = i16;
        this.f134785d = i17;
    }

    public void a(int i3, int i16) {
        this.f134784c = i3;
        this.f134785d = i16;
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, CharSequence charSequence, int i26, int i27, int i28) {
        float lineLeft;
        float lineWidth;
        if (this.f134785d >= i26 && this.f134784c <= i27) {
            int color = paint.getColor();
            int lineForOffset = TextLayoutUtil.getLineForOffset(this.f134782a, this.f134784c);
            int lineForOffset2 = TextLayoutUtil.getLineForOffset(this.f134782a, this.f134785d);
            if (lineForOffset <= i28 && i28 <= lineForOffset2) {
                if (lineForOffset == i28) {
                    lineLeft = TextLayoutUtil.getPrimaryHorizontal(this.f134782a, this.f134784c);
                } else {
                    lineLeft = TextLayoutUtil.getLineLeft(this.f134782a, i28);
                }
                i3 = (int) lineLeft;
                if (lineForOffset2 == i28) {
                    lineWidth = TextLayoutUtil.getPrimaryHorizontal(this.f134782a, this.f134785d);
                } else {
                    lineWidth = TextLayoutUtil.getLineWidth(this.f134782a, i28);
                }
                i16 = (int) lineWidth;
            }
            int descent = (int) (i18 + paint.descent());
            Rect rect = this.f134786e;
            rect.left = i3;
            if (this.f134784c == i26) {
                rect.left = i3 - 4;
            }
            rect.right = i16;
            if (this.f134785d == i16) {
                rect.right = i16 + 4;
            }
            rect.top = i17;
            rect.bottom = descent;
            paint.setColor(this.f134783b);
            canvas.drawRect(this.f134786e, paint);
            paint.setColor(color);
        }
    }
}
