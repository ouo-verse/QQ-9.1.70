package com.tencent.mobileqq.filemanager.fileviewer.viewer;

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
import com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.teamwork.menu.ak;
import com.tencent.mobileqq.teamwork.menu.au;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TDocFileBrowserView extends SimpleFileViewer {

    /* renamed from: e0, reason: collision with root package name */
    public DocCooperationBanner f208570e0;

    /* renamed from: f0, reason: collision with root package name */
    public com.tencent.mobileqq.filemanageraux.widget.a f208571f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.mobileqq.teamwork.api.b f208572g0;

    /* renamed from: h0, reason: collision with root package name */
    private c f208573h0;

    /* renamed from: i0, reason: collision with root package name */
    private INativeEngineFileBrowserWrapper f208574i0;

    /* renamed from: j0, reason: collision with root package name */
    private MenuTabViewBase f208575j0;

    /* renamed from: k0, reason: collision with root package name */
    private MenuTabViewBase.a f208576k0;

    /* renamed from: l0, reason: collision with root package name */
    private ak f208577l0;

    /* renamed from: m0, reason: collision with root package name */
    RelativeLayout f208578m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f208579n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f208580o0;

    /* renamed from: p0, reason: collision with root package name */
    private volatile boolean f208581p0;

    /* renamed from: q0, reason: collision with root package name */
    private final WeakReference<Activity> f208582q0;

    /* renamed from: r0, reason: collision with root package name */
    private OpenDocsPerformanceRecorder f208583r0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class GestureRelativeLayout extends RelativeLayout {

        /* renamed from: d, reason: collision with root package name */
        private final GestureDetector f208586d;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends GestureDetector.SimpleOnGestureListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TDocFileBrowserView f208588d;

            a(TDocFileBrowserView tDocFileBrowserView) {
                this.f208588d = tDocFileBrowserView;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (Math.abs(f17) <= Math.abs(f16)) {
                    return false;
                }
                View H0 = TDocFileBrowserView.this.H0();
                if (f17 > 0.0f) {
                    if (H0 != null) {
                        H0.setVisibility(8);
                    }
                    DocCooperationBanner docCooperationBanner = TDocFileBrowserView.this.f208570e0;
                    if (docCooperationBanner != null) {
                        docCooperationBanner.b(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar = TDocFileBrowserView.this.f208571f0;
                    if (aVar != null) {
                        aVar.c(true);
                    }
                } else {
                    if (H0 != null) {
                        H0.setVisibility(0);
                    }
                    DocCooperationBanner docCooperationBanner2 = TDocFileBrowserView.this.f208570e0;
                    if (docCooperationBanner2 != null) {
                        docCooperationBanner2.e(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar2 = TDocFileBrowserView.this.f208571f0;
                    if (aVar2 != null) {
                        aVar2.g(true);
                    }
                }
                return true;
            }
        }

        public GestureRelativeLayout(TDocFileBrowserView tDocFileBrowserView, Context context) {
            this(context, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f208586d;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public GestureRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f208586d = new GestureDetector(context, new a(TDocFileBrowserView.this));
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

    public TDocFileBrowserView(Activity activity) {
        super(activity);
        this.f208580o0 = true;
        this.f208581p0 = false;
        this.f208582q0 = new WeakReference<>(activity);
    }

    private String F0(String str) {
        return ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(str);
    }

    private void I0(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        Activity activity = this.f208582q0.get();
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isBottomMenuEnable() && this.f208574i0 != null && activity != null) {
            this.f208576k0 = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createMenuItemClickListener(activity, teamWorkFileImportInfo, this.f208574i0, this.f208577l0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper;
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isBottomMenuEnable() && (iNativeEngineFileBrowserWrapper = this.f208574i0) != null && this.f208575j0 == null) {
            this.f208575j0 = iNativeEngineFileBrowserWrapper.a(this.f208578m0.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            this.f208575j0.setMenuClickListener(new MenuTabViewBase.a() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.c
                @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase.a
                public final boolean a(au auVar) {
                    boolean N0;
                    N0 = TDocFileBrowserView.this.N0(auVar);
                    return N0;
                }
            });
            this.f208578m0.addView(this.f208575j0, layoutParams);
        }
    }

    private void K0(String str, String str2, String str3) {
        W0();
        Activity activity = this.f208582q0.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "initNativeEngineFileBrowser activity is null");
            return;
        }
        S0(ITDocFileBrowserFacade.EngineType.NATIVE);
        INativeEngineFileBrowserWrapper createNativeEngineFileBrowser = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createNativeEngineFileBrowser(activity, str3, ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(str), INativeEngineFileBrowserWrapper.OpenMode.CHILD_PROCESS, this.f208583r0, new a(str, str2, str3));
        this.f208574i0 = createNativeEngineFileBrowser;
        d1(null, createNativeEngineFileBrowser.getView());
        this.f208578m0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.g
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TDocFileBrowserView.this.O0();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L0(String str, String str2) {
        boolean z16;
        String F0 = F0(str);
        if (F0 == null) {
            QLog.w("TDocFileBrowserView", 1, "engine is not support to open the file, filePath = " + str + "no type");
            c cVar = this.f208573h0;
            if (cVar != null) {
                cVar.b(-102, ITDocFileBrowserFacade.TD_UNSUPPORTED_MSG);
                return;
            }
            return;
        }
        if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isNativeSupportDocsType(F0)) {
            K0(F0, str2, str);
        } else if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(F0)) {
            M0(F0, str2, str);
        } else {
            z16 = false;
            if (z16) {
                QLog.w("TDocFileBrowserView", 1, "engine is not support to open the file, filePath =" + str);
                c cVar2 = this.f208573h0;
                if (cVar2 != null) {
                    cVar2.b(-101, ITDocFileBrowserFacade.TD_UNSUPPORTED_MSG);
                    return;
                }
                return;
            }
            QLog.i("TDocFileBrowserView", 1, " initView refreshWithFileInfo");
            R();
            return;
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(String str, String str2, String str3) {
        View view;
        X0();
        Activity activity = this.f208582q0.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "initWebEngineFileBrowser activity is null");
            return;
        }
        S0(ITDocFileBrowserFacade.EngineType.WEB);
        com.tencent.mobileqq.teamwork.api.b createWebEngineFileBrowser = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).createWebEngineFileBrowser(activity, str, this.f208583r0, new b());
        this.f208572g0 = createWebEngineFileBrowser;
        View view2 = createWebEngineFileBrowser.getView();
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f208574i0;
        if (iNativeEngineFileBrowserWrapper != null) {
            view = iNativeEngineFileBrowserWrapper.getView();
        } else {
            view = null;
        }
        d1(view, view2);
        this.f208572g0.loadUrl(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getWebEngineFileLoadUrl(str, str3, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean N0(au auVar) {
        MenuTabViewBase.a aVar = this.f208576k0;
        if (aVar != null) {
            boolean a16 = aVar.a(auVar);
            this.f208575j0.c();
            return a16;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0() {
        int V0 = V0(this.f208578m0.getWidth());
        int V02 = V0(this.f208578m0.getHeight());
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f208574i0;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.c(new RectF(0.0f, 0.0f, V0, V02));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(Runnable runnable, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        o(true);
        n(false);
        if (runnable != null) {
            runnable.run();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        L0(str, str2);
        I0(teamWorkFileImportInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        RelativeLayout relativeLayout;
        if (this.f208581p0) {
            QLog.i("TDocFileBrowserView", 1, "refreshWithFileInfo pauseLoad");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f208606e.getParent();
        if (viewGroup != null && (relativeLayout = this.f208578m0) != null) {
            if (relativeLayout.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) this.f208578m0.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f208578m0);
                viewGroup2.removeViews(indexOfChild + 1, viewGroup2.getChildCount() - 1);
                if (indexOfChild > 0) {
                    viewGroup2.removeViews(0, indexOfChild);
                }
            } else {
                viewGroup.addView(this.f208578m0, 0, new RelativeLayout.LayoutParams(-1, -1));
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
    public /* synthetic */ void R0(boolean z16) {
        this.f208581p0 = z16;
    }

    private void S0(ITDocFileBrowserFacade.EngineType engineType) {
        OpenDocsPerformanceRecorder openDocsPerformanceRecorder = this.f208583r0;
        if (openDocsPerformanceRecorder != null) {
            openDocsPerformanceRecorder.f(engineType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(int i3) {
        OpenDocsPerformanceRecorder openDocsPerformanceRecorder = this.f208583r0;
        if (openDocsPerformanceRecorder != null) {
            openDocsPerformanceRecorder.g(i3);
        }
    }

    private int V0(float f16) {
        Activity activity = this.f208582q0.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "px2dp activity is null");
        } else {
            f16 = (f16 / activity.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f208574i0;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.onDestroy();
            this.f208574i0 = null;
            QLog.i("TDocFileBrowserView", 1, "releaseNativeView");
        }
    }

    private void X0() {
        com.tencent.mobileqq.teamwork.api.b bVar = this.f208572g0;
        if (bVar != null) {
            bVar.onDestroy();
            this.f208572g0 = null;
            QLog.i("TDocFileBrowserView", 1, "releaseWebView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(String str, String str2) {
        String F0 = F0(str);
        if (F0 == null) {
            return;
        }
        boolean isNativeSupportDocsType = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isNativeSupportDocsType(F0);
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f208574i0;
        if (iNativeEngineFileBrowserWrapper != null && isNativeSupportDocsType) {
            iNativeEngineFileBrowserWrapper.onResume();
            return;
        }
        boolean isWebEngineEnable = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(F0);
        com.tencent.mobileqq.teamwork.api.b bVar = this.f208572g0;
        if (bVar != null && isWebEngineEnable) {
            bVar.onResume();
        }
    }

    public boolean G0() {
        return this.f208581p0;
    }

    public View H0() {
        return this.f208579n0;
    }

    public void U0(final Runnable runnable) {
        o(false);
        n(true);
        e(HardCodeUtil.qqStr(R.string.iop), new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TDocFileBrowserView.this.P0(runnable, view);
            }
        });
    }

    public void Y0(ak akVar) {
        this.f208577l0 = akVar;
    }

    public void Z0(c cVar) {
        this.f208573h0 = cVar;
    }

    public void a1(final String str, final String str2, final TeamWorkFileImportInfo teamWorkFileImportInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.d
            @Override // java.lang.Runnable
            public final void run() {
                TDocFileBrowserView.this.Q0(str, str2, teamWorkFileImportInfo);
            }
        });
    }

    public void b1(final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.f
            @Override // java.lang.Runnable
            public final void run() {
                TDocFileBrowserView.this.R0(z16);
            }
        });
    }

    public void c1(OpenDocsPerformanceRecorder openDocsPerformanceRecorder) {
        this.f208583r0 = openDocsPerformanceRecorder;
    }

    boolean d1(View view, View view2) {
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
        Activity activity = this.f208582q0.get();
        if (activity == null) {
            QLog.e("TDocFileBrowserView", 1, "setRealFileView activity is null");
            return false;
        }
        RelativeLayout relativeLayout = this.f208578m0;
        if (relativeLayout == null) {
            this.f208578m0 = new GestureRelativeLayout(this, activity);
        } else {
            if (view == null || (indexOfChild = relativeLayout.indexOfChild(view)) < 0) {
                return false;
            }
            this.f208578m0.removeView(view);
            i3 = indexOfChild;
        }
        this.f208578m0.addView(view2, i3, new RelativeLayout.LayoutParams(-1, -1));
        return true;
    }

    public void e1() {
        com.tencent.mobileqq.teamwork.api.b bVar = this.f208572g0;
        if (bVar != null) {
            bVar.onDestroy();
        }
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f208574i0;
        if (iNativeEngineFileBrowserWrapper != null) {
            iNativeEngineFileBrowserWrapper.onDestroy();
        }
        MenuTabViewBase menuTabViewBase = this.f208575j0;
        if (menuTabViewBase != null) {
            menuTabViewBase.b();
        }
    }

    public void f1(final String str, final String str2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView.3
            @Override // java.lang.Runnable
            public void run() {
                TDocFileBrowserView.this.g1(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements INativeEngineFileBrowserWrapper.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f208590a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f208591b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f208592c;

        a(String str, String str2, String str3) {
            this.f208590a = str;
            this.f208591b = str2;
            this.f208592c = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i3, String str, String str2, String str3, String str4) {
            if (i3 == 0) {
                QLog.i("TDocFileBrowserView", 1, " Native callback refreshWithFileInfo");
                TDocFileBrowserView.this.R();
                TDocFileBrowserView.this.J0();
                if (TDocFileBrowserView.this.f208573h0 != null) {
                    TDocFileBrowserView.this.f208573h0.a(ITDocFileBrowserFacade.EngineType.NATIVE);
                    return;
                }
                return;
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkPasswordCode(i3)) {
                QLog.i("TDocFileBrowserView", 1, "tDoc_step Native callback hasPassword");
                if (TDocFileBrowserView.this.f208573h0 != null) {
                    TDocFileBrowserView.this.f208573h0.hasPassword();
                    return;
                }
                return;
            }
            if (TDocFileBrowserView.this.f208573h0 != null) {
                TDocFileBrowserView.this.f208573h0.c(i3, str, ITDocFileBrowserFacade.EngineType.NATIVE);
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isWebEngineEnable(str2)) {
                TDocFileBrowserView.this.M0(str2, str3, str4);
                TDocFileBrowserView.this.W0();
                TDocFileBrowserView.this.T0(i3);
            } else {
                QLog.w("TDocFileBrowserView", 1, "web engine is not support to open the file");
                if (TDocFileBrowserView.this.f208573h0 != null) {
                    TDocFileBrowserView.this.f208573h0.b(i3, str);
                }
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void b(final int i3, final String str) {
            QLog.i("TDocFileBrowserView", 1, "nativeLoadCallback, code:" + i3 + " msg:" + str);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final String str2 = this.f208590a;
            final String str3 = this.f208591b;
            final String str4 = this.f208592c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.h
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.a.this.e(i3, str, str2, str3, str4);
                }
            });
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void d(int i3) {
            if (TDocFileBrowserView.this.f208573h0 != null) {
                TDocFileBrowserView.this.f208573h0.b(i3, "");
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.c
        public void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements b.InterfaceC8637b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            TDocFileBrowserView.this.R();
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void a() {
            Log.d("TDocFileBrowserView", "loadUrl loadStart");
            QLog.i("TDocFileBrowserView", 1, "tDoc_step web beforeLoadUrl refreshWithFileInfo");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.i
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFileBrowserView.b.this.f();
                }
            });
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void b(int i3, String str) {
            Log.d("TDocFileBrowserView", "loadUrl onError code = " + i3 + " msg = " + str);
            if (TDocFileBrowserView.this.f208573h0 == null) {
                return;
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkPasswordCode(i3)) {
                QLog.i("TDocFileBrowserView", 1, "tDoc_step Web callback hasPassword");
                TDocFileBrowserView.this.f208573h0.hasPassword();
            } else if (i3 == 0) {
                TDocFileBrowserView.this.f208573h0.a(ITDocFileBrowserFacade.EngineType.WEB);
            } else {
                TDocFileBrowserView.this.f208573h0.c(i3, str, ITDocFileBrowserFacade.EngineType.WEB);
                TDocFileBrowserView.this.f208573h0.b(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void d() {
            Log.d("TDocFileBrowserView", "loadUrl loadFinish");
        }

        @Override // com.tencent.mobileqq.teamwork.api.b.InterfaceC8637b
        public void c() {
        }
    }
}
