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
public final class TeamMember extends GeneratedMessageV3 implements h {
    public static final int TINYID_FIELD_NUMBER = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final TeamMember f381345d = new TeamMember();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<TeamMember> f381346e = new a();
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long tinyid_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<TeamMember> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public TeamMember g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new TeamMember(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements h {

        /* renamed from: i, reason: collision with root package name */
        private long f381347i;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public b A(long j3) {
            this.f381347i = j3;
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
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381368m;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381369n.e(TeamMember.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public TeamMember build() {
            TeamMember buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public TeamMember buildPartial() {
            TeamMember teamMember = new TeamMember(this, (a) null);
            teamMember.tinyid_ = this.f381347i;
            onBuilt();
            return teamMember;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381347i = 0L;
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
        public TeamMember getDefaultInstanceForType() {
            return TeamMember.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            TeamMember teamMember = null;
            try {
                try {
                    TeamMember teamMember2 = (TeamMember) TeamMember.f381346e.g(kVar, tVar);
                    if (teamMember2 != null) {
                        x(teamMember2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    TeamMember teamMember3 = (TeamMember) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        teamMember = teamMember3;
                        if (teamMember != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (teamMember != null) {
                    x(teamMember);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof TeamMember) {
                return x((TeamMember) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(TeamMember teamMember) {
            if (teamMember == TeamMember.getDefaultInstance()) {
                return this;
            }
            if (teamMember.getTinyid() != 0) {
                A(teamMember.getTinyid());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) teamMember).unknownFields);
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

    /* synthetic */ TeamMember(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static TeamMember getDefaultInstance() {
        return f381345d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381368m;
    }

    public static b newBuilder() {
        return f381345d.toBuilder();
    }

    public static TeamMember parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseDelimitedWithIOException(f381346e, inputStream);
    }

    public static TeamMember parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381346e.d(byteBuffer);
    }

    public static bg<TeamMember> parser() {
        return f381346e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMember)) {
            return super.equals(obj);
        }
        TeamMember teamMember = (TeamMember) obj;
        if (getTinyid() == teamMember.getTinyid() && this.unknownFields.equals(teamMember.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<TeamMember> getParserForType() {
        return f381346e;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        long j3 = this.tinyid_;
        int i16 = 0;
        if (j3 != 0) {
            i16 = 0 + CodedOutputStream.a0(1, j3);
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public long getTinyid() {
        return this.tinyid_;
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
        int hashCode = ((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getTinyid())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381369n.e(TeamMember.class, b.class);
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
        return new TeamMember();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j3 = this.tinyid_;
        if (j3 != 0) {
            codedOutputStream.d1(1, j3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ TeamMember(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(TeamMember teamMember) {
        return f381345d.toBuilder().x(teamMember);
    }

    public static TeamMember parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381346e.m(byteBuffer, tVar);
    }

    TeamMember(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TeamMember parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseDelimitedWithIOException(f381346e, inputStream, tVar);
    }

    public static TeamMember parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381346e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public TeamMember getDefaultInstanceForType() {
        return f381345d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381345d ? new b(aVar) : new b(aVar).x(this);
    }

    public static TeamMember parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381346e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    TeamMember() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TeamMember parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381346e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static TeamMember parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381346e.i(bArr, tVar);
    }

    TeamMember(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                            this.tinyid_ = kVar.L();
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

    public static TeamMember parseFrom(InputStream inputStream) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseWithIOException(f381346e, inputStream);
    }

    public static TeamMember parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseWithIOException(f381346e, inputStream, tVar);
    }

    public static TeamMember parseFrom(k kVar) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseWithIOException(f381346e, kVar);
    }

    public static TeamMember parseFrom(k kVar, t tVar) throws IOException {
        return (TeamMember) GeneratedMessageV3.parseWithIOException(f381346e, kVar, tVar);
    }
}
