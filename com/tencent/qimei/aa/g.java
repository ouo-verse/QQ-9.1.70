package com.tencent.qimei.aa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f342916a;

    /* renamed from: b, reason: collision with root package name */
    public FileChannel f342917b;

    /* renamed from: c, reason: collision with root package name */
    public MappedByteBuffer f342918c;

    /* renamed from: d, reason: collision with root package name */
    public int f342919d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f342920e;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342919d = 0;
            this.f342920e = false;
        }
    }

    public boolean a(String str, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }
        try {
            String a16 = com.tencent.qimei.ab.a.a(str + com.tencent.qimei.u.a.c());
            com.tencent.qimei.ab.c.a(a16);
            RandomAccessFile randomAccessFile = new RandomAccessFile(com.tencent.qimei.u.a.a(a16), "rw");
            this.f342916a = randomAccessFile;
            FileChannel channel = randomAccessFile.getChannel();
            this.f342917b = channel;
            this.f342918c = channel.map(FileChannel.MapMode.READ_WRITE, 0L, i3);
            this.f342919d = i3;
            z16 = true;
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            z16 = false;
        }
        this.f342920e = z16;
        return z16;
    }
}
