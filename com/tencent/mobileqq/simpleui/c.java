package com.tencent.mobileqq.simpleui;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static Drawable a(float[] fArr, int i3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(i3);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(fArr);
        gradientDrawable2.setColor(0);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static void b(Dialog dialog) {
        c(dialog, 1000);
    }

    public static void c(Dialog dialog, int i3) {
        Context context;
        View findViewById;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        if (dialog == null || (context = dialog.getContext()) == null) {
            return;
        }
        View findViewById2 = dialog.findViewById(com.tencent.mobileqq.R.id.vdy);
        if (findViewById2 == null) {
            findViewById = dialog.findViewById(com.tencent.mobileqq.R.id.bja);
        } else {
            findViewById = findViewById2.findViewById(com.tencent.mobileqq.R.id.bja);
        }
        if (findViewById == null) {
            return;
        }
        if (QQTheme.isNowSimpleUI()) {
            i16 = 4;
        } else {
            i16 = 6;
        }
        int c16 = x.c(context, i16);
        int g16 = ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_overlay_standard_primary, i3);
        TextView textView = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogLeftBtn);
        TextView textView2 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogRightBtn);
        TextView textView3 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.biv);
        if (textView != null && textView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (textView2 != null && textView2.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (textView3 != null && textView3.getVisibility() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            if (z16) {
                textView.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, g16));
            }
            if (z17) {
                textView2.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, g16));
            }
            float f16 = c16;
            textView3.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f16, f16, f16, f16}, g16));
            return;
        }
        if (z16 && z17) {
            float f17 = c16;
            textView.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f17, f17}, g16));
            textView2.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f17, f17, 0.0f, 0.0f}, g16));
        } else if (z16 || z17) {
            if (z16) {
                float f18 = c16;
                textView.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f18, f18, f18, f18}, g16));
            }
            if (z17) {
                float f19 = c16;
                textView2.setBackground(a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f19, f19, f19, f19}, g16));
            }
        }
    }

    public static void d(Dialog dialog) {
        e(dialog, 1000);
    }

    public static void e(Dialog dialog, int i3) {
        Context context;
        Drawable drawable;
        if (dialog == null || (context = dialog.getContext()) == null) {
            return;
        }
        if (i3 == 1000) {
            drawable = context.getResources().getDrawable(com.tencent.mobileqq.R.drawable.qui_common_border_standard_bg);
        } else {
            int g16 = ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_border_standard, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(g16);
            drawable = gradientDrawable;
        }
        View findViewById = dialog.findViewById(com.tencent.mobileqq.R.id.biw);
        if (findViewById != null) {
            findViewById.setBackground(drawable);
        }
        View findViewById2 = dialog.findViewById(com.tencent.mobileqq.R.id.bix);
        if (findViewById2 != null) {
            findViewById2.setBackground(drawable);
        }
        View findViewById3 = dialog.findViewById(com.tencent.mobileqq.R.id.biy);
        if (findViewById3 != null) {
            findViewById3.setBackground(drawable);
        }
        View findViewById4 = dialog.findViewById(com.tencent.mobileqq.R.id.biz);
        if (findViewById4 != null) {
            findViewById4.setBackground(drawable);
        }
    }

    public static void f(Dialog dialog) {
        g(dialog, 1000);
    }

    public static void g(Dialog dialog, int i3) {
        Context context;
        View findViewById;
        int i16;
        if (dialog == null || (context = dialog.getContext()) == null) {
            return;
        }
        View findViewById2 = dialog.findViewById(com.tencent.mobileqq.R.id.vdy);
        if (findViewById2 == null) {
            findViewById = dialog.findViewById(com.tencent.mobileqq.R.id.bja);
        } else {
            findViewById = findViewById2.findViewById(com.tencent.mobileqq.R.id.bja);
        }
        if (findViewById == null) {
            return;
        }
        if (QQTheme.isNowSimpleUI()) {
            i16 = 4;
        } else {
            i16 = 6;
        }
        int c16 = x.c(context, i16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_bg_top_light, i3));
        gradientDrawable.setCornerRadius(c16);
        findViewById.setBackground(gradientDrawable);
    }

    public static void h(Dialog dialog) {
        i(dialog, 1000);
    }

    public static void i(Dialog dialog, int i3) {
        Context context;
        if (dialog == null || (context = dialog.getContext()) == null) {
            return;
        }
        TextView textView = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogTitle);
        if (textView != null) {
            textView.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
            textView.setTypeface(null, 1);
        }
        TextView textView2 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogText);
        if (textView2 != null) {
            textView2.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
        }
        TextView textView3 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.bjg);
        if (textView3 != null) {
            textView3.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
        }
        TextView textView4 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.kdc);
        if (textView4 != null) {
            textView4.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_secondary, i3));
        }
        TextView textView5 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.bit);
        if (textView5 != null) {
            textView5.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
        }
        TextView textView6 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogLeftBtn);
        if (textView6 != null) {
            textView6.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
            textView6.setTypeface(null, 1);
        }
        TextView textView7 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.dialogRightBtn);
        if (textView7 != null) {
            textView7.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
            textView7.setTypeface(null, 1);
        }
        TextView textView8 = (TextView) dialog.findViewById(com.tencent.mobileqq.R.id.biv);
        if (textView8 != null) {
            textView8.setTextColor(ie0.a.f().g(context, com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
            textView8.setTypeface(null, 1);
        }
    }

    public static void j(Dialog dialog, int i3) {
        i(dialog, i3);
        g(dialog, i3);
    }
}
