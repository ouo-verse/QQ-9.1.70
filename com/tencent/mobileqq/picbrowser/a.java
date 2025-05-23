package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends PicBrowserImage {
    static IPatchRedirector $redirector_;

    public a(Context context, PicInfo picInfo) {
        super(context, picInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) picInfo);
        }
    }
}
