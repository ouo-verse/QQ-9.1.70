package com.tencent.halley.common.a;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i {
    public static Handler a(String str) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(b(str), 10);
        baseHandlerThread.start();
        return new Handler(baseHandlerThread.getLooper());
    }

    public static String b(String str) {
        return "halley_" + com.tencent.halley.common.a.c() + "_" + str;
    }
}
