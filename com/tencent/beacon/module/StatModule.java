package com.tencent.beacon.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.d.b;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class StatModule implements BeaconModule, d {

    /* renamed from: a, reason: collision with root package name */
    private Context f78069a;

    /* renamed from: d, reason: collision with root package name */
    private b f78072d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f78070b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f78071c = true;

    /* renamed from: e, reason: collision with root package name */
    private long f78073e = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.module.StatModule$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f78083a;

        @Override // java.lang.Runnable
        public void run() {
            BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_sensor").withParams(this.f78083a).build());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.module.StatModule$5, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f78084a;

        @Override // java.lang.Runnable
        public void run() {
            BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_appresumed").withIsSucceed(true).withParams(this.f78084a).withType(EventType.REALTIME).build());
        }
    }

    private void c() {
        ((Application) this.f78069a).registerActivityLifecycleCallbacks(new com.tencent.beacon.c.a.d(this));
    }

    private void d() {
        if (!this.f78072d.j()) {
            return;
        }
        a a16 = a.a();
        if (com.tencent.beacon.base.util.b.d().equals(a16.getString("rqd_model", ""))) {
            return;
        }
        com.tencent.beacon.a.b.a.a().a(50000L, new Runnable() { // from class: com.tencent.beacon.module.StatModule.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                e l3 = e.l();
                f e16 = f.e();
                BeaconEvent.Builder withParams = BeaconEvent.builder().withParams("A9", Build.BRAND).withParams("A10", e16.h()).withParams("A11", l3.g()).withParams("A12", l3.n()).withParams("A13", l3.A()).withParams("A14", l3.x() + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO).withParams("A15", l3.u() + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO).withParams("A16", l3.h()).withParams("A17", l3.v()).withParams("A18", "").withParams("A20", e16.j()).withParams("A30", l3.y() + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO).withParams("A19", l3.q()).withParams("A52", "" + l3.z()).withParams("A53", "" + l3.e() + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(l3.s());
                BeaconEvent.Builder withParams2 = withParams.withParams("A54", sb5.toString()).withParams("A55", l3.f());
                String str2 = "Y";
                if (l3.E()) {
                    str = "Y";
                } else {
                    str = "N";
                }
                BeaconEvent.Builder withParams3 = withParams2.withParams("A56", str).withParams("A57", l3.B());
                if (!l3.m()) {
                    str2 = "N";
                }
                BeaconReport.getInstance().report(withParams3.withParams("A58", str2).withParams("A59", l3.k() + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO).withParams("A69", e16.k()).withParams("A82", l3.w()).withType(EventType.REALTIME).withCode("rqd_model").build());
            }
        });
        a.SharedPreferencesEditorC0784a edit = a16.edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putString("rqd_model", com.tencent.beacon.base.util.b.d());
        }
    }

    private void e() {
        String str;
        String str2;
        String str3;
        if (!this.f78072d.j()) {
            return;
        }
        if (this.f78072d.h()) {
            if (com.tencent.beacon.base.util.b.d().equals(a.a().getString("LAUEVE_DENGTA", ""))) {
                c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new Object[0]);
                return;
            }
        }
        e l3 = e.l();
        HashMap hashMap = new HashMap();
        hashMap.put("A19", l3.q());
        String str4 = "Y";
        hashMap.put(Constants.HAS_HOOK_FRAME, "Y");
        if (com.tencent.beacon.a.c.b.g()) {
            str = "Y";
        } else {
            str = "N";
        }
        hashMap.put("A21", str);
        if (com.tencent.beacon.a.c.b.e(this.f78069a)) {
            str2 = "Y";
        } else {
            str2 = "N";
        }
        hashMap.put("A45", str2);
        if (com.tencent.beacon.a.c.b.f(this.f78069a)) {
            str3 = UserInfo.SEX_FEMALE;
        } else {
            str3 = "B";
        }
        hashMap.put("A66", str3);
        hashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.f78069a));
        if (!com.tencent.beacon.a.c.b.f77633d) {
            str4 = "N";
        }
        hashMap.put("A85", str4);
        hashMap.put("A9", Build.BRAND);
        hashMap.put("A14", l3.x());
        f e16 = f.e();
        hashMap.put("A20", e16.j());
        hashMap.put("A69", e16.k());
        if (a(hashMap)) {
            a.SharedPreferencesEditorC0784a edit = a.a().edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("LAUEVE_DENGTA", com.tencent.beacon.base.util.b.d());
            }
        }
    }

    public void a() {
    }

    public void b() {
    }

    static /* synthetic */ long b(StatModule statModule, long j3) {
        long j16 = statModule.f78073e + j3;
        statModule.f78073e = j16;
        return j16;
    }

    public void b(final String str, final long j3, final long j16) {
        if (this.f78072d.j()) {
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.StatModule.3
                @Override // java.lang.Runnable
                public void run() {
                    BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(j16)).withParams("A111", str).withParams("A112", String.valueOf(j3)).withCode("rqd_page").withType(EventType.NORMAL).build());
                    StatModule.b(StatModule.this, j3);
                    if (StatModule.this.f78073e >= 15000) {
                        StatModule.this.f78073e = 0L;
                    }
                }
            });
        }
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        this.f78069a = context;
        if (!com.tencent.beacon.a.c.b.g(context)) {
            c.a("non-main process. do not report rqd event", new Object[0]);
            return;
        }
        b b16 = ((StrategyModule) BeaconModule.f78053a.get(ModuleName.STRATEGY)).b();
        this.f78072d = b16;
        this.f78071c = b16.k();
        ((Application) this.f78069a).registerActivityLifecycleCallbacks(new com.tencent.beacon.c.a.c(this));
        com.tencent.beacon.a.a.b.a().a(2, this);
        com.tencent.beacon.a.a.b.a().a(10, this);
    }

    public boolean b(Map<String, String> map) {
        if (!this.f78072d.j()) {
            return true;
        }
        return BeaconReport.getInstance().report(BeaconEvent.builder().withParams(map).withCode("rqd_heartbeat").withType(EventType.REALTIME).build()).isSuccess();
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        int i3 = cVar.f77584a;
        if (i3 == 2) {
            Map map = (Map) cVar.f77585b.get("d_m");
            if (map != null) {
                this.f78070b = com.tencent.beacon.base.util.b.a((String) map.get("modelEventUsable"), this.f78070b);
                this.f78071c = com.tencent.beacon.base.util.b.a((String) map.get("isPagePath"), this.f78071c);
                return;
            }
            return;
        }
        if (i3 != 10) {
            return;
        }
        e();
        if (com.tencent.beacon.a.c.b.g(this.f78069a)) {
            new com.tencent.beacon.c.c(this.f78069a).a(this.f78072d);
        }
        if (this.f78070b) {
            d();
        }
        if (this.f78071c) {
            c();
        }
    }

    public boolean a(Map<String, String> map) {
        if (!this.f78072d.j()) {
            return true;
        }
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_applaunched").withParams(map).withType(EventType.REALTIME).build()).isSuccess();
    }

    public void a(final String str, final long j3, final long j16) {
        if (this.f78072d.j()) {
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.StatModule.2
                @Override // java.lang.Runnable
                public void run() {
                    BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(j16)).withParams("A111", str).withParams("A112", String.valueOf(j3)).withCode("rqd_page_fgt").withType(EventType.REALTIME).build());
                }
            });
        }
    }
}
