package com.tencent.mobileqq.zootopia.ipc.downloadprogress;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import gc3.a;
import gc3.c;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/downloadprogress/FileDownloadIPCImplForZplan;", "Lgc3/b;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "needProgressCallback", "Lgc3/c;", "callback", "", "bindFileDownloadProgress", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FileDownloadIPCImplForZplan implements gc3.b {
    private static final String TAG = "FileDownloadIPCImplForZplan";

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/ipc/downloadprogress/FileDownloadIPCImplForZplan$b", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "c", "", "code", h.F, "", "progress", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f328360b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f328361c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f328362d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z16, c cVar) {
            super(str);
            this.f328360b = str;
            this.f328361c = z16;
            this.f328362d = cVar;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.c(task);
            QLog.i(FileDownloadIPCImplForZplan.TAG, 1, "bindFileDownloadProgress onComplete -- " + this.f328361c + " - " + this.f328360b);
            if (this.f328361c) {
                ((a) i.INSTANCE.a(a.class)).onFinalCallback(this.f328360b, 5, 0);
            } else {
                c cVar = this.f328362d;
                if (cVar != null) {
                    cVar.onFinalCallback(this.f328360b, 5, 0);
                }
            }
            FileDownloadManager.f328148a.x(this);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.f(progress, task);
            if (this.f328361c) {
                ((a) i.INSTANCE.a(a.class)).onProgress(this.f328360b, progress, task.getCurReceivedLength(), task.getCurTotalLength());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.h(code, task);
            QLog.e(FileDownloadIPCImplForZplan.TAG, 1, "bindFileDownloadProgress onFailed-" + code + " -- " + this.f328361c + " - " + this.f328360b);
            if (this.f328361c) {
                ((a) i.INSTANCE.a(a.class)).onFinalCallback(this.f328360b, 6, code);
            } else {
                c cVar = this.f328362d;
                if (cVar != null) {
                    cVar.onFinalCallback(this.f328360b, 6, code);
                }
            }
            FileDownloadManager.f328148a.x(this);
        }
    }

    @Override // gc3.b
    public void bindFileDownloadProgress(String taskId, boolean needProgressCallback, c callback) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        QLog.i(TAG, 1, "bindFileDownloadProgress START " + needProgressCallback + " - " + taskId);
        FileDownloadManager.f328148a.f(new b(taskId, needProgressCallback, callback));
    }
}
