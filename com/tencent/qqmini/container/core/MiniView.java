package com.tencent.qqmini.container.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import du3.s;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniView extends FrameLayout implements IPage {
    private boolean C;
    private int D;
    private g E;
    private final Runnable F;
    private final fu3.a G;
    private Lifecycle H;
    private int I;
    private int J;
    private final LifecycleObserver K;

    /* renamed from: d, reason: collision with root package name */
    private String f345987d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f345988e;

    /* renamed from: f, reason: collision with root package name */
    private ax f345989f;

    /* renamed from: h, reason: collision with root package name */
    private MiniWebView f345990h;

    /* renamed from: i, reason: collision with root package name */
    private f f345991i;

    /* renamed from: m, reason: collision with root package name */
    private l f345992m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements s.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MiniView> f345994a;

        public a(MiniView miniView) {
            this.f345994a = new WeakReference<>(miniView);
        }

        @Override // du3.s.a
        public void a(boolean z16, String str) {
            MiniView miniView = this.f345994a.get();
            if (miniView == null) {
                return;
            }
            QMLog.i("Mini-MiniView", "container init finish, success: " + z16 + ", message: " + str + miniView.l());
            if (z16) {
                miniView.v();
            } else {
                miniView.u(1, str);
            }
        }
    }

    public MiniView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.I == 3) {
                QMLog.i("Mini-MiniView", "detectRenderException, view is destroyed, return");
                return;
            }
            eu3.g.b("Mini-MiniView", "detectRenderException");
            int width = (int) (this.f345990h.getWidth() * 0.1f);
            int height = (int) (this.f345990h.getHeight() * 0.1f);
            IX5WebViewExtension x5WebViewExtension = this.f345990h.getX5WebViewExtension();
            if (x5WebViewExtension == null) {
                QMLog.e("Mini-MiniView", "detectRenderException, extension is null!" + l());
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            x5WebViewExtension.snapshotVisible(createBitmap, false, false, false, false, 0.1f, 0.1f, null);
            int[] iArr = new int[width * height];
            createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            createBitmap.recycle();
            for (int i3 = 0; i3 < width; i3++) {
                for (int i16 = 0; i16 < height; i16++) {
                    if (iArr[(i3 * width) + i16] != 0) {
                        eu3.g.b("Mini-MiniView", "detectRenderException");
                        QMLog.i("Mini-MiniView", "detectRenderException, no render exception" + l());
                        int i17 = this.D;
                        if (i17 > 0) {
                            this.G.j(i17);
                            return;
                        }
                        return;
                    }
                }
            }
            int i18 = this.D;
            if (i18 < 3) {
                int i19 = i18 + 1;
                this.D = i19;
                if (i19 == 1) {
                    this.G.i();
                }
                w();
            } else {
                u(3, "WebView render exception");
            }
            eu3.g.b("Mini-MiniView", "detectRenderException");
            QMLog.e("Mini-MiniView", "detectRenderException, detect render exception, count: " + this.D + l());
        } catch (Exception e16) {
            QMLog.e("Mini-MiniView", "detectRenderException" + l(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        String str = ", instance: " + hashCode();
        int k3 = k();
        if (k3 > 0) {
            return str + ", viewId: " + k3;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(WeakReference weakReference, int i3, String str) {
        eu3.g.b("Mini-MiniView", "load");
        if (((MiniView) weakReference.get()) == null) {
            return;
        }
        if (i3 == 0) {
            eu3.f.e(this.F, 6000L);
        }
        u(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(WeakReference weakReference) {
        if (((MiniView) weakReference.get()) == null) {
            return;
        }
        this.G.e("mini_app_dom_ready");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, String str) {
        this.J = 2;
        l lVar = this.f345992m;
        if (lVar != null) {
            lVar.onLoaded(i3, str);
        }
        this.G.d(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String str;
        QMLog.d("Mini-MiniView", "onReady" + l());
        if (!du3.s.x().I()) {
            return;
        }
        ax y16 = du3.s.x().y();
        this.f345989f = y16;
        MiniAppInfo miniAppInfo = y16.getMiniAppInfo();
        if (miniAppInfo != null) {
            str = miniAppInfo.version;
        } else {
            str = "";
        }
        this.G.l(str);
        this.G.e("mini_app_container_prepare");
        MiniWebView n3 = this.f345989f.n();
        this.f345990h = n3;
        n3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f345990h, 0);
        final WeakReference weakReference = new WeakReference(this);
        this.f345990h.setLoadCallback(new l() { // from class: com.tencent.qqmini.container.core.n
            @Override // com.tencent.qqmini.container.core.l
            public final void onLoaded(int i3, String str2) {
                MiniView.this.p(weakReference, i3, str2);
            }
        });
        this.f345990h.B(new MiniWebView.c() { // from class: com.tencent.qqmini.container.core.o
            @Override // com.tencent.qqmini.container.core.MiniWebView.c
            public final void a() {
                MiniView.this.q(weakReference);
            }
        });
        this.G.e("mini_app_webview_ready");
        this.f345990h.d0(this.f345987d, this.f345988e);
        this.f345989f.I(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.C) {
            super.dispatchDraw(canvas);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    @Deprecated
    public String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent) {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public ICapsuleButton getCapsuleButton() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarTextStyle() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarVisibility() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public AppPageInfo getPageInfo(int i3) {
        return new AppPageInfo.Builder().setPageId(k()).setPageUrl(this.f345987d).setWindowWidth(getMeasuredWidth()).setWindowHeight(getMeasuredHeight()).build();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public String getPageOrientation() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getTabBarVisibility() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean hideLoading() {
        this.G.e("mini_app_hide_loading");
        f fVar = this.f345991i;
        if (fVar != null && fVar.hide()) {
            return true;
        }
        return false;
    }

    public String j() {
        return this.f345987d;
    }

    public int k() {
        MiniWebView miniWebView = this.f345990h;
        if (miniWebView != null) {
            return miniWebView.J();
        }
        return 0;
    }

    public void m(String str) {
        QMLog.d("Mini-MiniView", "invokeMiniViewCallback, param = " + str);
        g gVar = this.E;
        if (gVar == null) {
            QMLog.d("Mini-MiniView", "invokeMiniViewCallback, but miniViewCallback is null");
        } else {
            gVar.a(str);
        }
    }

    public boolean n() {
        if (this.I == 3) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.I == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QMLog.d("Mini-MiniView", "onAttachedToWindow, isHardwareAccelerated: " + isHardwareAccelerated() + l());
    }

    public void onDestroy() {
        QMLog.d("Mini-MiniView", MosaicConstants$JsFunction.FUNC_ON_DESTROY + l());
        if (this.J == 1) {
            u(4, "miniView destroyed");
        }
        ax axVar = this.f345989f;
        if (axVar != null) {
            axVar.J(this);
            this.f345989f = null;
        }
        MiniWebView miniWebView = this.f345990h;
        if (miniWebView != null) {
            miniWebView.destroy();
        }
        Lifecycle lifecycle = this.H;
        if (lifecycle != null) {
            lifecycle.removeObserver(this.K);
        }
        du3.s.x().w();
        eu3.f.c(this.F);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QMLog.d("Mini-MiniView", "onDetachedFromWindow " + l());
    }

    public void onPause() {
        MiniWebView miniWebView;
        QMLog.d("Mini-MiniView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE + l());
        if (this.f345989f != null && (miniWebView = this.f345990h) != null) {
            miniWebView.i0();
        }
    }

    public void onResume() {
        MiniWebView miniWebView;
        QMLog.d("Mini-MiniView", "onResume" + l());
        if (this.f345989f != null && (miniWebView = this.f345990h) != null) {
            miniWebView.m0();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateCustomButton(String str, long j3, JSONObject jSONObject, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateFloatDragAd(String str, FloatDragAdInfo floatDragAdInfo) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operatePendantAd(String str, PendantAdInfo pendantAdInfo) {
        return false;
    }

    public void r(String str) {
        t(str, this.f345988e);
    }

    public void s(String str, Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            jSONObject = new JSONObject(map);
        }
        t(str, jSONObject);
    }

    public void setDrawEnabled(boolean z16) {
        this.C = z16;
    }

    public void setLifeCycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            return;
        }
        Lifecycle lifecycle = this.H;
        if (lifecycle != null) {
            lifecycle.removeObserver(this.K);
        }
        Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
        this.H = lifecycle2;
        lifecycle2.addObserver(this.K);
    }

    public void setLoadCallback(l lVar) {
        this.f345992m = lVar;
    }

    public void setLoadingView(f fVar) {
        this.f345991i = fVar;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean setMiniAIOEntranceVisible(boolean z16, JSONObject jSONObject) {
        return false;
    }

    public void setMiniViewCallback(g gVar) {
        this.E = gVar;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean showLoading() {
        f fVar = this.f345991i;
        if (fVar != null && fVar.show()) {
            return true;
        }
        return false;
    }

    public void t(String str, JSONObject jSONObject) {
        QMLog.i("Mini-MiniView", "load, path: " + str + ", params: " + jSONObject + l());
        this.J = 1;
        eu3.g.b("Mini-MiniView", "load");
        this.G.k(str);
        this.G.b();
        this.f345987d = str;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f345988e = jSONObject;
        du3.s.x().e0(new a(this));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean toggleDebugPanel() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean toggleMonitorPanel() {
        return false;
    }

    public void w() {
        QMLog.i("Mini-MiniView", "reload, path: " + this.f345987d + ", ready: " + du3.s.x().I() + l());
        if (TextUtils.isEmpty(this.f345987d)) {
            return;
        }
        removeAllViews();
        ax axVar = this.f345989f;
        if (axVar != null) {
            axVar.J(this);
        }
        MiniWebView miniWebView = this.f345990h;
        if (miniWebView != null) {
            miniWebView.destroy();
            this.f345990h = null;
        }
        t(this.f345987d, this.f345988e);
    }

    public void x() {
        QMLog.i("Mini-MiniView", "retry load, path: " + this.f345987d + ", ready: " + du3.s.x().I() + l());
        if (TextUtils.isEmpty(this.f345987d)) {
            return;
        }
        if (du3.s.x().I() && this.f345990h != null) {
            this.G.h();
            this.f345990h.n0();
        } else {
            t(this.f345987d, this.f345988e);
        }
    }

    public MiniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = true;
        this.D = 0;
        this.I = 0;
        this.J = 0;
        this.K = new LifecycleObserver() { // from class: com.tencent.qqmini.container.core.MiniView.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onLifecycleDestroy() {
                if (MiniView.this.I != 3) {
                    MiniView.this.I = 3;
                    MiniView.this.onDestroy();
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void onLifecyclePause() {
                if (MiniView.this.I != 2) {
                    MiniView.this.I = 2;
                    MiniView.this.onPause();
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onLifecycleResume() {
                if (MiniView.this.I != 1) {
                    MiniView.this.I = 1;
                    MiniView.this.onResume();
                }
            }
        };
        this.F = new Runnable() { // from class: com.tencent.qqmini.container.core.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniView.this.i();
            }
        };
        this.G = new fu3.a(du3.s.x().G());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void hideSoftInput(View view) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setNaviVisibility(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setTabBarVisibility(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    @Deprecated
    public void dispatchEventToWebView(String str, String str2, int[] iArr) {
    }
}
