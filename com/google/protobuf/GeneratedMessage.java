package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.au;
import com.google.protobuf.cc;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class GeneratedMessage extends com.google.protobuf.a implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected cc unknownFields;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f35420a;

        a(a.b bVar) {
            this.f35420a = bVar;
        }

        @Override // com.google.protobuf.a.b
        public void a() {
            this.f35420a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b extends h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ar f35422b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f35423c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ar arVar, int i3) {
            super(null);
            this.f35422b = arVar;
            this.f35423c = i3;
        }

        @Override // com.google.protobuf.GeneratedMessage.h
        public Descriptors.FieldDescriptor a() {
            return this.f35422b.getDescriptorForType().q().get(this.f35423c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class c extends h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ar f35424b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f35425c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ar arVar, String str) {
            super(null);
            this.f35424b = arVar;
            this.f35425c = str;
        }

        @Override // com.google.protobuf.GeneratedMessage.h
        protected Descriptors.FieldDescriptor a() {
            return this.f35424b.getDescriptorForType().n(this.f35425c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class d extends h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f35426b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f35427c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f35428d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Class cls, String str, String str2) {
            super(null);
            this.f35426b = cls;
            this.f35427c = str;
            this.f35428d = str2;
        }

        @Override // com.google.protobuf.GeneratedMessage.h
        protected Descriptors.FieldDescriptor a() {
            try {
                return ((Descriptors.FileDescriptor) this.f35426b.getClassLoader().loadClass(this.f35427c).getField("descriptor").get(null)).n(this.f35428d);
            } catch (Exception e16) {
                throw new RuntimeException("Cannot load descriptors: " + this.f35427c + " is not a valid descriptor class name", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35429a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            f35429a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35429a[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class f<BuilderType extends f<BuilderType>> extends a.AbstractC0252a<BuilderType> {
        private g builderParent;
        private boolean isClean;
        private f<BuilderType>.a meAsParent;
        private cc unknownFields;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private class a implements g {
            a() {
            }

            @Override // com.google.protobuf.a.b
            public void a() {
                f.this.onChanged();
            }

            /* synthetic */ a(f fVar, a aVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public f() {
            this(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> r16 = internalGetFieldAccessorTable().f35432a.r();
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

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.a.AbstractC0252a
        public void dispose() {
            this.builderParent = null;
        }

        @Override // com.google.protobuf.ax
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        @Override // com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return internalGetFieldAccessorTable().f35432a;
        }

        @Override // com.google.protobuf.ax
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object m3 = internalGetFieldAccessorTable().f(fieldDescriptor).m(this);
            if (fieldDescriptor.isRepeated()) {
                return Collections.unmodifiableList((List) m3);
            }
            return m3;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).f(this);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
            return internalGetFieldAccessorTable().g(gVar).b(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public g getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new a(this, null);
            }
            return this.meAsParent;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).n(this, i3);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public ar.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).j(this, i3);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).i(this);
        }

        @Override // com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.ax
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).d(this);
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public boolean hasOneof(Descriptors.g gVar) {
            return internalGetFieldAccessorTable().g(gVar).d(this);
        }

        protected abstract j internalGetFieldAccessorTable();

        protected MapField internalGetMapField(int i3) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected MapField internalGetMutableMapField(int i3) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.av
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.a.AbstractC0252a
        public void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.ar.a
        public ar.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void onChanged() {
            g gVar;
            if (this.isClean && (gVar = this.builderParent) != null) {
                gVar.a();
                this.isClean = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean parseUnknownField(com.google.protobuf.k kVar, cc.b bVar, t tVar, int i3) throws IOException {
            return bVar.k(i3, kVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public f(g gVar) {
            this.unknownFields = cc.c();
            this.builderParent = gVar;
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).o(this, obj);
            return this;
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            internalGetFieldAccessorTable().f(fieldDescriptor).c(this);
            return this;
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).g(this, obj);
            return this;
        }

        /* renamed from: setRepeatedField, reason: merged with bridge method [inline-methods] */
        public BuilderType m56setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).k(this, i3, obj);
            return this;
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType setUnknownFields(cc ccVar) {
            this.unknownFields = ccVar;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public BuilderType clearOneof(Descriptors.g gVar) {
            internalGetFieldAccessorTable().g(gVar).a(this);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        /* renamed from: mergeUnknownFields */
        public BuilderType mo52mergeUnknownFields(cc ccVar) {
            this.unknownFields = cc.h(this.unknownFields).p(ccVar).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a
        public BuilderType clear() {
            this.unknownFields = cc.c();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a
        /* renamed from: clone */
        public BuilderType mo50clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface g extends a.b {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static abstract class h implements i {

        /* renamed from: a, reason: collision with root package name */
        private volatile Descriptors.FieldDescriptor f35431a;

        h() {
        }

        protected abstract Descriptors.FieldDescriptor a();

        @Override // com.google.protobuf.GeneratedMessage.i
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.f35431a == null) {
                synchronized (this) {
                    if (this.f35431a == null) {
                        this.f35431a = a();
                    }
                }
            }
            return this.f35431a;
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface i {
        Descriptors.FieldDescriptor getDescriptor();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class k<ContainingType extends ar, Type> extends Extension<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        private i f35487a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f35488b;

        /* renamed from: c, reason: collision with root package name */
        private final ar f35489c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f35490d;

        /* renamed from: e, reason: collision with root package name */
        private final Method f35491e;

        /* renamed from: f, reason: collision with root package name */
        private final Extension.ExtensionType f35492f;

        k(i iVar, Class cls, ar arVar, Extension.ExtensionType extensionType) {
            if (ar.class.isAssignableFrom(cls) && !cls.isInstance(arVar)) {
                throw new IllegalArgumentException("Bad messageDefaultInstance for " + cls.getName());
            }
            this.f35487a = iVar;
            this.f35488b = cls;
            this.f35489c = arVar;
            if (bk.class.isAssignableFrom(cls)) {
                this.f35490d = GeneratedMessage.getMethodOrDie(cls, "valueOf", Descriptors.d.class);
                this.f35491e = GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new Class[0]);
            } else {
                this.f35490d = null;
                this.f35491e = null;
            }
            this.f35492f = extensionType;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.Extension
        public Object b(Object obj) {
            Descriptors.FieldDescriptor c16 = c();
            if (c16.isRepeated()) {
                if (c16.v() != Descriptors.FieldDescriptor.JavaType.MESSAGE && c16.v() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return obj;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(e(it.next()));
                }
                return arrayList;
            }
            return e(obj);
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor c() {
            i iVar = this.f35487a;
            if (iVar != null) {
                return iVar.getDescriptor();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.Extension
        public ar d() {
            return this.f35489c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.Extension
        public Object e(Object obj) {
            int i3 = e.f35429a[c().v().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return GeneratedMessage.invokeOrDie(this.f35490d, null, (Descriptors.d) obj);
                }
                return obj;
            }
            if (this.f35488b.isInstance(obj)) {
                return obj;
            }
            return this.f35489c.newBuilderForType().mergeFrom((ar) obj).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessage() {
        this.unknownFields = cc.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType, T> Extension<MessageType, T> checkNotLite(q<MessageType, T> qVar) {
        if (!qVar.a()) {
            return (Extension) qVar;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    protected static int computeStringSize(int i3, Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.V(i3, (String) obj);
        }
        return CodedOutputStream.h(i3, (ByteString) obj);
    }

    protected static int computeStringSizeNoTag(Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.W((String) obj);
        }
        return CodedOutputStream.i((ByteString) obj);
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z16) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> r16 = internalGetFieldAccessorTable().f35432a.r();
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

    public static <ContainingType extends ar, Type> k<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, ar arVar) {
        return new k<>(null, cls, arVar, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingType extends ar, Type> k<ContainingType, Type> newMessageScopedGeneratedExtension(ar arVar, int i3, Class cls, ar arVar2) {
        return new k<>(new b(arVar, i3), cls, arVar2, Extension.ExtensionType.IMMUTABLE);
    }

    protected static <M extends ar> M parseDelimitedWithIOException(bg<M> bgVar, InputStream inputStream) throws IOException {
        try {
            return bgVar.h(inputStream);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static <M extends ar> M parseWithIOException(bg<M> bgVar, InputStream inputStream) throws IOException {
        try {
            return bgVar.f(inputStream);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static void writeString(CodedOutputStream codedOutputStream, int i3, Object obj) throws IOException {
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
        return internalGetFieldAccessorTable().f35432a;
    }

    @Override // com.google.protobuf.ax
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).e(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).h(this);
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.g gVar) {
        return internalGetFieldAccessorTable().g(gVar).c(this);
    }

    @Override // com.google.protobuf.au
    public bg<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i3) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).b(this, i3);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).a(this);
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

    @Override // com.google.protobuf.ax
    public cc getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.ax
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).l(this);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.g gVar) {
        return internalGetFieldAccessorTable().g(gVar).e(this);
    }

    protected abstract j internalGetFieldAccessorTable();

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

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ ar.a newBuilderForType();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ar.a newBuilderForType(g gVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.a
    public ar.a newBuilderForType(a.b bVar) {
        return newBuilderForType((g) new a(bVar));
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ au.a newBuilderForType();

    protected boolean parseUnknownField(com.google.protobuf.k kVar, cc.b bVar, t tVar, int i3) throws IOException {
        return bVar.k(i3, kVar);
    }

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ ar.a toBuilder();

    @Override // com.google.protobuf.au, com.google.protobuf.ar
    public abstract /* synthetic */ au.a toBuilder();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.b f35432a;

        /* renamed from: b, reason: collision with root package name */
        private final a[] f35433b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f35434c;

        /* renamed from: d, reason: collision with root package name */
        private final c[] f35435d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f35436e;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public interface a {
            int a(GeneratedMessage generatedMessage);

            Object b(GeneratedMessage generatedMessage, int i3);

            void c(f fVar);

            boolean d(f fVar);

            Object e(GeneratedMessage generatedMessage);

            ar.a f(f fVar);

            void g(f fVar, Object obj);

            Object h(GeneratedMessage generatedMessage);

            int i(f fVar);

            ar.a j(f fVar, int i3);

            void k(f fVar, int i3, Object obj);

            boolean l(GeneratedMessage generatedMessage);

            Object m(f fVar);

            Object n(f fVar, int i3);

            ar.a newBuilder();

            void o(f fVar, Object obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class b implements a {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.FieldDescriptor f35437a;

            /* renamed from: b, reason: collision with root package name */
            private final ar f35438b;

            b(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
                this.f35437a = fieldDescriptor;
                this.f35438b = q((GeneratedMessage) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).k();
            }

            private MapField<?, ?> p(f fVar) {
                return fVar.internalGetMapField(this.f35437a.getNumber());
            }

            private MapField<?, ?> q(GeneratedMessage generatedMessage) {
                return generatedMessage.internalGetMapField(this.f35437a.getNumber());
            }

            private MapField<?, ?> r(f fVar) {
                return fVar.internalGetMutableMapField(this.f35437a.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int a(GeneratedMessage generatedMessage) {
                return q(generatedMessage).i().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object b(GeneratedMessage generatedMessage, int i3) {
                return q(generatedMessage).i().get(i3);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void c(f fVar) {
                r(fVar).l().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean d(f fVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object e(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < a(generatedMessage); i3++) {
                    arrayList.add(b(generatedMessage, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a f(f fVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                c(fVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    o(fVar, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object h(GeneratedMessage generatedMessage) {
                return e(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int i(f fVar) {
                return p(fVar).i().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a j(f fVar, int i3) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void k(f fVar, int i3, Object obj) {
                r(fVar).l().set(i3, (ar) obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean l(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object m(f fVar) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < i(fVar); i3++) {
                    arrayList.add(n(fVar, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object n(f fVar, int i3) {
                return p(fVar).i().get(i3);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a newBuilder() {
                return this.f35438b.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void o(f fVar, Object obj) {
                r(fVar).l().add((ar) obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.b f35439a;

            /* renamed from: b, reason: collision with root package name */
            private final Method f35440b;

            /* renamed from: c, reason: collision with root package name */
            private final Method f35441c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f35442d;

            c(Descriptors.b bVar, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
                this.f35439a = bVar;
                this.f35440b = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Case", new Class[0]);
                this.f35441c = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Case", new Class[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(QCircleLpReportDc05507.KEY_CLEAR);
                sb5.append(str);
                this.f35442d = GeneratedMessage.getMethodOrDie(cls2, sb5.toString(), new Class[0]);
            }

            public void a(f fVar) {
                GeneratedMessage.invokeOrDie(this.f35442d, fVar, new Object[0]);
            }

            public Descriptors.FieldDescriptor b(f fVar) {
                int number = ((ad.c) GeneratedMessage.invokeOrDie(this.f35441c, fVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f35439a.o(number);
                }
                return null;
            }

            public Descriptors.FieldDescriptor c(GeneratedMessage generatedMessage) {
                int number = ((ad.c) GeneratedMessage.invokeOrDie(this.f35440b, generatedMessage, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f35439a.o(number);
                }
                return null;
            }

            public boolean d(f fVar) {
                if (((ad.c) GeneratedMessage.invokeOrDie(this.f35441c, fVar, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public boolean e(GeneratedMessage generatedMessage) {
                if (((ad.c) GeneratedMessage.invokeOrDie(this.f35440b, generatedMessage, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class d extends e {

            /* renamed from: k, reason: collision with root package name */
            private Descriptors.c f35443k;

            /* renamed from: l, reason: collision with root package name */
            private final Method f35444l;

            /* renamed from: m, reason: collision with root package name */
            private final Method f35445m;

            /* renamed from: n, reason: collision with root package name */
            private boolean f35446n;

            /* renamed from: o, reason: collision with root package name */
            private Method f35447o;

            /* renamed from: p, reason: collision with root package name */
            private Method f35448p;

            /* renamed from: q, reason: collision with root package name */
            private Method f35449q;

            /* renamed from: r, reason: collision with root package name */
            private Method f35450r;

            d(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f35443k = fieldDescriptor.s();
                this.f35444l = GeneratedMessage.getMethodOrDie(this.f35451a, "valueOf", Descriptors.d.class);
                this.f35445m = GeneratedMessage.getMethodOrDie(this.f35451a, "getValueDescriptor", new Class[0]);
                boolean z16 = fieldDescriptor.h().z();
                this.f35446n = z16;
                if (z16) {
                    Class cls3 = Integer.TYPE;
                    this.f35447o = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", cls3);
                    this.f35448p = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", cls3);
                    this.f35449q = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", cls3, cls3);
                    this.f35450r = GeneratedMessage.getMethodOrDie(cls2, "add" + str + "Value", cls3);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public Object b(GeneratedMessage generatedMessage, int i3) {
                if (!this.f35446n) {
                    return GeneratedMessage.invokeOrDie(this.f35445m, super.b(generatedMessage, i3), new Object[0]);
                }
                return this.f35443k.n(((Integer) GeneratedMessage.invokeOrDie(this.f35447o, generatedMessage, Integer.valueOf(i3))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public Object e(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                int a16 = a(generatedMessage);
                for (int i3 = 0; i3 < a16; i3++) {
                    arrayList.add(b(generatedMessage, i3));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public void k(f fVar, int i3, Object obj) {
                if (this.f35446n) {
                    GeneratedMessage.invokeOrDie(this.f35449q, fVar, Integer.valueOf(i3), Integer.valueOf(((Descriptors.d) obj).getNumber()));
                } else {
                    super.k(fVar, i3, GeneratedMessage.invokeOrDie(this.f35444l, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public Object m(f fVar) {
                ArrayList arrayList = new ArrayList();
                int i3 = i(fVar);
                for (int i16 = 0; i16 < i3; i16++) {
                    arrayList.add(n(fVar, i16));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public Object n(f fVar, int i3) {
                if (!this.f35446n) {
                    return GeneratedMessage.invokeOrDie(this.f35445m, super.n(fVar, i3), new Object[0]);
                }
                return this.f35443k.n(((Integer) GeneratedMessage.invokeOrDie(this.f35448p, fVar, Integer.valueOf(i3))).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public void o(f fVar, Object obj) {
                if (this.f35446n) {
                    GeneratedMessage.invokeOrDie(this.f35450r, fVar, Integer.valueOf(((Descriptors.d) obj).getNumber()));
                } else {
                    super.o(fVar, GeneratedMessage.invokeOrDie(this.f35444l, null, obj));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class e implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class f35451a;

            /* renamed from: b, reason: collision with root package name */
            protected final Method f35452b;

            /* renamed from: c, reason: collision with root package name */
            protected final Method f35453c;

            /* renamed from: d, reason: collision with root package name */
            protected final Method f35454d;

            /* renamed from: e, reason: collision with root package name */
            protected final Method f35455e;

            /* renamed from: f, reason: collision with root package name */
            protected final Method f35456f;

            /* renamed from: g, reason: collision with root package name */
            protected final Method f35457g;

            /* renamed from: h, reason: collision with root package name */
            protected final Method f35458h;

            /* renamed from: i, reason: collision with root package name */
            protected final Method f35459i;

            /* renamed from: j, reason: collision with root package name */
            protected final Method f35460j;

            e(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
                this.f35452b = GeneratedMessage.getMethodOrDie(cls, "get" + str + "List", new Class[0]);
                this.f35453c = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "List", new Class[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("get");
                sb5.append(str);
                String sb6 = sb5.toString();
                Class cls3 = Integer.TYPE;
                Method methodOrDie = GeneratedMessage.getMethodOrDie(cls, sb6, cls3);
                this.f35454d = methodOrDie;
                this.f35455e = GeneratedMessage.getMethodOrDie(cls2, "get" + str, cls3);
                Class<?> returnType = methodOrDie.getReturnType();
                this.f35451a = returnType;
                this.f35456f = GeneratedMessage.getMethodOrDie(cls2, "set" + str, cls3, returnType);
                this.f35457g = GeneratedMessage.getMethodOrDie(cls2, "add" + str, returnType);
                this.f35458h = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Count", new Class[0]);
                this.f35459i = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Count", new Class[0]);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(QCircleLpReportDc05507.KEY_CLEAR);
                sb7.append(str);
                this.f35460j = GeneratedMessage.getMethodOrDie(cls2, sb7.toString(), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int a(GeneratedMessage generatedMessage) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.f35458h, generatedMessage, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object b(GeneratedMessage generatedMessage, int i3) {
                return GeneratedMessage.invokeOrDie(this.f35454d, generatedMessage, Integer.valueOf(i3));
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void c(f fVar) {
                GeneratedMessage.invokeOrDie(this.f35460j, fVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean d(f fVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object e(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.f35452b, generatedMessage, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a f(f fVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                c(fVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    o(fVar, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object h(GeneratedMessage generatedMessage) {
                return e(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int i(f fVar) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.f35459i, fVar, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a j(f fVar, int i3) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void k(f fVar, int i3, Object obj) {
                GeneratedMessage.invokeOrDie(this.f35456f, fVar, Integer.valueOf(i3), obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean l(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object m(f fVar) {
                return GeneratedMessage.invokeOrDie(this.f35453c, fVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object n(f fVar, int i3) {
                return GeneratedMessage.invokeOrDie(this.f35455e, fVar, Integer.valueOf(i3));
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void o(f fVar, Object obj) {
                GeneratedMessage.invokeOrDie(this.f35457g, fVar, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class f extends e {

            /* renamed from: k, reason: collision with root package name */
            private final Method f35461k;

            /* renamed from: l, reason: collision with root package name */
            private final Method f35462l;

            f(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f35461k = GeneratedMessage.getMethodOrDie(this.f35451a, "newBuilder", new Class[0]);
                this.f35462l = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object p(Object obj) {
                if (this.f35451a.isInstance(obj)) {
                    return obj;
                }
                return ((ar.a) GeneratedMessage.invokeOrDie(this.f35461k, null, new Object[0])).mergeFrom((ar) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public ar.a j(f fVar, int i3) {
                return (ar.a) GeneratedMessage.invokeOrDie(this.f35462l, fVar, Integer.valueOf(i3));
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public void k(f fVar, int i3, Object obj) {
                super.k(fVar, i3, p(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public ar.a newBuilder() {
                return (ar.a) GeneratedMessage.invokeOrDie(this.f35461k, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.e, com.google.protobuf.GeneratedMessage.j.a
            public void o(f fVar, Object obj) {
                super.o(fVar, p(obj));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class g extends h {

            /* renamed from: m, reason: collision with root package name */
            private Descriptors.c f35463m;

            /* renamed from: n, reason: collision with root package name */
            private Method f35464n;

            /* renamed from: o, reason: collision with root package name */
            private Method f35465o;

            /* renamed from: p, reason: collision with root package name */
            private boolean f35466p;

            /* renamed from: q, reason: collision with root package name */
            private Method f35467q;

            /* renamed from: r, reason: collision with root package name */
            private Method f35468r;

            /* renamed from: s, reason: collision with root package name */
            private Method f35469s;

            g(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35463m = fieldDescriptor.s();
                this.f35464n = GeneratedMessage.getMethodOrDie(this.f35470a, "valueOf", Descriptors.d.class);
                this.f35465o = GeneratedMessage.getMethodOrDie(this.f35470a, "getValueDescriptor", new Class[0]);
                boolean z16 = fieldDescriptor.h().z();
                this.f35466p = z16;
                if (z16) {
                    this.f35467q = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Value", new Class[0]);
                    this.f35468r = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Value", new Class[0]);
                    this.f35469s = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public Object e(GeneratedMessage generatedMessage) {
                if (!this.f35466p) {
                    return GeneratedMessage.invokeOrDie(this.f35465o, super.e(generatedMessage), new Object[0]);
                }
                return this.f35463m.n(((Integer) GeneratedMessage.invokeOrDie(this.f35467q, generatedMessage, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                if (this.f35466p) {
                    GeneratedMessage.invokeOrDie(this.f35469s, fVar, Integer.valueOf(((Descriptors.d) obj).getNumber()));
                } else {
                    super.g(fVar, GeneratedMessage.invokeOrDie(this.f35464n, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public Object m(f fVar) {
                if (!this.f35466p) {
                    return GeneratedMessage.invokeOrDie(this.f35465o, super.m(fVar), new Object[0]);
                }
                return this.f35463m.n(((Integer) GeneratedMessage.invokeOrDie(this.f35468r, fVar, new Object[0])).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class h implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class<?> f35470a;

            /* renamed from: b, reason: collision with root package name */
            protected final Method f35471b;

            /* renamed from: c, reason: collision with root package name */
            protected final Method f35472c;

            /* renamed from: d, reason: collision with root package name */
            protected final Method f35473d;

            /* renamed from: e, reason: collision with root package name */
            protected final Method f35474e;

            /* renamed from: f, reason: collision with root package name */
            protected final Method f35475f;

            /* renamed from: g, reason: collision with root package name */
            protected final Method f35476g;

            /* renamed from: h, reason: collision with root package name */
            protected final Method f35477h;

            /* renamed from: i, reason: collision with root package name */
            protected final Method f35478i;

            /* renamed from: j, reason: collision with root package name */
            protected final Descriptors.FieldDescriptor f35479j;

            /* renamed from: k, reason: collision with root package name */
            protected final boolean f35480k;

            /* renamed from: l, reason: collision with root package name */
            protected final boolean f35481l;

            h(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2, String str2) {
                boolean z16;
                boolean z17;
                Method method;
                Method method2;
                Method method3;
                this.f35479j = fieldDescriptor;
                if (fieldDescriptor.p() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f35480k = z16;
                if (!j.i(fieldDescriptor.h()) && (z16 || fieldDescriptor.v() != Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                this.f35481l = z17;
                Method methodOrDie = GeneratedMessage.getMethodOrDie(cls, "get" + str, new Class[0]);
                this.f35471b = methodOrDie;
                this.f35472c = GeneratedMessage.getMethodOrDie(cls2, "get" + str, new Class[0]);
                Class<?> returnType = methodOrDie.getReturnType();
                this.f35470a = returnType;
                this.f35473d = GeneratedMessage.getMethodOrDie(cls2, "set" + str, returnType);
                Method method4 = null;
                if (z17) {
                    method = GeneratedMessage.getMethodOrDie(cls, "has" + str, new Class[0]);
                } else {
                    method = null;
                }
                this.f35474e = method;
                if (z17) {
                    method2 = GeneratedMessage.getMethodOrDie(cls2, "has" + str, new Class[0]);
                } else {
                    method2 = null;
                }
                this.f35475f = method2;
                this.f35476g = GeneratedMessage.getMethodOrDie(cls2, QCircleLpReportDc05507.KEY_CLEAR + str, new Class[0]);
                if (z16) {
                    method3 = GeneratedMessage.getMethodOrDie(cls, "get" + str2 + "Case", new Class[0]);
                } else {
                    method3 = null;
                }
                this.f35477h = method3;
                if (z16) {
                    method4 = GeneratedMessage.getMethodOrDie(cls2, "get" + str2 + "Case", new Class[0]);
                }
                this.f35478i = method4;
            }

            private int p(f fVar) {
                return ((ad.c) GeneratedMessage.invokeOrDie(this.f35478i, fVar, new Object[0])).getNumber();
            }

            private int q(GeneratedMessage generatedMessage) {
                return ((ad.c) GeneratedMessage.invokeOrDie(this.f35477h, generatedMessage, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int a(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object b(GeneratedMessage generatedMessage, int i3) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void c(f fVar) {
                GeneratedMessage.invokeOrDie(this.f35476g, fVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean d(f fVar) {
                if (!this.f35481l) {
                    if (this.f35480k) {
                        if (p(fVar) != this.f35479j.getNumber()) {
                            return false;
                        }
                        return true;
                    }
                    return !m(fVar).equals(this.f35479j.r());
                }
                return ((Boolean) GeneratedMessage.invokeOrDie(this.f35475f, fVar, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object e(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.f35471b, generatedMessage, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a f(f fVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                GeneratedMessage.invokeOrDie(this.f35473d, fVar, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object h(GeneratedMessage generatedMessage) {
                return e(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public int i(f fVar) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a j(f fVar, int i3) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void k(f fVar, int i3, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public boolean l(GeneratedMessage generatedMessage) {
                if (!this.f35481l) {
                    if (this.f35480k) {
                        if (q(generatedMessage) != this.f35479j.getNumber()) {
                            return false;
                        }
                        return true;
                    }
                    return !e(generatedMessage).equals(this.f35479j.r());
                }
                return ((Boolean) GeneratedMessage.invokeOrDie(this.f35474e, generatedMessage, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object m(f fVar) {
                return GeneratedMessage.invokeOrDie(this.f35472c, fVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public Object n(f fVar, int i3) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public ar.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.j.a
            public void o(f fVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class i extends h {

            /* renamed from: m, reason: collision with root package name */
            private final Method f35482m;

            /* renamed from: n, reason: collision with root package name */
            private final Method f35483n;

            i(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35482m = GeneratedMessage.getMethodOrDie(this.f35470a, "newBuilder", new Class[0]);
                this.f35483n = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object r(Object obj) {
                if (this.f35470a.isInstance(obj)) {
                    return obj;
                }
                return ((ar.a) GeneratedMessage.invokeOrDie(this.f35482m, null, new Object[0])).mergeFrom((ar) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public ar.a f(f fVar) {
                return (ar.a) GeneratedMessage.invokeOrDie(this.f35483n, fVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                super.g(fVar, r(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public ar.a newBuilder() {
                return (ar.a) GeneratedMessage.invokeOrDie(this.f35482m, null, new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.google.protobuf.GeneratedMessage$j$j, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0249j extends h {

            /* renamed from: m, reason: collision with root package name */
            private final Method f35484m;

            /* renamed from: n, reason: collision with root package name */
            private final Method f35485n;

            /* renamed from: o, reason: collision with root package name */
            private final Method f35486o;

            C0249j(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f35484m = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Bytes", new Class[0]);
                this.f35485n = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Bytes", new Class[0]);
                this.f35486o = GeneratedMessage.getMethodOrDie(cls2, "set" + str + "Bytes", ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public void g(f fVar, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessage.invokeOrDie(this.f35486o, fVar, obj);
                } else {
                    super.g(fVar, obj);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.j.h, com.google.protobuf.GeneratedMessage.j.a
            public Object h(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.f35484m, generatedMessage, new Object[0]);
            }
        }

        public j(Descriptors.b bVar, String[] strArr, Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
            this(bVar, strArr);
            e(cls, cls2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a f(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.q() == this.f35432a) {
                if (!fieldDescriptor.z()) {
                    return this.f35433b[fieldDescriptor.u()];
                }
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c g(Descriptors.g gVar) {
            if (gVar.p() == this.f35432a) {
                return this.f35435d[gVar.r()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private boolean h(Descriptors.FieldDescriptor fieldDescriptor) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean i(Descriptors.FileDescriptor fileDescriptor) {
            if (fileDescriptor.t() == Descriptors.FileDescriptor.Syntax.PROTO2) {
                return true;
            }
            return false;
        }

        public j e(Class<? extends GeneratedMessage> cls, Class<? extends f> cls2) {
            if (this.f35436e) {
                return this;
            }
            synchronized (this) {
                if (this.f35436e) {
                    return this;
                }
                int length = this.f35433b.length;
                int i3 = 0;
                while (true) {
                    String str = null;
                    if (i3 >= length) {
                        break;
                    }
                    Descriptors.FieldDescriptor fieldDescriptor = this.f35432a.r().get(i3);
                    if (fieldDescriptor.p() != null) {
                        str = this.f35434c[fieldDescriptor.p().r() + length];
                    }
                    String str2 = str;
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (fieldDescriptor.A() && h(fieldDescriptor)) {
                                this.f35433b[i3] = new b(fieldDescriptor, this.f35434c[i3], cls, cls2);
                            } else {
                                this.f35433b[i3] = new f(fieldDescriptor, this.f35434c[i3], cls, cls2);
                            }
                        } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.f35433b[i3] = new d(fieldDescriptor, this.f35434c[i3], cls, cls2);
                        } else {
                            this.f35433b[i3] = new e(fieldDescriptor, this.f35434c[i3], cls, cls2);
                        }
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.f35433b[i3] = new i(fieldDescriptor, this.f35434c[i3], cls, cls2, str2);
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.f35433b[i3] = new g(fieldDescriptor, this.f35434c[i3], cls, cls2, str2);
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.f35433b[i3] = new C0249j(fieldDescriptor, this.f35434c[i3], cls, cls2, str2);
                    } else {
                        this.f35433b[i3] = new h(fieldDescriptor, this.f35434c[i3], cls, cls2, str2);
                    }
                    i3++;
                }
                int length2 = this.f35435d.length;
                for (int i16 = 0; i16 < length2; i16++) {
                    this.f35435d[i16] = new c(this.f35432a, this.f35434c[i16 + length], cls, cls2);
                }
                this.f35436e = true;
                this.f35434c = null;
                return this;
            }
        }

        public j(Descriptors.b bVar, String[] strArr) {
            this.f35432a = bVar;
            this.f35434c = strArr;
            this.f35433b = new a[bVar.r().size()];
            this.f35435d = new c[bVar.t().size()];
            this.f35436e = false;
        }
    }

    public static <ContainingType extends ar, Type> k<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, ar arVar, String str, String str2) {
        return new k<>(new d(cls, str, str2), cls, arVar, Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends ar, Type> k<ContainingType, Type> newMessageScopedGeneratedExtension(ar arVar, String str, Class cls, ar arVar2) {
        return new k<>(new c(arVar, str), cls, arVar2, Extension.ExtensionType.MUTABLE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessage(f<?> fVar) {
        this.unknownFields = fVar.getUnknownFields();
    }

    protected static <M extends ar> M parseDelimitedWithIOException(bg<M> bgVar, InputStream inputStream, t tVar) throws IOException {
        try {
            return bgVar.k(inputStream, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static <M extends ar> M parseWithIOException(bg<M> bgVar, InputStream inputStream, t tVar) throws IOException {
        try {
            return bgVar.l(inputStream, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static <M extends ar> M parseWithIOException(bg<M> bgVar, com.google.protobuf.k kVar) throws IOException {
        try {
            return bgVar.c(kVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected static <M extends ar> M parseWithIOException(bg<M> bgVar, com.google.protobuf.k kVar, t tVar) throws IOException {
        try {
            return bgVar.e(kVar, tVar);
        } catch (InvalidProtocolBufferException e16) {
            throw e16.unwrapIOException();
        }
    }

    protected void makeExtensionsImmutable() {
    }
}
