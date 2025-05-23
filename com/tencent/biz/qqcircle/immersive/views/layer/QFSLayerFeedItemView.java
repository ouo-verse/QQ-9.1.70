package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoErrorPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.av;
import com.tencent.biz.qqcircle.immersive.feed.ax;
import com.tencent.biz.qqcircle.immersive.feed.be;
import com.tencent.biz.qqcircle.immersive.feed.cc;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.qqcircle.utils.co;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ua0.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedItemView extends QFSLayerFeedAbsItemView {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSLayerFeedItemView> f90799a;

        public a(QFSLayerFeedItemView qFSLayerFeedItemView) {
            this.f90799a = new WeakReference<>(qFSLayerFeedItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.f90799a.get() == null) {
                return buildElementParams;
            }
            QFSLayerFeedItemView qFSLayerFeedItemView = this.f90799a.get();
            b data = qFSLayerFeedItemView.getData();
            int dataPosInList = qFSLayerFeedItemView.getDataPosInList();
            buildElementParams.putAll(c.d(data));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(dataPosInList + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(data.g().createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, data.g().cover.picUrl.get());
            if (c40.a.f(data.g())) {
                qFSLayerFeedItemView.getIocInterface(t40.a.class);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(c40.a.c(data.g())));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_CACHE, Integer.valueOf(r.a0(data.g()) ? 1 : 0));
            try {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) qFSLayerFeedItemView.findViewById(R.id.f40181do))));
            } catch (Exception e16) {
                QLog.e("QFSLayerFeedItemView", 2, e16, new Object[0]);
            }
            return buildElementParams;
        }
    }

    public QFSLayerFeedItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            VideoReport.setEventDynamicParams(this, new a(this));
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + bVar.g().f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            if (QLog.isColorLevel()) {
                QLog.i(getLogTag(), 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    public ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (q16 = q06.q()) != null) {
            arrayList.addAll(q16);
        }
        int i3 = this.mViewType;
        if (i3 == 1003) {
            arrayList.add(QFSFeedChildVideoPresenter.class);
            arrayList.add(QFSFeedChildVideoErrorPresenter.class);
            arrayList.add(ax.class);
            if (cb.c()) {
                arrayList.add(be.class);
            }
            if (co.b()) {
                arrayList.add(cc.class);
            }
            arrayList.add(com.tencent.biz.qqcircle.immersive.feed.cb.class);
        } else if (i3 == 1002) {
            arrayList.add(QFSFeedChildPicPresenter.class);
            if (ac0.c.a()) {
                arrayList.add(av.class);
                arrayList.add(be.class);
            }
        }
        return arrayList;
    }
}
