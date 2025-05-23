package com.tencent.mobileqq.qmmkv;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class MMKVAdapter implements SharedPreferences, SharedPreferences.Editor {
    private static final String TAG = "MMKVAdapter";
    private static final String TYPE_BOOL = "_@Bool_";
    private static final String TYPE_FLOT = "_@Flot_";
    private static final String TYPE_INTE = "_@Inte_";
    private static final String TYPE_LONG = "_@Long_";
    private static final String TYPE_SETS = "_@Strt_";
    private static final String TYPE_STRI = "_@Stri_";
    private final MMKVOptionEntity mmkvOptionEntity;
    private final String spName;

    /* JADX INFO: Access modifiers changed from: protected */
    public MMKVAdapter(@NonNull MMKVOptionEntity mMKVOptionEntity, String str) {
        this.spName = str;
        this.mmkvOptionEntity = mMKVOptionEntity;
    }

    private Map<String, Object> decodeAllForShared(String str, Map<String, Object> map) {
        Object obj;
        String[] allKeyArr = this.mmkvOptionEntity.allKeyArr();
        if (allKeyArr != null && allKeyArr.length > 0) {
            for (String str2 : allKeyArr) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    String internalKeyOriginal = internalKeyOriginal(str, str2);
                    String substring = str2.substring(str.length());
                    if (substring.startsWith(TYPE_BOOL)) {
                        obj = Boolean.valueOf(this.mmkvOptionEntity.decodeBool(str2, false));
                    } else if (substring.startsWith(TYPE_FLOT)) {
                        obj = Float.valueOf(this.mmkvOptionEntity.decodeFloat(str2, 0.0f));
                    } else if (substring.startsWith(TYPE_INTE)) {
                        obj = Integer.valueOf(this.mmkvOptionEntity.decodeInt(str2, 0));
                    } else if (substring.startsWith(TYPE_LONG)) {
                        obj = Long.valueOf(this.mmkvOptionEntity.decodeLong(str2, 0L));
                    } else if (substring.startsWith(TYPE_STRI)) {
                        obj = this.mmkvOptionEntity.decodeString(str2, null);
                    } else if (substring.startsWith(TYPE_SETS)) {
                        obj = this.mmkvOptionEntity.decodeStringSet(str2, null);
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        map.put(internalKeyOriginal, obj);
                    }
                }
            }
        }
        return map;
    }

    private String internalKeyOriginal(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int length = str.length() + 7;
            if (str2.length() < length) {
                return str2;
            }
            return str2.substring(length);
        }
        return str2;
    }

    private String internalKeyWithType(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str + str3 + str2;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.commitAsync();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        String[] allKeyArr;
        if (isEntityAccessible() && (allKeyArr = this.mmkvOptionEntity.allKeyArr()) != null && allKeyArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : allKeyArr) {
                if (!TextUtils.isEmpty(str) && str.startsWith(this.spName)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                this.mmkvOptionEntity.removeKeyList(arrayList);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.commitSync();
            return true;
        }
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            String[] strArr = {TYPE_BOOL, TYPE_FLOT, TYPE_INTE, TYPE_LONG, TYPE_STRI, TYPE_SETS};
            for (int i3 = 0; i3 < 6; i3++) {
                if (this.mmkvOptionEntity.containsKey(internalKeyWithType(this.spName, str, strArr[i3]))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap(0);
        if (isEntityAccessible()) {
            return decodeAllForShared(this.spName, hashMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeBool(internalKeyWithType(this.spName, str, TYPE_BOOL), z16);
        }
        return z16;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeFloat(internalKeyWithType(this.spName, str, TYPE_FLOT), f16);
        }
        return f16;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeInt(internalKeyWithType(this.spName, str, TYPE_INTE), i3);
        }
        return i3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeLong(internalKeyWithType(this.spName, str, TYPE_LONG), j3);
        }
        return j3;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeString(internalKeyWithType(this.spName, str, TYPE_STRI), str2);
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && isEntityAccessible()) {
            return this.mmkvOptionEntity.decodeStringSet(internalKeyWithType(this.spName, str, TYPE_SETS), set);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEntityAccessible() {
        MMKVOptionEntity mMKVOptionEntity = this.mmkvOptionEntity;
        if (mMKVOptionEntity != null && mMKVOptionEntity.isAccessible()) {
            return true;
        }
        return false;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeBool(internalKeyWithType(this.spName, str, TYPE_BOOL), z16);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeFloat(internalKeyWithType(this.spName, str, TYPE_FLOT), f16);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeInt(internalKeyWithType(this.spName, str, TYPE_INTE), i3);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeLong(internalKeyWithType(this.spName, str, TYPE_LONG), j3);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeString(internalKeyWithType(this.spName, str, TYPE_STRI), str2);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (isEntityAccessible()) {
            this.mmkvOptionEntity.encodeStringSet(internalKeyWithType(this.spName, str, TYPE_SETS), set);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (isEntityAccessible()) {
            String[] strArr = {TYPE_BOOL, TYPE_FLOT, TYPE_INTE, TYPE_LONG, TYPE_STRI, TYPE_SETS};
            for (int i3 = 0; i3 < 6; i3++) {
                String internalKeyWithType = internalKeyWithType(this.spName, str, strArr[i3]);
                if (this.mmkvOptionEntity.containsKey(internalKeyWithType)) {
                    this.mmkvOptionEntity.removeKey(internalKeyWithType);
                }
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
