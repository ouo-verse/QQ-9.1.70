package com.tencent.ams.fusion.widget.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.Frame;
import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.ams.fusion.widget.apng.io.APNGWriter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StillFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            $assertionsDisabled = true;
        }
    }

    public StillFrame(APNGReader aPNGReader) {
        super(aPNGReader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aPNGReader);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i3, Bitmap bitmap, APNGWriter aPNGWriter) {
        Bitmap decodeStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, canvas, paint, Integer.valueOf(i3), bitmap, aPNGWriter);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i3;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((APNGReader) this.reader).reset();
            decodeStream = BitmapFactory.decodeStream(((APNGReader) this.reader).toInputStream(), null, options);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (!$assertionsDisabled && decodeStream == null) {
                throw new AssertionError();
            }
            paint.setXfermode(null);
            canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
            return decodeStream;
        } catch (Throwable th6) {
            th = th6;
            bitmap2 = decodeStream;
            th.printStackTrace();
            return bitmap2;
        }
    }
}
