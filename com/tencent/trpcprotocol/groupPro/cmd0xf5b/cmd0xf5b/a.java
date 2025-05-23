package com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.tencent.trpcprotocol.group_pro.common.client.client;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final Descriptors.b f381356a;

    /* renamed from: b, reason: collision with root package name */
    static final GeneratedMessageV3.e f381357b;

    /* renamed from: c, reason: collision with root package name */
    static final Descriptors.b f381358c;

    /* renamed from: d, reason: collision with root package name */
    static final GeneratedMessageV3.e f381359d;

    /* renamed from: e, reason: collision with root package name */
    static final Descriptors.b f381360e;

    /* renamed from: f, reason: collision with root package name */
    static final GeneratedMessageV3.e f381361f;

    /* renamed from: g, reason: collision with root package name */
    static final Descriptors.b f381362g;

    /* renamed from: h, reason: collision with root package name */
    static final GeneratedMessageV3.e f381363h;

    /* renamed from: i, reason: collision with root package name */
    static final Descriptors.b f381364i;

    /* renamed from: j, reason: collision with root package name */
    static final GeneratedMessageV3.e f381365j;

    /* renamed from: k, reason: collision with root package name */
    static final Descriptors.b f381366k;

    /* renamed from: l, reason: collision with root package name */
    static final GeneratedMessageV3.e f381367l;

    /* renamed from: m, reason: collision with root package name */
    static final Descriptors.b f381368m;

    /* renamed from: n, reason: collision with root package name */
    static final GeneratedMessageV3.e f381369n;

    /* renamed from: o, reason: collision with root package name */
    static final Descriptors.b f381370o;

    /* renamed from: p, reason: collision with root package name */
    static final GeneratedMessageV3.e f381371p;

    /* renamed from: q, reason: collision with root package name */
    static final Descriptors.b f381372q;

    /* renamed from: r, reason: collision with root package name */
    static final GeneratedMessageV3.e f381373r;

    /* renamed from: s, reason: collision with root package name */
    private static Descriptors.FileDescriptor f381374s = Descriptors.FileDescriptor.u(new String[]{"\n\u000ecmd0xf5b.proto\u0012\u0017trpc.group_pro.cmd0xf5b\u001a\fclient.proto\"!\n\u0007DressUp\u0012\u0016\n\u000eavatar_pendant\u0018\u0001 \u0001(\t\"\u008e\n\n\nMemberInfo\u0012\u0019\n\u0011uint64_member_uin\u0018\u0001 \u0001(\u0004\u0012\u0019\n\u0011bytes_member_name\u0018\u0002 \u0001(\f\u0012\u0017\n\u000fbytes_nick_name\u0018\u0003 \u0001(\f\u0012\u0018\n\u0010uint64_join_time\u0018\u0004 \u0001(\u0004\u00126\n\u000buint32_role\u0018\u0005 \u0001(\u000e2!.trpc.group_pro.cmd0xf5b.RoleType\u0012\u0013\n\u000buint32_type\u0018\u0006 \u0001(\r\u0012\u001c\n\u0014uint64_be_admin_time\u0018\u0007 \u0001(\u0004\u0012\u0015\n\ruint64_tinyid\u0018\b \u0001(\u0004\u0012E\n\u0013uint32_channel_role\u0018\t \u0001(\u000e2(.trpc.group_pro.cmd0xf5b.ChannelRoleType\u0012 \n\u0018uint64_join_channel_time\u0018\n \u0001(\u0004\u0012\u001d\n\u0015uint64_heartbeat_time\u0018\u000b \u0001(\u0004\u0012\u001e\n\u0016uint32_guild_mute_flag\u0018\f \u0001(\r\u0012\u001e\n\u0016uint32_is_in_blacklist\u0018\r \u0001(\r\u0012\u0017\n\u000fuint32_platform\u0018\u000e \u0001(\r\u0012$\n\u001cuint32_is_in_private_channel\u0018\u0011 \u0001(\r\u00121\n\bmy_roles\u0018\u0012 \u0003(\u000b2\u001f.trpc.group_pro.cmd0xf5b.MyRole\u0012\u0019\n\u0011is_in_req_role_id\u0018\u0013 \u0001(\r\u0012\u001b\n\u0013shut_up_expire_time\u0018\u0014 \u0001(\u0004\u0012&\n\u001euint32_guild_robot_mute_status\u0018\u0015 \u0001(\r\u0012,\n$uint32_guild_robot_punishment_status\u0018\u0016 \u0001(\r\u0012:\n\fmember_state\u0018\u0017 \u0001(\u000b2$.trpc.group_pro.cmd0xf5b.MemberState\u00128\n\u000brobot_state\u0018\u0018 \u0001(\u000b2#.trpc.group_pro.cmd0xf5b.RobotState\u0012\u001f\n\u0017bytes_robot_test_guilds\u0018\u0019 \u0001(\f\u0012\u001d\n\u0015client_identity_bytes\u0018\u001b \u0001(\f\u0012\u0019\n\u0011bytes_avatar_meta\u0018\u001c \u0001(\f\u0012\u0018\n\u0010bytes_trans_data\u0018\u001d \u0001(\f\u0012\u0015\n\ruint32_gender\u0018\u001e \u0001(\r\u0012(\n uint32_is_allowed_sharing_screen\u0018\u001f \u0001(\r\u0012F\n\u000ftrans_data_type\u0018  \u0001(\u000e2-.trpc.group_pro.cmd0xf5b.ChannelTransDataType\u0012\u001a\n\u0012channel_trans_data\u0018! \u0001(\f\u0012\u0018\n\u0010uint32_is_banned\u0018\" \u0001(\r\u0012\u001b\n\u0013uint32_online_state\u0018# \u0001(\r\u0012\u0015\n\rlevel_role_id\u0018$ \u0001(\r\u00122\n\bdress_up\u0018% \u0001(\u000b2 .trpc.group_pro.cmd0xf5b.DressUp\u0012\u001f\n\u0017uint32_member_name_flag\u0018& \u0001(\r\u0012\u001a\n\u0012uint32_avatar_flag\u0018' \u0001(\r\"R\n\u000bMemberState\u0012C\n\u0011team_member_state\u0018\u0001 \u0001(\u000b2(.trpc.group_pro.cmd0xf5b.TeamMemberState\"\u00d2\u0001\n\u000fTeamMemberState\u0012\r\n\u0005state\u0018\u0001 \u0001(\r\u0012\u0012\n\nstate_desc\u0018\u0002 \u0001(\t\u0012\u0012\n\nlabel_icon\u0018\u0003 \u0001(\t\u0012\u0010\n\bapp_icon\u0018\u0004 \u0001(\t\u00128\n\trole_type\u0018\u0005 \u0001(\u000e2%.trpc.group_pro.cmd0xf5b.TeamRoleType\u0012<\n\rschema_config\u0018\u0006 \u0001(\u000b2%.trpc.group_pro.cmd0xf5b.SchemaConfig\"\u00a1\u0001\n\nRobotState\u00126\n\nrobot_type\u0018\u0001 \u0001(\u000e2\".trpc.group_pro.cmd0xf5b.RobotType\u0012A\n\u0010team_robot_state\u0018\u0002 \u0001(\u000b2'.trpc.group_pro.cmd0xf5b.TeamRobotState\u0012\u0018\n\u0010is_channel_admin\u0018\u0003 \u0001(\b\"\u00c5\u0001\n\u000eTeamRobotState\u0012\r\n\u0005state\u0018\u0001 \u0001(\r\u0012\u0012\n\nstate_desc\u0018\u0002 \u0001(\t\u0012<\n\rschema_config\u0018\u0003 \u0001(\u000b2%.trpc.group_pro.cmd0xf5b.SchemaConfig\u00129\n\fteam_members\u0018\u0004 \u0003(\u000b2#.trpc.group_pro.cmd0xf5b.TeamMember\u0012\u0017\n\u000fstart_timestamp\u0018\u0005 \u0001(\u0003\"\u001c\n\nTeamMember\u0012\u000e\n\u0006tinyid\u0018\u0001 \u0001(\u0004\",\n\fSchemaConfig\u0012\u000e\n\u0006schema\u0018\u0001 \u0001(\t\u0012\f\n\u0004text\u0018\u0002 \u0001(\t\"\u0019\n\u0006MyRole\u0012\u000f\n\u0007role_id\u0018\u0001 \u0001(\u0004*B\n\bRoleType\u0012\u0016\n\u0012Role_Normal_Member\u0010\u0000\u0012\u000e\n\nRole_Admin\u0010\u0001\u0012\u000e\n\nRole_Owner\u0010\u0002*O\n\u000fChannelRoleType\u0012\u0010\n\fRole_Invalid\u0010\u0000\u0012\u0015\n\u0011Role_Voice_Normal\u0010\u0001\u0012\u0013\n\u000fRole_Voice_Host\u0010\u0002*b\n\fTeamRoleType\u0012\u001b\n\u0017TEAM_ROLE_TYPE_AUDIENCE\u0010\u0000\u0012\u001a\n\u0016TEAM_ROLE_TYPE_CAPTAIN\u0010\u0001\u0012\u0019\n\u0015TEAM_ROLE_TYPE_MEMBER\u0010\u0002*_\n\u0014ChannelTransDataType\u0012\"\n\u001eCHANNEL_TRANS_DATATYPE_DEFAUTL\u0010\u0000\u0012#\n\u001fCHANNEL_TRANS_DATATYPE_USERLIST\u0010\u0001*8\n\tRobotType\u0012\u0016\n\u0012ROBOT_TYPE_DEFAULT\u0010\u0000\u0012\u0013\n\u000fROBOT_TYPE_TEAM\u0010\u0001Bh\n3com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5bP\u0001Z/git.code.oa.com/trpcprotocol/group_pro/cmd0xf5bb\u0006proto3"}, new Descriptors.FileDescriptor[]{client.e()});

    static {
        Descriptors.b bVar = a().p().get(0);
        f381356a = bVar;
        f381357b = new GeneratedMessageV3.e(bVar, new String[]{"AvatarPendant"});
        Descriptors.b bVar2 = a().p().get(1);
        f381358c = bVar2;
        f381359d = new GeneratedMessageV3.e(bVar2, new String[]{"Uint64MemberUin", "BytesMemberName", "BytesNickName", "Uint64JoinTime", "Uint32Role", "Uint32Type", "Uint64BeAdminTime", "Uint64Tinyid", "Uint32ChannelRole", "Uint64JoinChannelTime", "Uint64HeartbeatTime", "Uint32GuildMuteFlag", "Uint32IsInBlacklist", "Uint32Platform", "Uint32IsInPrivateChannel", "MyRoles", "IsInReqRoleId", "ShutUpExpireTime", "Uint32GuildRobotMuteStatus", "Uint32GuildRobotPunishmentStatus", "MemberState", "RobotState", "BytesRobotTestGuilds", "ClientIdentityBytes", "BytesAvatarMeta", "BytesTransData", "Uint32Gender", "Uint32IsAllowedSharingScreen", "TransDataType", "ChannelTransData", "Uint32IsBanned", "Uint32OnlineState", "LevelRoleId", "DressUp", "Uint32MemberNameFlag", "Uint32AvatarFlag"});
        Descriptors.b bVar3 = a().p().get(2);
        f381360e = bVar3;
        f381361f = new GeneratedMessageV3.e(bVar3, new String[]{"TeamMemberState"});
        Descriptors.b bVar4 = a().p().get(3);
        f381362g = bVar4;
        f381363h = new GeneratedMessageV3.e(bVar4, new String[]{"State", "StateDesc", "LabelIcon", "AppIcon", "RoleType", "SchemaConfig"});
        Descriptors.b bVar5 = a().p().get(4);
        f381364i = bVar5;
        f381365j = new GeneratedMessageV3.e(bVar5, new String[]{"RobotType", "TeamRobotState", "IsChannelAdmin"});
        Descriptors.b bVar6 = a().p().get(5);
        f381366k = bVar6;
        f381367l = new GeneratedMessageV3.e(bVar6, new String[]{"State", "StateDesc", "SchemaConfig", "TeamMembers", "StartTimestamp"});
        Descriptors.b bVar7 = a().p().get(6);
        f381368m = bVar7;
        f381369n = new GeneratedMessageV3.e(bVar7, new String[]{"Tinyid"});
        Descriptors.b bVar8 = a().p().get(7);
        f381370o = bVar8;
        f381371p = new GeneratedMessageV3.e(bVar8, new String[]{"Schema", "Text"});
        Descriptors.b bVar9 = a().p().get(8);
        f381372q = bVar9;
        f381373r = new GeneratedMessageV3.e(bVar9, new String[]{"RoleId"});
        client.e();
    }

    public static Descriptors.FileDescriptor a() {
        return f381374s;
    }
}
