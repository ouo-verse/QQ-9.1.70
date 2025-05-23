package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.am;
import com.google.protobuf.ar;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class al<K, V> extends com.google.protobuf.a {

    /* renamed from: d, reason: collision with root package name */
    private final K f35667d;

    /* renamed from: e, reason: collision with root package name */
    private final V f35668e;

    /* renamed from: f, reason: collision with root package name */
    private final c<K, V> f35669f;

    /* renamed from: h, reason: collision with root package name */
    private volatile int f35670h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c<K, V> extends am.b<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public final Descriptors.b f35676e;

        /* renamed from: f, reason: collision with root package name */
        public final bg<al<K, V>> f35677f;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<al<K, V>> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public al<K, V> g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new al<>(c.this, kVar, tVar);
            }
        }

        public c(Descriptors.b bVar, al<K, V> alVar, WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2) {
            super(fieldType, ((al) alVar).f35667d, fieldType2, ((al) alVar).f35668e);
            this.f35676e = bVar;
            this.f35677f = new a();
        }
    }

    private void c(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.q() == this.f35669f.f35676e) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.i() + "\" used in message \"" + this.f35669f.f35676e.i());
    }

    private static <V> boolean t(c cVar, V v3) {
        if (cVar.f35683c.getJavaType() == WireFormat.JavaType.MESSAGE) {
            return ((au) v3).isInitialized();
        }
        return true;
    }

    public static <K, V> al<K, V> v(Descriptors.b bVar, WireFormat.FieldType fieldType, K k3, WireFormat.FieldType fieldType2, V v3) {
        return new al<>(bVar, fieldType, k3, fieldType2, v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.ax
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor fieldDescriptor : this.f35669f.f35676e.r()) {
            if (hasField(fieldDescriptor)) {
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
            }
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.google.protobuf.ax
    public Descriptors.b getDescriptorForType() {
        return this.f35669f.f35676e;
    }

    @Override // com.google.protobuf.ax
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        Object s16;
        c(fieldDescriptor);
        if (fieldDescriptor.getNumber() == 1) {
            s16 = q();
        } else {
            s16 = s();
        }
        if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.ENUM) {
            return fieldDescriptor.s().n(((Integer) s16).intValue());
        }
        return s16;
    }

    @Override // com.google.protobuf.au
    public bg<al<K, V>> getParserForType() {
        return this.f35669f.f35677f;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        if (this.f35670h != -1) {
            return this.f35670h;
        }
        int b16 = am.b(this.f35669f, this.f35667d, this.f35668e);
        this.f35670h = b16;
        return b16;
    }

    @Override // com.google.protobuf.ax
    public cc getUnknownFields() {
        return cc.c();
    }

    @Override // com.google.protobuf.ax
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        c(fieldDescriptor);
        return true;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.av
    public boolean isInitialized() {
        return t(this.f35669f, this.f35668e);
    }

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public al<K, V> getDefaultInstanceForType() {
        c<K, V> cVar = this.f35669f;
        return new al<>(cVar, cVar.f35682b, cVar.f35684d);
    }

    public K q() {
        return this.f35667d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c<K, V> r() {
        return this.f35669f;
    }

    public V s() {
        return this.f35668e;
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public b<K, V> newBuilderForType() {
        return new b<>(this.f35669f);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public b<K, V> toBuilder() {
        return new b<>(this.f35669f, this.f35667d, this.f35668e, true, true);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        am.f(codedOutputStream, this.f35669f, this.f35667d, this.f35668e);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K, V> extends a.AbstractC0252a<b<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        private final c<K, V> f35671d;

        /* renamed from: e, reason: collision with root package name */
        private K f35672e;

        /* renamed from: f, reason: collision with root package name */
        private V f35673f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f35674h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f35675i;

        private void d(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == this.f35671d.f35676e) {
                return;
            }
            throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.i() + "\" used in message \"" + this.f35671d.f35676e.i());
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b<K, V> addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public al<K, V> build() {
            al<K, V> buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public al<K, V> buildPartial() {
            return new al<>(this.f35671d, this.f35672e, this.f35673f);
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b<K, V> clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                f();
            } else {
                h();
            }
            return this;
        }

        public b<K, V> f() {
            this.f35672e = this.f35671d.f35682b;
            this.f35674h = false;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : this.f35671d.f35676e.r()) {
                if (hasField(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }

        @Override // com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return this.f35671d.f35676e;
        }

        @Override // com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object l3;
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                l3 = k();
            } else {
                l3 = l();
            }
            if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.ENUM) {
                return fieldDescriptor.s().n(((Integer) l3).intValue());
            }
            return l3;
        }

        @Override // com.google.protobuf.ax
        public cc getUnknownFields() {
            return cc.c();
        }

        public b<K, V> h() {
            this.f35673f = this.f35671d.f35684d;
            this.f35675i = false;
            return this;
        }

        @Override // com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                return this.f35674h;
            }
            return this.f35675i;
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public b<K, V> mo50clone() {
            return new b<>(this.f35671d, this.f35672e, this.f35673f, this.f35674h, this.f35675i);
        }

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public al<K, V> getDefaultInstanceForType() {
            c<K, V> cVar = this.f35671d;
            return new al<>(cVar, cVar.f35682b, cVar.f35684d);
        }

        public K k() {
            return this.f35672e;
        }

        public V l() {
            return this.f35673f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.ar.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b<K, V> setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                n(obj);
            } else {
                if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.ENUM) {
                    obj = Integer.valueOf(((Descriptors.d) obj).getNumber());
                } else if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.MESSAGE && obj != null && !this.f35671d.f35684d.getClass().isInstance(obj)) {
                    obj = ((ar) this.f35671d.f35684d).toBuilder().mergeFrom((ar) obj).build();
                }
                p(obj);
            }
            return this;
        }

        public b<K, V> n(K k3) {
            this.f35672e = k3;
            this.f35674h = true;
            return this;
        }

        @Override // com.google.protobuf.ar.a
        public ar.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 2 && fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return ((ar) this.f35673f).newBuilderForType();
            }
            throw new RuntimeException("\"" + fieldDescriptor.i() + "\" is not a message value field.");
        }

        public b<K, V> p(V v3) {
            this.f35673f = v3;
            this.f35675i = true;
            return this;
        }

        b(c<K, V> cVar) {
            this(cVar, cVar.f35682b, cVar.f35684d, false, false);
        }

        b(c<K, V> cVar, K k3, V v3, boolean z16, boolean z17) {
            this.f35671d = cVar;
            this.f35672e = k3;
            this.f35673f = v3;
            this.f35674h = z16;
            this.f35675i = z17;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b<K, V> setUnknownFields(cc ccVar) {
            return this;
        }
    }

    al(Descriptors.b bVar, WireFormat.FieldType fieldType, K k3, WireFormat.FieldType fieldType2, V v3) {
        this.f35670h = -1;
        this.f35667d = k3;
        this.f35668e = v3;
        this.f35669f = new c<>(bVar, this, fieldType, fieldType2);
    }

    al(c cVar, K k3, V v3) {
        this.f35670h = -1;
        this.f35667d = k3;
        this.f35668e = v3;
        this.f35669f = cVar;
    }

    al(c<K, V> cVar, k kVar, t tVar) throws InvalidProtocolBufferException {
        this.f35670h = -1;
        try {
            this.f35669f = cVar;
            Map.Entry d16 = am.d(kVar, cVar, tVar);
            this.f35667d = (K) d16.getKey();
            this.f35668e = (V) d16.getValue();
        } catch (InvalidProtocolBufferException e16) {
            throw e16.setUnfinishedMessage(this);
        } catch (IOException e17) {
            throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
        }
    }
}
