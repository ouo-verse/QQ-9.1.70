package com.tencent.liteav.base.storage;

import android.content.SharedPreferences;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class PersistStorage {
    public static final String GLOBAL_DOMAIN = "com.liteav.storage.global";
    private static final String LITEAV_PERSIST_STORAGE_SP_NAME = "com.liteav.persist.storage";
    private String mDomain;
    private final SharedPreferences.Editor mEditor;
    private final SharedPreferences mSharedPreferences;

    public PersistStorage(String str) {
        this(str, false);
    }

    private String[] filterSet(Set<String> set, String str) {
        if (str != null && !str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : set) {
                if (str2.startsWith(str)) {
                    arrayList.add(str2.substring(str.length()));
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            return strArr;
        }
        return (String[]) set.toArray(new String[set.size()]);
    }

    private void initializeDomain(String str, boolean z16) {
        if (!z16) {
            if (str != null && !str.isEmpty()) {
                this.mDomain = str + "|";
                return;
            }
            this.mDomain = "null|";
            return;
        }
        this.mDomain = "";
    }

    public static int integerToBase(Integer num) {
        return num.intValue();
    }

    public static long longToBase(Long l3) {
        return l3.longValue();
    }

    public void clear(String str) {
        this.mEditor.remove(this.mDomain + str);
    }

    public void commit() {
        this.mEditor.apply();
    }

    public String[] getAllKeys() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            return filterSet(all.keySet(), this.mDomain);
        }
        return new String[0];
    }

    public Integer getInt(String str) {
        if (!this.mSharedPreferences.contains(this.mDomain + str)) {
            return null;
        }
        try {
            return Integer.valueOf(this.mSharedPreferences.getInt(this.mDomain + str, -1));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Long getLong(String str) {
        if (!this.mSharedPreferences.contains(this.mDomain + str)) {
            return null;
        }
        try {
            return Long.valueOf(this.mSharedPreferences.getLong(this.mDomain + str, -1L));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getString(String str) {
        if (!this.mSharedPreferences.contains(this.mDomain + str)) {
            return null;
        }
        try {
            return this.mSharedPreferences.getString(this.mDomain + str, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void put(String str, int i3) {
        this.mEditor.putInt(this.mDomain + str, i3);
    }

    public PersistStorage(String str, boolean z16) {
        initializeDomain(str, z16);
        SharedPreferences sharedPreferences = ContextUtils.getApplicationContext().getSharedPreferences(z16 ? str : LITEAV_PERSIST_STORAGE_SP_NAME, 0);
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public void put(String str, long j3) {
        this.mEditor.putLong(this.mDomain + str, j3);
    }

    public void put(String str, String str2) {
        this.mEditor.putString(this.mDomain + str, str2);
    }
}
