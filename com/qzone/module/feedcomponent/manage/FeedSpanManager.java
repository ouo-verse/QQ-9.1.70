package com.qzone.module.feedcomponent.manage;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSpanManager {
    static FeedSpanManager mInstance;
    ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();

    FeedSpanManager() {
    }

    public static FeedSpanManager getInstance() {
        if (mInstance == null) {
            synchronized (FeedSpanManager.class) {
                if (mInstance == null) {
                    mInstance = new FeedSpanManager();
                }
            }
        }
        return mInstance;
    }

    public void destroyInstance() {
        if (mInstance != null) {
            this.map.clear();
            this.map = null;
            mInstance = null;
        }
    }

    public boolean isContainKey(String str) {
        return this.map.containsKey(str);
    }

    public void removeKey(String str) {
        this.map.remove(str);
    }

    public void saveState(String str, boolean z16) {
        this.map.put(str, Boolean.valueOf(z16));
    }

    public boolean getState(String str) {
        return (str == null || this.map.get(str) == null) ? false : true;
    }
}
