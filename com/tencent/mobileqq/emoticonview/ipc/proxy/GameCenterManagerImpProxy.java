package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class GameCenterManagerImpProxy extends AbsManagerProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_GAMECENTERMANAGERIMP_CHECKNEWFLAGBYPATH = "gamecentermanagerimp_checknewflagbypath";
    private static final String CHECK_NEWFLAG = "checkNewFlag";
    private static final String PARAM_PATH = "param_path";
    public static final String TAG = "GameCenterManagerImpProxy";

    public GameCenterManagerImpProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ((IEmosmService) QRoute.api(IEmosmService.class)).getManagerID(IEmosmService.GAMECENTER_MANAGER));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onCheckNewFlagByPath(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        int checkNewFlagByPath = ((IEmosmService) QRoute.api(IEmosmService.class)).checkNewFlagByPath(baseQQAppInterface, bundle.getString(PARAM_PATH));
        Bundle bundle2 = new Bundle();
        bundle2.putInt(CHECK_NEWFLAG, checkNewFlagByPath);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public int checkNewFlagByPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        if (this.manager != 0) {
            return ((IEmosmService) QRoute.api(IEmosmService.class)).checkNewFlagByPath(this.mApp, str);
        }
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_PATH, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_GAMECENTERMANAGERIMP_CHECKNEWFLAGBYPATH, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getInt(CHECK_NEWFLAG);
        }
        QLog.e(TAG, 4, "checkNewFlagByPath fail.");
        return 0;
    }
}
