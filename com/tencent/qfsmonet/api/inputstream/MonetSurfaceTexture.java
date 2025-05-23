package com.tencent.qfsmonet.api.inputstream;

import android.graphics.SurfaceTexture;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.utils.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetSurfaceTexture extends SurfaceTexture {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MonetSurfaceTexture";

    @IntRange(from = 0)
    private int mHeight;
    private String mRichMediaParams;
    private MonetTextureCropInfo mTextureCropInfo;

    @IntRange(from = 0)
    private int mWidth;

    public MonetSurfaceTexture(@IntRange(from = 0) int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        a.c(TAG, "create TPMonetSurfaceTexture, tex = " + i3);
    }

    public void height(@IntRange(from = 0) int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mHeight = i3;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    public void richMediaParams(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mRichMediaParams = str;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    public MonetTextureCropInfo textureCropInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.mTextureCropInfo : (MonetTextureCropInfo) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    public void width(@IntRange(from = 0) int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mWidth = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public int height() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.mHeight : ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
    }

    @Nullable
    public String richMediaParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.mRichMediaParams : (String) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    public void textureCropInfo(MonetTextureCropInfo monetTextureCropInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.mTextureCropInfo = monetTextureCropInfo;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) monetTextureCropInfo);
        }
    }

    public int width() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mWidth : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }
}
