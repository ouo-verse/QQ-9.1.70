package com.tencent.qqnt.aio.widget;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.ProxyDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.devices.api.IDevicesApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.util.EstablishSetting;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes23.dex */
public class BubblePopupWindow implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final int[] A0;
    private boolean C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private View.OnTouchListener Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f352375a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f352376b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f352377c0;

    /* renamed from: d, reason: collision with root package name */
    private Context f352378d;

    /* renamed from: d0, reason: collision with root package name */
    private int[] f352379d0;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager f352380e;

    /* renamed from: e0, reason: collision with root package name */
    private int[] f352381e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f352382f;

    /* renamed from: f0, reason: collision with root package name */
    private Rect f352383f0;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f352384g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f352385h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f352386h0;

    /* renamed from: i, reason: collision with root package name */
    private View f352387i;

    /* renamed from: i0, reason: collision with root package name */
    private int f352388i0;

    /* renamed from: j0, reason: collision with root package name */
    private c f352389j0;

    /* renamed from: k0, reason: collision with root package name */
    private List<c> f352390k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f352391l0;

    /* renamed from: m, reason: collision with root package name */
    private View f352392m;

    /* renamed from: m0, reason: collision with root package name */
    private b f352393m0;

    /* renamed from: n0, reason: collision with root package name */
    private b f352394n0;

    /* renamed from: o0, reason: collision with root package name */
    private b f352395o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f352396p0;

    /* renamed from: q0, reason: collision with root package name */
    private WeakReference<View> f352397q0;

    /* renamed from: r0, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f352398r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f352399s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f352400t0;

    /* renamed from: u0, reason: collision with root package name */
    private ImageView f352401u0;

    /* renamed from: v0, reason: collision with root package name */
    private ImageView f352402v0;

    /* renamed from: w0, reason: collision with root package name */
    private FrameLayout f352403w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f352404x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f352405y0;

    /* renamed from: z0, reason: collision with root package name */
    private f f352406z0;

    /* loaded from: classes23.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubblePopupWindow.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view;
            WindowManager.LayoutParams layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (BubblePopupWindow.this.f352397q0 != null) {
                view = (View) BubblePopupWindow.this.f352397q0.get();
            } else {
                view = null;
            }
            if (view == null || BubblePopupWindow.this.f352392m == null || (layoutParams = (WindowManager.LayoutParams) BubblePopupWindow.this.f352392m.getLayoutParams()) == null) {
                return;
            }
            BubblePopupWindow bubblePopupWindow = BubblePopupWindow.this;
            bubblePopupWindow.y(view, layoutParams, bubblePopupWindow.f352399s0, BubblePopupWindow.this.f352400t0);
            BubblePopupWindow.this.U(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes23.dex */
    public static class b extends ProxyDrawable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f352408d;

        /* renamed from: e, reason: collision with root package name */
        int f352409e;

        public b(Drawable drawable) {
            super(drawable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
                return;
            }
            Rect bounds = getBounds();
            if (this.f352409e > this.f352408d) {
                int save = canvas.save();
                canvas.clipRect(this.f352408d, 0, this.f352409e, bounds.height());
                this.mCurrDrawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }

        public void setClipRange(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f352408d = i3;
            this.f352409e = i16;
            invalidateSelf();
        }
    }

    /* loaded from: classes23.dex */
    public interface c {
        void onDismiss();
    }

    /* loaded from: classes23.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class e extends FrameLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        View f352410d;

        public e(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubblePopupWindow.this, (Object) context);
            } else {
                this.f352410d = null;
            }
        }

        private View a(View view) {
            if (view.isPressed()) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View a16 = a(viewGroup.getChildAt(i3));
                    if (a16 != null) {
                        return a16;
                    }
                }
                return null;
            }
            return null;
        }

        private void b(View view, View view2, Rect rect) {
            if (view == view2) {
                return;
            }
            rect.top += view.getTop();
            rect.bottom += view.getTop();
            rect.left += view.getLeft();
            rect.right += view.getLeft();
            b((View) view.getParent(), view2, rect);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) keyEvent)).booleanValue();
            }
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    BubblePopupWindow.i(BubblePopupWindow.this);
                    BubblePopupWindow.this.w();
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            boolean z16;
            boolean z17;
            int i3;
            boolean z18;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (BubblePopupWindow.this.Q != null && BubblePopupWindow.this.Q.onTouch(this, motionEvent)) {
                return true;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (BubblePopupWindow.this.f352392m == null) {
                return dispatchTouchEvent;
            }
            View a16 = a(BubblePopupWindow.this.f352387i);
            if (this.f352410d == null && a16 == null) {
                z16 = false;
            } else {
                this.f352410d = a16;
                if (a16 != null) {
                    a16.scrollTo(0, 0);
                    this.f352410d.getDrawingRect(BubblePopupWindow.this.f352383f0);
                    b(this.f352410d, BubblePopupWindow.this.f352387i, BubblePopupWindow.this.f352383f0);
                    if (BubblePopupWindow.this.f352383f0.left == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (BubblePopupWindow.this.f352383f0.right == BubblePopupWindow.this.f352387i.getWidth()) {
                        i3 = BubblePopupWindow.this.f352392m.getWidth();
                        z18 = true;
                    } else {
                        i3 = 0;
                        z18 = false;
                    }
                    if (z17 && z18) {
                        i16 = 0;
                    } else {
                        this.f352410d.getDrawingRect(BubblePopupWindow.this.f352383f0);
                        b(this.f352410d, BubblePopupWindow.this.f352403w0, BubblePopupWindow.this.f352383f0);
                        if (!z17) {
                            i16 = BubblePopupWindow.this.f352383f0.left;
                        } else {
                            i16 = 0;
                        }
                        if (!z18) {
                            i3 = BubblePopupWindow.this.f352383f0.right;
                        }
                    }
                    BubblePopupWindow.this.f352393m0.setClipRange(i16, i3);
                    BubblePopupWindow.this.f352394n0.setClipRange(i16 - BubblePopupWindow.this.f352402v0.getLeft(), i3 - BubblePopupWindow.this.f352402v0.getLeft());
                    BubblePopupWindow.this.f352395o0.setClipRange(i16 - BubblePopupWindow.this.f352401u0.getLeft(), i3 - BubblePopupWindow.this.f352401u0.getLeft());
                    z16 = false;
                } else {
                    BubblePopupWindow.this.f352393m0.setClipRange(0, 0);
                    BubblePopupWindow.this.f352394n0.setClipRange(0, 0);
                    BubblePopupWindow.this.f352395o0.setClipRange(0, 0);
                    z16 = true;
                }
                BubblePopupWindow.this.f352403w0.invalidate();
            }
            if (!z16 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                BubblePopupWindow.this.f352393m0.setClipRange(0, 0);
                BubblePopupWindow.this.f352394n0.setClipRange(0, 0);
                BubblePopupWindow.this.f352395o0.setClipRange(0, 0);
                BubblePopupWindow.this.f352403w0.invalidate();
            }
            return dispatchTouchEvent;
        }

        @Override // android.view.View
        @TargetApi(8)
        protected void onConfigurationChanged(Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            } else {
                super.onConfigurationChanged(configuration);
                BubblePopupWindow.this.w();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            if (BubblePopupWindow.this.f352386h0) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
                View.mergeDrawableStates(onCreateDrawableState, BubblePopupWindow.A0);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i3);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
            }
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x16 < 0 || x16 >= getWidth() || y16 < 0 || y16 >= getHeight())) {
                BubblePopupWindow.this.w();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                BubblePopupWindow.this.w();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else if (BubblePopupWindow.this.f352387i != null) {
                BubblePopupWindow.this.f352387i.sendAccessibilityEvent(i3);
            } else {
                super.sendAccessibilityEvent(i3);
            }
        }
    }

    /* loaded from: classes23.dex */
    public interface f {
        void onMenuNoIconEmptyClick();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 70)) {
            redirector.redirect((short) 70);
        } else {
            A0 = new int[]{R.attr.state_above_anchor};
        }
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    private void B(WindowManager.LayoutParams layoutParams, View view, View view2, boolean z16, int i3, int i16, Rect rect, Integer num, int i17, int i18) {
        boolean z17;
        boolean z18;
        int height;
        if (((com.tencent.qqnt.aio.menu.ui.a) this.f352387i).b() && view.getResources().getConfiguration().orientation == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (z16 && iArr[1] - i16 < rect.top) {
            layoutParams.gravity = 51;
            z18 = false;
        } else {
            z18 = z16;
        }
        if (num != null && !z18 && iArr[1] + view.getHeight() + i16 > num.intValue()) {
            QLog.d("BubblePopupWindow", 2, "[menu] layoutMenuContainerX handle long view! Bottom: " + (iArr[1] + view.getHeight() + i16) + " containerBottom: " + num);
            layoutParams.y = num.intValue() - i16;
        } else {
            if (z18) {
                height = view2.getHeight() - iArr[1];
            } else {
                height = iArr[1] + view.getHeight();
            }
            layoutParams.y = height;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "[menu] layoutMenuContainerY ViewY: ", Integer.valueOf(iArr[1]), " ViewB: ", Integer.valueOf(iArr[1] + view.getBottom()), " ViewT: ", Integer.valueOf(view.getTop()), " ViewH: ", Integer.valueOf(view.getHeight()), " ContainerBottom: ", num, " displayFrame: ", rect, " screenH: ", Integer.valueOf(ViewUtils.getScreenHeight()), " screenW: ", Integer.valueOf(ViewUtils.getScreenWidth()), " onTop: ", Boolean.valueOf(z18), " popupH: ", Integer.valueOf(i16), " ParamY: ", Integer.valueOf(layoutParams.y), " ViewH: ", Integer.valueOf(view.getHeight()), " RootH: ", Integer.valueOf(view2.getHeight()));
        }
        int width = (view.getWidth() / 2) + (iArr[0] - i17);
        this.Z = width;
        C(layoutParams, width, z17, z18, i3, i17, i18);
    }

    private void C(WindowManager.LayoutParams layoutParams, int i3, boolean z16, boolean z17, int i16, int i17, int i18) {
        int dpToPx;
        this.f352375a0 = i17;
        this.f352376b0 = i18;
        if (!EstablishSetting.isAllowLandscape(MobileQQ.sMobileQQ) && !EstablishSetting.isSplitViewMode(MobileQQ.sMobileQQ)) {
            if (z16) {
                dpToPx = Math.min((i18 - i16) / 2, ViewUtils.dpToPx(9.0f));
            } else {
                dpToPx = ViewUtils.dpToPx(9.0f);
            }
        } else {
            dpToPx = ViewUtils.dpToPx(9.0f);
        }
        int i19 = i3 + i17;
        int i26 = i19 - (i16 / 2);
        layoutParams.x = i26;
        int max = Math.max(dpToPx + i17, i26);
        layoutParams.x = max;
        layoutParams.x = Math.min(max, ((i18 - dpToPx) - i16) + i17);
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "[menu] layoutMenuContainerX ParamX: " + layoutParams.x + " centerX: " + i3 + " isMenusLineFull: " + z16 + " popupWidth: " + i16 + " displayWidth: " + i18);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[menu] margin: ");
            sb5.append(dpToPx);
            sb5.append(" offsetWidth: ");
            sb5.append(i17);
            QLog.d("BubblePopupWindow", 2, sb5.toString());
        }
        V(z17, i19 - layoutParams.x);
    }

    private void D(WindowManager.LayoutParams layoutParams, boolean z16) {
        E(layoutParams, z16, true, false);
    }

    private void E(WindowManager.LayoutParams layoutParams, boolean z16, boolean z17, boolean z18) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if (this.f352387i != null && this.f352378d != null && this.f352380e != null) {
            e eVar = new e(this.f352378d);
            FrameLayout frameLayout = new FrameLayout(this.f352378d);
            if (z16 && !z18) {
                frameLayout.setOnClickListener(this);
            }
            int i36 = -2;
            if (this.f352387i instanceof com.tencent.qqnt.aio.menu.ui.a) {
                this.f352403w0 = new FrameLayout(this.f352378d);
                this.f352393m0 = new b(this.f352378d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.caz));
                this.f352403w0.addView(this.f352387i, new FrameLayout.LayoutParams(-2, -2, 17));
                frameLayout.addView(this.f352403w0, new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
                i36 = ViewUtils.dpToPx(10.0f);
                i19 = ViewUtils.dpToPx(8.0f);
                if (this.f352404x0) {
                    layoutParams2.setMargins(0, ViewUtils.dpToPx(8.2f), 0, ViewUtils.dpToPx(8.2f));
                }
                eVar.addView(frameLayout, layoutParams2);
            } else {
                if (z16 && !z18) {
                    i3 = Math.round(TypedValue.applyDimension(1, 5.0f, this.f352378d.getResources().getDisplayMetrics()));
                    i16 = Math.round(TypedValue.applyDimension(1, 5.0f, this.f352378d.getResources().getDisplayMetrics()));
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                if (this.f352404x0) {
                    i17 = Math.round(TypedValue.applyDimension(1, 8.0f, this.f352378d.getResources().getDisplayMetrics()));
                    i18 = Math.round(TypedValue.applyDimension(1, 8.0f, this.f352378d.getResources().getDisplayMetrics()));
                } else {
                    i17 = 0;
                    i18 = 0;
                }
                frameLayout.setPadding(i3, i17, i16, i18);
                eVar.addView(frameLayout, -1, -1);
                FrameLayout frameLayout2 = new FrameLayout(this.f352378d);
                this.f352403w0 = frameLayout2;
                frameLayout.addView(frameLayout2, -1, -1);
                Drawable drawable = this.f352378d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cay);
                this.f352393m0 = new b(this.f352378d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.caz));
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, this.f352393m0});
                if (z17) {
                    this.f352403w0.setBackgroundDrawable(layerDrawable);
                }
                this.f352403w0.addView(this.f352387i, new FrameLayout.LayoutParams(-1, -1, 17));
                i19 = -2;
            }
            this.f352402v0 = new ImageView(this.f352378d);
            ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i36, i19, 51);
            QQTheme.isNowThemeIsNight();
            KeyEvent.Callback callback = this.f352387i;
            float f16 = 1.0f;
            if (callback instanceof com.tencent.qqnt.aio.menu.ui.a) {
                if (((com.tencent.qqnt.aio.menu.ui.a) callback).c()) {
                    f16 = 0.85f;
                }
                i26 = com.tencent.mobileqq.R.drawable.mot;
                i27 = com.tencent.mobileqq.R.drawable.mot;
            } else {
                i26 = com.tencent.mobileqq.R.drawable.cax;
                i27 = com.tencent.mobileqq.R.drawable.caw;
            }
            this.f352394n0 = new b(this.f352378d.getResources().getDrawable(i26));
            this.f352402v0.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.f352378d.getResources().getDrawable(i27), this.f352394n0}));
            this.f352402v0.setAlpha(f16);
            eVar.addView(this.f352402v0, layoutParams3);
            this.f352401u0 = new ImageView(this.f352378d);
            ViewGroup.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i36, i19, 83);
            if (this.f352387i instanceof com.tencent.qqnt.aio.menu.ui.a) {
                i28 = com.tencent.mobileqq.R.drawable.moq;
                i29 = com.tencent.mobileqq.R.drawable.moq;
            } else {
                i28 = com.tencent.mobileqq.R.drawable.cav;
                i29 = com.tencent.mobileqq.R.drawable.cau;
            }
            this.f352395o0 = new b(this.f352378d.getResources().getDrawable(i28));
            this.f352401u0.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.f352378d.getResources().getDrawable(i29), this.f352395o0}));
            this.f352401u0.setAlpha(f16);
            eVar.addView(this.f352401u0, layoutParams4);
            this.f352392m = eVar;
            this.X = layoutParams.width;
            this.Y = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    private void T() {
        View view;
        WeakReference<View> weakReference = this.f352397q0;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.f352398r0);
        }
        this.f352397q0 = null;
    }

    private void V(boolean z16, int i3) {
        ImageView imageView;
        ImageView imageView2;
        if (!this.f352404x0) {
            this.f352402v0.setVisibility(8);
            this.f352401u0.setVisibility(8);
            return;
        }
        this.f352386h0 = z16;
        if (!z16) {
            imageView = this.f352402v0;
        } else {
            imageView = this.f352401u0;
        }
        if (!z16) {
            imageView2 = this.f352401u0;
        } else {
            imageView2 = this.f352402v0;
        }
        int measuredWidth = imageView.getMeasuredWidth();
        imageView.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = i3 - (measuredWidth / 2);
        if (this.f352386h0) {
            marginLayoutParams.bottomMargin = 1;
        } else {
            marginLayoutParams.topMargin = 1;
        }
        imageView2.setVisibility(4);
    }

    static /* bridge */ /* synthetic */ d i(BubblePopupWindow bubblePopupWindow) {
        bubblePopupWindow.getClass();
        return null;
    }

    private void s(WindowManager.LayoutParams layoutParams, int i3, int i16, View view, int i17, int i18) {
        View rootView;
        view.getRootView();
        layoutParams.x = i3;
        if (QLog.isDevelopLevel()) {
            QLog.i("BubblePopupWindow", 4, "[calcLocation]: p.x= " + layoutParams.x + " x= " + i3);
        }
        layoutParams.y = i16;
        layoutParams.gravity = 51;
        int i19 = this.X;
        int i26 = this.Y;
        if (i19 == -2 || i26 == -2) {
            this.f352392m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.X == -2) {
                i19 = this.f352392m.getMeasuredWidth();
            }
            if (this.Y == -2) {
                this.f352392m.getMeasuredHeight();
            }
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (view.getContext() instanceof Activity) {
            rootView = ((Activity) view.getContext()).getWindow().getDecorView();
        } else {
            rootView = view.getRootView();
        }
        int[] iArr = new int[2];
        rootView.getLocationOnScreen(iArr);
        rect.offset(-iArr[0], -iArr[1]);
        if (this.K) {
            int i27 = rect.right;
            int i28 = i27 - rect.left;
            int i29 = layoutParams.x;
            int i36 = i19 + i29;
            if (i36 > i27) {
                layoutParams.x = i29 - (i36 - i27);
                if (QLog.isDevelopLevel()) {
                    QLog.i("BubblePopupWindow", 4, "[calcLocation]: p.x= " + layoutParams.x + " right= " + i36 + " displayFrameWidth= " + i28);
                }
            }
            int i37 = layoutParams.x;
            int i38 = rect.left;
            if (i37 < i38) {
                layoutParams.x = i38;
                layoutParams.width = Math.min(layoutParams.width, i28);
                if (QLog.isDevelopLevel()) {
                    QLog.i("BubblePopupWindow", 4, "[calcLocation]: p.x= " + layoutParams.x + "displayFrame.left= " + rect.left);
                }
            }
            layoutParams.y = Math.max(layoutParams.y + this.f352377c0, rect.top);
            layoutParams.gravity |= 268435456;
        }
        V(false, 0);
    }

    private int t() {
        int i3 = this.f352396p0;
        if (i3 != -1) {
            return i3;
        }
        if (!this.f352385h) {
            return 0;
        }
        if (this.f352386h0) {
            return com.tencent.mobileqq.R.style.a4o;
        }
        return com.tencent.mobileqq.R.style.a4n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x001f, code lost:
    
        r4 = r4 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x001d, code lost:
    
        if (r3.D == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r3.D == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int u(int i3) {
        int i16 = i3 & (-8815129);
        if (this.f352391l0) {
            i16 |= 32768;
        }
        if (!this.C) {
            i16 |= 8;
        }
        if (!this.F) {
            i16 |= 16;
        }
        if (this.G) {
            i16 |= 262144;
        }
        if (!this.H) {
            i16 |= 512;
        }
        if (A()) {
            i16 |= 8388608;
        }
        if (this.J) {
            i16 |= 256;
        }
        if (this.M) {
            i16 |= 65536;
        }
        if (this.P) {
            return i16 | 32;
        }
        return i16;
    }

    private WindowManager.LayoutParams v(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i3 = this.S;
        this.T = i3;
        layoutParams.width = i3;
        int i16 = this.V;
        this.W = i16;
        layoutParams.height = i16;
        Drawable drawable = this.f352384g0;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = u(layoutParams.flags);
        layoutParams.type = this.f352388i0;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.E;
        layoutParams.setTitle("PopupWindow");
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(WindowManager.LayoutParams layoutParams, int i3, int i16, View view, int i17, int i18) {
        boolean z16;
        boolean z17;
        int i19;
        int measuredHeight;
        boolean z18;
        KeyEvent.Callback callback;
        ?? r142;
        FreesiaWrapperImpl.Companion companion;
        boolean isInMultiWindowMode;
        int i26;
        View rootView = view.getRootView();
        layoutParams.x = i3;
        if (QLog.isDevelopLevel()) {
            QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + " x= " + i3);
        }
        layoutParams.y = i16;
        if (this.N) {
            layoutParams.gravity = 51;
            z16 = false;
        } else {
            layoutParams.gravity = 83;
            z16 = true;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i27 = this.X;
        int i28 = this.Y;
        if (i27 != -2 && i28 != -2) {
            z17 = z16;
        } else {
            z17 = z16;
            this.f352392m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.X == -2) {
                i27 = this.f352392m.getMeasuredWidth();
            }
            if (this.Y == -2) {
                i19 = i27;
                measuredHeight = this.f352392m.getMeasuredHeight();
                if (i19 > 0) {
                    layoutParams.x = i3 - (i19 / 2);
                    if (QLog.isDevelopLevel()) {
                        QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + " x= " + i3 + " popupWidth= " + i19);
                    }
                }
                int i29 = rect.top;
                if (this.f352377c0 > 0) {
                    i29 = 0;
                }
                if (this.N && (((i26 = i16 - measuredHeight) < i29 || (i3 + i19) - rootView.getWidth() > 0) && i26 < i29)) {
                    layoutParams.gravity = 51;
                    z18 = false;
                } else {
                    z18 = z17;
                }
                if (this.K) {
                    int i36 = rect.right - rect.left;
                    int i37 = layoutParams.x;
                    int i38 = i37 + i19;
                    if (i38 > i36) {
                        layoutParams.x = i37 - (i38 - i36);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + " right= " + i38 + " displayFrameWidth= " + i36);
                        }
                    }
                    int i39 = layoutParams.x;
                    int i46 = rect.left;
                    if (i39 < i46) {
                        layoutParams.x = i46;
                        layoutParams.width = Math.min(layoutParams.width, i36);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + "displayFrame.left= " + rect.left);
                        }
                    }
                    if (z18) {
                        int i47 = i16 - this.Y;
                        if (i47 < 0) {
                            layoutParams.y += i47;
                        }
                    } else {
                        layoutParams.y = Math.max(layoutParams.y + this.f352377c0, rect.top);
                    }
                    layoutParams.gravity |= 268435456;
                }
                if (z18) {
                    layoutParams.y = rootView.getHeight() - layoutParams.y;
                }
                callback = this.f352387i;
                if (!(callback instanceof com.tencent.qqnt.aio.menu.ui.a) && ((com.tencent.qqnt.aio.menu.ui.a) callback).d()) {
                    r142 = 1;
                    B(layoutParams, view, rootView, z18, i19, measuredHeight, rect, ((com.tencent.qqnt.aio.menu.ui.a) this.f352387i).a(), i17, i18);
                } else {
                    r142 = 1;
                    V(z18, i3 - layoutParams.x);
                }
                companion = FreesiaWrapperImpl.INSTANCE;
                if (!companion.b().isSwitchOn("aio_menu_switch_9150", r142) && Build.VERSION.SDK_INT >= 24 && (view.getContext() instanceof Activity)) {
                    isInMultiWindowMode = ((Activity) view.getContext()).isInMultiWindowMode();
                    if (!isInMultiWindowMode) {
                        if (((IDevicesApi) com.tencent.qqnt.aio.adapter.a.b(IDevicesApi.class)).isPadDevice() && companion.b().isSwitchOn("aio_menu_pad_switch_8985", r142)) {
                            return;
                        }
                        int[] iArr = new int[2];
                        ((Activity) view.getContext()).getWindow().getDecorView().getLocationOnScreen(iArr);
                        int i48 = iArr[r142];
                        if (i48 > 10) {
                            layoutParams.y += i48;
                        }
                        int i49 = iArr[0];
                        if (i49 > 10) {
                            layoutParams.x -= i49;
                            if (QLog.isDevelopLevel()) {
                                QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + "pos[0]= " + iArr[0]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        i19 = i27;
        measuredHeight = i28;
        if (i19 > 0) {
        }
        int i292 = rect.top;
        if (this.f352377c0 > 0) {
        }
        if (this.N) {
        }
        z18 = z17;
        if (this.K) {
        }
        if (z18) {
        }
        callback = this.f352387i;
        if (!(callback instanceof com.tencent.qqnt.aio.menu.ui.a)) {
        }
        r142 = 1;
        V(z18, i3 - layoutParams.x);
        companion = FreesiaWrapperImpl.INSTANCE;
        if (!companion.b().isSwitchOn("aio_menu_switch_9150", r142)) {
            isInMultiWindowMode = ((Activity) view.getContext()).isInMultiWindowMode();
            if (!isInMultiWindowMode) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean y(View view, WindowManager.LayoutParams layoutParams, int i3, int i16) {
        String str;
        Rect rect;
        View view2;
        Rect rect2;
        int i17;
        char c16;
        boolean z16;
        boolean z17;
        view.getLocationInWindow(this.f352379d0);
        View rootView = view.getRootView();
        int[] iArr = this.f352379d0;
        layoutParams.x = iArr[0] + i3;
        layoutParams.y = iArr[1] + i16;
        if (QLog.isDevelopLevel()) {
            QLog.i("BubblePopupWindow", 4, "[findAbovePosition]: p.x= " + layoutParams.x + " p.y= " + layoutParams.y + " drawingLocation[0]= " + this.f352379d0[0] + " drawingLocation[1]= " + this.f352379d0[1] + " xoff= " + i3 + " yoff= " + i16);
        }
        layoutParams.gravity = 83;
        view.getLocationOnScreen(this.f352381e0);
        Rect rect3 = new Rect();
        view.getWindowVisibleDisplayFrame(rect3);
        Rect rect4 = new Rect();
        view.getGlobalVisibleRect(rect4);
        int i18 = this.X;
        int i19 = this.Y;
        if (i18 == -2 || i19 == -2) {
            this.f352392m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.X == -2) {
                i18 = this.f352392m.getMeasuredWidth();
            } else {
                i18 = i18;
            }
            if (this.Y == -2) {
                i19 = this.f352392m.getMeasuredHeight();
            }
        }
        if (i18 <= 0) {
            str = "[findAbovePosition]1: p.x= ";
            rect = rect4;
        } else {
            rect = rect4;
            layoutParams.x = ((this.f352381e0[0] + (view.getWidth() / 2)) - (i18 / 2)) + i3;
            if (!QLog.isDevelopLevel()) {
                str = "[findAbovePosition]1: p.x= ";
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[findAbovePosition]1: p.x= ");
                str = "[findAbovePosition]1: p.x= ";
                sb5.append(layoutParams.x);
                sb5.append(" drawingLocation[0]= ");
                sb5.append(this.f352379d0[0]);
                sb5.append(" xoff= ");
                sb5.append(i3);
                sb5.append("anchor.width= ");
                sb5.append(view.getWidth() / 2);
                sb5.append(" popupWidth= ");
                sb5.append(i18);
                QLog.i("BubblePopupWindow", 4, sb5.toString());
            }
        }
        if ((this.f352381e0[1] + i16) - i19 >= rect3.top && (layoutParams.x + i18) - rootView.getWidth() <= 0) {
            view2 = rootView;
        } else {
            if (this.L) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view2 = rootView;
                rect2 = rect3;
                i17 = i19;
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, scrollX + i18 + i3, scrollY + i19 + view.getHeight() + i16), true);
                view.getLocationInWindow(this.f352379d0);
                if (i18 > 0) {
                    layoutParams.x = ((this.f352379d0[0] + (view.getWidth() / 2)) - (i18 / 2)) + i3;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("BubblePopupWindow", 4, "[findAbovePosition]2: p.x= " + layoutParams.x + " drawingLocation[0]= " + this.f352379d0[0] + " xoff= " + i3 + "anchor.width= " + (view.getWidth() / 2) + " popupWidth= " + i18);
                    }
                } else {
                    layoutParams.x = this.f352379d0[0] + i3;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("BubblePopupWindow", 4, "[findAbovePosition]3: p.x= " + layoutParams.x + " drawingLocation[0]= " + this.f352379d0[0] + " xoff= " + i3);
                    }
                }
                c16 = 1;
                layoutParams.y = this.f352379d0[1] + i16;
                view.getLocationOnScreen(this.f352381e0);
            } else {
                view2 = rootView;
                rect2 = rect3;
                i17 = i19;
                c16 = 1;
            }
            int i26 = (this.f352381e0[c16] + i16) - i17;
            rect3 = rect2;
            if (i26 < rect3.top) {
                Rect rect5 = rect;
                if (i17 + rect5.bottom + i16 > rect3.bottom) {
                    layoutParams.y = rect5.top + (rect5.height() / 2) + i16;
                    z16 = true;
                    z17 = true;
                    if (this.K) {
                        int i27 = rect3.right;
                        int i28 = rect3.left;
                        int i29 = i27 - i28;
                        int i36 = layoutParams.x;
                        int i37 = i18 + i36;
                        if (i37 > i29) {
                            layoutParams.x = i36 - (i37 - i29);
                        }
                        if (layoutParams.x < i28) {
                            layoutParams.x = i28;
                            layoutParams.width = Math.min(layoutParams.width, i29);
                            if (QLog.isDevelopLevel()) {
                                QLog.i("BubblePopupWindow", 4, str + layoutParams.x + " displayFrame.left= " + rect3.left);
                            }
                        }
                        if (z16 && !z17) {
                            int i38 = (this.f352381e0[1] + i16) - this.Y;
                            if (i38 < 0) {
                                layoutParams.y += i38;
                            }
                        } else {
                            layoutParams.y = Math.max(layoutParams.y, rect3.top);
                        }
                        layoutParams.gravity |= 268435456;
                    }
                    if (z16 && !z17) {
                        layoutParams.y = view2.getHeight() - layoutParams.y;
                    }
                    int width = ((this.f352381e0[0] + (view.getWidth() / 2)) + i3) - layoutParams.x;
                    if (z16) {
                        layoutParams.y -= Math.round(TypedValue.applyDimension(1, 5.0f, this.f352378d.getResources().getDisplayMetrics()));
                    } else {
                        layoutParams.y -= Math.round(TypedValue.applyDimension(1, 3.0f, this.f352378d.getResources().getDisplayMetrics()));
                    }
                    V(z16, width);
                    return z16;
                }
                layoutParams.y = this.f352379d0[1] + view.getHeight() + i16;
                layoutParams.gravity = 51;
                z16 = false;
                z17 = false;
                if (this.K) {
                }
                if (z16) {
                    layoutParams.y = view2.getHeight() - layoutParams.y;
                }
                int width2 = ((this.f352381e0[0] + (view.getWidth() / 2)) + i3) - layoutParams.x;
                if (z16) {
                }
                V(z16, width2);
                return z16;
            }
            layoutParams.y = this.f352379d0[1] + i16;
        }
        z16 = true;
        z17 = false;
        if (this.K) {
        }
        if (z16) {
        }
        int width22 = ((this.f352381e0[0] + (view.getWidth() / 2)) + i3) - layoutParams.x;
        if (z16) {
        }
        V(z16, width22);
        return z16;
    }

    @TargetApi(14)
    private void z(WindowManager.LayoutParams layoutParams) {
        try {
            Context context = this.f352378d;
            if (context != null) {
                layoutParams.packageName = context.getPackageName();
            }
            if (VersionUtils.isIceScreamSandwich()) {
                this.f352392m.setFitsSystemWindows(this.M);
            }
            if (this.f352392m.getParent() == null) {
                this.f352380e.addView(this.f352392m, layoutParams);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("BubblePopupWindow", 4, "[invokePopup]: p.x= " + layoutParams.x + " p.y= " + layoutParams.y);
            }
        } catch (Throwable th5) {
            QLog.i("BubblePopupWindow", 1, "[invokePopup]: ", th5);
        }
    }

    public boolean A() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        int i3 = this.I;
        if (i3 < 0 && (context = this.f352378d) != null) {
            if (context.getApplicationInfo().targetSdkVersion < 11) {
                return false;
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
            return;
        }
        this.f352405y0 = z16;
        if (!z16 && this.f352392m.getAlpha() == 0.0f) {
            w();
        }
    }

    public void G(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else {
            this.f352384g0 = drawable;
        }
    }

    public void H(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (isShowing()) {
            return;
        }
        this.f352387i = view;
        if (this.f352378d == null && view != null) {
            this.f352378d = view.getContext();
        }
        if (this.f352380e == null && this.f352387i != null) {
            this.f352380e = (WindowManager) this.f352378d.getSystemService("window");
        }
    }

    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            this.V = i3;
        }
    }

    public void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.N = z16;
        }
    }

    public void M(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) cVar);
        } else {
            this.f352389j0 = cVar;
        }
    }

    public void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void O(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) fVar);
        } else {
            this.f352406z0 = fVar;
        }
    }

    public void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.S = i3;
        }
    }

    public void R(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "showAtLocation() called with: parent = [" + view + "], x = [" + i3 + "], y = [" + i16 + "]");
        }
        if (!isShowing() && this.f352387i != null) {
            T();
            this.f352404x0 = false;
            this.f352382f = true;
            this.f352385h = true;
            WindowManager.LayoutParams v3 = v(view.getWindowToken());
            E(v3, true, false, true);
            s(v3, i3, i16, view, i17, i18);
            int i19 = this.U;
            if (i19 < 0) {
                this.W = i19;
                v3.height = i19;
            }
            int i26 = this.R;
            if (i26 < 0) {
                this.T = i26;
                v3.width = i26;
            }
            v3.windowAnimations = t();
            z(v3);
        }
    }

    public void S(View view, int i3, int i16, boolean z16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "showAtLocation() called with: parent = [" + view + "], x = [" + i3 + "], y = [" + i16 + "], isNoIcon = [" + z16 + "]");
        }
        if (!isShowing() && this.f352387i != null) {
            T();
            this.f352382f = true;
            this.f352385h = true;
            WindowManager.LayoutParams v3 = v(view.getWindowToken());
            D(v3, z16);
            x(v3, i3, i16, view, i17, i18);
            int i19 = this.U;
            if (i19 < 0) {
                this.W = i19;
                v3.height = i19;
            }
            int i26 = this.R;
            if (i26 < 0) {
                this.T = i26;
                v3.width = i26;
            }
            v3.windowAnimations = t();
            z(v3);
        }
    }

    public void U(int i3, int i16, int i17, int i18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16));
            return;
        }
        if (i17 != -1) {
            this.T = i17;
            Q(i17);
        }
        if (i18 != -1) {
            this.W = i18;
            J(i18);
        }
        if (isShowing() && this.f352387i != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f352392m.getLayoutParams();
            int i19 = this.R;
            if (i19 >= 0) {
                i19 = this.T;
            }
            if (i17 != -1 && layoutParams.width != i19) {
                this.T = i19;
                layoutParams.width = i19;
                z16 = true;
            }
            int i26 = this.U;
            if (i26 >= 0) {
                i26 = this.W;
            }
            if (i18 != -1 && layoutParams.height != i26) {
                this.W = i26;
                layoutParams.height = i26;
                z16 = true;
            }
            if (layoutParams.x != i3) {
                layoutParams.x = i3;
                if (QLog.isDevelopLevel()) {
                    QLog.i("BubblePopupWindow", 4, "[update]: p.x= " + layoutParams.x + " x= " + i3);
                }
                z16 = true;
            }
            if (layoutParams.y != i16) {
                layoutParams.y = i16;
                z16 = true;
            }
            int t16 = t();
            if (t16 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = t16;
                z16 = true;
            }
            int u16 = u(layoutParams.flags);
            if (u16 != layoutParams.flags) {
                layoutParams.flags = u16;
            } else {
                z17 = z16;
            }
            if (z17) {
                this.f352380e.updateViewLayout(this.f352392m, layoutParams);
            }
        }
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.f352382f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) view);
        } else {
            w();
            f fVar = this.f352406z0;
            if (fVar != null) {
                fVar.onMenuNoIconEmptyClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void r(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) cVar);
        } else {
            this.f352390k0.add(cVar);
        }
    }

    public void w() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "dismiss() called \n" + QLog.getStackTraceString(new RuntimeException()));
        }
        if (isShowing() && (view = this.f352392m) != null) {
            if (this.f352405y0) {
                view.setAlpha(0.0f);
                this.f352405y0 = false;
                return;
            }
            this.f352382f = false;
            T();
            try {
                if (this.f352392m.getParent() != null) {
                    this.f352380e.removeViewImmediate(this.f352392m);
                }
            } finally {
                View view2 = this.f352392m;
                View view3 = this.f352387i;
                if (view2 != view3 && (view2 instanceof ViewGroup)) {
                    ((ViewGroup) view2).removeView(view3);
                }
                this.f352392m = null;
                c cVar = this.f352389j0;
                if (cVar != null) {
                    cVar.onDismiss();
                }
                for (c cVar2 : this.f352390k0) {
                    if (cVar2 != null) {
                        cVar2.onDismiss();
                    }
                }
            }
        }
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.D = 0;
        this.E = 1;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = -1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.f352376b0 = ViewUtils.getScreenWidth();
        this.f352377c0 = 0;
        this.f352379d0 = new int[2];
        this.f352381e0 = new int[2];
        this.f352383f0 = new Rect();
        this.f352388i0 = 1000;
        this.f352390k0 = new ArrayList();
        this.f352391l0 = false;
        this.f352396p0 = -1;
        this.f352398r0 = new a();
        this.f352404x0 = true;
        this.f352405y0 = false;
        this.f352378d = context;
        this.f352380e = (WindowManager) context.getSystemService("window");
    }

    public BubblePopupWindow() {
        this((View) null, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public BubblePopupWindow(int i3, int i16) {
        this((View) null, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public BubblePopupWindow(View view, int i3, int i16) {
        this(view, i3, i16, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public BubblePopupWindow(View view, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.D = 0;
        this.E = 1;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = -1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.f352376b0 = ViewUtils.getScreenWidth();
        this.f352377c0 = 0;
        this.f352379d0 = new int[2];
        this.f352381e0 = new int[2];
        this.f352383f0 = new Rect();
        this.f352388i0 = 1000;
        this.f352390k0 = new ArrayList();
        this.f352391l0 = false;
        this.f352396p0 = -1;
        this.f352398r0 = new a();
        this.f352404x0 = true;
        this.f352405y0 = false;
        if (view != null) {
            Context context = view.getContext();
            this.f352378d = context;
            this.f352380e = (WindowManager) context.getSystemService("window");
        }
        H(view);
        Q(i3);
        J(i16);
        I(z16);
    }
}
