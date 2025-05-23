package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bh implements Runnable {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Callable<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f388264d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f388265e;

        a(Context context, String str) {
            this.f388264d = context;
            this.f388265e = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            return String.valueOf(com.xiaomi.push.service.b.a(this.f388264d, this.f388265e));
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements Callable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f388267d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f388268e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ NotificationChannel f388269f;

        b(Context context, String str, NotificationChannel notificationChannel) {
            this.f388267d = context;
            this.f388268e = str;
            this.f388269f = notificationChannel;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            return String.valueOf(com.xiaomi.push.service.f.a(this.f388267d, this.f388268e, this.f388269f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f388271a = "dc_job_result_time_26";

        /* renamed from: b, reason: collision with root package name */
        public SharedPreferences f388272b;

        public c(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.f388272b = sharedPreferences;
            long j3 = sharedPreferences.getLong("dc_job_result_time_26", 0L);
            if (j3 <= 0 || j3 - System.currentTimeMillis() > 259200000) {
                this.f388272b.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        public void b() {
            long j3 = this.f388272b.getLong("dc_job_result_time_26", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (currentTimeMillis >= 0) {
                this.f388272b.edit().putLong("dc_job_result_time_26", j3 + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }

        public boolean c() {
            if (System.currentTimeMillis() - this.f388272b.getLong("dc_job_result_time_26", 0L) > 0) {
                return true;
            }
            return false;
        }
    }

    bh() {
    }

    public static void a(Context context) {
        if (context != null && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            c cVar = new c(context);
            if (cVar.c()) {
                new BaseThread(new bh()).start();
                cVar.b();
            }
        }
    }

    private void b(Context context, am amVar, aj ajVar) {
        gj gjVar = new gj();
        gjVar.d("category_app_channel_info");
        gjVar.c("app_channel_info");
        gjVar.b(amVar.toString());
        gjVar.a(false);
        gjVar.a(1L);
        gjVar.a("xmsf_channel");
        gjVar.b(System.currentTimeMillis());
        gjVar.g("com.xiaomi.xmsf");
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.af.b());
        com.xiaomi.push.service.ba.a(context, gjVar);
    }

    private void c(aj ajVar, ai aiVar, Exception exc) {
        HashMap hashMap = new HashMap();
        String d16 = com.xiaomi.push.service.av.d(ii.b());
        if (!TextUtils.isEmpty(d16)) {
            hashMap.put("uuid", d16);
        }
        hashMap.put("appCount", Long.valueOf(ajVar.b()));
        hashMap.put("channels", Long.valueOf(ajVar.e()));
        hashMap.put("packCount", Long.valueOf(ajVar.g()));
        hashMap.put("totalSize", Long.valueOf(ajVar.i()));
        hashMap.put("isBatch", Integer.valueOf(ajVar.a()));
        hashMap.put("maxCallTime", Long.valueOf(aiVar.a()));
        hashMap.put("minCallTime", Long.valueOf(aiVar.c()));
        hashMap.put("callAvg", Long.valueOf(aiVar.d()));
        hashMap.put("duration", Long.valueOf(aiVar.e()));
        if (exc != null) {
            hashMap.put("exception", exc.toString());
        }
        dv.b().a("app_switch_upload", hashMap);
    }

    @Override // java.lang.Runnable
    public void run() {
        aj ajVar;
        int size;
        String str;
        String str2;
        aj ajVar2;
        Iterator<Map.Entry<String, ?>> it;
        al alVar;
        am amVar;
        am amVar2;
        al alVar2;
        List<NotificationChannel> l3;
        String id5;
        String str3;
        al alVar3;
        String str4 = "mipush_";
        String str5 = "com.xiaomi.xmsf";
        Context b16 = ii.b();
        if (b16 != null) {
            aj ajVar3 = new aj();
            ai aiVar = new ai(50L, 1000L);
            try {
                Map<String, ?> all = ii.b().getSharedPreferences("pref_registered_pkg_names", 0).getAll();
                if (all != null && !all.isEmpty()) {
                    Set<String> keySet = all.keySet();
                    if (keySet.contains("com.xiaomi.xmsf")) {
                        size = keySet.size() - 1;
                    } else {
                        size = keySet.size();
                    }
                    ajVar3.d(size);
                    am amVar3 = new am();
                    amVar3.put("c", ajVar3.b());
                    Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                    al alVar4 = new al();
                    Iterator<Map.Entry<String, ?>> it5 = entrySet.iterator();
                    am amVar4 = amVar3;
                    al alVar5 = alVar4;
                    while (it5.hasNext()) {
                        Map.Entry<String, ?> next = it5.next();
                        String key = next.getKey();
                        String str6 = (String) next.getValue();
                        if (!TextUtils.isEmpty(key) && !str5.equals(key) && !TextUtils.isEmpty(str6)) {
                            am amVar5 = new am();
                            amVar5.put("a", str6);
                            amVar5.put(ReportConstant.COSTREPORT_PREFIX, (String) aiVar.b(new a(b16, key)));
                            if (Build.VERSION.SDK_INT >= 26 && (l3 = com.xiaomi.push.service.j.e(b16, key).l()) != null && !l3.isEmpty()) {
                                al alVar6 = new al();
                                str2 = str5;
                                it = it5;
                                amVar2 = amVar4;
                                ajVar3.f(l3.size());
                                Iterator<NotificationChannel> it6 = l3.iterator();
                                while (it6.hasNext()) {
                                    NotificationChannel next2 = it6.next();
                                    id5 = next2.getId();
                                    am amVar6 = new am();
                                    Iterator<NotificationChannel> it7 = it6;
                                    aj ajVar4 = ajVar3;
                                    if (id5.startsWith(str4)) {
                                        alVar3 = alVar5;
                                        try {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(str4);
                                            sb5.append(key);
                                            str3 = str4;
                                            sb5.append("_");
                                            String replace = id5.replace(sb5.toString(), "");
                                            amVar6.put("t", 1);
                                            amVar6.put("c", replace);
                                        } catch (Exception e16) {
                                            e = e16;
                                            ajVar = ajVar4;
                                        }
                                    } else {
                                        str3 = str4;
                                        alVar3 = alVar5;
                                        if (id5.startsWith("mipush|")) {
                                            String replace2 = id5.replace("mipush|" + key + "|", "");
                                            amVar6.put("t", 2);
                                            amVar6.put("c", replace2);
                                        }
                                    }
                                    amVar6.put(ReportConstant.COSTREPORT_PREFIX, (String) aiVar.b(new b(b16, key, next2)));
                                    alVar6.mo162put(amVar6);
                                    alVar5 = alVar3;
                                    it6 = it7;
                                    ajVar3 = ajVar4;
                                    str4 = str3;
                                }
                                str = str4;
                                ajVar2 = ajVar3;
                                amVar5.put("c", alVar6);
                                alVar2 = alVar5;
                            } else {
                                str = str4;
                                str2 = str5;
                                ajVar2 = ajVar3;
                                it = it5;
                                amVar2 = amVar4;
                                alVar2 = alVar5;
                            }
                            alVar2.mo162put(amVar5);
                            am amVar7 = amVar2;
                            amVar7.put("d", alVar2);
                            amVar = amVar7;
                            alVar = alVar2;
                        } else {
                            str = str4;
                            str2 = str5;
                            ajVar2 = ajVar3;
                            it = it5;
                            amVar = amVar4;
                            alVar = alVar5;
                        }
                        if (amVar.a() > 30720) {
                            ajVar2.c();
                            ajVar = ajVar2;
                            try {
                                ajVar.h(amVar.a());
                                b(b16, amVar, ajVar);
                                am amVar8 = new am();
                                amVar8.put("c", ajVar.b());
                                amVar = amVar8;
                                alVar = new al();
                            } catch (Exception e17) {
                                e = e17;
                            }
                        } else {
                            ajVar = ajVar2;
                        }
                        ajVar3 = ajVar;
                        str5 = str2;
                        it5 = it;
                        str4 = str;
                        amVar4 = amVar;
                        alVar5 = alVar;
                    }
                    ajVar = ajVar3;
                    if (alVar5.length() > 0) {
                        ajVar.c();
                        ajVar.h(amVar4.a());
                        b(b16, amVar4, ajVar);
                    }
                } else {
                    ajVar = ajVar3;
                }
                e = null;
            } catch (Exception e18) {
                e = e18;
                ajVar = ajVar3;
            }
            c(ajVar, aiVar, e);
        }
    }
}
