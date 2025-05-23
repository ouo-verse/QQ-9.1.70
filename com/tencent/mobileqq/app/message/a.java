package com.tencent.mobileqq.app.message;

import PushNotifyPack.RequestPushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a extends com.tencent.imcore.message.i {
    static IPatchRedirector $redirector_;

    public a(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        }
    }

    public abstract void Y0(String str, String str2);

    public abstract void Z0(byte b16, int i3, String str, String str2, ArrayList<String> arrayList);

    public abstract boolean a1(SubAccountInfo subAccountInfo);

    public abstract void b1(boolean z16, ArrayList<SimpleAccount> arrayList);

    public abstract void c1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    public abstract void d1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    public abstract void e1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    public abstract void f1(RequestPushNotify requestPushNotify);
}
