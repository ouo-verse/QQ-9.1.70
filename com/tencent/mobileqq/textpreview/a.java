package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.text.AbsQQText;
import cooperation.qqfav.QfavBuilder;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends BaseMenuUtil {
    private static String a(String str) {
        int i3;
        int i16;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        int length = sb5.length();
        int i17 = 0;
        while (i17 < length) {
            if (20 == sb5.charAt(i17) && (i3 = i17 + 1) < length && '\u00ff' == sb5.charAt(i3) && (i16 = i17 + 2) < length) {
                if (sb5.charAt(i16) == 20) {
                    sb5.setCharAt(i16, AbsQQText.HEAD_INDEX_REPLACE);
                }
                i17 += 4;
            }
            i17++;
        }
        return sb5.toString();
    }

    public static void b(Activity activity, QQAppInterface qQAppInterface, String str) {
        QfavBuilder.k0(null, a(str)).R(qQAppInterface, null).h(activity, qQAppInterface.getAccount());
        cooperation.qqfav.d.e(qQAppInterface, 6, 1);
    }

    public static void c(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", -1);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("direct_send_if_dataline_forward", true);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
    }

    public static void d(Activity activity, String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 48);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, str);
        bundle.putInt(AppConstants.Key.FORWARD_EXTRA, i3);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("direct_send_if_dataline_forward", true);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
    }
}
