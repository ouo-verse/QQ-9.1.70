package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressView;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTagView;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryWaterfallFeedItemView extends QFSGalleryWaterfallFeedBaseItemView implements Observer<e30.b> {
    private TextView C;
    private TextView D;
    private FeedCloudMeta$StFeed E;
    private Size F;
    private ImageView G;
    private QFSRoundProgressView H;
    private ImageView I;
    private View J;
    private int K;
    private boolean L;
    private e30.b M;

    /* renamed from: d, reason: collision with root package name */
    private e30.b f86458d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCorneredRelativeLayout f86459e;

    /* renamed from: f, reason: collision with root package name */
    private QFSMixFeedTagView f86460f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f86461h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAsyncTextView f86462i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleAvatarView f86463m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements RFWAsyncRichTextView.OnClickAtTextListener {
        a() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
        public void onClick(String str) {
            if (QFSGalleryWaterfallFeedItemView.this.f86459e != null) {
                QFSGalleryWaterfallFeedItemView.this.f86459e.callOnClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements RFWAsyncRichTextView.OnClickHashTagTextListener {
        b() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
        public void onClick(String str) {
            if (QFSGalleryWaterfallFeedItemView.this.f86459e != null) {
                QFSGalleryWaterfallFeedItemView.this.f86459e.callOnClick();
            }
            QFSGalleryWaterfallFeedItemView.this.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSGalleryWaterfallFeedItemView.this.f86459e != null) {
                QFSGalleryWaterfallFeedItemView.this.f86459e.callOnClick();
            }
            QFSGalleryWaterfallFeedItemView.this.C0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e30.b f86467a;

        d(e30.b bVar) {
            this.f86467a = bVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            e30.b bVar;
            if (QFSGalleryWaterfallFeedItemView.this.E != null && (bVar = this.f86467a) != null && bVar.g() != null) {
                FeedCloudMeta$StFeed g16 = this.f86467a.g();
                QFSGalleryWaterfallFeedItemView qFSGalleryWaterfallFeedItemView = QFSGalleryWaterfallFeedItemView.this;
                qFSGalleryWaterfallFeedItemView.H0(qFSGalleryWaterfallFeedItemView.E, g16);
                QFSGalleryWaterfallFeedItemView qFSGalleryWaterfallFeedItemView2 = QFSGalleryWaterfallFeedItemView.this;
                qFSGalleryWaterfallFeedItemView2.J0(qFSGalleryWaterfallFeedItemView2.E, g16);
                QFSGalleryWaterfallFeedItemView qFSGalleryWaterfallFeedItemView3 = QFSGalleryWaterfallFeedItemView.this;
                qFSGalleryWaterfallFeedItemView3.M0(qFSGalleryWaterfallFeedItemView3.E, g16);
                QFSGalleryWaterfallFeedItemView qFSGalleryWaterfallFeedItemView4 = QFSGalleryWaterfallFeedItemView.this;
                qFSGalleryWaterfallFeedItemView4.K0(qFSGalleryWaterfallFeedItemView4.E, this.f86467a);
            }
            return null;
        }
    }

    private boolean A0(e30.b bVar) {
        if (bVar.b("key_gallery_publish_feed_status") != null) {
            return true;
        }
        return false;
    }

    private boolean B0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StFeed.liteBanner.business_type.get() == 7 || this.E.liteBanner.business_type.get() == 8 || this.E.liteBanner.business_type.get() == 6)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        if (this.f86461h == null) {
            return;
        }
        if (A0(this.f86458d) && !"STATUS_SUCCESS".equals((String) this.f86458d.b("key_gallery_publish_feed_status"))) {
            QLog.d("QFSGalleryWaterfallFeedItemView", 1, "is publishing feed, ignore launch");
            return;
        }
        w0();
        if (z0()) {
            D0();
        } else {
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), getDetailInitBean());
        }
    }

    private void D0() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setForceFromNetwork(false);
        qCircleInitBean.setExtraTypeInfo(getQCircleExtraTypeInfo());
        qCircleInitBean.setFeed(this.E);
        qCircleInitBean.setFromReportBean(new QCircleReportBean());
        com.tencent.biz.qqcircle.launcher.c.W(getContext(), qCircleInitBean);
    }

    private void F0() {
        QCircleAsyncTextView qCircleAsyncTextView = this.f86462i;
        if (qCircleAsyncTextView != null && this.C != null) {
            qCircleAsyncTextView.setPreloadParserInfo(uc0.a.c(this.E, QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary), true));
            this.f86462i.setOnClickAtTextListener(new a());
            this.f86462i.setOnClickHashTagTextListener(new b());
            this.f86462i.setOnClickListener(new c());
            this.f86462i.setText(this.E.content.get());
            this.C.setText(this.E.poster.nick.get());
            return;
        }
        QLog.e(getLogTag(), 1, "[setTextConfiguration] mTvTitle or mNickName == null");
    }

    private void G0() {
        if (this.f86460f != null && this.E != null) {
            if (!B0()) {
                this.f86460f.setVisibility(8);
            } else {
                this.f86460f.b(this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.commentCount.has()) {
            return;
        }
        feedCloudMeta$StFeed.commentCount.set(feedCloudMeta$StFeed2.commentCount.get());
    }

    private void I0(e30.b bVar) {
        String str;
        if (bVar != null && this.E != null) {
            Size m06 = m0();
            ViewGroup.LayoutParams layoutParams = this.f86461h.getLayoutParams();
            layoutParams.width = m06.getWidth();
            layoutParams.height = m06.getHeight();
            this.f86461h.setLayoutParams(layoutParams);
            if (this.f86461h.getTag(R.id.f43291m3) instanceof String) {
                str = (String) this.f86461h.getTag(R.id.f43291m3);
            } else {
                str = "";
            }
            this.f86461h.setTag(R.id.f43291m3, this.E.cover.picUrl.get());
            if (!str.equals(this.E.cover.picUrl.get())) {
                Option failedDrawableId = Option.obtain().setUrl(this.E.cover.picUrl.get()).setTargetView(this.f86461h).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(m06.getWidth()).setRequestHeight(m06.getHeight()).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc);
                failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                q50.b.e().q(failedDrawableId, false);
                QCircleFeedPicLoader.g().loadImage(failedDrawableId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.likeInfo.has()) {
            return;
        }
        feedCloudMeta$StFeed.likeInfo = feedCloudMeta$StFeed2.likeInfo;
        if (!feedCloudMeta$StFeed2.tianshuEntry.has()) {
            return;
        }
        feedCloudMeta$StFeed.tianshuEntry.set(feedCloudMeta$StFeed2.tianshuEntry.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, e30.b bVar) {
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar.b("DITTO_FEED_BUSI_REQ_DATA");
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(this.E.f398449id.get());
        if (f16 != null && qQCircleFeedBase$StFeedBusiReqData != null) {
            qQCircleFeedBase$StFeedBusiReqData.pushList.set(f16);
            feedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
        }
    }

    private void L0() {
        int i3;
        ImageView imageView = this.G;
        if (imageView == null) {
            return;
        }
        if (this.L) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.share.sharedCount.has()) {
            return;
        }
        feedCloudMeta$StFeed.share.sharedCount.set(feedCloudMeta$StFeed2.share.sharedCount.get());
    }

    private void N0(QCircleAvatarView qCircleAvatarView, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (qCircleAvatarView != null && feedCloudMeta$StUser != null) {
            this.f86463m.setAvatar(this.E.poster, this.F);
        } else {
            QLog.d("QFSGalleryWaterfallFeedItemView", 1, "[UpdateUserAvatar] avatar should not be null.");
        }
    }

    private void O0(e30.b bVar) {
        if (this.D == null) {
            return;
        }
        String f16 = r.f(bVar.g().visitorInfo.viewCount.get());
        if (!TextUtils.isEmpty(f16)) {
            this.D.setText(f16);
        }
    }

    private QCircleLayerBean getDetailInitBean() {
        int hashCode;
        if (this.E == null) {
            return new QCircleLayerBean();
        }
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        if (getReportBean() != null) {
            qCircleReportBean = getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        }
        qCircleInitBean.setExtraTypeInfo(getQCircleExtraTypeInfo());
        qCircleLayerBean.setFeed(this.E);
        qCircleLayerBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
        qCircleLayerBean.setUseLoadingPic(true);
        qCircleLayerBean.setSourceType(getQCircleExtraTypeInfo().pageType);
        qCircleLayerBean.setFromReportBean(qCircleReportBean);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        if (getQCircleBaseFragment() == null) {
            hashCode = 0;
        } else {
            hashCode = getQCircleBaseFragment().hashCode();
        }
        qCircleLayerBean.setPageCode(hashCode);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(getQCircleExtraTypeInfo().mGlobalViewModelKey);
        if (this.L) {
            int[] iArr = new int[2];
            this.f86461h.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i3 = iArr[0];
            qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.f86461h.getWidth() + i3, iArr[1] + this.f86461h.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.E.cover.picUrl.get()).setTransitionDelayTimeMs(0).setEnterAnimFadeCoverTimeMs(300).setTransitionDurationMs(200));
            qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.f86461h.getDrawable());
        }
        qCircleLayerBean.setPreRenderType(10005);
        return qCircleLayerBean;
    }

    private void v0(e30.b bVar) {
        int intValue;
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        if (bVar.b("key_gallery_publish_progress") != null && (intValue = ((Integer) bVar.b("key_gallery_publish_progress")).intValue()) >= 0 && intValue <= 100) {
            this.H.setVisibility(0);
            this.J.setVisibility(0);
            this.H.setProgress(intValue);
        }
        if (bVar.b("key_gallery_publish_feed_status") != null) {
            String str = (String) bVar.b("key_gallery_publish_feed_status");
            if ("STATUS_SUCCESS".equals(str)) {
                this.H.setVisibility(8);
                this.J.setVisibility(8);
            } else if ("STATUS_FAILED".equals(str)) {
                this.H.setVisibility(8);
                this.J.setVisibility(0);
                this.I.setVisibility(0);
            }
        }
    }

    private void x0() {
        if (this.E == null) {
            return;
        }
        VideoReport.setElementId(this.f86459e, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        VideoReport.setElementReuseIdentifier(this.f86459e, "em_xsj_product_" + this.K + "_" + this.E.f398449id.get());
        VideoReport.setElementParams(this.f86459e, y0());
        VideoReport.setElementExposePolicy(this.f86459e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f86459e, ClickPolicy.REPORT_ALL);
    }

    private Map<String, Object> y0() {
        QFSMixFeedTagView qFSMixFeedTagView;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        int i3 = 1;
        if (feedCloudMeta$StFeed == null) {
            QLog.e(getLogTag(), 1, "[feedInfoDtReportMap] mFeed == null");
            return buildElementParams;
        }
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.E.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.K));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LIKE_NUM, Integer.valueOf(this.E.likeInfo.count.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.E.feedShowReason.showReason.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, this.E.feedShowReason.showReason.get());
        if (!z0()) {
            i3 = 2;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, Integer.valueOf(i3));
        if (B0() && (qFSMixFeedTagView = this.f86460f) != null) {
            buildElementParams.putAll(qFSMixFeedTagView.a(this.E));
        }
        return buildElementParams;
    }

    private boolean z0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        QFSAsyncUtils.executeSub(new d(bVar), new Void[0]);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168682gd2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryWaterfallFeedItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryWaterfallFeedBaseItemView
    @NonNull
    /* renamed from: l0 */
    public ImageView getMCoverImg() {
        return this.f86461h;
    }

    protected void w0() {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(this.E).setActionType(97).setSubActionType(2).setPageId(getQCircleExtraTypeInfo().pageType)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            this.K = i3;
            this.f86458d = bVar;
            this.E = bVar.g();
            I0(bVar);
            G0();
            O0(bVar);
            N0(this.f86463m, this.E.poster);
            F0();
            L0();
            v0(this.f86458d);
            x0();
            this.M = new e30.b(this.E);
            w20.a.j().observerGlobalState(this.M, this);
            return;
        }
        QLog.e("QFSGalleryWaterfallFeedItemView", 1, "[bindData]: blockData is null");
    }
}
