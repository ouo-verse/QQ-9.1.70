package com.tencent.mobileqq.quibadge;

import android.app.Activity;
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
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ud0.d;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QUIBadgeDragLayout extends FrameLayout implements b {
    static IPatchRedirector $redirector_ = null;
    private static final int[] BORN_IMAGES;
    private static final float FIRST_FACTOR = 0.3f;
    public static final int MODE_BORN = 4;
    public static final int MODE_BORN_ALL = 5;
    public static final int MODE_DRAG = 1;
    public static final int MODE_IDLE = -1;
    public static final int MODE_MOVE = 2;
    public static final int MODE_ONLY_SHAKE = 6;
    public static final int MODE_ORIGIN = 0;
    public static final int MODE_SHAKE = 3;
    private static final float SECOND_FACTOR = 0.7f;
    public static final float SWELL_SCALE = 1.0f;
    private static final String TAG = "QUIBadgeDragLayout";
    private AllBornRunner mAllBornRun;
    private int mBgColor;
    private BornRunner mBornRun;
    private int mCircleR;
    private float mCurLen;
    private final PointF mCurPoint;
    private Bitmap mDragCache;
    private String mDragGroup;
    private OnDragListener mDragListener;
    private OnDragSingleClick mDragSingleClick;
    private int mDragType;
    private View mDragView;
    private IDragViewProvider mDragViewProvider;
    private final HashMap<String, List<IDragViewProvider>> mDragViewProviderByGroup;
    private final int mMaxCircleR;
    private final int mMaxDragLen;
    private final int mMinCircleR;
    private int mMode;
    private final List<OnDragModeChangedListener> mOnDragModeChangeListeners;
    private final HashMap<String, List<OnDragModeChangedListener>> mOnDragModeChangeListenersByGroup;
    private final Rect mOriginRect;
    private final Paint mPaint;
    private ShakeRunner mShaker;
    private int mViewType;

    /* renamed from: sm, reason: collision with root package name */
    private float f276948sm;

    /* renamed from: sx, reason: collision with root package name */
    private float f276949sx;

    /* renamed from: sy, reason: collision with root package name */
    private float f276950sy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class AllBornRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f276951d;

        /* renamed from: e, reason: collision with root package name */
        private final List<WeakReference<View>> f276952e;

        /* renamed from: f, reason: collision with root package name */
        private final Bitmap[] f276953f;

        public AllBornRunner(List<View> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBadgeDragLayout.this, (Object) list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.f276952e = arrayList;
            arrayList.clear();
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                this.f276952e.add(new WeakReference<>(it.next()));
            }
            this.f276951d = -1;
            this.f276953f = new Bitmap[QUIBadgeDragLayout.BORN_IMAGES.length];
        }

        public PointF e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PointF) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            PointF pointF = new PointF();
            if (this.f276952e.size() > 0) {
                View view = this.f276952e.get(0).get();
                if (view == null) {
                    return pointF;
                }
                Rect rect = new Rect();
                QUIBadgeDragLayout.this.getGlobalVisibleRect(rect);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            int i3 = this.f276951d;
            if (i3 < 0 || i3 >= QUIBadgeDragLayout.BORN_IMAGES.length) {
                return null;
            }
            try {
                bitmap = this.f276953f[this.f276951d];
                if (bitmap == null) {
                    try {
                        bitmap = BitmapFactory.decodeResource(QUIBadgeDragLayout.this.getResources(), QUIBadgeDragLayout.BORN_IMAGES[this.f276951d]);
                        this.f276953f[this.f276951d] = bitmap;
                    } catch (OutOfMemoryError e17) {
                        e16 = e17;
                        if (d.h()) {
                            d.b("DragRelativeLayout", d.f438810d, "decodeBitmap failed" + e16, e16);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (this.f276952e.size() == 0) {
                if (this == QUIBadgeDragLayout.this.mAllBornRun) {
                    QUIBadgeDragLayout.this.mAllBornRun = null;
                }
                QUIBadgeDragLayout.this.setMode(-1);
                if (d.h()) {
                    d.a("Drag", d.f438810d, "DONE!");
                }
                QUIBadgeDragLayout.this.invokeModeToListener(true);
                QUIBadgeDragLayout.this.mDragView = null;
            } else if (this.f276951d == QUIBadgeDragLayout.BORN_IMAGES.length) {
                this.f276952e.remove(0);
                this.f276951d = -1;
            } else {
                View view = this.f276952e.get(0).get();
                if (view != null) {
                    view.setVisibility(4);
                }
                this.f276951d++;
            }
            QUIBadgeDragLayout.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class BornRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f276954d;

        /* renamed from: e, reason: collision with root package name */
        private PointF f276955e;

        public BornRunner(PointF pointF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIBadgeDragLayout.this, (Object) pointF);
                return;
            }
            PointF pointF2 = new PointF();
            this.f276955e = pointF2;
            pointF2.set(pointF);
            this.f276954d = -1;
        }

        public Bitmap e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            int i3 = this.f276954d;
            if (i3 >= 0 && i3 < QUIBadgeDragLayout.BORN_IMAGES.length) {
                try {
                    return BitmapFactory.decodeResource(QUIBadgeDragLayout.this.getResources(), QUIBadgeDragLayout.BORN_IMAGES[this.f276954d]);
                } catch (OutOfMemoryError e16) {
                    if (d.h()) {
                        d.b("DragRelativeLayout", d.f438810d, "decodeBitmap failed" + e16, e16);
                    }
                }
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f276954d == QUIBadgeDragLayout.BORN_IMAGES.length) {
                if (this == QUIBadgeDragLayout.this.mBornRun) {
                    QUIBadgeDragLayout.this.mBornRun = null;
                }
                QUIBadgeDragLayout.this.mDragCache = null;
                if (QUIBadgeDragLayout.this.mDragType != 2) {
                    QUIBadgeDragLayout.this.setMode(-1);
                    if (d.h()) {
                        d.a("Drag", d.f438810d, "DONE!");
                    }
                    QUIBadgeDragLayout.this.invokeModeToListener(true);
                    QUIBadgeDragLayout.this.mDragView = null;
                } else {
                    List<View> arrayList = new ArrayList<>();
                    if (QUIBadgeDragLayout.this.mDragViewProvider != null) {
                        arrayList = QUIBadgeDragLayout.this.mDragViewProvider.onGetVisibleDragView();
                    } else if (!TextUtils.isEmpty(QUIBadgeDragLayout.this.mDragGroup) && QUIBadgeDragLayout.this.mDragViewProviderByGroup.containsKey(QUIBadgeDragLayout.this.mDragGroup) && (list = (List) QUIBadgeDragLayout.this.mDragViewProviderByGroup.get(QUIBadgeDragLayout.this.mDragGroup)) != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.addAll(((IDragViewProvider) it.next()).onGetVisibleDragView());
                        }
                    }
                    if (arrayList == null || arrayList.size() <= 0) {
                        QUIBadgeDragLayout.this.setMode(-1);
                        if (d.h()) {
                            d.a("Drag", d.f438810d, "DONE!");
                        }
                        QUIBadgeDragLayout.this.invokeModeToListener(true);
                        QUIBadgeDragLayout.this.mDragView = null;
                    } else {
                        QUIBadgeDragLayout.this.setMode(5);
                        QUIBadgeDragLayout qUIBadgeDragLayout = QUIBadgeDragLayout.this;
                        qUIBadgeDragLayout.mAllBornRun = new AllBornRunner(arrayList);
                    }
                }
            } else {
                this.f276954d++;
            }
            QUIBadgeDragLayout.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface IDragViewProvider {
        List<View> onGetVisibleDragView();
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface OnDragListener {
        void onDrag(float f16, float f17, int i3, @NonNull View view);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface OnDragModeChangedListener<T extends QUIBadgeDragLayout> {
        void onChange(boolean z16, int i3, @NonNull T t16);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface OnDragSingleClick {
        void onClick(QUIBadgeDragLayout qUIBadgeDragLayout, float f16, float f17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class ShakeRunner implements Runnable {
        static IPatchRedirector $redirector_;
        private int C;
        private boolean D;

        /* renamed from: d, reason: collision with root package name */
        private int f276956d;

        /* renamed from: e, reason: collision with root package name */
        private int f276957e;

        /* renamed from: f, reason: collision with root package name */
        private float f276958f;

        /* renamed from: h, reason: collision with root package name */
        private RectF f276959h;

        /* renamed from: i, reason: collision with root package name */
        private PointF f276960i;

        /* renamed from: m, reason: collision with root package name */
        private PointF f276961m;

        public ShakeRunner(PointF pointF, RectF rectF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QUIBadgeDragLayout.this, pointF, rectF);
                return;
            }
            this.f276956d = 9;
            this.f276957e = 20;
            this.f276956d = (int) (9 * QUIBadgeDragLayout.this.getResources().getDisplayMetrics().density);
            this.f276957e = (int) (this.f276957e * QUIBadgeDragLayout.this.getResources().getDisplayMetrics().density);
            this.f276960i = new PointF(pointF.x, pointF.y);
            PointF pointF2 = this.f276960i;
            this.f276961m = new PointF(pointF2.x, pointF2.y);
            this.f276959h = rectF;
            float sqrt = (float) Math.sqrt((rectF.width() * this.f276959h.width()) + (this.f276959h.height() * this.f276959h.height()));
            this.f276958f = sqrt;
            if (sqrt <= 0.01d) {
                this.C = 0;
                return;
            }
            this.f276957e = (int) ((this.f276957e * sqrt) / QUIBadgeDragLayout.this.mMaxDragLen);
            this.f276956d = (int) ((this.f276956d * this.f276958f) / QUIBadgeDragLayout.this.mMaxDragLen);
            this.C = -this.f276957e;
        }

        public PointF e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PointF) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f276961m;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (this.D) {
                return;
            }
            int abs = Math.abs(this.C);
            int i3 = this.f276956d;
            if (abs >= i3 && i3 != 0) {
                this.f276961m.x = this.f276960i.x + ((this.C * this.f276959h.width()) / this.f276958f);
                this.f276961m.y = this.f276960i.y + ((this.C * this.f276959h.height()) / this.f276958f);
                int i16 = this.C;
                if (i16 < 0) {
                    this.C = (-i16) - this.f276956d;
                } else {
                    this.C = (-i16) + this.f276956d;
                }
            } else if (QUIBadgeDragLayout.this.mShaker == this) {
                QUIBadgeDragLayout.this.mShaker = null;
                QUIBadgeDragLayout.this.setMode(-1);
                QUIBadgeDragLayout.this.mDragCache = null;
                QUIBadgeDragLayout.this.mDragView.setVisibility(0);
                QUIBadgeDragLayout.this.mDragView = null;
                QUIBadgeDragLayout.this.invokeModeToListener(false);
            }
            QUIBadgeDragLayout.this.invalidate();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            BORN_IMAGES = new int[]{R.drawable.qui_badge_born_01, R.drawable.qui_badge_born_02, R.drawable.qui_badge_born_03, R.drawable.qui_badge_born_04, R.drawable.qui_badge_born_05};
        }
    }

    public QUIBadgeDragLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mMode = -1;
        this.mDragViewProviderByGroup = new HashMap<>();
        this.mPaint = new Paint();
        this.mOriginRect = new Rect();
        this.mCurPoint = new PointF(-1.0f, -1.0f);
        this.mOnDragModeChangeListeners = new ArrayList();
        this.mOnDragModeChangeListenersByGroup = new HashMap<>();
        this.f276949sx = 0.0f;
        this.f276950sy = 0.0f;
        this.f276948sm = 0.0f;
        super.setWillNotDraw(false);
        this.mMinCircleR = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.mMaxCircleR = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.mMaxDragLen = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }

    private void checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            d.a(TAG, d.f438811e, "checkThread  CurrentThread:" + Thread.currentThread() + ", StackTrace:\n" + Log.getStackTraceString(new Throwable()));
        }
    }

    private void cleanTapFlag() {
        this.f276949sx = 0.0f;
        this.f276950sy = 0.0f;
        this.f276948sm = 0.0f;
    }

    private static Bitmap createWillDragViewCache(View view) {
        Bitmap copy;
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            try {
                copy = drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            } catch (Throwable th5) {
                d.a(TAG, d.f438811e, "createWillDragViewCache err: e=", th5);
            }
            view.setDrawingCacheEnabled(false);
            return copy;
        }
        copy = null;
        view.setDrawingCacheEnabled(false);
        return copy;
    }

    private void doDraw(Canvas canvas) {
        if (this.mMode == -1) {
            return;
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColorFilter(null);
        int c16 = com.tencent.mobileqq.quibadge.helper.a.c(getContext(), this.mViewType);
        this.mBgColor = c16;
        this.mPaint.setColor(c16);
        int i3 = this.mMode;
        if (i3 == 0) {
            Bitmap bitmap = this.mDragCache;
            Rect rect = this.mOriginRect;
            canvas.drawBitmap(bitmap, rect.left, rect.top, this.mPaint);
            return;
        }
        if (i3 == 1) {
            canvas.save();
            float f16 = this.mCircleR * (0.8f - ((this.mCurLen * 0.45f) / this.mMaxDragLen));
            int i16 = this.mMaxCircleR;
            if (f16 > i16) {
                f16 = i16;
            }
            int i17 = this.mMinCircleR;
            if (f16 < i17) {
                f16 = i17;
            }
            if (d.h()) {
                d.a(TAG, d.f438810d, "MODE_DRAG:" + f16 + " for " + this.mCurLen + ", " + this.mMaxDragLen);
            }
            canvas.translate(this.mOriginRect.centerX(), this.mOriginRect.centerY());
            canvas.rotate(((float) (Math.atan2(this.mCurPoint.y - this.mOriginRect.centerY(), this.mCurPoint.x - this.mOriginRect.centerX()) * 57.29577951308232d)) - 90.0f);
            float f17 = this.mCircleR / 1.5f;
            canvas.translate(-f17, -f16);
            drawAtOrigionM(canvas, f16, f17);
            canvas.restore();
            this.mPaint.setColor(-1);
            canvas.drawBitmap(this.mDragCache, this.mCurPoint.x - (this.mOriginRect.width() / 2.0f), this.mCurPoint.y - (this.mOriginRect.height() / 2.0f), this.mPaint);
            return;
        }
        if (i3 != 3 && i3 != 6) {
            if (i3 == 2) {
                this.mPaint.setColor(-1);
                canvas.drawBitmap(this.mDragCache, this.mCurPoint.x - (this.mOriginRect.width() / 2.0f), this.mCurPoint.y - (this.mOriginRect.height() / 2.0f), this.mPaint);
                return;
            }
            if (i3 == 4) {
                this.mPaint.setColor(-1);
                BornRunner bornRunner = this.mBornRun;
                if (bornRunner != null) {
                    Bitmap e16 = bornRunner.e();
                    if (e16 != null) {
                        canvas.drawBitmap(e16, new Rect(0, 0, e16.getWidth(), e16.getHeight()), new RectF(this.mCurPoint.x - (e16.getWidth() / 2.0f), this.mCurPoint.y - (e16.getHeight() / 2.0f), this.mCurPoint.x + (e16.getWidth() / 2.0f), this.mCurPoint.y + (e16.getHeight() / 2.0f)), this.mPaint);
                    }
                    postDelayed(this.mBornRun, 50L);
                    return;
                }
                return;
            }
            if (i3 == 5) {
                this.mPaint.setColor(-1);
                AllBornRunner allBornRunner = this.mAllBornRun;
                if (allBornRunner != null) {
                    PointF e17 = allBornRunner.e();
                    Bitmap f18 = this.mAllBornRun.f();
                    if (f18 != null && e17.x > 0.0f && e17.y > 0.0f) {
                        canvas.drawBitmap(f18, new Rect(0, 0, f18.getWidth(), f18.getHeight()), new RectF(e17.x - (f18.getWidth() / 2.0f), e17.y - (f18.getHeight() / 2.0f), e17.x + (f18.getWidth() / 2.0f), e17.y + (f18.getHeight() / 2.0f)), this.mPaint);
                    }
                    if (this.mAllBornRun.f276951d == -1) {
                        post(this.mAllBornRun);
                        return;
                    } else {
                        postDelayed(this.mAllBornRun, 25L);
                        return;
                    }
                }
                return;
            }
            return;
        }
        ShakeRunner shakeRunner = this.mShaker;
        if (shakeRunner != null && this.mDragCache != null) {
            this.mCurPoint.set(shakeRunner.e());
            this.mCurLen = (float) Math.sqrt(((this.mCurPoint.x - this.mOriginRect.centerX()) * (this.mCurPoint.x - this.mOriginRect.centerX())) + ((this.mCurPoint.y - this.mOriginRect.centerY()) * (this.mCurPoint.y - this.mOriginRect.centerY())));
            canvas.save();
            float f19 = this.mCircleR / 1.5f;
            float f26 = (1.0f - (this.mCurLen / this.mMaxDragLen)) * f19;
            int i18 = this.mMaxCircleR;
            if (f26 > i18 / 2) {
                f26 = i18 / 2;
            }
            int i19 = this.mMinCircleR;
            if (f26 < i19) {
                f26 = i19;
            }
            canvas.translate(this.mOriginRect.centerX(), this.mOriginRect.centerY());
            canvas.rotate(((float) (Math.atan2(this.mCurPoint.y - this.mOriginRect.centerY(), this.mCurPoint.x - this.mOriginRect.centerX()) * 57.29577951308232d)) - 90.0f);
            canvas.translate(-f19, -f26);
            canvas.restore();
            this.mPaint.setColor(-1);
            canvas.drawBitmap(this.mDragCache, this.mCurPoint.x - (this.mOriginRect.width() / 2.0f), this.mCurPoint.y - (this.mOriginRect.height() / 2.0f), this.mPaint);
            postDelayed(this.mShaker, 60L);
        }
    }

    private void drawAtOrigionM(Canvas canvas, float f16, float f17) {
        if (d.h()) {
            d.a("Drag", d.f438810d, "drawAtOrigion:" + f16 + ", " + f17);
        }
        float f18 = this.mCurLen;
        float f19 = f16 / 2.0f;
        float f26 = f17 - f19;
        float f27 = f17 + f19;
        canvas.drawCircle(f17, f16, f16, this.mPaint);
        Path path = new Path();
        path.moveTo(f17 + f16, f16);
        float f28 = f16 + f18 + 0.5f;
        path.cubicTo(f27, f16 + (0.3f * f18), f27, f16 + (f18 * 0.7f), f17 + f17, f28);
        path.lineTo(f17 - f17, f28);
        path.cubicTo(f26, (f18 * 0.7f) + f16, f26, (f18 * 0.3f) + f16, f17 - f16, f16);
        canvas.drawPath(path, this.mPaint);
    }

    private List<View> getVisibleDragView() {
        List<IDragViewProvider> list;
        ArrayList arrayList = new ArrayList();
        IDragViewProvider iDragViewProvider = this.mDragViewProvider;
        if (iDragViewProvider != null) {
            return iDragViewProvider.onGetVisibleDragView();
        }
        if (!TextUtils.isEmpty(this.mDragGroup) && this.mDragViewProviderByGroup.containsKey(this.mDragGroup) && (list = this.mDragViewProviderByGroup.get(this.mDragGroup)) != null) {
            Iterator<IDragViewProvider> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().onGetVisibleDragView());
            }
            return arrayList;
        }
        return arrayList;
    }

    private void invokeDragListener(float f16, float f17, int i3) {
        OnDragListener onDragListener = this.mDragListener;
        if (onDragListener != null) {
            onDragListener.onDrag(f16, f17, i3, this.mDragView);
        }
    }

    private void invokeDragSingleClick(boolean z16, float f16, float f17) {
        OnDragSingleClick onDragSingleClick;
        if (z16 && (onDragSingleClick = this.mDragSingleClick) != null) {
            onDragSingleClick.onClick(this, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeModeToListener(boolean z16) {
        if (this.mMode == -1) {
            this.mBgColor = 0;
        }
        Iterator<OnDragModeChangedListener> it = this.mOnDragModeChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onChange(z16, this.mDragType, this);
        }
        if (!TextUtils.isEmpty(this.mDragGroup) && this.mOnDragModeChangeListenersByGroup.containsKey(this.mDragGroup)) {
            Iterator<OnDragModeChangedListener> it5 = this.mOnDragModeChangeListenersByGroup.get(this.mDragGroup).iterator();
            while (it5.hasNext()) {
                it5.next().onChange(z16, this.mDragType, this);
            }
        }
    }

    private Boolean isSoftTap(float f16, float f17) {
        if (Math.abs(this.f276949sx - f16) < 2.0f && Math.abs(this.f276950sy - f17) < 2.0f) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static QUIBadgeDragLayout makeControlView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof QUIBadgeDragLayout) {
            return (QUIBadgeDragLayout) childAt;
        }
        QUIBadgeDragLayout qUIBadgeDragLayout = new QUIBadgeDragLayout(activity.getApplication());
        viewGroup.addView(qUIBadgeDragLayout, 0);
        viewGroup.removeView(childAt);
        qUIBadgeDragLayout.addView(childAt);
        return qUIBadgeDragLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(int i3) {
        this.mMode = i3;
        if (d.h()) {
            d.a("Drag", d.f438810d, "setMode:" + this.mMode);
        }
    }

    public void addDragViewProviderByGroup(String str, IDragViewProvider iDragViewProvider, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, iDragViewProvider, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str) && iDragViewProvider != null) {
            if (!this.mDragViewProviderByGroup.containsKey(str)) {
                this.mDragViewProviderByGroup.put(str, new ArrayList());
            }
            List<IDragViewProvider> list = this.mDragViewProviderByGroup.get(str);
            if (list.contains(iDragViewProvider)) {
                return;
            }
            if (!z16) {
                list.add(iDragViewProvider);
            } else {
                list.add(0, iDragViewProvider);
            }
        }
    }

    public void addOnDragModeChangeListener(OnDragModeChangedListener onDragModeChangedListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, onDragModeChangedListener, Boolean.valueOf(z16));
            return;
        }
        if (onDragModeChangedListener != null && !this.mOnDragModeChangeListeners.contains(onDragModeChangedListener)) {
            if (!z16) {
                this.mOnDragModeChangeListeners.add(onDragModeChangedListener);
            } else {
                this.mOnDragModeChangeListeners.add(0, onDragModeChangedListener);
            }
        }
    }

    public void addOnDragModeChangeListenerByGroup(String str, OnDragModeChangedListener onDragModeChangedListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, onDragModeChangedListener, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str) && onDragModeChangedListener != null) {
            if (!this.mOnDragModeChangeListenersByGroup.containsKey(str)) {
                this.mOnDragModeChangeListenersByGroup.put(str, new ArrayList());
            }
            List<OnDragModeChangedListener> list = this.mOnDragModeChangeListenersByGroup.get(str);
            if (!z16) {
                list.add(onDragModeChangedListener);
            } else {
                list.add(0, onDragModeChangedListener);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e16) {
            if (d.i()) {
                d.a(TAG, d.f438809c, e16);
            }
        }
        doDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        int i16 = this.mMode;
        if (i16 != -1 && (i3 = this.mDragType) != 3) {
            if (i16 != 6 && i3 == 1) {
                setMode(6);
                this.mShaker = new ShakeRunner(new PointF(this.mOriginRect.centerX(), this.mOriginRect.centerY()), new RectF(this.mOriginRect.centerX(), this.mOriginRect.centerY(), this.mOriginRect.centerX() - 6, this.mOriginRect.centerY()));
                invalidate();
            }
            if (action != 3 && action != 1) {
                if (action != 2) {
                    return true;
                }
                int i17 = this.mMode;
                if (i17 != 0 && i17 != 1) {
                    if (i17 != 3 && i17 == 2) {
                        this.mCurPoint.set(x16, y16);
                        invokeDragListener(this.mOriginRect.centerX() - x16, this.mOriginRect.centerY() - y16, 2);
                        invalidate();
                    }
                } else {
                    float sqrt = (float) Math.sqrt(((x16 - this.mOriginRect.centerX()) * (x16 - this.mOriginRect.centerX())) + ((y16 - this.mOriginRect.centerY()) * (y16 - this.mOriginRect.centerY())));
                    if (sqrt >= this.mCircleR + this.mMaxDragLen) {
                        this.mCurLen = sqrt;
                        this.mCurPoint.set(x16, y16);
                        setMode(2);
                        invokeDragListener(this.mOriginRect.centerX() - x16, this.mOriginRect.centerY() - y16, 2);
                    } else if (sqrt >= 0.0f) {
                        this.mCurLen = sqrt;
                        this.mCurPoint.set(x16, y16);
                        setMode(1);
                        invokeDragListener(this.mOriginRect.centerX() - x16, this.mOriginRect.centerY() - y16, 1);
                    } else {
                        setMode(0);
                        invokeDragListener(0.0f, 0.0f, 0);
                    }
                    invalidate();
                }
                this.f276948sm = x16;
                return true;
            }
            invokeDragListener(this.mOriginRect.centerX() - x16, this.mOriginRect.centerY() - y16, -1);
            int i18 = this.mMode;
            if (i18 != 0 && i18 != 1) {
                if (i18 == 1) {
                    setMode(3);
                    this.mCurPoint.set(x16, y16);
                    float centerX = this.mOriginRect.centerX();
                    float centerY = this.mOriginRect.centerY();
                    PointF pointF = this.mCurPoint;
                    this.mShaker = new ShakeRunner(new PointF(this.mOriginRect.centerX(), this.mOriginRect.centerY()), new RectF(centerX, centerY, pointF.x, pointF.y));
                    invalidate();
                } else if (i18 != 3 && i18 == 2) {
                    if (((float) Math.sqrt(((x16 - this.mOriginRect.centerX()) * (x16 - this.mOriginRect.centerX())) + ((y16 - this.mOriginRect.centerY()) * (y16 - this.mOriginRect.centerY())))) < (this.mCircleR + this.mMaxDragLen) / 2) {
                        this.mDragCache = null;
                        this.mDragView.setVisibility(0);
                        this.mDragView = null;
                        setMode(-1);
                        invokeModeToListener(false);
                    } else {
                        setMode(4);
                        this.mCurPoint.set(x16, y16);
                        this.mBornRun = new BornRunner(this.mCurPoint);
                    }
                    invalidate();
                }
            } else {
                if (((float) Math.sqrt(((x16 - this.mOriginRect.centerX()) * (x16 - this.mOriginRect.centerX())) + ((y16 - this.mOriginRect.centerY()) * (y16 - this.mOriginRect.centerY())))) < this.mCircleR || isSoftTap(x16, y16).booleanValue()) {
                    invokeDragSingleClick(true, x16, y16);
                }
                this.mDragCache = null;
                this.mDragView.setVisibility(0);
                this.mDragView = null;
                setMode(-1);
                invalidate();
                invokeModeToListener(false);
            }
            super.dispatchTouchEvent(motionEvent);
            cleanTapFlag();
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (action == 3 || action == 1) {
            if (isSoftTap(x16, y16).booleanValue()) {
                invokeDragSingleClick(true, x16, y16);
            }
            cleanTapFlag();
        }
        if (action == 0) {
            cleanTapFlag();
            this.f276949sx = x16;
            this.f276950sy = y16;
        }
        if (action == 2) {
            this.f276948sm = x16;
        }
        return dispatchTouchEvent;
    }

    @MainThread
    public void forceAllToBorn(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
            return;
        }
        this.mDragGroup = str;
        this.mDragType = i3;
        List<View> visibleDragView = getVisibleDragView();
        if (visibleDragView != null && visibleDragView.size() > 0) {
            setMode(5);
            this.mAllBornRun = new AllBornRunner(visibleDragView);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
        if (i3 < 0 || i3 >= getChildCount()) {
            d.a(TAG, d.f438811e, "getChildAt index:" + i3, ", mChildrenCount:" + getChildCount());
        }
        return super.getChildAt(i3);
    }

    public View getDragView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mDragView;
    }

    public int getMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mMode;
    }

    public OnDragListener getOnDragListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OnDragListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mDragListener;
    }

    @Override // com.tencent.mobileqq.quibadge.b
    public void onModeChanged(View view, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, view, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        if (d.h()) {
            d.a("Drag", d.f438810d, "onModeChanged: group: " + str + "view: " + view);
        }
        this.mBgColor = com.tencent.mobileqq.quibadge.helper.a.c(getContext(), i16);
        Bitmap createWillDragViewCache = createWillDragViewCache(view);
        if (createWillDragViewCache != null) {
            this.mBgColor = createWillDragViewCache.getPixel(createWillDragViewCache.getWidth() / 2, 1);
            if (d.h()) {
                d.a("Drag", d.f438810d, "getOrginCachePixel:" + this.mBgColor);
            }
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, 1.0f);
            this.mDragCache = Bitmap.createBitmap(createWillDragViewCache, 0, 0, createWillDragViewCache.getWidth(), createWillDragViewCache.getHeight(), matrix, true);
            getGlobalVisibleRect(this.mOriginRect);
            Rect rect = this.mOriginRect;
            int i17 = rect.left;
            int i18 = rect.top;
            view.getGlobalVisibleRect(rect);
            Rect rect2 = this.mOriginRect;
            rect2.left -= i17;
            rect2.top -= i18;
            rect2.right -= i17;
            rect2.bottom -= i18;
            int width = rect2.width();
            int height = this.mOriginRect.height();
            Rect rect3 = this.mOriginRect;
            float f16 = width;
            float f17 = ((f16 * 1.0f) - f16) / 2.0f;
            rect3.left = (int) (rect3.left - f17);
            rect3.right = (int) (rect3.right + f17);
            float f18 = height;
            float f19 = ((1.0f * f18) - f18) / 2.0f;
            rect3.bottom = (int) (rect3.bottom + f19);
            rect3.top = (int) (rect3.top - f19);
            int min = (int) (Math.min(rect3.width(), this.mOriginRect.height()) * 0.8d);
            this.mCircleR = min;
            int i19 = this.mMaxCircleR;
            if (min > i19) {
                this.mCircleR = i19;
            }
            this.mDragView = view;
            setMode(0);
            this.mDragType = i3;
            this.mViewType = i16;
            this.mDragGroup = str;
            view.setVisibility(4);
            invalidate();
            invokeModeToListener(false);
            if (d.h()) {
                d.a("Drag", d.f438810d, "init:" + this.mOriginRect);
            }
        }
    }

    public void onPause() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.mMode != -1) {
            if (this.mShaker != null) {
                getHandler().removeCallbacks(this.mShaker);
                this.mShaker = null;
            }
            if (this.mBornRun != null) {
                getHandler().removeCallbacks(this.mBornRun);
                this.mBornRun = null;
            }
            if (this.mAllBornRun != null) {
                getHandler().removeCallbacks(this.mAllBornRun);
                this.mAllBornRun = null;
            }
            if (this.mMode == 5) {
                z16 = true;
            } else {
                z16 = false;
            }
            d.a(TAG, d.f438810d, "onPause call, mMode=" + this.mMode, " isDone=", Boolean.valueOf(z16));
            setMode(-1);
            invokeModeToListener(z16);
            this.mDragCache = null;
            this.mDragView = null;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            checkThread();
            super.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            checkThread();
            super.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, view, Boolean.valueOf(z16));
        } else {
            checkThread();
            super.removeDetachedView(view, z16);
        }
    }

    public void removeDragViewProviderByGroup(String str, IDragViewProvider iDragViewProvider) {
        List<IDragViewProvider> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) iDragViewProvider);
        } else if (!TextUtils.isEmpty(str) && iDragViewProvider != null && (list = this.mDragViewProviderByGroup.get(str)) != null) {
            list.remove(iDragViewProvider);
        }
    }

    public void removeOnDragModeChangeListener(OnDragModeChangedListener onDragModeChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onDragModeChangedListener);
        } else if (onDragModeChangedListener != null && this.mOnDragModeChangeListeners.contains(onDragModeChangedListener)) {
            this.mOnDragModeChangeListeners.remove(onDragModeChangedListener);
        }
    }

    public void removeOnDragModeChangeListenerByGroup(String str, OnDragModeChangedListener onDragModeChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) onDragModeChangedListener);
            return;
        }
        if (TextUtils.isEmpty(str) || onDragModeChangedListener == null || !this.mOnDragModeChangeListenersByGroup.containsKey(str)) {
            return;
        }
        List<OnDragModeChangedListener> list = this.mOnDragModeChangeListenersByGroup.get(str);
        if (list.contains(onDragModeChangedListener)) {
            list.remove(onDragModeChangedListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else {
            checkThread();
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            checkThread();
            super.removeViewAt(i3);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
        } else {
            checkThread();
            super.removeViewInLayout(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            checkThread();
            super.removeViews(i3, i16);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            checkThread();
            super.removeViewsInLayout(i3, i16);
        }
    }

    public void setDragViewProvider(IDragViewProvider iDragViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iDragViewProvider);
        } else {
            this.mDragViewProvider = iDragViewProvider;
        }
    }

    public void setOnDragListener(OnDragListener onDragListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onDragListener);
        } else {
            this.mDragListener = onDragListener;
        }
    }

    public void setOnDragSingleClick(OnDragSingleClick onDragSingleClick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onDragSingleClick);
        } else {
            this.mDragSingleClick = onDragSingleClick;
        }
    }

    public QUIBadgeDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mMode = -1;
        this.mDragViewProviderByGroup = new HashMap<>();
        this.mPaint = new Paint();
        this.mOriginRect = new Rect();
        this.mCurPoint = new PointF(-1.0f, -1.0f);
        this.mOnDragModeChangeListeners = new ArrayList();
        this.mOnDragModeChangeListenersByGroup = new HashMap<>();
        this.f276949sx = 0.0f;
        this.f276950sy = 0.0f;
        this.f276948sm = 0.0f;
        super.setWillNotDraw(false);
        this.mMinCircleR = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.mMaxCircleR = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.mMaxDragLen = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }

    public QUIBadgeDragLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mMode = -1;
        this.mDragViewProviderByGroup = new HashMap<>();
        this.mPaint = new Paint();
        this.mOriginRect = new Rect();
        this.mCurPoint = new PointF(-1.0f, -1.0f);
        this.mOnDragModeChangeListeners = new ArrayList();
        this.mOnDragModeChangeListenersByGroup = new HashMap<>();
        this.f276949sx = 0.0f;
        this.f276950sy = 0.0f;
        this.f276948sm = 0.0f;
        super.setWillNotDraw(false);
        this.mMinCircleR = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.mMaxCircleR = (int) (getResources().getDisplayMetrics().density * 12.0f);
        this.mMaxDragLen = (int) (getResources().getDisplayMetrics().density * 48.0f);
    }
}
