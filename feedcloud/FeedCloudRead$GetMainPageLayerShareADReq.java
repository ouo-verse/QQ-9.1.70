package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetMainPageLayerShareADReq extends MessageMicro<FeedCloudRead$GetMainPageLayerShareADReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"feed_ids", "adres", "attach_info", "dst_user_id"}, new Object[]{"", ByteStringMicro.EMPTY, "", ""}, FeedCloudRead$GetMainPageLayerShareADReq.class);
    public final PBRepeatField<String> feed_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField dst_user_id = PBField.initString("");
}
