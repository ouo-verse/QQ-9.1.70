package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.route.ServerRouteTable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoTaskTypeConfig extends TaskTypeConfig {
    static IPatchRedirector $redirector_;

    public VideoTaskTypeConfig(ServerRouteTable serverRouteTable) {
        super(1, serverRouteTable);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
        }
    }
}
