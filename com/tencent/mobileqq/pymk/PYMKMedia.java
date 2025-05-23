package com.tencent.mobileqq.pymk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* loaded from: classes16.dex */
public class PYMKMedia implements Serializable, Cloneable {
    static IPatchRedirector $redirector_;
    public int mediaType;
    public String picUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PYMKMedia(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.mediaType = i3;
            this.picUrl = str;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PYMKMedia m214clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PYMKMedia) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return (PYMKMedia) super.clone();
        } catch (CloneNotSupportedException e16) {
            QLog.e("PYMKMedia", 1, "clone error " + e16);
            return this;
        }
    }
}
