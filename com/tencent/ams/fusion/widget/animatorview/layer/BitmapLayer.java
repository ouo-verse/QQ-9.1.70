package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BitmapLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BitmapLayer";
    private Bitmap mBitmap;
    private boolean mVisible;

    public BitmapLayer() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else if (this.mVisible && (bitmap = getBitmap()) != null) {
            canvas.drawBitmap(bitmap, getMatrix(), getPaint());
        }
    }

    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mBitmap;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            super.postScale(f16, f17);
            getMatrix().postScale(f16, f17, getPx(), getPy());
        }
    }

    public BitmapLayer setBitmap(Bitmap bitmap) {
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BitmapLayer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        }
        Bitmap adapterGrayBitmap = adapterGrayBitmap(bitmap);
        if (!AnimatorConfig.isEnableHardware() && Build.VERSION.SDK_INT >= 26 && adapterGrayBitmap != null) {
            Bitmap.Config config2 = adapterGrayBitmap.getConfig();
            config = Bitmap.Config.HARDWARE;
            if (config2 == config) {
                try {
                    Logger.d(TAG, "switch hardware bitmap to software");
                    this.mBitmap = adapterGrayBitmap.copy(Bitmap.Config.ARGB_8888, false);
                    return this;
                } catch (Throwable unused) {
                    Logger.w(TAG, "software bitmap create failed");
                }
            }
        }
        this.mBitmap = adapterGrayBitmap;
        return this;
    }

    public BitmapLayer setTintColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BitmapLayer) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        getPaint().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
        return this;
    }

    public void setVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mVisible = z16;
        }
    }

    public BitmapLayer(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.mVisible = true;
            setBitmap(bitmap);
        }
    }
}
