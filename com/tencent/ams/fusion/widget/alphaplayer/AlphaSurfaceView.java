package com.tencent.ams.fusion.widget.alphaplayer;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
class AlphaSurfaceView extends SurfaceView implements SurfaceHolder.Callback, AlphaPlayerView {
    static IPatchRedirector $redirector_;
    private boolean mIsAvailable;
    private AlphaPlayerView.SurfaceListener mSurfaceListener;

    public AlphaSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public Object getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getHolder().getSurface();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public boolean isAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mIsAvailable;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public void setPlayInfo(PlayInfo playInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) playInfo);
            return;
        }
        if (playInfo != null && !playInfo.isZOrderOnTop()) {
            z16 = false;
        } else {
            z16 = true;
        }
        setZOrderOnTop(z16);
        if (playInfo != null && playInfo.isSurfaceViewMediaOverlay()) {
            setZOrderMediaOverlay(true);
        }
        SurfaceHolder holder = getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayerView
    public void setSurfaceListener(AlphaPlayerView.SurfaceListener surfaceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceListener);
        } else {
            this.mSurfaceListener = surfaceListener;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceHolder);
            return;
        }
        this.mIsAvailable = true;
        AlphaPlayerView.SurfaceListener surfaceListener = this.mSurfaceListener;
        if (surfaceListener != null) {
            surfaceListener.onSurfaceAvailable(surfaceHolder.getSurface(), getWidth(), getHeight());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) surfaceHolder);
            return;
        }
        this.mIsAvailable = false;
        AlphaPlayerView.SurfaceListener surfaceListener = this.mSurfaceListener;
        if (surfaceListener != null) {
            surfaceListener.onSurfaceDestroyed(surfaceHolder.getSurface());
        }
    }
}
