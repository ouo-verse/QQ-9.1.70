package com.huawei.hms.health;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabk {
    public static aabn aab(Activity activity, aabl aablVar) {
        Checker.assertNonNull(activity);
        return new aabj(activity, aablVar);
    }

    public static aabn aab(Context context, aabl aablVar) {
        Checker.assertNonNull(context);
        return new aabj(context, aablVar);
    }
}
