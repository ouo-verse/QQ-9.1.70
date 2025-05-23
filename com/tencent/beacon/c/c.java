package com.tencent.beacon.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f77810a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f77811b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f77812c = false;

    public c(Context context) {
        this.f77810a = context;
        this.f77811b = com.tencent.beacon.a.c.b.f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return ((StatModule) com.tencent.beacon.a.c.c.c().a(ModuleName.STAT)).b(b());
    }

    private Map<String, String> b() {
        this.f77812c = com.tencent.beacon.a.c.b.f77633d;
        HashMap hashMap = new HashMap(8);
        e l3 = e.l();
        f e16 = f.e();
        hashMap.put("A19", l3.q());
        hashMap.put("A66", com.tencent.beacon.a.c.b.f(this.f77810a) ? UserInfo.SEX_FEMALE : "B");
        hashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.f77810a));
        hashMap.put("A85", this.f77812c ? "Y" : "N");
        hashMap.put("A20", e16.j());
        hashMap.put("A69", e16.k());
        return hashMap;
    }

    public void a(com.tencent.beacon.d.b bVar) {
        String d16 = com.tencent.beacon.base.util.b.d();
        com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
        String string = a16.getString("HEART_DENGTA", "");
        String string2 = a16.getString("active_user_date", "");
        if (!d16.equals(string) && !string2.equals(d16)) {
            if (bVar.a("rqd_heartbeat")) {
                com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
                return;
            } else if (!bVar.b("rqd_heartbeat")) {
                com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
                return;
            } else {
                com.tencent.beacon.a.b.a.a().a(new b(this, d16, a16));
                return;
            }
        }
        com.tencent.beacon.base.util.c.e("[event] heartbeat had upload!", new Object[0]);
    }

    public void a() {
        com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
        if (!com.tencent.beacon.base.util.b.d().equals(a16.getString("active_user_date", ""))) {
            com.tencent.beacon.base.util.c.a("[event] recover a heart beat for active user.", new Object[0]);
            if (c()) {
                com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success", new Object[0]);
                a.SharedPreferencesEditorC0784a edit = a16.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("active_user_date", com.tencent.beacon.base.util.b.d()).apply();
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.beacon.base.util.c.e("[event] active user event had upload.", new Object[0]);
    }
}
