package ee0;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quicommon.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f396123a = new b();

    public static b g() {
        return f396123a;
    }

    public StateListDrawable a(Context context, int i3, int i16, int i17) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, d(context, i3, i16, i17));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, d(context, i3, i16, i17));
        stateListDrawable.addState(new int[]{-16842910}, c(context, i3, i16, i17));
        stateListDrawable.addState(new int[0], b(context, i3, i16, i17));
        return stateListDrawable;
    }

    public GradientDrawable b(Context context, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (context == null) {
            return gradientDrawable;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_outline_default, com.tencent.mobileqq.R.color.qui_button_border_primary_outline_default);
                        }
                    } else {
                        i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_error_default, com.tencent.mobileqq.R.color.qui_button_border_error_default);
                    }
                } else {
                    i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_ghost_default, com.tencent.mobileqq.R.color.qui_button_border_ghost_default);
                }
            } else {
                i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_secondary_default, com.tencent.mobileqq.R.color.qui_button_border_secondary_default);
            }
        } else {
            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_default, com.tencent.mobileqq.R.color.qui_button_border_primary_default);
        }
        gradientDrawable.setCornerRadius(f(context, i3, i16));
        return gradientDrawable;
    }

    public GradientDrawable c(Context context, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (context == null) {
            return gradientDrawable;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_outline_disable, com.tencent.mobileqq.R.color.qui_button_border_primary_outline_disable);
                        }
                    } else {
                        i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_error_disable, com.tencent.mobileqq.R.color.qui_button_border_error_disable);
                    }
                } else {
                    i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_ghost_disable, com.tencent.mobileqq.R.color.qui_button_border_ghost_disable);
                }
            } else {
                i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_secondary_disable, com.tencent.mobileqq.R.color.qui_button_border_secondary_disable);
            }
        } else {
            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_disable, com.tencent.mobileqq.R.color.qui_button_border_primary_disable);
        }
        gradientDrawable.setCornerRadius(f(context, i3, i16));
        return gradientDrawable;
    }

    public GradientDrawable d(Context context, int i3, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (context == null) {
            return gradientDrawable;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_outline_pressed, com.tencent.mobileqq.R.color.qui_button_border_primary_outline_pressed);
                        }
                    } else {
                        i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_error_pressed, com.tencent.mobileqq.R.color.qui_button_border_error_pressed);
                    }
                } else {
                    i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_ghost_pressed, com.tencent.mobileqq.R.color.qui_button_border_ghost_pressed);
                }
            } else {
                i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_secondary_pressed, com.tencent.mobileqq.R.color.qui_button_border_secondary_pressed);
            }
        } else {
            i(context, gradientDrawable, i3, i16, i17, com.tencent.mobileqq.R.color.qui_button_bg_primary_pressed, com.tencent.mobileqq.R.color.qui_button_border_primary_pressed);
        }
        gradientDrawable.setCornerRadius(f(context, i3, i16));
        return gradientDrawable;
    }

    @Deprecated
    public int e(Context context, int i3) {
        if (i3 == 3) {
            return e.b(context, 2.0f);
        }
        return e.b(context, 4.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(Context context, int i3, int i16) {
        return e(context, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h(Context context, int i3, int i16, int i17) {
        return e.b(context, 1.0f);
    }

    protected void i(@NonNull Context context, @NonNull GradientDrawable gradientDrawable, int i3, int i16, int i17, @ColorRes int i18, @ColorRes int i19) {
        gradientDrawable.setColor(ie0.a.f().g(context, i18, i17));
        int g16 = ie0.a.f().g(context, i19, i17);
        if (Color.alpha(g16) != 0) {
            gradientDrawable.setStroke(h(context, i3, i16, i17), g16);
        }
    }
}
