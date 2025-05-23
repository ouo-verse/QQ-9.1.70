package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileLabelTypeInfo implements Cloneable, Serializable {
    static IPatchRedirector $redirector_;
    public List<ProfileLabelInfo> labels;
    public String typeId;
    public String typeInfo;
    public String typeName;

    public ProfileLabelTypeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.labels = new ArrayList();
        }
    }
}
