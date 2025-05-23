package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetworkCenter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f290254a;

    /* renamed from: b, reason: collision with root package name */
    private List<a> f290255b;

    /* renamed from: c, reason: collision with root package name */
    private String f290256c;

    /* renamed from: d, reason: collision with root package name */
    private int f290257d;

    /* renamed from: e, reason: collision with root package name */
    private long f290258e;

    /* renamed from: f, reason: collision with root package name */
    private short f290259f;

    /* renamed from: g, reason: collision with root package name */
    private short f290260g;

    /* renamed from: h, reason: collision with root package name */
    private short f290261h;

    /* renamed from: i, reason: collision with root package name */
    boolean f290262i;

    /* renamed from: j, reason: collision with root package name */
    public long f290263j;

    /* renamed from: k, reason: collision with root package name */
    public long f290264k;

    /* renamed from: l, reason: collision with root package name */
    public final int f290265l;

    public c(AppRuntime appRuntime, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        this.f290259f = (short) 0;
        this.f290260g = (short) 0;
        this.f290261h = (short) 1;
        this.f290262i = false;
        this.f290255b = new ArrayList();
        this.f290256c = str;
        this.f290254a = i16;
        this.f290265l = ((IStreamParams) QRoute.api(IStreamParams.class)).getSliceSize(appRuntime, i3, NetworkCenter.getInstance().getNetType());
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(str);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f290254a;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f290259f = (short) 0;
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (!z16) {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(this.f290256c);
        } else {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(this.f290256c);
        }
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f290257d;
    }

    public File e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (File) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new File(this.f290256c);
    }

    public short f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Short) iPatchRedirector.redirect((short) 9, (Object) this)).shortValue();
        }
        return this.f290260g;
    }

    public List<a> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f290255b;
    }

    public short h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Short) iPatchRedirector.redirect((short) 13, (Object) this)).shortValue();
        }
        return this.f290261h;
    }

    public short i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Short) iPatchRedirector.redirect((short) 15, (Object) this)).shortValue();
        }
        return this.f290259f;
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f290257d = i3;
        }
    }

    public void k(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Short.valueOf(s16));
        } else {
            this.f290260g = s16;
        }
    }

    public void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        } else {
            this.f290258e = j3;
        }
    }

    public void m(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Short.valueOf(s16));
        } else {
            this.f290261h = s16;
        }
    }

    public void n(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Short.valueOf(s16));
        } else {
            this.f290259f = s16;
        }
    }

    public void o(byte[] bArr, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr, i3);
        } else {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(this.f290256c, bArr, i3);
        }
    }
}
