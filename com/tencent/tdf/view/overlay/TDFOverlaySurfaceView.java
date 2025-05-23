package com.tencent.tdf.view.overlay;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.event.IgnoreHitCheckEvent;
import com.tencent.tdf.view.INativeViewDelegate;
import com.tencent.tdf.view.NativeViewDelegate;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFOverlaySurfaceView extends SurfaceView implements SurfaceHolder.Callback, IgnoreHitCheckEvent, INativeViewDelegate {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DFOverlaySurfaceView";
    private boolean hasSurfaceCreated;
    private INativeViewDelegate mNativeViewDelegate;
    private long mViewId;
    private TDFEngine tdfEngine;

    public TDFOverlaySurfaceView(Context context, TDFEngine tDFEngine, long j3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFEngine, Long.valueOf(j3));
            return;
        }
        this.tdfEngine = tDFEngine;
        this.mViewId = j3;
        getHolder().addCallback(this);
        this.mNativeViewDelegate = new NativeViewDelegate(this);
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Rect) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mNativeViewDelegate.getLayoutRect();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, i3);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.tdfEngine.onOverlaySurfaceChanged(this.mViewId, i16, i17);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
        } else {
            if (this.hasSurfaceCreated) {
                return;
            }
            this.hasSurfaceCreated = true;
            surfaceHolder.setFormat(-2);
            this.tdfEngine.onOverlaySurfaceCreated(this.mViewId, surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
        } else {
            this.hasSurfaceCreated = false;
            this.tdfEngine.onOverlaySurfaceDestroyed(this.mViewId);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mNativeViewDelegate.updateLayoutParams(i3, i16, i17, i18);
        }
    }
}
