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
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.SchemaConfig;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class TeamMemberState extends GeneratedMessageV3 implements i {
    public static final int APP_ICON_FIELD_NUMBER = 4;
    public static final int LABEL_ICON_FIELD_NUMBER = 3;
    public static final int ROLE_TYPE_FIELD_NUMBER = 5;
    public static final int SCHEMA_CONFIG_FIELD_NUMBER = 6;
    public static final int STATE_DESC_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final TeamMemberState f381348d = new TeamMemberState();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<TeamMemberState> f381349e = new a();
    private static final long serialVersionUID = 0;
    private volatile Object appIcon_;
    private volatile Object labelIcon_;
    private byte memoizedIsInitialized;
    private int roleType_;
    private SchemaConfig schemaConfig_;
    private volatile Object stateDesc_;
    private int state_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<TeamMemberState> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public TeamMemberState g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new TeamMemberState(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements i {
        private Object C;
        private Object D;
        private int E;
        private SchemaConfig F;
        private bu<SchemaConfig, SchemaConfig.b, g> G;

        /* renamed from: i, reason: collision with root package name */
        private int f381350i;

        /* renamed from: m, reason: collision with root package name */
        private Object f381351m;

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

        public b B(int i3) {
            this.E = i3;
            onChanged();
            return this;
        }

        public b C(int i3) {
            this.f381350i = i3;
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
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381362g;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381363h.e(TeamMemberState.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public TeamMemberState build() {
            TeamMemberState buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public TeamMemberState buildPartial() {
            TeamMemberState teamMemberState = new TeamMemberState(this, (a) null);
            teamMemberState.state_ = this.f381350i;
            teamMemberState.stateDesc_ = this.f381351m;
            teamMemberState.labelIcon_ = this.C;
            teamMemberState.appIcon_ = this.D;
            teamMemberState.roleType_ = this.E;
            bu<SchemaConfig, SchemaConfig.b, g> buVar = this.G;
            if (buVar == null) {
                teamMemberState.schemaConfig_ = this.F;
            } else {
                teamMemberState.schemaConfig_ = buVar.b();
            }
            onBuilt();
            return teamMemberState;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381350i = 0;
            this.f381351m = "";
            this.C = "";
            this.D = "";
            this.E = 0;
            if (this.G == null) {
                this.F = null;
            } else {
                this.F = null;
                this.G = null;
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
        public TeamMemberState getDefaultInstanceForType() {
            return TeamMemberState.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            TeamMemberState teamMemberState = null;
            try {
                try {
                    TeamMemberState teamMemberState2 = (TeamMemberState) TeamMemberState.f381349e.g(kVar, tVar);
                    if (teamMemberState2 != null) {
                        x(teamMemberState2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    TeamMemberState teamMemberState3 = (TeamMemberState) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        teamMemberState = teamMemberState3;
                        if (teamMemberState != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (teamMemberState != null) {
                    x(teamMemberState);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof TeamMemberState) {
                return x((TeamMemberState) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b x(TeamMemberState teamMemberState) {
            if (teamMemberState == TeamMemberState.getDefaultInstance()) {
                return this;
            }
            if (teamMemberState.getState() != 0) {
                C(teamMemberState.getState());
            }
            if (!teamMemberState.getStateDesc().isEmpty()) {
                this.f381351m = teamMemberState.stateDesc_;
                onChanged();
            }
            if (!teamMemberState.getLabelIcon().isEmpty()) {
                this.C = teamMemberState.labelIcon_;
                onChanged();
            }
            if (!teamMemberState.getAppIcon().isEmpty()) {
                this.D = teamMemberState.appIcon_;
                onChanged();
            }
            if (teamMemberState.roleType_ != 0) {
                B(teamMemberState.getRoleTypeValue());
            }
            if (teamMemberState.hasSchemaConfig()) {
                y(teamMemberState.getSchemaConfig());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) teamMemberState).unknownFields);
            onChanged();
            return this;
        }

        public b y(SchemaConfig schemaConfig) {
            bu<SchemaConfig, SchemaConfig.b, g> buVar = this.G;
            if (buVar == null) {
                SchemaConfig schemaConfig2 = this.F;
                if (schemaConfig2 != null) {
                    this.F = SchemaConfig.newBuilder(schemaConfig2).x(schemaConfig).buildPartial();
                } else {
                    this.F = schemaConfig;
                }
                onChanged();
            } else {
                buVar.g(schemaConfig);
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
            this.f381351m = "";
            this.C = "";
            this.D = "";
            this.E = 0;
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f381351m = "";
            this.C = "";
            this.D = "";
            this.E = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ TeamMemberState(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static TeamMemberState getDefaultInstance() {
        return f381348d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381362g;
    }

    public static b newBuilder() {
        return f381348d.toBuilder();
    }

    public static TeamMemberState parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseDelimitedWithIOException(f381349e, inputStream);
    }

    public static TeamMemberState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381349e.d(byteBuffer);
    }

    public static bg<TeamMemberState> parser() {
        return f381349e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMemberState)) {
            return super.equals(obj);
        }
        TeamMemberState teamMemberState = (TeamMemberState) obj;
        if (getState() != teamMemberState.getState() || !getStateDesc().equals(teamMemberState.getStateDesc()) || !getLabelIcon().equals(teamMemberState.getLabelIcon()) || !getAppIcon().equals(teamMemberState.getAppIcon()) || this.roleType_ != teamMemberState.roleType_ || hasSchemaConfig() != teamMemberState.hasSchemaConfig()) {
            return false;
        }
        if ((!hasSchemaConfig() || getSchemaConfig().equals(teamMemberState.getSchemaConfig())) && this.unknownFields.equals(teamMemberState.unknownFields)) {
            return true;
        }
        return false;
    }

    public String getAppIcon() {
        Object obj = this.appIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.appIcon_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getAppIconBytes() {
        Object obj = this.appIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public String getLabelIcon() {
        Object obj = this.labelIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.labelIcon_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getLabelIconBytes() {
        Object obj = this.labelIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.labelIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<TeamMemberState> getParserForType() {
        return f381349e;
    }

    public TeamRoleType getRoleType() {
        TeamRoleType valueOf = TeamRoleType.valueOf(this.roleType_);
        if (valueOf == null) {
            return TeamRoleType.UNRECOGNIZED;
        }
        return valueOf;
    }

    public int getRoleTypeValue() {
        return this.roleType_;
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
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i16 = this.state_;
        int i17 = 0;
        if (i16 != 0) {
            i17 = 0 + CodedOutputStream.Y(1, i16);
        }
        if (!getStateDescBytes().isEmpty()) {
            i17 += GeneratedMessageV3.computeStringSize(2, this.stateDesc_);
        }
        if (!getLabelIconBytes().isEmpty()) {
            i17 += GeneratedMessageV3.computeStringSize(3, this.labelIcon_);
        }
        if (!getAppIconBytes().isEmpty()) {
            i17 += GeneratedMessageV3.computeStringSize(4, this.appIcon_);
        }
        if (this.roleType_ != TeamRoleType.TEAM_ROLE_TYPE_AUDIENCE.getNumber()) {
            i17 += CodedOutputStream.l(5, this.roleType_);
        }
        if (this.schemaConfig_ != null) {
            i17 += CodedOutputStream.G(6, getSchemaConfig());
        }
        int serializedSize = i17 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
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
        int hashCode = ((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getState()) * 37) + 2) * 53) + getStateDesc().hashCode()) * 37) + 3) * 53) + getLabelIcon().hashCode()) * 37) + 4) * 53) + getAppIcon().hashCode()) * 37) + 5) * 53) + this.roleType_;
        if (hasSchemaConfig()) {
            hashCode = (((hashCode * 37) + 6) * 53) + getSchemaConfig().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381363h.e(TeamMemberState.class, b.class);
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
        return new TeamMemberState();
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
        if (!getLabelIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.labelIcon_);
        }
        if (!getAppIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.appIcon_);
        }
        if (this.roleType_ != TeamRoleType.TEAM_ROLE_TYPE_AUDIENCE.getNumber()) {
            codedOutputStream.u0(5, this.roleType_);
        }
        if (this.schemaConfig_ != null) {
            codedOutputStream.K0(6, getSchemaConfig());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ TeamMemberState(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(TeamMemberState teamMemberState) {
        return f381348d.toBuilder().x(teamMemberState);
    }

    public static TeamMemberState parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381349e.m(byteBuffer, tVar);
    }

    TeamMemberState(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TeamMemberState parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseDelimitedWithIOException(f381349e, inputStream, tVar);
    }

    public static TeamMemberState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381349e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public TeamMemberState getDefaultInstanceForType() {
        return f381348d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381348d ? new b(aVar) : new b(aVar).x(this);
    }

    public static TeamMemberState parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381349e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    TeamMemberState() {
        this.memoizedIsInitialized = (byte) -1;
        this.stateDesc_ = "";
        this.labelIcon_ = "";
        this.appIcon_ = "";
        this.roleType_ = 0;
    }

    public static TeamMemberState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381349e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static TeamMemberState parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381349e.i(bArr, tVar);
    }

    public static TeamMemberState parseFrom(InputStream inputStream) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseWithIOException(f381349e, inputStream);
    }

    public static TeamMemberState parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseWithIOException(f381349e, inputStream, tVar);
    }

    TeamMemberState(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                            this.state_ = kVar.K();
                        } else if (J == 18) {
                            this.stateDesc_ = kVar.I();
                        } else if (J == 26) {
                            this.labelIcon_ = kVar.I();
                        } else if (J == 34) {
                            this.appIcon_ = kVar.I();
                        } else if (J == 40) {
                            this.roleType_ = kVar.s();
                        } else if (J != 50) {
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                            }
                        } else {
                            SchemaConfig schemaConfig = this.schemaConfig_;
                            SchemaConfig.b builder = schemaConfig != null ? schemaConfig.toBuilder() : null;
                            SchemaConfig schemaConfig2 = (SchemaConfig) kVar.z(SchemaConfig.parser(), tVar);
                            this.schemaConfig_ = schemaConfig2;
                            if (builder != null) {
                                builder.x(schemaConfig2);
                                this.schemaConfig_ = builder.buildPartial();
                            }
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

    public static TeamMemberState parseFrom(k kVar) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseWithIOException(f381349e, kVar);
    }

    public static TeamMemberState parseFrom(k kVar, t tVar) throws IOException {
        return (TeamMemberState) GeneratedMessageV3.parseWithIOException(f381349e, kVar, tVar);
    }
}
