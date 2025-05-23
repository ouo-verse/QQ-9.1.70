package com.tencent.mobileqq.profilecard.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AddressInfo {
    static IPatchRedirector $redirector_;
    public int addressType;
    public String code;
    public int count;
    public HashMap<String, AddressInfo> dataMap;
    public String name;

    public AddressInfo(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.name = str;
        this.code = str2;
        this.count = i3;
        this.addressType = i16;
        this.dataMap = new HashMap<>();
    }

    public ArrayList<AddressInfo> getDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.dataMap != null) {
            return new ArrayList<>(this.dataMap.values());
        }
        return null;
    }
}
