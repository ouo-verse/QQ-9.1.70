package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface e {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final e f185602a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.guidebanner.e
        public long a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).longValue();
            }
            return ((Long) p.a(BaseApplication.getContext(), str, "key_newer_guide_banner_close_time", 0L)).longValue();
        }

        @Override // com.tencent.mobileqq.activity.recent.guidebanner.e
        public String b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            return (String) p.a(BaseApplication.getContext(), str, "newer_guide_banner_last_preload_time", "");
        }

        @Override // com.tencent.mobileqq.activity.recent.guidebanner.e
        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                p.g(BaseApplication.getContext(), str, true, "newer_guide_banner_last_preload_time", new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).format(new Date()));
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.guidebanner.e
        public void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                p.g(BaseApplication.getContext(), str, true, "key_newer_guide_banner_close_time", Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.guidebanner.e
        public void e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                p.g(BaseApplication.getContext(), str, true, "key_newer_guide_banner_close_time", 0L);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(26574), (Class<?>) e.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f185602a = new a();
        }
    }

    long a(String str);

    String b(String str);

    void c(String str);

    void d(String str);

    void e(String str);
}
