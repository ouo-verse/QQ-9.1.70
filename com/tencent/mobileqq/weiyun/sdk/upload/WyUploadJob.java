package com.tencent.mobileqq.weiyun.sdk.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.uploader.IReporter;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WyUploadJob implements IUploader, Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected File f315251d;

    /* renamed from: e, reason: collision with root package name */
    protected UploadRequest f315252e;

    /* renamed from: f, reason: collision with root package name */
    private IUploader.IUploadListener f315253f;

    /* renamed from: h, reason: collision with root package name */
    private volatile int f315254h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile boolean f315255i;

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f315256m;

    public WyUploadJob() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f315254h = 0;
        this.f315255i = false;
        this.f315256m = false;
    }

    c a(UploadRequest uploadRequest) {
        return new d(uploadRequest, this);
    }

    UploadResponse b(int i3) {
        UploadResponse.Builder builder = new UploadResponse.Builder();
        builder.request(this.f315252e);
        builder.code(i3);
        return builder.build();
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) canceledFlag);
        }
        return null;
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void cancel(UploadRequest uploadRequest) {
        UploadRequest uploadRequest2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uploadRequest);
        } else if (uploadRequest != null && (uploadRequest2 = this.f315252e) != null && uploadRequest2.requestKey() != null && this.f315252e.requestKey().equals(uploadRequest.requestKey())) {
            this.f315255i = true;
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f315255i = true;
        }
    }

    boolean e() {
        int a16 = a(this.f315252e).a();
        l(a16);
        if (a16 == 0) {
            return true;
        }
        return false;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f315254h;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!this.f315255i && !this.f315256m) {
            return true;
        }
        return false;
    }

    public void h(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.f315253f.onUploadProgress(this.f315252e, j16, (float) (j3 / j16), 0L, 0L, 0L);
        }
    }

    void i() {
        this.f315253f.onUploadCanceled(this.f315252e);
    }

    public void j(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f315253f.onUploadFinished(this.f315252e, z16, b(i3));
        }
    }

    boolean k() {
        if (!g() || !e()) {
            return false;
        }
        return true;
    }

    protected void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f315254h = i3;
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void reportError(long j3, String str, String str2, String str3, int i3, boolean z16, long j16, long j17, long j18, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z17), Integer.valueOf(i16));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            if (k()) {
                j(true, 0);
            } else {
                if (!Thread.interrupted() && g()) {
                    j(false, f());
                }
                if (this.f315255i) {
                    i();
                } else {
                    j(false, f());
                }
            }
        } catch (Throwable unused) {
            if (f() == 0) {
                l(ErrorCode.TRAN_UNKNOWN_EXCEPTION);
            }
            j(false, f());
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setHttpProxy(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setIpConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setNetType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setReporter(IReporter iReporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iReporter);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void speedDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void trialSpeedUp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public boolean upload(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) uploadRequest)).booleanValue();
        }
        if (uploadRequest == null) {
            return false;
        }
        this.f315252e = uploadRequest;
        this.f315251d = new File(this.f315252e.path());
        this.f315253f = this.f315252e.listener();
        new BaseThread(this).start();
        return true;
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void vipSpeedUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }
}
