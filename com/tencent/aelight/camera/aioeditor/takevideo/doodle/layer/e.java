package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.s;
import com.tencent.widget.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends d {
    public e(DoodleView doodleView) {
        super(doodleView);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d
    protected void l() {
        this.L = new s(this.f437142d);
        this.Q = new ScaleGestureDetector(this.f437142d, new d.a());
    }
}
