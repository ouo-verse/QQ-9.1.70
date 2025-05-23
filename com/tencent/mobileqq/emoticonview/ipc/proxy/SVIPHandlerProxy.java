package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class SVIPHandlerProxy extends AbsHandlerProxy<ISVIPHandler> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_SVIPHANDLER_GETCURRENTUSERVIPTYPE = "svip_viptype";
    private static final String SVIP_HANDLER;
    public static final String TAG = "SVIPHandlerProxy";
    private static final String VIP_TYPE = "vip_type";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            SVIP_HANDLER = ((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName();
        }
    }

    public SVIPHandlerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, SVIP_HANDLER);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onGetCurrentUserVipType(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        int currentUserVipType = ((ISVIPHandler) baseQQAppInterface.getBusinessHandler(SVIP_HANDLER)).getCurrentUserVipType();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("vip_type", currentUserVipType);
        return EIPCResult.createSuccessResult(bundle2);
    }

    @Deprecated
    public int getCurrentUserVipType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            return ((ISVIPHandler) t16).getCurrentUserVipType();
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_SVIPHANDLER_GETCURRENTUSERVIPTYPE, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getInt("vip_type");
        }
        QLog.e(TAG, 4, "getCurrentUserVipType fail.");
        return 0;
    }
}
