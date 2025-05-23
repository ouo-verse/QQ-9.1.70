package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;

/* compiled from: P */
/* loaded from: classes24.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static String a(boolean z16, int i3, PicElement picElement) {
        String emojiWebUrl;
        if (picElement == null || z16) {
            return "";
        }
        if (picElement.getOriginImageUrl() != null) {
            emojiWebUrl = picElement.getOriginImageUrl();
        } else {
            if (picElement.getEmojiWebUrl() == null) {
                return "";
            }
            emojiWebUrl = picElement.getEmojiWebUrl();
        }
        if (i3 != 2 && i3 != 3) {
            return EmotionPanelConstans.RELATED_EMO_C2C_HTTP_PREFIX + emojiWebUrl;
        }
        return EmotionPanelConstans.RELATED_EMO_GROUP_HTTP_PREFIX + emojiWebUrl;
    }

    public static String b(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 109 && i3 != 117) {
                        switch (i3) {
                            case 99:
                            case 100:
                            case 101:
                            case 102:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                                break;
                            case 103:
                                i16 = 4;
                                break;
                            default:
                                i16 = 999;
                                break;
                        }
                    }
                } else {
                    i16 = 2;
                }
            } else {
                i16 = 3;
            }
        } else {
            i16 = 0;
        }
        return String.valueOf(i16);
    }

    public static int c(int i3) {
        if (i3 == -1) {
            return 0;
        }
        int parseInt = Integer.parseInt(b(i3));
        if (parseInt == 0) {
            return 2;
        }
        if (parseInt == 1) {
            return 3;
        }
        if (parseInt != 2) {
            if (parseInt != 3) {
                return 0;
            }
            return 1;
        }
        return 4;
    }

    public static String d(PicElement picElement) {
        if (picElement == null) {
            return "";
        }
        if (picElement.getPicSubType() == 0) {
            return "2";
        }
        if (picElement.getPicSubType() == 8) {
            return "3";
        }
        if (picElement.getPicSubType() == 2) {
            return "6";
        }
        if (picElement.getPicSubType() == 3) {
            return "7";
        }
        if (picElement.getPicSubType() == 4) {
            return "8";
        }
        if (picElement.getPicSubType() != 7 && picElement.getPicSubType() != 9) {
            if (picElement.getPicSubType() == 10) {
                return "10";
            }
            if (picElement.getPicType().intValue() != 2000 && picElement.getPicType().intValue() != 2) {
                return "";
            }
            return "9";
        }
        return "5";
    }
}
