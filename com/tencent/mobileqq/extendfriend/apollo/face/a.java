package com.tencent.mobileqq.extendfriend.apollo.face;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface a {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f205553a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f205554b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f205555c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f205556d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f205557e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f205558f;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(71777), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        int[] iArr = {0, 1};
        f205553a = iArr;
        int[] iArr2 = {0, 1, 2};
        f205554b = iArr2;
        f205555c = b.h(0, 0);
        f205556d = b.g(iArr, iArr2);
        f205557e = new int[]{0, 8, 7, 6};
        f205558f = new int[]{-2611, -5427, -7983, -665107, -1190657, -2304513, -2826497};
    }
}
