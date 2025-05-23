package com.tencent.mobileqq.activity.textanimation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static AnimatorSet a(View view) {
        int i3;
        int color = ResourcesCompat.getColor(view.getResources(), R.color.qui_common_brand_standard, view.getContext().getTheme());
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 51;
        } else {
            i3 = 25;
        }
        int alphaComponent = ColorUtils.setAlphaComponent(color, i3);
        ObjectAnimator duration = ObjectAnimator.ofInt(view, "backgroundColor", 16643300, alphaComponent).setDuration(16L);
        duration.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration2 = ObjectAnimator.ofInt(view, "backgroundColor", alphaComponent, alphaComponent).setDuration(1000L);
        duration2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration3 = ObjectAnimator.ofInt(view, "backgroundColor", alphaComponent, 16643300).setDuration(100L);
        duration3.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public static Boolean b() {
        return Boolean.valueOf(((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("locate_msg_animation"));
    }
}
