package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(RockDownloadInfo rockDownloadInfo, String str, int i3);

    public abstract void b(ArrayList<RockDownloadInfo> arrayList);
}
