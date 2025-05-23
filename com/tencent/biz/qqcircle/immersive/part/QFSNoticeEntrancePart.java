package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSNoticeEntranceClickEvent;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes4.dex */
public class QFSNoticeEntrancePart extends u implements View.OnClickListener, SimpleEventReceiver {
    private final int C;
    private Boolean D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f87476d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f87477e;

    /* renamed from: f, reason: collision with root package name */
    private DragTextView f87478f;

    /* renamed from: h, reason: collision with root package name */
    private View f87479h;

    /* renamed from: i, reason: collision with root package name */
    private View f87480i;

    /* renamed from: m, reason: collision with root package name */
    private QQCircleCounter$RedPointInfo f87481m;

    private int A9(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (!com.tencent.biz.qqcircle.immersive.utils.ai.c(qQCircleCounter$RedPointInfo)) {
            return 0;
        }
        if (qQCircleCounter$RedPointInfo.redTotalNum.get() > 0) {
            return 1;
        }
        return 2;
    }

    private void B9(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 27) {
            F9();
        }
    }

    private void C9(@NonNull QCircleRedPointEvent qCircleRedPointEvent) {
        if (qCircleRedPointEvent.mRedPointMainMsgType != 102) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSNoticeEntrancePart.1
            @Override // java.lang.Runnable
            public void run() {
                QFSNoticeEntrancePart.this.F9();
            }
        });
    }

    private void D9() {
        View view = this.f87479h;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void E9() {
        ViewStub viewStub;
        if (this.f87479h != null || this.f87480i == null) {
            return;
        }
        boolean b16 = com.tencent.biz.qqcircle.immersive.utils.ai.b(this.C);
        boolean c16 = com.tencent.biz.qqcircle.drawer.i.c();
        QLog.d(getTAG(), 1, "[inflateNoticeEntrance] isNoticeIconLeft:" + b16 + ", isHitDrawerExp:" + c16);
        if (c16) {
            viewStub = (ViewStub) this.f87480i.findViewById(R.id.f48001yt);
        } else if (b16) {
            viewStub = (ViewStub) this.f87480i.findViewById(R.id.f47991ys);
        } else {
            viewStub = (ViewStub) this.f87480i.findViewById(R.id.f47981yr);
        }
        View inflate = viewStub.inflate();
        this.f87479h = inflate;
        this.f87476d = (ImageView) inflate.findViewById(R.id.f47971yq);
        this.f87477e = (ImageView) this.f87479h.findViewById(R.id.f48021yv);
        this.f87478f = (DragTextView) this.f87479h.findViewById(R.id.f48011yu);
        this.f87479h.setOnClickListener(this);
        this.f87479h.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f183923kh));
        this.D = Boolean.valueOf(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            D9();
            return;
        }
        E9();
        View view = this.f87479h;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        G9();
        z9();
    }

    private void G9() {
        QQCircleCounter$RedPointInfo numRedPointInfoByAppid = QCircleHostRedPointHelper.getNumRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        this.f87481m = numRedPointInfoByAppid;
        if (!com.tencent.biz.qqcircle.immersive.utils.ai.c(numRedPointInfoByAppid)) {
            this.f87477e.setVisibility(8);
            this.f87478f.setVisibility(8);
        } else if (this.f87481m.redTotalNum.get() > 0) {
            this.f87477e.setVisibility(8);
            this.f87478f.setVisibility(0);
            this.f87478f.setText(HostChatUtils.getMaxUnReadCountText(this.f87481m.redTotalNum.get()));
        } else {
            this.f87477e.setVisibility(0);
            this.f87478f.setVisibility(8);
        }
    }

    private void z9() {
        View view = this.f87479h;
        if (view != null && this.f87481m != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_MSG_BUTTON);
            VideoReport.setElementClickPolicy(this.f87479h, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.f87479h, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.f87479h, EndExposurePolicy.REPORT_ALL);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.f87481m.extend.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(A9(this.f87481m)));
            buildElementParams.put("xsj_reddot_number", Integer.valueOf(this.f87481m.redTotalNum.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_ID, EeveeRedpointUtil.getRedPointId(this.f87481m));
            VideoReport.setElementParams(this.f87479h, buildElementParams);
            return;
        }
        QLog.d("QFSNoticeEntrancePart", 1, "dtReportNoticeEntranceView, noticeView or red dot is null ");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleRedPointEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNoticeEntrancePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals("qfs_notice_entrance_is_left", str)) {
            return this.D;
        }
        return super.getMessage(str, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.b(getTAG(), 500L) && view.getId() == R.id.f48031yw) {
            String account = HostDataTransUtils.getAccount();
            if (QCirclePluginUtil.isOwner(account)) {
                if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
                    QLog.d("QFSNoticeEntrancePart", 1, "[onclick] forbid launch notice page because of sencebeat");
                } else {
                    if (com.tencent.biz.qqcircle.drawer.i.c()) {
                        QFSNoticeEntranceClickEvent qFSNoticeEntranceClickEvent = new QFSNoticeEntranceClickEvent(view, getActivityHashCode());
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.f87481m;
                        if (qQCircleCounter$RedPointInfo != null && qQCircleCounter$RedPointInfo.squareRedExt.extInfo.has()) {
                            qFSNoticeEntranceClickEvent.setStCommonExt(this.f87481m.squareRedExt.extInfo.get());
                        }
                        SimpleEventBus.getInstance().dispatchEvent(qFSNoticeEntranceClickEvent);
                    } else {
                        QCircleInitBean qCircleInitBean = new QCircleInitBean();
                        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
                        qCircleInitBean.setLaunchFrom(String.valueOf(1));
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2 = this.f87481m;
                        if (qQCircleCounter$RedPointInfo2 != null && qQCircleCounter$RedPointInfo2.squareRedExt.extInfo.has()) {
                            qCircleInitBean.setCommonExtInfo(this.f87481m.squareRedExt.extInfo.get());
                        }
                        com.tencent.biz.qqcircle.launcher.c.T(getContext(), qCircleInitBean);
                    }
                    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(account).setActionType(11).setSubActionType(2).setThrActionType(2).setPageId(getPageId()).setfPageId(getFromPageId()));
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    protected void onEnableSkinChange(boolean z16) {
        int i3;
        int i16;
        if (this.f87476d == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.drawer.i.c()) {
            ImageView imageView = this.f87476d;
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i16 = R.drawable.qui_chat_settings;
            } else {
                i16 = R.drawable.orz;
            }
            imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i16));
            return;
        }
        ImageView imageView2 = this.f87476d;
        QCircleSkinHelper qCircleSkinHelper2 = QCircleSkinHelper.getInstance();
        if (z16) {
            i3 = R.drawable.qui_remind;
        } else {
            i3 = R.drawable.ory;
        }
        imageView2.setImageDrawable(qCircleSkinHelper2.getDrawable(i3));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87480i = view;
        F9();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        F9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleRedPointEvent) {
            C9((QCircleRedPointEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            B9((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }
}
