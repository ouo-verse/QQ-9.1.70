package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleTextureView extends GLTextureView implements GLSurfaceView.Renderer, a {
    int M;
    int N;
    d P;

    public DoodleTextureView(Context context) {
        super(context);
        this.M = 320;
        this.N = 480;
        super.setEGLContextClientVersion(2);
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        super.setOpaque(false);
        super.setRenderer(this);
        super.setRenderMode(0);
    }

    public void N() {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleTextureView", 2, "onDestroy start");
        }
        I(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleTextureView.2
            @Override // java.lang.Runnable
            public void run() {
                d dVar = DoodleTextureView.this.P;
                if (dVar != null) {
                    dVar.C();
                    PersonalityOperator personalityOperator = (PersonalityOperator) DoodleTextureView.this.P.l(102);
                    if (personalityOperator != null) {
                        personalityOperator.j();
                    }
                    DoodleTextureView.this.P = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleTextureView", 2, "onDestroy end");
                }
            }
        });
    }

    public void O(int i3) {
        d dVar = this.P;
        if (dVar != null) {
            dVar.B(i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a
    public void a() {
        requestRender();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.a
    public void b(Runnable runnable) {
        I(runnable);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        d dVar = this.P;
        if (dVar != null) {
            dVar.w();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        PersonalityOperator personalityOperator;
        this.M = i3;
        this.N = i16;
        d dVar = this.P;
        if (dVar == null || (personalityOperator = (PersonalityOperator) dVar.l(102)) == null) {
            return;
        }
        personalityOperator.p(i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        d dVar = this.P;
        if (dVar != null) {
            dVar.s();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    public void setOpController(d dVar) {
        this.P = dVar;
        dVar.J(this);
        super.I(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                PersonalityOperator personalityOperator = (PersonalityOperator) DoodleTextureView.this.P.l(102);
                if (personalityOperator != null) {
                    personalityOperator.n();
                    DoodleTextureView doodleTextureView = DoodleTextureView.this;
                    personalityOperator.p(doodleTextureView.M, doodleTextureView.N);
                    DoodleTextureView.this.P.F();
                    DoodleTextureView.this.a();
                }
            }
        });
    }
}
