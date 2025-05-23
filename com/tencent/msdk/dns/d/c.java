package com.tencent.msdk.dns.d;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.core.rest.share.e;
import com.tencent.msdk.dns.d.b;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.msdk.dns.a f336445a;

    /* renamed from: b, reason: collision with root package name */
    private static Runnable f336446b;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.i(e.a());
                com.tencent.msdk.dns.base.executor.a aVar = DnsExecutors.f336207b;
                aVar.a(c.f336446b);
                aVar.a(c.f336446b, MiniBoxNoticeInfo.MIN_5);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends com.tencent.msdk.dns.c.b.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.msdk.dns.c.b.a
        public void g(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else {
                DnsExecutors.f336207b.execute(c.f336446b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336446b = new a();
        }
    }

    public static void b(com.tencent.msdk.dns.a aVar) {
        if (aVar != null) {
            f336445a = aVar;
            h();
            return;
        }
        throw new IllegalArgumentException("dnsConfig".concat(" can not be null"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (r1.f336386g.f336319e != 1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x024c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(com.tencent.msdk.dns.core.d dVar, Context context) {
        String str;
        com.tencent.msdk.dns.core.stat.b bVar;
        com.tencent.msdk.dns.d f16;
        com.tencent.msdk.dns.core.stat.b bVar2;
        d dVar2;
        com.tencent.msdk.dns.core.stat.b bVar3;
        if (dVar != null) {
            if (!(dVar.f336252b instanceof com.tencent.msdk.dns.core.stat.b)) {
                com.tencent.msdk.dns.base.log.c.i("lookupResult.stat is not instanceof StatisticsMerge", new Object[0]);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("lookupResult:" + String.valueOf(dVar), new Object[0]);
            com.tencent.msdk.dns.core.stat.b bVar4 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
            if (bVar4.f336385f.f336319e != 2 && bVar4.f336386g.f336319e != 2) {
                if ("Https".equals(f336445a.f336181k)) {
                    com.tencent.msdk.dns.core.stat.b bVar5 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                    if (bVar5.f336385f.f336319e != 1) {
                    }
                }
                bVar = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                if (bVar.f336385f.f336319e != 0 || bVar.f336386g.f336319e == 0) {
                    f16 = com.tencent.msdk.dns.d.f();
                    d c16 = d.c();
                    f16.c(0);
                    if (f336445a.f336182l && c16.b()) {
                        String c17 = com.tencent.msdk.dns.d.a.c(context);
                        String a16 = f16.a();
                        bVar2 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                        if (bVar2.f336385f.f336319e != 0) {
                            com.tencent.msdk.dns.base.executor.a aVar = DnsExecutors.f336207b;
                            String str2 = bVar2.f336380a;
                            com.tencent.msdk.dns.a aVar2 = f336445a;
                            String str3 = aVar2.f336176f.f336366b;
                            String str4 = aVar2.f336181k;
                            long currentTimeMillis = System.currentTimeMillis();
                            String b16 = com.tencent.msdk.dns.d.a.b();
                            String d16 = com.tencent.msdk.dns.d.a.d();
                            com.tencent.msdk.dns.core.stat.b bVar6 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                            dVar2 = c16;
                            aVar.execute(com.tencent.msdk.dns.d.a.a(c17, str2, str3, str4, "HttpDnsSpend", currentTimeMillis, a16, "3.9.0a", b16, "Andriod", d16, r8.f336378c, bVar6.f336381b, "a", f336445a.f336177g, bVar6.f336385f.f336322h, r8.f336319e));
                        } else {
                            dVar2 = c16;
                        }
                        bVar3 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                        if (bVar3.f336386g.f336319e == 0) {
                            com.tencent.msdk.dns.base.executor.a aVar3 = DnsExecutors.f336207b;
                            String str5 = bVar3.f336380a;
                            com.tencent.msdk.dns.a aVar4 = f336445a;
                            String str6 = aVar4.f336176f.f336366b;
                            String str7 = aVar4.f336181k;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            String b17 = com.tencent.msdk.dns.d.a.b();
                            String d17 = com.tencent.msdk.dns.d.a.d();
                            com.tencent.msdk.dns.core.stat.b bVar7 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                            aVar3.execute(com.tencent.msdk.dns.d.a.a(c17, str5, str6, str7, "HttpDnsSpend", currentTimeMillis2, a16, "3.9.0a", b17, "Andriod", d17, r4.f336378c, bVar7.f336381b, "aaaa", f336445a.f336177g, bVar7.f336386g.f336322h, r4.f336319e));
                        }
                        dVar2.a(System.currentTimeMillis());
                    }
                }
                if (com.tencent.msdk.dns.base.report.e.e()) {
                    return;
                }
                Map b18 = kl3.a.b(29);
                com.tencent.msdk.dns.core.c cVar = dVar.f336251a;
                b18.put("dns_ips", com.tencent.msdk.dns.c.e.a.c(cVar.f336248a, ","));
                b18.put("dns_4a_ips", com.tencent.msdk.dns.c.e.a.c(cVar.f336249b, ","));
                com.tencent.msdk.dns.core.stat.b bVar8 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                b18.put(WadlProxyConsts.CHANNEL, bVar8.f336382c);
                b18.put("netType", bVar8.f336380a);
                b18.put("domain", bVar8.f336381b);
                b18.put("net_stack", String.valueOf(bVar8.f336383d));
                b18.put("ldns_ip", com.tencent.msdk.dns.c.e.a.c(bVar8.f336384e.f336376a, ","));
                b18.put("ldns_time", String.valueOf(bVar8.f336384e.f336378c));
                b18.put(QAdRewardDefine$VideoParams.ISCACHE, String.valueOf(bVar8.f336385f.f336324j));
                b18.put("hdns_a_err_code", String.valueOf(bVar8.f336385f.f336319e));
                b18.put("hdns_a_err_msg", bVar8.f336385f.f336320f);
                b18.put("hdns_ip", com.tencent.msdk.dns.c.e.a.c(bVar8.f336385f.f336376a, ","));
                b18.put(RemoteMessageConst.TTL, String.valueOf(bVar8.f336385f.f336322h));
                b18.put("clientIP", bVar8.f336385f.f336321g);
                b18.put("hdns_time", String.valueOf(bVar8.f336385f.f336378c));
                b18.put("hdns_a_retry", String.valueOf(bVar8.f336385f.f336323i));
                b18.put("hdns_4a_cache_hit", String.valueOf(bVar8.f336386g.f336324j));
                b18.put("hdns_4a_err_code", String.valueOf(bVar8.f336386g.f336319e));
                b18.put("hdns_4a_err_msg", bVar8.f336386g.f336320f);
                b18.put("hdns_4a_ips", com.tencent.msdk.dns.c.e.a.c(bVar8.f336386g.f336376a, ","));
                b18.put("hdns_4a_ttl", String.valueOf(bVar8.f336386g.f336322h));
                b18.put("hdns_4a_client_ip", bVar8.f336386g.f336321g);
                b18.put("hdns_4a_time_ms", String.valueOf(bVar8.f336386g.f336378c));
                b18.put("hdns_4a_retry", String.valueOf(bVar8.f336386g.f336323i));
                f(b18);
                d("HDNSGetHostByName", b18);
                return;
            }
            com.tencent.msdk.dns.d f17 = com.tencent.msdk.dns.d.f();
            if (f336445a.f336182l && f17.d(f17.e() + 1)) {
                String c18 = com.tencent.msdk.dns.d.a.c(context);
                String a17 = f17.a();
                com.tencent.msdk.dns.core.stat.b bVar9 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                if (bVar9.f336385f.f336319e != 0) {
                    com.tencent.msdk.dns.base.executor.a aVar5 = DnsExecutors.f336207b;
                    String str8 = bVar9.f336380a;
                    com.tencent.msdk.dns.a aVar6 = f336445a;
                    String str9 = aVar6.f336176f.f336366b;
                    String str10 = aVar6.f336181k;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String b19 = com.tencent.msdk.dns.d.a.b();
                    String d18 = com.tencent.msdk.dns.d.a.d();
                    com.tencent.msdk.dns.core.stat.b bVar10 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                    str = c18;
                    aVar5.execute(com.tencent.msdk.dns.d.a.a(str, str8, str9, str10, "HttpDnsfail", currentTimeMillis3, a17, "3.9.0a", b19, "Andriod", d18, r8.f336378c, bVar10.f336381b, "a", f336445a.f336177g, bVar10.f336385f.f336322h, r8.f336319e));
                } else {
                    str = c18;
                }
                com.tencent.msdk.dns.core.stat.b bVar11 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                if (bVar11.f336386g.f336319e != 0) {
                    com.tencent.msdk.dns.base.executor.a aVar7 = DnsExecutors.f336207b;
                    String str11 = bVar11.f336380a;
                    com.tencent.msdk.dns.a aVar8 = f336445a;
                    String str12 = aVar8.f336176f.f336366b;
                    String str13 = aVar8.f336181k;
                    long currentTimeMillis4 = System.currentTimeMillis();
                    String b26 = com.tencent.msdk.dns.d.a.b();
                    String d19 = com.tencent.msdk.dns.d.a.d();
                    com.tencent.msdk.dns.core.stat.b bVar12 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                    aVar7.execute(com.tencent.msdk.dns.d.a.a(str, str11, str12, str13, "HttpDnsfail", currentTimeMillis4, a17, "3.9.0a", b26, "Andriod", d19, r4.f336378c, bVar12.f336381b, "aaaa", f336445a.f336177g, bVar12.f336386g.f336322h, r4.f336319e));
                }
            }
            f17.g();
            com.tencent.msdk.dns.base.log.c.c("dnsip\u8fde\u63a5\u5931\u8d25, \u5f53\u524d\u5931\u8d25\u6b21\u6570\uff1a" + f17.e(), new Object[0]);
            bVar = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
            if (bVar.f336385f.f336319e != 0) {
            }
            f16 = com.tencent.msdk.dns.d.f();
            d c162 = d.c();
            f16.c(0);
            if (f336445a.f336182l) {
                String c172 = com.tencent.msdk.dns.d.a.c(context);
                String a162 = f16.a();
                bVar2 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                if (bVar2.f336385f.f336319e != 0) {
                }
                bVar3 = (com.tencent.msdk.dns.core.stat.b) dVar.f336252b;
                if (bVar3.f336386g.f336319e == 0) {
                }
                dVar2.a(System.currentTimeMillis());
            }
            if (com.tencent.msdk.dns.base.report.e.e()) {
            }
        } else {
            throw new IllegalArgumentException("lookupResult".concat(" can not be null"));
        }
    }

    private static void d(String str, Map<String, String> map) {
        com.tencent.msdk.dns.base.report.e.c(3, str, map);
    }

    private static void f(Map<String, String> map) {
        map.put("sdk_Version", "3.9.0a");
        map.put("appID", f336445a.f336172b);
        map.put("id", f336445a.f336176f.f336366b);
        map.put("userID", f336445a.f336173c);
    }

    public static void g(com.tencent.msdk.dns.core.d[] dVarArr) {
        if (dVarArr != null) {
            if (!com.tencent.msdk.dns.base.report.e.e()) {
                return;
            }
            Map b16 = kl3.a.b(24);
            b16.put(WadlProxyConsts.CHANNEL, f336445a.f336181k);
            b16.put("lookup_count", String.valueOf(dVarArr.length));
            b.C9223b c9223b = new b.C9223b(false);
            for (com.tencent.msdk.dns.core.d dVar : dVarArr) {
                c9223b.a((com.tencent.msdk.dns.core.stat.b) dVar.f336252b);
            }
            com.tencent.msdk.dns.d.b b17 = c9223b.b();
            b16.put("net_types", b17.f336405a);
            b16.put("domains", b17.f336406b);
            b16.put("net_stacks", b17.f336407c);
            b16.put("hdns_a_err_codes", b17.f336410f);
            b16.put("hdns_a_err_msgs", b17.f336411g);
            b16.put("hdns_a_ipses", b17.f336412h);
            b16.put("hdns_a_ttls", b17.f336413i);
            b16.put("hdns_a_client_ips", b17.f336414j);
            b16.put("hdns_a_time_mses", b17.f336415k);
            b16.put("hdns_a_retrys", b17.f336416l);
            b16.put("hdns_4a_err_codes", b17.f336417m);
            b16.put("hdns_4a_err_msgs", b17.f336419o);
            b16.put("hdns_4a_ipses", b17.f336418n);
            b16.put("hdns_4a_ttls", b17.f336420p);
            b16.put("hdns_4a_client_ips", b17.f336421q);
            b16.put("hdns_4a_time_mses", b17.f336422r);
            b16.put("hdns_4a_retrys", b17.f336423s);
            f(b16);
            d("HDNSPreLookup", b16);
            return;
        }
        throw new IllegalArgumentException("lookupResults".concat(" can not be null"));
    }

    private static void h() {
        DnsExecutors.f336207b.a(f336446b, MiniBoxNoticeInfo.MIN_5);
        com.tencent.msdk.dns.c.b.b.c(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Collection<com.tencent.msdk.dns.core.d> collection) {
        if (!com.tencent.msdk.dns.c.e.a.f(collection) && com.tencent.msdk.dns.base.report.e.e()) {
            Map b16 = kl3.a.b(19);
            b16.put(WadlProxyConsts.CHANNEL, f336445a.f336181k);
            b16.put("lookup_count", String.valueOf(collection.size()));
            b.C9223b c9223b = new b.C9223b(true);
            Iterator<com.tencent.msdk.dns.core.d> it = collection.iterator();
            while (it.hasNext()) {
                c9223b.a((com.tencent.msdk.dns.core.stat.b) it.next().f336252b);
            }
            com.tencent.msdk.dns.d.b b17 = c9223b.b();
            b16.put("net_types", b17.f336405a);
            b16.put("net_changes", b17.f336408d);
            b16.put("domains", b17.f336406b);
            b16.put("lookup_time_mses", b17.f336409e);
            b16.put("net_stacks", b17.f336407c);
            b16.put("hdns_err_codes", b17.f336410f);
            b16.put("hdns_err_msgs", b17.f336411g);
            b16.put("hdns_ipses", b17.f336412h);
            b16.put("hdns_ttls", b17.f336413i);
            b16.put("hdns_client_ips", b17.f336414j);
            b16.put("hdns_time_mses", b17.f336415k);
            b16.put("hdns_retrys", b17.f336416l);
            f(b16);
            d("HDNSLookupAsync", b16);
        }
    }
}
