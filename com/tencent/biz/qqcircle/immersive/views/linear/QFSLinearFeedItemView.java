package com.tencent.biz.qqcircle.immersive.views.linear;

import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m40.a;
import m40.d;
import m40.i;
import m40.k;
import m40.l;
import m40.n;
import m40.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0014J4\u0010\u0010\u001a.\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u000bj\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f`\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedItemView;", "Lcom/tencent/biz/qqcircle/immersive/views/layer/QFSLayerFeedAbsItemView;", "", "getLogTag", "", "getLayoutId", "Le30/b;", "data", c.G, "", "n0", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lkotlin/collections/ArrayList;", "p0", "", "isVideoType", "G", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLinearFeedItemView extends QFSLayerFeedAbsItemView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedItemView$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedItemView;", "a", "Ljava/lang/ref/WeakReference;", "wrfView", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSLinearFeedItemView> wrfView;

        public b(@NotNull QFSLinearFeedItemView itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.wrfView = new WeakReference<>(itemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            if (this.wrfView.get() == null) {
                Intrinsics.checkNotNullExpressionValue(map, "map");
                return map;
            }
            QFSLinearFeedItemView qFSLinearFeedItemView = this.wrfView.get();
            if (qFSLinearFeedItemView != null) {
                e30.b data = qFSLinearFeedItemView.getData();
                int i3 = ((BaseWidgetView) qFSLinearFeedItemView).dataPosInList;
                Map<String, Object> d16 = ua0.c.d(data);
                Intrinsics.checkNotNullExpressionValue(d16, "convertDataToDTParamsMap(data)");
                map.putAll(d16);
                Intrinsics.checkNotNullExpressionValue(map, "map");
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            }
            Intrinsics.checkNotNullExpressionValue(map, "map");
            return map;
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ghi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSLinearFeedItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public boolean isVideoType() {
        if (getViewType() == 1003) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(@NotNull e30.b data, int pos) {
        Intrinsics.checkNotNullParameter(data, "data");
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_FLOW_CARD);
        VideoReport.setEventDynamicParams(this, new b(this));
        VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_FLOW_CARD + data.g().f398449id.get());
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    @NotNull
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        arrayList.add(s.class);
        if (getViewType() == 1003) {
            arrayList.add(n.class);
        } else if (getViewType() == 1002) {
            arrayList.add(k.class);
        }
        arrayList.add(d.class);
        arrayList.add(a.class);
        arrayList.add(l.class);
        arrayList.add(i.class);
        return arrayList;
    }
}
