package com.tencent.mobileqq.winkpublish.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.IPublishApi;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.Outbox;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0014H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/impl/PublishApiImpl;", "Lcom/tencent/mobileqq/winkpublish/api/IPublishApi;", "Landroid/os/Bundle;", "params", "", "addTask", "addExportTask", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "listener", "", "businessType", "addTaskListener", "addTaskListenerStrong", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lkotlin/Function0;", "resumeFailed", "resumeTaskWithId", "removeTaskListener", "cancelTaskWithId", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "addTaskR", "<init>", "()V", "Companion", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PublishApiImpl implements IPublishApi {
    private static final String TAG = "PublishApiImpl";

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void addExportTask(Bundle params) {
        try {
            WinkExportTask winkExportTask = (WinkExportTask) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(QQWinkConstants.MMKV_QCIRCLE_EXPORT_TASK, WinkExportTask.class, null);
            if (winkExportTask != null) {
                ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTaskToMain(winkExportTask);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void addTask(Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            WinkPublishParams winkPublishParams = (WinkPublishParams) QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeParcelable(QQWinkConstants.MMKV_QCIRLE_PUBLISH_TASK, WinkPublishParams.class, null);
            if (winkPublishParams != null) {
                Outbox.f327227d.c(winkPublishParams);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void addTaskListener(ITaskListener listener, int businessType) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Outbox.f327227d.d(businessType, listener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void addTaskListenerStrong(int businessType, ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Outbox.f327227d.e(businessType, listener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public TaskInfo addTaskR(WinkPublishParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return Outbox.f327227d.c(params);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void cancelTaskWithId(int businessType, long taskId) {
        Outbox.f327227d.f(businessType, taskId);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void removeTaskListener(int businessType, ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Outbox.f327227d.j(businessType, listener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IPublishApi
    public void resumeTaskWithId(int businessType, long taskId, Function0<Unit> resumeFailed) {
        Intrinsics.checkNotNullParameter(resumeFailed, "resumeFailed");
        Outbox.f327227d.l(businessType, taskId, resumeFailed);
    }
}
