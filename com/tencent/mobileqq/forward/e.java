package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface e {
    public static final IPatchRedirector $redirector_ = null;
    public static final Integer N3;
    public static final Integer O3;
    public static final Integer P3;
    public static final Integer Q3;
    public static final Integer R3;
    public static final Integer S3;
    public static final Integer T3;
    public static final Integer U3;
    public static final Integer V3;
    public static final Integer W3;
    public static final Integer X3;
    public static final Integer Y3;
    public static final Integer Z3;

    /* renamed from: a4, reason: collision with root package name */
    public static final Integer f211015a4;

    /* renamed from: c4, reason: collision with root package name */
    public static final Integer f211016c4;

    /* renamed from: e4, reason: collision with root package name */
    public static final Integer f211017e4;

    /* renamed from: f4, reason: collision with root package name */
    public static final Integer f211018f4;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(71990), (Class<?>) e.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        N3 = 0;
        O3 = 1;
        P3 = 2;
        Q3 = 3;
        R3 = 4;
        S3 = 5;
        T3 = 6;
        U3 = 8;
        V3 = 9;
        W3 = 10;
        X3 = 11;
        Y3 = 12;
        Z3 = 13;
        f211015a4 = 14;
        f211016c4 = 15;
        f211017e4 = 16;
        f211018f4 = 17;
    }
}
