package com.tencent.mobileqq.soload.download;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/soload/download/SoPriorityDownloader$postTask$r$1", "Ljava/lang/Runnable;", TencentLocation.RUN_MODE, "", "toString", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SoPriorityDownloader$postTask$r$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f288666d;
    final /* synthetic */ SoPriorityDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoPriorityDownloader$postTask$r$1(g gVar, SoPriorityDownloader soPriorityDownloader) {
        this.f288666d = gVar;
        this.this$0 = soPriorityDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar, (Object) soPriorityDownloader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SoPriorityDownloader this$0, g task, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "$task");
        this$0.k(task);
        this$0.e();
        QLog.d("SoLoadWidget.SoPriorityDownloader", 1, "[postTask] run() downloaded task cost=" + (task.I - task.H) + ",task=" + task);
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        b bVar;
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            atomicInteger = this.this$0.downloadingTaskCount;
            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[postTask] run() downloadLimitCount=" + atomicInteger.get() + ",task=" + this.f288666d);
            bVar = this.this$0.sodownLoader;
            if (!bVar.a(this.f288666d)) {
                this.this$0.k(this.f288666d);
                this.this$0.e();
                QLog.d("SoLoadWidget.SoPriorityDownloader", 1, "[postTask] run() task is limit of failTime, task=" + this.f288666d);
                return;
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            bVar2 = this.this$0.sodownLoader;
            final g gVar = this.f288666d;
            final SoPriorityDownloader soPriorityDownloader = this.this$0;
            bVar2.b(gVar, runtime, new m03.a() { // from class: com.tencent.mobileqq.soload.download.e
                @Override // m03.a
                public final void onDownloadFinish(boolean z16) {
                    SoPriorityDownloader$postTask$r$1.b(SoPriorityDownloader.this, gVar, z16);
                }
            });
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:10:0x0016, B:12:0x0021, B:15:0x0028, B:16:0x0037, B:18:0x0051, B:19:0x0058, B:22:0x0033), top: B:9:0x0016 }] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String str;
        LinkedList linkedList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            List<String> list = this.f288666d.f313009g;
            if (list != null && list.size() != 0) {
                str = this.f288666d.f313009g.get(0);
                sb5.append("SoLoadWidget.SoPriorityDownloader");
                sb5.append("[postTask]:");
                sb5.append(str);
                sb5.append(",downloadQueue size:");
                linkedList = this.this$0.downloadQueue;
                if (linkedList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                    linkedList = null;
                }
                sb5.append(linkedList.size());
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                return sb6;
            }
            str = this.f288666d.f313004c;
            sb5.append("SoLoadWidget.SoPriorityDownloader");
            sb5.append("[postTask]:");
            sb5.append(str);
            sb5.append(",downloadQueue size:");
            linkedList = this.this$0.downloadQueue;
            if (linkedList == null) {
            }
            sb5.append(linkedList.size());
            String sb62 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb62, "sb.toString()");
            return sb62;
        } catch (Exception e16) {
            QLog.e("SoLoadWidget.SoPriorityDownloader", 1, e16, new Object[0]);
            return super.toString();
        }
    }
}
