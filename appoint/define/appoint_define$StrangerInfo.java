package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$StrangerInfo extends MessageMicro<appoint_define$StrangerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 58, 64, 72, 82, 88, 96, 104, 112, 120}, new String[]{"uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "uint32_dating", "uint32_list_idx", "str_constellation", "uint32_profession", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_charm", "uint32_charm_level", "uint64_uin"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, 0, 0, "", 0, 0, "", 0, 0, 0, 0, 0L}, appoint_define$StrangerInfo.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dating = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_idx = PBField.initUInt32(0);
    public final PBStringField str_constellation = PBField.initString("");
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
    public final PBStringField str_vipinfo = PBField.initString("");
    public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_godflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
