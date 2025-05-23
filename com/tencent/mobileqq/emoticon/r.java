package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class r {
    static IPatchRedirector $redirector_;

    public static Bundle a(BaseQQAppInterface baseQQAppInterface, String str) {
        int currentUserVipType = ((ISVIPHandler) baseQQAppInterface.getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonContentProvider", 2, "call, vipType = " + currentUserVipType);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(str, currentUserVipType);
        return bundle;
    }
}
