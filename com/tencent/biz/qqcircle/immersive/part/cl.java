package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleForQZoneVideoState;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cl extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f87839d;

    /* renamed from: e, reason: collision with root package name */
    private View f87840e;

    /* renamed from: f, reason: collision with root package name */
    private View f87841f;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StFeed f87842h;

    private void A9() {
        if (this.f87840e != null && getReportBean() != null && TextUtils.equals(getReportBean().getDtFromPageId(), QCircleDaTongConstant.PageId.PG_XSJ_RELATE_REC_PAGE)) {
            this.f87840e.setVisibility(0);
        }
    }

    private void x9(View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        boolean z16;
        View findViewById = view.findViewById(R.id.va_);
        this.f87841f = findViewById;
        findViewById.setOnClickListener(this);
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null) {
            feedCloudMeta$StFeed = qCircleInitBean.getFeed();
        } else {
            feedCloudMeta$StFeed = null;
        }
        int i3 = 0;
        if (p40.o.f(qCircleInitBean) && !QCircleForQZoneVideoState.isMixMode() && p40.o.e(feedCloudMeta$StFeed)) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view2 = this.f87841f;
        if (!z16) {
            i3 = 8;
        }
        view2.setVisibility(i3);
        p40.o.a(this.f87841f, new e30.b(this.f87842h), QCirclePluginUtil.getQCircleInitBean(getContext()));
    }

    private void z9() {
        String str;
        if (this.f87842h == null) {
            QLog.e("FSLayerBarViewPart", 1, "[clickOpenSmallWindow] current should not be null.");
            return;
        }
        if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(getActivity())) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(getActivity());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onClick] feed id: ");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f87842h;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        sb5.append(str);
        QLog.d("FSLayerBarViewPart", 1, sb5.toString());
        SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_LAYER_TOP_FLOAT_TRIGGER));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FSLayerBarViewPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (!"layer_notify_part_update_feed".equals(str) || !(obj instanceof e30.b)) {
            return;
        }
        e30.b bVar = (e30.b) obj;
        if (bVar.g() == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        this.f87842h = g16;
        if (p40.o.e(g16) && p40.o.f(QCirclePluginUtil.getQCircleInitBean(getContext())) && !QCircleForQZoneVideoState.isMixMode()) {
            this.f87841f.setVisibility(0);
            View view = this.f87839d;
            view.setPadding(view.getPaddingLeft(), this.f87839d.getPaddingTop(), com.tencent.biz.qqcircle.utils.cx.a(6.0f), this.f87839d.getPaddingBottom());
        } else {
            this.f87841f.setVisibility(8);
            View view2 = this.f87839d;
            view2.setPadding(view2.getPaddingLeft(), this.f87839d.getPaddingTop(), com.tencent.biz.qqcircle.utils.cx.a(14.0f), this.f87839d.getPaddingBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.va6) {
            if (p40.o.d(QCirclePluginUtil.getQCircleInitBean(getContext())) && uq3.o.g()) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_TOP_CLOSE_TRIGGER));
            } else {
                getActivity().onBackPressed();
            }
        } else if (view.getId() == R.id.va_) {
            p40.o.a(this.f87841f, new e30.b(this.f87842h), QCirclePluginUtil.getQCircleInitBean(getContext()));
            z9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        int i3;
        super.onInitView(view);
        this.f87839d = view.findViewById(R.id.va6);
        this.f87840e = view.findViewById(R.id.va8);
        this.f87839d.setOnClickListener(this);
        this.f87839d.setContentDescription("\u9000\u51fa");
        x9(view);
        View view2 = this.f87839d;
        if (QCircleForQZoneVideoState.isMixMode()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view2.setVisibility(i3);
        VideoReport.setElementId(this.f87839d, "em_xsj_back_button");
        VideoReport.setElementParams(this.f87839d, new QCircleDTParamBuilder().buildElementParams());
        com.tencent.biz.qqcircle.immersive.views.search.util.p.G(view, QCirclePluginUtil.getQCircleInitBean(getContext()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        A9();
    }
}
