package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected Paint f67003a;

    public c() {
        Paint paint = new Paint();
        this.f67003a = paint;
        paint.setAntiAlias(true);
        this.f67003a.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public abstract void a(Canvas canvas, RectF rectF, int i3, int i16);

    public abstract void b(Canvas canvas, ArrayList<aa> arrayList, int i3, int i16);
}
