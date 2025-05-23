package com.tencent.mobileqq.wink.magicstudio.parts;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.magicstudio.view.WinkMagicStudioResultPreview;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.MediaType;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 d2\u00020\u0001:\u0001eB\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\bb\u0010cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010&R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010V\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010QR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010`\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultPreviewPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Z9", "initViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "event", "ea", "ca", "R9", "ba", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$c;", "da", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "generateInfo", "ia", "U9", "ha", "W9", "showErrorView", "showLoadingView", "ga", "T9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioStyle", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originImage", "f", "Landroid/view/View;", "previewContainer", "Lcom/tencent/mobileqq/wink/magicstudio/view/WinkMagicStudioResultPreview;", tl.h.F, "Lcom/tencent/mobileqq/wink/magicstudio/view/WinkMagicStudioResultPreview;", "previewView", "i", "previewOverlayContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadingContainer", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "loadingProgress", "D", "loadingTip", "E", "errorContainer", "", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "currentLoadingTips", "", "G", "I", "currentLoadingTipsIndex", "H", "Ljava/lang/String;", "loadingImagePath", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "blurMaskAnimator", "Landroid/animation/AnimatorSet;", "J", "Landroid/animation/AnimatorSet;", "progressAnimator", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "loadingBlurView", "", "L", "Z", "isFirstGenerate", "M", "isBlurImageGenerated", "N", "needReportRetryEnd", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "P", "Lkotlin/Lazy;", "Q9", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "resultViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P9", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "createViewModel", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultPreviewPart extends Part {

    @NotNull
    private static final List<String> S;

    @NotNull
    private static final List<String> T;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView loadingProgress;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView loadingTip;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View errorContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentLoadingTipsIndex;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String loadingImagePath;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator blurMaskAnimator;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView loadingBlurView;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isBlurImageGenerated;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needReportRetryEnd;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy createViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MagicStudioPicStyle magicStudioStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LocalMediaInfo originImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View previewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMagicStudioResultPreview previewView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View previewOverlayContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<String> currentLoadingTips = T;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private AnimatorSet progressAnimator = new AnimatorSet();

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isFirstGenerate = true;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f323815a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.TypeImage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.TypeVideo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.TypeGIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f323815a = iArr;
        }
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("\u91cd\u65b0\u751f\u6210\u4e2d...");
        S = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u521b\u610f\u52a0\u8f7d\u4e2d...", "\u8272\u5f69\u878d\u5408\u4e2d...", "\u52a0\u901f\u751f\u6210\u4e2d..."});
        T = listOf2;
    }

    public WinkMagicStudioResultPreviewPart(@Nullable MagicStudioPicStyle magicStudioPicStyle, @Nullable LocalMediaInfo localMediaInfo) {
        Lazy lazy;
        Lazy lazy2;
        this.magicStudioStyle = magicStudioPicStyle;
        this.originImage = localMediaInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioMultiViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$resultViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioMultiViewModel invoke() {
                return (MagicStudioMultiViewModel) WinkMagicStudioResultPreviewPart.this.getViewModel(MagicStudioMultiViewModel.class);
            }
        });
        this.resultViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$createViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioCreationViewModel invoke() {
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) WinkMagicStudioResultPreviewPart.this.getViewModel(MagicStudioCreationViewModel.class);
                magicStudioCreationViewModel.u3(true);
                return magicStudioCreationViewModel;
            }
        });
        this.createViewModel = lazy2;
    }

    private final MagicStudioCreationViewModel P9() {
        Object value = this.createViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createViewModel>(...)");
        return (MagicStudioCreationViewModel) value;
    }

    private final MagicStudioMultiViewModel Q9() {
        Object value = this.resultViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-resultViewModel>(...)");
        return (MagicStudioMultiViewModel) value;
    }

    private final void R9() {
        showErrorView();
        if (this.isFirstGenerate) {
            this.isFirstGenerate = false;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.n
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMagicStudioResultPreviewPart.S9(WinkMagicStudioResultPreviewPart.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(WinkMagicStudioResultPreviewPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicStudioCreationViewModel.s2(this$0.P9(), false, 1, null);
        WinkMagicStudioUtils.f323888a.c(this$0.getActivity(), this$0.magicStudioStyle);
    }

    private final void T9() {
        Q9().r2(0);
        View view = this.previewOverlayContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.errorContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.loadingContainer;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.blurMaskAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.progressAnimator.cancel();
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp_end", this.loadingContainer, WinkDaTongReportConstant.ElementId.EM_QZ_LOADING, null, null, 24, null);
        getMainHandler().removeCallbacksAndMessages(null);
    }

    private final void U9() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkMagicStudioResultPreviewPart$initBlurMaskAnimator$1(this, null), 3, null);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.97f, 1.0f);
        ofFloat.setDuration(1500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WinkMagicStudioResultPreviewPart.V9(WinkMagicStudioResultPreviewPart.this, valueAnimator);
            }
        });
        this.blurMaskAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(WinkMagicStudioResultPreviewPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView = this$0.loadingBlurView;
        if (imageView != null) {
            imageView.setAlpha(floatValue);
        }
    }

    private final void W9() {
        ValueAnimator ofInt = ValueAnimator.ofInt(1, 90);
        ofInt.setDuration(10000L);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(90, 99);
        ofInt2.setDuration(20000L);
        ofInt2.setInterpolator(new com.tencent.mobileqq.widget.g());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WinkMagicStudioResultPreviewPart.X9(WinkMagicStudioResultPreviewPart.this, valueAnimator);
            }
        });
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WinkMagicStudioResultPreviewPart.Y9(WinkMagicStudioResultPreviewPart.this, valueAnimator);
            }
        });
        this.progressAnimator.playSequentially(ofInt, ofInt2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(WinkMagicStudioResultPreviewPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        TextView textView = this$0.loadingProgress;
        if (textView != null) {
            textView.setText(intValue + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(WinkMagicStudioResultPreviewPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        TextView textView = this$0.loadingProgress;
        if (textView != null) {
            textView.setText(intValue + "%");
        }
    }

    private final void Z9(View rootView) {
        View view;
        View view2;
        WinkMagicStudioResultPreview winkMagicStudioResultPreview;
        View view3;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        View view4 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f27330fy);
        } else {
            view = null;
        }
        this.previewOverlayContainer = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f27150fg);
        } else {
            view2 = null;
        }
        this.previewContainer = view2;
        if (rootView != null) {
            winkMagicStudioResultPreview = (WinkMagicStudioResultPreview) rootView.findViewById(R.id.f27460ga);
        } else {
            winkMagicStudioResultPreview = null;
        }
        this.previewView = winkMagicStudioResultPreview;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.ef_);
        } else {
            view3 = null;
        }
        this.loadingContainer = view3;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.efn);
        } else {
            textView = null;
        }
        this.loadingProgress = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.yt9);
        } else {
            textView2 = null;
        }
        this.loadingTip = textView2;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.ysb);
        } else {
            imageView = null;
        }
        this.loadingBlurView = imageView;
        VideoReport.setElementId(this.loadingContainer, WinkDaTongReportConstant.ElementId.EM_QZ_LOADING);
        VideoReport.setElementExposePolicy(this.loadingContainer, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.loadingContainer, EndExposurePolicy.REPORT_NONE);
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.by9);
        }
        this.errorContainer = view4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(WinkMagicStudioResultPreviewPart this$0, Pair pair) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.previewContainer;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = (String) pair.getFirst();
            View view2 = this$0.previewContainer;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
        }
        this$0.loadingImagePath = (String) pair.getSecond();
        View view3 = this$0.previewContainer;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this$0.showLoadingView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onCreateCancel");
        ValueAnimator valueAnimator = this.blurMaskAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.progressAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onCreateFailed");
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(MagicStudioCreationViewModel.b.ProgressUpdate event) {
        if (event.getIsRegenerate() && event.getProgress() == 0) {
            w53.b.f("WinkMagicStudioResultButtonPart", "onRegenerateProgress start");
            showLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ea(MagicStudioCreationViewModel.b.GotoMultiSelect event) {
        Object firstOrNull;
        boolean z16;
        Object firstOrNull2;
        String aigcImgPath;
        boolean z17;
        w53.b.f("WinkMagicStudioResultButtonPart", "onCreateSuccess: " + event);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.getJumpInfo().c());
        GenerateInfo generateInfo = (GenerateInfo) firstOrNull;
        if (generateInfo != null && (aigcImgPath = generateInfo.getAigcImgPath()) != null) {
            z16 = true;
            if (aigcImgPath.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            if (!this.isFirstGenerate) {
                m83.b.t(m83.b.f416442a, event.getJumpInfo().c(), false, 2, null);
            }
            Q9().q2(P9().H2());
            Q9().o2(event.getJumpInfo().c());
            this.isFirstGenerate = false;
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.getJumpInfo().c());
            ia((GenerateInfo) firstOrNull2);
            return;
        }
        w53.b.c("WinkMagicStudioResultButtonPart", "onCreateSuccess: aigcImgPath is empty");
        R9();
    }

    private final void ga() {
        List<String> list;
        Object first;
        if (this.isFirstGenerate) {
            list = T;
        } else {
            list = S;
        }
        this.currentLoadingTips = list;
        this.currentLoadingTipsIndex = 0;
        TextView textView = this.loadingTip;
        if (textView != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            textView.setText((CharSequence) first);
        }
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$showLoadingTips$1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                List list2;
                TextView textView2;
                List list3;
                int i17;
                WinkMagicStudioResultPreviewPart winkMagicStudioResultPreviewPart = WinkMagicStudioResultPreviewPart.this;
                i3 = winkMagicStudioResultPreviewPart.currentLoadingTipsIndex;
                winkMagicStudioResultPreviewPart.currentLoadingTipsIndex = i3 + 1;
                i16 = winkMagicStudioResultPreviewPart.currentLoadingTipsIndex;
                list2 = winkMagicStudioResultPreviewPart.currentLoadingTips;
                if (i16 < list2.size()) {
                    textView2 = winkMagicStudioResultPreviewPart.loadingTip;
                    if (textView2 != null) {
                        list3 = winkMagicStudioResultPreviewPart.currentLoadingTips;
                        i17 = winkMagicStudioResultPreviewPart.currentLoadingTipsIndex;
                        textView2.setText((CharSequence) list3.get(i17));
                    }
                    winkMagicStudioResultPreviewPart.getMainHandler().postDelayed(this, 3000L);
                }
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        String str;
        String str2 = this.loadingImagePath;
        if (str2 != null) {
            WinkMagicStudioResultPreview winkMagicStudioResultPreview = this.previewView;
            if (winkMagicStudioResultPreview != null) {
                winkMagicStudioResultPreview.setImagePath(str2);
            }
            MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
            if (magicStudioPicStyle != null) {
                str = magicStudioPicStyle.getOutputImageAspectRatio();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "-1")) {
                WinkMagicStudioResultPreview winkMagicStudioResultPreview2 = this.previewView;
                if (winkMagicStudioResultPreview2 != null) {
                    winkMagicStudioResultPreview2.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                }
                return;
            }
            WinkMagicStudioResultPreview winkMagicStudioResultPreview3 = this.previewView;
            if (winkMagicStudioResultPreview3 != null) {
                winkMagicStudioResultPreview3.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    private final void ia(GenerateInfo generateInfo) {
        ViewGroup.LayoutParams layoutParams;
        w53.b.f("WinkMagicStudioResultButtonPart", "showResultPreview");
        if (generateInfo == null) {
            w53.b.c("WinkMagicStudioResultButtonPart", "generateInfo is null");
            return;
        }
        if (generateInfo.getWidth() != 0 && generateInfo.getHeight() != 0) {
            View view = this.previewContainer;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = generateInfo.getWidth() + ":" + generateInfo.getHeight();
                View view2 = this.previewContainer;
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        }
        int i3 = b.f323815a[generateInfo.getMediaType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    w53.b.c("WinkMagicStudioResultButtonPart", "unknown media type: " + generateInfo.getMediaType());
                } else {
                    WinkMagicStudioResultPreview winkMagicStudioResultPreview = this.previewView;
                    if (winkMagicStudioResultPreview != null) {
                        winkMagicStudioResultPreview.setGifPath(generateInfo.getAigcImgPath());
                    }
                }
            } else {
                WinkMagicStudioResultPreview winkMagicStudioResultPreview2 = this.previewView;
                if (winkMagicStudioResultPreview2 != null) {
                    winkMagicStudioResultPreview2.setVideoPath(generateInfo.getAigcImgPath());
                }
            }
        } else {
            WinkMagicStudioResultPreview winkMagicStudioResultPreview3 = this.previewView;
            if (winkMagicStudioResultPreview3 != null) {
                winkMagicStudioResultPreview3.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            WinkMagicStudioResultPreview winkMagicStudioResultPreview4 = this.previewView;
            if (winkMagicStudioResultPreview4 != null) {
                winkMagicStudioResultPreview4.setImagePath(generateInfo.getAigcImgPath());
            }
        }
        T9();
    }

    private final void initViewModel() {
        Q9().f2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMagicStudioResultPreviewPart.aa(WinkMagicStudioResultPreviewPart.this, (Pair) obj);
            }
        });
        MagicStudioCreationViewModel P9 = P9();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "hostFragment.viewLifecycleOwner");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MagicStudioCreationViewModel.v2(P9, viewLifecycleOwner, context, null, new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
                invoke2(gotoMultiSelect);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkMagicStudioResultPreviewPart.this.ea(it);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$initViewModel$3
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
                WinkMagicStudioResultPreviewPart.this.ca();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$initViewModel$4
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
                WinkMagicStudioResultPreviewPart.this.ba();
            }
        }, new Function1<MagicStudioCreationViewModel.b.ProgressUpdate, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultPreviewPart$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate) {
                invoke2(progressUpdate);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicStudioCreationViewModel.b.ProgressUpdate it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkMagicStudioResultPreviewPart.this.da(it);
            }
        }, true, true, 4, null);
    }

    private final void showErrorView() {
        Q9().r2(2);
        ValueAnimator valueAnimator = this.blurMaskAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.progressAnimator.cancel();
        View view = this.previewOverlayContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.loadingContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.errorContainer;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        ImageView imageView = this.loadingBlurView;
        if (imageView != null) {
            imageView.setAlpha(1.0f);
        }
        this.needReportRetryEnd = true;
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.r(eVar, "dt_imp_end", this.loadingContainer, WinkDaTongReportConstant.ElementId.EM_QZ_LOADING, null, null, 24, null);
        com.tencent.mobileqq.wink.report.e.r(eVar, "dt_imp", this.errorContainer, WinkDaTongReportConstant.ElementId.EM_QZ_TRY_AGAIN, null, null, 24, null);
        getMainHandler().removeCallbacksAndMessages(null);
    }

    private final void showLoadingView() {
        Q9().r2(1);
        if (this.isBlurImageGenerated) {
            ha();
        }
        View view = this.previewOverlayContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.loadingContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.errorContainer;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.blurMaskAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        this.progressAnimator.start();
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.r(eVar, "dt_imp", this.loadingContainer, WinkDaTongReportConstant.ElementId.EM_QZ_LOADING, null, null, 24, null);
        if (this.needReportRetryEnd) {
            com.tencent.mobileqq.wink.report.e.r(eVar, "dt_imp_end", this.errorContainer, WinkDaTongReportConstant.ElementId.EM_QZ_TRY_AGAIN, null, null, 24, null);
            this.needReportRetryEnd = false;
        }
        ga();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        Z9(rootView);
        initViewModel();
        U9();
        W9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ValueAnimator valueAnimator = this.blurMaskAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.progressAnimator.cancel();
        MagicStudioCreationViewModel.s2(P9(), false, 1, null);
        getMainHandler().removeCallbacksAndMessages(null);
    }
}
