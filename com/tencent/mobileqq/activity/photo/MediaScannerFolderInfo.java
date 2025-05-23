package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaScannerFolderInfo {
    static IPatchRedirector $redirector_;
    public String folderpath;

    /* renamed from: id, reason: collision with root package name */
    public int f183981id;
    public long modifiedDate;

    public MediaScannerFolderInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
