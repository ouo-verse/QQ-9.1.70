package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.mo.a;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SelectableTextHelper {
    public static final String TAG = "SelectableTextHelper";
    public ViewTreeObserver.OnScrollChangedListener A;
    public ViewTreeObserver.OnPreDrawListener B;
    public ViewTreeObserver.OnGlobalLayoutListener C;
    public View.OnTouchListener D;
    public int O;
    public OnTouchOutsideListener S;
    public ArrayList T;

    /* renamed from: a, reason: collision with root package name */
    public CursorHandle f153972a;

    /* renamed from: b, reason: collision with root package name */
    public CursorHandle f153973b;

    /* renamed from: d, reason: collision with root package name */
    public OnSelectListener f153975d;

    /* renamed from: e, reason: collision with root package name */
    public Context f153976e;

    /* renamed from: f, reason: collision with root package name */
    public View f153977f;

    /* renamed from: g, reason: collision with root package name */
    public OuterMenuAction f153978g;

    /* renamed from: k, reason: collision with root package name */
    public View.OnClickListener f153982k;

    /* renamed from: l, reason: collision with root package name */
    public View.OnTouchListener f153983l;

    /* renamed from: n, reason: collision with root package name */
    public int f153985n;

    /* renamed from: o, reason: collision with root package name */
    public Spannable f153986o;

    /* renamed from: p, reason: collision with root package name */
    public MMPopupMenu f153987p;

    /* renamed from: q, reason: collision with root package name */
    public int f153988q;

    /* renamed from: r, reason: collision with root package name */
    public int f153989r;

    /* renamed from: s, reason: collision with root package name */
    public int f153990s;

    /* renamed from: t, reason: collision with root package name */
    public int f153991t;

    /* renamed from: u, reason: collision with root package name */
    public int f153992u;

    /* renamed from: v, reason: collision with root package name */
    public int f153993v;

    /* renamed from: w, reason: collision with root package name */
    public a f153994w;

    /* renamed from: x, reason: collision with root package name */
    public int f153995x;

    /* renamed from: y, reason: collision with root package name */
    public int f153996y;

    /* renamed from: z, reason: collision with root package name */
    public View.OnAttachStateChangeListener f153997z;

    /* renamed from: c, reason: collision with root package name */
    public SelectionInfo f153974c = new SelectionInfo();

    /* renamed from: h, reason: collision with root package name */
    public boolean f153979h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153980i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f153981j = false;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f153984m = new ArrayList();
    public boolean E = false;
    public boolean F = true;
    public boolean G = false;
    public boolean H = false;
    public boolean I = true;
    public boolean J = true;
    public boolean K = true;
    public boolean L = false;
    public boolean M = false;
    public int[] N = new int[2];
    public final Runnable P = new Runnable() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (SelectableTextHelper.this.E) {
                n.a(SelectableTextHelper.TAG, "isReInit, return.", new Object[0]);
                return;
            }
            n.a(SelectableTextHelper.TAG, "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", Boolean.valueOf(SelectableTextHelper.this.K), Boolean.valueOf(SelectableTextHelper.this.L));
            if (SelectableTextHelper.this.f153978g != null) {
                if (!SelectableTextHelper.this.K) {
                    SelectableTextHelper.this.K = true;
                    if (SelectableTextHelper.this.L) {
                        n.a(SelectableTextHelper.TAG, "menu is hide: %s, cursor is hide: %s.", Boolean.valueOf(SelectableTextHelper.this.menuIsHide()), Boolean.valueOf(SelectableTextHelper.this.cursorIsHide()));
                        if (!SelectableTextHelper.this.menuIsHide()) {
                            SelectableTextHelper.this.showOperateMenu();
                        }
                        if (!SelectableTextHelper.this.cursorIsHide()) {
                            SelectableTextHelper.this.showCursorHandle();
                            SelectableTextHelper selectableTextHelper = SelectableTextHelper.this;
                            selectableTextHelper.selectText(selectableTextHelper.f153974c.f154036a, SelectableTextHelper.this.f153974c.f154037b);
                        }
                        if (SelectableTextHelper.this.f153978g != null && SelectableTextHelper.this.menuIsHide() && !SelectableTextHelper.this.cursorIsHide()) {
                            SelectableTextHelper.this.f153978g.open(SelectableTextHelper.this.f153977f);
                        }
                    }
                    SelectableTextHelper.this.L = false;
                    return;
                }
                if (SelectableTextHelper.this.M) {
                    SelectableTextHelper.this.M = false;
                    n.a(SelectableTextHelper.TAG, "judge result(delay), click outside.", new Object[0]);
                    if (SelectableTextHelper.this.S != null) {
                        SelectableTextHelper.this.S.touchOutside();
                        return;
                    }
                    return;
                }
                n.a(SelectableTextHelper.TAG, "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
                return;
            }
            if (!SelectableTextHelper.this.menuIsHide()) {
                SelectableTextHelper.this.showOperateMenu();
            }
            if (!SelectableTextHelper.this.cursorIsHide()) {
                SelectableTextHelper.this.showCursorHandle();
            }
        }
    };
    public final Runnable Q = new Runnable() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.2
        @Override // java.lang.Runnable
        public void run() {
            n.a(SelectableTextHelper.TAG, "dismiss all runnable.", new Object[0]);
            if (SelectableTextHelper.this.S != null) {
                SelectableTextHelper.this.S.touchOutside();
            }
        }
    };
    public int[] R = new int[2];

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class CursorHandle extends View {
        public Point C;
        public boolean D;
        public int[] E;

        /* renamed from: a, reason: collision with root package name */
        public PopupWindow f154020a;

        /* renamed from: b, reason: collision with root package name */
        public Paint f154021b;

        /* renamed from: c, reason: collision with root package name */
        public int f154022c;

        /* renamed from: d, reason: collision with root package name */
        public int f154023d;

        /* renamed from: e, reason: collision with root package name */
        public int f154024e;

        /* renamed from: f, reason: collision with root package name */
        public int f154025f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f154026g;

        /* renamed from: h, reason: collision with root package name */
        public int f154027h;

        /* renamed from: i, reason: collision with root package name */
        public int f154028i;

        /* renamed from: j, reason: collision with root package name */
        public int f154029j;

        /* renamed from: k, reason: collision with root package name */
        public int f154030k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f154031l;

        /* renamed from: m, reason: collision with root package name */
        public Rect f154032m;

        public CursorHandle(boolean z16) {
            super(SelectableTextHelper.this.f153976e);
            int i3 = SelectableTextHelper.this.f153993v / 2;
            this.f154022c = i3;
            int i16 = i3 * 2;
            this.f154023d = i16;
            this.f154024e = i16;
            this.f154025f = 20;
            this.f154031l = new int[2];
            this.f154032m = new Rect();
            this.C = new Point();
            this.D = false;
            this.E = new int[2];
            this.f154026g = z16;
            Paint paint = new Paint(1);
            this.f154021b = paint;
            paint.setColor(SelectableTextHelper.this.f153976e.getResources().getColor(SelectableTextHelper.this.f153992u));
            PopupWindow popupWindow = new PopupWindow(this);
            this.f154020a = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.f154020a.setWidth(this.f154023d + (this.f154025f * 3));
            this.f154020a.setHeight(this.f154024e + (this.f154025f * 2));
        }

        public final int b() {
            int i3;
            int i16;
            int i17;
            if (this.f154026g) {
                i3 = SelectableTextHelper.this.f153974c.f154036a;
            } else {
                i3 = SelectableTextHelper.this.f153974c.f154037b;
            }
            TextPaint paint = TextLayoutUtil.getPaint(SelectableTextHelper.this.f153977f);
            if (paint != null) {
                i16 = TextLayoutUtil.getLineBaseline(SelectableTextHelper.this.f153977f, TextLayoutUtil.getLineForOffset(SelectableTextHelper.this.f153977f, i3)) + ((int) paint.getFontMetrics().descent);
                i17 = (int) TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.this.f153977f, i3);
            } else {
                i16 = 0;
                i17 = 0;
            }
            SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
            SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
            if (!this.f154026g) {
                i16 = a(i17, i16)[1];
            }
            return i16 + getExtraY();
        }

        public final void c() {
            SelectableTextHelper.this.setFromSpanMenu(false);
            SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
            TextPaint paint = TextLayoutUtil.getPaint(SelectableTextHelper.this.f153977f);
            if (paint != null) {
                int i3 = (int) paint.getFontMetrics().descent;
                if (this.f154026g) {
                    this.f154020a.update((((int) TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154036a)) - this.f154023d) + getExtraX(), TextLayoutUtil.getLineBaseline(SelectableTextHelper.this.f153977f, TextLayoutUtil.getLineForOffset(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154036a)) + i3 + getExtraY(), -1, -1);
                    return;
                }
                int[] a16 = a((int) TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154037b), TextLayoutUtil.getLineBaseline(SelectableTextHelper.this.f153977f, TextLayoutUtil.getLineForOffset(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154037b)) + i3);
                this.f154020a.update(a16[0] + this.f154025f + getExtraX(), a16[1] + getExtraY(), -1, -1);
            }
        }

        public void dismiss() {
            this.f154020a.dismiss();
        }

        public int getExtraX() {
            return (this.f154031l[0] - (this.f154025f * 2)) + SelectableTextHelper.this.f153977f.getPaddingLeft();
        }

        public int getExtraY() {
            return this.f154031l[1] + SelectableTextHelper.this.f153977f.getPaddingTop();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            if (SelectableTextHelper.this.f153978g != null) {
                int b16 = b();
                if (SelectableTextHelper.this.f153977f.getGlobalVisibleRect(this.f154032m, this.C)) {
                    Rect rect = this.f154032m;
                    if (b16 >= rect.bottom) {
                        if (this.f154026g) {
                            n.a(SelectableTextHelper.TAG, "start below bottom, dismiss all.", new Object[0]);
                            SelectableTextHelper.this.resetSelectionInfo();
                            SelectableTextHelper.this.setMenuHide(true);
                            SelectableTextHelper.this.setCursorHide(true);
                            SelectableTextHelper.this.hideSelectView();
                            SelectableTextHelper.this.f153978g.dismiss();
                        }
                        n.a(SelectableTextHelper.TAG, "cursor invisible.", new Object[0]);
                        return;
                    }
                    if (b16 <= rect.top) {
                        if (!this.f154026g) {
                            n.a(SelectableTextHelper.TAG, "end above top, dismiss all.", new Object[0]);
                            SelectableTextHelper.this.resetSelectionInfo();
                            SelectableTextHelper.this.setMenuHide(true);
                            SelectableTextHelper.this.setCursorHide(true);
                            SelectableTextHelper.this.hideSelectView();
                            SelectableTextHelper.this.f153978g.dismiss();
                        }
                        n.a(SelectableTextHelper.TAG, "cursor invisible.", new Object[0]);
                        return;
                    }
                } else {
                    n.a(SelectableTextHelper.TAG, "view invisible.", new Object[0]);
                    return;
                }
            }
            if (this.f154026g) {
                int i3 = this.f154022c;
                float f16 = (this.f154025f * 2) + i3;
                float f17 = i3;
                canvas.drawCircle(f16, f17, f17, this.f154021b);
                int i16 = this.f154022c;
                int i17 = this.f154025f * 2;
                canvas.drawRect(i16 + i17, 0.0f, (i16 * 2) + i17, i16, this.f154021b);
                return;
            }
            int i18 = this.f154022c;
            float f18 = this.f154025f + i18;
            float f19 = i18;
            canvas.drawCircle(f18, f19, f19, this.f154021b);
            canvas.drawRect(this.f154025f, 0.0f, r0 + r1, this.f154022c, this.f154021b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
        
            if (r0 != 3) goto L33;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            n.a(SelectableTextHelper.TAG, "onTouchEvent: " + motionEvent.getAction(), new Object[0]);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (SelectableTextHelper.this.f153978g != null) {
                            SelectableTextHelper.this.f153978g.onSwitchMenu();
                            SelectableTextHelper.this.f153978g.dismiss();
                        }
                        SelectableTextHelper.this.hideOperateMenu();
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        if (SelectableTextHelper.this.f153978g == null) {
                            update(rawX - this.E[0], ((rawY + this.f154028i) - this.f154024e) - SelectableTextHelper.this.f153995x);
                        } else {
                            update((rawX - this.E[0]) + this.f154022c, ((rawY + this.f154028i) - this.f154024e) - SelectableTextHelper.this.f153995x);
                        }
                        if (SelectableTextHelper.this.f153978g != null) {
                            SelectableTextHelper.this.f153978g.onSwitchMenuFinish();
                        }
                    }
                }
                if (SelectableTextHelper.this.f153978g != null && !this.D) {
                    this.D = true;
                    SelectableTextHelper.this.f153978g.onSwitchMenu();
                    if (SelectableTextHelper.this.f153974c.f154037b - SelectableTextHelper.this.f153974c.f154036a == TextLayoutUtil.getText(SelectableTextHelper.this.f153977f).length()) {
                        SelectableTextHelper.this.f153978g.open(SelectableTextHelper.this.f153977f);
                        SelectableTextHelper.this.setMenuHide(true);
                        SelectableTextHelper.this.hideOperateMenu();
                    } else {
                        SelectableTextHelper.this.f153978g.dismiss();
                        SelectableTextHelper.this.setMenuHide(false);
                        SelectableTextHelper.this.showOperateMenu();
                    }
                    SelectableTextHelper.this.f153978g.onSwitchMenuFinish();
                } else if (!SelectableTextHelper.this.menuIsHide()) {
                    SelectableTextHelper.this.showOperateMenu();
                }
            } else {
                this.f154029j = SelectableTextHelper.this.f153974c.f154036a;
                this.f154030k = SelectableTextHelper.this.f153974c.f154037b;
                this.f154027h = (int) motionEvent.getX();
                this.f154028i = (int) motionEvent.getY();
                this.D = false;
                SelectableTextHelper.this.f153977f.getLocationOnScreen(this.E);
            }
            return true;
        }

        public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.f154020a.setOnDismissListener(onDismissListener);
        }

        public void setOutsideTouchable(boolean z16) {
            this.f154020a.setOutsideTouchable(z16);
        }

        public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
            this.f154020a.setTouchInterceptor(onTouchListener);
        }

        public void show(int i3, int i16) {
            int i17;
            SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
            boolean z16 = this.f154026g;
            if (z16) {
                i17 = this.f154023d;
            } else {
                i17 = 0;
            }
            if (!z16) {
                int[] a16 = a(i3, i16);
                int i18 = a16[0] + this.f154025f;
                i16 = a16[1];
                i3 = i18;
            }
            try {
                this.f154020a.showAtLocation(SelectableTextHelper.this.f153977f, 0, (i3 - i17) + getExtraX(), i16 + getExtraY());
            } catch (Exception e16) {
                n.b(SelectableTextHelper.TAG, "error! message: %s.", e16.getMessage());
            }
        }

        public void update(int i3, int i16) {
            int i17;
            SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
            if (this.f154026g) {
                i17 = SelectableTextHelper.this.f153974c.f154036a;
            } else {
                i17 = SelectableTextHelper.this.f153974c.f154037b;
            }
            boolean z16 = true;
            int hysteresisOffset = TextLayoutUtil.getHysteresisOffset(SelectableTextHelper.this.f153977f, i3, i16 - this.f154031l[1], i17);
            if (hysteresisOffset != i17) {
                SelectableTextHelper.this.f153985n = 0;
                SelectableTextHelper.this.resetSelectionInfo();
                if (this.f154026g) {
                    if (hysteresisOffset > this.f154030k) {
                        CursorHandle a16 = SelectableTextHelper.this.a(false);
                        a();
                        a16.a();
                        int i18 = this.f154030k;
                        this.f154029j = i18;
                        SelectableTextHelper selectableTextHelper = SelectableTextHelper.this;
                        if (hysteresisOffset - i18 >= 1) {
                            z16 = false;
                        }
                        selectableTextHelper.f153981j = z16;
                        SelectableTextHelper.this.selectText(this.f154030k, hysteresisOffset);
                        a16.c();
                    } else {
                        SelectableTextHelper selectableTextHelper2 = SelectableTextHelper.this;
                        if (selectableTextHelper2.f153974c.f154037b - hysteresisOffset >= 1) {
                            z16 = false;
                        }
                        selectableTextHelper2.f153981j = z16;
                        SelectableTextHelper.this.selectText(hysteresisOffset, -1);
                    }
                    c();
                    return;
                }
                int i19 = this.f154029j;
                if (hysteresisOffset < i19) {
                    CursorHandle a17 = SelectableTextHelper.this.a(true);
                    a17.a();
                    a();
                    int i26 = this.f154029j;
                    this.f154030k = i26;
                    SelectableTextHelper selectableTextHelper3 = SelectableTextHelper.this;
                    if (i26 - hysteresisOffset >= 1) {
                        z16 = false;
                    }
                    selectableTextHelper3.f153981j = z16;
                    SelectableTextHelper.this.selectText(hysteresisOffset, this.f154029j);
                    a17.c();
                } else {
                    SelectableTextHelper selectableTextHelper4 = SelectableTextHelper.this;
                    if (hysteresisOffset - i19 >= 1) {
                        z16 = false;
                    }
                    selectableTextHelper4.f153981j = z16;
                    SelectableTextHelper.this.selectText(this.f154029j, hysteresisOffset);
                }
                c();
            }
        }

        public final void a() {
            this.f154026g = !this.f154026g;
            invalidate();
        }

        public final int[] a(int i3, int i16) {
            int[] iArr = new int[2];
            if (i3 == 0 && SelectableTextHelper.this.f153974c.f154037b > 1) {
                SelectableTextHelper.this.f153977f.getLocationInWindow(this.f154031l);
                TextPaint paint = TextLayoutUtil.getPaint(SelectableTextHelper.this.f153977f);
                if (paint != null) {
                    int i17 = (int) paint.getFontMetrics().descent;
                    int lineWidth = (int) TextLayoutUtil.getLineWidth(SelectableTextHelper.this.f153977f, TextLayoutUtil.getLineForOffset(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154037b - 1));
                    i16 = i17 + TextLayoutUtil.getLineBaseline(SelectableTextHelper.this.f153977f, TextLayoutUtil.getLineForOffset(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153974c.f154037b - 1));
                    i3 = lineWidth;
                }
            }
            iArr[0] = i3;
            iArr[1] = i16;
            return iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ImageSpanInfo {

        /* renamed from: a, reason: collision with root package name */
        public int f154033a;

        /* renamed from: b, reason: collision with root package name */
        public int f154034b;

        public ImageSpanInfo() {
        }

        public boolean a(int i3) {
            if (i3 >= this.f154033a && i3 < this.f154034b) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "start: " + this.f154033a + " end: " + this.f154034b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnSelectListener {
        void onTextSelected(CharSequence charSequence);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnTouchOutsideListener {
        void touchOutside();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class SelectionInfo {

        /* renamed from: a, reason: collision with root package name */
        public int f154036a;

        /* renamed from: b, reason: collision with root package name */
        public int f154037b;

        /* renamed from: c, reason: collision with root package name */
        public String f154038c;

        public SelectionInfo() {
        }
    }

    public SelectableTextHelper(Builder builder) {
        this.f153988q = 0;
        this.O = 0;
        this.f153977f = builder.f154010a;
        this.f153978g = builder.f154011b;
        this.f153982k = builder.f154012c;
        this.f153983l = builder.f154013d;
        this.f153987p = builder.f154014e;
        this.f153988q = builder.f154018i;
        this.O = builder.f154019j;
        this.f153976e = this.f153977f.getContext();
        this.f153991t = builder.f154016g;
        this.f153992u = builder.f154015f;
        this.f153995x = TextLayoutUtil.getLineHeight(this.f153977f);
        if (this.f153993v == 0) {
            this.f153993v = (int) TextLayoutUtil.getTextSize(this.f153977f);
        } else {
            this.f153993v = o.a(this.f153976e, builder.f154017h);
        }
        this.f153997z = new View.OnAttachStateChangeListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                n.a(SelectableTextHelper.TAG, "onViewAttachedToWindow", new Object[0]);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                n.a(SelectableTextHelper.TAG, "onViewDetachedFromWindow", new Object[0]);
                SelectableTextHelper.this.destroy();
            }
        };
        this.B = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (SelectableTextHelper.this.G) {
                    SelectableTextHelper.this.G = false;
                    SelectableTextHelper.this.a(100);
                    return true;
                }
                return true;
            }
        };
        this.A = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.5
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (SelectableTextHelper.this.f153978g != null) {
                    SelectableTextHelper.this.f153977f.removeCallbacks(SelectableTextHelper.this.Q);
                    SelectableTextHelper.this.f153977f.getLocationInWindow(SelectableTextHelper.this.R);
                    if (SelectableTextHelper.this.K) {
                        if (!SelectableTextHelper.this.L && !SelectableTextHelper.this.M) {
                            if (SelectableTextHelper.this.N[1] != SelectableTextHelper.this.R[1]) {
                                SelectableTextHelper.this.L = true;
                                SelectableTextHelper.this.K = false;
                                n.a(SelectableTextHelper.TAG, "judge result, inScrolling.", new Object[0]);
                            } else {
                                SelectableTextHelper.this.M = true;
                                n.a(SelectableTextHelper.TAG, "need delay judge.", new Object[0]);
                            }
                        } else if (SelectableTextHelper.this.M) {
                            SelectableTextHelper.this.M = false;
                            SelectableTextHelper.this.K = false;
                            if (SelectableTextHelper.this.N[1] != SelectableTextHelper.this.R[1]) {
                                SelectableTextHelper.this.L = true;
                                n.a(SelectableTextHelper.TAG, "judge result(delay), inScrolling.", new Object[0]);
                            } else {
                                SelectableTextHelper.this.L = false;
                                n.a(SelectableTextHelper.TAG, "judge result, click outside.", new Object[0]);
                            }
                        }
                    }
                    SelectableTextHelper.this.N[1] = SelectableTextHelper.this.R[1];
                }
                if (!SelectableTextHelper.this.G) {
                    if ((!SelectableTextHelper.this.menuIsHide() || !SelectableTextHelper.this.cursorIsHide()) && !SelectableTextHelper.this.H) {
                        SelectableTextHelper.this.G = true;
                        SelectableTextHelper.this.hideSelectView();
                    }
                }
            }
        };
        this.C = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                OuterMenuAction unused = SelectableTextHelper.this.f153978g;
            }
        };
        this.D = new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SelectableTextHelper.this.f153983l != null) {
                    SelectableTextHelper.this.f153983l.onTouch(view, motionEvent);
                }
                SelectableTextHelper.this.f153989r = (int) motionEvent.getX();
                SelectableTextHelper.this.f153990s = (int) motionEvent.getY();
                return false;
            }
        };
        init();
    }

    public boolean cursorIsHide() {
        return this.J;
    }

    public void destroy() {
        Log.i(TAG, "destroy: " + hashCode() + ", context= " + this.f153977f.getContext() + ", observer= " + this.f153977f.getViewTreeObserver());
        this.E = false;
        this.F = true;
        this.G = false;
        this.f153977f.removeCallbacks(this.P);
        this.f153977f.getViewTreeObserver().removeOnScrollChangedListener(this.A);
        this.f153977f.getViewTreeObserver().removeOnPreDrawListener(this.B);
        this.f153977f.getViewTreeObserver().removeOnGlobalLayoutListener(this.C);
        this.f153977f.removeOnAttachStateChangeListener(this.f153997z);
        setMenuHide(true);
        setCursorHide(true);
        hideSelectView();
        resetSelectionInfo();
        this.f153972a = null;
        this.f153973b = null;
        OuterMenuAction outerMenuAction = this.f153978g;
        if (outerMenuAction != null) {
            outerMenuAction.dismiss();
        }
    }

    public boolean fromSpanMenu() {
        return this.f153980i;
    }

    public OuterMenuAction getOuterMenuAction() {
        return this.f153978g;
    }

    public Pair<Integer, Integer> getSelectedIndex() {
        return new Pair<>(Integer.valueOf(this.f153974c.f154036a), Integer.valueOf(this.f153974c.f154037b));
    }

    public int getSelectedType() {
        return this.f153985n;
    }

    public void hideCursorHandle() {
        CursorHandle cursorHandle = this.f153972a;
        if (cursorHandle != null) {
            cursorHandle.dismiss();
        }
        CursorHandle cursorHandle2 = this.f153973b;
        if (cursorHandle2 != null) {
            cursorHandle2.dismiss();
        }
        this.f153981j = false;
    }

    public void hideOperateMenu() {
        MMPopupMenu mMPopupMenu = this.f153987p;
        if (mMPopupMenu != null) {
            mMPopupMenu.dismiss();
        }
    }

    public void hideOuterMenu() {
        OuterMenuAction outerMenuAction = this.f153978g;
        if (outerMenuAction != null) {
            outerMenuAction.dismiss();
        }
    }

    public void hideSelectView() {
        hideCursorHandle();
        hideOperateMenu();
        OuterMenuAction outerMenuAction = this.f153978g;
        if (outerMenuAction != null) {
            outerMenuAction.dismiss();
        }
        this.f153981j = false;
    }

    public void init() {
        Log.i(TAG, "init: " + hashCode() + ", isDestroyed=" + this.F + ", context= " + this.f153977f.getContext() + ", observer= " + this.f153977f.getViewTreeObserver());
        if (!this.F) {
            n.a(TAG, "not destroy, isReInit: %s.", Boolean.valueOf(this.E));
            this.E = true;
            return;
        }
        n.a(TAG, "not init yet, need to init.", new Object[0]);
        this.E = false;
        this.F = false;
        this.G = false;
        if (this.f153978g == null) {
            View view = this.f153977f;
            TextLayoutUtil.setText(view, TextLayoutUtil.getText(view), TextView.BufferType.SPANNABLE);
        }
        a();
        if (TextLayoutUtil.getText(this.f153977f).length() > 0) {
            this.f153977f.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.8
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    int i3;
                    boolean z16;
                    n.a(SelectableTextHelper.TAG, "onLongClick.", new Object[0]);
                    SelectableTextHelper.this.E = false;
                    if (SelectableTextHelper.this.f153978g != null) {
                        SelectableTextHelper.this.K = true;
                        SelectableTextHelper.this.L = false;
                        SelectableTextHelper.this.M = false;
                        CharSequence text = TextLayoutUtil.getText(SelectableTextHelper.this.f153977f);
                        if (text instanceof SpannableString) {
                            SelectableTextHelper.this.a((SpannableString) text);
                        }
                        SelectableTextHelper.this.hideSelectView();
                        if (SelectableTextHelper.this.f153996y > 0 && SelectableTextHelper.this.f153996y < TextLayoutUtil.getText(SelectableTextHelper.this.f153977f).length()) {
                            SelectableTextHelper.this.f153985n = 0;
                            SelectableTextHelper selectableTextHelper = SelectableTextHelper.this;
                            selectableTextHelper.b(0, selectableTextHelper.f153996y);
                            SelectableTextHelper.this.setMenuHide(false);
                            SelectableTextHelper.this.setCursorHide(false);
                            SelectableTextHelper.this.showOperateMenu();
                            SelectableTextHelper.this.showCursorHandle();
                        } else {
                            int size = SelectableTextHelper.this.f153984m.size();
                            if (size > 0) {
                                int offsetForPosition = TextLayoutUtil.getOffsetForPosition(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153989r, SelectableTextHelper.this.f153990s);
                                for (int i16 = 0; i16 < size; i16++) {
                                    int[] iArr = (int[]) SelectableTextHelper.this.f153984m.get(i16);
                                    n.a(SelectableTextHelper.TAG, "start:%s, end:%s, type:%s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]));
                                    if (offsetForPosition >= iArr[0] && offsetForPosition <= iArr[1]) {
                                        SelectableTextHelper.this.setFromSpanMenu(true);
                                        SelectableTextHelper.this.f153985n = iArr[2];
                                        SelectableTextHelper.this.b(iArr[0], iArr[1]);
                                        SelectableTextHelper.this.f153978g.dismiss();
                                        SelectableTextHelper.this.setMenuHide(false);
                                        SelectableTextHelper.this.setCursorHide(false);
                                        SelectableTextHelper.this.showOperateMenu();
                                        SelectableTextHelper.this.showCursorHandle();
                                        z16 = true;
                                        break;
                                    }
                                }
                            }
                            z16 = false;
                            if (!z16) {
                                SelectableTextHelper.this.f153985n = 1;
                                SelectableTextHelper selectableTextHelper2 = SelectableTextHelper.this;
                                selectableTextHelper2.b(0, TextLayoutUtil.getText(selectableTextHelper2.f153977f).length());
                                SelectableTextHelper.this.setMenuHide(true);
                                SelectableTextHelper.this.setCursorHide(false);
                                SelectableTextHelper.this.showCursorHandle();
                                SelectableTextHelper.this.f153978g.onLongClick(view2);
                            }
                        }
                    } else {
                        SelectableTextHelper.this.K = false;
                        SelectableTextHelper.this.f153985n = 1;
                        if (SelectableTextHelper.this.f153984m.size() > 0) {
                            int offsetForPosition2 = TextLayoutUtil.getOffsetForPosition(SelectableTextHelper.this.f153977f, SelectableTextHelper.this.f153989r, SelectableTextHelper.this.f153990s);
                            int[] iArr2 = (int[]) SelectableTextHelper.this.f153984m.get(0);
                            int i17 = iArr2[0];
                            if (offsetForPosition2 >= i17 && offsetForPosition2 <= (i3 = iArr2[1])) {
                                SelectableTextHelper.this.b(i17, i3);
                            }
                        } else {
                            SelectableTextHelper selectableTextHelper3 = SelectableTextHelper.this;
                            selectableTextHelper3.a(selectableTextHelper3.f153989r, SelectableTextHelper.this.f153990s);
                        }
                        SelectableTextHelper.this.hideSelectView();
                        SelectableTextHelper.this.setMenuHide(false);
                        SelectableTextHelper.this.setCursorHide(false);
                        SelectableTextHelper.this.showOperateMenu();
                        SelectableTextHelper.this.showCursorHandle();
                    }
                    return true;
                }
            });
        }
        this.f153977f.setOnTouchListener(this.D);
        this.f153977f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                n.a(SelectableTextHelper.TAG, NodeProps.ON_CLICK, new Object[0]);
                if (SelectableTextHelper.this.f153982k != null) {
                    SelectableTextHelper.this.f153982k.onClick(view2);
                }
                SelectableTextHelper.this.setMenuHide(true);
                SelectableTextHelper.this.setCursorHide(true);
                SelectableTextHelper.this.hideSelectView();
                SelectableTextHelper.this.resetSelectionInfo();
                if (SelectableTextHelper.this.f153978g != null) {
                    SelectableTextHelper.this.f153978g.dismiss();
                }
            }
        });
        this.f153977f.addOnAttachStateChangeListener(this.f153997z);
        this.f153977f.getViewTreeObserver().addOnPreDrawListener(this.B);
        this.f153977f.getViewTreeObserver().addOnScrollChangedListener(this.A);
        this.f153977f.getViewTreeObserver().addOnGlobalLayoutListener(this.C);
        this.f153977f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.10
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SelectableTextHelper.this.f153977f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (SelectableTextHelper.this.f153978g != null) {
                    SelectableTextHelper.this.f153977f.getLocationInWindow(SelectableTextHelper.this.N);
                }
            }
        });
    }

    public boolean isShouldShowOutMenu() {
        return this.f153979h;
    }

    public boolean menuIsHide() {
        return this.I;
    }

    public void resetSelectedType() {
        this.f153985n = 1;
    }

    public void resetSelectionInfo() {
        a aVar;
        this.f153974c.f154038c = null;
        Spannable spannable = this.f153986o;
        if (spannable != null && (aVar = this.f153994w) != null) {
            spannable.removeSpan(aVar);
            this.f153994w = null;
        }
    }

    public void selectText(int i3, int i16) {
        int i17;
        if (!this.f153981j) {
            if (i3 != -1) {
                this.f153974c.f154036a = a(i3, true);
            }
            if (i16 != -1) {
                this.f153974c.f154037b = a(i16, false);
            }
        } else {
            n.c(TAG, "is illegalSelect! startPos: %s. endPos:%s", Integer.valueOf(i3), Integer.valueOf(i16));
        }
        int i18 = this.f153974c.f154036a;
        if (i18 >= 0 && i18 <= TextLayoutUtil.getText(this.f153977f).length() && (i17 = this.f153974c.f154037b) >= 0 && i17 <= TextLayoutUtil.getText(this.f153977f).length()) {
            SelectionInfo selectionInfo = this.f153974c;
            int i19 = selectionInfo.f154036a;
            int i26 = selectionInfo.f154037b;
            if (i19 > i26) {
                selectionInfo.f154036a = i26;
                selectionInfo.f154037b = i19;
            }
            Spannable spannable = this.f153986o;
            if (spannable != null) {
                selectionInfo.f154038c = spannable.subSequence(selectionInfo.f154036a, selectionInfo.f154037b).toString();
                a aVar = this.f153994w;
                if (aVar != null) {
                    SelectionInfo selectionInfo2 = this.f153974c;
                    aVar.a(selectionInfo2.f154036a, selectionInfo2.f154037b);
                } else {
                    View view = this.f153977f;
                    int color = this.f153976e.getResources().getColor(this.f153991t);
                    SelectionInfo selectionInfo3 = this.f153974c;
                    this.f153994w = new a(view, color, selectionInfo3.f154036a, selectionInfo3.f154037b);
                }
                this.f153986o.setSpan(this.f153994w, TextLayoutUtil.getLineStart(this.f153977f, TextLayoutUtil.getLineForOffset(this.f153977f, this.f153974c.f154036a)), this.f153974c.f154037b, 17);
                OnSelectListener onSelectListener = this.f153975d;
                if (onSelectListener != null) {
                    onSelectListener.onTextSelected(this.f153974c.f154038c);
                }
            }
        }
    }

    public void setAutoSelectEnd(int i3) {
        this.f153996y = i3;
    }

    public void setCursorHide(boolean z16) {
        this.J = z16;
    }

    public void setFromSpanMenu(boolean z16) {
        this.f153980i = z16;
    }

    public void setIgnoreScroll(boolean z16) {
        this.H = z16;
    }

    public void setMenuHide(boolean z16) {
        this.I = z16;
    }

    public void setOnTouchOutsideListener(OnTouchOutsideListener onTouchOutsideListener) {
        this.S = onTouchOutsideListener;
    }

    public void setSelectListener(OnSelectListener onSelectListener) {
        this.f153975d = onSelectListener;
    }

    public void setShouldShowOutMenu(Boolean bool) {
        this.f153979h = bool.booleanValue();
    }

    public void setSpanLocation(ArrayList<int[]> arrayList) {
        this.f153984m.clear();
        this.f153984m.addAll(arrayList);
    }

    public void showCursorHandle() {
        if (!b()) {
            if (this.f153972a == null || this.f153973b == null) {
                a();
            }
            a(this.f153972a);
            a(this.f153973b);
        }
    }

    public void showOperateMenu() {
        if (this.f153987p != null) {
            int[] iArr = new int[2];
            this.f153977f.getLocationInWindow(iArr);
            int i3 = this.f153974c.f154037b;
            int length = TextLayoutUtil.getText(this.f153977f).length();
            if (i3 >= length) {
                i3 = length - 1;
            }
            float primaryHorizontal = TextLayoutUtil.getPrimaryHorizontal(this.f153977f, this.f153974c.f154036a);
            float primaryHorizontal2 = TextLayoutUtil.getPrimaryHorizontal(this.f153977f, i3);
            if (TextLayoutUtil.getLineForOffset(this.f153977f, this.f153974c.f154037b) > TextLayoutUtil.getLineForOffset(this.f153977f, this.f153974c.f154036a) || primaryHorizontal2 <= primaryHorizontal) {
                View view = this.f153977f;
                primaryHorizontal2 = TextLayoutUtil.getLineWidth(view, TextLayoutUtil.getLineForOffset(view, this.f153974c.f154036a));
            }
            if (this.f153988q == 0) {
                this.f153988q = iArr[0] + this.f153977f.getPaddingLeft();
            }
            int i16 = ((int) ((primaryHorizontal + primaryHorizontal2) / 2.0f)) + this.f153988q;
            View view2 = this.f153977f;
            int lineTop = TextLayoutUtil.getLineTop(view2, TextLayoutUtil.getLineForOffset(view2, this.f153974c.f154036a)) + iArr[1] + this.f153976e.getResources().getDimensionPixelSize(R.dimen.caf);
            n.a(TAG, "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", Integer.valueOf(i16), Integer.valueOf(TextLayoutUtil.getLineForOffset(this.f153977f, this.f153974c.f154036a)), Integer.valueOf(TextLayoutUtil.getLineForOffset(this.f153977f, this.f153974c.f154037b)), Integer.valueOf(this.f153988q));
            if (i16 <= 0) {
                i16 = 16;
            }
            if (lineTop < 0) {
                lineTop = 16;
            }
            if (i16 > TextLayoutUtil.getScreenWidth(this.f153976e)) {
                i16 = TextLayoutUtil.getScreenWidth(this.f153976e) - 16;
            }
            int i17 = this.O;
            if (i17 != 0) {
                lineTop += i17;
            }
            this.f153987p.show(i16, lineTop);
        }
        OuterMenuAction outerMenuAction = this.f153978g;
        if (outerMenuAction != null) {
            outerMenuAction.onInnerMenuShow();
        }
    }

    public void showOuterMenu() {
        OuterMenuAction outerMenuAction = this.f153978g;
        if (outerMenuAction != null) {
            outerMenuAction.open(this.f153977f);
        }
    }

    public final void b(int i3, int i16) {
        resetSelectionInfo();
        if (TextLayoutUtil.getText(this.f153977f) instanceof Spannable) {
            this.f153986o = (Spannable) TextLayoutUtil.getText(this.f153977f);
        }
        if (this.f153986o != null && i3 < TextLayoutUtil.getText(this.f153977f).length()) {
            selectText(i3, i16);
            return;
        }
        SelectionInfo selectionInfo = this.f153974c;
        selectionInfo.f154036a = 0;
        selectionInfo.f154037b = 0;
    }

    public final void a() {
        CursorHandle cursorHandle = new CursorHandle(true);
        this.f153972a = cursorHandle;
        if (this.f153978g != null) {
            cursorHandle.setOutsideTouchable(true);
            this.f153972a.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.11
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    n.a(SelectableTextHelper.TAG, "interceptor onTouch. event.getAction():%s", Integer.valueOf(motionEvent.getAction()));
                    int x16 = (int) motionEvent.getX();
                    int y16 = (int) motionEvent.getY();
                    if (motionEvent.getAction() == 0 && (x16 < 0 || x16 >= SelectableTextHelper.this.f153972a.getWidth() || y16 < 0 || y16 >= SelectableTextHelper.this.f153972a.getHeight())) {
                        n.a(SelectableTextHelper.TAG, "interceptor onTouch, down, outside.", new Object[0]);
                        SelectableTextHelper.this.f153977f.postDelayed(SelectableTextHelper.this.Q, 100L);
                        return true;
                    }
                    if (motionEvent.getAction() != 4) {
                        return false;
                    }
                    n.a(SelectableTextHelper.TAG, "interceptor onTouch, outside.", new Object[0]);
                    SelectableTextHelper.this.f153977f.postDelayed(SelectableTextHelper.this.Q, 100L);
                    return true;
                }
            });
            this.f153972a.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mm.ui.widget.textview.SelectableTextHelper.12
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    SelectableTextHelper.this.f153977f.setOnTouchListener(SelectableTextHelper.this.D);
                }
            });
        }
        this.f153973b = new CursorHandle(false);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public View f154010a;

        /* renamed from: b, reason: collision with root package name */
        public OuterMenuAction f154011b;

        /* renamed from: c, reason: collision with root package name */
        public View.OnClickListener f154012c;

        /* renamed from: d, reason: collision with root package name */
        public View.OnTouchListener f154013d;

        /* renamed from: e, reason: collision with root package name */
        public MMPopupMenu f154014e;

        /* renamed from: f, reason: collision with root package name */
        public int f154015f;

        /* renamed from: g, reason: collision with root package name */
        public int f154016g;

        /* renamed from: h, reason: collision with root package name */
        public int f154017h;

        /* renamed from: i, reason: collision with root package name */
        public int f154018i;

        /* renamed from: j, reason: collision with root package name */
        public int f154019j;

        public Builder(View view, MMPopupMenu mMPopupMenu) {
            this.f154015f = R.color.bgb;
            this.f154016g = R.color.cpr;
            this.f154017h = 0;
            this.f154018i = 0;
            this.f154019j = 0;
            this.f154010a = view;
            this.f154014e = mMPopupMenu;
        }

        public SelectableTextHelper build() {
            return new SelectableTextHelper(this);
        }

        public Builder setCursorHandleColor(int i3) {
            this.f154015f = i3;
            return this;
        }

        public Builder setCursorHandleSizeInDp(int i3) {
            this.f154017h = i3;
            return this;
        }

        public Builder setLeftPadding(int i3) {
            n.a(SelectableTextHelper.TAG, "setLeftPadding:%s", Integer.valueOf(i3));
            this.f154018i = i3;
            return this;
        }

        public Builder setMenuAdjustY(int i3) {
            n.a(SelectableTextHelper.TAG, "setMenuAdjustY:%s", Integer.valueOf(i3));
            this.f154019j = i3;
            return this;
        }

        public Builder setSelectedColor(int i3) {
            this.f154016g = i3;
            return this;
        }

        public Builder(View view, MMPopupMenu mMPopupMenu, OuterMenuAction outerMenuAction, View.OnClickListener onClickListener, View.OnTouchListener onTouchListener) {
            this(view, mMPopupMenu);
            this.f154011b = outerMenuAction;
            this.f154012c = onClickListener;
            this.f154013d = onTouchListener;
        }
    }

    public final void a(int i3) {
        this.f153977f.removeCallbacks(this.P);
        if (i3 <= 0) {
            this.P.run();
        } else {
            this.f153977f.postDelayed(this.P, i3);
        }
    }

    public final boolean b() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f153976e.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public final void a(int i3, int i16) {
        int offsetForPosition = TextLayoutUtil.getOffsetForPosition(this.f153977f, i3, i16);
        b(offsetForPosition, offsetForPosition + 1);
    }

    public final void a(CursorHandle cursorHandle) {
        int i3;
        int i16;
        if (cursorHandle == null) {
            return;
        }
        int i17 = cursorHandle.f154026g ? this.f153974c.f154036a : this.f153974c.f154037b;
        SelectionInfo selectionInfo = this.f153974c;
        if (selectionInfo.f154036a != selectionInfo.f154037b && i17 >= 0 && i17 <= TextLayoutUtil.getText(this.f153977f).length()) {
            TextPaint paint = TextLayoutUtil.getPaint(this.f153977f);
            if (paint != null) {
                int i18 = (int) paint.getFontMetrics().descent;
                View view = this.f153977f;
                i3 = TextLayoutUtil.getLineBaseline(view, TextLayoutUtil.getLineForOffset(view, i17)) + i18;
                i16 = (int) TextLayoutUtil.getPrimaryHorizontal(this.f153977f, i17);
            } else {
                i3 = 0;
                i16 = 0;
            }
            cursorHandle.show(i16, i3);
        }
    }

    public final CursorHandle a(boolean z16) {
        if (this.f153972a.f154026g == z16) {
            return this.f153972a;
        }
        return this.f153973b;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class OuterMenuAction {
        public void dismiss() {
        }

        public void onInnerMenuShow() {
        }

        public void onLongClick(View view) {
        }

        public void onSwitchMenu() {
        }

        public void onSwitchMenuFinish() {
        }

        public void open(View view) {
        }
    }

    public final void a(SpannableString spannableString) {
        this.T = new ArrayList();
        int i3 = 0;
        while (i3 < spannableString.length()) {
            int nextSpanTransition = spannableString.nextSpanTransition(i3, spannableString.length(), ImageSpan.class);
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannableString.getSpans(i3, nextSpanTransition, ImageSpan.class);
            if (1 == imageSpanArr.length) {
                ImageSpanInfo imageSpanInfo = new ImageSpanInfo();
                imageSpanInfo.f154033a = i3;
                imageSpanInfo.f154034b = nextSpanTransition;
                this.T.add(imageSpanInfo);
            } else {
                n.b(TAG, "other situation occur! length: %d.", Integer.valueOf(imageSpanArr.length));
            }
            n.a(TAG, "spans from %d to %d.", Integer.valueOf(i3), Integer.valueOf(nextSpanTransition));
            i3 = nextSpanTransition;
        }
        n.a(TAG, this.T.toString(), new Object[0]);
    }

    public final int a(int i3, boolean z16) {
        ArrayList arrayList = this.T;
        if (arrayList == null) {
            return i3;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ImageSpanInfo imageSpanInfo = (ImageSpanInfo) it.next();
            if (imageSpanInfo.a(i3)) {
                if (z16) {
                    return imageSpanInfo.f154033a;
                }
                return imageSpanInfo.f154034b;
            }
        }
        return i3;
    }
}
