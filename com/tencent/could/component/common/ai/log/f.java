package com.tencent.could.component.common.ai.log;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public File f99971a;

    /* renamed from: b, reason: collision with root package name */
    public volatile BufferedWriter f99972b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference<Context> f99973c;

    public f(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f99973c = new WeakReference<>(context);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (this.f99972b != null) {
                this.f99972b.close();
            }
        } catch (Exception e16) {
            Log.e("LogWriter", "close writer fail! e: " + e16.getMessage());
        } finally {
            this.f99972b = null;
            this.f99971a = null;
        }
    }
}
