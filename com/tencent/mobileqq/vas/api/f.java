package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends EIPCCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f308458d;

        a(b bVar) {
            this.f308458d = bVar;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
            this.f308458d.onCallback(eIPCResult.data.getString("rsp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onCallback(String str);
    }

    public static EIPCCallback a(b bVar) {
        return new a(bVar);
    }

    public static void b(EIPCCallback eIPCCallback, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("rsp", str);
        try {
            eIPCCallback.callback(EIPCResult.createSuccessResult(bundle));
        } catch (Exception e16) {
            QLog.e("RemoteProxy", 1, e16, new Object[0]);
        }
    }
}
