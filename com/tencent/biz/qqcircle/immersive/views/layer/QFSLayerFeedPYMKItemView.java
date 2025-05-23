package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import ua0.c;

/* loaded from: classes4.dex */
public class QFSLayerFeedPYMKItemView extends QFSLayerDittoItemView {
    private a G;

    public QFSLayerFeedPYMKItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.G = (a) getViewModel(a.class);
    }

    private String E0(b bVar) {
        if (bVar == null) {
            return "";
        }
        return QCirclePluginUtil.getValueFromListEntry(((QQCircleDitto$StCircleDittoDataNew) bVar.b(String.valueOf(bVar.g().dittoFeed.dittoId.get()))).itemContainter.get().busiInfo.get(), "pymk_trigger_event");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gf8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedPYMKItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        int i16;
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.d(bVar));
            if (bVar.g().dittoFeed != null) {
                if (bVar.g().dittoFeed.dittoId.get() == 34) {
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, Integer.valueOf(i16));
                a aVar = this.G;
                if (aVar != null && aVar.L1() != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.G.L1().getUin());
                }
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_TRIGGER, E0(bVar));
            buildElementParams.put("dt_pgstp", Integer.valueOf(i3 + 1));
            buildElementParams.put("dt_ref_pgid", Integer.valueOf(getPageId()));
            buildElementParams.put("xsj_feed_id", bVar.g().f398449id.get());
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            QLog.i("QFSLayerFeedPYMKItemView", 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> o16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (o16 = q06.o()) != null) {
            arrayList.addAll(o16);
        }
        return arrayList;
    }
}
