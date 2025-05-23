package com.tencent.tdf.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.event.IgnoreHitCheckEvent;
import com.tencent.tdf.view.RenderSurface;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFSurfaceView extends SurfaceView implements SurfaceHolder.Callback, IgnoreHitCheckEvent, RenderSurface {
    static IPatchRedirector $redirector_;
    private RenderSurface.Callback mCallback;
    private boolean mIsRenderInImageView;
    private SurfaceHolder mSurfaceHolder;

    public TDFSurfaceView(Context context, RenderSurface.Callback callback) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCallback = callback;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) callback);
        }
    }

    @Override // com.tencent.tdf.view.RenderSurface
    public void attachSurfaceToRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null && !this.mIsRenderInImageView) {
            this.mCallback.surfaceCreated(surfaceHolder.getSurface());
        }
    }

    @Override // com.tencent.tdf.view.RenderSurface
    public void setRenderInImageView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mIsRenderInImageView = z16;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mCallback.surfaceChanged(surfaceHolder.getSurface(), i16, i17);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceHolder);
        } else {
            this.mSurfaceHolder = surfaceHolder;
            attachSurfaceToRenderer();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceHolder);
        } else {
            this.mSurfaceHolder = null;
            this.mCallback.surfaceDestroyed(surfaceHolder.getSurface());
        }
    }

    public TDFSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.mIsRenderInImageView = false;
            getHolder().addCallback(this);
        }
    }
}
