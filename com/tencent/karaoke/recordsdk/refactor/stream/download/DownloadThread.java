package com.tencent.karaoke.recordsdk.refactor.stream.download;

import android.os.Process;
import com.google.android.exoplayer2.upstream.DataSource;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xz0.b;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/karaoke/recordsdk/refactor/stream/download/DownloadThread;", "Ljava/lang/Thread;", "", "o", "p", TencentLocation.RUN_MODE, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isStoped", "Ljava/util/concurrent/ExecutorService;", "D", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService", "(Ljava/util/concurrent/ExecutorService;)V", "executorService", "E", "enableDebug", "", UserInfo.SEX_FEMALE, "I", "sHttpDownloadBytes", "G", "sHttpServerFileSize", "Lcom/google/android/exoplayer2/upstream/DataSource;", "H", "Lcom/google/android/exoplayer2/upstream/DataSource;", "mHttpDataSource", "mBufferSize", "lib_record_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class DownloadThread extends BaseThread {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isStoped;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ExecutorService executorService;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean enableDebug;

    /* renamed from: F, reason: from kotlin metadata */
    private int sHttpDownloadBytes;

    /* renamed from: G, reason: from kotlin metadata */
    private int sHttpServerFileSize;

    /* renamed from: H, reason: from kotlin metadata */
    private DataSource mHttpDataSource;

    /* renamed from: I, reason: from kotlin metadata */
    private final int mBufferSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()I"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes7.dex */
    static final class a<V> implements Callable<Integer> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f117063e;

        a(byte[] bArr) {
            this.f117063e = bArr;
        }

        public final int a() {
            DataSource dataSource = DownloadThread.this.mHttpDataSource;
            byte[] bArr = this.f117063e;
            return dataSource.read(bArr, 0, bArr.length);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() {
            return Integer.valueOf(a());
        }
    }

    public final void o() {
        try {
            this.mHttpDataSource.close();
        } catch (Exception e16) {
            e16.printStackTrace();
            b.b("closeConnSafely error,msg = " + e16.getMessage(), null, 2, null);
        }
    }

    public final void p() {
        b.b("stop downloadThread", null, 2, null);
        this.isStoped = true;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Integer readNum;
        Process.setThreadPriority(-16);
        while (true) {
            if (!this.isStoped) {
                FutureTask futureTask = new FutureTask(new a(new byte[this.mBufferSize]));
                this.executorService.execute(futureTask);
                try {
                    readNum = (Integer) futureTask.get(xz0.a.f449168k.b(), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    futureTask.cancel(true);
                    readNum = Integer.valueOf(xz0.a.f449168k.a());
                } catch (ExecutionException e17) {
                    e17.printStackTrace();
                    futureTask.cancel(true);
                    readNum = Integer.valueOf(xz0.a.f449168k.a());
                } catch (TimeoutException e18) {
                    e18.printStackTrace();
                    futureTask.cancel(true);
                    readNum = Integer.valueOf(xz0.a.f449168k.a());
                }
                int i3 = this.sHttpServerFileSize;
                if (i3 > 0 && this.sHttpDownloadBytes == i3) {
                    b.b("download thread should be stop auto,because has download all data", null, 2, null);
                    p();
                    break;
                }
                if (readNum != null && readNum.intValue() == -1) {
                    b.b("download thread should be stop,because download occur exception! readNum=" + this.sHttpDownloadBytes + ",sHttpServerSize=" + this.sHttpServerFileSize, null, 2, null);
                    p();
                    break;
                }
                int a16 = xz0.a.f449168k.a();
                if (readNum != null && readNum.intValue() == a16) {
                    b.b("error_network_exceed_limit", null, 2, null);
                    p();
                    break;
                } else {
                    if (Intrinsics.compare(readNum.intValue(), 0) < 0) {
                        p();
                        break;
                    }
                    int i16 = this.sHttpDownloadBytes;
                    Intrinsics.checkExpressionValueIsNotNull(readNum, "readNum");
                    this.sHttpDownloadBytes = i16 + readNum.intValue();
                    if (this.enableDebug) {
                        LockMethodProxy.sleep(50L);
                    }
                }
            } else {
                break;
            }
        }
        o();
    }
}
