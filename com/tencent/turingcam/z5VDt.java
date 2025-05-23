package com.tencent.turingcam;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class z5VDt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, spXPg> f382473a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f382474b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final akdmq f382475a;

        public spXPg(z5VDt z5vdt, HandlerThread handlerThread, akdmq akdmqVar) {
            super(handlerThread.getLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, z5vdt, handlerThread, akdmqVar);
            } else {
                this.f382475a = akdmqVar;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            try {
                this.f382475a.a(message);
            } catch (Throwable th5) {
                this.f382475a.a(th5);
            }
        }
    }

    public z5VDt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382473a = new ConcurrentHashMap();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MFA-ASYNC-WORKER");
        this.f382474b = baseHandlerThread;
        baseHandlerThread.setPriority(10);
        this.f382474b.start();
        new Handler(this.f382474b.getLooper());
    }

    public void a(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        spXPg spxpg = this.f382473a.get(str);
        if (spxpg != null) {
            spxpg.sendEmptyMessageDelayed(i3, j3);
        }
    }

    public void a(String str, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) message);
            return;
        }
        spXPg spxpg = this.f382473a.get(str);
        if (spxpg != null) {
            spxpg.sendMessageDelayed(message, 0L);
        }
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        spXPg spxpg = this.f382473a.get(str);
        if (spxpg != null) {
            spxpg.removeMessages(i3);
        }
    }

    public String a(akdmq akdmqVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) akdmqVar);
        }
        String uuid = UUID.randomUUID().toString();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MFA-ASYNC-WORKER-" + uuid);
        baseHandlerThread.start();
        this.f382473a.put(uuid, new spXPg(this, baseHandlerThread, akdmqVar));
        return uuid;
    }
}
