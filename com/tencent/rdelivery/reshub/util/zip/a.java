package com.tencent.rdelivery.reshub.util.zip;

import android.os.Looper;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements e<File, File> {

    /* renamed from: a, reason: collision with root package name */
    private int f364606a;

    /* renamed from: b, reason: collision with root package name */
    private long f364607b = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f364608c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f364609d = true;

    private boolean a(File file, boolean z16, d<File> dVar, ReadWriteLock readWriteLock) {
        File[] listFiles;
        int i3;
        readWriteLock.readLock().lock();
        if (z16 && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (this.f364608c || ((this.f364609d && file2.getName().startsWith(".")) || (i3 = this.f364606a) > 50)) {
                        return true;
                    }
                    this.f364606a = i3 + 1;
                    c(file2, true, dVar);
                    this.f364606a--;
                }
            }
        }
        return false;
    }

    public void b(boolean z16) {
        this.f364609d = z16;
    }

    public void c(File file, boolean z16, d<File> dVar) {
        if (file != null && dVar != null) {
            ReadWriteLock j3 = jz3.c.j(file.getAbsolutePath());
            try {
                if (a(file, z16, dVar, j3)) {
                    return;
                }
                try {
                    j3.writeLock().lock();
                    dVar.a(this, file, System.currentTimeMillis() - this.f364607b);
                    return;
                } finally {
                    j3.writeLock().unlock();
                }
            } finally {
                j3.readLock().unlock();
            }
        }
        throw new NullPointerException(" file or strategy can not be null");
    }

    @Override // com.tencent.rdelivery.reshub.util.zip.e
    public void cancel() {
        this.f364608c = true;
    }

    @Override // com.tencent.rdelivery.reshub.util.zip.e
    public void pause(long j3) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                LockMethodProxy.sleep(j3);
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                this.f364607b = System.currentTimeMillis();
                throw th5;
            }
            this.f364607b = System.currentTimeMillis();
        }
    }
}
