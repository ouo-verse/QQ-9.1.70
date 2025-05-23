package com.tencent.mobileqq.location;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.ui.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: classes15.dex */
public class LocationPickViewModelV2 extends com.tencent.mobileqq.mvvm.c<c> {
    static IPatchRedirector $redirector_;
    public static ViewModelProvider.Factory G;
    private com.tencent.mobileqq.location.ui.d C;
    public MutableLiveData<com.tencent.mobileqq.location.model.b> D;
    public MutableLiveData<Integer> E;
    private final Runnable F;

    /* renamed from: i, reason: collision with root package name */
    private Activity f241194i;

    /* renamed from: m, reason: collision with root package name */
    private LocationRoom.b f241195m;

    /* loaded from: classes15.dex */
    class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new LocationPickViewModelV2(new c());
        }
    }

    /* loaded from: classes15.dex */
    class b implements d.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickViewModelV2.this);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.d.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                LocationPickViewModelV2.this.E.setValue(4);
                                return;
                            }
                            return;
                        }
                        LocationPickViewModelV2.this.E.setValue(3);
                        return;
                    }
                    LocationPickViewModelV2.this.E.setValue(2);
                    return;
                }
                LocationPickViewModelV2.this.E.setValue(1);
                return;
            }
            LocationPickViewModelV2 locationPickViewModelV2 = LocationPickViewModelV2.this;
            locationPickViewModelV2.O1(locationPickViewModelV2.E);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            G = new a();
        }
    }

    public LocationPickViewModelV2(c cVar) {
        super(cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new Runnable() { // from class: com.tencent.mobileqq.location.LocationPickViewModelV2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationPickViewModelV2.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (LocationPickViewModelV2.this.C.getCount() <= 0) {
                    LocationPickViewModelV2.this.E.setValue(2);
                }
                QQToast.makeText(LocationPickViewModelV2.this.f241194i, 1, R.string.hh5, 0).show();
            }
        };
    }

    public void N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((c) this.mRepository).k();
        }
    }

    protected void O1(MutableLiveData<Integer> mutableLiveData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) mutableLiveData);
            return;
        }
        if (mutableLiveData == null) {
            QLog.e("Q.LocationShare", 1, "STATE_LOADING setValue param empty");
            return;
        }
        try {
            mutableLiveData.setValue(0);
        } catch (Exception e16) {
            QLog.e("Q.LocationShare", 1, "STATE_LOADING setValue error: " + e16);
        }
    }

    public void P1(QBaseActivity qBaseActivity, LocationRoom.b bVar, com.tencent.mobileqq.location.ui.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, bVar, dVar);
            return;
        }
        this.f241194i = qBaseActivity;
        this.f241195m = bVar;
        this.C = dVar;
        ((c) this.mRepository).m(this);
    }

    public boolean Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.C.n();
    }

    public void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            com.tencent.mobileqq.location.ui.b.c().a();
            ((c) this.mRepository).l();
        }
    }

    public void S1(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + bVar + " mRoomKey: " + this.f241195m);
        }
        QQToast.makeText(BaseApplication.getContext(), "\u5df2\u5728\u5176\u4ed6\u8bbe\u5907\u8fdb\u884c\u5171\u4eab", 0).show();
        this.f241194i.setResult(1);
        this.f241194i.finish();
    }

    public void T1(LocationRoom.b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, i3);
        } else if (bVar.equals(this.f241195m) && i3 != 2 && i3 != 1) {
            this.f241194i.setResult(1);
            LocationDialogUtil.k(this.f241194i);
        }
    }

    public void U1(LocationRoom.b bVar, int i3, int i16) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "onOperateRoomResponse: invoked. ", " roomKey: ", bVar, " errorCode: ", Integer.valueOf(i3), " operateType: ", Integer.valueOf(i16));
        }
        if (!bVar.equals(this.f241195m)) {
            return;
        }
        if (i3 == 10100) {
            Activity activity2 = this.f241194i;
            if (activity2 != null && !activity2.isFinishing()) {
                this.f241194i.setResult(1);
                LocationDialogUtil.k(this.f241194i);
                return;
            }
            return;
        }
        if (i3 == 10101 && (activity = this.f241194i) != null && !activity.isFinishing()) {
            this.f241194i.setResult(1);
            LocationDialogUtil.l(this.f241194i);
        }
    }

    public void W1(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bVar, venue, list);
            return;
        }
        if (bVar.equals(this.f241195m) && !this.f241194i.isFinishing()) {
            com.tencent.mobileqq.location.model.b bVar2 = new com.tencent.mobileqq.location.model.b();
            bVar2.f241301a = bVar;
            bVar2.f241302b = venue;
            bVar2.f241303c = list;
            this.D.postValue(bVar2);
        }
    }

    public void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ThreadManager.getUIHandler().postDelayed(this.F, 10000L);
        }
    }

    public void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            ThreadManager.getUIHandler().removeCallbacks(this.F);
        }
    }

    public void a2(TencentMap tencentMap, LatLng latLng, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tencentMap, latLng, str);
        } else {
            this.C.m(tencentMap, latLng, LocationHandler.K2().J2(this.f241195m).j().b(), str);
        }
    }

    public void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.C.o(new b());
        }
    }
}
