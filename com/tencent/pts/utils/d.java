package com.tencent.pts.utils;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Typeface> f342266a;

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Typeface> f342267b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342266a = new ConcurrentHashMap<>();
            f342267b = new ConcurrentHashMap<>();
        }
    }

    public static Typeface a(Context context, String str) throws RuntimeException {
        Typeface typeface = f342266a.get(str);
        if (typeface == null) {
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str);
            f342266a.put(str, createFromAsset);
            return createFromAsset;
        }
        return typeface;
    }

    public static Typeface b(String str) {
        Typeface typeface = f342267b.get(str);
        if (typeface == null) {
            Typeface create = Typeface.create(str, 0);
            f342267b.put(str, create);
            return create;
        }
        return typeface;
    }
}
