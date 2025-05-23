package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s extends ShapeOperator {
    public s(Context context) {
        super(context);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator
    protected q j(ShapeOperator.Shape shape, Context context, float f16, int i3, q.d dVar) {
        r rVar = new r(context, shape, f16, i3);
        rVar.e0(dVar);
        return rVar;
    }
}
