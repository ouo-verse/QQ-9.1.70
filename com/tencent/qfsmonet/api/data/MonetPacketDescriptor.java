package com.tencent.qfsmonet.api.data;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
/* loaded from: classes22.dex */
public class MonetPacketDescriptor {
    static IPatchRedirector $redirector_;
    private int mFormat;

    @IntRange(from = 0)
    private int mHeight;

    @IntRange(from = 0)
    private int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface MonetDataFormat {
        public static final int R8 = 6409;
        public static final int RG8 = 6410;
        public static final int RGB888 = 6407;
        public static final int RGBA32F = 34836;
        public static final int RGBA8888 = 6408;
    }

    public MonetPacketDescriptor(@IntRange(from = 1) int i3, @IntRange(from = 1) int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mWidth = i3;
        this.mHeight = i16;
        this.mFormat = i17;
    }

    public int format() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mFormat;
    }

    public int height() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public int width() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mWidth;
    }
}
