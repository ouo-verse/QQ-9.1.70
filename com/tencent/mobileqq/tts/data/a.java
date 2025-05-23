package com.tencent.mobileqq.tts.data;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends InputStream {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final HttpURLConnection f303365d;

    /* renamed from: e, reason: collision with root package name */
    private final InputStream f303366e;

    /* renamed from: f, reason: collision with root package name */
    private final String f303367f;

    /* renamed from: h, reason: collision with root package name */
    private final long f303368h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f303369i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303370m;

    public a(HttpURLConnection httpURLConnection, InputStream inputStream, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, httpURLConnection, inputStream, str, Boolean.valueOf(z16));
            return;
        }
        this.f303370m = false;
        this.C = true;
        this.D = true;
        this.f303365d = httpURLConnection;
        this.f303366e = inputStream;
        this.f303367f = str;
        this.f303368h = NetConnInfoCenter.getServerTimeMillis();
        this.f303369i = z16;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            if (!this.f303369i) {
                return;
            }
            e.a().a(this.f303367f, this.f303368h, Boolean.valueOf(z16));
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 == -1 || !this.f303369i) {
            return;
        }
        if (!this.f303370m) {
            this.f303370m = true;
            this.C = e.a().b(this.f303367f, this.f303368h);
        }
        if (this.C && this.D) {
            this.D = e.a().d(this.f303367f, this.f303368h, i3);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.close();
        this.f303365d.disconnect();
        QLog.d("ConnectionInputStream", 1, "[close] connection disconnect.", this.f303365d);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int read = this.f303366e.read();
        b(read);
        return read;
    }
}
