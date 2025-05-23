package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f388044a = false;

    /* renamed from: b, reason: collision with root package name */
    private static long f388045b;

    public static void a(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (b()) {
            long j3 = f388045b;
            if (j3 <= 0 || j3 + MiniBoxNoticeInfo.MIN_5 <= elapsedRealtime) {
                f388045b = elapsedRealtime;
                c(context);
            }
        }
    }

    public static boolean b() {
        return f388044a;
    }

    public static void c(Context context) {
        a b16 = e.c(context).b(d.ASSEMBLE_PUSH_COS);
        if (b16 != null) {
            jz4.c.m("ASSEMBLE_PUSH :  register cos when network change!");
            b16.register();
        }
    }
}
