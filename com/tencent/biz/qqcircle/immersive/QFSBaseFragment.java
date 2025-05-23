package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper;
import com.tencent.biz.qqcircle.immersive.utils.as;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseFragment extends QCircleBaseFragment {
    protected boolean C = false;
    protected boolean D = true;

    private void ph(@NonNull QCircleTransActivityLifeEvent qCircleTransActivityLifeEvent) {
        QLog.d("QFSBaseFragment", 1, "[handleFlutterPageEvent] event isPageOpenFlag: ", Integer.valueOf(qCircleTransActivityLifeEvent.getLifeEvent()));
        int lifeEvent = qCircleTransActivityLifeEvent.getLifeEvent();
        if (lifeEvent == 0) {
            onStop();
        } else if (lifeEvent == 1) {
            onStart();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    protected void doPause() {
        QLog.d("QFSBaseFragment", 1, getLogTag() + "->doPause");
        super.doPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        QLog.d("QFSBaseFragment", 1, getLogTag() + "->doResume");
        super.doResume();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleTransActivityLifeEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        return eventClass;
    }

    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartFragmentIOCKt.getIocInterface(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.C = false;
        as.b(getDaTongPageId(), getClass().getSimpleName());
        if (qh()) {
            QFSTeenModeLoginTimeReporter.getInstance().stopReport();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleTransActivityLifeEvent) {
            ph((QCircleTransActivityLifeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.D = false;
        this.C = true;
        QQLiveRemoteFloatWindowHelper.f88336d.c();
        as.c(getDaTongPageId(), getClass().getSimpleName());
        if (qh()) {
            QFSTeenModeLoginTimeReporter.getInstance().startReport();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        QLog.d("QFSBaseFragment", 1, getLogTag() + "->doOnCreateView");
        super.onViewCreatedBeforePartInit(view, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    protected boolean qh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(View view, Object obj, Class<?> cls) {
        PartFragmentIOCKt.registerIoc(this, view, obj, cls);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        QLog.d("QFSBaseFragment", 1, getLogTag() + "->setUserVisibleHint:" + z16);
        super.setUserVisibleHint(z16);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        Object viewTagData = super.getViewTagData();
        if (!(viewTagData instanceof QCircleReportBean)) {
            if (!RFWApplication.isDebug()) {
                QLog.e("QFSBaseFragment", 1, "getReportBean but QCircleReportBean is null");
                QCircleReportBean qCircleReportBean = new QCircleReportBean();
                qCircleReportBean.setPageId(getPageId());
                qCircleReportBean.setDtPageId(getDaTongPageId());
                return qCircleReportBean;
            }
            QLog.e("QFSBaseFragment", 1, "getReportBean but QCircleReportBean is null , debug");
            throw new RuntimeException("getReportBean but QCircleReportBean is null");
        }
        return (QCircleReportBean) viewTagData;
    }
}
