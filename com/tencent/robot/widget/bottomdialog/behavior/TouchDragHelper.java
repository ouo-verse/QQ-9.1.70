package com.tencent.robot.widget.bottomdialog.behavior;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010!\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b \u0010\u001eR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u0017\u0010\u001eR$\u0010\u000e\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper;", "", "Landroid/view/MotionEvent;", "ev", "", "e", "f", "g", "Landroid/graphics/PointF;", "another", "", "k", "i", "", "flag", h.F, "a", "set", "j", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper$a;", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper$a;", "callback", "Landroid/view/VelocityTracker;", "b", "Lkotlin/Lazy;", "d", "()Landroid/view/VelocityTracker;", "velocityTracker", "c", "Landroid/graphics/PointF;", "()Landroid/graphics/PointF;", "downPoint", "getPrevPoint", "prevPoint", "currPoint", "<set-?>", "I", "getFlag", "()I", "<init>", "(Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper$a;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class TouchDragHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy velocityTracker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF downPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF prevPoint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF currPoint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int flag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper$a;", "", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper;", "helper", "", "c", "", "deltaX", "deltaY", "b", "a", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        boolean a(@NotNull TouchDragHelper helper);

        boolean b(@NotNull TouchDragHelper helper, float deltaX, float deltaY);

        boolean c(@NotNull TouchDragHelper helper);
    }

    public TouchDragHelper(@NotNull a callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VelocityTracker>() { // from class: com.tencent.robot.widget.bottomdialog.behavior.TouchDragHelper$velocityTracker$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VelocityTracker invoke() {
                return VelocityTracker.obtain();
            }
        });
        this.velocityTracker = lazy;
        this.downPoint = new PointF(0.0f, 0.0f);
        this.prevPoint = new PointF(0.0f, 0.0f);
        this.currPoint = new PointF(0.0f, 0.0f);
    }

    private final boolean e(MotionEvent ev5) {
        this.downPoint.set(ev5.getX(), ev5.getY());
        k(this.prevPoint, this.downPoint);
        k(this.currPoint, this.prevPoint);
        d().addMovement(ev5);
        boolean c16 = this.callback.c(this);
        j(1, c16);
        return c16;
    }

    private final boolean f(MotionEvent ev5) {
        if (!h(1)) {
            return false;
        }
        d().addMovement(ev5);
        this.currPoint.set(ev5.getX(), ev5.getY());
        a aVar = this.callback;
        PointF pointF = this.currPoint;
        float f16 = pointF.x;
        PointF pointF2 = this.prevPoint;
        boolean b16 = aVar.b(this, f16 - pointF2.x, pointF.y - pointF2.y);
        k(this.prevPoint, this.currPoint);
        return b16;
    }

    private final boolean g(MotionEvent ev5) {
        boolean a16;
        if (!h(1)) {
            return false;
        }
        if (ev5.getAction() == 1) {
            d().addMovement(ev5);
            this.currPoint.set(ev5.getX(), ev5.getY());
            a16 = this.callback.a(this);
            k(this.prevPoint, this.currPoint);
        } else {
            a16 = this.callback.a(this);
        }
        a(1);
        return a16;
    }

    private final void k(PointF pointF, PointF pointF2) {
        pointF.set(pointF2.x, pointF2.y);
    }

    public final void a(int flag) {
        this.flag = (~flag) & this.flag;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final PointF getCurrPoint() {
        return this.currPoint;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final PointF getDownPoint() {
        return this.downPoint;
    }

    @NotNull
    public final VelocityTracker d() {
        Object value = this.velocityTracker.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-velocityTracker>(...)");
        return (VelocityTracker) value;
    }

    public final boolean h(int flag) {
        if ((flag & this.flag) != 0) {
            return true;
        }
        return false;
    }

    public final boolean i(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return f(ev5);
                }
            }
            return g(ev5);
        }
        return e(ev5);
    }

    public final void j(int flag, boolean set) {
        int i3;
        if (set) {
            i3 = flag | this.flag;
        } else {
            i3 = (~flag) & this.flag;
        }
        this.flag = i3;
    }
}
