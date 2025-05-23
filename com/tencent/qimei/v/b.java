package com.tencent.qimei.v;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ad.c;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f343407a;

    /* renamed from: b, reason: collision with root package name */
    public FileChannel f343408b;

    /* renamed from: c, reason: collision with root package name */
    public FileLock f343409c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            FileLock fileLock = this.f343409c;
            if (fileLock != null) {
                fileLock.release();
            }
            FileChannel fileChannel = this.f343408b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.f343407a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (IOException e16) {
            c.a(e16);
        }
    }

    public final boolean a(String str, a aVar, int i3) {
        FileLock lock;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, aVar, Integer.valueOf(i3))).booleanValue();
        }
        if (!com.tencent.qimei.ab.c.a(str)) {
            return false;
        }
        try {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(com.tencent.qimei.u.a.a(str), "rw");
                this.f343407a = randomAccessFile;
                FileChannel channel = randomAccessFile.getChannel();
                this.f343408b = channel;
                if (channel != null) {
                    if (i3 == 1) {
                        lock = channel.tryLock();
                    } else if (i3 == 2) {
                        lock = channel.lock(0L, Long.MAX_VALUE, true);
                    } else if (i3 == 3) {
                        lock = channel.lock();
                    }
                    this.f343409c = lock;
                }
                if (this.f343409c == null || aVar == null) {
                    z16 = false;
                } else {
                    aVar.a();
                }
                a();
                return z16;
            } catch (Exception e16) {
                c.b(JoinPoint.SYNCHRONIZATION_LOCK, "except %d, %s", Integer.valueOf(i3), e16.getMessage());
                a();
                return false;
            }
        } catch (Throwable th5) {
            a();
            throw th5;
        }
    }
}
