package com.tencent.mobileqq.aio.reply;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(TextView textView, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int desiredWidth = (i3 - ((int) Layout.getDesiredWidth(MiniBoxNoticeInfo.APPNAME_SUFFIX, textView.getPaint()))) - 1;
        int codePointCount = str.codePointCount(0, str.length());
        int length = str.length();
        float desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        while (true) {
            int i16 = ((int) desiredWidth2) + 1;
            if (codePointCount <= 0 || i16 <= desiredWidth) {
                break;
            }
            codePointCount--;
            length = str.offsetByCodePoints(0, codePointCount);
            desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        }
        if (length == str.length()) {
            return str;
        }
        return str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public static Drawable b(Resources resources, u uVar) {
        int i3;
        if (m.f194167a.c(uVar)) {
            i3 = R.drawable.qui_aio_reply_bg;
        } else {
            i3 = R.drawable.gxi;
        }
        return resources.getDrawable(i3);
    }

    public static boolean c() {
        return true;
    }
}
