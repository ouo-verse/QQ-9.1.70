package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class o extends v {

    /* renamed from: a, reason: collision with root package name */
    protected UnvarnishedMessage f387587a;

    public o() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("msg_v1", this.f387587a.unpackToJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String a16 = dVar.a("msg_v1");
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(a16);
        this.f387587a = unvarnishedMessage;
        unvarnishedMessage.setMsgId(f());
    }

    public final UnvarnishedMessage e() {
        return this.f387587a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnMessageCommand";
    }

    public final String d() {
        UnvarnishedMessage unvarnishedMessage = this.f387587a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }
}
