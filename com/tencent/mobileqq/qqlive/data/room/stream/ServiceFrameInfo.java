package com.tencent.mobileqq.qqlive.data.room.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ServiceFrameInfo {
    static IPatchRedirector $redirector_;
    public ArrayList<ServiceAddressInfo> addresses;
    public String definition;
    public int level;

    public ServiceFrameInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.level = -1;
            this.addresses = new ArrayList<>();
        }
    }
}
