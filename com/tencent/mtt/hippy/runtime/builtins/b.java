package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.runtime.builtins.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b<T extends com.tencent.mtt.hippy.runtime.builtins.a> extends e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f337586a = true;

    /* renamed from: b, reason: collision with root package name */
    private T f337587b;

    /* renamed from: c, reason: collision with root package name */
    private a f337588c;

    /* renamed from: d, reason: collision with root package name */
    private final int f337589d;

    /* renamed from: e, reason: collision with root package name */
    private final String f337590e = "byteOffset";

    /* renamed from: f, reason: collision with root package name */
    private final String f337591f = "byteLength";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum a {
        INT8_ARRAY,
        UINT8_ARRAY,
        UINT8_CLAMPED_ARRAY,
        INT16_ARRAY,
        UINT16_ARRAY,
        INT32_ARRAY,
        UINT32_ARRAY,
        FLOAT32_ARRAY,
        FLOAT64_ARRAY,
        BIGINT64_ARRAY,
        BIGUINT64_ARRAY,
        DATA_VIEW
    }

    public b(T t16, a aVar, int i3, int i16, int i17) {
        this.f337587b = t16;
        this.f337588c = aVar;
        this.f337589d = i17;
        a("byteOffset", Integer.valueOf(i3));
        a("byteLength", Integer.valueOf(i16));
    }

    public a a() {
        return this.f337588c;
    }

    public int b() {
        return this.f337589d;
    }

    public T c() {
        return this.f337587b;
    }

    public int d() {
        Object a16 = a("byteOffset");
        if (!f337586a && a16 == null) {
            throw new AssertionError();
        }
        return ((Integer) a16).intValue();
    }

    public int e() {
        Object a16 = a("byteLength");
        if (!f337586a && a16 == null) {
            throw new AssertionError();
        }
        return ((Integer) a16).intValue();
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b<T> clone() throws CloneNotSupportedException {
        b<T> bVar = (b) super.clone();
        bVar.f337588c = this.f337588c;
        bVar.f337587b = (T) this.f337587b.clone();
        return bVar;
    }
}
