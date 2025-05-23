package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;

/* compiled from: P */
/* loaded from: classes32.dex */
public class aa extends e {

    /* renamed from: e, reason: collision with root package name */
    protected String f66921e;

    /* renamed from: f, reason: collision with root package name */
    protected float f66922f;

    public aa(int i3, int i16, TextPaint textPaint, String str, RectF rectF, float f16) {
        super(i3, i16, textPaint, rectF);
        this.f66921e = str;
        this.f66922f = f16;
    }

    public void a(Canvas canvas, c cVar, int i3, int i16) {
        cVar.a(canvas, this.f67006c, i3, i16);
    }

    public void b(Canvas canvas, int i3, int i16) {
        if (canvas == null) {
            return;
        }
        String str = this.f66921e;
        int length = str.length();
        RectF rectF = this.f67006c;
        canvas.drawText(str, 0, length, rectF.left + i3, i16 + this.f66922f + rectF.top, (Paint) this.f67007d);
    }
}
