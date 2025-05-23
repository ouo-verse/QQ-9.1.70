package com.tencent.open;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.t;
import com.tencent.tmassistantbase.util.GlobalUtil;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends com.tencent.open.b {

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f341545d = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements EIPClientConnectListener {
        a() {
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            t.b("OpenSdkQIPCClient", "connectFailed");
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            t.b("OpenSdkQIPCClient", "connectSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f341546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f341547b;

        b(int i3, String str) {
            this.f341546a = i3;
            this.f341547b = str;
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            f.this.h(this.f341547b, this.f341546a, 2006, -100);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(aj ajVar) {
            f.this.h(this.f341547b, this.f341546a, ajVar.f241864a, -102);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            OpenProxy.c().a(str);
            com.tencent.open.b.c(str);
            f.this.h(str, this.f341546a, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static f f341549a = new f("ae_camera_get_info_client");
    }

    public f(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, int i3, int i16, int i17) {
        t.b("OpenSdkQIPCClient", "backToMainProcess uin=" + g.C(str) + ", ssoResult=" + i16 + ", epicCode=" + i17);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("uin", str);
            bundle.putInt("key_sso_ret", i16);
            callbackResult(i3, EIPCResult.createResult(i17, bundle));
        } catch (Exception e16) {
            t.d("OpenSdkQIPCClient", "Exception", e16);
        }
    }

    private void i(Bundle bundle, int i3) {
        String str;
        if (bundle == null) {
            t.e("OpenSdkQIPCClient", "doWtLogin params==null");
            h("", i3, 1005, -102);
            return;
        }
        String string = bundle.getString("uin");
        String string2 = bundle.getString("passwd");
        String string3 = bundle.getString("appid");
        if (TextUtils.isEmpty(string2)) {
            str = GlobalUtil.DEF_STRING;
        } else {
            str = "****";
        }
        t.b("OpenSdkQIPCClient", "doWtLogin uin=" + g.C(string) + ", maskPasswd=" + str + ", appId=" + string3);
        com.tencent.open.agent.util.b.e(string3, string, string2, new b(i3, string));
    }

    public static f j() {
        return c.f341549a;
    }

    public static void registerModule() {
        t.f("OpenSdkQIPCClient", "registerModule isRegisterModule=" + f341545d);
        if (f341545d.compareAndSet(false, true)) {
            t.f("OpenSdkQIPCClient", "registerModule execute");
            QIPCClientHelper.getInstance().getClient().registerModule(j());
            QIPCClientHelper.getInstance().getClient().connect(new a());
        }
    }

    public static void unRegisterModule() {
        t.b("OpenSdkQIPCClient", "unRegisterModule isRegisterModule=" + f341545d);
        if (f341545d.compareAndSet(true, false)) {
            t.b("OpenSdkQIPCClient", "unRegisterModule execute");
            QIPCClientHelper.getInstance().getClient().unRegisterModule(j());
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        t.b("OpenSdkQIPCClient", "onCall action=" + str);
        if ("action_to_wt_login".equals(str)) {
            i(bundle, i3);
            return null;
        }
        if ("action_handle_qrlogin_result".equals(str)) {
            QrAgentLoginManager.t().y(bundle);
            return null;
        }
        return null;
    }
}
