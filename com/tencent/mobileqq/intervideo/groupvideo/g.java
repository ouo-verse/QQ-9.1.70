package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final MMKVOptionEntity f238214a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f238214a = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_HOMEWORK);
        }
    }

    public static MMKVOptionEntity a() {
        return f238214a;
    }
}
