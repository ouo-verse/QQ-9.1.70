package com.qzone.reborn.feedpro.widget.comment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedpro.viewmodel.i;
import com.qzone.reborn.feedpro.widget.comment.QZoneFeedProDetailCommentAdItemView;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.qzone.util.l;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001VB\u000f\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0014R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006W"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailCommentAdItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lwd/c;", "Landroid/view/View$OnClickListener;", "", "initView", "u0", "I0", "G0", "s0", "C0", "w0", "F0", "x0", "", "A0", "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "v0", "E0", "D0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "v", NodeProps.ON_CLICK, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mAdContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAdAvatar", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mAdNickName", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mAdContent", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mAdImage", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mAdFeedBackContainer", "Lcom/tencent/gdtad/aditem/GdtAd;", "D", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "E", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mAdExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", UserInfo.SEX_FEMALE, "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mCallBack", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "G", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mOnScrollListener", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "H", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mAdFeedbackDialogListener", "Lcom/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailCommentAdItemView$a$a;", "I", "Lcom/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailCommentAdItemView$a$a;", "mActivityLifeCycleCallbacks", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "J", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedProDetailCommentAdItemView extends QZoneBaseWidgetView<wd.c> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mAdFeedBackContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: E, reason: from kotlin metadata */
    private AdExposureChecker mAdExposureChecker;

    /* renamed from: F, reason: from kotlin metadata */
    private AdExposureChecker.ExposureCallback mCallBack;

    /* renamed from: G, reason: from kotlin metadata */
    private final RecyclerView.OnScrollListener mOnScrollListener;

    /* renamed from: H, reason: from kotlin metadata */
    private final AdFeedbackDialogFragment.Listener mAdFeedbackDialogListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final Companion.C0458a mActivityLifeCycleCallbacks;

    /* renamed from: J, reason: from kotlin metadata */
    private i mDetailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mAdContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAdAvatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mAdNickName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mAdContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mAdImage;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailCommentAdItemView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                RelativeLayout relativeLayout = QZoneFeedProDetailCommentAdItemView.this.mAdContainer;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
                    relativeLayout = null;
                }
                if (qZoneAdFeedUtils.p(relativeLayout, QZoneFeedProDetailCommentAdItemView.this.getHostActivity()) > 1.0f) {
                    QZoneFeedProDetailCommentAdItemView.this.C0();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProDetailCommentAdItemView$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            RelativeLayout relativeLayout = QZoneFeedProDetailCommentAdItemView.this.mAdContainer;
            RelativeLayout relativeLayout2 = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
                relativeLayout = null;
            }
            if (qZoneAdFeedUtils.p(relativeLayout, QZoneFeedProDetailCommentAdItemView.this.getHostActivity()) > 1.0f) {
                QZoneFeedProDetailCommentAdItemView.this.C0();
            }
            RelativeLayout relativeLayout3 = QZoneFeedProDetailCommentAdItemView.this.mAdContainer;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
            } else {
                relativeLayout2 = relativeLayout3;
            }
            ViewTreeObserver viewTreeObserver = relativeLayout2.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedProDetailCommentAdItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnScrollListener = new b();
        this.mAdFeedbackDialogListener = new AdFeedbackDialogFragment.Listener() { // from class: se.i
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QZoneFeedProDetailCommentAdItemView.B0(QZoneFeedProDetailCommentAdItemView.this, result);
            }
        };
        this.mActivityLifeCycleCallbacks = new Companion.C0458a(new WeakReference(this));
        this.mDetailViewModel = (i) p(i.class);
    }

    private final boolean A0() {
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        return gdtAd.getInnerShowType() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QZoneFeedProDetailCommentAdItemView this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result == null || result.action != 3) {
            return;
        }
        RelativeLayout relativeLayout = this$0.mAdContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        i iVar = this$0.mDetailViewModel;
        if (iVar != null) {
            iVar.W1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.startCheck();
        }
        w0();
    }

    private final void F0() {
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
            QLog.e("QZoneFeedProDetailCommentAdItemView", 1, "openAdFeedBackDialog", th5);
        }
    }

    private final void G0() {
        GdtAd gdtAd = this.mAd;
        RelativeLayout relativeLayout = null;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        RelativeLayout relativeLayout2 = this.mAdContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        this.mAdExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(relativeLayout));
        this.mCallBack = new AdExposureChecker.ExposureCallback() { // from class: se.f
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                QZoneFeedProDetailCommentAdItemView.H0(QZoneFeedProDetailCommentAdItemView.this, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(new WeakReference<>(this.mCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(QZoneFeedProDetailCommentAdItemView this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QZoneFeedProDetailCommentAdItemView", 2, "onExposure expo checker success");
        this$0.s0();
    }

    private final void I0() {
        G0();
        RelativeLayout relativeLayout = this.mAdContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContainer");
            relativeLayout = null;
        }
        ViewTreeObserver viewTreeObserver = relativeLayout.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new c());
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup instanceof RecyclerView) {
            ((RecyclerView) viewGroup).addOnScrollListener(this.mOnScrollListener);
        }
        E0();
    }

    private final void s0() {
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
        QLog.d("QZoneFeedProDetailCommentAdItemView", 2, objArr);
    }

    private final void u0() {
        GdtAd gdtAd = this.mAd;
        ImageView imageView = null;
        if (gdtAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd = null;
        }
        String text = gdtAd.getText();
        if (text == null) {
            text = "";
        }
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd2 = null;
        }
        String advertiser_corporate_image_name = gdtAd2.getAdvertiser_corporate_image_name();
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd3 = null;
        }
        String advertiser_corporate_logo = gdtAd3.getAdvertiser_corporate_logo();
        GdtAd gdtAd4 = this.mAd;
        if (gdtAd4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd4 = null;
        }
        GdtImageData imageData = gdtAd4.getImageData();
        String str = imageData != null ? imageData.url : null;
        String str2 = str != null ? str : "";
        int e16 = ar.e(A0() ? 104.0f : 186.0f);
        int e17 = ar.e(A0() ? 186.0f : 104.0f);
        QZoneRichTextView qZoneRichTextView = this.mAdContent;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContent");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setText(text);
        QZoneNickNameView qZoneNickNameView = this.mAdNickName;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setText(advertiser_corporate_image_name);
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        Option obtain = Option.obtain();
        QZoneUserAvatarView qZoneUserAvatarView = this.mAdAvatar;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdAvatar");
            qZoneUserAvatarView = null;
        }
        a16.h(obtain.setTargetView(qZoneUserAvatarView).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(true).setUrl(advertiser_corporate_logo));
        Option obtain2 = Option.obtain();
        ImageView imageView2 = this.mAdImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdImage");
        } else {
            imageView = imageView2;
        }
        a16.h(obtain2.setTargetView(imageView).setRequestWidth(e16).setRequestHeight(e17).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(true).setUrl(str2));
    }

    private final void w0() {
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
            QLog.e("QZoneFeedProDetailCommentAdItemView", 1, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAd");
            gdtAd3 = null;
        }
        QLog.i("QZoneFeedProDetailCommentAdItemView", 1, "[doOriginalExposureReport] doOriginExpose + " + gdtAd3.getTraceId());
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

    private final void x0() {
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
    public static final List y0(QZoneNickNameView this_apply, List list) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        return xd.c.f(list, r.f54359a.b(this_apply.getContext()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z0(QZoneRichTextView this_apply, List list) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        return xd.c.f(list, r.f54359a.b(this_apply.getContext()), false);
    }

    public final void D0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void E0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130468u;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity hostActivity;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 29 || (hostActivity = getHostActivity()) == null) {
            return;
        }
        hostActivity.registerActivityLifecycleCallbacks(this.mActivityLifeCycleCallbacks);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            if (v3.getId() == R.id.f203081) {
                F0();
            } else {
                x0();
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
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Activity hostActivity;
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 29 || (hostActivity = getHostActivity()) == null) {
            return;
        }
        hostActivity.unregisterActivityLifecycleCallbacks(this.mActivityLifeCycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void bindData(wd.c objData, int pos) {
        if ((objData instanceof wd.b) && (getContext() instanceof Activity)) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            setHostActivity((Activity) context);
            this.mAd = ((wd.b) objData).getAd();
            if (this.mAdContainer == null) {
                initView();
            }
            u0();
            I0();
        }
    }

    private final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.nm8);
        final QZoneRichTextView qZoneRichTextView = null;
        RelativeLayout relativeLayout = (RelativeLayout) (viewStub != null ? viewStub.inflate() : null);
        if (relativeLayout == null) {
            return;
        }
        this.mAdContainer = relativeLayout;
        View findViewById = findViewById(R.id.f20287z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_comment_ad_avatar)");
        this.mAdAvatar = (QZoneUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f203485);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.detail_comment_ad_nickname_view)");
        this.mAdNickName = (QZoneNickNameView) findViewById2;
        View findViewById3 = findViewById(R.id.f202980);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.detail_comment_ad_content_tv)");
        this.mAdContent = (QZoneRichTextView) findViewById3;
        View findViewById4 = findViewById(R.id.f203384);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.detail_comment_ad_img)");
        this.mAdImage = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f203081);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.detail\u2026nt_ad_feedback_container)");
        this.mAdFeedBackContainer = (LinearLayout) findViewById5;
        ImageView imageView = this.mAdImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdImage");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        QZoneUserAvatarView qZoneUserAvatarView = this.mAdAvatar;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdAvatar");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setOnClickListener(this);
        QZoneNickNameView qZoneNickNameView = this.mAdNickName;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setOnClickListener(this);
        QZoneRichTextView qZoneRichTextView2 = this.mAdContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContent");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setOnClickListener(this);
        LinearLayout linearLayout = this.mAdFeedBackContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdFeedBackContainer");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        final QZoneNickNameView qZoneNickNameView2 = this.mAdNickName;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdNickName");
            qZoneNickNameView2 = null;
        }
        qZoneNickNameView2.setMaxLine(1);
        qZoneNickNameView2.setParseUrl(false);
        qZoneNickNameView2.setDrawBackground(true);
        qZoneNickNameView2.setPreDecorateListener(new CellTextView.d() { // from class: se.g
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List y06;
                y06 = QZoneFeedProDetailCommentAdItemView.y0(QZoneNickNameView.this, list);
                return y06;
            }
        });
        QZoneRichTextView qZoneRichTextView3 = this.mAdContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdContent");
        } else {
            qZoneRichTextView = qZoneRichTextView3;
        }
        qZoneRichTextView.setPreDecorateListener(new CellTextView.d() { // from class: se.h
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List z06;
                z06 = QZoneFeedProDetailCommentAdItemView.z0(QZoneRichTextView.this, list);
                return z06;
            }
        });
        qZoneRichTextView.setUrlColorRes(qZoneRichTextView.getContext().getColor(R.color.qui_common_text_secondary));
        qZoneRichTextView.setLineSpace(com.qzone.reborn.util.r.f59560a.e(4));
        qZoneRichTextView.setMaxCommentLine(2);
        qZoneRichTextView.setEllipsisStr(l.a(R.string.jmx));
        qZoneRichTextView.setMoreCellColor(r.f54359a.b(qZoneRichTextView.getContext()));
    }
}
