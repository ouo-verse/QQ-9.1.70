package hp3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.agent.util.t;
import com.tencent.qconn.protofile.preAuth$PreAuthResponse;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f405802a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.open.model.e> f405803b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.open.model.a> f405804c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, List<e>> f405805d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, hp3.a> f405806e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, preAuth$PreAuthResponse> f405807f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f405808g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, Bundle> f405809h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, List<e>> f405810i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, List<GameCenterAuthPermission>> f405811j = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f405812a = new b();
    }

    public static b e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AbstractOpenSdkAppInterface)) {
            return a.f405812a;
        }
        return ((AbstractOpenSdkAppInterface) peekAppRuntime).g();
    }

    public void a(String str) {
        t.b("AuthMemoryCache", "addForce540Account uin=" + com.tencent.open.agent.util.g.C(str));
        this.f405802a.add(str);
    }

    public com.tencent.open.model.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405804c.get(str);
    }

    public hp3.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405806e.get(str);
    }

    public long d(String str) {
        Long l3;
        if (TextUtils.isEmpty(str) || (l3 = this.f405808g.get(str)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public Bundle f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405809h.get(str);
    }

    public List<e> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405805d.get(str);
    }

    public String h(String str, boolean z16) {
        List<e> list;
        List<GameCenterAuthPermission> list2;
        boolean z17 = true;
        if (str != null && !str.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            if (z16) {
                list = this.f405810i.remove(str);
            } else {
                list = this.f405810i.get(str);
            }
            if (list != null) {
                for (e eVar : list) {
                    int i3 = eVar.f405819a;
                    if (i3 == 2 || i3 == 3) {
                        if (z17) {
                            z17 = false;
                        } else {
                            sb5.append(',');
                        }
                        sb5.append(eVar.f405820b);
                        sb5.append(':');
                        sb5.append(eVar.f405825g ? 1 : 0);
                    }
                }
            }
            if (z16) {
                list2 = this.f405811j.remove(str);
            } else {
                list2 = this.f405811j.get(str);
            }
            if (list2 != null) {
                for (GameCenterAuthPermission gameCenterAuthPermission : list2) {
                    if (z17) {
                        z17 = false;
                    } else {
                        sb5.append(',');
                    }
                    sb5.append(gameCenterAuthPermission.getTitle());
                    sb5.append(':');
                    sb5.append(gameCenterAuthPermission.getRangeStr());
                }
            }
            return sb5.toString();
        }
        t.e("AuthMemoryCache", "getPermissionReportStr appId null or empty");
        return "";
    }

    public preAuth$PreAuthResponse i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405807f.get(str);
    }

    public com.tencent.open.model.e j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405803b.get(str);
    }

    public boolean k(String str) {
        boolean contains = this.f405802a.contains(str);
        t.b("AuthMemoryCache", "isForceTo540 uin=" + com.tencent.open.agent.util.g.C(str) + ", force540=" + contains);
        return contains;
    }

    public void l(String str, hp3.a aVar) {
        t.b("AuthMemoryCache", "putPreAuthAppInfo=", aVar);
        this.f405806e.put(str, aVar);
    }

    public void m(String str, List<e> list) {
        this.f405805d.put(str, list);
    }

    public void n(String str, preAuth$PreAuthResponse preauth_preauthresponse) {
        this.f405807f.put(str, preauth_preauthresponse);
    }

    public void o(String str, List<e> list) {
        this.f405810i.put(str, list);
    }

    public void p(String str, com.tencent.open.model.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            this.f405803b.put(str, eVar);
        }
    }

    public void q(String str, com.tencent.open.model.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            this.f405804c.put(str, aVar);
        }
    }

    public void r(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            this.f405808g.put(str, Long.valueOf(j3));
        }
    }

    public void s(String str, List<GameCenterAuthPermission> list) {
        this.f405811j.put(str, list);
    }

    public void t(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null) {
            this.f405809h.put(str, bundle);
        }
    }
}
