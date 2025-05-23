package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ2\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u0010J2\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b#\u0010$\u0012\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0014\u00104\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010$R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010$R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0018\u0010@\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/ai;", "", "", "t", "", "targetState", "v", "Luv4/bk;", "data", "w", "", "need", "u", "withAnim", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "inflatedViews", "o", "j", "Ln74/ad;", "a", "Ln74/ad;", "binding", "Lg94/g;", "b", "Lg94/g;", "sizeHelper", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "mPendingTask", "d", "Z", "mAnimRunning", "e", "I", "getMState$annotations", "()V", "mState", "f", "mIconNormalSize", "g", "mIconSelectedSize", tl.h.F, "mHintAreaBtmMarginNormal", "i", "mHintAreaBtmMarginSelected", "", UserInfo.SEX_FEMALE, "mHintTxtSizeNormal", "k", "mHintTxtSizeSelected", "l", "mBgShadowSizeGap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBgPadding", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "mIconTarget", "needShowActivity", "p", "Luv4/bk;", "bindingData", "<init>", "(Ln74/ad;Lg94/g;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n74.ad binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final g94.g sizeHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Runnable mPendingTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mAnimRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mIconNormalSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int mIconSelectedSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mHintAreaBtmMarginNormal;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mHintAreaBtmMarginSelected;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float mHintTxtSizeNormal;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final float mHintTxtSizeSelected;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int mBgShadowSizeGap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mBgPadding;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final RoundCornerImageView mIconTarget;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean needShowActivity;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private bk bindingData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/ai$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends oc4.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ai.this.v(2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/ai$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f370836d;

        c(View view) {
            this.f370836d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f370836d.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/ai$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f370837d;

        d(View view) {
            this.f370837d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f370837d.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/ai$e", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends oc4.a {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ai.this.v(1);
        }
    }

    public ai(n74.ad binding, g94.g sizeHelper) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        this.binding = binding;
        this.sizeHelper = sizeHelper;
        this.mIconNormalSize = (int) BaseApplication.context.getResources().getDimension(R.dimen.f11484w);
        this.mIconSelectedSize = (int) BaseApplication.context.getResources().getDimension(R.dimen.f11494x);
        this.mHintAreaBtmMarginNormal = (int) BaseApplication.context.getResources().getDimension(R.dimen.f11464u);
        this.mHintAreaBtmMarginSelected = (int) BaseApplication.context.getResources().getDimension(R.dimen.f11474v);
        this.mHintTxtSizeNormal = BaseApplication.context.getResources().getDimension(R.dimen.f11514z);
        this.mHintTxtSizeSelected = BaseApplication.context.getResources().getDimension(R.dimen.f115250);
        this.mBgShadowSizeGap = ((int) BaseApplication.context.getResources().getDimension(R.dimen.f11444s)) * 2;
        this.mBgPadding = com.tencent.sqshow.zootopia.utils.i.b(2);
        RoundCornerImageView roundCornerImageView = binding.f418598i;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.itemIcon");
        this.mIconTarget = roundCornerImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, float f16, int i16, float f17, ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f18 = i3;
        float f19 = f18 + ((f16 - f18) * floatValue);
        float f26 = i16;
        ViewGroup.LayoutParams layoutParams = this$0.binding.f418592c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = (int) (f26 + ((f17 - f26) * floatValue));
        layoutParams2.height = (int) f19;
        this$0.binding.f418592c.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ai this$0, boolean z16, HashMap inflatedViews) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inflatedViews, "$inflatedViews");
        this$0.j(z16, inflatedViews);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.binding.f418597h.f418869e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.binding.f418597h.f418874j.setTextSize(0, ((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ai this$0, boolean z16, HashMap inflatedViews) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inflatedViews, "$inflatedViews");
        this$0.o(z16, inflatedViews);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.binding.f418597h.f418869e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.binding.f418597h.f418874j.setTextSize(0, ((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(float f16, float f17, float f18, float f19, ai this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f26 = f16 + ((f17 - f16) * floatValue);
        ViewGroup.LayoutParams layoutParams = this$0.binding.f418592c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = (int) (f18 + ((f19 - f18) * floatValue));
        layoutParams2.height = (int) f26;
        this$0.binding.f418592c.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(@StoreItemState int targetState) {
        az azVar;
        bk bkVar = this.bindingData;
        QLog.i("StoreItemAnimHelper_", 4, "onAnimEnd targetState:" + targetState + ", id:" + ((bkVar == null || (azVar = bkVar.f440366b) == null) ? null : r94.b.a(azVar)));
        this.mState = targetState;
        this.mAnimRunning = false;
        Runnable runnable = this.mPendingTask;
        this.mPendingTask = null;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void u(boolean need) {
        this.needShowActivity = need;
    }

    public final void w(bk data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bindingData = data;
        t();
    }

    private final void t() {
        this.mPendingTask = null;
    }

    public final void j(final boolean withAnim, final HashMap<Integer, View> inflatedViews) {
        Intrinsics.checkNotNullParameter(inflatedViews, "inflatedViews");
        if (this.mAnimRunning) {
            this.mPendingTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ai.l(ai.this, withAnim, inflatedViews);
                }
            };
            return;
        }
        if (this.mState == 2) {
            return;
        }
        this.mAnimRunning = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mIconTarget, "translationY", com.tencent.sqshow.zootopia.utils.i.d(-2.5f), 0.0f);
        animatorSet.addListener(new b());
        ViewGroup.LayoutParams layoutParams = this.binding.f418597h.f418869e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ValueAnimator ofInt = ValueAnimator.ofInt(((FrameLayout.LayoutParams) layoutParams).bottomMargin, this.mHintAreaBtmMarginNormal);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.af
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.m(ai.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.binding.f418597h.f418874j.getTextSize(), this.mHintTxtSizeNormal);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ag
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.n(ai.this, valueAnimator);
            }
        });
        float alpha = this.binding.f418592c.getAlpha();
        final int height = this.binding.f418592c.getHeight();
        final int width = this.binding.f418592c.getWidth();
        final float mItemHeight = (this.sizeHelper.getMItemHeight() - this.mBgShadowSizeGap) - (this.mBgPadding * 2);
        final float mItemWidth = (this.sizeHelper.getMItemWidth() - this.mBgShadowSizeGap) - (this.mBgPadding * 2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.binding.f418592c, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 0.0f);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ah
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.k(height, mItemHeight, width, mItemWidth, this, valueAnimator);
            }
        });
        if (this.needShowActivity) {
            View view = inflatedViews.get(Integer.valueOf(R.id.pep));
            if (view != null) {
                view.setVisibility(0);
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight());
                ofFloat5.addListener(new c(view));
                animatorSet.play(ofFloat5);
            }
            View view2 = inflatedViews.get(Integer.valueOf(R.id.peu));
            if (view2 != null) {
                view2.setVisibility(0);
                ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
                ofFloat6.addListener(new d(view2));
                animatorSet.play(ofFloat6);
            }
            View view3 = inflatedViews.get(Integer.valueOf(R.id.pkp));
            if (view3 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view3, "translationY", com.tencent.sqshow.zootopia.utils.i.e(-8), 0.0f));
            }
        } else {
            View view4 = inflatedViews.get(Integer.valueOf(R.id.peu));
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View view5 = inflatedViews.get(Integer.valueOf(R.id.pep));
            if (view5 != null) {
                view5.setVisibility(8);
            }
        }
        animatorSet.play(ofFloat);
        animatorSet.play(ofInt);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(withAnim ? 100L : 0L);
        animatorSet.start();
    }

    public final void o(final boolean withAnim, final HashMap<Integer, View> inflatedViews) {
        Intrinsics.checkNotNullParameter(inflatedViews, "inflatedViews");
        if (this.mAnimRunning) {
            this.mPendingTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ai.p(ai.this, withAnim, inflatedViews);
                }
            };
            return;
        }
        if (this.mState == 1) {
            return;
        }
        this.mAnimRunning = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mIconTarget, "translationY", 0.0f, com.tencent.sqshow.zootopia.utils.i.d(-2.5f));
        animatorSet.addListener(new e());
        ViewGroup.LayoutParams layoutParams = this.binding.f418597h.f418869e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ValueAnimator ofInt = ValueAnimator.ofInt(((FrameLayout.LayoutParams) layoutParams).bottomMargin, this.mHintAreaBtmMarginSelected);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ab
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.q(ai.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.binding.f418597h.f418874j.getTextSize(), this.mHintTxtSizeSelected);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ac
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.r(ai.this, valueAnimator);
            }
        });
        float alpha = this.binding.f418592c.getAlpha();
        final float mItemHeight = (this.sizeHelper.getMItemHeight() - this.mBgShadowSizeGap) - (this.mBgPadding * 2);
        final float mItemWidth = (this.sizeHelper.getMItemWidth() - this.mBgShadowSizeGap) - (this.mBgPadding * 2);
        final float mItemHeight2 = this.sizeHelper.getMItemHeight() - (this.mBgPadding * 2);
        final float mItemWidth2 = this.sizeHelper.getMItemWidth() - (this.mBgPadding * 2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.binding.f418592c, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 1.0f);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ad
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.s(mItemHeight, mItemHeight2, mItemWidth, mItemWidth2, this, valueAnimator);
            }
        });
        if (this.needShowActivity) {
            View view = inflatedViews.get(Integer.valueOf(R.id.pep));
            if (view != null) {
                view.setVisibility(0);
                animatorSet.play(ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f));
            }
            View view2 = inflatedViews.get(Integer.valueOf(R.id.peu));
            if (view2 != null) {
                view2.setVisibility(0);
                animatorSet.play(ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.0f));
            }
            View view3 = inflatedViews.get(Integer.valueOf(R.id.pkp));
            if (view3 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view3, "translationY", 0.0f, com.tencent.sqshow.zootopia.utils.i.e(-8)));
            }
        } else {
            View view4 = inflatedViews.get(Integer.valueOf(R.id.pep));
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View view5 = inflatedViews.get(Integer.valueOf(R.id.peu));
            if (view5 != null) {
                view5.setVisibility(8);
            }
        }
        animatorSet.play(ofFloat);
        animatorSet.play(ofInt);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(withAnim ? 100L : 0L);
        animatorSet.start();
    }
}
