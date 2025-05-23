package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDiskReadWrite {
    public static final String TAG = "TVKPlayer[TVKDiskReadWrite]";
    private ArrayList<String> mKey = new ArrayList<>();
    private LocalCache mKeyCache;
    private String mKeyCacheName;
    private LocalCache mMessageCache;

    public TVKDiskReadWrite(Context context, String str) {
        this.mMessageCache = null;
        this.mKeyCache = null;
        this.mKeyCacheName = null;
        this.mMessageCache = LocalCache.get(context, str);
        String str2 = str + "_key";
        this.mKeyCacheName = str2;
        this.mKeyCache = LocalCache.get(context, str2);
    }

    public synchronized Object readAllFile() {
        Object asObject;
        ArrayList arrayList = (ArrayList) this.mKeyCache.getAsObject(this.mKeyCacheName);
        ArrayList arrayList2 = null;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                if (!TextUtils.isEmpty(str) && (asObject = this.mMessageCache.getAsObject(str)) != null) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(asObject);
                }
            }
            this.mMessageCache.clear();
            this.mKeyCache.clear();
            this.mKey.clear();
            return arrayList2;
        }
        return null;
    }

    public synchronized Map<String, Properties> readAllFileForMap() {
        Properties properties;
        ArrayList arrayList = (ArrayList) this.mKeyCache.getAsObject(this.mKeyCacheName);
        if (arrayList != null && arrayList.size() > 0) {
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                if (!TextUtils.isEmpty(str) && (properties = (Properties) this.mMessageCache.getAsObject(str)) != null) {
                    hashMap.put(str, properties);
                }
            }
            return hashMap;
        }
        return new HashMap();
    }

    public synchronized void rmFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMessageCache.remove(str);
        this.mKey.remove(str);
        this.mKeyCache.remove(this.mKeyCacheName);
        this.mKeyCache.put(this.mKeyCacheName, this.mKey);
    }

    public synchronized void writeFile(String str, Serializable serializable) {
        if (serializable != null) {
            if (!TextUtils.isEmpty(str)) {
                this.mMessageCache.remove(str);
                this.mMessageCache.put(str, serializable);
                this.mKey.remove(str);
                this.mKey.add(str);
                this.mKeyCache.remove(this.mKeyCacheName);
                this.mKeyCache.put(this.mKeyCacheName, this.mKey);
            }
        }
    }
}
