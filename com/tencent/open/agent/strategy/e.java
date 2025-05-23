package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.ChallengeActivity;

/* compiled from: P */
/* loaded from: classes22.dex */
class e extends m {
    public e(String str) {
        super(str);
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        c(new Intent(activity, (Class<?>) ChallengeActivity.class), activity, bundle);
    }
}
