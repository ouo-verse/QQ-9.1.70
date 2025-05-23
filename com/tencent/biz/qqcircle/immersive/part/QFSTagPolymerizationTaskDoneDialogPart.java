package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.event.QFSTagPolymerizationTaskDoneShowDialogEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudEeveeBase$StEeveeDialogData;
import feedcloud.FeedCloudRead$CommDialog;
import feedcloud.FeedCloudRead$DialogJumpInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSTagPolymerizationTaskDoneDialogPart extends u implements SimpleEventReceiver {
    private String C;
    private FeedCloudEeveeBase$StEeveeDialogData D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private Dialog f87585d;

    /* renamed from: e, reason: collision with root package name */
    private String f87586e;

    /* renamed from: f, reason: collision with root package name */
    private String f87587f;

    /* renamed from: h, reason: collision with root package name */
    private String f87588h;

    /* renamed from: i, reason: collision with root package name */
    private String f87589i;

    /* renamed from: m, reason: collision with root package name */
    private List<FeedCloudRead$DialogJumpInfo> f87590m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f87591d;

        a(Activity activity) {
            this.f87591d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            com.tencent.biz.qqcircle.launcher.c.g(this.f87591d, QFSTagPolymerizationTaskDoneDialogPart.this.C);
            QFSTagPolymerizationTaskDoneDialogPart.this.A9(QCircleDaTongConstant.ElementId.EM_XSJ_PUBLIC_BENEFIT_POPUP_RECEIVE_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QFSTagPolymerizationTaskDoneDialogPart.this.A9(QCircleDaTongConstant.ElementId.EM_XSJ_PUBLIC_BENEFIT_POPUP_STAY_XSJ_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        buildElementParams.putAll(E9());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void B9(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        buildElementParams.putAll(E9());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void C9(QFSTagPolymerizationTaskDoneShowDialogEvent qFSTagPolymerizationTaskDoneShowDialogEvent) {
        FeedCloudEeveeBase$StEeveeDialogData stEeveeDialogData = qFSTagPolymerizationTaskDoneShowDialogEvent.getStEeveeDialogData();
        this.D = stEeveeDialogData;
        if (stEeveeDialogData != null && stEeveeDialogData.dialog.get() != null) {
            FeedCloudRead$CommDialog feedCloudRead$CommDialog = this.D.dialog.get();
            this.f87586e = feedCloudRead$CommDialog.title.get();
            this.f87587f = feedCloudRead$CommDialog.text.get();
            this.f87588h = feedCloudRead$CommDialog.cancel_btn_text.get();
            this.f87589i = feedCloudRead$CommDialog.ok_btn_text.get();
            List<FeedCloudRead$DialogJumpInfo> list = feedCloudRead$CommDialog.jump_infos.get();
            this.f87590m = list;
            if (!RFSafeListUtils.isEmpty(list) && TextUtils.equals(this.f87590m.get(0).key_word.get(), "ok_jump_info")) {
                this.C = this.f87590m.get(0).jump_url.get();
                return;
            }
            return;
        }
        QLog.e("QFSTagPolymerizationTaskDoneDialogPart", 1, "[showDialog] mStEeveeDialogData should not be null");
    }

    private void D9() {
        Dialog dialog = this.f87585d;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private Map<String, Object> E9() {
        HashMap hashMap = new HashMap();
        if (getHostFragment() != null && getHostFragment().getReportBean() != null) {
            hashMap.put("xsj_custom_pgid", getHostFragment().getReportBean().getDtPageId());
        }
        FeedCloudEeveeBase$StEeveeDialogData feedCloudEeveeBase$StEeveeDialogData = this.D;
        if (feedCloudEeveeBase$StEeveeDialogData != null) {
            hashMap.put("xsj_feed_id", QCirclePluginUtil.getValueFromListEntry(feedCloudEeveeBase$StEeveeDialogData.entries.get(), "xsj_feed_id"));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, QCirclePluginUtil.getValueFromListEntry(this.D.entries.get(), QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN));
        }
        return hashMap;
    }

    private void F9(QFSTagPolymerizationTaskDoneShowDialogEvent qFSTagPolymerizationTaskDoneShowDialogEvent) {
        QLog.d("QFSTagPolymerizationTaskDoneDialogPart", 1, "[handleTagPolymerizationTaskDoneShowDialogEvent]");
        if (!this.E) {
            QLog.d("QFSTagPolymerizationTaskDoneDialogPart", 1, "[handleTagPolymerizationTaskDoneShowDialogEvent] is not resume, return");
            return;
        }
        C9(qFSTagPolymerizationTaskDoneShowDialogEvent);
        if (QCirclePluginUtil.isInQCircleNew()) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSTagPolymerizationTaskDoneDialogPart qFSTagPolymerizationTaskDoneDialogPart = QFSTagPolymerizationTaskDoneDialogPart.this;
                    qFSTagPolymerizationTaskDoneDialogPart.G9(qFSTagPolymerizationTaskDoneDialogPart.getActivity());
                }
            });
        }
    }

    public void G9(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (TextUtils.isEmpty(this.f87586e)) {
                QLog.e("QFSTagPolymerizationTaskDoneDialogPart", 1, "[showDialog] title should not be null");
                return;
            }
            this.f87585d = QCircleCustomDialog.R(activity, this.f87586e, this.f87587f, this.f87588h, this.f87589i, new a(activity), new b());
            if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                Dialog dialog = this.f87585d;
                if (dialog != null && !dialog.isShowing()) {
                    this.f87585d.show();
                    B9(QCircleDaTongConstant.ElementId.EM_XSJ_PUBLIC_BENEFIT_ACTIVITY_POPUP);
                    return;
                } else {
                    QLog.e("QFSTagPolymerizationTaskDoneDialogPart", 1, "[showDialog] dialog is showing");
                    return;
                }
            }
            QLog.e("QFSTagPolymerizationTaskDoneDialogPart", 1, "[showDialog] activity is finish.");
            return;
        }
        QLog.e("QFSTagPolymerizationTaskDoneDialogPart", 1, "[showDialog] view == null || activity is finish");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTagPolymerizationTaskDoneShowDialogEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTagPolymerizationTaskDoneDialogPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !FontSettingManager.isFontSizeLarge()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        this.E = false;
        D9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        this.E = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTagPolymerizationTaskDoneShowDialogEvent) {
            F9((QFSTagPolymerizationTaskDoneShowDialogEvent) simpleBaseEvent);
        }
    }
}
