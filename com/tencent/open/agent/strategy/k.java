package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.SocialFriendChooser;

/* compiled from: P */
/* loaded from: classes22.dex */
class k extends m {
    public k(String str) {
        super(str);
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        c(new Intent(activity, (Class<?>) SocialFriendChooser.class), activity, bundle);
    }
}
