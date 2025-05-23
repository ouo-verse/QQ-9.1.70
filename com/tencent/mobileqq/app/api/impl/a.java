package com.tencent.mobileqq.app.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Window;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements IScreenShot {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ScreenShot f195269a;

    public a(Context context, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) window);
        } else {
            this.f195269a = new ScreenShot(context, window);
        }
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public boolean activate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f195269a.f();
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public void disactivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f195269a.i();
        }
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public Bitmap getCacheBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f195269a.M;
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f195269a.o();
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f195269a.isShowing();
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public void screenShotAndExit() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f195269a.t();
        }
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShot
    public void setCachedBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
        } else {
            this.f195269a.M = bitmap;
        }
    }
}
