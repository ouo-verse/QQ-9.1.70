package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.route.ServerRouteTable;

/* loaded from: classes27.dex */
public class PhotoTaskTypeConfig extends TaskTypeConfig {
    static IPatchRedirector $redirector_;

    public PhotoTaskTypeConfig(ServerRouteTable serverRouteTable) {
        super(0, serverRouteTable);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
        }
    }
}
