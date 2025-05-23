package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements InvocationHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends QRouteApi> f276477a;

    public d(Class<? extends QRouteApi> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
        } else {
            this.f276477a = cls;
        }
    }

    @Nullable
    private Object a(@NonNull String str, c cVar) {
        boolean z16;
        Bundle bundle;
        if (cVar != null) {
            if (cVar.f276474a == 0 && (bundle = cVar.f276475b) != null) {
                String string = bundle.getString(RemoteProxy.KEY_RESULT_TYPE);
                if (string != null) {
                    return e.c(cVar.f276475b, string, "result");
                }
                String str2 = "Call " + this.f276477a.getName() + "$" + str + " fail, resultType is null";
                QRoute.logger.a("QRouteRemoteHandler", str2);
                throw new IllegalStateException(str2, cVar.f276476c);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Call ");
            sb5.append(this.f276477a.getName());
            sb5.append("$");
            sb5.append(str);
            sb5.append(" fail, code=");
            sb5.append(cVar.f276474a);
            sb5.append(" data=");
            if (cVar.f276475b == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            QRoute.logger.b("QRouteRemoteHandler", sb6, cVar.f276476c);
            throw new IllegalStateException(sb6, cVar.f276476c);
        }
        String str3 = "callAPISync before init, " + this.f276477a.getName() + "$" + str + " fail, result is null";
        QRoute.logger.a("QRouteRemoteHandler", str3);
        throw new IllegalStateException(str3);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
        }
        if (QRoute.getConfig().isForceCheck()) {
            e.a(this.f276477a, method);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        e.b(method, true, objArr);
        e.l(method, objArr, bundle);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "callApi$" + this.f276477a.getName() + "$" + method.getName();
        c b16 = b.b(str, bundle);
        if (QRoute.logger.isColorLevel()) {
            QRoute.logger.debug("QRouteRemoteHandler", "action=" + str + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return a(method.getName(), b16);
    }
}
