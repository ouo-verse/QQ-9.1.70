package com.qzone.reborn.repair.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.request.QZoneRepairQueryTasksRequest;
import com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper;
import com.tencent.mobileqq.opr.helper.repair.model.ImageInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$QueryTasksRsp;
import qzone.SuperResolution$SRTask;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R4\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001e0'0&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/repair/viewmodel/i;", "Lcom/qzone/reborn/base/n;", "Lxn/d;", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/SuperResolution$QueryTasksRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "S1", "", "Lwn/d;", "P1", "Z1", "getLogTag", "Landroid/content/Context;", "context", "U1", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "B3", "L1", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "i", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "Q1", "()Ljava/util/List;", "setAllTaskList", "(Ljava/util/List;)V", "allTaskList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "setTaskListLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "taskListLiveData", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends n implements xn.d {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<wn.d> allTaskList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<wn.d>>> taskListLiveData = new MutableLiveData<>();

    public i() {
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().I(this);
    }

    private final void P1(List<wn.d> list) {
        QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM = QZonePhotoRepairQNESingletonVM.f59266a;
        if (!qZonePhotoRepairQNESingletonVM.k()) {
            QLog.e("QZonePhotoRepairTaskListViewModel", 1, "[fillSrUrlIfNeed] not support opr");
            return;
        }
        qZonePhotoRepairQNESingletonVM.i();
        for (wn.d dVar : list) {
            if (dVar.getRsTask().status.get() == 1) {
                String str = dVar.getRsTask().sr_url.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.rsTask.sr_url.get()");
                boolean z16 = false;
                if (str.length() == 0) {
                    QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
                    String str2 = dVar.getRsTask().task_id.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "it.rsTask.task_id.get()");
                    qZoneRepairTaskStateBean.setTaskId(str2);
                    String str3 = dVar.getRsTask().album_id.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.rsTask.album_id.get()");
                    qZoneRepairTaskStateBean.setAlbumId(str3);
                    String str4 = dVar.getRsTask().lloc.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.rsTask.lloc.get()");
                    qZoneRepairTaskStateBean.setLloc(str4);
                    String str5 = dVar.getRsTask().src_url.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "it.rsTask.src_url.get()");
                    qZoneRepairTaskStateBean.setSrOriginUrl(str5);
                    QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM2 = QZonePhotoRepairQNESingletonVM.f59266a;
                    OldPhotoRepairHelper g16 = qZonePhotoRepairQNESingletonVM2.g();
                    String n3 = g16 != null ? g16.n(qZonePhotoRepairQNESingletonVM2.l(new ImageInfo(qZoneRepairTaskStateBean.getAlbumId(), qZoneRepairTaskStateBean.getLloc(), qZoneRepairTaskStateBean.getSrOriginUrl(), "", null, 16, null))) : null;
                    QLog.i("QZonePhotoRepairTaskListViewModel", 1, "[fillSrUrlIfNeed] hit local cache, taskBean=" + qZoneRepairTaskStateBean + ", localPath=" + n3);
                    if (n3 != null) {
                        if (n3.length() > 0) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        dVar.getRsTask().sr_url.set(n3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIStateData<List<wn.d>> value = this$0.taskListLiveData.getValue();
        if (value != null) {
            value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        }
        MutableLiveData<UIStateData<List<wn.d>>> mutableLiveData = this$0.taskListLiveData;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(final i this$0, final boolean z16, BaseRequest baseRequest, final boolean z17, final long j3, final String str, final SuperResolution$QueryTasksRsp superResolution$QueryTasksRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "queryRecentTaskListRequest  | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z17 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp=" + superResolution$QueryTasksRsp + " | isLoadMore=" + z16);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.viewmodel.g
            @Override // java.lang.Runnable
            public final void run() {
                i.X1(i.this, z17, j3, str, superResolution$QueryTasksRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(i this$0, boolean z16, long j3, String errMsg, SuperResolution$QueryTasksRsp superResolution$QueryTasksRsp, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.S1(z16, j3, errMsg, superResolution$QueryTasksRsp, z17);
    }

    private final void Z1() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    @Override // xn.d
    public void B3(QZoneRepairTaskStateBean taskBean) {
        List<wn.d> data;
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        if (!TextUtils.isEmpty(taskBean.getTaskId()) && taskBean.getSrStatus() != null) {
            UIStateData<List<wn.d>> value = this.taskListLiveData.getValue();
            if (value == null || (data = value.getData()) == null) {
                return;
            }
            for (wn.d dVar : data) {
                if (Intrinsics.areEqual(dVar.getRsTask().task_id.get(), taskBean.getTaskId())) {
                    int i3 = dVar.getRsTask().status.get();
                    Integer srStatus = taskBean.getSrStatus();
                    if (srStatus == null || i3 != srStatus.intValue()) {
                        if (!TextUtils.isEmpty(taskBean.getSrUrl())) {
                            dVar.getRsTask().sr_url.set(taskBean.getSrUrl());
                        }
                        PBEnumField pBEnumField = dVar.getRsTask().status;
                        Integer srStatus2 = taskBean.getSrStatus();
                        Intrinsics.checkNotNull(srStatus2);
                        pBEnumField.set(srStatus2.intValue());
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.viewmodel.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                i.T1(i.this);
                            }
                        });
                    }
                }
            }
            return;
        }
        QLog.e("QZonePhotoRepairTaskListViewModel", 1, "[onStateChange] taskId" + taskBean.getTaskId() + ",status" + taskBean.getSrStatus());
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        super.L1();
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().P(this);
    }

    public final List<wn.d> Q1() {
        return this.allTaskList;
    }

    public final MutableLiveData<UIStateData<List<wn.d>>> R1() {
        return this.taskListLiveData;
    }

    public final void U1(Context context, final boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isLoadMore) {
            Z1();
        }
        QLog.d(getTAG(), 1, "queryRecentTaskListRequest  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore);
        if (this.loadInfo.getCurrentState() != 4) {
            QLog.w(getTAG(), 1, "requestAlbumList  mLoadInfo.currentState = " + this.loadInfo.getCurrentState());
            return;
        }
        this.loadInfo.setCurrentState(2);
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        if (stringAttachInfo == null) {
            stringAttachInfo = "";
        }
        sendRequest(context, new QZoneRepairQueryTasksRequest(stringAttachInfo), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.viewmodel.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                i.W1(i.this, isLoadMore, baseRequest, z16, j3, str, (SuperResolution$QueryTasksRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePhotoRepairTaskListViewModel";
    }

    private final void S1(boolean isSuccess, long retCode, String errMsg, SuperResolution$QueryTasksRsp rsp, boolean isLoadMore) {
        if (isSuccess && retCode == 0 && rsp != null) {
            this.loadInfo.setStringAttachInfo(rsp.attach_info.get());
            if (!isLoadMore) {
                this.allTaskList.clear();
            }
            ArrayList arrayList = new ArrayList();
            for (SuperResolution$SRTask item : rsp.tasks.get()) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                arrayList.add(new wn.d(item));
            }
            P1(arrayList);
            this.allTaskList.addAll(arrayList);
            QLog.d(getTAG(), 1, "[handleTaskListResponse]  | attachInfo: " + rsp.attach_info.get() + " | hasMore: " + rsp.has_more.get() + " | rsp.tasks.size: " + rsp.tasks.get().size() + " | allTaskList.size: " + this.allTaskList.size());
            if (bl.b(this.allTaskList)) {
                this.taskListLiveData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore).setFinish(true));
                return;
            } else {
                this.loadInfo.setFinish(!rsp.has_more.get());
                this.taskListLiveData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.allTaskList).setFinish(this.loadInfo.isFinish()));
                return;
            }
        }
        this.taskListLiveData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(isLoadMore).setFinish(true));
    }
}
