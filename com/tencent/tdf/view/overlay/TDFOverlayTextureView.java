package com.tencent.tdf.view.overlay;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.event.IgnoreHitCheckEvent;
import com.tencent.tdf.view.INativeViewDelegate;
import com.tencent.tdf.view.NativeViewDelegate;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFOverlayTextureView extends TextureView implements IgnoreHitCheckEvent, TextureView.SurfaceTextureListener, INativeViewDelegate {
    static IPatchRedirector $redirector_;
    private boolean hasSurfaceCreated;
    private INativeViewDelegate mNativeViewDelegate;
    private long nativeSurfaceView;
    private Surface surface;
    private TDFEngine tdfEngine;

    public TDFOverlayTextureView(Context context, TDFEngine tDFEngine, long j3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFEngine, Long.valueOf(j3));
            return;
        }
        this.tdfEngine = tDFEngine;
        this.nativeSurfaceView = j3;
        setSurfaceTextureListener(this);
        this.mNativeViewDelegate = new NativeViewDelegate(this);
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Rect) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mNativeViewDelegate.getLayoutRect();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.surface.release();
            this.surface = null;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.hasSurfaceCreated) {
            return;
        }
        this.hasSurfaceCreated = true;
        if (i3 != 0 && i16 != 0) {
            onSurfaceTextureAvailable();
        } else {
            post(new Runnable() { // from class: com.tencent.tdf.view.overlay.TDFOverlayTextureView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TDFOverlayTextureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TDFOverlayTextureView.this.onSurfaceTextureAvailable();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.hasSurfaceCreated = false;
        this.tdfEngine.onOverlaySurfaceDestroyed(this.nativeSurfaceView);
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.tdfEngine.onOverlaySurfaceChanged(this.nativeSurfaceView, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceTexture);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mNativeViewDelegate.updateLayoutParams(i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceTextureAvailable() {
        Surface surface = new Surface(getSurfaceTexture());
        this.surface = surface;
        this.tdfEngine.onOverlaySurfaceCreated(this.nativeSurfaceView, surface);
    }
}
