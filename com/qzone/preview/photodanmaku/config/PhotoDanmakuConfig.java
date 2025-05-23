package com.qzone.preview.photodanmaku.config;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.qzone.util.ar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;

/* loaded from: classes39.dex */
public class PhotoDanmakuConfig {
    public static final int DEFAULT_ALPHA = 255;
    public static final float DEFAULT_BARRAGE_EFFECT_HORIZONTAL_PADDING = 15.0f;
    public static final float DEFAULT_BARRAGE_EFFECT_VERTICAL_PADDING = 10.0f;
    public static final float DEFAULT_BORDER_WIDTG = 6.0f;
    public static final boolean DEFAULT_CLICK_ENABLE = true;
    public static final boolean DEFAULT_DRAW_CACHE_ENABLE = true;
    public static final int DEFAULT_DURATION = 8000;
    public static final boolean DEFAULT_HAS_ANTI_ALIAS = true;
    public static final int DEFAULT_INTERAL = 800;
    public static final float DEFAULT_LEFT_IMAGE_PADDING = 2.0f;
    public static final int DEFAULT_MARGIN_HORIZONTAL = 9;
    public static final int DEFAULT_MARGIN_TOP = 16;
    public static final int DEFAULT_MARGIN_VERTICAL = 16;
    public static final int DEFAULT_MARGIN_VERTICAL_SCENE_VIDEO = 4;
    public static final int DEFAULT_MAX_CONTENT_LENGTH = 30;
    public static final int DEFAULT_MAX_NICK_NAME_LENGTH = 16;
    public static final int DEFAULT_MAX_NICK_NAME_LENGTH_SCENE_VIDEO = 10;
    public static final float DEFAULT_PADDING_HORIZONTAL = 2.0f;
    public static final float DEFAULT_PADDING_VERTICAL = 2.0f;
    public static final int DEFAULT_ROWS_R2L = 2;
    public static final int DEFAULT_TEXT_COLOR = -1;
    public static final int DEFAULT_TEXT_SIZE = 14;
    public static final int SCENE_ALBUM = 1;
    public static final int SCENE_VIDEO = 2;
    public int mAlpha;
    public float mBarrageEffectHorizontalPadding;
    public float mBarrageEffectVerticalPadding;
    public float mBorderWidth;
    public boolean mClickEnable;
    public boolean mDrawCacheEnable;
    public int mDuration;
    public boolean mHasAntiAlias;
    public float mLeftImagePadding;
    public int mMarginHorizontal;
    public int mMarginVertical;
    public float mPaddingHorizontal;
    public float mPaddingVertical;
    public int mRowCount;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mTextColor;
    public float mTextSize;
    public int mWindowMarginTop;
    public int maxContentLength;
    public int maxNickNameLength;
    public static final SparseArray<PhotoDanmakuConfig> CONFIGS = new SparseArray<>();
    public static boolean sGlobalDrawCacheEnable = true;

    PhotoDanmakuConfig(Context context, int i3, int i16) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i17 = displayMetrics.widthPixels;
        int i18 = displayMetrics.heightPixels;
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            this.mScreenHeight = Math.min(i17, i18);
            this.mScreenWidth = Math.max(i17, i18);
        } else {
            this.mScreenHeight = Math.max(i17, i18);
            this.mScreenWidth = Math.min(i17, i18);
        }
        if (i16 == 1) {
            this.mDuration = 8000;
            this.mWindowMarginTop = ar.d(16.0f) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + SystemUtil.getNotchHeight(BaseApplicationImpl.getApplication(), null);
            this.mMarginVertical = ar.d(16.0f);
            this.mMarginHorizontal = ar.d(9.0f);
            this.mPaddingHorizontal = ar.d(2.0f);
            this.mPaddingVertical = ar.d(2.0f);
            this.mBarrageEffectHorizontalPadding = ar.d(15.0f);
            this.mBarrageEffectVerticalPadding = ar.d(10.0f);
            this.mAlpha = 255;
            this.mTextSize = ar.d(14.0f);
            this.mTextColor = -1;
            this.maxNickNameLength = 16;
            this.maxContentLength = 30;
            this.mLeftImagePadding = ar.d(2.0f);
            this.mHasAntiAlias = true;
            this.mClickEnable = true;
            this.mDrawCacheEnable = true;
            this.mBorderWidth = ar.d(6.0f);
            this.mRowCount = 2;
            return;
        }
        if (i16 != 2) {
            return;
        }
        this.mDuration = 8000;
        this.mWindowMarginTop = ar.d(40) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        this.mMarginVertical = ar.d(4.0f);
        this.mMarginHorizontal = ar.d(9.0f);
        this.mPaddingHorizontal = ar.d(2.0f);
        this.mPaddingVertical = ar.d(2.0f);
        this.mBarrageEffectHorizontalPadding = ar.d(15.0f);
        this.mBarrageEffectVerticalPadding = ar.d(10.0f);
        this.mAlpha = 255;
        this.mTextSize = ar.d(14.0f);
        this.mTextColor = -1;
        this.maxNickNameLength = 10;
        this.maxContentLength = 30;
        this.mLeftImagePadding = ar.d(2.0f);
        this.mHasAntiAlias = true;
        this.mClickEnable = true;
        this.mDrawCacheEnable = true;
        this.mBorderWidth = ar.d(6.0f);
        this.mRowCount = 2;
    }

    public static PhotoDanmakuConfig getConfig(Context context, int i3, int i16) {
        SparseArray<PhotoDanmakuConfig> sparseArray = CONFIGS;
        int i17 = (i3 * 10) + i16;
        PhotoDanmakuConfig photoDanmakuConfig = sparseArray.get(i17);
        if (photoDanmakuConfig == null) {
            synchronized (PhotoDanmakuConfig.class) {
                photoDanmakuConfig = sparseArray.get(i17);
                if (photoDanmakuConfig == null) {
                    photoDanmakuConfig = new PhotoDanmakuConfig(context, i3, i16);
                    sparseArray.put(i17, photoDanmakuConfig);
                }
            }
        }
        return photoDanmakuConfig;
    }

    public static boolean isGlobalDrawCacheEnable() {
        return sGlobalDrawCacheEnable;
    }

    public static void setsGlobalDrawCacheEnable(boolean z16) {
        sGlobalDrawCacheEnable = z16;
    }
}
