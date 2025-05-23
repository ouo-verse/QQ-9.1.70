package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import eipc.EIPCResult;
import java.io.Serializable;

/* loaded from: classes12.dex */
public class FavEmoRoamingHandlerProxy extends AbsHandlerProxy<FavEmoRoamingHandler> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_FAVEMOROAMINGHANDLER_NOTIFYUI = "favhandler_notifyui";
    private static final String PARAM_DATA = "param_data";
    private static final String PARAM_SUCCESS = "param_success";
    private static final String PARAM_TYPE = "param_type";
    public static final String TAG = "FavEmoRoamingHandlerProxy";

    public FavEmoRoamingHandlerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, FavEmoRoamingHandler.f194632e);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onNotifyUI(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((FavEmoRoamingHandler) baseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.f194632e)).notifyUI(bundle.getInt("param_type"), bundle.getBoolean(PARAM_SUCCESS), bundle.getSerializable(PARAM_DATA));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void notifyUI(int i3, boolean z16, Serializable serializable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), serializable);
            return;
        }
        T t16 = this.businessHandler;
        if (t16 != 0) {
            ((FavEmoRoamingHandler) t16).notifyUI(i3, z16, serializable);
        }
    }
}
