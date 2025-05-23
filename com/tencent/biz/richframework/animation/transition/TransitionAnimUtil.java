package com.tencent.biz.richframework.animation.transition;

import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionAnimUtil {
    private static Drawable mCacheDrawable;

    public static void clearCacheDrawable() {
        if (mCacheDrawable != null) {
            mCacheDrawable = null;
        }
    }

    public static Drawable getCoverDrawable() {
        return mCacheDrawable;
    }

    public static void saveCoverDrawable(Drawable drawable) {
        mCacheDrawable = drawable;
    }
}
