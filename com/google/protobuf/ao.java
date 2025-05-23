package com.google.protobuf;

import com.google.protobuf.am;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
class ao implements an {
    ao() {
    }

    private static <K, V> int i(int i3, Object obj, Object obj2) {
        int i16 = 0;
        if (obj == null) {
            return 0;
        }
        Map<K, V> j3 = ((MapField) obj).j();
        al alVar = (al) obj2;
        if (j3.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : j3.entrySet()) {
            i16 += CodedOutputStream.X(i3) + CodedOutputStream.E(am.b(alVar.r(), entry.getKey(), entry.getValue()));
        }
        return i16;
    }

    private static <K, V> Object j(Object obj, Object obj2) {
        MapField mapField = (MapField) obj;
        MapField<K, V> mapField2 = (MapField) obj2;
        if (!mapField.n()) {
            mapField.g();
        }
        mapField.p(mapField2);
        return mapField;
    }

    @Override // com.google.protobuf.an
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.an
    public Object b(Object obj) {
        return MapField.q((al) obj);
    }

    @Override // com.google.protobuf.an
    public int c(int i3, Object obj, Object obj2) {
        return i(i3, obj, obj2);
    }

    @Override // com.google.protobuf.an
    public boolean d(Object obj) {
        return !((MapField) obj).n();
    }

    @Override // com.google.protobuf.an
    public am.b<?, ?> e(Object obj) {
        return ((al) obj).r();
    }

    @Override // com.google.protobuf.an
    public Object f(Object obj) {
        ((MapField) obj).o();
        return obj;
    }

    @Override // com.google.protobuf.an
    public Map<?, ?> g(Object obj) {
        return ((MapField) obj).m();
    }

    @Override // com.google.protobuf.an
    public Map<?, ?> h(Object obj) {
        return ((MapField) obj).j();
    }
}
