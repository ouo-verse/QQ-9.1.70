package com.tencent.gcloud.netinterface;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public class NetInterfaceHelper {
    static IPatchRedirector $redirector_;
    private static String LOGTAG;
    private static MsgWorker mMsgWorker;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            LOGTAG = "NetInterfaceHelper";
        }
    }

    public NetInterfaceHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void init(Context context) {
        if (mMsgWorker != null) {
            return;
        }
        mMsgWorker = new MsgWorker(context);
        new BaseThread(mMsgWorker).start();
    }

    public static void pushMsg(int i3, int i16, int i17, String str) {
        mMsgWorker.sendMessage(new EventMsg(i3, i16, i17, str));
    }
}
