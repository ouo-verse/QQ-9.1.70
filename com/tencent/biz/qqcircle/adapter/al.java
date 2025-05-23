package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.widgets.pymk.QFSPymkFeedItemView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class al extends QFSPersonalFeedBaseAdapter {
    public al(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter
    protected void l0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_PRODUCT_INDEX, Integer.valueOf(i3 + 1));
        buildElementParams.put("xsj_feed_id", eVar.d());
        VideoReport.setElementParams(view, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new QFSPersonalFeedBaseAdapter.c(new QFSPymkFeedItemView(viewGroup.getContext(), getNUM_BACKGOURND_ICON()));
    }
}
