package com.tencent.youtu.ytposedetect.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTActRefImage {
    static IPatchRedirector $redirector_;
    public String checksum;
    public String encodeImage;

    /* renamed from: h, reason: collision with root package name */
    public int f385206h;
    public byte[] image;

    /* renamed from: w, reason: collision with root package name */
    public int f385207w;
    public float[] xys;

    public YTActRefImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
