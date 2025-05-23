package fp3;

import android.os.Bundle;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.k;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qconn.protofile.auth$AuthResponse;
import java.util.List;
import kotlin.Pair;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.agent.auth.model.d f400260a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f400261b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f400262c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f400263d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f400264e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f400265f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f400266g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f400267h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f400268i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f400269j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f400270k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f400271l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ fp3.a f400272m;

        /* compiled from: P */
        /* renamed from: fp3.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C10332a implements com.tencent.open.appcommon.d {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f400274d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f400275e;

            C10332a(String str, boolean z16) {
                this.f400274d = str;
                this.f400275e = z16;
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x0192  */
            /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
            @Override // mqq.observer.BusinessObserver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                boolean z17;
                long currentTimeMillis = System.currentTimeMillis() - a.this.f400271l;
                String string = bundle.getString("ssoAccount");
                int i16 = bundle.getInt("code");
                t.b("ProxyAuthManager", "ProxyAuth.doAuthorize.onReceive:  ssoAccount: " + g.C(string) + ", uin=*" + g.C(a.this.f400262c.f341678a) + ", timeCost=" + currentTimeMillis + ", isSuccess=" + z16 + ", code=" + i16 + ", cmd=" + this.f400274d);
                if (!a.this.f400262c.f341678a.equals(string)) {
                    a.this.f400272m.a(false, -1, null);
                    return;
                }
                if (z16) {
                    auth$AuthResponse auth_authresponse = new auth$AuthResponse();
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        boolean z18 = bundle.getBoolean("use_open_sdk_ticket", false);
                        if (this.f400275e && !z18) {
                            byteArray = OpenSdkVirtualUtil.c(byteArray, a.this.f400262c);
                        }
                        if (byteArray != null) {
                            auth$AuthResponse mergeFrom = auth_authresponse.mergeFrom(byteArray);
                            try {
                                i16 = mergeFrom.ret.get();
                                String str = mergeFrom.state.get();
                                t.b("ProxyAuthManager", "code=", Integer.valueOf(i16), ", respState=", str, ", reqState=", a.this.f400270k);
                                if (i16 == 0 && a.this.f400270k.equals(str)) {
                                    a.this.f400272m.a(true, i16, b.b(mergeFrom));
                                    OpenAuthTelemetryProxy.e(true);
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                try {
                                    int i17 = mergeFrom.ret.get();
                                    String str2 = this.f400274d;
                                    a aVar = a.this;
                                    com.tencent.open.agent.util.d.v(bundle, currentTimeMillis, i17, 13, str2, aVar.f400265f, aVar.f400262c.f341678a);
                                    com.tencent.open.agent.util.d.o("agent_authority", a.this.f400271l, byteArray.length, mergeFrom.toByteArray().length, 0, a.this.f400262c.f341678a, "ret: " + i17);
                                    a aVar2 = a.this;
                                    com.tencent.open.agent.util.d.r(0, "LOGIN_AUTH", aVar2.f400262c.f341678a, aVar2.f400265f, i17, null);
                                    auth_authresponse = mergeFrom;
                                } catch (Exception e16) {
                                    e = e16;
                                    auth_authresponse = mergeFrom;
                                    t.a("ProxyAuthManager", "-->exception catch", e);
                                    a.this.f400272m.a(false, i16, null);
                                    OpenAuthTelemetryProxy.e(false);
                                    if (!z17) {
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                auth_authresponse = mergeFrom;
                                z17 = false;
                                t.a("ProxyAuthManager", "-->exception catch", e);
                                a.this.f400272m.a(false, i16, null);
                                OpenAuthTelemetryProxy.e(false);
                                if (!z17) {
                                }
                            }
                        } else {
                            z17 = false;
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                    if (!z17) {
                        a.this.f400272m.a(false, i16, b.b(auth_authresponse));
                        OpenAuthTelemetryProxy.e(false);
                        return;
                    }
                    return;
                }
                a.this.f400272m.a(false, i16, null);
                a aVar3 = a.this;
                com.tencent.open.agent.util.d.o("agent_authority", aVar3.f400271l, 0L, 0L, i16, aVar3.f400262c.f341678a, "");
                a aVar4 = a.this;
                com.tencent.open.agent.util.d.r(1, "LOGIN_AUTH", aVar4.f400262c.f341678a, aVar4.f400265f, 3002, "");
                a aVar5 = a.this;
                com.tencent.open.agent.util.d.z(aVar5.f400262c.f341678a, aVar5.f400265f, "6", "3002", false);
                OpenAuthTelemetryProxy.e(false);
            }
        }

        a(com.tencent.open.agent.auth.model.d dVar, Bundle bundle, com.tencent.open.model.a aVar, boolean z16, String str, String str2, String str3, List list, long j3, String str4, String str5, long j16, fp3.a aVar2) {
            this.f400260a = dVar;
            this.f400261b = bundle;
            this.f400262c = aVar;
            this.f400263d = z16;
            this.f400264e = str;
            this.f400265f = str2;
            this.f400266g = str3;
            this.f400267h = list;
            this.f400268i = j3;
            this.f400269j = str4;
            this.f400270k = str5;
            this.f400271l = j16;
            this.f400272m = aVar2;
        }

        @Override // com.tencent.open.agent.util.k.a
        public void a(Pair<String, appType$LoginSig> pair) {
            String first = pair.getFirst();
            this.f400260a.d(this.f400261b, this.f400262c, this.f400263d, this.f400264e, this.f400265f, this.f400266g, this.f400267h, this.f400268i, this.f400269j, this.f400270k, new Object[]{pair.getFirst(), pair.getSecond()}, new C10332a(first, "QQConnectLogin.auth_emp".equals(first)));
            t.b("ProxyAuthManager", "cmd=" + first, ", uin=*" + g.C(this.f400262c.f341678a));
        }
    }

    public void a(com.tencent.open.agent.auth.model.d dVar, boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, fp3.a aVar, String str4, com.tencent.open.model.a aVar2, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        g.z(MobileQQ.sMobileQQ.waitAppRuntime(null), aVar2.f341678a, "QQConnectLogin.auth", "QQConnectLogin.auth_emp", new a(dVar, bundle, aVar2, z16, str, str2, str3, list, j3, str4, String.valueOf(System.currentTimeMillis()), currentTimeMillis, aVar));
    }
}
