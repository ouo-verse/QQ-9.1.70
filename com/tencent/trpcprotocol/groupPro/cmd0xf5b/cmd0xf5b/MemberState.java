package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ar;
import com.google.protobuf.bg;
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.TeamMemberState;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class MemberState extends GeneratedMessageV3 implements d {
    public static final int TEAM_MEMBER_STATE_FIELD_NUMBER = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final MemberState f381330d = new MemberState();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<MemberState> f381331e = new a();
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private TeamMemberState teamMemberState_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<MemberState> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public MemberState g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new MemberState(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements d {

        /* renamed from: i, reason: collision with root package name */
        private TeamMemberState f381332i;

        /* renamed from: m, reason: collision with root package name */
        private bu<TeamMemberState, TeamMemberState.b, i> f381333m;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381360e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381361f.e(MemberState.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public MemberState build() {
            MemberState buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public MemberState buildPartial() {
            MemberState memberState = new MemberState(this, (a) null);
            bu<TeamMemberState, TeamMemberState.b, i> buVar = this.f381333m;
            if (buVar == null) {
                memberState.teamMemberState_ = this.f381332i;
            } else {
                memberState.teamMemberState_ = buVar.b();
            }
            onBuilt();
            return memberState;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            if (this.f381333m == null) {
                this.f381332i = null;
            } else {
                this.f381332i = null;
                this.f381333m = null;
            }
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
        public MemberState getDefaultInstanceForType() {
            return MemberState.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            MemberState memberState = null;
            try {
                try {
                    MemberState memberState2 = (MemberState) MemberState.f381331e.g(kVar, tVar);
                    if (memberState2 != null) {
                        x(memberState2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    MemberState memberState3 = (MemberState) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        memberState = memberState3;
                        if (memberState != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (memberState != null) {
                    x(memberState);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof MemberState) {
                return x((MemberState) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(MemberState memberState) {
            if (memberState == MemberState.getDefaultInstance()) {
                return this;
            }
            if (memberState.hasTeamMemberState()) {
                y(memberState.getTeamMemberState());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) memberState).unknownFields);
            onChanged();
            return this;
        }

        public b y(TeamMemberState teamMemberState) {
            bu<TeamMemberState, TeamMemberState.b, i> buVar = this.f381333m;
            if (buVar == null) {
                TeamMemberState teamMemberState2 = this.f381332i;
                if (teamMemberState2 != null) {
                    this.f381332i = TeamMemberState.newBuilder(teamMemberState2).x(teamMemberState).buildPartial();
                } else {
                    this.f381332i = teamMemberState;
                }
                onChanged();
            } else {
                buVar.g(teamMemberState);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final b mo52mergeUnknownFields(cc ccVar) {
            return (b) super.mo52mergeUnknownFields(ccVar);
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

    /* synthetic */ MemberState(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static MemberState getDefaultInstance() {
        return f381330d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381360e;
    }

    public static b newBuilder() {
        return f381330d.toBuilder();
    }

    public static MemberState parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MemberState) GeneratedMessageV3.parseDelimitedWithIOException(f381331e, inputStream);
    }

    public static MemberState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381331e.d(byteBuffer);
    }

    public static bg<MemberState> parser() {
        return f381331e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MemberState)) {
            return super.equals(obj);
        }
        MemberState memberState = (MemberState) obj;
        if (hasTeamMemberState() != memberState.hasTeamMemberState()) {
            return false;
        }
        if ((!hasTeamMemberState() || getTeamMemberState().equals(memberState.getTeamMemberState())) && this.unknownFields.equals(memberState.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<MemberState> getParserForType() {
        return f381331e;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        if (this.teamMemberState_ != null) {
            i16 = 0 + CodedOutputStream.G(1, getTeamMemberState());
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public TeamMemberState getTeamMemberState() {
        TeamMemberState teamMemberState = this.teamMemberState_;
        if (teamMemberState == null) {
            return TeamMemberState.getDefaultInstance();
        }
        return teamMemberState;
    }

    public i getTeamMemberStateOrBuilder() {
        return getTeamMemberState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
    public final cc getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasTeamMemberState() {
        if (this.teamMemberState_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i3 = this.memoizedHashCode;
        if (i3 != 0) {
            return i3;
        }
        int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
        if (hasTeamMemberState()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getTeamMemberState().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381361f.e(MemberState.class, b.class);
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
        return new MemberState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.teamMemberState_ != null) {
            codedOutputStream.K0(1, getTeamMemberState());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ MemberState(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(MemberState memberState) {
        return f381330d.toBuilder().x(memberState);
    }

    public static MemberState parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381331e.m(byteBuffer, tVar);
    }

    MemberState(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MemberState parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (MemberState) GeneratedMessageV3.parseDelimitedWithIOException(f381331e, inputStream, tVar);
    }

    public static MemberState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381331e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public MemberState getDefaultInstanceForType() {
        return f381330d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381330d ? new b(aVar) : new b(aVar).x(this);
    }

    public static MemberState parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381331e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    MemberState() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MemberState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381331e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static MemberState parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381331e.i(bArr, tVar);
    }

    MemberState(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                            if (J != 10) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                TeamMemberState teamMemberState = this.teamMemberState_;
                                TeamMemberState.b builder = teamMemberState != null ? teamMemberState.toBuilder() : null;
                                TeamMemberState teamMemberState2 = (TeamMemberState) kVar.z(TeamMemberState.parser(), tVar);
                                this.teamMemberState_ = teamMemberState2;
                                if (builder != null) {
                                    builder.x(teamMemberState2);
                                    this.teamMemberState_ = builder.buildPartial();
                                }
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

    public static MemberState parseFrom(InputStream inputStream) throws IOException {
        return (MemberState) GeneratedMessageV3.parseWithIOException(f381331e, inputStream);
    }

    public static MemberState parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (MemberState) GeneratedMessageV3.parseWithIOException(f381331e, inputStream, tVar);
    }

    public static MemberState parseFrom(k kVar) throws IOException {
        return (MemberState) GeneratedMessageV3.parseWithIOException(f381331e, kVar);
    }

    public static MemberState parseFrom(k kVar, t tVar) throws IOException {
        return (MemberState) GeneratedMessageV3.parseWithIOException(f381331e, kVar, tVar);
    }
}
