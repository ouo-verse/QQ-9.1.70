package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class SpCache implements ISpOperation {
    private static final String TAG = "SpCache";
    private static volatile SpCache sInstance;
    private SpService mService;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> mCache = new ConcurrentHashMap<>();
    private AnnotationProcessor mAnnotationProcessor = AnnotationProcessor.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a<T> implements Callable<List<Pair<String, T>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Class f345330d;

        a(Class cls) {
            this.f345330d = cls;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Pair<String, T>> call() {
            return SpCache.this.mService.getAllObjects(this.f345330d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements Callable<Void> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f345332d;

        b(Runnable runnable) {
            this.f345332d = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.f345332d.run();
            return null;
        }
    }

    SpCache(Context context) {
        this.mService = new SpService(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpCache getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SpCache.class) {
                if (sInstance == null) {
                    sInstance = new SpCache(context);
                }
            }
        }
        return sInstance;
    }

    private void operateSp(Runnable runnable) {
        operateSp(new b(runnable));
    }

    private <T> void sync(Class<T> cls) {
        String classId = this.mAnnotationProcessor.getClassId(cls);
        if (!this.mCache.containsKey(classId)) {
            List<Pair> list = (List) operateSp(new a(cls));
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            for (Pair pair : list) {
                concurrentHashMap.put((String) pair.first, pair.second);
            }
            this.mCache.putIfAbsent(classId, concurrentHashMap);
        }
    }

    public void clearCache() {
        synchronized (this.mCache) {
            this.mCache.clear();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public void clearSp() {
        synchronized (this.mCache) {
            Iterator<ConcurrentHashMap<String, Object>> it = this.mCache.values().iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.6
                @Override // java.lang.Runnable
                public void run() {
                    SpCache.this.mService.clearSp();
                }
            });
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> boolean containsObject(Class<T> cls, String str) {
        sync(cls);
        return this.mCache.get(this.mAnnotationProcessor.getClassId(cls)).containsKey(str);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteAllObjects(final Class<T> cls) {
        sync(cls);
        synchronized (this.mCache) {
            this.mCache.get(this.mAnnotationProcessor.getClassId(cls)).clear();
            operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.4
                @Override // java.lang.Runnable
                public void run() {
                    SpCache.this.mService.deleteAllObjects(cls);
                }
            });
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteObject(final Class<T> cls, final String str) {
        sync(cls);
        synchronized (this.mCache) {
            ConcurrentHashMap<String, Object> concurrentHashMap = this.mCache.get(this.mAnnotationProcessor.getClassId(cls));
            if (concurrentHashMap.containsKey(str)) {
                concurrentHashMap.remove(str);
                operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SpCache.this.mService.deleteObject(cls, str);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteObjects(final Class<T> cls, final List<String> list) {
        sync(cls);
        synchronized (this.mCache) {
            ConcurrentHashMap<String, Object> concurrentHashMap = this.mCache.get(this.mAnnotationProcessor.getClassId(cls));
            for (String str : list) {
                if (str != null) {
                    concurrentHashMap.remove(str);
                }
            }
            operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.5
                @Override // java.lang.Runnable
                public void run() {
                    SpCache.this.mService.deleteObjects(cls, list);
                }
            });
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> List<Pair<String, T>> getAllObjects(Class<T> cls) {
        sync(cls);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mCache.get(this.mAnnotationProcessor.getClassId(cls));
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
            linkedList.add(new Pair(entry.getKey(), cls.cast(entry.getValue())));
        }
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> T getObject(Class<T> cls, String str) {
        sync(cls);
        return cls.cast(this.mCache.get(this.mAnnotationProcessor.getClassId(cls)).get(str));
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> List<Pair<String, T>> getObjects(Class<T> cls, Condition<T> condition) {
        T cast;
        sync(cls);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mCache.get(this.mAnnotationProcessor.getClassId(cls));
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
            if (entry != null && (cast = cls.cast(entry.getValue())) != null && (condition == null || condition.satisfy(cast))) {
                linkedList.add(new Pair(entry.getKey(), cast));
            }
        }
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void insertObject(final T t16, final String str) {
        if (!TextUtils.isEmpty(str)) {
            sync(t16.getClass());
            synchronized (this.mCache) {
                this.mCache.get(this.mAnnotationProcessor.getClassId(t16.getClass())).put(str, t16);
                operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpCache.this.mService.insertObject(t16, str);
                    }
                });
            }
            return;
        }
        throw new IllegalArgumentException("Illegal object id!");
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void insertObjects(final List<T> list, final List<String> list2) {
        if (list.size() == list2.size()) {
            if (list.isEmpty()) {
                return;
            }
            Class<?> cls = list.get(0).getClass();
            sync(cls);
            synchronized (this.mCache) {
                ConcurrentHashMap<String, Object> concurrentHashMap = this.mCache.get(this.mAnnotationProcessor.getClassId(cls));
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    String str = list2.get(i3);
                    T t16 = list.get(i3);
                    if (t16 != null && !TextUtils.isEmpty(str)) {
                        if (t16.getClass() == cls) {
                            concurrentHashMap.put(str, t16);
                        } else {
                            throw new IllegalArgumentException("Object type is different from others.");
                        }
                    } else {
                        throw new IllegalArgumentException("Object is null or id is null.");
                    }
                }
                operateSp(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.storage.preference.SpCache.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SpCache.this.mService.insertObjects(list, list2);
                    }
                });
            }
            return;
        }
        throw new IllegalArgumentException("Two lists have different sizes.");
    }

    private <T> T operateSp(Callable<T> callable) {
        if (!ThreadUtils.isMainThread()) {
            try {
                return callable.call();
            } catch (Exception e16) {
                Log.e(TAG, "operate sharedPreference exception: " + e16.getLocalizedMessage());
                return null;
            }
        }
        throw new RuntimeException("Cannot be called on the main thread!");
    }

    public <T> void deleteObjects(Class<T> cls, Condition<T> condition) {
        sync(cls);
        synchronized (this.mCache) {
            Set<Map.Entry<String, Object>> entrySet = this.mCache.get(this.mAnnotationProcessor.getClassId(cls)).entrySet();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Object> entry : entrySet) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null && (condition == null || condition.satisfy(cls.cast(entry.getValue())))) {
                    arrayList.add(entry.getKey());
                }
            }
            if (!arrayList.isEmpty()) {
                deleteObjects(cls, arrayList);
            }
        }
    }
}
