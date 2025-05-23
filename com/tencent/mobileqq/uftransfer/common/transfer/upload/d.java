package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.depend.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends com.tencent.mobileqq.uftransfer.depend.b implements com.tencent.mobileqq.uftransfer.common.transfer.upload.a {
    static IPatchRedirector $redirector_;
    private final byte[] C;
    private a D;
    private b E;

    /* renamed from: m, reason: collision with root package name */
    private final byte[] f305081m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected int f305082a;

        /* renamed from: b, reason: collision with root package name */
        protected int f305083b;

        /* renamed from: c, reason: collision with root package name */
        protected String f305084c;

        /* renamed from: d, reason: collision with root package name */
        protected String f305085d;

        /* renamed from: e, reason: collision with root package name */
        protected long f305086e;

        /* renamed from: f, reason: collision with root package name */
        protected boolean f305087f;

        /* renamed from: g, reason: collision with root package name */
        protected String f305088g;

        /* renamed from: h, reason: collision with root package name */
        protected String f305089h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (TextUtils.isEmpty(this.f305084c)) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "strCheckSum is empty");
                return false;
            }
            if (!TextUtils.isEmpty(this.f305085d)) {
                return true;
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "strSHA is empty");
            return false;
        }

        public void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else {
                this.f305086e = j3;
            }
        }

        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f305083b = i3;
            }
        }

        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.f305087f = z16;
            }
        }

        public void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.f305082a = i3;
            }
        }

        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                this.f305084c = str;
            }
        }

        public void g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                this.f305088g = str;
            }
        }

        public void h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.f305085d = str;
            }
        }

        public void i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.f305089h = str;
            }
        }
    }

    d(AppRuntime appRuntime, long j3, a aVar) {
        super(appRuntime, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Long.valueOf(j3), aVar);
            return;
        }
        this.D = aVar;
        this.f305081m = com.tencent.mobileqq.uftransfer.depend.a.y(aVar.f305084c);
        this.C = com.tencent.mobileqq.uftransfer.depend.a.y(aVar.f305085d);
    }

    public static d m(AppRuntime appRuntime, long j3, a aVar) {
        if (aVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTFtnDataUploader", 1, "DlderAttr is null");
            return null;
        }
        if (!aVar.a()) {
            return null;
        }
        return new d(appRuntime, j3, aVar);
    }

    private byte[] n(long j3, byte[] bArr) {
        byte[] bArr2;
        int length = this.f305081m.length + 2 + 2 + this.C.length + 20 + bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length + 16);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(-1412589450);
                dataOutputStream.writeInt(1007);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(length);
                dataOutputStream.writeShort(this.f305081m.length);
                dataOutputStream.write(this.f305081m);
                dataOutputStream.writeShort(this.C.length);
                dataOutputStream.write(this.C);
                dataOutputStream.writeInt((int) (this.D.f305086e & 4294967295L));
                dataOutputStream.writeInt((int) (j3 & 4294967295L));
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.writeInt((int) (this.D.f305086e >> 32));
                dataOutputStream.writeInt((int) (j3 >> 32));
                dataOutputStream.write(bArr, 0, bArr.length);
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (IOException e16) {
                e16.printStackTrace();
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "id[" + this.f305127e + "] packageData exception:" + e16.toString());
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused) {
                }
                bArr2 = null;
            }
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused2) {
            }
            return bArr2;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th5;
        }
    }

    private void o(byte[] bArr, String str) {
        int readInt;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            try {
                dataInputStream.skip(4L);
                readInt = dataInputStream.readInt();
            } catch (IOException e16) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "id[" + this.f305127e + "] unPackageData exception:" + e16.toString());
                this.E.i(9001, "httpServer flag!=0 flag!=1");
            }
            if (readInt != 0) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "id[" + this.f305127e + "] unPackageData retErrCode:" + readInt);
                this.E.i(9001, "httpServer retCode!=0");
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            dataInputStream.skip(8L);
            byte readByte = dataInputStream.readByte();
            if (readByte == 0) {
                this.E.o(dataInputStream.readInt() | (dataInputStream.readInt() << 32), str);
            } else if (readByte == 1) {
                this.E.r();
            } else {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "id[" + this.f305127e + "] unPackageData errFlag:" + ((int) readByte));
                this.E.i(9001, "httpServer flag!=0 flag!=1");
            }
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th5) {
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (Exception unused3) {
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public boolean a(String str, long j3, byte[] bArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), bArr)).booleanValue();
        }
        byte[] n3 = n(j3, bArr);
        if (n3 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 2, "id[" + this.f305127e + "] sendData packageData return null");
            return false;
        }
        b.C8867b c8867b = new b.C8867b(str, n3, false);
        c8867b.v("POST");
        c8867b.w(5);
        c8867b.q(this.D.f305083b);
        c8867b.p(this.D.f305082a);
        c8867b.x(this.D.f305089h);
        if (str != null) {
            str2 = str.toLowerCase();
        } else {
            str2 = "";
        }
        if (this.D.f305087f && str2.startsWith("https")) {
            c8867b.s(true);
            c8867b.r(com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.b.d(str));
            c8867b.u(this.D.f305088g);
        }
        return l(c8867b);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.E = bVar;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void i(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnDataUploader", 1, "id[" + this.f305127e + "] onError errCode:" + aVar.a() + " errMsg:" + aVar.b());
        this.E.t(aVar.a(), aVar.b(), aVar.c());
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.E.c(str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void k(b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            o(cVar.b(), cVar.a());
        }
    }
}
