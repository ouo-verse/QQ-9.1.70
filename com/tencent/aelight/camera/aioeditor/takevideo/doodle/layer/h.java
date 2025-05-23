package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends g {
    public h(DoodleView doodleView) {
        super(doodleView);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g
    public DynamicTextItem K(g.b bVar, SegmentKeeper segmentKeeper, int i3) {
        g.d dVar;
        int size = this.X.size();
        if (size >= g.f67987k0) {
            return null;
        }
        if (bVar != null) {
            dVar = new g.d(bVar);
        } else {
            dVar = new g.d();
        }
        dVar.I = i3;
        dVar.f453065u = new SegmentKeeper(segmentKeeper);
        dVar.f453050f.set(this.J);
        float f16 = g.f67982f0 * size;
        dVar.f453048d = f16;
        dVar.f453049e = f16;
        this.X.add(dVar);
        DynamicTextItem dynamicTextItem = dVar.f68001z;
        this.W = dVar;
        return dynamicTextItem;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g
    public void U() {
        if (!isEmpty()) {
            f0(6);
            g.c cVar = this.W;
            if (cVar != null) {
                g.d dVar = new g.d(cVar);
                this.f67990b0 = dVar;
                dVar.j();
                this.f67990b0.f();
                return;
            }
            return;
        }
        g.a aVar = this.V;
        if (aVar != null) {
            aVar.d(1.0f);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g
    protected void l() {
        this.P = BaseAIOUtils.f(50.0f, this.f437142d.getResources());
        this.M = zr.a.f(this.f437142d);
        this.L = 1;
        this.K = 1;
        zr.d dVar = new zr.d();
        this.Q = dVar;
        dVar.y(6.0f);
        this.Q.z(0.2f);
        this.Q.A(true);
        Paint paint = new Paint();
        this.Z = paint;
        paint.setAntiAlias(true);
        this.Z.setStyle(Paint.Style.STROKE);
        this.Z.setColor(-1);
        this.Z.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.f67989a0 = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        g.f67985i0 = ViewConfiguration.get(this.f437142d).getScaledTouchSlop();
        if (g.f67986j0 == 270 && Z()) {
            g.f67986j0 = 540;
        }
    }
}
