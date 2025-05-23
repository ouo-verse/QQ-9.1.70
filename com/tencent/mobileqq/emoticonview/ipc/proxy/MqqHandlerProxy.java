package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IMqqHandlerProxy;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class MqqHandlerProxy implements IMqqHandlerProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_MQQHANDLER_SENDTOTARGET = "sendtotarget";
    private static final String PARAM_CLAZZ = "param_clazz";
    private static final String PARAM_MSGUPDATE = "param_msgupdate";
    public static final String TAG = "MqqHandlerProxy";
    private BaseQQAppInterface mApp;
    private Class mClass;
    private MqqHandler mMqqHandler;

    public MqqHandlerProxy(BaseQQAppInterface baseQQAppInterface, Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) cls);
            return;
        }
        this.mApp = baseQQAppInterface;
        this.mClass = cls;
        if (baseQQAppInterface != null) {
            this.mMqqHandler = baseQQAppInterface.getHandler(cls);
        }
    }

    public static EIPCResult onSendToTarget(AppInterface appInterface, String str, Bundle bundle, int i3) {
        appInterface.getHandler((Class) bundle.getSerializable(PARAM_CLAZZ)).obtainMessage(bundle.getInt(PARAM_MSGUPDATE)).sendToTarget();
        return EIPCResult.createSuccessResult(null);
    }

    @Override // com.tencent.mobileqq.emoticonview.IMqqHandlerProxy
    public void sendToTarget(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        MqqHandler mqqHandler = this.mMqqHandler;
        if (mqqHandler != null) {
            mqqHandler.obtainMessage(i3).sendToTarget();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_MSGUPDATE, i3);
        bundle.putSerializable(PARAM_CLAZZ, this.mClass);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_MQQHANDLER_SENDTOTARGET, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "sendToTarget suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "sendToTarget fail.");
    }
}
