package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$BatchDelFromWatchLaterReq extends MessageMicro<FeedCloudWatchlater$BatchDelFromWatchLaterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"del_mode", "feed_id_list", "attach_info"}, new Object[]{0, "", ByteStringMicro.EMPTY}, FeedCloudWatchlater$BatchDelFromWatchLaterReq.class);
    public final PBEnumField del_mode = PBField.initEnum(0);
    public final PBRepeatField<String> feed_id_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBytesField attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
