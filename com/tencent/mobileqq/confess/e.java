package com.tencent.mobileqq.confess;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f202184a;

    /* renamed from: b, reason: collision with root package name */
    public static Random f202185b;

    /* renamed from: c, reason: collision with root package name */
    private static Paint f202186c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f202184a = 12;
        f202185b = new Random();
        f202186c = new Paint();
    }

    public static float a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f202186c.setTextSize(36.0f);
            return f202186c.measureText(str) / 36.0f;
        }
        return 1.0f;
    }
}
