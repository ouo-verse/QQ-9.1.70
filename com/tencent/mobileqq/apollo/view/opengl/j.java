package com.tencent.mobileqq.apollo.view.opengl;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j extends Writer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private StringBuilder f194435d;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f194435d = new StringBuilder();
        }
    }

    private void a() {
        if (this.f194435d.length() > 0) {
            Log.v("GLTextureView", this.f194435d.toString());
            StringBuilder sb5 = this.f194435d;
            sb5.delete(0, sb5.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            char c16 = cArr[i3 + i17];
            if (c16 == '\n') {
                a();
            } else {
                this.f194435d.append(c16);
            }
        }
    }
}
