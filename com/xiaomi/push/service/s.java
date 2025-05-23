package com.xiaomi.push.service;

import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public class s extends XMPushService.j {

    /* renamed from: e, reason: collision with root package name */
    private XMPushService f389804e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f389805f;

    /* renamed from: h, reason: collision with root package name */
    private String f389806h;

    /* renamed from: i, reason: collision with root package name */
    private String f389807i;

    /* renamed from: m, reason: collision with root package name */
    private String f389808m;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f389804e = xMPushService;
        this.f389806h = str;
        this.f389805f = bArr;
        this.f389807i = str2;
        this.f389808m = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        am.b next;
        au b16 = av.b(this.f389804e);
        if (b16 == null) {
            try {
                b16 = av.c(this.f389804e, this.f389806h, this.f389807i, this.f389808m);
            } catch (Exception e16) {
                jz4.c.B("fail to register push account. " + e16);
            }
        }
        if (b16 == null) {
            jz4.c.B("no account for registration.");
            az.a(this.f389804e, 70000002, "no account.");
            return;
        }
        jz4.c.m("do registration now.");
        Collection<am.b> f16 = am.c().f("5");
        if (f16.isEmpty()) {
            next = b16.a(this.f389804e);
            w.j(this.f389804e, next);
            am.c().l(next);
        } else {
            next = f16.iterator().next();
        }
        if (this.f389804e.m462c()) {
            try {
                am.c cVar = next.f389617m;
                if (cVar == am.c.binded) {
                    w.l(this.f389804e, this.f389806h, this.f389805f);
                } else if (cVar == am.c.unbind) {
                    az.e(this.f389806h, this.f389805f);
                    XMPushService xMPushService = this.f389804e;
                    xMPushService.getClass();
                    xMPushService.a(new XMPushService.b(next));
                }
                return;
            } catch (fi e17) {
                jz4.c.B("meet error, disconnect connection. " + e17);
                this.f389804e.a(10, e17);
                return;
            }
        }
        az.e(this.f389806h, this.f389805f);
        this.f389804e.a(true);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String e() {
        return "register app";
    }
}
