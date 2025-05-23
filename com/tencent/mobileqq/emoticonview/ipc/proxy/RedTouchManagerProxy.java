package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class RedTouchManagerProxy extends AbsEmoRuntimeServiceProxy<IRedTouchManager> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_REDTOUCHMANAGER_GETAPPINFOBYPATH = "redtouchmanager_getappinfobypath";
    public static final String ACTION_REDTOUCHMANAGER_ONREDTOUCHITEMCLICK = "redtouchmanager_onredtouchitemclick";
    private static final String INEWFLAG = "inewflag";
    private static final String PARAM_MYPATH = "param_mypath";
    public static final String TAG = "RedTouchManagerProxy";

    public RedTouchManagerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IRedTouchManager.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onGetAppInfoNewFlagByPath(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        int i16;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) baseQQAppInterface.getRuntimeService(IRedTouchManager.class)).getAppInfoByPath(bundle.getString(PARAM_MYPATH));
        Bundle bundle2 = new Bundle();
        if (appInfoByPath != null) {
            i16 = appInfoByPath.iNewFlag.get();
        } else {
            i16 = 0;
        }
        bundle2.putInt(INEWFLAG, i16);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onOnRedTouchItemClick(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IRedTouchManager) baseQQAppInterface.getRuntimeService(IRedTouchManager.class)).onRedTouchItemClick(bundle.getString(PARAM_MYPATH));
        return EIPCResult.createSuccessResult(null);
    }

    public int getAppInfoNewFlagByPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) t16).getAppInfoByPath(str);
            if (appInfoByPath == null) {
                return 0;
            }
            return appInfoByPath.iNewFlag.get();
        }
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_MYPATH, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_REDTOUCHMANAGER_GETAPPINFOBYPATH, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getInt(INEWFLAG);
        }
        QLog.e(TAG, 4, "getAppInfoNewFlagByPath fail.");
        return 0;
    }

    public void onRedTouchItemClick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IRedTouchManager) t16).onRedTouchItemClick(str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_MYPATH, str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_REDTOUCHMANAGER_ONREDTOUCHITEMCLICK, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "onRedTouchItemClick suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "onRedTouchItemClick fail.");
    }
}
