package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0002[\u001aB\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TB\u001b\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u00a2\u0006\u0004\bS\u0010WB#\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\u0006\u0010X\u001a\u00020\u0007\u00a2\u0006\u0004\bS\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0014J\u0016\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0016R\"\u00101\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R$\u0010=\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010?\u001a\u0004\b4\u0010@R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010CR\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010,R\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010KR\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010K\u00a8\u0006\\"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout;", "Landroid/widget/FrameLayout;", "", "g", "", "deltaX", "deltaY", "", "d", "Landroid/graphics/PointF;", "downPoint", "upX", "upY", "", "deltaTime", "", h.F, "draggingType", "deltaXDown", "deltaYDown", "widthAfterFactor", "heightAfterFactor", "e", "startX", "startY", "startScale", "b", "k", "scale", "width", "height", "j", "factor", "l", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "clipTop", "clipHeight", "setClipVertical", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "Z", "i", "()Z", "setFeatureEnable", "(Z)V", "isFeatureEnable", "isEnableDragHorizontal", "setEnableDragHorizontal", "f", "isEnableDragVertical", "setEnableDragVertical", "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout$b;", "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout$b;", "getOnDragListener", "()Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout$b;", "setOnDragListener", "(Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout$b;)V", "onDragListener", "Landroid/graphics/drawable/ColorDrawable;", "Lkotlin/Lazy;", "()Landroid/graphics/drawable/ColorDrawable;", "windowBgDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/PointF;", BdhLogUtil.LogTag.Tag_Conn, "lastPoint", "D", "startDragPoint", "E", "isDragging", UserInfo.SEX_FEMALE, "I", "touchSlop", "G", "H", "J", "downTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSDragFrameLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private PointF lastPoint;

    /* renamed from: D, reason: from kotlin metadata */
    private PointF startDragPoint;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDragging;

    /* renamed from: F, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: G, reason: from kotlin metadata */
    private int draggingType;

    /* renamed from: H, reason: from kotlin metadata */
    private long downTime;

    /* renamed from: I, reason: from kotlin metadata */
    private int clipTop;

    /* renamed from: J, reason: from kotlin metadata */
    private int clipHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFeatureEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableDragHorizontal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableDragVertical;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b onDragListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy windowBgDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PointF downPoint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSDragFrameLayout$b;", "", "", "onStartDrag", "", "isDragToClose", "onEndDrag", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void onEndDrag(boolean isDragToClose);

        void onStartDrag();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WSDragFrameLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WSDragFrameLayout this$0, float f16, float f17, float f18, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f19 = 1;
        float animatedFraction = f19 - valueAnimator.getAnimatedFraction();
        this$0.setTranslationX(f16 * animatedFraction);
        this$0.setTranslationY(f17 * animatedFraction);
        this$0.setScaleX(f18 + ((f19 - f18) * valueAnimator.getAnimatedFraction()));
        this$0.setScaleY(this$0.getScaleX());
    }

    private final int d(float deltaX, float deltaY) {
        boolean z16 = Math.abs(deltaX) > Math.abs(deltaY);
        if (z16 && this.isEnableDragHorizontal && deltaX > this.touchSlop) {
            return 1;
        }
        return (z16 || !this.isEnableDragVertical || deltaY <= ((float) this.touchSlop)) ? 0 : 2;
    }

    private final float e(int draggingType, float deltaXDown, float deltaYDown, float widthAfterFactor, float heightAfterFactor) {
        float f16;
        if (draggingType != 1) {
            if (draggingType != 2) {
                f16 = 1.0f;
            } else {
                f16 = 1.0f - (deltaYDown / heightAfterFactor);
            }
        } else {
            f16 = 1.0f - (deltaXDown / widthAfterFactor);
        }
        if (f16 - 0.5f < 1.0E-15d) {
            return 0.5f;
        }
        if (f16 - 1.0f > 1.0E-15d) {
            return 1.0f;
        }
        return f16;
    }

    private final ColorDrawable f() {
        return (ColorDrawable) this.windowBgDrawable.getValue();
    }

    private final void g() {
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setWillNotDraw(false);
    }

    private final boolean h(PointF downPoint, float upX, float upY, long deltaTime) {
        float f16 = upX - downPoint.x;
        float f17 = upY - downPoint.y;
        float f18 = ((float) deltaTime) / 1000.0f;
        return f16 / f18 > 500.0f || f17 / f18 > 500.0f;
    }

    private final void k(float deltaX, float deltaY) {
        setTranslationX(getTranslationX() + deltaX);
        setTranslationY(getTranslationY() + deltaY);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsFeatureEnable() {
        return this.isFeatureEnable;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.clipHeight > 0) {
            canvas.clipRect(0, this.clipTop, canvas.getWidth(), this.clipTop + this.clipHeight);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.isFeatureEnable) {
            return super.onInterceptTouchEvent(ev5);
        }
        int action = ev5.getAction();
        if (action == 0) {
            this.downTime = System.currentTimeMillis();
            this.downPoint.set(ev5.getRawX(), ev5.getRawY());
        } else if (action == 2) {
            int d16 = d(ev5.getRawX() - this.downPoint.x, ev5.getRawY() - this.downPoint.y);
            this.draggingType = d16;
            if (this.isDragging || d16 == 1 || d16 == 2) {
                b bVar = this.onDragListener;
                if (bVar != null) {
                    bVar.onStartDrag();
                }
                this.isDragging = true;
                this.lastPoint.set(ev5.getRawX(), ev5.getRawY());
                this.startDragPoint.set(ev5.getRawX(), ev5.getRawY());
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        if (r0 != 3) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.isFeatureEnable) {
            return super.onTouchEvent(ev5);
        }
        int action = ev5.getAction();
        if (action != 1) {
            if (action == 2) {
                float rawX = ev5.getRawX();
                float rawY = ev5.getRawY();
                PointF pointF = this.lastPoint;
                float f16 = rawX - pointF.x;
                float f17 = rawY - pointF.y;
                pointF.set(rawX, rawY);
                int i3 = this.draggingType;
                PointF pointF2 = this.startDragPoint;
                float e16 = e(i3, rawX - pointF2.x, rawY - pointF2.y, getWidth() * 1.8f, getHeight() * 1.8f);
                j(e16, getWidth(), getHeight());
                k(f16, f17);
                l(e16);
            }
            return super.onTouchEvent(ev5);
        }
        this.isDragging = false;
        this.draggingType = 0;
        if (getScaleX() - 0.9f >= 1.0E-6d && !h(this.downPoint, ev5.getRawX(), ev5.getRawY(), System.currentTimeMillis() - this.downTime)) {
            b bVar = this.onDragListener;
            if (bVar != null) {
                bVar.onEndDrag(false);
            }
            b(getTranslationX(), getTranslationY(), getScaleX());
        } else {
            b bVar2 = this.onDragListener;
            if (bVar2 != null) {
                bVar2.onEndDrag(true);
            }
        }
        return super.onTouchEvent(ev5);
    }

    public final void setClipVertical(int clipTop, int clipHeight) {
        this.clipTop = clipTop;
        this.clipHeight = clipHeight;
    }

    public final void setEnableDragHorizontal(boolean z16) {
        this.isEnableDragHorizontal = z16;
    }

    public final void setEnableDragVertical(boolean z16) {
        this.isEnableDragVertical = z16;
    }

    public final void setFeatureEnable(boolean z16) {
        this.isFeatureEnable = z16;
    }

    public final void setOnDragListener(b bVar) {
        this.onDragListener = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WSDragFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(final float startX, final float startY, final float startScale) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WSDragFrameLayout.c(WSDragFrameLayout.this, startX, startY, startScale, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSDragFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isEnableDragHorizontal = true;
        this.isEnableDragVertical = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ColorDrawable>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSDragFrameLayout$windowBgDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorDrawable invoke() {
                return new ColorDrawable(-33554432);
            }
        });
        this.windowBgDrawable = lazy;
        this.downPoint = new PointF();
        this.lastPoint = new PointF();
        this.startDragPoint = new PointF();
        g();
    }

    private final void j(float scale, float width, float height) {
        float f16 = 2;
        setPivotX(width / f16);
        setPivotY(height / f16);
        setScaleX(scale);
        setScaleY(scale);
    }

    private final void l(float factor) {
        int i3 = 255;
        int i16 = (int) (factor * 0.5f * 255);
        if (i16 < 0) {
            i3 = 0;
        } else if (i16 <= 255) {
            i3 = i16;
        }
        f().setAlpha(i3);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).getWindow().setBackgroundDrawable(f());
    }
}
