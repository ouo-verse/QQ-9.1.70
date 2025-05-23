package com.tencent.halley;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.halley.common.HalleyException;
import com.tencent.halley.common.ParseDnsServerType;
import com.tencent.halley.common.a.k;
import com.tencent.halley.common.d.g;
import com.tencent.halley.common.d.h;
import com.tencent.halley.common.d.i;
import com.tencent.halley.common.e.a;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.c.a;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.e;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.measure.RAFTMeasure;
import com.tencent.raft.measure.config.RAFTComConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f113169a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f113170b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f113171a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16018);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ParseDnsServerType.values().length];
            f113171a = iArr;
            try {
                iArr[ParseDnsServerType.LOCAL_DNS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f113171a[ParseDnsServerType.HTTP_DNS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f113171a[ParseDnsServerType.HALLEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f113170b = false;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(com.tencent.halley.downloader.task.d.b bVar, String str, URL url, List<String> list, boolean z16) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a16 = com.tencent.halley.downloader.g.b.a(url, it.next(), z16);
            com.tencent.halley.common.utils.d.c("halley-cloud-HalleyAgent", " http dns replaced url = ".concat(String.valueOf(a16)));
            if (!TextUtils.isEmpty(a16)) {
                bVar.a(str, a16, a.EnumC1249a.f113907l);
            }
        }
    }

    public static b f() {
        if (f113169a == null) {
            synchronized (b.class) {
                if (f113169a == null) {
                    f113169a = new b();
                }
            }
        }
        return f113169a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca A[Catch: MalformedURLException -> 0x0107, TryCatch #0 {MalformedURLException -> 0x0107, blocks: (B:8:0x001b, B:10:0x002f, B:13:0x0034, B:15:0x0046, B:16:0x008a, B:18:0x009d, B:20:0x00a7, B:22:0x00c4, B:24:0x00ca, B:26:0x00d8, B:28:0x00de, B:30:0x00ec, B:32:0x004c, B:34:0x0056, B:35:0x005c, B:37:0x0062, B:38:0x0064, B:39:0x0077, B:40:0x0067, B:42:0x006d, B:43:0x0072, B:44:0x007d), top: B:7:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d8 A[Catch: MalformedURLException -> 0x0107, TryCatch #0 {MalformedURLException -> 0x0107, blocks: (B:8:0x001b, B:10:0x002f, B:13:0x0034, B:15:0x0046, B:16:0x008a, B:18:0x009d, B:20:0x00a7, B:22:0x00c4, B:24:0x00ca, B:26:0x00d8, B:28:0x00de, B:30:0x00ec, B:32:0x004c, B:34:0x0056, B:35:0x005c, B:37:0x0062, B:38:0x0064, B:39:0x0077, B:40:0x0067, B:42:0x006d, B:43:0x0072, B:44:0x007d), top: B:7:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(String str, com.tencent.halley.downloader.task.d.b bVar) {
        Pair<List<String>, List<String>> pair;
        Pair<List<String>, List<String>> pair2;
        com.tencent.halley.downloader.c.d dVar;
        com.tencent.halley.downloader.d.a aVar;
        if (!a.C1243a.a().f113664c.booleanValue()) {
            com.tencent.halley.common.utils.d.c("halley-cloud-HalleyAgent", "\u672a\u5f00\u542fdns\u9884\u89e3\u6790\uff0c\u8fd9\u91cc\u4e0d\u505a\u57df\u540d\u66ff\u6362");
            return;
        }
        String b16 = com.tencent.halley.common.a.c.b();
        try {
            URL url = new URL(str);
            com.tencent.halley.downloader.c.a a16 = a.C1243a.a();
            String host = url.getHost();
            if (!TextUtils.isEmpty(host) && (dVar = a16.f113662a) != null) {
                Object arrayList = new ArrayList();
                List<String> arrayList2 = new ArrayList<>();
                if (!dVar.f113690a.equals(b16)) {
                    pair = new Pair<>(arrayList, arrayList2);
                } else {
                    e eVar = dVar.f113691b.get(host);
                    if (eVar == null) {
                        pair = new Pair<>(arrayList, arrayList);
                    } else {
                        if (com.tencent.halley.common.a.c.i() == 1) {
                            aVar = eVar.f113692a;
                        } else if (com.tencent.halley.common.a.c.i() == 3) {
                            arrayList2 = eVar.f113692a.f113719b;
                            pair = new Pair<>(arrayList, arrayList2);
                        } else {
                            aVar = eVar.f113692a;
                            arrayList2 = aVar.f113719b;
                        }
                        arrayList = aVar.f113718a;
                        pair = new Pair<>(arrayList, arrayList2);
                    }
                }
                pair2 = pair;
                j(b16, url.getHost(), pair2, false);
                if (((List) pair2.first).size() != 0 && ((List) pair2.second).size() == 0) {
                    com.tencent.halley.common.utils.d.c("halley-cloud-HalleyAgent", "\u57df\u540d\uff1a" + url.getHost() + "\uff0c\u9884\u89e3\u6790\u7f13\u5b58\u6c60\u4e0d\u5b58\u5728\u8be5\u57df\u540d");
                    return;
                }
                if (com.tencent.halley.common.a.c.i() != 1) {
                    a(bVar, b16, url, (List) pair2.first, false);
                    return;
                } else if (com.tencent.halley.common.a.c.i() == 3) {
                    a(bVar, b16, url, (List) pair2.second, true);
                    return;
                } else {
                    a(bVar, b16, url, (List) pair2.second, true);
                    a(bVar, b16, url, (List) pair2.first, false);
                    return;
                }
            }
            pair = new Pair<>(Collections.emptyList(), Collections.emptyList());
            pair2 = pair;
            j(b16, url.getHost(), pair2, false);
            if (((List) pair2.first).size() != 0) {
            }
            if (com.tencent.halley.common.a.c.i() != 1) {
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            j(b16, str, new Pair<>(Collections.emptyList(), Collections.emptyList()), true);
            com.tencent.halley.common.utils.d.c("halley-cloud-HalleyAgent", "Parse Url error", e16);
        }
    }

    private void j(String str, String str2, Pair<List<String>, List<String>> pair, boolean z16) {
        String str3;
        com.tencent.halley.common.e.a aVar;
        HashMap hashMap = new HashMap();
        int i3 = a.f113171a[a.C1243a.a().f113665d.ordinal()];
        String str4 = "0";
        if (i3 == 1) {
            str3 = "0";
        } else if (i3 == 2 || i3 == 3) {
            str3 = "1";
        } else {
            str3 = "";
        }
        ArrayList arrayList = new ArrayList((Collection) pair.first);
        arrayList.addAll((Collection) pair.second);
        hashMap.put("qddReadCacheDomain", str2);
        hashMap.put("qddApnName", str);
        hashMap.put("qddDomainList", TextUtils.join(",", arrayList));
        hashMap.put("qddDnsType", str3);
        if (arrayList.size() == 0 || z16) {
            str4 = "1";
        }
        hashMap.put("qddReadCacheResult", str4);
        aVar = a.C1242a.f113533a;
        aVar.a("B_DLSDK_DnsPod_Read_Cache", true, hashMap);
    }

    public DownloaderTask b(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 4, this, str, str2, str3, downloaderTaskListener);
        }
        return c(str, str2, str3, downloaderTaskListener, -1L, "");
    }

    public DownloaderTask c(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener, long j3, String str4) {
        String str5;
        String str6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 5, this, str, str2, str3, downloaderTaskListener, Long.valueOf(j3), str4);
        }
        if (TextUtils.isEmpty(str)) {
            str5 = "url is empty.";
        } else if (downloaderTaskListener != null) {
            str5 = "";
        } else {
            str5 = "listener is null.";
        }
        if (j.a(str2)) {
            str6 = com.tencent.halley.downloader.a.a.e();
        } else {
            str6 = str2;
        }
        if ("".equals(str5)) {
            com.tencent.halley.downloader.task.d.b bVar = new com.tencent.halley.downloader.task.d.b(str, j3);
            i(str, bVar);
            return new com.tencent.halley.downloader.task.c(bVar, str6, str3, downloaderTaskListener, j3, str4);
        }
        throw new HalleyException(str5);
    }

    public void d(DownloaderTask downloaderTask, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, downloaderTask, Boolean.valueOf(z16));
        } else {
            com.tencent.halley.downloader.c.j.a().a(downloaderTask, z16);
        }
    }

    public List<DownloaderTask> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return com.tencent.halley.downloader.c.j.a().c();
    }

    public List<DownloaderTask> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.tencent.halley.downloader.c.j.a().d();
    }

    public void h(d dVar) {
        com.tencent.halley.downloader.c.c unused;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.halley.common.utils.d.d("halley-cloud-HalleyAgent", "HalleyAgent.init start. initFinish:" + f113170b + ",type:http,param:" + dVar);
        if (f113170b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (dVar != null) {
            unused = c.a.f113689a;
            try {
                com.tencent.msdk.dns.c.h().i(dVar.d(), dVar.g(), dVar.e(), dVar.f(), "119.29.29.98", true, 1000);
            } catch (Exception e16) {
                Log.e("HttpDnsManager", "init exception!", e16);
            }
            String a16 = i.a(dVar.d());
            com.tencent.halley.common.a.a(dVar.k(), dVar, a16);
            com.tencent.halley.common.a.b.a();
            k.f113283a = dVar.b();
            com.tencent.halley.common.utils.d.d("halley-cloud-HalleyAgent", "HalleyAgent.init try startPlatform on process:".concat(String.valueOf(a16)));
            h d16 = h.d();
            g e17 = g.e();
            d16.f113526a = e17;
            e17.a(d16);
            d16.f113526a.d();
            f113170b = true;
            com.tencent.halley.downloader.c.j.a();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.halley.common.utils.d.d("halley-cloud-HalleyAgent", "HalleyAgent.init finished on process:" + a16 + ",initFinish:" + f113170b + ",initTime:" + currentTimeMillis + ",costTime:" + elapsedRealtime2);
            Context d17 = dVar.d();
            RAFTComConfig rAFTComConfig = com.tencent.halley.common.a.f113181j;
            RAFTMeasure.enableCrashMonitor(d17, rAFTComConfig);
            RAFTMeasure.reportAvg(dVar.d(), rAFTComConfig, "init_cost", elapsedRealtime2);
            return;
        }
        throw new QDDownloaderRuntimeException("initParam null");
    }

    public String k(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloaderTask);
        }
        if (downloaderTask instanceof com.tencent.halley.downloader.task.c) {
            String b16 = com.tencent.halley.downloader.c.j.a().b(downloaderTask);
            com.tencent.halley.common.utils.d.a("halley-cloud-HalleyAgent", " startDownload- " + downloaderTask.getFileUrl() + ", ret= " + b16, true);
            return b16;
        }
        throw new RuntimeException("DownloaderTask should be created by Downloader.createNewTask");
    }
}
