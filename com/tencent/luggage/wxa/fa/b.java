package com.tencent.luggage.wxa.fa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static void a(Object obj, Intent intent) {
        if (!(obj instanceof Activity) && (obj instanceof Context)) {
            a.a().b(obj, intent);
        }
    }
}
