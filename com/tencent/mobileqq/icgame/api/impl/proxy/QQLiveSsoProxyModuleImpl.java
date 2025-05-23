package com.tencent.mobileqq.icgame.api.impl.proxy;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.sso.QQLiveBusinessHandler;
import com.tencent.mobileqq.icgame.sso.a;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderX5;
import t42.d;

/* loaded from: classes15.dex */
public class QQLiveSsoProxyModuleImpl implements IQQLiveSsoProxyModule {
    public static final String SSO_MODULE_NAME = "sso_module";
    private static final String TAG = "ICGameSsoProxyModuleImpl";
    private static final int TIMEOUT = 15000;
    private IQQLiveSDK liveSDK;

    private void doRealSend(String str, String str2, byte[] bArr, boolean z16, final IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited()) {
            if (this.liveSDK.isDestroyed()) {
                QLog.e(TAG, 1, "liveSDK.isDestroyed");
                iQQLiveProxySsoObserver.onFail(-100001, "cannot send req after destroy instance.");
                return;
            }
            AppInterface a16 = d.a();
            if (a16 == null) {
                QLog.e(TAG, 1, "getAppInterface null");
                iQQLiveProxySsoObserver.onFail(FileReaderX5.ERR_CODE_NOT_SUPPORT, "getAppInterface null.");
                return;
            } else {
                ((QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER)).sendQQLiveReq(this.liveSDK.getAppId(), str, str2, bArr, 15000, 0, z16, new h(new a() { // from class: com.tencent.mobileqq.icgame.api.impl.proxy.QQLiveSsoProxyModuleImpl.1
                    @Override // com.tencent.mobileqq.icgame.sso.a
                    public void onBusinessFailed(int i3, String str3) {
                        super.onBusinessFailed(i3, str3);
                        iQQLiveProxySsoObserver.onFail(i3, str3);
                    }

                    @Override // com.tencent.mobileqq.icgame.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int i3, String str3) {
                        super.onFailed(i3, str3);
                        iQQLiveProxySsoObserver.onFail(i3, str3);
                    }

                    @Override // com.tencent.mobileqq.icgame.sso.a
                    public void onProxyRequestSuccess(int i3, i iVar) {
                        iQQLiveProxySsoObserver.onReceive(iVar.e());
                    }
                }));
                return;
            }
        }
        QLog.e(TAG, 1, "the live sdk is null");
        iQQLiveProxySsoObserver.onFail(-100001, "do you forget init sdk instance ?");
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        QLog.i(TAG, 1, "the live sdk is destroy");
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.liveSDK = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.i(TAG, 1, "the live sdk is reset");
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule
    public void sendQQLiveProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        doRealSend(str, str2, bArr, false, iQQLiveProxySsoObserver);
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule
    public void sendQQLiveQuickProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        doRealSend(str, str2, bArr, true, iQQLiveProxySsoObserver);
    }
}
