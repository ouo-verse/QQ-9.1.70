package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ft;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class o implements ft {

    /* renamed from: a, reason: collision with root package name */
    private final XMPushService f389768a;

    public o(XMPushService xMPushService) {
        this.f389768a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if ("com.xiaomi.xmsf".equals(str)) {
            return "1000271";
        }
        return this.f389768a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.ft
    public void a(final List<gj> list, final String str, final String str2) {
        this.f389768a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                String d16 = o.this.d(str);
                ArrayList<he> c16 = af.c(list, str, d16, 32768);
                if (c16 != null) {
                    Iterator<he> it = c16.iterator();
                    while (it.hasNext()) {
                        he next = it.next();
                        next.a("uploadWay", "longXMPushService");
                        hb d17 = w.d(str, d16, next, gf.Notification);
                        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                            if (d17.m375a() == null) {
                                gs gsVar = new gs();
                                gsVar.a("-1");
                                d17.a(gsVar);
                            }
                            d17.m375a().b("ext_traffic_source_pkg", str2);
                        }
                        o.this.f389768a.a(str, fv.e(d17), true);
                    }
                    return;
                }
                jz4.c.B("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "Send tiny data.";
            }
        });
    }
}
