package com.tencent.rdelivery.reshub.util.zip;

import android.os.Looper;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f implements e<ZipInputStream, ZipEntry> {

    /* renamed from: a, reason: collision with root package name */
    private long f364618a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f364619b;

    public void a(ZipInputStream zipInputStream, boolean z16, d<ZipEntry> dVar) throws IOException {
        this.f364618a = System.currentTimeMillis();
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        do {
            dVar.a(this, nextEntry, System.currentTimeMillis() - this.f364618a);
            if (this.f364619b || !z16) {
                break;
            } else {
                nextEntry = zipInputStream.getNextEntry();
            }
        } while (nextEntry != null);
        zipInputStream.close();
    }

    @Override // com.tencent.rdelivery.reshub.util.zip.e
    public void cancel() {
        this.f364619b = true;
    }

    @Override // com.tencent.rdelivery.reshub.util.zip.e
    public void pause(long j3) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                LockMethodProxy.sleep(j3);
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                this.f364618a = System.currentTimeMillis();
                throw th5;
            }
            this.f364618a = System.currentTimeMillis();
        }
    }
}
