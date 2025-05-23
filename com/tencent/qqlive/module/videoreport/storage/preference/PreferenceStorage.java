package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.IDataStorage;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.database.DatabaseStorage;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class PreferenceStorage implements IDataStorage {
    private static volatile PreferenceStorage sInstance;
    private AnnotationProcessor mAnnotationProcessor = AnnotationProcessor.getInstance();
    private SpCache mCache;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes22.dex */
    class a<T> implements Condition<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f345319a;

        a(List list) {
            this.f345319a = list;
        }

        @Override // com.tencent.qqlive.module.videoreport.storage.util.Condition
        public boolean satisfy(T t16) {
            return this.f345319a.contains(PreferenceStorage.this.mAnnotationProcessor.getObjectId(t16));
        }
    }

    PreferenceStorage(Context context) {
        this.mCache = SpCache.getInstance(context);
    }

    public static PreferenceStorage getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DatabaseStorage.class) {
                if (sInstance == null) {
                    sInstance = new PreferenceStorage(context);
                }
            }
        }
        return sInstance;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public void clear() {
        this.mCache.clearSp();
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> boolean contains(T t16) {
        return contains(t16.getClass(), this.mAnnotationProcessor.getObjectId(t16));
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void delete(T t16) {
        this.mCache.deleteObject(t16.getClass(), this.mAnnotationProcessor.getObjectId(t16));
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void deleteAll(Class<T> cls) {
        this.mCache.deleteAllObjects(cls);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> T load(Class<T> cls, String str) {
        return (T) this.mCache.getObject(cls, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> List<T> loadAll(Class<T> cls) {
        List<Pair<String, T>> allObjects = this.mCache.getAllObjects(cls);
        ArrayList arrayList = new ArrayList();
        Iterator<Pair<String, T>> it = allObjects.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().second);
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void storeOrUpdate(T t16, String str) {
        this.mCache.insertObject(t16, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> List<T> load(Class<T> cls, List<String> list) {
        List<Pair<String, T>> objects = this.mCache.getObjects(cls, new a(list));
        ArrayList arrayList = new ArrayList();
        Iterator<Pair<String, T>> it = objects.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().second);
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void storeOrUpdate(T t16) {
        storeOrUpdate((PreferenceStorage) t16, this.mAnnotationProcessor.getObjectId(t16));
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> boolean contains(Class<T> cls, String str) {
        return this.mCache.containsObject(cls, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void delete(Class<T> cls, String str) {
        this.mCache.deleteObject(cls, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void delete(Class<T> cls, List<String> list) {
        this.mCache.deleteObjects(cls, list);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void storeOrUpdate(List<T> list, List<String> list2) {
        this.mCache.insertObjects(list, list2);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void delete(List<T> list) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Class<?> cls = list.get(0).getClass();
        for (T t16 : list) {
            if (t16 != null && t16.getClass() == cls) {
                arrayList.add(this.mAnnotationProcessor.getObjectId(t16));
            } else {
                throw new IllegalArgumentException("Element " + t16 + " has the different type from others.");
            }
        }
        delete(cls, arrayList);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void storeOrUpdate(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            String objectId = this.mAnnotationProcessor.getObjectId(t16);
            if (objectId != null) {
                arrayList.add(objectId);
            } else {
                throw new IllegalArgumentException("Element " + t16 + " has not initialized its ID.");
            }
        }
        storeOrUpdate(list, arrayList);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> List<T> load(Class<T> cls, Condition<T> condition) {
        List<Pair<String, T>> objects = this.mCache.getObjects(cls, condition);
        ArrayList arrayList = new ArrayList();
        Iterator<Pair<String, T>> it = objects.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().second);
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.IDataStorage
    public <T> void delete(Class<T> cls, Condition<T> condition) {
        this.mCache.deleteObjects(cls, condition);
    }
}
