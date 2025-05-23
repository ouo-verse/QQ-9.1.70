package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;

@Keep
/* loaded from: classes20.dex */
public class EIPCCallbackWrapper {
    public final EIPCCallback instance;

    /* loaded from: classes20.dex */
    class a extends EIPCCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f.b f308448d;

        a(f.b bVar) {
            this.f308448d = bVar;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
            this.f308448d.onCallback(eIPCResult.data.getString("rsp"));
        }
    }

    public EIPCCallbackWrapper(EIPCCallback eIPCCallback) {
        this.instance = eIPCCallback;
    }

    public static EIPCCallbackWrapper newInstance(f.b bVar) {
        return new EIPCCallbackWrapper(new a(bVar));
    }

    public void callWithData(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("rsp", str);
        try {
            this.instance.callback(EIPCResult.createSuccessResult(bundle));
        } catch (Exception e16) {
            QLog.e("RemoteProxy", 1, e16, new Object[0]);
        }
    }
}
