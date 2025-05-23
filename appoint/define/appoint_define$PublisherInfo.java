package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class appoint_define$PublisherInfo extends MessageMicro<appoint_define$PublisherInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname;
    public final PBBytesField bytes_stranger_declare;
    public appoint_define$CommonLabel msg_common_label;
    public final PBStringField str_constellation;
    public final PBStringField str_distance;
    public final PBStringField str_vipinfo;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_charm;
    public final PBUInt32Field uint32_charm_level;
    public final PBUInt32Field uint32_chatflag;
    public final PBUInt32Field uint32_chatup_count;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_godflag;
    public final PBUInt32Field uint32_history_flag;
    public final PBUInt32Field uint32_marriage;
    public final PBUInt32Field uint32_profession;
    public final PBUInt32Field uint32_pub_number;
    public final PBUInt32Field uint32_recent_vistor_time;
    public final PBUInt32Field uint32_recommend;
    public final PBUInt64Field uint64_followflag;
    public final PBUInt64Field uint64_friend_uin;
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 112, 120, 128, 138, 144, 154, 160, 168, 176}, new String[]{"uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "str_constellation", "uint32_profession", "str_distance", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_chatflag", "uint32_chatup_count", "uint32_charm", "uint32_charm_level", "uint32_pub_number", "msg_common_label", "uint32_recent_vistor_time", "bytes_stranger_declare", "uint64_friend_uin", "uint32_history_flag", "uint64_followflag"}, new Object[]{0L, byteStringMicro, 0, 0, "", 0, "", 0, "", 0, 0, 0, 0, 0, 0, 0, null, 0, byteStringMicro, 0L, 0, 0L}, appoint_define$PublisherInfo.class);
    }

    public appoint_define$PublisherInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nickname = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
        this.str_constellation = PBField.initString("");
        this.uint32_profession = PBField.initUInt32(0);
        this.str_distance = PBField.initString("");
        this.uint32_marriage = PBField.initUInt32(0);
        this.str_vipinfo = PBField.initString("");
        this.uint32_recommend = PBField.initUInt32(0);
        this.uint32_godflag = PBField.initUInt32(0);
        this.uint32_chatflag = PBField.initUInt32(0);
        this.uint32_chatup_count = PBField.initUInt32(0);
        this.uint32_charm = PBField.initUInt32(0);
        this.uint32_charm_level = PBField.initUInt32(0);
        this.uint32_pub_number = PBField.initUInt32(0);
        this.msg_common_label = new appoint_define$CommonLabel();
        this.uint32_recent_vistor_time = PBField.initUInt32(0);
        this.bytes_stranger_declare = PBField.initBytes(byteStringMicro);
        this.uint64_friend_uin = PBField.initUInt64(0L);
        this.uint32_history_flag = PBField.initUInt32(0);
        this.uint64_followflag = PBField.initUInt64(0L);
    }
}
