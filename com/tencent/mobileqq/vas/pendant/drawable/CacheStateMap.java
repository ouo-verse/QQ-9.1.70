package com.tencent.mobileqq.vas.pendant.drawable;

import android.text.TextUtils;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CacheStateMap {
    private static final String TAG = "CacheStateMap";
    private static final boolean isClearLostInThread = ar.b("shouyouye", "2024-04-11", "vas_bug_116510035").isEnable(true);
    private static final ConcurrentHashMap<Long, CacheStateRef> sMap = new ConcurrentHashMap<>();
    private static final Runnable clearLostRefTask = new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.a
        @Override // java.lang.Runnable
        public final void run() {
            CacheStateMap.clearLostRef();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class CacheStateRef {
        public final WeakReference<CacheDrawable.CacheState> cacheState;
        public final String path;

        public CacheStateRef(String str, CacheDrawable.CacheState cacheState) {
            this.path = str;
            this.cacheState = new WeakReference<>(cacheState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearLostRef() {
        ArrayList arrayList = new ArrayList();
        for (Long l3 : sMap.keySet()) {
            CacheStateRef cacheStateRef = sMap.get(l3);
            if (cacheStateRef != null && cacheStateRef.cacheState.get() == null) {
                arrayList.add(l3);
            }
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sMap.remove((Long) it.next());
            }
        } catch (Exception unused) {
            QLog.w(TAG, 1, "");
        }
    }

    private static void clearLostRefByToggle() {
        if (isClearLostInThread) {
            clearLostRef();
            return;
        }
        Runnable runnable = clearLostRefTask;
        ThreadManagerV2.removeJob(runnable, 16);
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    public static synchronized CacheDrawable.CacheState getCacheState(long j3, String str) {
        CacheDrawable.CacheState cacheState;
        synchronized (CacheStateMap.class) {
            CacheStateRef cacheStateRef = sMap.get(Long.valueOf(j3));
            if (cacheStateRef != null && TextUtils.equals(cacheStateRef.path, str)) {
                cacheState = cacheStateRef.cacheState.get();
            } else {
                cacheState = null;
            }
        }
        return cacheState;
    }

    public static synchronized void putCacheState(long j3, String str, CacheDrawable.CacheState cacheState) {
        synchronized (CacheStateMap.class) {
            ConcurrentHashMap<Long, CacheStateRef> concurrentHashMap = sMap;
            CacheStateRef cacheStateRef = concurrentHashMap.get(Long.valueOf(j3));
            if (cacheStateRef == null || cacheStateRef.cacheState == null || !TextUtils.equals(cacheStateRef.path, str) || cacheStateRef.cacheState.get() != cacheState) {
                concurrentHashMap.put(Long.valueOf(j3), new CacheStateRef(str, cacheState));
            }
            clearLostRefByToggle();
        }
    }

    public static void restart() {
        Iterator<Long> it = sMap.keySet().iterator();
        while (it.hasNext()) {
            restart(it.next().longValue());
        }
        clearLostRefByToggle();
    }

    public static void stop() {
        Iterator<Long> it = sMap.keySet().iterator();
        while (it.hasNext()) {
            stop(it.next().longValue());
        }
        clearLostRefByToggle();
    }

    public static void restart(long j3) {
        CacheDrawable.CacheState cacheState;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j b16;
        CacheStateRef cacheStateRef = sMap.get(Long.valueOf(j3));
        if (cacheStateRef != null && (cacheState = cacheStateRef.cacheState.get()) != null && (b16 = cacheState.b()) != null) {
            b16.x();
        }
        clearLostRefByToggle();
    }

    public static void stop(long j3) {
        CacheDrawable.CacheState cacheState;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j b16;
        CacheStateRef cacheStateRef = sMap.get(Long.valueOf(j3));
        if (cacheStateRef != null && (cacheState = cacheStateRef.cacheState.get()) != null && (b16 = cacheState.b()) != null) {
            b16.F();
        }
        clearLostRefByToggle();
    }
}
