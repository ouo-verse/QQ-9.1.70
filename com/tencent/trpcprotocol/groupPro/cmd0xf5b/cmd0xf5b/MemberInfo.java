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
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.DressUp;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.MemberState;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.MyRole;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.RobotState;
import com.tencent.trpcprotocol.group_pro.common.client.client;
import com.tencent.view.FilterEnum;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class MemberInfo extends GeneratedMessageV3 implements c {
    public static final int BYTES_AVATAR_META_FIELD_NUMBER = 28;
    public static final int BYTES_MEMBER_NAME_FIELD_NUMBER = 2;
    public static final int BYTES_NICK_NAME_FIELD_NUMBER = 3;
    public static final int BYTES_ROBOT_TEST_GUILDS_FIELD_NUMBER = 25;
    public static final int BYTES_TRANS_DATA_FIELD_NUMBER = 29;
    public static final int CHANNEL_TRANS_DATA_FIELD_NUMBER = 33;
    public static final int CLIENT_IDENTITY_BYTES_FIELD_NUMBER = 27;
    public static final int CLIENT_IDENTITY_FIELD_NUMBER = 15;
    public static final int DRESS_UP_FIELD_NUMBER = 37;
    public static final int IS_IN_REQ_ROLE_ID_FIELD_NUMBER = 19;
    public static final int LEVEL_ROLE_ID_FIELD_NUMBER = 36;
    public static final int MEMBER_STATE_FIELD_NUMBER = 23;
    public static final int MY_ROLES_FIELD_NUMBER = 18;
    public static final int PRESENCE_FIELD_NUMBER = 16;
    public static final int ROBOT_STATE_FIELD_NUMBER = 24;
    public static final int SHUT_UP_EXPIRE_TIME_FIELD_NUMBER = 20;
    public static final int TRANS_DATA_TYPE_FIELD_NUMBER = 32;
    public static final int UINT32_AVATAR_FLAG_FIELD_NUMBER = 39;
    public static final int UINT32_CHANNEL_ROLE_FIELD_NUMBER = 9;
    public static final int UINT32_GENDER_FIELD_NUMBER = 30;
    public static final int UINT32_GUILD_MUTE_FLAG_FIELD_NUMBER = 12;
    public static final int UINT32_GUILD_ROBOT_MUTE_STATUS_FIELD_NUMBER = 21;
    public static final int UINT32_GUILD_ROBOT_PUNISHMENT_STATUS_FIELD_NUMBER = 22;
    public static final int UINT32_IS_ALLOWED_SHARING_SCREEN_FIELD_NUMBER = 31;
    public static final int UINT32_IS_BANNED_FIELD_NUMBER = 34;
    public static final int UINT32_IS_IN_BLACKLIST_FIELD_NUMBER = 13;
    public static final int UINT32_IS_IN_PRIVATE_CHANNEL_FIELD_NUMBER = 17;
    public static final int UINT32_MEMBER_NAME_FLAG_FIELD_NUMBER = 38;
    public static final int UINT32_ONLINE_STATE_FIELD_NUMBER = 35;
    public static final int UINT32_PLATFORM_FIELD_NUMBER = 14;
    public static final int UINT32_ROLE_FIELD_NUMBER = 5;
    public static final int UINT32_TYPE_FIELD_NUMBER = 6;
    public static final int UINT64_BE_ADMIN_TIME_FIELD_NUMBER = 7;
    public static final int UINT64_HEARTBEAT_TIME_FIELD_NUMBER = 11;
    public static final int UINT64_JOIN_CHANNEL_TIME_FIELD_NUMBER = 10;
    public static final int UINT64_JOIN_TIME_FIELD_NUMBER = 4;
    public static final int UINT64_MEMBER_UIN_FIELD_NUMBER = 1;
    public static final int UINT64_TINYID_FIELD_NUMBER = 8;

    /* renamed from: d, reason: collision with root package name */
    private static final MemberInfo f381306d = new MemberInfo();

    /* renamed from: e, reason: collision with root package name */
    private static final bg<MemberInfo> f381307e = new a();
    private static final long serialVersionUID = 0;
    private ByteString bytesAvatarMeta_;
    private ByteString bytesMemberName_;
    private ByteString bytesNickName_;
    private ByteString bytesRobotTestGuilds_;
    private ByteString bytesTransData_;
    private ByteString channelTransData_;
    private ByteString clientIdentityBytes_;
    private client.ClientIdentity clientIdentity_;
    private DressUp dressUp_;
    private int isInReqRoleId_;
    private int levelRoleId_;
    private MemberState memberState_;
    private byte memoizedIsInitialized;
    private List<MyRole> myRoles_;
    private client.ClientPresence presence_;
    private RobotState robotState_;
    private long shutUpExpireTime_;
    private int transDataType_;
    private int uint32AvatarFlag_;
    private int uint32ChannelRole_;
    private int uint32Gender_;
    private int uint32GuildMuteFlag_;
    private int uint32GuildRobotMuteStatus_;
    private int uint32GuildRobotPunishmentStatus_;
    private int uint32IsAllowedSharingScreen_;
    private int uint32IsBanned_;
    private int uint32IsInBlacklist_;
    private int uint32IsInPrivateChannel_;
    private int uint32MemberNameFlag_;
    private int uint32OnlineState_;
    private int uint32Platform_;
    private int uint32Role_;
    private int uint32Type_;
    private long uint64BeAdminTime_;
    private long uint64HeartbeatTime_;
    private long uint64JoinChannelTime_;
    private long uint64JoinTime_;
    private long uint64MemberUin_;
    private long uint64Tinyid_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends com.google.protobuf.c<MemberInfo> {
        a() {
        }

        @Override // com.google.protobuf.bg
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public MemberInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
            return new MemberInfo(kVar, tVar, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements c {
        private ByteString C;
        private ByteString D;
        private long E;
        private int F;
        private int G;
        private long H;
        private long I;
        private int J;
        private long K;
        private long L;
        private int M;
        private int N;
        private int P;
        private client.ClientIdentity Q;
        private bu<client.ClientIdentity, client.ClientIdentity.b, client.b> R;
        private client.ClientPresence S;
        private bu<client.ClientPresence, client.ClientPresence.b, client.c> T;
        private int U;
        private List<MyRole> V;
        private bp<MyRole, MyRole.b, e> W;
        private int X;
        private long Y;
        private int Z;

        /* renamed from: a0, reason: collision with root package name */
        private int f381308a0;

        /* renamed from: b0, reason: collision with root package name */
        private MemberState f381309b0;

        /* renamed from: c0, reason: collision with root package name */
        private bu<MemberState, MemberState.b, d> f381310c0;

        /* renamed from: d0, reason: collision with root package name */
        private RobotState f381311d0;

        /* renamed from: e0, reason: collision with root package name */
        private bu<RobotState, RobotState.b, f> f381312e0;

        /* renamed from: f0, reason: collision with root package name */
        private ByteString f381313f0;

        /* renamed from: g0, reason: collision with root package name */
        private ByteString f381314g0;

        /* renamed from: h0, reason: collision with root package name */
        private ByteString f381315h0;

        /* renamed from: i, reason: collision with root package name */
        private int f381316i;

        /* renamed from: i0, reason: collision with root package name */
        private ByteString f381317i0;

        /* renamed from: j0, reason: collision with root package name */
        private int f381318j0;

        /* renamed from: k0, reason: collision with root package name */
        private int f381319k0;

        /* renamed from: l0, reason: collision with root package name */
        private int f381320l0;

        /* renamed from: m, reason: collision with root package name */
        private long f381321m;

        /* renamed from: m0, reason: collision with root package name */
        private ByteString f381322m0;

        /* renamed from: n0, reason: collision with root package name */
        private int f381323n0;

        /* renamed from: o0, reason: collision with root package name */
        private int f381324o0;

        /* renamed from: p0, reason: collision with root package name */
        private int f381325p0;

        /* renamed from: q0, reason: collision with root package name */
        private DressUp f381326q0;

        /* renamed from: r0, reason: collision with root package name */
        private bu<DressUp, DressUp.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b> f381327r0;

        /* renamed from: s0, reason: collision with root package name */
        private int f381328s0;

        /* renamed from: t0, reason: collision with root package name */
        private int f381329t0;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                w();
            }
        }

        private void u() {
            if ((this.f381316i & 1) == 0) {
                this.V = new ArrayList(this.V);
                this.f381316i |= 1;
            }
        }

        private bp<MyRole, MyRole.b, e> w() {
            if (this.W == null) {
                List<MyRole> list = this.V;
                boolean z16 = true;
                if ((this.f381316i & 1) == 0) {
                    z16 = false;
                }
                this.W = new bp<>(list, z16, h(), isClean());
                this.V = null;
            }
            return this.W;
        }

        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(ar arVar) {
            if (arVar instanceof MemberInfo) {
                return B((MemberInfo) arVar);
            }
            super.mergeFrom(arVar);
            return this;
        }

        public b B(MemberInfo memberInfo) {
            if (memberInfo == MemberInfo.getDefaultInstance()) {
                return this;
            }
            if (memberInfo.getUint64MemberUin() != 0) {
                l0(memberInfo.getUint64MemberUin());
            }
            ByteString bytesMemberName = memberInfo.getBytesMemberName();
            ByteString byteString = ByteString.EMPTY;
            if (bytesMemberName != byteString) {
                H(memberInfo.getBytesMemberName());
            }
            if (memberInfo.getBytesNickName() != byteString) {
                I(memberInfo.getBytesNickName());
            }
            if (memberInfo.getUint64JoinTime() != 0) {
                k0(memberInfo.getUint64JoinTime());
            }
            if (memberInfo.uint32Role_ != 0) {
                f0(memberInfo.getUint32RoleValue());
            }
            if (memberInfo.getUint32Type() != 0) {
                g0(memberInfo.getUint32Type());
            }
            if (memberInfo.getUint64BeAdminTime() != 0) {
                h0(memberInfo.getUint64BeAdminTime());
            }
            if (memberInfo.getUint64Tinyid() != 0) {
                m0(memberInfo.getUint64Tinyid());
            }
            if (memberInfo.uint32ChannelRole_ != 0) {
                T(memberInfo.getUint32ChannelRoleValue());
            }
            if (memberInfo.getUint64JoinChannelTime() != 0) {
                j0(memberInfo.getUint64JoinChannelTime());
            }
            if (memberInfo.getUint64HeartbeatTime() != 0) {
                i0(memberInfo.getUint64HeartbeatTime());
            }
            if (memberInfo.getUint32GuildMuteFlag() != 0) {
                V(memberInfo.getUint32GuildMuteFlag());
            }
            if (memberInfo.getUint32IsInBlacklist() != 0) {
                a0(memberInfo.getUint32IsInBlacklist());
            }
            if (memberInfo.getUint32Platform() != 0) {
                e0(memberInfo.getUint32Platform());
            }
            if (memberInfo.hasClientIdentity()) {
                x(memberInfo.getClientIdentity());
            }
            if (memberInfo.hasPresence()) {
                D(memberInfo.getPresence());
            }
            if (memberInfo.getUint32IsInPrivateChannel() != 0) {
                b0(memberInfo.getUint32IsInPrivateChannel());
            }
            if (this.W == null) {
                if (!memberInfo.myRoles_.isEmpty()) {
                    if (this.V.isEmpty()) {
                        this.V = memberInfo.myRoles_;
                        this.f381316i &= -2;
                    } else {
                        u();
                        this.V.addAll(memberInfo.myRoles_);
                    }
                    onChanged();
                }
            } else if (!memberInfo.myRoles_.isEmpty()) {
                if (this.W.j()) {
                    this.W.f();
                    bp<MyRole, MyRole.b, e> bpVar = null;
                    this.W = null;
                    this.V = memberInfo.myRoles_;
                    this.f381316i &= -2;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        bpVar = w();
                    }
                    this.W = bpVar;
                } else {
                    this.W.b(memberInfo.myRoles_);
                }
            }
            if (memberInfo.getIsInReqRoleId() != 0) {
                O(memberInfo.getIsInReqRoleId());
            }
            if (memberInfo.getShutUpExpireTime() != 0) {
                Q(memberInfo.getShutUpExpireTime());
            }
            if (memberInfo.getUint32GuildRobotMuteStatus() != 0) {
                W(memberInfo.getUint32GuildRobotMuteStatus());
            }
            if (memberInfo.getUint32GuildRobotPunishmentStatus() != 0) {
                X(memberInfo.getUint32GuildRobotPunishmentStatus());
            }
            if (memberInfo.hasMemberState()) {
                C(memberInfo.getMemberState());
            }
            if (memberInfo.hasRobotState()) {
                E(memberInfo.getRobotState());
            }
            if (memberInfo.getBytesRobotTestGuilds() != byteString) {
                J(memberInfo.getBytesRobotTestGuilds());
            }
            if (memberInfo.getClientIdentityBytes() != byteString) {
                M(memberInfo.getClientIdentityBytes());
            }
            if (memberInfo.getBytesAvatarMeta() != byteString) {
                G(memberInfo.getBytesAvatarMeta());
            }
            if (memberInfo.getBytesTransData() != byteString) {
                K(memberInfo.getBytesTransData());
            }
            if (memberInfo.getUint32Gender() != 0) {
                U(memberInfo.getUint32Gender());
            }
            if (memberInfo.getUint32IsAllowedSharingScreen() != 0) {
                Y(memberInfo.getUint32IsAllowedSharingScreen());
            }
            if (memberInfo.transDataType_ != 0) {
                R(memberInfo.getTransDataTypeValue());
            }
            if (memberInfo.getChannelTransData() != byteString) {
                L(memberInfo.getChannelTransData());
            }
            if (memberInfo.getUint32IsBanned() != 0) {
                Z(memberInfo.getUint32IsBanned());
            }
            if (memberInfo.getUint32OnlineState() != 0) {
                d0(memberInfo.getUint32OnlineState());
            }
            if (memberInfo.getLevelRoleId() != 0) {
                P(memberInfo.getLevelRoleId());
            }
            if (memberInfo.hasDressUp()) {
                y(memberInfo.getDressUp());
            }
            if (memberInfo.getUint32MemberNameFlag() != 0) {
                c0(memberInfo.getUint32MemberNameFlag());
            }
            if (memberInfo.getUint32AvatarFlag() != 0) {
                S(memberInfo.getUint32AvatarFlag());
            }
            mo52mergeUnknownFields(((GeneratedMessageV3) memberInfo).unknownFields);
            onChanged();
            return this;
        }

        public b C(MemberState memberState) {
            bu<MemberState, MemberState.b, d> buVar = this.f381310c0;
            if (buVar == null) {
                MemberState memberState2 = this.f381309b0;
                if (memberState2 != null) {
                    this.f381309b0 = MemberState.newBuilder(memberState2).x(memberState).buildPartial();
                } else {
                    this.f381309b0 = memberState;
                }
                onChanged();
            } else {
                buVar.g(memberState);
            }
            return this;
        }

        public b D(client.ClientPresence clientPresence) {
            bu<client.ClientPresence, client.ClientPresence.b, client.c> buVar = this.T;
            if (buVar == null) {
                client.ClientPresence clientPresence2 = this.S;
                if (clientPresence2 != null) {
                    this.S = client.ClientPresence.newBuilder(clientPresence2).x(clientPresence).buildPartial();
                } else {
                    this.S = clientPresence;
                }
                onChanged();
            } else {
                buVar.g(clientPresence);
            }
            return this;
        }

        public b E(RobotState robotState) {
            bu<RobotState, RobotState.b, f> buVar = this.f381312e0;
            if (buVar == null) {
                RobotState robotState2 = this.f381311d0;
                if (robotState2 != null) {
                    this.f381311d0 = RobotState.newBuilder(robotState2).x(robotState).buildPartial();
                } else {
                    this.f381311d0 = robotState;
                }
                onChanged();
            } else {
                buVar.g(robotState);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public final b mo52mergeUnknownFields(cc ccVar) {
            return (b) super.mo52mergeUnknownFields(ccVar);
        }

        public b G(ByteString byteString) {
            byteString.getClass();
            this.f381315h0 = byteString;
            onChanged();
            return this;
        }

        public b H(ByteString byteString) {
            byteString.getClass();
            this.C = byteString;
            onChanged();
            return this;
        }

        public b I(ByteString byteString) {
            byteString.getClass();
            this.D = byteString;
            onChanged();
            return this;
        }

        public b J(ByteString byteString) {
            byteString.getClass();
            this.f381313f0 = byteString;
            onChanged();
            return this;
        }

        public b K(ByteString byteString) {
            byteString.getClass();
            this.f381317i0 = byteString;
            onChanged();
            return this;
        }

        public b L(ByteString byteString) {
            byteString.getClass();
            this.f381322m0 = byteString;
            onChanged();
            return this;
        }

        public b M(ByteString byteString) {
            byteString.getClass();
            this.f381314g0 = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        public b O(int i3) {
            this.X = i3;
            onChanged();
            return this;
        }

        public b P(int i3) {
            this.f381325p0 = i3;
            onChanged();
            return this;
        }

        public b Q(long j3) {
            this.Y = j3;
            onChanged();
            return this;
        }

        public b R(int i3) {
            this.f381320l0 = i3;
            onChanged();
            return this;
        }

        public b S(int i3) {
            this.f381329t0 = i3;
            onChanged();
            return this;
        }

        public b T(int i3) {
            this.J = i3;
            onChanged();
            return this;
        }

        public b U(int i3) {
            this.f381318j0 = i3;
            onChanged();
            return this;
        }

        public b V(int i3) {
            this.M = i3;
            onChanged();
            return this;
        }

        public b W(int i3) {
            this.Z = i3;
            onChanged();
            return this;
        }

        public b X(int i3) {
            this.f381308a0 = i3;
            onChanged();
            return this;
        }

        public b Y(int i3) {
            this.f381319k0 = i3;
            onChanged();
            return this;
        }

        public b Z(int i3) {
            this.f381323n0 = i3;
            onChanged();
            return this;
        }

        public b a0(int i3) {
            this.N = i3;
            onChanged();
            return this;
        }

        public b b0(int i3) {
            this.U = i3;
            onChanged();
            return this;
        }

        public b c0(int i3) {
            this.f381328s0 = i3;
            onChanged();
            return this;
        }

        public b d0(int i3) {
            this.f381324o0 = i3;
            onChanged();
            return this;
        }

        public b e0(int i3) {
            this.P = i3;
            onChanged();
            return this;
        }

        public b f0(int i3) {
            this.F = i3;
            onChanged();
            return this;
        }

        public b g0(int i3) {
            this.G = i3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
        public Descriptors.b getDescriptorForType() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381358c;
        }

        public b h0(long j3) {
            this.H = j3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e i() {
            return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381359d.e(MemberInfo.class, b.class);
        }

        public b i0(long j3) {
            this.L = j3;
            onChanged();
            return this;
        }

        public b j0(long j3) {
            this.K = j3;
            onChanged();
            return this;
        }

        public b k0(long j3) {
            this.E = j3;
            onChanged();
            return this;
        }

        public b l0(long j3) {
            this.f381321m = j3;
            onChanged();
            return this;
        }

        public b m0(long j3) {
            this.I = j3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public final b setUnknownFields(cc ccVar) {
            return (b) super.setUnknownFields(ccVar);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public MemberInfo build() {
            MemberInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
        }

        @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public MemberInfo buildPartial() {
            MemberInfo memberInfo = new MemberInfo(this, (a) null);
            memberInfo.uint64MemberUin_ = this.f381321m;
            memberInfo.bytesMemberName_ = this.C;
            memberInfo.bytesNickName_ = this.D;
            memberInfo.uint64JoinTime_ = this.E;
            memberInfo.uint32Role_ = this.F;
            memberInfo.uint32Type_ = this.G;
            memberInfo.uint64BeAdminTime_ = this.H;
            memberInfo.uint64Tinyid_ = this.I;
            memberInfo.uint32ChannelRole_ = this.J;
            memberInfo.uint64JoinChannelTime_ = this.K;
            memberInfo.uint64HeartbeatTime_ = this.L;
            memberInfo.uint32GuildMuteFlag_ = this.M;
            memberInfo.uint32IsInBlacklist_ = this.N;
            memberInfo.uint32Platform_ = this.P;
            bu<client.ClientIdentity, client.ClientIdentity.b, client.b> buVar = this.R;
            if (buVar == null) {
                memberInfo.clientIdentity_ = this.Q;
            } else {
                memberInfo.clientIdentity_ = buVar.b();
            }
            bu<client.ClientPresence, client.ClientPresence.b, client.c> buVar2 = this.T;
            if (buVar2 == null) {
                memberInfo.presence_ = this.S;
            } else {
                memberInfo.presence_ = buVar2.b();
            }
            memberInfo.uint32IsInPrivateChannel_ = this.U;
            bp<MyRole, MyRole.b, e> bpVar = this.W;
            if (bpVar != null) {
                memberInfo.myRoles_ = bpVar.d();
            } else {
                if ((this.f381316i & 1) != 0) {
                    this.V = Collections.unmodifiableList(this.V);
                    this.f381316i &= -2;
                }
                memberInfo.myRoles_ = this.V;
            }
            memberInfo.isInReqRoleId_ = this.X;
            memberInfo.shutUpExpireTime_ = this.Y;
            memberInfo.uint32GuildRobotMuteStatus_ = this.Z;
            memberInfo.uint32GuildRobotPunishmentStatus_ = this.f381308a0;
            bu<MemberState, MemberState.b, d> buVar3 = this.f381310c0;
            if (buVar3 == null) {
                memberInfo.memberState_ = this.f381309b0;
            } else {
                memberInfo.memberState_ = buVar3.b();
            }
            bu<RobotState, RobotState.b, f> buVar4 = this.f381312e0;
            if (buVar4 == null) {
                memberInfo.robotState_ = this.f381311d0;
            } else {
                memberInfo.robotState_ = buVar4.b();
            }
            memberInfo.bytesRobotTestGuilds_ = this.f381313f0;
            memberInfo.clientIdentityBytes_ = this.f381314g0;
            memberInfo.bytesAvatarMeta_ = this.f381315h0;
            memberInfo.bytesTransData_ = this.f381317i0;
            memberInfo.uint32Gender_ = this.f381318j0;
            memberInfo.uint32IsAllowedSharingScreen_ = this.f381319k0;
            memberInfo.transDataType_ = this.f381320l0;
            memberInfo.channelTransData_ = this.f381322m0;
            memberInfo.uint32IsBanned_ = this.f381323n0;
            memberInfo.uint32OnlineState_ = this.f381324o0;
            memberInfo.levelRoleId_ = this.f381325p0;
            bu<DressUp, DressUp.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b> buVar5 = this.f381327r0;
            if (buVar5 == null) {
                memberInfo.dressUp_ = this.f381326q0;
            } else {
                memberInfo.dressUp_ = buVar5.b();
            }
            memberInfo.uint32MemberNameFlag_ = this.f381328s0;
            memberInfo.uint32AvatarFlag_ = this.f381329t0;
            onBuilt();
            return memberInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clear() {
            super.clear();
            this.f381321m = 0L;
            ByteString byteString = ByteString.EMPTY;
            this.C = byteString;
            this.D = byteString;
            this.E = 0L;
            this.F = 0;
            this.G = 0;
            this.H = 0L;
            this.I = 0L;
            this.J = 0;
            this.K = 0L;
            this.L = 0L;
            this.M = 0;
            this.N = 0;
            this.P = 0;
            if (this.R == null) {
                this.Q = null;
            } else {
                this.Q = null;
                this.R = null;
            }
            if (this.T == null) {
                this.S = null;
            } else {
                this.S = null;
                this.T = null;
            }
            this.U = 0;
            bp<MyRole, MyRole.b, e> bpVar = this.W;
            if (bpVar == null) {
                this.V = Collections.emptyList();
                this.f381316i &= -2;
            } else {
                bpVar.e();
            }
            this.X = 0;
            this.Y = 0L;
            this.Z = 0;
            this.f381308a0 = 0;
            if (this.f381310c0 == null) {
                this.f381309b0 = null;
            } else {
                this.f381309b0 = null;
                this.f381310c0 = null;
            }
            if (this.f381312e0 == null) {
                this.f381311d0 = null;
            } else {
                this.f381311d0 = null;
                this.f381312e0 = null;
            }
            this.f381313f0 = byteString;
            this.f381314g0 = byteString;
            this.f381315h0 = byteString;
            this.f381317i0 = byteString;
            this.f381318j0 = 0;
            this.f381319k0 = 0;
            this.f381320l0 = 0;
            this.f381322m0 = byteString;
            this.f381323n0 = 0;
            this.f381324o0 = 0;
            this.f381325p0 = 0;
            if (this.f381327r0 == null) {
                this.f381326q0 = null;
            } else {
                this.f381326q0 = null;
                this.f381327r0 = null;
            }
            this.f381328s0 = 0;
            this.f381329t0 = 0;
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
        public MemberInfo getDefaultInstanceForType() {
            return MemberInfo.getDefaultInstance();
        }

        public b x(client.ClientIdentity clientIdentity) {
            bu<client.ClientIdentity, client.ClientIdentity.b, client.b> buVar = this.R;
            if (buVar == null) {
                client.ClientIdentity clientIdentity2 = this.Q;
                if (clientIdentity2 != null) {
                    this.Q = client.ClientIdentity.newBuilder(clientIdentity2).x(clientIdentity).buildPartial();
                } else {
                    this.Q = clientIdentity;
                }
                onChanged();
            } else {
                buVar.g(clientIdentity);
            }
            return this;
        }

        public b y(DressUp dressUp) {
            bu<DressUp, DressUp.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b> buVar = this.f381327r0;
            if (buVar == null) {
                DressUp dressUp2 = this.f381326q0;
                if (dressUp2 != null) {
                    this.f381326q0 = DressUp.newBuilder(dressUp2).x(dressUp).buildPartial();
                } else {
                    this.f381326q0 = dressUp;
                }
                onChanged();
            } else {
                buVar.g(dressUp);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(k kVar, t tVar) throws IOException {
            MemberInfo memberInfo = null;
            try {
                try {
                    MemberInfo memberInfo2 = (MemberInfo) MemberInfo.f381307e.g(kVar, tVar);
                    if (memberInfo2 != null) {
                        B(memberInfo2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e16) {
                    MemberInfo memberInfo3 = (MemberInfo) e16.getUnfinishedMessage();
                    try {
                        throw e16.unwrapIOException();
                    } catch (Throwable th5) {
                        th = th5;
                        memberInfo = memberInfo3;
                        if (memberInfo != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (memberInfo != null) {
                    B(memberInfo);
                }
                throw th;
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        b() {
            ByteString byteString = ByteString.EMPTY;
            this.C = byteString;
            this.D = byteString;
            this.F = 0;
            this.J = 0;
            this.V = Collections.emptyList();
            this.f381313f0 = byteString;
            this.f381314g0 = byteString;
            this.f381315h0 = byteString;
            this.f381317i0 = byteString;
            this.f381320l0 = 0;
            this.f381322m0 = byteString;
            maybeForceBuilderInitialization();
        }

        b(GeneratedMessageV3.c cVar) {
            super(cVar);
            ByteString byteString = ByteString.EMPTY;
            this.C = byteString;
            this.D = byteString;
            this.F = 0;
            this.J = 0;
            this.V = Collections.emptyList();
            this.f381313f0 = byteString;
            this.f381314g0 = byteString;
            this.f381315h0 = byteString;
            this.f381317i0 = byteString;
            this.f381320l0 = 0;
            this.f381322m0 = byteString;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ MemberInfo(k kVar, t tVar, a aVar) throws InvalidProtocolBufferException {
        this(kVar, tVar);
    }

    public static MemberInfo getDefaultInstance() {
        return f381306d;
    }

    public static final Descriptors.b getDescriptor() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381358c;
    }

    public static b newBuilder() {
        return f381306d.toBuilder();
    }

    public static MemberInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381307e, inputStream);
    }

    public static MemberInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return f381307e.d(byteBuffer);
    }

    public static bg<MemberInfo> parser() {
        return f381307e;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MemberInfo)) {
            return super.equals(obj);
        }
        MemberInfo memberInfo = (MemberInfo) obj;
        if (getUint64MemberUin() != memberInfo.getUint64MemberUin() || !getBytesMemberName().equals(memberInfo.getBytesMemberName()) || !getBytesNickName().equals(memberInfo.getBytesNickName()) || getUint64JoinTime() != memberInfo.getUint64JoinTime() || this.uint32Role_ != memberInfo.uint32Role_ || getUint32Type() != memberInfo.getUint32Type() || getUint64BeAdminTime() != memberInfo.getUint64BeAdminTime() || getUint64Tinyid() != memberInfo.getUint64Tinyid() || this.uint32ChannelRole_ != memberInfo.uint32ChannelRole_ || getUint64JoinChannelTime() != memberInfo.getUint64JoinChannelTime() || getUint64HeartbeatTime() != memberInfo.getUint64HeartbeatTime() || getUint32GuildMuteFlag() != memberInfo.getUint32GuildMuteFlag() || getUint32IsInBlacklist() != memberInfo.getUint32IsInBlacklist() || getUint32Platform() != memberInfo.getUint32Platform() || hasClientIdentity() != memberInfo.hasClientIdentity()) {
            return false;
        }
        if ((hasClientIdentity() && !getClientIdentity().equals(memberInfo.getClientIdentity())) || hasPresence() != memberInfo.hasPresence()) {
            return false;
        }
        if ((hasPresence() && !getPresence().equals(memberInfo.getPresence())) || getUint32IsInPrivateChannel() != memberInfo.getUint32IsInPrivateChannel() || !getMyRolesList().equals(memberInfo.getMyRolesList()) || getIsInReqRoleId() != memberInfo.getIsInReqRoleId() || getShutUpExpireTime() != memberInfo.getShutUpExpireTime() || getUint32GuildRobotMuteStatus() != memberInfo.getUint32GuildRobotMuteStatus() || getUint32GuildRobotPunishmentStatus() != memberInfo.getUint32GuildRobotPunishmentStatus() || hasMemberState() != memberInfo.hasMemberState()) {
            return false;
        }
        if ((hasMemberState() && !getMemberState().equals(memberInfo.getMemberState())) || hasRobotState() != memberInfo.hasRobotState()) {
            return false;
        }
        if ((hasRobotState() && !getRobotState().equals(memberInfo.getRobotState())) || !getBytesRobotTestGuilds().equals(memberInfo.getBytesRobotTestGuilds()) || !getClientIdentityBytes().equals(memberInfo.getClientIdentityBytes()) || !getBytesAvatarMeta().equals(memberInfo.getBytesAvatarMeta()) || !getBytesTransData().equals(memberInfo.getBytesTransData()) || getUint32Gender() != memberInfo.getUint32Gender() || getUint32IsAllowedSharingScreen() != memberInfo.getUint32IsAllowedSharingScreen() || this.transDataType_ != memberInfo.transDataType_ || !getChannelTransData().equals(memberInfo.getChannelTransData()) || getUint32IsBanned() != memberInfo.getUint32IsBanned() || getUint32OnlineState() != memberInfo.getUint32OnlineState() || getLevelRoleId() != memberInfo.getLevelRoleId() || hasDressUp() != memberInfo.hasDressUp()) {
            return false;
        }
        if ((!hasDressUp() || getDressUp().equals(memberInfo.getDressUp())) && getUint32MemberNameFlag() == memberInfo.getUint32MemberNameFlag() && getUint32AvatarFlag() == memberInfo.getUint32AvatarFlag() && this.unknownFields.equals(memberInfo.unknownFields)) {
            return true;
        }
        return false;
    }

    public ByteString getBytesAvatarMeta() {
        return this.bytesAvatarMeta_;
    }

    public ByteString getBytesMemberName() {
        return this.bytesMemberName_;
    }

    public ByteString getBytesNickName() {
        return this.bytesNickName_;
    }

    public ByteString getBytesRobotTestGuilds() {
        return this.bytesRobotTestGuilds_;
    }

    public ByteString getBytesTransData() {
        return this.bytesTransData_;
    }

    public ByteString getChannelTransData() {
        return this.channelTransData_;
    }

    public client.ClientIdentity getClientIdentity() {
        client.ClientIdentity clientIdentity = this.clientIdentity_;
        if (clientIdentity == null) {
            return client.ClientIdentity.getDefaultInstance();
        }
        return clientIdentity;
    }

    public ByteString getClientIdentityBytes() {
        return this.clientIdentityBytes_;
    }

    public client.b getClientIdentityOrBuilder() {
        return getClientIdentity();
    }

    public DressUp getDressUp() {
        DressUp dressUp = this.dressUp_;
        if (dressUp == null) {
            return DressUp.getDefaultInstance();
        }
        return dressUp;
    }

    public com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.b getDressUpOrBuilder() {
        return getDressUp();
    }

    public int getIsInReqRoleId() {
        return this.isInReqRoleId_;
    }

    public int getLevelRoleId() {
        return this.levelRoleId_;
    }

    public MemberState getMemberState() {
        MemberState memberState = this.memberState_;
        if (memberState == null) {
            return MemberState.getDefaultInstance();
        }
        return memberState;
    }

    public d getMemberStateOrBuilder() {
        return getMemberState();
    }

    public MyRole getMyRoles(int i3) {
        return this.myRoles_.get(i3);
    }

    public int getMyRolesCount() {
        return this.myRoles_.size();
    }

    public List<MyRole> getMyRolesList() {
        return this.myRoles_;
    }

    public e getMyRolesOrBuilder(int i3) {
        return this.myRoles_.get(i3);
    }

    public List<? extends e> getMyRolesOrBuilderList() {
        return this.myRoles_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
    public bg<MemberInfo> getParserForType() {
        return f381307e;
    }

    public client.ClientPresence getPresence() {
        client.ClientPresence clientPresence = this.presence_;
        if (clientPresence == null) {
            return client.ClientPresence.getDefaultInstance();
        }
        return clientPresence;
    }

    public client.c getPresenceOrBuilder() {
        return getPresence();
    }

    public RobotState getRobotState() {
        RobotState robotState = this.robotState_;
        if (robotState == null) {
            return RobotState.getDefaultInstance();
        }
        return robotState;
    }

    public f getRobotStateOrBuilder() {
        return getRobotState();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public int getSerializedSize() {
        int i3;
        int i16 = this.memoizedSize;
        if (i16 != -1) {
            return i16;
        }
        long j3 = this.uint64MemberUin_;
        if (j3 != 0) {
            i3 = CodedOutputStream.a0(1, j3) + 0;
        } else {
            i3 = 0;
        }
        if (!this.bytesMemberName_.isEmpty()) {
            i3 += CodedOutputStream.h(2, this.bytesMemberName_);
        }
        if (!this.bytesNickName_.isEmpty()) {
            i3 += CodedOutputStream.h(3, this.bytesNickName_);
        }
        long j16 = this.uint64JoinTime_;
        if (j16 != 0) {
            i3 += CodedOutputStream.a0(4, j16);
        }
        if (this.uint32Role_ != RoleType.Role_Normal_Member.getNumber()) {
            i3 += CodedOutputStream.l(5, this.uint32Role_);
        }
        int i17 = this.uint32Type_;
        if (i17 != 0) {
            i3 += CodedOutputStream.Y(6, i17);
        }
        long j17 = this.uint64BeAdminTime_;
        if (j17 != 0) {
            i3 += CodedOutputStream.a0(7, j17);
        }
        long j18 = this.uint64Tinyid_;
        if (j18 != 0) {
            i3 += CodedOutputStream.a0(8, j18);
        }
        if (this.uint32ChannelRole_ != ChannelRoleType.Role_Invalid.getNumber()) {
            i3 += CodedOutputStream.l(9, this.uint32ChannelRole_);
        }
        long j19 = this.uint64JoinChannelTime_;
        if (j19 != 0) {
            i3 += CodedOutputStream.a0(10, j19);
        }
        long j26 = this.uint64HeartbeatTime_;
        if (j26 != 0) {
            i3 += CodedOutputStream.a0(11, j26);
        }
        int i18 = this.uint32GuildMuteFlag_;
        if (i18 != 0) {
            i3 += CodedOutputStream.Y(12, i18);
        }
        int i19 = this.uint32IsInBlacklist_;
        if (i19 != 0) {
            i3 += CodedOutputStream.Y(13, i19);
        }
        int i26 = this.uint32Platform_;
        if (i26 != 0) {
            i3 += CodedOutputStream.Y(14, i26);
        }
        if (this.clientIdentity_ != null) {
            i3 += CodedOutputStream.G(15, getClientIdentity());
        }
        if (this.presence_ != null) {
            i3 += CodedOutputStream.G(16, getPresence());
        }
        int i27 = this.uint32IsInPrivateChannel_;
        if (i27 != 0) {
            i3 += CodedOutputStream.Y(17, i27);
        }
        for (int i28 = 0; i28 < this.myRoles_.size(); i28++) {
            i3 += CodedOutputStream.G(18, this.myRoles_.get(i28));
        }
        int i29 = this.isInReqRoleId_;
        if (i29 != 0) {
            i3 += CodedOutputStream.Y(19, i29);
        }
        long j27 = this.shutUpExpireTime_;
        if (j27 != 0) {
            i3 += CodedOutputStream.a0(20, j27);
        }
        int i36 = this.uint32GuildRobotMuteStatus_;
        if (i36 != 0) {
            i3 += CodedOutputStream.Y(21, i36);
        }
        int i37 = this.uint32GuildRobotPunishmentStatus_;
        if (i37 != 0) {
            i3 += CodedOutputStream.Y(22, i37);
        }
        if (this.memberState_ != null) {
            i3 += CodedOutputStream.G(23, getMemberState());
        }
        if (this.robotState_ != null) {
            i3 += CodedOutputStream.G(24, getRobotState());
        }
        if (!this.bytesRobotTestGuilds_.isEmpty()) {
            i3 += CodedOutputStream.h(25, this.bytesRobotTestGuilds_);
        }
        if (!this.clientIdentityBytes_.isEmpty()) {
            i3 += CodedOutputStream.h(27, this.clientIdentityBytes_);
        }
        if (!this.bytesAvatarMeta_.isEmpty()) {
            i3 += CodedOutputStream.h(28, this.bytesAvatarMeta_);
        }
        if (!this.bytesTransData_.isEmpty()) {
            i3 += CodedOutputStream.h(29, this.bytesTransData_);
        }
        int i38 = this.uint32Gender_;
        if (i38 != 0) {
            i3 += CodedOutputStream.Y(30, i38);
        }
        int i39 = this.uint32IsAllowedSharingScreen_;
        if (i39 != 0) {
            i3 += CodedOutputStream.Y(31, i39);
        }
        if (this.transDataType_ != ChannelTransDataType.CHANNEL_TRANS_DATATYPE_DEFAUTL.getNumber()) {
            i3 += CodedOutputStream.l(32, this.transDataType_);
        }
        if (!this.channelTransData_.isEmpty()) {
            i3 += CodedOutputStream.h(33, this.channelTransData_);
        }
        int i46 = this.uint32IsBanned_;
        if (i46 != 0) {
            i3 += CodedOutputStream.Y(34, i46);
        }
        int i47 = this.uint32OnlineState_;
        if (i47 != 0) {
            i3 += CodedOutputStream.Y(35, i47);
        }
        int i48 = this.levelRoleId_;
        if (i48 != 0) {
            i3 += CodedOutputStream.Y(36, i48);
        }
        if (this.dressUp_ != null) {
            i3 += CodedOutputStream.G(37, getDressUp());
        }
        int i49 = this.uint32MemberNameFlag_;
        if (i49 != 0) {
            i3 += CodedOutputStream.Y(38, i49);
        }
        int i56 = this.uint32AvatarFlag_;
        if (i56 != 0) {
            i3 += CodedOutputStream.Y(39, i56);
        }
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime_;
    }

    public ChannelTransDataType getTransDataType() {
        ChannelTransDataType valueOf = ChannelTransDataType.valueOf(this.transDataType_);
        if (valueOf == null) {
            return ChannelTransDataType.UNRECOGNIZED;
        }
        return valueOf;
    }

    public int getTransDataTypeValue() {
        return this.transDataType_;
    }

    public int getUint32AvatarFlag() {
        return this.uint32AvatarFlag_;
    }

    public ChannelRoleType getUint32ChannelRole() {
        ChannelRoleType valueOf = ChannelRoleType.valueOf(this.uint32ChannelRole_);
        if (valueOf == null) {
            return ChannelRoleType.UNRECOGNIZED;
        }
        return valueOf;
    }

    public int getUint32ChannelRoleValue() {
        return this.uint32ChannelRole_;
    }

    public int getUint32Gender() {
        return this.uint32Gender_;
    }

    public int getUint32GuildMuteFlag() {
        return this.uint32GuildMuteFlag_;
    }

    public int getUint32GuildRobotMuteStatus() {
        return this.uint32GuildRobotMuteStatus_;
    }

    public int getUint32GuildRobotPunishmentStatus() {
        return this.uint32GuildRobotPunishmentStatus_;
    }

    public int getUint32IsAllowedSharingScreen() {
        return this.uint32IsAllowedSharingScreen_;
    }

    public int getUint32IsBanned() {
        return this.uint32IsBanned_;
    }

    public int getUint32IsInBlacklist() {
        return this.uint32IsInBlacklist_;
    }

    public int getUint32IsInPrivateChannel() {
        return this.uint32IsInPrivateChannel_;
    }

    public int getUint32MemberNameFlag() {
        return this.uint32MemberNameFlag_;
    }

    public int getUint32OnlineState() {
        return this.uint32OnlineState_;
    }

    public int getUint32Platform() {
        return this.uint32Platform_;
    }

    public RoleType getUint32Role() {
        RoleType valueOf = RoleType.valueOf(this.uint32Role_);
        if (valueOf == null) {
            return RoleType.UNRECOGNIZED;
        }
        return valueOf;
    }

    public int getUint32RoleValue() {
        return this.uint32Role_;
    }

    public int getUint32Type() {
        return this.uint32Type_;
    }

    public long getUint64BeAdminTime() {
        return this.uint64BeAdminTime_;
    }

    public long getUint64HeartbeatTime() {
        return this.uint64HeartbeatTime_;
    }

    public long getUint64JoinChannelTime() {
        return this.uint64JoinChannelTime_;
    }

    public long getUint64JoinTime() {
        return this.uint64JoinTime_;
    }

    public long getUint64MemberUin() {
        return this.uint64MemberUin_;
    }

    public long getUint64Tinyid() {
        return this.uint64Tinyid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
    public final cc getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasClientIdentity() {
        if (this.clientIdentity_ != null) {
            return true;
        }
        return false;
    }

    public boolean hasDressUp() {
        if (this.dressUp_ != null) {
            return true;
        }
        return false;
    }

    public boolean hasMemberState() {
        if (this.memberState_ != null) {
            return true;
        }
        return false;
    }

    public boolean hasPresence() {
        if (this.presence_ != null) {
            return true;
        }
        return false;
    }

    public boolean hasRobotState() {
        if (this.robotState_ != null) {
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getUint64MemberUin())) * 37) + 2) * 53) + getBytesMemberName().hashCode()) * 37) + 3) * 53) + getBytesNickName().hashCode()) * 37) + 4) * 53) + ad.h(getUint64JoinTime())) * 37) + 5) * 53) + this.uint32Role_) * 37) + 6) * 53) + getUint32Type()) * 37) + 7) * 53) + ad.h(getUint64BeAdminTime())) * 37) + 8) * 53) + ad.h(getUint64Tinyid())) * 37) + 9) * 53) + this.uint32ChannelRole_) * 37) + 10) * 53) + ad.h(getUint64JoinChannelTime())) * 37) + 11) * 53) + ad.h(getUint64HeartbeatTime())) * 37) + 12) * 53) + getUint32GuildMuteFlag()) * 37) + 13) * 53) + getUint32IsInBlacklist()) * 37) + 14) * 53) + getUint32Platform();
        if (hasClientIdentity()) {
            hashCode = (((hashCode * 37) + 15) * 53) + getClientIdentity().hashCode();
        }
        if (hasPresence()) {
            hashCode = (((hashCode * 37) + 16) * 53) + getPresence().hashCode();
        }
        int uint32IsInPrivateChannel = (((hashCode * 37) + 17) * 53) + getUint32IsInPrivateChannel();
        if (getMyRolesCount() > 0) {
            uint32IsInPrivateChannel = (((uint32IsInPrivateChannel * 37) + 18) * 53) + getMyRolesList().hashCode();
        }
        int isInReqRoleId = (((((((((((((((uint32IsInPrivateChannel * 37) + 19) * 53) + getIsInReqRoleId()) * 37) + 20) * 53) + ad.h(getShutUpExpireTime())) * 37) + 21) * 53) + getUint32GuildRobotMuteStatus()) * 37) + 22) * 53) + getUint32GuildRobotPunishmentStatus();
        if (hasMemberState()) {
            isInReqRoleId = (((isInReqRoleId * 37) + 23) * 53) + getMemberState().hashCode();
        }
        if (hasRobotState()) {
            isInReqRoleId = (((isInReqRoleId * 37) + 24) * 53) + getRobotState().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((isInReqRoleId * 37) + 25) * 53) + getBytesRobotTestGuilds().hashCode()) * 37) + 27) * 53) + getClientIdentityBytes().hashCode()) * 37) + 28) * 53) + getBytesAvatarMeta().hashCode()) * 37) + 29) * 53) + getBytesTransData().hashCode()) * 37) + 30) * 53) + getUint32Gender()) * 37) + 31) * 53) + getUint32IsAllowedSharingScreen()) * 37) + 32) * 53) + this.transDataType_) * 37) + 33) * 53) + getChannelTransData().hashCode()) * 37) + 34) * 53) + getUint32IsBanned()) * 37) + 35) * 53) + getUint32OnlineState()) * 37) + 36) * 53) + getLevelRoleId();
        if (hasDressUp()) {
            hashCode2 = (((hashCode2 * 37) + 37) * 53) + getDressUp().hashCode();
        }
        int uint32MemberNameFlag = (((((((((hashCode2 * 37) + 38) * 53) + getUint32MemberNameFlag()) * 37) + 39) * 53) + getUint32AvatarFlag()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = uint32MemberNameFlag;
        return uint32MemberNameFlag;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.f381359d.e(MemberInfo.class, b.class);
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
        return new MemberInfo();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j3 = this.uint64MemberUin_;
        if (j3 != 0) {
            codedOutputStream.d1(1, j3);
        }
        if (!this.bytesMemberName_.isEmpty()) {
            codedOutputStream.q0(2, this.bytesMemberName_);
        }
        if (!this.bytesNickName_.isEmpty()) {
            codedOutputStream.q0(3, this.bytesNickName_);
        }
        long j16 = this.uint64JoinTime_;
        if (j16 != 0) {
            codedOutputStream.d1(4, j16);
        }
        if (this.uint32Role_ != RoleType.Role_Normal_Member.getNumber()) {
            codedOutputStream.u0(5, this.uint32Role_);
        }
        int i3 = this.uint32Type_;
        if (i3 != 0) {
            codedOutputStream.b1(6, i3);
        }
        long j17 = this.uint64BeAdminTime_;
        if (j17 != 0) {
            codedOutputStream.d1(7, j17);
        }
        long j18 = this.uint64Tinyid_;
        if (j18 != 0) {
            codedOutputStream.d1(8, j18);
        }
        if (this.uint32ChannelRole_ != ChannelRoleType.Role_Invalid.getNumber()) {
            codedOutputStream.u0(9, this.uint32ChannelRole_);
        }
        long j19 = this.uint64JoinChannelTime_;
        if (j19 != 0) {
            codedOutputStream.d1(10, j19);
        }
        long j26 = this.uint64HeartbeatTime_;
        if (j26 != 0) {
            codedOutputStream.d1(11, j26);
        }
        int i16 = this.uint32GuildMuteFlag_;
        if (i16 != 0) {
            codedOutputStream.b1(12, i16);
        }
        int i17 = this.uint32IsInBlacklist_;
        if (i17 != 0) {
            codedOutputStream.b1(13, i17);
        }
        int i18 = this.uint32Platform_;
        if (i18 != 0) {
            codedOutputStream.b1(14, i18);
        }
        if (this.clientIdentity_ != null) {
            codedOutputStream.K0(15, getClientIdentity());
        }
        if (this.presence_ != null) {
            codedOutputStream.K0(16, getPresence());
        }
        int i19 = this.uint32IsInPrivateChannel_;
        if (i19 != 0) {
            codedOutputStream.b1(17, i19);
        }
        for (int i26 = 0; i26 < this.myRoles_.size(); i26++) {
            codedOutputStream.K0(18, this.myRoles_.get(i26));
        }
        int i27 = this.isInReqRoleId_;
        if (i27 != 0) {
            codedOutputStream.b1(19, i27);
        }
        long j27 = this.shutUpExpireTime_;
        if (j27 != 0) {
            codedOutputStream.d1(20, j27);
        }
        int i28 = this.uint32GuildRobotMuteStatus_;
        if (i28 != 0) {
            codedOutputStream.b1(21, i28);
        }
        int i29 = this.uint32GuildRobotPunishmentStatus_;
        if (i29 != 0) {
            codedOutputStream.b1(22, i29);
        }
        if (this.memberState_ != null) {
            codedOutputStream.K0(23, getMemberState());
        }
        if (this.robotState_ != null) {
            codedOutputStream.K0(24, getRobotState());
        }
        if (!this.bytesRobotTestGuilds_.isEmpty()) {
            codedOutputStream.q0(25, this.bytesRobotTestGuilds_);
        }
        if (!this.clientIdentityBytes_.isEmpty()) {
            codedOutputStream.q0(27, this.clientIdentityBytes_);
        }
        if (!this.bytesAvatarMeta_.isEmpty()) {
            codedOutputStream.q0(28, this.bytesAvatarMeta_);
        }
        if (!this.bytesTransData_.isEmpty()) {
            codedOutputStream.q0(29, this.bytesTransData_);
        }
        int i36 = this.uint32Gender_;
        if (i36 != 0) {
            codedOutputStream.b1(30, i36);
        }
        int i37 = this.uint32IsAllowedSharingScreen_;
        if (i37 != 0) {
            codedOutputStream.b1(31, i37);
        }
        if (this.transDataType_ != ChannelTransDataType.CHANNEL_TRANS_DATATYPE_DEFAUTL.getNumber()) {
            codedOutputStream.u0(32, this.transDataType_);
        }
        if (!this.channelTransData_.isEmpty()) {
            codedOutputStream.q0(33, this.channelTransData_);
        }
        int i38 = this.uint32IsBanned_;
        if (i38 != 0) {
            codedOutputStream.b1(34, i38);
        }
        int i39 = this.uint32OnlineState_;
        if (i39 != 0) {
            codedOutputStream.b1(35, i39);
        }
        int i46 = this.levelRoleId_;
        if (i46 != 0) {
            codedOutputStream.b1(36, i46);
        }
        if (this.dressUp_ != null) {
            codedOutputStream.K0(37, getDressUp());
        }
        int i47 = this.uint32MemberNameFlag_;
        if (i47 != 0) {
            codedOutputStream.b1(38, i47);
        }
        int i48 = this.uint32AvatarFlag_;
        if (i48 != 0) {
            codedOutputStream.b1(39, i48);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    /* synthetic */ MemberInfo(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(MemberInfo memberInfo) {
        return f381306d.toBuilder().B(memberInfo);
    }

    public static MemberInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        return f381307e.m(byteBuffer, tVar);
    }

    MemberInfo(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MemberInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381307e, inputStream, tVar);
    }

    public static MemberInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return f381307e.b(byteString);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
    public MemberInfo getDefaultInstanceForType() {
        return f381306d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b toBuilder() {
        a aVar = null;
        return this == f381306d ? new b(aVar) : new b(aVar).B(this);
    }

    public static MemberInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return f381307e.a(byteString, tVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
    public b newBuilderForType() {
        return newBuilder();
    }

    MemberInfo() {
        this.memoizedIsInitialized = (byte) -1;
        ByteString byteString = ByteString.EMPTY;
        this.bytesMemberName_ = byteString;
        this.bytesNickName_ = byteString;
        this.uint32Role_ = 0;
        this.uint32ChannelRole_ = 0;
        this.myRoles_ = Collections.emptyList();
        this.bytesRobotTestGuilds_ = byteString;
        this.clientIdentityBytes_ = byteString;
        this.bytesAvatarMeta_ = byteString;
        this.bytesTransData_ = byteString;
        this.transDataType_ = 0;
        this.channelTransData_ = byteString;
    }

    public static MemberInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return f381307e.j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    public static MemberInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return f381307e.i(bArr, tVar);
    }

    public static MemberInfo parseFrom(InputStream inputStream) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseWithIOException(f381307e, inputStream);
    }

    public static MemberInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseWithIOException(f381307e, inputStream, tVar);
    }

    public static MemberInfo parseFrom(k kVar) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseWithIOException(f381307e, kVar);
    }

    public static MemberInfo parseFrom(k kVar, t tVar) throws IOException {
        return (MemberInfo) GeneratedMessageV3.parseWithIOException(f381307e, kVar, tVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0014. Please report as an issue. */
    MemberInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
        this();
        tVar.getClass();
        cc.b g16 = cc.g();
        boolean z16 = false;
        boolean z17 = false;
        while (!z16) {
            try {
                try {
                    int J = kVar.J();
                    switch (J) {
                        case 0:
                            z16 = true;
                        case 8:
                            this.uint64MemberUin_ = kVar.L();
                        case 18:
                            this.bytesMemberName_ = kVar.q();
                        case 26:
                            this.bytesNickName_ = kVar.q();
                        case 32:
                            this.uint64JoinTime_ = kVar.L();
                        case 40:
                            this.uint32Role_ = kVar.s();
                        case 48:
                            this.uint32Type_ = kVar.K();
                        case 56:
                            this.uint64BeAdminTime_ = kVar.L();
                        case 64:
                            this.uint64Tinyid_ = kVar.L();
                        case 72:
                            this.uint32ChannelRole_ = kVar.s();
                        case 80:
                            this.uint64JoinChannelTime_ = kVar.L();
                        case 88:
                            this.uint64HeartbeatTime_ = kVar.L();
                        case 96:
                            this.uint32GuildMuteFlag_ = kVar.K();
                        case 104:
                            this.uint32IsInBlacklist_ = kVar.K();
                        case 112:
                            this.uint32Platform_ = kVar.K();
                        case 122:
                            client.ClientIdentity clientIdentity = this.clientIdentity_;
                            client.ClientIdentity.b builder = clientIdentity != null ? clientIdentity.toBuilder() : null;
                            client.ClientIdentity clientIdentity2 = (client.ClientIdentity) kVar.z(client.ClientIdentity.parser(), tVar);
                            this.clientIdentity_ = clientIdentity2;
                            if (builder != null) {
                                builder.x(clientIdentity2);
                                this.clientIdentity_ = builder.buildPartial();
                            }
                        case 130:
                            client.ClientPresence clientPresence = this.presence_;
                            client.ClientPresence.b builder2 = clientPresence != null ? clientPresence.toBuilder() : null;
                            client.ClientPresence clientPresence2 = (client.ClientPresence) kVar.z(client.ClientPresence.parser(), tVar);
                            this.presence_ = clientPresence2;
                            if (builder2 != null) {
                                builder2.x(clientPresence2);
                                this.presence_ = builder2.buildPartial();
                            }
                        case 136:
                            this.uint32IsInPrivateChannel_ = kVar.K();
                        case 146:
                            boolean z18 = (z17 ? 1 : 0) & true;
                            z17 = z17;
                            if (!z18) {
                                this.myRoles_ = new ArrayList();
                                z17 = (z17 ? 1 : 0) | true;
                            }
                            this.myRoles_.add((MyRole) kVar.z(MyRole.parser(), tVar));
                        case 152:
                            this.isInReqRoleId_ = kVar.K();
                        case 160:
                            this.shutUpExpireTime_ = kVar.L();
                        case 168:
                            this.uint32GuildRobotMuteStatus_ = kVar.K();
                        case 176:
                            this.uint32GuildRobotPunishmentStatus_ = kVar.K();
                        case 186:
                            MemberState memberState = this.memberState_;
                            MemberState.b builder3 = memberState != null ? memberState.toBuilder() : null;
                            MemberState memberState2 = (MemberState) kVar.z(MemberState.parser(), tVar);
                            this.memberState_ = memberState2;
                            if (builder3 != null) {
                                builder3.x(memberState2);
                                this.memberState_ = builder3.buildPartial();
                            }
                        case 194:
                            RobotState robotState = this.robotState_;
                            RobotState.b builder4 = robotState != null ? robotState.toBuilder() : null;
                            RobotState robotState2 = (RobotState) kVar.z(RobotState.parser(), tVar);
                            this.robotState_ = robotState2;
                            if (builder4 != null) {
                                builder4.x(robotState2);
                                this.robotState_ = builder4.buildPartial();
                            }
                        case 202:
                            this.bytesRobotTestGuilds_ = kVar.q();
                        case 218:
                            this.clientIdentityBytes_ = kVar.q();
                        case 226:
                            this.bytesAvatarMeta_ = kVar.q();
                        case 234:
                            this.bytesTransData_ = kVar.q();
                        case 240:
                            this.uint32Gender_ = kVar.K();
                        case 248:
                            this.uint32IsAllowedSharingScreen_ = kVar.K();
                        case 256:
                            this.transDataType_ = kVar.s();
                        case 266:
                            this.channelTransData_ = kVar.q();
                        case 272:
                            this.uint32IsBanned_ = kVar.K();
                        case FilterEnum.MIC_PTU_TRANS_XINXIAN /* 280 */:
                            this.uint32OnlineState_ = kVar.K();
                        case 288:
                            this.levelRoleId_ = kVar.K();
                        case 298:
                            DressUp dressUp = this.dressUp_;
                            DressUp.b builder5 = dressUp != null ? dressUp.toBuilder() : null;
                            DressUp dressUp2 = (DressUp) kVar.z(DressUp.parser(), tVar);
                            this.dressUp_ = dressUp2;
                            if (builder5 != null) {
                                builder5.x(dressUp2);
                                this.dressUp_ = builder5.buildPartial();
                            }
                        case 304:
                            this.uint32MemberNameFlag_ = kVar.K();
                        case 312:
                            this.uint32AvatarFlag_ = kVar.K();
                        default:
                            if (!parseUnknownField(kVar, g16, tVar, J)) {
                                z16 = true;
                            }
                    }
                } catch (InvalidProtocolBufferException e16) {
                    throw e16.setUnfinishedMessage(this);
                } catch (IOException e17) {
                    throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                }
            } finally {
                if ((z17 ? 1 : 0) & true) {
                    this.myRoles_ = Collections.unmodifiableList(this.myRoles_);
                }
                this.unknownFields = g16.build();
                makeExtensionsImmutable();
            }
        }
    }
}
