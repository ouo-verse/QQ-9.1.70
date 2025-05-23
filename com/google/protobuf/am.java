package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.au;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class am<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final b<K, V> f35679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35680a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35680a = iArr;
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35680a[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35680a[WireFormat.FieldType.f35631GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f35681a;

        /* renamed from: b, reason: collision with root package name */
        public final K f35682b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f35683c;

        /* renamed from: d, reason: collision with root package name */
        public final V f35684d;

        public b(WireFormat.FieldType fieldType, K k3, WireFormat.FieldType fieldType2, V v3) {
            this.f35681a = fieldType;
            this.f35682b = k3;
            this.f35683c = fieldType2;
            this.f35684d = v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int b(b<K, V> bVar, K k3, V v3) {
        return z.m(bVar.f35681a, 1, k3) + z.m(bVar.f35683c, 2, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> d(k kVar, b<K, V> bVar, t tVar) throws IOException {
        Object obj = bVar.f35682b;
        Object obj2 = bVar.f35684d;
        while (true) {
            int J = kVar.J();
            if (J == 0) {
                break;
            }
            if (J == WireFormat.c(1, bVar.f35681a.getWireType())) {
                obj = e(kVar, tVar, bVar.f35681a, obj);
            } else if (J == WireFormat.c(2, bVar.f35683c.getWireType())) {
                obj2 = e(kVar, tVar, bVar.f35683c, obj2);
            } else if (!kVar.N(J)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    static <T> T e(k kVar, t tVar, WireFormat.FieldType fieldType, T t16) throws IOException {
        int i3 = a.f35680a[fieldType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return (T) z.L(kVar, fieldType, true);
                }
                throw new RuntimeException("Groups are not allowed in maps.");
            }
            return (T) Integer.valueOf(kVar.s());
        }
        au.a builder = ((au) t16).toBuilder();
        kVar.A(builder, tVar);
        return (T) builder.buildPartial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void f(CodedOutputStream codedOutputStream, b<K, V> bVar, K k3, V v3) throws IOException {
        z.O(codedOutputStream, bVar.f35681a, 1, k3);
        z.O(codedOutputStream, bVar.f35683c, 2, v3);
    }

    public int a(int i3, K k3, V v3) {
        return CodedOutputStream.X(i3) + CodedOutputStream.E(b(this.f35679a, k3, v3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b<K, V> c() {
        return this.f35679a;
    }
}
