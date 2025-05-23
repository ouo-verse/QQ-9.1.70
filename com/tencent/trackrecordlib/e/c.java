package com.tencent.trackrecordlib.e;

import android.content.Context;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f381111a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f381112b;

    /* renamed from: c, reason: collision with root package name */
    private int f381113c;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f381114d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11496);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f381111a = c.class.getSimpleName();
        }
    }

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f381112b = false;
        this.f381114d = (WindowManager) context.getSystemService("window");
        this.f381113c = c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        try {
            return this.f381114d.getDefaultDisplay().getRotation();
        } catch (Throwable th5) {
            Log.e(f381111a, "\u83b7\u53d6\u5c4f\u5e55\u65cb\u8f6c\u65b9\u5411\u51fa\u9519\uff01");
            th5.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.trackrecordlib.e.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f381112b = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.trackrecordlib.e.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            new BaseThread(new Runnable() { // from class: com.tencent.trackrecordlib.e.c.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    while (!c.this.f381112b) {
                        try {
                            int c16 = c.this.c();
                            if (c16 != c.this.f381113c) {
                                com.tencent.trackrecordlib.core.c.a().b(c16);
                            }
                            c.this.f381113c = c16;
                            LockMethodProxy.sleep(1000L);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }, "RotationMonitorThread").start();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
