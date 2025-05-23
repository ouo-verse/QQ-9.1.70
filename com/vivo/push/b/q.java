package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class q extends v {

    /* renamed from: a, reason: collision with root package name */
    protected InsideNotificationItem f387598a;

    /* renamed from: b, reason: collision with root package name */
    private String f387599b;

    public q() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        String b16 = com.vivo.push.util.v.b(this.f387598a);
        this.f387599b = b16;
        dVar.a("notification_v1", b16);
    }

    public final InsideNotificationItem d() {
        return this.f387598a;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f387599b)) {
            InsideNotificationItem insideNotificationItem = this.f387598a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.v.b(insideNotificationItem);
        }
        return this.f387599b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String a16 = dVar.a("notification_v1");
        this.f387599b = a16;
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        InsideNotificationItem a17 = com.vivo.push.util.v.a(this.f387599b);
        this.f387598a = a17;
        if (a17 != null) {
            a17.setMsgId(f());
        }
    }
}
