package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class nt_msg_common$RoutingHead extends MessageMicro<nt_msg_common$RoutingHead> {
    static final MessageMicro.FieldMap __fieldMap__;
    public nt_msg_common$C2c c2c;
    public final PBUInt32Field from_appid;
    public final PBUInt32Field from_instid;
    public final PBBytesField from_uid;
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public nt_msg_common$Group group;
    public final PBBytesField to_uid;
    public final PBUInt64Field to_uin;

    static {
        String[] strArr = {ShortVideoConstants.FROM_UIN, "from_uid", "from_appid", "from_instid", "to_uin", "to_uid", "c2c", VipFunCallConstants.KEY_GROUP};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 66}, strArr, new Object[]{0L, byteStringMicro, 0, 0, 0L, byteStringMicro, null, null}, nt_msg_common$RoutingHead.class);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [msf.msgcomm.nt_msg_common$C2c] */
    /* JADX WARN: Type inference failed for: r0v4, types: [msf.msgcomm.nt_msg_common$Group] */
    public nt_msg_common$RoutingHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_uid = PBField.initBytes(byteStringMicro);
        this.from_appid = PBField.initUInt32(0);
        this.from_instid = PBField.initUInt32(0);
        this.to_uin = PBField.initUInt64(0L);
        this.to_uid = PBField.initBytes(byteStringMicro);
        this.c2c = new MessageMicro<nt_msg_common$C2c>() { // from class: msf.msgcomm.nt_msg_common$C2c
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], nt_msg_common$C2c.class);
        };
        this.group = new MessageMicro<nt_msg_common$Group>() { // from class: msf.msgcomm.nt_msg_common$Group
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField ext_group_key_info;
            public final PBBytesField group_card;
            public final PBUInt32Field group_card_type;
            public final PBUInt32Field group_level;
            public final PBBytesField group_name;
            public final PBUInt64Field group_code = PBField.initUInt64(0);
            public final PBUInt32Field group_type = PBField.initUInt32(0);
            public final PBUInt64Field group_info_seq = PBField.initUInt64(0);

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66}, new String[]{"group_code", "group_type", "group_info_seq", "group_card", "group_card_type", "group_level", "group_name", "ext_group_key_info"}, new Object[]{0L, 0, 0L, byteStringMicro2, 0, 0, byteStringMicro2, byteStringMicro2}, nt_msg_common$Group.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.group_card = PBField.initBytes(byteStringMicro2);
                this.group_card_type = PBField.initUInt32(0);
                this.group_level = PBField.initUInt32(0);
                this.group_name = PBField.initBytes(byteStringMicro2);
                this.ext_group_key_info = PBField.initBytes(byteStringMicro2);
            }
        };
    }
}
