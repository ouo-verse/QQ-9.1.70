package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ExifBitmapCreator extends BitmapCreatorGetter implements IBitmapCreator {
    static IPatchRedirector $redirector_;
    String path;

    public ExifBitmapCreator(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.path = str;
        }
    }

    @Override // com.tencent.mobileqq.transfile.bitmapcreator.IBitmapCreator
    public Bitmap creatBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        }
        int exifOrientation = BaseImageUtil.getExifOrientation(this.path);
        if (exifOrientation == 0) {
            return getBitmap(bitmap);
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(exifOrientation, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != null && createBitmap != bitmap) {
            bitmap.recycle();
            return getBitmap(createBitmap);
        }
        throw new OutOfMemoryError("OOM");
    }
}
