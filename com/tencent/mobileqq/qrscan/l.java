package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f276668a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f276669b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f276670c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f276671d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int[] f276672a;

        public a(int... iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iArr);
            } else {
                this.f276672a = iArr;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f276672a.length;
        }

        public int[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f276672a;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276668a = new a(1);
        f276669b = new a(2);
        f276670c = new a(2, 1);
        f276671d = new a(2, 1, 3);
    }
}
