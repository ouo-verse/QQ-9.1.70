package com.tencent.lbssearch.object.result;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AddressComponent extends JsonComposer {
    static IPatchRedirector $redirector_;
    public String city;
    public String district;
    public String nation;
    public String province;
    public String street;
    public String street_number;

    public AddressComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
