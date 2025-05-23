package hynb.b;

import com.huya.huyasdk.data.HYNSRequest;
import com.huya.huyasdk.data.QueryHttpDnsReq;
import com.huya.huyasdk.data.TReqQueryHttpDnsRsp;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    public static volatile j f406622b;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, TReqQueryHttpDnsRsp.HttpDnsItem> f406623a = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f406624a;

        public a(String str) {
            this.f406624a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a("cdnws.api.huya.com", this.f406624a);
        }
    }

    public final void b(String str) {
        Map<String, TReqQueryHttpDnsRsp.HttpDnsItem> map = this.f406623a;
        if (map != null && !map.isEmpty()) {
            StringBuilder sb5 = new StringBuilder(2048);
            for (String str2 : this.f406623a.keySet()) {
                TReqQueryHttpDnsRsp.HttpDnsItem httpDnsItem = this.f406623a.get(str2);
                sb5.append(str2);
                sb5.append(" expireTime:");
                sb5.append(httpDnsItem.iExpireTime);
                sb5.append(" ipv4:");
                sb5.append(httpDnsItem.vIp.toString());
                sb5.append(" ipv6:");
                sb5.append(httpDnsItem.vIpv6.toString());
                hynb.p.g.f406799a.a("HttpDnsHelper", "printHttpDnsItemMap %s : %s", str, sb5.toString());
                sb5.delete(0, sb5.length());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements h<TReqQueryHttpDnsRsp> {
        public b() {
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(TReqQueryHttpDnsRsp tReqQueryHttpDnsRsp) {
            if (tReqQueryHttpDnsRsp == null) {
                return;
            }
            hynb.p.g.f406799a.info("HttpDnsHelper", "sendHttpDnsRequest response: " + hynb.o.c.a(tReqQueryHttpDnsRsp));
            j.this.a(tReqQueryHttpDnsRsp.mDomain2Ip);
        }

        @Override // hynb.b.h
        public Class<TReqQueryHttpDnsRsp> getResponseClass() {
            return TReqQueryHttpDnsRsp.class;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, TReqQueryHttpDnsRsp tReqQueryHttpDnsRsp) {
            hynb.p.g.f406799a.error("HttpDnsHelper", "sendHttpDnsRequest onError: " + str);
        }
    }

    public static j a() {
        if (f406622b == null) {
            synchronized (j.class) {
                if (f406622b == null) {
                    f406622b = new j();
                }
            }
        }
        return f406622b;
    }

    public void a(String str) {
        new BaseThread(new a(str)).start();
    }

    public final void a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        QueryHttpDnsReq queryHttpDnsReq = new QueryHttpDnsReq();
        queryHttpDnsReq.vDomain = arrayList;
        queryHttpDnsReq.sUA = str2;
        queryHttpDnsReq.iIpStack = l.i().p() ? 1 : 0;
        hynb.p.g.f406799a.info("HttpDnsHelper", "sendHttpDnsRequest queryHttpDnsReq: " + hynb.o.c.a(queryHttpDnsReq));
        l.i().c(new HYNSRequest.Builder().sServantName("launch").sFuncName("queryHttpDns").jsonBodyObj(queryHttpDnsReq).channel(1).build(), new b());
    }

    public final void a(Map<String, TReqQueryHttpDnsRsp.HttpDnsItem> map) {
        List<String> list;
        if (map != null && !map.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            for (Map.Entry<String, TReqQueryHttpDnsRsp.HttpDnsItem> entry : map.entrySet()) {
                TReqQueryHttpDnsRsp.HttpDnsItem value = entry.getValue();
                String key = entry.getKey();
                value.iExpireTime = (value.iExpireTime * 1000) + currentTimeMillis;
                List<String> list2 = value.vIp;
                if ((list2 != null && list2.size() > 0) || ((list = value.vIpv6) != null && list.size() > 0)) {
                    List<String> list3 = value.vIp;
                    if (list3 != null && list3.size() > 0) {
                        List<String> a16 = a(value.vIp);
                        value.vIp.clear();
                        value.vIp.addAll(a16);
                    }
                    List<String> list4 = value.vIpv6;
                    if (list4 != null && list4.size() > 0) {
                        List<String> a17 = a(value.vIpv6);
                        value.vIpv6.clear();
                        value.vIpv6.addAll(a17);
                    }
                    this.f406623a.put(key, value);
                } else {
                    hynb.p.g.f406799a.b("HttpDnsHelper", "The server issues an empty IPs, domain = %s", key);
                }
            }
        } else {
            hynb.p.g.f406799a.error("HttpDnsHelper", "saveHttpdnsResult domain2IpMap is empty");
        }
        b("saveHttpdnsResult");
    }

    public final List<String> a(TReqQueryHttpDnsRsp.HttpDnsItem httpDnsItem, boolean z16) {
        if (httpDnsItem == null) {
            return null;
        }
        if (z16 && a(httpDnsItem.iExpireTime)) {
            hynb.p.g.f406799a.info("HttpDnsHelper", "isExpired");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<String> list = httpDnsItem.vIp;
        if (list != null) {
            arrayList.addAll(list);
        }
        List<String> list2 = httpDnsItem.vIpv6;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    public final boolean a(long j3) {
        return System.currentTimeMillis() > j3;
    }

    public String a(String str, boolean z16) {
        hynb.p.e eVar = hynb.p.g.f406799a;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = z16 ? "true" : "false";
        eVar.a("HttpDnsHelper", "getHostByName domainName = %s, needCheck=%s", objArr);
        if (str == null) {
            eVar.a("HttpDnsHelper", "getHostByName domain is null, domainName=%s", str);
            return "";
        }
        List<String> a16 = a(this.f406623a.get(str), z16);
        if (a16 != null && a16.size() > 0) {
            eVar.a("HttpDnsHelper", "getHostByName from cache , ips=%s, domainName = %s", Arrays.toString(a16.toArray()), str);
            return a16.get(0);
        }
        eVar.a("HttpDnsHelper", "getHostByName finally, return null. domainName=%s", str);
        return "";
    }

    public List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                if (InetAddress.getByName(str).isReachable(5000)) {
                    arrayList.add(str);
                }
            } catch (IOException e16) {
                hynb.p.g.f406799a.info("HttpDnsHelper", "findAvailableIp IOException: " + e16.getMessage());
            }
        }
        hynb.p.g.f406799a.info("HttpDnsHelper", "findAvailableIp ips:" + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }
}
