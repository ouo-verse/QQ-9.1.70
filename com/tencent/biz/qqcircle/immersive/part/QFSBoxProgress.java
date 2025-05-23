package com.tencent.biz.qqcircle.immersive.part;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel;
import com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressView;
import com.tencent.biz.qqcircle.utils.j;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.wink.QCirclePublishProgress;
import com.tencent.libra.LoadState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class QFSBoxProgress implements View.OnClickListener {
    private static final long G = (QzoneConfig.getWinkCancelUploadShowCloseButton() * 60) * 1000;
    private Context C;
    private QCircleCustomDialog D;
    private TaskInfo E;

    /* renamed from: d, reason: collision with root package name */
    public QFSRoundProgressView f87320d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f87321e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f87322f;

    /* renamed from: m, reason: collision with root package name */
    private au f87325m;

    /* renamed from: h, reason: collision with root package name */
    boolean f87323h = false;

    /* renamed from: i, reason: collision with root package name */
    private final FakeProgressRunnable f87324i = new FakeProgressRunnable();
    private final Runnable F = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSBoxProgress.1
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "mShowCloseBtnRunnable, run ");
            QFSBoxProgress.this.q(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class FakeProgressRunnable implements Runnable {
        FakeProgressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QFSBoxProgress.this.E == null) {
                return;
            }
            int e16 = QCirclePublishProgress.f93922d.e(QFSBoxProgress.this.E.getTaskId());
            QFSBoxProgress.this.f87320d.setProgress(e16);
            if (e16 < 100) {
                RFWThreadManager.getUIHandler().postDelayed(this, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String h16 = QFSBoxProgress.this.h();
            HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, h16);
            au.C9(QFSBoxProgress.this.D.getRootView(), "dt_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_TERMINATE_PANEL, hashMap);
        }
    }

    public QFSBoxProgress(TaskInfo taskInfo) {
        this.E = taskInfo;
    }

    private TaskInfo g() {
        if (this.E == null) {
            QLog.w("WinkPublish-Progress-QFSBoxProgress", 1, "cancelUploadActually, mCurrentTask is null ");
            return null;
        }
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService == null) {
            QLog.w("WinkPublish-Progress-QFSBoxProgress", 1, "cancelUploadActually, serviceProxy is null ");
            return null;
        }
        long taskId = this.E.getTaskId();
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "cancelUploadActually, taskId: " + taskId);
        qfsService.cancelTaskWithId(taskId);
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        String str;
        String str2;
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "cancelUploadManually ");
        TaskInfo g16 = g();
        if (g16 == null) {
            str = "";
        } else {
            ((QFSTopPopBannerViewModel) this.f87325m.getViewModel(QFSTopPopBannerViewModel.class)).O1(g16.getTaskId());
            Bundle transParams = g16.getTransParams();
            if (transParams == null) {
                str = "";
            } else {
                str = transParams.getString(QQWinkConstants.PUBLISH_TRANS_PARAMS_CAMERA_SESSION_ID);
            }
            if (this.E == null) {
                str2 = "";
            } else {
                str2 = ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).getSnapshotInfo(String.valueOf(this.f87320d.q()), this.E.getExportProgress(), this.E.getUploadProgress());
            }
            QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "cancelUploadManually, dtCameraSessionId=" + str + ", snapshot:" + str2);
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ePublishCancelUpload()).setTraceId(g16.getTraceId()).setExt1(str).setAttachInfo(str2));
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private void i() {
        QCircleCustomDialog qCircleCustomDialog = this.D;
        if (qCircleCustomDialog != null && qCircleCustomDialog.isShowing()) {
            try {
                this.D.dismiss();
            } catch (Exception e16) {
                QLog.e("WinkPublish-Progress-QFSBoxProgress", 1, e16, new Object[0]);
            }
        }
    }

    private boolean m(TaskInfo taskInfo) {
        if (taskInfo == null || taskInfo.getTransParams() == null || !TextUtils.equals("layer_publish_template", taskInfo.getTransParams().getString("publish_source_type"))) {
            return false;
        }
        return true;
    }

    private boolean n(TaskInfo taskInfo) {
        Bundle transParams;
        if (taskInfo.isImageTask() || (transParams = taskInfo.getTransParams()) == null) {
            return false;
        }
        return transParams.getBoolean("key_publish_use_hd_upload");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(LoadState loadState) {
        if (loadState == LoadState.STATE_SUCCESS) {
            this.f87323h = true;
        }
    }

    private boolean p() {
        Bundle transParams = this.E.getTransParams();
        if (transParams == null) {
            return true;
        }
        return transParams.getBoolean(QQWinkConstants.NEED_SAVE_TO_DRAFT_BOX, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16) {
        int i3;
        ImageView imageView = this.f87322f;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    private void r(String str) {
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "setLocalCover, localCoverUrl: " + str + ", isCoverShow: " + this.f87323h);
        if (!this.f87323h && !TextUtils.isEmpty(str)) {
            com.tencent.biz.qqcircle.utils.j.c(this.f87320d, str, 105.0f, 105.0f, new j.b() { // from class: com.tencent.biz.qqcircle.immersive.part.as
                @Override // com.tencent.biz.qqcircle.utils.j.b
                public final void a(LoadState loadState) {
                    QFSBoxProgress.this.o(loadState);
                }
            });
        }
    }

    private void s(String str) {
        if (this.f87320d != null && !TextUtils.isEmpty(str)) {
            this.f87320d.setShowTips(str);
            this.f87320d.requestLayout();
        }
    }

    private void u() {
        int i3;
        if (p()) {
            i3 = R.string.f193954al;
        } else {
            i3 = R.string.f193964am;
        }
        if (this.E.isVideoComment()) {
            i3 = R.string.f193984ao;
        }
        Context context = this.C;
        QCircleCustomDialog S = QCircleCustomDialog.S(context, null, context.getString(i3), R.string.cancel, R.string.f188503wv, new a(), new b());
        this.D = S;
        try {
            S.show();
        } catch (Exception e16) {
            QLog.e("WinkPublish-Progress-QFSBoxProgress", 1, e16, new Object[0]);
        }
    }

    private String v(TaskInfo taskInfo, boolean z16) {
        if (taskInfo.isNetworkWaiting()) {
            QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "handleTaskStateChange, network waiting ");
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f193924ai);
        }
        if (taskInfo.isImageTask()) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f193974an);
        }
        if (m(taskInfo)) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f193894af);
        }
        if (n(taskInfo)) {
            if (z16) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.f193914ah);
            }
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f193904ag);
        }
        if (z16) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f194004aq);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f193994ap);
    }

    public void destroy() {
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "hide");
        RFWThreadManager.getUIHandler().removeCallbacks(this.f87324i);
        RFWThreadManager.getUIHandler().removeCallbacks(this.F);
        i();
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).clear();
    }

    public void f() {
        RFWThreadManager.getUIHandler().postDelayed(this.F, G);
    }

    public void j(TaskInfo taskInfo) {
        boolean z16;
        this.E = taskInfo;
        if (taskInfo.getUploadProgress() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        s(v(taskInfo, z16));
    }

    public void k(TaskInfo taskInfo) {
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "handleTaskStateChange, taskId:" + taskInfo.getTaskId() + ", state:" + taskInfo.getState());
        if (taskInfo.isActive()) {
            t(taskInfo);
            if (!taskInfo.isNetworkWaiting()) {
                int exportProgress = taskInfo.getExportProgress();
                int uploadProgress = taskInfo.getUploadProgress();
                int i3 = 100;
                if (exportProgress != 100 || uploadProgress != 100) {
                    RFWThreadManager.getUIHandler().postDelayed(this.f87324i, 200L);
                    i3 = 0;
                }
                this.f87320d.setProgress(i3);
                return;
            }
            RFWThreadManager.getUIHandler().removeCallbacks(this.f87324i);
            return;
        }
        if (com.tencent.biz.qqcircle.widgets.p.d(taskInfo)) {
            destroy();
        }
    }

    public void l(Context context, au auVar) {
        this.f87325m = auVar;
        this.C = context;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.gp6, (ViewGroup) null);
        this.f87321e = frameLayout;
        this.f87320d = (QFSRoundProgressView) frameLayout.findViewById(R.id.f52312_g);
        this.f87322f = (ImageView) this.f87321e.findViewById(R.id.f350310r);
        this.f87320d.setOnClickListener(this);
        this.f87322f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f350310r || view.getId() == R.id.f52312_g) {
            u();
            au.C9(this.f87321e, "dt_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void t(TaskInfo taskInfo) {
        boolean z16 = true;
        QLog.d("WinkPublish-Progress-QFSBoxProgress", 1, "show, task: " + taskInfo);
        r(taskInfo.getCoverUrl());
        if (taskInfo.getUploadProgress() <= 0) {
            z16 = false;
        }
        s(v(taskInfo, z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
