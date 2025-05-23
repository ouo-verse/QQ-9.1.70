package com.tencent.mobileqq.guild.gift.view.banner;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.b;
import com.tencent.mobileqq.guild.gift.view.GiftBannerWipesAnimationView;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.widget.GCircleImageView;
import com.tencent.mobileqq.guild.util.bd;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 f2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0002R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010)R\u0016\u0010,\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010ER\u0014\u0010G\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010ER\u0014\u0010H\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010ER\u0014\u0010J\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010LR\u0016\u0010N\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010ER\u0016\u0010O\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010ER\"\u0010V\u001a\u00020P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010\\\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010^R\u0016\u0010a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010`R\u0016\u0010c\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010b\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/view/banner/GiftBannerImpl;", "Lcom/tencent/mobileqq/guild/gift/view/banner/e;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "giftData", "p", "", "comboText", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "a", "data", "c", "", "contentViewY", "b", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", "size", "y", DomainData.DOMAIN_NAME, "k", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", ReportConstant.COSTREPORT_PREFIX, "r", "l", "Lcom/tencent/mobileqq/guild/gift/view/banner/f;", "Lcom/tencent/mobileqq/guild/gift/view/banner/f;", "giftResAction", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "receiveGiftIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "receiveGiftComboTv", "d", "sendGiftUserTv", "e", "receiveGiftUserTv", "Lcom/tencent/mobileqq/guild/media/widget/GCircleImageView;", "f", "Lcom/tencent/mobileqq/guild/media/widget/GCircleImageView;", "sendGiftAvtarIv", "Lcom/tencent/mobileqq/guild/gift/view/GiftBannerWipesAnimationView;", "g", "Lcom/tencent/mobileqq/guild/gift/view/GiftBannerWipesAnimationView;", "scanLightAv", "Landroidx/constraintlayout/widget/ConstraintLayout;", h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "bannerContains", "i", "giftBannerCly", "Landroid/animation/ValueAnimator;", "j", "Landroid/animation/ValueAnimator;", "giftAnimator", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "comboAnimatorSet", "", "J", "giftDuration", "comboDuration", "enterDuration", "o", "scanLightDuration", "Lcom/tencent/mobileqq/guild/util/bd;", "Lcom/tencent/mobileqq/guild/util/bd;", "handler", "bannerDuration", "time", "Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;", "Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;", "getGiftQueue", "()Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;", "setGiftQueue", "(Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;)V", "giftQueue", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "getLastGiftData", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "setLastGiftData", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;)V", "lastGiftData", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "cancelGiftBanner", UserInfo.SEX_FEMALE, "giftBannerY", "Landroid/view/View;", "giftBanner", "<init>", "(Lcom/tencent/mobileqq/guild/gift/view/banner/f;)V", HippyTKDListViewAdapter.X, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GiftBannerImpl implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f giftResAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView receiveGiftIv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView receiveGiftComboTv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView sendGiftUserTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView receiveGiftUserTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GCircleImageView sendGiftAvtarIv;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private GiftBannerWipesAnimationView scanLightAv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout bannerContains;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout giftBannerCly;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator giftAnimator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimatorSet comboAnimatorSet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final long giftDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long comboDuration;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final long enterDuration;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final long scanLightDuration;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bd handler;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long bannerDuration;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long time;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaGiftQueue giftQueue;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a lastGiftData;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> cancelGiftBanner;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private float giftBannerY;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private View giftBanner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/gift/view/banner/GiftBannerImpl$c", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.gift.module.d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable String pngFilePath, @Nullable String apngFilePath) {
            if (!TextUtils.isEmpty(pngFilePath)) {
                b.Companion companion = com.tencent.mobileqq.guild.discover.b.INSTANCE;
                ImageView imageView = GiftBannerImpl.this.receiveGiftIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("receiveGiftIv");
                    imageView = null;
                }
                Intrinsics.checkNotNull(pngFilePath);
                b.Companion.g(companion, imageView, pngFilePath, null, 4, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/gift/view/banner/GiftBannerImpl$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f224609e;

        d(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f224609e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            super.onAnimationEnd(animation);
            if (!GiftBannerImpl.this.q(this.f224609e)) {
                GiftBannerImpl.this.v();
                if (GiftBannerImpl.this.giftAnimator != null) {
                    ValueAnimator valueAnimator = GiftBannerImpl.this.giftAnimator;
                    Intrinsics.checkNotNull(valueAnimator);
                    if (valueAnimator.isRunning()) {
                        return;
                    }
                }
                GiftBannerImpl.this.z();
            }
        }
    }

    public GiftBannerImpl(@NotNull f giftResAction) {
        Intrinsics.checkNotNullParameter(giftResAction, "giftResAction");
        this.giftResAction = giftResAction;
        this.giftDuration = 2000L;
        this.comboDuration = 150L;
        this.enterDuration = 300L;
        this.scanLightDuration = 1000L;
        this.handler = new bd();
        this.bannerDuration = 2500L;
        this.giftQueue = new MediaGiftQueue(2200L);
        this.cancelGiftBanner = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.gift.view.banner.GiftBannerImpl$cancelGiftBanner$1
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
                GiftBannerImpl.this.l();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GiftBannerImpl this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView = this$0.receiveGiftIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftIv");
            imageView = null;
        }
        imageView.setTranslationY(floatValue);
    }

    private final void m() {
        if (!this.giftQueue.l()) {
            this.giftQueue.n(new Function1<com.tencent.mobileqq.qqgift.mvvm.business.anim.a, Unit>() { // from class: com.tencent.mobileqq.guild.gift.view.banner.GiftBannerImpl$doQueue$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a element) {
                    Intrinsics.checkNotNullParameter(element, "element");
                    GiftBannerImpl.this.n(element);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void p(com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData) {
        ConstraintLayout constraintLayout = this.giftBannerCly;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout = null;
        }
        float[] fArr = new float[2];
        ConstraintLayout constraintLayout3 = this.bannerContains;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerContains");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        fArr[0] = -constraintLayout2.getWidth();
        fArr[1] = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(constraintLayout, "translationX", fArr);
        ofFloat.setDuration(this.enterDuration);
        ofFloat.start();
        ofFloat.addListener(new d(giftData));
    }

    private final void w(final String comboText) {
        TextView textView = this.receiveGiftComboTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftComboTv");
            textView = null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 0.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 0.0f));
        ofPropertyValuesHolder.setDuration(this.comboDuration);
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n\u2026= comboDuration\n        }");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        ofInt.setDuration(10L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.gift.view.banner.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GiftBannerImpl.x(GiftBannerImpl.this, comboText, valueAnimator);
            }
        });
        TextView textView3 = this.receiveGiftComboTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftComboTv");
        } else {
            textView2 = textView3;
        }
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(textView2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f, 1.2f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f, 1.2f, 1.0f));
        ofPropertyValuesHolder2.setDuration(this.comboDuration);
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(\n\u2026= comboDuration\n        }");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofPropertyValuesHolder).before(ofInt).before(ofPropertyValuesHolder2);
        this.comboAnimatorSet = animatorSet;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GiftBannerImpl this$0, String comboText, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(comboText, "$comboText");
        TextView textView = this$0.receiveGiftComboTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftComboTv");
            textView = null;
        }
        textView.setText(comboText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -30.0f, 0.0f);
        ofFloat.setDuration(this.giftDuration);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.gift.view.banner.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GiftBannerImpl.A(GiftBannerImpl.this, valueAnimator);
            }
        });
        this.giftAnimator = ofFloat;
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.start();
    }

    public final void B() {
        ValueAnimator valueAnimator = this.giftAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.end();
            ValueAnimator valueAnimator2 = this.giftAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.removeAllListeners();
            ValueAnimator valueAnimator3 = this.giftAnimator;
            Intrinsics.checkNotNull(valueAnimator3);
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.e
    @NotNull
    public View a(@NotNull LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eyk, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026gift_banner_layout, null)");
        this.giftBanner = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.vp5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "giftBanner.findViewById(\u2026t_banner_receive_iv_gift)");
        this.receiveGiftIv = (ImageView) findViewById;
        View view = this.giftBanner;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.vp6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "giftBanner.findViewById(\u2026_banner_receive_tv_combo)");
        this.receiveGiftComboTv = (TextView) findViewById2;
        View view2 = this.giftBanner;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.f165366vp2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "giftBanner.findViewById(R.id.gift_banner_avtar)");
        this.sendGiftAvtarIv = (GCircleImageView) findViewById3;
        View view3 = this.giftBanner;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.vp8);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "giftBanner.findViewById(\u2026gift_banner_send_tv_name)");
        this.sendGiftUserTv = (TextView) findViewById4;
        View view4 = this.giftBanner;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.vp7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "giftBanner.findViewById(\u2026t_banner_receive_tv_name)");
        this.receiveGiftUserTv = (TextView) findViewById5;
        View view5 = this.giftBanner;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view5 = null;
        }
        View findViewById6 = view5.findViewById(R.id.f166050yi2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "giftBanner.findViewById(\u2026.lighting_animation_view)");
        this.scanLightAv = (GiftBannerWipesAnimationView) findViewById6;
        View view6 = this.giftBanner;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view6 = null;
        }
        View findViewById7 = view6.findViewById(R.id.f165367vp3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "giftBanner.findViewById(R.id.gift_banner_contains)");
        this.bannerContains = (ConstraintLayout) findViewById7;
        View view7 = this.giftBanner;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            view7 = null;
        }
        View findViewById8 = view7.findViewById(R.id.f165365vp1);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "giftBanner.findViewById(R.id.gift_banner)");
        this.giftBannerCly = (ConstraintLayout) findViewById8;
        View view8 = this.giftBanner;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBanner");
            return null;
        }
        return view8;
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.e
    public void b(float contentViewY) {
        ConstraintLayout constraintLayout = this.giftBannerCly;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout = null;
        }
        this.giftBannerY = constraintLayout.getY();
        ConstraintLayout constraintLayout3 = this.giftBannerCly;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout3 = null;
        }
        float height = contentViewY - constraintLayout3.getHeight();
        ConstraintLayout constraintLayout4 = this.giftBannerCly;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout4 = null;
        }
        if (constraintLayout4.getVisibility() == 0) {
            ConstraintLayout constraintLayout5 = this.giftBannerCly;
            if (constraintLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                constraintLayout5 = null;
            }
            float[] fArr = new float[2];
            ConstraintLayout constraintLayout6 = this.giftBannerCly;
            if (constraintLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            } else {
                constraintLayout2 = constraintLayout6;
            }
            fArr[0] = constraintLayout2.getY();
            fArr[1] = height;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(constraintLayout5, "y", fArr);
            ofFloat.setDuration(this.enterDuration);
            ofFloat.start();
        } else {
            ConstraintLayout constraintLayout7 = this.giftBannerCly;
            if (constraintLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            } else {
                constraintLayout2 = constraintLayout7;
            }
            constraintLayout2.setY(height);
        }
        QLog.i("GiftBannerImpl", 1, "onPanelShow contentView.y:" + contentViewY + ",giftBannerY:" + this.giftBannerY);
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.e
    public void c(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.giftQueue.g(data);
        m();
    }

    public final void k() {
        AnimatorSet animatorSet = this.comboAnimatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                AnimatorSet animatorSet2 = this.comboAnimatorSet;
                Intrinsics.checkNotNull(animatorSet2);
                animatorSet2.cancel();
            }
        }
        B();
    }

    public final void l() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        ConstraintLayout constraintLayout = this.giftBannerCly;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout = null;
        }
        constraintLayout.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    public final void n(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData) {
        GCircleImageView gCircleImageView;
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        ConstraintLayout constraintLayout = this.giftBannerCly;
        TextView textView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
            constraintLayout = null;
        }
        if (constraintLayout.getVisibility() != 0) {
            ConstraintLayout constraintLayout2 = this.giftBannerCly;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(0);
        }
        if (q(giftData)) {
            ConstraintLayout constraintLayout3 = this.bannerContains;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerContains");
                constraintLayout3 = null;
            }
            constraintLayout3.setBackgroundResource(R.drawable.guild_media_gift_banner_free_bg);
            y(46.0f);
            GiftBannerWipesAnimationView giftBannerWipesAnimationView = this.scanLightAv;
            if (giftBannerWipesAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanLightAv");
                giftBannerWipesAnimationView = null;
            }
            giftBannerWipesAnimationView.setVisibility(8);
            this.bannerDuration = 2500L;
            B();
        } else {
            ConstraintLayout constraintLayout4 = this.bannerContains;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerContains");
                constraintLayout4 = null;
            }
            constraintLayout4.setBackgroundResource(R.drawable.guild_media_gift_banner_charge_bg);
            y(79.0f);
            GiftBannerWipesAnimationView giftBannerWipesAnimationView2 = this.scanLightAv;
            if (giftBannerWipesAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanLightAv");
                giftBannerWipesAnimationView2 = null;
            }
            giftBannerWipesAnimationView2.setVisibility(0);
            this.bannerDuration = 3000L;
        }
        TextView textView2 = this.sendGiftUserTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendGiftUserTv");
            textView2 = null;
        }
        textView2.setText(giftData.f264919j);
        TextView textView3 = this.receiveGiftUserTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftUserTv");
            textView3 = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\u9001\u7ed9 %s", Arrays.copyOf(new Object[]{giftData.f264921l}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView3.setText(format);
        b.Companion companion = com.tencent.mobileqq.guild.discover.b.INSTANCE;
        GCircleImageView gCircleImageView2 = this.sendGiftAvtarIv;
        if (gCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendGiftAvtarIv");
            gCircleImageView = null;
        } else {
            gCircleImageView = gCircleImageView2;
        }
        String str = giftData.f264922m;
        if (str == null) {
            str = "";
        }
        b.Companion.g(companion, gCircleImageView, str, null, 4, null);
        this.giftResAction.R7(giftData, new c());
        if (System.currentTimeMillis() - this.time < this.bannerDuration) {
            w(HippyTKDListViewAdapter.X + giftData.f264928s);
            if (!q(giftData) && (valueAnimator = this.giftAnimator) != null) {
                Intrinsics.checkNotNull(valueAnimator);
                if (!valueAnimator.isRunning()) {
                    z();
                }
            }
            this.handler.d();
            if (!u(giftData) && !r(giftData)) {
                if (!r(giftData) && giftData.f264928s % 15 == 0) {
                    v();
                }
            } else {
                ConstraintLayout constraintLayout5 = this.giftBannerCly;
                if (constraintLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                    constraintLayout5 = null;
                }
                constraintLayout5.setVisibility(4);
                ?? r06 = this.giftBannerCly;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                } else {
                    textView = r06;
                }
                textView.setVisibility(0);
                p(giftData);
            }
        } else {
            TextView textView4 = this.receiveGiftComboTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("receiveGiftComboTv");
            } else {
                textView = textView4;
            }
            textView.setText(HippyTKDListViewAdapter.X + giftData.f264928s);
            p(giftData);
        }
        this.time = System.currentTimeMillis();
        bd bdVar = this.handler;
        final Function0<Unit> function0 = this.cancelGiftBanner;
        bdVar.c(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.view.banner.b
            @Override // java.lang.Runnable
            public final void run() {
                GiftBannerImpl.o(Function0.this);
            }
        }, this.bannerDuration);
        this.lastGiftData = giftData;
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.e
    public void onDestroy() {
        k();
        this.giftQueue.o();
    }

    public final boolean q(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        if (giftData.f264912c == 0) {
            return true;
        }
        return false;
    }

    public final boolean r(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        if (giftData.f264926q == 0) {
            return true;
        }
        return false;
    }

    public final boolean s(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual(String.valueOf(data.f264918i), MediaChannelCore.INSTANCE.a().o0().getSelfUserInfo().f228093a);
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.e
    public void t() {
        boolean z16;
        if (this.giftBannerY == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ConstraintLayout constraintLayout = this.giftBannerCly;
            ConstraintLayout constraintLayout2 = null;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                constraintLayout = null;
            }
            if (constraintLayout.getVisibility() == 0) {
                ConstraintLayout constraintLayout3 = this.giftBannerCly;
                if (constraintLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                    constraintLayout3 = null;
                }
                float[] fArr = new float[2];
                ConstraintLayout constraintLayout4 = this.giftBannerCly;
                if (constraintLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                } else {
                    constraintLayout2 = constraintLayout4;
                }
                fArr[0] = constraintLayout2.getY();
                fArr[1] = this.giftBannerY;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(constraintLayout3, "y", fArr);
                ofFloat.setDuration(this.enterDuration);
                ofFloat.start();
            } else {
                ConstraintLayout constraintLayout5 = this.giftBannerCly;
                if (constraintLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                } else {
                    constraintLayout2 = constraintLayout5;
                }
                constraintLayout2.setY(this.giftBannerY);
            }
        }
        QLog.i("GiftBannerImpl", 1, "onPanelShow giftBannerY:" + this.giftBannerY);
    }

    public final boolean u(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar;
        Intrinsics.checkNotNullParameter(data, "data");
        if (s(data) && (aVar = this.lastGiftData) != null) {
            Intrinsics.checkNotNull(aVar);
            if (s(aVar)) {
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.lastGiftData;
                Intrinsics.checkNotNull(aVar2);
                if (aVar2.f264910a != data.f264910a) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void v() {
        GiftBannerWipesAnimationView giftBannerWipesAnimationView = this.scanLightAv;
        if (giftBannerWipesAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanLightAv");
            giftBannerWipesAnimationView = null;
        }
        giftBannerWipesAnimationView.d(this.scanLightDuration, 0);
    }

    public final void y(float size) {
        ImageView imageView = this.receiveGiftIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftIv");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = ViewUtils.dip2px(size);
        layoutParams.height = ViewUtils.dip2px(size);
        ImageView imageView3 = this.receiveGiftIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveGiftIv");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setLayoutParams(layoutParams);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/gift/view/banner/GiftBannerImpl$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            ConstraintLayout constraintLayout = GiftBannerImpl.this.giftBannerCly;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giftBannerCly");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
