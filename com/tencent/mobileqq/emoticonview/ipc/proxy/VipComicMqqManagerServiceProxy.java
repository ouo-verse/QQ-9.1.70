package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class VipComicMqqManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IVipComicMqqManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_VIPCOMICM_UPLOADINITCOMICEINFO = "vipcomicm_uploadinitcomiceinfo";
    public static final String TAG = "VipComicMqqManagerServiceProxy";

    public VipComicMqqManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IVipComicMqqManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onUploadInitComicEmoStructMsgInfo(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IVipComicMqqManagerService) baseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class, "")).uploadInitComicEmoStructMsgInfo();
        return EIPCResult.createSuccessResult(null);
    }

    public void uploadInitComicEmoStructMsgInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do uploadInitComicEmoStructMsgInfo.");
            }
            ((IVipComicMqqManagerService) this.manager).uploadInitComicEmoStructMsgInfo();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_VIPCOMICM_UPLOADINITCOMICEINFO, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "uploadInitComicEmoStructMsgInfo suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "uploadInitComicEmoStructMsgInfo fail.");
    }
}
