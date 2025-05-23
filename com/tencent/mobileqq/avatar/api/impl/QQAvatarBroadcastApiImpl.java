package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarBroadcastApiImpl implements IQQAvatarBroadcastApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQAvatarBroadcastApiImpl";

    public QQAvatarBroadcastApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastApi
    public boolean checkIsBroadcastRegister(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        boolean isBroadcastRegister = ((IQQAvatarBroadcastTempApi) QRoute.api(IQQAvatarBroadcastTempApi.class)).isBroadcastRegister();
        QLog.i(TAG, 1, "checkIsBroadcastRegister, hasRegister=" + isBroadcastRegister + ", shouldRegisterAgain=" + z16);
        if (!isBroadcastRegister && z16) {
            ((IQQAvatarBroadcastTempApi) QRoute.api(IQQAvatarBroadcastTempApi.class)).registerBroadcast();
            boolean isBroadcastRegister2 = ((IQQAvatarBroadcastTempApi) QRoute.api(IQQAvatarBroadcastTempApi.class)).isBroadcastRegister();
            QLog.i(TAG, 1, "checkIsBroadcastRegister, register again, hasRegister=" + isBroadcastRegister2);
            return isBroadcastRegister2;
        }
        return isBroadcastRegister;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastApi
    public List<String> queryAvatarByUin(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        return ((IQQAvatarBroadcastTempApi) QRoute.api(IQQAvatarBroadcastTempApi.class)).queryAvatarByUin(list);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastApi
    public void resetBroadcastRegisterState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((IQQAvatarBroadcastTempApi) QRoute.api(IQQAvatarBroadcastTempApi.class)).resetBroadcastRegisterState();
        }
    }
}
