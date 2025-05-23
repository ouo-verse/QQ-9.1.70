package com.tencent.open;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.open.ticket.OpenTicketHelper;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b extends QIPCModule {
    public b(String str) {
        super(str);
    }

    public static void c(final String str) {
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AbstractOpenSdkAppInterface)) {
            t.b("BaseOpenSdkQIPCClient", "clearLoginData !(app instanceof OpenSDKAppInterface)");
        } else {
            hp3.b.e().a(str);
            OpenTicketHelper.b(str, new u() { // from class: com.tencent.open.a
                @Override // com.tencent.open.agent.util.u
                public final void onResult(boolean z16, String str2) {
                    b.e(str, z16, str2);
                }
            });
        }
    }

    public static void d() {
        t.f("BaseOpenSdkQIPCClient", "doPtloginCancel");
        QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_ptlogin_cancel", new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, boolean z16, String str2) {
        t.b("BaseOpenSdkQIPCClient", "clearLoginData hasTicket: " + z16);
        if (z16) {
            OpenTicketHelper.e(str, true);
        }
    }

    public static void f(Bundle bundle) {
        t.b("BaseOpenSdkQIPCClient", "onSsoLoginComplete");
        QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_on_sso_login_complete", bundle);
    }
}
