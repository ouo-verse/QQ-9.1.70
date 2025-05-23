package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpriteVideoView extends SpriteGLView {
    static IPatchRedirector $redirector_;
    protected VideoSprite K;
    protected int L;

    public SpriteVideoView(Context context, boolean z16) {
        super(context, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
        } else {
            this.L = 0;
            v(z16);
        }
    }

    public void setCenterCrop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.K.f291262b0 = z16;
        }
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.K.V(str);
        }
    }

    public void setLooping(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.K.W(z16);
        }
    }

    public void setOnPlayedListener(VideoSprite.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            this.K.Y(bVar);
        }
    }

    public void setOnProgressChangedListener(VideoSprite.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        } else {
            this.K.Z(cVar);
        }
    }

    protected void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        VideoSprite videoSprite = new VideoSprite(this, getContext(), z16) { // from class: com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView.1
            static IPatchRedirector $redirector_;

            {
                super(this, r7, z16);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SpriteVideoView.this, this, r7, Boolean.valueOf(z16));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
            public void a0(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                SpriteVideoView spriteVideoView = SpriteVideoView.this;
                if (spriteVideoView.L == 0) {
                    spriteVideoView.L = i16;
                }
                super.a0(i3, spriteVideoView.L);
            }
        };
        this.K = videoSprite;
        videoSprite.Z = true;
        videoSprite.f291261a0 = true;
        i(videoSprite);
    }

    public void w(String str, int i3, FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), aVar);
        } else {
            this.K.U(str, i3);
            this.K.X(aVar);
        }
    }

    public void x(String str, FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) aVar);
        } else {
            this.K.T(str);
            this.K.X(aVar);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.K.stop();
        }
    }

    public SpriteVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.L = 0;
            v(true);
        }
    }
}
