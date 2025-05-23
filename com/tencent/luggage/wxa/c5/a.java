package com.tencent.luggage.wxa.c5;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.ic.s0;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.b0;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.c5.f, com.tencent.luggage.wxa.wj.f {

    @Nullable
    private String _softOrientation;

    @Nullable
    private final com.tencent.luggage.wxa.wj.e activityOrientationHandler;

    @NotNull
    private final DisplayMetrics displayMetrics;
    private final boolean dryRun;
    private int heightPx;

    @Nullable
    private com.tencent.luggage.wxa.j4.d initConfig;
    private boolean isFold;
    private final boolean isFoldDevice;
    private boolean isLastInMultiWindowMode;
    private int lastLandscapeVHeight;
    private int lastLandscapeVWidth;
    private int lastOrientation;
    private int lastPortraitVHeight;
    private int lastPortraitVWidth;
    private int lastScreenHDp;
    private int lastScreenWDp;
    private int maxEdge;
    private int minEdge;

    @NotNull
    private String orientation;
    private boolean resizable;

    /* renamed from: rt, reason: collision with root package name */
    @NotNull
    private final com.tencent.luggage.wxa.ic.g f123291rt;
    private float scale;
    private double systemRatio;
    private int widthPx;

    @NotNull
    private b windowOrientation;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class ViewOnLayoutChangeListenerC6094a implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public int f123292a;

        public abstract void a(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29);

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            int i29 = this.f123292a + 1;
            this.f123292a = i29;
            a(view, i3, i16, i17, i18, i19, i26, i27, i28, i29);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        LANDSCAPE,
        PORTRAIT
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public final void a(e.b bVar, boolean z16) {
            w.d("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", Boolean.valueOf(z16));
            if (a.this.getInitConfig() != null) {
                a.this.tuningRtContentView("requestDeviceOrientation done", true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ViewOnLayoutChangeListenerC6094a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f123297b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f123298c;

        public d(View view, a aVar) {
            this.f123297b = view;
            this.f123298c = aVar;
        }

        @Override // com.tencent.luggage.wxa.c5.a.ViewOnLayoutChangeListenerC6094a
        public void a(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
            boolean z16;
            if (i29 == 10) {
                this.f123297b.removeOnLayoutChangeListener(this);
                return;
            }
            if (i3 == i16 && i3 == i18 && i3 == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 == i19 && i17 == i27 && i18 == i28 && i16 == i26 && !z16) {
                w.d("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
                return;
            }
            if (this.f123298c.getInitConfig() != null) {
                a.tuningRtContentView$default(this.f123298c, "onConfigurationChanged", false, 2, null);
            }
            this.f123297b.removeOnLayoutChangeListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f123300b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f123301c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f123302d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f123303e;

        public e(boolean z16, boolean z17, String str, boolean z18) {
            this.f123300b = z16;
            this.f123301c = z17;
            this.f123302d = str;
            this.f123303e = z18;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.tuningRtContentView(this.f123300b, this.f123301c, this.f123302d, this.f123303e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.tuningRtContentView$default(a.this, false, false, Method.POST, false, 8, null);
        }
    }

    public a(@NotNull com.tencent.luggage.wxa.ic.g rt5, @Nullable com.tencent.luggage.wxa.wj.e eVar, boolean z16) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f123291rt = rt5;
        this.activityOrientationHandler = eVar;
        this.dryRun = z16;
        this.orientation = "portrait";
        this.scale = 1.0f;
        boolean b16 = l.f126905a.b();
        this.isFoldDevice = b16;
        this.displayMetrics = new DisplayMetrics();
        this.isFold = b16 && !rt5.n0().isInMultiWindowMode();
        this.systemRatio = -1.0d;
        this.windowOrientation = b.PORTRAIT;
        Activity L = rt5.L();
        Intrinsics.checkNotNull(L);
        this.lastOrientation = L.getResources().getConfiguration().orientation;
        Activity L2 = rt5.L();
        Intrinsics.checkNotNull(L2);
        this.lastScreenWDp = L2.getResources().getConfiguration().screenWidthDp;
        Activity L3 = rt5.L();
        Intrinsics.checkNotNull(L3);
        this.lastScreenHDp = L3.getResources().getConfiguration().screenHeightDp;
        refreshDisplayInfo();
    }

    private final View getBackgroundView() {
        ViewParent viewParent;
        com.tencent.luggage.wxa.il.g K = this.f123291rt.K();
        if (K != null) {
            viewParent = K.getParent();
        } else {
            viewParent = null;
        }
        if (!(viewParent instanceof View)) {
            return null;
        }
        return (View) viewParent;
    }

    private final b parseOrientation(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                w.h("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", Integer.valueOf(i3));
                return b.PORTRAIT;
            }
            return b.LANDSCAPE;
        }
        return b.PORTRAIT;
    }

    private final void refreshDisplayInfo() {
        Point point = new Point();
        Activity L = this.f123291rt.L();
        Intrinsics.checkNotNull(L);
        Object systemService = L.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Activity L2 = this.f123291rt.L();
        Intrinsics.checkNotNull(L2);
        if (b0.c(L2) && l.f126905a.a()) {
            defaultDisplay.getRealSize(point);
            defaultDisplay.getRealMetrics(this.displayMetrics);
        } else {
            defaultDisplay.getSize(point);
            defaultDisplay.getMetrics(this.displayMetrics);
        }
        int i3 = point.x;
        this.widthPx = i3;
        int i16 = point.y;
        this.heightPx = i16;
        this.maxEdge = Math.max(i3, i16);
        this.minEdge = Math.min(this.widthPx, this.heightPx);
        w.d("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", Integer.valueOf(this.widthPx), Integer.valueOf(this.heightPx));
    }

    private final void resetWindowOrientation() {
        if (this.f123291rt.B0() && this.activityOrientationHandler != null) {
            if (!TextUtils.isEmpty(this._softOrientation)) {
                w.d("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", this._softOrientation);
                this.activityOrientationHandler.a(e.b.a(this._softOrientation), null);
            } else {
                e.b a16 = this.activityOrientationHandler.a();
                Intrinsics.checkNotNullExpressionValue(a16, "activityOrientationHandler.currentOrientation");
                w.d("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", a16);
                this.activityOrientationHandler.a(a16, null);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(12:3|(2:5|(2:7|(1:11))(2:44|(1:46)))(2:47|(1:49))|12|13|(2:17|(2:25|(2:32|(1:38)(2:36|37))(1:40))(1:23))|42|(1:19)|25|(1:27)|30|32|(2:34|38)(1:39))|50|12|13|(8:15|17|(0)|25|(0)|30|32|(0)(0))|42|(0)|25|(0)|30|32|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void set_softOrientation(String str) {
        com.tencent.luggage.wxa.wj.d dVar;
        int requestedOrientation;
        p Y;
        v pageView;
        Activity L = this.f123291rt.L();
        Intrinsics.checkNotNull(L);
        w.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", str);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3005871) {
                if (hashCode != 729267099) {
                    if (hashCode == 1430647483 && str.equals("landscape")) {
                        this.windowOrientation = b.LANDSCAPE;
                    }
                } else if (str.equals("portrait")) {
                    this.windowOrientation = b.PORTRAIT;
                }
            } else if (str.equals("auto")) {
                this.windowOrientation = parseOrientation(L.getResources().getConfiguration().orientation);
            }
            Y = this.f123291rt.Y();
            if (Y != null && (pageView = Y.getPageView()) != null) {
                dVar = pageView.h0();
                if (dVar == null && (dVar instanceof s0) && ((s0) dVar).f()) {
                    return;
                }
                this._softOrientation = str;
                tuningRtContentView("set softOrientation", true);
                if ((!shouldInLargeScreenCompatMode() || this.resizable) && this.activityOrientationHandler != null) {
                    w.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
                    requestedOrientation = L.getRequestedOrientation();
                    if (requestedOrientation == 14 && requestedOrientation != -1) {
                        this.activityOrientationHandler.a(e.b.UNSPECIFIED, new c());
                        return;
                    }
                    return;
                }
                return;
            }
            dVar = null;
            if (dVar == null) {
            }
            this._softOrientation = str;
            tuningRtContentView("set softOrientation", true);
            if (!shouldInLargeScreenCompatMode()) {
            }
            w.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
            requestedOrientation = L.getRequestedOrientation();
            if (requestedOrientation == 14) {
                return;
            } else {
                return;
            }
        }
        w.h("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", str);
        Y = this.f123291rt.Y();
        if (Y != null) {
            dVar = pageView.h0();
            if (dVar == null) {
            }
            this._softOrientation = str;
            tuningRtContentView("set softOrientation", true);
            if (!shouldInLargeScreenCompatMode()) {
            }
            w.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
            requestedOrientation = L.getRequestedOrientation();
            if (requestedOrientation == 14) {
            }
        }
        dVar = null;
        if (dVar == null) {
        }
        this._softOrientation = str;
        tuningRtContentView("set softOrientation", true);
        if (!shouldInLargeScreenCompatMode()) {
        }
        w.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
        requestedOrientation = L.getRequestedOrientation();
        if (requestedOrientation == 14) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tuningRtContentView(String str, boolean z16) {
        tuningRtContentView(true, false, str, z16);
    }

    public static /* synthetic */ void tuningRtContentView$default(a aVar, String str, boolean z16, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tuningRtContentView");
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.tuningRtContentView(str, z16);
    }

    @NotNull
    public com.tencent.luggage.wxa.wj.d createFullscreenHandler(@Nullable d.a aVar) {
        Activity L = this.f123291rt.L();
        if (L == null) {
            L = null;
        }
        com.tencent.luggage.wxa.wj.c n06 = this.f123291rt.n0();
        Intrinsics.checkNotNullExpressionValue(n06, "rt.windowAndroid");
        return new s0(n06, aVar, L);
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public boolean forceLightMode() {
        return false;
    }

    public int getBackgroundColor() {
        return R.color.ah6;
    }

    @NotNull
    public final DisplayMetrics getDisplayMetrics() {
        return this.displayMetrics;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    @Nullable
    public final com.tencent.luggage.wxa.j4.d getInitConfig() {
        return this.initConfig;
    }

    public final int getLastLandscapeVHeight() {
        return this.lastLandscapeVHeight;
    }

    public final int getLastLandscapeVWidth() {
        return this.lastLandscapeVWidth;
    }

    public final int getLastPortraitVHeight() {
        return this.lastPortraitVHeight;
    }

    public final int getLastPortraitVWidth() {
        return this.lastPortraitVWidth;
    }

    public final int getMaxEdge() {
        return this.maxEdge;
    }

    public final int getMinEdge() {
        return this.minEdge;
    }

    @Nullable
    public com.tencent.luggage.wxa.wj.e getOrientationHandler() {
        com.tencent.luggage.wxa.wj.c n06 = this.f123291rt.n0();
        Intrinsics.checkNotNullExpressionValue(n06, "rt.windowAndroid");
        return new com.tencent.luggage.wxa.yj.a(n06);
    }

    public final boolean getResizable() {
        return this.resizable;
    }

    @NotNull
    public final com.tencent.luggage.wxa.ic.g getRt() {
        return this.f123291rt;
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public float getScale() {
        return this.scale;
    }

    @Override // com.tencent.luggage.wxa.wj.f
    @androidx.annotation.Nullable
    public abstract /* synthetic */ c.C6887c getStatusBar();

    @NotNull
    public DisplayMetrics getVDisplayMetrics() {
        return getVDisplayMetrics(false);
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    @NotNull
    public final b getWindowOrientation() {
        return this.windowOrientation;
    }

    @Override // com.tencent.luggage.wxa.c5.f
    public void init(@NotNull com.tencent.luggage.wxa.j4.d initConfig) {
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        this.initConfig = initConfig;
        this.resizable = initConfig.X.I;
        tuningRtContentView$default(this, true, false, "init", false, 8, null);
    }

    public final boolean isFold() {
        return this.isFold;
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public boolean isLargeScreenWindow() {
        Activity L = this.f123291rt.L();
        Intrinsics.checkNotNull(L);
        if (b0.c(L) && !shouldInLargeScreenCompatMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.c5.f
    public void onAppConfigGot(@NotNull com.tencent.luggage.wxa.fd.b appConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        String str = "portrait";
        this.orientation = "portrait";
        String str2 = appConfig.b().f125694n;
        if (str2 == null) {
            String str3 = appConfig.a().f125641a;
            if (str3 != null) {
                if (str3.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    str = str3;
                }
            }
            this.orientation = str;
        } else {
            this.orientation = str2;
        }
        boolean z17 = appConfig.H;
        boolean z18 = this.resizable;
        if (z18 != z17) {
            this.resizable = z17;
            tuningRtContentView$default(this, "redundancy field check fail", false, 2, null);
            w.h("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", Boolean.valueOf(z18), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.luggage.wxa.c5.f
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.lastOrientation != newConfig.orientation && Intrinsics.areEqual(this._softOrientation, "auto") && shouldInLargeScreenCompatMode() && !this.resizable) {
            this.windowOrientation = parseOrientation(newConfig.orientation);
        }
        int i3 = this.lastOrientation;
        int i16 = newConfig.orientation;
        if (i3 != i16 || newConfig.screenHeightDp != this.lastScreenHDp || newConfig.screenWidthDp != this.lastScreenWDp) {
            if (!this.isFoldDevice && ((newConfig.screenHeightDp == this.lastScreenHDp && newConfig.screenWidthDp == this.lastScreenWDp) || i3 != i16)) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.isFold = z16;
            if (Build.VERSION.SDK_INT >= 24) {
                if (this.f123291rt.n0().isInMultiWindowMode() || this.isLastInMultiWindowMode) {
                    this.isFold = false;
                }
                this.isLastInMultiWindowMode = this.f123291rt.n0().isInMultiWindowMode();
            }
            refreshDisplayInfo();
            if (this.isFold && (newConfig.screenHeightDp != this.lastScreenHDp || newConfig.screenWidthDp != this.lastScreenWDp)) {
                resetWindowOrientation();
            }
            View backgroundView = getBackgroundView();
            if (backgroundView != null) {
                backgroundView.addOnLayoutChangeListener(new d(backgroundView, this));
            }
        }
        this.lastOrientation = newConfig.orientation;
        this.lastScreenHDp = newConfig.screenHeightDp;
        this.lastScreenWDp = newConfig.screenWidthDp;
    }

    public void onDecorViewLayout() {
        tuningRtContentView$default(this, "onDecorViewLayout", false, 2, null);
    }

    @Override // com.tencent.luggage.wxa.c5.f
    public void onInitConfigUpdated(@NotNull com.tencent.luggage.wxa.j4.d initConfig) {
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        this.initConfig = initConfig;
        this.resizable = initConfig.X.I;
        if (shouldInLargeScreenCompatMode()) {
            Activity L = this.f123291rt.L();
            Intrinsics.checkNotNull(L);
            Configuration configuration = L.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "rt.context!!.resources.configuration");
            onConfigurationChanged(configuration);
        }
        tuningRtContentView$default(this, true, true, "onInitConfigUpdated", false, 8, null);
    }

    public final void setInitConfig(@Nullable com.tencent.luggage.wxa.j4.d dVar) {
        this.initConfig = dVar;
    }

    public final void setLastLandscapeVHeight(int i3) {
        this.lastLandscapeVHeight = i3;
    }

    public final void setLastLandscapeVWidth(int i3) {
        this.lastLandscapeVWidth = i3;
    }

    public final void setLastPortraitVHeight(int i3) {
        this.lastPortraitVHeight = i3;
    }

    public final void setLastPortraitVWidth(int i3) {
        this.lastPortraitVWidth = i3;
    }

    public final void setMaxEdge(int i3) {
        this.maxEdge = i3;
    }

    public final void setMinEdge(int i3) {
        this.minEdge = i3;
    }

    public final void setResizable(boolean z16) {
        this.resizable = z16;
    }

    public void setSoftOrientation(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        set_softOrientation(name);
    }

    public final void setWindowOrientation(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.windowOrientation = bVar;
    }

    public boolean shouldInLargeScreenCompatMode() {
        Context c16 = z.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
        return b0.c(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tuningRtContentView(boolean z16, boolean z17, String str, boolean z18) {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            h.f146825d.a(new e(z16, z17, str, z18));
            return;
        }
        View backgroundView = getBackgroundView();
        if (!shouldInLargeScreenCompatMode() || backgroundView == null) {
            return;
        }
        DisplayMetrics vDisplayMetrics = getVDisplayMetrics(z18);
        w.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s %s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", str, this.f123291rt.getAppId(), this.windowOrientation, Integer.valueOf(vDisplayMetrics.widthPixels), Integer.valueOf(vDisplayMetrics.heightPixels));
        this.f123291rt.f(true);
        if ((!backgroundView.isLaidOut() && z16) || z17) {
            backgroundView.post(new f());
            return;
        }
        int measuredWidth = backgroundView.getMeasuredWidth();
        int measuredHeight = backgroundView.getMeasuredHeight();
        w.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s %s]: width [%d], height[%d]", str, this.f123291rt.getAppId(), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        float f16 = (measuredWidth * 1.0f) / vDisplayMetrics.widthPixels;
        float f17 = (measuredHeight * 1.0f) / vDisplayMetrics.heightPixels;
        float min = Math.min(f16, f17);
        w.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s %s]: scaleMin = [%f], scaleMax = [%f]", str, this.f123291rt.getAppId(), Float.valueOf(min), Float.valueOf(Math.max(f16, f17)));
        this.scale = min;
        com.tencent.luggage.wxa.wj.h hVar = new com.tencent.luggage.wxa.wj.h(vDisplayMetrics.widthPixels, vDisplayMetrics.heightPixels);
        ((FrameLayout.LayoutParams) hVar).gravity = 17;
        hVar.a(this.scale);
        if (this.dryRun) {
            return;
        }
        this.f123291rt.n0().setWindowLayoutParams(hVar, this.f123291rt);
        com.tencent.luggage.wxa.wj.c n06 = this.f123291rt.n0();
        Activity L = this.f123291rt.L();
        Intrinsics.checkNotNull(L);
        n06.setWindowBackgroundColor(ContextCompat.getColor(L, getBackgroundColor()), this.f123291rt);
        com.tencent.luggage.wxa.il.g K = this.f123291rt.K();
        Activity L2 = this.f123291rt.L();
        Intrinsics.checkNotNull(L2);
        K.setBackgroundColor(ContextCompat.getColor(L2, getBackgroundColor()));
    }

    public static /* synthetic */ void tuningRtContentView$default(a aVar, boolean z16, boolean z17, String str, boolean z18, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tuningRtContentView");
        }
        if ((i3 & 8) != 0) {
            z18 = false;
        }
        aVar.tuningRtContentView(z16, z17, str, z18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if ((r13.systemRatio == -1.0d) != false) goto L9;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DisplayMetrics getVDisplayMetrics(boolean z16) {
        int i3;
        int i16;
        View backgroundView = getBackgroundView();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setTo(this.displayMetrics);
        boolean z17 = false;
        if (this.isFold) {
        }
        this.systemRatio = (this.maxEdge * 1.0d) / (this.minEdge * 1.0d);
        int i17 = this.maxEdge;
        int i18 = this.minEdge;
        boolean isLaidOut = backgroundView != null ? backgroundView.isLaidOut() : false;
        if (isLaidOut) {
            Intrinsics.checkNotNull(backgroundView);
            i17 = RangesKt___RangesKt.coerceAtLeast(backgroundView.getMeasuredWidth(), backgroundView.getMeasuredHeight());
            i18 = RangesKt___RangesKt.coerceAtMost(backgroundView.getMeasuredWidth(), backgroundView.getMeasuredHeight());
            this.systemRatio = (i17 * 1.0d) / (i18 * 1.0d);
        }
        double d16 = this.systemRatio;
        if (d16 <= 1.3333333333333333d || d16 >= 4.444444444444445d) {
            d16 = 1.7777777777777777d;
        }
        displayMetrics.setTo(this.displayMetrics);
        b bVar = this.windowOrientation;
        b bVar2 = b.PORTRAIT;
        if (bVar != bVar2) {
            d16 = 1 / d16;
        }
        float f16 = (this.systemRatio < 1.3333333333333333d || this.isFold) ? 1.0f : 0.75f;
        w.d("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics(%s): contentRatio = [%f], systemRatio = [%f], isFold = [%b], ratio = [%f]", this.f123291rt.getAppId(), Double.valueOf(d16), Double.valueOf(this.systemRatio), Boolean.valueOf(this.isFold), Float.valueOf(f16));
        if (this.isFold) {
            if (this.windowOrientation == bVar2) {
                int i19 = this.lastPortraitVHeight;
                if (i19 != 0 && (i16 = this.lastPortraitVWidth) != 0) {
                    displayMetrics.heightPixels = i19;
                    displayMetrics.widthPixels = i16;
                    z17 = true;
                }
            } else {
                int i26 = this.lastLandscapeVHeight;
                if (i26 != 0 && (i3 = this.lastLandscapeVWidth) != 0) {
                    displayMetrics.heightPixels = i26;
                    displayMetrics.widthPixels = i3;
                    z17 = true;
                }
            }
        }
        if (!z17) {
            if (this.windowOrientation == bVar2) {
                int i27 = (int) (i17 * f16);
                displayMetrics.heightPixels = i27;
                displayMetrics.widthPixels = (int) (i27 / d16);
            } else {
                int i28 = (int) (i18 * f16);
                displayMetrics.heightPixels = i28;
                displayMetrics.widthPixels = (int) (i28 / d16);
            }
        }
        if (isLaidOut) {
            if (this.windowOrientation == bVar2) {
                this.lastPortraitVHeight = displayMetrics.heightPixels;
                this.lastPortraitVWidth = displayMetrics.widthPixels;
            } else {
                this.lastLandscapeVHeight = displayMetrics.heightPixels;
                this.lastLandscapeVWidth = displayMetrics.widthPixels;
            }
        }
        return displayMetrics;
    }

    public /* synthetic */ a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.wj.e eVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, eVar, (i3 & 4) != 0 ? false : z16);
    }
}
