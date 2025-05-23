package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.model.SizeI;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TextureInfo {
    static IPatchRedirector $redirector_;
    private final SizeI size;
    private final String stackTrace;

    public TextureInfo() {
        this(null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextureInfo)) {
            return false;
        }
        TextureInfo textureInfo = (TextureInfo) obj;
        if (this.size.equals(textureInfo.size) && this.stackTrace.equals(textureInfo.stackTrace)) {
            return true;
        }
        return false;
    }

    public SizeI getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SizeI) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.size;
    }

    public String getStackTrace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.stackTrace;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        SizeI sizeI = this.size;
        int i16 = 0;
        if (sizeI != null) {
            i3 = sizeI.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str = this.stackTrace;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i17 + i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "TextureInfo(size=" + this.size + ", stackTrace=" + this.stackTrace + ")";
    }

    public TextureInfo(SizeI sizeI, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sizeI, (Object) str);
            return;
        }
        sizeI = sizeI == null ? new SizeI(0, 0) : sizeI;
        str = str == null ? "" : str;
        this.size = sizeI;
        this.stackTrace = str;
    }
}
