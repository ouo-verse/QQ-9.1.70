package com.google.protobuf;

import com.google.protobuf.am;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
class ap implements an {
    private static <K, V> int i(int i3, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        am amVar = (am) obj2;
        int i16 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : mapFieldLite.entrySet()) {
            i16 += amVar.a(i3, entry.getKey(), entry.getValue());
        }
        return i16;
    }

    private static <K, V> MapFieldLite<K, V> j(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj;
        MapFieldLite<K, V> mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable()) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.mergeFrom(mapFieldLite2);
        }
        return mapFieldLite;
    }

    @Override // com.google.protobuf.an
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.an
    public Object b(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.protobuf.an
    public int c(int i3, Object obj, Object obj2) {
        return i(i3, obj, obj2);
    }

    @Override // com.google.protobuf.an
    public boolean d(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }

    @Override // com.google.protobuf.an
    public am.b<?, ?> e(Object obj) {
        return ((am) obj).c();
    }

    @Override // com.google.protobuf.an
    public Object f(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }

    @Override // com.google.protobuf.an
    public Map<?, ?> g(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.protobuf.an
    public Map<?, ?> h(Object obj) {
        return (MapFieldLite) obj;
    }
}
