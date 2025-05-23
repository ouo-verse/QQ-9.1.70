package com.tencent.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d implements CustomWidgetConstants {
    static IPatchRedirector $redirector_;

    public static void a(QUIBadge qUIBadge, int i3, int i16, int i17, String str) {
        if (qUIBadge == null) {
            return;
        }
        qUIBadge.setVisibility(0);
        qUIBadge.setContentDescription("");
        switch (i3) {
            case 1:
            case 8:
                qUIBadge.setRedDot();
                return;
            case 2:
                qUIBadge.setRedText("NEW");
                return;
            case 3:
            case 7:
            case 9:
                qUIBadge.setContentDescription(String.valueOf(i16));
                if (i16 > i17) {
                    qUIBadge.setRedText(i17 + Marker.ANY_NON_NULL_MARKER);
                    return;
                }
                qUIBadge.setRedNum(i16);
                return;
            case 4:
                qUIBadge.setContentDescription(String.valueOf(i16));
                qUIBadge.setRedNum(i16);
                return;
            case 5:
                qUIBadge.setRedText(str);
                return;
            case 6:
                qUIBadge.setRedText("\u65b0");
                return;
            case 10:
            default:
                qUIBadge.setVisibility(8);
                return;
            case 11:
                qUIBadge.setGrayDot();
                return;
        }
    }

    public static void b(TextView textView, int i3, int i16, int i17) {
        c(textView, i3, i16, i17, 99, null);
    }

    public static void c(TextView textView, int i3, int i16, int i17, int i18, String str) {
        d(textView, i3, i16, i17, i18, str, false);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    public static void d(TextView textView, int i3, int i16, int i17, int i18, String str, boolean z16) {
        String valueOf;
        int i19;
        String valueOf2;
        if (textView == null) {
            return;
        }
        int i26 = 1;
        String str2 = "";
        switch (i3) {
            case 1:
            case 8:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_dot;
                }
                str = "";
                i19 = 0;
                i26 = 0;
                break;
            case 2:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                str = "NEW";
                i19 = i17;
                i17 = 0;
                i26 = i17;
                break;
            case 3:
            case 7:
            case 9:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                if (i16 > i18) {
                    valueOf = String.valueOf(i18) + Marker.ANY_NON_NULL_MARKER;
                } else {
                    valueOf = String.valueOf(i16);
                }
                str = valueOf;
                RedWidgetUtil.fixTextViewLayout(textView, i16, i18, i17, z16);
                i19 = i17;
                i17 = 0;
                break;
            case 4:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                if (i16 > 99) {
                    valueOf2 = "99+";
                } else {
                    valueOf2 = String.valueOf(i16);
                }
                str = valueOf2;
                RedWidgetUtil.fixTextViewLayout(textView, i16, i18, i17, z16);
                i19 = i17;
                i17 = 0;
                break;
            case 5:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                if (TextUtils.isEmpty(str)) {
                    i19 = i17;
                    str = "";
                    i17 = 0;
                    i26 = i17;
                    break;
                }
                i19 = i17;
                i17 = 0;
                i26 = i17;
            case 6:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_new;
                }
                str = "";
                i19 = 0;
                i26 = 0;
                break;
            case 10:
            default:
                str = "";
                i19 = 0;
                i17 = 0;
                i26 = i17;
                break;
            case 11:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage_gray_small;
                }
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                textView.setLayoutParams(layoutParams);
                str = "";
                i19 = 0;
                i26 = 0;
                break;
        }
        if (str != null) {
            str2 = str;
        }
        if (TextUtils.isEmpty(str2) && i17 == 0 && i19 == 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setVisibility(8);
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
        textView.setTag(R.id.unreadmsg, Integer.valueOf(i17));
        textView.setText(str2);
        textView.setPadding(0, 0, 0, 0);
        if (i26 == 0 || !z16) {
            textView.setBackgroundResource(i19);
        }
        if (!Utils.p(textView.getText().toString(), str2)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setText(str2);
        }
        textView.setVisibility(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Context context, TextView textView, int i3, boolean z16) {
        int dimensionPixelSize;
        int measuredWidth;
        int measuredHeight;
        int i16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (textView != null && i3 != 0) {
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f158891ro);
            int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f158889rm);
            switch (i3) {
                case 1:
                    int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(R.dimen.f158891ro);
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158889rm);
                    textView.measure(0, 0);
                    measuredWidth = dimensionPixelSize4 - (textView.getMeasuredWidth() / 2);
                    measuredHeight = textView.getMeasuredHeight() / 2;
                    dimensionPixelSize3 = dimensionPixelSize - measuredHeight;
                    dimensionPixelSize2 = measuredWidth;
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                        if (marginLayoutParams.leftMargin != dimensionPixelSize2 || marginLayoutParams.bottomMargin != dimensionPixelSize3 || marginLayoutParams.rightMargin != i16) {
                            marginLayoutParams.setMargins(dimensionPixelSize2, 0, i16, dimensionPixelSize3);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f158894rr);
                    dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f158892rp);
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 3:
                    dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f158894rr);
                    dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f158892rp);
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 4:
                case 6:
                default:
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 5:
                    dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f158894rr);
                    dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f158892rp);
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 7:
                    int dimensionPixelSize5 = context.getResources().getDimensionPixelSize(R.dimen.f158891ro);
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158889rm);
                    textView.measure(0, 0);
                    measuredWidth = dimensionPixelSize5 - (textView.getMeasuredWidth() / 2);
                    measuredHeight = textView.getMeasuredHeight() / 2;
                    dimensionPixelSize3 = dimensionPixelSize - measuredHeight;
                    dimensionPixelSize2 = measuredWidth;
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 8:
                    int dimensionPixelSize6 = context.getResources().getDimensionPixelSize(R.dimen.f158891ro);
                    int dimensionPixelSize7 = context.getResources().getDimensionPixelSize(R.dimen.f158890rn);
                    if (z16) {
                        dimensionPixelSize7 += ViewUtils.dip2px(8.0f);
                    }
                    textView.measure(0, 0);
                    int measuredWidth2 = textView.getMeasuredWidth();
                    int measuredHeight2 = textView.getMeasuredHeight();
                    if (measuredWidth2 <= measuredHeight2) {
                        measuredWidth2 = measuredHeight2;
                    }
                    textView.setWidth(measuredWidth2);
                    textView.setHeight(measuredWidth2);
                    int i17 = measuredWidth2 / 2;
                    dimensionPixelSize2 = dimensionPixelSize6 - i17;
                    dimensionPixelSize3 = dimensionPixelSize7 - i17;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams2 != null) {
                        i16 = marginLayoutParams2.rightMargin;
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                        if (marginLayoutParams != null) {
                        }
                    }
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 9:
                    dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f158895rs);
                    dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f158893rq);
                    i16 = 0;
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    if (marginLayoutParams != null) {
                    }
                    break;
                case 10:
                    if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams.addRule(15, -1);
                        layoutParams.setMargins(0, 0, context.getResources().getDimensionPixelSize(R.dimen.f158896cb4), 0);
                        return;
                    }
                    return;
            }
        }
    }
}
