package com.tencent.aekit.plugin.core;

import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AEDetectorType {
    private static final /* synthetic */ AEDetectorType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AEDetectorType AR_DETECT;
    public static final AEDetectorType BODY;
    public static final AEDetectorType CAT;
    public static final AEDetectorType EMOTION;
    public static final AEDetectorType FACE;
    public static final AEDetectorType FACE_MARKING;
    public static final AEDetectorType GENDER_DETECT;
    public static final AEDetectorType HAIR_SEGMENT;
    public static final AEDetectorType HAND;
    public static final AEDetectorType RGB_DEPTH;
    public static final AEDetectorType SEGMENT;
    public static final AEDetectorType SKY_SEGMENT;
    public static final AEDetectorType VOICE_RECOGNIZE;
    public String value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AEDetectorType aEDetectorType = new AEDetectorType("FACE", 0, "FaceDetector");
        FACE = aEDetectorType;
        AEDetectorType aEDetectorType2 = new AEDetectorType("HAND", 1, "HandDetector");
        HAND = aEDetectorType2;
        AEDetectorType aEDetectorType3 = new AEDetectorType("FACE_MARKING", 2, "FaceMarkingDetector");
        FACE_MARKING = aEDetectorType3;
        AEDetectorType aEDetectorType4 = new AEDetectorType(HeytapHealthParams.BODY, 3, "BodyDetector");
        BODY = aEDetectorType4;
        AEDetectorType aEDetectorType5 = new AEDetectorType("EMOTION", 4, "EmotionDetector");
        EMOTION = aEDetectorType5;
        AEDetectorType aEDetectorType6 = new AEDetectorType("SEGMENT", 5, "Segmentor");
        SEGMENT = aEDetectorType6;
        AEDetectorType aEDetectorType7 = new AEDetectorType("HAIR_SEGMENT", 6, "Hair_Segmentor");
        HAIR_SEGMENT = aEDetectorType7;
        AEDetectorType aEDetectorType8 = new AEDetectorType("SKY_SEGMENT", 7, "Sky_Segmentor");
        SKY_SEGMENT = aEDetectorType8;
        AEDetectorType aEDetectorType9 = new AEDetectorType("VOICE_RECOGNIZE", 8, "Voice_Recognize");
        VOICE_RECOGNIZE = aEDetectorType9;
        AEDetectorType aEDetectorType10 = new AEDetectorType("GENDER_DETECT", 9, "GenderDetect");
        GENDER_DETECT = aEDetectorType10;
        AEDetectorType aEDetectorType11 = new AEDetectorType("CAT", 10, "CatDetector");
        CAT = aEDetectorType11;
        AEDetectorType aEDetectorType12 = new AEDetectorType("AR_DETECT", 11, "ARDetect");
        AR_DETECT = aEDetectorType12;
        AEDetectorType aEDetectorType13 = new AEDetectorType("RGB_DEPTH", 12, "RGB_Depth");
        RGB_DEPTH = aEDetectorType13;
        $VALUES = new AEDetectorType[]{aEDetectorType, aEDetectorType2, aEDetectorType3, aEDetectorType4, aEDetectorType5, aEDetectorType6, aEDetectorType7, aEDetectorType8, aEDetectorType9, aEDetectorType10, aEDetectorType11, aEDetectorType12, aEDetectorType13};
    }

    AEDetectorType(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.value = str2;
        }
    }

    public static AEDetectorType valueOf(String str) {
        return (AEDetectorType) Enum.valueOf(AEDetectorType.class, str);
    }

    public static AEDetectorType[] values() {
        return (AEDetectorType[]) $VALUES.clone();
    }
}
