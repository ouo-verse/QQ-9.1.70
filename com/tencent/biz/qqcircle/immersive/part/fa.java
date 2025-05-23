package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.QFSSquareSearchPresenter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fa extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f88088d;

    /* renamed from: e, reason: collision with root package name */
    private final QFSSquareSearchPresenter f88089e = new QFSSquareSearchPresenter();

    /* renamed from: f, reason: collision with root package name */
    private final int f88090f;

    public fa(int i3) {
        this.f88090f = i3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchEntrancePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_refresh_event".equals(str) && (obj instanceof e40.b) && ((e40.b) obj).b() == 3) {
            this.f88089e.o1();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_search_entrance_show");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f46581uz) {
            QFSSearchBean qFSSearchBean = new QFSSearchBean();
            qFSSearchBean.setUserSource(4);
            com.tencent.biz.qqcircle.launcher.c.y0(getContext(), qFSSearchBean);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(2));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    protected void onEnableSkinChange(boolean z16) {
        int i3;
        ImageView imageView = this.f88088d;
        if (imageView == null) {
            return;
        }
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        if (z16) {
            i3 = R.drawable.qui_search;
        } else {
            i3 = R.drawable.f162071os1;
        }
        imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        boolean b16;
        super.onInitView(view);
        Object broadcastGetMessage = broadcastGetMessage("qfs_notice_entrance_is_left", null);
        if (broadcastGetMessage instanceof Boolean) {
            b16 = ((Boolean) broadcastGetMessage).booleanValue();
        } else {
            b16 = com.tencent.biz.qqcircle.immersive.utils.ai.b(this.f88090f);
            com.tencent.xaction.log.b.a(getTAG(), 1, "[onInitView] noticeEntranceObj error, re-judge");
        }
        boolean c16 = com.tencent.biz.qqcircle.drawer.i.c();
        com.tencent.xaction.log.b.a(getTAG(), 1, "[onInitView] isNoticeIconLeft:" + b16 + ", isHitDrawerExp:" + c16);
        View inflate = ((ViewStub) view.findViewById(R.id.f46611v2)).inflate();
        this.f88088d = (ImageView) inflate.findViewById(R.id.f46581uz);
        if (!b16 && c16 && (inflate.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams.rightMargin = com.tencent.biz.qqcircle.utils.cx.a(4.0f);
            inflate.setLayoutParams(layoutParams);
        }
        this.f88088d.setOnClickListener(this);
        this.f88089e.N0(view);
        com.tencent.biz.qqcircle.immersive.views.search.util.p.d(this.f88088d);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f88089e.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        if (this.mIsFirstResume) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(1));
        }
        super.onPartResume(activity);
    }
}
