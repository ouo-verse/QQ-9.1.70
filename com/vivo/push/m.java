package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f387721a;

    /* renamed from: h, reason: collision with root package name */
    private Context f387728h;

    /* renamed from: j, reason: collision with root package name */
    private String f387730j;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f387733m;

    /* renamed from: n, reason: collision with root package name */
    private Long f387734n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f387735o;

    /* renamed from: q, reason: collision with root package name */
    private int f387737q;

    /* renamed from: b, reason: collision with root package name */
    private long f387722b = -1;

    /* renamed from: c, reason: collision with root package name */
    private long f387723c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f387724d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f387725e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f387726f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f387727g = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f387729i = true;

    /* renamed from: k, reason: collision with root package name */
    private SparseArray<a> f387731k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private int f387732l = 0;

    /* renamed from: p, reason: collision with root package name */
    private IPushClientFactory f387736p = new l();

    m() {
    }

    public static List<String> c() {
        String g16 = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.u.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(g16)) {
            return arrayList;
        }
        Iterator keys = new JSONObject(g16).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    private boolean l() {
        boolean z16;
        if (this.f387733m == null) {
            if (k() >= 1230 && ag.d(this.f387728h)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f387733m = Boolean.valueOf(z16);
        }
        return this.f387733m.booleanValue();
    }

    public final boolean d() {
        if (this.f387728h == null) {
            com.vivo.push.util.u.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(l());
        this.f387733m = valueOf;
        return valueOf.booleanValue();
    }

    public final void e() {
        this.f387730j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.f387735o;
    }

    public final boolean g() {
        return this.f387729i;
    }

    public final Context h() {
        return this.f387728h;
    }

    public final String i() {
        return this.f387730j;
    }

    public final int j() {
        return this.f387737q;
    }

    public final long k() {
        Context context = this.f387728h;
        if (context == null) {
            return -1L;
        }
        if (this.f387734n == null) {
            this.f387734n = Long.valueOf(ag.a(context));
        }
        return this.f387734n.longValue();
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (f387721a == null) {
                f387721a = new m();
            }
            mVar = f387721a;
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() throws VivoPushException {
        Context context = this.f387728h;
        if (context != null) {
            ag.b(context);
        }
    }

    public static void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String g16 = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(g16)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(g16);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(jSONObject2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private IPushActionListener f387738a;

        /* renamed from: b, reason: collision with root package name */
        private com.vivo.push.b.c f387739b;

        /* renamed from: c, reason: collision with root package name */
        private IPushActionListener f387740c;

        /* renamed from: d, reason: collision with root package name */
        private Runnable f387741d;

        /* renamed from: e, reason: collision with root package name */
        private Object[] f387742e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f387739b = cVar;
            this.f387738a = iPushActionListener;
        }

        public final void a(int i3, Object... objArr) {
            this.f387742e = objArr;
            IPushActionListener iPushActionListener = this.f387740c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i3);
            }
            IPushActionListener iPushActionListener2 = this.f387738a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i3);
            }
        }

        public final Object[] b() {
            return this.f387742e;
        }

        public final void a(Runnable runnable) {
            this.f387741d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f387741d;
            if (runnable == null) {
                com.vivo.push.util.u.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f387740c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f387728h == null) {
            this.f387728h = ContextDelegate.getContext(context);
            this.f387735o = com.vivo.push.util.aa.c(context, context.getPackageName());
            ad.b().a(this.f387728h);
            a(new com.vivo.push.b.g());
            this.f387730j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f387730j)) {
            e();
        }
    }

    public static void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String g16 = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(g16)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(g16);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(jSONObject2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new RunnableC11730r(this, str));
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f387730j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f387725e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f387735o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f387728h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f387725e = SystemClock.elapsedRealtime();
        String a16 = a(new a(aVar, iPushActionListener));
        aVar.b(a16);
        a(aVar);
        c(a16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z16) {
        this.f387729i = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.f387722b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f387722b = SystemClock.elapsedRealtime();
        String packageName = this.f387728h.getPackageName();
        a aVar = null;
        if (this.f387728h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.e();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (this.f387735o) {
                if (l()) {
                    aVar = a(bVar, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else {
                aVar = a(bVar, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new n(this, aVar, str, str2));
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f387731k.get(parseInt);
                this.f387731k.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f387727g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f387727g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f387735o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.f387728h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a16 = a(new a(zVar, iPushActionListener));
        zVar.b(a16);
        a(zVar);
        c(a16);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a16 = a(aVar);
        bVar.b(a16);
        aVar.a(new o(this, bVar, a16));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i3) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.f387723c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f387723c = SystemClock.elapsedRealtime();
            a a16 = a(iPushActionListener, this.f387728h.getPackageName(), str, str2, i3);
            if (a16 == null) {
                return;
            }
            a16.a(new p(this));
            a16.a();
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i3) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i3 > 0) {
            bVar.a(i3);
        }
        bVar.e();
        bVar.b(100);
        if (this.f387735o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String a16 = a(aVar);
            bVar.b(a16);
            aVar.a(new q(this, bVar, a16));
            return aVar;
        }
        if (bVar.a(this.f387728h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    public final void a(String str, int i3, Object... objArr) {
        a b16 = b(str);
        if (b16 != null) {
            b16.a(i3, objArr);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f387730j) && this.f387730j.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f387724d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f387735o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f387728h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f387724d = SystemClock.elapsedRealtime();
        String a16 = a(new a(aVar, iPushActionListener));
        aVar.b(a16);
        a(aVar);
        c(a16);
    }

    private static boolean a(long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j3 == -1 || elapsedRealtime <= j3 || elapsedRealtime >= j3 + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.f387730j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i3) {
        a b16 = b(str);
        if (b16 != null) {
            b16.a(i3, new Object[0]);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i3;
        this.f387731k.put(this.f387732l, aVar);
        i3 = this.f387732l;
        this.f387732l = i3 + 1;
        return Integer.toString(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f387728h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f387726f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f387726f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f387735o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.f387728h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a16 = a(new a(zVar, iPushActionListener));
        zVar.b(a16);
        a(zVar);
        c(a16);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v createReceiverCommand = this.f387736p.createReceiverCommand(intent);
        Context context = a().f387728h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01");
            return 2805;
        }
        com.vivo.push.f.aa createReceiveTask = this.f387736p.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4" + createReceiverCommand + "\u4efb\u52a1\u7a7a\uff01");
            return 2806;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[\u63a5\u6536\u6307\u4ee4]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        createReceiveTask.run();
        return createReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().f387728h;
        if (vVar == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01");
                return;
            }
            return;
        }
        s createTask = this.f387736p.createTask(vVar);
        if (createTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4" + vVar + "\u4efb\u52a1\u7a7a\uff01");
                return;
            }
            return;
        }
        com.vivo.push.util.u.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(createTask);
    }
}
