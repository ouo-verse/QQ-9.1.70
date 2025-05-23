package com.tencent.ams.fusion.widget.flipcard.layers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardBitmapLayer extends BitmapLayer {
    static IPatchRedirector $redirector_;

    public FlipCardBitmapLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            if (this.mMatrixChanged) {
                canvas.setMatrix(getMatrix());
                canvas.drawBitmap(bitmap, getX(), getY(), getPaint());
                canvas.setMatrix(null);
                return;
            }
            canvas.drawBitmap(bitmap, getX(), getY(), getPaint());
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    public FlipCardBitmapLayer(Bitmap bitmap) {
        super(bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
    }
}
