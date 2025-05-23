package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class PortConfigStrategy {
    private static final String TAG = "PortConfigStrategy";
    private String mJsonConfig = null;
    private Map<String, List<Integer>> mapAvailablePorts = new HashMap();
    private Map<String, List<Integer>> mapCacheAvailablePorts = new HashMap();
    private Map<String, Pattern> mDominPatterns = new HashMap();
    private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<Integer> findPortConfig(String str) {
        List<Integer> list;
        List<Integer> list2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.RW_LOCK.readLock().lock();
        boolean z16 = true;
        try {
        } finally {
            try {
                if (!z16) {
                }
                return list2;
            } finally {
            }
        }
        if (this.mapCacheAvailablePorts.containsKey(str)) {
            list = this.mapCacheAvailablePorts.get(str);
        } else {
            z16 = false;
            String dominKey = getDominKey(str);
            if (!TextUtils.isEmpty(dominKey) && this.mapAvailablePorts.containsKey(dominKey)) {
                list = this.mapAvailablePorts.get(dominKey);
            }
            if (!z16 && list2 != null) {
                try {
                    this.RW_LOCK.writeLock().lock();
                    this.mapCacheAvailablePorts.put(str, list2);
                } finally {
                    this.RW_LOCK.writeLock().unlock();
                }
            }
            return list2;
        }
        list2 = list;
        if (!z16) {
            this.RW_LOCK.writeLock().lock();
            this.mapCacheAvailablePorts.put(str, list2);
        }
        return list2;
    }

    private String getDominKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, Pattern> entry : this.mDominPatterns.entrySet()) {
            String key = entry.getKey();
            if (Utils.match(entry.getValue(), str)) {
                return key;
            }
        }
        return null;
    }

    public final int changePort(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str)) {
            List<Integer> findPortConfig = findPortConfig(str);
            if (findPortConfig != null) {
                try {
                    if (findPortConfig.size() > 0) {
                        this.RW_LOCK.readLock().lock();
                        int indexOf = findPortConfig.indexOf(new Integer(i3));
                        if (indexOf < 0) {
                            indexOf = 0;
                        }
                        return findPortConfig.get((indexOf + 1) % findPortConfig.size()).intValue();
                    }
                    return -1;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return -1;
                } finally {
                    this.RW_LOCK.readLock().unlock();
                }
            }
            return -1;
        }
        return 80;
    }

    public final void setConfig(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mJsonConfig)) {
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "Downloader port config:" + str);
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i3 = 0; i3 < names.length(); i3++) {
                        String string = names.getString(i3);
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray(names.getString(i3));
                        if (jSONArray != null) {
                            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                Integer valueOf = Integer.valueOf(jSONArray.getJSONObject(i16).getInt("port"));
                                arrayList.add(valueOf);
                                if (QDLog.isInfoEnable()) {
                                    QDLog.i(TAG, "downloader port: domain:" + string + " port:" + valueOf);
                                }
                            }
                        }
                        hashMap.put(string, arrayList);
                        hashMap2.put(string, Pattern.compile(string, 2));
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                this.RW_LOCK.writeLock().lock();
                this.mJsonConfig = str;
                this.mapAvailablePorts.clear();
                this.mapAvailablePorts.putAll(hashMap);
                this.mapCacheAvailablePorts.clear();
                this.mDominPatterns.clear();
                this.mDominPatterns.putAll(hashMap2);
            } finally {
                this.RW_LOCK.writeLock().unlock();
            }
        }
    }

    public final boolean supportExtraPort(String str) {
        if (TextUtils.isEmpty(str) || findPortConfig(str) == null) {
            return false;
        }
        return true;
    }
}
