package com.xiaomi.push.service;

import com.xiaomi.push.eb;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends XMPushService.j {

    /* renamed from: e, reason: collision with root package name */
    private XMPushService f389706e;

    /* renamed from: f, reason: collision with root package name */
    private eb[] f389707f;

    public c(XMPushService xMPushService, eb[] ebVarArr) {
        super(4);
        this.f389706e = xMPushService;
        this.f389707f = ebVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            eb[] ebVarArr = this.f389707f;
            if (ebVarArr != null) {
                this.f389706e.a(ebVarArr);
            }
        } catch (fi e16) {
            jz4.c.q(e16);
            this.f389706e.a(10, e16);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String e() {
        return "batch send message.";
    }
}
