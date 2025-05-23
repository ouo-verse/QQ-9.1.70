package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.WireFormat;
import com.google.protobuf.ad;
import com.google.protobuf.au;
import com.google.protobuf.b;
import com.google.protobuf.f;
import com.google.protobuf.z;
import com.huawei.agconnect.config.impl.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.protobuf.b<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected cd unknownFields = cd.e();
    protected int memoizedSerializedSize = -1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(au auVar) {
            Class<?> cls = auVar.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = auVar.toByteArray();
        }

        @Deprecated
        private Object a() throws ObjectStreamException {
            try {
                Field declaredField = b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((au) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e16) {
                throw new RuntimeException("Unable to understand proto buffer", e16);
            } catch (ClassNotFoundException e17) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e17);
            } catch (IllegalAccessException e18) {
                throw new RuntimeException("Unable to call parsePartialFrom", e18);
            } catch (NoSuchFieldException e19) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e19);
            } catch (SecurityException e26) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e26);
            }
        }

        private Class<?> b() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            if (cls == null) {
                return Class.forName(this.messageClassName);
            }
            return cls;
        }

        public static SerializedForm of(au auVar) {
            return new SerializedForm(auVar);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = b().getDeclaredField(Utils.DEFAULT_NAME);
                declaredField.setAccessible(true);
                return ((au) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e16) {
                throw new RuntimeException("Unable to understand proto buffer", e16);
            } catch (ClassNotFoundException e17) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e17);
            } catch (IllegalAccessException e18) {
                throw new RuntimeException("Unable to call parsePartialFrom", e18);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e19) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e19);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b.a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            bi.a().e(messagetype).a(messagetype, messagetype2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        protected void copyOnWriteInternal() {
            MessageType messagetype = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            mergeFromInstance(messagetype, this.instance);
            this.instance = messagetype;
        }

        @Override // com.google.protobuf.av
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw b.a.newUninitializedMessageException(buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        /* renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final BuilderType m57clear() {
            this.instance = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.b.a
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((a<MessageType, BuilderType>) messagetype);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo50clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo59mergeFrom(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                bi.a().e(this.instance).f(this.instance, bArr, i3, i3 + i16, new f.b(tVar));
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e17);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo58mergeFrom(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
            return mo59mergeFrom(bArr, i3, i16, t.b());
        }

        @Override // com.google.protobuf.b.a, com.google.protobuf.au.a
        public BuilderType mergeFrom(k kVar, t tVar) throws IOException {
            copyOnWrite();
            try {
                bi.a().e(this.instance).i(this.instance, l.g(kVar), tVar);
                return this;
            } catch (RuntimeException e16) {
                if (e16.getCause() instanceof IOException) {
                    throw ((IOException) e16.getCause());
                }
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static class b<T extends GeneratedMessageLite<T, ?>> extends com.google.protobuf.c<T> {

        /* renamed from: b, reason: collision with root package name */
        private final T f35493b;

        public b(T t16) {
            this.f35493b = t16;
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public T g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.f35493b, kVar, tVar);
        }

        @Override // com.google.protobuf.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public T F(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.f35493b, bArr, i3, i16, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements av {

        /* renamed from: d, reason: collision with root package name */
        protected z<d> f35494d = z.q();

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.av, com.google.protobuf.ax
        public /* bridge */ /* synthetic */ au getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.au, com.google.protobuf.ar
        public /* bridge */ /* synthetic */ au.a newBuilderForType() {
            return super.newBuilderForType();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public z<d> p() {
            if (this.f35494d.B()) {
                this.f35494d = this.f35494d.clone();
            }
            return this.f35494d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.au, com.google.protobuf.ar
        public /* bridge */ /* synthetic */ au.a toBuilder() {
            return super.toBuilder();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d implements z.c<d> {

        /* renamed from: d, reason: collision with root package name */
        final ad.d<?> f35495d;

        /* renamed from: e, reason: collision with root package name */
        final int f35496e;

        /* renamed from: f, reason: collision with root package name */
        final WireFormat.FieldType f35497f;

        /* renamed from: h, reason: collision with root package name */
        final boolean f35498h;

        /* renamed from: i, reason: collision with root package name */
        final boolean f35499i;

        d(ad.d<?> dVar, int i3, WireFormat.FieldType fieldType, boolean z16, boolean z17) {
            this.f35495d = dVar;
            this.f35496e = i3;
            this.f35497f = fieldType;
            this.f35498h = z16;
            this.f35499i = z17;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.z.c
        public au.a a(au.a aVar, au auVar) {
            return ((a) aVar).mergeFrom((a) auVar);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f35496e - dVar.f35496e;
        }

        @Override // com.google.protobuf.z.c
        public WireFormat.JavaType getLiteJavaType() {
            return this.f35497f.getJavaType();
        }

        @Override // com.google.protobuf.z.c
        public WireFormat.FieldType getLiteType() {
            return this.f35497f;
        }

        @Override // com.google.protobuf.z.c
        public int getNumber() {
            return this.f35496e;
        }

        public ad.d<?> h() {
            return this.f35495d;
        }

        @Override // com.google.protobuf.z.c
        public boolean isPacked() {
            return this.f35499i;
        }

        @Override // com.google.protobuf.z.c
        public boolean isRepeated() {
            return this.f35498h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e<ContainingType extends au, Type> extends q<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        final ContainingType f35500a;

        /* renamed from: b, reason: collision with root package name */
        final Type f35501b;

        /* renamed from: c, reason: collision with root package name */
        final au f35502c;

        /* renamed from: d, reason: collision with root package name */
        final d f35503d;

        e(ContainingType containingtype, Type type, au auVar, d dVar, Class cls) {
            if (containingtype != null) {
                if (dVar.getLiteType() == WireFormat.FieldType.MESSAGE && auVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f35500a = containingtype;
                this.f35501b = type;
                this.f35502c = auVar;
                this.f35503d = dVar;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public WireFormat.FieldType b() {
            return this.f35503d.getLiteType();
        }

        public au c() {
            return this.f35502c;
        }

        public int d() {
            return this.f35503d.getNumber();
        }

        public boolean e() {
            return this.f35503d.f35498h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType, T> e<MessageType, T> checkIsLite(q<MessageType, T> qVar) {
        if (qVar.a()) {
            return (e) qVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t16) throws InvalidProtocolBufferException {
        if (t16 != null && !t16.isInitialized()) {
            throw t16.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t16);
        }
        return t16;
    }

    protected static ad.a emptyBooleanList() {
        return h.n();
    }

    protected static ad.b emptyDoubleList() {
        return o.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ad.f emptyFloatList() {
        return aa.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ad.g emptyIntList() {
        return ac.m();
    }

    protected static ad.i emptyLongList() {
        return aj.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> ad.j<E> emptyProtobufList() {
        return bj.h();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == cd.e()) {
            this.unknownFields = cd.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e16) {
                throw new IllegalStateException("Class initialization cannot fail.", e16);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) ch.j(cls)).getDefaultInstanceForType();
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) generatedMessageLite;
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(au auVar, String str, Object[] objArr) {
        return new bm(auVar, str, objArr);
    }

    public static <ContainingType extends au, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, au auVar, ad.d<?> dVar, int i3, WireFormat.FieldType fieldType, boolean z16, Class cls) {
        return new e<>(containingtype, Collections.emptyList(), auVar, new d(dVar, i3, fieldType, true, z16), cls);
    }

    public static <ContainingType extends au, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, au auVar, ad.d<?> dVar, int i3, WireFormat.FieldType fieldType, Class cls) {
        return new e<>(containingtype, type, auVar, new d(dVar, i3, fieldType, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t16, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t16, inputStream, t.b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t16, k.i(byteBuffer), tVar));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t16, InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            k g16 = k.g(new b.a.C0253a(inputStream, k.C(read, inputStream)));
            T t17 = (T) parsePartialFrom(t16, g16, tVar);
            try {
                g16.a(0);
                return t17;
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(t17);
            }
        } catch (IOException e17) {
            throw new InvalidProtocolBufferException(e17.getMessage());
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t16, k kVar, t tVar) throws InvalidProtocolBufferException {
        T t17 = (T) t16.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            bq e16 = bi.a().e(t17);
            e16.i(t17, l.g(kVar), tVar);
            e16.g(t17);
            return t17;
        } catch (IOException e17) {
            if (e17.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e17.getCause());
            }
            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(t17);
        } catch (RuntimeException e18) {
            if (e18.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e18.getCause());
            }
            throw e18;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t16) {
        defaultInstanceMap.put(cls, t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return bi.a().e(this).d(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.protobuf.b
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    @Override // com.google.protobuf.au
    public final bg<MessageType> getParserForType() {
        return (bg) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.protobuf.au
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = bi.a().e(this).h(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i3 = this.memoizedHashCode;
        if (i3 != 0) {
            return i3;
        }
        int c16 = bi.a().e(this).c(this);
        this.memoizedHashCode = c16;
        return c16;
    }

    @Override // com.google.protobuf.av
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    protected void makeImmutable() {
        bi.a().e(this).g(this);
    }

    protected void mergeLengthDelimitedField(int i3, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.m(i3, byteString);
    }

    protected final void mergeUnknownFields(cd cdVar) {
        this.unknownFields = cd.o(this.unknownFields, cdVar);
    }

    protected void mergeVarintField(int i3, int i16) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.n(i3, i16);
    }

    protected boolean parseUnknownField(int i3, k kVar) throws IOException {
        if (WireFormat.b(i3) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.k(i3, kVar);
    }

    @Override // com.google.protobuf.b
    void setMemoizedSerializedSize(int i3) {
        this.memoizedSerializedSize = i3;
    }

    public String toString() {
        return aw.e(this, super.toString());
    }

    @Override // com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        bi.a().e(this).e(this, m.T(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t16, boolean z16) {
        byte byteValue = ((Byte) t16.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b16 = bi.a().e(t16).b(t16);
        if (z16) {
            t16.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, b16 ? t16 : null);
        }
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // com.google.protobuf.av, com.google.protobuf.ax
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$i] */
    protected static ad.i mutableCopy(ad.i iVar) {
        int size = iVar.size();
        return iVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t16, byteBuffer, t.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t16, InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t16, inputStream, tVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t16, byteString, t.b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$f] */
    public static ad.f mutableCopy(ad.f fVar) {
        int size = fVar.size();
        return fVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, byteString, tVar));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$b] */
    protected static ad.b mutableCopy(ad.b bVar) {
        int size = bVar.size();
        return bVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, bArr, 0, bArr.length, t.b()));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.ad$a] */
    protected static ad.a mutableCopy(ad.a aVar) {
        int size = aVar.size();
        return aVar.b2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, bArr, 0, bArr.length, tVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> ad.j<E> mutableCopy(ad.j<E> jVar) {
        int size = jVar.size();
        return jVar.b2(size == 0 ? 10 : size * 2);
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t16, byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
        T t17 = (T) t16.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            bq e16 = bi.a().e(t17);
            e16.f(t17, bArr, i3, i3 + i16, new f.b(tVar));
            e16.g(t17);
            if (t17.memoizedHashCode == 0) {
                return t17;
            }
            throw new RuntimeException();
        } catch (IOException e17) {
            if (e17.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e17.getCause());
            }
            throw new InvalidProtocolBufferException(e17.getMessage()).setUnfinishedMessage(t17);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(t17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, k.g(inputStream), t.b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, k.g(inputStream), tVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, k kVar) throws InvalidProtocolBufferException {
        return (T) parseFrom(t16, kVar, t.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t16, k kVar, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, kVar, tVar));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t16, k kVar) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t16, kVar, t.b());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t16, ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        try {
            k newCodedInput = byteString.newCodedInput();
            T t17 = (T) parsePartialFrom(t16, newCodedInput, tVar);
            try {
                newCodedInput.a(0);
                return t17;
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(t17);
            }
        } catch (InvalidProtocolBufferException e17) {
            throw e17;
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t16, byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t16, bArr, 0, bArr.length, tVar));
    }
}
