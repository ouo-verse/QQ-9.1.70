package com.tencent.gamematrix.gmcg.api;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgCodecAbility {
    CODEC_HARDWARE("1", "hard"),
    CODEC_SOFTWARE("2", "soft"),
    CODEC_HARDWARE_BAD("3", "hard_bad"),
    CODEC_SOFTWARE_BAD("4", "soft_bad"),
    CODEC_BOTH_BAD("5", WidgetCacheConstellationData.BAD);

    private final String mName;
    private final String mValue;

    GmCgCodecAbility(String str, String str2) {
        this.mValue = str;
        this.mName = str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static GmCgCodecAbility fromValue(String str) {
        char c16;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 50:
                if (str.equals("2")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 51:
                if (str.equals("3")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 52:
                if (str.equals("4")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 53:
                if (str.equals("5")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        if (c16 != 0) {
            if (c16 != 1) {
                if (c16 != 2) {
                    if (c16 != 3) {
                        return CODEC_BOTH_BAD;
                    }
                    return CODEC_HARDWARE;
                }
                return CODEC_SOFTWARE;
            }
            return CODEC_HARDWARE_BAD;
        }
        return CODEC_SOFTWARE_BAD;
    }

    public static boolean isAbility(String str, GmCgCodecAbility gmCgCodecAbility) {
        if (gmCgCodecAbility == fromValue(str)) {
            return true;
        }
        return false;
    }

    public static boolean isHardwareAbility(String str) {
        if (CODEC_HARDWARE == fromValue(str)) {
            return true;
        }
        return false;
    }

    public static boolean isHardwareAbilityOfWeak(String str) {
        if (!isAbility(str, CODEC_HARDWARE) && !isAbility(str, CODEC_HARDWARE_BAD)) {
            return false;
        }
        return true;
    }

    public static boolean isTooBadAbility(String str) {
        return isAbility(str, CODEC_BOTH_BAD);
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }
}
