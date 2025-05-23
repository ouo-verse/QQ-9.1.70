package com.tencent.mobileqq.vpng.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.glrenderer.a;
import com.tencent.mobileqq.vpng.glrenderer.b;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;

/* loaded from: classes20.dex */
public class VPNGImageView extends FrameLayout implements TextureView.SurfaceTextureListener, a {
    static IPatchRedirector $redirector_;
    protected int mAlign;
    protected LiveRoomGiftCallback mCallback;
    protected int mHeight;
    protected boolean mIsLoop;
    protected ImageView mPreImageView;
    protected TextureView mTextureView;
    protected VPNGRenderer mVPNGRenderer;
    protected String mVideoPath;
    protected int mWidth;
    protected boolean playOnSubThread;

    public VPNGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mAlign = 1;
        this.playOnSubThread = false;
        init();
    }

    private void init() {
        this.mTextureView = new TextureView(getContext());
        this.mPreImageView = new ImageView(getContext());
        addView(this.mTextureView, -1, -1);
        addView(this.mPreImageView, -1, -1);
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.a
    public int getRenderHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.a
    public int getRenderWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    public VPNGRenderer getVPNGRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (VPNGRenderer) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mVPNGRenderer;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (this.mVPNGRenderer != null) {
            b.b().d(this.mVPNGRenderer);
            this.mVPNGRenderer = null;
        }
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.a
    public void onDrawBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            post(new Runnable() { // from class: com.tencent.mobileqq.vpng.view.VPNGImageView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VPNGImageView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        VPNGImageView.this.mTextureView.setAlpha(1.0f);
                        VPNGImageView.this.mPreImageView.setVisibility(8);
                    }
                }
            });
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.F();
        }
    }

    public void onRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.n();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.J();
        }
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.a
    public void onSetRenderer(VPNGRenderer vPNGRenderer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) vPNGRenderer);
            return;
        }
        this.mVPNGRenderer = vPNGRenderer;
        if (isActivated() && getVisibility() == 0) {
            this.mVPNGRenderer.r();
            playRender();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mVPNGRenderer == null) {
            VPNGRenderer c16 = b.b().c(this, this.mWidth, this.mHeight);
            this.mVPNGRenderer = c16;
            if (c16 != null) {
                c16.P(this.mVideoPath, this.mAlign, this.mCallback);
                this.mVPNGRenderer.L(this.mIsLoop);
            }
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.q(i3, i16);
            this.mVPNGRenderer.s(surfaceTexture);
            playRender();
        }
        this.mTextureView.setAlpha(0.0f);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.t();
        }
        LiveRoomGiftCallback liveRoomGiftCallback = this.mCallback;
        if (liveRoomGiftCallback != null) {
            liveRoomGiftCallback.onCall(9, "");
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        if (vPNGRenderer != null) {
            vPNGRenderer.q(i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) surfaceTexture);
        }
    }

    protected void playRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!this.playOnSubThread) {
            VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
            if (vPNGRenderer != null) {
                vPNGRenderer.G();
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vpng.view.VPNGImageView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VPNGImageView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                VPNGRenderer vPNGRenderer2 = VPNGImageView.this.mVPNGRenderer;
                if (vPNGRenderer2 != null) {
                    vPNGRenderer2.G();
                }
            }
        }, 128, null, true);
    }

    public void setImage(String str, BitmapFactory.Options options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) options);
            return;
        }
        Bitmap copy = BitmapFactory.decodeFile(str, options).copy(Bitmap.Config.ARGB_8888, true);
        this.mWidth = copy.getWidth();
        this.mHeight = copy.getHeight();
        String str2 = str + ".vpng";
        if (!new File(str2).exists() && com.tencent.mobileqq.vpng.util.a.c(str, str2)) {
            setVideo(str2, true);
        }
        this.mPreImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mPreImageView.setImageBitmap(copy);
        this.mPreImageView.setVisibility(0);
    }

    public void setPlayOnSubThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.playOnSubThread = z16;
        }
    }

    public void setRenderHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mHeight = i3;
        }
    }

    public void setRenderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mWidth = i3;
        }
    }

    public void setVideo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setVideo(str, z16, 0, null);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
    }

    public void setVideo(String str, boolean z16, int i3, LiveRoomGiftCallback liveRoomGiftCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), liveRoomGiftCallback);
            return;
        }
        VPNGRenderer vPNGRenderer = this.mVPNGRenderer;
        boolean z17 = vPNGRenderer != null;
        if (vPNGRenderer == null) {
            this.mVPNGRenderer = b.b().c(this, this.mWidth, this.mHeight);
        }
        VPNGRenderer vPNGRenderer2 = this.mVPNGRenderer;
        if (vPNGRenderer2 != null) {
            vPNGRenderer2.P(str, i3, liveRoomGiftCallback);
            this.mVPNGRenderer.L(z16);
            if (z17) {
                this.mVPNGRenderer.N(true);
                playRender();
            }
        }
        this.mVideoPath = str;
        this.mIsLoop = z16;
        this.mAlign = i3;
        this.mCallback = liveRoomGiftCallback;
        this.mTextureView.setOpaque(false);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public VPNGImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mAlign = 1;
        this.playOnSubThread = false;
        init();
    }
}
