package com.tencent.mobileqq.winkpublish.service;

import android.os.RemoteException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.api.IWinkPublishService;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.Outbox;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkDcReporter;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.util.g;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
class b extends IWinkPublishService.Stub {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x() {
        com.tencent.mobileqq.winkpublish.outbox.db.a.c().b();
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void addExportTask(WinkExportTask winkExportTask) throws RemoteException {
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTaskToMain(winkExportTask);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public TaskInfo addTask(WinkPublishParams winkPublishParams) throws RemoteException {
        return Outbox.f327227d.c(winkPublishParams);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void addTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
        Outbox.f327227d.d(i3, iTaskListener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void addTaskListener2(ITaskListener iTaskListener, int i3) throws RemoteException {
        Outbox.f327227d.e(i3, iTaskListener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void cancelExportTask(String str) throws RemoteException {
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).cancelTaskToMain(str);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void cancelTaskWithId(long j3, int i3) throws RemoteException {
        Outbox.f327227d.f(i3, j3);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void dc5507Report(WinkDc5507ReportData winkDc5507ReportData, int i3) throws RemoteException {
        WinkDcReporter.f327381a.a(winkDc5507ReportData);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public List<TaskInfo> getRunningTasks(int i3) throws RemoteException {
        return Outbox.f327227d.g(i3);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public boolean hasRunningTask(int i3) throws RemoteException {
        return Outbox.f327227d.h(i3);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void init(int i3) throws RemoteException {
        g.c(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.service.a
            @Override // java.lang.Runnable
            public final void run() {
                b.x();
            }
        });
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void qualityReport(WinkPublishQualityReportData winkPublishQualityReportData, int i3) throws RemoteException {
        l a16 = l.INSTANCE.a(i3);
        a16.getReporter().a(a16, winkPublishQualityReportData);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void removeTaskListener(ITaskListener iTaskListener, int i3) throws RemoteException {
        Outbox.f327227d.j(i3, iTaskListener);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public void resumeTaskWithId(long j3, int i3) throws RemoteException {
        Outbox.f327227d.k(i3, j3);
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IWinkPublishService
    public boolean updateTaskWithId(long j3, WinkPublishParams winkPublishParams) throws RemoteException {
        return Outbox.f327227d.o(j3, winkPublishParams);
    }
}
