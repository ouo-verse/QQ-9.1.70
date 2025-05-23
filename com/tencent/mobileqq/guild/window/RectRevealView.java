package com.tencent.mobileqq.guild.window;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/window/RectRevealView;", "Landroid/widget/FrameLayout;", "", "left", "top", "right", "bottom", "", "duration", "", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "I", "mHeight", "e", "mWidth", "", "f", UserInfo.SEX_FEMALE, "mLeft", tl.h.F, "mTop", "i", "mRight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBottom", BdhLogUtil.LogTag.Tag_Conn, "mPercent", "", "D", "Z", "start", "Landroid/graphics/Rect;", "E", "Landroid/graphics/Rect;", "getMRect", "()Landroid/graphics/Rect;", "mRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class RectRevealView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float mPercent;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean start;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Rect mRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mLeft;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mTop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mRight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mBottom;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectRevealView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RectRevealView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mWidth = this$0.getWidth();
        this$0.mHeight = this$0.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(RectRevealView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mPercent = valueAnimator.getAnimatedFraction();
        this$0.invalidate();
        this$0.start = true;
    }

    public final void d(int left, int top, int right, int bottom, long duration) {
        this.mLeft = left;
        this.mTop = top;
        this.mRight = right;
        this.mBottom = bottom;
        animate().setDuration(duration).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.window.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RectRevealView.e(RectRevealView.this, valueAnimator);
            }
        }).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        if (this.start) {
            Rect rect = this.mRect;
            float f16 = this.mLeft;
            float f17 = this.mPercent;
            rect.left = (int) (f16 * f17);
            rect.top = (int) (this.mTop * f17);
            rect.right = (int) (this.mWidth - (this.mRight * f17));
            rect.bottom = (int) (this.mHeight - (this.mBottom * f17));
            if (canvas != null) {
                canvas.save();
                canvas.clipRect(this.mRect);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectRevealView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RectRevealView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RectRevealView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRect = new Rect();
        post(new Runnable() { // from class: com.tencent.mobileqq.guild.window.q
            @Override // java.lang.Runnable
            public final void run() {
                RectRevealView.c(RectRevealView.this);
            }
        });
    }
}
