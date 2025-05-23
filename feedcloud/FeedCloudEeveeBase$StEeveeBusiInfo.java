package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeBase$StEeveeBusiInfo extends MessageMicro<FeedCloudEeveeBase$StEeveeBusiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"appid", "msgMainType", "msgSubType", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "pushStr"}, new Object[]{0, 101, 1010001, ByteStringMicro.EMPTY, ""}, FeedCloudEeveeBase$StEeveeBusiInfo.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBEnumField msgMainType = PBField.initEnum(101);
    public final PBEnumField msgSubType = PBField.initEnum(1010001);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pushStr = PBField.initString("");
}
