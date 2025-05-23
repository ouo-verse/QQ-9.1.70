package mqq.app.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.remote.e;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mqq.app.api.IRuntimeService;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ServiceRemoteHandler implements InvocationHandler {
    private static final String TAG = "ServiceRemoteHandler";
    private final Class<? extends IRuntimeService> clazz;

    public ServiceRemoteHandler(Class<? extends IRuntimeService> cls) {
        this.clazz = cls;
    }

    private Object checkResult(@NonNull String str, EIPCResult eIPCResult) {
        boolean z16;
        Bundle bundle;
        if (eIPCResult != null) {
            if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
                String string = bundle.getString(RemoteProxy.KEY_RESULT_TYPE);
                if (string != null) {
                    return e.c(eIPCResult.data, string, "result");
                }
                String str2 = "Call " + this.clazz.getName() + "$" + str + " fail, resultType is null";
                QLog.e(TAG, 1, str2);
                throw new IllegalStateException(str2, eIPCResult.f396321e);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Call ");
            sb5.append(this.clazz.getName());
            sb5.append("$");
            sb5.append(str);
            sb5.append(" fail, code=");
            sb5.append(eIPCResult.code);
            sb5.append(" data=");
            if (eIPCResult.data == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            QLog.e(TAG, 1, sb6, eIPCResult.f396321e);
            throw new IllegalStateException(sb6, eIPCResult.f396321e);
        }
        String str3 = "callAPISync before init, " + this.clazz.getName() + "$" + str + " fail, result is null";
        QLog.e(TAG, 1, str3);
        throw new IllegalStateException(str3);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!MqqInjectorManager.instance().isPublicVersion() && !MqqInjectorManager.instance().isGrayVersion()) {
            e.a(this.clazz, method);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        e.b(method, true, objArr);
        e.l(method, objArr, bundle);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "callService$" + this.clazz.getName() + "$" + method.getName();
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", str, bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "action=" + str + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return checkResult(method.getName(), callServer);
    }
}
