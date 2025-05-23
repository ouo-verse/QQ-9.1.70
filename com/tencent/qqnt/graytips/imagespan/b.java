package com.tencent.qqnt.graytips.imagespan;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.c;
import com.tencent.qqnt.graytips.util.h;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f356872a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356872a = new HashMap<>();
        }
    }

    public static void a(Context context, SpannableStringBuilder spannableStringBuilder, c cVar, boolean z16, h.a aVar) {
        UrlCenterImageSpan urlCenterImageSpan;
        int identifier;
        UrlBottomImageSpan urlBottomImageSpan;
        String str = cVar.iconUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (c(str)) {
                String b16 = b(str);
                if (!TextUtils.isEmpty(b16)) {
                    if (z16) {
                        urlBottomImageSpan = new UrlBottomImageSpan(context, 0, b16, ViewUtils.dpToPx(16.0f));
                    } else {
                        urlBottomImageSpan = new UrlBottomImageSpan(context, 0, b16);
                    }
                    urlBottomImageSpan.getDrawable();
                    spannableStringBuilder.setSpan(urlBottomImageSpan, cVar.start, cVar.end, 33);
                    aVar.a(urlBottomImageSpan);
                    if (QLog.isColorLevel()) {
                        QLog.i("ImageSpanUtil", 2, "decodeImageSpan isMutualMarkImageUrlTemplate Url Image=" + b16);
                        return;
                    }
                    return;
                }
                return;
            }
            int indexOf = str.indexOf(46);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            HashMap<String, Integer> hashMap = f356872a;
            if (hashMap.containsKey(str)) {
                identifier = hashMap.get(str).intValue();
            } else {
                identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            }
            if (identifier != 0) {
                if (z16) {
                    spannableStringBuilder.setSpan(new a(context, identifier, ViewUtils.dip2px(16.0f)), cVar.start, cVar.end, 33);
                } else {
                    spannableStringBuilder.setSpan(new a(context, identifier), cVar.start, cVar.end, 33);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ImageSpanUtil", 2, "MessageForGrayTips.getHightlightMsgText Image=" + str + " resourceId:" + identifier);
                return;
            }
            return;
        }
        if (z16) {
            urlCenterImageSpan = new UrlCenterImageSpan(context, 0, str, ViewUtils.dpToPx(16.0f));
        } else {
            urlCenterImageSpan = new UrlCenterImageSpan(context, 0, str);
        }
        urlCenterImageSpan.getDrawable();
        spannableStringBuilder.setSpan(urlCenterImageSpan, cVar.start, cVar.end, 33);
        aVar.a(urlCenterImageSpan);
        if (QLog.isColorLevel()) {
            QLog.i("ImageSpanUtil", 2, "MessageForGrayTips.getHightlightMsgText Url Image=" + str);
        }
    }

    public static String b(String str) {
        Matcher matcher = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (QLog.isColorLevel()) {
                QLog.i("ImageSpanUtil", 2, "getMutualMarkImageUrlTemplateUrl. url:" + group + " template:" + str);
            }
            return group;
        }
        return null;
    }

    public static boolean c(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && str.startsWith("#image_url") && Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(str).matches()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ImageSpanUtil", 2, "isMutualMarkImageUrlTemplate. res:" + z16 + " template:" + str);
        }
        return z16;
    }
}
