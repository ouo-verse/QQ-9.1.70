package com.tencent.qqmini.miniapp.proxy;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqmini.miniapp.util.VideoCompressProxy;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* loaded from: classes23.dex */
public class VideoCompressProxyDefault extends VideoCompressProxy {
    public static final String TAG = "VideoCompress";
    private static final ExecutorService executor = ProxyExecutors.newSingleThreadExecutor();

    @Override // com.tencent.qqmini.miniapp.util.VideoCompressProxy
    public void execute() {
        executor.execute(new Runnable() { // from class: com.tencent.qqmini.miniapp.proxy.VideoCompressProxyDefault.1
            @Override // java.lang.Runnable
            public void run() {
                QMLog.i(VideoCompressProxyDefault.TAG, "start compress " + ((VideoCompressProxy) VideoCompressProxyDefault.this).mediaInfo.path);
                ((VideoCompressProxy) VideoCompressProxyDefault.this).compresslistener.onStart();
                File file = new File(((VideoCompressProxy) VideoCompressProxyDefault.this).mediaInfo.path);
                File file2 = new File(((VideoCompressProxy) VideoCompressProxyDefault.this).outputPath);
                boolean z16 = false;
                for (int i3 = 1; i3 <= 100; i3++) {
                    try {
                        LockMethodProxy.sleep(Math.round(Math.random() * 200.0d));
                    } catch (InterruptedException unused) {
                    }
                    if (i3 == 50) {
                        z16 = FileUtils.copyFile(file, file2);
                    }
                    ((VideoCompressProxy) VideoCompressProxyDefault.this).compresslistener.onProgress(String.format("progress:%s", Integer.valueOf(i3)), i3 / 100.0f);
                }
                if (z16) {
                    ((VideoCompressProxy) VideoCompressProxyDefault.this).compresslistener.onSuccess("compress success");
                } else {
                    ((VideoCompressProxy) VideoCompressProxyDefault.this).compresslistener.onFailure("compress failed");
                }
                ((VideoCompressProxy) VideoCompressProxyDefault.this).compresslistener.onFinish(z16);
            }
        });
    }
}
