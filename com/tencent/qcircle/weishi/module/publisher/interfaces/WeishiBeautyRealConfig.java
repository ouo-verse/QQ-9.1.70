package com.tencent.qcircle.weishi.module.publisher.interfaces;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WeishiBeautyRealConfig {
    public static final TYPE[] SINGLE_TRANS_TYPE;
    public static final TYPE[] SINGLE_TRANS_TYPE_573;
    public static final TYPE[] SINGLE_TRANS_TYPE_580;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum TYPE {
        BEAUTY(0),
        FACE_V(1),
        FACE_THIN(2),
        CHIN(3),
        EYE(4),
        NOSE(5),
        NONE(6),
        NATURE(7),
        CUTE(8),
        MELON(9),
        FACE_SHORTEN(10),
        BASIC3(11),
        REMOVE_POUNCH(12),
        EYE_LIGHTEN(13),
        AUTO_BRIGHTNESS(14),
        FOREHEAD(15),
        EYE_DISTANCE(16),
        EYE_ANGLE(17),
        MOUTH_SHAPE(18),
        TOOTH_WHITEN(19),
        COLOR_TONE(20),
        CONTRAST_RATIO(21),
        NOSE_WING(22),
        NOSE_POSITION(23),
        LIPS_THICKNESS(24),
        LIPS_WIDTH(25),
        WUGUANLITI(26),
        FACECOLOR(27),
        LONG_LEG(28),
        REMOVE_WRINKLES(29),
        REMOVE_WRINKLES2(30),
        BASIC4(31),
        BASIC5(32),
        BASIC6(33),
        BASIC7(34),
        BASIC8(35),
        SHUIGUANGJI(36),
        CHEEKBONE_THIN(37),
        SHARPEN(38),
        SLIM_WAIST(39),
        THIN_SHOULDER(40),
        THIN_BODY(41),
        EMPTY(-1);

        public final int value;

        TYPE(int i3) {
            this.value = i3;
        }
    }

    static {
        TYPE type = TYPE.FACE_V;
        TYPE type2 = TYPE.FACE_THIN;
        TYPE type3 = TYPE.FACE_SHORTEN;
        TYPE type4 = TYPE.CHIN;
        TYPE type5 = TYPE.EYE;
        TYPE type6 = TYPE.NOSE;
        SINGLE_TRANS_TYPE_573 = new TYPE[]{type, type2, type3, type4, type5, type6, TYPE.BASIC3};
        TYPE type7 = TYPE.FOREHEAD;
        TYPE type8 = TYPE.EYE_LIGHTEN;
        TYPE type9 = TYPE.EYE_DISTANCE;
        TYPE type10 = TYPE.EYE_ANGLE;
        TYPE type11 = TYPE.NOSE_WING;
        TYPE type12 = TYPE.NOSE_POSITION;
        TYPE type13 = TYPE.MOUTH_SHAPE;
        TYPE type14 = TYPE.TOOTH_WHITEN;
        TYPE type15 = TYPE.COLOR_TONE;
        TYPE type16 = TYPE.REMOVE_POUNCH;
        TYPE type17 = TYPE.LIPS_THICKNESS;
        TYPE type18 = TYPE.LIPS_WIDTH;
        SINGLE_TRANS_TYPE_580 = new TYPE[]{type, type2, type3, type4, type7, type5, type8, type9, type10, type6, type11, type12, type13, type13, type14, type15, type16, type17, type18};
        SINGLE_TRANS_TYPE = new TYPE[]{type15, type16, type, type2, type3, type4, type7, type5, type8, type9, type10, type6, type13, type14, type11, type12, type13, type17, type18};
    }

    public static Map<TYPE, Integer> getBeautyLevels(int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        TYPE type = TYPE.BEAUTY;
        hashMap.put(type, 60);
        if (i3 == TYPE.NONE.value) {
            if (z16) {
                hashMap.put(type, 0);
                hashMap.put(TYPE.BASIC3, 0);
            } else {
                hashMap.put(type, 50);
                hashMap.put(TYPE.BASIC3, 55);
            }
            for (TYPE type2 : SINGLE_TRANS_TYPE_580) {
                hashMap.put(type2, 0);
            }
        }
        for (TYPE type3 : SINGLE_TRANS_TYPE_580) {
            if (!hashMap.containsKey(type3)) {
                hashMap.put(type3, 0);
            }
        }
        return hashMap;
    }

    public static boolean isFaceType(int i3) {
        if (i3 != TYPE.BASIC3.value && i3 != TYPE.BASIC4.value && i3 != TYPE.BASIC5.value && i3 != TYPE.BASIC6.value && i3 != TYPE.BASIC7.value && i3 != TYPE.BASIC8.value) {
            return false;
        }
        return true;
    }
}
