package com.tencent.libavif;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class AvifFormat {
    private static final /* synthetic */ AvifFormat[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AvifFormat FORMAT_AVIF;
    public static final AvifFormat FORMAT_AVIS;
    public static final AvifFormat FORMAT_BMP;
    public static final AvifFormat FORMAT_GIF;
    public static final AvifFormat FORMAT_HEIC;
    public static final AvifFormat FORMAT_HEVC;
    public static final AvifFormat FORMAT_INVAILD;
    public static final AvifFormat FORMAT_JPEG;
    public static final AvifFormat FORMAT_PNG;
    public static final AvifFormat FORMAT_SHARPP;
    public static final AvifFormat FORMAT_TIFF;
    public static final AvifFormat FORMAT_TPG;
    public static final AvifFormat FORMAT_WEBP;
    public static final AvifFormat FORMAT_WXGF;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AvifFormat avifFormat = new AvifFormat("FORMAT_INVAILD", 0);
        FORMAT_INVAILD = avifFormat;
        AvifFormat avifFormat2 = new AvifFormat("FORMAT_JPEG", 1);
        FORMAT_JPEG = avifFormat2;
        AvifFormat avifFormat3 = new AvifFormat("FORMAT_GIF", 2);
        FORMAT_GIF = avifFormat3;
        AvifFormat avifFormat4 = new AvifFormat("FORMAT_PNG", 3);
        FORMAT_PNG = avifFormat4;
        AvifFormat avifFormat5 = new AvifFormat("FORMAT_BMP", 4);
        FORMAT_BMP = avifFormat5;
        AvifFormat avifFormat6 = new AvifFormat("FORMAT_WEBP", 5);
        FORMAT_WEBP = avifFormat6;
        AvifFormat avifFormat7 = new AvifFormat("FORMAT_TIFF", 6);
        FORMAT_TIFF = avifFormat7;
        AvifFormat avifFormat8 = new AvifFormat("FORMAT_HEVC", 7);
        FORMAT_HEVC = avifFormat8;
        AvifFormat avifFormat9 = new AvifFormat("FORMAT_WXGF", 8);
        FORMAT_WXGF = avifFormat9;
        AvifFormat avifFormat10 = new AvifFormat("FORMAT_SHARPP", 9);
        FORMAT_SHARPP = avifFormat10;
        AvifFormat avifFormat11 = new AvifFormat("FORMAT_HEIC", 10);
        FORMAT_HEIC = avifFormat11;
        AvifFormat avifFormat12 = new AvifFormat("FORMAT_TPG", 11);
        FORMAT_TPG = avifFormat12;
        AvifFormat avifFormat13 = new AvifFormat("FORMAT_AVIF", 12);
        FORMAT_AVIF = avifFormat13;
        AvifFormat avifFormat14 = new AvifFormat("FORMAT_AVIS", 13);
        FORMAT_AVIS = avifFormat14;
        $VALUES = new AvifFormat[]{avifFormat, avifFormat2, avifFormat3, avifFormat4, avifFormat5, avifFormat6, avifFormat7, avifFormat8, avifFormat9, avifFormat10, avifFormat11, avifFormat12, avifFormat13, avifFormat14};
    }

    AvifFormat(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AvifFormat valueOf(String str) {
        return (AvifFormat) Enum.valueOf(AvifFormat.class, str);
    }

    public static AvifFormat[] values() {
        return (AvifFormat[]) $VALUES.clone();
    }
}
