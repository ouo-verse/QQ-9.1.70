package com.tencent.qqmini.sdk.widget.media.danmu;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AnimationHelper {
    public static Animation createTranslateAnim(Context context, int i3, int i16) {
        TranslateAnimation translateAnimation = new TranslateAnimation(i3, i16, 0.0f, 0.0f);
        translateAnimation.setDuration(((Math.abs(i16 - i3) * 1.0f) / DisplayUtil.getScreenWidth(context)) * 3000.0f);
        translateAnimation.setInterpolator(new DecelerateAccelerateInterpolator());
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }
}
