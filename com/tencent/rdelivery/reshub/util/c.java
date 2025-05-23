package com.tencent.rdelivery.reshub.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/c;", "", "Ljava/nio/channels/FileChannel;", "a", "", "b", "c", "", "Z", "multiProcessMode", "Ljava/nio/channels/FileLock;", "Ljava/nio/channels/FileLock;", "getLock", "()Ljava/nio/channels/FileLock;", "setLock", "(Ljava/nio/channels/FileLock;)V", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/nio/channels/FileChannel;", "getLockFileChannel", "()Ljava/nio/channels/FileChannel;", "setLockFileChannel", "(Ljava/nio/channels/FileChannel;)V", "lockFileChannel", "Lcom/tencent/rdelivery/reshub/core/k;", "d", "Lcom/tencent/rdelivery/reshub/core/k;", "getReq", "()Lcom/tencent/rdelivery/reshub/core/k;", "req", "<init>", "(Lcom/tencent/rdelivery/reshub/core/k;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean multiProcessMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile FileLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile FileChannel lockFileChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.rdelivery.reshub.core.k req;

    public c(@NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        this.req = req;
        this.multiProcessMode = com.tencent.rdelivery.reshub.core.j.L.R();
    }

    private final FileChannel a() {
        try {
            String str = jz3.b.k(this.req) + ".lock";
            jz3.d.a("MultiProcFileOptLock", "getLockChannel: " + this.req.x() + ", lockFilePath = " + str);
            File n3 = jz3.c.n(str);
            Intrinsics.checkExpressionValueIsNotNull(n3, "FileUtil.safeCreateFile(lockFilePath)");
            return new FileOutputStream(n3).getChannel();
        } catch (Exception e16) {
            jz3.d.d("MultiProcFileOptLock", "Get LockFile Channel Exception(" + this.req.x() + "): " + e16.getMessage(), e16);
            return null;
        }
    }

    public final void b() {
        if (!this.multiProcessMode) {
            return;
        }
        try {
            FileChannel a16 = a();
            if (a16 == null) {
                jz3.d.e("MultiProcFileOptLock", "Lock File Operate: " + this.req.x() + ", return for null channel");
                return;
            }
            jz3.d.a("MultiProcFileOptLock", "Lock File Operate: " + this.req.x() + ", before lock()");
            int i3 = 0;
            while (true) {
                if (i3 >= 1000) {
                    jz3.d.e("MultiProcFileOptLock", "Lock File Operate: " + this.req.x() + ", break for timeout sleepCount = " + i3);
                    break;
                }
                try {
                    this.lock = a16.tryLock();
                } catch (OverlappingFileLockException unused) {
                    jz3.d.a("MultiProcFileOptLock", "Lock File Operate: " + this.req.x() + ", sleep for OverlappingFileLockException");
                    LockMethodProxy.sleep(20L);
                }
                if (this.lock != null) {
                    break;
                }
                jz3.d.a("MultiProcFileOptLock", "Lock File Operate: " + this.req.x() + ", sleep for get null lock");
                LockMethodProxy.sleep(20L);
                i3++;
            }
            this.lockFileChannel = a16;
            if (this.lock != null) {
                jz3.d.e("MultiProcFileOptLock", "Lock File Operate: " + this.req.x());
            }
        } catch (Exception e16) {
            jz3.d.d("MultiProcFileOptLock", "Lock File Operate(" + this.req.x() + ") Exception: " + e16.getMessage(), e16);
        }
    }

    public final void c() {
        if (!this.multiProcessMode) {
            return;
        }
        try {
            FileLock fileLock = this.lock;
            if (fileLock != null) {
                fileLock.release();
                jz3.d.e("MultiProcFileOptLock", "Unlock File Operate: " + this.req.x());
            }
            FileChannel fileChannel = this.lockFileChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Exception e16) {
            jz3.d.d("MultiProcFileOptLock", "Unlock File Operate(" + this.req.x() + ") Exception: " + e16.getMessage(), e16);
        }
    }
}
