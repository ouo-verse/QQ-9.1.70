package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSignVideoView extends SpriteGLView {
    static IPatchRedirector $redirector_;
    private String K;
    private VideoSprite L;
    private int M;
    private VideoSprite.b N;
    private boolean P;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class SignVideoSprite extends VideoSprite {
        static IPatchRedirector $redirector_;
        private int N0;

        public SignVideoSprite(SpriteGLView spriteGLView, Context context, boolean z16) {
            super(spriteGLView, context, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopSignVideoView.this, spriteGLView, context, Boolean.valueOf(z16));
            } else {
                this.N0 = GLES20.glGetUniformLocation(this.f291281u0, "v_isShowCover");
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
        protected void O(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (this.f291282v0 == null) {
                return;
            }
            a0(i3, i16);
            GLES20.glEnableVertexAttribArray(this.f291267g0);
            GLES20.glVertexAttribPointer(this.f291267g0, 2, 5126, false, 0, (Buffer) this.f291282v0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f291280t0[0]);
            GLES20.glUniform1i(this.f291264d0, 0);
            GLES20.glEnableVertexAttribArray(this.f291265e0);
            GLES20.glVertexAttribPointer(this.f291265e0, 4, 5126, false, 0, (Buffer) this.f291274n0);
            if (this.f291277q0) {
                GLES20.glUniform1i(this.f291269i0, 1);
                GLES20.glEnableVertexAttribArray(this.f291266f0);
                GLES20.glVertexAttribPointer(this.f291266f0, 4, 5126, false, 0, (Buffer) this.f291275o0);
            } else {
                GLES20.glUniform1i(this.f291269i0, 0);
            }
            GLES20.glUniform1i(this.N0, TroopSignVideoView.this.P ? 1 : 0);
            GLES20.glUniformMatrix4fv(this.f291268h0, 1, false, this.f291284x0, 0);
            GLES20.glDrawElements(4, VideoSprite.M0.length, 5123, this.f291283w0);
            GLES20.glDisableVertexAttribArray(this.f291267g0);
            GLES20.glDisableVertexAttribArray(this.f291265e0);
            GLES20.glDisableVertexAttribArray(this.f291266f0);
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
        public String P() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Context context = TroopSignVideoView.this.getContext();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("troop");
            String str = File.separator;
            sb5.append(str);
            sb5.append("shaders");
            sb5.append(str);
            sb5.append("FragmentShaderVideoForTroopSign.glsl");
            return com.tencent.mobileqq.surfaceviewaction.util.a.c(context, sb5.toString());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
        public void a0(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (TroopSignVideoView.this.M == 0) {
                TroopSignVideoView.this.M = i16;
            }
            super.a0(i3, TroopSignVideoView.this.M);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
        public void b0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                super.b0();
                this.N0 = GLES20.glGetUniformLocation(this.f291281u0, "v_isShowCover");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements VideoSprite.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSignVideoView.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (TroopSignVideoView.this.N != null) {
                TroopSignVideoView.this.N.a();
            }
        }
    }

    public TroopSignVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.M = 0;
            this.P = false;
        }
    }

    public void A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        VideoSprite videoSprite = this.L;
        if (videoSprite == null || videoSprite.R() || !str.equals(this.K)) {
            com.tencent.mobileqq.surfaceviewaction.gl.d dVar = this.L;
            if (dVar != null) {
                r(dVar);
            }
            this.K = str;
            SignVideoSprite signVideoSprite = new SignVideoSprite(this, getContext(), true);
            this.L = signVideoSprite;
            signVideoSprite.Z = true;
            signVideoSprite.f291261a0 = true;
            i(signVideoSprite);
        }
        this.L.W(true);
        this.L.T(str);
        this.L.Y(new a());
        if (QLog.isColorLevel()) {
            QLog.d("SpriteGLView", 2, "SpriteGLView->play");
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        VideoSprite videoSprite = this.L;
        if (videoSprite != null && !videoSprite.R()) {
            this.L.n();
        } else {
            String str = this.K;
            if (str != null) {
                A(str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpriteGLView", 2, "SpriteGLView->resume");
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpriteGLView", 2, "onVisibilityChanged: visibility = " + i3);
        }
        if (i3 == 0) {
            B();
        } else if (i3 == 4) {
            z();
        } else if (i3 == 8) {
            u();
        }
        super.onVisibilityChanged(view, i3);
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.K = str;
        }
    }

    public void setOnPlayedListener(VideoSprite.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.N = bVar;
        }
    }

    public void setShowCover(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.P = z16;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        VideoSprite videoSprite = this.L;
        if (videoSprite != null) {
            videoSprite.l();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
        }
    }
}
