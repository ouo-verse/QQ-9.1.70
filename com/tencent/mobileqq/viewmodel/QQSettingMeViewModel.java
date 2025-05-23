package com.tencent.mobileqq.viewmodel;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade;
import com.tencent.mobileqq.activity.qqsettingme.bean.b;
import com.tencent.mobileqq.activity.qqsettingme.bean.g;
import com.tencent.mobileqq.activity.qqsettingme.bean.h;
import com.tencent.mobileqq.activity.qqsettingme.bean.i;
import com.tencent.mobileqq.activity.qqsettingme.bean.j;
import com.tencent.mobileqq.activity.qqsettingme.bean.k;
import com.tencent.mobileqq.activity.qqsettingme.bean.l;
import com.tencent.mobileqq.activity.qqsettingme.bean.m;
import com.tencent.mobileqq.activity.qqsettingme.bean.n;
import com.tencent.mobileqq.activity.qqsettingme.bean.o;
import com.tencent.mobileqq.activity.qqsettingme.bean.p;
import com.tencent.mobileqq.activity.qqsettingme.bean.q;
import com.tencent.mobileqq.activity.qqsettingme.r;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.s;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQSettingMeViewModel extends c<r> {
    static IPatchRedirector $redirector_;

    /* renamed from: m0, reason: collision with root package name */
    public static ViewModelProvider.Factory f312690m0;

    /* renamed from: n0, reason: collision with root package name */
    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor.yml", version = 2)
    private static ArrayList<Class<? extends s>> f312691n0;
    public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> C;
    public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> D;
    public MutableLiveData<n> E;
    public MutableLiveData<l> F;
    public MutableLiveData<g> G;
    public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> H;
    public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> I;
    public MutableLiveData<o> J;
    public MutableLiveData<b> K;
    public MutableLiveData<String> L;
    public MutableLiveData<h> M;
    public MutableLiveData<i> N;
    public MutableLiveData<k> P;
    public MutableLiveData<j> Q;
    public MutableLiveData<q> R;
    public MutableLiveData<p> S;
    public MutableLiveData<Boolean> T;
    public MutableLiveData<m> U;
    public final MutableLiveData<Integer> V;
    public final MutableLiveData<Integer> W;
    public final MutableLiveData<Integer> X;
    private final MutableLiveData<Float> Y;
    private final MutableLiveData<Boolean> Z;

    /* renamed from: a0, reason: collision with root package name */
    private final MutableLiveData<Boolean> f312692a0;

    /* renamed from: b0, reason: collision with root package name */
    public final MutableLiveData<Integer> f312693b0;

    /* renamed from: c0, reason: collision with root package name */
    public final MutableLiveData<Boolean> f312694c0;

    /* renamed from: d0, reason: collision with root package name */
    public final MutableLiveData<Integer> f312695d0;

    /* renamed from: e0, reason: collision with root package name */
    public final MutableLiveData<Boolean> f312696e0;

    /* renamed from: f0, reason: collision with root package name */
    public final MutableLiveData<Integer> f312697f0;

    /* renamed from: g0, reason: collision with root package name */
    public final MutableLiveData<Integer> f312698g0;

    /* renamed from: h0, reason: collision with root package name */
    public final MutableLiveData<Boolean> f312699h0;

    /* renamed from: i, reason: collision with root package name */
    private s f312700i;

    /* renamed from: i0, reason: collision with root package name */
    public final MutableLiveData<Integer> f312701i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f312702j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f312703k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f312704l0;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.a> f312705m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
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
            return new QQSettingMeViewModel(new r());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        f312690m0 = new a();
        ArrayList<Class<? extends s>> arrayList = new ArrayList<>();
        f312691n0 = arrayList;
        arrayList.add(DrawerBizFacade.class);
    }

    public QQSettingMeViewModel(r rVar) {
        super(rVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rVar);
            return;
        }
        this.f312705m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>();
        this.M = new MutableLiveData<>();
        this.N = new MutableLiveData<>();
        this.P = new MutableLiveData<>();
        this.Q = new MutableLiveData<>();
        this.R = new MutableLiveData<>();
        this.S = new MutableLiveData<>();
        this.T = new MutableLiveData<>();
        this.U = new MutableLiveData<>();
        this.V = new MutableLiveData<>();
        this.W = new MutableLiveData<>();
        this.X = new MutableLiveData<>();
        this.Y = new MutableLiveData<>();
        this.Z = new MutableLiveData<>();
        this.f312692a0 = new MutableLiveData<>(Boolean.TRUE);
        this.f312693b0 = new MutableLiveData<>();
        this.f312694c0 = new MutableLiveData<>();
        this.f312695d0 = new MutableLiveData<>();
        this.f312696e0 = new MutableLiveData<>();
        this.f312697f0 = new MutableLiveData<>();
        this.f312698g0 = new MutableLiveData<>();
        this.f312699h0 = new MutableLiveData<>();
        this.f312701i0 = new MutableLiveData<>();
        this.f312702j0 = 0;
        this.f312703k0 = 0;
        this.f312704l0 = -1;
    }

    public void M1(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime);
        } else {
            O1().c(appRuntime);
        }
    }

    public com.tencent.mobileqq.processor.b N1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.processor.b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return ((com.tencent.mobileqq.processor.a) O1()).e(str);
    }

    public s O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (s) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        s sVar = this.f312700i;
        if (sVar != null) {
            return sVar;
        }
        if (f312691n0.size() != 0) {
            try {
                s newInstance = f312691n0.get(0).newInstance();
                this.f312700i = newInstance;
                return newInstance;
            } catch (IllegalAccessException | InstantiationException e16) {
                e16.printStackTrace();
            }
        } else {
            QLog.i("QQSettingMeViewModel", 2, "getQQSettingMeProcessor. sInjectProcessor.size() = 0");
        }
        return new com.tencent.mobileqq.a();
    }

    public String P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        int i3 = this.f312704l0;
        if (i3 != 0) {
            if (i3 == 1) {
                return "0";
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    return "0";
                }
                if (i3 != 4) {
                    return "";
                }
            }
            return "1";
        }
        return "2";
    }

    public int Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (this.f312703k0 <= 0) {
            this.f312703k0 = ScreenUtil.getRealHeight(BaseApplication.getContext());
        }
        return this.f312703k0;
    }

    public MutableLiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f312692a0;
    }

    public MutableLiveData<Boolean> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.Z;
    }

    public MutableLiveData<Float> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.Y;
    }

    public void U1(QBaseActivity qBaseActivity, LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) lifecycleOwner);
        } else {
            O1().f(qBaseActivity, lifecycleOwner);
        }
    }

    public void W1(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            O1().d(aVar);
        }
    }

    public void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            O1().onConfigurationChanged();
        }
    }

    public void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            O1().a();
        }
    }

    public void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            O1().b();
        }
    }

    public void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            O1().onPostThemeChanged();
        }
    }

    public void c2(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, (Object) motionEvent);
        } else {
            O1().onTouch(view, motionEvent);
        }
    }

    public void d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            O1().preload();
        }
    }

    public void e2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            O1().g(str);
        }
    }

    public void f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            O1().reset();
        }
    }

    public void g2(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (i3 != this.f312704l0 && i3 >= 0 && i3 <= 4) {
            int i17 = 2;
            QLog.i("QQSettingMeViewModel", 2, "setDrawerMode: " + i3);
            this.f312704l0 = i3;
            boolean z16 = false;
            z16 = false;
            z16 = false;
            z16 = false;
            boolean z17 = true;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            z17 = false;
                            i16 = 2;
                            i17 = 0;
                        }
                    } else {
                        z16 = true;
                    }
                    i16 = 2;
                    i17 = z16 ? 1 : 0;
                } else {
                    i16 = 1;
                    i17 = 1;
                    z17 = false;
                }
            } else {
                i16 = 0;
            }
            this.f312695d0.postValue(Integer.valueOf(i17));
            this.f312696e0.postValue(Boolean.valueOf(z16));
            this.f312698g0.postValue(Integer.valueOf(i16));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(z17) { // from class: com.tencent.mobileqq.viewmodel.QQSettingMeViewModel.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f312706d;

                {
                    this.f312706d = z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQSettingMeViewModel.this, Boolean.valueOf(z17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQSettingMeViewModel.this.Z.setValue(Boolean.valueOf(this.f312706d));
                    }
                }
            });
        }
    }

    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else {
            O1().onClick(view);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            O1().onDestroy();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            O1().onPause();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            O1().onResume();
        }
    }
}
