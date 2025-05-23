package com.tencent.mobileqq.qqgift.updatasystem.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ResConfigDetailInfo implements Serializable {
    static IPatchRedirector $redirector_;

    @SerializedName("static")
    public String defaultName;

    @SerializedName("name")
    public String name;

    @SerializedName("type")
    public String type;

    public ResConfigDetailInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ResConfigDetailInfo{name='" + this.name + "', type='" + this.type + "', defaultName='" + this.defaultName + "'}";
    }

    public ResConfigDetailInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.name = str;
        this.type = str2;
        this.defaultName = str3;
    }
}
