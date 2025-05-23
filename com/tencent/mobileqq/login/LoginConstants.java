package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface LoginConstants {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f241790a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface AccountLoginType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface LoginType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface PhoneLoginType {
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38262), (Class<?>) LoginConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f241790a = new ArrayList<>(Arrays.asList("0X800AA33", "0X800AA34", "0X800AA35", "0X800AA36", "0X800AA37", "0X800B0AA", "0X800B0AC", "0X800B0A3", "0X800B106", "0X800B107", "0X800B108", "0X800B109", "0X800B10A", "0X800B10B", "0X800B10C", "0X800ADD9", "0X800B660", "0X800ADDC", "0X800ADDD", "0X800BA0B", "0X800BA0C", "0X800ADDA", "0X800B662", "0X800B663", "0X800B664", "0X800B661", "0X800BC46", "0X800A31A", "0X800BC47", "0X800BC48"));
        }
    }
}
