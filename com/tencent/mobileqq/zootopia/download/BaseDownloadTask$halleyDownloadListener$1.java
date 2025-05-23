package com.tencent.mobileqq.zootopia.download;

import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/zootopia/download/BaseDownloadTask$halleyDownloadListener$1", "Lcom/tencent/mobileqq/zootopia/download/b;", "", "errCode", "", "errMsg", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "", "d", "onTaskDetectedSubloop", "onTaskStartedSubloop", "onTaskReceivedSubloop", "onTaskPausedSubloop", "onTaskFailedMainloop", "onTaskFailedSubloop", "onTaskCompletedMainloop", "onTaskCompletedSubloop", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BaseDownloadTask$halleyDownloadListener$1 extends b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseDownloadTask f327977d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseDownloadTask$halleyDownloadListener$1(BaseDownloadTask baseDownloadTask) {
        this.f327977d = baseDownloadTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int errCode, String errMsg, DownloaderTask task) {
        this.f327977d.N(errCode);
        this.f327977d.downloadFailInfo = errMsg;
        BaseDownloadTask baseDownloadTask = this.f327977d;
        baseDownloadTask.O(ZPlanFileDownloadResult.INSTANCE.b(baseDownloadTask, task));
        CopyOnWriteArrayList<y> F = this.f327977d.F();
        BaseDownloadTask baseDownloadTask2 = this.f327977d;
        Iterator<T> it = F.iterator();
        while (it.hasNext()) {
            ((y) it.next()).h(errCode, baseDownloadTask2);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.b
    public void b(DownloaderTask task) {
        String str;
        str = this.f327977d.id;
        QLog.e("Zootopia_DownloadTask", 1, str + " customOnTaskDeletedSubLoop - " + this.f327977d);
        CopyOnWriteArrayList<y> F = this.f327977d.F();
        BaseDownloadTask baseDownloadTask = this.f327977d;
        Iterator<T> it = F.iterator();
        while (it.hasNext()) {
            ((y) it.next()).g(baseDownloadTask);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(final DownloaderTask task) {
        super.onTaskCompletedMainloop(task);
        v vVar = v.f328299a;
        final BaseDownloadTask baseDownloadTask = this.f327977d;
        vVar.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.BaseDownloadTask$halleyDownloadListener$1$onTaskCompletedMainloop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                ec3.a aVar;
                str = BaseDownloadTask.this.id;
                DownloaderTask downloaderTask = task;
                String taskUniqueKey = downloaderTask != null ? downloaderTask.getTaskUniqueKey() : null;
                DownloaderTask downloaderTask2 = task;
                QLog.i("Zootopia_DownloadTask", 1, str + " onTaskCompletedMainloop - " + taskUniqueKey + ", hasHttpHeader= " + ((downloaderTask2 != null ? downloaderTask2.getHttpRspHeaderMap() : null) != null));
                BaseDownloadTask.this.T(task);
                BaseDownloadTask baseDownloadTask2 = BaseDownloadTask.this;
                DownloaderTask downloaderTask3 = task;
                baseDownloadTask2.httpRspHeader = downloaderTask3 != null ? downloaderTask3.getHttpRspHeaderMap() : null;
                BaseDownloadTask baseDownloadTask3 = BaseDownloadTask.this;
                DownloaderTask downloaderTask4 = task;
                baseDownloadTask3.N(downloaderTask4 != null ? downloaderTask4.getRet() : 0);
                BaseDownloadTask baseDownloadTask4 = BaseDownloadTask.this;
                baseDownloadTask4.O(ZPlanFileDownloadResult.INSTANCE.b(baseDownloadTask4, task));
                BaseDownloadTask.this.M();
                DownloaderTask downloaderTask5 = task;
                if (downloaderTask5 != null) {
                    BaseDownloadTask baseDownloadTask5 = BaseDownloadTask.this;
                    aVar = baseDownloadTask5.reporter;
                    aVar.k(true, downloaderTask5, baseDownloadTask5.getIsUpdate(), baseDownloadTask5.getIsSilentDownload());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask task) {
        String str;
        this.f327977d.downloadCost = task != null ? task.getTotalCostTime() : 0L;
        str = this.f327977d.id;
        String taskUniqueKey = task != null ? task.getTaskUniqueKey() : null;
        BaseDownloadTask baseDownloadTask = this.f327977d;
        QLog.i("Zootopia_DownloadTask", 1, str + " SubLoop onDownloadComplete - " + taskUniqueKey + " - " + baseDownloadTask + " - taskStatus=" + baseDownloadTask.getTaskStatus());
        this.f327977d.R(5);
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask task) {
        String str;
        v vVar = v.f328299a;
        str = this.f327977d.filePath;
        long b16 = vVar.b(str);
        long totalLen = task != null ? task.getTotalLen() : 0L;
        this.f327977d.httpRspHeader = task != null ? task.getHttpRspHeaderMap() : null;
        QLog.i("Zootopia_DownloadTask", 1, "onTaskDetected available size " + b16 + " fileSize " + totalLen);
        CopyOnWriteArrayList<y> F = this.f327977d.F();
        BaseDownloadTask baseDownloadTask = this.f327977d;
        Iterator<T> it = F.iterator();
        while (it.hasNext()) {
            ((y) it.next()).i(totalLen, baseDownloadTask);
        }
        if (totalLen > b16) {
            HalleyDownloader halleyDownloader = HalleyDownloader.f327980a;
            String fileUrl = task != null ? task.getFileUrl() : null;
            if (fileUrl == null) {
                fileUrl = "";
            }
            halleyDownloader.d(fileUrl, true);
            d(-4, "no enough space", task);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskFailedMainloop(final DownloaderTask task) {
        super.onTaskFailedMainloop(task);
        v vVar = v.f328299a;
        final BaseDownloadTask baseDownloadTask = this.f327977d;
        vVar.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.BaseDownloadTask$halleyDownloadListener$1$onTaskFailedMainloop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                ec3.a aVar;
                str = BaseDownloadTask.this.id;
                DownloaderTask downloaderTask = task;
                Integer valueOf = downloaderTask != null ? Integer.valueOf(downloaderTask.getRet()) : null;
                DownloaderTask downloaderTask2 = task;
                String failInfoMsg = downloaderTask2 != null ? downloaderTask2.getFailInfoMsg() : null;
                DownloaderTask downloaderTask3 = task;
                String taskUniqueKey = downloaderTask3 != null ? downloaderTask3.getTaskUniqueKey() : null;
                QLog.e("Zootopia_DownloadTask", 1, str + " onError " + valueOf + " - " + failInfoMsg + " - " + taskUniqueKey + " - " + BaseDownloadTask.this);
                HalleyDownloader halleyDownloader = HalleyDownloader.f327980a;
                str2 = BaseDownloadTask.this.url;
                halleyDownloader.d(str2, false);
                BaseDownloadTask.this.R(6);
                BaseDownloadTask$halleyDownloadListener$1 baseDownloadTask$halleyDownloadListener$1 = this;
                DownloaderTask downloaderTask4 = task;
                int ret = downloaderTask4 != null ? downloaderTask4.getRet() : -1;
                DownloaderTask downloaderTask5 = task;
                String failInfoMsg2 = downloaderTask5 != null ? downloaderTask5.getFailInfoMsg() : null;
                if (failInfoMsg2 == null) {
                    failInfoMsg2 = "download failed";
                }
                baseDownloadTask$halleyDownloadListener$1.d(ret, failInfoMsg2, task);
                DownloaderTask downloaderTask6 = task;
                if (downloaderTask6 != null) {
                    BaseDownloadTask baseDownloadTask2 = BaseDownloadTask.this;
                    aVar = baseDownloadTask2.reporter;
                    aVar.k(false, downloaderTask6, baseDownloadTask2.getIsUpdate(), baseDownloadTask2.getIsSilentDownload());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask task) {
        String str;
        str = this.f327977d.id;
        Integer valueOf = task != null ? Integer.valueOf(task.getRet()) : null;
        String failInfoMsg = task != null ? task.getFailInfoMsg() : null;
        String taskUniqueKey = task != null ? task.getTaskUniqueKey() : null;
        QLog.e("Zootopia_DownloadTask", 1, str + " onError " + valueOf + " - " + failInfoMsg + " - " + taskUniqueKey + " - " + this.f327977d);
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask task) {
        String str;
        ec3.a aVar;
        str = this.f327977d.id;
        QLog.i("Zootopia_DownloadTask", 1, str + " onPauseCallBack - " + (task != null ? task.getTaskUniqueKey() : null));
        this.f327977d.downloadCost = task != null ? task.getTotalCostTime() : 0L;
        if (task != null) {
            BaseDownloadTask baseDownloadTask = this.f327977d;
            aVar = baseDownloadTask.reporter;
            aVar.l(task, baseDownloadTask.getIsUpdate());
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask task) {
        String str;
        ec3.a aVar;
        String str2;
        String str3;
        boolean z16;
        str = this.f327977d.id;
        String taskUniqueKey = task != null ? task.getTaskUniqueKey() : null;
        QLog.i("Zootopia_DownloadTask", 1, str + " onStart - " + taskUniqueKey + " - taskStatus= " + this.f327977d.getTaskStatus());
        this.f327977d.R(2);
        this.f327977d.T(task);
        CopyOnWriteArrayList<y> F = this.f327977d.F();
        BaseDownloadTask baseDownloadTask = this.f327977d;
        Iterator<T> it = F.iterator();
        while (it.hasNext()) {
            ((y) it.next()).b(baseDownloadTask);
        }
        if (task != null) {
            BaseDownloadTask baseDownloadTask2 = this.f327977d;
            aVar = baseDownloadTask2.reporter;
            str2 = baseDownloadTask2.url;
            str3 = baseDownloadTask2.id;
            String category = baseDownloadTask2.getCategory();
            String taskUniqueTraceKey = baseDownloadTask2.getTaskUniqueTraceKey();
            boolean isUpdate = baseDownloadTask2.getIsUpdate();
            z16 = baseDownloadTask2.isResumeStart;
            aVar.m(str2, str3, category, taskUniqueTraceKey, isUpdate, z16);
        }
        this.f327977d.isResumeStart = false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.b, com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask task) {
        float percentage;
        float f16;
        ec3.a aVar;
        float f17;
        if (task == null) {
            return;
        }
        this.f327977d.R(2);
        this.f327977d.T(task);
        BaseDownloadTask baseDownloadTask = this.f327977d;
        if (task.getTotalLen() != 0) {
            percentage = (float) task.getReceivedLen();
            f16 = (float) task.getTotalLen();
        } else {
            percentage = task.getPercentage();
            f16 = 100.0f;
        }
        baseDownloadTask.curProgress = percentage / f16;
        CopyOnWriteArrayList<y> F = this.f327977d.F();
        BaseDownloadTask baseDownloadTask2 = this.f327977d;
        for (y yVar : F) {
            f17 = baseDownloadTask2.curProgress;
            yVar.f(f17, baseDownloadTask2);
        }
        aVar = this.f327977d.reporter;
        aVar.o(task.getReceivedLen(), task.getTotalLen());
    }
}
