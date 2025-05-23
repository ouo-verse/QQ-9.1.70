package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryControllerSimplify;
import com.tencent.mobileqq.activity.contacts.topentry.b;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactsViewController extends com.tencent.mobileqq.activity.contacts.base.a implements QUIPageTabBar.i, StudyModeChangeListener, com.tencent.mobileqq.activity.contacts.pullrefresh.a, ContactsBaseFragment.c {
    static IPatchRedirector $redirector_;
    private QUIPageTabBar C;
    private CommonRefreshLayout D;
    private q E;
    private HeaderScrollView F;
    private ContactsViewPager G;
    private com.tencent.mobileqq.activity.contacts.base.tabs.c H;
    private com.tencent.mobileqq.activity.contacts.topentry.b I;
    private View J;
    protected View K;
    private com.tencent.mobileqq.activity.contacts.base.tabs.b L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private volatile boolean S;
    private boolean T;
    private BaseContactsMiniAppEntryManager U;
    private long V;
    private ac W;
    private boolean X;
    MqqHandler Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private ar f181463a0;

    /* renamed from: e, reason: collision with root package name */
    private int f181464e;

    /* renamed from: f, reason: collision with root package name */
    private int f181465f;

    /* renamed from: h, reason: collision with root package name */
    private int f181466h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181467i;

    /* renamed from: m, reason: collision with root package name */
    protected QQAppInterface f181468m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.contacts.base.ContactsViewController$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7153a implements vc1.b {
            static IPatchRedirector $redirector_;

            C7153a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // vc1.b
            public void a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ContactsViewController.this.f181465f + "  defaultPos:" + i3);
                }
                if (ContactsViewController.this.f181465f != i3) {
                    ContactsViewController.this.M = true;
                    ContactsViewController.this.t0(i3);
                    ContactsViewController.this.f181466h = i3;
                    ContactsViewController.this.M = false;
                }
                ContactsViewController.this.Z = false;
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onMayKnowEntryStateChanged(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + z16);
            }
            if (z16) {
                ContactsViewController.this.Q(false, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ContactsViewController.this.Z);
            }
            if (ContactsViewController.this.Z) {
                ContactsViewController.this.U(false, new C7153a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        private void a() {
            if (ContactsViewController.this.D != null) {
                ContactsViewController.this.D.setRefreshing(false);
            }
            if (ContactsViewController.this.E != null) {
                q qVar = ContactsViewController.this.E;
                Boolean bool = Boolean.FALSE;
                qVar.j(18, bool);
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101787", false);
                if (QLog.isColorLevel()) {
                    QLog.i("ContactsViewController", 1, "performSwitch: " + isSwitchOn);
                }
                if (isSwitchOn) {
                    ContactsViewController.this.E.j(27, bool);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            switch (message.what) {
                case 3:
                    QQToast.makeText(ContactsViewController.this.f(), 1, R.string.hqe, 0).show(ContactsViewController.this.f181464e);
                    a();
                    break;
                case 4:
                    if (message.arg2 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (ContactsViewController.this.E != null) {
                            ContactsViewController.this.E.j(20, null);
                            ContactsViewController.this.Y.sendEmptyMessage(5);
                            ContactsViewController.this.E.l(0);
                            break;
                        }
                    } else {
                        a();
                        QQToast.makeText(ContactsViewController.this.f(), 1, R.string.hqe, 0).show(ContactsViewController.this.f181464e);
                        break;
                    }
                    break;
                case 5:
                    a();
                    break;
                case 6:
                    ContactsViewController.this.Q(true, true);
                    break;
                case 7:
                    ContactsViewController.this.X();
                    break;
                case 8:
                    ContactsViewController.this.T();
                    break;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements b.InterfaceC7159b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.topentry.b.InterfaceC7159b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ContactsViewController.this.Y.sendEmptyMessageDelayed(7, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (i3 == 1) {
                ContactsViewController contactsViewController = ContactsViewController.this;
                contactsViewController.f181466h = contactsViewController.G.getCurrentItem();
            }
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ContactsViewController.this.Z + "  mPageChangedByIndicator:" + ContactsViewController.this.T);
            }
            if (ContactsViewController.this.T) {
                ContactsViewController.this.Z = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ContactsViewController.this.f0(i3);
                if (!ContactsViewController.this.T) {
                    ReportController.o(ContactsViewController.this.f181468m, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ContactsViewController.this.Z + " mPageChangedByIndicator:" + ContactsViewController.this.T);
                }
                ContactsViewController.this.T = false;
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100236", false)) {
                    ContactsViewController.this.f181466h = i3;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements QUIPageTabBar.g {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.g
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                FrameHelperActivity.gj(!z16, "ContactsViewController");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements vc1.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        @Override // vc1.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ContactsViewController.this.t0(i3);
                if (ContactsViewController.this.f181465f != 0) {
                    ContactsViewController.this.f181467i = true;
                    ContactsViewController.this.f181466h = i3;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements HeaderScrollView.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.base.HeaderScrollView.a
        public void onScroll(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (ContactsViewController.this.H != null) {
                ContactsViewController.this.H.o(i3, i16);
            }
            ContactsViewController.this.n0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class h extends com.tencent.qqnt.kernel.listeneradapt.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ContactsViewController> f181490a;

        public h(ContactsViewController contactsViewController) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) contactsViewController);
            } else {
                this.f181490a = new WeakReference<>(contactsViewController);
            }
        }

        @Override // com.tencent.qqnt.kernel.listeneradapt.a, com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public void onRobotFriendListChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ContactsViewController contactsViewController = this.f181490a.get();
            if (contactsViewController != null) {
                contactsViewController.R();
            }
        }
    }

    public ContactsViewController(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f181466h = -1;
        this.f181467i = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.W = null;
        this.X = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106114", false);
        this.Y = new MqqHandler(Looper.getMainLooper(), new b());
        this.Z = false;
        this.f181463a0 = new a();
        if (activity instanceof SplashActivity) {
            this.f181468m = ((SplashActivity) activity).app;
        }
        this.L = new com.tencent.mobileqq.activity.contacts.base.tabs.b(StudyModeManager.t());
        com.tencent.mobileqq.activity.contacts.topentry.b V = V(activity);
        this.I = V;
        V.o(new c());
        M();
        R();
    }

    private void M() {
        j0();
        this.W = ((IKernelService) this.f181468m.getRuntimeService(IKernelService.class, "all")).getRobotService();
        QLog.i("ContactsViewController", 1, "addRobotFriendChangedListener");
        ac acVar = this.W;
        if (acVar != null) {
            this.V = acVar.addKernelRobotListener(new h(this));
        }
    }

    private static void N(vc1.b bVar, int i3, boolean z16) {
        if (z16) {
            bVar.a(i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.3
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f181474e;

                {
                    this.f181474e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) vc1.b.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        vc1.b.this.a(this.f181474e);
                    }
                }
            });
        }
    }

    private boolean O() {
        com.tencent.mobileqq.activity.contacts.base.tabs.b bVar;
        if (this.H != null && this.G != null && this.C != null && (bVar = this.L) != null && this.f181468m != null && this.F != null) {
            boolean d16 = bVar.d(StudyModeManager.t(), this.S);
            if (d16) {
                this.H.w(this.L.f181545c);
                this.C.setTabData(this.L.f181543a);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, "checkAndUpdateTabShow. mCurrentTabPos:" + this.f181465f + " changed:" + d16);
            }
            return d16;
        }
        return false;
    }

    private boolean P() {
        long j3;
        boolean z16;
        ac robotService = ((IKernelService) this.f181468m.getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService != null) {
            j3 = robotService.getAllRobotFriendsCountFromCache();
        } else {
            j3 = 0;
        }
        QLog.i("ContactsViewController", 1, "checkUpdateRobotTab: size=" + j3);
        if (j3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.S == z16) {
            return false;
        }
        QLog.i("ContactsViewController", 1, "checkUpdateRobotTab: mShowRobotTab" + this.S);
        this.S = z16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "checkTabsNeedChange. causeSwitchAccount:" + z16 + " moveToDefault:" + z17 + " mIsResumed:" + this.N);
        }
        if (this.N) {
            this.M = true;
            int b16 = this.L.b(this.f181465f);
            if (O()) {
                int c16 = this.L.c(b16);
                if (c16 != -1 && !z17) {
                    i0(c16);
                } else {
                    U(z16, new vc1.b() { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.9
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
                            }
                        }

                        @Override // vc1.b
                        public void a(int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                            } else {
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.9.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ int f181480d;

                                    {
                                        this.f181480d = i3;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this, i3);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                            ContactsViewController.this.i0(this.f181480d);
                                            ContactsViewController.this.M = false;
                                        } else {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
            }
            this.M = false;
            return;
        }
        this.P = true;
        this.Q = z16;
        this.R = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.f
            @Override // java.lang.Runnable
            public final void run() {
                ContactsViewController.this.a0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z16, vc1.b bVar) {
        boolean z17 = true;
        int c16 = this.L.c(1);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "getDefaultTabPosition. defaultPos:" + c16);
        }
        N(bVar, c16, z17);
    }

    private com.tencent.mobileqq.activity.contacts.topentry.b V(Activity activity) {
        return new MayKnowPersonEntryControllerSimplify(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i3) {
        X();
        BaseContactsMiniAppEntryManager baseContactsMiniAppEntryManager = this.U;
        if (baseContactsMiniAppEntryManager != null) {
            baseContactsMiniAppEntryManager.setDrawerFrameEvent(com.tencent.mobileqq.activity.home.impl.a.f183040c);
        }
        this.Y.removeMessages(8);
        this.Y.sendEmptyMessageDelayed(8, 500L);
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "onResume. oldPos:" + i3 + " mCurrentTabPos:" + this.f181465f + " isBackground_Stop:" + this.f181468m.isBackgroundStop + " isBackground_Pause:" + this.f181468m.isBackgroundPause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        HeaderScrollView headerScrollView;
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null && (headerScrollView = this.F) != null) {
            cVar.o(headerScrollView.getScrollY(), this.F.c());
        }
    }

    private void Y() {
        int i3;
        try {
            VideoReport.addToDetectionWhitelist(this.f181499d);
            VideoReport.setPageId(this.J, "pg_kl_contact");
            boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(this.f181468m, false, null);
            View view = this.J;
            if (isNowThemeIsSimple) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            VideoReport.setPageParams(view, "qqtype", Integer.valueOf(i3));
            VideoReport.setElementId(this.C, "em_contact_main_panel");
            VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_NONE);
        } catch (Throwable th5) {
            QLog.e("ContactsViewController", 1, th5, new Object[0]);
        }
    }

    private void Z() {
        if (QLog.isColorLevel()) {
            QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
        }
        QQAppInterface qQAppInterface = this.f181468m;
        if (qQAppInterface == null) {
            QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
            return;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if (manager != null && this.f181468m.getCurrentAccountUin() != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).sendUserAppListRequest(manager, Long.valueOf(this.f181468m.getCurrentAccountUin()).longValue(), 20L);
        }
        if (this.U == null) {
            BaseContactsMiniAppEntryManager createContactsMiniAppEntryManager = ((IMiniAppService) QRoute.api(IMiniAppService.class)).createContactsMiniAppEntryManager(f(), this.f181468m, (RelativeLayout) this.E, 1);
            this.U = createContactsMiniAppEntryManager;
            this.D.setMiniAppScrollListener((CommonRefreshLayout.b) createContactsMiniAppEntryManager);
        }
        this.U.showMicroAppPanel(com.tencent.mobileqq.activity.home.impl.a.f183040c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        if (P()) {
            Q(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        HeaderScrollView headerScrollView = this.F;
        if (headerScrollView != null) {
            headerScrollView.scrollTo(0, 0);
        }
    }

    private void d0(QQAppInterface qQAppInterface) {
        BaseContactsMiniAppEntryManager baseContactsMiniAppEntryManager;
        CommonRefreshLayout commonRefreshLayout;
        BaseContactsMiniAppEntryManager baseContactsMiniAppEntryManager2 = this.U;
        if (baseContactsMiniAppEntryManager2 != null) {
            baseContactsMiniAppEntryManager2.onAccountChanged(qQAppInterface);
        }
        if (!s0() && (baseContactsMiniAppEntryManager = this.U) != null && (commonRefreshLayout = this.D) != null) {
            baseContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(commonRefreshLayout, com.tencent.mobileqq.activity.home.impl.a.f183040c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ContactsViewController", 2, "onPageChange. position:" + i3 + " fixPositionCrashSwitch:" + this.X);
        }
        int f373114d = this.H.getF373114d();
        if (this.X && i3 >= f373114d) {
            QLog.d("ContactsViewController", 2, "position >= count position = " + i3 + " count = " + f373114d);
            return;
        }
        this.F.setCurrentScrollableContainer(this.H.l(i3, true));
        this.H.r(i3, this.f181466h);
        this.C.setCurrentPosition(i3, !this.M);
        this.f181465f = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i3) {
        t0(i3);
        this.f181466h = i3;
        this.G.setOffscreenPageLimit(this.L.f181545c.size());
    }

    private void j0() {
        ac acVar = this.W;
        if (acVar != null) {
            acVar.removeKernelRobotListener(this.V);
            this.W = null;
            QLog.i("ContactsViewController", 1, "removeKernelRobotListener");
        }
    }

    private void l0(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("label_field", str);
            hashMap.put("trace_id", "");
            VideoReport.reportEvent("dt_clck", this.C, hashMap);
        } catch (Exception e16) {
            QLog.e("ContactsViewController", 1, "reportTabBarClick ", e16);
        }
    }

    private void m0() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (ContactsViewController.this.L == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.tencent.mobileqq.activity.contacts.base.tabs.f> it = ContactsViewController.this.L.f181545c.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(it.next().f181554a));
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("label_field", arrayList);
                    hashMap.put("trace_id", "");
                    VideoReport.reportEvent("dt_imp", ContactsViewController.this.C, hashMap);
                } catch (Exception e16) {
                    QLog.e("ContactsViewController", 1, "reportTabBarExpose ", e16);
                }
            }
        }, 16, null, false, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null) {
            cVar.u(qQAppInterface);
        }
        HeaderScrollView headerScrollView = this.F;
        if (headerScrollView != null) {
            headerScrollView.scrollTo(0, 0);
        }
        this.I.e(qQAppInterface);
        d0(qQAppInterface);
    }

    private static boolean s0() {
        MiniAppConfBean j3 = MiniAppConfProcessor.j();
        if (j3 != null && j3.d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(int i3) {
        if (this.H != null && this.G != null && this.C != null && this.L != null && this.f181468m != null && this.F != null) {
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, "switchToTabPos mCurrentTabPos:" + this.f181465f + "  pos:" + i3);
            }
            this.f181465f = i3;
            this.C.setCurrentPosition(i3, false);
            this.G.setCurrentItem(this.f181465f, false);
            this.F.setCurrentScrollableContainer(this.H.l(this.f181465f, true));
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
    public void I0(int i3, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "onContactTabChange. position:" + i3 + " fromUserClick:" + z16);
        }
        int currentItem = this.G.getCurrentItem();
        this.f181466h = currentItem;
        if (currentItem != i3) {
            this.T = true;
        }
        this.f181465f = i3;
        this.G.setCurrentItem(i3, false);
        int b16 = this.L.b(i3);
        l0(String.valueOf(b16));
        if (z16) {
            switch (b16) {
                case 1:
                    str = "0X8007F19";
                    break;
                case 2:
                    str = "0X8007F1A";
                    break;
                case 3:
                    str = "0X8007F1C";
                    break;
                case 4:
                    str = "0X8007F1D";
                    break;
                case 5:
                    str = "0X8007F1E";
                    break;
                case 6:
                    str = "0X800A1F6";
                    break;
                default:
                    str = "";
                    break;
            }
            String str2 = str;
            ReportController.o(this.f181468m, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        ContactsViewPager contactsViewPager = this.G;
        if (contactsViewPager != null && ContactsBaseFragment.M == null && contactsViewPager.getHeight() > 0 && this.G.getWidth() > 0) {
            int[] iArr = new int[2];
            this.G.getLocationOnScreen(iArr);
            DisplayMetrics displayMetrics = this.G.getResources().getDisplayMetrics();
            ContactsBaseFragment.M = new Rect(iArr[0], iArr[1], displayMetrics.widthPixels, displayMetrics.heightPixels - ((int) (displayMetrics.density * 54.0f)));
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", ContactsBaseFragment.M.toString(), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(displayMetrics.density)));
            }
        }
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            this.C.updateTabText(R.id.b8m, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle());
        } catch (Throwable th5) {
            QLog.e("ContactsViewController", 2, "updateContactsTabPubAccount error! " + QLog.getStackTraceString(th5));
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.c
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        HeaderScrollView headerScrollView = this.F;
        if (headerScrollView != null && !headerScrollView.f()) {
            HeaderScrollView headerScrollView2 = this.F;
            headerScrollView2.scrollTo(0, headerScrollView2.c());
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.c
    public void c(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "onRefreshResult. position:" + i3 + " success:" + z16);
        }
        this.Y.sendMessage(this.Y.obtainMessage(4, i3, z16 ? 1 : 0));
        if (this.L.c(i3) == 7) {
            R();
        }
    }

    public void c0() {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        HeaderScrollView headerScrollView = this.F;
        if (headerScrollView != null && (findViewById = headerScrollView.findViewById(R.id.f7j)) != null && this.F.getScrollY() > findViewById.getTop()) {
            this.F.scrollTo(0, findViewById.getTop());
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (qQAppInterface != null) {
            QQAppInterface qQAppInterface2 = this.f181468m;
            if (qQAppInterface2 != qQAppInterface) {
                if (qQAppInterface2 != null) {
                    qQAppInterface2.removeObserver(this.f181463a0);
                }
                qQAppInterface.addObserver(this.f181463a0);
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102250", false);
                if (QLog.isColorLevel()) {
                    QLog.i("ContactsViewController", 1, "performSwitch: " + isSwitchOn);
                }
                if (isSwitchOn) {
                    StudyModeManager.U(this);
                    StudyModeManager.H(this);
                }
            }
            this.f181468m = qQAppInterface;
            M();
            boolean P = P();
            if (QLog.isColorLevel()) {
                QLog.i("ContactsViewController", 2, "fillData. tabsChanged:" + P + " mIsResumed:" + this.N);
            }
            this.Y.removeMessages(6);
            if (P) {
                this.Y.sendEmptyMessageDelayed(6, 500L);
                o0(qQAppInterface);
            } else {
                this.M = true;
                U(true, new vc1.b(qQAppInterface) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.8
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f181475a;

                    {
                        this.f181475a = qQAppInterface;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactsViewController.this, (Object) qQAppInterface);
                        }
                    }

                    @Override // vc1.b
                    public void a(int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.8.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ int f181477d;

                                {
                                    this.f181477d = i3;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, i3);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        ContactsViewController.this.t0(this.f181477d);
                                        ContactsViewController.this.f181466h = this.f181477d;
                                        ContactsViewController.this.M = false;
                                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                        ContactsViewController.this.o0(anonymousClass8.f181475a);
                                        ContactsViewController.this.X();
                                        return;
                                    }
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            });
                        }
                    }
                });
                return;
            }
        }
        X();
    }

    public void e0() {
        ContactsViewPager contactsViewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.H != null && (contactsViewPager = this.G) != null) {
            int currentItem = contactsViewPager.getCurrentItem();
            this.H.q(currentItem);
            if (currentItem == this.L.c(1) || currentItem == this.L.c(2)) {
                this.F.scrollTo(0, 0);
            }
        }
        this.Z = false;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void g(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        this.J = view;
        this.C = (QUIPageTabBar) view.findViewById(R.id.ixv);
        this.F = (HeaderScrollView) view.findViewById(R.id.b8a);
        this.G = (ContactsViewPager) view.findViewById(R.id.b8d);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102369", true);
        Fragment findFragmentByTag = ((SplashActivity) f()).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag == null) {
            QLog.i("ContactsViewController", 2, "mainFragment is null");
        }
        if (isSwitchOn && findFragmentByTag != null) {
            this.H = new com.tencent.mobileqq.activity.contacts.base.tabs.c(findFragmentByTag.getChildFragmentManager(), ((SplashActivity) f()).app, (BaseActivity) f(), this.L.f181545c);
        } else {
            this.H = new com.tencent.mobileqq.activity.contacts.base.tabs.c(((SplashActivity) f()).getSupportFragmentManager(), ((SplashActivity) f()).app, (BaseActivity) f(), this.L.f181545c);
        }
        this.H.v(this);
        this.G.setAdapter(this.H);
        this.G.setOffscreenPageLimit(this.L.f181545c.size());
        this.G.setOnPageChangeListener(new d());
        this.C.setTabData(this.L.f181543a);
        this.C.setViewPager(this.G);
        this.C.setTabChangeListener(this);
        this.C.setInterceptListener(new e());
        CommonRefreshLayout commonRefreshLayout = (CommonRefreshLayout) view.findViewById(R.id.j8z);
        this.D = commonRefreshLayout;
        commonRefreshLayout.setRefreshCompleteDelayDuration(0);
        q qVar = (q) this.D.findViewById(R.id.j8x);
        this.E = qVar;
        if (qVar != null) {
            qVar.j(19, null);
        }
        this.D.setOnRefreshListener(this);
        this.I.g(view);
        if (s0()) {
            Z();
        }
        U(false, new f());
        this.F.setOnScrollListener(new g());
        this.K = SimpleModeHelper.x(view.findViewById(R.id.idz));
        Y();
    }

    public void g0(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        ContactsViewPager contactsViewPager = this.G;
        if (contactsViewPager != null) {
            contactsViewPager.setBackground(this.J.getContext().getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        }
        boolean isNowThemeIsDefaultCache = ThemeUtil.isNowThemeIsDefaultCache(this.f181468m, true);
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null) {
            cVar.s(isNowThemeIsDefaultCache, i3);
        }
        this.I.n(isNowThemeIsDefaultCache);
        BaseContactsMiniAppEntryManager baseContactsMiniAppEntryManager = this.U;
        if (baseContactsMiniAppEntryManager != null) {
            baseContactsMiniAppEntryManager.onPostThemeChanged();
        }
        k0();
        this.E = SimpleModeHelper.f(this.D);
        SimpleModeHelper.D(this.K);
        if (!QQTheme.isSimpleWhite() && (view = this.K) != null) {
            view.setVisibility(8);
        }
        ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).onPostThemeChanged();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.h();
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null) {
            cVar.p();
        }
        this.I.h();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.i();
        QQAppInterface qQAppInterface = this.f181468m;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f181463a0);
        }
        this.I.i();
        StudyModeManager.U(this);
        StudyModeManager.H(this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.j();
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null) {
            cVar.g();
        }
        this.I.j();
        QQAppInterface qQAppInterface = this.f181468m;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f181463a0);
        }
        StudyModeManager.U(this);
        j0();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void k(boolean z16) {
        ContactsViewPager contactsViewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        super.k(z16);
        com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
        if (cVar != null && (contactsViewPager = this.G) != null) {
            cVar.h(contactsViewPager.getCurrentItem());
        }
        if (QLog.isColorLevel()) {
            QLog.i("ContactsViewController", 2, "onPause. mCurrentTabPos:" + this.f181465f + " isBackground_Stop:" + this.f181468m.isBackgroundStop + " isBackground_Pause:" + this.f181468m.isBackgroundPause);
        }
        this.I.k(z16);
        this.N = false;
    }

    protected void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            t0(this.L.c(1));
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        this.N = true;
        super.l(z16);
        this.f181468m.setTalkbackSwitch();
        if (this.H != null && this.G != null) {
            if (!this.f181467i) {
                if (QLog.isColorLevel()) {
                    QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
                }
                this.H.i(this.G.getCurrentItem(), z16);
            } else {
                this.f181467i = false;
            }
        }
        this.I.l(z16);
        m0();
        int i3 = this.f181465f;
        if (this.P) {
            Q(this.Q, this.R);
            this.P = false;
            W(i3);
            return;
        }
        U(false, new vc1.b(i3) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.10
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f181469a;

            {
                this.f181469a = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactsViewController.this, i3);
                }
            }

            @Override // vc1.b
            public void a(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(i16) { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.10.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f181471d;

                        {
                            this.f181471d = i16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this, i16);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f181471d != ContactsViewController.this.f181465f) {
                                ContactsViewController contactsViewController = ContactsViewController.this;
                                if (contactsViewController.f181468m.isBackgroundStop) {
                                    contactsViewController.M = true;
                                    ContactsViewController.this.t0(this.f181471d);
                                    ContactsViewController.this.M = false;
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    ContactsViewController.this.W(anonymousClass10.f181469a);
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    protected void n0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        if (this.K == null) {
            return;
        }
        if (!QQTheme.isSimpleWhite()) {
            this.K.setVisibility(8);
        } else if (i3 < 10) {
            this.K.setVisibility(8);
        } else {
            this.K.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
    public void onChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.ContactsViewController.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactsViewController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ContactsViewController.this.Q(false, false);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            Q(false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.a
    public void onRefresh() {
        ContactsViewPager contactsViewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            com.tencent.mobileqq.activity.contacts.base.tabs.c cVar = this.H;
            if (cVar != null && (contactsViewPager = this.G) != null) {
                cVar.t(contactsViewPager.getCurrentItem());
            }
            ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).onRefresh();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
        }
        this.Y.sendMessageDelayed(this.Y.obtainMessage(3), 1000L);
    }

    public void p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QUIPageTabBar qUIPageTabBar = this.C;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setCurrentPosition(this.L.c(3), false);
        }
    }

    public void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        HeaderScrollView headerScrollView = this.F;
        if (headerScrollView == null) {
            return;
        }
        headerScrollView.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.e
            @Override // java.lang.Runnable
            public final void run() {
                ContactsViewController.this.b0();
            }
        });
    }

    public void r0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.f181464e = i3;
        }
    }
}
