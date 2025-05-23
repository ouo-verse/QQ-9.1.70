package nearby_interact_state;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class interact_value$OneInteract extends MessageMicro<interact_value$OneInteract> {
    public static final int STATE_TYPE_AWARD_POST = 3;
    public static final int STATE_TYPE_FOLLOW = 9;
    public static final int STATE_TYPE_LIKE_COMMENT = 5;
    public static final int STATE_TYPE_LIKE_POST = 2;
    public static final int STATE_TYPE_NEARBY_LIKE_POST = 7;
    public static final int STATE_TYPE_NEARBY_REPLY_COMMENT = 8;
    public static final int STATE_TYPE_NEARBY_REPLY_POST = 6;
    public static final int STATE_TYPE_REPLY_COMMENT = 4;
    public static final int STATE_TYPE_REPLY_POST = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64, 72, 80}, new String[]{"uint32_state_type", "uint64_uin", "uint64_tinyid", "uint64_time", "msg_tribe", "msg_fresh_thing", "uint32_color2", "uint32_color3", "uint64_seq", "uint32_is_del"}, new Object[]{0, 0L, 0L, 0L, null, null, 0, 0, 0L, 0}, interact_value$OneInteract.class);
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public interact_value$Tribe msg_tribe = new interact_value$Tribe();
    public interact_value$FreshThing msg_fresh_thing = new interact_value$FreshThing();
    public final PBUInt32Field uint32_color2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color3 = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_is_del = PBField.initUInt32(0);
}
