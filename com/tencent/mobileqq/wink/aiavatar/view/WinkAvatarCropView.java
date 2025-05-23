package com.tencent.mobileqq.wink.aiavatar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView;
import com.tencent.smtt.utils.Md5Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u0001XB'\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010U\u001a\u00020\u0010\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ,\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\bJ.\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%J.\u0010(\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0010J\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\u0004R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00105R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "F0", "D0", "E0", "", "enable", "B0", "useBigLoadingView", "setUseBigLoadingView", "Lkotlin/Function0;", "listener", "setResultImageOnClickListener", "", "heightPx", "setTopBlankViewHeight", "check", "setCheckboxState", "(Ljava/lang/Boolean;)V", "isVisible", "setMaskBorderVisible", "setCornerMaskVisible", "setAnchorBarVisible", "targetWidth", "targetHeight", "usedARGB", "forResultImage", "Landroid/graphics/Bitmap;", "C0", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/RectF;", "faceDetectResult", "", "faceRatio", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView$FaceFillPriority;", "faceFillPriority", "J0", "H0", "widthDp", "setCircleBorderWidth", "release", "setAnchorBarWidth", "show", "G0", "A0", "d", "I", "topBlankViewHeight", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;", "e", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarImageView;", "avatarImageView", "f", "avatarResultImageView", h.F, "Lkotlin/jvm/functions/Function0;", "onResultImageViewClick", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarMaskView;", "i", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarMaskView;", "avatarMaskView", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "avatarSelectImageView", "Lcom/airbnb/lottie/LottieAnimationView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/airbnb/lottie/LottieAnimationView;", "loadingProgressView", "D", "loadingShimmer", "E", "Landroid/view/View;", "topBlankView", UserInfo.SEX_FEMALE, "bottomBlankView", "G", "Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAvatarCropView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private LottieAnimationView loadingProgressView;

    /* renamed from: D, reason: from kotlin metadata */
    private LottieAnimationView loadingShimmer;

    /* renamed from: E, reason: from kotlin metadata */
    private View topBlankView;

    /* renamed from: F, reason: from kotlin metadata */
    private View bottomBlankView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean useBigLoadingView;

    @NotNull
    public Map<Integer, View> H;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int topBlankViewHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WinkAvatarImageView avatarImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private WinkAvatarImageView avatarResultImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onResultImageViewClick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WinkAvatarMaskView avatarMaskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarSelectImageView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarCropView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void D0() {
        String str;
        String str2;
        if (this.useBigLoadingView) {
            str = "https://downv6.qq.com/shadow_qqcamera/AIAvatar/qq_avatar_ai_couple_loading_number.json";
        } else {
            str = "https://downv6.qq.com/shadow_qqcamera/AIAvatar/qq_avatar_ai_loading_number.json";
        }
        LottieAnimationView lottieAnimationView = this.loadingProgressView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setAnimationFromUrl(str, Md5Utils.getMD5(str));
        LottieAnimationView lottieAnimationView3 = this.loadingProgressView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.cancelAnimation();
        if (this.useBigLoadingView) {
            str2 = "https://downv6.qq.com/shadow_qqcamera/AIAvatar/qq_avatar_ai_couple_loading_bg.json";
        } else {
            str2 = "https://downv6.qq.com/shadow_qqcamera/AIAvatar/qq_avatar_ai_loading_bg.json";
        }
        LottieAnimationView lottieAnimationView4 = this.loadingShimmer;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
            lottieAnimationView4 = null;
        }
        lottieAnimationView4.setAnimationFromUrl(str2, Md5Utils.getMD5(str2));
        LottieAnimationView lottieAnimationView5 = this.loadingShimmer;
        if (lottieAnimationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
        } else {
            lottieAnimationView2 = lottieAnimationView5;
        }
        lottieAnimationView2.cancelAnimation();
    }

    private final void E0() {
        G0(false);
        D0();
    }

    private final void F0(View rootView) {
        View findViewById = rootView.findViewById(R.id.f116066xq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.vTopBlank)");
        this.topBlankView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f115916xb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.vBottomBlank)");
        this.bottomBlankView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.xye);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.ivAvatar)");
        this.avatarImageView = (WinkAvatarImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f115886x9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.vAvatarMask)");
        this.avatarMaskView = (WinkAvatarMaskView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.xyg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ivAvatarSelect)");
        this.avatarSelectImageView = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.xyf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.ivAvatarResult)");
        this.avatarResultImageView = (WinkAvatarImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f116006xk);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.vLoadingProgress)");
        this.loadingProgressView = (LottieAnimationView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f116016xl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.vLoadingShimmer)");
        this.loadingShimmer = (LottieAnimationView) findViewById8;
        int color = getContext().getColor(R.color.qui_common_bg_bottom_standard);
        View view = this.topBlankView;
        WinkAvatarImageView winkAvatarImageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBlankView");
            view = null;
        }
        view.setBackgroundColor(color);
        setTopBlankViewHeight(this.topBlankViewHeight);
        View view2 = this.bottomBlankView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBlankView");
            view2 = null;
        }
        view2.setBackgroundColor(color);
        setCornerMaskVisible(true);
        WinkAvatarImageView winkAvatarImageView2 = this.avatarResultImageView;
        if (winkAvatarImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView2;
        }
        winkAvatarImageView.setOnTapListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarCropView$initView$1
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
                Function0 function0;
                function0 = WinkAvatarCropView.this.onResultImageViewClick;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        E0();
    }

    public static /* synthetic */ void I0(WinkAvatarCropView winkAvatarCropView, Bitmap bitmap, RectF rectF, float f16, WinkAvatarImageView.FaceFillPriority faceFillPriority, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            rectF = null;
        }
        if ((i3 & 4) != 0) {
            f16 = 0.3f;
        }
        if ((i3 & 8) != 0) {
            faceFillPriority = WinkAvatarImageView.FaceFillPriority.LongSide;
        }
        winkAvatarCropView.H0(bitmap, rectF, f16, faceFillPriority);
    }

    public static /* synthetic */ void K0(WinkAvatarCropView winkAvatarCropView, Bitmap bitmap, RectF rectF, float f16, WinkAvatarImageView.FaceFillPriority faceFillPriority, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            rectF = null;
        }
        if ((i3 & 4) != 0) {
            f16 = 0.3f;
        }
        if ((i3 & 8) != 0) {
            faceFillPriority = WinkAvatarImageView.FaceFillPriority.LongSide;
        }
        winkAvatarCropView.J0(bitmap, rectF, f16, faceFillPriority);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setResultImageOnClickListener$default(WinkAvatarCropView winkAvatarCropView, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        winkAvatarCropView.setResultImageOnClickListener(function0);
    }

    public final void A0() {
        WinkAvatarImageView winkAvatarImageView = this.avatarImageView;
        WinkAvatarImageView winkAvatarImageView2 = null;
        if (winkAvatarImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView = null;
        }
        winkAvatarImageView.y();
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView2 = winkAvatarImageView3;
        }
        winkAvatarImageView2.y();
    }

    public final void B0(boolean enable) {
        WinkAvatarImageView winkAvatarImageView = this.avatarImageView;
        WinkAvatarImageView winkAvatarImageView2 = null;
        if (winkAvatarImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView = null;
        }
        winkAvatarImageView.B(enable);
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView2 = winkAvatarImageView3;
        }
        winkAvatarImageView2.B(enable);
    }

    @Nullable
    public final Bitmap C0(int targetWidth, int targetHeight, boolean usedARGB, boolean forResultImage) {
        WinkAvatarImageView winkAvatarImageView = null;
        if (forResultImage) {
            WinkAvatarImageView winkAvatarImageView2 = this.avatarResultImageView;
            if (winkAvatarImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
            } else {
                winkAvatarImageView = winkAvatarImageView2;
            }
            return winkAvatarImageView.C(targetWidth, targetHeight, usedARGB);
        }
        WinkAvatarImageView winkAvatarImageView3 = this.avatarImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView3;
        }
        return winkAvatarImageView.C(targetWidth, targetHeight, usedARGB);
    }

    public final void G0(boolean show) {
        WinkAvatarImageView winkAvatarImageView = null;
        LottieAnimationView lottieAnimationView = null;
        if (show) {
            LottieAnimationView lottieAnimationView2 = this.loadingProgressView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setVisibility(0);
            LottieAnimationView lottieAnimationView3 = this.loadingShimmer;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setVisibility(0);
            WinkAvatarImageView winkAvatarImageView2 = this.avatarImageView;
            if (winkAvatarImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
                winkAvatarImageView2 = null;
            }
            winkAvatarImageView2.setBlurImageVisible(true);
            WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
            if (winkAvatarImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
                winkAvatarImageView3 = null;
            }
            winkAvatarImageView3.setBlurImageVisible(true);
            LottieAnimationView lottieAnimationView4 = this.loadingShimmer;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
                lottieAnimationView4 = null;
            }
            lottieAnimationView4.playAnimation();
            LottieAnimationView lottieAnimationView5 = this.loadingProgressView;
            if (lottieAnimationView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
                lottieAnimationView5 = null;
            }
            lottieAnimationView5.setRepeatCount(0);
            LottieAnimationView lottieAnimationView6 = this.loadingProgressView;
            if (lottieAnimationView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
            } else {
                lottieAnimationView = lottieAnimationView6;
            }
            lottieAnimationView.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView7 = this.loadingShimmer;
        if (lottieAnimationView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
            lottieAnimationView7 = null;
        }
        lottieAnimationView7.cancelAnimation();
        LottieAnimationView lottieAnimationView8 = this.loadingProgressView;
        if (lottieAnimationView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
            lottieAnimationView8 = null;
        }
        lottieAnimationView8.cancelAnimation();
        LottieAnimationView lottieAnimationView9 = this.loadingShimmer;
        if (lottieAnimationView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingShimmer");
            lottieAnimationView9 = null;
        }
        lottieAnimationView9.setVisibility(8);
        LottieAnimationView lottieAnimationView10 = this.loadingProgressView;
        if (lottieAnimationView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressView");
            lottieAnimationView10 = null;
        }
        lottieAnimationView10.setVisibility(8);
        WinkAvatarImageView winkAvatarImageView4 = this.avatarImageView;
        if (winkAvatarImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView4 = null;
        }
        winkAvatarImageView4.setBlurImageVisible(false);
        WinkAvatarImageView winkAvatarImageView5 = this.avatarResultImageView;
        if (winkAvatarImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView5;
        }
        winkAvatarImageView.setBlurImageVisible(false);
    }

    public final void H0(@NotNull Bitmap bitmap, @Nullable RectF faceDetectResult, float faceRatio, @NotNull WinkAvatarImageView.FaceFillPriority faceFillPriority) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(faceFillPriority, "faceFillPriority");
        WinkAvatarImageView winkAvatarImageView = this.avatarImageView;
        WinkAvatarImageView winkAvatarImageView2 = null;
        if (winkAvatarImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView = null;
        }
        winkAvatarImageView.setImageBitmap(bitmap);
        if (faceDetectResult != null) {
            WinkAvatarImageView winkAvatarImageView3 = this.avatarImageView;
            if (winkAvatarImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
                winkAvatarImageView3 = null;
            }
            winkAvatarImageView3.setFaceRatioRectF(faceDetectResult, faceRatio, faceFillPriority);
        }
        WinkAvatarImageView winkAvatarImageView4 = this.avatarImageView;
        if (winkAvatarImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView4 = null;
        }
        winkAvatarImageView4.setVisibility(0);
        WinkAvatarImageView winkAvatarImageView5 = this.avatarResultImageView;
        if (winkAvatarImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView2 = winkAvatarImageView5;
        }
        winkAvatarImageView2.setVisibility(4);
    }

    public final void J0(@NotNull Bitmap bitmap, @Nullable RectF faceDetectResult, float faceRatio, @NotNull WinkAvatarImageView.FaceFillPriority faceFillPriority) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(faceFillPriority, "faceFillPriority");
        WinkAvatarImageView winkAvatarImageView = this.avatarResultImageView;
        WinkAvatarImageView winkAvatarImageView2 = null;
        if (winkAvatarImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
            winkAvatarImageView = null;
        }
        winkAvatarImageView.setImageBitmap(bitmap);
        if (faceDetectResult != null) {
            WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
            if (winkAvatarImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
                winkAvatarImageView3 = null;
            }
            winkAvatarImageView3.setFaceRatioRectF(faceDetectResult, faceRatio, faceFillPriority);
        }
        WinkAvatarImageView winkAvatarImageView4 = this.avatarResultImageView;
        if (winkAvatarImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
            winkAvatarImageView4 = null;
        }
        winkAvatarImageView4.setVisibility(0);
        WinkAvatarImageView winkAvatarImageView5 = this.avatarImageView;
        if (winkAvatarImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
        } else {
            winkAvatarImageView2 = winkAvatarImageView5;
        }
        winkAvatarImageView2.setVisibility(4);
        G0(false);
    }

    public final void release() {
        WinkAvatarImageView winkAvatarImageView = this.avatarImageView;
        WinkAvatarImageView winkAvatarImageView2 = null;
        if (winkAvatarImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView = null;
        }
        winkAvatarImageView.L();
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView2 = winkAvatarImageView3;
        }
        winkAvatarImageView2.L();
    }

    public final void setAnchorBarVisible(boolean isVisible) {
        WinkAvatarMaskView winkAvatarMaskView = this.avatarMaskView;
        if (winkAvatarMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarMaskView");
            winkAvatarMaskView = null;
        }
        winkAvatarMaskView.setShowAnchorBar(isVisible);
    }

    public final void setAnchorBarWidth(int widthDp) {
        int dpToPx = ViewUtils.dpToPx(widthDp);
        WinkAvatarMaskView winkAvatarMaskView = this.avatarMaskView;
        WinkAvatarImageView winkAvatarImageView = null;
        if (winkAvatarMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarMaskView");
            winkAvatarMaskView = null;
        }
        winkAvatarMaskView.setAnchorBarStrokeWidthPx(dpToPx);
        WinkAvatarImageView winkAvatarImageView2 = this.avatarImageView;
        if (winkAvatarImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView2 = null;
        }
        winkAvatarImageView2.setAnchorBarStrokeWidth(dpToPx);
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView3;
        }
        winkAvatarImageView.setAnchorBarStrokeWidth(dpToPx);
    }

    public final void setCheckboxState(@Nullable Boolean check) {
        Drawable drawable;
        ImageView imageView = null;
        if (check == null) {
            ImageView imageView2 = this.avatarSelectImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarSelectImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.avatarSelectImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarSelectImageView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        if (check.booleanValue()) {
            drawable = getContext().getDrawable(R.drawable.odn);
        } else {
            drawable = getContext().getDrawable(R.drawable.odm);
        }
        ImageView imageView4 = this.avatarSelectImageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarSelectImageView");
        } else {
            imageView = imageView4;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setCircleBorderWidth(int widthDp) {
        WinkAvatarMaskView winkAvatarMaskView = this.avatarMaskView;
        if (winkAvatarMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarMaskView");
            winkAvatarMaskView = null;
        }
        winkAvatarMaskView.setCircleStrokeWidthPx(ViewUtils.dpToPx(widthDp));
    }

    public final void setCornerMaskVisible(boolean isVisible) {
        WinkAvatarMaskView winkAvatarMaskView = this.avatarMaskView;
        WinkAvatarImageView winkAvatarImageView = null;
        if (winkAvatarMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarMaskView");
            winkAvatarMaskView = null;
        }
        winkAvatarMaskView.setShowCornerMask(isVisible);
        WinkAvatarImageView winkAvatarImageView2 = this.avatarImageView;
        if (winkAvatarImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView2 = null;
        }
        winkAvatarImageView2.setBlurCornerMaskVisible(isVisible);
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView3;
        }
        winkAvatarImageView.setBlurCornerMaskVisible(isVisible);
    }

    public final void setMaskBorderVisible(boolean isVisible) {
        WinkAvatarMaskView winkAvatarMaskView = this.avatarMaskView;
        if (winkAvatarMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarMaskView");
            winkAvatarMaskView = null;
        }
        winkAvatarMaskView.setShowCircleBorder(isVisible);
    }

    public final void setResultImageOnClickListener(@Nullable Function0<Unit> listener) {
        this.onResultImageViewClick = listener;
    }

    public final void setTopBlankViewHeight(int heightPx) {
        View view = this.topBlankView;
        WinkAvatarImageView winkAvatarImageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBlankView");
            view = null;
        }
        View view2 = this.topBlankView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBlankView");
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = heightPx;
        view.setLayoutParams(layoutParams);
        this.topBlankViewHeight = heightPx;
        WinkAvatarImageView winkAvatarImageView2 = this.avatarImageView;
        if (winkAvatarImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
            winkAvatarImageView2 = null;
        }
        float f16 = heightPx;
        winkAvatarImageView2.setTopOffset(f16);
        WinkAvatarImageView winkAvatarImageView3 = this.avatarResultImageView;
        if (winkAvatarImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarResultImageView");
        } else {
            winkAvatarImageView = winkAvatarImageView3;
        }
        winkAvatarImageView.setTopOffset(f16);
    }

    public final void setUseBigLoadingView(boolean useBigLoadingView) {
        this.useBigLoadingView = useBigLoadingView;
        D0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarCropView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkAvatarCropView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.H = new LinkedHashMap();
        View view = LayoutInflater.from(context).inflate(R.layout.i3m, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        F0(view);
    }

    public /* synthetic */ WinkAvatarCropView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
