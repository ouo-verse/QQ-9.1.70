package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.IConfigHandlerTempService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import protocol.KQQConfig.GetResourceReqInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ConfigHandlerTempServiceImpl implements IConfigHandlerTempService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ConfigHandlerTempServiceImpl";

    public ConfigHandlerTempServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IConfigHandlerTempService
    public void doConfigHandlerUpdateConfigs(AppRuntime appRuntime, ArrayList<GetResourceReqInfo> arrayList, GetResourceReqInfo... getResourceReqInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, arrayList, getResourceReqInfoArr);
            return;
        }
        if (appRuntime != null) {
            ((ConfigHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).y3(arrayList, getResourceReqInfoArr);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "doConfigHandlerUpdateConfigs, listInfos:" + arrayList + ", infos:" + getResourceReqInfoArr);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
