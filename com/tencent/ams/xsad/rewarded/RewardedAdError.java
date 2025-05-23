package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardedAdError {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f71713a;

    /* renamed from: b, reason: collision with root package name */
    private String f71714b;

    /* renamed from: c, reason: collision with root package name */
    private int f71715c;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int DISABLE = 100;
        public static final int LOAD_AD_DATA_INVALID = 106;
        public static final int LOAD_EMPTY_ORDER = 107;
        public static final int LOAD_FAILED = 104;
        public static final int LOAD_PARAMS_ERROR = 102;
        public static final int LOAD_PARSE_FAILED = 105;
        public static final int LOAD_PROVIDER_EMPTY = 101;
        public static final int LOAD_URL_ERROR = 103;
        public static final int SHOW_AD_INVALID = 204;
        public static final int SHOW_NOT_FINISH_LOAD = 203;
        public static final int SHOW_NULL_CONTEXT = 201;
        public static final int SHOW_PLAY_FAILED = 205;
        public static final int SHOW_UNLOCK_DURATION_ERROR = 202;
    }

    public RewardedAdError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.f71713a = i3;
            this.f71714b = str;
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f71713a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71714b;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f71715c;
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f71715c = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return String.format(Locale.getDefault(), "%s(%d)", this.f71714b, Integer.valueOf(this.f71713a));
    }
}
