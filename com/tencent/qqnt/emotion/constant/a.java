package com.tencent.qqnt.emotion.constant;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static short f356188a;

    /* renamed from: b, reason: collision with root package name */
    public static int f356189b;

    /* renamed from: c, reason: collision with root package name */
    public static int f356190c;

    /* renamed from: d, reason: collision with root package name */
    public static int f356191d;

    /* renamed from: e, reason: collision with root package name */
    public static int f356192e;

    /* renamed from: f, reason: collision with root package name */
    public static int f356193f;

    /* renamed from: g, reason: collision with root package name */
    public static int f356194g;

    /* renamed from: h, reason: collision with root package name */
    public static int f356195h;

    /* renamed from: i, reason: collision with root package name */
    public static String f356196i;

    /* renamed from: j, reason: collision with root package name */
    public static String f356197j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f356188a = (short) 0;
        f356189b = 0;
        f356190c = 1;
        f356191d = 2;
        f356192e = 3;
        f356193f = 4;
        f356194g = 100;
        f356195h = 101;
        f356196i = HardCodeUtil.qqStr(R.string.zuy);
        f356197j = HardCodeUtil.qqStr(R.string.f170884zv0);
    }
}
