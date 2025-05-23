package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010Y\u001a\u00020X\u0012\b\u0010[\u001a\u0004\u0018\u00010Z\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR+\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR+\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR+\u0010)\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR+\u00100\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00104\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u001e\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R+\u00108\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u001b\u0010F\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010;\u001a\u0004\bE\u0010BR\u001b\u0010I\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010;\u001a\u0004\bH\u0010BR\u0016\u0010K\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0012R\u0016\u0010N\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010Q\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010MR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010\u000bR\u0016\u0010U\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010MR\u0014\u0010W\u001a\u00020*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010-\u00a8\u0006^"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "", "c", "b", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", NodeProps.ON_DETACHED_FROM_WINDOW, "", "I", "getTransitionTimingMs", "()I", "setTransitionTimingMs", "(I)V", "transitionTimingMs", "", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animDuration", "value", HippyQQPagView.FunctionName.GET_PROGRESS, HippyQQPagView.FunctionName.SET_PROGRESS, "progress", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "getCircleColor", "setCircleColor", "circleColor", "e", "getDotColor", "setDotColor", "dotColor", "f", "getProgressColor", "setProgressColor", "progressColor", "", "g", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth", tl.h.F, "getDotWidth", "setDotWidth", "dotWidth", "i", "getProgressWidth", "setProgressWidth", "progressWidth", "Landroid/animation/ValueAnimator;", "j", "Lkotlin/Lazy;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator", "Landroid/graphics/Paint;", "k", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint", "l", "getDotPaint", "dotPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getProgressPaint", "progressPaint", BdhLogUtil.LogTag.Tag_Conn, "currentPlayTime", "D", UserInfo.SEX_FEMALE, "pointX", "E", "pointY", "angle", "G", "step", "H", "processToDraw", "getRadius", "radius", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "luggage-wechat-full-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AppBrandCircleProgressView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    public long currentPlayTime;

    /* renamed from: D, reason: from kotlin metadata */
    public float pointX;

    /* renamed from: E, reason: from kotlin metadata */
    public float pointY;

    /* renamed from: F, reason: from kotlin metadata */
    public float angle;

    /* renamed from: G, reason: from kotlin metadata */
    public int step;

    /* renamed from: H, reason: from kotlin metadata */
    public float processToDraw;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int transitionTimingMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long animDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int progress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty circleColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty dotColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty progressColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty circleStrokeWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty dotWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final ReadWriteProperty progressWidth;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Lazy animator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Lazy circlePaint;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Lazy dotPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Lazy progressPaint;
    public static final /* synthetic */ KProperty[] J = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "circleColor", "getCircleColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "dotColor", "getDotColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "progressColor", "getProgressColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "circleStrokeWidth", "getCircleStrokeWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "dotWidth", "getDotWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppBrandCircleProgressView.class, "progressWidth", "getProgressWidth()F", 0))};

    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ValueAnimator invoke() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(-1.5707964f, 4.712389f);
            AppBrandCircleProgressView appBrandCircleProgressView = AppBrandCircleProgressView.this;
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            ofFloat.setDuration(appBrandCircleProgressView.getAnimDuration());
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint(1);
            AppBrandCircleProgressView appBrandCircleProgressView = AppBrandCircleProgressView.this;
            paint.setStrokeWidth(appBrandCircleProgressView.getCircleStrokeWidth());
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(appBrandCircleProgressView.getCircleColor());
            return paint;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint(1);
            AppBrandCircleProgressView appBrandCircleProgressView = AppBrandCircleProgressView.this;
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(appBrandCircleProgressView.getDotWidth());
            return paint;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e extends Lambda implements Function0 {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint(1);
            AppBrandCircleProgressView appBrandCircleProgressView = AppBrandCircleProgressView.this;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(appBrandCircleProgressView.getProgressWidth());
            paint.setColor(appBrandCircleProgressView.getProgressColor());
            return paint;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152287a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152287a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            int intValue = ((Number) obj2).intValue();
            ((Number) obj).intValue();
            this.f152287a.getCirclePaint().setColor(intValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class g extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152288a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152288a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            int intValue = ((Number) obj2).intValue();
            ((Number) obj).intValue();
            this.f152288a.getDotPaint().setColor(intValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class h extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152289a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            int intValue = ((Number) obj2).intValue();
            ((Number) obj).intValue();
            this.f152289a.getProgressPaint().setColor(intValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class i extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152290a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152290a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            float floatValue = ((Number) obj2).floatValue();
            ((Number) obj).floatValue();
            this.f152290a.getCirclePaint().setStrokeWidth(floatValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class j extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152291a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152291a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            float floatValue = ((Number) obj2).floatValue();
            ((Number) obj).floatValue();
            this.f152291a.getDotPaint().setStrokeWidth(floatValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBrandCircleProgressView f152292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Object obj, AppBrandCircleProgressView appBrandCircleProgressView) {
            super(obj);
            this.f152292a = appBrandCircleProgressView;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            float floatValue = ((Number) obj2).floatValue();
            ((Number) obj).floatValue();
            this.f152292a.getProgressPaint().setStrokeWidth(floatValue);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l implements ValueAnimator.AnimatorUpdateListener {
        public l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AppBrandCircleProgressView.this.currentPlayTime = animation.getCurrentPlayTime();
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            AppBrandCircleProgressView appBrandCircleProgressView = AppBrandCircleProgressView.this;
            double d16 = floatValue;
            appBrandCircleProgressView.pointX = appBrandCircleProgressView.getRadius() * ((float) Math.cos(d16));
            AppBrandCircleProgressView appBrandCircleProgressView2 = AppBrandCircleProgressView.this;
            appBrandCircleProgressView2.pointY = appBrandCircleProgressView2.getRadius() * ((float) Math.sin(d16));
            AppBrandCircleProgressView.this.angle = (float) ((floatValue * 360.0f) / 6.283185307179586d);
            AppBrandCircleProgressView.this.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBrandCircleProgressView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        super(ctx, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.transitionTimingMs = 2000;
        this.animDuration = 1500L;
        Delegates delegates = Delegates.INSTANCE;
        this.circleColor = new f(-7829368, this);
        this.dotColor = new g(-7829368, this);
        this.progressColor = new h(-16711936, this);
        Float valueOf = Float.valueOf(1.0f);
        this.circleStrokeWidth = new i(valueOf, this);
        this.dotWidth = new j(valueOf, this);
        this.progressWidth = new k(Float.valueOf(3.0f), this);
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.animator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new c());
        this.circlePaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new d());
        this.dotPaint = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new e());
        this.progressPaint = lazy4;
        this.step = 1;
        this.processToDraw = this.progress;
    }

    private final ValueAnimator getAnimator() {
        Object value = this.animator.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animator>(...)");
        return (ValueAnimator) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getCirclePaint() {
        return (Paint) this.circlePaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getDotPaint() {
        return (Paint) this.dotPaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getProgressPaint() {
        return (Paint) this.progressPaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getRadius() {
        if (isLaidOut()) {
            float f16 = 2;
            return Math.min(getMeasuredHeight() - (Math.max(getProgressWidth(), getDotWidth()) * f16), getMeasuredWidth() - (f16 * Math.max(getProgressWidth(), getDotWidth()))) / 2.0f;
        }
        return 0.0f;
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final int getCircleColor() {
        return ((Number) this.circleColor.getValue(this, J[0])).intValue();
    }

    public final float getCircleStrokeWidth() {
        return ((Number) this.circleStrokeWidth.getValue(this, J[3])).floatValue();
    }

    public final int getDotColor() {
        return ((Number) this.dotColor.getValue(this, J[1])).intValue();
    }

    public final float getDotWidth() {
        return ((Number) this.dotWidth.getValue(this, J[4])).floatValue();
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getProgressColor() {
        return ((Number) this.progressColor.getValue(this, J[2])).intValue();
    }

    public final float getProgressWidth() {
        return ((Number) this.progressWidth.getValue(this, J[5])).floatValue();
    }

    public final int getTransitionTimingMs() {
        return this.transitionTimingMs;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        boolean z17 = true;
        if (this.pointX == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.pointY != 0.0f) {
                z17 = false;
            }
            if (!z17) {
                float measuredWidth = getMeasuredWidth();
                float measuredHeight = getMeasuredHeight();
                canvas.drawCircle(measuredWidth / 2.0f, measuredHeight / 2.0f, getRadius(), getCirclePaint());
                if (this.currentPlayTime <= this.transitionTimingMs) {
                    canvas.drawCircle(this.pointX + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.pointY + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
                    return;
                }
                float f16 = this.processToDraw;
                if (f16 < this.progress) {
                    this.processToDraw = f16 + this.step;
                } else if (f16 <= 80.0f) {
                    this.processToDraw = f16 + 0.5f;
                }
                float f17 = 2;
                float f18 = measuredWidth / f17;
                float f19 = measuredHeight / f17;
                canvas.drawArc(f18 - getRadius(), f19 - getRadius(), getRadius() + f18, getRadius() + f19, this.angle, (this.processToDraw * 360) / 100.0f, false, getProgressPaint());
                if (this.processToDraw >= 100.0f) {
                    c();
                }
            }
        }
    }

    public final void setAnimDuration(long j3) {
        this.animDuration = j3;
    }

    public final void setCircleColor(int i3) {
        this.circleColor.setValue(this, J[0], Integer.valueOf(i3));
    }

    public final void setCircleStrokeWidth(float f16) {
        this.circleStrokeWidth.setValue(this, J[3], Float.valueOf(f16));
    }

    public final void setDotColor(int i3) {
        this.dotColor.setValue(this, J[1], Integer.valueOf(i3));
    }

    public final void setDotWidth(float f16) {
        this.dotWidth.setValue(this, J[4], Float.valueOf(f16));
    }

    public final void setProgress(int i3) {
        w.a("AppBrandCircleProgressView", "hash = " + hashCode() + " progress = " + i3);
        this.progress = i3;
    }

    public final void setProgressColor(int i3) {
        this.progressColor.setValue(this, J[2], Integer.valueOf(i3));
    }

    public final void setProgressWidth(float f16) {
        this.progressWidth.setValue(this, J[5], Float.valueOf(f16));
    }

    public final void setTransitionTimingMs(int i3) {
        this.transitionTimingMs = i3;
    }

    public final void b() {
        this.currentPlayTime = 0L;
        getAnimator().addUpdateListener(new l());
        getAnimator().start();
    }

    public final void c() {
        getAnimator().cancel();
        getAnimator().removeAllUpdateListeners();
    }

    public final void a() {
        this.transitionTimingMs = 0;
        getAnimator().setDuration(1000L);
        this.step = 5;
    }
}
