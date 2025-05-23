package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.common.b.i;
import com.tencent.gamecenter.wadl.sdk.common.e.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class DNSPreParseManager {
    public static final int DNS_PRE_PARSE_TYPE_HALLEY = 2001;
    public static final int DNS_PRE_PARSE_TYPE_LOCAL_DNS = 2000;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.b.d.a f107390a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f107391b;

    /* renamed from: c, reason: collision with root package name */
    private int f107392c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f107393d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f107394e;

    /* loaded from: classes6.dex */
    class a implements com.tencent.gamecenter.wadl.sdk.common.b.d {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.common.b.d
        public void onNetworkSwitch(int i3, String str) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl_DNSPreParseManager", String.format("netType=%1$s, apn=%2$s", Integer.valueOf(i3), str));
            DNSPreParseManager.this.f107390a = new com.tencent.gamecenter.wadl.sdk.downloader.b.d.a(str);
            DNSPreParseManager dNSPreParseManager = DNSPreParseManager.this;
            dNSPreParseManager.a((List<String>) dNSPreParseManager.f107393d, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f107396d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f107397e;

        b(List list, int i3) {
            this.f107396d = list;
            this.f107397e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            DNSPreParseManager dNSPreParseManager = DNSPreParseManager.this;
            com.tencent.gamecenter.wadl.sdk.downloader.b.b dnsParserImplByType = dNSPreParseManager.getDnsParserImplByType(dNSPreParseManager.f107392c);
            if (dnsParserImplByType != null) {
                Map<String, com.tencent.gamecenter.wadl.sdk.downloader.b.d.b> a16 = dnsParserImplByType.a(this.f107396d);
                if (a16.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dns_type", String.valueOf(this.f107397e));
                    hashMap.put("refresh_type", String.valueOf(DNSPreParseManager.this.f107392c));
                    hashMap.put("dns_parse_result", "0");
                    dnsParserImplByType.a(WadlProxyConsts.OPER_ID_URL_CHANGE, "50", hashMap);
                } else {
                    DNSPreParseManager.this.f107390a.a(a16);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("dns_type", String.valueOf(this.f107397e));
                    hashMap2.put("refresh_type", String.valueOf(DNSPreParseManager.this.f107392c));
                    hashMap2.put("dns_parse_result", "1");
                    dnsParserImplByType.b(WadlProxyConsts.OPER_ID_URL_CHANGE, "50", hashMap2);
                }
                DNSPreParseManager.this.b(a16);
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_DNSPreParseManager", "can't handle dns parser!!!");
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DNSPreParseManager dNSPreParseManager = DNSPreParseManager.this;
            dNSPreParseManager.a((List<String>) dNSPreParseManager.f107393d, 1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final DNSPreParseManager f107400a = new DNSPreParseManager(null);
    }

    DNSPreParseManager() {
        this.f107391b = false;
        this.f107393d = new ArrayList();
        this.f107394e = new c();
        com.tencent.gamecenter.wadl.sdk.common.b.c.a("Wadl_DNSPreParseManager", new a());
        this.f107390a = new com.tencent.gamecenter.wadl.sdk.downloader.b.d.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b());
    }

    private long a(Map<String, com.tencent.gamecenter.wadl.sdk.downloader.b.d.b> map) {
        long j3 = 60000;
        if (map == null || map.isEmpty()) {
            return 60000L;
        }
        Iterator<Map.Entry<String, com.tencent.gamecenter.wadl.sdk.downloader.b.d.b>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.gamecenter.wadl.sdk.downloader.b.d.b value = it.next().getValue();
            j3 = Math.max(j3, Math.min(value.b() * 1000, value.d() * 1000));
        }
        return ((float) j3) * 0.85f;
    }

    public static DNSPreParseManager getInstance() {
        return d.f107400a;
    }

    public void executeDnsPreParserByHalley(List<String> list) {
        this.f107392c = 2;
        this.f107393d.clear();
        this.f107393d.addAll(list);
        a(this.f107393d, 1000);
    }

    public void executeDnsPreParserByLocalDns(List<String> list) {
        this.f107392c = 1;
        this.f107393d.clear();
        this.f107393d.addAll(list);
        a(this.f107393d, 1000);
    }

    public List<String> getAllDomains() {
        return this.f107393d;
    }

    public Pair<List<String>, List<String>> getAllIpsFromCache(String str, String str2) {
        com.tencent.gamecenter.wadl.sdk.downloader.b.d.a aVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.f107390a) != null) {
            return aVar.a(str, str2);
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_DNSPreParseManager", "[getAllIpsFromCache] params error!!!");
        return new Pair<>(Collections.emptyList(), Collections.emptyList());
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.b.b getDnsParserImplByType(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            return new com.tencent.gamecenter.wadl.sdk.downloader.b.a();
        }
        return new com.tencent.gamecenter.wadl.sdk.downloader.b.c();
    }

    public int getDnsPreParseType() {
        return this.f107392c;
    }

    public boolean isDnsPreParseSwitchOn() {
        return this.f107391b;
    }

    public void setDnsPreParserSwitch(boolean z16) {
        this.f107391b = z16;
    }

    /* synthetic */ DNSPreParseManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, com.tencent.gamecenter.wadl.sdk.downloader.b.d.b> map) {
        if (isDnsPreParseSwitchOn()) {
            i.a().a(this.f107394e, a(map));
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_DNSPreParseManager", "[refreshIpInfoCircle] dns pre parse switch is off!!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, int i3) {
        if (!isDnsPreParseSwitchOn()) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_DNSPreParseManager", "[preDnsParseFromDomains] dns pre parse switch is off!!!");
        } else if (list == null || list.size() == 0) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_DNSPreParseManager", "[preDnsParseFromDomains] domains is empty!!!");
        } else {
            i.a().a(this.f107394e);
            f.a(new b(list, i3));
        }
    }
}
