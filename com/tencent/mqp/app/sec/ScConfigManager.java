package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ScConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final ScConfigManager f336126c;

    /* renamed from: d, reason: collision with root package name */
    private static final a[] f336127d;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, b> f336128a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f336129b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class LoadLocalConfig implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f336130d;

        /* renamed from: e, reason: collision with root package name */
        private String f336131e;

        /* renamed from: f, reason: collision with root package name */
        private QQAppInterface f336132f;

        public LoadLocalConfig(QQAppInterface qQAppInterface, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ScConfigManager.this, qQAppInterface, str, Boolean.valueOf(z16));
                return;
            }
            this.f336132f = qQAppInterface;
            this.f336131e = str;
            this.f336130d = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ScConfigManager.this.m(this.f336131e);
                if (this.f336130d) {
                    ScConfigManager.this.b(this.f336132f, this.f336131e);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f336133a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.mqp.app.sec.a f336134b;

        public a(String str, com.tencent.mqp.app.sec.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
            } else {
                this.f336133a = str;
                this.f336134b = aVar;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f336126c = new ScConfigManager();
            f336127d = new a[]{new a("SecCenterConfig", new d())};
        }
    }

    ScConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f336128a = new HashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f336129b = hashMap;
        hashMap.put("SecCenterConfig", "qq_security_sccfg");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006f A[Catch: IOException -> 0x006b, TRY_LEAVE, TryCatch #7 {IOException -> 0x006b, blocks: (B:38:0x0067, B:31:0x006f), top: B:37:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream open;
        InputStream inputStream = null;
        try {
            try {
                open = BaseApplication.getContext().getAssets().open(d(str) + ".xml");
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        open.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                inputStream = open;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStream = open;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
    }

    private String d(String str) {
        return this.f336129b.get(str);
    }

    private String f(String str) {
        String name = new File(str).getName();
        return name.substring(0, name.lastIndexOf("."));
    }

    private String g(String str) {
        return BaseApplication.getContext().getFilesDir().getPath() + "/" + str + ".xml";
    }

    private b h(String str) {
        synchronized (this.f336128a) {
            if (this.f336128a.containsKey(str)) {
                return this.f336128a.get(str);
            }
            return null;
        }
    }

    public static ScConfigManager i() {
        return f336126c;
    }

    public static com.tencent.mqp.app.sec.a j(String str) {
        for (a aVar : f336127d) {
            if (aVar.f336133a.equals(str)) {
                return aVar.f336134b;
            }
        }
        return null;
    }

    private boolean k(String str) {
        return !q.p(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        String g16 = g(str);
        if (k(g16)) {
            c(str, g16);
        }
        o(g16);
    }

    private boolean o(String str) {
        String f16 = f(str);
        com.tencent.mqp.app.sec.a j3 = j(f16);
        if (j3 != null) {
            b a16 = j3.a(str);
            if (a16 != null) {
                synchronized (this.f336128a) {
                    this.f336128a.put(f16, a16);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public void b(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) str);
        } else {
            AntiFraudConfigFileUtil.n().f(qQAppInterface, str);
        }
    }

    public b e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        b h16 = h(str);
        if (h16 == null && z16) {
            m(str);
            return h(str);
        }
        return h16;
    }

    public void l(QQAppInterface qQAppInterface, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, Boolean.valueOf(z16));
        } else if (e(str, false) == null) {
            ThreadManagerV2.executeOnFileThread(new LoadLocalConfig(qQAppInterface, str, z16));
        }
    }

    public boolean n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return o(str);
    }
}
