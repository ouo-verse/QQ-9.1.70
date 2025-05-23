package com.tencent.gathererga.core.internal.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f108253a;

    /* renamed from: b, reason: collision with root package name */
    private String f108254b;

    /* renamed from: c, reason: collision with root package name */
    private String f108255c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f108256d;

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f108257e;

    /* renamed from: f, reason: collision with root package name */
    private FileLock f108258f;

    public a(String str, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Boolean.valueOf(z16));
            return;
        }
        this.f108253a = str;
        this.f108254b = str2;
        this.f108255c = str3;
        this.f108256d = z16;
    }

    private boolean c() {
        if (!TextUtils.isEmpty(this.f108253a) && !TextUtils.isEmpty(this.f108254b) && !TextUtils.isEmpty(this.f108255c)) {
            return true;
        }
        return false;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            FileLock fileLock = this.f108258f;
            if (fileLock != null) {
                fileLock.release();
                this.f108258f = null;
            }
        } catch (Throwable th5) {
            d.c("AdFile close", th5);
        }
        try {
            RandomAccessFile randomAccessFile = this.f108257e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.f108257e = null;
            }
        } catch (Throwable th6) {
            d.c("AdFile close", th6);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (c() && this.f108256d && this.f108257e == null && this.f108258f == null) {
            try {
                File file = new File(this.f108253a);
                File file2 = new File(file, this.f108254b);
                if (!file.exists()) {
                    return true;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                this.f108257e = randomAccessFile;
                this.f108258f = randomAccessFile.getChannel().lock();
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                    a();
                    return true;
                }
                a();
                return true;
            } catch (Throwable th5) {
                d.c("AdFile open", th5);
                a();
            }
        }
        return false;
    }

    public boolean d() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (c() && this.f108257e == null && this.f108258f == null) {
            try {
                File file = new File(this.f108253a);
                File file2 = new File(file, this.f108254b);
                if (this.f108256d && !file.exists() && !file.mkdirs()) {
                    return false;
                }
                if (this.f108256d) {
                    str = "rwd";
                } else {
                    str = "r";
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, str);
                this.f108257e = randomAccessFile;
                if (this.f108256d) {
                    this.f108258f = randomAccessFile.getChannel().lock();
                } else {
                    this.f108258f = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                }
                if (file2.exists() && file2.isFile()) {
                    return true;
                }
                a();
                return false;
            } catch (Throwable th5) {
                d.c("AdFile open", th5);
                a();
            }
        }
        return false;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f(Integer.MIN_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x002e, code lost:
    
        if (r0.length() <= r7) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (c() && (r0 = this.f108257e) != null && this.f108258f != null) {
            if (i3 != Integer.MIN_VALUE) {
                try {
                } catch (Throwable th5) {
                    d.c("AdFile read", th5);
                }
            }
            i3 = Long.valueOf(this.f108257e.length()).intValue();
            if (i3 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            if (this.f108257e.read(bArr, 0, i3) != i3) {
                return null;
            }
            return new String(bArr, 0, i3, this.f108255c);
        }
        return null;
    }

    public boolean g(String str) {
        RandomAccessFile randomAccessFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (c() && this.f108256d && (randomAccessFile = this.f108257e) != null && this.f108258f != null) {
            try {
                randomAccessFile.setLength(0L);
                if (!TextUtils.isEmpty(str)) {
                    this.f108257e.write(str.getBytes(this.f108255c));
                    return true;
                }
                return true;
            } catch (Throwable th5) {
                d.c("AdFile write", th5);
            }
        }
        return false;
    }
}
