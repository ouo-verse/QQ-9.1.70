package com.tencent.hlyyb.downloader.g.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.av.so.ResInfo;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static volatile j f114681i;

    /* renamed from: a, reason: collision with root package name */
    public Context f114682a;

    /* renamed from: b, reason: collision with root package name */
    public final List<com.tencent.hlyyb.downloader.g.a.a> f114683b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f114684c;

    /* renamed from: d, reason: collision with root package name */
    public CountDownLatch f114685d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f114686e;

    /* renamed from: f, reason: collision with root package name */
    public String f114687f;

    /* renamed from: g, reason: collision with root package name */
    public String f114688g;

    /* renamed from: h, reason: collision with root package name */
    public final BroadcastReceiver f114689h;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.hlyyb.downloader.g.a.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC5824a implements Runnable {
            static IPatchRedirector $redirector_;

            public RunnableC5824a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (!j.this.f114683b.isEmpty()) {
                        for (com.tencent.hlyyb.downloader.g.a.a aVar : j.this.f114683b) {
                            if (aVar != null) {
                                aVar.b(true, j.this.f114687f, j.this.f114688g);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null) {
                j.this.f114686e = true;
                try {
                    j.this.f114687f = intent.getStringExtra("A1");
                    j.this.f114688g = intent.getStringExtra(NowProxyConstants.AccountInfoKey.A2);
                } catch (Throwable unused) {
                }
                try {
                    if (j.this.f114685d != null) {
                        j.this.f114685d.countDown();
                    }
                } catch (Throwable unused2) {
                }
                j.this.q();
                try {
                    h.e().post(new RunnableC5824a());
                } catch (Throwable unused3) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f114692d;

        public b(d dVar) {
            this.f114692d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, (Object) dVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                j.this.n(this.f114692d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114683b = new ArrayList();
        this.f114686e = false;
        this.f114687f = "";
        this.f114688g = "";
        this.f114689h = new a();
    }

    public static d a(JSONObject jSONObject) {
        try {
            d dVar = new d();
            dVar.f114663a = jSONObject.optBoolean(ResInfo.RES_TYPE_SO);
            dVar.f114664b = jSONObject.optInt("pi");
            dVar.f114665c = jSONObject.optInt("lpd");
            jSONObject.optInt("cvc");
            String str = Build.BRAND;
            DeviceInfoMonitor.getModel();
            if (jSONObject.has("bbl")) {
                String optString = jSONObject.optString("bbl");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    dVar.f114666d = jSONObject2.optString("a");
                    dVar.f114667e = jSONObject2.optString("b");
                    dVar.f114668f = jSONObject2.optString("c");
                }
            }
            if (jSONObject.has("aso")) {
                dVar.f114669g = jSONObject.optBoolean("aso");
            }
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static j b() {
        if (f114681i == null) {
            synchronized (j.class) {
                if (f114681i == null) {
                    f114681i = new j();
                }
            }
        }
        return f114681i;
    }

    public static Map<String, String> e(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("yyb_qua", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("yyb_ver", str2);
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.tencent.android.qqdownloader.action.QUERY_CONNECT_STATE");
            intent.setPackage(SDKConst.SELF_PACKAGENAME);
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
            k.m(context, GlobalUtil.DEF_STRING, 5, null);
        }
    }

    private void h(d dVar) {
        try {
            this.f114683b.clear();
            if (dVar.f114669g && k.j(dVar.f114666d)) {
                this.f114683b.add(new f());
            }
            if (k.u(this.f114682a) && k.j(dVar.f114667e)) {
                this.f114683b.add(new i());
            }
            if (k.t(this.f114682a) && k.j(dVar.f114668f)) {
                this.f114683b.add(new com.tencent.hlyyb.downloader.g.a.b());
            }
        } catch (Throwable unused) {
        }
    }

    private long k() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            boolean z16 = false;
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            if (currentTimeMillis >= timeInMillis && currentTimeMillis - timeInMillis <= 120000) {
                z16 = true;
            }
            if (!z16) {
                return 0L;
            }
            return ((new Random().nextInt(60) % 60) + 1) * 1000;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(d dVar) {
        com.tencent.hlyyb.downloader.g.a.a next;
        h(dVar);
        if (this.f114683b.isEmpty()) {
            k.m(this.f114682a, GlobalUtil.DEF_STRING, 18, null);
            return;
        }
        Iterator<com.tencent.hlyyb.downloader.g.a.a> it = this.f114683b.iterator();
        while (it.hasNext() && ((next = it.next()) == null || !next.c(this.f114682a))) {
        }
        k.v(this.f114682a);
    }

    private void p() {
        if (this.f114684c) {
            return;
        }
        try {
            this.f114682a.registerReceiver(this.f114689h, new IntentFilter("com.tencent.android.qqdownloader.action.CONNECT_PC_STATE"));
            this.f114684c = true;
        } catch (Throwable unused) {
            k.m(this.f114682a, GlobalUtil.DEF_STRING, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            this.f114682a.unregisterReceiver(this.f114689h);
        } catch (Throwable unused) {
        }
        this.f114684c = false;
    }

    public void g(Context context, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) jSONObject);
            return;
        }
        try {
            this.f114682a = context;
            d a16 = a(jSONObject);
            this.f114686e = false;
            this.f114687f = "";
            this.f114688g = "";
            this.f114683b.clear();
            if (a16 != null && a16.f114663a) {
                if (k.s(context) <= 0) {
                    k.m(context, GlobalUtil.DEF_STRING, 2, null);
                    return;
                }
                c d16 = k.d(context, a16);
                if (d16 != null && !d16.f114660a) {
                    HashMap hashMap = new HashMap();
                    String str = d16.f114662c;
                    if (str != null) {
                        hashMap.put("pull_count", str);
                    }
                    k.m(context, GlobalUtil.DEF_STRING, d16.f114661b, hashMap);
                    return;
                }
                p();
                this.f114685d = new CountDownLatch(1);
                f(context);
                if (!this.f114685d.await(5000L, TimeUnit.MILLISECONDS)) {
                    if (!this.f114686e) {
                        long k3 = k();
                        if (k3 > 0) {
                            h.d().postDelayed(new b(a16), k3);
                            return;
                        } else {
                            n(a16);
                            return;
                        }
                    }
                    k.m(context, GlobalUtil.DEF_STRING, 12, e(this.f114687f, this.f114688g));
                    return;
                }
                k.m(context, GlobalUtil.DEF_STRING, 12, e(this.f114687f, this.f114688g));
                return;
            }
            k.m(context, GlobalUtil.DEF_STRING, 8, null);
        } catch (Throwable th5) {
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", String.valueOf(th5));
                k.m(context, GlobalUtil.DEF_STRING, 14, hashMap2);
            } catch (Throwable unused) {
            }
        }
    }
}
