package msf.registerproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class register_proxy$GroupList extends MessageMicro<register_proxy$GroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112}, new String[]{"group_code", "group_seq", "member_seq", "mask", "redpack_time", "has_msg", "group_flag", "group_type", "group_name_seq", "group_member_seq", "uin_flag_ex2", "important_msg_latest_seq", "group_max_event_seq", "guild_id"}, new Object[]{0L, 0L, 0L, 0L, 0L, Boolean.FALSE, 0L, 0L, 0, 0, 0, 0, 0, 0L}, register_proxy$GroupList.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field group_seq = PBField.initUInt64(0);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
    public final PBUInt64Field mask = PBField.initUInt64(0);
    public final PBUInt64Field redpack_time = PBField.initUInt64(0);
    public final PBBoolField has_msg = PBField.initBool(false);
    public final PBInt64Field group_flag = PBField.initInt64(0);
    public final PBUInt64Field group_type = PBField.initUInt64(0);
    public final PBUInt32Field group_name_seq = PBField.initUInt32(0);
    public final PBUInt32Field group_member_seq = PBField.initUInt32(0);
    public final PBUInt32Field uin_flag_ex2 = PBField.initUInt32(0);
    public final PBUInt32Field important_msg_latest_seq = PBField.initUInt32(0);
    public final PBUInt32Field group_max_event_seq = PBField.initUInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
}
