package com.tencent.biz.richframework.video.rfw.player.exp;

import android.os.Handler;

/* loaded from: classes5.dex */
public class RFWPostAtFrontUtils {
    public static void post(Handler handler, Runnable runnable) {
        if (handler != null && runnable != null) {
            handler.postAtFrontOfQueue(runnable);
        }
    }
}
