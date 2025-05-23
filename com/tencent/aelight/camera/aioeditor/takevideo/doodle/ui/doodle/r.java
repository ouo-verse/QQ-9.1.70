package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends q {
    public r(Context context, ShapeOperator.Shape shape, float f16, int i3) {
        super(context, shape, f16, i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q
    protected void z(Canvas canvas, RectF rectF) {
        y(canvas, rectF.centerX(), rectF.centerY() + (((int) Math.ceil(this.f68455q.descent() - this.f68455q.ascent())) / 2) + this.P, false);
    }
}
