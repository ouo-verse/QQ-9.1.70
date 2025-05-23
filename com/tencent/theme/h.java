package com.tencent.theme;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface h {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f376073a;

        /* renamed from: b, reason: collision with root package name */
        public String f376074b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f376075c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    boolean needTransformDrawable(int i3);

    a transformDrawable(int i3, String str);
}
