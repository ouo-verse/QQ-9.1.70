package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes15.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private String f387791a;

    /* renamed from: b, reason: collision with root package name */
    private String f387792b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.f387791a = aVar.a();
        }
        this.f387792b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.f387791a) && !TextUtils.isEmpty(this.f387792b)) {
            return new com.vivo.push.b.h(this.f387791a, this.f387792b);
        }
        u.a("convertOffLineMsg() error, mMessageID = " + this.f387791a + ", mNodeArrayInfo = " + this.f387792b);
        return null;
    }
}
