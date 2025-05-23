package guild;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$ChannelUserInfo extends MessageMicro<GuildChannelBase$ChannelUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_identity_bytes;
    public final PBBytesField client_identity_bytes_json;
    public final PBEnumField role_type;
    public GuildChannelBase$VoiceLiveInfo voice_live_info;
    public GuildChannelBase$ClientIdentity client_identity = new MessageMicro<GuildChannelBase$ClientIdentity>() { // from class: guild.GuildChannelBase$ClientIdentity
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "desc"}, new Object[]{0, ""}, GuildChannelBase$ClientIdentity.class);
        public final PBUInt32Field client_id = PBField.initUInt32(0);
        public final PBStringField desc = PBField.initString("");
    };
    public final PBEnumField member_type = PBField.initEnum(0);
    public GuildChannelBase$ChannelUserPermission permission = new MessageMicro<GuildChannelBase$ChannelUserPermission>() { // from class: guild.GuildChannelBase$ChannelUserPermission
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField allow_read_feed = PBField.initBool(false);
        public final PBBoolField allow_write_feed = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"allow_read_feed", "allow_write_feed"}, new Object[]{bool, bool}, GuildChannelBase$ChannelUserPermission.class);
        }
    };
    public final PBRepeatMessageField<GuildChannelBase$RoleGroupInfo> role_groups = PBField.initRepeatMessage(GuildChannelBase$RoleGroupInfo.class);

    static {
        String[] strArr = {"client_identity", "member_type", QCircleDaTongConstant.ElementParamValue.PERMISSION, "role_groups", "client_identity_bytes", "role_type", "client_identity_bytes_json", "voice_live_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 58, 66}, strArr, new Object[]{null, 0, null, null, byteStringMicro, 0, byteStringMicro, null}, GuildChannelBase$ChannelUserInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [guild.GuildChannelBase$ClientIdentity] */
    /* JADX WARN: Type inference failed for: r0v4, types: [guild.GuildChannelBase$VoiceLiveInfo] */
    /* JADX WARN: Type inference failed for: r1v1, types: [guild.GuildChannelBase$ChannelUserPermission] */
    public GuildChannelBase$ChannelUserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_identity_bytes = PBField.initBytes(byteStringMicro);
        this.role_type = PBField.initEnum(0);
        this.client_identity_bytes_json = PBField.initBytes(byteStringMicro);
        this.voice_live_info = new MessageMicro<GuildChannelBase$VoiceLiveInfo>() { // from class: guild.GuildChannelBase$VoiceLiveInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField channel_name;
            public final PBRepeatMessageField<GuildChannelBase$ChannelStateInfo> channel_status_list;
            public final PBBytesField join_guild_sig;
            public final PBStringField main_source;
            public final PBStringField sub_source;
            public final PBUInt64Field guild_id = PBField.initUInt64(0);
            public final PBUInt64Field channel_id = PBField.initUInt64(0);
            public final PBUInt32Field channel_type = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66}, new String[]{"guild_id", "channel_id", "channel_type", "channel_name", "main_source", "sub_source", "join_guild_sig", "channel_status_list"}, new Object[]{0L, 0L, 0, byteStringMicro2, "", "", byteStringMicro2, null}, GuildChannelBase$VoiceLiveInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.channel_name = PBField.initBytes(byteStringMicro2);
                this.main_source = PBField.initString("");
                this.sub_source = PBField.initString("");
                this.join_guild_sig = PBField.initBytes(byteStringMicro2);
                this.channel_status_list = PBField.initRepeatMessage(GuildChannelBase$ChannelStateInfo.class);
            }
        };
    }
}
