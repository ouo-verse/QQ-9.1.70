package com.tencent.mobileqq.fragment.blacklist;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.blacklist.proto.a;
import com.tencent.mobileqq.fragment.blacklist.proto.b;
import com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager;
import com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.ShieldUserDisplayDataSeq;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.UserDisplayDataSeq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    UserDisplayManager f211301a;

    /* renamed from: b, reason: collision with root package name */
    ShieldUserDisplayManager f211302b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.mobileqq.fragment.blacklist.proto.a f211303c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.fragment.blacklist.proto.b f211304d;

    /* renamed from: e, reason: collision with root package name */
    AppInterface f211305e;

    /* renamed from: f, reason: collision with root package name */
    BlackListViewModel f211306f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements a.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f211307a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.fragment.blacklist.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7628a implements a.c {
            static IPatchRedirector $redirector_;

            C7628a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.fragment.blacklist.proto.a.c
            public void a(long j3, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.fragment.blacklist.proto.a.c
            public void b(UserDisplayManager.a aVar) {
                d dVar;
                BlackListViewModel blackListViewModel;
                BlackListViewModel blackListViewModel2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                    return;
                }
                if ((aVar != null || (blackListViewModel2 = d.this.f211306f) == null || blackListViewModel2.X1().getValue() == null) && (blackListViewModel = (dVar = d.this).f211306f) != null && dVar.f211301a != null) {
                    blackListViewModel.X1().postValue(aVar);
                    d.this.f211301a.d(aVar);
                }
            }
        }

        a(long j3) {
            this.f211307a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.a.c
        public void a(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
            } else if (j3 == 0 || j3 != this.f211307a) {
                d dVar = d.this;
                dVar.f211303c.a(dVar.f211305e, 0L, 0L, 500, new C7628a());
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.a.c
        public void b(UserDisplayManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements b.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f211310a;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.d {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
            public void a(long j3, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
            public void b(ShieldUserDisplayManager.a aVar) {
                d dVar;
                BlackListViewModel blackListViewModel;
                BlackListViewModel blackListViewModel2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                    return;
                }
                if ((aVar != null || (blackListViewModel2 = d.this.f211306f) == null || blackListViewModel2.Z1().getValue() == null) && (blackListViewModel = (dVar = d.this).f211306f) != null && dVar.f211302b != null) {
                    blackListViewModel.Z1().postValue(aVar);
                    d.this.f211302b.d(aVar);
                }
            }
        }

        b(long j3) {
            this.f211310a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void a(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
            } else if (j3 == 0 || j3 != this.f211310a) {
                d dVar = d.this;
                dVar.f211304d.b(dVar.f211305e, 0L, 0L, 500, new a());
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void b(ShieldUserDisplayManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements b.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void a(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            BlackListViewModel blackListViewModel = d.this.f211306f;
            if (blackListViewModel != null) {
                blackListViewModel.U1().postValue(Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void b(ShieldUserDisplayManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppInterface appInterface, BlackListViewModel blackListViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) blackListViewModel);
            return;
        }
        this.f211305e = appInterface;
        this.f211306f = blackListViewModel;
        this.f211301a = (UserDisplayManager) appInterface.getManager(QQManagerFactory.BLACK_LIST_MANAGER);
        this.f211302b = (ShieldUserDisplayManager) appInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER_NEW);
        this.f211303c = new com.tencent.mobileqq.fragment.blacklist.proto.a();
        this.f211304d = new com.tencent.mobileqq.fragment.blacklist.proto.b();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f211304d.a(this.f211305e, new c());
        }
    }

    public void b() {
        BlackListViewModel blackListViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        UserDisplayManager.a b16 = this.f211301a.b();
        if (b16 != null && (blackListViewModel = this.f211306f) != null) {
            blackListViewModel.X1().postValue(b16);
        }
    }

    public void c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        UserDisplayDataSeq c16 = this.f211301a.c();
        if (c16 == null) {
            str = "0";
        } else {
            str = c16.seq;
        }
        this.f211303c.b(this.f211305e, 0L, new a(Long.valueOf(str).longValue()));
    }

    public void d() {
        BlackListViewModel blackListViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ShieldUserDisplayManager.a b16 = this.f211302b.b();
        if (b16 != null && (blackListViewModel = this.f211306f) != null) {
            blackListViewModel.Z1().postValue(b16);
        }
    }

    public void e() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ShieldUserDisplayDataSeq c16 = this.f211302b.c();
        if (c16 == null) {
            str = "0";
        } else {
            str = c16.seq;
        }
        this.f211304d.c(this.f211305e, 0L, new b(Long.valueOf(str).longValue()));
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f211305e = null;
        this.f211306f = null;
        this.f211301a = null;
        this.f211302b = null;
    }
}
