package com.tencent.mobileqq.activity.qqsettingme.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f185027a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35541);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f185027a = null;
        }
    }

    public static CharSequence a(String str, CharSequence charSequence) {
        if (f185027a == null) {
            b();
        }
        String str2 = f185027a.get(str);
        if (str2 != null) {
            return str2;
        }
        return charSequence;
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        f185027a = hashMap;
        hashMap.put("d_vip_identity", "\u4f1a\u5458");
        f185027a.put("d_qqwallet", "\u94b1\u5305");
        f185027a.put("d_financial", "\u5c0f\u91d1\u5e93");
        f185027a.put("d_decoration", "\u4e2a\u6027\u88c5\u626e");
        f185027a.put("d_vip_card", "\u738b\u5361");
        f185027a.put("d_favorite", "\u6536\u85cf");
        f185027a.put("d_album", QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE);
        f185027a.put("d_document", "\u6587\u4ef6");
        f185027a.put("d_my_game", "\u6e38\u620f");
    }
}
