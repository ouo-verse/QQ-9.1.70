package com.tencent.mobileqq.qqsec.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f274416a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27545);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274416a = new ArrayList<>(Arrays.asList("0X800AA2F", "0X800AA30", "0X800AA31", "0X800AA32"));
        }
    }
}
