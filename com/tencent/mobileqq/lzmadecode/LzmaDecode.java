package com.tencent.mobileqq.lzmadecode;

import android.content.res.AssetManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LzmaDecode {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f243267a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f243267a = new a();
        }
    }

    public LzmaDecode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(b bVar) {
        f243267a = bVar;
    }

    public static native int decode(AssetManager assetManager, String str, String str2, String str3, String str4);

    public static native int decodeEx(String str, String str2);
}
