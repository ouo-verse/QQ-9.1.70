package com.tencent.mobileqq.wink.utils;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class aj {
    public static String a(TextView textView) {
        if (textView == null) {
            return "";
        }
        TextPaint paint = textView.getPaint();
        float width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] split = textView.getText().toString().replaceAll("\r", "").split("\n");
        StringBuilder sb5 = new StringBuilder();
        for (String str : split) {
            if (paint.measureText(str) <= width) {
                sb5.append(str);
            } else {
                float f16 = 0.0f;
                for (int i3 = 0; i3 != str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    f16 += paint.measureText(String.valueOf(charAt));
                    if (f16 <= width) {
                        sb5.append(charAt);
                    } else {
                        if (i3 > 2) {
                            return sb5.subSequence(0, i3 - 2).toString() + "...\"";
                        }
                        return sb5.toString();
                    }
                }
            }
        }
        return sb5.toString();
    }

    public static String b() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static long c() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                return Long.parseLong(account);
            } catch (Exception e16) {
                QLog.w("QCircleHostUtil", 1, e16.getMessage());
                return 0L;
            }
        }
        return 0L;
    }
}
