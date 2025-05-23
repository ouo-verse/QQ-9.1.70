package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sharpP.SharpPDecoderWrapper;

/* loaded from: classes25.dex */
public class SharpPDecoderHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SharpPDecoderHelper";
    SharpPPathDecoder mDecoder;

    public SharpPDecoderHelper(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mDecoder = new SharpPPathDecoder(str);
        }
    }

    public void closeDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mDecoder.closeDecoder();
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public long createDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        try {
            return this.mDecoder.createDecoder();
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "createDecoder catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e16));
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.tencent.sharpP.SharpPPathDecoder] */
    public Bitmap decodeSharpP(int i3, int i16, Bitmap.Config config) {
        String str = "decodeSharpP error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                try {
                    bitmap = this.mDecoder.decodeSharpP(i3, i16, config);
                    str = str;
                    i16 = i16;
                    config = config;
                    if (bitmap == null) {
                        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP error,retry once");
                        try {
                            this.mDecoder.closeDecoder();
                            SharpPPathDecoder sharpPPathDecoder = this.mDecoder;
                            bitmap = sharpPPathDecoder.decodeSharpP(i3, i16, config);
                            str = sharpPPathDecoder;
                            i16 = i16;
                            config = config;
                        } catch (OutOfMemoryError e16) {
                            ILog logger = ImageManagerEnv.getLogger();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("decodeSharpP error,retry once failed,");
                            sb5.append(Log.getStackTraceString(e16));
                            Object[] objArr = {sb5.toString()};
                            logger.e("SharpPDecoderHelper", objArr);
                            str = sb5;
                            i16 = logger;
                            config = objArr;
                        }
                    }
                } catch (UnsatisfiedLinkError e17) {
                    ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e17));
                    str = str;
                    i16 = i16;
                    config = config;
                }
            } catch (OutOfMemoryError unused) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP catch a OutOfMemoryError.");
                int i17 = i3 / 2;
                int i18 = i16 / 2;
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    SharpPPathDecoder sharpPPathDecoder2 = this.mDecoder;
                    bitmap = sharpPPathDecoder2.decodeSharpP(i17, i18, config);
                    str = sharpPPathDecoder2;
                    i16 = i18;
                    config = config;
                } catch (OutOfMemoryError e18) {
                    ILog logger2 = ImageManagerEnv.getLogger();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("decodeSharpP error,retry once failed,");
                    sb6.append(Log.getStackTraceString(e18));
                    Object[] objArr2 = {sb6.toString()};
                    logger2.e("SharpPDecoderHelper", objArr2);
                    str = sb6;
                    i16 = logger2;
                    config = objArr2;
                }
            }
            i3 = this.mDecoder;
            i3.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e("SharpPDecoderHelper", str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP(i3, i16, config);
            } catch (OutOfMemoryError e19) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP error,retry once failed," + Log.getStackTraceString(e19));
            }
            this.mDecoder.closeDecoder();
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeSharpP2GifFrame(long j3, int i3, int i16, int i17, SharpPDecoderWrapper.WriteableInteger writeableInteger, Bitmap bitmap) {
        SharpPPathDecoder sharpPPathDecoder;
        long j16;
        int i18;
        int i19;
        int i26;
        Bitmap decodeSharpP2GifFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), writeableInteger, bitmap);
        }
        try {
            try {
                Bitmap decodeSharpP2GifFrame2 = this.mDecoder.decodeSharpP2GifFrame(j3, i3, i16, i17, writeableInteger, bitmap);
                if (decodeSharpP2GifFrame2 == null) {
                    this.mDecoder.closeDecoder();
                    decodeSharpP2GifFrame2 = this.mDecoder.decodeSharpP2GifFrame(j3, i3, i16, i17, writeableInteger, decodeSharpP2GifFrame2);
                }
                this.mDecoder.closeDecoder();
                return decodeSharpP2GifFrame2;
            } catch (OutOfMemoryError e16) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2GifFrame catch an OutOfMemoryError:" + Log.getStackTraceString(e16));
                i19 = i16 / 2;
                try {
                    i26 = i17 / 2;
                    if (bitmap == null) {
                        this.mDecoder.closeDecoder();
                        sharpPPathDecoder = this.mDecoder;
                        j16 = j3;
                        i18 = i3;
                        decodeSharpP2GifFrame = sharpPPathDecoder.decodeSharpP2GifFrame(j16, i18, i19, i26, writeableInteger, bitmap);
                        this.mDecoder.closeDecoder();
                        return decodeSharpP2GifFrame;
                    }
                    decodeSharpP2GifFrame = bitmap;
                    this.mDecoder.closeDecoder();
                    return decodeSharpP2GifFrame;
                } catch (Throwable th5) {
                    th = th5;
                    if (bitmap == null) {
                        this.mDecoder.closeDecoder();
                        this.mDecoder.decodeSharpP2GifFrame(j3, i3, i19, i17, writeableInteger, bitmap);
                    }
                    this.mDecoder.closeDecoder();
                    throw th;
                }
            } catch (UnsatisfiedLinkError e17) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2GifFrame catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e17));
                if (bitmap == null) {
                    this.mDecoder.closeDecoder();
                    sharpPPathDecoder = this.mDecoder;
                    j16 = j3;
                    i18 = i3;
                    i19 = i16;
                    i26 = i17;
                    decodeSharpP2GifFrame = sharpPPathDecoder.decodeSharpP2GifFrame(j16, i18, i19, i26, writeableInteger, bitmap);
                    this.mDecoder.closeDecoder();
                    return decodeSharpP2GifFrame;
                }
                decodeSharpP2GifFrame = bitmap;
                this.mDecoder.closeDecoder();
                return decodeSharpP2GifFrame;
            }
        } catch (Throwable th6) {
            th = th6;
            i19 = i16;
            if (bitmap == null) {
            }
            this.mDecoder.closeDecoder();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.tencent.sharpP.SharpPPathDecoder] */
    public Bitmap decodeSharpP2JPG(int i3, int i16, Bitmap.Config config) {
        String str = "decodeSharpP2JPG error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                try {
                    bitmap = this.mDecoder.decodeSharpP2JPG(i3, i16, config);
                    str = str;
                    i16 = i16;
                    config = config;
                    if (bitmap == null) {
                        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2JPG error,retry once");
                        try {
                            this.mDecoder.closeDecoder();
                            SharpPPathDecoder sharpPPathDecoder = this.mDecoder;
                            bitmap = sharpPPathDecoder.decodeSharpP2JPG(i3, i16, config);
                            str = sharpPPathDecoder;
                            i16 = i16;
                            config = config;
                        } catch (OutOfMemoryError e16) {
                            ILog logger = ImageManagerEnv.getLogger();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("decodeSharpP2PNG error,retry once failed,");
                            sb5.append(Log.getStackTraceString(e16));
                            Object[] objArr = {sb5.toString()};
                            logger.e("SharpPDecoderHelper", objArr);
                            str = sb5;
                            i16 = logger;
                            config = objArr;
                        }
                    }
                } catch (UnsatisfiedLinkError e17) {
                    ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2JPG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e17));
                    str = str;
                    i16 = i16;
                    config = config;
                }
            } catch (OutOfMemoryError e18) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2JPG catch a OutOfMemoryError:" + Log.getStackTraceString(e18));
                int i17 = i3 / 2;
                int i18 = i16 / 2;
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2JPG error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    SharpPPathDecoder sharpPPathDecoder2 = this.mDecoder;
                    bitmap = sharpPPathDecoder2.decodeSharpP2JPG(i17, i18, config);
                    str = sharpPPathDecoder2;
                    i16 = i18;
                    config = config;
                } catch (OutOfMemoryError e19) {
                    ILog logger2 = ImageManagerEnv.getLogger();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("decodeSharpP2PNG error,retry once failed,");
                    sb6.append(Log.getStackTraceString(e19));
                    Object[] objArr2 = {sb6.toString()};
                    logger2.e("SharpPDecoderHelper", objArr2);
                    str = sb6;
                    i16 = logger2;
                    config = objArr2;
                }
            }
            i3 = this.mDecoder;
            i3.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e("SharpPDecoderHelper", str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP2JPG(i3, i16, config);
            } catch (OutOfMemoryError e26) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(e26));
            }
            this.mDecoder.closeDecoder();
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.tencent.sharpP.SharpPPathDecoder] */
    public Bitmap decodeSharpP2PNG(int i3, int i16, Bitmap.Config config) {
        String str = "decodeSharpP2PNG error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                try {
                    bitmap = this.mDecoder.decodeSharpP2PNG(i3, i16, config);
                    str = str;
                    i16 = i16;
                    config = config;
                    if (bitmap == null) {
                        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG error,retry once");
                        try {
                            this.mDecoder.closeDecoder();
                            SharpPPathDecoder sharpPPathDecoder = this.mDecoder;
                            bitmap = sharpPPathDecoder.decodeSharpP2PNG(i3, i16, config);
                            str = sharpPPathDecoder;
                            i16 = i16;
                            config = config;
                        } catch (OutOfMemoryError e16) {
                            ILog logger = ImageManagerEnv.getLogger();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("decodeSharpP2PNG error,retry once failed,");
                            sb5.append(Log.getStackTraceString(e16));
                            Object[] objArr = {sb5.toString()};
                            logger.e("SharpPDecoderHelper", objArr);
                            str = sb5;
                            i16 = logger;
                            config = objArr;
                        }
                    }
                } catch (UnsatisfiedLinkError e17) {
                    ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e17));
                    str = str;
                    i16 = i16;
                    config = config;
                }
            } catch (OutOfMemoryError e18) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG catch a OutOfMemoryError:" + Log.getStackTraceString(e18));
                int i17 = i3 / 2;
                int i18 = i16 / 2;
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    SharpPPathDecoder sharpPPathDecoder2 = this.mDecoder;
                    bitmap = sharpPPathDecoder2.decodeSharpP2PNG(i17, i18, config);
                    str = sharpPPathDecoder2;
                    i16 = i18;
                    config = config;
                } catch (OutOfMemoryError e19) {
                    ILog logger2 = ImageManagerEnv.getLogger();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("decodeSharpP2PNG error,retry once failed,");
                    sb6.append(Log.getStackTraceString(e19));
                    Object[] objArr2 = {sb6.toString()};
                    logger2.e("SharpPDecoderHelper", objArr2);
                    str = sb6;
                    i16 = logger2;
                    config = objArr2;
                }
            }
            i3 = this.mDecoder;
            i3.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e("SharpPDecoderHelper", str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP2PNG(i3, i16, config);
            } catch (OutOfMemoryError e26) {
                ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(e26));
            }
            this.mDecoder.closeDecoder();
            throw th5;
        }
    }

    public int getAllocationByteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mDecoder.getAllocationByteCount();
    }

    public SharpPDecoderWrapper.SharpPFeatureWrapper getFeatureInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharpPDecoderWrapper.SharpPFeatureWrapper) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mDecoder.getFeatureInfo();
    }

    public String getMimeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mDecoder.getMimeType();
    }

    public int parseHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            return this.mDecoder.parseHeader();
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().e("SharpPDecoderHelper", "parseHeader catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e16));
            return -1;
        }
    }

    public void closeDecoder(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mDecoder.closeDecoder(j3);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }
    }
}
