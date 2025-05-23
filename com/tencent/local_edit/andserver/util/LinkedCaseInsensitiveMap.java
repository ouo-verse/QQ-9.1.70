package com.tencent.local_edit.andserver.util;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LinkedCaseInsensitiveMap<V> implements Map<String, V>, Serializable, Cloneable {
    private final HashMap<String, String> mCaseInsensitiveKeys;
    private final Locale mLocale;
    private final LinkedHashMap<String, V> mSource;

    public LinkedCaseInsensitiveMap() {
        this((Locale) null);
    }

    @Override // java.util.Map
    public void clear() {
        this.mCaseInsensitiveKeys.clear();
        this.mSource.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if ((obj instanceof String) && this.mCaseInsensitiveKeys.containsKey(convertKey((String) obj))) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.mSource.containsValue(obj);
    }

    protected String convertKey(String str) {
        return str.toLowerCase(getLocale());
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<String, V>> entrySet() {
        return this.mSource.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.mSource.equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        String str;
        if ((obj instanceof String) && (str = this.mCaseInsensitiveKeys.get(convertKey((String) obj))) != null) {
            return this.mSource.get(str);
        }
        return null;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    @Override // java.util.Map
    public V getOrDefault(Object obj, V v3) {
        String str;
        if ((obj instanceof String) && (str = this.mCaseInsensitiveKeys.get(convertKey((String) obj))) != null) {
            return this.mSource.get(str);
        }
        return v3;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.mSource.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mSource.isEmpty();
    }

    @Override // java.util.Map
    @NonNull
    public Set<String> keySet() {
        return this.mSource.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends String, ? extends V> map) {
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<? extends String, ? extends V> entry : map.entrySet()) {
            put2(entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        String remove;
        if ((obj instanceof String) && (remove = this.mCaseInsensitiveKeys.remove(convertKey((String) obj))) != null) {
            return this.mSource.remove(remove);
        }
        return null;
    }

    protected boolean removeEldestEntry(Map.Entry<String, V> entry) {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.mSource.size();
    }

    public String toString() {
        return this.mSource.toString();
    }

    @Override // java.util.Map
    @NonNull
    public Collection<V> values() {
        return this.mSource.values();
    }

    public LinkedCaseInsensitiveMap(Locale locale) {
        this(16, locale);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LinkedCaseInsensitiveMap<V> m159clone() {
        return new LinkedCaseInsensitiveMap<>(this);
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(String str, V v3) {
        String put = this.mCaseInsensitiveKeys.put(convertKey(str), str);
        if (put != null && !put.equals(str)) {
            this.mSource.remove(put);
        }
        return this.mSource.put(str, v3);
    }

    public LinkedCaseInsensitiveMap(int i3) {
        this(i3, null);
    }

    public LinkedCaseInsensitiveMap(int i3, Locale locale) {
        this.mSource = new LinkedHashMap<String, V>(i3) { // from class: com.tencent.local_edit.andserver.util.LinkedCaseInsensitiveMap.1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object obj) {
                return LinkedCaseInsensitiveMap.this.containsKey(obj);
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, V> entry) {
                boolean removeEldestEntry = LinkedCaseInsensitiveMap.this.removeEldestEntry(entry);
                if (removeEldestEntry) {
                    LinkedCaseInsensitiveMap.this.mCaseInsensitiveKeys.remove(LinkedCaseInsensitiveMap.this.convertKey(entry.getKey()));
                }
                return removeEldestEntry;
            }
        };
        this.mCaseInsensitiveKeys = new HashMap<>(i3);
        this.mLocale = locale == null ? Locale.getDefault() : locale;
    }

    LinkedCaseInsensitiveMap(LinkedCaseInsensitiveMap<V> linkedCaseInsensitiveMap) {
        this.mSource = (LinkedHashMap) linkedCaseInsensitiveMap.mSource.clone();
        this.mCaseInsensitiveKeys = (HashMap) linkedCaseInsensitiveMap.mCaseInsensitiveKeys.clone();
        this.mLocale = linkedCaseInsensitiveMap.mLocale;
    }
}
