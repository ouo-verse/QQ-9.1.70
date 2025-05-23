package com.tencent.beacon.a.d;

import com.tencent.beacon.a.b.i;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f77688a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f77689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, Runnable runnable) {
        this.f77689b = gVar;
        this.f77688a = runnable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
    
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r1 != null) goto L35;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        FileChannel fileChannel;
        synchronized (this.f77689b) {
            FileLock fileLock = null;
            try {
                try {
                    fileChannel = this.f77689b.f77691b;
                    fileLock = fileChannel.lock();
                    this.f77688a.run();
                } catch (Exception e16) {
                    Object[] objArr = new Object[1];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("file get lock error:");
                    sb5.append(e16.getMessage());
                    objArr[0] = sb5.toString();
                    com.tencent.beacon.base.util.c.b("[properties]", objArr);
                    i.e().a("504", "[properties] File get lock error!", e16);
                }
            } catch (Throwable th5) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                throw th5;
            }
        }
    }
}
