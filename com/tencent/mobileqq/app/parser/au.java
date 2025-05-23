package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class au {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f196454a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f196454a = arrayList;
        arrayList.add("qq.com");
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a16 = com.tencent.mobileqq.utils.bi.a(str, false);
        if (TextUtils.isEmpty(a16) || !Pattern.compile("gamecenter\\s*=\\s*1").matcher(a16).find()) {
            return false;
        }
        return true;
    }

    private static boolean b(boolean... zArr) {
        if (zArr != null && zArr.length != 0) {
            for (boolean z16 : zArr) {
                if (!z16) {
                    return false;
                }
            }
            return true;
        }
        QLog.e("JumpAction", 1, "judgeNeedDecodeUrlByParam error: params are null");
        return false;
    }

    private static String[] c(String str, boolean... zArr) {
        if (zArr != null && zArr.length != 0) {
            for (boolean z16 : zArr) {
                if (z16) {
                    return com.tencent.mobileqq.utils.bi.d(str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                }
            }
            return str.split("\\?");
        }
        QLog.e("JumpAction", 1, "parseDefaultBodyArray: params are empty");
        return str.split("\\?");
    }

    private static com.tencent.mobileqq.utils.ax d(QQAppInterface qQAppInterface, Context context, String str, String str2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        String str3;
        String str4;
        boolean z27;
        boolean z28;
        boolean startsWith = str2.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
        boolean startsWith2 = str2.startsWith("mqqapi://readingcenter");
        boolean startsWith3 = str2.startsWith(" mqqapi://qqreader");
        boolean startsWith4 = str2.startsWith("wtloginmqq://");
        boolean startsWith5 = str2.startsWith("mqqwpa://");
        boolean startsWith6 = str2.startsWith("mqqtribe://");
        boolean startsWith7 = str2.startsWith("mqqverifycode://");
        boolean startsWith8 = str2.startsWith("mqqdevlock://");
        if (str2.startsWith("mqqapi://im/chat") && str2.contains("chat_type=crm") && str2.contains("kfnick=")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (str2.startsWith("mqqapi://card/show_pslcard") && str2.contains("card_type=troopmember")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (str2.startsWith("mqqapi://qstory") && str2.contains("topicid=")) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean startsWith9 = str2.startsWith("mqqapi://qqcomic/");
        boolean a16 = a(str2);
        boolean startsWith10 = str2.startsWith("mqqguild://");
        boolean startsWith11 = str2.startsWith("mqqapi://hippy/remoteDebug");
        boolean startsWith12 = str2.startsWith("mqqconferenceflyticket://");
        if (str2.startsWith("mqqapi://readinjoy") && str2.contains("readinjoyNotDecodeUrl=1")) {
            z19 = startsWith7;
            z26 = true;
        } else {
            z19 = startsWith7;
            z26 = false;
        }
        boolean z29 = z16;
        boolean b16 = b(!str.startsWith("mqqopensdkapi://bizAgent/"), !str2.startsWith("mqqapi://group/invite_join"), !startsWith2, !startsWith4, !startsWith5, !startsWith6, !startsWith, !str2.startsWith("mqqapi://ecommerce"), !z17, !a16, !startsWith9, !z18, !z26, !startsWith10, !startsWith11);
        String str5 = null;
        if (b16) {
            if (!startsWith2 && !z29 && !startsWith12) {
                z28 = true;
            } else {
                z28 = false;
            }
            str3 = com.tencent.mobileqq.utils.bi.a(str, z28);
            if (str3 == null) {
                return null;
            }
        } else {
            str3 = str2;
        }
        String[] c16 = c(str3, startsWith3, startsWith2, startsWith4, startsWith5, startsWith6, z19, startsWith8, a16, startsWith9);
        String str6 = c16[0];
        if (c16.length > 1) {
            str5 = c16[1];
        }
        if ((str5 != null && b16 && !str6.startsWith("mqqconferenceflyticket://")) || startsWith11) {
            if (!startsWith2 && !z29) {
                z27 = true;
            } else {
                z27 = false;
            }
            str4 = com.tencent.mobileqq.utils.bi.a(str5, z27);
        } else {
            str4 = str5;
        }
        return e(qQAppInterface, context, str, str3, str6, str4, c16, startsWith4, startsWith2, startsWith5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.tencent.mobileqq.utils.ax e(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3, String str4, String[] strArr, boolean z16, boolean z17, boolean z18) {
        String uri;
        String[] split;
        String str5 = str2;
        String str6 = "";
        JumpActionLegacy jumpActionLegacy = new JumpActionLegacy(qQAppInterface, context);
        if (str5.startsWith("mqqapi://now/openroom")) {
            jumpActionLegacy.f307438c = str5;
        } else if (str5.startsWith("nowmqqapi://now/openroom")) {
            str5 = Uri.parse(str2).buildUpon().scheme(SchemaUtils.SCHEMA_MQQAPI).build().toString();
            uri = Uri.parse(str3).buildUpon().scheme(SchemaUtils.SCHEMA_MQQAPI).build().toString();
            jumpActionLegacy.f307438c = str5;
            if (!uri.startsWith("mqqopensdkapi://bizAgent/")) {
                str6 = uri.substring(25);
                jumpActionLegacy.r("attr_original_url", str);
            } else if (uri.startsWith("http://qm.qq.com/cgi-bin/")) {
                str6 = uri.substring(25);
                jumpActionLegacy.r("attr_original_url", str);
            } else if (uri.startsWith("http://clientui.3g.qq.com/mqqapi/")) {
                str6 = uri.substring(33);
            } else if (uri.startsWith("http://clientui.3g.qq.com/mqq/")) {
                str6 = uri.substring(30);
            } else {
                try {
                    ArrayList arrayList = new ArrayList(Arrays.asList("mqqapi://", "qqstory://", "mqq://", "mqqflyticket://", "mqqwpa://", "wtloginmqq://", "mqqtribe://", "mqqverifycode://", "mqqconnect://", "mqqdevlock://", "mqqconferenceflyticket://", "mqqguild://"));
                    int indexOf = uri.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
                    if (indexOf > 0) {
                        int i3 = indexOf + 3;
                        if (arrayList.contains(uri.substring(0, i3))) {
                            str6 = uri.substring(i3);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("JumpAction", 1, "jumpParser error: " + e16.getMessage());
                }
            }
            split = str6.split("/");
            if (split.length == 2) {
                return null;
            }
            jumpActionLegacy.f307438c = str5;
            jumpActionLegacy.f307439d = split[0];
            jumpActionLegacy.f307440e = split[1];
            if (str4 == null) {
                return jumpActionLegacy;
            }
            if (z16) {
                for (String str7 : str4.split(ContainerUtils.FIELD_DELIMITER)) {
                    String a16 = com.tencent.mobileqq.utils.bi.a(str7, !z17);
                    int indexOf2 = a16.indexOf(61);
                    if (indexOf2 > 0) {
                        jumpActionLegacy.r(a16.substring(0, indexOf2), a16.substring(indexOf2 + 1, a16.length()));
                    }
                }
            } else {
                for (String str8 : str4.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] d16 = com.tencent.mobileqq.utils.bi.d(str8, ContainerUtils.KEY_VALUE_DELIMITER);
                    if (d16.length == 2) {
                        if (z18) {
                            jumpActionLegacy.r(d16[0], com.tencent.mobileqq.utils.bi.a(d16[1], false));
                        } else {
                            jumpActionLegacy.r(d16[0], d16[1]);
                        }
                    }
                }
            }
            f(jumpActionLegacy);
            return jumpActionLegacy;
        }
        uri = str3;
        if (!uri.startsWith("mqqopensdkapi://bizAgent/")) {
        }
        split = str6.split("/");
        if (split.length == 2) {
        }
    }

    private static void f(com.tencent.mobileqq.utils.ax axVar) {
        String E;
        String i3;
        if ("forward".equals(axVar.f307439d) && "url".equals(axVar.f307440e) && "0".equals(axVar.f("need_login")) && (E = com.tencent.mobileqq.utils.ax.E(axVar.f("url_prefix"))) != null && E.startsWith("https://") && (i3 = com.tencent.mobileqq.webview.util.s.i(E)) != null && f196454a.contains(i3)) {
            axVar.J = false;
        }
    }

    @Nullable
    public static com.tencent.mobileqq.utils.ax g(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        String str2;
        if (str.contains("videochat") && str.contains("uinType=21")) {
            str = URLDecoder.decode(str);
        }
        if (QQAudioHelper.f() && QQAudioHelper.c(8) == 1 && str.startsWith("mqqconferenceflyticket://")) {
            str2 = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
        } else {
            str2 = str;
        }
        if (str2.startsWith("mqqavshare://")) {
            return com.tencent.av.utils.au.a(new JumpActionLegacy((QQAppInterface) baseQQAppInterface, context), context, str2);
        }
        if (str2.startsWith("mqqapi://qzone/groupalbum")) {
            String[] split = str2.split("\\?");
            if (split.length != 2) {
                return null;
            }
            String str3 = split[0];
            String str4 = split[1];
            JumpActionLegacy jumpActionLegacy = new JumpActionLegacy((QQAppInterface) baseQQAppInterface, context);
            String[] split2 = str3.substring(9).split("/");
            if (split2.length != 2) {
                return null;
            }
            jumpActionLegacy.f307438c = str2;
            jumpActionLegacy.f307439d = split2[0];
            jumpActionLegacy.f307440e = split2[1];
            for (String str5 : str4.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split3 = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length == 2) {
                    try {
                        split3[1] = URLDecoder.decode(split3[1], "UTF-8");
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + split3[0] + ",tmps[1] is:" + split3[1], e16);
                        }
                    }
                    jumpActionLegacy.r(split3[0], split3[1]);
                }
            }
            return jumpActionLegacy;
        }
        return d((QQAppInterface) baseQQAppInterface, context, str, str2);
    }
}
