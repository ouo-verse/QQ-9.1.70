package com.tencent.creatorad.data;

import android.text.TextUtils;
import com.tencent.creatorad.pb.CreatorReader$GetShareADRsp;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.creatorad.utils.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DataManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static DataManager f100362a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f100363b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Long> f100364c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f100363b = new ConcurrentHashMap();
            f100364c = new ConcurrentHashMap();
        }
    }

    public DataManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DataManager d() {
        if (f100362a == null) {
            synchronized (DataManager.class) {
                if (f100362a == null) {
                    f100362a = new DataManager();
                }
            }
        }
        return f100362a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g(str);
        Map<String, b> map = f100363b;
        if (map.containsKey(str)) {
            QLog.d("CREATOR_AD.DataManager", 2, "Unnecessary to Request ShareAd..");
            if (aVar != null) {
                aVar.a(true, map.get(str).f100370a);
            }
            return false;
        }
        Map<String, Long> map2 = f100364c;
        if (map2.containsKey(str)) {
            if (System.currentTimeMillis() - map2.get(str).longValue() < 10800000) {
                if (aVar != null) {
                    aVar.a(false, null);
                }
                return false;
            }
        }
        return true;
    }

    private void g(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, b> map = f100363b;
        if (map.containsKey(str) && currentTimeMillis > map.get(str).f100371b.longValue() + 86400000) {
            QLog.i("CREATOR_AD.DataManager", 2, "removeOvertimeAd ticket:" + str);
            map.remove(str);
        }
    }

    public void b(String str, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), aVar);
        } else {
            ThreadManagerV2.excute(new Runnable(str, aVar, i3) { // from class: com.tencent.creatorad.data.DataManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f100365d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ a f100366e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f100367f;

                {
                    this.f100365d = str;
                    this.f100366e = aVar;
                    this.f100367f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataManager.this, str, aVar, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (DataManager.this.f(this.f100365d, this.f100366e)) {
                        com.tencent.creatorad.servlet.b.b().e(Collections.singletonList(this.f100365d), this.f100367f, this.f100366e);
                    }
                }
            }, 128, null, false);
        }
    }

    public void c(List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, i3);
        } else if (list != null && !list.isEmpty()) {
            ThreadManagerV2.excute(new Runnable(list, i3) { // from class: com.tencent.creatorad.data.DataManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f100368d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f100369e;

                {
                    this.f100368d = list;
                    this.f100369e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataManager.this, list, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (String str : this.f100368d) {
                        if (DataManager.this.f(str, null)) {
                            arrayList.add(str);
                        }
                    }
                    com.tencent.creatorad.servlet.b.b().e(arrayList, this.f100369e, null);
                }
            }, 128, null, false);
        }
    }

    public void e(boolean z16, CreatorReader$GetShareADRsp creatorReader$GetShareADRsp, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), creatorReader$GetShareADRsp, list);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                f100364c.put(it.next(), Long.valueOf(currentTimeMillis));
            }
        }
        if (z16 && creatorReader$GetShareADRsp != null && creatorReader$GetShareADRsp.ads.has()) {
            for (int i3 = 0; i3 < creatorReader$GetShareADRsp.ads.size(); i3++) {
                String str = creatorReader$GetShareADRsp.ads.get(i3).tickets.get();
                CreatorReader$ShareAD creatorReader$ShareAD = creatorReader$GetShareADRsp.ads.get(i3);
                if (c.g(creatorReader$ShareAD)) {
                    f100363b.put(str, new b(Long.valueOf(currentTimeMillis), creatorReader$ShareAD));
                }
            }
        }
    }
}
