package com.tencent.mobileqq.widget.participle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpanWatcher;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes20.dex */
public class ParticipleView extends View implements Handler.Callback {

    /* renamed from: r0, reason: collision with root package name */
    private static final int f317138r0 = 2131104217;

    /* renamed from: s0, reason: collision with root package name */
    private static final int f317139s0 = 2131104267;

    /* renamed from: t0, reason: collision with root package name */
    private static final int f317140t0 = 2131104292;

    /* renamed from: u0, reason: collision with root package name */
    private static final int f317141u0 = 2131104276;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private List<f> I;
    private d J;
    private e K;
    private Point L;
    private Paint M;
    private Paint N;
    private Paint P;
    private int Q;
    private int R;
    private float S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f317147a0;

    /* renamed from: b0, reason: collision with root package name */
    private RectF f317148b0;

    /* renamed from: c0, reason: collision with root package name */
    private RectF f317149c0;

    /* renamed from: d, reason: collision with root package name */
    private int f317150d;

    /* renamed from: d0, reason: collision with root package name */
    private f f317151d0;

    /* renamed from: e, reason: collision with root package name */
    private int f317152e;

    /* renamed from: e0, reason: collision with root package name */
    private float f317153e0;

    /* renamed from: f, reason: collision with root package name */
    private int f317154f;

    /* renamed from: f0, reason: collision with root package name */
    private float f317155f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f317156g0;

    /* renamed from: h, reason: collision with root package name */
    private int f317157h;

    /* renamed from: h0, reason: collision with root package name */
    private byte f317158h0;

    /* renamed from: i, reason: collision with root package name */
    private int f317159i;

    /* renamed from: i0, reason: collision with root package name */
    private g f317160i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f317161j0;

    /* renamed from: k0, reason: collision with root package name */
    private ScrollView f317162k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f317163l0;

    /* renamed from: m, reason: collision with root package name */
    private int f317164m;

    /* renamed from: m0, reason: collision with root package name */
    private ValueAnimator f317165m0;

    /* renamed from: n0, reason: collision with root package name */
    private final List<f> f317166n0;

    /* renamed from: o0, reason: collision with root package name */
    private final Handler f317167o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f317168p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f317169q0;

    /* renamed from: v0, reason: collision with root package name */
    private static final int f317142v0 = Color.parseColor("#00CAFC");

    /* renamed from: w0, reason: collision with root package name */
    private static final int f317143w0 = Color.parseColor("#FFFFFF");

    /* renamed from: x0, reason: collision with root package name */
    private static final int f317144x0 = Color.parseColor("#FFFFFF");

    /* renamed from: y0, reason: collision with root package name */
    private static final int f317145y0 = Color.parseColor("#03081A");

