package com.hihonor.cloudservice.common.q;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import b2.a;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import h45.h;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends q.q.q.w.q.b {

    /* renamed from: h, reason: collision with root package name */
    private String f36211h;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f36212i;

    /* renamed from: m, reason: collision with root package name */
    private Context f36213m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends a.AbstractBinderC0086a {
        a() {
        }

        @Override // b2.a
        public void d3(DataBuffer dataBuffer) {
            ClassLoader classLoader;
            e.c("SilentLoginTask", "onResult", true);
            if (!((q.q.q.w.q.b) b.this).f428130e.get()) {
                b.this.e();
                Bundle bundle = dataBuffer.f36218h;
                if (b.this.f36213m.getClassLoader() == null) {
                    classLoader = a.class.getClassLoader();
                } else {
                    classLoader = b.this.f36213m.getClassLoader();
                }
                bundle.setClassLoader(classLoader);
                int i3 = bundle.getInt("retCode");
                e.c("SilentLoginTask", "execute : onResult retCode = " + i3, true);
                if (i3 == 0) {
                    HonorAccount b16 = new HonorAccount().b(((Intent) bundle.getParcelable("data")).getExtras());
                    b.this.i(b16);
                    m2.a.b(b.this.f36213m).c(b16);
                    m2.a.b(b.this.f36213m).a();
                    b.l(b.this);
                    k2.a.a(b.this.f36213m).a(b.this.f36213m, b16);
                    return;
                }
                if (i3 != 2002) {
                    if (i3 != 2001) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                String str = "";
                                if (i3 == 2009) {
                                    Bundle extras = ((Intent) bundle.getParcelable("data")).getExtras();
                                    int i16 = 56;
                                    if (extras != null) {
                                        i16 = extras.getInt(CheckForwardServlet.KEY_ERR_CODE, 56);
                                        str = extras.getString("server_err_desc", "access server return error");
                                    }
                                    e.b("SilentLoginTask", "loginResult : errCode = " + i16 + " errMsg = " + str, true);
                                    if (1101 != i16) {
                                        if (1202 == i16) {
                                            b.l(b.this);
                                            new ErrorStatus(68, str);
                                            throw null;
                                        }
                                        b.l(b.this);
                                        new ErrorStatus(i16, str);
                                        throw null;
                                    }
                                    b.l(b.this);
                                    new ErrorStatus(67, str);
                                    throw null;
                                }
                                if (i3 == 2004) {
                                    b.l(b.this);
                                    new ErrorStatus(2004, "password verification required");
                                    throw null;
                                }
                                b.l(b.this);
                                new ErrorStatus(i3, "");
                                throw null;
                            }
                            b.l(b.this);
                            new ErrorStatus(30, "serviceToken invalid");
                            throw null;
                        }
                        b.l(b.this);
                        new ErrorStatus(29, "Signature invalid");
                        throw null;
                    }
                    b.l(b.this);
                    new ErrorStatus(31, "Account hasnot login");
                    throw null;
                }
                b.l(b.this);
                new ErrorStatus(55, "scopes not authorize");
                throw null;
            }
            e.c("SilentLoginTask", "has cancelled by timeout, return directly", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(HonorAccount honorAccount) {
        String G0 = honorAccount.G0();
        if (TextUtils.isEmpty(G0) || "null".equalsIgnoreCase(G0)) {
            String a16 = h.a(this.f36213m, 0);
            if (a16 == null) {
                a16 = "";
            }
            honorAccount.L0(a16);
        }
    }

    static /* synthetic */ z1.a l(b bVar) {
        bVar.getClass();
        return null;
    }

    @Override // q.q.q.w.q.b
    protected void a() {
        e.c("SilentLoginTask", "LoginTask execute", true);
        b2.b a16 = q.q.q.w.q.a.c(this.f36213m).a();
        try {
            DataBuffer dataBuffer = new DataBuffer("honorid.silentsignin", 1001);
            m45.b bVar = new m45.b();
            dataBuffer.a(this.f36212i);
            l45.a aVar = new l45.a();
            this.f36212i.getString("clientId");
            this.f36212i.getString("packageName");
            dataBuffer.f36217f = aVar.a(bVar);
            a16.L4(dataBuffer, new a());
        } catch (RemoteException unused) {
            e.c("SilentLoginTask", "login remote exception", true);
        }
    }

    @Override // q.q.q.w.q.b
    public void b(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "login timeout. retry again");
        }
        e.c("SilentLoginTask", "timeout : Status = " + errorStatus.c(), true);
        throw null;
    }

    public String toString() {
        return "SilentLoginTask{mServiceType='" + this.f36211h + "'}";
    }
}
