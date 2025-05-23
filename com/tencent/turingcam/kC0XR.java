package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class kC0XR {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f382290a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        Random random = Ckq8l.f381753a;
        byte[] bArr = new byte[3];
        for (int i3 = 0; i3 < 3; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = Integer.valueOf("414553".substring(i16, i16 + 2), 16).byteValue();
        }
        new String(bArr);
    }
}
