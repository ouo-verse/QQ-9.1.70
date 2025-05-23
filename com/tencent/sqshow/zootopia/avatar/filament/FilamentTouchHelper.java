package com.tencent.sqshow.zootopia.avatar.filament;

import android.graphics.PointF;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", "e", "f", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "scene", "j", "", "width", "height", "k", "b", "d", "a", "c", tl.h.F, "i", "g", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mEnableScale", "mEnableRotate", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "mLastPanPoint", "mLastPinchPoint", "", UserInfo.SEX_FEMALE, "mLastScale", "mScaleDeltaSum", "mViewWidth", "mViewHeight", "<init>", "(Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentTouchHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IPortalBusiness scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mEnableScale = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mEnableRotate = new AtomicBoolean(true);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PointF mLastPanPoint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PointF mLastPinchPoint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mLastScale;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mScaleDeltaSum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mViewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mViewHeight;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f369960a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f369961b;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.Pan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.Pinch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f369960a = iArr;
            int[] iArr2 = new int[TouchEventState.values().length];
            try {
                iArr2[TouchEventState.Began.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            f369961b = iArr2;
        }
    }

    public FilamentTouchHelper(IPortalBusiness iPortalBusiness) {
        this.scene = iPortalBusiness;
        e84.a aVar = e84.a.f395879a;
        this.mViewWidth = com.tencent.sqshow.zootopia.utils.i.c(aVar.f());
        this.mViewHeight = com.tencent.sqshow.zootopia.utils.i.c(aVar.e());
    }

    private final void e(TouchEvent event) {
        final FilamentViewerV2 viewer;
        IPortalBusiness iPortalBusiness;
        if (!this.mEnableRotate.get()) {
            h();
            return;
        }
        if (b.f369961b[event.getState().ordinal()] == 1) {
            this.mLastPanPoint = event.getLocation();
            return;
        }
        this.mLastPinchPoint = null;
        PointF pointF = this.mLastPanPoint;
        if (pointF == null) {
            return;
        }
        float f16 = event.getLocation().x - pointF.x;
        this.mLastPanPoint = event.getLocation();
        final float f17 = (float) ((f16 / this.mViewWidth) * 3.141592653589793d);
        IPortalBusiness iPortalBusiness2 = this.scene;
        if (iPortalBusiness2 == null || (viewer = iPortalBusiness2.getViewer()) == null || (iPortalBusiness = this.scene) == null) {
            return;
        }
        iPortalBusiness.runOnViewerThread("resetRotation", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper$handlePanEvent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentViewerV2.this.rotateAvatar(new RotateParam(0.0f, 1.0f, 0.0f, f17));
            }
        });
    }

    private final void f(TouchEvent event) {
        final FilamentViewerV2 viewer;
        IPortalBusiness iPortalBusiness;
        if (!this.mEnableScale.get()) {
            i();
            return;
        }
        if (b.f369961b[event.getState().ordinal()] == 1) {
            this.mLastPinchPoint = event.getLocation();
            Float scale = event.getScale();
            this.mLastScale = scale != null ? scale.floatValue() : 0.0f;
            return;
        }
        this.mLastPanPoint = null;
        float f16 = this.mLastScale;
        Float scale2 = event.getScale();
        if (this.mLastPinchPoint != null) {
            if ((f16 == 0.0f) || scale2 == null) {
                return;
            }
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            float floatValue = scale2.floatValue() - f16;
            floatRef.element = floatValue;
            float f17 = this.mScaleDeltaSum + floatValue;
            this.mScaleDeltaSum = f17;
            if (f17 < 0.0f) {
                this.mScaleDeltaSum = 0.0f;
                scale2 = Float.valueOf(f16);
                floatRef.element = 0.0f;
            } else if (f17 > 10.0f) {
                this.mScaleDeltaSum = 10.0f;
                scale2 = Float.valueOf(f16);
                floatRef.element = 0.0f;
            }
            this.mLastScale = scale2.floatValue();
            QLog.i("FilamentTouchHelper", 1, "mScaleDeltaSum:" + this.mScaleDeltaSum);
            final float f18 = event.getLocation().x;
            final float f19 = this.mViewHeight - event.getLocation().y;
            QLog.i("FilamentTouchHelper", 1, "scaleDelta:" + floatRef.element + ", lastScale:" + f16 + ", currentScale:" + scale2 + ", scaleCenterX:" + f18 + ", scaleCenterY:" + f19);
            IPortalBusiness iPortalBusiness2 = this.scene;
            if (iPortalBusiness2 == null || (viewer = iPortalBusiness2.getViewer()) == null || (iPortalBusiness = this.scene) == null) {
                return;
            }
            iPortalBusiness.runOnViewerThread("scrollCameraManipulator", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper$handlePinchEvent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentViewerV2.this.scrollCameraManipulator(f18, f19, (-1) * floatRef.element * 100);
                }
            });
        }
    }

    public final void c() {
        QLog.i("FilamentTouchHelper", 1, "enableRotate");
        this.mEnableRotate.set(true);
    }

    public final void g(TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = b.f369960a[event.getType().ordinal()];
        if (i3 == 1) {
            e(event);
        } else {
            if (i3 != 2) {
                return;
            }
            f(event);
        }
    }

    public final void j(IPortalBusiness scene) {
        this.scene = scene;
    }

    public final void k(int width, int height) {
        QLog.i("FilamentTouchHelper", 1, "updateViewport width:" + width + ", height:" + height);
        this.mViewWidth = (float) width;
        this.mViewHeight = (float) height;
    }

    public final void a() {
        QLog.i("FilamentTouchHelper", 1, "disableRotate");
        this.mEnableRotate.set(false);
        h();
    }

    public final void b() {
        QLog.i("FilamentTouchHelper", 1, "disableScale");
        this.mEnableScale.set(false);
        i();
    }

    public final void d() {
        QLog.i("FilamentTouchHelper", 1, "enableScale");
    }

    public final void h() {
        final FilamentViewerV2 viewer;
        IPortalBusiness iPortalBusiness;
        QLog.i("FilamentTouchHelper", 1, "resetRotate");
        IPortalBusiness iPortalBusiness2 = this.scene;
        if (iPortalBusiness2 == null || (viewer = iPortalBusiness2.getViewer()) == null || (iPortalBusiness = this.scene) == null) {
            return;
        }
        iPortalBusiness.runOnViewerThread("resetRotation", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper$resetRotate$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentViewerV2.this.resetRotation();
            }
        });
    }

    public final void i() {
        final FilamentViewerV2 viewer;
        IPortalBusiness iPortalBusiness;
        QLog.i("FilamentTouchHelper", 1, "resetScale");
        IPortalBusiness iPortalBusiness2 = this.scene;
        if (iPortalBusiness2 != null && (viewer = iPortalBusiness2.getViewer()) != null && (iPortalBusiness = this.scene) != null) {
            iPortalBusiness.runOnViewerThread("resetCameraManipulator", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper$resetScale$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentViewerV2.this.resetCameraManipulator();
                }
            });
        }
        this.mScaleDeltaSum = 0.0f;
    }
}
