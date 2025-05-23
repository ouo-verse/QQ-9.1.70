package com.tencent.qqnt.qbasealbum.preview.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001\u000bB\u0019\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010)\u001a\u00020\"\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/a;", "", "Landroid/view/MotionEvent;", "ev", "", "b", "c", "", "g", "f", "", "a", "I", "mActivePointerId", "mActivePointerIndex", "Landroid/view/ScaleGestureDetector;", "Landroid/view/ScaleGestureDetector;", "mDetector", "Landroid/view/VelocityTracker;", "d", "Landroid/view/VelocityTracker;", "mVelocityTracker", "<set-?>", "e", "Z", "()Z", "isDragging", UserInfo.SEX_FEMALE, "mLastTouchX", "mLastTouchY", h.F, "mTouchSlop", "i", "mMinimumVelocity", "Lcom/tencent/qqnt/qbasealbum/preview/view/b;", "j", "Lcom/tencent/qqnt/qbasealbum/preview/view/b;", "mOnGestureListener", "isScaling", "Landroid/content/Context;", "context", "onGestureListener", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/qbasealbum/preview/view/b;)V", "k", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mActivePointerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mActivePointerIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScaleGestureDetector mDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VelocityTracker mVelocityTracker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDragging;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mLastTouchX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mLastTouchY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float mTouchSlop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float mMinimumVelocity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.preview.view.b mOnGestureListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/a$a;", "", "", "INVALID_POINTER_ID", "I", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.preview.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/view/a$b", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScale", "onScaleBegin", "", "onScaleEnd", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector detector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) detector)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(detector, "detector");
            float scaleFactor = detector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                if (scaleFactor >= 0.0f) {
                    a.this.mOnGestureListener.onScale(scaleFactor, detector.getFocusX(), detector.getFocusY());
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(@NotNull ScaleGestureDetector detector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detector)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(detector, "detector");
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(@NotNull ScaleGestureDetector detector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) detector);
            } else {
                Intrinsics.checkNotNullParameter(detector, "detector");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable Context context, @NotNull com.tencent.qqnt.qbasealbum.preview.view.b onGestureListener) {
        Intrinsics.checkNotNullParameter(onGestureListener, "onGestureListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) onGestureListener);
            return;
        }
        this.mActivePointerId = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mOnGestureListener = onGestureListener;
        this.mDetector = new ScaleGestureDetector(context, new b());
    }

    private final float b(MotionEvent ev5) {
        try {
            return ev5.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return ev5.getX();
        }
    }

    private final float c(MotionEvent ev5) {
        try {
            return ev5.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return ev5.getY();
        }
    }

    private final boolean g(MotionEvent ev5) {
        float coerceAtLeast;
        boolean z16;
        int i3;
        int action = ev5.getAction() & 255;
        int i16 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int a16 = c.a(ev5.getAction());
                            if (ev5.getPointerId(a16) == this.mActivePointerId) {
                                if (a16 == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.mActivePointerId = ev5.getPointerId(i3);
                                this.mLastTouchX = ev5.getX(i3);
                                this.mLastTouchY = ev5.getY(i3);
                            }
                        }
                    } else {
                        this.mActivePointerId = -1;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            Intrinsics.checkNotNull(velocityTracker);
                            velocityTracker.recycle();
                            this.mVelocityTracker = null;
                        }
                    }
                } else {
                    float b16 = b(ev5);
                    float c16 = c(ev5);
                    int pointerCount = ev5.getPointerCount();
                    float f16 = b16 - this.mLastTouchX;
                    float f17 = c16 - this.mLastTouchY;
                    if (!this.isDragging) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.mTouchSlop) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.isDragging = z16;
                    }
                    if (pointerCount > 1) {
                        this.isDragging = false;
                    }
                    if (this.isDragging) {
                        this.mLastTouchX = b16;
                        this.mLastTouchY = c16;
                        VelocityTracker velocityTracker2 = this.mVelocityTracker;
                        if (velocityTracker2 != null) {
                            Intrinsics.checkNotNull(velocityTracker2);
                            velocityTracker2.addMovement(ev5);
                        }
                    }
                }
            } else {
                this.mActivePointerId = -1;
                if (this.isDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = b(ev5);
                    this.mLastTouchY = c(ev5);
                    VelocityTracker velocityTracker3 = this.mVelocityTracker;
                    Intrinsics.checkNotNull(velocityTracker3);
                    velocityTracker3.addMovement(ev5);
                    VelocityTracker velocityTracker4 = this.mVelocityTracker;
                    Intrinsics.checkNotNull(velocityTracker4);
                    velocityTracker4.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker5 = this.mVelocityTracker;
                    Intrinsics.checkNotNull(velocityTracker5);
                    float xVelocity = velocityTracker5.getXVelocity();
                    VelocityTracker velocityTracker6 = this.mVelocityTracker;
                    Intrinsics.checkNotNull(velocityTracker6);
                    float yVelocity = velocityTracker6.getYVelocity();
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.abs(xVelocity), Math.abs(yVelocity));
                    if (coerceAtLeast >= this.mMinimumVelocity) {
                        this.mOnGestureListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker7 = this.mVelocityTracker;
                if (velocityTracker7 != null) {
                    Intrinsics.checkNotNull(velocityTracker7);
                    velocityTracker7.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else {
            this.mActivePointerId = ev5.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            if (obtain != null) {
                Intrinsics.checkNotNull(obtain);
                obtain.addMovement(ev5);
            }
            this.mLastTouchX = b(ev5);
            this.mLastTouchY = c(ev5);
            this.isDragging = false;
        }
        int i17 = this.mActivePointerId;
        if (i17 != -1) {
            i16 = i17;
        }
        this.mActivePointerIndex = ev5.findPointerIndex(i16);
        return true;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isDragging;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mDetector.isInProgress();
    }

    public final boolean f(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        try {
            boolean onTouchEvent = this.mDetector.onTouchEvent(ev5);
            boolean g16 = g(ev5);
            if (!onTouchEvent || !g16) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
