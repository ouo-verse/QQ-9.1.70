package com.tencent.tbs.one.impl.a;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final File f374582a;

    /* renamed from: b, reason: collision with root package name */
    private final FileOutputStream f374583b;

    /* renamed from: c, reason: collision with root package name */
    private final FileLock f374584c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class a implements Callable<k> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Callable f374585d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f374586e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Callable callable, File file) {
            this.f374585d = callable;
            this.f374586e = file;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ k call() throws Exception {
            if (((Boolean) this.f374585d.call()).booleanValue()) {
                return k.a(this.f374586e);
            }
            throw new Exception("Aborted");
        }
    }

    k(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.f374582a = file;
        this.f374583b = fileOutputStream;
        this.f374584c = fileLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Callable<T> callable, File file, long j3) {
        for (int i3 = 0; i3 < j3 / 200; i3++) {
            try {
                T call = callable.call();
                if (call != null) {
                    if (i3 > 0) {
                        g.a("Finished waiting on lock file: %s", file.getAbsolutePath());
                    }
                    return call;
                }
                if (i3 == 0) {
                    g.a("Waiting on lock file: %s", file.getAbsolutePath());
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException unused) {
                }
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new RuntimeException("Timed out waiting for lock file: " + file.getAbsolutePath());
    }

    public static k a(File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock != null) {
                g.a("Created lock file: %s", file.getAbsolutePath());
                return new k(file, fileOutputStream, tryLock);
            }
        } catch (Throwable th6) {
            th = th6;
            g.c("Failed to try to acquire lock %s", file.getAbsolutePath(), th);
            d.a(fileOutputStream);
            return null;
        }
        d.a(fileOutputStream);
        return null;
    }

    public final void a() {
        try {
            g.a("Deleting lock file: %s", this.f374582a.getAbsolutePath());
            this.f374584c.release();
            this.f374583b.close();
            if (this.f374582a.delete()) {
                return;
            }
            throw new IOException("Failed to delete lock file: " + this.f374582a.getAbsolutePath());
        } catch (IOException e16) {
            g.c("Failed to release process lock file %s", this.f374582a.getAbsolutePath(), e16);
        }
    }
}