    /* renamed from: z0, reason: collision with root package name */
    private static final int f317146z0 = Color.parseColor("#0066CC");
    private static final int A0 = Color.parseColor("#1A1A1A");
    private static final int B0 = Color.parseColor("#FFFFFF");
    private static final int C0 = Color.parseColor("#999999");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = ParticipleView.this.f317166n0.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                f fVar = (f) it.next();
                float min = Math.min(((float) (currentTimeMillis - fVar.f317178f)) / ParticipleView.this.H, 1.0f);
                fVar.f317177e = min;
                if (min < 1.0f) {
                    z16 = false;
                } else {
                    it.remove();
                }
            }
            if (z16) {
                ParticipleView.this.f317165m0.cancel();
                ParticipleView.this.f317165m0 = null;
                ParticipleView.this.f317166n0.clear();
                if (QLog.isColorLevel()) {
                    QLog.d("ParticipleView", 2, "selectedAnimation end cancel");
                }
            }
            ParticipleView.this.invalidate();
        }
    }

    /* loaded from: classes20.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ParticipleView.this.S = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ParticipleView.this.invalidate();
        }
    }

    /* loaded from: classes20.dex */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ParticipleView.this.S = 1.0f;
            ParticipleView.this.invalidate();
        }
    }

    /* loaded from: classes20.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes20.dex */
    public interface e {
        void onThemeChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class f {

        /* renamed from: c, reason: collision with root package name */
        QQText f317175c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f317176d;

        /* renamed from: f, reason: collision with root package name */
        private long f317178f;

        /* renamed from: a, reason: collision with root package name */
        private List<RectF> f317173a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private List<QQText> f317174b = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private float f317177e = 0.0f;

        f(QQText qQText) {
            this.f317175c = qQText;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(RectF rectF, QQText qQText) {
            boolean z16;
            if (this.f317173a.size() > 0) {
                Iterator<RectF> it = this.f317173a.iterator();
                while (it.hasNext()) {
                    if (rectF.equals(it.next())) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                this.f317173a.add(rectF);
                this.f317174b.add(qQText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class g extends ExploreByTouchHelper {

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f317179e;

        g(View view) {
            super(view);
            this.f317179e = new WeakReference<>(view);
        }

        private String a(String str, boolean z16) {
            if (z16) {
                return HardCodeUtil.qqStr(R.string.f213625qp) + str;
            }
            return HardCodeUtil.qqStr(R.string.f213635qq) + str;
        }

        private f b(int i3) {
            View view = this.f317179e.get();
            if (view instanceof ParticipleView) {
                List list = ((ParticipleView) view).I;
                if (i3 < list.size()) {
                    return (f) list.get(i3);
                }
                return null;
            }
            return null;
        }

        private void c(String str) {
            ViewParent parent;
            View view = this.f317179e.get();
            if (view != null && (parent = view.getParent()) != null) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
                obtain.setEnabled(true);
                obtain.setClassName(view.getClass().getName());
                obtain.setContentDescription(str);
                parent.requestSendAccessibilityEvent(view, obtain);
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            int C;
            View view = this.f317179e.get();
            if ((view instanceof ParticipleView) && (C = ((ParticipleView) view).C(f16, f17)) >= 0) {
                return C;
            }
            return Integer.MIN_VALUE;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            View view = this.f317179e.get();
            if (view instanceof ParticipleView) {
                int size = ((ParticipleView) view).I.size();
                for (int i3 = 0; i3 < size; i3++) {
                    list.add(Integer.valueOf(i3));
                }
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (i16 == 16) {
                View view = this.f317179e.get();
                if (view instanceof ParticipleView) {
                    f b16 = b(i3);
                    if (b16 != null) {
                        ParticipleView participleView = (ParticipleView) view;
                        participleView.f317151d0 = b16;
                        participleView.J();
                        c(a(b16.f317175c.toPlainText(4), b16.f317176d));
                    }
                    g gVar = ((ParticipleView) view).f317160i0;
                    if (gVar != null) {
                        gVar.invalidateVirtualView(i3);
                        gVar.sendEventForVirtualView(i3, 1);
                    }
                }
                return true;
            }
            return false;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            View view = this.f317179e.get();
            if (view instanceof ParticipleView) {
                List list = ((ParticipleView) view).I;
                if (i3 < list.size()) {
                    f fVar = (f) list.get(i3);
                    accessibilityEvent.setContentDescription(a(fVar.f317175c.toPlainText(4), fVar.f317176d));
                }
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            View view = this.f317179e.get();
            if (view instanceof ParticipleView) {
                List list = ((ParticipleView) view).I;
                if (i3 < list.size() && i3 != Integer.MIN_VALUE) {
                    f fVar = (f) list.get(i3);
                    if (fVar.f317173a.size() > 0) {
                        String a16 = a(fVar.f317175c.toPlainText(4), fVar.f317176d);
                        RectF rectF = (RectF) fVar.f317173a.get(0);
                        accessibilityNodeInfoCompat.setContentDescription(a16);
                        accessibilityNodeInfoCompat.addAction(16);
                        accessibilityNodeInfoCompat.setBoundsInParent(new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
                    }
                }
            }
        }
    }

    public ParticipleView(Context context) {
        super(context);
        this.I = new ArrayList();
        this.L = new Point(0, 0);
        this.Q = 0;
        this.S = 0.0f;
        this.T = 0;
        this.U = 0;
        this.W = false;
        this.f317147a0 = false;
        this.f317158h0 = (byte) 0;
        this.f317166n0 = new ArrayList();
        this.f317167o0 = new WeakReferenceHandler(ThreadManager.getUIHandler().getLooper(), this);
        this.f317168p0 = false;
        this.f317169q0 = true;
        D(context, null);
    }

    private int A(QQText qQText) {
        int i3 = qQText.mSpanCount;
        String qQText2 = qQText.toString();
        if (i3 > 0) {
            int[] spanData = qQText.getSpanData();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < i3; i19++) {
                if (i16 > 0) {
                    i18 = i16;
                }
                int i26 = i19 * 3;
                int i27 = spanData[i26];
                i16 = spanData[i26 + 1];
                if (i27 > i18) {
                    i17 = (int) (i17 + this.M.measureText(qQText2.substring(i18, i27)));
                }
                i17 += this.f317150d;
            }
            if (i16 < qQText2.length()) {
                return (int) (i17 + this.M.measureText(qQText2.substring(i16)));
            }
            return i17;
        }
        return (int) this.M.measureText(qQText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C(float f16, float f17) {
        List<f> list = this.I;
        if (list != null && list.size() > 0) {
            int size = this.I.size();
            for (int i3 = 0; i3 < size; i3++) {
                Iterator it = this.I.get(i3).f317173a.iterator();
                while (it.hasNext()) {
                    if (((RectF) it.next()).contains(f16, f17)) {
                        return i3;
                    }
                }
            }
            return -1;
        }
        return -1;
    }

    private void D(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.S4);
            this.C = obtainStyledAttributes.getColor(jj2.b.f410012c5, f317142v0);
            this.D = obtainStyledAttributes.getColor(jj2.b.f410024d5, f317143w0);
            this.f317164m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.W4, x.c(getContext(), 3.0f));
            this.E = obtainStyledAttributes.getColor(jj2.b.X4, f317144x0);
            this.F = obtainStyledAttributes.getColor(jj2.b.f410000b5, f317145y0);
            if (QQTheme.isNowThemeIsNight()) {
                this.C = f317146z0;
                this.D = A0;
                this.E = B0;
                this.F = C0;
            }
            if (obtainStyledAttributes.getBoolean(jj2.b.f410036e5, false)) {
                this.C = getResources().getColor(f317138r0);
                this.D = getResources().getColor(f317139s0);
                this.F = getResources().getColor(f317140t0);
                this.E = getResources().getColor(f317141u0);
            }
            this.f317150d = obtainStyledAttributes.getDimensionPixelSize(jj2.b.Z4, x.c(getContext(), 27.0f));
            this.f317152e = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f409988a5, x.c(getContext(), 4.0f));
            this.f317154f = obtainStyledAttributes.getDimensionPixelSize(jj2.b.Y4, x.c(getContext(), 6.0f));
            this.f317157h = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410048f5, x.c(getContext(), 12.0f));
            this.f317159i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.V4, x.c(getContext(), 8.0f));
            this.G = obtainStyledAttributes.getInteger(jj2.b.T4, 200);
            this.H = obtainStyledAttributes.getInteger(jj2.b.U4, 200);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.M = paint;
        paint.setTextSize(this.f317150d);
        Paint paint2 = new Paint(1);
        this.N = paint2;
        paint2.setColor(this.D);
        Paint paint3 = new Paint(1);
        this.P = paint3;
        paint3.setColor(this.C);
        g gVar = new g(this);
        this.f317160i0 = gVar;
        ViewCompat.setAccessibilityDelegate(this, gVar);
        this.f317161j0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void E(Object obj, QQText qQText) {
        int spanStart = qQText.getSpanStart(obj);
        int spanEnd = qQText.getSpanEnd(obj);
        SpanWatcher[] spanWatcherArr = (SpanWatcher[]) qQText.getSpans(spanStart, spanEnd, SpanWatcher.class);
        if (spanWatcherArr != null && spanWatcherArr.length > 0) {
            for (SpanWatcher spanWatcher : spanWatcherArr) {
                try {
                    spanWatcher.onSpanChanged(qQText, obj, spanStart, spanEnd, spanStart, spanEnd);
                } catch (Exception e16) {
                    QLog.e("ParticipleView", 1, "Exception: " + e16.getMessage());
                }
            }
        }
    }

    private void F(Message message, QQText qQText, IEmoticonSpanRefreshCallback[] iEmoticonSpanRefreshCallbackArr) {
        if (iEmoticonSpanRefreshCallbackArr != null && iEmoticonSpanRefreshCallbackArr.length > 0) {
            this.f317168p0 = true;
            for (IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback : iEmoticonSpanRefreshCallbackArr) {
                if (iEmoticonSpanRefreshCallback.getDrawable() == message.obj) {
                    E(iEmoticonSpanRefreshCallback, qQText);
                }
            }
            this.f317168p0 = false;
        }
    }

    private boolean G(RectF rectF, RectF rectF2) {
        float f16 = rectF.top;
        float f17 = rectF2.top;
        if (f16 >= f17 && (f16 != f17 || rectF.left >= rectF2.left)) {
            return false;
        }
        return true;
    }

    private boolean H(f fVar) {
        boolean z16;
        if (this.W && !fVar.f317173a.isEmpty()) {
            y(this);
            if (this.f317162k0 != null) {
                Iterator it = fVar.f317173a.iterator();
                do {
                    z16 = false;
                    if (!it.hasNext()) {
                        return false;
                    }
                    int i3 = (int) ((RectF) it.next()).top;
                    if (((this.f317150d + i3) + (this.f317152e * 2)) - this.f317162k0.getScrollY() > 0 && i3 - this.f317162k0.getScrollY() < this.f317162k0.getHeight()) {
                        z16 = true;
                    }
                } while (!z16);
                return true;
            }
        }
        return true;
    }

    private void I() {
        ReportController.o(null, "dc00898", "", "", "0X800A359", "0X800A359", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        N();
        f fVar = this.f317151d0;
        if (fVar != null && fVar.f317176d) {
            ReportController.o(null, "dc00898", "", "", "0X800A358", "0X800A358", 0, 0, "", "", "", "");
        }
    }

    private void K() {
        N();
    }

    private void N() {
        f fVar = this.f317151d0;
        if (fVar != null) {
            this.f317147a0 = fVar.f317176d;
            if (this.f317151d0.f317176d) {
                this.f317151d0.f317176d = false;
                this.V = false;
                invalidate();
            } else {
                this.f317151d0.f317176d = true;
                this.V = true;
                this.f317151d0.f317178f = System.currentTimeMillis();
                P(this.f317151d0);
            }
            d dVar = this.J;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private void O(RectF rectF, RectF rectF2) {
        List<f> list;
        RectF rectF3;
        RectF rectF4;
        int i3;
        RectF rectF5;
        RectF rectF6;
        RectF rectF7;
        RectF rectF8;
        boolean z16;
        RectF rectF9;
        RectF rectF10;
        if (rectF != null && rectF2 != null && rectF != rectF2 && (list = this.I) != null && list.size() > 0) {
            boolean z17 = true;
            if (G(rectF, rectF2)) {
                rectF4 = rectF;
                rectF3 = rectF2;
                i3 = 2;
            } else {
                rectF3 = rectF;
                rectF4 = rectF2;
                i3 = 1;
            }
            if (G(rectF4, this.f317149c0) && G(this.f317149c0, rectF3)) {
                if (i3 == 2) {
                    rectF10 = this.f317149c0;
                    rectF9 = rectF3;
                    rectF3 = rectF10;
                } else {
                    rectF9 = this.f317149c0;
                    rectF10 = rectF4;
                    rectF4 = rectF9;
                }
                this.V = this.f317151d0.f317176d;
                rectF7 = rectF10;
                rectF5 = rectF4;
                rectF8 = rectF9;
                rectF6 = rectF3;
            } else {
                if (rectF.equals(this.f317149c0)) {
                    this.V = this.f317151d0.f317176d;
                } else {
                    int i16 = this.U;
                    if (i16 != 0 && i16 != i3) {
                        this.V = !this.V;
                    }
                }
                rectF5 = null;
                rectF6 = null;
                rectF7 = rectF4;
                rectF8 = rectF3;
            }
            this.U = i3;
            if (rectF2.equals(this.f317149c0)) {
                if (i3 == 1) {
                    z17 = false;
                }
                z16 = z17;
            } else {
                z16 = !G(this.f317149c0, rectF2);
            }
            t(rectF5, rectF6, rectF7, rectF8, z16);
        }
    }

    private void P(f fVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(fVar);
        Q(arrayList);
    }

    private void Q(List<f> list) {
        this.f317166n0.addAll(list);
        if (this.f317165m0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ParticipleView", 2, "selectedAnimation create");
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f317165m0 = ofFloat;
            ofFloat.setDuration(this.H);
            this.f317165m0.setRepeatCount(-1);
            this.f317165m0.addUpdateListener(new a());
            this.f317165m0.start();
        }
    }

    private void l(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I.add(new f(new QQText(str, 5)));
        }
    }

    private void m(int i3, int i16, QQText qQText, f fVar, Canvas canvas) {
        int width;
        boolean z16;
        int A = A(qQText);
        if (getWidth() <= 0) {
            width = this.R;
        } else {
            width = getWidth();
        }
        int i17 = A + i3;
        if ((this.f317154f * 2) + i17 + getPaddingRight() > width) {
            if (getPaddingLeft() + getPaddingRight() + A + (this.f317154f * 2) <= width) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                q(getPaddingLeft(), this.f317150d + i16 + this.f317157h + (this.f317152e * 2), qQText, fVar, canvas);
                this.L.x = getPaddingLeft() + A + (this.f317154f * 2) + this.f317159i;
                this.L.y = i16 + this.f317150d + this.f317157h + (this.f317152e * 2);
                return;
            }
            v(i3, i16, qQText, fVar, canvas);
            return;
        }
        q(i3, i16, qQText, fVar, canvas);
        this.L.x = i17 + this.f317159i + (this.f317154f * 2);
    }

    private int n() {
        w(null);
        return this.Q;
    }

    private void o(MotionEvent motionEvent) {
        RectF rectF;
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        List<f> list = this.I;
        if (list != null && list.size() > 0) {
            int size = this.I.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.I.get(i3);
                Iterator it = fVar.f317173a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        RectF rectF2 = (RectF) it.next();
                        if (rectF2.contains(x16, y16)) {
                            rectF = rectF2;
                        } else {
                            rectF = null;
                        }
                        if (rectF != null) {
                            if (motionEvent.getAction() == 0) {
                                this.f317148b0 = rectF2;
                                this.f317149c0 = rectF2;
                                this.f317151d0 = fVar;
                            } else if (motionEvent.getAction() == 2) {
                                if (this.f317151d0 == null) {
                                    this.f317148b0 = rectF2;
                                    this.f317149c0 = rectF2;
                                    this.f317151d0 = fVar;
                                    N();
                                } else if (!rectF.equals(this.f317148b0)) {
                                    O(this.f317148b0, rectF);
                                    this.f317148b0 = rectF;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean p(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ('\u4e00' <= charAt && charAt < '\u9fa5') {
                return true;
            }
        }
        return false;
    }

    private void q(int i3, int i16, QQText qQText, f fVar, Canvas canvas) {
        RectF rectF = new RectF(i3, i16, A(qQText) + (this.f317154f * 2) + i3, this.f317150d + i16 + (this.f317152e * 2));
        fVar.j(rectF, qQText);
        r(rectF, qQText, fVar, canvas);
    }

    private void r(RectF rectF, QQText qQText, f fVar, Canvas canvas) {
        float f16;
        float f17;
        int i3;
        int i16 = (int) rectF.bottom;
        int i17 = (int) rectF.left;
        int i18 = (int) rectF.top;
        int i19 = (int) rectF.right;
        if (canvas != null) {
            int i26 = (i19 - i17) - (this.f317154f * 2);
            if (fVar.f317176d) {
                if (fVar.f317177e >= 0.0f) {
                    f16 = fVar.f317177e;
                } else {
                    f16 = 0.0f;
                }
                f17 = 1.0f;
            } else {
                float f18 = this.S;
                if (f18 >= 0.0f) {
                    f17 = f18;
                    f16 = 0.0f;
                } else {
                    f16 = 0.0f;
                    f17 = 0.0f;
                }
            }
            if (f16 < 1.0f) {
                RectF rectF2 = new RectF(i17, i18, (int) ((((this.f317154f * 2) + i26) * f17) + r7), i16);
                int i27 = this.f317164m;
                canvas.drawRoundRect(rectF2, i27, i27, this.N);
            }
            if (f16 > 0.0f) {
                if (this.T == 4) {
                    RectF rectF3 = new RectF(i17, i18, (int) (((i26 + (this.f317154f * 2)) * f16) + r4), i16);
                    int i28 = this.f317164m;
                    canvas.drawRoundRect(rectF3, i28, i28, this.P);
                } else {
                    RectF rectF4 = new RectF((int) (i17 + (((this.f317154f * 2) + i26) * (1.0f - f16))), i18, i26 + i17 + (this.f317154f * 2), i16);
                    int i29 = this.f317164m;
                    canvas.drawRoundRect(rectF4, i29, i29, this.P);
                }
            }
            Paint paint = this.M;
            if (fVar.f317176d) {
                i3 = this.E;
            } else {
                i3 = this.F;
            }
            paint.setColor(i3);
            x(qQText, canvas, i17 + this.f317154f, i18);
        }
        this.Q = i16;
    }

    private void s(List<f> list) {
        if (list.size() > 0) {
            Q(list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ParticipleView", 2, "doAnimationAfterSelectAmong invalidate()");
        }
        invalidate();
    }

    private void t(RectF rectF, RectF rectF2, RectF rectF3, RectF rectF4, boolean z16) {
        ArrayList arrayList = new ArrayList();
        int size = this.I.size();
        for (int i3 = 0; i3 < size; i3++) {
            f fVar = this.I.get(i3);
            for (RectF rectF5 : fVar.f317173a) {
                if (rectF != null && rectF2 != null && !rectF5.equals(rectF3) && !rectF5.equals(rectF4) && ((G(rectF, rectF5) && G(rectF5, rectF2)) || rectF5.equals(rectF2) || rectF5.equals(rectF))) {
                    if (!this.f317147a0) {
                        fVar.f317176d = !this.V;
                    } else if (fVar.f317176d) {
                        fVar.f317176d = false;
                    }
                } else {
                    float f16 = rectF3.top;
                    float f17 = rectF5.top;
                    if (f16 >= f17) {
                        if (f16 == f17) {
                            float f18 = rectF3.left;
                            float f19 = rectF5.left;
                            if (z16) {
                                if (f18 <= f19) {
                                }
                            } else if (f18 < f19) {
                            }
                        }
                    }
                    float f26 = rectF4.top;
                    if (f17 >= f26) {
                        if (f17 == f26) {
                            float f27 = rectF5.left;
                            float f28 = rectF4.left;
                            if (z16) {
                                if (f27 < f28) {
                                }
                            } else if (f27 <= f28) {
                            }
                        }
                    }
                    if (this.f317147a0) {
                        if (fVar.f317176d) {
                            fVar.f317176d = false;
                        }
                    } else if (this.V) {
                        if (!fVar.f317176d) {
                            fVar.f317176d = true;
                            fVar.f317178f = System.currentTimeMillis();
                            arrayList.add(fVar);
                        }
                    } else if (fVar.f317176d) {
                        fVar.f317176d = false;
                    }
                }
            }
        }
        s(arrayList);
        d dVar = this.J;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void u(Canvas canvas, f fVar) {
        if (fVar.f317173a.isEmpty()) {
            Point point = this.L;
            m(point.x, point.y, fVar.f317175c, fVar, canvas);
            return;
        }
        int size = fVar.f317173a.size();
        for (int i3 = 0; i3 < size; i3++) {
            RectF rectF = (RectF) fVar.f317173a.get(i3);
            r(rectF, (QQText) fVar.f317174b.get(i3), fVar, canvas);
            Point point2 = this.L;
            point2.x = ((int) rectF.right) + this.f317159i;
            point2.y = (int) rectF.top;
        }
    }

    private void v(int i3, int i16, QQText qQText, f fVar, Canvas canvas) {
        int width;
        int i17;
        int i18;
        boolean z16;
        String substring;
        int i19;
        if (getWidth() <= 0) {
            width = this.R;
        } else {
            width = getWidth();
        }
        int i26 = qQText.mSpanCount;
        int[] spanData = qQText.getSpanData();
        int i27 = 1;
        if (i26 > 0) {
            i17 = spanData[0];
            i18 = spanData[1];
        } else {
            i17 = 0;
            i18 = 0;
        }
        String qQText2 = qQText.toString();
        int length = qQText2.length();
        int i28 = 0;
        int i29 = 0;
        while (true) {
            if (i28 < length) {
                if (i26 > 0 && i29 < i26 && i17 == i28) {
                    substring = qQText2.substring(0, i18);
                    i19 = i18 - 1;
                    i29++;
                    if (i29 < i26) {
                        int i36 = i29 * 3;
                        int i37 = spanData[i36];
                        i18 = spanData[i36 + i27];
                        i17 = i37;
                    }
                } else {
                    substring = qQText2.substring(0, i28 + 1);
                    i19 = i28;
                }
                if (A(new QQText(substring, 5)) + i3 + (this.f317154f * 2) + getPaddingRight() > width) {
                    this.L.x = getPaddingLeft();
                    Point point = this.L;
                    int i38 = (this.f317152e * 2) + i16 + this.f317150d + this.f317157h;
                    point.y = i38;
                    if (i28 <= 0) {
                        m(point.x, i38, qQText, fVar, canvas);
                    } else {
                        q(i3, i16, new QQText(qQText2.substring(0, i28), 5), fVar, canvas);
                        String substring2 = qQText2.substring(i28, length);
                        Point point2 = this.L;
                        m(point2.x, point2.y, new QQText(substring2, 5), fVar, canvas);
                    }
                    z16 = true;
                } else {
                    i27 = 1;
                    i28 = i19 + 1;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            m(i3, i16, qQText, fVar, canvas);
        }
    }

    private void w(Canvas canvas) {
        this.L.x = getPaddingLeft();
        this.L.y = getPaddingTop();
        List<f> list = this.I;
        if (list != null && list.size() > 0) {
            int size = this.I.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.I.get(i3);
                if (canvas == null || H(fVar)) {
                    u(canvas, fVar);
                }
            }
        }
    }

    private void x(QQText qQText, Canvas canvas, int i3, int i16) {
        Drawable drawable;
        String qQText2 = qQText.toString();
        if (qQText.mSpanCount > 0) {
            int[] spanData = qQText.getSpanData();
            Object[] objArr = qQText.mSpans;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < qQText.mSpanCount; i19++) {
                if (i17 > 0) {
                    i18 = i17;
                }
                int i26 = i19 * 3;
                int i27 = spanData[i26];
                i17 = spanData[i26 + 1];
                if (i27 > i18) {
                    String substring = qQText2.substring(i18, i27);
                    float f16 = i3;
                    canvas.drawText(substring, f16, this.f317150d + i16, this.M);
                    i3 = (int) (f16 + this.M.measureText(substring));
                }
                Object obj = objArr[i19];
                if ((obj instanceof IEmoticonSpanRefreshCallback) && (drawable = ((IEmoticonSpanRefreshCallback) obj).getDrawable()) != null) {
                    drawable.setCallback(this);
                    int i28 = this.f317152e;
                    int i29 = this.f317150d;
                    drawable.setBounds(i3, i16 + i28, i3 + i29, i28 + i16 + i29);
                    drawable.draw(canvas);
                    i3 += this.f317150d;
                }
            }
            if (i17 < qQText2.length()) {
                canvas.drawText(qQText2.substring(i17), i3, i16 + this.f317150d, this.M);
                return;
            }
            return;
        }
        canvas.drawText(qQText2, i3, i16 + this.f317152e + (this.f317150d / 2.0f) + z(this.M), this.M);
    }

    private void y(View view) {
        if (this.f317162k0 == null && view != null) {
            View view2 = (View) view.getParent();
            if (view2 instanceof ScrollView) {
                this.f317162k0 = (ScrollView) view2;
            } else {
                y(view2);
            }
        }
    }

    private static float z(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = fontMetrics.descent;
        return ((f16 - fontMetrics.ascent) / 2.0f) - f16;
    }

    public String B() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        List<f> list = this.I;
        if (list != null && list.size() > 0) {
            int size = this.I.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.I.get(i3);
                if (fVar.f317176d) {
                    String qQText = fVar.f317175c.toString();
                    boolean p16 = p(qQText);
                    if (this.f317169q0 && sb5.length() > 0 && ((z16 = this.f317163l0) != p16 || !z16)) {
                        sb5.append(" ");
                    }
                    this.f317163l0 = p(qQText);
                    sb5.append(qQText);
                }
            }
        }
        return sb5.toString();
    }

    public void L() {
        this.C = getResources().getColor(f317138r0);
        this.D = getResources().getColor(f317139s0);
        this.F = getResources().getColor(f317140t0);
        this.E = getResources().getColor(f317141u0);
        e eVar = this.K;
        if (eVar != null) {
            eVar.onThemeChanged();
        }
        invalidate();
    }

    public void M() {
        if (QLog.isColorLevel()) {
            QLog.d("ParticipleView", 2, "resetState invalidate()");
        }
        List<f> list = this.I;
        if (list != null && list.size() > 0) {
            int size = this.I.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.I.get(i3).f317176d = false;
                y(this);
                ScrollView scrollView = this.f317162k0;
                if (scrollView != null) {
                    scrollView.scrollTo(0, 0);
                }
            }
        }
        invalidate();
    }

    public void R() {
        if (QLog.isColorLevel()) {
            QLog.d("ParticipleView", 2, "translateAppearAnimation invalidate()");
        }
        setAlpha(0.0f);
        setVisibility(0);
        this.S = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(this.G);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new b());
        ofFloat2.setDuration(this.H);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new c());
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.start();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        g gVar;
        if (QQUIAppSetting.enableTalkBack() && (gVar = this.f317160i0) != null && gVar.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        Iterator<f> it = this.f317166n0.iterator();
        while (it.hasNext()) {
            for (QQText qQText : it.next().f317174b) {
                F(message, qQText, (IEmoticonSpanRefreshCallback[]) qQText.getSpans(0, qQText.length(), IEmoticonSpanRefreshCallback.class));
            }
        }
        return true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        Message obtainMessage = this.f317167o0.obtainMessage(1);
        obtainMessage.obj = drawable;
        if (this.f317167o0.hasMessages(1)) {
            return;
        }
        this.f317167o0.removeMessages(1);
        this.f317167o0.sendMessageDelayed(obtainMessage, 100L);
    }

    public void k(boolean z16) {
        this.f317169q0 = z16;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int n3;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i3);
        this.R = defaultSize;
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i16);
        if (View.MeasureSpec.getMode(i16) == 1073741824) {
            n3 = View.MeasureSpec.getSize(i16);
        } else {
            n3 = n();
        }
        if (n3 > 0) {
            defaultSize2 = n3;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0 != 3) goto L42;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                int i3 = 3;
                if (action == 2) {
                    float x16 = (int) motionEvent.getX();
                    float y16 = (int) motionEvent.getY();
                    if (this.f317158h0 == 0) {
                        float abs = Math.abs(x16 - this.f317153e0);
                        float abs2 = Math.abs(y16 - this.f317155f0);
                        int i16 = this.f317161j0;
                        if (abs > i16 || abs2 > i16) {
                            if (abs2 > abs) {
                                this.f317158h0 = (byte) 2;
                            } else {
                                this.f317158h0 = (byte) 1;
                                I();
                                N();
                                if (x16 - this.f317153e0 > 0.0f) {
                                    i3 = 4;
                                }
                                this.T = i3;
                            }
                        }
                    }
                    if (this.f317158h0 == 0) {
                        return true;
                    }
                    this.W = true;
                    ViewParent parent = getParent();
                    if (this.f317158h0 == 1) {
                        z16 = true;
                    }
                    parent.requestDisallowInterceptTouchEvent(z16);
                    if (this.f317158h0 == 1) {
                        o(motionEvent);
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            if (!this.W) {
                if (System.currentTimeMillis() - this.f317156g0 >= 500) {
                    K();
                } else {
                    J();
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f317158h0 = (byte) 0;
            this.f317148b0 = null;
            this.f317149c0 = null;
            this.f317151d0 = null;
            this.U = 0;
            this.W = false;
            if (QLog.isColorLevel()) {
                QLog.d("ParticipleView", 2, "ACTION_UP invalidate()");
            }
            invalidate();
            return super.onTouchEvent(motionEvent);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f317158h0 = (byte) 0;
        this.f317156g0 = System.currentTimeMillis();
        this.W = false;
        this.f317153e0 = motionEvent.getX();
        this.f317155f0 = motionEvent.getY();
        if (QLog.isColorLevel()) {
            QLog.d("ParticipleView", 2, "onTouchEvent ACTION_DOWN  downX -> " + this.f317153e0 + ", downY -> " + this.f317155f0);
        }
        o(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.f317168p0) {
            super.requestLayout();
        }
    }

    public void setOnParticipleSelectChangeListener(d dVar) {
        this.J = dVar;
    }

    public void setOnThemeChangedListener(e eVar) {
        this.K = eVar;
    }

    public void setParticipleItems(List<String> list) {
        boolean z16 = false;
        if (list != null && list.size() == this.I.size()) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (!TextUtils.equals(list.get(i3), this.I.get(i3).f317175c.toString())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            if (list != null && list.size() > 0) {
                this.I.clear();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    l(it.next());
                }
                return;
            }
            return;
        }
        M();
    }

    public void setTextColor(int i3) {
        this.M.setColor(i3);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    public ParticipleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = new ArrayList();
        this.L = new Point(0, 0);
        this.Q = 0;
        this.S = 0.0f;
        this.T = 0;
        this.U = 0;
        this.W = false;
        this.f317147a0 = false;
        this.f317158h0 = (byte) 0;
        this.f317166n0 = new ArrayList();
        this.f317167o0 = new WeakReferenceHandler(ThreadManager.getUIHandler().getLooper(), this);
        this.f317168p0 = false;
        this.f317169q0 = true;
        D(context, attributeSet);
    }

    public ParticipleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = new ArrayList();
        this.L = new Point(0, 0);
        this.Q = 0;
        this.S = 0.0f;
        this.T = 0;
        this.U = 0;
        this.W = false;
        this.f317147a0 = false;
        this.f317158h0 = (byte) 0;
        this.f317166n0 = new ArrayList();
        this.f317167o0 = new WeakReferenceHandler(ThreadManager.getUIHandler().getLooper(), this);
        this.f317168p0 = false;
        this.f317169q0 = true;
        D(context, attributeSet);
    }
}
