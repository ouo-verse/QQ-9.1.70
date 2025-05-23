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
import com.google.protobuf.bp;
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.SchemaConfig;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.TeamMember;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class TeamRobotState extends GeneratedMessageV3 implements j {
    public static final int SCHEMA_CONFIG_FIELD_NUMBER = 3;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 5;
    public static final int STATE_DESC_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 1;
    public static final int TEAM_MEMBERS_FIELD_NUMBER = 4;

    /* renamed from: d, reason: collision with root package name */
    private static final TeamRobotState f381352d = new TeamRobotState();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<TeamRobotState> f381353e = new a();
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private SchemaConfig schemaConfig_;
    private long startTimestamp_;
    private volatile Object stateDesc_;
    private int state_;
    private List<TeamMember> teamMembers_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<TeamRobotState> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public TeamRobotState g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new TeamRobotState(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements j {
        private Object C;
        private SchemaConfig D;
        private bu<SchemaConfig, SchemaConfig.b, g> E;
        private List<TeamMember> F;
        private bp<TeamMember, TeamMember.b, h> G;
        private long H;

        /* renamed from: i, reason: collision with root package name */
        private int f381354i;

        /* renamed from: m, reason: collision with root package name */
        private int f381355m;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                w();
            }
        }

        private void u() {
            if ((this.f381354i & 1) == 0) {
                this.F = new ArrayList(this.F);
                this.f381354i |= 1;
            }
        }

        private bp<TeamMember, TeamMember.b, h> w() {
            if (this.G == null) {
                List<TeamMember> list = this.F;
                boolean z16 = true;
                if ((this.f381354i & 1) == 0) {
                    z16 = false;
                }
                this.G = new bp<>(list, z16, h(), isClean());
                this.F = null;
            }
            return this.G;
        }

        public b A(SchemaConfig schemaConfig) {
            bu<SchemaConfig, SchemaConfig.b, g> buVar = this.E;
            if (buVar == null) {
                SchemaConfig schemaConfig2 = this.D;
                if (schemaConfig2 != null) {
                    this.D = SchemaConfig.newBuilder(schemaConfig2).x(schemaConfig).buildPartial();
                } else {
                    this.D = schemaConfig;
                }
                onChanged();
            } else {
                buVar.g(schemaConfig);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public final b mo52mergeUnknownFields(cc ccVar) {
            return (b) super.mo52mergeUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        public b D(long j3) {
            this.H = j3;
            onChanged();
            return this;
        }

        public b E(int i3) {
            this.f381355m = i3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381366k;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381367l.e(TeamRobotState.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public TeamRobotState build() {
            TeamRobotState buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public TeamRobotState buildPartial() {
            TeamRobotState teamRobotState = new TeamRobotState(this, (a) null);
            teamRobotState.state_ = this.f381355m;
            teamRobotState.stateDesc_ = this.C;
            bu<SchemaConfig, SchemaConfig.b, g> buVar = this.E;
            if (buVar == null) {
                teamRobotState.schemaConfig_ = this.D;
            } else {
                teamRobotState.schemaConfig_ = buVar.b();
            }
            bp<TeamMember, TeamMember.b, h> bpVar = this.G;
            if (bpVar != null) {
                teamRobotState.teamMembers_ = bpVar.d();
            } else {
                if ((this.f381354i & 1) != 0) {
                    this.F = Collections.unmodifiableList(this.F);
                    this.f381354i &= -2;
                }
                teamRobotState.teamMembers_ = this.F;
            }
            teamRobotState.startTimestamp_ = this.H;
            onBuilt();
            return teamRobotState;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381355m = 0;
            this.C = "";
            if (this.E == null) {
                this.D = null;
            } else {
                this.D = null;
                this.E = null;
            }
            bp<TeamMember, TeamMember.b, h> bpVar = this.G;
            if (bpVar == null) {
                this.F = Collections.emptyList();
                this.f381354i &= -2;
            } else {
                bpVar.e();
            }
            this.H = 0L;
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
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public TeamRobotState getDefaultInstanceForType() {
            return TeamRobotState.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            TeamRobotState teamRobotState = null;
            try {
                try {
                    TeamRobotState teamRobotState2 = (TeamRobotState) TeamRobotState.f381353e.g(kVar, tVar);
                    if (teamRobotState2 != null) {
                        z(teamRobotState2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    TeamRobotState teamRobotState3 = (TeamRobotState) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        teamRobotState = teamRobotState3;
                        if (teamRobotState != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (teamRobotState != null) {
                    z(teamRobotState);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof TeamRobotState) {
                return z((TeamRobotState) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b z(TeamRobotState teamRobotState) {
            if (teamRobotState == TeamRobotState.getDefaultInstance()) {
                return this;
            }
            if (teamRobotState.getState() != 0) {
                E(teamRobotState.getState());
            }
            if (!teamRobotState.getStateDesc().isEmpty()) {
                this.C = teamRobotState.stateDesc_;
                onChanged();
            }
            if (teamRobotState.hasSchemaConfig()) {
                A(teamRobotState.getSchemaConfig());
            }
            if (this.G == null) {
                if (!teamRobotState.teamMembers_.isEmpty()) {
                    if (this.F.isEmpty()) {
                        this.F = teamRobotState.teamMembers_;
                        this.f381354i &= -2;
                    } else {
                        u();
                        this.F.addAll(teamRobotState.teamMembers_);
                    }
                    onChanged();
                }
            } else if (!teamRobotState.teamMembers_.isEmpty()) {
                if (this.G.j()) {
                    this.G.f();
                    bp<TeamMember, TeamMember.b, h> bpVar = null;
                    this.G = null;
                    this.F = teamRobotState.teamMembers_;
                    this.f381354i &= -2;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        bpVar = w();
                    }
                    this.G = bpVar;
                } else {
                    this.G.b(teamRobotState.teamMembers_);
                }
            }
            if (teamRobotState.getStartTimestamp() != 0) {
                D(teamRobotState.getStartTimestamp());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) teamRobotState).unknownFields);
            onChanged();
            return this;
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        b() {
            this.C = "";
            this.F = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.C = "";
            this.F = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ TeamRobotState(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static TeamRobotState getDefaultInstance() {
        return f381352d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381366k;
    }

    public static b newBuilder() {
        return f381352d.toBuilder();
    }

    public static TeamRobotState parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseDelimitedWithIOException(f381353e, inputStream);
    }

    public static TeamRobotState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381353e.d(byteBuffer);
    }

    public static bg<TeamRobotState> parser() {
        return f381353e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamRobotState)) {
            return super.equals(obj);
        }
        TeamRobotState teamRobotState = (TeamRobotState) obj;
        if (getState() != teamRobotState.getState() || !getStateDesc().equals(teamRobotState.getStateDesc()) || hasSchemaConfig() != teamRobotState.hasSchemaConfig()) {
            return false;
        }
        if ((!hasSchemaConfig() || getSchemaConfig().equals(teamRobotState.getSchemaConfig())) && getTeamMembersList().equals(teamRobotState.getTeamMembersList()) && getStartTimestamp() == teamRobotState.getStartTimestamp() && this.unknownFields.equals(teamRobotState.unknownFields)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<TeamRobotState> getParserForType() {
        return f381353e;
    }

    public SchemaConfig getSchemaConfig() {
        SchemaConfig schemaConfig = this.schemaConfig_;
        if (schemaConfig == null) {
            return SchemaConfig.getDefaultInstance();
        }
        return schemaConfig;
    }

    public g getSchemaConfigOrBuilder() {
        return getSchemaConfig();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3;
        int i16 = this.memoizedSize;
        if (i16 != -1) {
            return i16;
        }
        int i17 = this.state_;
        if (i17 != 0) {
            i3 = CodedOutputStream.Y(1, i17) + 0;
        } else {
            i3 = 0;
        }
        if (!getStateDescBytes().isEmpty()) {
            i3 += GeneratedMessageV3.computeStringSize(2, this.stateDesc_);
        }
        if (this.schemaConfig_ != null) {
            i3 += CodedOutputStream.G(3, getSchemaConfig());
        }
        for (int i18 = 0; i18 < this.teamMembers_.size(); i18++) {
            i3 += CodedOutputStream.G(4, this.teamMembers_.get(i18));
        }
        long j3 = this.startTimestamp_;
        if (j3 != 0) {
            i3 += CodedOutputStream.z(5, j3);
        }
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    public int getState() {
        return this.state_;
    }

    public String getStateDesc() {
        Object obj = this.stateDesc_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stateDesc_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getStateDescBytes() {
        Object obj = this.stateDesc_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stateDesc_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public TeamMember getTeamMembers(int i3) {
        return this.teamMembers_.get(i3);
    }

    public int getTeamMembersCount() {
        return this.teamMembers_.size();
    }

    public List<TeamMember> getTeamMembersList() {
        return this.teamMembers_;
    }

    public h getTeamMembersOrBuilder(int i3) {
        return this.teamMembers_.get(i3);
    }

    public List<? extends h> getTeamMembersOrBuilderList() {
        return this.teamMembers_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
    public final cc getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasSchemaConfig() {
        if (this.schemaConfig_ != null) {
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
        int hashCode = ((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getState()) * 37) + 2) * 53) + getStateDesc().hashCode();
        if (hasSchemaConfig()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getSchemaConfig().hashCode();
        }
        if (getTeamMembersCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getTeamMembersList().hashCode();
        }
        int h16 = (((((hashCode * 37) + 5) * 53) + ad.h(getStartTimestamp())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = h16;
        return h16;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381367l.e(TeamRobotState.class, b.class);
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
        return new TeamRobotState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i3 = this.state_;
        if (i3 != 0) {
            codedOutputStream.b1(1, i3);
        }
        if (!getStateDescBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.stateDesc_);
        }
        if (this.schemaConfig_ != null) {
            codedOutputStream.K0(3, getSchemaConfig());
        }
        for (int i16 = 0; i16 < this.teamMembers_.size(); i16++) {
            codedOutputStream.K0(4, this.teamMembers_.get(i16));
        }
        long j3 = this.startTimestamp_;
        if (j3 != 0) {
            codedOutputStream.I0(5, j3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ TeamRobotState(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(TeamRobotState teamRobotState) {
        return f381352d.toBuilder().z(teamRobotState);
    }

    public static TeamRobotState parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381353e.m(byteBuffer, tVar);
    }

    TeamRobotState(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TeamRobotState parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseDelimitedWithIOException(f381353e, inputStream, tVar);
    }

    public static TeamRobotState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381353e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public TeamRobotState getDefaultInstanceForType() {
        return f381352d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381352d ? new b(aVar) : new b(aVar).z(this);
    }

    public static TeamRobotState parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381353e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    TeamRobotState() {
        this.memoizedIsInitialized = (byte) -1;
        this.stateDesc_ = "";
        this.teamMembers_ = Collections.emptyList();
    }

    public static TeamRobotState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381353e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static TeamRobotState parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381353e.i(bArr, tVar);
    }

    public static TeamRobotState parseFrom(InputStream inputStream) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseWithIOException(f381353e, inputStream);
    }

    TeamRobotState(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        boolean z17 = false;
        while (!z16) {
            try {
                try {
                    int J = kVar.J();
                    if (J != 0) {
                        if (J == 8) {
                            this.state_ = kVar.K();
                        } else if (J == 18) {
                            this.stateDesc_ = kVar.I();
                        } else if (J == 26) {
                            SchemaConfig schemaConfig = this.schemaConfig_;
                            SchemaConfig.b builder = schemaConfig != null ? schemaConfig.toBuilder() : null;
                            SchemaConfig schemaConfig2 = (SchemaConfig) kVar.z(SchemaConfig.parser(), tVar);
                            this.schemaConfig_ = schemaConfig2;
                            if (builder != null) {
                                builder.x(schemaConfig2);
                                this.schemaConfig_ = builder.buildPartial();
                            }
                        } else if (J == 34) {
                            if (!(z17 & true)) {
                                this.teamMembers_ = new ArrayList();
                                z17 |= true;
                            }
                            this.teamMembers_.add((TeamMember) kVar.z(TeamMember.parser(), tVar));
                        } else if (J != 40) {
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                            }
                        } else {
                            this.startTimestamp_ = kVar.y();
                        }
                    }
                    z16 = true;
                } catch (InvalidProtocolBufferException e16) {
                    throw e16.setUnfinishedMessage(this);
                } catch (IOException e17) {
                    throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                }
            } finally {
                if (z17 & true) {
                    this.teamMembers_ = Collections.unmodifiableList(this.teamMembers_);
                }
                this.unknownFields = g16.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static TeamRobotState parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseWithIOException(f381353e, inputStream, tVar);
    }

    public static TeamRobotState parseFrom(k kVar) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseWithIOException(f381353e, kVar);
    }

    public static TeamRobotState parseFrom(k kVar, t tVar) throws IOException {
        return (TeamRobotState) GeneratedMessageV3.parseWithIOException(f381353e, kVar, tVar);
    }
}
