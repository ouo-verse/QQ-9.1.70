package com.tencent.mobileqq.guild.media.gift;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002PS\u0018\u0000 \u00122\u00020\u0001:\u0001`B\u001d\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0013\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\tJ\u0013\u0010\u000b\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\tJ#\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\tJ\b\u0010\u0013\u001a\u00020\u0002H\u0002J#\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0011J+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\tJ\u0013\u0010\u001d\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\tJ\u001b\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$J&\u0010*\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u0002J\b\u0010,\u001a\u00020\u0002H\u0014R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00109\u001a\n 6*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010;\u001a\n 6*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001c\u0010=\u001a\n 6*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u001c\u0010A\u001a\n 6*\u0004\u0018\u00010>0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R0\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170Bj\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010DR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010GR0\u0010J\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020I0Bj\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020I`C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010DR\u0014\u0010K\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0005R\u0016\u0010L\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010MR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010MR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010X\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/GuildFreeGiftView;", "Landroid/widget/FrameLayout;", "", "W", "G", UserInfo.SEX_FEMALE, "H", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "N", "", "progressDuration", "", "startProgress", "O", "(JFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "M", "L", BdhLogUtil.LogTag.Tag_Req, "", "url", "", "height", "loopCount", "I", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, "T", "count", "J", "(Ljava/lang/Integer;)V", "Lkotlinx/coroutines/CoroutineScope;", "D", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "E", "lastNum", "needShowAddOne", "isLastGift", "V", "U", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/gift/GuildGiftCircleProgressView;", "e", "Lcom/tencent/mobileqq/guild/media/gift/GuildGiftCircleProgressView;", "mProgressView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "f", "Landroid/widget/ImageView;", "mStaticIconView", tl.h.F, "mGiftCountView", "i", "mGiftAddOneView", "Lcom/tencent/image/URLImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/image/URLImageView;", "mAnimImageView", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mGiftCountRes", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mActivityRef", "", "apngCallbackHolder", "mMaxWaitProgress", "mLastNum", "Z", "mIsLastGift", "mIsCheckRspReady", "com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$freeGiftNumEvent$1", "Lcom/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$freeGiftNumEvent$1;", "freeGiftNumEvent", "com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$mGiftSendListener$1", "K", "Lcom/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$mGiftSendListener$1;", "mGiftSendListener", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mProgressAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFreeGiftView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> mGiftCountRes;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<FragmentActivity> mActivityRef;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> apngCallbackHolder;

    /* renamed from: F, reason: from kotlin metadata */
    private final float mMaxWaitProgress;

    /* renamed from: G, reason: from kotlin metadata */
    private int mLastNum;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsLastGift;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsCheckRspReady;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GuildFreeGiftView$freeGiftNumEvent$1 freeGiftNumEvent;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GuildFreeGiftView$mGiftSendListener$1 mGiftSendListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mProgressAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildGiftCircleProgressView mProgressView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView mStaticIconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView mGiftCountView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView mGiftAddOneView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final URLImageView mAnimImageView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            GuildGiftCircleProgressView guildGiftCircleProgressView = GuildFreeGiftView.this.mProgressView;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            guildGiftCircleProgressView.setProgress(((Float) animatedValue).floatValue());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFreeGiftView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C() {
        CoroutineContext coroutineContext;
        com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
        j jVar = j.f228942e;
        CoroutineScope f16 = aVar.f(jVar);
        if (f16 != null && (coroutineContext = f16.getCoroutineContext()) != null) {
            JobKt.cancelChildren$default(coroutineContext, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope f17 = aVar.f(jVar);
        if (f17 != null) {
            CoroutineScopeKt.cancel$default(f17, null, 1, null);
        }
        aVar.b(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope D() {
        com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
        j jVar = j.f228942e;
        CoroutineScope f16 = aVar.f(jVar);
        if (f16 == null) {
            aVar.d(jVar);
            CoroutineScope f17 = aVar.f(jVar);
            if (f17 != null) {
                return f17;
            }
            throw new IllegalStateException("create MediaFreeGiftTaskType scope error!");
        }
        return f16;
    }

    private final void F() {
        URLImageView mAnimImageView = this.mAnimImageView;
        Intrinsics.checkNotNullExpressionValue(mAnimImageView, "mAnimImageView");
        jt1.b.b(mAnimImageView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$initClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFreeGiftView.this.H();
            }
        });
        ImageView mStaticIconView = this.mStaticIconView;
        Intrinsics.checkNotNullExpressionValue(mStaticIconView, "mStaticIconView");
        jt1.b.b(mStaticIconView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$initClickListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFreeGiftView.this.H();
            }
        });
    }

    private final void G() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158981ch1) - getResources().getDimensionPixelSize(R.dimen.cdb);
        ViewGroup.LayoutParams layoutParams = this.mGiftCountView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = dimensionPixelSize;
        this.mGiftCountView.setLayoutParams(marginLayoutParams);
        ct1.a freeGiftInfo = com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo();
        if (freeGiftInfo.getFreeGiftAccountBalance() > 0) {
            this.mGiftCountView.setVisibility(0);
            K(this, null, 1, null);
            float countDownProgressPercent = com.tencent.mobileqq.guild.media.core.j.a().H().getCountDownProgressPercent();
            if (countDownProgressPercent > 0.0f) {
                BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$initGiftCountView$1(this, freeGiftInfo, countDownProgressPercent, null), 3, null);
            }
        }
        ViewGroup.LayoutParams layoutParams2 = this.mGiftAddOneView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.topMargin = dimensionPixelSize;
        this.mGiftAddOneView.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        FragmentActivity fragmentActivity;
        boolean z16;
        FragmentActivity fragmentActivity2;
        FragmentActivity fragmentActivity3;
        FragmentActivity fragmentActivity4;
        if (o.a(this.mRootView)) {
            Logger.f235387a.d().w("GuildFreeGiftView", 1, "[initClickListener] fast click. ignore");
            return;
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this, "em_sgrp_free_gift", "clck", new HashMap());
        Logger logger = Logger.f235387a;
        logger.d().i("GuildFreeGiftView", 1, "[launchGiftPanel] start");
        WeakReference<FragmentActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            if (weakReference != null) {
                fragmentActivity = weakReference.get();
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                WeakReference<FragmentActivity> weakReference2 = this.mActivityRef;
                boolean z17 = false;
                if (weakReference2 != null && (fragmentActivity4 = weakReference2.get()) != null && fragmentActivity4.isFinishing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    WeakReference<FragmentActivity> weakReference3 = this.mActivityRef;
                    if (weakReference3 != null && (fragmentActivity3 = weakReference3.get()) != null && fragmentActivity3.isDestroyed()) {
                        z17 = true;
                    }
                    if (!z17) {
                        WeakReference<FragmentActivity> weakReference4 = this.mActivityRef;
                        if (weakReference4 != null && (fragmentActivity2 = weakReference4.get()) != null) {
                            com.tencent.mobileqq.guild.media.core.j.a().b0().K(fragmentActivity2, ShowPanelTab.Pack);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        logger.d().w("GuildFreeGiftView", 1, "[launchGiftPanel] invalid context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(final String str, int i3, int i16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setUseCache(true);
        if (i16 > 0) {
            apngOptions.setLoop(i16);
        }
        ViewGroup.LayoutParams layoutParams = this.mAnimImageView.getLayoutParams();
        layoutParams.height = i3;
        this.mAnimImageView.setLayoutParams(layoutParams);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildFreeGiftView", 1, "[setAnimImageDrawable] start, url: " + str);
        }
        final APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("GuildFreeGiftView", str, apngOptions);
        apngDrawable.setLoadedListener(new Function1<IDynamicDrawable, Unit>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$setAnimImageDrawable$2$drawable$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                invoke2(iDynamicDrawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IDynamicDrawable it) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(it, "it");
                final String str2 = str;
                final CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                ApngDrawable.OnPlayRepeatListener onPlayRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$setAnimImageDrawable$2$drawable$1$1$callback$1
                    @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                    public final void onPlayRepeat(int i17) {
                        Logger logger2 = Logger.f235387a;
                        String str3 = str2;
                        if (QLog.isDebugVersion()) {
                            logger2.d().d("GuildFreeGiftView", 1, "[setAnimImageDrawable] repeated: " + i17 + ", url: " + str3);
                        }
                        if (i17 > 1) {
                            return;
                        }
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final CancellableContinuation<Boolean> cancellableContinuation2 = cancellableContinuation;
                        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$setAnimImageDrawable$2$drawable$1$1$callback$1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (cancellableContinuation2.isActive()) {
                                    CancellableContinuation<Boolean> cancellableContinuation3 = cancellableContinuation2;
                                    Result.Companion companion = Result.INSTANCE;
                                    cancellableContinuation3.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                                }
                            }
                        });
                    }
                };
                hashMap = GuildFreeGiftView.this.apngCallbackHolder;
                hashMap.put(str, onPlayRepeatListener);
                apngDrawable.setOnPlayRepeatListener(onPlayRepeatListener);
            }
        });
        this.mAnimImageView.setVisibility(0);
        this.mAnimImageView.setImageDrawable(apngDrawable);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Integer count) {
        int freeGiftAccountBalance;
        int coerceAtMost;
        int coerceAtLeast;
        if (count != null) {
            freeGiftAccountBalance = count.intValue();
        } else {
            freeGiftAccountBalance = com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftAccountBalance();
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(9, freeGiftAccountBalance);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, coerceAtMost);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildFreeGiftView", 1, "[setGiftCountResource] giftInfo HashCode: " + com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().hashCode());
        }
        logger.d().i("GuildFreeGiftView", 1, "[setGiftCountResource] count: " + count + ", resourceCount: " + coerceAtLeast);
        ImageView imageView = this.mGiftCountView;
        Integer num = this.mGiftCountRes.get(Integer.valueOf(coerceAtLeast));
        Intrinsics.checkNotNull(num);
        imageView.setImageResource(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void K(GuildFreeGiftView guildFreeGiftView, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        guildFreeGiftView.J(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        this.mGiftAddOneView.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        long j3 = 1000 / 2;
        alphaAnimation.setDuration(j3);
        animationSet.addAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(j3);
        alphaAnimation2.setStartOffset(j3);
        animationSet.addAnimation(alphaAnimation2);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -114.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(new b());
        animationSet.addAnimation(translateAnimation);
        this.mGiftAddOneView.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mStaticIconView.setVisibility(8);
        this.mAnimImageView.setVisibility(0);
        J(Boxing.boxInt(com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftAccountBalance() - 1));
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$showAnimBlockNumChange$2$1(this, cancellableContinuationImpl, null), 3, null);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$showAnimBlockNumChange$2$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$showAnimBlockNumChange$2$2$1", f = "GuildFreeGiftView.kt", i = {}, l = {427, 428}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$showAnimBlockNumChange$2$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ GuildFreeGiftView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(GuildFreeGiftView guildFreeGiftView, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = guildFreeGiftView;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    Object T;
                    Object S;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        GuildFreeGiftView guildFreeGiftView = this.this$0;
                        this.label = 1;
                        T = guildFreeGiftView.T(this);
                        if (T == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    GuildFreeGiftView guildFreeGiftView2 = this.this$0;
                    this.label = 2;
                    S = guildFreeGiftView2.S(this);
                    if (S == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                BuildersKt__Builders_commonKt.launch$default(GuildFreeGiftView.this.D(), null, null, new AnonymousClass1(GuildFreeGiftView.this, null), 3, null);
            }
        }, 500 / 2);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        this.mStaticIconView.setVisibility(0);
        K(this, null, 1, null);
        this.mGiftCountView.setVisibility(0);
        Object I = I("https://downv6.qq.com/innovate/guild/avChannel/guild_free_gift_particle_fly_anim.png", getResources().getDimensionPixelSize(R.dimen.cdb), 1, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (I == coroutine_suspended) {
            return I;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object O(long j3, float f16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mProgressView.setProgress(0.0f);
        this.mAnimImageView.setVisibility(0);
        K(this, null, 1, null);
        this.mGiftCountView.setVisibility(0);
        this.mStaticIconView.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$showAnimBlockProgress$2$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$showAnimBlockProgress$2$2(this, j3, f16, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object P(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mStaticIconView.setVisibility(0);
        K(this, null, 1, null);
        this.mGiftCountView.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$showAnimBlockStarExplode$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Logger.f235387a.d().i("GuildFreeGiftView", 1, "[showAnimBlockZoom] ");
        AnimationSet animationSet = new AnimationSet(true);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158981ch1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        setPivotY((this.mRootView.getHeight() / 2) - dimensionPixelSize);
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        scaleAnimation2.setStartOffset(300L);
        setPivotY((this.mRootView.getHeight() / 2) - dimensionPixelSize);
        scaleAnimation2.setAnimationListener(new c(cancellableContinuationImpl));
        animationSet.addAnimation(scaleAnimation2);
        this.mRootView.startAnimation(animationSet);
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$showAnimBlockZoom$2$4(this, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R(long j3, float f16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        long coerceAtMost;
        long coerceAtLeast;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(j3, j3 - (((float) j3) * f16));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0L, coerceAtMost);
        Logger logger = Logger.f235387a;
        logger.d().w("GuildFreeGiftView", 1, "[showCircleProgress]. progressDuration: " + j3 + ", startProgress: " + f16 + ", circleDuration: " + coerceAtLeast);
        ValueAnimator valueAnimator = this.mProgressAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (j3 > 0 && coerceAtLeast > 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f16 * this.mMaxWaitProgress, this.mMaxWaitProgress);
            ofFloat.setDuration(coerceAtLeast);
            ofFloat.addUpdateListener(new d());
            ofFloat.addListener(new e(cancellableContinuationImpl));
            this.mProgressAnim = ofFloat;
            ValueAnimator valueAnimator2 = this.mProgressAnim;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        } else {
            logger.d().w("GuildFreeGiftView", 1, "[showCircleProgress] failed. totalTime invalid: " + j3);
            this.mProgressView.setProgress(0.0f);
            if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mGiftCountView.setVisibility(0);
        K(this, null, 1, null);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.1f, 0.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(130L);
        scaleAnimation2.setStartOffset(200L);
        scaleAnimation2.setAnimationListener(new f(cancellableContinuationImpl));
        animationSet.addAnimation(scaleAnimation2);
        this.mGiftCountView.startAnimation(animationSet);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        J(Boxing.boxInt(com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftAccountBalance() - 1));
        ImageView imageView = this.mGiftCountView;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setAnimationListener(new g(cancellableContinuationImpl));
        imageView.startAnimation(scaleAnimation);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void W() {
        C();
        ValueAnimator valueAnimator = this.mProgressAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mProgressAnim = null;
        com.tencent.mobileqq.guild.media.core.j.a().b0().g(this.mGiftSendListener);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.j.class, this.freeGiftNumEvent);
    }

    public final void E(@Nullable FragmentActivity activity) {
        this.mActivityRef = new WeakReference<>(activity);
        G();
        F();
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.j.class, this.freeGiftNumEvent);
        com.tencent.mobileqq.guild.media.core.j.a().b0().h(this.mGiftSendListener);
    }

    public final void U() {
        this.mLastNum = 0;
        this.mIsLastGift = true;
        this.mStaticIconView.setVisibility(0);
        this.mProgressView.setProgress(0.0f);
        ValueAnimator valueAnimator = this.mProgressAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mAnimImageView.setVisibility(8);
        this.mGiftCountView.setVisibility(0);
    }

    public final void V(int lastNum, long progressDuration, boolean needShowAddOne, boolean isLastGift) {
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new GuildFreeGiftView$startGiftAnim$1(this, lastNum, isLastGift, needShowAddOne, progressDuration, null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        W();
        super.onDetachedFromWindow();
    }

    public /* synthetic */ GuildFreeGiftView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$freeGiftNumEvent$1] */
    @JvmOverloads
    public GuildFreeGiftView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyg, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026a_free_gift_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.sww);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026.audio_free_gift_process)");
        this.mProgressView = (GuildGiftCircleProgressView) findViewById;
        this.mStaticIconView = (ImageView) inflate.findViewById(R.id.swv);
        this.mGiftCountView = (ImageView) inflate.findViewById(R.id.vem);
        this.mGiftAddOneView = (ImageView) inflate.findViewById(R.id.vel);
        this.mAnimImageView = (URLImageView) inflate.findViewById(R.id.spj);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, Integer.valueOf(R.drawable.lvj));
        hashMap.put(1, Integer.valueOf(R.drawable.guild_free_gift_count_1));
        hashMap.put(2, Integer.valueOf(R.drawable.guild_free_gift_count_2));
        hashMap.put(3, Integer.valueOf(R.drawable.guild_free_gift_count_3));
        hashMap.put(4, Integer.valueOf(R.drawable.guild_free_gift_count_4));
        hashMap.put(5, Integer.valueOf(R.drawable.guild_free_gift_count_5));
        hashMap.put(6, Integer.valueOf(R.drawable.guild_free_gift_count_6));
        hashMap.put(7, Integer.valueOf(R.drawable.guild_free_gift_count_7));
        hashMap.put(8, Integer.valueOf(R.drawable.guild_free_gift_count_8));
        hashMap.put(9, Integer.valueOf(R.drawable.guild_free_gift_count_9));
        this.mGiftCountRes = hashMap;
        this.apngCallbackHolder = new HashMap<>();
        this.mMaxWaitProgress = 95.0f;
        this.freeGiftNumEvent = new com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.j>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$freeGiftNumEvent$1
            @Override // com.tencent.mobileqq.guild.media.core.notify.o
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.j event) {
                int i3;
                ValueAnimator valueAnimator;
                Intrinsics.checkNotNullParameter(event, "event");
                Logger logger = Logger.f235387a;
                logger.d().i("GuildFreeGiftView", 1, "[onEventReceive] FreeGiftNumChangeEvent giftInfo: " + event.getGiftInfo());
                GuildFreeGiftView.this.mIsCheckRspReady = true;
                ct1.a giftInfo = event.getGiftInfo();
                if (giftInfo.getFreeGiftCountDownSecond() == 0 && (valueAnimator = GuildFreeGiftView.this.mProgressAnim) != null) {
                    valueAnimator.cancel();
                }
                if (giftInfo.i()) {
                    logger.d().i("GuildFreeGiftView", 1, "[onEventReceive] FreeGiftNumChangeEvent show static view");
                    GuildFreeGiftView.this.U();
                    GuildFreeGiftView.K(GuildFreeGiftView.this, null, 1, null);
                    if (giftInfo.b()) {
                        BuildersKt__Builders_commonKt.launch$default(GuildFreeGiftView.this.D(), null, null, new GuildFreeGiftView$freeGiftNumEvent$1$onEventReceive$3(GuildFreeGiftView.this, null), 3, null);
                        return;
                    }
                    return;
                }
                if (!giftInfo.k()) {
                    ValueAnimator valueAnimator2 = GuildFreeGiftView.this.mProgressAnim;
                    boolean z16 = false;
                    if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                        z16 = true;
                    }
                    if (z16) {
                        logger.d().i("GuildFreeGiftView", 1, "[onEventReceive] FreeGiftNumChangeEvent ignore event. do not need show anim");
                        return;
                    }
                }
                int freeGiftAccountBalance = giftInfo.getFreeGiftAccountBalance();
                i3 = GuildFreeGiftView.this.mLastNum;
                if (freeGiftAccountBalance < i3) {
                    logger.d().i("GuildFreeGiftView", 1, "[onEventReceive] FreeGiftNumChangeEvent decrease");
                    GuildFreeGiftView.this.mLastNum = giftInfo.getFreeGiftAccountBalance() - 1;
                    GuildFreeGiftView.K(GuildFreeGiftView.this, null, 1, null);
                } else {
                    boolean k3 = giftInfo.k();
                    if (giftInfo.getFreeGiftAccountBalance() == 1) {
                        GuildFreeGiftView.this.V(0, giftInfo.getFreeGiftCountDownSecond() * 1000, k3, giftInfo.i());
                    } else {
                        GuildFreeGiftView.this.V(giftInfo.getFreeGiftAccountBalance() - 1, giftInfo.getFreeGiftCountDownSecond() * 1000, k3, giftInfo.i());
                    }
                }
            }
        };
        this.mGiftSendListener = new GuildFreeGiftView$mGiftSendListener$1(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationCancel", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f228911e;

        /* JADX WARN: Multi-variable type inference failed */
        e(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f228911e = cancellableContinuation;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            GuildFreeGiftView.this.mProgressView.setProgress(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (this.f228911e.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f228911e;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
            GuildGiftCircleProgressView guildGiftCircleProgressView = GuildFreeGiftView.this.mProgressView;
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            GuildFreeGiftView guildFreeGiftView = GuildFreeGiftView.this;
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new a(guildFreeGiftView));
            guildGiftCircleProgressView.startAnimation(alphaAnimation);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$e$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements Animation.AnimationListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GuildFreeGiftView f228912d;

            a(GuildFreeGiftView guildFreeGiftView) {
                this.f228912d = guildFreeGiftView;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@Nullable Animation animation) {
                this.f228912d.mProgressView.setProgress(0.0f);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@Nullable Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@Nullable Animation animation) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            GuildFreeGiftView.this.mGiftAddOneView.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f228908d;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f228908d = cancellableContinuation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            if (this.f228908d.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f228908d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$f", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f228913d;

        /* JADX WARN: Multi-variable type inference failed */
        f(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f228913d = cancellableContinuation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            if (this.f228913d.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f228913d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildFreeGiftView$g", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f228915d;

        /* JADX WARN: Multi-variable type inference failed */
        g(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f228915d = cancellableContinuation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            if (this.f228915d.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f228915d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
