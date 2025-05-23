package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface ac {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static abstract class a implements ac {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void c(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void d(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void f(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void i(int i3, ArrayList<q> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static abstract class b implements ac {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void b(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void c(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void d(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void f(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public final void g(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) qVar);
            }
        }
    }

    void b(int i3, boolean z16);

    void c(int i3, q qVar);

    void d(int i3, q qVar);

    void e(int i3);

    void f(int i3, q qVar);

    void g(int i3, q qVar);

    void i(int i3, ArrayList<q> arrayList);
}
