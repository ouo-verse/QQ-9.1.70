package com.tencent.qimei.aa;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f342895a;

    /* renamed from: b, reason: collision with root package name */
    public FileChannel f342896b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f342897c;

    /* renamed from: d, reason: collision with root package name */
    public MappedByteBuffer f342898d;

    /* renamed from: e, reason: collision with root package name */
    public long f342899e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f342900f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f342901g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f342902h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f342903i;

    public e(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
            return;
        }
        this.f342897c = new JSONObject();
        this.f342901g = new Object();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f342895a = randomAccessFile;
        this.f342896b = randomAccessFile.getChannel();
        this.f342899e = this.f342895a.length();
        a();
    }

    public static e a(Context context, String str) throws IOException {
        File file = new File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            com.tencent.qimei.ab.f.a("mkdir " + file.getName() + " exception!");
        }
        File file2 = new File(file, str + "V1");
        if (file2.exists()) {
            return new e(file2);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public synchronized <T> T a(@NonNull String str, @NonNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) t16);
        }
        if (this.f342902h) {
            return t16;
        }
        ?? r06 = 0;
        r06 = 0;
        try {
            synchronized (this.f342901g) {
                r06 = this.f342897c.get(str);
            }
        } catch (Exception unused) {
        }
        if (r06 != 0) {
            t16 = r06;
        }
        return t16;
    }

    public final void a() throws IOException {
        byte[] bArr;
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f342899e <= 10) {
            this.f342903i = true;
            this.f342899e = 4L;
        }
        MappedByteBuffer map = this.f342896b.map(FileChannel.MapMode.READ_WRITE, 0L, this.f342899e);
        this.f342898d = map;
        map.rewind();
        if (this.f342903i) {
            this.f342898d.putInt(0, 1);
            if (this.f342900f == null) {
                this.f342900f = new c(this);
            }
            com.tencent.qimei.t.a.a().a(new d(this, this.f342900f));
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.f342898d;
        int i3 = mappedByteBuffer.getInt(0);
        if (i3 <= 1 || i3 > 2097152 || mappedByteBuffer.capacity() <= 10 || mappedByteBuffer.capacity() < i3 + 10) {
            bArr = null;
        } else {
            mappedByteBuffer.position(10);
            bArr = new byte[i3];
            mappedByteBuffer.get(bArr, 0, i3);
        }
        if (bArr == null) {
            return;
        }
        try {
            byte[] a16 = a(bArr, "BEACONDEFAULTAES");
            if (a16 == null) {
                synchronized (com.tencent.qimei.u.c.class) {
                    cVar = com.tencent.qimei.u.c.f343390p;
                }
                a16 = a(bArr, cVar.b());
                if (a16 == null) {
                    a16 = a(bArr, "");
                }
            }
            this.f342897c = new JSONObject(new String(a16, "ISO8859-1"));
        } catch (Exception e16) {
            e16.getMessage();
        }
        this.f342897c.toString();
    }

    public final byte[] a(byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, (Object) str);
        }
        try {
            return com.tencent.qimei.f.a.a(bArr, com.tencent.qimei.f.a.a(str).getBytes(), 2);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
            return null;
        }
    }
}
