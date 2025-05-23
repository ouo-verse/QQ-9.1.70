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
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.TeamRobotState;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RobotState extends GeneratedMessageV3 implements f {
    public static final int IS_CHANNEL_ADMIN_FIELD_NUMBER = 3;
    public static final int ROBOT_TYPE_FIELD_NUMBER = 1;
    public static final int TEAM_ROBOT_STATE_FIELD_NUMBER = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final RobotState f381337d = new RobotState();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<RobotState> f381338e = new a();
    private static final long serialVersionUID = 0;
    private boolean isChannelAdmin_;
    private byte memoizedIsInitialized;
    private int robotType_;
    private TeamRobotState teamRobotState_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<RobotState> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public RobotState g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new RobotState(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements f {
        private bu<TeamRobotState, TeamRobotState.b, j> C;
        private boolean D;

        /* renamed from: i, reason: collision with root package name */
        private int f381339i;

        /* renamed from: m, reason: collision with root package name */
        private TeamRobotState f381340m;

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

        public b B(boolean z16) {
            this.D = z16;
            onChanged();
            return this;
        }

        public b C(int i3) {
            this.f381339i = i3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381364i;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381365j.e(RobotState.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public RobotState build() {
            RobotState buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public RobotState buildPartial() {
            RobotState robotState = new RobotState(this, (a) null);
            robotState.robotType_ = this.f381339i;
            bu<TeamRobotState, TeamRobotState.b, j> buVar = this.C;
            if (buVar == null) {
                robotState.teamRobotState_ = this.f381340m;
            } else {
                robotState.teamRobotState_ = buVar.b();
            }
            robotState.isChannelAdmin_ = this.D;
            onBuilt();
            return robotState;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381339i = 0;
            if (this.C == null) {
                this.f381340m = null;
            } else {
                this.f381340m = null;
                this.C = null;
            }
            this.D = false;
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
        public RobotState getDefaultInstanceForType() {
            return RobotState.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            RobotState robotState = null;
            try {
                try {
                    RobotState robotState2 = (RobotState) RobotState.f381338e.g(kVar, tVar);
                    if (robotState2 != null) {
                        x(robotState2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    RobotState robotState3 = (RobotState) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        robotState = robotState3;
                        if (robotState != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (robotState != null) {
                    x(robotState);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof RobotState) {
                return x((RobotState) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(RobotState robotState) {
            if (robotState == RobotState.getDefaultInstance()) {
                return this;
            }
            if (robotState.robotType_ != 0) {
                C(robotState.getRobotTypeValue());
            }
            if (robotState.hasTeamRobotState()) {
                y(robotState.getTeamRobotState());
            }
            if (robotState.getIsChannelAdmin()) {
                B(robotState.getIsChannelAdmin());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) robotState).unknownFields);
            onChanged();
            return this;
        }

        public b y(TeamRobotState teamRobotState) {
            bu<TeamRobotState, TeamRobotState.b, j> buVar = this.C;
            if (buVar == null) {
                TeamRobotState teamRobotState2 = this.f381340m;
                if (teamRobotState2 != null) {
                    this.f381340m = TeamRobotState.newBuilder(teamRobotState2).z(teamRobotState).buildPartial();
                } else {
                    this.f381340m = teamRobotState;
                }
                onChanged();
            } else {
                buVar.g(teamRobotState);
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
            this.f381339i = 0;
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f381339i = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ RobotState(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static RobotState getDefaultInstance() {
        return f381337d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381364i;
    }

    public static b newBuilder() {
        return f381337d.toBuilder();
    }

    public static RobotState parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RobotState) GeneratedMessageV3.parseDelimitedWithIOException(f381338e, inputStream);
    }

    public static RobotState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381338e.d(byteBuffer);
    }

    public static bg<RobotState> parser() {
        return f381338e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RobotState)) {
            return super.equals(obj);
        }
        RobotState robotState = (RobotState) obj;
        if (this.robotType_ != robotState.robotType_ || hasTeamRobotState() != robotState.hasTeamRobotState()) {
            return false;
        }
        if ((!hasTeamRobotState() || getTeamRobotState().equals(robotState.getTeamRobotState())) && getIsChannelAdmin() == robotState.getIsChannelAdmin() && this.unknownFields.equals(robotState.unknownFields)) {
            return true;
        }
        return false;
    }

    public boolean getIsChannelAdmin() {
        return this.isChannelAdmin_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<RobotState> getParserForType() {
        return f381338e;
    }

    public RobotType getRobotType() {
        RobotType valueOf = RobotType.valueOf(this.robotType_);
        if (valueOf == null) {
            return RobotType.UNRECOGNIZED;
        }
        return valueOf;
    }

    public int getRobotTypeValue() {
        return this.robotType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        if (this.robotType_ != RobotType.ROBOT_TYPE_DEFAULT.getNumber()) {
            i16 = 0 + CodedOutputStream.l(1, this.robotType_);
        }
        if (this.teamRobotState_ != null) {
            i16 += CodedOutputStream.G(2, getTeamRobotState());
        }
        boolean z16 = this.isChannelAdmin_;
        if (z16) {
            i16 += CodedOutputStream.e(3, z16);
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public TeamRobotState getTeamRobotState() {
        TeamRobotState teamRobotState = this.teamRobotState_;
        if (teamRobotState == null) {
            return TeamRobotState.getDefaultInstance();
        }
        return teamRobotState;
    }

    public j getTeamRobotStateOrBuilder() {
        return getTeamRobotState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
    public final cc getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasTeamRobotState() {
        if (this.teamRobotState_ != null) {
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
        int hashCode = ((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + this.robotType_;
        if (hasTeamRobotState()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getTeamRobotState().hashCode();
        }
        int c16 = (((((hashCode * 37) + 3) * 53) + ad.c(getIsChannelAdmin())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = c16;
        return c16;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381365j.e(RobotState.class, b.class);
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
        return new RobotState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.robotType_ != RobotType.ROBOT_TYPE_DEFAULT.getNumber()) {
            codedOutputStream.u0(1, this.robotType_);
        }
        if (this.teamRobotState_ != null) {
            codedOutputStream.K0(2, getTeamRobotState());
        }
        boolean z16 = this.isChannelAdmin_;
        if (z16) {
            codedOutputStream.m0(3, z16);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ RobotState(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(RobotState robotState) {
        return f381337d.toBuilder().x(robotState);
    }

    public static RobotState parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381338e.m(byteBuffer, tVar);
    }

    RobotState(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static RobotState parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (RobotState) GeneratedMessageV3.parseDelimitedWithIOException(f381338e, inputStream, tVar);
    }

    public static RobotState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381338e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public RobotState getDefaultInstanceForType() {
        return f381337d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381337d ? new b(aVar) : new b(aVar).x(this);
    }

    public static RobotState parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381338e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    RobotState() {
        this.memoizedIsInitialized = (byte) -1;
        this.robotType_ = 0;
    }

    public static RobotState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381338e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static RobotState parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381338e.i(bArr, tVar);
    }

    public static RobotState parseFrom(InputStream inputStream) throws IOException {
        return (RobotState) GeneratedMessageV3.parseWithIOException(f381338e, inputStream);
    }

    RobotState(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        while (!z16) {
            try {
                try {
                    int J = kVar.J();
                    if (J != 0) {
                        if (J == 8) {
                            this.robotType_ = kVar.s();
                        } else if (J == 18) {
                            TeamRobotState teamRobotState = this.teamRobotState_;
                            TeamRobotState.b builder = teamRobotState != null ? teamRobotState.toBuilder() : null;
                            TeamRobotState teamRobotState2 = (TeamRobotState) kVar.z(TeamRobotState.parser(), tVar);
                            this.teamRobotState_ = teamRobotState2;
                            if (builder != null) {
                                builder.z(teamRobotState2);
                                this.teamRobotState_ = builder.buildPartial();
                            }
                        } else if (J != 24) {
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                            }
                        } else {
                            this.isChannelAdmin_ = kVar.p();
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

    public static RobotState parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (RobotState) GeneratedMessageV3.parseWithIOException(f381338e, inputStream, tVar);
    }

    public static RobotState parseFrom(k kVar) throws IOException {
        return (RobotState) GeneratedMessageV3.parseWithIOException(f381338e, kVar);
    }

    public static RobotState parseFrom(k kVar, t tVar) throws IOException {
        return (RobotState) GeneratedMessageV3.parseWithIOException(f381338e, kVar, tVar);
    }
}
