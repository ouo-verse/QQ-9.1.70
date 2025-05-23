package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.part.ep;
import com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSHomePageFragment extends QFSBaseFragment {
    private List<Part> E;
    private QFSHomePageFragmentPart F;
    private ep G;

    private void rh() {
        QCircleFolderBean qCircleFolderBean;
        if (getActivity() == null || getActivity().getIntent() == null || (qCircleFolderBean = (QCircleFolderBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean")) == null) {
            return;
        }
        boolean isPublish = qCircleFolderBean.isPublish();
        if (this.G != null && isPublish) {
            getPartManager().broadcastMessage("publish_on_click", null);
            qCircleFolderBean.setPublish(false);
        }
    }

    private boolean sh() {
        if (bz.q(getActivity())) {
            return false;
        }
        QLog.d("ASDynamicEngine_back_qcircle", 1, "QCircleFolder back isPluginTab:false_" + ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_FLASH_SHOW) + "_");
        return false;
    }

    private void th(ASEngineTabBackEvent aSEngineTabBackEvent) {
        if (!aSEngineTabBackEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) || bz.q(getActivity())) {
            return;
        }
        ASInject.g().getOnBackEventListener().onBackEvent(onBackEvent(), ASEngineConstants.BusinessKey.BUSINESS_FLASH_SHOW);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        if (this.E == null) {
            this.E = new ArrayList();
            QFSHomePageFragmentPart qFSHomePageFragmentPart = new QFSHomePageFragmentPart(getPartManager());
            this.F = qFSHomePageFragmentPart;
            this.E.add(qFSHomePageFragmentPart);
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gde;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        QFSHomePageFragmentPart qFSHomePageFragmentPart = this.F;
        if (qFSHomePageFragmentPart != null) {
            return qFSHomePageFragmentPart.L9();
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(ASEngineTabBackEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHomePageFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        QFSHomePageFragmentPart qFSHomePageFragmentPart = this.F;
        if (qFSHomePageFragmentPart != null) {
            return qFSHomePageFragmentPart.getPageId();
        }
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (sh()) {
            boolean onBackEvent = super.onBackEvent();
            QLog.d("ASDynamicEngine_back_qcircle", 1, "FsFolder back onBackEvent:" + onBackEvent);
            ASInject.g().getOnBackEventListener().onBackEvent(onBackEvent, ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d("QFSHomePageFragment", 1, "fs_lifecycle onPause");
        super.onPause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof ASEngineTabBackEvent) {
            th((ASEngineTabBackEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("QFSHomePageFragment", 1, "fs_lifecycle onResume");
        super.onResume();
        rh();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        this.mReportBean.setPageId(getPageId());
        this.mReportBean.setDtPageId(getDaTongPageId());
        return this.mReportBean;
    }
}
