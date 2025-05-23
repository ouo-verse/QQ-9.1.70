package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tdf.module.TDFModuleContext;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QQBaseWebIpcModule extends QQBaseModule {
    private static final String TAG = "HippyQQBaseWebIpcModule";
    boolean mIsStartService;
    public t mOnRemoteResp;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            QQBaseWebIpcModule.this.onBindedToClient();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
            QQBaseWebIpcModule.this.onDisconnectWithService();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
            QQBaseWebIpcModule.this.onPushMsg(bundle);
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            QQBaseWebIpcModule.this.onResponse(bundle);
        }
    }

    public QQBaseWebIpcModule(TDFModuleContext tDFModuleContext) {
        this(tDFModuleContext, true);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQBaseModule, com.tencent.tdf.module.TDFBaseModule
    public void destroy() {
        if (this.mIsStartService) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
        }
    }

    public void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            QLog.e("", 1, "sendRemoteReq error ipc service not ready");
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    public QQBaseWebIpcModule(TDFModuleContext tDFModuleContext, boolean z16) {
        super(tDFModuleContext);
        this.mIsStartService = false;
        this.mOnRemoteResp = new a();
        this.mIsStartService = z16;
        if (z16) {
            if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplication.getContext().getApplicationContext());
            }
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
        }
    }

    protected void onBindedToClient() {
    }

    protected void onDisconnectWithService() {
    }

    protected void onPushMsg(Bundle bundle) {
    }

    protected void onResponse(Bundle bundle) {
    }
}
