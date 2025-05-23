package com.tencent.beacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.module.StrategyModule;
import com.tencent.beacon.pack.CommonStrategy;
import com.tencent.beacon.pack.ModuleStrategy;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i implements Runnable, Callback<byte[]> {

    /* renamed from: b, reason: collision with root package name */
    private final StrategyModule f77867b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f77869d;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f77868c = false;

    /* renamed from: a, reason: collision with root package name */
    private final Context f77866a = com.tencent.beacon.a.c.c.c().b();

    public i(StrategyModule strategyModule) {
        this.f77867b = strategyModule;
    }

    private void c() {
        f();
        this.f77868c = false;
    }

    private void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("s_e_e", Boolean.FALSE);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(7, hashMap));
    }

    private void e() {
        com.tencent.beacon.base.util.c.a("local strategyQuery finish!", new Object[0]);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(10));
    }

    private void f() {
        long b16 = this.f77867b.a().b() * 60000;
        com.tencent.beacon.a.b.a.a().a(b16, this);
        com.tencent.beacon.base.util.c.a("[strategy] next time: %d", Long.valueOf(b16));
    }

    private void g() {
        String str;
        String str2;
        if (!k.b() && !k.c()) {
            com.tencent.beacon.a.c.e l3 = com.tencent.beacon.a.c.e.l();
            com.tencent.beacon.a.c.f e16 = com.tencent.beacon.a.c.f.e();
            JceRequestEntity.a b16 = JceRequestEntity.builder().a(RequestType.STRATEGY).a(100).b(101).a(com.tencent.beacon.a.c.c.c().e()).b(com.tencent.beacon.base.net.b.b.b(false)).a(com.tencent.beacon.base.net.b.b.b(true), 8081).b("A1", com.tencent.beacon.a.c.c.c().k()).b(NowProxyConstants.AccountInfoKey.A2, e16.b()).b("A4", e16.d()).b("A6", e16.f()).b("A7", l3.d()).b("A23", com.tencent.beacon.a.c.c.c().a(com.tencent.beacon.a.c.c.c().e())).b("A31", l3.p()).b("A19", l3.q());
            if (com.tencent.beacon.a.c.b.f(this.f77866a)) {
                str = UserInfo.SEX_FEMALE;
            } else {
                str = "B";
            }
            JceRequestEntity.a b17 = b16.b("A66", str).b("A67", com.tencent.beacon.a.c.b.c(this.f77866a)).b("A68", String.valueOf(com.tencent.beacon.a.c.b.b(this.f77866a)));
            if (com.tencent.beacon.a.c.b.f77633d) {
                str2 = "Y";
            } else {
                str2 = "N";
            }
            com.tencent.beacon.base.net.c.c().b(b17.b("A85", str2).a(com.tencent.beacon.a.c.j.d()).a()).b(this);
            return;
        }
        com.tencent.beacon.base.util.c.e("[strategy] query times or query success times arrive max, return!", new Object[0]);
        this.f77867b.a(true);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(byte[] bArr) {
        a(bArr, true);
        this.f77867b.a(true);
        c();
    }

    public void b() {
        byte[] bArr;
        try {
            try {
                String string = com.tencent.beacon.a.d.a.a().getString("strategy_data", "");
                if (!TextUtils.isEmpty(string)) {
                    bArr = Base64.decode(string, 0);
                } else {
                    j a16 = k.a(this.f77866a, 101);
                    bArr = a16 != null ? a16.f77872c : null;
                }
                if (bArr != null) {
                    a(bArr, false);
                } else {
                    com.tencent.beacon.base.util.c.a("[strategy] local strategy is null!", new Object[0]);
                }
            } catch (Exception e16) {
                com.tencent.beacon.base.util.c.a(e16);
            }
        } finally {
            e();
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        c();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f77868c = true;
        if (!this.f77867b.a().e()) {
            g();
        }
    }

    private void c(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.sampleEvent;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , SampleEventSet changed...", Byte.valueOf(moduleStrategy.mId));
        this.f77869d = true;
        eVar.b(com.tencent.beacon.base.util.b.a(moduleStrategy.sampleEvent));
        bVar.b(com.tencent.beacon.base.util.b.a(moduleStrategy.sampleEvent));
    }

    public void a(byte[] bArr, boolean z16) {
        try {
            CommonStrategy commonStrategy = new CommonStrategy();
            commonStrategy.readFrom(new com.tencent.beacon.pack.a(bArr));
            com.tencent.beacon.base.util.c.a("[strategy] -> common strategy: %s", commonStrategy);
            if (a(commonStrategy, a.a()) && z16) {
                a.SharedPreferencesEditorC0784a edit = com.tencent.beacon.a.d.a.a().edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("strategy_data", Base64.encodeToString(bArr, 0));
                }
            }
            if (z16) {
                k.d();
            }
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            com.tencent.beacon.base.util.c.b("[strategy] error to common strategy!", new Object[0]);
        }
    }

    private void b(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.preventEventCode;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , PreventEventCode changed...", Byte.valueOf(moduleStrategy.mId));
        this.f77869d = true;
        eVar.a(com.tencent.beacon.base.util.b.a(moduleStrategy.preventEventCode));
        bVar.a(com.tencent.beacon.base.util.b.a(moduleStrategy.preventEventCode));
    }

    protected boolean a(CommonStrategy commonStrategy, a aVar) {
        if (commonStrategy == null || aVar == null) {
            return false;
        }
        String a16 = com.tencent.beacon.base.net.b.b.a(commonStrategy.url);
        if (!a16.equals(com.tencent.beacon.base.net.b.b.b(true))) {
            com.tencent.beacon.base.util.c.a("[strategy] url changed to: %s", commonStrategy.url);
            this.f77869d = true;
            com.tencent.beacon.base.net.b.b.d(a16);
        }
        if (commonStrategy.queryInterval != aVar.b()) {
            com.tencent.beacon.base.util.c.a("[strategy] QueryPeriod changed to: %d", Integer.valueOf(commonStrategy.queryInterval));
            this.f77869d = true;
            aVar.a(commonStrategy.queryInterval);
        }
        if (a(commonStrategy.moduleList)) {
            this.f77869d = true;
        }
        if (a(commonStrategy.cloudParas, aVar)) {
            this.f77869d = true;
        }
        return this.f77869d;
    }

    boolean a(ArrayList<ModuleStrategy> arrayList) {
        e d16 = this.f77867b.a().d();
        if (arrayList == null) {
            d16.a(false);
            d();
            return false;
        }
        b b16 = this.f77867b.b();
        Iterator<ModuleStrategy> it = arrayList.iterator();
        while (it.hasNext()) {
            ModuleStrategy next = it.next();
            if (next.mId == d16.b()) {
                a(d16, next);
                a(next);
                a(d16, b16, next);
                b(d16, b16, next);
                c(d16, b16, next);
            }
        }
        return this.f77869d;
    }

    private void a(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        if (moduleStrategy.detail != null) {
            com.tencent.beacon.base.util.c.a("[strategy] mid: %d , detail changed...", Byte.valueOf(moduleStrategy.mId));
            eVar.a(moduleStrategy.detail);
            bVar.a(moduleStrategy.detail);
            this.f77869d = true;
        }
    }

    private void a(e eVar, ModuleStrategy moduleStrategy) {
        boolean z16 = moduleStrategy.onOff == 1;
        if (eVar.c() != z16) {
            com.tencent.beacon.base.util.c.a("[strategy] mid: %d , isUsable changed: %b ", Byte.valueOf(moduleStrategy.mId), Boolean.valueOf(z16));
            eVar.a(z16);
            this.f77869d = true;
        }
    }

    private void a(ModuleStrategy moduleStrategy) {
        String a16 = com.tencent.beacon.base.net.b.b.a(moduleStrategy.url);
        if (com.tencent.beacon.base.net.b.b.a(true).equals(a16)) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , url changed: %s", Byte.valueOf(moduleStrategy.mId), moduleStrategy.url);
        com.tencent.beacon.base.net.b.b.b(a16);
        this.f77869d = true;
    }

    private boolean a(Map<String, String> map, a aVar) {
        if (aVar == null || map == null) {
            return false;
        }
        aVar.a(map);
        return true;
    }

    public boolean a() {
        return this.f77868c;
    }
}
