package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QUA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f280141a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74469);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f280141a = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
        }
    }

    public static newest_feeds_req a(int i3, long j3, ArrayList<Long> arrayList, long j16, String str) {
        return new newest_feeds_req(i3, j3, arrayList, j16, str, QUA.getQUA3(), null);
    }

    public static Intent b(Intent intent, newest_feeds_req newest_feeds_reqVar) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("req", newest_feeds_reqVar);
        return intent;
    }

    public static newest_feeds_req c(Intent intent) {
        if (intent == null) {
            return new newest_feeds_req();
        }
        Serializable serializableExtra = intent.getSerializableExtra("req");
        if (serializableExtra != null && (serializableExtra instanceof newest_feeds_req)) {
            return (newest_feeds_req) serializableExtra;
        }
        return new newest_feeds_req();
    }

    public static String d(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(",nick:");
        int indexOf2 = str.indexOf("}");
        if (indexOf != -1) {
            i3 = indexOf + 6;
        } else {
            i3 = 0;
        }
        if (indexOf2 == -1 || i3 == 0) {
            return null;
        }
        return str.substring(i3, indexOf2);
    }

    public static String e(String str, QQAppInterface qQAppInterface) {
        if (!TextUtils.isEmpty(str) && qQAppInterface != null) {
            Matcher matcher = f280141a.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                String f16 = f(group);
                String str2 = "";
                if (!TextUtils.isEmpty(f16)) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(f16), "QzoneContactsFeedUtils");
                    if (friendsSimpleInfoWithUid != null) {
                        str2 = friendsSimpleInfoWithUid.m();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = d(group);
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str.replace(group, "@" + str2 + " ");
                }
            }
            return str;
        }
        return null;
    }

    public static String f(String str) {
        int i3;
        if ("".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf("uin:");
        int indexOf2 = str.indexOf(",");
        if (indexOf != -1) {
            i3 = indexOf + 4;
        } else {
            i3 = 0;
        }
        if (i3 == 0 || indexOf2 == -1) {
            return null;
        }
        return str.substring(i3, indexOf2);
    }
}
