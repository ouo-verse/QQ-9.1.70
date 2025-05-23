package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Dispatchers {
    private static final ConcurrentHashMap<Long, Dispatcher> sDispatcherMap = new ConcurrentHashMap<>();

    @NonNull
    public static Dispatcher get(@NonNull Looper looper) {
        AssertUtils.checkNotNull(looper);
        ConcurrentHashMap<Long, Dispatcher> concurrentHashMap = sDispatcherMap;
        Dispatcher dispatcher = concurrentHashMap.get(Long.valueOf(looper.getThread().getId()));
        if (dispatcher == null) {
            DefaultDispatcher defaultDispatcher = new DefaultDispatcher(looper);
            Dispatcher putIfAbsent = concurrentHashMap.putIfAbsent(Long.valueOf(looper.getThread().getId()), defaultDispatcher);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return defaultDispatcher;
        }
        return dispatcher;
    }
}
