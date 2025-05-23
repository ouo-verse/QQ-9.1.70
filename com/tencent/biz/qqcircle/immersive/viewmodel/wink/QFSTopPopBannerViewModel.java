package com.tencent.biz.qqcircle.immersive.viewmodel.wink;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.qqcircle.widgets.p;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import e40.QFSTopPopBannerData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class QFSTopPopBannerViewModel extends BaseViewModel {
    private long D;
    private String E;
    private boolean F;
    private String G;
    private boolean H;
    private long I;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<QFSTopPopBannerData> f90272i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<DraftBean> f90273m = new MutableLiveData<>();
    public final MutableLiveData<DraftBean> C = new MutableLiveData<>();
    private final CopyOnWriteArrayList<Long> J = new CopyOnWriteArrayList<>();
    private Selection K = Selection.DEFAULT;

    /* loaded from: classes4.dex */
    public enum Selection {
        RE_EDIT,
        SAVE_DRAFT,
        DEFAULT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f90279a;

        a(Context context) {
            this.f90279a = context;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            QLog.d("QFSTopPopBannerViewModel", 1, "getFeedDetail, isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            if (z16 && j3 == 0 && (feedCloudMeta$StFeed = feedCloudRead$StGetFeedDetailRsp.feed) != null) {
                QFSTopPopBannerViewModel.this.T1(this.f90279a, feedCloudMeta$StFeed);
                com.tencent.biz.qqcircle.manager.d.b().g(true, feedCloudRead$StGetFeedDetailRsp.feed.f398449id.get());
            }
        }
    }

    private void Q1(Context context) {
        sendRequest(new QFSGetFeedDetailRequest(this.G, true), new a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setSingleFeed(true);
        qCircleLayerBean.setSourceType(59);
        com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean);
    }

    private void U1(DraftBean draftBean) {
        if (draftBean == null) {
            QLog.e("QFSTopPopBannerViewModel", 1, "handleBeforeUploadStatus, lastDraft is null.");
        } else if (b2(draftBean.getOriginPath())) {
            QLog.w("QFSTopPopBannerViewModel", 1, "handleBeforeUploadStatus, original file has deleted ");
        } else {
            this.f90273m.postValue(draftBean);
            WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.T_CATCH_IMPORTANT_INFO).ext1(QCirclePublishQualityReporter.Scene.SCENE_KILL_PROCESS_IN_EDITOR).ext2(draftBean.getMissionId()).retCode("0").getReportData(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        DraftBean draftBean;
        try {
            draftBean = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin());
        } catch (Throwable th5) {
            QLog.w("QFSTopPopBannerViewModel", 1, "handleRestoreDraft, error ", th5);
            draftBean = null;
        }
        if (draftBean == null) {
            QLog.d("QFSTopPopBannerViewModel", 1, "handleRestoreDraft, lastDraft is null ");
            return;
        }
        QLog.d("QFSTopPopBannerViewModel", 1, "handleRestoreDraft, lastDraft: " + draftBean);
        if (draftBean.getUploadStatus() != 5) {
            List<DraftBean> dataByUploadStatusSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getDataByUploadStatusSync(HostDataTransUtils.getLongAccountUin(), 1, 2);
            QLog.d("QFSTopPopBannerViewModel", 1, "handleRestoreDraft, draftBeanList: " + dataByUploadStatusSync);
            if (dataByUploadStatusSync != null && !dataByUploadStatusSync.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (DraftBean draftBean2 : dataByUploadStatusSync) {
                    if (!b2(draftBean2.getOriginPath())) {
                        winkPublishServiceProxy2.resumeTaskWithId(draftBean2.getTaskId());
                        arrayList.add(draftBean2.getMissionId());
                        arrayList2.add(Long.valueOf(draftBean2.getTaskId()));
                    }
                }
                if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
                    WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_AUTO_RECOVER_PUBLISH).ext1(arrayList.toString()).ext2(arrayList2.toString()).getReportData(), 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(Context context) {
        DraftBean draftBean;
        try {
            draftBean = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin());
        } catch (Throwable th5) {
            QLog.w("QFSTopPopBannerViewModel", 1, "handleShowPopupWindow, error ", th5);
            draftBean = null;
        }
        if (draftBean == null) {
            QLog.d("QFSTopPopBannerViewModel", 1, "handleShowPopupWindow, lastDraft is null ");
            return;
        }
        QLog.d("QFSTopPopBannerViewModel", 1, "handleShowPopupWindow, lastDraft: " + draftBean);
        if (a2(draftBean, context)) {
            U1(draftBean);
        }
    }

    public static boolean a2(DraftBean draftBean, Context context) {
        int uploadStatus = draftBean.getUploadStatus();
        boolean M6 = uq3.c.M6();
        if (b80.e.b() || b80.e.a()) {
            M6 = true;
        }
        String decodeString = QMMKV.from(context, QMMKVFile.FILE_QCIRCLE).decodeString("has_show_popup_window", "default_mission_id");
        QLog.i("QFSTopPopBannerViewModel", 1, "publishContent.mUploadStatus:" + uploadStatus + " mainTabEntrance:" + M6 + " lastMissionId:" + decodeString + " lastDraft:" + draftBean.getMissionId());
        if ((uploadStatus == 5 || uploadStatus == 3) && M6 && !decodeString.equals(draftBean.getMissionId())) {
            return true;
        }
        return false;
    }

    private boolean b2(List<String> list) {
        boolean z16;
        QLog.d("QFSTopPopBannerViewModel", 1, "isOriginalFileDeleted, originPathList: " + list);
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                z16 = true;
                break;
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        QLog.w("QFSTopPopBannerViewModel", 1, "isOriginalFileDeleted, has file deleted ");
        return true;
    }

    private void d2() {
        QLog.d("QFSTopPopBannerViewModel", 1, "retryPublish, mTaskId: " + this.D + ", mMissionId: " + this.E);
        if (this.D != -1 && !TextUtils.isEmpty(this.E)) {
            WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
            if (qfsService == null) {
                QLog.w("QFSTopPopBannerViewModel", 1, "retryPublish, invalid service");
                return;
            }
            qfsService.resumeTaskWithId(this.D);
            i2(this.E, 0);
            WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_RETRY_PUBLISH).getReportData(), 1);
        }
    }

    public static void g2(DraftBean draftBean, Context context) {
        QMMKV.from(context, QMMKVFile.FILE_QCIRCLE).encodeString("has_show_popup_window", draftBean.getMissionId());
    }

    public void O1(long j3) {
        this.J.add(Long.valueOf(j3));
    }

    public void P1(final boolean z16, final Context context) {
        WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel.2
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public void onServiceConnected(@NotNull final WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                QLog.d("QFSTopPopBannerViewModel", 1, "checkExceptionMission, onServiceConnected, service: " + winkPublishServiceProxy2);
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!winkPublishServiceProxy2.getRunningTasks().isEmpty()) {
                            QLog.w("QFSTopPopBannerViewModel", 1, "checkExceptionMission, has task running ");
                            return;
                        }
                        try {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z16) {
                                QFSTopPopBannerViewModel.this.X1(winkPublishServiceProxy2);
                            } else {
                                QFSTopPopBannerViewModel.this.Z1(context);
                            }
                        } catch (Exception e16) {
                            QLog.e("QFSTopPopBannerViewModel", 1, "handleExceptionMission, error ", e16);
                        }
                    }
                });
            }
        });
    }

    public LiveData<QFSTopPopBannerData> R1() {
        return this.f90272i;
    }

    public LiveData<DraftBean> S1() {
        return this.f90273m;
    }

    public void W1(TaskInfo taskInfo) {
        boolean z16;
        this.D = taskInfo.getTaskId();
        this.E = p.b(taskInfo);
        this.F = taskInfo.isSuccess();
        this.G = taskInfo.getFeedId();
        this.I = taskInfo.getFeedTime();
        this.H = r.Y(taskInfo.getTransParams());
        if (this.J.contains(Long.valueOf(taskInfo.getTaskId()))) {
            this.J.remove(Long.valueOf(taskInfo.getTaskId()));
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && c60.a.f30394a.a()) {
            Bundle transParams = taskInfo.getTransParams();
            if (transParams == null) {
                transParams = new Bundle();
            }
            transParams.putBoolean(QQWinkConstants.NEED_SHOW_SAVE_DRAFT_DIALOG, true);
            transParams.putInt(QQWinkConstants.NEED_SELECT_WHICH, this.K.ordinal());
            Selection selection = this.K;
            if (selection == Selection.RE_EDIT || selection == Selection.SAVE_DRAFT) {
                ((IWinkDraft) QRoute.api(IWinkDraft.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), this.E, 0);
            }
        }
        this.f90272i.postValue(new QFSTopPopBannerData(this.F, taskInfo.getCoverUrl(), z16, taskInfo.getTransParams(), taskInfo.getErrCode(), taskInfo.getErrMsg()));
    }

    public void c2(DraftBean draftBean) {
        this.C.postValue(draftBean);
    }

    public void e2() {
        QLog.d("QFSTopPopBannerViewModel", 1, "retryPublishIfNeed, mIsSuccess: " + this.F);
        if (!this.F) {
            d2();
        }
    }

    public QFSTopPopBannerViewModel f2(Selection selection) {
        this.K = selection;
        return this;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTopPopBannerViewModel";
    }

    public boolean h2(Context context) {
        QLog.d("QFSTopPopBannerViewModel", 1, "tryLaunchContentLayerPage, mIsSuccess: " + this.F + ", mFeedId: " + this.G);
        if (TextUtils.isEmpty(this.G)) {
            return false;
        }
        if (this.H) {
            return true;
        }
        if (this.F) {
            Q1(context);
        }
        return this.F;
    }

    public void i2(String str, int i3) {
        ((IWinkDraft) QRoute.api(IWinkDraft.class)).updateToastStatus(HostDataTransUtils.getLongAccountUin(), str, i3);
    }

    public void j2(String str, int i3) {
        ((IWinkDraft) QRoute.api(IWinkDraft.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), str, i3);
    }
}
