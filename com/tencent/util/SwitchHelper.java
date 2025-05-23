package com.tencent.util;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SwitchHelper {
    static IPatchRedirector $redirector_ = null;
    public static final float SWITCH_TRACK_HEIGHT_DP = 26.0f;
    public static final float SWITCH_TRACK_RADIUS_DP = 29.0f;
    public static final float SWITCH_TRACK_WIDTH_DP = 47.0f;

    public SwitchHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static GradientDrawable buildTrackDrawable(Context context, int i3, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ie0.a.f().g(context, i16, i3));
        gradientDrawable.setCornerRadius(x.c(context, 29.0f));
        gradientDrawable.setSize(x.c(context, 47.0f), x.c(context, 26.0f));
        return gradientDrawable;
    }

    public static StateListDrawable buildTrackDrawable(Context context, int i3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, buildTrackDrawable(context, i3, com.tencent.mobileqq.R.color.qui_common_brand_standard));
        stateListDrawable.addState(new int[0], buildTrackDrawable(context, i3, com.tencent.mobileqq.R.color.qui_common_fill_standard_secondary));
        return stateListDrawable;
    }
}
