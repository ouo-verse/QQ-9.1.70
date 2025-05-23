package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedFreeFlowView extends c implements View.OnClickListener, SimpleEventReceiver {
    private View D;
    private TextView E;
    private TextView F;
    private int G;
    private final Runnable H;
    private final Runnable I;

    public QFSFeedFreeFlowView(a aVar) {
        super(aVar);
        this.G = -1;
        this.H = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFreeFlowView.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) QFSFeedFreeFlowView.this, false);
            }
        };
        this.I = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFreeFlowView.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.qqcircle.immersive.utils.r.N0(true);
            }
        };
    }

    private void t(Runnable runnable) {
        if (runnable != null) {
            n().removeCallbacks(runnable);
        }
    }

    private void u(@NonNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f42131iy);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.D = inflate.findViewById(R.id.f39831cq);
        this.E = (TextView) inflate.findViewById(R.id.f39821cp);
        TextView textView = (TextView) inflate.findViewById(R.id.f39811co);
        this.F = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    private void v() {
        View view = this.D;
        if (view == null || this.G == -1) {
            return;
        }
        view.setVisibility(0);
        t(this.I);
        n().post(this.I);
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_TO_OPEN_DATA_FREE_BAR);
        int i3 = this.G;
        if (i3 == 1 || i3 == 2) {
            this.F.setVisibility(8);
            this.E.setText(this.D.getContext().getString(R.string.f1902641m));
            VideoReport.setElementId(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_DATA_FREE_OPENED_BAR);
        }
        t(this.H);
        n().postDelayed(this.H, 5000L);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSUnShowFreeFlowViewEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 121;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (QCircleHostGlobalInfo.isWifiState()) {
            QLog.d("QFSFreeFlowWidget", 1, "isElementCanActivate = false, is wifi state");
            return false;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.w()) {
            QLog.d("QFSFreeFlowWidget", 1, "isElementCanActivate = false, has show free flow view");
            return false;
        }
        String a16 = com.tencent.biz.qqcircle.utils.k.a("exp_xsj_mianliu");
        if (TextUtils.equals("exp_xsj_mianliu_C", a16)) {
            QLog.d("QFSFreeFlowWidget", 1, "isElementCanActivate = false, exp hit C");
            return false;
        }
        this.G = com.tencent.biz.qqcircle.immersive.utils.r.i();
        QLog.d("QFSFreeFlowWidget", 1, "isElementCanActivate, cardState=" + this.G + ", assignment=" + a16);
        if (TextUtils.equals("exp_xsj_mianliu_B", a16)) {
            int i3 = this.f90603f;
            if (i3 < 2 || i3 > 4 || this.G == -1) {
                return false;
            }
            return true;
        }
        if (this.G == -1) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39811co) {
            com.tencent.biz.qqcircle.launcher.c.o0(view.getContext(), VasUtil.getService().getVasFtManager().obtainCardInfo("040").getOrderUrl(), null, -1);
            VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_TO_OPEN_DATA_FREE_BUTTON);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        u(this.f90604h);
        v();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSUnShowFreeFlowViewEvent) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        t(this.H);
        t(this.I);
    }
}
