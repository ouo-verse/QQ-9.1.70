package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.ij;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bd implements XMPushService.z {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f389700a = Log.isLoggable("UNDatas", 3);

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Map<String, List<String>>> f389701b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Context f389702c;

    public bd(Context context) {
        f389702c = context;
    }

    private static he c(String str, String str2, String str3, String str4) {
        he heVar = new he();
        if (str3 != null) {
            heVar.c(str3);
        }
        if (str != null) {
            heVar.b(str);
        }
        if (str2 != null) {
            heVar.a(str2);
        }
        if (str4 != null) {
            heVar.d(str4);
        }
        heVar.a(false);
        return heVar;
    }

    private static void d(Context context, final he heVar) {
        if (f389700a) {
            jz4.c.w("UNDatas upload message notification:" + heVar);
        }
        com.xiaomi.push.ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] e16 = fv.e(w.d(he.this.d(), he.this.b(), he.this, gf.Notification));
                if (bd.f389702c instanceof XMPushService) {
                    ((XMPushService) bd.f389702c).a(he.this.d(), e16, true);
                } else {
                    jz4.c.m("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static void e() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f389701b);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb5.append(str);
                        sb5.append(":");
                        List list = (List) map.get(str);
                        if (!ij.d(list)) {
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                if (i3 != 0) {
                                    sb5.append(",");
                                }
                                sb5.append((String) list.get(i3));
                            }
                        }
                        sb5.append(";");
                    }
                    he c16 = c(null, m.a(), gp.NotificationRemoved.f24750a, null);
                    c16.a("removed_reason", String.valueOf(num));
                    c16.a("all_delete_msgId_appId", sb5.toString());
                    jz4.c.w("UNDatas upload all removed messages reason: " + num + " allIds: " + sb5.toString());
                    d(f389702c, c16);
                }
                f389701b.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.z
    public void a() {
        Map<Integer, Map<String, List<String>>> map = f389701b;
        if (map.size() > 0) {
            synchronized (map) {
                e();
            }
        }
    }
}
