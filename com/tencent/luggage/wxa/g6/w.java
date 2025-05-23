package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends Window {

    /* renamed from: a, reason: collision with root package name */
    public int f126567a;

    /* renamed from: b, reason: collision with root package name */
    public int f126568b;

    /* renamed from: c, reason: collision with root package name */
    public int f126569c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f126570d;

    /* renamed from: e, reason: collision with root package name */
    public WindowInsets f126571e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f126572f;

    /* renamed from: g, reason: collision with root package name */
    public final a f126573g;

    /* renamed from: h, reason: collision with root package name */
    public WindowInsetsController f126574h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f126573g = new a(context, this);
    }

    public WindowInsets a(WindowInsets windowInsets) {
        return null;
    }

    @Override // android.view.Window
    public void addContentView(View contentView, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f126573g.addView(contentView, params);
    }

    public final void b() {
        if (this.f126573g.getLayoutParams() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = getAttributes();
        ViewGroup.LayoutParams layoutParams = this.f126573g.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = attributes.gravity;
        this.f126573g.setLayoutParams(layoutParams2);
    }

    public Boolean c() {
        return this.f126572f;
    }

    public void d() {
        WindowInsets a16 = a(this.f126571e);
        if (a16 == null) {
            return;
        }
        this.f126573g.dispatchApplyWindowInsets(a16);
    }

    @Override // android.view.Window
    public View getCurrentFocus() {
        return this.f126573g.findFocus();
    }

    @Override // android.view.Window
    public View getDecorView() {
        return this.f126573g;
    }

    @Override // android.view.Window
    public WindowInsetsController getInsetsController() {
        if (this.f126574h == null) {
            this.f126574h = new b();
        }
        WindowInsetsController windowInsetsController = this.f126574h;
        if (windowInsetsController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("insetsController");
            return null;
        }
        return windowInsetsController;
    }

    @Override // android.view.Window
    public LayoutInflater getLayoutInflater() {
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        return from;
    }

    @Override // android.view.Window
    public int getNavigationBarColor() {
        return this.f126568b;
    }

    @Override // android.view.Window
    public int getNavigationBarDividerColor() {
        return this.f126569c;
    }

    @Override // android.view.Window
    public int getStatusBarColor() {
        return this.f126567a;
    }

    @Override // android.view.Window
    public int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public WindowManager getWindowManager() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) systemService;
    }

    @Override // android.view.Window
    public boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Window
    public View peekDecorView() {
        return this.f126573g;
    }

    @Override // android.view.Window
    public boolean performContextMenuIdentifierAction(int i3, int i16) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelIdentifierAction(int i3, int i16, int i17) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelShortcut(int i3, int i16, KeyEvent keyEvent, int i17) {
        return false;
    }

    @Override // android.view.Window
    public Bundle saveHierarchyState() {
        return new Bundle();
    }

    @Override // android.view.Window
    public void setAttributes(WindowManager.LayoutParams lp5) {
        Intrinsics.checkNotNullParameter(lp5, "lp");
        super.setAttributes(lp5);
        b();
    }

    @Override // android.view.Window
    public void setBackgroundDrawable(Drawable drawable) {
        this.f126573g.setBackgroundDrawable(drawable);
    }

    @Override // android.view.Window
    public void setColorMode(int i3) {
        super.setColorMode(i3);
        b();
    }

    @Override // android.view.Window
    public void setContentView(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layoutResID, null)");
        setContentView(inflate);
    }

    @Override // android.view.Window
    public void setDimAmount(float f16) {
        super.setDimAmount(f16);
        b();
    }

    @Override // android.view.Window
    public void setFlags(int i3, int i16) {
        super.setFlags(i3, i16);
        b();
    }

    @Override // android.view.Window
    public void setFormat(int i3) {
        super.setFormat(i3);
        b();
    }

    @Override // android.view.Window
    public void setGravity(int i3) {
        super.setGravity(i3);
        b();
    }

    @Override // android.view.Window
    public void setLayout(int i3, int i16) {
        super.setLayout(i3, i16);
        b();
    }

    @Override // android.view.Window
    public void setNavigationBarColor(int i3) {
        this.f126568b = i3;
        this.f126570d = true;
    }

    @Override // android.view.Window
    public void setNavigationBarDividerColor(int i3) {
        this.f126569c = i3;
    }

    @Override // android.view.Window
    public void setPreferMinimalPostProcessing(boolean z16) {
        super.setPreferMinimalPostProcessing(z16);
        b();
    }

    @Override // android.view.Window
    public void setSoftInputMode(int i3) {
        super.setSoftInputMode(i3);
        b();
    }

    @Override // android.view.Window
    public void setStatusBarColor(int i3) {
        this.f126567a = i3;
    }

    @Override // android.view.Window
    public void setType(int i3) {
        super.setType(i3);
        b();
    }

    @Override // android.view.Window
    public void setWindowAnimations(int i3) {
        super.setWindowAnimations(i3);
        b();
    }

    @Override // android.view.Window
    public boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f126573g.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f126573g.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window
    public boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f126573g.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return this.f126573g.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window
    public boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f126573g.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window
    public void takeInputQueue(InputQueue.Callback callback) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Window
    public void takeSurface(SurfaceHolder.Callback2 callback2) {
        throw new UnsupportedOperationException();
    }

    public void a() {
    }

    @Override // android.view.Window
    public void setContentView(View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.f126573g.removeAllViews();
        this.f126573g.addView(contentView);
    }

    public void a(Boolean bool) {
        this.f126572f = bool;
    }

    @Override // android.view.Window
    public void setContentView(View contentView, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f126573g.removeAllViews();
        this.f126573g.addView(contentView, params);
    }

    public int a(int i3) {
        int i16 = i3 & (-8193);
        return ((c() == null && (getContext().getResources().getConfiguration().uiMode & 48) == 16) || Intrinsics.areEqual(c(), Boolean.TRUE)) ? i16 | 8192 : i16;
    }

    public void b(int i3) {
        a(Boolean.valueOf((i3 & 8192) != 0));
    }

    @Override // android.view.Window
    public void closeAllPanels() {
    }

    @Override // android.view.Window
    public void onActive() {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f126575a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, w wVar) {
            super(context);
            this.f126575a = wVar;
            setClickable(true);
            setFocusable(true);
        }

        @Override // android.view.ViewGroup, android.view.View
        public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            WindowInsets a16 = this.f126575a.a(insets);
            if (a16 != null) {
                insets = a16;
            }
            WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(insets);
            Intrinsics.checkNotNullExpressionValue(dispatchApplyWindowInsets, "super.dispatchApplyWindowInsets(newInsets)");
            return dispatchApplyWindowInsets;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchSystemUiVisibilityChanged(int i3) {
            super.dispatchSystemUiVisibilityChanged(i3);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchWindowSystemUiVisiblityChanged(int i3) {
            super.dispatchWindowSystemUiVisiblityChanged(i3);
        }

        @Override // android.view.View
        public int getSystemUiVisibility() {
            return this.f126575a.a(super.getSystemUiVisibility());
        }

        @Override // android.view.View
        public WindowInsets onApplyWindowInsets(WindowInsets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            this.f126575a.f126571e = insets;
            WindowInsets a16 = this.f126575a.a(insets);
            if (a16 != null) {
                insets = a16;
            }
            WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(insets);
            Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "super.onApplyWindowInsets(newInsets)");
            return onApplyWindowInsets;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestFitSystemWindows() {
            super.requestFitSystemWindows();
            this.f126575a.d();
        }

        @Override // android.view.View
        public void setSystemUiVisibility(int i3) {
            int systemUiVisibility = getSystemUiVisibility();
            int i16 = i3 & (-5) & (-3) & (-8193) & (-17) & (-1025) & (-257);
            this.f126575a.b(i3);
            super.setSystemUiVisibility(i16);
            if (systemUiVisibility != i16) {
                this.f126575a.a();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void recomputeViewAttributes(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements WindowInsetsController {
        @Override // android.view.WindowInsetsController
        public void addOnControllableInsetsChangedListener(WindowInsetsController.OnControllableInsetsChangedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // android.view.WindowInsetsController
        public void controlWindowInsetsAnimation(int i3, long j3, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // android.view.WindowInsetsController
        public int getSystemBarsAppearance() {
            return 0;
        }

        @Override // android.view.WindowInsetsController
        public int getSystemBarsBehavior() {
            return 0;
        }

        @Override // android.view.WindowInsetsController
        public void removeOnControllableInsetsChangedListener(WindowInsetsController.OnControllableInsetsChangedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // android.view.WindowInsetsController
        public void hide(int i3) {
        }

        @Override // android.view.WindowInsetsController
        public void setSystemBarsBehavior(int i3) {
        }

        @Override // android.view.WindowInsetsController
        public void show(int i3) {
        }

        @Override // android.view.WindowInsetsController
        public void setSystemBarsAppearance(int i3, int i16) {
        }
    }

    @Override // android.view.Window
    public void closePanel(int i3) {
    }

    @Override // android.view.Window
    public void invalidatePanelMenu(int i3) {
    }

    @Override // android.view.Window
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.Window
    public void restoreHierarchyState(Bundle bundle) {
    }

    @Override // android.view.Window
    public void setDecorCaptionShade(int i3) {
    }

    @Override // android.view.Window
    public void setResizingCaptionDrawable(Drawable drawable) {
    }

    @Override // android.view.Window
    public void setTitle(CharSequence charSequence) {
    }

    @Override // android.view.Window
    public void setTitleColor(int i3) {
    }

    @Override // android.view.Window
    public void setVolumeControlStream(int i3) {
    }

    @Override // android.view.Window
    public void takeKeyEvents(boolean z16) {
    }

    @Override // android.view.Window
    public void openPanel(int i3, KeyEvent keyEvent) {
    }

    @Override // android.view.Window
    public void setChildDrawable(int i3, Drawable drawable) {
    }

    @Override // android.view.Window
    public void setChildInt(int i3, int i16) {
    }

    @Override // android.view.Window
    public void setFeatureDrawable(int i3, Drawable drawable) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableAlpha(int i3, int i16) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableResource(int i3, int i16) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableUri(int i3, Uri uri) {
    }

    @Override // android.view.Window
    public void setFeatureInt(int i3, int i16) {
    }

    @Override // android.view.Window
    public void togglePanel(int i3, KeyEvent keyEvent) {
    }
}
