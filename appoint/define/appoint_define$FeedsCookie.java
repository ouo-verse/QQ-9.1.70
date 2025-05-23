package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$FeedsCookie extends MessageMicro<appoint_define$FeedsCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"rpt_str_list", "uint32_pose", "bytes_cookie", "rpt_uint64_topics"}, new Object[]{"", 0, ByteStringMicro.EMPTY, 0L}, appoint_define$FeedsCookie.class);
    public final PBRepeatField<String> rpt_str_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_pose = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_topics = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
