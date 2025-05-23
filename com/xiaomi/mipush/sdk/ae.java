package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.u;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ae {
    public static a a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static a b(Context context, d dVar) {
        u.b a16 = u.a(dVar);
        if (a16 != null && !TextUtils.isEmpty(a16.f388108a) && !TextUtils.isEmpty(a16.f388109b)) {
            return (a) com.xiaomi.push.y.g(a16.f388108a, a16.f388109b, context);
        }
        return null;
    }
}
