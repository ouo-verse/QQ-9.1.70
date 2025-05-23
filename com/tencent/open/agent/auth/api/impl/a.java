package com.tencent.open.agent.auth.api.impl;

import android.app.Activity;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static boolean a(Activity activity, int i3, int i16, Intent intent) {
        if (activity == null || i3 != 103 || intent == null) {
            return false;
        }
        activity.setResult(i16, intent);
        activity.finish();
        return true;
    }
}
