package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HWTroopMemberCard implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final long HW_GROUP_CLASS_EXT_ID = 32;
    public static final int IDENTITY_PARENTS = 2;
    public static final int IDENTITY_STUDENT = 3;
    public static final int IDENTITY_TEACHER = 1;
    public static final int IDENTITY_UNKNOW = 0;
    private static final long serialVersionUID = 1;
    public int identity;

    public HWTroopMemberCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.identity = 0;
        }
    }
}
