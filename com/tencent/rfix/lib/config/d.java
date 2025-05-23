package com.tencent.rfix.lib.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rdelivery.dependency.AbsLog;
import com.tencent.rfix.loader.log.RFixLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends AbsLog {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f364941a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9381);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AbsLog.Level.values().length];
            f364941a = iArr;
            try {
                iArr[AbsLog.Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f364941a[AbsLog.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f364941a[AbsLog.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f364941a[AbsLog.Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f364941a[AbsLog.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void b(@Nullable String str, @NotNull AbsLog.Level level, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, level, str2);
            return;
        }
        int i3 = a.f364941a[level.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            RFixLog.e(str, str2);
                            return;
                        }
                        return;
                    }
                    RFixLog.w(str, str2);
                    return;
                }
                RFixLog.i(str, str2);
                return;
            }
            RFixLog.d(str, str2);
            return;
        }
        RFixLog.v(str, str2);
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void c(@Nullable String str, @NotNull AbsLog.Level level, @Nullable String str2, @Nullable Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, level, str2, th5);
            return;
        }
        int i3 = a.f364941a[level.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            RFixLog.e(str, str2, th5);
                            return;
                        }
                        return;
                    }
                    RFixLog.w(str, str2, th5);
                    return;
                }
                RFixLog.i(str, str2, th5);
                return;
            }
            RFixLog.d(str, str2, th5);
            return;
        }
        RFixLog.v(str, str2, th5);
    }
}
