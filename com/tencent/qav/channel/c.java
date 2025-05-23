package com.tencent.qav.channel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static c f342361f;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f342362d;

    /* renamed from: e, reason: collision with root package name */
    private int f342363e;

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c z() {
        if (f342361f == null) {
            synchronized (c.class) {
                if (f342361f == null) {
                    f342361f = new c();
                }
            }
        }
        return f342361f;
    }

    public void A(AppRuntime appRuntime) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof AppInterface) {
            i3 = ((AppInterface) appRuntime).getAppid();
        } else {
            i3 = 0;
        }
        this.f342362d = appRuntime;
        this.f342363e = i3;
    }

    @Override // com.tencent.qav.channel.a
    protected long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        AppRuntime appRuntime = this.f342362d;
        if (appRuntime != null) {
            return appRuntime.getLongAccountUin();
        }
        return 0L;
    }

    @Override // com.tencent.qav.channel.a
    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 5);
        newIntent.putExtra("app_id", this.f342363e);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void p(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void q(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 7);
        newIntent.putExtra("uin", j3);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void s(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 4);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void t(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 3);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void u(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 100);
        newIntent.putExtra("sso_cmd", str);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void w(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 2);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }

    @Override // com.tencent.qav.channel.a
    protected void x(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f342362d.getApplication(), f.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        newIntent.putExtra("wup_buffer", bArr);
        this.f342362d.startServlet(newIntent);
    }
}
