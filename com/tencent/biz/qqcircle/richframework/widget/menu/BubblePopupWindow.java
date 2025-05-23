package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.image.ProxyDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class BubblePopupWindow implements View.OnClickListener {

    /* renamed from: x0, reason: collision with root package name */
    private static final int[] f92170x0 = {R.attr.state_above_anchor};
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
    private int f92171a0;

    /* renamed from: b0, reason: collision with root package name */
    private int[] f92172b0;

    /* renamed from: c0, reason: collision with root package name */
    private int[] f92173c0;

    /* renamed from: d, reason: collision with root package name */
    private Context f92174d;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f92175d0;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager f92176e;

    /* renamed from: e0, reason: collision with root package name */
    private Drawable f92177e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f92178f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f92179f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f92180g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f92181h;

    /* renamed from: h0, reason: collision with root package name */
    private c f92182h0;

    /* renamed from: i, reason: collision with root package name */
    private View f92183i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f92184i0;

    /* renamed from: j0, reason: collision with root package name */
    private b f92185j0;

    /* renamed from: k0, reason: collision with root package name */
    private b f92186k0;

    /* renamed from: l0, reason: collision with root package name */
    private b f92187l0;

    /* renamed from: m, reason: collision with root package name */
    private View f92188m;

    /* renamed from: m0, reason: collision with root package name */
    private int f92189m0;

    /* renamed from: n0, reason: collision with root package name */
    private rb0.a f92190n0;

    /* renamed from: o0, reason: collision with root package name */
    private WeakReference<View> f92191o0;

    /* renamed from: p0, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f92192p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f92193q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f92194r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageView f92195s0;

    /* renamed from: t0, reason: collision with root package name */
    private ImageView f92196t0;

    /* renamed from: u0, reason: collision with root package name */
    private FrameLayout f92197u0;

    /* renamed from: v0, reason: collision with root package name */
    private Drawable f92198v0;

    /* renamed from: w0, reason: collision with root package name */
    private f f92199w0;

    /* loaded from: classes5.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view;
            WindowManager.LayoutParams layoutParams;
            if (BubblePopupWindow.this.f92191o0 != null) {
                view = (View) BubblePopupWindow.this.f92191o0.get();
            } else {
                view = null;
            }
            if (view == null || BubblePopupWindow.this.f92188m == null || (layoutParams = (WindowManager.LayoutParams) BubblePopupWindow.this.f92188m.getLayoutParams()) == null) {
                return;
            }
            BubblePopupWindow bubblePopupWindow = BubblePopupWindow.this;
            bubblePopupWindow.v(view, layoutParams, bubblePopupWindow.f92193q0, BubblePopupWindow.this.f92194r0);
            BubblePopupWindow.this.O(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends ProxyDrawable {

        /* renamed from: d, reason: collision with root package name */
        int f92201d;

        /* renamed from: e, reason: collision with root package name */
        int f92202e;

        public b(Drawable drawable) {
            super(drawable);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            if (this.f92202e > this.f92201d) {
                int save = canvas.save();
                canvas.clipRect(this.f92201d, 0, this.f92202e, bounds.height());
                this.mCurrDrawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }

        public void setClipRange(int i3, int i16) {
            this.f92201d = i3;
            this.f92202e = i16;
            invalidateSelf();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onDismiss();
    }

    /* loaded from: classes5.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        View f92204d;

        public e(Context context) {
            super(context);
            this.f92204d = null;
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
                    BubblePopupWindow.this.u();
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
            if (BubblePopupWindow.this.Q != null && BubblePopupWindow.this.Q.onTouch(this, motionEvent)) {
                return true;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (BubblePopupWindow.this.f92188m == null) {
                return dispatchTouchEvent;
            }
            View a16 = a(BubblePopupWindow.this.f92183i);
            if (this.f92204d == null && a16 == null) {
                z16 = false;
            } else {
                this.f92204d = a16;
                if (a16 != null) {
                    a16.scrollTo(0, 0);
                    this.f92204d.getDrawingRect(BubblePopupWindow.this.f92175d0);
                    b(this.f92204d, BubblePopupWindow.this.f92183i, BubblePopupWindow.this.f92175d0);
                    if (BubblePopupWindow.this.f92175d0.left == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (BubblePopupWindow.this.f92175d0.right == BubblePopupWindow.this.f92183i.getWidth()) {
                        i3 = BubblePopupWindow.this.f92188m.getWidth();
                        z18 = true;
                    } else {
                        i3 = 0;
                        z18 = false;
                    }
                    if (z17 && z18) {
                        i16 = 0;
                    } else {
                        this.f92204d.getDrawingRect(BubblePopupWindow.this.f92175d0);
                        b(this.f92204d, BubblePopupWindow.this.f92197u0, BubblePopupWindow.this.f92175d0);
                        if (!z17) {
                            i16 = BubblePopupWindow.this.f92175d0.left;
                        } else {
                            i16 = 0;
                        }
                        if (!z18) {
                            i3 = BubblePopupWindow.this.f92175d0.right;
                        }
                    }
                    BubblePopupWindow.this.f92185j0.setClipRange(i16, i3);
                    BubblePopupWindow.this.f92186k0.setClipRange(i16 - BubblePopupWindow.this.f92196t0.getLeft(), i3 - BubblePopupWindow.this.f92196t0.getLeft());
                    BubblePopupWindow.this.f92187l0.setClipRange(i16 - BubblePopupWindow.this.f92195s0.getLeft(), i3 - BubblePopupWindow.this.f92195s0.getLeft());
                    z16 = false;
                } else {
                    BubblePopupWindow.this.f92185j0.setClipRange(0, 0);
                    BubblePopupWindow.this.f92186k0.setClipRange(0, 0);
                    BubblePopupWindow.this.f92187l0.setClipRange(0, 0);
                    z16 = true;
                }
                BubblePopupWindow.this.f92197u0.invalidate();
            }
            if (!z16 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                BubblePopupWindow.this.f92185j0.setClipRange(0, 0);
                BubblePopupWindow.this.f92186k0.setClipRange(0, 0);
                BubblePopupWindow.this.f92187l0.setClipRange(0, 0);
                BubblePopupWindow.this.f92197u0.invalidate();
            }
            return dispatchTouchEvent;
        }

        @Override // android.view.View
        @TargetApi(8)
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            BubblePopupWindow.this.u();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i3) {
            if (BubblePopupWindow.this.f92179f0) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
                View.mergeDrawableStates(onCreateDrawableState, BubblePopupWindow.f92170x0);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i3);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x16 < 0 || x16 >= getWidth() || y16 < 0 || y16 >= getHeight())) {
                BubblePopupWindow.this.u();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                BubblePopupWindow.this.u();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i3) {
            if (BubblePopupWindow.this.f92183i != null) {
                BubblePopupWindow.this.f92183i.sendAccessibilityEvent(i3);
            } else {
                super.sendAccessibilityEvent(i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onMenuNoIconEmptyClick();
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
    }

    private void A(WindowManager.LayoutParams layoutParams) {
        B(layoutParams, false);
    }

    private void B(WindowManager.LayoutParams layoutParams, boolean z16) {
        int i3;
        int i16;
        if (this.f92183i != null && this.f92174d != null && this.f92176e != null) {
            e eVar = new e(this.f92174d);
            FrameLayout frameLayout = new FrameLayout(this.f92174d);
            if (z16) {
                frameLayout.setOnClickListener(this);
            }
            if (this.f92183i instanceof QQCustomMenuLayout) {
                this.f92197u0 = new FrameLayout(this.f92174d);
                this.f92185j0 = new b(this.f92174d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.o08));
                this.f92197u0.addView(this.f92183i, new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
                layoutParams2.setMargins(0, cx.a(9.0f), 0, cx.a(9.0f));
                eVar.addView(this.f92197u0, layoutParams2);
            } else {
                if (z16) {
                    i3 = Math.round(TypedValue.applyDimension(1, 5.0f, this.f92174d.getResources().getDisplayMetrics()));
                    i16 = Math.round(TypedValue.applyDimension(1, 5.0f, this.f92174d.getResources().getDisplayMetrics()));
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                frameLayout.setPadding(i3, Math.round(TypedValue.applyDimension(1, 8.0f, this.f92174d.getResources().getDisplayMetrics())), i16, Math.round(TypedValue.applyDimension(1, 8.0f, this.f92174d.getResources().getDisplayMetrics())));
                eVar.addView(frameLayout, -1, -1);
                FrameLayout frameLayout2 = new FrameLayout(this.f92174d);
                this.f92197u0 = frameLayout2;
                frameLayout.addView(frameLayout2, -1, -1);
                this.f92197u0.setBackgroundDrawable(x());
                this.f92197u0.addView(this.f92183i, new FrameLayout.LayoutParams(-1, -1, 17));
            }
            this.f92196t0 = new ImageView(this.f92174d);
            ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 51);
            this.f92186k0 = new b(this.f92190n0.b(this.f92174d));
            this.f92196t0.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.f92190n0.b(this.f92174d), this.f92186k0}));
            eVar.addView(this.f92196t0, layoutParams3);
            this.f92195s0 = new ImageView(this.f92174d);
            ViewGroup.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 83);
            this.f92187l0 = new b(this.f92190n0.a(this.f92174d));
            this.f92195s0.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.f92190n0.a(this.f92174d), this.f92187l0}));
            eVar.addView(this.f92195s0, layoutParams4);
            this.f92188m = eVar;
            this.X = layoutParams.width;
            this.Y = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    private void C(View view, int i3, int i16) {
        N();
        this.f92191o0 = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.f92192p0);
        }
        this.f92193q0 = i3;
        this.f92194r0 = i16;
    }

    private void N() {
        View view;
        WeakReference<View> weakReference = this.f92191o0;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.f92192p0);
        }
        this.f92191o0 = null;
    }

    private void P(boolean z16, int i3) {
        ImageView imageView;
        ImageView imageView2;
        this.f92179f0 = z16;
        if (!z16) {
            imageView = this.f92196t0;
        } else {
            imageView = this.f92195s0;
        }
        if (!z16) {
            imageView2 = this.f92195s0;
        } else {
            imageView2 = this.f92196t0;
        }
        int measuredWidth = imageView.getMeasuredWidth();
        imageView.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = i3 - (measuredWidth / 2);
        if (this.f92179f0) {
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

    private int r() {
        int i3 = this.f92189m0;
        if (i3 == -1) {
            if (this.f92181h) {
                if (this.f92179f0) {
                    return com.tencent.mobileqq.R.style.a78;
                }
                return com.tencent.mobileqq.R.style.a77;
            }
            return 0;
        }
        return i3;
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
    private int s(int i3) {
        int i16 = i3 & (-8815129);
        if (this.f92184i0) {
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
        if (z()) {
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

    private WindowManager.LayoutParams t(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i3 = this.S;
        this.T = i3;
        layoutParams.width = i3;
        int i16 = this.V;
        this.W = i16;
        layoutParams.height = i16;
        Drawable drawable = this.f92177e0;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = s(layoutParams.flags);
        layoutParams.type = this.f92180g0;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.E;
        layoutParams.setTitle("PopupWindow");
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean v(View view, WindowManager.LayoutParams layoutParams, int i3, int i16) {
        boolean z16;
        boolean z17;
        int round;
        view.getLocationInWindow(this.f92172b0);
        View rootView = view.getRootView();
        int[] iArr = this.f92172b0;
        layoutParams.x = iArr[0] + i3;
        layoutParams.y = iArr[1] + i16;
        if (this.N) {
            layoutParams.gravity = 51;
            z16 = false;
        } else {
            layoutParams.gravity = 83;
            z16 = true;
        }
        view.getLocationOnScreen(this.f92173c0);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int i17 = this.X;
        int i18 = this.Y;
        if (i17 == -2 || i18 == -2) {
            this.f92188m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.X == -2) {
                i17 = this.f92188m.getMeasuredWidth();
            }
            if (this.Y == -2) {
                i18 = this.f92188m.getMeasuredHeight();
            }
        }
        if (i17 > 0) {
            layoutParams.x = ((this.f92173c0[0] + (view.getWidth() / 2)) - (i17 / 2)) + i3;
        }
        if ((this.f92173c0[1] + i16) - i18 < rect.top || (layoutParams.x + i17) - rootView.getWidth() > 0) {
            if (this.L) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, scrollX + i17 + i3, scrollY + i18 + view.getHeight() + i16), true);
                view.getLocationInWindow(this.f92172b0);
                if (i17 > 0) {
                    layoutParams.x = ((this.f92172b0[0] + (view.getWidth() / 2)) - (i17 / 2)) + i3;
                } else {
                    layoutParams.x = this.f92172b0[0] + i3;
                }
                layoutParams.y = this.f92172b0[1] + i16;
                view.getLocationOnScreen(this.f92173c0);
            }
            if ((this.f92173c0[1] + i16) - i18 < rect.top) {
                if (i18 + rect2.bottom + i16 > rect.bottom) {
                    layoutParams.y = rect2.top + (rect2.height() / 2) + i16;
                    z17 = true;
                } else {
                    layoutParams.y = this.f92172b0[1] + view.getHeight() + i16;
                    layoutParams.gravity = 51;
                    z16 = false;
                    z17 = false;
                }
                if (this.K) {
                    int i19 = rect.right;
                    int i26 = rect.left;
                    int i27 = i19 - i26;
                    int i28 = layoutParams.x;
                    int i29 = i17 + i28;
                    if (i29 > i27) {
                        layoutParams.x = i28 - (i29 - i27);
                    }
                    if (layoutParams.x < i26) {
                        layoutParams.x = i26;
                        layoutParams.width = Math.min(layoutParams.width, i27);
                    }
                    if (z16 && !z17) {
                        int i36 = (this.f92173c0[1] + i16) - this.Y;
                        if (i36 < 0) {
                            layoutParams.y += i36;
                        }
                    } else {
                        layoutParams.y = Math.max(layoutParams.y, rect.top);
                    }
                    layoutParams.gravity |= 268435456;
                }
                if (z16 && !z17) {
                    layoutParams.y = rootView.getHeight() - layoutParams.y;
                }
                int width = (this.f92173c0[0] + (view.getWidth() / 2)) - layoutParams.x;
                if (!z16) {
                    round = Math.round(TypedValue.applyDimension(1, 5.0f, this.f92174d.getResources().getDisplayMetrics()));
                } else {
                    round = Math.round(TypedValue.applyDimension(1, 3.0f, this.f92174d.getResources().getDisplayMetrics()));
                }
                layoutParams.y -= round;
                P(z16, width);
                return z16;
            }
            layoutParams.y = this.f92172b0[1] + i16;
        }
        z17 = false;
        if (this.K) {
        }
        if (z16) {
            layoutParams.y = rootView.getHeight() - layoutParams.y;
        }
        int width2 = (this.f92173c0[0] + (view.getWidth() / 2)) - layoutParams.x;
        if (!z16) {
        }
        layoutParams.y -= round;
        P(z16, width2);
        return z16;
    }

    private Drawable w() {
        Drawable drawable = this.f92174d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cay);
        this.f92185j0 = new b(this.f92174d.getResources().getDrawable(com.tencent.mobileqq.R.drawable.o08));
        return new LayerDrawable(new Drawable[]{drawable, this.f92185j0});
    }

    @TargetApi(14)
    private void y(WindowManager.LayoutParams layoutParams) {
        Context context = this.f92174d;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f92188m.setFitsSystemWindows(this.M);
        if (this.f92188m.getParent() == null) {
            this.f92176e.addView(this.f92188m, layoutParams);
        }
    }

    public void D(Drawable drawable) {
        this.f92177e0 = drawable;
    }

    public void E(View view) {
        Context context;
        if (isShowing()) {
            return;
        }
        this.f92183i = view;
        if (this.f92174d == null && view != null) {
            this.f92174d = view.getContext();
        }
        if (this.f92176e == null && (context = this.f92174d) != null) {
            this.f92176e = (WindowManager) context.getSystemService("window");
        }
    }

    public void F(boolean z16) {
        this.C = z16;
    }

    public void G(int i3) {
        this.V = i3;
    }

    public void H(c cVar) {
        this.f92182h0 = cVar;
    }

    public void I(boolean z16) {
        this.G = z16;
    }

    public void J(f fVar) {
        this.f92199w0 = fVar;
    }

    public void K(int i3) {
        this.S = i3;
    }

    public void L(View view) {
        M(view, 0, 0);
    }

    public void M(View view, int i3, int i16) {
        if (!isShowing() && this.f92183i != null) {
            C(view, i3, i16);
            this.f92178f = true;
            this.f92181h = true;
            WindowManager.LayoutParams t16 = t(view.getWindowToken());
            A(t16);
            v(view, t16, i3, i16);
            int i17 = this.U;
            if (i17 < 0) {
                this.W = i17;
                t16.height = i17;
            }
            int i18 = this.R;
            if (i18 < 0) {
                this.T = i18;
                t16.width = i18;
            }
            t16.windowAnimations = r();
            y(t16);
        }
    }

    public void O(int i3, int i16, int i17, int i18, boolean z16) {
        if (i17 != -1) {
            this.T = i17;
            K(i17);
        }
        if (i18 != -1) {
            this.W = i18;
            G(i18);
        }
        if (isShowing() && this.f92183i != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f92188m.getLayoutParams();
            int i19 = this.R;
            if (i19 >= 0) {
                i19 = this.T;
            }
            boolean z17 = true;
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
                z16 = true;
            }
            if (layoutParams.y != i16) {
                layoutParams.y = i16;
                z16 = true;
            }
            int r16 = r();
            if (r16 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = r16;
                z16 = true;
            }
            int s16 = s(layoutParams.flags);
            if (s16 != layoutParams.flags) {
                layoutParams.flags = s16;
            } else {
                z17 = z16;
            }
            if (z17) {
                this.f92176e.updateViewLayout(this.f92188m, layoutParams);
            }
        }
    }

    public void Q(int i3, boolean z16, int i16) {
        int x16 = (int) (i3 + (this.f92183i.getX() * 2.0f));
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f92188m.getLayoutParams();
        if (this.Z > DisplayUtil.getScreenWidth() / 2) {
            layoutParams.x = (layoutParams.x + i16) - x16;
        }
        P(this.f92179f0, this.Z - layoutParams.x);
        this.f92176e.removeView(this.f92188m);
        this.f92176e.addView(this.f92188m, layoutParams);
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "[menu] updateLocationX ParamX: " + layoutParams.x + " menuContainerWidth: " + x16 + " centerX: " + this.Z + " isMenusLineFull: " + z16);
        }
    }

    public boolean isShowing() {
        return this.f92178f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u();
        f fVar = this.f92199w0;
        if (fVar != null) {
            fVar.onMenuNoIconEmptyClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void u() {
        if (QLog.isColorLevel()) {
            QLog.d("BubblePopupWindow", 2, "dismiss() called \n");
        }
        if (isShowing() && this.f92188m != null) {
            this.f92178f = false;
            N();
            try {
                if (this.f92188m.getParent() != null) {
                    this.f92176e.removeViewImmediate(this.f92188m);
                }
            } finally {
                View view = this.f92188m;
                View view2 = this.f92183i;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.f92188m = null;
                c cVar = this.f92182h0;
                if (cVar != null) {
                    cVar.onDismiss();
                }
            }
        }
    }

    public Drawable x() {
        if (this.f92198v0 == null) {
            this.f92198v0 = w();
        }
        return this.f92198v0;
    }

    public boolean z() {
        Context context;
        int i3 = this.I;
        if (i3 < 0 && (context = this.f92174d) != null) {
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

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public BubblePopupWindow(Context context, AttributeSet attributeSet, int i3, int i16) {
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
        this.f92171a0 = 0;
        this.f92172b0 = new int[2];
        this.f92173c0 = new int[2];
        this.f92175d0 = new Rect();
        this.f92180g0 = 1000;
        this.f92184i0 = false;
        this.f92189m0 = -1;
        this.f92192p0 = new a();
        this.f92174d = context;
        this.f92176e = (WindowManager) context.getSystemService("window");
    }

    public BubblePopupWindow() {
        this((View) null, 0, 0);
    }

    public BubblePopupWindow(int i3, int i16) {
        this((View) null, i3, i16);
    }

    public BubblePopupWindow(View view, int i3, int i16) {
        this(view, i3, i16, false);
    }

    public BubblePopupWindow(View view, int i3, int i16, boolean z16) {
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
        this.f92171a0 = 0;
        this.f92172b0 = new int[2];
        this.f92173c0 = new int[2];
        this.f92175d0 = new Rect();
        this.f92180g0 = 1000;
        this.f92184i0 = false;
        this.f92189m0 = -1;
        this.f92192p0 = new a();
        if (view != null) {
            Context context = view.getContext();
            this.f92174d = context;
            this.f92176e = (WindowManager) context.getSystemService("window");
        }
        this.f92190n0 = new rb0.f();
        E(view);
        K(i3);
        G(i16);
        F(z16);
    }
}
