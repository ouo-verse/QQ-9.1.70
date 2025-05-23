package oe3;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Loe3/b;", "", "", "speed", "c", "", "b", "Lcom/tencent/hlyyb/downloader/Downloader;", "Lcom/tencent/hlyyb/downloader/Downloader;", QDLog.TAG_DOWNLOAD, "I", "d", "()I", "e", "(I)V", "currentSpeed", "Lcom/tencent/hlyyb/downloader/DownloaderTaskListener;", "Lcom/tencent/hlyyb/downloader/DownloaderTaskListener;", "taskListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f422582a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Downloader downloader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentSpeed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final DownloaderTaskListener taskListener;

    static {
        HalleyAgent.init(BaseApplication.getContext(), "", "");
        Downloader downloader2 = HalleyAgent.getDownloader();
        downloader2.setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 1);
        downloader2.setNotNetworkWaitMillis(5000);
        downloader2.setProgressInterval(200);
        downloader = downloader2;
        taskListener = new a();
    }

    b() {
    }

    public final int d() {
        return currentSpeed;
    }

    public final void e(int i3) {
        currentSpeed = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int c(int speed) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(speed / t74.a.f435529b);
        return roundToInt;
    }

    public final void b() {
        currentSpeed = 0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"oe3/b$a", "Lcom/tencent/hlyyb/downloader/DownloaderTaskListener;", "Lcom/tencent/hlyyb/downloader/DownloaderTask;", "downloaderTask", "", "onTaskPendingMainloop", "onTaskStartedMainloop", "onTaskDetectedMainloop", "onTaskReceivedMainloop", "onTaskPausedMainloop", "onTaskFailedMainloop", "onTaskCompletedMainloop", "onTaskStartedSubloop", "onTaskDetectedSubloop", "onTaskReceivedSubloop", "onTaskPausedSubloop", "onTaskFailedSubloop", "onTaskCompletedSubloop", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements DownloaderTaskListener {
        a() {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
            b bVar = b.f422582a;
            int c16 = bVar.c(downloaderTask != null ? downloaderTask.getAverageSpeed() : 0);
            QLog.i("NetSpeedTester", 1, "onTaskCompletedMainLoop :: averageSpeed == " + c16);
            bVar.e(c16);
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskFailedMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPausedMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPendingMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskStartedMainloop(DownloaderTask downloaderTask) {
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        }
    }
}
