package com.tencent.gamecenter.wadl.sdk.common.b;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {
    public static Handler a(String str, int i3) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(a(str), i3);
        baseHandlerThread.start();
        return new Handler(baseHandlerThread.getLooper());
    }

    public static String a(String str) {
        return "halley_" + com.tencent.gamecenter.wadl.sdk.common.a.c() + "_" + str;
    }
}
