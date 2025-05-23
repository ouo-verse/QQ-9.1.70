package com.tencent.mobileqq.avifcodec.decoder;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, com.tencent.mobileqq.avifcodec.decoder.data.e> f200176a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34761);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, com.tencent.mobileqq.avifcodec.decoder.data.e> hashMap = new HashMap<>();
        f200176a = hashMap;
        hashMap.put(1, new c());
        hashMap.put(2, new d());
        hashMap.put(3, new e());
    }

    public static com.tencent.mobileqq.avifcodec.decoder.data.e a(int i3) {
        return f200176a.get(Integer.valueOf(i3));
    }
}
