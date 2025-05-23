package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class a extends tr.a {
    public static final String K = "a";

    public a(DoodleView doodleView) {
        super(doodleView);
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        hd0.c.a(K, "EmptyLayer handle touch event.");
        return false;
    }

    @Override // tr.a
    public String h() {
        return K;
    }

    @Override // tr.d
    public boolean isEmpty() {
        return true;
    }

    @Override // tr.a
    public boolean m(long j3) {
        return true;
    }

    @Override // tr.a
    public boolean q(MotionEvent motionEvent) {
        return false;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
    }

    @Override // tr.d
    public void clear() {
    }

    @Override // tr.a
    public void v(Canvas canvas, float f16) {
    }
}
