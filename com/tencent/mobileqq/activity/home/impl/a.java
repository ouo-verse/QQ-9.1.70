package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f183038a;

    /* renamed from: b, reason: collision with root package name */
    public static int f183039b;

    /* renamed from: c, reason: collision with root package name */
    public static int f183040c;

    /* renamed from: d, reason: collision with root package name */
    public static int f183041d;

    /* renamed from: e, reason: collision with root package name */
    public static int f183042e;

    /* renamed from: f, reason: collision with root package name */
    public static int f183043f;

    /* renamed from: g, reason: collision with root package name */
    public static int f183044g;

    /* renamed from: h, reason: collision with root package name */
    public static int f183045h;

    /* renamed from: i, reason: collision with root package name */
    public static int f183046i;

    /* renamed from: j, reason: collision with root package name */
    public static int f183047j;

    /* renamed from: k, reason: collision with root package name */
    public static int f183048k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45160);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f183038a = 0;
        f183039b = 1;
        f183040c = 2;
        f183041d = 3;
        f183042e = 4;
        f183043f = 5;
        f183044g = 7;
        f183045h = 8;
        f183046i = 9;
        f183047j = 11;
        f183048k = 12;
    }
}
