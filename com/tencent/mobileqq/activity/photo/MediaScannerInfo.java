package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaScannerInfo {
    static IPatchRedirector $redirector_;
    public long duration;
    public long fileSize;
    public String folderPath;

    /* renamed from: id, reason: collision with root package name */
    public int f183982id;
    public String md5;
    public String mimeType;
    public long modifiedDate;
    public String name;
    public String path;

    public MediaScannerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
