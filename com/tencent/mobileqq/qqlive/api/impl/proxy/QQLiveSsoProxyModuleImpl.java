package com.tencent.mobileqq.qqlive.api.impl.proxy;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler;
import com.tencent.mobileqq.qqlive.sso.a;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.mobileqq.qqlive.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderX5;

/* loaded from: classes17.dex */
public class QQLiveSsoProxyModuleImpl implements IQQLiveSsoProxyModule {
    static IPatchRedirector $redirector_ = null;
    public static final String SSO_MODULE_NAME = "sso_module";
    private static final String TAG = "QQLiveSsoProxyModuleImpl";
    private static final int TIMEOUT = 15000;
    private IQQLiveSDK liveSDK;

    public QQLiveSsoProxyModuleImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void doRealSend(String str, String str2, byte[] bArr, boolean z16, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited()) {
            if (this.liveSDK.isDestroyed()) {
                QLog.e(TAG, 1, "liveSDK.isDestroyed");
                iQQLiveProxySsoObserver.onFail(-100001, "cannot send req after destroy instance.");
                return;
            }
            AppInterface a16 = g.a();
            if (a16 == null) {
                QLog.e(TAG, 1, "getAppInterface null");
                iQQLiveProxySsoObserver.onFail(FileReaderX5.ERR_CODE_NOT_SUPPORT, "getAppInterface null.");
                return;
            } else {
                ((QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER)).sendQQLiveReq(this.liveSDK.getAppId(), str, str2, bArr, 15000, 0, z16, new com.tencent.mobileqq.qqlive.sso.g(new a(iQQLiveProxySsoObserver) { // from class: com.tencent.mobileqq.qqlive.api.impl.proxy.QQLiveSsoProxyModuleImpl.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IQQLiveProxySsoObserver val$observer;

                    {
                        this.val$observer = iQQLiveProxySsoObserver;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveSsoProxyModuleImpl.this, (Object) iQQLiveProxySsoObserver);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.a
                    public void onBusinessFailed(int i3, String str3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str3);
                        } else {
                            super.onBusinessFailed(i3, str3);
                            this.val$observer.onFail(i3, str3);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int i3, String str3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str3);
                        } else {
                            super.onFailed(i3, str3);
                            this.val$observer.onFail(i3, str3);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.sso.a
                    public void onProxyRequestSuccess(int i3, h hVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) hVar);
                        } else {
                            this.val$observer.onReceive(hVar.e());
                        }
                    }
                }));
                return;
            }
        }
        QLog.e(TAG, 1, "the live sdk is null");
        iQQLiveProxySsoObserver.onFail(-100001, "do you forget init sdk instance ?");
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.i(TAG, 1, "the live sdk is destroy");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.liveSDK = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.i(TAG, 1, "the live sdk is reset");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule
    public void sendQQLiveProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, bArr, iQQLiveProxySsoObserver);
        } else {
            doRealSend(str, str2, bArr, false, iQQLiveProxySsoObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule
    public void sendQQLiveQuickProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, bArr, iQQLiveProxySsoObserver);
        } else {
            doRealSend(str, str2, bArr, true, iQQLiveProxySsoObserver);
        }
    }
}
