package com.tencent.qqnt.emotion.text;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static final String a(int i3) {
        if (i3 < 0) {
            QLog.e("TextUtils", 1, "[getEmojiString] error, index=", Integer.valueOf(i3));
            return null;
        }
        return String.valueOf(Character.toChars(QQEmojiUtil.getEmojiUnicode(i3)));
    }

    public static final Drawable b(int i3, boolean z16) {
        if (!z16) {
            return QQSysFaceUtil.getFaceDrawable(i3);
        }
        return QQSysFaceUtil.getFaceGifDrawable(i3);
    }

    public static final String c(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }
}
