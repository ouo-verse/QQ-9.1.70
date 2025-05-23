package com.tencent.mobileqq.temp.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    File f292632a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.temp.transfile.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8644a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        File f292633a;

        /* renamed from: b, reason: collision with root package name */
        private String f292634b;

        C8644a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
                return;
            }
            if (!a.this.f292632a.exists()) {
                a.this.f292632a.mkdirs();
            }
            this.f292634b = str;
            this.f292633a = new File(a.this.f292632a, str + ".tmp");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(boolean z16) {
            if (!z16 || this.f292633a.length() <= 0) {
                this.f292633a.delete();
                QLog.d("DiskCache", 2, "dirtyFile delete as abort: " + this.f292633a.getPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public File b() throws IOException {
            File b16 = a.this.b(this.f292634b);
            if (b16.exists()) {
                return b16;
            }
            if (this.f292633a.exists() && this.f292633a.length() > 0) {
                QLog.d("DiskCache", 2, "dirtyFile rename: " + this.f292633a.getPath());
                this.f292633a.renameTo(b16);
                return b16;
            }
            QLog.d("DiskCache", 2, "dirtyFile delete: " + this.f292633a.getPath());
            this.f292633a.delete();
            throw new IOException("write 0 length file or null File");
        }
    }

    public a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
        } else {
            this.f292632a = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8644a a(String str) {
        return new C8644a(str);
    }

    File b(String str) {
        if (!this.f292632a.exists()) {
            this.f292632a.mkdirs();
        }
        return new File(this.f292632a, str);
    }

    public File c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f292632a;
    }
}
