package com.tencent.mobileqq.onlinestatus.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.widget.RedWidgetUtil;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aj {
    public static void a(TextView textView, int i3, int i16, int i17, int i18, String str) {
        String valueOf;
        int i19;
        if (textView == null) {
            return;
        }
        String str2 = "";
        switch (i3) {
            case 1:
            case 8:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_dot;
                }
                str = "";
                i19 = 0;
                break;
            case 2:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                str = "NEW";
                i19 = i17;
                i17 = 0;
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
                RedWidgetUtil.fixTextViewLayout(textView, i16, i18, i17);
                i19 = i17;
                i17 = 0;
                break;
            case 4:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_newmessage;
                }
                if (i16 > 99) {
                    str = "";
                } else {
                    str = String.valueOf(i16);
                }
                RedWidgetUtil.fixTextViewLayout(textView, i16, i18, i17);
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
                    break;
                }
                i19 = i17;
                i17 = 0;
            case 6:
                if (i17 <= 0) {
                    i17 = R.drawable.skin_tips_new;
                }
                str = "";
                i19 = 0;
                break;
            default:
                str = "";
                i19 = 0;
                i17 = 0;
                break;
        }
        if (str != null) {
            str2 = str;
        }
        if (TextUtils.isEmpty(str2) && i17 == 0 && i19 == 0) {
            textView.setVisibility(8);
            return;
        }
        Object tag = textView.getTag(R.id.unreadmsg);
        if ((tag != null || i17 != 0) && (!(tag instanceof Integer) || ((Integer) tag).intValue() != i17)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i17, 0, 0, 0);
            textView.setTag(R.id.unreadmsg, Integer.valueOf(i17));
            textView.setText(str2);
            textView.setPadding(0, 0, 0, 0);
        }
        textView.setBackgroundResource(i19);
        if (!Utils.p(textView.getText().toString(), str2)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setText(str2);
        }
        textView.setVisibility(0);
    }
}
