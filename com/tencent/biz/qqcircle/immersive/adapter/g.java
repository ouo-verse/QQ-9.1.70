package com.tencent.biz.qqcircle.immersive.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedHotTagFeedItemView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends QFSPersonalFeedBaseAdapter {
    private String D;
    private String E;

    public g(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter
    protected void l0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_topic_id", this.D);
        buildElementParams.put("xsj_topic_name", this.E);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, eVar.b().poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_VIEW_NUM, Integer.valueOf(eVar.b().visitorInfo.viewCount.get()));
        buildElementParams.put("xsj_feed_id", eVar.d());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, eVar.d());
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new QFSPersonalFeedBaseAdapter.c(new QFSLayerFeedHotTagFeedItemView(viewGroup.getContext()));
    }

    public void r0(String str) {
        this.D = str;
    }

    public void s0(String str) {
        this.E = str;
    }
}
