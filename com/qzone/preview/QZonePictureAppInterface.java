package com.qzone.preview;

import android.os.Bundle;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IThreadPool;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import mqq.app.AppRuntime;

/* loaded from: classes39.dex */
public class QZonePictureAppInterface extends AppRuntime {

    /* loaded from: classes39.dex */
    class a implements IThreadPool {

        /* renamed from: com.qzone.preview.QZonePictureAppInterface$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0421a implements ThreadPool.Job<Object> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f49680d;

            C0421a(Runnable runnable) {
                this.f49680d = runnable;
            }

            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                this.f49680d.run();
                return null;
            }
        }

        a() {
        }

        @Override // com.qzone.common.event.IThreadPool
        public void submit(Runnable runnable) {
            PriorityThreadPool.getDefault().submit(new C0421a(runnable));
        }
    }

    @Override // mqq.app.AppRuntime
    public BaseApplication getApp() {
        return BaseApplication.getContext();
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.getAccount();
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QZonePictureAppInterface onCreate ,theadid=" + Thread.currentThread().getId());
        PerfTracer.traceStart(PerfTracer.RUNTIME_ONCREATE);
        PerfTracer.traceStart(PerfTracer.RUNTIME_SUPER_ONCREATE);
        super.onCreate(bundle);
        PerfTracer.traceEnd(PerfTracer.RUNTIME_SUPER_ONCREATE);
        EventCenter.setThreadPool(new a());
        EventCenter.getInstance();
        com.qzone.album.env.common.b.a();
        PerfTracer.traceStart(PerfTracer.RUNTIME_VIDEO_INIT);
        QZoneVideoLoader.r();
        FeedVideoEnv.preloadResource(FeedVideoEnv.feedResources, FeedVideoEnv.externalFunc);
        com.qzone.proxy.feedcomponent.e.c(BaseApplication.getContext(), getApplication());
        PerfTracer.traceEnd(PerfTracer.RUNTIME_VIDEO_INIT);
        QZoneVideoLoader.t();
        PerfTracer.traceEnd(PerfTracer.RUNTIME_ONCREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        if (QZLog.isColorLevel()) {
            QZLog.i("QZonePictureAppInterface", 2, "onRunningBackground");
        }
        super.onRunningBackground();
        LpReportManager.getInstance().startReportImediately(2);
    }
}
