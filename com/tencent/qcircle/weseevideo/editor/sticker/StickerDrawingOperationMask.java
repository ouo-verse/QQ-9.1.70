package com.tencent.qcircle.weseevideo.editor.sticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerDrawingOperationMask {
    public static final int DRAW_ALL = 63;
    public static final int DRAW_ALL_BTN = 15;
    public static final int DRAW_ALL_BTN_AND_BORDER = 31;
    public static final int DRAW_BORDER = 16;
    public static final int DRAW_GUIDE_LINE = 32;
    public static final int DRAW_LEFT_BOTTOM_BTN = 8;
    public static final int DRAW_LEFT_TOP_BTN = 1;
    public static final int DRAW_RIGHT_BOTTOM_BTN = 4;
    public static final int DRAW_RIGHT_TOP_BTN = 2;
    public static final int NO_DRAW_ALL_BTN_AND_BORDER = 0;

    public static boolean isDrawBorder(int i3) {
        if (1 == ((i3 >> 4) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDrawGuideLine(int i3) {
        if (1 == ((i3 >> 5) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDrawLeftBottom(int i3) {
        if (1 == ((i3 >> 3) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDrawLeftTop(int i3) {
        if (1 == (i3 & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDrawRightBottom(int i3) {
        if (1 == ((i3 >> 2) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDrawRightTop(int i3) {
        if (1 == ((i3 >> 1) & 1)) {
            return true;
        }
        return false;
    }
}
