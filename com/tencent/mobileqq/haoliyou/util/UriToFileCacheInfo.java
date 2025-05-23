package com.tencent.mobileqq.haoliyou.util;

import android.net.Uri;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UriToFileCacheInfo {
    static IPatchRedirector $redirector_;
    public final long lastModified;
    public final String path;
    public final Uri uri;

    public UriToFileCacheInfo(Uri uri, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uri, str, Long.valueOf(j3));
            return;
        }
        this.uri = uri;
        this.path = str;
        this.lastModified = j3;
        if (QLog.isDevelopLevel()) {
            QLog.i(UriParserPathHelper.TAG, 4, "UriToFileCacheInfo path: " + str + ", lastModified: " + j3);
        }
    }
}
