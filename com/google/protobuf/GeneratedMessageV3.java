package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ae;
import com.google.protobuf.ar;
import com.google.protobuf.au;
import com.google.protobuf.cc;
import com.google.protobuf.p;
import com.google.protobuf.z;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class GeneratedMessageV3 extends com.google.protobuf.a implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected cc unknownFields;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f35508a;

        a(a.b bVar) {
            this.f35508a = bVar;
        }

        @Override // com.google.protobuf.a.b
        public void a() {
            this.f35508a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b<BuilderType extends b<BuilderType>> extends a.AbstractC0252a<BuilderType> {

        /* renamed from: d, reason: collision with root package name */
        private c f35510d;

        /* renamed from: e, reason: collision with root package name */
        private b<BuilderType>.a f35511e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f35512f;

        /* renamed from: h, reason: collision with root package name */
        private cc f35513h;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private class a implements c {
            a() {
            }

            @Override // com.google.protobuf.a.b
            public void a() {
                b.this.onChanged();
            }

            /* synthetic */ a(b bVar, a aVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            this(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> r16 = i().f35516a.r();
            int i3 = 0;
            while (i3 < r16.size()) {
                Descriptors.FieldDescriptor fieldDescriptor = r16.get(i3);
                Descriptors.g p16 = fieldDescriptor.p();
                if (p16 != null) {
                    i3 += p16.q() - 1;
                    if (hasOneof(p16)) {
                        fieldDescriptor = getOneofFieldDescriptor(p16);
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                        i3++;
                    } else {
                        i3++;
                    }
                } else {
                    if (fieldDescriptor.isRepeated()) {
                        List list = (List) getField(fieldDescriptor);
                        if (!list.isEmpty()) {
                            treeMap.put(fieldDescriptor, list);
                        }
                    } else {
                        if (!hasField(fieldDescriptor)) {
                        }
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                    }
                    i3++;
                }
            }
            return treeMap;
        }

        private BuilderType m(cc ccVar) {
            this.f35513h = ccVar;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            i().f(fieldDescriptor).i(this, obj);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType clear() {
            this.f35513h = cc.c();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            i().f(fieldDescriptor).a(this);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        void dispose() {
            this.f35510d = null;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType clearOneof(Descriptors.g gVar) {
            i().g(gVar).a(this);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo50clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.b getDescriptorForType() {
            return i().f35516a;
        }

        @Override // com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object c16 = i().f(fieldDescriptor).c(this);
            if (fieldDescriptor.isRepeated()) {
                return Collections.unmodifiableList((List) c16);
            }
            return c16;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            return i().f(fieldDescriptor).l(this);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
            return i().g(gVar).b(this);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            return i().f(fieldDescriptor).k(this, i3);
        }

        @Override // com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.f35513h;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c h() {
            if (this.f35511e == null) {
                this.f35511e = new a(this, null);
            }
            return this.f35511e;
        }

        @Override // com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return i().f(fieldDescriptor).f(this);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public boolean hasOneof(Descriptors.g gVar) {
            return i().g(gVar).d(this);
        }

        protected abstract e i();

        protected MapField internalGetMapField(int i3) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected MapField internalGetMutableMapField(int i3) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isClean() {
            return this.f35512f;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo52mergeUnknownFields(cc ccVar) {
            return setUnknownFields(cc.h(this.f35513h).p(ccVar).build());
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            i().f(fieldDescriptor).e(this, obj);
            return this;
        }

        @Override // com.google.protobuf.ar.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public BuilderType setUnknownFields(cc ccVar) {
            return m(ccVar);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        protected void markClean() {
            this.f35512f = true;
        }

        @Override // com.google.protobuf.ar.a
        public ar.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return i().f(fieldDescriptor).newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onBuilt() {
            if (this.f35510d != null) {
                markClean();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void onChanged() {
            c cVar;
            if (this.f35512f && (cVar = this.f35510d) != null) {
                cVar.a();
                this.f35512f = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(c cVar) {
            this.f35513h = cc.c();
            this.f35510d = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c extends a.b {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class d<MessageType extends ExtendableMessage, BuilderType extends d<MessageType, BuilderType>> extends b<BuilderType> implements ax {

        /* renamed from: i, reason: collision with root package name */
        private z.b<Descriptors.FieldDescriptor> f35515i;

        /* JADX INFO: Access modifiers changed from: protected */
        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public z<Descriptors.FieldDescriptor> p() {
            z.b<Descriptors.FieldDescriptor> bVar = this.f35515i;
            if (bVar == null) {
                return z.q();
            }
            return bVar.b();
        }

        private void s() {
            if (this.f35515i == null) {
                this.f35515i = z.J();
            }
        }

        private void v(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == getDescriptorForType()) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable();
            z.b<Descriptors.FieldDescriptor> bVar = this.f35515i;
            if (bVar != null) {
                allFieldsMutable.putAll(bVar.e());
            }
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object f16;
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                z.b<Descriptors.FieldDescriptor> bVar = this.f35515i;
                if (bVar == null) {
                    f16 = null;
                } else {
                    f16 = bVar.f(fieldDescriptor);
                }
                if (f16 == null) {
                    if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        return p.e(fieldDescriptor.w());
                    }
                    return fieldDescriptor.r();
                }
                return f16;
            }
            return super.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        public ar.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    s();
                    Object g16 = this.f35515i.g(fieldDescriptor);
                    if (g16 == null) {
                        p.b r16 = p.r(fieldDescriptor.w());
                        this.f35515i.p(fieldDescriptor, r16);
                        onChanged();
                        return r16;
                    }
                    if (g16 instanceof ar.a) {
                        return (ar.a) g16;
                    }
                    if (g16 instanceof ar) {
                        ar.a builder = ((ar) g16).toBuilder();
                        this.f35515i.p(fieldDescriptor, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
            return super.getFieldBuilder(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        public ar.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                s();
                if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    Object h16 = this.f35515i.h(fieldDescriptor, i3);
                    if (h16 instanceof ar.a) {
                        return (ar.a) h16;
                    }
                    if (h16 instanceof ar) {
                        ar.a builder = ((ar) h16).toBuilder();
                        this.f35515i.q(fieldDescriptor, i3, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            return super.getRepeatedFieldBuilder(fieldDescriptor, i3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                z.b<Descriptors.FieldDescriptor> bVar = this.f35515i;
                if (bVar == null) {
                    return false;
                }
                return bVar.i(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        public ar.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                return p.r(fieldDescriptor.w());
            }
            return super.newBuilderForField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                s();
                this.f35515i.a(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderType) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType clear() {
            this.f35515i = null;
            return (BuilderType) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                s();
                this.f35515i.c(fieldDescriptor);
                onChanged();
                return this;
            }
            return (BuilderType) super.clearField(fieldDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void t(ExtendableMessage extendableMessage) {
            if (extendableMessage.extensions != null) {
                s();
                this.f35515i.j(extendableMessage.extensions);
                onChanged();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.z()) {
                v(fieldDescriptor);
                s();
                this.f35515i.p(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderType) super.setField(fieldDescriptor, obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d(c cVar) {
            super(cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static final class f {

        /* renamed from: a, reason: collision with root package name */
        static final f f35573a = new f();

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3() {
        this.unknownFields = cc.c();
    }

    private static <V> void a(CodedOutputStream codedOutputStream, Map<Boolean, V> map, al<Boolean, V> alVar, int i3, boolean z16) throws IOException {
        if (map.containsKey(Boolean.valueOf(z16))) {
            codedOutputStream.K0(i3, alVar.newBuilderForType().n(Boolean.valueOf(z16)).p(map.get(Boolean.valueOf(z16))).build());
        }
    }

    private static <K, V> void b(CodedOutputStream codedOutputStream, Map<K, V> map, al<K, V> alVar, int i3) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            codedOutputStream.K0(i3, alVar.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
        }
    }

    protected static boolean canUseUnsafe() {
        if (ch.H() && ch.I()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(q<MessageType, T> qVar) {
        if (!qVar.a()) {
            return (Extension) qVar;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSize(int i3, Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.V(i3, (String) obj);
        }
        return CodedOutputStream.h(i3, (ByteString) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSizeNoTag(Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.W((String) obj);
        }
        return CodedOutputStream.i((ByteString) obj);
    }

    protected static ad.a emptyBooleanList() {
        return h.n();
    }

    protected static ad.b emptyDoubleList() {
        return o.n();
    }

    protected static ad.f emptyFloatList() {
        return aa.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ad.g emptyIntList() {
        return ac.m();
    }

    protected static ad.i emptyLongList() {
        return aj.n();
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z16) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> r16 = internalGetFieldAccessorTable().f35516a.r();
        int i3 = 0;
        while (i3 < r16.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = r16.get(i3);
            Descriptors.g p16 = fieldDescriptor.p();
            if (p16 != null) {
                i3 += p16.q() - 1;
                if (hasOneof(p16)) {
                    fieldDescriptor = getOneofFieldDescriptor(p16);
                    if (!z16 && fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(fieldDescriptor, getFieldRaw(fieldDescriptor));
                    } else {
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                    }
                    i3++;
                } else {
                    i3++;
                }
            } else {
                if (fieldDescriptor.isRepeated()) {
                    List list = (List) getField(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else {
                    if (!hasField(fieldDescriptor)) {
                    }
                    if (!z16) {
                    }
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
                i3++;
            }
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e16);
        } catch (InvocationTargetException e17) {
            Throwable cause = e17.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$g] */
    public static ad.g mutableCopy(ad.g gVar) {
        int size = gVar.size();
        return gVar.b2(size == 0 ? 10 : size * 2);
    }

    protected static ad.a newBooleanList() {
        return new h();
    }

    protected static ad.b newDoubleList() {
        return new o();
    }

    protected static ad.f newFloatList() {
        return new aa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ad.g newIntList() {
        return new ac();
    }

    protected static ad.i newLongList() {
        return new aj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseDelimitedWithIOException(bg<M> bgVar, InputStream inputStream) throws IOException {
        try {
            return bgVar.h(inputStream);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseWithIOException(bg<M> bgVar, InputStream inputStream) throws IOException {
        try {
            return bgVar.f(inputStream);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static <V> void serializeBooleanMapTo(CodedOutputStream codedOutputStream, MapField<Boolean, V> mapField, al<Boolean, V> alVar, int i3) throws IOException {
        Map<Boolean, V> j3 = mapField.j();
        if (!codedOutputStream.g0()) {
            b(codedOutputStream, j3, alVar, i3);
        } else {
            a(codedOutputStream, j3, alVar, i3, false);
            a(codedOutputStream, j3, alVar, i3, true);
        }
    }

    protected static <V> void serializeIntegerMapTo(CodedOutputStream codedOutputStream, MapField<Integer, V> mapField, al<Integer, V> alVar, int i3) throws IOException {
        Map<Integer, V> j3 = mapField.j();
        if (!codedOutputStream.g0()) {
            b(codedOutputStream, j3, alVar, i3);
            return;
        }
        int size = j3.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = j3.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            iArr[i16] = it.next().intValue();
            i16++;
        }
        Arrays.sort(iArr);
        for (int i17 = 0; i17 < size; i17++) {
            int i18 = iArr[i17];
            codedOutputStream.K0(i3, alVar.newBuilderForType().n(Integer.valueOf(i18)).p(j3.get(Integer.valueOf(i18))).build());
        }
    }

    protected static <V> void serializeLongMapTo(CodedOutputStream codedOutputStream, MapField<Long, V> mapField, al<Long, V> alVar, int i3) throws IOException {
        Map<Long, V> j3 = mapField.j();
        if (!codedOutputStream.g0()) {
            b(codedOutputStream, j3, alVar, i3);
            return;
        }
        int size = j3.size();
        long[] jArr = new long[size];
        Iterator<Long> it = j3.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            jArr[i16] = it.next().longValue();
            i16++;
        }
        Arrays.sort(jArr);
        for (int i17 = 0; i17 < size; i17++) {
            long j16 = jArr[i17];
            codedOutputStream.K0(i3, alVar.newBuilderForType().n(Long.valueOf(j16)).p(j3.get(Long.valueOf(j16))).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <V> void serializeStringMapTo(CodedOutputStream codedOutputStream, MapField<String, V> mapField, al<String, V> alVar, int i3) throws IOException {
        Map<String, V> j3 = mapField.j();
        if (!codedOutputStream.g0()) {
            b(codedOutputStream, j3, alVar, i3);
            return;
        }
        String[] strArr = (String[]) j3.keySet().toArray(new String[j3.size()]);
        Arrays.sort(strArr);
        for (String str : strArr) {
            codedOutputStream.K0(i3, alVar.newBuilderForType().n(str).p(j3.get(str)).build());
        }
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean z16) {
        alwaysUseFieldBuilders = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void writeString(CodedOutputStream codedOutputStream, int i3, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.Y0(i3, (String) obj);
        } else {
            codedOutputStream.q0(i3, (ByteString) obj);
        }
    }

    protected static void writeStringNoTag(CodedOutputStream codedOutputStream, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.Z0((String) obj);
        } else {
            codedOutputStream.r0((ByteString) obj);
        }
    }

    @Override // com.google.protobuf.ax
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    public abstract /* synthetic */ ar getDefaultInstanceForType();

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    public abstract /* synthetic */ au getDefaultInstanceForType();

    @Override // com.google.protobuf.ax
    public Descriptors.b getDescriptorForType() {
        return internalGetFieldAccessorTable().f35516a;
    }

    @Override // com.google.protobuf.ax
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).b(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).j(this);
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
        return internalGetFieldAccessorTable().g(gVar).c(this);
    }

    @Override // com.google.protobuf.au
    public bg<? extends GeneratedMessageV3> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).g(this, i3);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).h(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int e16 = MessageReflection.e(this, getAllFieldsRaw());
        this.memoizedSize = e16;
        return e16;
    }

    public cc getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.ax
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).d(this);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.g gVar) {
        return internalGetFieldAccessorTable().g(gVar).e(this);
    }

    protected abstract e internalGetFieldAccessorTable();

    protected MapField internalGetMapField(int i3) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    @Override // com.google.protobuf.a, com.google.protobuf.av
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().r()) {
            if (fieldDescriptor.E() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    Iterator it = ((List) getField(fieldDescriptor)).iterator();
                    while (it.hasNext()) {
                        if (!((ar) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (hasField(fieldDescriptor) && !((ar) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void mergeFromAndMakeImmutableInternal(k kVar, t tVar) throws InvalidProtocolBufferException {
        bq e16 = bi.a().e(this);
        try {
            e16.i(this, l.g(kVar), tVar);
            e16.g(this);
        } catch (InvalidProtocolBufferException e17) {
            throw e17.setUnfinishedMessage(this);
        } catch (IOException e18) {
            throw new InvalidProtocolBufferException(e18).setUnfinishedMessage(this);
        }
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ ar.a newBuilderForType();

    protected abstract ar.a newBuilderForType(c cVar);

    @Override // com.google.protobuf.a
    protected ar.a newBuilderForType(a.b bVar) {
        return newBuilderForType((c) new a(bVar));
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ au.a newBuilderForType();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object newInstance(f fVar) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseUnknownField(k kVar, cc.b bVar, t tVar, int i3) throws IOException {
        if (kVar.M()) {
            return kVar.N(i3);
        }
        return bVar.k(i3, kVar);
    }

    protected boolean parseUnknownFieldProto3(k kVar, cc.b bVar, t tVar, int i3) throws IOException {
        return parseUnknownField(kVar, bVar, tVar, i3);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ ar.a toBuilder();

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ au.a toBuilder();

    protected Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessageV3 implements ax {
        private static final long serialVersionUID = 1;
        private final z<Descriptors.FieldDescriptor> extensions;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        protected class a {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> f35504a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry<Descriptors.FieldDescriptor, Object> f35505b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f35506c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z16, a aVar) {
                this(z16);
            }

            public void a(int i3, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.f35505b;
                    if (entry != null && entry.getKey().getNumber() < i3) {
                        Descriptors.FieldDescriptor key = this.f35505b.getKey();
                        if (this.f35506c && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                            if (this.f35505b instanceof ae.b) {
                                codedOutputStream.O0(key.getNumber(), ((ae.b) this.f35505b).a().f());
                            } else {
                                codedOutputStream.N0(key.getNumber(), (ar) this.f35505b.getValue());
                            }
                        } else {
                            z.Q(key, this.f35505b.getValue(), codedOutputStream);
                        }
                        if (this.f35504a.hasNext()) {
                            this.f35505b = this.f35504a.next();
                        } else {
                            this.f35505b = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            a(boolean z16) {
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> F = ExtendableMessage.this.extensions.F();
                this.f35504a = F;
                if (F.hasNext()) {
                    this.f35505b = F.next();
                }
                this.f35506c = z16;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage() {
            this.extensions = z.K();
        }

        private void c(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == getDescriptorForType()) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void d(Extension<MessageType, ?> extension) {
            if (extension.c().q() == getDescriptorForType()) {
                return;
            }
            throw new IllegalArgumentException("Extension is for type \"" + extension.c().q().i() + "\" which does not match message type \"" + getDescriptorForType().i() + "\".");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.C();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.x();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.t();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public abstract /* synthetic */ ar getDefaultInstanceForType();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public abstract /* synthetic */ au getDefaultInstanceForType();

        public final <Type> Type getExtension(q<MessageType, Type> qVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(qVar);
            d(checkNotLite);
            Descriptors.FieldDescriptor c16 = checkNotLite.c();
            Object s16 = this.extensions.s(c16);
            if (s16 == null) {
                if (c16.isRepeated()) {
                    return (Type) Collections.emptyList();
                }
                if (c16.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (Type) checkNotLite.d();
                }
                return (Type) checkNotLite.b(c16.r());
            }
            return (Type) checkNotLite.b(s16);
        }

        public final <Type> int getExtensionCount(q<MessageType, List<Type>> qVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(qVar);
            d(checkNotLite);
            return this.extensions.w(checkNotLite.c());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.r();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                c(fieldDescriptor);
                Object s16 = this.extensions.s(fieldDescriptor);
                if (s16 == null) {
                    if (fieldDescriptor.isRepeated()) {
                        return Collections.emptyList();
                    }
                    if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        return p.e(fieldDescriptor.w());
                    }
                    return fieldDescriptor.r();
                }
                return s16;
            }
            return super.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            if (fieldDescriptor.z()) {
                c(fieldDescriptor);
                return this.extensions.v(fieldDescriptor, i3);
            }
            return super.getRepeatedField(fieldDescriptor, i3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                c(fieldDescriptor);
                return this.extensions.w(fieldDescriptor);
            }
            return super.getRepeatedFieldCount(fieldDescriptor);
        }

        public final <Type> boolean hasExtension(q<MessageType, Type> qVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(qVar);
            d(checkNotLite);
            return this.extensions.z(checkNotLite.c());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.z()) {
                c(fieldDescriptor);
                return this.extensions.z(fieldDescriptor);
            }
            return super.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public boolean isInitialized() {
            if (super.isInitialized() && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public void makeExtensionsImmutable() {
            this.extensions.G();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public abstract /* synthetic */ ar.a newBuilderForType();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public abstract /* synthetic */ au.a newBuilderForType();

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        protected ExtendableMessage<MessageType>.a newMessageSetExtensionWriter() {
            return new a(this, true, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public boolean parseUnknownField(k kVar, cc.b bVar, t tVar, int i3) throws IOException {
            if (kVar.M()) {
                bVar = null;
            }
            return MessageReflection.g(kVar, bVar, tVar, getDescriptorForType(), new MessageReflection.c(this.extensions), i3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected boolean parseUnknownFieldProto3(k kVar, cc.b bVar, t tVar, int i3) throws IOException {
            return parseUnknownField(kVar, bVar, tVar, i3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public abstract /* synthetic */ ar.a toBuilder();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public abstract /* synthetic */ au.a toBuilder();

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage(d<MessageType, ?> dVar) {
            super(dVar);
            this.extensions = dVar.p();
        }

        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((q) extension);
        }

        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((q) extension);
        }

        public final <Type> boolean hasExtension(GeneratedMessage.k<MessageType, Type> kVar) {
            return hasExtension((q) kVar);
        }

        public final <Type> int getExtensionCount(GeneratedMessage.k<MessageType, List<Type>> kVar) {
            return getExtensionCount((q) kVar);
        }

        public final <Type> Type getExtension(q<MessageType, List<Type>> qVar, int i3) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(qVar);
            d(checkNotLite);
            return (Type) checkNotLite.e(this.extensions.v(checkNotLite.c(), i3));
        }

        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return (Type) getExtension((q) extension);
        }

        public final <Type> Type getExtension(GeneratedMessage.k<MessageType, Type> kVar) {
            return (Type) getExtension((q) kVar);
        }

        public final <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int i3) {
            return (Type) getExtension((q) extension, i3);
        }

        public final <Type> Type getExtension(GeneratedMessage.k<MessageType, List<Type>> kVar, int i3) {
            return (Type) getExtension((q) kVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3(b<?> bVar) {
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$i] */
    protected static ad.i mutableCopy(ad.i iVar) {
        int size = iVar.size();
        return iVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseDelimitedWithIOException(bg<M> bgVar, InputStream inputStream, t tVar) throws IOException {
        try {
            return bgVar.k(inputStream, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseWithIOException(bg<M> bgVar, InputStream inputStream, t tVar) throws IOException {
        try {
            return bgVar.l(inputStream, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$f] */
    protected static ad.f mutableCopy(ad.f fVar) {
        int size = fVar.size();
        return fVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseWithIOException(bg<M> bgVar, k kVar) throws IOException {
        try {
            return bgVar.c(kVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$b] */
    protected static ad.b mutableCopy(ad.b bVar) {
        int size = bVar.size();
        return bVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends ar> M parseWithIOException(bg<M> bgVar, k kVar, t tVar) throws IOException {
        try {
            return bgVar.e(kVar, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$a] */
    protected static ad.a mutableCopy(ad.a aVar) {
        int size = aVar.size();
        return aVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.b f35516a;

        /* renamed from: b, reason: collision with root package name */
        private final a[] f35517b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f35518c;

        /* renamed from: d, reason: collision with root package name */
        private final c[] f35519d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f35520e = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public interface a {
            void a(b bVar);

            Object b(GeneratedMessageV3 generatedMessageV3);

            Object c(b bVar);

            boolean d(GeneratedMessageV3 generatedMessageV3);

            void e(b bVar, Object obj);

            boolean f(b bVar);

            Object g(GeneratedMessageV3 generatedMessageV3, int i3);

            int h(GeneratedMessageV3 generatedMessageV3);

            void i(b bVar, Object obj);

            Object j(GeneratedMessageV3 generatedMessageV3);

            ar.a k(b bVar, int i3);

            ar.a l(b bVar);

            ar.a newBuilder();
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class b implements a {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.FieldDescriptor f35521a;

            /* renamed from: b, reason: collision with root package name */
            private final ar f35522b;

            b(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                this.f35521a = fieldDescriptor;
                this.f35522b = o((GeneratedMessageV3) GeneratedMessageV3.invokeOrDie(GeneratedMessageV3.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).k();
            }

            private ar m(ar arVar) {
                if (arVar == null) {
                    return null;
                }
                if (this.f35522b.getClass().isInstance(arVar)) {
                    return arVar;
                }
                return this.f35522b.toBuilder().mergeFrom(arVar).build();
            }

            private MapField<?, ?> n(b bVar) {
                return bVar.internalGetMapField(this.f35521a.getNumber());
            }

            private MapField<?, ?> o(GeneratedMessageV3 generatedMessageV3) {
                return generatedMessageV3.internalGetMapField(this.f35521a.getNumber());
            }

            private MapField<?, ?> p(b bVar) {
                return bVar.internalGetMutableMapField(this.f35521a.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar) {
                p(bVar).l().clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < h(generatedMessageV3); i3++) {
                    arrayList.add(g(generatedMessageV3, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object c(b bVar) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < r(bVar); i3++) {
                    arrayList.add(q(bVar, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean d(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                a(bVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i(bVar, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean f(b bVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object g(GeneratedMessageV3 generatedMessageV3, int i3) {
                return o(generatedMessageV3).i().get(i3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int h(GeneratedMessageV3 generatedMessageV3) {
                return o(generatedMessageV3).i().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void i(b bVar, Object obj) {
                p(bVar).l().add(m((ar) obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object j(GeneratedMessageV3 generatedMessageV3) {
                return b(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a k(b bVar, int i3) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a l(b bVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a newBuilder() {
                return this.f35522b.newBuilderForType();
            }

            public Object q(b bVar, int i3) {
                return n(bVar).i().get(i3);
            }

            public int r(b bVar) {
                return n(bVar).i().size();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.b f35523a;

            /* renamed from: b, reason: collision with root package name */
            private final Method f35524b;

            /* renamed from: c, reason: collision with root package name */
            private final Method f35525c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f35526d;

            c(Descriptors.b bVar, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                this.f35523a = bVar;
                this.f35524b = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Case", new Class[0]);
                this.f35525c = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Case", new Class[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(QCircleLpReportDc05507.KEY_CLEAR);
                sb5.append(str);
                this.f35526d = GeneratedMessageV3.getMethodOrDie(cls2, sb5.toString(), new Class[0]);
            }

            public void a(b bVar) {
                GeneratedMessageV3.invokeOrDie(this.f35526d, bVar, new Object[0]);
            }

            public Descriptors.FieldDescriptor b(b bVar) {
                int number = ((ad.c) GeneratedMessageV3.invokeOrDie(this.f35525c, bVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f35523a.o(number);
                }
                return null;
            }

            public Descriptors.FieldDescriptor c(GeneratedMessageV3 generatedMessageV3) {
                int number = ((ad.c) GeneratedMessageV3.invokeOrDie(this.f35524b, generatedMessageV3, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f35523a.o(number);
                }
                return null;
            }

            public boolean d(b bVar) {
                if (((ad.c) GeneratedMessageV3.invokeOrDie(this.f35525c, bVar, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public boolean e(GeneratedMessageV3 generatedMessageV3) {
                if (((ad.c) GeneratedMessageV3.invokeOrDie(this.f35524b, generatedMessageV3, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static final class d extends C0250e {

            /* renamed from: c, reason: collision with root package name */
            private Descriptors.c f35527c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f35528d;

            /* renamed from: e, reason: collision with root package name */
            private final Method f35529e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f35530f;

            /* renamed from: g, reason: collision with root package name */
            private Method f35531g;

            /* renamed from: h, reason: collision with root package name */
            private Method f35532h;

            /* renamed from: i, reason: collision with root package name */
            private Method f35533i;

            /* renamed from: j, reason: collision with root package name */
            private Method f35534j;

            d(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f35527c = fieldDescriptor.s();
                this.f35528d = GeneratedMessageV3.getMethodOrDie(this.f35535a, "valueOf", Descriptors.d.class);
                this.f35529e = GeneratedMessageV3.getMethodOrDie(this.f35535a, "getValueDescriptor", new Class[0]);
                boolean z16 = fieldDescriptor.h().z();
                this.f35530f = z16;
                if (z16) {
                    Class cls3 = Integer.TYPE;
                    this.f35531g = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", cls3);
                    this.f35532h = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", cls3);
                    this.f35533i = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", cls3, cls3);
                    this.f35534j = GeneratedMessageV3.getMethodOrDie(cls2, "add" + str + "Value", cls3);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                int h16 = h(generatedMessageV3);
                for (int i3 = 0; i3 < h16; i3++) {
                    arrayList.add(g(generatedMessageV3, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object c(b bVar) {
                ArrayList arrayList = new ArrayList();
                int o16 = o(bVar);
                for (int i3 = 0; i3 < o16; i3++) {
                    arrayList.add(n(bVar, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object g(GeneratedMessageV3 generatedMessageV3, int i3) {
                if (!this.f35530f) {
                    return GeneratedMessageV3.invokeOrDie(this.f35529e, super.g(generatedMessageV3, i3), new Object[0]);
                }
                return this.f35527c.n(((Integer) GeneratedMessageV3.invokeOrDie(this.f35531g, generatedMessageV3, Integer.valueOf(i3))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public void i(b bVar, Object obj) {
                if (this.f35530f) {
                    GeneratedMessageV3.invokeOrDie(this.f35534j, bVar, Integer.valueOf(((Descriptors.d) obj).getNumber()));
                } else {
                    super.i(bVar, GeneratedMessageV3.invokeOrDie(this.f35528d, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e
            public Object n(b bVar, int i3) {
                if (!this.f35530f) {
                    return GeneratedMessageV3.invokeOrDie(this.f35529e, super.n(bVar, i3), new Object[0]);
                }
                return this.f35527c.n(((Integer) GeneratedMessageV3.invokeOrDie(this.f35532h, bVar, Integer.valueOf(i3))).intValue());
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static final class f extends C0250e {

            /* renamed from: c, reason: collision with root package name */
            private final Method f35546c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f35547d;

            f(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f35546c = GeneratedMessageV3.getMethodOrDie(this.f35535a, "newBuilder", new Class[0]);
                this.f35547d = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object p(Object obj) {
                if (this.f35535a.isInstance(obj)) {
                    return obj;
                }
                return ((ar.a) GeneratedMessageV3.invokeOrDie(this.f35546c, null, new Object[0])).mergeFrom((ar) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public void i(b bVar, Object obj) {
                super.i(bVar, p(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a k(b bVar, int i3) {
                return (ar.a) GeneratedMessageV3.invokeOrDie(this.f35547d, bVar, Integer.valueOf(i3));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e, com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a newBuilder() {
                return (ar.a) GeneratedMessageV3.invokeOrDie(this.f35546c, null, new Object[0]);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static final class g extends h {

            /* renamed from: f, reason: collision with root package name */
            private Descriptors.c f35548f;

            /* renamed from: g, reason: collision with root package name */
            private Method f35549g;

            /* renamed from: h, reason: collision with root package name */
            private Method f35550h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f35551i;

            /* renamed from: j, reason: collision with root package name */
            private Method f35552j;

            /* renamed from: k, reason: collision with root package name */
            private Method f35553k;

            /* renamed from: l, reason: collision with root package name */
            private Method f35554l;

            g(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35548f = fieldDescriptor.s();
                this.f35549g = GeneratedMessageV3.getMethodOrDie(this.f35555a, "valueOf", Descriptors.d.class);
                this.f35550h = GeneratedMessageV3.getMethodOrDie(this.f35555a, "getValueDescriptor", new Class[0]);
                boolean z16 = fieldDescriptor.h().z();
                this.f35551i = z16;
                if (z16) {
                    this.f35552j = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", new Class[0]);
                    this.f35553k = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", new Class[0]);
                    this.f35554l = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                if (!this.f35551i) {
                    return GeneratedMessageV3.invokeOrDie(this.f35550h, super.b(generatedMessageV3), new Object[0]);
                }
                return this.f35548f.n(((Integer) GeneratedMessageV3.invokeOrDie(this.f35552j, generatedMessageV3, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object c(b bVar) {
                if (!this.f35551i) {
                    return GeneratedMessageV3.invokeOrDie(this.f35550h, super.c(bVar), new Object[0]);
                }
                return this.f35548f.n(((Integer) GeneratedMessageV3.invokeOrDie(this.f35553k, bVar, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                if (this.f35551i) {
                    GeneratedMessageV3.invokeOrDie(this.f35554l, bVar, Integer.valueOf(((Descriptors.d) obj).getNumber()));
                } else {
                    super.e(bVar, GeneratedMessageV3.invokeOrDie(this.f35549g, null, obj));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static final class i extends h {

            /* renamed from: f, reason: collision with root package name */
            private final Method f35568f;

            /* renamed from: g, reason: collision with root package name */
            private final Method f35569g;

            i(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35568f = GeneratedMessageV3.getMethodOrDie(this.f35555a, "newBuilder", new Class[0]);
                this.f35569g = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object n(Object obj) {
                if (this.f35555a.isInstance(obj)) {
                    return obj;
                }
                return ((ar.a) GeneratedMessageV3.invokeOrDie(this.f35568f, null, new Object[0])).mergeFrom((ar) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                super.e(bVar, n(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a l(b bVar) {
                return (ar.a) GeneratedMessageV3.invokeOrDie(this.f35569g, bVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a newBuilder() {
                return (ar.a) GeneratedMessageV3.invokeOrDie(this.f35568f, null, new Object[0]);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static final class j extends h {

            /* renamed from: f, reason: collision with root package name */
            private final Method f35570f;

            /* renamed from: g, reason: collision with root package name */
            private final Method f35571g;

            /* renamed from: h, reason: collision with root package name */
            private final Method f35572h;

            j(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35570f = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Bytes", new Class[0]);
                this.f35571g = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Bytes", new Class[0]);
                this.f35572h = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Bytes", ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessageV3.invokeOrDie(this.f35572h, bVar, obj);
                } else {
                    super.e(bVar, obj);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object j(GeneratedMessageV3 generatedMessageV3) {
                return GeneratedMessageV3.invokeOrDie(this.f35570f, generatedMessageV3, new Object[0]);
            }
        }

        public e(Descriptors.b bVar, String[] strArr) {
            this.f35516a = bVar;
            this.f35518c = strArr;
            this.f35517b = new a[bVar.r().size()];
            this.f35519d = new c[bVar.t().size()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a f(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == this.f35516a) {
                if (!fieldDescriptor.z()) {
                    return this.f35517b[fieldDescriptor.u()];
                }
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c g(Descriptors.g gVar) {
            if (gVar.p() == this.f35516a) {
                return this.f35519d[gVar.r()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean h(Descriptors.FileDescriptor fileDescriptor) {
            if (fileDescriptor.t() == Descriptors.FileDescriptor.Syntax.PROTO2) {
                return true;
            }
            return false;
        }

        public e e(Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
            if (this.f35520e) {
                return this;
            }
            synchronized (this) {
                if (this.f35520e) {
                    return this;
                }
                int length = this.f35517b.length;
                int i3 = 0;
                while (true) {
                    String str = null;
                    if (i3 >= length) {
                        break;
                    }
                    Descriptors.FieldDescriptor fieldDescriptor = this.f35516a.r().get(i3);
                    if (fieldDescriptor.p() != null) {
                        str = this.f35518c[fieldDescriptor.p().r() + length];
                    }
                    String str2 = str;
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (fieldDescriptor.A()) {
                                this.f35517b[i3] = new b(fieldDescriptor, this.f35518c[i3], cls, cls2);
                            } else {
                                this.f35517b[i3] = new f(fieldDescriptor, this.f35518c[i3], cls, cls2);
                            }
                        } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.f35517b[i3] = new d(fieldDescriptor, this.f35518c[i3], cls, cls2);
                        } else {
                            this.f35517b[i3] = new C0250e(fieldDescriptor, this.f35518c[i3], cls, cls2);
                        }
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.f35517b[i3] = new i(fieldDescriptor, this.f35518c[i3], cls, cls2, str2);
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.f35517b[i3] = new g(fieldDescriptor, this.f35518c[i3], cls, cls2, str2);
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.f35517b[i3] = new j(fieldDescriptor, this.f35518c[i3], cls, cls2, str2);
                    } else {
                        this.f35517b[i3] = new h(fieldDescriptor, this.f35518c[i3], cls, cls2, str2);
                    }
                    i3++;
                }
                int length2 = this.f35519d.length;
                for (int i16 = 0; i16 < length2; i16++) {
                    this.f35519d[i16] = new c(this.f35516a, this.f35518c[i16 + length], cls, cls2);
                }
                this.f35520e = true;
                this.f35518c = null;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.google.protobuf.GeneratedMessageV3$e$e, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0250e implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class f35535a;

            /* renamed from: b, reason: collision with root package name */
            protected final a f35536b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.google.protobuf.GeneratedMessageV3$e$e$a */
            /* loaded from: classes2.dex */
            public interface a {
                void a(b<?> bVar);

                Object b(GeneratedMessageV3 generatedMessageV3);

                Object c(b<?> bVar);

                Object d(b<?> bVar, int i3);

                int e(b<?> bVar);

                Object g(GeneratedMessageV3 generatedMessageV3, int i3);

                int h(GeneratedMessageV3 generatedMessageV3);

                void i(b<?> bVar, Object obj);
            }

            /* compiled from: P */
            /* renamed from: com.google.protobuf.GeneratedMessageV3$e$e$b */
            /* loaded from: classes2.dex */
            private static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f35537a;

                /* renamed from: b, reason: collision with root package name */
                protected final Method f35538b;

                /* renamed from: c, reason: collision with root package name */
                protected final Method f35539c;

                /* renamed from: d, reason: collision with root package name */
                protected final Method f35540d;

                /* renamed from: e, reason: collision with root package name */
                protected final Method f35541e;

                /* renamed from: f, reason: collision with root package name */
                protected final Method f35542f;

                /* renamed from: g, reason: collision with root package name */
                protected final Method f35543g;

                /* renamed from: h, reason: collision with root package name */
                protected final Method f35544h;

                /* renamed from: i, reason: collision with root package name */
                protected final Method f35545i;

                b(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                    this.f35537a = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "List", new Class[0]);
                    this.f35538b = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "List", new Class[0]);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("get");
                    sb5.append(str);
                    String sb6 = sb5.toString();
                    Class cls3 = Integer.TYPE;
                    Method methodOrDie = GeneratedMessageV3.getMethodOrDie(cls, sb6, cls3);
                    this.f35539c = methodOrDie;
                    this.f35540d = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, cls3);
                    Class<?> returnType = methodOrDie.getReturnType();
                    this.f35541e = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, cls3, returnType);
                    this.f35542f = GeneratedMessageV3.getMethodOrDie(cls2, "add" + str, returnType);
                    this.f35543g = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Count", new Class[0]);
                    this.f35544h = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Count", new Class[0]);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(QCircleLpReportDc05507.KEY_CLEAR);
                    sb7.append(str);
                    this.f35545i = GeneratedMessageV3.getMethodOrDie(cls2, sb7.toString(), new Class[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public void a(b<?> bVar) {
                    GeneratedMessageV3.invokeOrDie(this.f35545i, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public Object b(GeneratedMessageV3 generatedMessageV3) {
                    return GeneratedMessageV3.invokeOrDie(this.f35537a, generatedMessageV3, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public Object c(b<?> bVar) {
                    return GeneratedMessageV3.invokeOrDie(this.f35538b, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public Object d(b<?> bVar, int i3) {
                    return GeneratedMessageV3.invokeOrDie(this.f35540d, bVar, Integer.valueOf(i3));
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public int e(b<?> bVar) {
                    return ((Integer) GeneratedMessageV3.invokeOrDie(this.f35544h, bVar, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public Object g(GeneratedMessageV3 generatedMessageV3, int i3) {
                    return GeneratedMessageV3.invokeOrDie(this.f35539c, generatedMessageV3, Integer.valueOf(i3));
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public int h(GeneratedMessageV3 generatedMessageV3) {
                    return ((Integer) GeneratedMessageV3.invokeOrDie(this.f35543g, generatedMessageV3, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.C0250e.a
                public void i(b<?> bVar, Object obj) {
                    GeneratedMessageV3.invokeOrDie(this.f35542f, bVar, obj);
                }
            }

            C0250e(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                b bVar = new b(fieldDescriptor, str, cls, cls2);
                this.f35535a = bVar.f35539c.getReturnType();
                this.f35536b = m(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar) {
                this.f35536b.a(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                return this.f35536b.b(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object c(b bVar) {
                return this.f35536b.c(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean d(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                a(bVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i(bVar, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean f(b bVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object g(GeneratedMessageV3 generatedMessageV3, int i3) {
                return this.f35536b.g(generatedMessageV3, i3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int h(GeneratedMessageV3 generatedMessageV3) {
                return this.f35536b.h(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void i(b bVar, Object obj) {
                this.f35536b.i(bVar, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object j(GeneratedMessageV3 generatedMessageV3) {
                return b(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a k(b bVar, int i3) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a l(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            public Object n(b bVar, int i3) {
                return this.f35536b.d(bVar, i3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            public int o(b bVar) {
                return this.f35536b.e(bVar);
            }

            static a m(b bVar) {
                return bVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class h implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class<?> f35555a;

            /* renamed from: b, reason: collision with root package name */
            protected final Descriptors.FieldDescriptor f35556b;

            /* renamed from: c, reason: collision with root package name */
            protected final boolean f35557c;

            /* renamed from: d, reason: collision with root package name */
            protected final boolean f35558d;

            /* renamed from: e, reason: collision with root package name */
            protected final a f35559e;

            /* JADX INFO: Access modifiers changed from: private */
            /* compiled from: P */
            /* loaded from: classes2.dex */
            public interface a {
                void a(b<?> bVar);

                Object b(GeneratedMessageV3 generatedMessageV3);

                Object c(b<?> bVar);

                boolean d(GeneratedMessageV3 generatedMessageV3);

                void e(b<?> bVar, Object obj);

                boolean f(b<?> bVar);

                int g(GeneratedMessageV3 generatedMessageV3);

                int h(b<?> bVar);
            }

            /* compiled from: P */
            /* loaded from: classes2.dex */
            private static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f35560a;

                /* renamed from: b, reason: collision with root package name */
                protected final Method f35561b;

                /* renamed from: c, reason: collision with root package name */
                protected final Method f35562c;

                /* renamed from: d, reason: collision with root package name */
                protected final Method f35563d;

                /* renamed from: e, reason: collision with root package name */
                protected final Method f35564e;

                /* renamed from: f, reason: collision with root package name */
                protected final Method f35565f;

                /* renamed from: g, reason: collision with root package name */
                protected final Method f35566g;

                /* renamed from: h, reason: collision with root package name */
                protected final Method f35567h;

                b(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2, boolean z16, boolean z17) {
                    Method method;
                    Method method2;
                    Method method3;
                    Method methodOrDie = GeneratedMessageV3.getMethodOrDie(cls, "get" + str, new Class[0]);
                    this.f35560a = methodOrDie;
                    this.f35561b = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, new Class[0]);
                    this.f35562c = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, methodOrDie.getReturnType());
                    Method method4 = null;
                    if (z17) {
                        method = GeneratedMessageV3.getMethodOrDie(cls, "has" + str, new Class[0]);
                    } else {
                        method = null;
                    }
                    this.f35563d = method;
                    if (z17) {
                        method2 = GeneratedMessageV3.getMethodOrDie(cls2, "has" + str, new Class[0]);
                    } else {
                        method2 = null;
                    }
                    this.f35564e = method2;
                    this.f35565f = GeneratedMessageV3.getMethodOrDie(cls2, QCircleLpReportDc05507.KEY_CLEAR + str, new Class[0]);
                    if (z16) {
                        method3 = GeneratedMessageV3.getMethodOrDie(cls, "get" + str2 + "Case", new Class[0]);
                    } else {
                        method3 = null;
                    }
                    this.f35566g = method3;
                    if (z16) {
                        method4 = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str2 + "Case", new Class[0]);
                    }
                    this.f35567h = method4;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public void a(b<?> bVar) {
                    GeneratedMessageV3.invokeOrDie(this.f35565f, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public Object b(GeneratedMessageV3 generatedMessageV3) {
                    return GeneratedMessageV3.invokeOrDie(this.f35560a, generatedMessageV3, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public Object c(b<?> bVar) {
                    return GeneratedMessageV3.invokeOrDie(this.f35561b, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public boolean d(GeneratedMessageV3 generatedMessageV3) {
                    return ((Boolean) GeneratedMessageV3.invokeOrDie(this.f35563d, generatedMessageV3, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public void e(b<?> bVar, Object obj) {
                    GeneratedMessageV3.invokeOrDie(this.f35562c, bVar, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public boolean f(b<?> bVar) {
                    return ((Boolean) GeneratedMessageV3.invokeOrDie(this.f35564e, bVar, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public int g(GeneratedMessageV3 generatedMessageV3) {
                    return ((ad.c) GeneratedMessageV3.invokeOrDie(this.f35566g, generatedMessageV3, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.e.h.a
                public int h(b<?> bVar) {
                    return ((ad.c) GeneratedMessageV3.invokeOrDie(this.f35567h, bVar, new Object[0])).getNumber();
                }
            }

            h(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                boolean z16;
                boolean z17;
                if (fieldDescriptor.p() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f35557c = z16;
                if (!e.h(fieldDescriptor.h()) && (z16 || fieldDescriptor.v() != Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                this.f35558d = z17;
                b bVar = new b(fieldDescriptor, str, cls, cls2, str2, z16, z17);
                this.f35556b = fieldDescriptor;
                this.f35555a = bVar.f35560a.getReturnType();
                this.f35559e = m(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar) {
                this.f35559e.a(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                return this.f35559e.b(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object c(b bVar) {
                return this.f35559e.c(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean d(GeneratedMessageV3 generatedMessageV3) {
                if (!this.f35558d) {
                    if (this.f35557c) {
                        if (this.f35559e.g(generatedMessageV3) == this.f35556b.getNumber()) {
                            return true;
                        }
                        return false;
                    }
                    return !b(generatedMessageV3).equals(this.f35556b.r());
                }
                return this.f35559e.d(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void e(b bVar, Object obj) {
                this.f35559e.e(bVar, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean f(b bVar) {
                if (!this.f35558d) {
                    if (this.f35557c) {
                        if (this.f35559e.h(bVar) == this.f35556b.getNumber()) {
                            return true;
                        }
                        return false;
                    }
                    return !c(bVar).equals(this.f35556b.r());
                }
                return this.f35559e.f(bVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object g(GeneratedMessageV3 generatedMessageV3, int i3) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int h(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void i(b bVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object j(GeneratedMessageV3 generatedMessageV3) {
                return b(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a k(b bVar, int i3) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a l(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public ar.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            static a m(b bVar) {
                return bVar;
            }
        }
    }
}
