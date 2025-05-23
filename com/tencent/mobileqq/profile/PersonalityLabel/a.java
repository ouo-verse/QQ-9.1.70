package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f259943a;

    /* renamed from: b, reason: collision with root package name */
    public static String f259944b;

    /* renamed from: c, reason: collision with root package name */
    public static String f259945c;

    /* renamed from: d, reason: collision with root package name */
    public static String f259946d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f259943a = "%s\u66f4\u65b0\u4e86\u4e2a\u6027\u6807\u7b7e";
        f259944b = HardCodeUtil.qqStr(R.string.l0l);
        f259945c = "https://ti.qq.com/specialtag/index.html?_wv=536884193&_wwv=5";
        f259946d = "?personality_label_blur=1";
    }
}
