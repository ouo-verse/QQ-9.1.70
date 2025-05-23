package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class PicEmoticonInfoConstant {
    static IPatchRedirector $redirector_;

    public PicEmoticonInfoConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getFictionPath(Emoticon emoticon) {
        if (emoticon == null) {
            return null;
        }
        return emoticon.epId + "_" + emoticon.eId;
    }
}
