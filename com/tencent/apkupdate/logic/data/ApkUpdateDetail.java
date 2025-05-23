package com.tencent.apkupdate.logic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ApkUpdateDetail {
    static IPatchRedirector $redirector_ = null;
    public static final int UpdateMethod_ByPatch = 4;
    public static final int UpdateMethod_GenPatch = 3;
    public static final int UpdateMethod_NoUpdate = 1;
    public static final int UpdateMethod_NoneRecord = 0;
    public static final int UpdateMethod_Normal = 2;
    public String fileMd5;
    public String newFeature;
    public int newapksize;
    public String packageName;
    public int patchsize;
    public String sigMd5;
    public int updatemethod;
    public String url;
    public int versioncode;
    public String versionname;

    public ApkUpdateDetail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
