package com.tencent.tmdownloader.internal.remote;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends a.AbstractBinderC10005a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        r.b("RemoteOpImpl", "<RemoteOpImpl.postReport> process:" + l.a() + ", type = " + i3 + ", data = " + str);
        SDKReportManager2.getInstance().postReport(i3, str);
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            SDKReportManager2.getInstance();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        return Settings.getInstance().getBoolean(str);
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            com.tencent.tmdownloader.f.a.a.a().e();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            com.tencent.tmdownloader.f.a.a.a().f();
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.tmdownloader.f.a.a.a().g();
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            Settings.getInstance().setString(str, str2);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public byte[] d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? Settings.getInstance().getBlob(str) : (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public long e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? Settings.getInstance().getLong(str) : ((Long) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).longValue();
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void a(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        r.b("RemoteOpImpl", "<RemoteOpImpl.postReport> process:" + l.a() + ", key = " + str + ", valueSize = " + bArr.length);
        Settings.getInstance().setBlob(str, bArr);
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? Settings.getInstance().getString(str) : (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            Settings.getInstance().setInt(str, i3);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            Settings.getInstance().setLong(str, j3);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            Settings.getInstance().setBoolean(str, z16);
        } else {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? Settings.getInstance().getInt(str) : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).intValue();
    }

    @Override // com.tencent.tmdownloader.internal.remote.a
    public int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? com.tencent.tmassistant.appinfo.a.b.a().a(appDetailReqParam, iGetAppInfoCallback) : ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appDetailReqParam, (Object) iGetAppInfoCallback)).intValue();
    }
}
