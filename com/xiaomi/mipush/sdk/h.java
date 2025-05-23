package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static long f388062a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f388063b = false;

    private static void a(Context context) {
        a b16 = e.c(context).b(d.ASSEMBLE_PUSH_FTOS);
        if (b16 != null) {
            jz4.c.m("ASSEMBLE_PUSH :  register fun touch os when network change!");
            b16.register();
        }
    }

    public static void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (c()) {
            long j3 = f388062a;
            if (j3 <= 0 || j3 + MiniBoxNoticeInfo.MIN_5 <= elapsedRealtime) {
                f388062a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean c() {
        return f388063b;
    }
}
