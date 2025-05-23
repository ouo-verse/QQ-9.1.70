package com.tencent.filament.zplan.view.controller;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.filament.zplan.view.controller.FilamentTouchController$gestureListener$2;
import com.tencent.filament.zplan.view.controller.FilamentTouchController$scaleListener$2;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0002.3\u0018\u0000 ?2\u00020\u0001:\u0002\u0016\u001bB\u0017\u0012\u0006\u0010<\u001a\u00020\u001a\u0012\u0006\u0010;\u001a\u000208\u00a2\u0006\u0004\b=\u0010>J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001d\u0010)\u001a\u0004\u0018\u00010$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "", "Landroid/view/MotionEvent;", "event", "Lcom/tencent/filament/zplan/view/event/TouchEventState;", "state", "", "w", "Landroid/view/ScaleGestureDetector;", "detector", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/view/ScaleGestureDetector;Lcom/tencent/filament/zplan/view/event/TouchEventState;)Ljava/lang/Float;", HippyTKDListViewAdapter.X, "r", "u", "y", "Lcom/tencent/filament/zplan/view/event/TouchEventType;", "type", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "Ljava/lang/Float;", "beginSpan", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "b", "Ljava/lang/ref/WeakReference;", "contextRef", "", "c", "Z", "isScrolling", "d", "skipScrolling", "Landroid/view/GestureDetector;", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/GestureDetector;", "gestureDetector", "f", "o", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "com/tencent/filament/zplan/view/controller/FilamentTouchController$gestureListener$2$a", "g", DomainData.DOMAIN_NAME, "()Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$gestureListener$2$a;", "gestureListener", "com/tencent/filament/zplan/view/controller/FilamentTouchController$scaleListener$2$a", h.F, "p", "()Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$scaleListener$2$a;", "scaleListener", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "i", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "filamentRender", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;)V", "j", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentTouchController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Float beginSpan;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isScrolling;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean skipScrolling;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy gestureDetector;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy scaleGestureDetector;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy gestureListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy scaleListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b filamentRender;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface b {
        void q(@NotNull TouchEvent event);
    }

    public FilamentTouchController(@NotNull Context context, @NotNull b filamentRender) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        this.filamentRender = filamentRender;
        this.contextRef = new WeakReference<>(context);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.filament.zplan.view.controller.FilamentTouchController$gestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GestureDetector invoke() {
                WeakReference weakReference;
                Context context2;
                FilamentTouchController$gestureListener$2.a n3;
                weakReference = FilamentTouchController.this.contextRef;
                if (weakReference == null || (context2 = (Context) weakReference.get()) == null) {
                    return null;
                }
                n3 = FilamentTouchController.this.n();
                return new GestureDetector(context2, n3);
            }
        });
        this.gestureDetector = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ScaleGestureDetector>() { // from class: com.tencent.filament.zplan.view.controller.FilamentTouchController$scaleGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ScaleGestureDetector invoke() {
                WeakReference weakReference;
                Context context2;
                FilamentTouchController$scaleListener$2.a p16;
                weakReference = FilamentTouchController.this.contextRef;
                if (weakReference == null || (context2 = (Context) weakReference.get()) == null) {
                    return null;
                }
                p16 = FilamentTouchController.this.p();
                return new ScaleGestureDetector(context2, p16);
            }
        });
        this.scaleGestureDetector = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentTouchController$gestureListener$2.a>() { // from class: com.tencent.filament.zplan.view.controller.FilamentTouchController$gestureListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/filament/zplan/view/controller/FilamentTouchController$gestureListener$2$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "event", "", "onDown", "startEvent", "endEvent", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "e", "onSingleTapConfirmed", "onDoubleTap", "", e.a.NAME, "onSingleTapUp", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a extends GestureDetector.SimpleOnGestureListener {
                a() {
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(@Nullable MotionEvent e16) {
                    FilamentTouchController.this.r(e16);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(@Nullable MotionEvent event) {
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(@Nullable MotionEvent e16) {
                    FilamentTouchController.this.u(e16);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(@Nullable MotionEvent startEvent, @Nullable MotionEvent endEvent, float distanceX, float distanceY) {
                    boolean z16;
                    boolean z17;
                    z16 = FilamentTouchController.this.skipScrolling;
                    if (!z16) {
                        z17 = FilamentTouchController.this.isScrolling;
                        if (!z17) {
                            FilamentTouchController.this.w(startEvent, TouchEventState.Began);
                            FilamentTouchController.this.isScrolling = true;
                        }
                        FilamentTouchController.this.w(endEvent, TouchEventState.Changed);
                        return super.onScroll(startEvent, endEvent, distanceX, distanceY);
                    }
                    return super.onScroll(startEvent, endEvent, distanceX, distanceY);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
                    FilamentTouchController.this.x(e16);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@Nullable MotionEvent e16) {
                    FilamentTouchController.this.y(e16);
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.gestureListener = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentTouchController$scaleListener$2.a>() { // from class: com.tencent.filament.zplan.view.controller.FilamentTouchController$scaleListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/view/controller/FilamentTouchController$scaleListener$2$a", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScaleBegin", "onScale", "", "onScaleEnd", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
                a() {
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(@Nullable ScaleGestureDetector detector) {
                    FilamentTouchController.this.v(detector, TouchEventState.Changed);
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScaleBegin(@Nullable ScaleGestureDetector detector) {
                    FilamentTouchController.this.v(detector, TouchEventState.Began);
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public void onScaleEnd(@Nullable ScaleGestureDetector detector) {
                    FilamentTouchController.this.v(detector, TouchEventState.Ended);
                    super.onScaleEnd(detector);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.scaleListener = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FilamentTouchController$gestureListener$2.a n() {
        return (FilamentTouchController$gestureListener$2.a) this.gestureListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FilamentTouchController$scaleListener$2.a p() {
        return (FilamentTouchController$scaleListener$2.a) this.scaleListener.getValue();
    }

    private final Float q(ScaleGestureDetector detector, TouchEventState state) {
        if (state == TouchEventState.Began) {
            this.beginSpan = Float.valueOf(detector.getCurrentSpan());
            return Float.valueOf(1.0f);
        }
        if (this.beginSpan == null) {
            FLog.INSTANCE.e("FilamentTouchController", "getScaleRate failed, state: " + state + ", detector.span: " + detector.getCurrentSpan() + ", beginSpan: null");
            return null;
        }
        float currentSpan = detector.getCurrentSpan();
        Float f16 = this.beginSpan;
        Intrinsics.checkNotNull(f16);
        return Float.valueOf(currentSpan / f16.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MotionEvent event) {
        if (event != null) {
            t(this, event, TouchEventType.DoubleTap, null, 4, null);
        }
    }

    private final void s(MotionEvent event, TouchEventType type, TouchEventState state) {
        this.filamentRender.q(new TouchEvent(type, state, event.getPointerCount(), new PointF(event.getX(), event.getY()), null, null, 48, null));
    }

    static /* synthetic */ void t(FilamentTouchController filamentTouchController, MotionEvent motionEvent, TouchEventType touchEventType, TouchEventState touchEventState, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            touchEventState = TouchEventState.Began;
        }
        filamentTouchController.s(motionEvent, touchEventType, touchEventState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MotionEvent event) {
        if (event != null) {
            t(this, event, TouchEventType.LongPress, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(ScaleGestureDetector detector, TouchEventState state) {
        if (detector == null) {
            FLog.INSTANCE.w("FilamentTouchController", "handleScale failed, event null.");
            return;
        }
        Float q16 = q(detector, state);
        if (q16 != null && !Float.isNaN(q16.floatValue())) {
            this.filamentRender.q(new TouchEvent(TouchEventType.Pinch, state, 2, new PointF(detector.getFocusX(), detector.getFocusY()), null, q16, 16, null));
            return;
        }
        FLog.INSTANCE.e("FilamentTouchController", "scale error, state: " + state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(MotionEvent event, TouchEventState state) {
        if (event == null) {
            FLog.INSTANCE.w("FilamentTouchController", "handleScroll failed, event null.");
        } else {
            s(event, TouchEventType.Pan, state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(MotionEvent event) {
        if (event != null) {
            t(this, event, TouchEventType.Tap, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(MotionEvent event) {
        if (event != null) {
            t(this, event, TouchEventType.TapUp, null, 4, null);
        }
    }

    @Nullable
    public final GestureDetector m() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    @Nullable
    public final ScaleGestureDetector o() {
        return (ScaleGestureDetector) this.scaleGestureDetector.getValue();
    }

    public final void z(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 6) {
            this.skipScrolling = true;
        }
        int action = event.getAction();
        if (action == 1 || action == 3) {
            if (this.isScrolling) {
                this.isScrolling = false;
                w(event, TouchEventState.Ended);
            }
            this.skipScrolling = false;
        }
    }
}
