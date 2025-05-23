package com.tencent.mobileqq.vas.adv.recommendad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView;
import com.tencent.mobileqq.vas.adv.recommendad.a;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J$\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "", "position", "Lcom/tencent/gdtad/aditem/GdtAd;", "i0", "ad", "", "j0", "Landroid/view/ViewGroup;", "viewGroup", "l0", "viewHolder", "", "k0", "m0", "n0", "getItemCount", "", "list", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "feedbackListener", "canAutoPlay", "o0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mRecommendInfos", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "mFeedbackListener", "D", "Z", "mCanAutoPlay", "<init>", "()V", "E", "a", "b", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecommendAdView.a mFeedbackListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mCanAutoPlay;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends GdtAd> mRecommendInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010^\u001a\u00020\u000b\u0012\b\u0010E\u001a\u0004\u0018\u00010@\u0012\u0006\u0010]\u001a\u000202\u00a2\u0006\u0004\b_\u0010`J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u0017\u0010$\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0017\u0010'\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0017\u0010*\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R\"\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0019\u0010E\u001a\u0004\u0018\u00010@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010Y\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u00104\u001a\u0004\bW\u00106\"\u0004\bX\u00108R\"\u0010]\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u00104\u001a\u0004\b[\u00106\"\u0004\b\\\u00108\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "r", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, HippyTKDListViewAdapter.X, "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;", "E", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;", "getVideo", "()Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;", "video", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "image", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getDes", "()Landroid/widget/TextView;", SecretUtils.DES, "H", "getIcon", "icon", "I", "getName", "name", "J", "getFeedbackText", "feedbackText", "K", "getFeedbackIcon", "feedbackIcon", "L", "Landroid/view/View;", "getMediaViewContainer", "()Landroid/view/View;", "setMediaViewContainer", "(Landroid/view/View;)V", "mediaViewContainer", "", "M", "Z", "w", "()Z", "setVideoAd", "(Z)V", "isVideoAd", "N", "Lcom/tencent/gdtad/aditem/GdtAd;", "p", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "P", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "getFeedbackListener", "()Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "feedbackListener", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "getAdExposureChecker", "()Lcom/tencent/ad/tangram/util/AdExposureChecker;", "setAdExposureChecker", "(Lcom/tencent/ad/tangram/util/AdExposureChecker;)V", "adExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "getAdExposureCallback", "()Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "setAdExposureCallback", "(Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;)V", "adExposureCallback", ExifInterface.LATITUDE_SOUTH, "getCanPlay", "y", "canPlay", "T", "getCanAutoPlay", "setCanAutoPlay", "canAutoPlay", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;Z)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RecommendAdVideoView video;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView image;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView des;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView icon;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView name;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView feedbackText;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final ImageView feedbackIcon;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private View mediaViewContainer;

        /* renamed from: M, reason: from kotlin metadata */
        private boolean isVideoAd;

        /* renamed from: N, reason: from kotlin metadata */
        @Nullable
        private GdtAd ad;

        /* renamed from: P, reason: from kotlin metadata */
        @Nullable
        private final RecommendAdView.a feedbackListener;

        /* renamed from: Q, reason: from kotlin metadata */
        @Nullable
        private AdExposureChecker adExposureChecker;

        /* renamed from: R, reason: from kotlin metadata */
        @Nullable
        private AdExposureChecker.ExposureCallback adExposureCallback;

        /* renamed from: S, reason: from kotlin metadata */
        private boolean canPlay;

        /* renamed from: T, reason: from kotlin metadata */
        private boolean canAutoPlay;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, @Nullable RecommendAdView.a aVar, boolean z16) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f71073n6);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.recommend_ad_item_video)");
            this.video = (RecommendAdVideoView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f71033n2);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026.recommend_ad_item_imgae)");
            this.image = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f71013n0);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.recommend_ad_item_des)");
            this.des = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f71023n1);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.recommend_ad_item_icon)");
            ImageView imageView = (ImageView) findViewById4;
            this.icon = imageView;
            View findViewById5 = itemView.findViewById(R.id.f71063n5);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.recommend_ad_item_name)");
            this.name = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f71003mz);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026commend_ad_feedback_text)");
            this.feedbackText = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.f70993my);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026commend_ad_feedback_icon)");
            this.feedbackIcon = (ImageView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.f71043n3);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.\u2026mmend_ad_item_media_view)");
            this.mediaViewContainer = findViewById8;
            this.feedbackListener = aVar;
            this.canPlay = true;
            this.canAutoPlay = z16;
            GdtUIUtils.setViewRadius(itemView, 4.0f);
            GdtUIUtils.setViewRadius(imageView, 25.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(GdtAd ad5, b this$0, WeakReference weakReference) {
            Intrinsics.checkNotNullParameter(ad5, "$ad");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (weakReference == null) {
                return;
            }
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(ad5.getUrlForImpression());
            f fVar = f.f308307a;
            String valueOf = String.valueOf(ad5.getAId());
            String posId = ad5.getPosId();
            String str = "";
            if (posId == null) {
                posId = "";
            }
            String traceId = ad5.getTraceId();
            if (traceId != null) {
                str = traceId;
            }
            fVar.c(valueOf, posId, str);
            QLog.e("RecommendAdAdapter", 1, "[doEffectiveExposureReport], traceId: " + ad5.getTraceId() + ',' + this$0.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(b this$0, GdtAd ad5, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(ad5, "$ad");
            RecommendAdView.a aVar = this$0.feedbackListener;
            if (aVar != null) {
                aVar.a(ad5);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(b this$0, GdtAd ad5, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(ad5, "$ad");
            RecommendAdView.a aVar = this$0.feedbackListener;
            if (aVar != null) {
                aVar.a(ad5);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.x();
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void onDestroy() {
            if (this.isVideoAd) {
                this.video.h();
            }
            AdExposureChecker adExposureChecker = this.adExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.onActivityDestroy();
            }
        }

        public final void onPause() {
            if (this.isVideoAd) {
                this.video.j();
            }
            AdExposureChecker adExposureChecker = this.adExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.onActivityPause();
            }
        }

        public final void onResume() {
            if (this.isVideoAd && this.canPlay && this.canAutoPlay) {
                this.video.k();
            }
            AdExposureChecker adExposureChecker = this.adExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.onActivityResume();
            }
            GdtOriginalExposureReporter.reportOriginalExposure(this.ad, this.itemView.getContext());
        }

        public final void onStop() {
            if (this.isVideoAd) {
                this.video.l();
            }
        }

        @Nullable
        /* renamed from: p, reason: from getter */
        public final GdtAd getAd() {
            return this.ad;
        }

        @Nullable
        public final View q() {
            return this.itemView.findViewById(R.id.f71043n3);
        }

        public final void r(@NotNull final GdtAd ad5) {
            Intrinsics.checkNotNullParameter(ad5, "ad");
            if (ad5.getInnerShowType() == 3) {
                this.video.setVideoData(ad5);
                this.video.setVisibility(0);
                this.image.setVisibility(8);
                this.isVideoAd = true;
            } else {
                this.video.setVisibility(8);
                this.image.setVisibility(0);
                this.image.setImageDrawable(GdtUIUtils.getUrlDrawable(ad5.getBasic_img()));
                this.isVideoAd = false;
            }
            this.adExposureChecker = new AdExposureChecker(ad5, new WeakReference(this.itemView));
            this.adExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.vas.adv.recommendad.b
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public final void onExposure(WeakReference weakReference) {
                    a.b.s(GdtAd.this, this, weakReference);
                }
            };
            AdExposureChecker adExposureChecker = this.adExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.setCallback(new WeakReference<>(this.adExposureCallback));
            }
            AdExposureChecker adExposureChecker2 = this.adExposureChecker;
            if (adExposureChecker2 != null) {
                adExposureChecker2.startCheck();
            }
            this.feedbackText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.recommendad.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.t(a.b.this, ad5, view);
                }
            });
            this.feedbackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.recommendad.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.u(a.b.this, ad5, view);
                }
            });
            this.icon.setImageDrawable(GdtUIUtils.getUrlDrawable(ad5.getAdvertiser_corporate_logo()));
            this.name.setText(ad5.getAdvertiser_corporate_image_name());
            this.des.setText(ad5.getText());
            this.ad = ad5;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.recommendad.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.v(a.b.this, view);
                }
            });
        }

        /* renamed from: w, reason: from getter */
        public final boolean getIsVideoAd() {
            return this.isVideoAd;
        }

        public final void x() {
            AdExposureChecker.ExposureCallback exposureCallback = this.adExposureCallback;
            if (exposureCallback != null) {
                AdExposureChecker.onClick(this.itemView.getContext(), this.ad, new WeakReference(exposureCallback));
            }
            GdtAd gdtAd = this.ad;
            if (gdtAd != null) {
                f fVar = f.f308307a;
                String valueOf = String.valueOf(gdtAd.getAId());
                String posId = gdtAd.getPosId();
                String str = "";
                if (posId == null) {
                    posId = "";
                }
                Intrinsics.checkNotNullExpressionValue(posId, "it.posId ?: \"\"");
                String traceId = gdtAd.getTraceId();
                if (traceId != null) {
                    str = traceId;
                }
                Intrinsics.checkNotNullExpressionValue(str, "it.traceId ?: \"\"");
                fVar.b(valueOf, posId, str);
            }
            GdtHandler.Params params = new GdtHandler.Params();
            params.f108486ad = this.ad;
            params.activity = new WeakReference<>((Activity) this.itemView.getContext());
            params.sceneID = 0;
            params.componentID = 1;
            params.extra = new Bundle();
            if (this.isVideoAd) {
                params.videoStartPositionMillis = this.video.e();
                this.video.o();
            }
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        }

        public final void y(boolean z16) {
            this.canPlay = z16;
        }
    }

    public a() {
        List<? extends GdtAd> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mRecommendInfos = emptyList;
        this.mCanAutoPlay = true;
    }

    private final GdtAd i0(int position) {
        int lastIndex;
        GdtAd gdtAd = null;
        if (this.mRecommendInfos.isEmpty()) {
            return null;
        }
        List<? extends GdtAd> list = this.mRecommendInfos;
        if (position >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (position <= lastIndex) {
                gdtAd = list.get(position);
            }
        }
        return gdtAd;
    }

    private final boolean j0(GdtAd ad5) {
        if (ad5.getInnerShowType() == 1 || ad5.getInnerShowType() == 3) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mRecommendInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        GdtAd i06 = i0(position);
        if (i06 != null && j0(i06)) {
            viewHolder.itemView.setVisibility(0);
            viewHolder.r(i06);
        } else {
            viewHolder.itemView.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup viewGroup, int position) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hms, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view, this.mFeedbackListener, this.mCanAutoPlay);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull b viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onViewAttachedToWindow(viewHolder);
        GdtOriginalExposureReporter.reportOriginalExposure(viewHolder.getAd(), viewHolder.itemView.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull b viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onViewDetachedFromWindow(viewHolder);
        viewHolder.onPause();
    }

    public final void o0(@NotNull List<? extends GdtAd> list, @NotNull RecommendAdView.a feedbackListener, boolean canAutoPlay) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(feedbackListener, "feedbackListener");
        this.mRecommendInfos = list;
        this.mFeedbackListener = feedbackListener;
        this.mCanAutoPlay = canAutoPlay;
    }
}
