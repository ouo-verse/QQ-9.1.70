package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f305950a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uniformdownload.downloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8879a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f305951a;

        /* renamed from: b, reason: collision with root package name */
        long f305952b;

        /* renamed from: c, reason: collision with root package name */
        String f305953c;

        /* renamed from: d, reason: collision with root package name */
        String f305954d;

        public C8879a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f305950a = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f305950a == null) {
                f305950a = new a();
            }
            aVar = f305950a;
        }
        return aVar;
    }

    public void a(String str, String str2, long j3, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), str3, str4);
            return;
        }
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
        uniformDownloadBPTransEntity.mUrl = str;
        uniformDownloadBPTransEntity.mFileName = str2;
        uniformDownloadBPTransEntity.mFileSize = j3;
        uniformDownloadBPTransEntity.mFilePath = str4;
        uniformDownloadBPTransEntity.mTempPath = str3;
        if (UniformDownloadMgr.m().k() == null) {
            QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] addBPTransItem.failed APP=null, filename[" + str2 + "] fillesize[" + j3 + "] tempPath[" + str3 + "] strPath[" + str4 + "] url[" + str + "]");
            return;
        }
        if (UniformDownloadBPTransProxy.m() != null) {
            UniformDownloadBPTransProxy.m().f(uniformDownloadBPTransEntity);
        }
        QLog.i("UniformDownloadBPTrans", 1, "[UniformDL] addBPTransItem.filename[" + str2 + "] fillesize[" + j3 + "] tempPath[" + str3 + "] strPath[" + str4 + "] url[" + str + "]");
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        QLog.i("UniformDownloadBPTrans", 1, "[UniformDL] delBPTransItem. url[" + str + "]");
        if (UniformDownloadMgr.m().k() == null) {
            QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] delBPTransItem failed APP=null. url[" + str + "]");
            return;
        }
        if (UniformDownloadBPTransProxy.m() != null) {
            UniformDownloadBPTransProxy.m().k(str);
        }
    }

    public C8879a c(String str) {
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (C8879a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (UniformDownloadMgr.m().k() == null) {
            QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + str + "]");
            return null;
        }
        if (UniformDownloadBPTransProxy.m() != null) {
            uniformDownloadBPTransEntity = UniformDownloadBPTransProxy.m().p(str);
        } else {
            QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] getUDLBPTransProxy=null.");
            uniformDownloadBPTransEntity = null;
        }
        if (uniformDownloadBPTransEntity == null) {
            return null;
        }
        C8879a c8879a = new C8879a();
        c8879a.f305951a = uniformDownloadBPTransEntity.mFileName;
        c8879a.f305952b = uniformDownloadBPTransEntity.mFileSize;
        c8879a.f305954d = uniformDownloadBPTransEntity.mFilePath;
        c8879a.f305953c = uniformDownloadBPTransEntity.mTempPath;
        return c8879a;
    }
}
