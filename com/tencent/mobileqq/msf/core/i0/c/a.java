package com.tencent.mobileqq.msf.core.i0.c;

import android.content.Intent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.q;
import com.tencent.mobileqq.msf.core.quicksend.d;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    public static final String f248465c = "WeakNetDetector";

    /* renamed from: d, reason: collision with root package name */
    public static final int f248466d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f248467e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f248468f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f248469g = 4;

    /* renamed from: h, reason: collision with root package name */
    public static final int f248470h = 8;

    /* renamed from: i, reason: collision with root package name */
    public static final int f248471i = 16;

    /* renamed from: j, reason: collision with root package name */
    public static final int f248472j = 32;

    /* renamed from: k, reason: collision with root package name */
    public static final int f248473k = 64;

    /* renamed from: l, reason: collision with root package name */
    public static final int f248474l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static final int f248475m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f248476n = 2;

    /* renamed from: o, reason: collision with root package name */
    private static final String f248477o = "com.tencent.mobileqq.msf.bd.weaknetchange";

    /* renamed from: p, reason: collision with root package name */
    private static final String f248478p = "is_weak_net";

    /* renamed from: q, reason: collision with root package name */
    private static final String f248479q = "weak_net_status_change_reason";

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC8083a f248480a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mobileqq.msf.core.i0.c.c.a f248481b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.i0.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8083a {
        void onNormalToWeakNet(int i3);

        void onWeakNetToNormal(int i3);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f248480a = null;
            this.f248481b = new com.tencent.mobileqq.msf.core.i0.c.c.a();
        }
    }

    public abstract void a(int i3);

    public abstract void a(int i3, int i16, int i17);

    public abstract void a(int i3, long j3, q qVar);

    public abstract void a(long j3);

    public abstract void a(long j3, long j16, boolean z16);

    public abstract void a(com.tencent.qphone.base.a aVar);

    public abstract void a(ToServiceMsg toServiceMsg);

    public abstract void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    public abstract void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, d dVar);

    public abstract void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, int i3);

    public abstract void a(Socket socket, int i3);

    public abstract void a(boolean z16);

    public void a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent("com.tencent.mobileqq.msf.bd.weaknetchange");
        intent.putExtra("is_weak_net", z16);
        intent.putExtra("weak_net_status_change_reason", i3);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent);
        QLog.d("WeakNetDetector", 1, "send weakNet status change broadcast, isWeakNet: " + z16 + ", reason: " + i3);
    }

    public abstract boolean a();

    public abstract void b();

    public abstract void b(ToServiceMsg toServiceMsg);

    public abstract void b(Socket socket, int i3);

    public abstract void c();

    public abstract void c(ToServiceMsg toServiceMsg);

    public abstract void d(ToServiceMsg toServiceMsg);

    public abstract void e(ToServiceMsg toServiceMsg);

    public static void a(Map<String, String> map) {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || !com.tencent.mobileqq.msf.core.i0.a.v().r()) {
            return;
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_CONNWEAKNET_NEW);
        fromServiceMsg.addAttribute(BaseConstants.KEY_WEAK_NET_PARAM_JSON, new JSONObject(map).toString());
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setMsfCommand(MsfCommand.onConnWeakNetNew);
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        NetConnInfoCenter.msfCore.addRespToQuque(null, fromServiceMsg);
    }

    public void a(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hashMap);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        String str = aVar.f248508a ? "Wi-fi" : aVar.f248509b ? com.tencent.mobileqq.msf.core.x.q.f250392x : "unknown";
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_REASON, Integer.toHexString(aVar.b()));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, str);
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_COST, String.valueOf(this.f248481b.f248512e));
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_PING_COST, String.valueOf(aVar2.f248515h - aVar2.f248514g));
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_HB_COST, String.valueOf(aVar3.f248518k - aVar3.f248517j));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_TRTT, String.valueOf(this.f248481b.f248522o));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_DOWN_BOUND, String.valueOf(this.f248481b.f248524q));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_UP_BOUND, String.valueOf(this.f248481b.f248525r));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BN, String.valueOf((int) this.f248481b.f248520m));
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BC, String.valueOf((int) this.f248481b.f248521n));
    }

    public void a(InterfaceC8083a interfaceC8083a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248480a = interfaceC8083a;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC8083a);
        }
    }
}
