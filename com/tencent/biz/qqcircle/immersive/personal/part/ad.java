package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ad extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener, SimpleEventReceiver {
    private ImageView C;
    private View D;
    private ImageView E;
    private ImageView F;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f88825d;

    /* renamed from: e, reason: collision with root package name */
    private Observer<QFSPersonalInfo> f88826e;

    /* renamed from: f, reason: collision with root package name */
    private QFSPersonalInfo f88827f;

    /* renamed from: h, reason: collision with root package name */
    private String f88828h = "";

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f88829i;

    /* renamed from: m, reason: collision with root package name */
    private View f88830m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalInfo> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            ad.this.E9(qFSPersonalInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            com.tencent.biz.qqcircle.launcher.c.x(ad.this.getContext());
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    private void A9(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        if (this.f88827f.f88420g.equals(qCircleFollowUpdateEvent.mUserId)) {
            this.f88827f.f88416c.followState.set(qCircleFollowUpdateEvent.mFollowStatus);
        }
    }

    private void B9(QCircleSpecialFollowUpdateEvent qCircleSpecialFollowUpdateEvent) {
        if (this.f88827f.f88420g.equals(qCircleSpecialFollowUpdateEvent.uin)) {
            this.f88827f.f88416c.relationState.set(qCircleSpecialFollowUpdateEvent.isFollow ? 1 : 0);
        }
    }

    private void D9(QCircleShowSettingEvent qCircleShowSettingEvent) {
        boolean z16;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.f88825d;
        if (rVar != null && rVar.L2()) {
            com.tencent.biz.qqcircle.immersive.personal.data.w value = this.f88825d.w2().getValue();
            QFSPersonalInfo qFSPersonalInfo = this.f88827f;
            if (qFSPersonalInfo != null && qFSPersonalInfo.f88432s != null && value != null) {
                int i3 = qCircleShowSettingEvent.mCode;
                if (com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.b(i3)) {
                    z16 = !qCircleShowSettingEvent.mShow;
                } else {
                    z16 = qCircleShowSettingEvent.mShow;
                }
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(value.L());
                if (z16) {
                    wVar.m(i3);
                } else {
                    wVar.G(i3);
                }
                wVar.R();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(QFSPersonalInfo qFSPersonalInfo) {
        if (qFSPersonalInfo == null) {
            QLog.e("QFSPersonalTitleBarPart", 1, "mPersonalInfo is null");
            return;
        }
        this.f88827f = qFSPersonalInfo;
        this.f88828h = qFSPersonalInfo.f88420g;
        F9();
    }

    private void F9() {
        QFSPersonalInfo qFSPersonalInfo;
        if (this.C != null && (qFSPersonalInfo = this.f88827f) != null && qFSPersonalInfo.f88416c != null) {
            if (QCirclePluginUtil.isOwner(this.f88828h)) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.f88828h).setActionType(11).setSubActionType(2).setThrActionType(1).setPageId(getPageId()).setfPageId(getFromPageId()));
            }
            this.C.setVisibility(8);
            View view = this.D;
            if (view != null) {
                view.setVisibility(8);
            }
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void initListener() {
        View view;
        ImageView imageView = this.E;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (this.f88829i != null && this.C != null && (view = this.f88830m) != null) {
            view.setOnClickListener(this);
            this.C.setOnClickListener(this);
            if (com.tencent.qcircle.cooperation.config.debug.c.f()) {
                this.f88830m.setOnLongClickListener(new b());
            }
        }
    }

    private void initViewModel() {
        this.f88825d = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.f88826e = new a();
        this.f88825d.g2().observeForever(this.f88826e);
    }

    private void z9() {
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_ROAST_BUTTON);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleSpecialFollowUpdateEvent.class);
        arrayList.add(QCircleFollowUpdateEvent.class);
        arrayList.add(QCircleShowSettingEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalTitleBarPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f1186774s && fb0.a.a("QCirclePersonalTitleBarTopContainer")) {
            C9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88829i = (RelativeLayout) view.findViewById(R.id.f760340k);
        this.f88830m = view.findViewById(R.id.f1186774s);
        this.f88829i.getLayoutParams().height += ImmersiveUtils.getStatusBarHeight(getContext());
        this.f88829i.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        this.C = (ImageView) view.findViewById(R.id.y77);
        this.D = view.findViewById(R.id.v8i);
        this.E = (ImageView) view.findViewById(R.id.y75);
        this.F = (ImageView) view.findViewById(R.id.y76);
        initListener();
        F9();
        initViewModel();
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.f88825d.g2().removeObserver(this.f88826e);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (this.f88827f == null) {
            return;
        }
        if (simpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent) {
            B9((QCircleSpecialFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            A9((QCircleFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleShowSettingEvent) {
            D9((QCircleShowSettingEvent) simpleBaseEvent);
        }
    }

    public void C9() {
    }
}
