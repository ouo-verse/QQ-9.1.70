package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.os.RemoteException;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$SetProfileRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/b;", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqqcircle/QQCircleProfile$SetProfileRsp;", "callBack", "", HippyTKDListViewAdapter.X, "onTaskChange", "Li83/a;", "d", "Li83/a;", "getAvatarContext", "()Li83/a;", "Z", "(Li83/a;)V", "avatarContext", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends ITaskListener.Stub {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i83.a avatarContext;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(b this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && j3 == 0) {
            QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChangeSuccessOnAvatar success ... ");
            QCircleToast.v(QCircleToast.f91646f, "\u5934\u50cf\u66f4\u6362\u6210\u529f", 0);
            i83.a aVar = this$0.avatarContext;
            if (aVar != null) {
                aVar.X5(true, null);
                return;
            }
            return;
        }
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChangeSuccessOnAvatar failed ... = " + j3);
        if (uq3.l.b().a(j3)) {
            QCircleToast.v(QCircleToast.f91645e, str, 0);
        } else {
            QCircleToast.v(QCircleToast.f91645e, "\u8bf7\u6c42\u5931\u8d25, \u5934\u50cf\u66f4\u6362\u5931\u8d25", 0);
        }
        QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CHANGE_FAIL, "ev_xsj_abnormal_imp");
        i83.a aVar2 = this$0.avatarContext;
        if (aVar2 != null) {
            aVar2.X5(false, new Exception(String.valueOf(j3)));
        }
    }

    private final void x(TaskInfo taskInfo, VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> callBack) {
        MediaUploadResult uploadResult = taskInfo.getMediaInfos().get(0).getUploadResult();
        Intrinsics.checkNotNull(uploadResult, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.result.ImageResult");
        String originUrl = ((ImageResult) uploadResult).getOriginUrl();
        QFSPersonalEditViewModel.FrequencyItem frequencyItem = new QFSPersonalEditViewModel.FrequencyItem(originUrl);
        frequencyItem.allowNum = uq3.k.a().e("magic_avatar_allow_num", 0);
        frequencyItem.totalNum = uq3.k.a().e("magic_avatar_total_num", 0);
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChangeSuccessOnAvatar... avatarUrl:" + originUrl + " item:" + frequencyItem);
        frequencyItem.showText = originUrl;
        QFSPersonalEditViewModel.f2(10025, frequencyItem, callBack);
    }

    public final void Z(@Nullable i83.a aVar) {
        this.avatarContext = aVar;
    }

    @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
    public void onTaskChange(@NotNull TaskInfo taskInfo) throws RemoteException {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChange..." + taskInfo.getTaskId() + "\uff0c" + taskInfo.isFinish() + ", " + (!taskInfo.getMediaInfos().isEmpty()) + ", " + (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult));
        if (taskInfo.isFinish() && (!taskInfo.getMediaInfos().isEmpty()) && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
            QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChange...onTaskChangeSuccessOnAvatar");
            WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(3);
            if (service != null) {
                service.removeTaskListener(this);
            }
            x(taskInfo, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    b.v(b.this, baseRequest, z16, j3, str, (QQCircleProfile$SetProfileRsp) obj);
                }
            });
            return;
        }
        if (taskInfo.isCancelled()) {
            QLog.d("QCircleMagicAvatarModifyDelegate", 1, "onTaskChange isCancelled...");
            WinkPublishServiceProxy2 service2 = WinkPublishHelper2.INSTANCE.getService(3);
            if (service2 != null) {
                service2.removeTaskListener(this);
            }
            QCircleToast.v(QCircleToast.f91645e, "\u4efb\u52a1\u53d6\u6d88\uff0c\u5934\u50cf\u66f4\u6362\u5931\u8d25", 0);
            QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CHANGE_FAIL, "ev_xsj_abnormal_imp");
            i83.a aVar = this.avatarContext;
            if (aVar != null) {
                aVar.X5(false, new Exception("cancel"));
            }
        }
    }
}
