package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.text.AbsQQText;
import cooperation.qqfav.QfavBuilder;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static final int f179522a = BaseChatItemLayout.P + BaseChatItemLayout.W;

    public static String a(QQAppInterface qQAppInterface, Activity activity, ChatMessage chatMessage, String str) {
        chatMessage.f203106msg = b(chatMessage.f203106msg, true);
        String b16 = b(str, true);
        QfavBuilder.k0(null, b16).R(qQAppInterface, chatMessage).h(activity, qQAppInterface.getAccount());
        cooperation.qqfav.d.e(qQAppInterface, 6, 1);
        return b16;
    }

    public static String b(String str, boolean z16) {
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
                if (z16) {
                    if (sb5.charAt(i16) == 20) {
                        sb5.setCharAt(i16, AbsQQText.HEAD_INDEX_REPLACE);
                    }
                } else if (sb5.charAt(i16) == '\u00fd') {
                    sb5.setCharAt(i16, (char) 20);
                }
                i17 += 4;
            }
            i17++;
        }
        return sb5.toString();
    }
}
