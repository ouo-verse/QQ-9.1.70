package com.tencent.tdf.view.overlay;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.view.TDFImageView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFOverlayImageView extends TDFImageView {
    static IPatchRedirector $redirector_;
    private long mNativeSurfaceView;

    public TDFOverlayImageView(Context context, TDFEngine tDFEngine, int i3, int i16, long j3) {
        super(context, tDFEngine, i3, i16, TDFImageView.SurfaceKind.overlay);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFEngine, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        } else {
            this.mNativeSurfaceView = j3;
            attachSurfaceToRenderer();
        }
    }

    @Override // com.tencent.tdf.view.TDFImageView
    protected void attachSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.tdfEngine.onOverlaySurfaceCreated(this.mNativeSurfaceView, getSurface());
        }
    }
}
