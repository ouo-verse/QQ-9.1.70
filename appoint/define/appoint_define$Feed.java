package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$Feed extends MessageMicro<appoint_define$Feed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_user_info", "msg_feed_info", "uint32_owner_flag"}, new Object[]{null, null, 0}, appoint_define$Feed.class);
    public appoint_define$PublisherInfo msg_user_info = new appoint_define$PublisherInfo();
    public appoint_define$FeedInfo msg_feed_info = new appoint_define$FeedInfo();
    public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
}
