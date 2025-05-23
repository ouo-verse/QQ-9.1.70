package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginReportConstants {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f241791a;

    /* renamed from: b, reason: collision with root package name */
    public static int f241792b;

    /* renamed from: c, reason: collision with root package name */
    public static String f241793c;

    /* renamed from: d, reason: collision with root package name */
    public static String f241794d;

    /* renamed from: e, reason: collision with root package name */
    public static final ArrayList<String> f241795e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public @interface AccountLoginScene {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public @interface LoginScene {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public @interface PhoneLoginScene {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f241791a = 0;
        f241792b = 1;
        f241793c = "1";
        f241794d = "0X800C276";
        f241795e = new ArrayList<>(Arrays.asList("0X800C27F", "0X800C280", "0X800C281", "0X800C282", "0X800C283", "0X800C300", "0X800C301", "0X800C302", "0X800C303", "0X800C304", "0X800C305", "0X800C306", "0X800C307", "0X800C378", "0X800C379", "0X800C308", "0X800C4C2", "0X800C4C4"));
    }
}
