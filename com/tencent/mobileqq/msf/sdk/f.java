package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements Runnable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f250542c = "MSF.S.IPCTransportMonitorTask";

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, ServiceMsgWrapper> f250543a;

    /* renamed from: b, reason: collision with root package name */
    private int f250544b;

    public f(ConcurrentHashMap<Integer, ServiceMsgWrapper> concurrentHashMap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) concurrentHashMap, i3);
        } else {
            this.f250543a = concurrentHashMap;
            this.f250544b = i3;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f250543a.get(Integer.valueOf(this.f250544b)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f250542c, 2, "transport msg to process timeout, ssoSeq is " + this.f250544b);
            }
            this.f250543a.remove(Integer.valueOf(this.f250544b));
        }
    }
}
