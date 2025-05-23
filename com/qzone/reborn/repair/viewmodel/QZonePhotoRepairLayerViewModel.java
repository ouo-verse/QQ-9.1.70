package com.qzone.reborn.repair.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.request.QZoneQueryPermissionsRequest;
import com.qzone.reborn.repair.request.QZoneRepairGetShareArkRequest;
import com.qzone.reborn.repair.request.QZoneRepairLeavePageRequest;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$GetShareArkRsp;
import qzone.SuperResolution$LeavePageRsp;
import qzone.SuperResolution$QueryPermissionsRsp;
import qzone.SuperResolution$QueryStatusRsp;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020\u0005H\u0014R\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u0016R(\u00105\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002060-8\u0006\u00a2\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00102R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:0-8\u0006\u00a2\u0006\f\n\u0004\b;\u00100\u001a\u0004\b<\u00102\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "Luk/a;", "Lxn/d;", "Lqzone/SuperResolution$QueryStatusRsp;", "rsp", "", ICustomDataEditor.STRING_PARAM_2, "j2", "", "v2", "Landroid/os/Bundle;", "bundle", "y2", "Landroid/content/Context;", "context", "i2", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "B3", "", "status", Constants.BASE_IN_PLUGIN_VERSION, "(Ljava/lang/Integer;)V", "t2", "Lcom/qzone/preview/service/QZoneAlbumRequestBuilder;", "builder", "Z1", "E2", "z2", "p2", "w2", "onCleared", "D", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "k2", "()Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "C2", "(Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;)V", "currentTaskBean", "E", "Ljava/lang/Integer;", "l2", "()Ljava/lang/Integer;", "setInitSrStatus", "initSrStatus", "Landroidx/lifecycle/MutableLiveData;", "Lqzone/SuperResolution$QueryPermissionsRsp;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "m2", "()Landroidx/lifecycle/MutableLiveData;", "setPermissionRspData", "(Landroidx/lifecycle/MutableLiveData;)V", "permissionRspData", "", "G", "o2", "shareArkData", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel$a$a;", "H", ICustomDataEditor.NUMBER_PARAM_2, "repairStatusLiveData", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerViewModel extends uk.a implements xn.d {

    /* renamed from: D, reason: from kotlin metadata */
    public QZoneRepairTaskStateBean currentTaskBean;

    /* renamed from: E, reason: from kotlin metadata */
    private Integer initSrStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<SuperResolution$QueryPermissionsRsp> permissionRspData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<String> shareArkData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Companion.RepairStatusData> repairStatusLiveData = new MutableLiveData<>();

    public QZonePhotoRepairLayerViewModel() {
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().I(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(final QZonePhotoRepairLayerViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, final SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBBoolField pBBoolField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String traceId = baseRequest.getTraceId();
        String str2 = null;
        Boolean valueOf = (superResolution$QueryPermissionsRsp == null || (pBBoolField = superResolution$QueryPermissionsRsp.enable_sr) == null) ? null : Boolean.valueOf(pBBoolField.get());
        String str3 = (superResolution$QueryPermissionsRsp == null || (pBStringField3 = superResolution$QueryPermissionsRsp.pp_button_hint) == null) ? null : pBStringField3.get();
        String str4 = (superResolution$QueryPermissionsRsp == null || (pBStringField2 = superResolution$QueryPermissionsRsp.pp_bottom_hint1) == null) ? null : pBStringField2.get();
        if (superResolution$QueryPermissionsRsp != null && (pBStringField = superResolution$QueryPermissionsRsp.pp_bottom_hint2) != null) {
            str2 = pBStringField.get();
        }
        QLog.i("QZonePhotoRepairLayerViewModel", 1, "queryPermissionRequest | traceId=" + traceId + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp.enable_sr=" + valueOf + " | rsp.pp_button_hint=" + str3 + " | rsp.pp_bottom_hint1=" + str4 + " | rsp.pp_bottom_hint2=" + str2);
        if (z16 && j3 == 0 && superResolution$QueryPermissionsRsp != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.viewmodel.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairLayerViewModel.B2(QZonePhotoRepairLayerViewModel.this, superResolution$QueryPermissionsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(QZonePhotoRepairLayerViewModel this$0, SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.permissionRspData.postValue(superResolution$QueryPermissionsRsp);
    }

    private final void j2() {
        QLog.i("QZonePhotoRepairLayerViewModel", 1, "doOprSilentRepair, taskBean=" + k2());
        k2().setSilentRepair(true);
        D2(0);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().O(k2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(final QZonePhotoRepairLayerViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, final SuperResolution$GetShareArkRsp superResolution$GetShareArkRsp) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZonePhotoRepairLayerViewModel", 1, "getShareArkRequest | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp.ark=" + ((superResolution$GetShareArkRsp == null || (pBStringField = superResolution$GetShareArkRsp.ark) == null) ? null : pBStringField.get()));
        if (z16 && j3 == 0 && superResolution$GetShareArkRsp != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.viewmodel.e
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairLayerViewModel.r2(QZonePhotoRepairLayerViewModel.this, superResolution$GetShareArkRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(QZonePhotoRepairLayerViewModel this$0, SuperResolution$GetShareArkRsp superResolution$GetShareArkRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareArkData.postValue(superResolution$GetShareArkRsp.ark.get());
    }

    private final boolean v2() {
        Integer srStatus = k2().getSrStatus();
        if (srStatus == null || srStatus.intValue() != 1 || URLUtil.isNetworkUrl(k2().getSrUrl())) {
            return false;
        }
        if (Intrinsics.areEqual(k2().getIsNeedDoSRReq(), Boolean.TRUE)) {
            return true;
        }
        if (TextUtils.isEmpty(k2().getSrUrl()) || FileUtils.fileExists(k2().getSrUrl())) {
            return false;
        }
        QLog.w("QZonePhotoRepairLayerViewModel", 1, "[isNeedSilentRepair] file not exist, path=" + k2().getSrUrl());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(BaseRequest baseRequest, boolean z16, long j3, String str, SuperResolution$LeavePageRsp superResolution$LeavePageRsp) {
        QLog.i("QZonePhotoRepairLayerViewModel", 1, "leavePageRequest | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp=" + superResolution$LeavePageRsp);
    }

    @Override // xn.d
    public void B3(QZoneRepairTaskStateBean taskBean) {
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        if (TextUtils.equals(k2().getLloc(), taskBean.getLloc())) {
            QLog.d("QZonePhotoRepairLayerViewModel", 1, "[onStateChange] update current task = " + taskBean);
            D2(taskBean.getSrStatus());
            if (taskBean.getSrStatus() != null) {
                k2().setSrStatus(taskBean.getSrStatus());
            }
            if (!TextUtils.isEmpty(taskBean.getTaskId())) {
                k2().setTaskId(taskBean.getTaskId());
            }
            if (TextUtils.isEmpty(taskBean.getSrUrl())) {
                return;
            }
            k2().setSrUrl(taskBean.getSrUrl());
        }
    }

    public final void C2(QZoneRepairTaskStateBean qZoneRepairTaskStateBean) {
        Intrinsics.checkNotNullParameter(qZoneRepairTaskStateBean, "<set-?>");
        this.currentTaskBean = qZoneRepairTaskStateBean;
    }

    public final void D2(Integer status) {
        QLog.d("QZonePhotoRepairLayerViewModel", 1, "[setRepairStatus] repairStatus = " + status);
        this.repairStatusLiveData.postValue(new Companion.RepairStatusData(status, k2().getIsSilentRepair()));
    }

    @Override // uk.a
    public void Z1(QZoneAlbumRequestBuilder builder) {
        QZoneFeedxPictureManager.getInstance().getQZonePhotoListEx(builder, this);
    }

    public final void i2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        z2(context);
        QZonePhotoRepairTaskQueueManger.Companion companion = QZonePhotoRepairTaskQueueManger.INSTANCE;
        companion.a().Q(k2());
        if (!t2(k2())) {
            QZonePhotoRepairTaskQueueManger.G(companion.a(), k2().getTaskId(), new Function1<SuperResolution$QueryStatusRsp, Unit>() { // from class: com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel$checkRefreshData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SuperResolution$QueryStatusRsp superResolution$QueryStatusRsp) {
                    invoke2(superResolution$QueryStatusRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SuperResolution$QueryStatusRsp superResolution$QueryStatusRsp) {
                    QZonePhotoRepairLayerViewModel.this.s2(superResolution$QueryStatusRsp);
                }
            }, 0L, 4, null);
        }
        Integer srStatus = k2().getSrStatus();
        if (srStatus != null && srStatus.intValue() == 0 && Intrinsics.areEqual(k2().getIsNeedDoSRReq(), Boolean.TRUE)) {
            companion.a().O(k2());
        } else if (v2()) {
            j2();
        }
    }

    public final QZoneRepairTaskStateBean k2() {
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = this.currentTaskBean;
        if (qZoneRepairTaskStateBean != null) {
            return qZoneRepairTaskStateBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentTaskBean");
        return null;
    }

    /* renamed from: l2, reason: from getter */
    public final Integer getInitSrStatus() {
        return this.initSrStatus;
    }

    public final MutableLiveData<SuperResolution$QueryPermissionsRsp> m2() {
        return this.permissionRspData;
    }

    public final MutableLiveData<Companion.RepairStatusData> n2() {
        return this.repairStatusLiveData;
    }

    public final MutableLiveData<String> o2() {
        return this.shareArkData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().P(this);
    }

    public final void p2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!TextUtils.isEmpty(this.shareArkData.getValue())) {
            QLog.e("QZonePhotoRepairLayerViewModel", 1, "[getShareArkRequest] arkData:" + ((Object) this.shareArkData.getValue()));
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(context.hashCode(), new QZoneRepairGetShareArkRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.viewmodel.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZonePhotoRepairLayerViewModel.q2(QZonePhotoRepairLayerViewModel.this, baseRequest, z16, j3, str, (SuperResolution$GetShareArkRsp) obj);
            }
        });
    }

    public final void w2() {
        if (TextUtils.isEmpty(k2().getTaskId())) {
            QLog.e("QZonePhotoRepairLayerViewModel", 1, "[leavePageRequest] taskId: " + k2().getTaskId());
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QZoneRepairLeavePageRequest(k2().getTaskId()), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZonePhotoRepairLayerViewModel.x2(baseRequest, z16, j3, str, (SuperResolution$LeavePageRsp) obj);
            }
        });
    }

    public final void z2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        VSNetworkHelper.getInstance().sendRequest(context.hashCode(), new QZoneQueryPermissionsRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.viewmodel.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZonePhotoRepairLayerViewModel.A2(QZonePhotoRepairLayerViewModel.this, baseRequest, z16, j3, str, (SuperResolution$QueryPermissionsRsp) obj);
            }
        });
    }

    public final void E2() {
        D2(0);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().O(k2());
    }

    public final void y2(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PictureConst.KEY_INIT_BEAN)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PictureConst.KEY_INIT_BEAN);
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean");
        C2((QZoneRepairTaskStateBean) serializable);
        this.initSrStatus = k2().getSrStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(SuperResolution$QueryStatusRsp rsp) {
        if (rsp != null && rsp.status.get() == 1 && TextUtils.isEmpty(rsp.sr_url.get())) {
            j2();
        }
    }

    public static /* synthetic */ boolean u2(QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel, QZoneRepairTaskStateBean qZoneRepairTaskStateBean, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            qZoneRepairTaskStateBean = null;
        }
        return qZonePhotoRepairLayerViewModel.t2(qZoneRepairTaskStateBean);
    }

    public final boolean t2(QZoneRepairTaskStateBean taskBean) {
        Integer status;
        Integer status2;
        Integer srStatus;
        if (taskBean != null) {
            Integer srStatus2 = taskBean.getSrStatus();
            if ((srStatus2 == null || srStatus2.intValue() != 1) && ((srStatus = taskBean.getSrStatus()) == null || srStatus.intValue() != 2)) {
                return false;
            }
        } else {
            Companion.RepairStatusData value = this.repairStatusLiveData.getValue();
            if (!((value == null || (status2 = value.getStatus()) == null || status2.intValue() != 1) ? false : true)) {
                Companion.RepairStatusData value2 = this.repairStatusLiveData.getValue();
                if (!((value2 == null || (status = value2.getStatus()) == null || status.intValue() != 2) ? false : true)) {
                    return false;
                }
            }
        }
        return true;
    }
}
