package com.tencent.rtmp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes25.dex */
public final class TXVideoResolution {
    private static final /* synthetic */ TXVideoResolution[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TXVideoResolution RESOLUTION_TYPE_1080_1920;
    public static final TXVideoResolution RESOLUTION_TYPE_120_120;
    public static final TXVideoResolution RESOLUTION_TYPE_1280_720;
    public static final TXVideoResolution RESOLUTION_TYPE_160_160;
    public static final TXVideoResolution RESOLUTION_TYPE_180_320;
    public static final TXVideoResolution RESOLUTION_TYPE_1920_1080;
    public static final TXVideoResolution RESOLUTION_TYPE_240_320;
    public static final TXVideoResolution RESOLUTION_TYPE_270_270;
    public static final TXVideoResolution RESOLUTION_TYPE_270_480;
    public static final TXVideoResolution RESOLUTION_TYPE_320_180;
    public static final TXVideoResolution RESOLUTION_TYPE_320_240;
    public static final TXVideoResolution RESOLUTION_TYPE_320_480;
    public static final TXVideoResolution RESOLUTION_TYPE_360_480;
    public static final TXVideoResolution RESOLUTION_TYPE_360_640;
    public static final TXVideoResolution RESOLUTION_TYPE_480_270;
    public static final TXVideoResolution RESOLUTION_TYPE_480_360;
    public static final TXVideoResolution RESOLUTION_TYPE_480_480;
    public static final TXVideoResolution RESOLUTION_TYPE_480_640;
    public static final TXVideoResolution RESOLUTION_TYPE_540_960;
    public static final TXVideoResolution RESOLUTION_TYPE_640_360;
    public static final TXVideoResolution RESOLUTION_TYPE_640_480;
    public static final TXVideoResolution RESOLUTION_TYPE_720_1280;
    public static final TXVideoResolution RESOLUTION_TYPE_960_540;
    public static final TXVideoResolution RESOLUTION_TYPE_INVALID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22590);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TXVideoResolution tXVideoResolution = new TXVideoResolution("RESOLUTION_TYPE_INVALID", 0);
        RESOLUTION_TYPE_INVALID = tXVideoResolution;
        TXVideoResolution tXVideoResolution2 = new TXVideoResolution("RESOLUTION_TYPE_360_640", 1);
        RESOLUTION_TYPE_360_640 = tXVideoResolution2;
        TXVideoResolution tXVideoResolution3 = new TXVideoResolution("RESOLUTION_TYPE_540_960", 2);
        RESOLUTION_TYPE_540_960 = tXVideoResolution3;
        TXVideoResolution tXVideoResolution4 = new TXVideoResolution("RESOLUTION_TYPE_720_1280", 3);
        RESOLUTION_TYPE_720_1280 = tXVideoResolution4;
        TXVideoResolution tXVideoResolution5 = new TXVideoResolution("RESOLUTION_TYPE_640_360", 4);
        RESOLUTION_TYPE_640_360 = tXVideoResolution5;
        TXVideoResolution tXVideoResolution6 = new TXVideoResolution("RESOLUTION_TYPE_960_540", 5);
        RESOLUTION_TYPE_960_540 = tXVideoResolution6;
        TXVideoResolution tXVideoResolution7 = new TXVideoResolution("RESOLUTION_TYPE_1280_720", 6);
        RESOLUTION_TYPE_1280_720 = tXVideoResolution7;
        TXVideoResolution tXVideoResolution8 = new TXVideoResolution("RESOLUTION_TYPE_320_480", 7);
        RESOLUTION_TYPE_320_480 = tXVideoResolution8;
        TXVideoResolution tXVideoResolution9 = new TXVideoResolution("RESOLUTION_TYPE_180_320", 8);
        RESOLUTION_TYPE_180_320 = tXVideoResolution9;
        TXVideoResolution tXVideoResolution10 = new TXVideoResolution("RESOLUTION_TYPE_270_480", 9);
        RESOLUTION_TYPE_270_480 = tXVideoResolution10;
        TXVideoResolution tXVideoResolution11 = new TXVideoResolution("RESOLUTION_TYPE_320_180", 10);
        RESOLUTION_TYPE_320_180 = tXVideoResolution11;
        TXVideoResolution tXVideoResolution12 = new TXVideoResolution("RESOLUTION_TYPE_480_270", 11);
        RESOLUTION_TYPE_480_270 = tXVideoResolution12;
        TXVideoResolution tXVideoResolution13 = new TXVideoResolution("RESOLUTION_TYPE_240_320", 12);
        RESOLUTION_TYPE_240_320 = tXVideoResolution13;
        TXVideoResolution tXVideoResolution14 = new TXVideoResolution("RESOLUTION_TYPE_360_480", 13);
        RESOLUTION_TYPE_360_480 = tXVideoResolution14;
        TXVideoResolution tXVideoResolution15 = new TXVideoResolution("RESOLUTION_TYPE_480_640", 14);
        RESOLUTION_TYPE_480_640 = tXVideoResolution15;
        TXVideoResolution tXVideoResolution16 = new TXVideoResolution("RESOLUTION_TYPE_320_240", 15);
        RESOLUTION_TYPE_320_240 = tXVideoResolution16;
        TXVideoResolution tXVideoResolution17 = new TXVideoResolution("RESOLUTION_TYPE_480_360", 16);
        RESOLUTION_TYPE_480_360 = tXVideoResolution17;
        TXVideoResolution tXVideoResolution18 = new TXVideoResolution("RESOLUTION_TYPE_640_480", 17);
        RESOLUTION_TYPE_640_480 = tXVideoResolution18;
        TXVideoResolution tXVideoResolution19 = new TXVideoResolution("RESOLUTION_TYPE_480_480", 18);
        RESOLUTION_TYPE_480_480 = tXVideoResolution19;
        TXVideoResolution tXVideoResolution20 = new TXVideoResolution("RESOLUTION_TYPE_270_270", 19);
        RESOLUTION_TYPE_270_270 = tXVideoResolution20;
        TXVideoResolution tXVideoResolution21 = new TXVideoResolution("RESOLUTION_TYPE_160_160", 20);
        RESOLUTION_TYPE_160_160 = tXVideoResolution21;
        TXVideoResolution tXVideoResolution22 = new TXVideoResolution("RESOLUTION_TYPE_120_120", 21);
        RESOLUTION_TYPE_120_120 = tXVideoResolution22;
        TXVideoResolution tXVideoResolution23 = new TXVideoResolution("RESOLUTION_TYPE_1080_1920", 22);
        RESOLUTION_TYPE_1080_1920 = tXVideoResolution23;
        TXVideoResolution tXVideoResolution24 = new TXVideoResolution("RESOLUTION_TYPE_1920_1080", 23);
        RESOLUTION_TYPE_1920_1080 = tXVideoResolution24;
        $VALUES = new TXVideoResolution[]{tXVideoResolution, tXVideoResolution2, tXVideoResolution3, tXVideoResolution4, tXVideoResolution5, tXVideoResolution6, tXVideoResolution7, tXVideoResolution8, tXVideoResolution9, tXVideoResolution10, tXVideoResolution11, tXVideoResolution12, tXVideoResolution13, tXVideoResolution14, tXVideoResolution15, tXVideoResolution16, tXVideoResolution17, tXVideoResolution18, tXVideoResolution19, tXVideoResolution20, tXVideoResolution21, tXVideoResolution22, tXVideoResolution23, tXVideoResolution24};
    }

    TXVideoResolution(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TXVideoResolution valueOf(String str) {
        return (TXVideoResolution) Enum.valueOf(TXVideoResolution.class, str);
    }

    public static TXVideoResolution[] values() {
        return (TXVideoResolution[]) $VALUES.clone();
    }
}
