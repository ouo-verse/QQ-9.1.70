package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class af extends c implements View.OnClickListener {
    private View D;
    private TextView E;

    public af(a aVar) {
        super(aVar);
    }

    private void t() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_HEATING_TICKET_ID, this.f90601d.g().promoteInfo.ticketID);
        buildElementParams.put("xsj_feed_id", this.f90601d.g().f398449id);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90601d.g().poster.f398463id);
        VideoReport.setElementId(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_HEATING_TICKET_FEED);
        VideoReport.setElementParams(this.D, buildElementParams);
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_TICKET_PAGE_SKIP_BUTTON);
        VideoReport.setElementParams(this.E, buildElementParams);
    }

    private void u(@NonNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f48041yx);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.D = inflate.findViewById(R.id.f40811fd);
        TextView textView = (TextView) inflate.findViewById(R.id.f40801fc);
        this.E = textView;
        textView.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 117;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && com.tencent.biz.qqcircle.immersive.utils.r.u0(feedCloudMeta$StFeed.poster) && this.f90602e.promoteInfo.usePromoteTicket.get()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f40801fc) {
            com.tencent.biz.qqcircle.launcher.c.o0(view.getContext(), this.f90602e.promoteInfo.ticketJumpUrl.get(), null, -1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        u(this.f90604h);
        this.D.setVisibility(0);
        t();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
