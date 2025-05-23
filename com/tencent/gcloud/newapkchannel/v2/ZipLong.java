package com.tencent.gcloud.newapkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ZipLong implements Cloneable {
    static IPatchRedirector $redirector_;
    private long value;

    public ZipLong(byte[] bArr) {
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
        if (!(obj instanceof ZipLong) || this.value != ((ZipLong) obj).getValue()) {
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        long j3 = this.value;
        return new byte[]{(byte) (255 & j3), (byte) ((65280 & j3) >> 8), (byte) ((16711680 & j3) >> 16), (byte) ((j3 & 4278190080L) >> 24)};
    }

    public long getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return (int) this.value;
    }

    public ZipLong(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.value = ((bArr[i3 + 3] << 24) & 4278190080L) + ((bArr[i3 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) + ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3);
        }
    }

    public ZipLong(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.value = j3;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
    }
}
