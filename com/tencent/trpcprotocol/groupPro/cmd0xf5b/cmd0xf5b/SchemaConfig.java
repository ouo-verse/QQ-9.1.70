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
public final class SchemaConfig extends GeneratedMessageV3 implements g {
    public static final int SCHEMA_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final SchemaConfig f381341d = new SchemaConfig();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<SchemaConfig> f381342e = new a();
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object schema_;
    private volatile Object text_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<SchemaConfig> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public SchemaConfig g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new SchemaConfig(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g {

        /* renamed from: i, reason: collision with root package name */
        private Object f381343i;

        /* renamed from: m, reason: collision with root package name */
        private Object f381344m;

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
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381370o;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381371p.e(SchemaConfig.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public SchemaConfig build() {
            SchemaConfig buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public SchemaConfig buildPartial() {
            SchemaConfig schemaConfig = new SchemaConfig(this, (a) null);
            schemaConfig.schema_ = this.f381343i;
            schemaConfig.text_ = this.f381344m;
            onBuilt();
            return schemaConfig;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381343i = "";
            this.f381344m = "";
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
        public SchemaConfig getDefaultInstanceForType() {
            return SchemaConfig.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            SchemaConfig schemaConfig = null;
            try {
                try {
                    SchemaConfig schemaConfig2 = (SchemaConfig) SchemaConfig.f381342e.g(kVar, tVar);
                    if (schemaConfig2 != null) {
                        x(schemaConfig2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    SchemaConfig schemaConfig3 = (SchemaConfig) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        schemaConfig = schemaConfig3;
                        if (schemaConfig != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (schemaConfig != null) {
                    x(schemaConfig);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof SchemaConfig) {
                return x((SchemaConfig) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(SchemaConfig schemaConfig) {
            if (schemaConfig == SchemaConfig.getDefaultInstance()) {
                return this;
            }
            if (!schemaConfig.getSchema().isEmpty()) {
                this.f381343i = schemaConfig.schema_;
                onChanged();
            }
            if (!schemaConfig.getText().isEmpty()) {
                this.f381344m = schemaConfig.text_;
                onChanged();
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) schemaConfig).unknownFields);
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
            this.f381343i = "";
            this.f381344m = "";
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f381343i = "";
            this.f381344m = "";
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ SchemaConfig(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static SchemaConfig getDefaultInstance() {
        return f381341d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381370o;
    }

    public static b newBuilder() {
        return f381341d.toBuilder();
    }

    public static SchemaConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseDelimitedWithIOException(f381342e, inputStream);
    }

    public static SchemaConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381342e.d(byteBuffer);
    }

    public static bg<SchemaConfig> parser() {
        return f381342e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchemaConfig)) {
            return super.equals(obj);
        }
        SchemaConfig schemaConfig = (SchemaConfig) obj;
        if (getSchema().equals(schemaConfig.getSchema()) && getText().equals(schemaConfig.getText()) && this.unknownFields.equals(schemaConfig.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<SchemaConfig> getParserForType() {
        return f381342e;
    }

    public String getSchema() {
        Object obj = this.schema_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.schema_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getSchemaBytes() {
        Object obj = this.schema_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.schema_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        if (!getSchemaBytes().isEmpty()) {
            i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.schema_);
        }
        if (!getTextBytes().isEmpty()) {
            i16 += GeneratedMessageV3.computeStringSize(2, this.text_);
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public String getText() {
        Object obj = this.text_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.text_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getTextBytes() {
        Object obj = this.text_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getSchema().hashCode()) * 37) + 2) * 53) + getText().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381371p.e(SchemaConfig.class, b.class);
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
        return new SchemaConfig();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getSchemaBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.schema_);
        }
        if (!getTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.text_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ SchemaConfig(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(SchemaConfig schemaConfig) {
        return f381341d.toBuilder().x(schemaConfig);
    }

    public static SchemaConfig parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381342e.m(byteBuffer, tVar);
    }

    SchemaConfig(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static SchemaConfig parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseDelimitedWithIOException(f381342e, inputStream, tVar);
    }

    public static SchemaConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381342e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public SchemaConfig getDefaultInstanceForType() {
        return f381341d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381341d ? new b(aVar) : new b(aVar).x(this);
    }

    public static SchemaConfig parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381342e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    SchemaConfig() {
        this.memoizedIsInitialized = (byte) -1;
        this.schema_ = "";
        this.text_ = "";
    }

    public static SchemaConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381342e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static SchemaConfig parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381342e.i(bArr, tVar);
    }

    public static SchemaConfig parseFrom(InputStream inputStream) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseWithIOException(f381342e, inputStream);
    }

    SchemaConfig(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        while (!z16) {
            try {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                this.schema_ = kVar.I();
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.text_ = kVar.I();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    }
                } catch (IOException e17) {
                    throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = g16.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static SchemaConfig parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseWithIOException(f381342e, inputStream, tVar);
    }

    public static SchemaConfig parseFrom(k kVar) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseWithIOException(f381342e, kVar);
    }

    public static SchemaConfig parseFrom(k kVar, t tVar) throws IOException {
        return (SchemaConfig) GeneratedMessageV3.parseWithIOException(f381342e, kVar, tVar);
    }
}
