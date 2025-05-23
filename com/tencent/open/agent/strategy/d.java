package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.BragActivity;

/* compiled from: P */
/* loaded from: classes22.dex */
class d extends m {
    public d(String str) {
        super(str);
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        c(new Intent(activity, (Class<?>) BragActivity.class), activity, bundle);
    }
}
