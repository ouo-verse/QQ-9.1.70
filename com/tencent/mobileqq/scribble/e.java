package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f282558a;

    /* renamed from: b, reason: collision with root package name */
    public static int f282559b;

    /* renamed from: c, reason: collision with root package name */
    public static int f282560c;

    /* renamed from: d, reason: collision with root package name */
    public static int f282561d;

    /* renamed from: e, reason: collision with root package name */
    public static int f282562e;

    /* renamed from: f, reason: collision with root package name */
    public static int f282563f;

    /* renamed from: g, reason: collision with root package name */
    public static int f282564g;

    /* renamed from: h, reason: collision with root package name */
    public static int f282565h;

    /* renamed from: i, reason: collision with root package name */
    public static int f282566i;

    /* renamed from: j, reason: collision with root package name */
    public static int f282567j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f282558a = 0;
        f282559b = 1;
        f282560c = 2;
        f282561d = 1;
        f282562e = 2;
        f282563f = 3;
        f282564g = 4;
        f282565h = 5;
        f282566i = 6;
        f282567j = 7;
    }

    public static String a() {
        return AppConstants.SCRIBBLE_FILE_DIR + "ScribbleCache/";
    }
}
