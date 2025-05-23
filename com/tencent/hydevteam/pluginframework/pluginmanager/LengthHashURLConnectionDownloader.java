package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.util.Log;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
class LengthHashURLConnectionDownloader extends SimpleURLConnectionDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f114746a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class LengthHashDownloadTask extends SimpleURLConnectionDownloader.DownloadTask {
        static IPatchRedirector $redirector_;

        public LengthHashDownloadTask(TargetDownloadInfo targetDownloadInfo, File file, File file2, AtomicLong atomicLong) {
            super(targetDownloadInfo, file, file2, atomicLong);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, targetDownloadInfo, file, file2, atomicLong);
            }
        }

        @Override // com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader.DownloadTask, java.util.concurrent.Callable
        /* renamed from: a */
        public final File call() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            long length = this.f114774a.length();
            HttpURLConnection b16 = b();
            int contentLength = b16.getContentLength();
            if (length != 0 && length == contentLength) {
                Log.d("LengthCheckDownloader", "\u4e0b\u8f7d\u7684\u6587\u4ef6\u6ca1\u6709\u53d8\u5316\uff0c\u4e0d\u8fdb\u884c\u4e0b\u8f7d fileLenght:" + length);
            } else {
                a(b16);
            }
            return this.f114774a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LengthHashURLConnectionDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114746a = ProxyExecutors.newSingleThreadExecutor();
        }
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader, com.tencent.hydevteam.pluginframework.pluginmanager.Downloader
    public ProgressFuture<File> download(TargetDownloadInfo targetDownloadInfo, File file, File file2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProgressFuture) iPatchRedirector.redirect((short) 2, this, targetDownloadInfo, file, file2);
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        return new ProgressFutureImpl<File>(this.f114746a.submit(new LengthHashDownloadTask(targetDownloadInfo, file, file2, atomicLong)), targetDownloadInfo.size, atomicLong) { // from class: com.tencent.hydevteam.pluginframework.pluginmanager.LengthHashURLConnectionDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private /* synthetic */ double f114747a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ AtomicLong f114748b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r5, null);
                this.f114747a = r6;
                this.f114748b = atomicLong;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, r5, Double.valueOf(r6), atomicLong);
                }
            }

            @Override // com.tencent.hydevteam.common.progress.ProgressFutureImpl, com.tencent.hydevteam.common.progress.Progress
            public double getProgress() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Double) iPatchRedirector2.redirect((short) 2, (Object) this)).doubleValue();
                }
                if (this.f114747a != 0.0d && !isDone()) {
                    return this.f114748b.get() / this.f114747a;
                }
                if (!isDone()) {
                    return 0.0d;
                }
                return 1.0d;
            }
        };
    }
}
