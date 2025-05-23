package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class VipComicMqqHandlerProxy extends AbsHandlerProxy<VipComicMqqHandler> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_VIPCOMICM_FAVOREMOTICONS = "vipcomicm_favoremoticons";
    public static final String TAG = "VipComicMqqHandlerProxy";

    public VipComicMqqHandlerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, VipComicMqqHandler.f204459e);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onGetMyComicFavorEmotIcons(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((VipComicMqqHandler) baseQQAppInterface.getBusinessHandler(VipComicMqqHandler.f204459e)).M();
        return EIPCResult.createSuccessResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getMyComicFavorEmotIcons() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.businessHandler != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do myComicFavorEmotIcons.");
            }
            ((VipComicMqqHandler) this.businessHandler).M();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_VIPCOMICM_FAVOREMOTICONS, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "getMyComicFavorEmotIcons suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "getMyComicFavorEmotIcons fail.");
    }
}
