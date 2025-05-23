package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
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
public class dq extends b implements View.OnClickListener {
    private RecyclerView S;
    private TextView T;
    private com.tencent.biz.qqcircle.immersive.adapter.j U;
    private String V = "";
    private String W = "";

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.S = (RecyclerView) view.findViewById(R.id.f515728g);
        this.T = (TextView) view.findViewById(R.id.f56482kq);
        this.S.setLayoutManager(new SafeLinearLayoutManager(m0()));
        com.tencent.biz.qqcircle.immersive.adapter.j jVar = new com.tencent.biz.qqcircle.immersive.adapter.j();
        this.U = jVar;
        this.S.setAdapter(jVar);
        this.T.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 36) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()))).itemContainter.get();
        this.V = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemContainer.urlInfo.get(), "jump_url");
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        StringBuilder sb5 = new StringBuilder();
        Iterator<QQCircleDitto$StItemInfo> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f429300id.get());
            sb5.append(";");
        }
        this.W = sb5.toString();
        this.U.setDatas(list);
        f0(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_PROP_LIST_CARD);
        f0(this.T, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_MORE_BUTTON);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f56482kq) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(613).setSubActionType(4).setExt3(this.W));
            com.tencent.biz.qqcircle.launcher.c.g(m0(), this.V);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(613).setSubActionType(1).setExt3(this.W));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSPropPresenter";
    }
}
