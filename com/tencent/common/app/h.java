package com.tencent.common.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.remote.ServiceRemoteProxy;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static h f99540d;

    public h(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f99540d == null) {
                f99540d = new h("QRouteIPCModule");
                QIPCClientHelper.getInstance().register(f99540d);
            }
            hVar = f99540d;
        }
        return hVar;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        EIPCResult callInMainProcess;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRouteIPCModule", 2, "action:" + str);
        }
        if (!TextUtils.isEmpty(str) && str.contains("$")) {
            String[] split = str.split("\\$");
            if (split.length != 3) {
                return EIPCResult.createExceptionResult(new IllegalStateException("wrong action, action = " + str));
            }
            if (split[0].compareTo("callApi") == 0) {
                com.tencent.mobileqq.qroute.remote.c a16 = com.tencent.mobileqq.qroute.remote.b.a(str, bundle, i3);
                if (a16 != null) {
                    EIPCResult createResult = EIPCResult.createResult(a16.f276474a, a16.f276475b);
                    createResult.f396321e = a16.f276476c;
                    return createResult;
                }
            } else if (split[0].compareTo("callService") == 0 && (callInMainProcess = ServiceRemoteProxy.callInMainProcess(str, bundle, i3)) != null) {
                return callInMainProcess;
            }
            return EIPCResult.createExceptionResult(new IllegalStateException("QRemoteProxy.callInMainProcess result is null, callType=" + split[0]));
        }
        return EIPCResult.createExceptionResult(new IllegalStateException("wrong action"));
    }
}
