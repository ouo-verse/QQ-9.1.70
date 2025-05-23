package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class m extends c {
    public m(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.strategy.c
    public void c(Intent intent, Activity activity, Bundle bundle) {
        com.tencent.open.agent.util.d.e(this.f340578a, 0L);
        bundle.putString("encrytoken", lq3.b.a(activity, "openid_encrytoken").getString(bundle.getString("hopenid"), ""));
        super.c(intent, activity, bundle);
    }
}
