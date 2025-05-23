package com.tencent.mobileqq.webview.swift.scheduler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC8977a f314644d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f314645e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f314646f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f314647h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.scheduler.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8977a {
        int a(Bundle bundle);
    }

    public a(InterfaceC8977a interfaceC8977a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC8977a);
            return;
        }
        this.f314646f = true;
        this.f314647h = false;
        this.f314644d = interfaceC8977a;
        this.f314645e = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f314647h = true;
            this.f314645e.removeMessages(1);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f314646f = false;
            QLog.d("WebLog_StateMachine", 1, "disableAsyncAction");
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f314647h;
    }

    public void d(Bundle bundle) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.f314647h = false;
        while (!this.f314647h && (a16 = this.f314644d.a(bundle)) != -1) {
            if (a16 != 1) {
                if (a16 != 2) {
                    continue;
                }
            } else if (this.f314646f) {
                Message obtainMessage = this.f314645e.obtainMessage(1);
                obtainMessage.setData(bundle);
                this.f314645e.sendMessage(obtainMessage);
                return;
            }
            if (this.f314646f) {
                Message obtainMessage2 = this.f314645e.obtainMessage(1);
                obtainMessage2.setData(bundle);
                this.f314645e.sendMessageDelayed(obtainMessage2, 50L);
                return;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what != 1) {
            return false;
        }
        if (!this.f314647h) {
            d(message.getData());
        }
        return true;
    }
}
