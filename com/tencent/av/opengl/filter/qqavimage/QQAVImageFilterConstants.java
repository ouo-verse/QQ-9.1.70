package com.tencent.av.opengl.filter.qqavimage;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageEffectFilterConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageFilterConstants {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface FilterEffect extends QQAVImageEffectFilterConstants.QQAVEFFECT {
        public static final int QQAVARTFILTER = 9;
        public static final int QQAVBLUR = 1008;
        public static final int QQAVBOX = 1015;
        public static final int QQAVBULGEDISTORTION = 1007;
        public static final int QQAVDANCEGAME = 10;
        public static final int QQAVGHOST = 1010;
        public static final int QQAVKALEIDOSCOPE = 1009;
        public static final int QQAVMIRROR = 1006;
        public static final int QQAVMIRROR_VERTICAL = 1016;
        public static final int QQAVOLDTV = 1012;
        public static final int QQAVSHAKE = 1013;
        public static final int QQAVSOUL = 1014;
        public static final int QQAVWRONGERASE = 1011;
        public static final int QQFILM = 1018;
        public static final int QQMTV1 = 1017;
        public static final int QQPTUCOLORFILTER = 12;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface QQAVEFFECT_TYPE {
        public static final int ART_FILTER = 1;
        public static final int DANCE_GAME_FILTER = 3;
        public static final int MTV_FILTER = 4;
        public static final int NORMAL_FILTER = 0;
        public static final int PTU_COLOR_FILTER = 5;
        public static final int SPECIAL_FILTER = 2;
    }

    public static int getFilterType(int i3) {
        if (i3 == 9) {
            return 1;
        }
        if (i3 != 1006 && i3 != 1016 && i3 != 1007 && i3 != 1008 && i3 != 1009 && i3 != 1010 && i3 != 1011 && i3 != 1012 && i3 != 1013 && i3 != 1014 && i3 != 1015) {
            if (i3 == 10) {
                return 3;
            }
            if (i3 != 1017 && i3 != 1018) {
                if (i3 == 12) {
                    return 5;
                }
                return 0;
            }
            return 4;
        }
        return 2;
    }

    public static boolean isMusicSpecialFilter(int i3) {
        if (i3 != 1013 && i3 != 1014 && i3 != 1017) {
            return false;
        }
        return true;
    }

    public static boolean isNormalFilterSpecialCases(int i3, String str) {
        if (getFilterType(i3) == 0 && str.equals("MANHUA")) {
            return true;
        }
        return false;
    }
}
