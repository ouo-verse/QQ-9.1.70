package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$HotUserFeed extends MessageMicro<appoint_define$HotUserFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"str_feed_id", "uint32_praise_count", "uint64_publish_uid", "uint32_publish_time"}, new Object[]{"", 0, 0L, 0}, appoint_define$HotUserFeed.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_publish_uid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
}
