package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketNumberRsp extends MessageMicro<FeedCloudDatacard$GetRedPocketNumberRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"count", "left_num", "check_num"}, new Object[]{0L, 0L, 0L}, FeedCloudDatacard$GetRedPocketNumberRsp.class);
    public final PBInt64Field count = PBField.initInt64(0);
    public final PBInt64Field left_num = PBField.initInt64(0);
    public final PBInt64Field check_num = PBField.initInt64(0);
}
