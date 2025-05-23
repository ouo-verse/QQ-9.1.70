package com.tencent.mobileqq.guild.media.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001BB)\b\u0007\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\t\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010#\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010.R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u00108\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRoomMsgGuideView;", "Landroid/view/View;", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "", "Landroid/animation/Animator;", "r", "", "count", "setAnimMaxStartCount", "Ljava/lang/Runnable;", "runnable", "setAnimFinishCallBack", "u", "l", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "mAnimMaxCount", "e", "mFinishAnimCount", "f", "Ljava/lang/Runnable;", "mAnimFinishCallback", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "mHandler", "i", "invalidateRunnable", "delayRestartRunnable", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Paint;", "mPaint", "", "D", "[I", "mCircleCurTransValue", "", "E", UserInfo.SEX_FEMALE, "mCurScaleValue", "mCurAlphaValue", "Landroid/animation/ValueAnimator;", "G", "Landroid/animation/ValueAnimator;", "mScaleAnimator", "H", "mAlphaAnimator", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "mAnimatorSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaRoomMsgGuideView extends View {
    private static final int K = ViewUtils.dip2px(167.0f);

    @NotNull
    private static final int[] L = {ViewUtils.dip2px(42.0f), ViewUtils.dip2px(39.0f), ViewUtils.dip2px(37.0f), ViewUtils.dip2px(36.0f), ViewUtils.dip2px(32.0f)};

    @NotNull
    private static final float[] M = {1.0f, 0.8f, 0.6f, 0.4f, 0.2f};

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final int[] mCircleCurTransValue;

    /* renamed from: E, reason: from kotlin metadata */
    private float mCurScaleValue;

    /* renamed from: F, reason: from kotlin metadata */
    private float mCurAlphaValue;

    /* renamed from: G, reason: from kotlin metadata */
    private ValueAnimator mScaleAnimator;

    /* renamed from: H, reason: from kotlin metadata */
    private ValueAnimator mAlphaAnimator;

    /* renamed from: I, reason: from kotlin metadata */
    private AnimatorSet mAnimatorSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mAnimMaxCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFinishAnimCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mAnimFinishCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable invalidateRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable delayRestartRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaRoomMsgGuideView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            GuildMediaRoomMsgGuideView.this.mFinishAnimCount++;
            if (GuildMediaRoomMsgGuideView.this.mFinishAnimCount < GuildMediaRoomMsgGuideView.this.mAnimMaxCount) {
                GuildMediaRoomMsgGuideView.this.mHandler.postDelayed(GuildMediaRoomMsgGuideView.this.delayRestartRunnable, 300L);
                return;
            }
            GuildMediaRoomMsgGuideView.this.l();
            Runnable runnable = GuildMediaRoomMsgGuideView.this.mAnimFinishCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @JvmOverloads
    public GuildMediaRoomMsgGuideView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    private final void m() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 0.5f, 1f, 1f)");
        this.mAlphaAnimator = ofFloat;
        ValueAnimator valueAnimator = null;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaAnimator");
            ofFloat = null;
        }
        ofFloat.setDuration(630L);
        ValueAnimator valueAnimator2 = this.mAlphaAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaAnimator");
            valueAnimator2 = null;
        }
        valueAnimator2.setInterpolator(new LinearInterpolator());
        ValueAnimator valueAnimator3 = this.mAlphaAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaAnimator");
        } else {
            valueAnimator = valueAnimator3;
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                GuildMediaRoomMsgGuideView.n(GuildMediaRoomMsgGuideView.this, valueAnimator4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildMediaRoomMsgGuideView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mCurAlphaValue = ((Float) animatedValue).floatValue();
    }

    private final void o() {
        m();
        p();
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.addListener(new b());
        AnimatorSet animatorSet2 = this.mAnimatorSet;
        AnimatorSet animatorSet3 = null;
        if (animatorSet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            animatorSet2 = null;
        }
        Animator[] animatorArr = new Animator[2];
        ValueAnimator valueAnimator = this.mScaleAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleAnimator");
            valueAnimator = null;
        }
        animatorArr[0] = valueAnimator;
        ValueAnimator valueAnimator2 = this.mAlphaAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaAnimator");
            valueAnimator2 = null;
        }
        animatorArr[1] = valueAnimator2;
        animatorSet2.playTogether(animatorArr);
        AnimatorSet animatorSet4 = this.mAnimatorSet;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
        } else {
            animatorSet3 = animatorSet4;
        }
        animatorSet3.playTogether(r());
    }

    private final void p() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.55f, 1.1f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 0.55f, 1.1f, 1.0f)");
        this.mScaleAnimator = ofFloat;
        ValueAnimator valueAnimator = null;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleAnimator");
            ofFloat = null;
        }
        ofFloat.setDuration(630L);
        ValueAnimator valueAnimator2 = this.mScaleAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleAnimator");
            valueAnimator2 = null;
        }
        valueAnimator2.setInterpolator(new LinearInterpolator());
        ValueAnimator valueAnimator3 = this.mScaleAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleAnimator");
        } else {
            valueAnimator = valueAnimator3;
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.aa
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                GuildMediaRoomMsgGuideView.q(GuildMediaRoomMsgGuideView.this, valueAnimator4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildMediaRoomMsgGuideView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mCurScaleValue = ((Float) animatedValue).floatValue();
    }

    private final List<Animator> r() {
        ArrayList arrayList = new ArrayList();
        int length = L.length;
        for (final int i3 = 0; i3 < length; i3++) {
            ValueAnimator animator = ValueAnimator.ofInt(0, K);
            animator.setStartDelay((i3 * 40) + 630);
            animator.setDuration(870L);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.y
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildMediaRoomMsgGuideView.s(GuildMediaRoomMsgGuideView.this, i3, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(animator, "animator");
            arrayList.add(animator);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GuildMediaRoomMsgGuideView this$0, int i3, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        int[] iArr = this$0.mCircleCurTransValue;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        iArr[i3] = ((Integer) animatedValue).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildMediaRoomMsgGuideView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    public final void l() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            animatorSet = null;
        }
        animatorSet.removeAllListeners();
        AnimatorSet animatorSet3 = this.mAnimatorSet;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            animatorSet3 = null;
        }
        if (animatorSet3.isRunning()) {
            AnimatorSet animatorSet4 = this.mAnimatorSet;
            if (animatorSet4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            } else {
                animatorSet2 = animatorSet4;
            }
            animatorSet2.cancel();
        }
        this.mHandler.removeCallbacks(this.invalidateRunnable);
        this.mHandler.removeCallbacks(this.delayRestartRunnable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = (measuredWidth - K) / 2;
        int i16 = measuredHeight / 2;
        if (this.mCircleCurTransValue[0] > 0) {
            int length = L.length;
            for (int i17 = 0; i17 < length; i17++) {
                this.mPaint.setAlpha((int) (M[i17] * 255));
                canvas.drawCircle(this.mCircleCurTransValue[i17] + i3, i16, (L[i17] / 2.0f) * this.mCurScaleValue, this.mPaint);
            }
            return;
        }
        this.mPaint.setAlpha((int) (this.mCurAlphaValue * 255));
        canvas.drawCircle(i3, i16, (L[0] / 2.0f) * this.mCurScaleValue, this.mPaint);
    }

    public final void setAnimFinishCallBack(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.mAnimFinishCallback = runnable;
    }

    public final void setAnimMaxStartCount(int count) {
        this.mAnimMaxCount = count;
    }

    public final void u() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            animatorSet = null;
        }
        if (!animatorSet.isRunning()) {
            AnimatorSet animatorSet3 = this.mAnimatorSet;
            if (animatorSet3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
            } else {
                animatorSet2 = animatorSet3;
            }
            animatorSet2.start();
            this.mHandler.removeCallbacks(this.invalidateRunnable);
            this.mHandler.post(this.invalidateRunnable);
        }
    }

    @JvmOverloads
    public GuildMediaRoomMsgGuideView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GuildMediaRoomMsgGuideView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @JvmOverloads
    public GuildMediaRoomMsgGuideView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAnimMaxCount = Integer.MAX_VALUE;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.invalidateRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRoomMsgGuideView$invalidateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                AnimatorSet animatorSet;
                GuildMediaRoomMsgGuideView.this.invalidate();
                GuildMediaRoomMsgGuideView.this.mHandler.removeCallbacks(this);
                animatorSet = GuildMediaRoomMsgGuideView.this.mAnimatorSet;
                if (animatorSet == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAnimatorSet");
                    animatorSet = null;
                }
                if (animatorSet.isRunning()) {
                    GuildMediaRoomMsgGuideView.this.mHandler.postDelayed(this, 16L);
                }
            }
        };
        this.delayRestartRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.x
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaRoomMsgGuideView.t(GuildMediaRoomMsgGuideView.this);
            }
        };
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mCircleCurTransValue = new int[L.length];
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        o();
    }
}
