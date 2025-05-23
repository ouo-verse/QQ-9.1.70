package com.tencent.mtt.supportui.utils.struct;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    static Object[] f337732b;

    /* renamed from: c, reason: collision with root package name */
    static int f337733c;

    /* renamed from: d, reason: collision with root package name */
    static Object[] f337734d;

    /* renamed from: e, reason: collision with root package name */
    static int f337735e;

    /* renamed from: f, reason: collision with root package name */
    int[] f337736f;

    /* renamed from: g, reason: collision with root package name */
    Object[] f337737g;

    /* renamed from: h, reason: collision with root package name */
    int f337738h;

    public SimpleArrayMap() {
        this.f337736f = ContainerHelpers.f337711a;
        this.f337737g = ContainerHelpers.f337713c;
        this.f337738h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i3 = this.f337738h;
        if (i3 == 0) {
            return -1;
        }
        int a16 = ContainerHelpers.a(this.f337736f, i3, 0);
        if (a16 < 0 || this.f337737g[a16 << 1] == null) {
            return a16;
        }
        int i16 = a16 + 1;
        while (i16 < i3 && this.f337736f[i16] == 0) {
            if (this.f337737g[i16 << 1] == null) {
                return i16;
            }
            i16++;
        }
        for (int i17 = a16 - 1; i17 >= 0 && this.f337736f[i17] == 0; i17--) {
            if (this.f337737g[i17 << 1] == null) {
                return i17;
            }
        }
        return ~i16;
    }

    public void clear() {
        int i3 = this.f337738h;
        if (i3 != 0) {
            a(this.f337736f, this.f337737g, i3);
            this.f337736f = ContainerHelpers.f337711a;
            this.f337737g = ContainerHelpers.f337713c;
            this.f337738h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            if (a() >= 0) {
                return true;
            }
        } else if (a(obj, obj.hashCode()) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (a(obj) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i3) {
        int[] iArr = this.f337736f;
        if (iArr.length < i3) {
            Object[] objArr = this.f337737g;
            a(i3);
            int i16 = this.f337738h;
            if (i16 > 0) {
                System.arraycopy(iArr, 0, this.f337736f, 0, i16);
                System.arraycopy(objArr, 0, this.f337737g, 0, this.f337738h << 1);
            }
            a(iArr, objArr, this.f337738h);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f337738h; i3++) {
                try {
                    K keyAt = keyAt(i3);
                    V valueAt = valueAt(i3);
                    Object obj2 = map.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !map.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int a16;
        if (obj == null) {
            a16 = a();
        } else {
            a16 = a(obj, obj.hashCode());
        }
        if (a16 >= 0) {
            return (V) this.f337737g[(a16 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.f337736f;
        Object[] objArr = this.f337737g;
        int i3 = this.f337738h;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            Object obj = objArr[i16];
            int i19 = iArr[i17];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i18 += hashCode ^ i19;
            i17++;
            i16 += 2;
        }
        return i18;
    }

    public boolean isEmpty() {
        if (this.f337738h <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i3) {
        return (K) this.f337737g[i3 << 1];
    }

    public V put(K k3, V v3) {
        int i3;
        int a16;
        if (k3 == null) {
            a16 = a();
            i3 = 0;
        } else {
            int hashCode = k3.hashCode();
            i3 = hashCode;
            a16 = a(k3, hashCode);
        }
        if (a16 >= 0) {
            int i16 = (a16 << 1) + 1;
            Object[] objArr = this.f337737g;
            V v16 = (V) objArr[i16];
            objArr[i16] = v3;
            return v16;
        }
        int i17 = ~a16;
        int i18 = this.f337738h;
        int[] iArr = this.f337736f;
        if (i18 >= iArr.length) {
            int i19 = 8;
            if (i18 >= 8) {
                i19 = (i18 >> 1) + i18;
            } else if (i18 < 4) {
                i19 = 4;
            }
            Object[] objArr2 = this.f337737g;
            a(i19);
            int[] iArr2 = this.f337736f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f337737g, 0, objArr2.length);
            }
            a(iArr, objArr2, this.f337738h);
        }
        int i26 = this.f337738h;
        if (i17 < i26) {
            int[] iArr3 = this.f337736f;
            int i27 = i17 + 1;
            System.arraycopy(iArr3, i17, iArr3, i27, i26 - i17);
            Object[] objArr3 = this.f337737g;
            System.arraycopy(objArr3, i17 << 1, objArr3, i27 << 1, (this.f337738h - i17) << 1);
        }
        this.f337736f[i17] = i3;
        Object[] objArr4 = this.f337737g;
        int i28 = i17 << 1;
        objArr4[i28] = k3;
        objArr4[i28 + 1] = v3;
        this.f337738h++;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i3 = simpleArrayMap.f337738h;
        ensureCapacity(this.f337738h + i3);
        if (this.f337738h == 0) {
            if (i3 > 0) {
                System.arraycopy(simpleArrayMap.f337736f, 0, this.f337736f, 0, i3);
                System.arraycopy(simpleArrayMap.f337737g, 0, this.f337737g, 0, i3 << 1);
                this.f337738h = i3;
                return;
            }
            return;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            put(simpleArrayMap.keyAt(i16), simpleArrayMap.valueAt(i16));
        }
    }

    public V remove(Object obj) {
        int a16;
        if (obj == null) {
            a16 = a();
        } else {
            a16 = a(obj, obj.hashCode());
        }
        if (a16 >= 0) {
            return removeAt(a16);
        }
        return null;
    }

    public V removeAt(int i3) {
        Object[] objArr = this.f337737g;
        int i16 = i3 << 1;
        V v3 = (V) objArr[i16 + 1];
        int i17 = this.f337738h;
        if (i17 <= 1) {
            a(this.f337736f, objArr, i17);
            this.f337736f = ContainerHelpers.f337711a;
            this.f337737g = ContainerHelpers.f337713c;
            this.f337738h = 0;
        } else {
            int[] iArr = this.f337736f;
            int i18 = 8;
            if (iArr.length > 8 && i17 < iArr.length / 3) {
                if (i17 > 8) {
                    i18 = i17 + (i17 >> 1);
                }
                a(i18);
                this.f337738h--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f337736f, 0, i3);
                    System.arraycopy(objArr, 0, this.f337737g, 0, i16);
                }
                int i19 = this.f337738h;
                if (i3 < i19) {
                    int i26 = i3 + 1;
                    System.arraycopy(iArr, i26, this.f337736f, i3, i19 - i3);
                    System.arraycopy(objArr, i26 << 1, this.f337737g, i16, (this.f337738h - i3) << 1);
                }
            } else {
                int i27 = i17 - 1;
                this.f337738h = i27;
                if (i3 < i27) {
                    int i28 = i3 + 1;
                    System.arraycopy(iArr, i28, iArr, i3, i27 - i3);
                    Object[] objArr2 = this.f337737g;
                    System.arraycopy(objArr2, i28 << 1, objArr2, i16, (this.f337738h - i3) << 1);
                }
                Object[] objArr3 = this.f337737g;
                int i29 = this.f337738h;
                objArr3[i29 << 1] = null;
                objArr3[(i29 << 1) + 1] = null;
            }
        }
        return v3;
    }

    public V setValueAt(int i3, V v3) {
        int i16 = (i3 << 1) + 1;
        Object[] objArr = this.f337737g;
        V v16 = (V) objArr[i16];
        objArr[i16] = v3;
        return v16;
    }

    public int size() {
        return this.f337738h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder(this.f337738h * 28);
        sb5.append('{');
        for (int i3 = 0; i3 < this.f337738h; i3++) {
            if (i3 > 0) {
                sb5.append(", ");
            }
            K keyAt = keyAt(i3);
            if (keyAt != this) {
                sb5.append(keyAt);
            } else {
                sb5.append("(this Map)");
            }
            sb5.append('=');
            V valueAt = valueAt(i3);
            if (valueAt != this) {
                sb5.append(valueAt);
            } else {
                sb5.append("(this Map)");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }

    public V valueAt(int i3) {
        return (V) this.f337737g[(i3 << 1) + 1];
    }

    public SimpleArrayMap(int i3) {
        if (i3 == 0) {
            this.f337736f = ContainerHelpers.f337711a;
            this.f337737g = ContainerHelpers.f337713c;
        } else {
            a(i3);
        }
        this.f337738h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Object obj) {
        int i3 = this.f337738h * 2;
        Object[] objArr = this.f337737g;
        if (obj == null) {
            for (int i16 = 1; i16 < i3; i16 += 2) {
                if (objArr[i16] == null) {
                    return i16 >> 1;
                }
            }
            return -1;
        }
        for (int i17 = 1; i17 < i3; i17 += 2) {
            if (obj.equals(objArr[i17])) {
                return i17 >> 1;
            }
        }
        return -1;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Object obj, int i3) {
        int i16 = this.f337738h;
        if (i16 == 0) {
            return -1;
        }
        int a16 = ContainerHelpers.a(this.f337736f, i16, i3);
        if (a16 < 0 || obj.equals(this.f337737g[a16 << 1])) {
            return a16;
        }
        int i17 = a16 + 1;
        while (i17 < i16 && this.f337736f[i17] == i3) {
            if (obj.equals(this.f337737g[i17 << 1])) {
                return i17;
            }
            i17++;
        }
        for (int i18 = a16 - 1; i18 >= 0 && this.f337736f[i18] == i3; i18--) {
            if (obj.equals(this.f337737g[i18 << 1])) {
                return i18;
            }
        }
        return ~i17;
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (ArrayMap.class) {
                Object[] objArr = f337734d;
                if (objArr != null) {
                    this.f337737g = objArr;
                    f337734d = (Object[]) objArr[0];
                    this.f337736f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f337735e--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (ArrayMap.class) {
                Object[] objArr2 = f337732b;
                if (objArr2 != null) {
                    this.f337737g = objArr2;
                    f337732b = (Object[]) objArr2[0];
                    this.f337736f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f337733c--;
                    return;
                }
            }
        }
        this.f337736f = new int[i3];
        this.f337737g = new Object[i3 << 1];
    }

    private static void a(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f337735e < 10) {
                    objArr[0] = f337734d;
                    objArr[1] = iArr;
                    for (int i16 = (i3 << 1) - 1; i16 >= 2; i16--) {
                        objArr[i16] = null;
                    }
                    f337734d = objArr;
                    f337735e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f337733c < 10) {
                    objArr[0] = f337732b;
                    objArr[1] = iArr;
                    for (int i17 = (i3 << 1) - 1; i17 >= 2; i17--) {
                        objArr[i17] = null;
                    }
                    f337732b = objArr;
                    f337733c++;
                }
            }
        }
    }
}
