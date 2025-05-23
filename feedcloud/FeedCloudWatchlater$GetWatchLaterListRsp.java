package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$GetWatchLaterListRsp extends MessageMicro<FeedCloudWatchlater$GetWatchLaterListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<FeedCloudWatchlater$Feed> feeds = PBField.initRepeatMessage(FeedCloudWatchlater$Feed.class);
    public final PBUInt32Field list_length = PBField.initUInt32(0);
    public final PBBoolField has_hidden = PBField.initBool(false);
    public final PBStringField bottom_text = PBField.initString("");
    public final PBBoolField is_finished = PBField.initBool(false);
    public final PBBytesField attach_info = PBField.initBytes(ByteStringMicro.EMPTY);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50}, new String[]{"feeds", "list_length", "has_hidden", "bottom_text", "is_finished", "attach_info"}, new Object[]{null, 0, bool, "", bool, ByteStringMicro.EMPTY}, FeedCloudWatchlater$GetWatchLaterListRsp.class);
    }
}
