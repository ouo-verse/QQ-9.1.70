package com.tribe.async.dispatch;

import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes27.dex */
public class HandlerPosterManager {
    private static final int MAX_DISPATCH_RUN_TIME = 200;
    private final Map<Looper, HandlerPoster> mHandlerPosterMap;

    /* loaded from: classes27.dex */
    private static class InstanceHolder {
        public static HandlerPosterManager sInstance = new HandlerPosterManager();

        InstanceHolder() {
        }
    }

    public static HandlerPosterManager instance() {
        return InstanceHolder.sInstance;
    }

    public HandlerPoster getHandlerPoster(Looper looper) {
        HandlerPoster handlerPoster = this.mHandlerPosterMap.get(looper);
        if (handlerPoster == null) {
            HandlerPoster handlerPoster2 = new HandlerPoster(looper, 200);
            this.mHandlerPosterMap.put(looper, handlerPoster2);
            return handlerPoster2;
        }
        return handlerPoster;
    }

    HandlerPosterManager() {
        this.mHandlerPosterMap = new ConcurrentHashMap(2);
    }
}
