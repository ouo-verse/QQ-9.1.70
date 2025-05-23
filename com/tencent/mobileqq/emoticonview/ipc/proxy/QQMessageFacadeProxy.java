package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes12.dex */
public class QQMessageFacadeProxy extends AbsManagerProxy implements IQQMessageFacadeProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_QQMESSAGEFACADE_CURRCHATUIN = "qqmessagefacade_currchatuin";
    public static final String ACTION_QQMESSAGEFACADE_GETCURRCHATTYPE = "qqmessagefacade_getcurrchattype";
    private static final String CURR_CHAT_TYPE = "currchat_type";
    private static final String CURR_CHAT_UIN = "currchat_uin";
    public static final String TAG = "QQMessageFacadeProxy";

    public QQMessageFacadeProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ((IEmosmService) QRoute.api(IEmosmService.class)).getManagerID(IEmosmService.MGR_MSG_FACADE));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult onGetCurrChatType(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        int currChatType = ((IEmosmService) QRoute.api(IEmosmService.class)).getCurrChatType(baseQQAppInterface);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(CURR_CHAT_TYPE, currChatType);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onGetCurrChatUin(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        String currChatUin = ((IEmosmService) QRoute.api(IEmosmService.class)).getCurrChatUin(baseQQAppInterface);
        Bundle bundle2 = new Bundle();
        bundle2.putString(CURR_CHAT_UIN, currChatUin);
        return EIPCResult.createSuccessResult(bundle2);
    }

    @Override // com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy
    public int getCurrChatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.manager != 0) {
            return ((IEmosmService) QRoute.api(IEmosmService.class)).getCurrChatType(this.mApp);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_QQMESSAGEFACADE_GETCURRCHATTYPE, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getInt(CURR_CHAT_TYPE);
        }
        QLog.e(TAG, 4, "getCurrChatType fail.");
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy
    public String getCurrChatUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.manager != 0) {
            return ((IEmosmService) QRoute.api(IEmosmService.class)).getCurrChatUin(this.mApp);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_QQMESSAGEFACADE_CURRCHATUIN, null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getString(CURR_CHAT_UIN);
        }
        QLog.e(TAG, 4, "getCurrChatType fail.");
        return null;
    }
}
