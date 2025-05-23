package com.tencent.qcircle.weseevideo.editor.sticker.model;

import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVStickerExKt {
    public static String getExtraStickerType(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            return tAVSticker.getExtraBundle().getString("key_extra_sticker_type");
        }
        return null;
    }

    public static int getLastStickerTextColr(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            return tAVSticker.getExtraBundle().getInt(Constants.STICKER.KEY_LAST_STICKER_TEXT_COLOR);
        }
        return -1;
    }

    public static String getLastStickerTextContent(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            return tAVSticker.getExtraBundle().getString(Constants.STICKER.KEY_LAST_STICKER_TEXT_CONTENT);
        }
        return null;
    }

    public static String getLastStickerTextFont(TAVSticker tAVSticker) {
        if (tAVSticker != null) {
            return tAVSticker.getExtraBundle().getString(Constants.STICKER.KEY_LAST_STICKER_TEXT_FONT);
        }
        return null;
    }

    public static float getSticerScaleMinY(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_MIN_Y, 0.0f);
    }

    public static int getStickerInteractive(TAVSticker tAVSticker) {
        if (tAVSticker == null) {
            return 0;
        }
        return tAVSticker.getExtraBundle().getInt(Constants.STICKER.KEY_STICKER_INTERACTIVE, 0);
    }

    public static float getStickerScaleMaxX(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_MAX_X, 0.0f);
    }

    public static float getStickerScaleMaxY(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_MAX_Y, 0.0f);
    }

    public static float getStickerScaleMinX(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_MIN_X, 0.0f);
    }

    public static float getStickerScaleX(TAVSticker tAVSticker) {
        if (tAVSticker == null) {
            return 0.0f;
        }
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_X, 1.0f);
    }

    public static float getStickerScaleY(TAVSticker tAVSticker) {
        if (tAVSticker == null) {
            return 0.0f;
        }
        return tAVSticker.getExtraBundle().getFloat(Constants.STICKER.KEY_STICKER_SCALE_Y, 1.0f);
    }

    public static String getStickerTextPngPath(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getString(Constants.STICKER.KEY_STICKER_TEXT_PATH);
    }

    public static String getStickerTexturePngPath(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getString(Constants.STICKER.KEY_STICKER_TEXTURE_PATH);
    }

    public static boolean isLockRatio(TAVSticker tAVSticker) {
        if (tAVSticker != null && tAVSticker.getExtraBundle().getBoolean(Constants.STICKER.KEY_STICKER_LOCK_RATIO, true)) {
            return true;
        }
        return false;
    }

    public static boolean isRotateEnable(TAVSticker tAVSticker) {
        if (tAVSticker != null && tAVSticker.getExtraBundle().getBoolean(Constants.STICKER.KEY_STICKER_ENABLE_ROTATE, true)) {
            return true;
        }
        return false;
    }

    public static boolean isStickerCarryTextFromOther(TAVSticker tAVSticker) {
        return tAVSticker.getExtraBundle().getBoolean(Constants.STICKER.KEY_STICKER_CARRY_TEXT_FROM_OTHERS, !"blur".equals(getExtraStickerType(tAVSticker)));
    }

    public static void markLastStickerTextData(TAVSticker tAVSticker, String str, String str2, int i3) {
        if (tAVSticker != null) {
            tAVSticker.getExtraBundle().putString(Constants.STICKER.KEY_LAST_STICKER_TEXT_FONT, str);
            tAVSticker.getExtraBundle().putString(Constants.STICKER.KEY_LAST_STICKER_TEXT_CONTENT, str2);
            tAVSticker.getExtraBundle().putInt(Constants.STICKER.KEY_LAST_STICKER_TEXT_COLOR, i3);
        }
    }

    public static void setExtraStickerType(TAVSticker tAVSticker, String str) {
        if (tAVSticker != null) {
            tAVSticker.getExtraBundle().putString("key_extra_sticker_type", str);
        }
    }

    public static void setStickerCarryTextFromOther(TAVSticker tAVSticker, boolean z16) {
        tAVSticker.getExtraBundle().putBoolean(Constants.STICKER.KEY_STICKER_CARRY_TEXT_FROM_OTHERS, z16);
    }

    public static void setStickerEnableRotate(TAVSticker tAVSticker, boolean z16) {
        tAVSticker.getExtraBundle().putBoolean(Constants.STICKER.KEY_STICKER_ENABLE_ROTATE, z16);
    }

    public static void setStickerInteractive(TAVSticker tAVSticker, int i3) {
        tAVSticker.getExtraBundle().putInt(Constants.STICKER.KEY_STICKER_INTERACTIVE, i3);
    }

    public static void setStickerLockRatio(TAVSticker tAVSticker, boolean z16) {
        tAVSticker.getExtraBundle().putBoolean(Constants.STICKER.KEY_STICKER_LOCK_RATIO, z16);
    }

    public static void setStickerScaleMaxX(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_MAX_X, f16);
    }

    public static void setStickerScaleMaxY(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_MAX_Y, f16);
    }

    public static void setStickerScaleMinX(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_MIN_X, f16);
    }

    public static void setStickerScaleMinY(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_MIN_Y, f16);
    }

    public static void setStickerScaleX(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_X, f16);
    }

    public static void setStickerScaleY(TAVSticker tAVSticker, float f16) {
        tAVSticker.getExtraBundle().putFloat(Constants.STICKER.KEY_STICKER_SCALE_Y, f16);
    }

    public static void setStickerTextPngPath(TAVSticker tAVSticker, String str) {
        tAVSticker.getExtraBundle().putString(Constants.STICKER.KEY_STICKER_TEXT_PATH, str);
    }

    public static void setStickerTexturePngPath(TAVSticker tAVSticker, String str) {
        tAVSticker.getExtraBundle().putString(Constants.STICKER.KEY_STICKER_TEXTURE_PATH, str);
    }
}
