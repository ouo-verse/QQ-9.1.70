package com.tencent.msdk.dns.core.rest.share.h;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.base.log.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f336374a;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f336375b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336374a = Pattern.compile("(.*),(.*)\\|(.*)");
            f336375b = Pattern.compile("(.*).:(.*),(.*)\\|(.*)");
        }
    }

    public static a a(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return a.f336369d;
        }
        String[] split = str.split("\n");
        int i16 = 2;
        int i17 = 1;
        if (split.length > 1) {
            ArrayList arrayList = new ArrayList();
            int length = split.length;
            String str2 = "";
            int i18 = 0;
            int i19 = 0;
            while (i18 < length) {
                Matcher matcher = f336375b.matcher(split[i18]);
                if (matcher.matches() && 4 == matcher.groupCount()) {
                    try {
                        String group = matcher.group(i17);
                        String str3 = matcher.group(4) + ",";
                        for (String str4 : matcher.group(i16).split(";")) {
                            arrayList.add(group + ":" + str4);
                        }
                        str2 = str3;
                        i19 = Integer.parseInt(matcher.group(3));
                    } catch (Exception e16) {
                        c.j(e16, "Parse external response failed", new Object[0]);
                        return a.f336369d;
                    }
                }
                i18++;
                i16 = 2;
                i17 = 1;
            }
            if (arrayList.size() == 0) {
                return a.f336369d;
            }
            return new a(i3, str2, (String[]) arrayList.toArray(new String[arrayList.size()]), i19);
        }
        Matcher matcher2 = f336374a.matcher(str);
        if (matcher2.matches() && 3 == matcher2.groupCount()) {
            try {
                return new a(i3, matcher2.group(3), matcher2.group(1).split(";"), Integer.parseInt(matcher2.group(2)));
            } catch (Exception e17) {
                c.j(e17, "Parse external response failed", new Object[0]);
                return a.f336369d;
            }
        }
        return a.f336369d;
    }
}
