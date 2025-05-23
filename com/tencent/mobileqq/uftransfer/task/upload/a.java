package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a extends UFTBaseOp implements com.tencent.mobileqq.uftransfer.common.transfer.b {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.common.transfer.a f305476j;

    /* renamed from: k, reason: collision with root package name */
    protected AbstractC8873a f305477k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f305478l;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.task.upload.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static abstract class AbstractC8873a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        public AbstractC8873a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        public abstract void d(long j3, long j16, long j17);

        public abstract void e(int i3, String str, long j3, String str2, Object obj);

        public abstract void f(String str);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends UFTBaseOp.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        private boolean f305479f;

        /* renamed from: g, reason: collision with root package name */
        private String f305480g;

        /* renamed from: h, reason: collision with root package name */
        private Object f305481h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f305482i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f305483j;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f305479f = false;
            this.f305482i = false;
            this.f305483j = false;
        }

        public Object n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f305481h;
        }

        public String o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f305480g;
        }

        public boolean p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.f305483j;
        }

        public boolean q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f305479f;
        }

        public boolean r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.f305482i;
        }
    }

    public a(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar2, AbstractC8873a abstractC8873a) {
        super(appRuntime, aVar, aVar2, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, aVar2, abstractC8873a);
        } else {
            this.f305478l = false;
            this.f305477k = abstractC8873a;
        }
    }

    public long A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar != null) {
            return aVar.h();
        }
        return 0L;
    }

    public String B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar != null) {
            return aVar.getUrl();
        }
        return "";
    }

    public abstract boolean C();

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bVar);
        } else {
            r(bVar);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void d(String str) {
        AbstractC8873a abstractC8873a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (!this.f305346e && (abstractC8873a = this.f305477k) != null) {
            abstractC8873a.f(str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void f(Object obj) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, obj);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUploadFileBaseOp", 1, "TId[" + p() + "] on sub uploader success");
        if (!this.f305346e && this.f305477k != null) {
            com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
            if (aVar != null) {
                j3 = aVar.h();
            } else {
                j3 = 0;
            }
            this.f305477k.e(0, "", j3, null, obj);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void j(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), obj);
            return;
        }
        this.f305478l = z16;
        if (!this.f305346e && this.f305477k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUploadFileBaseOp", 1, "TId[" + p() + "] on upload suc. isflash:" + z16);
            b bVar = new b();
            bVar.f(0);
            bVar.f305479f = z16;
            bVar.f305481h = obj;
            com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
            if (aVar != null) {
                bVar.f305482i = aVar.e();
            }
            bVar.f305483j = C();
            D(bVar);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void k(boolean z16, int i3, long j3, String str, String str2, Object obj) {
        int i16;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, obj);
            return;
        }
        if (!this.f305346e && this.f305477k != null) {
            if (i3 == 0) {
                i16 = 9001;
            } else {
                i16 = i3;
            }
            if (TextUtils.isEmpty(str)) {
                str3 = "errMsgString_NUll_retCode[" + i16 + "]";
            } else {
                str3 = str;
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTUploadFileBaseOp", 1, "TId[" + p() + "] on upload err. finished:" + z16 + " errcode:" + i16 + " errmsg:" + str3 + " tsize:" + j3 + " rspheader:" + str2);
            if (z16) {
                b bVar = new b();
                bVar.f(i16);
                bVar.g(str3);
                bVar.f305481h = obj;
                bVar.f305480g = str2;
                com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
                if (aVar != null) {
                    bVar.f305482i = aVar.e();
                }
                bVar.f305483j = C();
                D(bVar);
                return;
            }
            this.f305477k.e(i16, str3, j3, str2, obj);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void m(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (!this.f305346e && this.f305477k != null) {
            if (com.tencent.mobileqq.uftransfer.depend.c.d()) {
                com.tencent.mobileqq.uftransfer.depend.c.a("[UFTTransfer] UFTUploadFileBaseOp", 4, "TId[" + p() + "] on upload progress. fsize:" + this.f305343b.d().f() + " tsize:" + j3 + " speed:" + j17);
            }
            this.f305477k.d(j3, j16, j17);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void n() {
        AbstractC8873a abstractC8873a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTUploadFileBaseOp", 1, "TId[" + p() + "] on upload url or file id outdate");
        if (!this.f305346e && (abstractC8873a = this.f305477k) != null) {
            abstractC8873a.c();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void s(long j3, String str, String str2) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), str, str2);
            return;
        }
        if (!this.f305346e && this.f305477k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTUploadFileBaseOp", 1, "TId[" + p() + "] on upload roll back. rollbackPos:" + j3);
            if (TextUtils.isEmpty(str)) {
                str = "errMsgString_ServerRollback[9009]";
            }
            String str3 = str;
            com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
            if (aVar != null) {
                j16 = aVar.h();
            } else {
                j16 = 0;
            }
            this.f305477k.e(9009, str3, j16, str2, null);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        this.f305478l = false;
        return super.u();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.v();
        this.f305477k = null;
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        long j3 = this.f305349h;
        if (j3 <= 0) {
            return 0L;
        }
        long j16 = this.f305350i;
        if (j16 > j3) {
            return j16 - j3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j17 = this.f305349h;
        if (currentTimeMillis <= j17) {
            return 0L;
        }
        return currentTimeMillis - j17;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar != null) {
            return aVar.getRetryCount();
        }
        return 0;
    }

    public long y() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        if (this.f305478l) {
            return 0L;
        }
        if (w() <= 0) {
            return 0L;
        }
        if (A() > z()) {
            j3 = A() - z();
        } else {
            j3 = 0;
        }
        if (j3 < 1024) {
            return 0L;
        }
        return ((float) j3) / (((float) r3) / 1000.0f);
    }

    public long z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar != null) {
            return aVar.p();
        }
        return 0L;
    }
}
