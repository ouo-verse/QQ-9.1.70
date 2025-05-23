package com.tencent.gcloud.apkchannel.v1;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ZipShort implements Cloneable {
    static IPatchRedirector $redirector_;
    private int value;

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == null || !(obj instanceof ZipShort) || this.value != ((ZipShort) obj).getValue()) {
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int i3 = this.value;
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 & 65280) >> 8)};
    }

    public int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.value;
    }

    public ZipShort(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.value = ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3);
        }
    }

    public ZipShort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.value = i3;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }
}
