package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dp extends b implements View.OnClickListener {
    private LinearLayout S;
    private RecyclerView T;
    private TextView U;
    private com.tencent.biz.qqcircle.immersive.adapter.h V;
    private String W = "";
    private String X = "";

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.S = (LinearLayout) view.findViewById(R.id.f46171tv);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f515628f);
        this.T = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(m0()));
        TextView textView = (TextView) view.findViewById(R.id.f56482kq);
        this.U = textView;
        textView.setOnClickListener(this);
        com.tencent.biz.qqcircle.immersive.adapter.h hVar = new com.tencent.biz.qqcircle.immersive.adapter.h();
        this.V = hVar;
        this.T.setAdapter(hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 35) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()))).itemContainter.get();
        this.W = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemContainer.urlInfo.get(), "jump_url");
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        StringBuilder sb5 = new StringBuilder();
        Iterator<QQCircleDitto$StItemInfo> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().name.get());
            sb5.append(";");
        }
        this.X = sb5.toString();
        this.V.setDatas(list);
        f0(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_MULTI_LIST_CARD);
        f0(this.U, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_MORE_BUTTON);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f56482kq) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(611).setSubActionType(3).setExt3(this.X));
            com.tencent.biz.qqcircle.launcher.c.g(m0(), this.W);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(611).setSubActionType(1).setExt3(this.X));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSMulHotTagPresenter";
    }
}
