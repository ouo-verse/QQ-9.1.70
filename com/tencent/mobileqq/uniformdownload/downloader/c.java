package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static String f305960n;

    /* renamed from: a, reason: collision with root package name */
    protected String f305961a;

    /* renamed from: b, reason: collision with root package name */
    protected String f305962b;

    /* renamed from: c, reason: collision with root package name */
    protected long f305963c;

    /* renamed from: d, reason: collision with root package name */
    protected String f305964d;

    /* renamed from: e, reason: collision with root package name */
    protected String f305965e;

    /* renamed from: f, reason: collision with root package name */
    protected final long f305966f;

    /* renamed from: g, reason: collision with root package name */
    protected String f305967g;

    /* renamed from: h, reason: collision with root package name */
    protected int f305968h;

    /* renamed from: i, reason: collision with root package name */
    protected Object f305969i;

    /* renamed from: j, reason: collision with root package name */
    protected int f305970j;

    /* renamed from: k, reason: collision with root package name */
    protected Object f305971k;

    /* renamed from: l, reason: collision with root package name */
    protected int f305972l;

    /* renamed from: m, reason: collision with root package name */
    protected Object f305973m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f305960n = "UniformDownloaderAssinfo";
        }
    }

    public c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.f305961a = null;
        this.f305963c = 0L;
        this.f305967g = null;
        this.f305968h = 0;
        this.f305969i = new Object();
        this.f305970j = 0;
        this.f305971k = new Object();
        this.f305972l = 0;
        this.f305973m = new Object();
        this.f305966f = j3;
    }

    public int c(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle)).intValue();
        }
        if (f()) {
            return 0;
        }
        synchronized (this) {
            if (str != null && bundle != null) {
                this.f305961a = str;
                this.f305964d = bundle.getString("_PARAM_FILEPATH");
                this.f305965e = bundle.getString("_PARAM_TMP_FILEPATH");
                this.f305962b = bundle.getString("_PARAM_FILENAME");
                this.f305963c = bundle.getLong("_PARAM_FILESIZE");
                this.f305967g = bundle.getString("_PARAM_COOKIE");
                QLog.i(f305960n, 1, "[UniformDL][" + this.f305966f + "] init. ST:" + getStatus() + " PGR:" + e());
                i(1);
                return 0;
            }
            QLog.e(f305960n, 1, "[UniformDL][" + this.f305966f + "]. init param error");
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        synchronized (this.f305969i) {
            i3 = this.f305968h;
        }
        return i3;
    }

    public int e() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        synchronized (this.f305971k) {
            i3 = this.f305970j;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (getStatus() >= 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        synchronized (this.f305969i) {
            this.f305968h = i3;
        }
    }

    public int getStatus() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        synchronized (this.f305973m) {
            i3 = this.f305972l;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        synchronized (this.f305971k) {
            this.f305970j = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        synchronized (this.f305973m) {
            QLog.i(f305960n, 1, "[UniformDL][" + this.f305966f + "] setStatus. " + this.f305972l + "->" + i3);
            this.f305972l = i3;
        }
    }
}
