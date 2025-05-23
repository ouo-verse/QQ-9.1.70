package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$FreshFeedInfo extends MessageMicro<appoint_define$FreshFeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint32_time", "str_feed_id", "uint64_feed_type"}, new Object[]{0L, 0, "", 0L}, appoint_define$FreshFeedInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt64Field uint64_feed_type = PBField.initUInt64(0);
}
