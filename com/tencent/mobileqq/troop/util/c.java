package com.tencent.mobileqq.troop.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f301849a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301849a = new HashSet<>();
        }
    }

    public static String a(structmsg$StructMsg structmsg_structmsg, String str) {
        if (str.contains("%req_uin%")) {
            String str2 = structmsg_structmsg.f436065msg.req_uin_nick.get();
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            str = str.replace("%req_uin%", str2);
        }
        if (str.contains("%action_uin%")) {
            String str3 = structmsg_structmsg.f436065msg.action_uin_nick.get();
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            str = str.replace("%action_uin%", str3);
        }
        if (str.contains("%actor_uin%")) {
            String str4 = structmsg_structmsg.f436065msg.actor_uin_nick.get();
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            str = str.replace("%actor_uin%", str4);
        }
        if (str.contains("%group_name%")) {
            String str5 = structmsg_structmsg.f436065msg.group_name.get();
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            return str.replace("%group_name%", str5);
        }
        return str;
    }

    public static int b(int i3) {
        if (i3 != 2 && i3 != 3 && i3 != 6 && i3 != 7 && i3 != 15 && i3 != 16) {
            return 2;
        }
        return 1;
    }
}
