package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.f.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import e3.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36150a = "push_register";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36151b = "push_transmit";

    /* renamed from: e, reason: collision with root package name */
    private static final String f36154e = "com.mcs.action.RECEIVE_SDK_MESSAGE";

    /* renamed from: f, reason: collision with root package name */
    private static final String f36155f = "type";

    /* renamed from: g, reason: collision with root package name */
    private static final int f36156g = 1019;

    /* renamed from: h, reason: collision with root package name */
    private static final String f36157h = "eventID";

    /* renamed from: i, reason: collision with root package name */
    private static final String f36158i = "taskID";

    /* renamed from: j, reason: collision with root package name */
    private static final String f36159j = "appPackage";

    /* renamed from: k, reason: collision with root package name */
    private static final String f36160k = "extra";

    /* renamed from: l, reason: collision with root package name */
    private static final String f36161l = "messageType";

    /* renamed from: m, reason: collision with root package name */
    private static final String f36162m = "messageID";

    /* renamed from: n, reason: collision with root package name */
    private static final String f36163n = "globalID";

    /* renamed from: o, reason: collision with root package name */
    private static final String f36164o = "supportOpenPush";

    /* renamed from: p, reason: collision with root package name */
    private static final String f36165p = "versionName";

    /* renamed from: q, reason: collision with root package name */
    private static final String f36166q = "versionCode";

    /* renamed from: r, reason: collision with root package name */
    private static final String f36167r = "pushSdkVersion";

    /* renamed from: s, reason: collision with root package name */
    private static final int f36168s = 23;

    /* renamed from: t, reason: collision with root package name */
    private static final int f36169t = 59;

    /* renamed from: u, reason: collision with root package name */
    private static final int f36170u = 24;

    /* renamed from: v, reason: collision with root package name */
    private static final int f36171v = 1000;

    /* renamed from: x, reason: collision with root package name */
    private static String f36173x;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f36174y;
    private Context A;
    private List<com.heytap.mcssdk.e.c> B;
    private List<com.heytap.mcssdk.d.d> C;
    private String D;
    private String E;
    private String F;
    private ICallBackResultService G;

    /* renamed from: z, reason: collision with root package name */
    private final Object f36175z;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f36152c = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f36153d = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};

    /* renamed from: w, reason: collision with root package name */
    private static int f36172w = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f36178a = new d();

        a() {
        }
    }

    d() {
        this.f36175z = new Object();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.F = null;
        synchronized (d.class) {
            int i3 = f36172w;
            if (i3 > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            f36172w = i3 + 1;
        }
        a(new com.heytap.mcssdk.d.b());
        a(new com.heytap.mcssdk.d.a());
        a(new com.heytap.mcssdk.e.b());
        a(new com.heytap.mcssdk.e.a());
    }

    private Intent b(int i3, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(m());
        intent.setPackage(l());
        intent.putExtra("type", i3);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.A;
            jSONObject2.putOpt(f36165p, g.c(context, context.getPackageName()));
            Context context2 = this.A;
            jSONObject2.putOpt("versionCode", Integer.valueOf(g.b(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    jSONObject2.putOpt(str2, jSONObject.get(str2));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th5;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.A.getPackageName());
        intent.putExtra(com.heytap.mcssdk.a.a.f36102l, this.D);
        intent.putExtra(com.heytap.mcssdk.a.a.f36103m, this.E);
        intent.putExtra(com.heytap.mcssdk.a.a.f36104n, this.F);
        intent.putExtra("sdkVersion", s());
        return intent;
    }

    public static d k() {
        return a.f36178a;
    }

    public static String s() {
        return com.heytap.mcssdk.a.f36090f;
    }

    private boolean v() {
        if (this.A != null) {
            return true;
        }
        return false;
    }

    private boolean w() {
        if (this.F != null) {
            return true;
        }
        return false;
    }

    private boolean x() {
        if (v() && w()) {
            return true;
        }
        return false;
    }

    @Override // com.heytap.mcssdk.b
    public void c() {
        b((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.b
    public void d() {
        c(null);
    }

    @Override // com.heytap.mcssdk.b
    public void e() {
        d(null);
    }

    @Override // com.heytap.mcssdk.b
    public void f() {
        e(null);
    }

    @Override // com.heytap.mcssdk.b
    public void g() {
        f(null);
    }

    @Override // com.heytap.mcssdk.b
    public void h() {
        g(null);
    }

    @Override // com.heytap.mcssdk.b
    public void i() {
        h(null);
    }

    @Override // com.heytap.mcssdk.b
    public void j() {
        if (v()) {
            b(com.heytap.mcssdk.a.b.C);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    public String l() {
        boolean z16;
        if (f36173x == null) {
            String a16 = a(this.A);
            if (a16 == null) {
                f36173x = g.a(f36152c);
                z16 = false;
            } else {
                f36173x = a16;
                z16 = true;
            }
            f36174y = z16;
        }
        return f36173x;
    }

    public String m() {
        if (f36173x == null) {
            a(this.A);
        }
        if (f36174y) {
            return f36154e;
        }
        return g.a(f36153d);
    }

    public boolean n() {
        String l3 = l();
        if (g.a(this.A, l3) && g.b(this.A, l3) >= 1019 && g.a(this.A, l3, f36164o)) {
            return true;
        }
        return false;
    }

    public List<com.heytap.mcssdk.d.d> o() {
        return this.C;
    }

    public List<com.heytap.mcssdk.e.c> p() {
        return this.B;
    }

    public ICallBackResultService q() {
        return this.G;
    }

    public void r() {
        if (x()) {
            b(com.heytap.mcssdk.a.b.f36128v, null);
        } else if (q() != null) {
            q().onGetPushStatus(-2, 0);
        }
    }

    public String t() {
        if (v()) {
            return g.c(this.A, l());
        }
        return "";
    }

    public int u() {
        if (v()) {
            return g.b(this.A, l());
        }
        return 0;
    }

    public d a(Context context, boolean z16) {
        this.A = context.getApplicationContext();
        new com.heytap.mcssdk.b.a().a(this.A);
        com.heytap.mcssdk.f.c.f(z16);
        return this;
    }

    @Override // com.heytap.mcssdk.b
    public void b() {
        a((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.b
    public void c(JSONObject jSONObject) {
        if (x()) {
            b(com.heytap.mcssdk.a.b.f36131y, jSONObject);
        } else if (q() != null) {
            q().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void d(JSONObject jSONObject) {
        if (x()) {
            b(com.heytap.mcssdk.a.b.f36130x, jSONObject);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.b
    public void e(JSONObject jSONObject) {
        if (v()) {
            b(com.heytap.mcssdk.a.b.A, jSONObject);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.b
    public void f(JSONObject jSONObject) {
        if (x()) {
            b(com.heytap.mcssdk.a.b.f36132z, jSONObject);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.b
    public void g(JSONObject jSONObject) {
        if (x()) {
            b(12299, jSONObject);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.b
    public void h(JSONObject jSONObject) {
        if (x()) {
            b(12300, jSONObject);
        } else {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.b
    public String a() {
        return this.F;
    }

    public void b(int i3) {
        final Intent b16 = b(i3, "", null);
        this.A.bindService(b16, new ServiceConnection() { // from class: com.heytap.mcssdk.d.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Bundle bundle = new Bundle();
                bundle.putAll(b16.getExtras());
                try {
                    a.AbstractBinderC10214a.j(iBinder).M1(bundle);
                } catch (Exception e16) {
                    com.heytap.mcssdk.f.c.b("bindMcsService exception:" + e16);
                }
                d.this.A.unbindService(this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1);
    }

    private String a(Context context) {
        boolean z16;
        int packageUid;
        int packageUid2;
        boolean z17;
        List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), new Intent(f36154e), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            String str = it.next().serviceInfo.packageName;
            try {
                z16 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                packageUid = context.getPackageManager().getPackageUid(str, 0);
                packageUid2 = context.getPackageManager().getPackageUid("android", 0);
                z17 = packageUid == packageUid2;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z16 || z17) {
                return str;
            }
        }
        return null;
    }

    private void b(int i3, JSONObject jSONObject) {
        a(i3, "", jSONObject);
    }

    @Deprecated
    private static void b(Context context) {
        a(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    @Override // com.heytap.mcssdk.b
    public void a(int i3) {
        a(i3, (JSONObject) null);
    }

    private void a(int i3, String str, JSONObject jSONObject) {
        synchronized (this.f36175z) {
            this.A.startService(b(i3, str, jSONObject));
        }
    }

    public void b(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.D = str;
        this.E = str2;
        this.A = context.getApplicationContext();
        this.G = iCallBackResultService;
        b(jSONObject);
    }

    @Override // com.heytap.mcssdk.b
    public void a(int i3, JSONObject jSONObject) {
        if (!x()) {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, "please call the register first!");
            return;
        }
        a(com.heytap.mcssdk.a.b.f36129w, i3 + "", jSONObject);
    }

    @Override // com.heytap.mcssdk.b
    public void b(JSONObject jSONObject) {
        if (v()) {
            b(12290, jSONObject);
        } else if (q() != null) {
            q().onUnRegister(-2);
        }
    }

    public static void a(Context context, MessageStat messageStat) {
        com.heytap.mcssdk.f.e.a(context, messageStat);
    }

    @Override // com.heytap.mcssdk.b
    public void a(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        a(context, str, str2, (JSONObject) null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.b
    public void a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        a(context, new MessageStat(context.getPackageName(), f36150a, null));
        if (!n()) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
            }
        } else {
            this.D = str;
            this.E = str2;
            this.A = context.getApplicationContext();
            this.G = iCallBackResultService;
            b(12289, jSONObject);
        }
    }

    public static void a(Context context, List<MessageStat> list) {
        com.heytap.mcssdk.f.e.a(context, list);
    }

    private synchronized void a(com.heytap.mcssdk.d.d dVar) {
        if (dVar != null) {
            this.C.add(dVar);
        }
    }

    private synchronized void a(com.heytap.mcssdk.e.c cVar) {
        if (cVar != null) {
            this.B.add(cVar);
        }
    }

    public void a(ICallBackResultService iCallBackResultService) {
        this.G = iCallBackResultService;
    }

    public void a(DataMessage dataMessage, String str, int i3) {
        try {
            Intent intent = new Intent();
            intent.setAction(m());
            intent.setPackage(l());
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", dataMessage.getTaskID());
            intent.putExtra("appPackage", dataMessage.getAppPackage());
            intent.putExtra("messageID", dataMessage.getMessageID());
            intent.putExtra(f36161l, i3);
            intent.putExtra(f36157h, str);
            this.A.startService(intent);
        } catch (Exception e16) {
            com.heytap.mcssdk.f.c.e("statisticMessage--Exception" + e16.getMessage());
        }
    }

    @Override // com.heytap.mcssdk.b
    public void a(String str) {
        this.F = str;
    }

    public void a(String str, String str2) {
        this.D = str;
        this.E = str2;
    }

    @Override // com.heytap.mcssdk.b
    public void a(List<Integer> list, int i3, int i16, int i17, int i18) {
        a(list, i3, i16, i17, i18, null);
    }

    @Override // com.heytap.mcssdk.b
    public void a(List<Integer> list, int i3, int i16, int i17, int i18, JSONObject jSONObject) {
        if (!x()) {
            if (q() != null) {
                q().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i3 < 0 || i16 < 0 || i17 < i3 || i17 > 23 || i18 < i16 || i18 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", com.heytap.mcssdk.c.a.a(list));
            jSONObject2.put("startHour", i3);
            jSONObject2.put("startMin", i16);
            jSONObject2.put("endHour", i17);
            jSONObject2.put("endMin", i18);
            a(12298, jSONObject2.toString(), jSONObject);
        } catch (JSONException e16) {
            com.heytap.mcssdk.f.c.e(com.heytap.mcssdk.f.c.f36186a, e16.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.b
    public void a(JSONObject jSONObject) {
        if (v()) {
            b(12289, jSONObject);
        } else if (q() != null) {
            q().onRegister(-2, null);
        }
    }
}
