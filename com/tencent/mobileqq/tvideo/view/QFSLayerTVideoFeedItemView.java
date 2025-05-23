package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.danmaku.manager.n;
import com.tencent.mobileqq.tvideo.like.QFSTVideoLikePresenter;
import com.tencent.mobileqq.tvideo.presenter.QFSTVideoBottomInfoPresenter;
import com.tencent.mobileqq.tvideo.presenter.QFSTVideoChildVideoPresenter;
import com.tencent.mobileqq.tvideo.presenter.QFSTVideoTopInfoPresenter;
import com.tencent.mobileqq.tvideo.presenter.ak;
import com.tencent.mobileqq.tvideo.presenter.am;
import com.tencent.mobileqq.tvideo.presenter.ao;
import com.tencent.mobileqq.tvideo.presenter.as;
import com.tencent.mobileqq.tvideo.presenter.bb;
import com.tencent.mobileqq.tvideo.presenter.bd;
import com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import e30.b;
import ey2.e;
import ey2.h;
import ey2.k;
import ey2.m;
import feedcloud.FeedCloudMeta$StFeed;
import gy2.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kx2.g;
import rx2.f;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSLayerTVideoFeedItemView extends QFSLayerFeedAbsItemView {
    private Video G;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSLayerTVideoFeedItemView> f304777a;

        public a(QFSLayerTVideoFeedItemView qFSLayerTVideoFeedItemView) {
            this.f304777a = new WeakReference<>(qFSLayerTVideoFeedItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> g16 = c.g();
            if (this.f304777a.get() == null) {
                return g16;
            }
            QFSLayerTVideoFeedItemView qFSLayerTVideoFeedItemView = this.f304777a.get();
            g16.put("item_idx", Integer.valueOf(qFSLayerTVideoFeedItemView.getDataPosInList()));
            int ceil = (int) Math.ceil(r1 / 5);
            g16.put("rec_flush_num", Integer.valueOf(ceil));
            g16.putAll(c.m(qFSLayerTVideoFeedItemView.G, ceil));
            return g16;
        }
    }

    public QFSLayerTVideoFeedItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    private boolean F0() {
        t40.a aVar = this.D;
        if (aVar == null) {
            return false;
        }
        QCircleInitBean initBean = aVar.getInitBean();
        if (!(initBean instanceof TVideoLayerBean) || !((TVideoLayerBean) initBean).isDetailFeedsPage()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ggl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerTVideoFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    public void initView() {
        super.initView();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QAdVrReport.ElementID.AD_POSTER);
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            VideoReport.setEventDynamicParams(this, new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoReport.setEventDynamicParams(this, null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        if (!n.f()) {
            arrayList.add(QFSTVideoTopInfoPresenter.class);
        }
        arrayList.add(QFSTVideoChildVideoPresenter.class);
        arrayList.add(as.class);
        arrayList.add(ak.class);
        arrayList.add(am.class);
        arrayList.add(e.class);
        arrayList.add(k.class);
        arrayList.add(h.class);
        arrayList.add(QFSTVideoBottomInfoPresenter.class);
        arrayList.add(QFSTVideoIntroPresenter.class);
        arrayList.add(com.tencent.mobileqq.tvideo.presenter.intro.h.class);
        arrayList.add(bb.class);
        arrayList.add(m.class);
        arrayList.add(ao.class);
        arrayList.add(rx2.c.class);
        arrayList.add(f.class);
        arrayList.add(QFSTVideoLikePresenter.class);
        arrayList.add(g.class);
        arrayList.add(com.tencent.mobileqq.tvideo.pullqqlive.e.class);
        if (F0()) {
            arrayList.add(bd.class);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        super.bindData(bVar, i3);
        QLog.d("QFSLayerTVideoFeedItemView", 1, " bindData  pos " + i3);
        this.G = jy2.g.q(bVar.g());
    }
}
