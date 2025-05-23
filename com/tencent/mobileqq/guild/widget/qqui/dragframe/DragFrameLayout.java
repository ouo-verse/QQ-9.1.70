package com.tencent.mobileqq.guild.widget.qqui.dragframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class DragFrameLayout extends FrameLayout implements com.tencent.mobileqq.guild.widget.qqui.dragframe.b, com.tencent.mobileqq.guild.widget.qqui.dragframe.a {
    private static final int[] T = {R.drawable.dgs, R.drawable.dgt, R.drawable.dgu, R.drawable.dgv, R.drawable.dgw};
    private int C;
    private View D;
    private int E;
    private String F;
    private a G;
    private HashMap<String, List<a>> H;
    private Paint I;
    private ShakeRunner J;
    private BornRunner K;
    private AllBornRunner L;
    private Rect M;
    private int N;
    private PointF P;
    private float Q;
    private final List<c> R;
    private final HashMap<String, List<c>> S;

    /* renamed from: d, reason: collision with root package name */
    private final int f236501d;

    /* renamed from: e, reason: collision with root package name */
    private final int f236502e;

    /* renamed from: f, reason: collision with root package name */
    private final int f236503f;

    /* renamed from: h, reason: collision with root package name */
    private int f236504h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f236505i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f236506m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class AllBornRunner implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private List<View> f236508e;

        /* renamed from: d, reason: collision with root package name */
        private int f236507d = -1;

        /* renamed from: f, reason: collision with root package name */
        private Bitmap[] f236509f = new Bitmap[DragFrameLayout.T.length];

        public AllBornRunner(List<View> list) {
            this.f236508e = new ArrayList(list);
        }

        public PointF e() {
            PointF pointF = new PointF();
            if (this.f236508e.size() > 0) {
                View view = this.f236508e.get(0);
                Rect rect = new Rect();
                DragFrameLayout.this.getGlobalVisibleRect(rect);
                int i3 = rect.left;
                int i16 = rect.top;
                view.getGlobalVisibleRect(rect);
                rect.left -= i3;
                rect.top -= i16;
                rect.right -= i3;
                rect.bottom -= i16;
                pointF.set(rect.centerX(), rect.centerY());
            }
            return pointF;
        }

        public Bitmap f() {
            OutOfMemoryError e16;
            Bitmap bitmap;
            int i3 = this.f236507d;
            if (i3 < 0 || i3 >= DragFrameLayout.T.length) {
                return null;
            }
            try {
                bitmap = this.f236509f[this.f236507d];
                if (bitmap == null) {
                    try {
                        bitmap = BitmapFactory.decodeResource(DragFrameLayout.this.getResources(), DragFrameLayout.T[this.f236507d]);
                        this.f236509f[this.f236507d] = bitmap;
                    } catch (OutOfMemoryError e17) {
                        e16 = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + e16, e16);
                        }
                        return bitmap;
                    }
                }
            } catch (OutOfMemoryError e18) {
                e16 = e18;
                bitmap = null;
            }
            return bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f236508e.size() == 0) {
                if (this == DragFrameLayout.this.L) {
                    DragFrameLayout.this.L = null;
                }
                DragFrameLayout.this.x(-1);
                if (QLog.isColorLevel()) {
                    QLog.d("Drag", 2, "DONE!");
                }
                DragFrameLayout.this.w(true);
                DragFrameLayout.this.D = null;
            } else {
                View view = this.f236508e.get(0);
                if (this.f236507d == DragFrameLayout.T.length) {
                    this.f236508e.remove(0);
                    this.f236507d = -1;
                } else {
                    view.setVisibility(4);
                    this.f236507d++;
                }
            }
            DragFrameLayout.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class BornRunner implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f236510d;

        /* renamed from: e, reason: collision with root package name */
        private PointF f236511e;

        public BornRunner(PointF pointF) {
            PointF pointF2 = new PointF();
            this.f236511e = pointF2;
            pointF2.set(pointF);
            this.f236510d = -1;
        }

        public Bitmap e() {
            int i3 = this.f236510d;
            if (i3 >= 0 && i3 < DragFrameLayout.T.length) {
                try {
                    return BitmapFactory.decodeResource(DragFrameLayout.this.getResources(), DragFrameLayout.T[this.f236510d]);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + e16, e16);
                    }
                }
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            if (this.f236510d == DragFrameLayout.T.length) {
                if (this == DragFrameLayout.this.K) {
                    DragFrameLayout.this.K = null;
                }
                DragFrameLayout.this.f236506m = null;
                if (DragFrameLayout.this.E != 2) {
                    DragFrameLayout.this.x(-1);
                    if (QLog.isColorLevel()) {
                        QLog.d("Drag", 2, "DONE!");
                    }
                    DragFrameLayout.this.w(true);
                    DragFrameLayout.this.D = null;
                } else {
                    List<View> arrayList = new ArrayList<>();
                    if (DragFrameLayout.this.G != null) {
                        arrayList = DragFrameLayout.this.G.a();
                    } else if (!TextUtils.isEmpty(DragFrameLayout.this.F) && DragFrameLayout.this.H.containsKey(DragFrameLayout.this.F) && (list = (List) DragFrameLayout.this.H.get(DragFrameLayout.this.F)) != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.addAll(((a) it.next()).a());
                        }
                    }
                    if (arrayList == null || arrayList.size() <= 0) {
                        DragFrameLayout.this.x(-1);
                        if (QLog.isColorLevel()) {
                            QLog.d("Drag", 2, "DONE!");
                        }
                        DragFrameLayout.this.w(true);
                        DragFrameLayout.this.D = null;
                    } else {
                        DragFrameLayout.this.x(5);
                        DragFrameLayout dragFrameLayout = DragFrameLayout.this;
                        dragFrameLayout.L = new AllBornRunner(arrayList);
                    }
                }
            } else {
                this.f236510d++;
            }
            DragFrameLayout.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class ShakeRunner implements Runnable {
        private int C;
        private boolean D;

        /* renamed from: d, reason: collision with root package name */
        private int f236512d;

        /* renamed from: e, reason: collision with root package name */
        private int f236513e;

        /* renamed from: f, reason: collision with root package name */
        private float f236514f;

        /* renamed from: h, reason: collision with root package name */
        private RectF f236515h;

        /* renamed from: i, reason: collision with root package name */
        private PointF f236516i;

        /* renamed from: m, reason: collision with root package name */
        private PointF f236517m;

        public ShakeRunner(PointF pointF, RectF rectF) {
            this.f236512d = 9;
            this.f236513e = 20;
            this.f236512d = (int) (9 * DragFrameLayout.this.getResources().getDisplayMetrics().density);
            this.f236513e = (int) (this.f236513e * DragFrameLayout.this.getResources().getDisplayMetrics().density);
            this.f236516i = new PointF(pointF.x, pointF.y);
            PointF pointF2 = this.f236516i;
            this.f236517m = new PointF(pointF2.x, pointF2.y);
            this.f236515h = rectF;
            float sqrt = (float) Math.sqrt((rectF.width() * this.f236515h.width()) + (this.f236515h.height() * this.f236515h.height()));
            this.f236514f = sqrt;
            if (sqrt <= 0.01d) {
                this.C = 0;
                return;
            }
            this.f236513e = (int) ((this.f236513e * sqrt) / DragFrameLayout.this.f236501d);
            this.f236512d = (int) ((this.f236512d * this.f236514f) / DragFrameLayout.this.f236501d);
            this.C = -this.f236513e;
        }

        public PointF e() {
            return this.f236517m;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.D) {
                return;
            }
            int abs = Math.abs(this.C);
            int i3 = this.f236512d;
            if (abs >= i3 && i3 != 0) {
                this.f236517m.x = this.f236516i.x + ((this.C * this.f236515h.width()) / this.f236514f);
                this.f236517m.y = this.f236516i.y + ((this.C * this.f236515h.height()) / this.f236514f);
                int i16 = this.C;
                if (i16 < 0) {
                    this.C = (-i16) - this.f236512d;
                } else {
                    this.C = (-i16) + this.f236512d;
                }
            } else if (DragFrameLayout.this.J == this) {
                DragFrameLayout.this.J = null;
                DragFrameLayout.this.x(-1);
                DragFrameLayout.this.f236506m = null;
                DragFrameLayout.this.D.setVisibility(0);
                DragFrameLayout.this.D = null;
                DragFrameLayout.this.w(false);
            }
            DragFrameLayout.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        List<View> a();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void a(boolean z16, int i3, com.tencent.mobileqq.guild.widget.qqui.dragframe.a aVar);
    }

    public DragFrameLayout(Context context) {
        super(context);
        this.f236504h = -1;
        this.H = new HashMap<>();
        this.I = new Paint();
        this.M = new Rect();
        this.P = new PointF(-1.0f, -1.0f);
        this.R = new ArrayList();
        this.S = new HashMap<>();
        super.setWillNotDraw(false);
        this.f236502e = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.f236503f = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.f236501d = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }

    private static Bitmap s(View view) {
        Bitmap copy;
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            try {
                copy = drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            } catch (Throwable unused) {
            }
            view.setDrawingCacheEnabled(false);
            return copy;
        }
        copy = null;
        view.setDrawingCacheEnabled(false);
        return copy;
    }

    private void t(Canvas canvas) {
        AllBornRunner allBornRunner;
        if (this.f236504h == -1) {
            return;
        }
        this.I.setAntiAlias(true);
        int i3 = this.C;
        if (i3 != 0) {
            this.I.setColor(i3);
        } else if (this.E == 1) {
            this.I.setColor(-4797728);
        } else {
            this.I.setColor(SupportMenu.CATEGORY_MASK);
        }
        int i16 = this.f236504h;
        if (i16 == 0) {
            Bitmap bitmap = this.f236506m;
            Rect rect = this.M;
            canvas.drawBitmap(bitmap, rect.left, rect.top, this.I);
            return;
        }
        if (i16 == 1) {
            canvas.save();
            int i17 = this.N;
            float f16 = i17 / 1.5f;
            float f17 = i17 * (0.8f - ((this.Q * 0.45f) / this.f236501d));
            int i18 = this.f236503f;
            if (f17 > i18) {
                f17 = i18;
            }
            int i19 = this.f236502e;
            if (f17 < i19) {
                f17 = i19;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Drag", 2, "MODE_DRAG:" + f17 + " for " + this.Q + ", " + this.f236501d);
            }
            canvas.translate(this.M.centerX(), this.M.centerY());
            canvas.rotate(((float) (Math.atan2(this.P.y - this.M.centerY(), this.P.x - this.M.centerX()) * 57.29577951308232d)) - 90.0f);
            canvas.translate(-f16, -f17);
            u(canvas, f17, f16);
            canvas.restore();
            this.I.setColor(-16711936);
            canvas.drawBitmap(this.f236506m, this.P.x - (this.M.width() / 2.0f), this.P.y - (this.M.height() / 2.0f), this.I);
            return;
        }
        if (i16 != 3 && i16 != 6) {
            if (i16 == 2) {
                canvas.drawBitmap(this.f236506m, this.P.x - (this.M.width() / 2.0f), this.P.y - (this.M.height() / 2.0f), this.I);
                return;
            }
            if (i16 == 4) {
                BornRunner bornRunner = this.K;
                if (bornRunner != null) {
                    Bitmap e16 = bornRunner.e();
                    if (e16 != null) {
                        canvas.drawBitmap(e16, new Rect(0, 0, e16.getWidth(), e16.getHeight()), new RectF(this.P.x - (e16.getWidth() / 2.0f), this.P.y - (e16.getHeight() / 2.0f), this.P.x + (e16.getWidth() / 2.0f), this.P.y + (e16.getHeight() / 2.0f)), this.I);
                    }
                    postDelayed(this.K, 50L);
                    return;
                }
                return;
            }
            if (i16 == 5 && (allBornRunner = this.L) != null) {
                PointF e17 = allBornRunner.e();
                Bitmap f18 = this.L.f();
                if (f18 != null && e17.x > 0.0f && e17.y > 0.0f) {
                    canvas.drawBitmap(f18, new Rect(0, 0, f18.getWidth(), f18.getHeight()), new RectF(e17.x - (f18.getWidth() / 2.0f), e17.y - (f18.getHeight() / 2.0f), e17.x + (f18.getWidth() / 2.0f), e17.y + (f18.getHeight() / 2.0f)), this.I);
                }
                if (this.L.f236507d == -1) {
                    post(this.L);
                    return;
                } else {
                    postDelayed(this.L, 25L);
                    return;
                }
            }
            return;
        }
        ShakeRunner shakeRunner = this.J;
        if (shakeRunner != null && this.f236506m != null) {
            this.P.set(shakeRunner.e());
            this.Q = (float) Math.sqrt(((this.P.x - this.M.centerX()) * (this.P.x - this.M.centerX())) + ((this.P.y - this.M.centerY()) * (this.P.y - this.M.centerY())));
            canvas.save();
            float f19 = this.N / 1.5f;
            float f26 = (1.0f - (this.Q / this.f236501d)) * f19;
            int i26 = this.f236503f;
            if (f26 > i26 / 2) {
                f26 = i26 / 2;
            }
            int i27 = this.f236502e;
            if (f26 < i27) {
                f26 = i27;
            }
            canvas.translate(this.M.centerX(), this.M.centerY());
            canvas.rotate(((float) (Math.atan2(this.P.y - this.M.centerY(), this.P.x - this.M.centerX()) * 57.29577951308232d)) - 90.0f);
            canvas.translate(-f19, -f26);
            canvas.restore();
            this.I.setColor(-16711936);
            canvas.drawBitmap(this.f236506m, this.P.x - (this.M.width() / 2.0f), this.P.y - (this.M.height() / 2.0f), this.I);
            postDelayed(this.J, 60L);
        }
    }

    private void u(Canvas canvas, float f16, float f17) {
        float f18 = this.Q;
        float f19 = f16 / 2.0f;
        float f26 = f17 - f19;
        float f27 = (f18 * 0.7f) + f16;
        float f28 = f17 + f19;
        canvas.drawCircle(f17, f16, f16, this.I);
        Path path = new Path();
        path.moveTo(f17 + f16, f16);
        float f29 = f16 + f18 + 0.5f;
        path.cubicTo(f28, f16 + (0.3f * f18), f28, f16 + (f18 * 0.7f), f17 + f17, f29);
        path.lineTo(f17 - f17, f29);
        path.cubicTo(f26, f27, f26, (f18 * 0.3f) + f16, f17 - f16, f16);
        canvas.drawPath(path, this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        if (this.f236504h == -1) {
            this.C = 0;
        }
        Iterator<c> it = this.R.iterator();
        while (it.hasNext()) {
            it.next().a(z16, this.E, this);
        }
        if (!TextUtils.isEmpty(this.F) && this.S.containsKey(this.F)) {
            Iterator<c> it5 = this.S.get(this.F).iterator();
            while (it5.hasNext()) {
                it5.next().a(z16, this.E, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        if (this.f236504h != i3 && QLog.isColorLevel()) {
            QLog.d("Drag", 2, "setMode:" + this.f236504h);
        }
        this.f236504h = i3;
    }

    @Override // com.tencent.mobileqq.guild.widget.qqui.dragframe.b
    public void a(View view, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "onModeChanged:" + view);
        }
        this.C = 0;
        Bitmap s16 = s(view);
        this.f236505i = s16;
        if (s16 != null) {
            this.C = s16.getPixel(s16.getWidth() / 2, 1);
            if (QLog.isColorLevel()) {
                QLog.d("Drag", 2, "getOrginalCachePixel:" + this.C);
            }
            Matrix matrix = new Matrix();
            matrix.postScale(1.1f, 1.1f);
            Bitmap bitmap = this.f236505i;
            this.f236506m = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f236505i.getHeight(), matrix, true);
            getGlobalVisibleRect(this.M);
            Rect rect = this.M;
            int i16 = rect.left;
            int i17 = rect.top;
            view.getGlobalVisibleRect(rect);
            Rect rect2 = this.M;
            rect2.left -= i16;
            rect2.top -= i17;
            rect2.right -= i16;
            rect2.bottom -= i17;
            int width = rect2.width();
            int height = this.M.height();
            Rect rect3 = this.M;
            float f16 = width;
            float f17 = ((f16 * 1.1f) - f16) / 2.0f;
            rect3.left = (int) (rect3.left - f17);
            rect3.right = (int) (rect3.right + f17);
            float f18 = height;
            float f19 = ((1.1f * f18) - f18) / 2.0f;
            rect3.bottom = (int) (rect3.bottom + f19);
            rect3.top = (int) (rect3.top - f19);
            int min = (int) (Math.min(rect3.width(), this.M.height()) * 0.8d);
            this.N = min;
            int i18 = this.f236503f;
            if (min > i18) {
                this.N = i18;
            }
            this.D = view;
            x(0);
            this.E = i3;
            this.F = str;
            view.setVisibility(4);
            invalidate();
            w(false);
            if (QLog.isColorLevel()) {
                QLog.d("Drag", 2, "init:" + this.M);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
        View view;
        super.addChildrenForAccessibility(arrayList);
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                view = arrayList.get(i3);
                if (view.getId() == R.id.e3u) {
                    break;
                } else {
                    i3++;
                }
            } else {
                view = null;
                break;
            }
        }
        if (view != null) {
            arrayList.remove(view);
            arrayList.add(0, view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        t(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (this.f236504h == -1) {
            if (action == 0 && QLog.isColorLevel()) {
                QLog.d("Drag", 2, "Host.dispatchTouchEvent: Down At<" + motionEvent.getX() + ", " + motionEvent.getY() + ">");
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "Host.dispatchTouchEvent: " + motionEvent.getAction() + " At<" + motionEvent.getX() + ", " + motionEvent.getY() + ">");
        }
        if (this.f236504h != 6 && this.E == 4) {
            x(6);
            this.J = new ShakeRunner(new PointF(this.M.centerX(), this.M.centerY()), new RectF(this.M.centerX(), this.M.centerY(), this.M.centerX() - 6, this.M.centerY()));
            invalidate();
        }
        if (action != 3 && action != 1) {
            if (action == 2) {
                int i3 = this.f236504h;
                if (i3 != 0 && i3 != 1) {
                    if (i3 != 3 && i3 == 2) {
                        this.P.set(x16, y16);
                        v(this.M.centerX() - x16, this.M.centerY() - y16, 2);
                        invalidate();
                    }
                } else {
                    float sqrt = (float) Math.sqrt(((x16 - this.M.centerX()) * (x16 - this.M.centerX())) + ((y16 - this.M.centerY()) * (y16 - this.M.centerY())));
                    if (sqrt >= this.N + this.f236501d) {
                        this.Q = sqrt;
                        this.P.set(x16, y16);
                        x(2);
                        v(this.M.centerX() - x16, this.M.centerY() - y16, 2);
                    } else if (sqrt >= 0.0f) {
                        this.Q = sqrt;
                        this.P.set(x16, y16);
                        x(1);
                        v(this.M.centerX() - x16, this.M.centerY() - y16, 1);
                    } else {
                        x(0);
                        v(0.0f, 0.0f, 0);
                    }
                    invalidate();
                }
            }
        } else {
            v(this.M.centerX() - x16, this.M.centerY() - y16, -1);
            int i16 = this.f236504h;
            if (i16 == 0) {
                this.f236506m = null;
                this.D.setVisibility(0);
                this.D = null;
                x(-1);
                invalidate();
                w(false);
            } else if (i16 == 1) {
                x(3);
                this.P.set(x16, y16);
                float centerX = this.M.centerX();
                float centerY = this.M.centerY();
                PointF pointF = this.P;
                this.J = new ShakeRunner(new PointF(this.M.centerX(), this.M.centerY()), new RectF(centerX, centerY, pointF.x, pointF.y));
                invalidate();
            } else if (i16 != 3 && i16 == 2) {
                if (((float) Math.sqrt(((x16 - this.M.centerX()) * (x16 - this.M.centerX())) + ((y16 - this.M.centerY()) * (y16 - this.M.centerY())))) < (this.N + this.f236501d) / 2) {
                    this.f236506m = null;
                    this.D.setVisibility(0);
                    this.D = null;
                    x(-1);
                    w(false);
                } else {
                    x(4);
                    this.P.set(x16, y16);
                    this.K = new BornRunner(this.P);
                }
                invalidate();
            }
        }
        return true;
    }

    public void setDragViewProvider(a aVar) {
        this.G = aVar;
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236504h = -1;
        this.H = new HashMap<>();
        this.I = new Paint();
        this.M = new Rect();
        this.P = new PointF(-1.0f, -1.0f);
        this.R = new ArrayList();
        this.S = new HashMap<>();
        super.setWillNotDraw(false);
        this.f236502e = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.f236503f = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.f236501d = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }

    public void setOnDragListener(b bVar) {
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236504h = -1;
        this.H = new HashMap<>();
        this.I = new Paint();
        this.M = new Rect();
        this.P = new PointF(-1.0f, -1.0f);
        this.R = new ArrayList();
        this.S = new HashMap<>();
        super.setWillNotDraw(false);
        this.f236502e = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.f236503f = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.f236501d = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }

    private void v(float f16, float f17, int i3) {
    }
}
