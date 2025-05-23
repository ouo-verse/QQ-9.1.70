package com.qzone.reborn.feedpro.widget.comment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.reborn.feedpro.viewmodel.i;
import com.qzone.reborn.feedpro.widget.comment.QZoneFeedProDetailBottomAdBlockView;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.util.k;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.e;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001RB\u000f\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0014J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0018\u00101\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001aR\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailBottomAdBlockView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/gdtad/aditem/GdtAd;", "Landroid/view/View$OnClickListener;", "", "initView", "ad", "D0", "A0", "v0", "B0", "r0", "x0", "u0", "", "getLayoutId", com.tencent.luggage.wxa.c8.c.G, "s0", "z0", "y0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mAdContainer", "f", "mAdView", "Landroid/widget/RelativeLayout;", h.F, "Landroid/widget/RelativeLayout;", "mAdInfoView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mAdImage", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAdDes", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAdAvatar", "D", "mAdName", "E", "mAdFeedBackContainer", "Lcom/qzone/reborn/feedpro/viewmodel/i;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "G", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mAdExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "H", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mCallBack", "I", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "J", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mOnScrollListener", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "K", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mAdFeedbackDialogListener", "", "L", "Z", "mIsExistMoreComment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedProDetailBottomAdBlockView extends QZoneBaseWidgetView<GdtAd> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserAvatarView mAdAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAdName;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout mAdFeedBackContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private i mDetailViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private AdExposureChecker mAdExposureChecker;

    /* renamed from: H, reason: from kotlin metadata */
    private AdExposureChecker.ExposureCallback mCallBack;

    /* renamed from: I, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: J, reason: from kotlin metadata */
    private final RecyclerView.OnScrollListener mOnScrollListener;

    /* renamed from: K, reason: from kotlin metadata */
    private final AdFeedbackDialogFragment.Listener mAdFeedbackDialogListener;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsExistMoreComment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAdContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAdView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mAdInfoView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAdImage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAdDes;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailBottomAdBlockView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0 || QZoneAdFeedUtils.f55717a.p(QZoneFeedProDetailBottomAdBlockView.this.mAdView, QZoneFeedProDetailBottomAdBlockView.this.getHostActivity()) <= 1.0f) {
                return;
            }
            QZoneFeedProDetailBottomAdBlockView.this.x0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailBottomAdBlockView$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            ImageView imageView = QZoneFeedProDetailBottomAdBlockView.this.mAdImage;
            if (imageView != null && (viewTreeObserver = imageView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            ImageView imageView2 = QZoneFeedProDetailBottomAdBlockView.this.mAdImage;
            if (imageView2 != null) {
                imageView2.getLayoutParams().height = (imageView2.getMeasuredWidth() * 9) / 16;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailBottomAdBlockView$d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            if (QZoneAdFeedUtils.f55717a.p(QZoneFeedProDetailBottomAdBlockView.this.mAdView, QZoneFeedProDetailBottomAdBlockView.this.getHostActivity()) > 1.0f) {
                QZoneFeedProDetailBottomAdBlockView.this.x0();
            }
            LinearLayout linearLayout = QZoneFeedProDetailBottomAdBlockView.this.mAdView;
            if (linearLayout == null || (viewTreeObserver = linearLayout.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedProDetailBottomAdBlockView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnScrollListener = new b();
        this.mAdFeedbackDialogListener = new AdFeedbackDialogFragment.Listener() { // from class: se.b
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QZoneFeedProDetailBottomAdBlockView.w0(QZoneFeedProDetailBottomAdBlockView.this, result);
            }
        };
        this.mDetailViewModel = (i) p(i.class);
    }

    private final void A0() {
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        adFeedbackParams.activity = new WeakReference<>((Activity) context);
        adFeedbackParams.listener = new WeakReference<>(this.mAdFeedbackDialogListener);
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        adFeedbackParams.f61346ad = gdtAd;
        adFeedbackParams.isDarkMode = QQTheme.isNowThemeIsNight();
        adFeedbackParams.shouldShowCancelButton = false;
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QZoneFeedProDetailBottomAdBlockView", 1, "openAdFeedBackDialog", th5);
        }
    }

    private final void B0() {
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        this.mAdExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(this.mAdView));
        this.mCallBack = new AdExposureChecker.ExposureCallback() { // from class: se.c
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                QZoneFeedProDetailBottomAdBlockView.C0(QZoneFeedProDetailBottomAdBlockView.this, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(new WeakReference<>(this.mCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QZoneFeedProDetailBottomAdBlockView this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZoneFeedProDetailBottomAdBlockView", 2, "onExposure expo checker success");
        this$0.r0();
    }

    private final void D0(GdtAd ad5) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        if (!TextUtils.isEmpty(ad5.getTraceId()) && this.mAd != null) {
            String traceId = ad5.getTraceId();
            GdtAd gdtAd = this.mAd;
            if (gdtAd == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAd");
                gdtAd = null;
            }
            if (TextUtils.equals(traceId, gdtAd.getTraceId())) {
                return;
            }
        }
        this.mAd = ad5;
        LinearLayout linearLayout = this.mAdContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd2 = null;
        }
        String text = gdtAd2.getText();
        if (text == null) {
            text = "";
        }
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd3 = null;
        }
        String advertiser_corporate_image_name = gdtAd3.getAdvertiser_corporate_image_name();
        GdtAd gdtAd4 = this.mAd;
        if (gdtAd4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd4 = null;
        }
        String advertiser_corporate_logo = gdtAd4.getAdvertiser_corporate_logo();
        GdtAd gdtAd5 = this.mAd;
        if (gdtAd5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd5 = null;
        }
        GdtImageData imageData = gdtAd5.getImageData();
        String str = imageData != null ? imageData.url : null;
        String str2 = str != null ? str : "";
        TextView textView = this.mAdDes;
        if (textView != null) {
            textView.setText(text);
        }
        TextView textView2 = this.mAdName;
        if (textView2 != null) {
            textView2.setText(advertiser_corporate_image_name);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAdImage).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(true).setUrl(str2));
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAdAvatar).setNeedShowLoadingDrawable(false).setUrl(advertiser_corporate_logo));
        ImageView imageView = this.mAdImage;
        if (imageView != null && (viewTreeObserver2 = imageView.getViewTreeObserver()) != null) {
            viewTreeObserver2.addOnGlobalLayoutListener(new c());
        }
        B0();
        LinearLayout linearLayout2 = this.mAdView;
        if (linearLayout2 != null && (viewTreeObserver = linearLayout2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new d());
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup instanceof RecyclerView) {
            ((RecyclerView) viewGroup).addOnScrollListener(this.mOnScrollListener);
        }
    }

    private final void initView() {
        if (this.mAdContainer != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.nm7);
        LinearLayout linearLayout = (LinearLayout) (viewStub != null ? viewStub.inflate() : null);
        this.mAdContainer = linearLayout;
        if (linearLayout == null) {
            return;
        }
        this.mAdView = linearLayout != null ? (LinearLayout) linearLayout.findViewById(R.id.f20277y) : null;
        LinearLayout linearLayout2 = this.mAdContainer;
        this.mAdInfoView = linearLayout2 != null ? (RelativeLayout) linearLayout2.findViewById(R.id.f20247v) : null;
        LinearLayout linearLayout3 = this.mAdContainer;
        this.mAdImage = linearLayout3 != null ? (ImageView) linearLayout3.findViewById(R.id.f20237u) : null;
        LinearLayout linearLayout4 = this.mAdContainer;
        this.mAdDes = linearLayout4 != null ? (TextView) linearLayout4.findViewById(R.id.f20227t) : null;
        LinearLayout linearLayout5 = this.mAdContainer;
        QZoneUserAvatarView qZoneUserAvatarView = linearLayout5 != null ? (QZoneUserAvatarView) linearLayout5.findViewById(R.id.f20197q) : null;
        this.mAdAvatar = qZoneUserAvatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setClickable(false);
        }
        LinearLayout linearLayout6 = this.mAdContainer;
        this.mAdName = linearLayout6 != null ? (TextView) linearLayout6.findViewById(R.id.f20267x) : null;
        LinearLayout linearLayout7 = this.mAdContainer;
        this.mAdFeedBackContainer = linearLayout7 != null ? (LinearLayout) linearLayout7.findViewById(R.id.f203081) : null;
        LinearLayout linearLayout8 = this.mAdView;
        if (linearLayout8 != null) {
            linearLayout8.setOnClickListener(this);
        }
        LinearLayout linearLayout9 = this.mAdFeedBackContainer;
        if (linearLayout9 != null) {
            linearLayout9.setOnClickListener(this);
        }
        if (k.f59549a.f()) {
            ImageView imageView = this.mAdImage;
            if (imageView != null) {
                imageView.setBackgroundColor(-16777216);
            }
            ImageView imageView2 = this.mAdImage;
            if (imageView2 != null) {
                imageView2.setAlpha(0.8f);
            }
            TextView textView = this.mAdDes;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mAdName;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#66EBEBF5"));
            }
            QZoneUserAvatarView qZoneUserAvatarView2 = this.mAdAvatar;
            if (qZoneUserAvatarView2 != null) {
                qZoneUserAvatarView2.setBackgroundColor(Color.parseColor("#1F1F1F"));
            }
            QZoneUserAvatarView qZoneUserAvatarView3 = this.mAdAvatar;
            if (qZoneUserAvatarView3 != null) {
                qZoneUserAvatarView3.setAlpha(0.8f);
            }
            RelativeLayout relativeLayout = this.mAdInfoView;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
            }
        }
    }

    private final void r0() {
        GdtAd gdtAd = this.mAd;
        GdtAd gdtAd2 = null;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        GdtReporter.doCgiReport(gdtAd.getUrlForImpression());
        GdtThirdProcessorProxy gdtThirdProcessorProxy = new GdtThirdProcessorProxy();
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd3 = null;
        }
        gdtThirdProcessorProxy.c2sReportAsync(0, 0, gdtAd3.info);
        Object[] objArr = new Object[2];
        objArr[0] = "onExposure valid report success:";
        GdtAd gdtAd4 = this.mAd;
        if (gdtAd4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd4 = null;
        }
        String traceId = gdtAd4.getTraceId();
        GdtAd gdtAd5 = this.mAd;
        if (gdtAd5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
        } else {
            gdtAd2 = gdtAd5;
        }
        objArr[1] = traceId + "_" + gdtAd2.getAId();
        QLog.d("QZoneFeedProDetailBottomAdBlockView", 2, objArr);
    }

    private final void u0() {
        boolean contains;
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        HashSet<String> t16 = qZoneAdFeedUtils.t();
        GdtAd gdtAd = this.mAd;
        GdtAd gdtAd2 = null;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(t16, gdtAd.getTraceId());
        if (contains) {
            QLog.e("QZoneFeedProDetailBottomAdBlockView", 1, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd3 = null;
        }
        QLog.i("QZoneFeedProDetailBottomAdBlockView", 1, "[doOriginalExposureReport] doOriginExpose + " + gdtAd3.getTraceId());
        GdtAd gdtAd4 = this.mAd;
        if (gdtAd4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd4 = null;
        }
        String traceId = gdtAd4.getTraceId();
        if (traceId != null) {
            e.a(qZoneAdFeedUtils.t(), traceId);
        }
        GdtAd gdtAd5 = this.mAd;
        if (gdtAd5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
        } else {
            gdtAd2 = gdtAd5;
        }
        GdtAdFeedUtil.doOriginalExposureReport(gdtAd2, getContext(), -1);
    }

    private final void v0() {
        GdtHandler.Params params = new GdtHandler.Params();
        GdtAd gdtAd = this.mAd;
        GdtAd gdtAd2 = null;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        params.f108486ad = gdtAd;
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        params.activity = new WeakReference<>((Activity) context);
        params.directPlay = true;
        params.videoCeilingSupportedIfNotInstalled = true;
        params.widthHeightRatioOfVideoCeiling = "16:9";
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        params.extra = bundle;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        GdtThirdProcessorProxy gdtThirdProcessorProxy = new GdtThirdProcessorProxy();
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
        } else {
            gdtAd2 = gdtAd3;
        }
        gdtThirdProcessorProxy.c2sReportAsync(1, 0, gdtAd2.info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QZoneFeedProDetailBottomAdBlockView this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result == null || result.action != 3) {
            return;
        }
        i iVar = this$0.mDetailViewModel;
        if (iVar != null) {
            iVar.U1();
        }
        LinearLayout linearLayout = this$0.mAdView;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.startCheck();
        }
        u0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130458t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            if (v3.getId() == R.id.f203081) {
                A0();
            } else {
                v0();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void onDestroy() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
        this.mAdExposureChecker = null;
        this.mCallBack = null;
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup instanceof RecyclerView) {
            ((RecyclerView) viewGroup).removeOnScrollListener(this.mOnScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r5.o2() == true) goto L8;
     */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindData(GdtAd ad5, int pos) {
        boolean z16;
        i iVar = this.mDetailViewModel;
        if (iVar != null) {
            z16 = true;
        }
        z16 = false;
        this.mIsExistMoreComment = z16;
        QLog.i("QZoneFeedProDetailBottomAdBlockView", 2, "mIsExistMoreComment: " + z16 + ", ad: " + ad5);
        if (ad5 != null && !this.mIsExistMoreComment) {
            LinearLayout linearLayout = this.mAdContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            initView();
            D0(ad5);
            return;
        }
        LinearLayout linearLayout2 = this.mAdContainer;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    public final void y0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void z0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }
}
