package com.tencent.mobileqq.dt;

import android.content.Context;
import com.tencent.mobileqq.channel.ChannelProxy;
import com.tencent.mobileqq.fe.IFEKitLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Dtn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Dtn f203613a;

    public Dtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Dtn a() {
        if (f203613a == null) {
            synchronized (Dtn.class) {
                if (f203613a == null) {
                    f203613a = new Dtn();
                }
            }
        }
        return f203613a;
    }

    public native void finitMainProcess();

    public native void initContext(Context context, String str);

    public native void initGlobalConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public native void initLog(IFEKitLog iFEKitLog);

    public native void initMainProcess(Context context, ChannelProxy channelProxy);

    public native void initUin(String str);
}
