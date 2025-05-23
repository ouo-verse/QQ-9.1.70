package com.tencent.widget;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RedWidgetUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int RED_DOT_DOUBLE_SIZE = 23;
    private static final int RED_DOT_MAX_SIZE = 30;
    private static final String RED_DOT_QQ_FONT = "fonts/DIN-NextLT-Pro-QQ.ttf";
    private static final int RED_DOT_SINGLE_SIZE = 16;
    private static final int RED_DOT_SINGLE_SIZE_ROBOTO = 18;
    private static final int RED_DOT_TEXT_SIZE = 10;
    private static final int RED_DOT_TEXT_SIZE_ROBOTO = 12;
    private static final String TAG = "RedWidgetUtil";
    private static Typeface typeface;

    public RedWidgetUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void fixTextViewLayout(TextView textView, int i3, int i16, int i17) {
        fixTextViewLayout(textView, i3, i16, i17, false);
    }

    public static int getSuitableWidth(int i3, int i16) {
        if (i16 < 10) {
            return ViewUtils.dip2px(18.0f);
        }
        if (i3 > i16) {
            return ViewUtils.dip2px(30.0f);
        }
        if (i3 >= 10) {
            return ViewUtils.dip2px(23.0f);
        }
        return ViewUtils.dip2px(18.0f);
    }

    private static void useDINNextLTTtf(TextView textView) {
        try {
            if (typeface == null) {
                typeface = Typeface.createFromAsset(textView.getContext().getAssets(), RED_DOT_QQ_FONT);
            }
            if (typeface != textView.getTypeface()) {
                textView.setTypeface(typeface);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "setTypeFace wrong: " + e16);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public static void fixTextViewLayout(TextView textView, int i3, int i16, int i17, boolean z16) {
        if (textView == null || textView.getContext() == null) {
            return;
        }
        if (i17 == R.drawable.skin_tips_newmessage || i17 == R.drawable.skin_tips_newmessage_gray || i17 == R.drawable.guild_num_point_bg || i17 == R.drawable.n3l) {
            int c16 = x.c(textView.getContext(), z16 ? 18.0f : 16.0f);
            int c17 = x.c(textView.getContext(), 30.0f);
            int c18 = x.c(textView.getContext(), 23.0f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(c16, c16);
            }
            layoutParams.height = c16;
            if (i16 < 10) {
                layoutParams.width = c16;
            } else if (i3 > i16) {
                layoutParams.width = c17;
            } else if (i3 >= 10) {
                layoutParams.width = c18;
            } else {
                layoutParams.width = c16;
            }
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(2, z16 ? 12.0f : 10.0f);
            textView.setGravity(17);
            textView.setIncludeFontPadding(false);
            if (z16) {
                textView.setBackgroundResource(R.drawable.qui_unread_number_red_bg);
            } else {
                useDINNextLTTtf(textView);
            }
        }
    }
}
