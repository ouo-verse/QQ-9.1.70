package com.tencent.kuikly.core.render.android.css.animation;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 ,2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b*\u0010+JH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0015\u00a8\u0006-"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSSpringAnimationHandler;", "Lcom/tencent/kuikly/core/render/android/css/animation/c;", "Landroid/view/View;", "target", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", IXWebBroadcastListener.STAGE_FINISHED, "", "propKey", "", "onAnimationEndBlock", "o", "a", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "g", UserInfo.SEX_FEMALE, "getDamping", "()F", ReportConstant.COSTREPORT_PREFIX, "(F)V", "damping", tl.h.F, "getVelocity", "t", "velocity", "Landroidx/dynamicanimation/animation/SpringAnimation;", "i", "Landroidx/dynamicanimation/animation/SpringAnimation;", "springAnimation", "Landroid/os/Handler;", "j", "Landroid/os/Handler;", "uiHandler", "f", "()Z", QzoneWebMusicJsPlugin.EVENT_PLAYING, "r", "finalFloatValue", "<init>", "()V", "k", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class KRCSSSpringAnimationHandler extends c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float damping;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float velocity;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SpringAnimation springAnimation;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012B\u0010\u0002\u001a>\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003 \u0004*\u001f\u0012\u0016\b\u0001\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0018\u00010\u0003\u00a8\u0006\u00010\u0003\u00a8\u0006\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\n\u00a2\u0006\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "kotlin.jvm.PlatformType", "canceled", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "onAnimationEnd", "com/tencent/kuikly/core/render/android/css/animation/KRCSSSpringAnimationHandler$start$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    static final class b implements DynamicAnimation.OnAnimationEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SpringAnimation f117606a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ KRCSSSpringAnimationHandler f117607b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f117608c;

        b(SpringAnimation springAnimation, KRCSSSpringAnimationHandler kRCSSSpringAnimationHandler, Function2 function2) {
            this.f117606a = springAnimation;
            this.f117607b = kRCSSSpringAnimationHandler;
            this.f117608c = function2;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(DynamicAnimation<DynamicAnimation<?>> dynamicAnimation, boolean z16, float f16, float f17) {
            if (!z16) {
                if (this.f117607b.getRepeatForever()) {
                    SpringForce spring = this.f117606a.getSpring();
                    Intrinsics.checkNotNullExpressionValue(spring, "spring");
                    spring.setFinalPosition(this.f117607b.r());
                    this.f117606a.start();
                    return;
                }
                this.f117608c.invoke(Boolean.valueOf(this.f117607b.e(false)), this.f117607b.getPropKey());
                return;
            }
            this.f117608c.invoke(Boolean.valueOf(this.f117607b.e(true)), this.f117607b.getPropKey());
        }
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public void a() {
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        SpringAnimation springAnimation = this.springAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public boolean f() {
        SpringAnimation springAnimation = this.springAnimation;
        if (springAnimation != null && springAnimation.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.c
    public void o(@NotNull View target, @NotNull Function2<? super Boolean, ? super String, Unit> onAnimationEndBlock) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onAnimationEndBlock, "onAnimationEndBlock");
        SpringAnimation springAnimation = new SpringAnimation(target, q(target), r());
        springAnimation.setStartVelocity(this.velocity);
        SpringForce spring = springAnimation.getSpring();
        Intrinsics.checkNotNullExpressionValue(spring, "spring");
        float f16 = this.damping;
        if (f16 == 0.0f) {
            f16 = 1.0f;
        }
        spring.setDampingRatio(f16);
        springAnimation.setMinimumVisibleChange(0.00390625f);
        springAnimation.addEndListener(new b(springAnimation, this, onAnimationEndBlock));
        Unit unit = Unit.INSTANCE;
        this.springAnimation = springAnimation;
        if (getDelay() > 0) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.uiHandler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSSpringAnimationHandler$start$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpringAnimation springAnimation2;
                        springAnimation2 = KRCSSSpringAnimationHandler.this.springAnimation;
                        if (springAnimation2 != null) {
                            springAnimation2.start();
                        }
                    }
                }, getDelay() * 1000);
                return;
            }
            return;
        }
        SpringAnimation springAnimation2 = this.springAnimation;
        if (springAnimation2 != null) {
            springAnimation2.start();
        }
    }

    @NotNull
    public abstract FloatPropertyCompat<View> q(@NotNull View target);

    public abstract float r();

    public final void s(float f16) {
        this.damping = f16;
    }

    public final void t(float f16) {
        this.velocity = f16;
    }
}
