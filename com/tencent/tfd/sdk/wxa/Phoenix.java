package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes26.dex */
public final class Phoenix {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Set<String>> f375664a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f375665b;

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map<java.lang.String, java.util.Set<java.lang.String>>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map<java.lang.String, java.util.Set<java.lang.String>>, java.util.HashMap] */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375664a = new HashMap();
        f375665b = new HashMap();
        HashSet hashSet = new HashSet();
        hashSet.add("18C867F0717AA67B2AB7347505BA07ED");
        ?? r16 = f375664a;
        int[] iArr = Cswitch.J;
        r16.put(Cswitch.a(iArr), hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("31223B0BDF1DEF1FE8252971ADA3B577");
        hashSet2.add("CCD4AD38DC6669F875BC37E3F8840648");
        hashSet2.add("AA3978F41FD96FF9914A669E186474C7");
        hashSet2.add(AppConstants.TIM_SIG_MD5);
        hashSet2.add("A6B745BF24A2C277527716F6F36EB68D");
        hashSet2.add("A01EECAB85E9E3BA2B0F6A158C855C29");
        ?? r17 = f375664a;
        int[] iArr2 = Cswitch.K;
        r17.put(Cswitch.a(iArr2), hashSet2);
        f375665b.put(Cswitch.a(iArr), 105118);
        f375665b.put(Cswitch.a(iArr2), 105178);
    }
}
