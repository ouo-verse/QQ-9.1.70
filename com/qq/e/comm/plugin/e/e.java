package com.qq.e.comm.plugin.e;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.setting.QQSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.PrivacyPolicyListener;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.gathererga.core.a;
import com.tencent.gathererga.tangram.b;
import com.tencent.gathererga.tangram.c;
import com.tencent.gathererga.tangram.e;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f39364a;

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<Integer> f39365f = new HashSet<Integer>() { // from class: com.qq.e.comm.plugin.e.e.1
        {
            add(1);
            add(2);
            add(318);
            add(408);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gathererga.tangram.e f39366b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.gathererga.core.a f39367c;

    /* renamed from: d, reason: collision with root package name */
    private String f39368d;

    /* renamed from: e, reason: collision with root package name */
    private String f39369e;

    e() {
        e();
    }

    private void e() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(101);
        linkedList.add(102);
        linkedList.add(103);
        linkedList.add(110);
        linkedList.add(111);
        linkedList.add(112);
        linkedList.add(104);
        linkedList.add(115);
        linkedList.add(307);
        linkedList.add(309);
        linkedList.add(310);
        this.f39369e = linkedList.toString();
    }

    private void f() {
        boolean a16 = com.qq.e.comm.plugin.j.c.a("chromeVisitSystem", 0, 1);
        this.f39367c = new a.b().e(a16).d(com.qq.e.comm.plugin.j.c.a("chromeVisitDexOrOdex", 0, 1)).c();
    }

    private ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> g() {
        this.f39368d = com.qq.e.comm.plugin.j.c.a((String) null, Constants.KEYS.PRIVACY_POLICY_LIST, this.f39369e);
        ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(2, a(2, 2, true));
        concurrentHashMap.put(1, a(1, 2, true));
        concurrentHashMap.put(101, a(101, 3, false));
        concurrentHashMap.put(102, a(102, 3, false));
        concurrentHashMap.put(103, a(103, 3, false));
        concurrentHashMap.put(107, a(107, 3, false));
        concurrentHashMap.put(108, a(108, 3, false));
        concurrentHashMap.put(109, a(109, 3, false));
        concurrentHashMap.put(110, a(110, 3, false));
        concurrentHashMap.put(111, a(111, 3, false));
        concurrentHashMap.put(112, a(112, 3, false));
        concurrentHashMap.put(104, a(104, 3, false));
        concurrentHashMap.put(115, a(115, 3, false));
        concurrentHashMap.put(308, a(308, 3, false));
        concurrentHashMap.put(307, a(307, 1, false));
        concurrentHashMap.put(312, a(312, 1, true));
        concurrentHashMap.put(313, a(313, 1, true));
        concurrentHashMap.put(305, a(305, 1, true));
        concurrentHashMap.put(403, a(403, 3, false));
        concurrentHashMap.put(116, a(116, 3, false));
        concurrentHashMap.put(117, a(117, 3, false));
        concurrentHashMap.put(118, a(118, 2, true));
        concurrentHashMap.put(119, a(119, 1, true));
        concurrentHashMap.put(501, a(501, 1, true));
        concurrentHashMap.put(502, a(502, 1, true));
        concurrentHashMap.put(317, a(317, 1, true));
        concurrentHashMap.put(124, a(124, 2, true));
        concurrentHashMap.put(125, a(125, 1, true));
        concurrentHashMap.put(126, a(126, 2, true));
        concurrentHashMap.put(405, a(405, 1, true));
        concurrentHashMap.put(408, a(408, 3, false));
        concurrentHashMap.put(409, a(409, 3, false));
        concurrentHashMap.put(410, a(410, 3, false));
        concurrentHashMap.put(128, a(128, 3, false));
        concurrentHashMap.put(411, a(411, 3, false));
        concurrentHashMap.put(413, a(413, 3, false));
        concurrentHashMap.put(412, a(412, 3, false));
        concurrentHashMap.put(318, a(318, 3, false));
        concurrentHashMap.put(414, a(414, 2, true));
        return concurrentHashMap;
    }

    public com.tencent.gathererga.tangram.e b() {
        return this.f39366b;
    }

    public Map<Integer, com.tencent.gathererga.tangram.d> c() {
        com.tencent.gathererga.tangram.e eVar = this.f39366b;
        if (eVar == null) {
            GDTLogger.e("get sync result failed, tangram service is not init");
            return null;
        }
        return eVar.a();
    }

    public void d() {
        if (this.f39366b == null) {
            GDTLogger.e("update setting failed, tangram service is not init");
            return;
        }
        if (b.c()) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.e.e.5
                @Override // java.lang.Runnable
                public void run() {
                    e.this.f39366b.e();
                }
            });
        }
        this.f39366b.f(g());
        ConcurrentHashMap<Integer, Object> concurrentHashMap = new ConcurrentHashMap<>();
        if (SDKStatus.getSDKVersionCode() >= 280 && GlobalSetting.getDeviceInfoSetting() != null) {
            concurrentHashMap.putAll(GlobalSetting.getDeviceInfoSetting().getDeviceInfoValue());
        }
        this.f39366b.d(concurrentHashMap);
    }

    public static e a() {
        if (f39364a == null) {
            synchronized (e.class) {
                if (f39364a == null) {
                    f39364a = new e();
                }
            }
        }
        return f39364a;
    }

    private static com.tencent.gathererga.core.e b(int i3, boolean z16, boolean z17) {
        if (i3 == 1) {
            if (z16) {
                return com.tencent.gathererga.core.internal.provider.b.f().i().h(true).g(false).f();
            }
            return null;
        }
        if (i3 == 2) {
            if (z16) {
                return null;
            }
            return com.tencent.gathererga.core.internal.provider.b.f().i().l().h(true).g(z17).f();
        }
        if (i3 != 3) {
            GDTLogger.e("createUpdatePriority error, unknown gatherType");
            return null;
        }
        return com.tencent.gathererga.core.internal.provider.b.f().i().k().n().h(true).g(z17).f();
    }

    public void a(Context context) {
        ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> g16 = g();
        String str = SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion();
        com.tencent.gathererga.core.d dVar = new com.tencent.gathererga.core.d() { // from class: com.qq.e.comm.plugin.e.e.2
            @Override // com.tencent.gathererga.core.d
            public void d(String str2, String str3) {
                GDTLogger.d(str2 + " " + str3);
            }

            @Override // com.tencent.gathererga.core.d
            public void e(String str2, String str3) {
                GDTLogger.e(str2 + " " + str3);
            }

            @Override // com.tencent.gathererga.core.d
            public void i(String str2, String str3) {
                GDTLogger.i(str2 + " " + str3);
            }

            @Override // com.tencent.gathererga.core.d
            public void w(String str2, String str3) {
                GDTLogger.w(str2 + " " + str3);
            }

            @Override // com.tencent.gathererga.core.d
            public void e(String str2, String str3, Throwable th5) {
                GDTLogger.e(str2 + " " + str3, th5);
            }

            @Override // com.tencent.gathererga.core.d
            public void w(String str2, String str3, Throwable th5) {
                GDTLogger.w(str2 + " " + str3, th5);
            }
        };
        String qQAppVersion = QQSetting.getQQAppVersion();
        b.C1148b m3 = new b.C1148b().m(GDTADManager.getInstance().getAppStatus().getAPPID());
        if (!TextUtils.isEmpty(qQAppVersion)) {
            str = qQAppVersion;
        }
        this.f39366b = e.a.a(context, m3.l(str).r(g16).n(new com.tencent.gathererga.core.c() { // from class: com.qq.e.comm.plugin.e.e.4
            @Override // com.tencent.gathererga.core.c
            public void execute(Runnable runnable) {
                GdtSDKThreadManager.getInstance().runOnThread(2, runnable);
            }
        }).o(true).p(dVar).q(new com.tencent.gathererga.sdk.b() { // from class: com.qq.e.comm.plugin.e.e.3
            @Override // com.tencent.gathererga.sdk.b
            public boolean userAgreement() {
                PrivacyPolicyListener privacyPolicyListener = QQSetting.getPrivacyPolicyListener();
                if (privacyPolicyListener != null) {
                    return privacyPolicyListener.hasAgreed();
                }
                return GlobalSetting.isAgreePrivacyStrategy();
            }
        }).k());
        f();
        if (b.b()) {
            this.f39366b.c();
        }
    }

    public void a(ConcurrentHashMap<Integer, String> concurrentHashMap) {
        com.tencent.gathererga.tangram.e eVar = this.f39366b;
        if (eVar == null) {
            GDTLogger.e("update file cache failed, tangram service is not init");
        } else {
            eVar.b(concurrentHashMap);
        }
    }

    private com.tencent.gathererga.tangram.c a(int i3, int i16, boolean z16) {
        boolean a16 = b.a(i3);
        com.tencent.gathererga.tangram.c cVar = new com.tencent.gathererga.tangram.c();
        cVar.k(b.a(i3, z16));
        cVar.l(a16);
        cVar.j(false);
        cVar.h(b.b(i3));
        com.tencent.gathererga.core.e a17 = a(i16, a(i3), a16);
        com.tencent.gathererga.core.e b16 = b(i16, a(i3), a16);
        cVar.i(a17);
        cVar.m(b16);
        c.a aVar = new c.a();
        aVar.e(true);
        aVar.d(this.f39367c);
        cVar.g(aVar);
        return cVar;
    }

    private static boolean a(int i3) {
        return !f39365f.contains(Integer.valueOf(i3));
    }

    private static com.tencent.gathererga.core.e a(int i3, boolean z16, boolean z17) {
        if (i3 == 1) {
            if (z16) {
                return com.tencent.gathererga.core.internal.provider.b.f().j().h(true).g(false).f();
            }
            return null;
        }
        if (i3 == 2) {
            if (z16) {
                return com.tencent.gathererga.core.internal.provider.b.f().i().l().h(true).g(false).f();
            }
            return com.tencent.gathererga.core.internal.provider.b.f().i().k().h(true).g(z17).f();
        }
        if (i3 != 3) {
            GDTLogger.e("createFetchPriority error, unknown gatherType");
            return null;
        }
        if (z16) {
            return com.tencent.gathererga.core.internal.provider.b.f().i().k().n().h(true).g(z17).f();
        }
        return com.tencent.gathererga.core.internal.provider.b.f().i().k().h(true).g(z17).f();
    }
}
