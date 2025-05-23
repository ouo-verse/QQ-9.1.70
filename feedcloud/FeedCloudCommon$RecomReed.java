package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$RecomReed extends MessageMicro<FeedCloudCommon$RecomReed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"item_id", "tranfer"}, new Object[]{"", ByteStringMicro.EMPTY}, FeedCloudCommon$RecomReed.class);
    public final PBStringField item_id = PBField.initString("");
    public final PBBytesField tranfer = PBField.initBytes(ByteStringMicro.EMPTY);
}
