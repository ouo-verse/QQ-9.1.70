package com.tencent.mobileqq.location;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f241249a;

    /* renamed from: b, reason: collision with root package name */
    private LocationShareViewModel f241250b;

    /* renamed from: c, reason: collision with root package name */
    private final h f241251c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.friend.observer.a f241252d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.troop.api.observer.b f241253e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.mobileqq.troop.api.observer.f f241254f;

    /* renamed from: g, reason: collision with root package name */
    private INetInfoHandler f241255g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void a(LocationRoom.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
                return;
            }
            if (com.tencent.mobileqq.location.util.d.a(MobileQQ.sMobileQQ.getApplicationContext())) {
                i16 = 5;
            }
            if (i16 == i3) {
                return;
            }
            d.this.f241250b.W1(bVar);
        }

        @Override // com.tencent.mobileqq.location.h
        public void b(LocationRoom.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, i3);
            } else {
                d.this.f241250b.X1(bVar, i3);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void c(LocationRoom.b bVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                d.this.f241250b.b2(bVar, i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void d(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, bVar, venue, list);
                return;
            }
            com.tencent.mobileqq.location.model.b bVar2 = new com.tencent.mobileqq.location.model.b();
            bVar2.f241301a = bVar;
            bVar2.f241302b = venue;
            bVar2.f241303c = list;
            d.this.f241250b.D.postValue(bVar2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else {
                super.onUpdateDelFriend(z16, obj);
                d.this.f241250b.d2(z16, String.valueOf(obj));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            super.l(i3, i16, str);
            if ((i3 == 2 || i3 == 9) && i16 == 0) {
                LocationShareViewModel.g2(d.this.f241249a, 1, str);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.d$d, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7971d extends com.tencent.mobileqq.troop.api.observer.f {
        static IPatchRedirector $redirector_;

        C7971d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String str, int i3, ITroopPushHandler.PushType pushType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), pushType);
            } else {
                super.b(str, i3, pushType);
                d.this.f241250b.c2(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                d.this.f241250b.a2();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                d.this.f241250b.a2();
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241251c = new a();
        this.f241252d = new b();
        this.f241253e = new c();
        this.f241254f = new C7971d();
        this.f241255g = new e();
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f241249a.addObserver(this.f241253e);
        this.f241249a.addObserver(this.f241254f);
        this.f241249a.addObserver(this.f241252d);
        LocationHandler.K2().G2(this.f241251c);
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f241255g);
    }

    public void m(AppInterface appInterface, LocationShareViewModel locationShareViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) locationShareViewModel);
        } else {
            this.f241249a = appInterface;
            this.f241250b = locationShareViewModel;
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            AppNetConnInfo.unregisterNetInfoHandler(this.f241255g);
        } catch (Exception e16) {
            QLog.e("Q.LocationShare", 1, "onFragmentDestroy: failed. ", e16);
        }
        this.f241249a.removeObserver(this.f241253e);
        this.f241249a.removeObserver(this.f241254f);
        this.f241249a.removeObserver(this.f241252d);
        LocationHandler.K2().Q2(this.f241251c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            n();
            this.f241255g = null;
        }
    }
}
