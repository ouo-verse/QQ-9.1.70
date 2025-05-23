package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class y extends c {

    /* renamed from: b, reason: collision with root package name */
    private final int f67174b;

    public y(int i3, int i16) {
        Paint paint = new Paint();
        this.f67003a = paint;
        paint.setAntiAlias(true);
        this.f67003a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67003a.setColor(i3);
        this.f67174b = i16;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.c
    public void a(Canvas canvas, RectF rectF, int i3, int i16) {
        if (canvas == null || rectF == null) {
            return;
        }
        float f16 = rectF.left;
        int i17 = this.f67174b;
        float f17 = i3;
        float f18 = i16;
        canvas.drawRect((f16 - i17) + f17, (rectF.top - i17) + f18, rectF.right + i17 + f17, rectF.bottom + i17 + f18, this.f67003a);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.c
    public void b(Canvas canvas, ArrayList<aa> arrayList, int i3, int i16) {
    }
}
