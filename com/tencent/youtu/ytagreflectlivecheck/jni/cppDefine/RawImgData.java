package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RawImgData {
    static IPatchRedirector $redirector_;
    public long captureTime;
    public String checksum;
    public byte[] frameBuffer;

    /* renamed from: x, reason: collision with root package name */
    public int f385202x;

    /* renamed from: y, reason: collision with root package name */
    public int f385203y;

    public RawImgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
