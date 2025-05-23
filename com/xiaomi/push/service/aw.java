package com.xiaomi.push.service;

import com.xiaomi.push.eb;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aw extends XMPushService.j {

    /* renamed from: e, reason: collision with root package name */
    private XMPushService f389673e;

    /* renamed from: f, reason: collision with root package name */
    private eb f389674f;

    public aw(XMPushService xMPushService, eb ebVar) {
        super(4);
        this.f389673e = xMPushService;
        this.f389674f = ebVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            eb ebVar = this.f389674f;
            if (ebVar != null) {
                if (ak.a(ebVar)) {
                    this.f389674f.A(System.currentTimeMillis() - this.f389674f.b());
                }
                this.f389673e.a(this.f389674f);
            }
        } catch (fi e16) {
            jz4.c.q(e16);
            this.f389673e.a(10, e16);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String e() {
        return "send a message.";
    }
}
