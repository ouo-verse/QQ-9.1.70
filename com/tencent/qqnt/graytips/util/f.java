package com.tencent.qqnt.graytips.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.graytips.decoder.json.a;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (StringUtil.getWordCountNeo(str) > 19) {
            return StringUtil.substringNeo(str, 0, 16) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    public static String b(RevokeElement revokeElement) {
        return ((INickNameApi) QRoute.api(INickNameApi.class)).getPurePlainText(j.a(revokeElement), true).toString();
    }

    private static CharSequence c(Context context, AppRuntime appRuntime, RevokeElement revokeElement, int i3) {
        if (revokeElement.getOperatorRole() == 1) {
            return context.getString(R.string.f221326ai) + b(revokeElement) + context.getString(R.string.f221266ac);
        }
        if (revokeElement.getOperatorRole() == 2) {
            return context.getString(R.string.f221336aj) + b(revokeElement) + context.getString(R.string.f221266ac);
        }
        if (i3 == 2) {
            return context.getString(R.string.f221256ab);
        }
        return context.getString(R.string.yw8);
    }

    public static CharSequence d(Context context, AppRuntime appRuntime, MsgAbstractElement msgAbstractElement, GrayTipElement grayTipElement, String str, String str2, String str3, int i3, int i16, int i17) {
        if (appRuntime != null && grayTipElement != null) {
            try {
                if (grayTipElement.getXmlElement() != null) {
                    return g(appRuntime, grayTipElement, str2, i3, i16, str);
                }
                if (grayTipElement.getRevokeElement() != null) {
                    return f(context, appRuntime, grayTipElement.getRevokeElement(), str3, i17, i3);
                }
                if (grayTipElement.getSubElementType() == 17) {
                    return e(grayTipElement.getJsonGrayTipElement());
                }
                return zw3.a.c(grayTipElement);
            } catch (Exception e16) {
                if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                    QLog.e("GrayTipsUtils", 1, "parseGrayTipForChatsSummary " + e16);
                    return null;
                }
                throw new RuntimeException(e16);
            }
        }
        QLog.i("GrayTipsUtils", 1, "parseGrayTipForChatsSummary app == null");
        return null;
    }

    private static CharSequence e(JsonGrayElement jsonGrayElement) {
        if (jsonGrayElement == null) {
            QLog.i("GrayTipsUtils", 1, "parseGrayTipForChatsSummary json element is null");
            return "";
        }
        a.b d16 = com.tencent.qqnt.graytips.decoder.json.a.f356837a.d(jsonGrayElement);
        if (d16 == null) {
            return "";
        }
        SpannableStringBuilder c16 = d16.c();
        h(d16.e(), c16);
        return c16;
    }

    private static CharSequence f(Context context, AppRuntime appRuntime, RevokeElement revokeElement, String str, int i3, int i16) {
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(revokeElement.getWording())) {
            str2 = "";
        } else {
            str2 = "\uff0c" + revokeElement.getWording();
        }
        if (str2.endsWith("\u3002\t") && str2.length() >= 2) {
            str2 = str2.substring(0, str2.length() - 2);
        }
        QLog.i("GrayTipsUtils", 1, "parseRevokeGrayTipForChatsSummary suffix is:" + str2);
        if (i3 != 0) {
            return ((Object) c(context, appRuntime, revokeElement, i3)) + str2;
        }
        int operatorRole = (int) revokeElement.getOperatorRole();
        if (operatorRole == 0) {
            String b16 = b(revokeElement);
            if (!TextUtils.isEmpty(b16) || TextUtils.isEmpty(str)) {
                str = b16;
            }
            if (!TextUtils.isEmpty(str)) {
                str = ((INickNameApi) QRoute.api(INickNameApi.class)).getPurePlainText(str, true).toString();
            }
            if (TextUtils.equals(appRuntime.getCurrentUid(), revokeElement.getOperatorUid())) {
                str = context.getString(R.string.f214145s4);
            } else if (i16 == 3 || i16 == 1 || i16 == 100) {
                str = context.getString(R.string.f221316ah);
            }
            return str + context.getString(R.string.f221346ak) + str2;
        }
        if (operatorRole == 1 && !revokeElement.getIsSelfOperate()) {
            str3 = context.getString(R.string.f221326ai) + b(revokeElement);
        } else if (operatorRole == 2 && !revokeElement.getIsSelfOperate()) {
            str3 = context.getString(R.string.f221336aj) + b(revokeElement);
        }
        if (!revokeElement.getIsSelfOperate()) {
            return str3 + context.getString(R.string.f221266ac);
        }
        return context.getString(R.string.f214145s4) + context.getString(R.string.f221276ad) + context.getString(R.string.f221296af) + str + context.getString(R.string.f221286ae);
    }

    private static CharSequence g(AppRuntime appRuntime, GrayTipElement grayTipElement, String str, int i3, int i16, String str2) {
        com.tencent.qqnt.graytips.decoder.d g16 = com.tencent.qqnt.graytips.decoder.xml.a.g(appRuntime, grayTipElement, str, i3, i16, str2);
        if (g16 == null) {
            return "";
        }
        SpannableStringBuilder e16 = g16.e();
        h(g16.f356832e, e16);
        if (TextUtils.isEmpty(e16)) {
            return "";
        }
        return e16;
    }

    private static void h(List<com.tencent.qqnt.graytips.c> list, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.clearSpans();
        for (int size = list.size() - 1; size >= 0; size--) {
            com.tencent.qqnt.graytips.c cVar = list.get(size);
            if (!TextUtils.isEmpty(cVar.iconUrl)) {
                int i3 = cVar.start;
                int i16 = cVar.end;
                if (TextUtils.isEmpty(cVar.com.tencent.biz.qqcircle.QCircleSchemeAttr.Polymerize.ALT java.lang.String)) {
                    spannableStringBuilder.delete(i3, i16);
                }
            }
        }
        if (spannableStringBuilder.length() > 0) {
            char charAt = spannableStringBuilder.charAt(spannableStringBuilder.length() - 1);
            if (charAt == '\u3002' || charAt == '.') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
        }
    }
}
