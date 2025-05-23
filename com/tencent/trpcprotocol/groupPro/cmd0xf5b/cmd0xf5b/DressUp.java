package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
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
public final class DressUp extends GeneratedMessageV3 implements com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b {
    public static final int AVATAR_PENDANT_FIELD_NUMBER = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final DressUp f381303d = new DressUp();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<DressUp> f381304e = new a();
    private static final long serialVersionUID = 0;
    private volatile Object avatarPendant_;
    private byte memoizedIsInitialized;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<DressUp> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public DressUp g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new DressUp(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b {

        /* renamed from: i, reason: collision with root package name */
        private Object f381305i;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381356a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381357b.e(DressUp.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public DressUp build() {
            DressUp buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public DressUp buildPartial() {
            DressUp dressUp = new DressUp(this, (a) null);
            dressUp.avatarPendant_ = this.f381305i;
            onBuilt();
            return dressUp;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381305i = "";
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
        public DressUp getDefaultInstanceForType() {
            return DressUp.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            DressUp dressUp = null;
            try {
                try {
                    DressUp dressUp2 = (DressUp) DressUp.f381304e.g(kVar, tVar);
                    if (dressUp2 != null) {
                        x(dressUp2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    DressUp dressUp3 = (DressUp) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        dressUp = dressUp3;
                        if (dressUp != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (dressUp != null) {
                    x(dressUp);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof DressUp) {
                return x((DressUp) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(DressUp dressUp) {
            if (dressUp == DressUp.getDefaultInstance()) {
                return this;
            }
            if (!dressUp.getAvatarPendant().isEmpty()) {
                this.f381305i = dressUp.avatarPendant_;
                onChanged();
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) dressUp).unknownFields);
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
            this.f381305i = "";
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f381305i = "";
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ DressUp(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static DressUp getDefaultInstance() {
        return f381303d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381356a;
    }

    public static b newBuilder() {
        return f381303d.toBuilder();
    }

    public static DressUp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DressUp) GeneratedMessageV3.parseDelimitedWithIOException(f381304e, inputStream);
    }

    public static DressUp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381304e.d(byteBuffer);
    }

    public static bg<DressUp> parser() {
        return f381304e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DressUp)) {
            return super.equals(obj);
        }
        DressUp dressUp = (DressUp) obj;
        if (getAvatarPendant().equals(dressUp.getAvatarPendant()) && this.unknownFields.equals(dressUp.unknownFields)) {
            return true;
        }
        return false;
    }

    public String getAvatarPendant() {
        Object obj = this.avatarPendant_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarPendant_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getAvatarPendantBytes() {
        Object obj = this.avatarPendant_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarPendant_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<DressUp> getParserForType() {
        return f381304e;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        if (!getAvatarPendantBytes().isEmpty()) {
            i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.avatarPendant_);
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
        int hashCode = ((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getAvatarPendant().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381357b.e(DressUp.class, b.class);
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
        return new DressUp();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getAvatarPendantBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.avatarPendant_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ DressUp(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(DressUp dressUp) {
        return f381303d.toBuilder().x(dressUp);
    }

    public static DressUp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381304e.m(byteBuffer, tVar);
    }

    DressUp(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static DressUp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (DressUp) GeneratedMessageV3.parseDelimitedWithIOException(f381304e, inputStream, tVar);
    }

    public static DressUp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381304e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public DressUp getDefaultInstanceForType() {
        return f381303d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381303d ? new b(aVar) : new b(aVar).x(this);
    }

    public static DressUp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381304e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    DressUp() {
        this.memoizedIsInitialized = (byte) -1;
        this.avatarPendant_ = "";
    }

    public static DressUp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381304e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static DressUp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381304e.i(bArr, tVar);
    }

    public static DressUp parseFrom(InputStream inputStream) throws IOException {
        return (DressUp) GeneratedMessageV3.parseWithIOException(f381304e, inputStream);
    }

    DressUp(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        while (!z16) {
            try {
                try {
                    int J = kVar.J();
                    if (J != 0) {
                        if (J != 10) {
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                            }
                        } else {
                            this.avatarPendant_ = kVar.I();
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

    public static DressUp parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (DressUp) GeneratedMessageV3.parseWithIOException(f381304e, inputStream, tVar);
    }

    public static DressUp parseFrom(k kVar) throws IOException {
        return (DressUp) GeneratedMessageV3.parseWithIOException(f381304e, kVar);
    }

    public static DressUp parseFrom(k kVar, t tVar) throws IOException {
        return (DressUp) GeneratedMessageV3.parseWithIOException(f381304e, kVar, tVar);
    }
}
