package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.common.transfer.h;
import com.tencent.mobileqq.uftransfer.common.transfer.i;
import com.tencent.mobileqq.uftransfer.common.transfer.upload.d;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTFtnFileUploader extends UFTFileUploaderCbWrapper implements com.tencent.mobileqq.uftransfer.common.transfer.a, b, com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final long f305051d;

    /* renamed from: e, reason: collision with root package name */
    private final String f305052e;

    /* renamed from: f, reason: collision with root package name */
    private final long f305053f;

    /* renamed from: g, reason: collision with root package name */
    private final UFTUrlProvider f305054g;

    /* renamed from: h, reason: collision with root package name */
    private String f305055h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f305056i;

    /* renamed from: j, reason: collision with root package name */
    private long f305057j;

    /* renamed from: k, reason: collision with root package name */
    private InputStream f305058k;

    /* renamed from: l, reason: collision with root package name */
    private long f305059l;

    /* renamed from: m, reason: collision with root package name */
    private long f305060m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f305061n;

    /* renamed from: o, reason: collision with root package name */
    private long f305062o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.uftransfer.depend.d f305063p;

    /* renamed from: q, reason: collision with root package name */
    private a f305064q;

    /* renamed from: r, reason: collision with root package name */
    private long f305065r;

    /* renamed from: s, reason: collision with root package name */
    private int f305066s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f305067t;

    UFTFtnFileUploader(AppRuntime appRuntime, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) iVar);
            return;
        }
        this.f305056i = true;
        this.f305057j = 0L;
        this.f305058k = null;
        this.f305059l = 0L;
        this.f305060m = 0L;
        this.f305061n = false;
        this.f305062o = 0L;
        this.f305063p = new com.tencent.mobileqq.uftransfer.depend.d();
        this.f305065r = 0L;
        this.f305066s = 0;
        this.f305067t = false;
        long d16 = iVar.d();
        this.f305051d = d16;
        String e16 = iVar.e();
        this.f305052e = e16;
        this.f305053f = new File(e16).length();
        if (iVar.f()) {
            this.f305054g = new com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.c(appRuntime, iVar.k(), iVar.m(), d16, iVar.n(), this);
        } else {
            this.f305054g = new UFTUrlProvider(appRuntime, iVar.k(), iVar.m(), d16, iVar.n(), this);
        }
        this.f305055h = this.f305054g.c();
        e m3 = e.m(appRuntime, d16, iVar.c(), 0, iVar.n(), iVar.l());
        this.f305064q = m3;
        if (m3 != null) {
            m3.b(this);
        }
    }

    private void B() {
        a aVar = this.f305064q;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    private void C() {
        InputStream inputStream = this.f305058k;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
            this.f305058k = null;
        }
    }

    public static UFTFtnFileUploader D(AppRuntime appRuntime, h hVar) {
        if (appRuntime != null && hVar != null) {
            if (!hVar.a()) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "prop invaild:" + hVar.b());
            }
            return new UFTFtnFileUploader(appRuntime, hVar);
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
        return null;
    }

    public static UFTFtnFileUploader E(AppRuntime appRuntime, i iVar) {
        if (appRuntime != null && iVar != null) {
            if (!iVar.a()) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "prop invaild:" + iVar.b());
            }
            return new UFTFtnFileUploader(appRuntime, iVar);
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i3, long j3, String str, String str2) {
        this.f305056i = true;
        C();
        B();
        k(true, i3, j3, str, str2, null);
    }

    private void G(boolean z16) {
        this.f305056i = true;
        C();
        j(z16, null);
    }

    private byte[] H(long j3) {
        try {
            if (j3 == 0) {
                if (!I()) {
                    return null;
                }
            } else {
                long j16 = this.f305059l;
                if (j3 > j16) {
                    try {
                        this.f305058k.skip(j3 - j16);
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return null;
                    }
                } else if (j3 < j16) {
                    if (!I()) {
                        return null;
                    }
                    try {
                        this.f305058k.skip(j3);
                    } catch (IOException e17) {
                        this.f305058k = null;
                        e17.printStackTrace();
                        return null;
                    }
                }
            }
            this.f305059l = j3;
            int b16 = this.f305063p.b(this.f305057j, this.f305053f);
            byte[] bArr = new byte[b16];
            try {
                this.f305058k.read(bArr, 0, b16);
                this.f305059l += b16;
                return bArr;
            } catch (Exception e18) {
                e18.printStackTrace();
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "Id[" + this.f305051d + "] getSendStreamSlice exception:" + e18.toString());
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean I() {
        InputStream inputStream = this.f305058k;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            this.f305058k = null;
        }
        try {
            this.f305058k = new FileInputStream(this.f305052e);
            return true;
        } catch (FileNotFoundException e17) {
            this.f305058k = null;
            e17.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(long j3) {
        byte[] H = H(j3);
        if (H == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "] getSendStreamSlice return null");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTFtnFileUploader.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (UFTFtnFileUploader.this.f305056i) {
                            return;
                        }
                        UFTFtnFileUploader uFTFtnFileUploader = UFTFtnFileUploader.this;
                        uFTFtnFileUploader.F(9303, uFTFtnFileUploader.f305057j, "readfilefail", null);
                    }
                }
            });
            return;
        }
        if (!this.f305064q.a(this.f305055h, j3, H)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "] upload file data fail");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTFtnFileUploader.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (UFTFtnFileUploader.this.f305056i) {
                            return;
                        }
                        UFTFtnFileUploader uFTFtnFileUploader = UFTFtnFileUploader.this;
                        uFTFtnFileUploader.F(AppConstants.RichMediaErrorCode.ERROR_EXP_INTERRUPT, uFTFtnFileUploader.f305057j, "uploadfiledatafail", null);
                    }
                }
            });
        }
    }

    private void K(long j3, String str) {
        String str2 = "RangSizeError_rangError tSize[" + j3 + "]<=mSize[" + this.f305057j + "], lastRoolbackSize[" + this.f305065r + "], retry[" + this.f305066s + "]";
        if (j3 <= this.f305065r) {
            int i3 = this.f305066s + 1;
            this.f305066s = i3;
            if (i3 > 6) {
                F(9009, j3, str2, str);
                return;
            }
        }
        this.f305065r = j3;
        this.f305057j = j3;
        com.tencent.mobileqq.uftransfer.a.a().c(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTFtnFileUploader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    if (UFTFtnFileUploader.this.f305056i) {
                        return;
                    }
                    UFTFtnFileUploader uFTFtnFileUploader = UFTFtnFileUploader.this;
                    uFTFtnFileUploader.J(uFTFtnFileUploader.f305057j);
                }
            }
        }, 6000L);
        s(j3, str2, str);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.a
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return 6000L;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.a
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        if (this.f305056i) {
            return;
        }
        if (!str.equals(this.f305055h)) {
            d(str);
        }
        this.f305055h = str;
        this.f305063p = new com.tencent.mobileqq.uftransfer.depend.d();
        this.f305057j = 0L;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFtnFileUploader", 1, "Id[" + this.f305051d + "] onRetry. url:" + str);
        l(this.f305055h);
        J(0L);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.b
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            if (this.f305056i) {
                return;
            }
            F(AppConstants.RichMediaErrorCode.ERROIR_HTTP_CODE_REDIRECT, this.f305057j, "UrlOver", null);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        w(true);
        C();
        B();
        this.f305056i = true;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "] cancel");
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f305054g.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, j3)).booleanValue();
        }
        boolean z16 = false;
        w(false);
        if (this.f305064q == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "]uploadFile fail. uploader is null");
            return false;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "]uploadFile url:" + this.f305055h + " pos:" + j3);
        this.f305061n = true;
        this.f305067t = false;
        this.f305056i = false;
        byte[] H = H(j3);
        if (H != null) {
            z16 = this.f305064q.a(this.f305055h, j3, H);
        }
        if (z16) {
            long j16 = this.f305059l;
            if (j16 > j3) {
                this.f305062o = j16 - j3;
                if (!z16) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "id[" + this.f305051d + "]uploadFile return fail");
                    this.f305056i = true;
                }
                return z16;
            }
        }
        this.f305062o = 0L;
        if (!z16) {
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public int getRetryCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f305054g.a();
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f305055h;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.f305057j;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.b
    public void i(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
        } else {
            if (this.f305056i) {
                return;
            }
            F(AppConstants.RichMediaErrorCode.ERROR_DECODE_EXP, this.f305057j, "parseDataErr", null);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.b
    public void o(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), str);
            return;
        }
        if (this.f305056i) {
            return;
        }
        this.f305063p.c();
        if (this.f305061n) {
            this.f305061n = false;
            if (j3 == this.f305062o) {
                this.f305060m = 0L;
            } else {
                this.f305060m = j3;
            }
        }
        long j16 = this.f305057j;
        if (j3 <= j16) {
            K(j3, str);
            return;
        }
        if (j16 == 0) {
            long j17 = this.f305053f;
            if (j3 == j17) {
                this.f305060m = 0L;
                this.f305057j = j17;
                this.f305067t = true;
                G(true);
                return;
            }
        }
        this.f305057j = j3;
        if (com.tencent.mobileqq.uftransfer.depend.c.d()) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFtnFileUploader", 4, "send http data size[" + String.valueOf(this.f305057j) + "] fileSize[" + this.f305053f + "] success!");
        }
        if (j3 < this.f305053f) {
            m(j3, this.f305060m, 0L);
            this.f305054g.g(this.f305055h);
            J(this.f305057j);
            return;
        }
        G(false);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.f305060m;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public void q(com.tencent.mobileqq.uftransfer.common.transfer.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            v(bVar);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.b
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.f305056i) {
            return;
        }
        long j3 = this.f305053f;
        this.f305057j = j3;
        if (this.f305061n) {
            this.f305061n = false;
            this.f305060m = j3;
            this.f305067t = true;
        }
        G(this.f305067t);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.b
    public void t(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.f305056i) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "Id[" + this.f305051d + "] onUploadErr.errcode:" + i3 + " errMsg:" + str);
        if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnFileUploader", 1, "Id[" + this.f305051d + "] onUploadErr. no network");
            F(9004, this.f305057j, str, str2);
            return;
        }
        if (-9527 == i3 && str != null) {
            if (str.indexOf("-29602") > 0) {
                F(-29602, this.f305057j, str, str2);
                return;
            }
            if (str.indexOf("-6101") > 0) {
                F(9042, this.f305057j, str, str2);
                return;
            }
            if (str.indexOf("-29120") > 0) {
                n();
                return;
            } else if (str.indexOf("-38006") > 0 || str.indexOf("-38007") > 0 || str.indexOf("-38020") > 0) {
                F(i3, this.f305057j, str, str2);
                return;
            }
        }
        if (str != null && str.contains("SSLPeerUnverifiedException")) {
            F(i3, this.f305057j, str, str2);
        } else if (this.f305054g.h(this.f305055h, i3, false)) {
            k(false, i3, this.f305057j, str, str2, null);
        } else {
            F(i3, this.f305057j, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f305056i;
    }

    UFTFtnFileUploader(AppRuntime appRuntime, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) hVar);
            return;
        }
        this.f305056i = true;
        this.f305057j = 0L;
        this.f305058k = null;
        this.f305059l = 0L;
        this.f305060m = 0L;
        this.f305061n = false;
        this.f305062o = 0L;
        this.f305063p = new com.tencent.mobileqq.uftransfer.depend.d();
        this.f305065r = 0L;
        this.f305066s = 0;
        this.f305067t = false;
        long d16 = hVar.d();
        this.f305051d = d16;
        String e16 = hVar.e();
        this.f305052e = e16;
        long length = new File(e16).length();
        this.f305053f = length;
        if (hVar.f()) {
            this.f305054g = new com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.c(appRuntime, hVar.k(), hVar.m(), d16, hVar.n(), this);
        } else {
            this.f305054g = new UFTUrlProvider(appRuntime, hVar.k(), hVar.m(), d16, hVar.n(), this);
        }
        this.f305055h = this.f305054g.c();
        d.a aVar = new d.a();
        aVar.b(length);
        aVar.e(hVar.c());
        aVar.c(0);
        aVar.f(hVar.s());
        aVar.h(hVar.t());
        aVar.d(hVar.n());
        aVar.g(hVar.l());
        aVar.i(hVar.u());
        d m3 = d.m(appRuntime, d16, aVar);
        this.f305064q = m3;
        if (m3 != null) {
            m3.b(this);
        }
    }
}
