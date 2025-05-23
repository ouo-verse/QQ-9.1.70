package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSAdBannerChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0018\u00101\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010$R\u0018\u00103\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/dr;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "y", SemanticAttributes.DbSystemValues.H2, "Z1", "e2", "g2", ICustomDataEditor.NUMBER_PARAM_2, "m2", "o2", "f2", "d2", "fraction", "", "colorString", "", "c2", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "position", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedUnSelected", "onFeedSelected", "onPaused", "onResumed", "", "p0", "Z", "mIsNoCard", "Landroid/view/View;", "q0", "Landroid/view/View;", "bottomActionBtn", "Landroid/widget/TextView;", "r0", "Landroid/widget/TextView;", "actionTv", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "s0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "actionShareIcon", "t0", "author", "u0", "content", "v0", "feedback", "Landroid/animation/ValueAnimator;", "w0", "Landroid/animation/ValueAnimator;", "showBottomBannerAnim", "x0", "btnColorAnim", "Ljava/lang/Runnable;", "y0", "Ljava/lang/Runnable;", "mCurrentRunnable", "z0", "showBottomBannerRunnable", "A0", "showBtnColorRunnable", "<init>", "()V", "B0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class dr extends QFSFeedChildAdCardPresenter {

    @NotNull
    private static final a B0 = new a(null);

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsNoCard;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomActionBtn;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView actionTv;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView actionShareIcon;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View author;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View content;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View feedback;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator showBottomBannerAnim;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator btnColorAnim;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mCurrentRunnable;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable showBottomBannerRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dn
        @Override // java.lang.Runnable
        public final void run() {
            dr.i2(dr.this);
        }
    };

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private Runnable showBtnColorRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.do
        @Override // java.lang.Runnable
        public final void run() {
            dr.k2(dr.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/dr$a;", "", "", "COLOR_CHANGE_ANIM_DURATION", "J", "", "DP_BOTTOM_BANNER_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/dr$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            dr.this.h2(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            dr.this.n2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            View view = dr.this.bottomActionBtn;
            if (view != null) {
                view.setVisibility(0);
            }
            if (af.Z(dr.this.W)) {
                af.m0(dr.this.actionShareIcon);
                dr drVar = dr.this;
                drVar.T0(new com.tencent.biz.qqcircle.immersive.feed.event.c(drVar.W.getTraceId(), true));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/dr$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            View view = dr.this.bottomActionBtn;
            if (view != null) {
                view.setBackground(AppCompatResources.getDrawable(dr.this.m0(), R.drawable.kdt));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            dr.this.a2();
            SimpleEventBus.getInstance().dispatchEvent(new QFSAdBannerChangeEvent(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON));
        }
    }

    private final void Z1() {
        if (!this.mIsNoCard) {
            return;
        }
        o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2() {
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON);
        VideoReport.setElementParams(this.bottomActionBtn, map);
        VideoReport.clearElementExposure(this.bottomActionBtn, false);
        VideoReport.reportEvent("dt_imp", null, map);
    }

    private final void d2() {
        TextView textView;
        if (this.bottomActionBtn != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f384319y)).inflate();
        this.bottomActionBtn = inflate;
        GdtShakeIconView gdtShakeIconView = null;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.f384219x);
        } else {
            textView = null;
        }
        this.actionTv = textView;
        View view = this.bottomActionBtn;
        if (view != null) {
            gdtShakeIconView = (GdtShakeIconView) view.findViewById(R.id.f38451_0);
        }
        this.actionShareIcon = gdtShakeIconView;
        this.author = this.f85356l0.findViewById(R.id.f3739175);
        this.content = this.f85356l0.findViewById(R.id.v9j);
        this.feedback = this.f85356l0.findViewById(R.id.f380218u);
        F1(this.bottomActionBtn);
    }

    private final void e2() {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3 = this.showBottomBannerAnim;
        boolean z17 = true;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator2 = this.showBottomBannerAnim) != null) {
            valueAnimator2.pause();
        }
        ValueAnimator valueAnimator4 = this.btnColorAnim;
        if (valueAnimator4 == null || !valueAnimator4.isRunning()) {
            z17 = false;
        }
        if (z17 && (valueAnimator = this.btnColorAnim) != null) {
            valueAnimator.pause();
        }
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().removeCallbacks(this.showBtnColorRunnable);
        af.i0(this.actionShareIcon);
    }

    private final void f2() {
        boolean z16;
        boolean z17;
        Drawable drawable;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        View view = this.bottomActionBtn;
        if (view != null) {
            view.setVisibility(8);
        }
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().removeCallbacks(this.showBtnColorRunnable);
        ValueAnimator valueAnimator3 = this.showBottomBannerAnim;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator2 = this.showBottomBannerAnim) != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator4 = this.btnColorAnim;
        if (valueAnimator4 != null && valueAnimator4.isRunning()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && (valueAnimator = this.btnColorAnim) != null) {
            valueAnimator.cancel();
        }
        af.n0(this.actionShareIcon);
        String w3 = af.w(this.X, "startColor");
        String w16 = af.w(this.X, "endColor");
        View view2 = this.bottomActionBtn;
        if (view2 != null) {
            drawable = view2.getBackground();
        } else {
            drawable = null;
        }
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) drawable).setColors(new int[]{c2(0.0f, w3), c2(0.0f, w16)});
        af.k0(false);
    }

    private final void g2() {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3 = this.showBottomBannerAnim;
        boolean z17 = true;
        if (valueAnimator3 != null && valueAnimator3.isPaused()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator2 = this.showBottomBannerAnim) != null) {
            valueAnimator2.resume();
        }
        ValueAnimator valueAnimator4 = this.btnColorAnim;
        if (valueAnimator4 == null || !valueAnimator4.isPaused()) {
            z17 = false;
        }
        if (z17 && (valueAnimator = this.btnColorAnim) != null) {
            valueAnimator.resume();
        }
        if (Intrinsics.areEqual(this.mCurrentRunnable, this.showBottomBannerRunnable)) {
            m2();
        } else if (Intrinsics.areEqual(this.mCurrentRunnable, this.showBtnColorRunnable)) {
            n2();
        }
        if (af.Z(this.W)) {
            af.m0(this.actionShareIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(float y16) {
        View view = this.bottomActionBtn;
        if (view != null) {
            view.setTranslationY(y16);
        }
        View view2 = this.author;
        if (view2 != null) {
            view2.setTranslationY(y16);
        }
        View view3 = this.content;
        if (view3 != null) {
            view3.setTranslationY(y16);
        }
        View view4 = this.feedback;
        if (view4 != null) {
            view4.setTranslationY(y16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(final dr this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentRunnable = null;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(com.tencent.biz.qqcircle.utils.cx.a(32.0f), 0.0f);
        this$0.showBottomBannerAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.addListener(new b());
        }
        ValueAnimator valueAnimator = this$0.showBottomBannerAnim;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dq
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    dr.j2(dr.this, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this$0.showBottomBannerAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(250L);
        }
        ValueAnimator valueAnimator3 = this$0.showBottomBannerAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "1");
        QLog.d("QFSFeedChildNoCardPresenter", 1, "[showBottomBannerAnim] start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(dr this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.h2(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(final dr this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentRunnable = null;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this$0.btnColorAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(500L);
        }
        ValueAnimator valueAnimator = this$0.btnColorAnim;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        final String w3 = af.w(this$0.X, "startColor");
        final String w16 = af.w(this$0.X, "endColor");
        ValueAnimator valueAnimator2 = this$0.btnColorAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dp
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    dr.l2(dr.this, w3, w16, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this$0.btnColorAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new c());
        }
        ValueAnimator valueAnimator4 = this$0.btnColorAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        af.k0(true);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "2");
        QLog.d("QFSFeedChildNoCardPresenter", 1, "[showBtnColorAnim] start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(dr this$0, String str, String str2, ValueAnimator valueAnimator) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.bottomActionBtn;
        if (view != null) {
            drawable = view.getBackground();
        } else {
            drawable = null;
        }
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        gradientDrawable.setColors(new int[]{this$0.c2(floatValue, str), this$0.c2(floatValue, str2)});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    }

    private final void m2() {
        long j3 = this.X.createTime.get() * 1000;
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().postDelayed(this.showBottomBannerRunnable, j3);
        this.mCurrentRunnable = this.showBottomBannerRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2() {
        long j3 = 1000;
        long j16 = (this.X.createTimeNs.get() * j3) + (this.X.syncTime.get() * j3);
        x0().removeCallbacks(this.showBtnColorRunnable);
        x0().postDelayed(this.showBtnColorRunnable, j16);
        this.mCurrentRunnable = this.showBtnColorRunnable;
    }

    private final void o2() {
        if (af.Z(this.W)) {
            String x16 = af.x(this.W);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            TextView textView = this.actionTv;
            if (textView != null) {
                textView.setText(x16);
                return;
            }
            return;
        }
        TextView textView2 = this.actionTv;
        if (textView2 != null) {
            textView2.setText(this.X.subtitle.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        boolean i3 = eq.f85700a.i(this.W, this.Y);
        this.mIsNoCard = i3;
        if (!i3) {
            return;
        }
        d2();
        Z1();
    }

    public final int c2(float fraction, @Nullable String colorString) {
        float f16;
        float[] fArr = new float[3];
        if (fraction < 0.1f) {
            f16 = 25.5f;
        } else {
            f16 = 255 * fraction;
        }
        Color.colorToHSV(Color.parseColor(colorString), fArr);
        fArr[1] = fArr[1] * fraction;
        fArr[2] = 1.0f;
        return Color.HSVToColor((int) f16, fArr);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        String str;
        super.onFeedSelected(selectInfo);
        if (this.mIsNoCard) {
            if (selectInfo != null) {
                str = selectInfo.getSelectedType();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "TYPE_SELECT_NORMAL")) {
                f2();
                m2();
                return;
            }
        }
        g2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        String str;
        super.onFeedUnSelected(selectInfo);
        if (!this.mIsNoCard) {
            return;
        }
        String str2 = null;
        if (selectInfo != null) {
            str = selectInfo.getUnSelectedType();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "TYPE_UNSELECTED_NORMAL")) {
            if (selectInfo != null) {
                str2 = selectInfo.getUnSelectedType();
            }
            if (str2 != null) {
                return;
            }
        }
        f2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        if (this.mIsNoCard) {
            e2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (this.mIsNoCard) {
            g2();
        }
    }
}
