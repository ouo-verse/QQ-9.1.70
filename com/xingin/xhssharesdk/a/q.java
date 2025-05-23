package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.f;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class q<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    public static final q f389970b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f389971a;

    static {
        q qVar = new q(Collections.emptyMap());
        f389970b = qVar;
        qVar.f389971a = false;
    }

    public q() {
        this.f389971a = true;
    }

    public static <K, V> q<K, V> a() {
        return f389970b;
    }

    public final void b() {
        if (this.f389971a) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z16;
        boolean equals;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this != map) {
            if (size() == map.size()) {
                for (Map.Entry<K, V> entry : entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        V value = entry.getValue();
                        Object obj2 = map.get(entry.getKey());
                        if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                            equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                        } else {
                            equals = value.equals(obj2);
                        }
                        if (!equals) {
                        }
                    }
                }
            }
            z16 = false;
            if (z16) {
                return false;
            }
            return true;
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int hashCode;
        int i3 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            K key = entry.getKey();
            int i16 = 1;
            if (key instanceof byte[]) {
                byte[] bArr = (byte[]) key;
                Charset charset = f.f389911a;
                int length = bArr.length;
                hashCode = length;
                for (int i17 = 0; i17 < 0 + length; i17++) {
                    hashCode = (hashCode * 31) + bArr[i17];
                }
                if (hashCode == 0) {
                    hashCode = 1;
                }
            } else if (!(key instanceof f.a)) {
                hashCode = key.hashCode();
            } else {
                throw new UnsupportedOperationException();
            }
            V value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                Charset charset2 = f.f389911a;
                int length2 = bArr2.length;
                int i18 = length2;
                for (int i19 = 0; i19 < 0 + length2; i19++) {
                    i18 = (i18 * 31) + bArr2[i19];
                }
                if (i18 != 0) {
                    i16 = i18;
                }
            } else if (!(value instanceof f.a)) {
                i16 = value.hashCode();
            } else {
                throw new UnsupportedOperationException();
            }
            i3 += hashCode ^ i16;
        }
        return i3;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k3, V v3) {
        b();
        return (V) super.put(k3, v3);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b();
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        return (V) super.remove(obj);
    }

    public q(Map<K, V> map) {
        super(map);
        this.f389971a = true;
    }

    public final void a(q<K, V> qVar) {
        b();
        if (qVar.isEmpty()) {
            return;
        }
        b();
        super.putAll(qVar);
    }
}
