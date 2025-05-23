package com.tencent.aelight.camera.ae.util;

import android.util.LruCache;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f65762a = new LruCache<>(10);

    public static boolean a(View view) {
        Object tag = view.getTag(R.id.rnq);
        long currentTimeMillis = System.currentTimeMillis();
        view.setTag(R.id.rnq, Long.valueOf(currentTimeMillis));
        return (tag instanceof Long) && Math.abs(currentTimeMillis - ((Long) tag).longValue()) <= 500;
    }
}
