package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoChangedEvent;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalBasicRequestEvent;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalCollectFragment extends QFSBaseFragment {
    protected com.tencent.biz.qqcircle.immersive.personal.part.y E;
    protected QFSPersonalDetailsFragment F;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r G;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.j H;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t I;
    private com.tencent.biz.qqcircle.immersive.personal.widget.k J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalInfo> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            if (QFSPersonalCollectFragment.this.E != null && QCirclePluginUtil.isRequestSecurityHit(qFSPersonalInfo.f())) {
                QFSPersonalCollectFragment.this.wh(qFSPersonalInfo.f(), qFSPersonalInfo.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends v.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_extend_feed", "update_version_op_mask", "update_versionP_user_black");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            String x16;
            QFSPersonalInfo value;
            if (QFSPersonalCollectFragment.this.E != null && !wVar.x()) {
                if (QFSPersonalCollectFragment.this.G != null && (value = QFSPersonalCollectFragment.this.G.g2().getValue()) != null && QCirclePluginUtil.isRequestSecurityHit(value.f())) {
                    return;
                }
                if (QCirclePluginUtil.isRequestSecurityHit(wVar.q())) {
                    QFSPersonalCollectFragment.this.wh(wVar.q(), wVar.r());
                    return;
                }
                if (!wVar.z() && wVar.v()) {
                    QFSPersonalCollectFragment.this.E.M9(uq3.c.c2(), uq3.c.b2());
                    return;
                }
                if (!wVar.z() && wVar.w()) {
                    QFSPersonalCollectFragment.this.E.M9(uq3.c.c2(), uq3.c.a2());
                    return;
                }
                if (!wVar.z() && wVar.u(19)) {
                    QFSPersonalCollectFragment.this.E.L9();
                    return;
                }
                List<Integer> e16 = wVar.d().e();
                if (wVar.d().a() == 0 && e16 != null && !e16.contains(1)) {
                    if (wVar.z()) {
                        x16 = uq3.c.y1();
                    } else {
                        x16 = uq3.c.x1();
                    }
                    String[] f16 = cu.f(x16, "\n");
                    if (f16.length >= 2) {
                        QFSPersonalCollectFragment.this.E.M9(f16[0], f16[1]);
                        return;
                    } else {
                        QFSPersonalCollectFragment.this.E.M9(f16[0], "");
                        return;
                    }
                }
                QFSPersonalCollectFragment.this.E.E9();
                if (com.tencent.biz.qqcircle.immersive.personal.utils.j.a() && QFSPersonalCollectFragment.this.G != null && QFSPersonalCollectFragment.this.G.e2().getValue() == null) {
                    RFWLog.i("QFSPersonalCollectFragment", RFWLog.USR, "[requestCollectBox]");
                    QFSPersonalCollectFragment.this.G.Y2(false);
                }
                if (QFSPersonalCollectFragment.this.G != null && QFSPersonalCollectFragment.this.G.d2().getValue() == null) {
                    RFWLog.i("QFSPersonalCollectFragment", RFWLog.USR, "[requestAlbums]");
                    QFSPersonalCollectFragment.this.G.W2(false);
                }
                if (QFSPersonalCollectFragment.this.H != null && QFSPersonalCollectFragment.this.H.Q1().getValue() == null) {
                    RFWLog.i("QFSPersonalCollectFragment", RFWLog.USR, "[requestFeeds]");
                    QFSPersonalCollectFragment.this.H.U1(true);
                }
            }
        }
    }

    private void initViewModel() {
        QLog.i(getTAG(), 1, "[initViewModel] getParentFragment() = " + getParentFragment());
        this.G = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(this.F, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.H = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.j) getViewModel(this.F, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.j.class);
        this.I = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(this.F, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.G.g2().observe(this, new a());
        this.I.O1().c(this, new b());
    }

    private void uh() {
        VideoReport.setElementId(((QCircleBaseFragment) this).mContentView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_COLLECT_TAB);
    }

    private void vh(QFSPersonalBasicRequestEvent qFSPersonalBasicRequestEvent) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.G;
        if (rVar != null && TextUtils.equals(rVar.i2(), qFSPersonalBasicRequestEvent.getUin()) && !qFSPersonalBasicRequestEvent.isSuccess()) {
            wh(qFSPersonalBasicRequestEvent.getRetCode(), qFSPersonalBasicRequestEvent.getErrMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(long j3, String str) {
        this.E.E9();
        this.E.P9(str, j3);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = (QFSPersonalDetailsFragment) getParentFragment();
        this.F = qFSPersonalDetailsFragment;
        com.tencent.biz.qqcircle.immersive.personal.widget.k kVar = new com.tencent.biz.qqcircle.immersive.personal.widget.k(qFSPersonalDetailsFragment);
        this.J = kVar;
        arrayList.add(kVar);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.E = yVar;
        arrayList.add(yVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gkj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "pg_xsj_profile_page";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSPersonalBasicRequestEvent.class);
        eventClass.add(QCircleFeedAlbumInfoChangedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar = this.H;
        if (jVar != null) {
            jVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSPersonalBasicRequestEvent) {
            vh((QFSPersonalBasicRequestEvent) simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof QCircleFeedAlbumInfoChangedEvent) {
            this.G.W2(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar = this.H;
        if (jVar != null) {
            jVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        uh();
        initViewModel();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.J.G9(bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        this.mReportBean.setPageId(getPageId());
        if (getQCircleInitBean() != null && getQCircleInitBean().getFromReportBean() != null) {
            this.mReportBean.setFromPageId(getQCircleInitBean().getFromReportBean().getPageId());
        }
        return this.mReportBean;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
