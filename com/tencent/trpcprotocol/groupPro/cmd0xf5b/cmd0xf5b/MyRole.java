package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.bg;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class MyRole extends GeneratedMessageV3 implements e {
    public static final int ROLE_ID_FIELD_NUMBER = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final MyRole f381334d = new MyRole();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<MyRole> f381335e = new a();
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long roleId_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<MyRole> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public MyRole g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new MyRole(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements e {

        /* renamed from: i, reason: collision with root package name */
        private long f381336i;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public b A(long j3) {
            this.f381336i = j3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381372q;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381373r.e(MyRole.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public MyRole build() {
            MyRole buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public MyRole buildPartial() {
            MyRole myRole = new MyRole(this, (a) null);
            myRole.roleId_ = this.f381336i;
            onBuilt();
            return myRole;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381336i = 0L;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (b) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clearOneof(Descriptors.g gVar) {
            return (b) super.clearOneof(gVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b mo50clone() {
            return (b) super.mo50clone();
        }

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public MyRole getDefaultInstanceForType() {
            return MyRole.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            MyRole myRole = null;
            try {
                try {
                    MyRole myRole2 = (MyRole) MyRole.f381335e.g(kVar, tVar);
                    if (myRole2 != null) {
                        x(myRole2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    MyRole myRole3 = (MyRole) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        myRole = myRole3;
                        if (myRole != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (myRole != null) {
                    x(myRole);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof MyRole) {
                return x((MyRole) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(MyRole myRole) {
            if (myRole == MyRole.getDefaultInstance()) {
                return this;
            }
            if (myRole.getRoleId() != 0) {
                A(myRole.getRoleId());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) myRole).unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final b mo52mergeUnknownFields(cc ccVar) {
            return (b) super.mo52mergeUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        b() {
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ MyRole(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static MyRole getDefaultInstance() {
        return f381334d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381372q;
    }

    public static b newBuilder() {
        return f381334d.toBuilder();
    }

    public static MyRole parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MyRole) GeneratedMessageV3.parseDelimitedWithIOException(f381335e, inputStream);
    }

    public static MyRole parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381335e.d(byteBuffer);
    }

    public static bg<MyRole> parser() {
        return f381335e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyRole)) {
            return super.equals(obj);
        }
        MyRole myRole = (MyRole) obj;
        if (getRoleId() == myRole.getRoleId() && this.unknownFields.equals(myRole.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<MyRole> getParserForType() {
        return f381335e;
    }

    public long getRoleId() {
        return this.roleId_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        long j3 = this.roleId_;
        int i16 = 0;
        if (j3 != 0) {
            i16 = 0 + CodedOutputStream.a0(1, j3);
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
    public final cc getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i3 = this.memoizedHashCode;
        if (i3 != 0) {
            return i3;
        }
        int hashCode = ((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getRoleId())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381373r.e(MyRole.class, b.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
    public final boolean isInitialized() {
        byte b16 = this.memoizedIsInitialized;
        if (b16 == 1) {
            return true;
        }
        if (b16 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.f fVar) {
        return new MyRole();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j3 = this.roleId_;
        if (j3 != 0) {
            codedOutputStream.d1(1, j3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ MyRole(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(MyRole myRole) {
        return f381334d.toBuilder().x(myRole);
    }

    public static MyRole parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381335e.m(byteBuffer, tVar);
    }

    MyRole(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MyRole parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (MyRole) GeneratedMessageV3.parseDelimitedWithIOException(f381335e, inputStream, tVar);
    }

    public static MyRole parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381335e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public MyRole getDefaultInstanceForType() {
        return f381334d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381334d ? new b(aVar) : new b(aVar).x(this);
    }

    public static MyRole parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381335e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    MyRole() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MyRole parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381335e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static MyRole parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381335e.i(bArr, tVar);
    }

    MyRole(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        while (!z16) {
            try {
                try {
                    int J = kVar.J();
                    if (J != 0) {
                        if (J != 8) {
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                            }
                        } else {
                            this.roleId_ = kVar.L();
                        }
                    }
                    z16 = true;
                } catch (InvalidProtocolBufferException e16) {
                    throw e16.setUnfinishedMessage(this);
                } catch (IOException e17) {
                    throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = g16.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static MyRole parseFrom(InputStream inputStream) throws IOException {
        return (MyRole) GeneratedMessageV3.parseWithIOException(f381335e, inputStream);
    }

    public static MyRole parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (MyRole) GeneratedMessageV3.parseWithIOException(f381335e, inputStream, tVar);
    }

    public static MyRole parseFrom(k kVar) throws IOException {
        return (MyRole) GeneratedMessageV3.parseWithIOException(f381335e, kVar);
    }

    public static MyRole parseFrom(k kVar, t tVar) throws IOException {
        return (MyRole) GeneratedMessageV3.parseWithIOException(f381335e, kVar, tVar);
    }
}
