package com.tencent.storage.view.pv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001SB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0018\u00a2\u0006\u0004\bP\u0010QJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0014J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0014J\u0016\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u001e\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010,R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010,R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010=R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010=R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010=R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010DR\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010,R\u0014\u0010H\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010G\u00a8\u0006T"}, d2 = {"Lcom/tencent/storage/view/pv/LoadingProgressView;", "Landroid/view/View;", "", "bottomAngle", "topAngle", "", "e", "Lkotlin/Function0;", "recoverCompleteAction", "k", "Landroid/graphics/Canvas;", PM.CANVAS, "j", h.F, "i", "bottomPercent", "topPercent", "g", "targetBottomPercent", "targetTopPercent", DomainData.DOMAIN_NAME, "topProgress", "setTopProgress", "onDraw", "", "width", "height", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "startColor", "endColor", "setTopPaintShader", "setBottomPaintShader", "Landroid/graphics/Paint;", "paint", "setPaintShader", "", "duration", "setDuration", "", "d", "Z", "isSmallDimen", UserInfo.SEX_FEMALE, "progressWidth", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "f", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "rotateInterpolator", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "viewBounds", "curBottomAngle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curTopAngle", BdhLogUtil.LogTag.Tag_Conn, "targetBottomAngle", "D", "targetTopAngle", "E", "I", "bottomStartColor", "bottomEndColor", "G", "topStartColor", "H", "topEndColor", "J", "rotateDegree", "K", "Landroid/graphics/Paint;", "topPBPaint", "L", "bottomPBPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LoadingProgressView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float targetBottomAngle;

    /* renamed from: D, reason: from kotlin metadata */
    private float targetTopAngle;

    /* renamed from: E, reason: from kotlin metadata */
    private int bottomStartColor;

    /* renamed from: F, reason: from kotlin metadata */
    private int bottomEndColor;

    /* renamed from: G, reason: from kotlin metadata */
    private int topStartColor;

    /* renamed from: H, reason: from kotlin metadata */
    private int topEndColor;

    /* renamed from: I, reason: from kotlin metadata */
    private long duration;

    /* renamed from: J, reason: from kotlin metadata */
    private float rotateDegree;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Paint topPBPaint;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Paint bottomPBPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSmallDimen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float progressWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AccelerateDecelerateInterpolator rotateInterpolator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF viewBounds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float curBottomAngle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float curTopAngle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/storage/view/pv/LoadingProgressView$a;", "", "", "BOTTOM_END_COLOR", "Ljava/lang/String;", "BOTTOM_START_COLOR", "", "DURATION_ONE_ROUND", "J", "", "PROGRESS_WIDTH", UserInfo.SEX_FEMALE, "PROGRESS_WIDTH_SMALL", "START_ANGLE", "TAG", "TOP_END_COLOR", "TOP_START_COLOR", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.pv.LoadingProgressView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/storage/view/pv/LoadingProgressView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f373838e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f373839f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f373840h;

        b(Function0<Unit> function0, float f16, float f17) {
            this.f373838e = function0;
            this.f373839f = f16;
            this.f373840h = f17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LoadingProgressView.this, function0, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationEnd(animation);
            LoadingProgressView.this.setRotation(0.0f);
            Function0<Unit> function0 = this.f373838e;
            if (function0 != null) {
                function0.invoke();
            }
            LoadingProgressView.this.e(this.f373839f, this.f373840h);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingProgressView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(float bottomAngle, float topAngle) {
        final float f16 = this.curBottomAngle;
        final float f17 = bottomAngle - f16;
        final float f18 = this.curTopAngle;
        final float f19 = topAngle - f18;
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(this.duration);
        duration.setInterpolator(this.rotateInterpolator);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.storage.view.pv.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingProgressView.f(LoadingProgressView.this, f16, f17, f18, f19, valueAnimator);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LoadingProgressView this$0, float f16, float f17, float f18, float f19, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.curBottomAngle = f16 + (f17 * valueAnimator.getAnimatedFraction());
        this$0.curTopAngle = f18 + (f19 * valueAnimator.getAnimatedFraction());
        this$0.invalidate();
    }

    private final void h(Canvas canvas) {
        if (this.curBottomAngle <= 0.0f) {
            return;
        }
        float f16 = 2;
        float f17 = this.progressWidth / f16;
        int save = canvas.save();
        canvas.rotate(this.rotateDegree, this.viewBounds.width() / f16, this.viewBounds.height() / f16);
        canvas.drawArc(f17, f17, this.viewBounds.width() - f17, this.viewBounds.height() - f17, -90.0f, this.curBottomAngle, false, this.bottomPBPaint);
        canvas.restoreToCount(save);
    }

    private final void i(Canvas canvas) {
        if (this.curTopAngle <= 0.0f) {
            return;
        }
        float f16 = 2;
        float f17 = this.progressWidth / f16;
        int save = canvas.save();
        canvas.rotate(this.rotateDegree, this.viewBounds.width() / f16, this.viewBounds.height() / f16);
        canvas.drawArc(f17, f17, this.viewBounds.width() - f17, this.viewBounds.height() - f17, -90.0f, this.curTopAngle, false, this.topPBPaint);
        canvas.restoreToCount(save);
    }

    private final void j(Canvas canvas) {
        RectF rectF = this.viewBounds;
        canvas.translate(rectF.left, rectF.top);
        canvas.clipRect(0.0f, 0.0f, this.viewBounds.width(), this.viewBounds.height());
    }

    private final void k(float bottomAngle, float topAngle, Function0<Unit> recoverCompleteAction) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 720.0f);
        long j3 = 2;
        ofFloat.setDuration(this.duration * j3);
        ofFloat.setInterpolator(this.rotateInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.storage.view.pv.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingProgressView.l(LoadingProgressView.this, valueAnimator);
            }
        });
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(this.duration * j3);
        duration.setInterpolator(this.rotateInterpolator);
        final float f16 = this.curBottomAngle;
        final float f17 = this.curTopAngle;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.storage.view.pv.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingProgressView.m(LoadingProgressView.this, f16, f17, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, duration);
        animatorSet.addListener(new b(recoverCompleteAction, bottomAngle, topAngle));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LoadingProgressView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.rotateDegree = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LoadingProgressView this$0, float f16, float f17, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f18 = 1;
        this$0.curBottomAngle = f16 * (f18 - valueAnimator.getAnimatedFraction());
        this$0.curTopAngle = f17 * (f18 - valueAnimator.getAnimatedFraction());
        this$0.invalidate();
    }

    public final void g(float bottomPercent, float topPercent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(bottomPercent), Float.valueOf(topPercent));
        } else {
            float f16 = 100;
            e((bottomPercent * 360.0f) / f16, (topPercent * 360.0f) / f16);
        }
    }

    public final void n(float targetBottomPercent, float targetTopPercent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(targetBottomPercent), Float.valueOf(targetTopPercent));
            return;
        }
        float f16 = 100;
        float f17 = (targetBottomPercent * 360.0f) / f16;
        this.targetBottomAngle = f17;
        float f18 = (targetTopPercent * 360.0f) / f16;
        this.targetTopAngle = f18;
        k(f17, f18, null);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        j(canvas);
        h(canvas);
        i(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(width, height, oldw, oldh);
        int min = Math.min(width, height);
        int i3 = (width - min) / 2;
        int i16 = (height - min) / 2;
        this.viewBounds.set(getPaddingLeft() + i3, getPaddingTop() + i16, (width - getPaddingRight()) - i3, (height - getPaddingBottom()) - i16);
        setPaintShader(this.bottomPBPaint, this.bottomStartColor, this.bottomEndColor);
        setPaintShader(this.topPBPaint, this.topStartColor, this.topEndColor);
    }

    public final void setBottomPaintShader(int startColor, int endColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(startColor), Integer.valueOf(endColor));
            return;
        }
        this.bottomStartColor = startColor;
        this.bottomEndColor = endColor;
        setPaintShader(this.bottomPBPaint, startColor, endColor);
    }

    public final void setDuration(long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, duration);
        } else {
            this.duration = duration;
        }
    }

    public final void setPaintShader(@NotNull Paint paint, int startColor, int endColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, paint, Integer.valueOf(startColor), Integer.valueOf(endColor));
            return;
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        RectF rectF = this.viewBounds;
        float f16 = rectF.right - rectF.left;
        float f17 = 2;
        float f18 = f16 / f17;
        float sqrt = (float) Math.sqrt(2.0f);
        float f19 = ((sqrt - 1) / sqrt) * f18;
        float f26 = (f18 * f17) - f19;
        paint.setShader(new LinearGradient(f19, f19, f26, f26, startColor, endColor, Shader.TileMode.CLAMP));
        invalidate();
    }

    public final void setTopPaintShader(int startColor, int endColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(startColor), Integer.valueOf(endColor));
            return;
        }
        this.topStartColor = startColor;
        this.topEndColor = endColor;
        setPaintShader(this.topPBPaint, startColor, endColor);
    }

    public final void setTopProgress(float topProgress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(topProgress));
            return;
        }
        this.curBottomAngle = 0.0f;
        this.curTopAngle = (topProgress * 360.0f) / 100;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ LoadingProgressView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        com.tencent.storage.view.c cVar = com.tencent.storage.view.c.f373802a;
        boolean e16 = cVar.e((Activity) context);
        this.isSmallDimen = e16;
        float f16 = e16 ? 35.0f : 42.0f;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        float c16 = cVar.c(f16, resources);
        this.progressWidth = c16;
        this.rotateInterpolator = new AccelerateDecelerateInterpolator();
        this.viewBounds = new RectF();
        this.bottomStartColor = Color.parseColor("#9E63FF");
        this.bottomEndColor = Color.parseColor("#FF8DF4");
        this.topStartColor = Color.parseColor("#0099FF");
        this.topEndColor = Color.parseColor("#00F0FF");
        this.duration = 500L;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(c16);
        this.topPBPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(c16);
        this.bottomPBPaint = paint2;
        setBackgroundResource(R.drawable.lnv);
    }
}
