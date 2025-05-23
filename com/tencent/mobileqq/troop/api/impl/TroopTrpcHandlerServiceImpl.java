package com.tencent.mobileqq.troop.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.api.ITroopQIPCModuleApi;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTrpcHandlerServiceImpl implements ITroopTrpcHandlerService {
    static IPatchRedirector $redirector_ = null;
    private static final String MAIN_PROCESS_NAME = "com.tencent.mobileqq";
    private static final String TAG = "TroopTrpcHandlerServiceImpl";

    public TroopTrpcHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendRequest$0(com.tencent.mobileqq.troop.api.f fVar, EIPCResult eIPCResult) {
        TroopTrpcRemoteResponse troopTrpcRemoteResponse = (TroopTrpcRemoteResponse) eIPCResult.data.getSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA);
        if (troopTrpcRemoteResponse.code != 0) {
            QLog.e(TAG, 1, "unknown Error");
            fVar.a(troopTrpcRemoteResponse);
        } else {
            fVar.b(troopTrpcRemoteResponse);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService
    public void sendRequest(String str, String str2, byte[] bArr, int i3, String str3, final com.tencent.mobileqq.troop.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, bArr, Integer.valueOf(i3), str3, fVar);
            return;
        }
        if (TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
            ((TroopTrpcHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(TroopTrpcHandler.class.getName())).J2(str, str2, bArr, i3, null, str3, fVar);
            return;
        }
        try {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getPskeyIpcToMainProcess curProcessName = $curProcessName, start IPC");
            }
            Bundle bundle = new Bundle();
            bundle.putString("service", str);
            bundle.putString("method", str2);
            bundle.putByteArray("data", bArr);
            bundle.putInt("serializationType", i3);
            bundle.putString("refer", str3);
            QIPCClientHelper.getInstance().callServer(ITroopQIPCModuleApi.NAME, "action_send_trpc_request", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.troop.api.impl.n
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    TroopTrpcHandlerServiceImpl.lambda$sendRequest$0(com.tencent.mobileqq.troop.api.f.this, eIPCResult);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
