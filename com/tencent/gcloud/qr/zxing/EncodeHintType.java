package com.tencent.gcloud.qr.zxing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class EncodeHintType {
    private static final /* synthetic */ EncodeHintType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final EncodeHintType AZTEC_LAYERS;
    public static final EncodeHintType CHARACTER_SET;
    public static final EncodeHintType DATA_MATRIX_SHAPE;
    public static final EncodeHintType ERROR_CORRECTION;
    public static final EncodeHintType GS1_FORMAT;
    public static final EncodeHintType MARGIN;

    @Deprecated
    public static final EncodeHintType MAX_SIZE;

    @Deprecated
    public static final EncodeHintType MIN_SIZE;
    public static final EncodeHintType PDF417_COMPACT;
    public static final EncodeHintType PDF417_COMPACTION;
    public static final EncodeHintType PDF417_DIMENSIONS;
    public static final EncodeHintType QR_VERSION;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EncodeHintType encodeHintType = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = encodeHintType;
        EncodeHintType encodeHintType2 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = encodeHintType2;
        EncodeHintType encodeHintType3 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = encodeHintType3;
        EncodeHintType encodeHintType4 = new EncodeHintType("MIN_SIZE", 3);
        MIN_SIZE = encodeHintType4;
        EncodeHintType encodeHintType5 = new EncodeHintType("MAX_SIZE", 4);
        MAX_SIZE = encodeHintType5;
        EncodeHintType encodeHintType6 = new EncodeHintType("MARGIN", 5);
        MARGIN = encodeHintType6;
        EncodeHintType encodeHintType7 = new EncodeHintType("PDF417_COMPACT", 6);
        PDF417_COMPACT = encodeHintType7;
        EncodeHintType encodeHintType8 = new EncodeHintType("PDF417_COMPACTION", 7);
        PDF417_COMPACTION = encodeHintType8;
        EncodeHintType encodeHintType9 = new EncodeHintType("PDF417_DIMENSIONS", 8);
        PDF417_DIMENSIONS = encodeHintType9;
        EncodeHintType encodeHintType10 = new EncodeHintType("AZTEC_LAYERS", 9);
        AZTEC_LAYERS = encodeHintType10;
        EncodeHintType encodeHintType11 = new EncodeHintType("QR_VERSION", 10);
        QR_VERSION = encodeHintType11;
        EncodeHintType encodeHintType12 = new EncodeHintType("GS1_FORMAT", 11);
        GS1_FORMAT = encodeHintType12;
        $VALUES = new EncodeHintType[]{encodeHintType, encodeHintType2, encodeHintType3, encodeHintType4, encodeHintType5, encodeHintType6, encodeHintType7, encodeHintType8, encodeHintType9, encodeHintType10, encodeHintType11, encodeHintType12};
    }

    EncodeHintType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static EncodeHintType valueOf(String str) {
        return (EncodeHintType) Enum.valueOf(EncodeHintType.class, str);
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) $VALUES.clone();
    }
}
