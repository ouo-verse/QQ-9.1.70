package com.tencent.av.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class at {
    public static long a(Intent intent) {
        return intent.getLongExtra("log_seq", 0L);
    }

    public static long b(Bundle bundle) {
        if (bundle != null) {
            return bundle.getLong("log_seq");
        }
        return 0L;
    }

    public static long c(Object obj) {
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    public static long d(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.containsKey("log_seq")) {
            return c(hashMap.get("log_seq"));
        }
        return 0L;
    }

    public static long e(Object[] objArr, int i3) {
        if (objArr.length > i3) {
            return c(objArr[i3]);
        }
        return 0L;
    }

    public static void f(Intent intent, long j3) {
        intent.putExtra("log_seq", j3);
    }

    public static void g(Bundle bundle, long j3) {
        bundle.putLong("log_seq", j3);
    }

    public static void h(HashMap<String, Object> hashMap, long j3) {
        hashMap.put("log_seq", Long.valueOf(j3));
    }
}
