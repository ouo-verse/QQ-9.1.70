package com.tencent.halley.downloader.c;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile i f113704b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f113705a;

    /* renamed from: c, reason: collision with root package name */
    private int f113706c;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends InputStream {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final InputStream f113707a;

        /* renamed from: b, reason: collision with root package name */
        int f113708b;

        public a(InputStream inputStream, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, inputStream, Integer.valueOf(i3));
            } else {
                this.f113707a = inputStream;
                this.f113708b = i3 <= 0 ? 0 : i3;
            }
        }

        @Override // java.io.InputStream
        public final int read() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f113707a.read() : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? read(bArr, 0, bArr.length) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr)).intValue();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int i18 = this.f113708b;
            if (i18 <= 0) {
                return this.f113707a.read(bArr, i3, i16);
            }
            int i19 = i18 * 1024;
            while (i17 < i16) {
                int min = Math.min(i19, i16 - i17);
                long currentTimeMillis = System.currentTimeMillis();
                int read = this.f113707a.read(bArr, i3 + i17, min);
                if (read <= 0) {
                    return -1;
                }
                i17 += read;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j3 = (read * 1000) / i19;
                if (currentTimeMillis2 < j3) {
                    long j16 = j3 - currentTimeMillis2;
                    if (j16 > 0) {
                        SystemClock.sleep(j16);
                    }
                }
            }
            return i17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f113704b = null;
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113706c = 0;
            this.f113705a = new ArrayList<>();
        }
    }

    public static i a() {
        if (f113704b == null) {
            synchronized (i.class) {
                if (f113704b == null) {
                    f113704b = new i();
                }
            }
        }
        return f113704b;
    }

    public final void a(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputStream);
        } else if ((inputStream instanceof a) && this.f113705a.contains(inputStream)) {
            this.f113705a.remove(inputStream);
        }
    }

    public static void a(InputStream inputStream, int i3) {
        if (inputStream instanceof a) {
            ((a) inputStream).f113708b = i3;
        }
    }
}
