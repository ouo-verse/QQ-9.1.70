package com.tencent.gdtad.util;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f109566a = -1;

    public static int a(Context context) {
        if (f109566a == -1) {
            synchronized (o.class) {
                if (f109566a == -1) {
                    try {
                        f109566a = context.getResources().getInteger(R.integer.f167200bs);
                    } catch (Throwable th5) {
                        f109566a = 1;
                        QLog.e("GdtScreenWidthBucketUtils", 1, "getScreenWidthBucket", th5);
                    }
                }
            }
        }
        return f109566a;
    }
}
