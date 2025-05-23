package com.tencent.mobileqq.qipc.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.api.IQIPCApiClient;
import com.tencent.mobileqq.qipc.api.QIPCApiCallback;
import com.tencent.mobileqq.qipc.api.QIPCApiModule;
import com.tencent.mobileqq.qipc.api.QIPCApiResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* loaded from: classes16.dex */
public class QIPCApiClientImpl implements IQIPCApiClient {
    static IPatchRedirector $redirector_;
    private ConcurrentHashMap<QIPCApiModule, RealQIPCModule> mModuleMaps;

    /* loaded from: classes16.dex */
    static class RealQIPCModule extends QIPCModule {
        static IPatchRedirector $redirector_;
        WeakReference<QIPCApiModule> mSource;

        public RealQIPCModule(QIPCApiModule qIPCApiModule) {
            super(qIPCApiModule.name);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIPCApiModule);
            } else {
                this.mSource = new WeakReference<>(qIPCApiModule);
            }
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            QIPCApiResult onCall;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
            }
            WeakReference<QIPCApiModule> weakReference = this.mSource;
            if (weakReference != null && weakReference.get() != null && (onCall = this.mSource.get().onCall(str, bundle, i3)) != null) {
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.code = onCall.code;
                eIPCResult.data = onCall.data;
                return eIPCResult;
            }
            return null;
        }
    }

    /* loaded from: classes16.dex */
    static class RealResultCallback implements EIPCResultCallback {
        static IPatchRedirector $redirector_;
        WeakReference<QIPCApiCallback> mCallback;

        public RealResultCallback(QIPCApiCallback qIPCApiCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIPCApiCallback);
            } else {
                this.mCallback = new WeakReference<>(qIPCApiCallback);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QIPCApiResult qIPCApiResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            WeakReference<QIPCApiCallback> weakReference = this.mCallback;
            if (weakReference != null && weakReference.get() != null) {
                if (eIPCResult != null) {
                    qIPCApiResult = new QIPCApiResult();
                    qIPCApiResult.code = eIPCResult.code;
                    qIPCApiResult.data = eIPCResult.data;
                } else {
                    qIPCApiResult = null;
                }
                this.mCallback.get().onCallback(qIPCApiResult);
            }
        }
    }

    public QIPCApiClientImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mModuleMaps = new ConcurrentHashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.qipc.api.IQIPCApiClient
    public void callServer(String str, String str2, Bundle bundle, QIPCApiCallback qIPCApiCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            QIPCClientHelper.getInstance().callServer(str, str2, bundle, new RealResultCallback(qIPCApiCallback));
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, bundle, qIPCApiCallback);
        }
    }

    @Override // com.tencent.mobileqq.qipc.api.IQIPCApiClient
    public void register(QIPCApiModule qIPCApiModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qIPCApiModule);
            return;
        }
        RealQIPCModule realQIPCModule = new RealQIPCModule(qIPCApiModule);
        QIPCClientHelper.getInstance().register(realQIPCModule);
        this.mModuleMaps.put(qIPCApiModule, realQIPCModule);
    }

    @Override // com.tencent.mobileqq.qipc.api.IQIPCApiClient
    public void unRegisterModule(QIPCApiModule qIPCApiModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qIPCApiModule);
            return;
        }
        RealQIPCModule realQIPCModule = this.mModuleMaps.get(qIPCApiModule);
        if (realQIPCModule != null) {
            QIPCClientHelper.getInstance().getClient().unRegisterModule(realQIPCModule);
            this.mModuleMaps.remove(qIPCApiModule);
        }
    }

    @Override // com.tencent.mobileqq.qipc.api.IQIPCApiClient
    public QIPCApiResult callServer(String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QIPCApiResult) iPatchRedirector.redirect((short) 5, this, str, str2, bundle);
        }
        QIPCApiResult qIPCApiResult = new QIPCApiResult();
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(str, str2, bundle);
        if (callServer != null) {
            qIPCApiResult.data = callServer.data;
            qIPCApiResult.code = callServer.code;
        }
        return qIPCApiResult;
    }
}
