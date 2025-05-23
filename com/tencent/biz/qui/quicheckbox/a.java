package com.tencent.biz.qui.quicheckbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static Drawable a(Context context, int i3) {
        return f(e(context, 0, R.color.qui_common_icon_tertiary, i3), new LayerDrawable(new Drawable[]{e(context, R.color.qui_common_brand_standard, 0, i3), j(context, R.drawable.qui_common_check_on_brand_primary, R.color.qui_common_on_brand_primary, i3)}));
    }

    public static Drawable b(Context context, int i3) {
        return f(e(context, R.color.qui_common_fill_standard_secondary, R.color.qui_common_icon_tertiary, i3), new LayerDrawable(new Drawable[]{e(context, R.color.qui_common_fill_standard_secondary, 0, i3), j(context, R.drawable.qui_common_check_icon_secondary, R.color.qui_common_icon_secondary, i3)}));
    }

    public static Drawable c(Context context, int i3) {
        return f(ContextCompat.getDrawable(context, R.drawable.qui_common_check_box_unchecked_no_bg), j(context, R.drawable.qui_common_check_box_checked_no_bg, R.color.qui_common_brand_standard, i3));
    }

    public static Drawable d(Context context, int i3) {
        return f(ContextCompat.getDrawable(context, R.drawable.qui_common_check_box_unchecked_no_bg), j(context, R.drawable.qui_common_check_box_checked_no_bg, R.color.qui_common_brand_standard, i3));
    }

    private static GradientDrawable e(Context context, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (i3 == 0) {
            gradientDrawable.setColor(0);
        } else {
            gradientDrawable.setColor(ie0.a.f().h(context, i3, i17));
        }
        int a16 = e.a(1.0f);
        if (i16 != 0) {
            gradientDrawable.setStroke(a16, ie0.a.f().h(context, i16, i17));
        }
        gradientDrawable.setSize(e.a(24.0f), e.a(24.0f));
        return gradientDrawable;
    }

    private static StateListDrawable f(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static Drawable g(Context context, int i3) {
        return f(e(context, 0, R.color.qui_common_icon_tertiary, i3), e(context, R.color.qui_common_brand_standard, 0, i3));
    }

    public static Drawable h(Context context, int i3) {
        return f(ContextCompat.getDrawable(context, R.drawable.qui_common_check_box_unchecked_white_border), e(context, R.color.qui_common_brand_standard, R.color.qui_common_icon_white, i3));
    }

    public static Drawable i(Context context, int i3) {
        return f(ContextCompat.getDrawable(context, R.drawable.qui_common_check_box_unchecked_white_border), new LayerDrawable(new Drawable[]{e(context, R.color.qui_common_brand_standard, R.color.qui_common_icon_white, i3), j(context, R.drawable.qui_common_check_on_brand_primary, R.color.qui_common_on_brand_primary, i3)}));
    }

    private static Drawable j(Context context, int i3, int i16, int i17) {
        if (i17 == 1000) {
            return ContextCompat.getDrawable(context, i3);
        }
        return ie0.a.f().o(context, i3, i16, i17);
    }
}
