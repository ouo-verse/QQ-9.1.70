package com.tencent.biz.qqcircle.immersive.part.teenmode;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.floatingwindow.view.c;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StGPSV2;
import uq3.o;

/* loaded from: classes4.dex */
public class QFSTeenModeChangePart extends u {

    /* renamed from: d, reason: collision with root package name */
    private StudyModeChangeListener f88330d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A9(boolean z16) {
        QCircleBaseActivity qCircleBaseActivity;
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(getContext())) {
            return;
        }
        if ((getHostFragment().getActivity() instanceof QCircleBaseActivity) && (qCircleBaseActivity = (QCircleBaseActivity) getHostFragment().getActivity()) != null) {
            QLog.d("QFSTeenModeChangePart", 1, "refreshFolderPage isStudyMode =" + z16);
            qCircleBaseActivity.L2();
        }
        B9(z16);
    }

    private void B9(boolean z16) {
        if (z16 && p40.u.H().j0()) {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(c.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C9(final boolean z16) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.teenmode.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSTeenModeChangePart.this.A9(z16);
            }
        }, 1000L);
    }

    private void D9() {
        this.f88330d = new StudyModeChangeListener() { // from class: com.tencent.biz.qqcircle.immersive.part.teenmode.QFSTeenModeChangePart.1
            @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
            public void onChange(boolean z16) {
                FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
                QCircleFolderTabInfoManager m3 = QCircleFolderTabInfoManager.m();
                if (o.i()) {
                    feedCloudMeta$StGPSV2 = com.tencent.biz.qqcircle.c.e().d();
                } else {
                    feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
                }
                m3.o(feedCloudMeta$StGPSV2, new QCircleFolderBean((QCircleReportBean) QFSTeenModeChangePart.this.getViewTagData()));
                QFSTeenModeChangePart.this.C9(z16);
                if (z16) {
                    QFSTeenModeChangePart.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.teenmode.QFSTeenModeChangePart.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p40.u.H().E0();
                        }
                    });
                }
            }
        };
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.f88330d);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTeenModeChangePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f88330d != null) {
            ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.f88330d);
        }
    }
}
