package com.tencent.turingcam;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CXNbL {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Set<String>> f381751a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f381752b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f381751a = new HashMap();
        f381752b = new HashMap();
        HashSet hashSet = new HashSet();
        hashSet.add("18C867F0717AA67B2AB7347505BA07ED");
        Map<String, Set<String>> map = f381751a;
        int[] iArr = LwgsO.J;
        map.put(LwgsO.a(iArr), hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("31223B0BDF1DEF1FE8252971ADA3B577");
        hashSet2.add("CCD4AD38DC6669F875BC37E3F8840648");
        hashSet2.add("AA3978F41FD96FF9914A669E186474C7");
        hashSet2.add(AppConstants.TIM_SIG_MD5);
        hashSet2.add("A6B745BF24A2C277527716F6F36EB68D");
        hashSet2.add("A01EECAB85E9E3BA2B0F6A158C855C29");
        Map<String, Set<String>> map2 = f381751a;
        int[] iArr2 = LwgsO.K;
        map2.put(LwgsO.a(iArr2), hashSet2);
        f381752b.put(LwgsO.a(iArr), 105118);
        f381752b.put(LwgsO.a(iArr2), 105178);
    }
}
