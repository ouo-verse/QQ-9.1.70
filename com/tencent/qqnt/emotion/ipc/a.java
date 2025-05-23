package com.tencent.qqnt.emotion.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qqnt.emotion.api.INTEmoticonPanelIpcService;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static a f356281d;

    public a() {
        super(INTEmoticonPanelIpcService.NT_EMOTICON_MAINPANEL_IPC_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f356281d == null) {
                synchronized (a.class) {
                    if (f356281d == null) {
                        f356281d = new a();
                    }
                }
            }
            aVar = f356281d;
        }
        return aVar;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return EIPCResult.createResult(-105, null);
        }
        if (bundle != null) {
            bundle.setClassLoader(EmoticonPackage.class.getClassLoader());
        }
        EIPCResult a16 = com.tencent.qqnt.emotion.ipc.proxy.b.a(waitAppRuntime, str, bundle, i3);
        if (a16 == null) {
            return null;
        }
        return a16;
    }
}
