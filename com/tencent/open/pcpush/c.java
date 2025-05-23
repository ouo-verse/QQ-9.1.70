package com.tencent.open.pcpush;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.f;
import com.tencent.open.business.base.e;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements DownloadListener {

    /* renamed from: e, reason: collision with root package name */
    protected static c f341699e;

    /* renamed from: f, reason: collision with root package name */
    protected static List<a> f341700f;

    /* renamed from: a, reason: collision with root package name */
    protected int f341701a = 111;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f341702b = new HandlerC9282c(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: c, reason: collision with root package name */
    protected ConcurrentHashMap<String, b> f341703c = new ConcurrentHashMap<>(10);

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.open.pcpush.b f341704d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(int i3, String str);

        void b(b bVar, int i3, String str, int i16);

        void onDownloadUpdate(List<b> list);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f341705a;

        /* renamed from: b, reason: collision with root package name */
        public String f341706b;

        /* renamed from: c, reason: collision with root package name */
        public String f341707c;

        /* renamed from: d, reason: collision with root package name */
        public String f341708d;

        /* renamed from: e, reason: collision with root package name */
        public int f341709e;

        /* renamed from: f, reason: collision with root package name */
        public String f341710f;

        /* renamed from: g, reason: collision with root package name */
        public String f341711g;

        /* renamed from: h, reason: collision with root package name */
        public String f341712h;

        /* renamed from: i, reason: collision with root package name */
        public String f341713i;

        /* renamed from: j, reason: collision with root package name */
        public int f341714j;

        /* renamed from: k, reason: collision with root package name */
        public String f341715k;

        /* renamed from: l, reason: collision with root package name */
        public String f341716l;

        /* renamed from: m, reason: collision with root package name */
        public int f341717m;

        /* renamed from: n, reason: collision with root package name */
        public int f341718n;

        /* renamed from: o, reason: collision with root package name */
        public int f341719o;

        /* renamed from: p, reason: collision with root package name */
        public int f341720p;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.open.pcpush.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class HandlerC9282c extends Handler {
        public HandlerC9282c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            String str;
            f.e("PCPushProxy", "handleMessage msg.what = " + message.what + ", msg.obj = " + message.obj);
            int i3 = message.what;
            if (i3 != 115) {
                if (i3 != 116) {
                    String str2 = (String) message.obj;
                    if (str2 != null) {
                        bVar = c.this.f341703c.get(str2);
                        if (bVar == null) {
                            f.c("PCPushProxy", "handleMessage get entry = null, key = " + str2);
                            return;
                        }
                        if (bVar.f341714j != 1) {
                            String str3 = bVar.f341706b;
                            str = str3.substring(str3.indexOf("#") + 1);
                        } else {
                            str = bVar.f341706b;
                        }
                    } else {
                        f.c("PCPushProxy", "handleMessage get key = null");
                        bVar = null;
                        str = null;
                    }
                    int i16 = message.what;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 == 4 && bVar != null) {
                                    e.d("500", bVar.f341707c, str);
                                    return;
                                }
                                return;
                            }
                            c.this.f341704d.b(str2);
                            return;
                        }
                        if (bVar != null) {
                            if (bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.")) {
                                e.d("100", bVar.f341707c, str);
                            } else {
                                e.d("100", "ANDROIDQQ.PCPUSH." + bVar.f341707c, str);
                            }
                            c.this.f341704d.a(bVar);
                            return;
                        }
                        return;
                    }
                    c cVar = c.this;
                    cVar.f341704d.c(cVar.f341703c);
                    return;
                }
                e.d("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
                return;
            }
            e.d("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        }
    }

    protected c() {
        f341700f = new ArrayList(10);
        this.f341704d = new com.tencent.open.pcpush.b();
        this.f341702b.sendEmptyMessage(1);
        DownloadManager.C().Y(this);
    }

    public static synchronized c i() {
        c cVar;
        synchronized (c.class) {
            if (f341699e == null) {
                f341699e = new c();
            }
            cVar = f341699e;
        }
        return cVar;
    }

    public void d(String str) {
        f.a("PCPushProxy", "--> delete key = " + str);
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "delete error because entry = null, key = " + str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, bVar.f341706b);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, bVar.f341711g);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, bVar.f341708d);
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, bVar.f341707c);
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, bVar.f341710f);
        String str2 = com.tencent.open.downloadnew.e.f341516y;
        boolean z16 = true;
        if (bVar.f341714j != 1) {
            z16 = false;
        }
        bundle.putBoolean(str2, z16);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 10);
        DownloadApi.d(null, bundle, "5", null, 0);
        this.f341703c.remove(str);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.f341702b.sendMessage(obtain);
    }

    protected String e(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return "p" + str.hashCode();
    }

    public String f(String str) {
        if (!this.f341703c.containsKey(str)) {
            return null;
        }
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "getDownloadPath error because entry = null, key = " + str);
            return null;
        }
        DownloadInfo w3 = DownloadManager.C().w(bVar.f341706b);
        if (w3 == null) {
            return null;
        }
        return w3.L;
    }

    protected String g() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        Context e16 = com.tencent.open.adapter.a.f().e();
        if (e16 != null && (connectivityManager = (ConnectivityManager) e16.getSystemService("connectivity")) != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null && networkInfo.isConnected() && networkInfo.isAvailable()) {
            return "ANDROIDQQ.PCPUSH.AUTO";
        }
        int i3 = this.f341701a;
        if (i3 == 111) {
            return "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
        }
        if (i3 == 112) {
            return "ANDROIDQQ.PCPUSH.MUTIDETAIL";
        }
        if (i3 != 113) {
            return "ANDROIDQQ.PCPUSH.AUTO";
        }
        return "ANDROIDQQ.PCPUSH.UNREADPOP";
    }

    public void h(String str) {
        f.a("PCPushProxy", "--> install key = " + str);
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "install error because entry = null, key = " + str);
            return;
        }
        boolean z16 = true;
        if (bVar.f341714j != 1) {
            f.c("PCPushProxy", "The file to be installing is not a apk file");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, bVar.f341706b);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, bVar.f341711g);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, bVar.f341708d);
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, bVar.f341707c);
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, bVar.f341710f);
        String str2 = com.tencent.open.downloadnew.e.f341516y;
        if (bVar.f341714j != 1) {
            z16 = false;
        }
        bundle.putBoolean(str2, z16);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 5);
        DownloadApi.d(null, bundle, "5", null, 0);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        f.a("PCPushProxy", "--> installSucceed packageName = " + str2);
        b bVar = null;
        for (b bVar2 : this.f341703c.values()) {
            if (str2.equals(bVar2.f341708d) && bVar2.f341717m == 0) {
                bVar2.f341717m = 1;
                bVar = bVar2;
            }
        }
        if (bVar == null) {
            return;
        }
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().a(6, bVar.f341705a);
        }
    }

    public boolean j(String str) {
        f.a("PCPushProxy", "--> isInstalled key = " + str);
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.a("PCPushProxy", "--> key : " + str + " 's entry is not exist.");
            return false;
        }
        return com.tencent.open.business.base.a.a(bVar.f341708d);
    }

    public int k(String str) {
        String f16;
        f.a("PCPushProxy", "--> open key = " + str);
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + str);
            return 1;
        }
        if (bVar.f341714j != 1 && ((f16 = f(str)) == null || f16.trim().equals("") || !new File(f16).exists())) {
            f.c("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + str);
            return 2;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = str;
        this.f341702b.sendMessage(obtain);
        Context e16 = com.tencent.open.adapter.a.f().e();
        if (e16 == null) {
            f.a("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
            return 4;
        }
        PackageManager packageManager = e16.getPackageManager();
        if (packageManager == null) {
            f.a("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
            return 4;
        }
        if (bVar.f341714j == 1) {
            try {
                Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, bVar.f341708d);
                if (launchIntentForPackage == null) {
                    f.a("PCPushProxy", "open fail, because package not found, package = " + bVar.f341708d);
                    return 4;
                }
                launchIntentForPackage.addFlags(268435456);
                e16.startActivity(launchIntentForPackage);
            } catch (Exception e17) {
                f.b("PCPushProxy", "open fail, error : ", e17);
                return 4;
            }
        } else {
            DownloadInfo w3 = DownloadManager.C().w(bVar.f341706b);
            if (w3 == null) {
                return 4;
            }
            Intent b16 = com.tencent.open.pcpush.a.b(e16, new File(w3.L));
            if (b16 != null) {
                List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(packageManager, b16, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
                    e16.startActivity(b16);
                } else {
                    f.a("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
                    return 3;
                }
            }
        }
        f.a("PCPushProxy", "open success");
        return 0;
    }

    public void l(String str) {
        f.a("PCPushProxy", "--> pause key = " + str);
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "pause error because entry = null, key = " + str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, bVar.f341706b);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, bVar.f341711g);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, bVar.f341708d);
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, bVar.f341707c);
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, bVar.f341710f);
        String str2 = com.tencent.open.downloadnew.e.f341516y;
        boolean z16 = true;
        if (bVar.f341714j != 1) {
            z16 = false;
        }
        bundle.putBoolean(str2, z16);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 3);
        DownloadApi.d(null, bundle, "5", null, 0);
    }

    public void m(a aVar) {
        f.a("PCPushProxy", "registerDownloadLitener dataline register listeners");
        if (!f341700f.contains(aVar)) {
            f341700f.add(aVar);
        }
    }

    public void n(int i3) {
        this.f341702b.sendEmptyMessage(i3);
    }

    public void o(int i3) {
        this.f341701a = i3;
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
        f.a("PCPushProxy", "--> onDownloadCancel info = " + downloadInfo.toString());
        String e16 = e(downloadInfo.f341186f);
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().a(5, e16);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        b bVar;
        if (downloadInfo != null) {
            f.a("PCPushProxy", "--> onDownloadError info = " + downloadInfo.toString() + " errorCode = " + i3 + " errorMsg = " + str + " state = " + i16);
            String e16 = e(downloadInfo.f341186f);
            bVar = this.f341703c.get(e16);
            if (bVar == null) {
                f.c("PCPushProxy", "onDownloadError error because entry = null, key = " + e16);
                return;
            }
            bVar.f341719o = 105;
        } else {
            bVar = null;
        }
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().b(bVar, i3, str, i16);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        f.a("PCPushProxy", "--> onDownloadFinish info = " + downloadInfo.toString());
        String e16 = e(downloadInfo.f341186f);
        b bVar = this.f341703c.get(e16);
        if (bVar == null) {
            f.c("PCPushProxy", "onDownloadPause error because entry = null, key = " + e16);
            return;
        }
        bVar.f341719o = 102;
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().a(4, e16);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        f.a("PCPushProxy", "--> onDownloadPause info = " + downloadInfo.toString());
        String e16 = e(downloadInfo.f341186f);
        b bVar = this.f341703c.get(e16);
        if (bVar == null) {
            f.c("PCPushProxy", "onDownloadPause error because entry = null, key = " + e16);
            return;
        }
        bVar.f341719o = 105;
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().a(2, e16);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        f.a("PCPushProxy", "--> onDownloadUpdate infos = " + list.toString());
        ArrayList arrayList = new ArrayList(10);
        for (DownloadInfo downloadInfo : list) {
            String e16 = e(downloadInfo.f341186f);
            b bVar = this.f341703c.get(e16);
            if (bVar == null) {
                f.c("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + e16);
            } else {
                int i3 = bVar.f341719o;
                int f16 = downloadInfo.f();
                if (f16 != 1) {
                    if (f16 != 2) {
                        if (f16 != 3) {
                            if (f16 != 4) {
                                if (f16 == 20) {
                                    bVar.f341719o = 104;
                                }
                            } else if (bVar.f341717m == 1) {
                                bVar.f341719o = 103;
                            } else {
                                bVar.f341719o = 102;
                            }
                        } else {
                            bVar.f341719o = 105;
                        }
                    } else {
                        bVar.f341719o = 101;
                    }
                } else {
                    bVar.f341719o = 100;
                }
                bVar.f341720p = downloadInfo.Q;
                if (i3 != 101 && bVar.f341719o == 101) {
                    Iterator<a> it = f341700f.iterator();
                    while (it.hasNext()) {
                        it.next().a(1, e16);
                    }
                }
                arrayList.add(bVar);
            }
        }
        Iterator<a> it5 = f341700f.iterator();
        while (it5.hasNext()) {
            it5.next().onDownloadUpdate(arrayList);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        f.a("PCPushProxy", "--> onDownloadWait info = " + downloadInfo.toString());
        String e16 = e(downloadInfo.f341186f);
        Iterator<a> it = f341700f.iterator();
        while (it.hasNext()) {
            it.next().a(3, e16);
        }
    }

    public boolean p(String str) {
        boolean z16;
        int i3;
        f.a("PCPushProxy", "--> start key = " + str);
        if (!DownloadManager.C().U().contains(this)) {
            DownloadManager.C().Y(this);
            f.a("PCPushProxy", "PCPushProxy has not register, register download listener");
        }
        b bVar = this.f341703c.get(str);
        if (bVar == null) {
            f.c("PCPushProxy", "start error because entry = null, key = " + str);
            return false;
        }
        int i16 = bVar.f341719o;
        if (i16 != 101 && i16 != 104) {
            if (i16 != 105) {
                if (!bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.")) {
                    bVar.f341707c = g() + "." + bVar.f341707c;
                } else {
                    if (bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
                        i3 = 21;
                    } else if (bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
                        i3 = 29;
                    } else if (bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
                        i3 = 27;
                    } else if (bVar.f341707c.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
                        i3 = 26;
                    } else {
                        i3 = 16;
                    }
                    bVar.f341707c = g() + bVar.f341707c.substring(i3);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, bVar.f341706b);
            bundle.putString(com.tencent.open.downloadnew.e.f341501j, bVar.f341711g);
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, bVar.f341708d);
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, bVar.f341707c);
            bundle.putString(com.tencent.open.downloadnew.e.f341503l, bVar.f341710f);
            String str2 = com.tencent.open.downloadnew.e.f341516y;
            if (bVar.f341714j == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bundle.putBoolean(str2, z16);
            int i17 = 2;
            if (bVar.f341714j == 1 && bVar.f341718n == 2) {
                i17 = 12;
            }
            bundle.putInt(com.tencent.open.downloadnew.e.f341502k, i17);
            DownloadApi.d(null, bundle, "5", null, 0);
        }
        return true;
    }

    public void q(a aVar) {
        if (f341700f.contains(aVar)) {
            f341700f.remove(aVar);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(String str, String str2) {
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(String str, String str2) {
    }
}
