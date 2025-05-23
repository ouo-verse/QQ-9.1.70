package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.teamwork.menu.ak;
import com.tencent.mobileqq.teamwork.menu.au;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TDocFileBrowserView extends SimpleFileBrowserView {
    static IPatchRedirector $redirector_;
    static final /* synthetic */ boolean N;
    private com.tencent.mobileqq.teamwork.api.b A;
    private c B;
    private INativeEngineFileBrowserWrapper C;
    private MenuTabViewBase D;
    private MenuTabViewBase.a E;
    private ak F;
    RelativeLayout G;
    private View H;
    private QQProgressDialog I;
    private boolean J;
    private volatile boolean K;
    private final WeakReference<Activity> L;
    private OpenDocsPerformanceRecorder M;

    /* renamed from: y, reason: collision with root package name */
    public DocCooperationBanner f206121y;

    /* renamed from: z, reason: collision with root package name */
    public com.tencent.mobileqq.filemanageraux.widget.a f206122z;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class GestureRelativeLayout extends RelativeLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final GestureDetector f206125d;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends GestureDetector.SimpleOnGestureListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TDocFileBrowserView f206127d;

            a(TDocFileBrowserView tDocFileBrowserView) {
                this.f206127d = tDocFileBrowserView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureRelativeLayout.this, (Object) tDocFileBrowserView);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
                }
                if (Math.abs(f17) <= Math.abs(f16)) {
                    return false;
                }
                View c06 = TDocFileBrowserView.this.c0();
                if (f17 > 0.0f) {
                    if (c06 != null) {
                        c06.setVisibility(8);
                    }
                    DocCooperationBanner docCooperationBanner = TDocFileBrowserView.this.f206121y;
                    if (docCooperationBanner != null) {
                        docCooperationBanner.b(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar = TDocFileBrowserView.this.f206122z;
                    if (aVar != null) {
                        aVar.c(true);
                    }
                } else {
                    if (c06 != null) {
                        c06.setVisibility(0);
                    }
                    DocCooperationBanner docCooperationBanner2 = TDocFileBrowserView.this.f206121y;
                    if (docCooperationBanner2 != null) {
                        docCooperationBanner2.e(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar2 = TDocFileBrowserView.this.f206122z;
                    if (aVar2 != null) {
                        aVar2.g(true);
                    }
                }
                return true;
            }
        }

        public GestureRelativeLayout(TDocFileBrowserView tDocFileBrowserView, Context context) {
            this(context, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tDocFileBrowserView, (Object) context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            GestureDetector gestureDetector = this.f206125d;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public GestureRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f206125d = new GestureDetector(context, new a(TDocFileBrowserView.this));
            } else {
                iPatchRedirector.redirect((short) 2, this, TDocFileBrowserView.this, context, attributeSet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements INativeEngineFileBrowserWrapper.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f206129a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f206130b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f206131c;

        a(String str, String str2, String str3) {
            this.f206129a = str;
            this.f206130b = str2;
            this.f206131c = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TDocFileBrowserView.this, str, str2, str3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i3, String str, String str2, String str3, String str4) {
            if (i3 == 0) {
                QLog.i("TDocFileBrowserView", 1, "tDoc_step Native callback refreshWithFileInfo");
                TDocFileBrowserView.this.s0();
                TDocFileBrowserView.this.f0();
                if (TDocFileBrowserView.this.B != null) {
                    TDocFileBrowserView.this.B.a(ITDocFileBrowserFacade.EngineType.NATIVE);
                    return;
                }
                return;
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkPasswordCode(i3)) {
                QLog.i("TDocFileBrowserView", 1, "tDoc_step Native callback hasPassword");
                if (TDocFileBrowserView.this.B != null) {
                    TDocFileBrowserView.this.B.hasPassword();
                    return;
                }
                return;
            }
            if (TDocFileBrowserView.this.B != null) {
                TDocFileBrowserView.this.B.c(i3, str, ITDocFileBrowserFacade.EngineType.NATIVE);
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(str2)) {
                TDocFileBrowserView.this.i0(str2, str3, str4);
                TDocFileBrowserView.this.t0();
                TDocFileBrowserView.this.p0(i3);
            } else {
                QLog.w("TDocFileBrowserView", 1, "web engine is not support to open the file");
                if (TDocFileBrowserView.this.B != null) {
                    TDocFileBrowserView.this.B.b(i3, str);
                }
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void b(final int i3, final String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("TDocFileBrowserView", 1, "tDoc_step nativeLoadCallback, code:" + i3 + " msg:" + str);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final String str2 = this.f206129a;
            final String str3 = this.f206130b;
            final String str4 = this.f206131c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.a.this.e(i3, str, str2, str3, str4);
                }
            });
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (TDocFileBrowserView.this.B != null) {
                TDocFileBrowserView.this.B.b(i3, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements b.InterfaceC8637b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDocFileBrowserView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            TDocFileBrowserView.this.s0();
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Log.d("TDocFileBrowserView", "loadUrl loadStart");
            QLog.i("TDocFileBrowserView", 1, "tDoc_step web beforeLoadUrl refreshWithFileInfo");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.view.h
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.b.this.f();
                }
            });
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void b(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
                return;
            }
            Log.d("TDocFileBrowserView", "loadUrl onError code = " + i3 + " msg = " + str);
            if (TDocFileBrowserView.this.B == null) {
                return;
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkPasswordCode(i3)) {
                QLog.i("TDocFileBrowserView", 1, "tDoc_step Web callback hasPassword");
                TDocFileBrowserView.this.B.hasPassword();
            } else if (i3 == 0) {
                TDocFileBrowserView.this.B.a(ITDocFileBrowserFacade.EngineType.WEB);
            } else {
                TDocFileBrowserView.this.B.c(i3, str, ITDocFileBrowserFacade.EngineType.WEB);
                TDocFileBrowserView.this.B.b(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Log.d("TDocFileBrowserView", "loadUrl loadFinish");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a(ITDocFileBrowserFacade.EngineType engineType);

        void b(int i3, String str);

        void c(int i3, String str, ITDocFileBrowserFacade.EngineType engineType);

        void hasPassword();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            N = true;
        }
    }

    public TDocFileBrowserView(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.J = true;
        this.K = false;
        this.L = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(String str, String str2) {
        String a06 = a0(str);
        if (a06 == null) {
            return;
        }
        boolean isNativeSupportDocsType = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isNativeSupportDocsType(a06);
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.C;
        if (iNativeEngineFileBrowserWrapper != null && isNativeSupportDocsType) {
            iNativeEngineFileBrowserWrapper.onResume();
            return;
        }
        boolean isWebEngineEnable = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(a06);
        com.tencent.mobileqq.teamwork.api.b bVar = this.A;
        if (bVar != null && isWebEngineEnable) {
            bVar.onResume();
        }
    }

    private String a0(String str) {
        return ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(str);
    }

    private void e0(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        Activity activity = this.L.get();
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isBottomMenuEnable() && this.C != null && activity != null) {
            this.E = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createMenuItemClickListener(activity, teamWorkFileImportInfo, this.C, this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper;
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isBottomMenuEnable() && (iNativeEngineFileBrowserWrapper = this.C) != null && this.D == null) {
            this.D = iNativeEngineFileBrowserWrapper.a(this.f206085b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            this.D.setMenuClickListener(new MenuTabViewBase.a() { // from class: com.tencent.mobileqq.filebrowser.view.b
                @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase.a
                public final boolean a(au auVar) {
                    boolean j06;
                    j06 = TDocFileBrowserView.this.j0(auVar);
                    return j06;
                }
            });
            this.G.addView(this.D, layoutParams);
        }
    }

    private void g0(String str, String str2, String str3) {
        t0();
        QLog.i("TDocFileBrowserView", 1, "tDoc_step initNativeEngineFileBrowser");
        Activity activity = this.L.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "initNativeEngineFileBrowser activity is null");
            return;
        }
        o0(ITDocFileBrowserFacade.EngineType.NATIVE);
        INativeEngineFileBrowserWrapper createNativeEngineFileBrowser = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createNativeEngineFileBrowser(activity, str3, ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(str), INativeEngineFileBrowserWrapper.OpenMode.CHILD_PROCESS, this.M, new a(str, str2, str3));
        this.C = createNativeEngineFileBrowser;
        A0(null, createNativeEngineFileBrowser.getView());
        this.G.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.filebrowser.view.f
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TDocFileBrowserView.this.k0();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h0(String str, String str2) {
        boolean z16;
        String a06 = a0(str);
        if (a06 == null) {
            QLog.w("TDocFileBrowserView", 1, "engine is not support to open the file, filePath = " + str + "no type");
            c cVar = this.B;
            if (cVar != null) {
                cVar.b(-102, ITDocFileBrowserFacade.TD_UNSUPPORTED_MSG);
                return;
            }
            return;
        }
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isNativeSupportDocsType(a06)) {
            g0(a06, str2, str);
        } else if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(a06)) {
            i0(a06, str2, str);
        } else {
            z16 = false;
            if (z16) {
                QLog.w("TDocFileBrowserView", 1, "engine is not support to open the file, filePath =" + str);
                c cVar2 = this.B;
                if (cVar2 != null) {
                    cVar2.b(-101, ITDocFileBrowserFacade.TD_UNSUPPORTED_MSG);
                    return;
                }
                return;
            }
            QLog.i("TDocFileBrowserView", 1, " initView refreshWithFileInfo");
            s0();
            return;
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str, String str2, String str3) {
        View view;
        u0();
        Activity activity = this.L.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "initWebEngineFileBrowser activity is null");
            return;
        }
        o0(ITDocFileBrowserFacade.EngineType.WEB);
        com.tencent.mobileqq.teamwork.api.b createWebEngineFileBrowser = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createWebEngineFileBrowser(activity, str, this.M, new b());
        this.A = createWebEngineFileBrowser;
        View view2 = createWebEngineFileBrowser.getView();
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.C;
        if (iNativeEngineFileBrowserWrapper != null) {
            view = iNativeEngineFileBrowserWrapper.getView();
        } else {
            view = null;
        }
        A0(view, view2);
        this.A.loadUrl(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getWebEngineFileLoadUrl(str, str3, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j0(au auVar) {
        MenuTabViewBase.a aVar = this.E;
        if (aVar != null) {
            boolean a16 = aVar.a(auVar);
            this.D.c();
            return a16;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0() {
        int r06 = r0(this.G.getWidth());
        int r07 = r0(this.G.getHeight());
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.C;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.c(new RectF(0.0f, 0.0f, r06, r07));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Runnable runnable, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q(true);
        o(false);
        if (runnable != null) {
            runnable.run();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        h0(str, str2);
        e0(teamWorkFileImportInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(boolean z16) {
        this.K = z16;
    }

    private void o0(ITDocFileBrowserFacade.EngineType engineType) {
        OpenDocsPerformanceRecorder openDocsPerformanceRecorder = this.M;
        if (openDocsPerformanceRecorder != null) {
            openDocsPerformanceRecorder.f(engineType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3) {
        OpenDocsPerformanceRecorder openDocsPerformanceRecorder = this.M;
        if (openDocsPerformanceRecorder != null) {
            openDocsPerformanceRecorder.g(i3);
        }
    }

    private int r0(float f16) {
        Activity activity = this.L.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "px2dp activity is null");
        } else {
            f16 = (f16 / activity.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        RelativeLayout relativeLayout;
        if (this.K) {
            QLog.i("TDocFileBrowserView", 1, "refreshWithFileInfo pauseLoad");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f206084a.getParent();
        if (viewGroup != null && (relativeLayout = this.G) != null) {
            if (relativeLayout.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) this.G.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.G);
                viewGroup2.removeViews(indexOfChild + 1, viewGroup2.getChildCount() - 1);
                if (indexOfChild > 0) {
                    viewGroup2.removeViews(0, indexOfChild);
                }
            } else {
                viewGroup.addView(this.G, 0, new RelativeLayout.LayoutParams(-1, -1));
            }
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof RelativeLayout) {
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
                QLog.i("TDocFileBrowserView", 1, "refreshWithFileInfo statusBarHeight = " + statusBarHeight);
                ((RelativeLayout) parent).setPadding(0, statusBarHeight, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.C;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.onDestroy();
            this.C = null;
            QLog.i("TDocFileBrowserView", 1, "releaseNativeView");
        }
    }

    private void u0() {
        com.tencent.mobileqq.teamwork.api.b bVar = this.A;
        if (bVar != null) {
            bVar.onDestroy();
            this.A = null;
            QLog.i("TDocFileBrowserView", 1, "releaseWebView");
        }
    }

    boolean A0(View view, View view2) {
        int indexOfChild;
        int i3 = 0;
        if (view2 == null) {
            return false;
        }
        if (view != null && view.hashCode() == view2.hashCode()) {
            return false;
        }
        if (view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeAllViews();
        }
        Activity activity = this.L.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "setRealFileView activity is null");
            return false;
        }
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout == null) {
            if (!N && view != null) {
                throw new AssertionError();
            }
            this.G = new GestureRelativeLayout(this, activity);
        } else {
            if (view == null || (indexOfChild = relativeLayout.indexOfChild(view)) < 0) {
                return false;
            }
            this.G.removeView(view);
            i3 = indexOfChild;
        }
        this.G.addView(view2, i3, new RelativeLayout.LayoutParams(-1, -1));
        return true;
    }

    public void B0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (this.f206085b.isFinishing()) {
            return;
        }
        if (this.I == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f206085b);
            this.I = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
        }
        if (!this.I.isShowing()) {
            this.I.setMessage(str);
            this.I.show();
        }
    }

    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.teamwork.api.b bVar = this.A;
        if (bVar != null) {
            bVar.onDestroy();
        }
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.C;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.onDestroy();
        }
        MenuTabViewBase menuTabViewBase = this.D;
        if (menuTabViewBase != null) {
            menuTabViewBase.b();
        }
    }

    public void D0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206123d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f206124e;

                {
                    this.f206123d = str;
                    this.f206124e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDocFileBrowserView.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TDocFileBrowserView.this.E0(this.f206123d, this.f206124e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.K;
    }

    public View c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.H;
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.I;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.I.dismiss();
        }
    }

    public void q0(final Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
            return;
        }
        q(false);
        o(true);
        e(HardCodeUtil.qqStr(R.string.iop), new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TDocFileBrowserView.this.l0(runnable, view);
            }
        });
    }

    public void v0(ak akVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) akVar);
        } else {
            this.F = akVar;
        }
    }

    public void w0(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
        } else {
            this.B = cVar;
        }
    }

    public void x0(final String str, final String str2, final TeamWorkFileImportInfo teamWorkFileImportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, teamWorkFileImportInfo);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.this.m0(str, str2, teamWorkFileImportInfo);
                }
            });
        }
    }

    public void y0(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.this.n0(z16);
                }
            });
        }
    }

    public void z0(OpenDocsPerformanceRecorder openDocsPerformanceRecorder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) openDocsPerformanceRecorder);
        } else {
            this.M = openDocsPerformanceRecorder;
        }
    }
}
