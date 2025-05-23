package com.hihonor.cloudservice.common.q;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import b2.a;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends q.q.q.w.q.b {

    /* renamed from: h, reason: collision with root package name */
    private final Bundle f36208h;

    /* renamed from: i, reason: collision with root package name */
    private final String f36209i;

    /* compiled from: P */
    /* renamed from: com.hihonor.cloudservice.common.q.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class BinderC0254a extends a.AbstractBinderC0086a {
        BinderC0254a() {
        }

        @Override // b2.a
        public void d3(DataBuffer dataBuffer) {
            e.c("AuthOperationTask", "onResult", true);
            if (!((q.q.q.w.q.b) a.this).f428130e.get()) {
                a.this.e();
                String str = dataBuffer.f36216e;
                Bundle bundle = dataBuffer.f36218h;
                int i3 = bundle.getInt("retCode");
                e.c("AuthOperationTask", "onResult retCode:" + i3, true);
                if (i3 == 0) {
                    if (!str.equals("honorid.signout")) {
                        if (!str.equals("honorid.revokeaccess")) {
                            if (str.equals("honorid.getScope")) {
                                ((Intent) bundle.getParcelable("data")).getExtras();
                                a.i(a.this);
                                throw null;
                            }
                            a.i(a.this);
                            throw null;
                        }
                        a.i(a.this);
                        throw null;
                    }
                    e.c("AuthOperationTask", "opensdk signOut", true);
                    a.i(a.this);
                    throw null;
                }
                if (i3 != 2001) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            if (i3 != 9) {
                                if (i3 != 1) {
                                    if (i3 != 5) {
                                        if (i3 == 2002) {
                                            a.i(a.this);
                                            new ErrorStatus(2002, "has not auth");
                                            throw null;
                                        }
                                        a.i(a.this);
                                        new ErrorStatus(44, "other error");
                                        throw null;
                                    }
                                    a.i(a.this);
                                    new ErrorStatus(69, "uid not match");
                                    throw null;
                                }
                                a.i(a.this);
                                new ErrorStatus(29, "Signature invalid");
                                throw null;
                            }
                            a.i(a.this);
                            new ErrorStatus(43, "packagename not in honorid list");
                            throw null;
                        }
                        a.i(a.this);
                        new ErrorStatus(44, "packagename was not matched");
                        throw null;
                    }
                    a.i(a.this);
                    new ErrorStatus(42, "userid not system account");
                    throw null;
                }
                a.i(a.this);
                new ErrorStatus(31, "Account has not login");
                throw null;
            }
            e.c("AuthOperationTask", "has cancelled by timeout, return directly", true);
        }
    }

    static /* synthetic */ z1.b i(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // q.q.q.w.q.b
    protected void a() {
        DataBuffer dataBuffer = new DataBuffer(this.f36209i, 1001);
        dataBuffer.f36218h = this.f36208h;
        try {
            q.q.q.w.q.a.c(this.f428131f).a().L4(dataBuffer, new BinderC0254a());
        } catch (RemoteException unused) {
            e.b("AuthOperationTask", "authOperation remote exception", true);
        }
    }

    @Override // q.q.q.w.q.b
    public void b(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            new ErrorStatus(39, "authOperation timeout. retry again");
        }
        throw null;
    }
}
