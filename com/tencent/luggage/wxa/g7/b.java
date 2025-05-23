package com.tencent.luggage.wxa.g7;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.c5.a implements com.tencent.luggage.wxa.wj.c {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "Luggage.WXA.AppBrandCenterInsideWindowLayoutManager";

    @NotNull
    private final com.tencent.luggage.wxa.wj.c base;

    @Nullable
    private Boolean mayDisableInHuaWeiDevices;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull g rt5, @NotNull com.tencent.luggage.wxa.wj.e orientationHandler, @NotNull com.tencent.luggage.wxa.wj.c base) {
        super(rt5, orientationHandler, false, 4, null);
        Intrinsics.checkNotNullParameter(rt5, "rt");
        Intrinsics.checkNotNullParameter(orientationHandler, "orientationHandler");
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
    }

    private final boolean mayDisableInHuaWeiDevices() {
        boolean z16;
        if (this.mayDisableInHuaWeiDevices == null) {
            if (com.tencent.luggage.wxa.p003do.c.a() && com.tencent.luggage.wxa.p003do.b.b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mayDisableInHuaWeiDevices = Boolean.valueOf(z16);
        }
        Boolean bool = this.mayDisableInHuaWeiDevices;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    private final boolean shouldInLargeScreenCompatModeInner() {
        boolean z16;
        if (!getResizable() && getInitConfig() != null) {
            com.tencent.luggage.wxa.j4.d initConfig = getInitConfig();
            if (initConfig != null && initConfig.l()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !mayDisableInHuaWeiDevices() && l.f126905a.b()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    @NotNull
    public Context cloneContext() {
        Context cloneContext = this.base.cloneContext();
        Intrinsics.checkNotNullExpressionValue(cloneContext, "base.cloneContext()");
        return cloneContext;
    }

    @Override // java.lang.Comparable
    public int compareTo(@Nullable com.tencent.luggage.wxa.wj.c cVar) {
        return -1;
    }

    @NotNull
    public final com.tencent.luggage.wxa.wj.c getBase() {
        return this.base;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    @NotNull
    public Context getContext() {
        Context context = this.base.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "base.context");
        return context;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public /* bridge */ /* synthetic */ void getLocationInWindow(View view, int[] iArr) {
        o41.a.a(this, view, iArr);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    @Nullable
    public c.b getNavigationBar() {
        return this.base.getNavigationBar();
    }

    @Override // com.tencent.luggage.wxa.wj.c
    @Nullable
    public Rect getSafeAreaInsets() {
        return this.base.getSafeAreaInsets();
    }

    @Override // com.tencent.luggage.wxa.c5.a, com.tencent.luggage.wxa.wj.f
    @Nullable
    public c.C6887c getStatusBar() {
        return this.base.getStatusBar();
    }

    @Override // com.tencent.luggage.wxa.wj.c
    @NotNull
    public ViewGroup.LayoutParams getWindowLayoutParams(@Nullable g gVar) {
        ViewGroup.LayoutParams windowLayoutParams = this.base.getWindowLayoutParams(gVar);
        Intrinsics.checkNotNullExpressionValue(windowLayoutParams, "base.getWindowLayoutParams(rt)");
        return windowLayoutParams;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public boolean isInMultiWindowMode() {
        return this.base.isInMultiWindowMode();
    }

    @Override // com.tencent.luggage.wxa.c5.a, com.tencent.luggage.wxa.wj.f
    public boolean isLargeScreenWindow() {
        return this.base.isLargeScreenWindow();
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public boolean runInStandaloneTask() {
        return this.base.runInStandaloneTask();
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowBackgroundColor(int i3, @NotNull g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.base.setWindowBackgroundColor(i3, runtime);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowDescription(@Nullable c.a aVar) {
        this.base.setWindowDescription(aVar);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowLayoutParams(@Nullable h hVar, @Nullable g gVar) {
        this.base.setWindowLayoutParams(hVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.c5.a, com.tencent.luggage.wxa.wj.c
    public boolean shouldInLargeScreenCompatMode() {
        boolean shouldInLargeScreenCompatModeInner = shouldInLargeScreenCompatModeInner();
        w.d(TAG, "shouldInLargeScreenCompatMode: " + shouldInLargeScreenCompatModeInner);
        return shouldInLargeScreenCompatModeInner;
    }
}
