package com.tencent.mobileqq.newfriend.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.ThemeLabelTextView;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(context.getString(R.string.f160751vv))) {
                return str2;
            }
            if (str.equals(context.getString(R.string.f160741vu))) {
                return context.getString(R.string.f160721vs);
            }
            return str;
        }
        return null;
    }

    public static void b(Activity activity) {
        NewFriendVerifyBlockedListFragment.xh(activity);
    }

    public static void c(Button button) {
        int i3;
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.k4g;
        } else {
            i3 = R.drawable.k4f;
        }
        button.setBackgroundResource(i3);
    }

    public static void d(TextView textView) {
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#999999"));
        }
    }

    public static void e(TextView textView, TextView textView2, TextView textView3) {
        d(textView);
        d(textView2);
        d(textView3);
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(TextView textView, int i3, int i16, StringBuilder sb5) {
        int i17;
        boolean z16;
        if (i3 != 0) {
            if (i3 != 1) {
                textView.setBackgroundResource(R.drawable.ah8);
                i17 = 0;
                z16 = false;
                if (i16 <= 0 && (i3 == 0 || i3 == 1)) {
                    textView.setText(String.valueOf(i16));
                    if (sb5 != null && AppSetting.f99565y) {
                        sb5.append(",");
                        sb5.append(String.valueOf(i16));
                    }
                    z16 = true;
                } else {
                    textView.setText("");
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
                if (!z16) {
                    if (textView instanceof ThemeLabelTextView) {
                        ((ThemeLabelTextView) textView).setSupportMaskView(true);
                    }
                    textView.setVisibility(0);
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            textView.setBackgroundResource(R.drawable.ah7);
            if (sb5 != null && AppSetting.f99565y) {
                sb5.append(",\u5973");
            }
            i17 = R.drawable.f161849f53;
        } else {
            textView.setBackgroundResource(R.drawable.ah8);
            if (sb5 != null && AppSetting.f99565y) {
                sb5.append(",\u7537");
            }
            i17 = R.drawable.f161850f54;
        }
        z16 = true;
        if (i16 <= 0) {
        }
        textView.setText("");
        textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(TextView textView, int i3, int i16, StringBuilder sb5) {
        int i17;
        boolean z16;
        if (i3 != 0) {
            if (i3 != 1) {
                i17 = 0;
                z16 = false;
                textView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg_corner_4);
                if (i16 <= 0 && (i3 == 0 || i3 == 1)) {
                    textView.setText(String.valueOf(i16));
                    if (sb5 != null && AppSetting.f99565y) {
                        sb5.append(",");
                        sb5.append(String.valueOf(i16));
                    }
                    z16 = true;
                } else {
                    textView.setText("");
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
                if (!z16) {
                    if (textView instanceof ThemeLabelTextView) {
                        ((ThemeLabelTextView) textView).setSupportMaskView(true);
                    }
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
                if (sb5 == null && AppSetting.f99565y) {
                    textView.setContentDescription(sb5.toString());
                    return;
                }
            }
            if (sb5 != null && AppSetting.f99565y) {
                sb5.append(",\u5973");
            }
            i17 = R.drawable.ngh;
        } else {
            if (sb5 != null && AppSetting.f99565y) {
                sb5.append(",\u7537");
            }
            i17 = R.drawable.ngi;
        }
        z16 = true;
        textView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg_corner_4);
        if (i16 <= 0) {
        }
        textView.setText("");
        textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
        if (!z16) {
        }
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
        if (sb5 == null) {
        }
    }

    public static void h(View view, boolean z16) {
        if (view == null) {
            return;
        }
        if (z16) {
            view.setBackgroundResource(R.drawable.jix);
        } else {
            view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }
}
