package com.tencent.mobileqq.qqlive.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.sso.IBufferHeaderHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private FromServiceMsg f273201a;

    /* renamed from: b, reason: collision with root package name */
    private int f273202b;

    /* renamed from: c, reason: collision with root package name */
    private String f273203c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f273204d;

    /* renamed from: e, reason: collision with root package name */
    private int f273205e;

    /* renamed from: f, reason: collision with root package name */
    private int f273206f;

    /* renamed from: g, reason: collision with root package name */
    private int f273207g;

    /* renamed from: h, reason: collision with root package name */
    private String f273208h;

    /* renamed from: i, reason: collision with root package name */
    private String f273209i;

    /* renamed from: j, reason: collision with root package name */
    private String f273210j;

    public h(FromServiceMsg fromServiceMsg, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fromServiceMsg, str, str2);
            return;
        }
        this.f273201a = fromServiceMsg;
        this.f273209i = str;
        this.f273210j = str2;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f273209i;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f273207g;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f273208h;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f273210j;
    }

    public byte[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f273204d;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f273203c;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f273202b;
    }

    public FromServiceMsg h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f273201a;
    }

    public h(IBufferHeaderHandler iBufferHeaderHandler, FromServiceMsg fromServiceMsg, byte[] bArr, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iBufferHeaderHandler, fromServiceMsg, bArr, str, str2);
            return;
        }
        this.f273201a = fromServiceMsg;
        this.f273209i = str;
        this.f273210j = str2;
        try {
            if (iBufferHeaderHandler != null) {
                this.f273204d = iBufferHeaderHandler.unpackRspHeader(bArr);
                this.f273207g = fromServiceMsg.getBusinessFailCode();
                this.f273208h = fromServiceMsg.getBusinessFailMsg();
            } else {
                dr4.c c16 = dr4.c.c(bArr);
                this.f273202b = c16.f394715a;
                this.f273203c = c16.f394716b;
                this.f273204d = c16.f394717c;
                this.f273205e = c16.f394718d;
                this.f273206f = c16.f394719e;
                this.f273207g = c16.f394720f;
                this.f273208h = c16.f394721g;
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveRspData", 2, "QQLiveRspData ProxyRsp:" + c16);
                }
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("QQLiveRspData", 1, "QQLiveRspData throw exception:" + e16.getMessage());
        }
    }
}
