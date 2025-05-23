package com.tencent.beacon.event;

import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class f implements Callback<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Set<Long> f77949a;

    /* renamed from: b, reason: collision with root package name */
    private final String f77950b;

    /* renamed from: c, reason: collision with root package name */
    private final String f77951c;

    /* renamed from: d, reason: collision with root package name */
    private long f77952d = new Date().getTime();

    /* renamed from: e, reason: collision with root package name */
    private g f77953e;

    /* renamed from: f, reason: collision with root package name */
    private String f77954f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.beacon.event.a.a f77955g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, String str, com.tencent.beacon.event.a.a aVar, Set<Long> set, String str2) {
        this.f77953e = gVar;
        this.f77954f = str;
        this.f77955g = aVar;
        this.f77949a = new HashSet(set);
        this.f77950b = "[EventReport(" + str + ")]";
        this.f77951c = str2;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        com.tencent.beacon.base.util.c.a(this.f77950b, 3, "send failure reason: %s. LogID: %s.", dVar.toString(), this.f77951c);
        this.f77953e.a(this.f77949a);
        if (dVar.f77778b.equals(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE)) {
            this.f77953e.a();
            com.tencent.beacon.a.b.a.a().a(this.f77953e);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(byte[] bArr) {
        com.tencent.beacon.base.util.c.a(this.f77950b, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", Boolean.valueOf(((EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT)).d().a(new e(this, new Date().getTime() - this.f77952d))));
        if (this.f77949a.size() >= this.f77953e.b()) {
            com.tencent.beacon.a.b.a.a().a(this.f77953e);
        }
        this.f77953e.c();
    }
}
