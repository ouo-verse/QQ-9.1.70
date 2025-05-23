package com.tencent.mobileqq.location;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.location.ui.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Observer<com.tencent.mobileqq.location.model.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f241287d;

        a(k kVar) {
            this.f241287d = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.location.model.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            } else {
                this.f241287d.w(bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f241288d;

        b(k kVar) {
            this.f241288d = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else {
                this.f241288d.r(bool.booleanValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Observer<com.tencent.mobileqq.location.model.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f241289d;

        c(k kVar) {
            this.f241289d = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.location.model.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                this.f241289d.h(cVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements Observer<com.tencent.mobileqq.location.model.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.location.ui.e f241290d;

        d(com.tencent.mobileqq.location.ui.e eVar) {
            this.f241290d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.location.model.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            } else {
                this.f241290d.j(bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Observer<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.location.ui.e f241291d;

        e(com.tencent.mobileqq.location.ui.e eVar) {
            this.f241291d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                return;
            }
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4) {
                                this.f241291d.r();
                                return;
                            }
                            return;
                        }
                        this.f241291d.o();
                        return;
                    }
                    this.f241291d.m();
                    return;
                }
                this.f241291d.q();
                return;
            }
            this.f241291d.p();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.f$f, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7972f implements Observer<com.tencent.mobileqq.location.model.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.location.ui.g f241292d;

        C7972f(com.tencent.mobileqq.location.ui.g gVar) {
            this.f241292d = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.location.model.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            } else {
                this.f241292d.n(bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g implements Observer<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.location.ui.g f241293d;

        g(com.tencent.mobileqq.location.ui.g gVar) {
            this.f241293d = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                return;
            }
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4) {
                                this.f241293d.w();
                                return;
                            }
                            return;
                        }
                        this.f241293d.t();
                        return;
                    }
                    this.f241293d.r();
                    return;
                }
                this.f241293d.v();
                return;
            }
            this.f241293d.u();
        }
    }

    public static void a(LocationPickViewModel locationPickViewModel, com.tencent.mobileqq.mvvm.d dVar, com.tencent.mobileqq.location.ui.e eVar) {
        locationPickViewModel.N1();
        locationPickViewModel.D.observe(dVar, new d(eVar));
        locationPickViewModel.E.observe(dVar, new e(eVar));
    }

    public static void b(LocationPickViewModelV2 locationPickViewModelV2, com.tencent.mobileqq.mvvm.d dVar, com.tencent.mobileqq.location.ui.g gVar) {
        locationPickViewModelV2.N1();
        locationPickViewModelV2.D.observe(dVar, new C7972f(gVar));
        locationPickViewModelV2.E.observe(dVar, new g(gVar));
    }

    public static void c(LocationShareViewModel locationShareViewModel, com.tencent.mobileqq.mvvm.d dVar, k kVar) {
        locationShareViewModel.O1();
        locationShareViewModel.D.observe(dVar, new a(kVar));
        locationShareViewModel.E.observe(dVar, new b(kVar));
        locationShareViewModel.F.observe(dVar, new c(kVar));
    }
}
