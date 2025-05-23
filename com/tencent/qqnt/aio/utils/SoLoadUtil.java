package com.tencent.qqnt.aio.utils;

import android.content.res.AssetManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SoLoadUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Set<String> f352268a;

    /* renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f352269b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashSet hashSet = new HashSet();
        f352268a = hashSet;
        hashSet.add("libamrnb.so");
        f352268a.add("libcodecsilk.so");
        f352269b = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    }

    public SoLoadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native int Decode(AssetManager assetManager, String str, String str2, String str3, String str4);
}
