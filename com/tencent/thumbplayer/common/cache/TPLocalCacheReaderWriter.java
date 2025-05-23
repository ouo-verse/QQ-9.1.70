package com.tencent.thumbplayer.common.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class TPLocalCacheReaderWriter {
    private final TPLocalCache mDataCache;
    private final TPLocalCache mKeyCache;
    private final String mKeyCacheName;
    private ArrayList<String> mKeyList;

    public TPLocalCacheReaderWriter(@NonNull Context context, String str) {
        this.mDataCache = TPLocalCache.getInstance(context, str);
        String str2 = str + "_key";
        this.mKeyCacheName = str2;
        TPLocalCache tPLocalCache = TPLocalCache.getInstance(context, str2);
        this.mKeyCache = tPLocalCache;
        if (tPLocalCache != null) {
            this.mKeyList = (ArrayList) tPLocalCache.getAsObject(str2);
        }
        if (this.mKeyList == null) {
            this.mKeyList = new ArrayList<>();
        }
    }

    public synchronized void clearAll() {
        TPLocalCache tPLocalCache = this.mDataCache;
        if (tPLocalCache != null) {
            tPLocalCache.clear();
        }
        TPLocalCache tPLocalCache2 = this.mKeyCache;
        if (tPLocalCache2 != null) {
            tPLocalCache2.clear();
        }
        this.mKeyList.clear();
    }

    @NonNull
    public synchronized ArrayList<String> getKeyList() {
        return (ArrayList) this.mKeyList.clone();
    }

    @Nullable
    public synchronized Object read(@NonNull String str) {
        TPLocalCache tPLocalCache;
        if (!TextUtils.isEmpty(str) && (tPLocalCache = this.mDataCache) != null) {
            return tPLocalCache.getAsObject(str);
        }
        return null;
    }

    @NonNull
    public synchronized List<Object> readAll() {
        Object asObject;
        TPLocalCache tPLocalCache = this.mKeyCache;
        if (tPLocalCache != null && this.mDataCache != null) {
            ArrayList arrayList = (ArrayList) tPLocalCache.getAsObject(this.mKeyCacheName);
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    String str = (String) arrayList.get(i3);
                    if (!TextUtils.isEmpty(str) && (asObject = this.mDataCache.getAsObject(str)) != null) {
                        arrayList2.add(asObject);
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return null;
    }

    public synchronized void remove(String str) {
        TPLocalCache tPLocalCache;
        if (!TextUtils.isEmpty(str) && this.mKeyCache != null && (tPLocalCache = this.mDataCache) != null) {
            tPLocalCache.remove(str);
            this.mKeyList.remove(str);
            this.mKeyCache.remove(this.mKeyCacheName);
            if (!this.mKeyList.isEmpty()) {
                this.mKeyCache.put(this.mKeyCacheName, this.mKeyList);
            }
        }
    }

    public synchronized void write(@NonNull String str, @NonNull Serializable serializable) {
        TPLocalCache tPLocalCache;
        if (serializable != null) {
            if (!TextUtils.isEmpty(str) && this.mKeyCache != null && (tPLocalCache = this.mDataCache) != null) {
                tPLocalCache.remove(str);
                this.mDataCache.put(str, serializable);
                this.mKeyList.remove(str);
                this.mKeyList.add(str);
                this.mKeyCache.remove(this.mKeyCacheName);
                this.mKeyCache.put(this.mKeyCacheName, this.mKeyList);
            }
        }
    }
}
