package com.tencent.upload.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.IUploadConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageCompressRecord {
    static IPatchRedirector $redirector_;
    final boolean autoRotate;
    final boolean compressToWebp;
    final int flowId;
    final IUploadConfig.UploadImageSize mSize;
    final String md5;
    final String path;

    public ImageCompressRecord(int i3, String str, String str2, IUploadConfig.UploadImageSize uploadImageSize, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, uploadImageSize, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.flowId = i3;
        this.path = str;
        this.md5 = str2;
        this.mSize = uploadImageSize;
        this.autoRotate = z16;
        this.compressToWebp = z17;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ImageCompressRecord{mSize=" + this.mSize + ", autoRotate=" + this.autoRotate + ", compressToWebp=" + this.compressToWebp + ", flowId=" + this.flowId + ", path='" + this.path + "', md5='" + this.md5 + "'}";
    }
}
