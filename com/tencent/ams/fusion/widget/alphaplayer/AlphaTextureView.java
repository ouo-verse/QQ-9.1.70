package com.tencent.ams.fusion.widget.alphaplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
class AlphaTextureView extends TextureView implements TextureView.SurfaceTextureListener, AlphaPlayerView {
    static IPatchRedirector $redirector_;
    private AlphaPlayerView.SurfaceListener mSurfaceListener;

    public AlphaTextureView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            setSurfaceTextureListener(this);
            setOpaque(false);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public Object getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getSurfaceTexture();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AlphaPlayerView.SurfaceListener surfaceListener = this.mSurfaceListener;
        if (surfaceListener != null) {
            surfaceListener.onSurfaceAvailable(surfaceTexture, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        AlphaPlayerView.SurfaceListener surfaceListener = this.mSurfaceListener;
        if (surfaceListener != null) {
            surfaceListener.onSurfaceDestroyed(surfaceTexture);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) surfaceTexture);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public void setPlayInfo(PlayInfo playInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) playInfo);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public void setSurfaceListener(AlphaPlayerView.SurfaceListener surfaceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceListener);
        } else {
            this.mSurfaceListener = surfaceListener;
        }
    }
}
