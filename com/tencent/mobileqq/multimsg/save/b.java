package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, String> f251673a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        f251673a = hashMap;
        hashMap.put(10001, BaseApplication.getContext().getString(R.string.f173074h41));
        f251673a.put(10002, BaseApplication.getContext().getString(R.string.h3z));
        f251673a.put(10003, BaseApplication.getContext().getString(R.string.f173165hp0));
        f251673a.put(10004, BaseApplication.getContext().getString(R.string.aer));
        f251673a.put(10005, BaseApplication.getContext().getString(R.string.h3w));
        f251673a.put(10006, BaseApplication.getContext().getString(R.string.h4b));
        f251673a.put(10007, BaseApplication.getContext().getString(R.string.f173073h40));
    }

    public static String a(int i3) {
        return f251673a.get(Integer.valueOf(i3));
    }
}
