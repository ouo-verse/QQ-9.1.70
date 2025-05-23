package com.tencent.mobileqq.richstatus.topic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f282432a;

    public static boolean a(String str) {
        if (str == null || str.trim().length() < 3) {
            return false;
        }
        return true;
    }

    public static String b(int i3, String str) {
        StringBuilder sb5 = new StringBuilder("https://ti.qq.com/signature/focustopic?_wv=3&&_wwv=129");
        sb5.append(Typography.amp);
        sb5.append("topic_id=");
        sb5.append(i3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("topic_name=");
        try {
            sb5.append(URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TopicUtil", 2, String.format("constructTopicDetailUrl[%d,%s]", Integer.valueOf(i3), str));
        }
        return sb5.toString();
    }

    public static ITopic c(Spannable spannable, int i3) {
        if (i3 >= 0 && i3 < spannable.length()) {
            ITopic[] iTopicArr = (ITopic[]) spannable.getSpans(i3, i3, ITopic.class);
            for (int i16 = 0; i16 < iTopicArr.length; i16++) {
                int spanStart = spannable.getSpanStart(iTopicArr[i16]);
                int spanEnd = spannable.getSpanEnd(iTopicArr[i16]);
                if (i3 >= spanStart && i3 < spanEnd) {
                    return iTopicArr[i16];
                }
            }
        }
        return null;
    }

    public static void d(Context context, String str, int i3) {
        if (System.currentTimeMillis() - f282432a < 500) {
            return;
        }
        f282432a = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        ((Activity) context).startActivityForResult(intent, i3);
    }

    public static void e(ETTextView eTTextView, CharSequence charSequence, int i3) {
        boolean z16;
        ETFont eTFont = eTTextView.W;
        if (eTFont != null && eTFont.getId() != 0 && 9999 != eTTextView.W.getId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TopicUtil", 2, String.format("topicSpanCompactETTextView isCustom=%b from=%d", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
        if (charSequence == null) {
            charSequence = eTTextView.getText();
        }
        if (charSequence != null && (charSequence instanceof Spannable)) {
            Spannable spannable = (Spannable) charSequence;
            ITopic[] iTopicArr = (ITopic[]) spannable.getSpans(0, spannable.length(), ITopic.class);
            for (int i16 = 0; i16 < iTopicArr.length; i16++) {
                iTopicArr[0].setCustomFont(z16);
            }
        }
    }
}
