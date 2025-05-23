package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes32.dex */
public class u extends w {
    private TextPaint A;
    private Map<Integer, Integer> B;
    private Map<Integer, Integer> C;

    /* renamed from: y, reason: collision with root package name */
    private int f67157y;

    /* renamed from: z, reason: collision with root package name */
    private StaticLayout f67158z;

    public u(int i3, List<String> list) {
        super(i3, list);
        this.B = new HashMap();
        this.C = new HashMap();
        this.f67167s.setAntiAlias(true);
        this.f67167s.setStyle(Paint.Style.FILL);
        this.f67167s.setColor(-1);
        this.f67167s.setTextSize(w.f67161v);
        if (this.A == null) {
            this.A = new TextPaint(this.f67167s);
        }
        this.A.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A.setStrokeWidth(2.0f);
        Z();
    }

    private void Z() {
        this.B.put(-14079703, -1275068417);
        this.B.put(-1, -869717719);
        this.B.put(-1027508, -27761);
        this.B.put(-1131223, -6997);
        this.B.put(-6038445, -5770946);
        this.B.put(-12147713, -4199169);
        this.B.put(-7768577, -5464321);
        this.B.put(-496479, -20274);
        this.C.put(-14079703, -2130706433);
        this.C.put(-1, -1003935447);
        this.C.put(-1027508, -62975);
        this.C.put(-1131223, -27136);
        this.C.put(-6038445, -5505226);
        this.C.put(-12147713, -16744193);
        this.C.put(-7768577, -10682121);
        this.C.put(-496479, -65439);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void I(Canvas canvas) {
        StaticLayout staticLayout = this.f66898k;
        if (staticLayout != null) {
            if (staticLayout.getLineCount() == 1) {
                canvas.save();
                canvas.translate(w() / 2.0f, m() / 2.0f);
                this.f67167s.setTextAlign(Paint.Align.CENTER);
                this.A.setTextAlign(Paint.Align.CENTER);
                float f16 = -((this.f67167s.descent() + this.f67167s.ascent()) / 2.0f);
                String k3 = super.k(0);
                if (TextUtils.isEmpty(k3)) {
                    k3 = "\u3000\u3000";
                }
                this.A.setAlpha(102);
                canvas.drawText(k3, 0.0f, f16, this.A);
                this.A.setAlpha(255);
                canvas.drawText(k3, 0.0f, f16, this.A);
                canvas.drawText(k3, 0.0f, f16, this.f67167s);
                if (super.H(0)) {
                    int measureText = (int) this.f67167s.measureText(k3);
                    int ceil = (int) Math.ceil(this.f67167s.descent() - this.f67167s.ascent());
                    RectF rectF = this.f67164p;
                    rectF.left = (-measureText) / 2.0f;
                    rectF.top = (-ceil) / 2.0f;
                    rectF.right = measureText / 2.0f;
                    rectF.bottom = ceil / 2.0f;
                    canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
                }
                canvas.restore();
                return;
            }
            this.f67167s.setTextAlign(Paint.Align.LEFT);
            this.A.setTextAlign(Paint.Align.LEFT);
            canvas.save();
            StaticLayout staticLayout2 = this.f67158z;
            if (staticLayout2 != null) {
                staticLayout2.getPaint().setAlpha(102);
                this.f67158z.draw(canvas);
                this.f67158z.getPaint().setAlpha(255);
                this.f67158z.draw(canvas);
            }
            this.f66898k.draw(canvas);
            if (super.H(0)) {
                float x16 = super.x(this.f66898k);
                float height = this.f66898k.getHeight();
                RectF rectF2 = this.f67164p;
                rectF2.left = 0.0f;
                rectF2.top = 0.0f;
                rectF2.right = x16;
                rectF2.bottom = height;
                canvas.drawRoundRect(rectF2, 6.0f, 6.0f, j());
            }
            canvas.restore();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w
    public int R() {
        return this.f67157y;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w
    public void V(int i3) {
        this.f67157y = i3;
        this.A.setColor(Y(this.B, i3));
        this.A.setShadowLayer(10.0f, 0.0f, 0.0f, Y(this.C, i3));
    }

    private int Y(Map<Integer, Integer> map, int i3) {
        Integer num;
        return (map == null || !map.containsKey(Integer.valueOf(i3)) || (num = map.get(Integer.valueOf(i3))) == null || num.intValue() <= 0) ? i3 : num.intValue();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        if (this.A == null) {
            this.A = new TextPaint(this.f67167s);
        }
        if (this.f66890c) {
            this.A.setTextSize(this.f66889b);
        }
        int length = k3.length();
        TextPaint textPaint = this.A;
        int i16 = w.f67162w;
        StaticLayout a16 = ag.a(k3, 0, length, textPaint, i16, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, this.f67165q);
        this.f67158z = a16;
        int lineCount = a16.getLineCount();
        int i17 = this.f67165q;
        if (lineCount > i17) {
            int lineEnd = this.f67158z.getLineEnd(i17 - 1);
            if (lineEnd < k3.length()) {
                k3 = ((Object) k3.subSequence(0, lineEnd)) + "";
            }
            String str2 = k3;
            this.f67158z = ag.a(str2, 0, str2.length(), this.A, i16, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, this.f67165q);
        }
    }
}
