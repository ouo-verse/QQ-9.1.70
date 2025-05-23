package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StIconInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001yB\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00106R\u0018\u0010U\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010$R\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010(R\u0018\u0010]\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010(R\u0018\u0010_\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010(R\u0018\u0010a\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010(R\u0018\u0010c\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010(R\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010WR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006z"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/bs;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "", "q1", ICustomDataEditor.NUMBER_PARAM_1, "k1", "m1", "Landroid/view/View;", "view", "t1", "v1", "p1", "o1", "u1", "j1", ICustomDataEditor.STRING_PARAM_1, "", "w0", "data", "", "position", "r1", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onResumed", "onFeedSelected", "onFeedUnSelected", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", NodeProps.ON_CLICK, "I", "Landroid/view/View;", "mRootLayout", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mAdName", "K", "mAdDesc", "L", "mReplayButton", "M", "mAdClickButton", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "N", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAdLogo", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "mAdCoverImage", "Landroidx/constraintlayout/widget/ConstraintLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/constraintlayout/widget/ConstraintLayout;", "mBackGround", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "mLinearLayout", "Lcom/tencent/biz/qqcircle/widgets/QCircleDoubleClickLayout;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/biz/qqcircle/widgets/QCircleDoubleClickLayout;", "mLayout", "T", "mAdClickButtonLayout", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "U", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "mDownloadBtn", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "V", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "mDownloadBtnController", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "W", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "mPlayView", "X", "mAdMotiveIcon", "Y", "mAdBusinessCard", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "Z", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "mAdBusinessCardCover", "a0", "mAdBusinessCardDes", "b0", "mAdBusinessCardPrice", "c0", "mAdBusinessCardEndPrice", "d0", "mAdBusinessFirstLabel", "e0", "mAdBusinessLastLabel", "Lcom/tencent/gdtad/aditem/GdtAd;", "f0", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "g0", "Lfeedcloud/FeedCloudMeta$StFeed;", "mAdFeed", "", "h0", "mCanShowEndCard", "Landroid/animation/ValueAnimator;", "i0", "Landroid/animation/ValueAnimator;", "mAlphaValueAnimator", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "j0", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "mAntiSpamReportHelper", "<init>", "()V", "k0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bs extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mRootLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mAdName;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView mAdDesc;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView mReplayButton;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView mAdClickButton;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAdLogo;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdCoverImage;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mBackGround;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLinearLayout;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private QCircleDoubleClickLayout mLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAdClickButtonLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private QFSAdDownloadButton mDownloadBtn;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private AdAppDownloadButtonController mDownloadBtnController;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private QFSVideoView mPlayView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdMotiveIcon;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private View mAdBusinessCard;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private QCircleRoundImageView mAdBusinessCardCover;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardDes;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardPrice;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessCardEndPrice;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessFirstLabel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBusinessLastLabel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mAdFeed;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean mCanShowEndCard;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mAlphaValueAnimator;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GdtAd mAd = new GdtAd();

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtAntiSpamReportHelper mAntiSpamReportHelper = new GdtAntiSpamReportHelper();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(bs this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QCircleDoubleClickLayout qCircleDoubleClickLayout = this$0.mLayout;
        if (qCircleDoubleClickLayout != null) {
            qCircleDoubleClickLayout.setVisibility(8);
        }
        View view = this$0.mRootLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this$0.mRootLayout;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        ValueAnimator valueAnimator = this$0.mAlphaValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        AdAppDownloadButtonController adAppDownloadButtonController = this$0.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
        if (eq.f85700a.h(this$0.mAd) && (imageView = this$0.mAdMotiveIcon) != null) {
            imageView.setVisibility(0);
        }
    }

    private final void j1() {
        Drawable drawable;
        String w3 = af.w(this.mAdFeed, "startColor");
        String w16 = af.w(this.mAdFeed, "endColor");
        LinearLayout linearLayout = this.mAdClickButtonLayout;
        if (linearLayout != null) {
            drawable = linearLayout.getBackground();
        } else {
            drawable = null;
        }
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        af.j0((GradientDrawable) drawable, w3, w16);
    }

    private final void k1() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        this.mAlphaValueAnimator = ofInt;
        if (ofInt != null) {
            ofInt.setInterpolator(new DecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.mAlphaValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(300L);
        }
        ValueAnimator valueAnimator2 = this.mAlphaValueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bq
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    bs.l1(bs.this, valueAnimator3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(bs this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        View view = this$0.mRootLayout;
        if (view != null) {
            view.setAlpha(animation.getAnimatedFraction());
        }
    }

    private final void m1() {
        TextView textView = this.mReplayButton;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        t1(this.mAdClickButton);
        t1(this.mRootLayout);
        t1(this.mAdCoverImage);
        t1(this.mBackGround);
        t1(this.mAdLogo);
        t1(this.mAdName);
        t1(this.mAdDesc);
        t1(this.mAdBusinessCard);
        t1(this.mAdBusinessCardCover);
        t1(this.mAdBusinessCardDes);
        t1(this.mAdBusinessCardPrice);
        t1(this.mAdBusinessCardEndPrice);
        t1(this.mAdBusinessFirstLabel);
        t1(this.mAdBusinessLastLabel);
        t1(this.mAdClickButtonLayout);
    }

    private final void n1() {
        boolean k3 = af.k(this.mAd);
        QLog.d("QFSFeedChildAdEndCardPresenter", 1, "initDownloadBtnView isValid: " + k3);
        ImageView imageView = null;
        if (k3) {
            QFSAdDownloadButton qFSAdDownloadButton = this.mDownloadBtn;
            if (qFSAdDownloadButton != null) {
                imageView = (ImageView) qFSAdDownloadButton.findViewById(R.id.f3815197);
            }
        } else {
            View view = this.mRootLayout;
            if (view != null) {
                imageView = (ImageView) view.findViewById(R.id.v9y);
            }
        }
        this.mAdMotiveIcon = imageView;
        Context m06 = m0();
        Intrinsics.checkNotNull(m06, "null cannot be cast to non-null type android.app.Activity");
        this.mDownloadBtnController = af.R((Activity) m06, this.mAd, this.mDownloadBtn, this.mAdClickButtonLayout, R.drawable.kdt);
    }

    private final void o1() {
        Map<String, Object> dtReportParams = ae.c(r0(), QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_4, null, this.f85018i);
        Intrinsics.checkNotNullExpressionValue(dtReportParams, "dtReportParams");
        dtReportParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_CARD_TYPE, "2");
        HashMap hashMap = new HashMap();
        ImageView imageView = this.mAdCoverImage;
        if (imageView != null) {
        }
        QCircleAvatarView qCircleAvatarView = this.mAdLogo;
        if (qCircleAvatarView != null) {
        }
        TextView textView = this.mAdName;
        if (textView != null) {
        }
        TextView textView2 = this.mAdClickButton;
        if (textView2 != null) {
        }
        ConstraintLayout constraintLayout = this.mBackGround;
        if (constraintLayout != null) {
        }
        TextView textView3 = this.mReplayButton;
        if (textView3 != null) {
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ae.a((View) entry.getKey(), this.E, (String) entry.getValue(), dtReportParams);
        }
    }

    private final void p1() {
        TextView textView = this.mReplayButton;
        if (textView != null) {
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f187883v7));
        }
        TextView textView2 = this.mReplayButton;
        if (textView2 != null) {
            textView2.setTextColor(m0().getColor(R.color.cl7));
        }
        TextView textView3 = this.mReplayButton;
        if (textView3 != null) {
            textView3.setTextSize(1, 14.0f);
        }
        TextView textView4 = this.mAdName;
        if (textView4 != null) {
            textView4.setTextColor(m0().getColor(R.color.cla));
        }
        TextView textView5 = this.mAdDesc;
        if (textView5 != null) {
            textView5.setTextColor(m0().getColor(R.color.cl7));
        }
        TextView textView6 = this.mAdDesc;
        if (textView6 != null) {
            textView6.setTextSize(1, 15.0f);
        }
    }

    private final void q1() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        QFSAdDownloadButton qFSAdDownloadButton;
        LinearLayout linearLayout;
        TextView textView4;
        QCircleAvatarView qCircleAvatarView;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        QCircleRoundImageView qCircleRoundImageView;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        if (this.mRootLayout != null) {
            return;
        }
        this.mPlayView = (QFSVideoView) this.C.findViewById(R.id.f74163vi);
        View inflate = ((ViewStub) this.C.findViewById(R.id.v_6)).inflate();
        this.mRootLayout = inflate;
        TextView textView9 = null;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.v_3);
        } else {
            textView = null;
        }
        this.mAdName = textView;
        this.mLinearLayout = (LinearLayout) this.C.findViewById(R.id.f33120vl);
        View view = this.mRootLayout;
        if (view != null) {
            textView2 = (TextView) view.findViewById(R.id.v_4);
        } else {
            textView2 = null;
        }
        this.mReplayButton = textView2;
        View view2 = this.mRootLayout;
        if (view2 != null) {
            textView3 = (TextView) view2.findViewById(R.id.v9x);
        } else {
            textView3 = null;
        }
        this.mAdClickButton = textView3;
        View view3 = this.mRootLayout;
        if (view3 != null) {
            qFSAdDownloadButton = (QFSAdDownloadButton) view3.findViewById(R.id.f380118t);
        } else {
            qFSAdDownloadButton = null;
        }
        this.mDownloadBtn = qFSAdDownloadButton;
        if (qFSAdDownloadButton != null) {
            qFSAdDownloadButton.setPrefixTag("QFSFeedChildAdEndCardPresenter");
        }
        View view4 = this.mRootLayout;
        if (view4 != null) {
            linearLayout = (LinearLayout) view4.findViewById(R.id.v9w);
        } else {
            linearLayout = null;
        }
        this.mAdClickButtonLayout = linearLayout;
        View view5 = this.mRootLayout;
        if (view5 != null) {
            textView4 = (TextView) view5.findViewById(R.id.v_1);
        } else {
            textView4 = null;
        }
        this.mAdDesc = textView4;
        View view6 = this.mRootLayout;
        if (view6 != null) {
            qCircleAvatarView = (QCircleAvatarView) view6.findViewById(R.id.v_2);
        } else {
            qCircleAvatarView = null;
        }
        this.mAdLogo = qCircleAvatarView;
        View view7 = this.mRootLayout;
        if (view7 != null) {
            imageView = (ImageView) view7.findViewById(R.id.v9z);
        } else {
            imageView = null;
        }
        this.mAdCoverImage = imageView;
        View view8 = this.mRootLayout;
        if (view8 != null) {
            constraintLayout = (ConstraintLayout) view8.findViewById(R.id.v_5);
        } else {
            constraintLayout = null;
        }
        this.mBackGround = constraintLayout;
        this.mLayout = (QCircleDoubleClickLayout) this.C.findViewById(R.id.v_o);
        View findViewById = this.C.findViewById(R.id.f380018s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026_card_business_card_stub)");
        View inflate2 = ((ViewStub) findViewById).inflate();
        this.mAdBusinessCard = inflate2;
        if (inflate2 != null) {
            inflate2.setVisibility(8);
        }
        View view9 = this.mAdBusinessCard;
        if (view9 != null) {
            qCircleRoundImageView = (QCircleRoundImageView) view9.findViewById(R.id.f378718f);
        } else {
            qCircleRoundImageView = null;
        }
        this.mAdBusinessCardCover = qCircleRoundImageView;
        View view10 = this.mAdBusinessCard;
        if (view10 != null) {
            textView5 = (TextView) view10.findViewById(R.id.f378818g);
        } else {
            textView5 = null;
        }
        this.mAdBusinessCardDes = textView5;
        View view11 = this.mAdBusinessCard;
        if (view11 != null) {
            textView6 = (TextView) view11.findViewById(R.id.f379218k);
        } else {
            textView6 = null;
        }
        this.mAdBusinessCardPrice = textView6;
        View view12 = this.mAdBusinessCard;
        if (view12 != null) {
            textView7 = (TextView) view12.findViewById(R.id.f378918h);
        } else {
            textView7 = null;
        }
        this.mAdBusinessCardEndPrice = textView7;
        View view13 = this.mAdBusinessCard;
        if (view13 != null) {
            textView8 = (TextView) view13.findViewById(R.id.f379018i);
        } else {
            textView8 = null;
        }
        this.mAdBusinessFirstLabel = textView8;
        View view14 = this.mAdBusinessCard;
        if (view14 != null) {
            textView9 = (TextView) view14.findViewById(R.id.f379118j);
        }
        this.mAdBusinessLastLabel = textView9;
        View view15 = this.mRootLayout;
        if (view15 != null) {
            view15.setVisibility(8);
        }
        k1();
        o1();
        j1();
    }

    private final void s1() {
        TextView textView = this.mAdBusinessCardEndPrice;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mAdBusinessCardPrice;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.mAdBusinessFirstLabel;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.mAdBusinessLastLabel;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    private final void t1(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(this);
        this.mAntiSpamReportHelper.listenOnTouchEvent(view);
    }

    private final void u1() {
        boolean z16;
        boolean z17;
        TextPaint textPaint;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo adMaterialInfo = this.mAd.getAdMaterialInfo();
        if (adMaterialInfo != null) {
            QCircleRoundImageView qCircleRoundImageView = this.mAdBusinessCardCover;
            if (qCircleRoundImageView != null) {
                qCircleRoundImageView.setRoundRect(com.tencent.biz.qqcircle.utils.cx.a(3.0f));
            }
            TextView textView = this.mAdBusinessCardDes;
            if (textView != null) {
                textView.setText(adMaterialInfo.title.get());
            }
            Option regionWidth = Option.obtain().setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setTargetView(this.mAdBusinessCardCover).setUrl(adMaterialInfo.image_url.get()).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(72.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(72.0f));
            regionWidth.setSupportRecycler(false);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
            List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> labelList = this.mAd.getLabelList();
            String price = adMaterialInfo.price.get();
            String str = adMaterialInfo.original_price.get();
            Intrinsics.checkNotNullExpressionValue(price, "price");
            boolean z18 = true;
            if (price.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView textView2 = this.mAdBusinessCardPrice;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.mAdBusinessCardPrice;
                if (textView3 != null) {
                    textView3.setText("\u00a5 " + price);
                }
                String str2 = adMaterialInfo.original_price.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.original_price.get()");
                if (str2.length() <= 0) {
                    z18 = false;
                }
                if (z18) {
                    TextView textView4 = this.mAdBusinessCardEndPrice;
                    if (textView4 != null) {
                        textView4.setText("\u00a5 " + str);
                    }
                    TextView textView5 = this.mAdBusinessCardEndPrice;
                    if (textView5 != null) {
                        textPaint = textView5.getPaint();
                    } else {
                        textPaint = null;
                    }
                    if (textPaint != null) {
                        textPaint.setFlags(16);
                    }
                    TextView textView6 = this.mAdBusinessCardEndPrice;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            String str3 = adMaterialInfo.original_price.get();
            Intrinsics.checkNotNullExpressionValue(str3, "it.original_price.get()");
            if (str3.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                TextView textView7 = this.mAdBusinessCardPrice;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                TextView textView8 = this.mAdBusinessCardPrice;
                if (textView8 != null) {
                    textView8.setText("\u00a5 " + str);
                    return;
                }
                return;
            }
            if (labelList != null && (!labelList.isEmpty())) {
                String str4 = labelList.get(0).content.get();
                TextView textView9 = this.mAdBusinessFirstLabel;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                TextView textView10 = this.mAdBusinessFirstLabel;
                if (textView10 != null) {
                    textView10.setText(str4);
                }
                if (labelList.size() > 1 && str4.length() < 9) {
                    TextView textView11 = this.mAdBusinessLastLabel;
                    if (textView11 != null) {
                        textView11.setVisibility(0);
                    }
                    TextView textView12 = this.mAdBusinessLastLabel;
                    if (textView12 != null) {
                        textView12.setText(labelList.get(1).content.get());
                    }
                }
            }
        }
    }

    private final void v1() {
        String str;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        PBUInt32Field pBUInt32Field;
        String str2;
        PBStringField pBStringField;
        String str3;
        PBStringField pBStringField2;
        String str4;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField3;
        ImageView imageView;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        FeedCloudMeta$StIconInfo feedCloudMeta$StIconInfo;
        PBStringField pBStringField4;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mAdFeed;
        ViewGroup.LayoutParams layoutParams3 = null;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser2 = feedCloudMeta$StFeed.poster) != null && (feedCloudMeta$StIconInfo = feedCloudMeta$StUser2.icon) != null && (pBStringField4 = feedCloudMeta$StIconInfo.iconUrl) != null) {
            str = pBStringField4.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            Option obtain = Option.obtain();
            QCircleAvatarView qCircleAvatarView = this.mAdLogo;
            if (qCircleAvatarView != null) {
                imageView = qCircleAvatarView.k();
            } else {
                imageView = null;
            }
            Option regionWidth = obtain.setTargetView(imageView).setUrl(str).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(66.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(66.0f)).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(66.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(66.0f));
            regionWidth.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
        }
        TextView textView = this.mAdName;
        if (textView != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mAdFeed;
            if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField3 = feedCloudMeta$StUser.nick) != null) {
                str4 = pBStringField3.get();
            } else {
                str4 = null;
            }
            textView.setText(str4);
        }
        TextView textView2 = this.mAdDesc;
        if (textView2 != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.mAdFeed;
            if (feedCloudMeta$StFeed3 != null && (pBStringField2 = feedCloudMeta$StFeed3.content) != null) {
                str3 = pBStringField2.get();
            } else {
                str3 = null;
            }
            textView2.setText(str3);
        }
        TextView textView3 = this.mAdClickButton;
        if (textView3 != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.mAdFeed;
            if (feedCloudMeta$StFeed4 != null && (pBStringField = feedCloudMeta$StFeed4.subtitle) != null) {
                str2 = pBStringField.get();
            } else {
                str2 = null;
            }
            textView3.setText(str2);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed5 = this.mAdFeed;
        if (feedCloudMeta$StFeed5 != null && (pBUInt32Field = feedCloudMeta$StFeed5.status) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        eq eqVar = eq.f85700a;
        if (eqVar.m(this.mAd, i3)) {
            p1();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(m0().getColor(R.color.ckx));
            gradientDrawable.setCornerRadius(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
            ConstraintLayout constraintLayout = this.mBackGround;
            if (constraintLayout != null) {
                constraintLayout.setBackground(gradientDrawable);
            }
            ImageView imageView2 = this.mAdCoverImage;
            if (imageView2 != null) {
                imageView2.setBackground(new ColorDrawable(m0().getColor(R.color.cj8)));
                return;
            }
            return;
        }
        if (eqVar.i(this.mAd, i3)) {
            p1();
            ConstraintLayout constraintLayout2 = this.mBackGround;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackground(new ColorDrawable(0));
            }
            ConstraintLayout constraintLayout3 = this.mBackGround;
            if (constraintLayout3 != null) {
                layoutParams = constraintLayout3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = -1;
            layoutParams4.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(44.0f);
            layoutParams4.rightMargin = com.tencent.biz.qqcircle.utils.cx.a(44.0f);
            ConstraintLayout constraintLayout4 = this.mBackGround;
            if (constraintLayout4 != null) {
                constraintLayout4.setLayoutParams(layoutParams4);
            }
            LinearLayout linearLayout = this.mAdClickButtonLayout;
            if (linearLayout != null) {
                layoutParams2 = linearLayout.getLayoutParams();
            } else {
                layoutParams2 = null;
            }
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams2)).bottomMargin = com.tencent.biz.qqcircle.utils.cx.a(10.0f);
            LinearLayout linearLayout2 = this.mAdClickButtonLayout;
            if (linearLayout2 != null) {
                layoutParams3 = linearLayout2.getLayoutParams();
            }
            if (layoutParams3 != null) {
                layoutParams3.width = -1;
            }
            TextView textView4 = this.mAdDesc;
            if (textView4 != null) {
                textView4.setMaxWidth(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@NotNull com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) && TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.e) event).getMTraceId(), this.mAd.getTraceId()) && this.mCanShowEndCard) {
            View view = this.mRootLayout;
            boolean z16 = false;
            if (view != null && view.getVisibility() == 0) {
                z16 = true;
            }
            if (!z16) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.br
                    @Override // java.lang.Runnable
                    public final void run() {
                        bs.i1(bs.this);
                    }
                });
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        int i3 = 0;
        if (num != null && num.intValue() == R.id.v_4) {
            View view = this.mRootLayout;
            if (view != null) {
                view.setVisibility(8);
            }
            LinearLayout linearLayout = this.mLinearLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            QCircleDoubleClickLayout qCircleDoubleClickLayout = this.mLayout;
            if (qCircleDoubleClickLayout != null) {
                qCircleDoubleClickLayout.setVisibility(0);
            }
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.f(this.mAd.getTraceId()));
        } else {
            Integer b16 = a.f85437a.b(num);
            String adAntiSpamForClickParams = this.mAntiSpamReportHelper.getAdAntiSpamForClickParams(this.C);
            com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
            GdtAd gdtAd = this.mAd;
            View view2 = this.C;
            int i16 = this.f85018i;
            QCircleExtraTypeInfo r16 = r();
            if (b16 != null) {
                i3 = b16.intValue();
            }
            jVar.J(gdtAd, view2, i16, r16, i3, adAntiSpamForClickParams);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        this.mAntiSpamReportHelper.onDestroy();
        super.onDestroy();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mDownloadBtn));
        }
        this.mDownloadBtnController = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        View view = this.mRootLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        QCircleDoubleClickLayout qCircleDoubleClickLayout = this.mLayout;
        if (qCircleDoubleClickLayout != null) {
            qCircleDoubleClickLayout.setVisibility(0);
        }
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        this.mAntiSpamReportHelper.setExpoTime();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        this.mAntiSpamReportHelper.resetExpoTime();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewPause();
        }
        super.onFeedUnSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        AdAppDownloadButtonController adAppDownloadButtonController = this.mDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.L0(data, position);
        this.mAdFeed = u.c(this.E);
        this.mAd = new GdtAd(u.e(this.E));
        e30.b bVar = this.E;
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        this.mCanShowEndCard = af.h(feedCloudMeta$StFeed, this.mAdFeed, this.mAd);
        View view = this.mRootLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!this.mCanShowEndCard) {
            View view2 = this.mAdBusinessCard;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        q1();
        s1();
        eq eqVar = eq.f85700a;
        if (eqVar.d(this.mAd, 1)) {
            View view3 = this.mAdBusinessCard;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            TextView textView = this.mAdDesc;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.mAdName;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            u1();
        } else {
            View view4 = this.mAdBusinessCard;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            TextView textView3 = this.mAdDesc;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.mAdName;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        v1();
        m1();
        n1();
        if (eqVar.h(this.mAd)) {
            ImageView imageView = this.mAdMotiveIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.mAdMotiveIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        U0(ae.b(data, position));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdEndCardPresenter";
    }
}
