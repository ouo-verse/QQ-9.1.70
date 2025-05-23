package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BitmapCreatorGetter {
    static IPatchRedirector $redirector_;
    IBitmapCreator nextBitmapCreator;

    public BitmapCreatorGetter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap getBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        }
        IBitmapCreator iBitmapCreator = this.nextBitmapCreator;
        if (iBitmapCreator == null) {
            return bitmap;
        }
        return iBitmapCreator.creatBitmap(bitmap);
    }

    public IBitmapCreator getNextBitmapCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBitmapCreator) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nextBitmapCreator;
    }

    public void setNextBitmapCreator(IBitmapCreator iBitmapCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iBitmapCreator);
        } else {
            this.nextBitmapCreator = iBitmapCreator;
        }
    }
}
