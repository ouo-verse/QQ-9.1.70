package com.tencent.od.common.util;

import android.widget.TextView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static void a(TextView textView) {
        b(textView, true);
    }

    public static void b(TextView textView, boolean z16) {
        String str;
        if (z16) {
            str = "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf";
        } else {
            str = "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-Bold.ttf";
        }
        RFWTypefaceUtil.setNumberTypeface(textView, str);
    }
}
