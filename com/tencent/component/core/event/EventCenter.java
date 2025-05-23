package com.tencent.component.core.event;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.component.core.event.impl.EventImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EventCenter {
    private static volatile boolean isInited = false;

    public static void init() {
        synchronized (EventCenter.class) {
            if (isInited) {
                return;
            }
            EventImpl.getInstance().setRecvHandler(new Handler(Looper.getMainLooper()));
            Log.i("event_log", "event create ok");
            isInited = true;
        }
    }

    public static void post(Object obj) {
        tryInitEventCenter();
        EventImpl.getInstance().post(obj);
    }

    private static void tryInitEventCenter() {
        if (!isInited) {
            init();
        }
    }

    public static void post(Object obj, Handler handler) {
        tryInitEventCenter();
        EventImpl.getInstance().post(obj, handler);
    }
}
