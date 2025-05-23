package com.tencent.image.sharp;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.image.URLDrawable;
import com.tencent.image.api.ILog;
import com.tencent.image.sharp.SharpImage;
import com.tencent.image.sharp.SharpPDecoderWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
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
            URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "createDecoder catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e16));
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    public Bitmap decodeSharpP(int i3, int i16, Bitmap.Config config) {
        ILog iLog;
        StringBuilder sb5;
        String str = "decodeSharpP error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = this.mDecoder.decodeSharpP(i3, i16, config);
                str = str;
                i3 = i3;
                if (bitmap == null) {
                    URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP error,retry once");
                    try {
                        this.mDecoder.closeDecoder();
                        ?? r16 = this.mDecoder;
                        ?? decodeSharpP = r16.decodeSharpP(i3, i16, config);
                        bitmap = decodeSharpP;
                        str = r16;
                        i3 = decodeSharpP;
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        iLog = URLDrawable.depImp.mLog;
                        sb5 = new StringBuilder();
                        sb5.append("decodeSharpP error,retry once failed,");
                        sb5.append(Log.getStackTraceString(e));
                        iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                        this.mDecoder.closeDecoder();
                        return bitmap;
                    }
                }
            } catch (OutOfMemoryError unused) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP catch a OutOfMemoryError.");
                int i17 = i3 / 2;
                i16 /= 2;
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    ?? r17 = this.mDecoder;
                    bitmap = r17.decodeSharpP(i17, i16, config);
                    str = r17;
                    i3 = i17;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    iLog = URLDrawable.depImp.mLog;
                    sb5 = new StringBuilder();
                    sb5.append("decodeSharpP error,retry once failed,");
                    sb5.append(Log.getStackTraceString(e));
                    iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                    this.mDecoder.closeDecoder();
                    return bitmap;
                }
            } catch (UnsatisfiedLinkError e18) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e18));
                str = str;
                i3 = i3;
            }
            this.mDecoder.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP(i3, i16, config);
            } catch (OutOfMemoryError e19) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP error,retry once failed," + Log.getStackTraceString(e19));
            }
            this.mDecoder.closeDecoder();
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeSharpP2GifFrame(long j3, int i3, int i16, int i17, SharpImage.WriteableInteger writeableInteger, Bitmap bitmap, boolean z16) {
        SharpPPathDecoder sharpPPathDecoder;
        long j16;
        int i18;
        int i19;
        int i26;
        Bitmap decodeSharpP2GifFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), writeableInteger, bitmap, Boolean.valueOf(z16));
        }
        try {
            try {
                try {
                    Bitmap decodeSharpP2GifFrame2 = this.mDecoder.decodeSharpP2GifFrame(j3, i3, i16, i17, writeableInteger, bitmap, z16);
                    if (decodeSharpP2GifFrame2 == null) {
                        this.mDecoder.closeDecoder();
                        decodeSharpP2GifFrame2 = this.mDecoder.decodeSharpP2GifFrame(j3, i3, i16, i17, writeableInteger, decodeSharpP2GifFrame2, z16);
                    }
                    this.mDecoder.closeDecoder();
                    return decodeSharpP2GifFrame2;
                } catch (UnsatisfiedLinkError e16) {
                    URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2GifFrame catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e16));
                    if (bitmap == null) {
                        this.mDecoder.closeDecoder();
                        sharpPPathDecoder = this.mDecoder;
                        j16 = j3;
                        i18 = i3;
                        i19 = i16;
                        i26 = i17;
                        decodeSharpP2GifFrame = sharpPPathDecoder.decodeSharpP2GifFrame(j16, i18, i19, i26, writeableInteger, bitmap, z16);
                        this.mDecoder.closeDecoder();
                        return decodeSharpP2GifFrame;
                    }
                    decodeSharpP2GifFrame = bitmap;
                    this.mDecoder.closeDecoder();
                    return decodeSharpP2GifFrame;
                }
            } catch (OutOfMemoryError e17) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2GifFrame catch an OutOfMemoryError:" + Log.getStackTraceString(e17));
                i19 = i16 / 2;
                try {
                    i26 = i17 / 2;
                    if (bitmap == null) {
                        this.mDecoder.closeDecoder();
                        sharpPPathDecoder = this.mDecoder;
                        j16 = j3;
                        i18 = i3;
                        decodeSharpP2GifFrame = sharpPPathDecoder.decodeSharpP2GifFrame(j16, i18, i19, i26, writeableInteger, bitmap, z16);
                        this.mDecoder.closeDecoder();
                        return decodeSharpP2GifFrame;
                    }
                    decodeSharpP2GifFrame = bitmap;
                    this.mDecoder.closeDecoder();
                    return decodeSharpP2GifFrame;
                } catch (Throwable th5) {
                    th = th5;
                    if (bitmap == null) {
                    }
                    this.mDecoder.closeDecoder();
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            i19 = i16;
            if (bitmap == null) {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP2GifFrame(j3, i3, i19, i17, writeableInteger, bitmap, z16);
            }
            this.mDecoder.closeDecoder();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    public Bitmap decodeSharpP2JPG(int i3, int i16, Bitmap.Config config) {
        ILog iLog;
        StringBuilder sb5;
        String str = "decodeSharpP2JPG error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = this.mDecoder.decodeSharpP2JPG(i3, i16, config);
                str = str;
                i3 = i3;
                if (bitmap == null) {
                    URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2JPG error,retry once");
                    try {
                        this.mDecoder.closeDecoder();
                        ?? r16 = this.mDecoder;
                        ?? decodeSharpP2JPG = r16.decodeSharpP2JPG(i3, i16, config);
                        bitmap = decodeSharpP2JPG;
                        str = r16;
                        i3 = decodeSharpP2JPG;
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        iLog = URLDrawable.depImp.mLog;
                        sb5 = new StringBuilder();
                        sb5.append("decodeSharpP2PNG error,retry once failed,");
                        sb5.append(Log.getStackTraceString(e));
                        iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                        this.mDecoder.closeDecoder();
                        return bitmap;
                    }
                }
            } catch (OutOfMemoryError e17) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2JPG catch a OutOfMemoryError:" + Log.getStackTraceString(e17));
                int i17 = i3 / 2;
                i16 /= 2;
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2JPG error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    ?? r17 = this.mDecoder;
                    bitmap = r17.decodeSharpP2JPG(i17, i16, config);
                    str = r17;
                    i3 = i17;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    iLog = URLDrawable.depImp.mLog;
                    sb5 = new StringBuilder();
                    sb5.append("decodeSharpP2PNG error,retry once failed,");
                    sb5.append(Log.getStackTraceString(e));
                    iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                    this.mDecoder.closeDecoder();
                    return bitmap;
                }
            } catch (UnsatisfiedLinkError e19) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2JPG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e19));
                str = str;
                i3 = i3;
            }
            this.mDecoder.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP2JPG(i3, i16, config);
            } catch (OutOfMemoryError e26) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(e26));
            }
            this.mDecoder.closeDecoder();
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.tencent.image.sharp.SharpPPathDecoder] */
    public Bitmap decodeSharpP2PNG(int i3, int i16, Bitmap.Config config) {
        ILog iLog;
        StringBuilder sb5;
        String str = "decodeSharpP2PNG error,retry once";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), config);
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = this.mDecoder.decodeSharpP2PNG(i3, i16, config);
                str = str;
                i3 = i3;
                if (bitmap == null) {
                    URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG error,retry once");
                    try {
                        this.mDecoder.closeDecoder();
                        ?? r16 = this.mDecoder;
                        ?? decodeSharpP2PNG = r16.decodeSharpP2PNG(i3, i16, config);
                        bitmap = decodeSharpP2PNG;
                        str = r16;
                        i3 = decodeSharpP2PNG;
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        iLog = URLDrawable.depImp.mLog;
                        sb5 = new StringBuilder();
                        sb5.append("decodeSharpP2PNG error,retry once failed,");
                        sb5.append(Log.getStackTraceString(e));
                        iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                        this.mDecoder.closeDecoder();
                        return bitmap;
                    }
                }
            } catch (OutOfMemoryError e17) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG catch a OutOfMemoryError:" + Log.getStackTraceString(e17));
                int i17 = i3 / 2;
                i16 /= 2;
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG error,retry once");
                try {
                    this.mDecoder.closeDecoder();
                    ?? r17 = this.mDecoder;
                    bitmap = r17.decodeSharpP2PNG(i17, i16, config);
                    str = r17;
                    i3 = i17;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    iLog = URLDrawable.depImp.mLog;
                    sb5 = new StringBuilder();
                    sb5.append("decodeSharpP2PNG error,retry once failed,");
                    sb5.append(Log.getStackTraceString(e));
                    iLog.e("SharpPDecoderHelper", 2, sb5.toString());
                    this.mDecoder.closeDecoder();
                    return bitmap;
                }
            } catch (UnsatisfiedLinkError e19) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e19));
                str = str;
                i3 = i3;
            }
            this.mDecoder.closeDecoder();
            return bitmap;
        } catch (Throwable th5) {
            URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, str);
            try {
                this.mDecoder.closeDecoder();
                this.mDecoder.decodeSharpP2PNG(i3, i16, config);
            } catch (OutOfMemoryError e26) {
                URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(e26));
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
            URLDrawable.depImp.mLog.e("SharpPDecoderHelper", 2, "parseHeader catch a UnsatisfiedLinkError:" + Log.getStackTraceString(e16));
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
