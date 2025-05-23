package com.tencent.mobileqq.qqbattery;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends e implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public volatile int C;
    public final Handler D;
    public final HandlerThread E;

    /* renamed from: f, reason: collision with root package name */
    public final b f262356f;

    /* renamed from: h, reason: collision with root package name */
    public final a f262357h;

    /* renamed from: i, reason: collision with root package name */
    public final c f262358i;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f262359m;

    public g(b bVar, a aVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, aVar, cVar);
            return;
        }
        this.f262359m = false;
        this.C = 0;
        this.f262356f = bVar;
        this.f262357h = aVar;
        this.f262358i = cVar;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qq_battery_thread");
        this.E = baseHandlerThread;
        baseHandlerThread.start();
        this.D = new Handler(baseHandlerThread.getLooper(), this);
        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_QQBatteryMonitorCore", "#configure", new Object[0]);
        Iterator<com.tencent.mobileqq.qqbattery.feature.e> it = bVar.b().iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.d
    public void a(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (!f.d()) {
            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_QQBatteryMonitorCore", "QQBattery was not installed yet, just ignore the event", new Object[0]);
        }
        try {
            synchronized (g.class) {
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                if (this.C == i3) {
                    com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_QQBatteryMonitorCore", "foreground state is same, isForeground = " + z16 + ", just ignore the event", new Object[0]);
                    return;
                }
                this.C = i3;
                com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_QQBatteryMonitorCore", "#onForeground foreground = " + z16, new Object[0]);
                Iterator<com.tencent.mobileqq.qqbattery.feature.e> it = this.f262356f.b().iterator();
                while (it.hasNext()) {
                    it.next().a(z16);
                }
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_QQBatteryMonitorCore", e16, "onForeground error", new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.e
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.f();
        synchronized (g.class) {
            if (!this.f262359m) {
                com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_QQBatteryMonitorCore", "#onTurnOn", new Object[0]);
                Iterator<com.tencent.mobileqq.qqbattery.feature.e> it = this.f262356f.b().iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                this.f262359m = true;
                if (this.f262356f.e()) {
                    a(j().a());
                }
            }
        }
    }

    public a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f262357h;
    }

    public b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f262356f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    public Handler i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Handler) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.D;
    }

    public c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f262358i;
    }

    public <T extends com.tencent.mobileqq.qqbattery.feature.e> T k(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
        }
        Iterator<com.tencent.mobileqq.qqbattery.feature.e> it = this.f262356f.b().iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isAssignableFrom(t16.getClass())) {
                return t16;
            }
        }
        return null;
    }

    public HandlerThread l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.E;
    }
}
