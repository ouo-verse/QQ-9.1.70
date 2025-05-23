package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.manager.g;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.aj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSMixFeedAlignBaseItemView extends QFSMixFeedBaseWidgetView<e30.b> implements View.OnClickListener, SimpleEventReceiver, Observer<e30.b> {
    private static final int G = cx.a(4.0f) * 2;
    private static final int H = cx.a(4.0f);
    private ImageView C;
    protected FeedCloudMeta$StFeed D;
    protected int E;
    private e30.b F;

    /* renamed from: e, reason: collision with root package name */
    private RoundCorneredRelativeLayout f90822e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f90823f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAsyncTextView f90824h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90825i;

    /* renamed from: m, reason: collision with root package name */
    private QFSVipNickNameAndIconView f90826m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e30.b f90827a;

        a(e30.b bVar) {
            this.f90827a = bVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            e30.b bVar = this.f90827a;
            if (bVar != null && bVar.g() != null) {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) this.f90827a.b("DITTO_FEED_BUSI_REQ_DATA");
                FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(QFSMixFeedAlignBaseItemView.this.D.f398449id.get());
                if (f16 != null && qQCircleFeedBase$StFeedBusiReqData != null) {
                    qQCircleFeedBase$StFeedBusiReqData.pushList.set(f16);
                    QFSMixFeedAlignBaseItemView.this.D.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
                }
            }
            return null;
        }
    }

    public QFSMixFeedAlignBaseItemView(Context context) {
        super(context);
        r0(this);
        q0(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void A0() {
        if (this.f90823f != null && this.D != null) {
            this.f90823f.setAvatar(this.D.poster, n.a(getContext(), R.dimen.f158711n0));
        }
    }

    private QCircleLayerBean getDetailInitBean() {
        int hashCode;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (getExtraTypeInfo() != null && this.D != null && this.C != null) {
            QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            QCircleReportBean qCircleReportBean = new QCircleReportBean();
            if (getReportBean() != null) {
                qCircleReportBean = getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
            }
            qCircleInitBean.setExtraTypeInfo(getQCircleExtraTypeInfo());
            qCircleLayerBean.setFeed(this.D);
            if (this.D.poiInfo.has() && getQCircleExtraTypeInfo() != null && getQCircleExtraTypeInfo().mSubPageType == 12) {
                qCircleLayerBean.setPoiInfo(this.D.poiInfo.get());
            }
            qCircleLayerBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(getQCircleExtraTypeInfo().mSubPageType);
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
            int[] iArr = new int[2];
            this.C.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i3 = iArr[0];
            qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.C.getWidth() + i3, iArr[1] + this.C.getMeasuredHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.D.cover.picUrl.get()).setTransitionDelayTimeMs(0).setEnterAnimFadeCoverTimeMs(300).setTransitionDurationMs(200));
            RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
            RFWPlayerPreRenderBean sourceType = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10005).setActivity((Activity) getContext()).setIsJumpTrigger(o.U0()).setSourceType(g.e().i(getReportBean()));
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
            if (feedCloudMeta$StFeed != null) {
                feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
            } else {
                feedCloudMeta$StVideo = null;
            }
            rFWPlayerPreRenderHelper.playerRender(gb0.b.f(sourceType.setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setPreloadOriginData(gb0.b.m(new e30.b(this.D))).setMultiLevel(true)));
            qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.C.getDrawable());
            return qCircleLayerBean;
        }
        return new QCircleLayerBean();
    }

    private void k0() {
        if (this.D == null) {
            return;
        }
        Pair<Integer, Integer> h16 = d.h(getContext(), this.D);
        if (((Integer) h16.first).intValue() != 0 && ((Integer) h16.second).intValue() != 0) {
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            layoutParams.width = ((Integer) h16.first).intValue();
            layoutParams.height = ((Integer) h16.second).intValue();
            this.C.setLayoutParams(layoutParams);
        }
    }

    private void m0(e30.b bVar) {
        String str;
        if (this.D == null) {
            return;
        }
        VideoReport.setElementId(this.f90822e, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        VideoReport.setElementReuseIdentifier(this.f90822e, "em_xsj_product_" + this.E + "_" + this.D.f398449id.get());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.E));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.feedShowReason.showReason.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, str);
        if (bVar != null) {
            aj.d(bVar.g().extInfo.get(), buildElementParams, new String[]{QCircleDaTongConstant.ElementParamKey.XSJ_CORNER_MASK_TYPE, "xsj_operation_activity_id"});
        }
        buildElementParams.putAll(ua0.c.d(bVar));
        if (n0() != null) {
            buildElementParams.putAll(n0());
        }
        VideoReport.setElementParams(this.f90822e, buildElementParams);
        VideoReport.setElementExposePolicy(this.f90822e, ExposurePolicy.REPORT_ALL);
    }

    private void p0() {
        k0();
        updateFeedCover();
    }

    private void r0(View view) {
        if (view == null) {
            return;
        }
        this.f90822e = (RoundCorneredRelativeLayout) view.findViewById(R.id.slk);
        this.C = (ImageView) view.findViewById(R.id.slh);
        this.f90824h = (QCircleAsyncTextView) view.findViewById(R.id.kbs);
        this.f90823f = (QCircleAvatarView) view.findViewById(R.id.f85674pl);
        this.f90826m = (QFSVipNickNameAndIconView) view.findViewById(R.id.f112276nh);
        this.f90825i = (TextView) view.findViewById(R.id.slm);
        this.f90822e.setOnClickListener(this);
        x0();
    }

    private void v0() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setForceFromNetwork(false);
        qCircleInitBean.setExtraTypeInfo(getQCircleExtraTypeInfo());
        qCircleInitBean.setFeed(this.D);
        qCircleInitBean.setFromReportBean(new QCircleReportBean());
        com.tencent.biz.qqcircle.launcher.c.W(getContext(), qCircleInitBean);
    }

    private void x0() {
        int a16 = cx.a(8.0f);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.f90822e;
        if (roundCorneredRelativeLayout != null) {
            float f16 = a16;
            roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        }
    }

    private void y0() {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && (qFSVipNickNameAndIconView = this.f90826m) != null && this.f90825i != null) {
            qFSVipNickNameAndIconView.setUser(feedCloudMeta$StFeed.poster);
            this.f90826m.setReportData(new QFSVipNickNameAndIconView.b().g(this.D).h(89));
            this.f90826m.w0(this.D.poster.nick.get());
            String f16 = r.f(this.D.visitorInfo.viewCount.get());
            if (!TextUtils.isEmpty(f16)) {
                this.f90825i.setText(f16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g4l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedAlignBaseItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i3 = H;
        layoutParams.setMargins(i3, i3, i3, i3);
        return layoutParams;
    }

    protected void l0() {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(this.D).setActionType(97).setSubActionType(2).setPageId(getQCircleExtraTypeInfo().mSubPageType)));
    }

    protected Map<String, Object> n0() {
        return null;
    }

    protected void o0() {
        u0();
        l0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.slk) {
            o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            p0();
        }
    }

    protected abstract void q0(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    protected void u0() {
        if (this.C == null) {
            return;
        }
        if (s0()) {
            v0();
        } else {
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), getDetailInitBean());
        }
    }

    protected void updateFeedCover() {
        ImageView imageView;
        String str;
        int i3;
        int i16;
        if (this.D != null && (imageView = this.C) != null) {
            if (imageView.getTag(R.id.f113916rx) instanceof String) {
                str = (String) this.C.getTag(R.id.f113916rx);
            } else {
                str = "";
            }
            this.C.setTag(R.id.f113916rx, this.D.cover.picUrl.get());
            if (!str.equals(this.D.cover.picUrl.get())) {
                ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
                if (layoutParams == null) {
                    i3 = this.C.getWidth();
                } else {
                    i3 = layoutParams.width;
                }
                if (layoutParams == null) {
                    i16 = this.C.getHeight();
                } else {
                    i16 = layoutParams.height;
                }
                QLog.d("QFSMixFeedAlignBaseItemView", 1, "[updateFeedCover] width: " + i3 + " | height: " + i16);
                Option failedDrawableId = Option.obtain().setUrl(this.D.cover.picUrl.get()).setTargetView(this.C).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc);
                failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                q50.b.e().q(failedDrawableId, false);
                QCircleFeedPicLoader.g().loadImage(failedDrawableId);
            }
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        QFSAsyncUtils.executeSub(new a(bVar), new Void[0]);
    }

    protected void z0() {
        QCircleAsyncTextView qCircleAsyncTextView;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && (qCircleAsyncTextView = this.f90824h) != null) {
            qCircleAsyncTextView.setPreloadParserInfo(uc0.a.c(feedCloudMeta$StFeed, QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary), true));
            this.f90824h.setNeedSpecialAreaBold(false);
            this.f90824h.setSpecialClickAreaColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary), true);
            this.f90824h.setText(this.D.content.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        this.E = i3;
        this.D = bVar.g();
        k0();
        updateFeedCover();
        z0();
        A0();
        y0();
        m0(bVar);
        this.F = new e30.b(this.D);
        w20.a.j().observerGlobalState(this.F, this);
    }
}
