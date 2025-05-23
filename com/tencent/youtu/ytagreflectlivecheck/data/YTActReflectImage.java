package com.tencent.youtu.ytagreflectlivecheck.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTActReflectImage {
    static IPatchRedirector $redirector_;
    public String checksum;
    public byte[] image;
    public float[] xys;

    public YTActReflectImage(byte[] bArr, float[] fArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, fArr, str);
            return;
        }
        this.image = bArr;
        this.xys = fArr;
        this.checksum = str;
    }
}
