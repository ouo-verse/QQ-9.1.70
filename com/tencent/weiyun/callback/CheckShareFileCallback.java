package com.tencent.weiyun.callback;

import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.data.CBundleReader;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class CheckShareFileCallback extends WeiyunCallback {
    static IPatchRedirector $redirector_;

    public CheckShareFileCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onError(int i3, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.weiyun.callback.WeiyunCallback
    public void onNativeCallback(long j3, int i3, int i16, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (i16 == 0) {
            if (j3 == 0) {
                onSuccess("");
                return;
            }
            String string = CBundleReader.getString(j3, GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
            CBundleReader.deleteBundle(j3);
            onSuccess(string);
            return;
        }
        onError(i16, str);
    }

    public abstract void onSuccess(String str);
}
