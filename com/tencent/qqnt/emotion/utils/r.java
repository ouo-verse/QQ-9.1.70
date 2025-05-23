package com.tencent.qqnt.emotion.utils;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static String a(int i3, int i16) {
        if (i3 == 1) {
            return QQSysFaceUtil.getFaceString(i16);
        }
        if (i3 == 2) {
            return com.tencent.qqnt.emotion.text.c.a(i16);
        }
        return null;
    }

    public static Drawable b(int i3, boolean z16) {
        if (!z16) {
            return QQSysFaceUtil.getFaceDrawable(i3);
        }
        return QQSysFaceUtil.getFaceGifDrawable(i3);
    }
}
