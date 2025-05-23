package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StListTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StListTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"infos", "pageSize", "pageCurrent", "pageTotal"}, new Object[]{null, 0, 0, 0}, FeedCloudTagbasesvr$StListTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StTagBaseInfo> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StTagBaseInfo.class);
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public final PBInt32Field pageCurrent = PBField.initInt32(0);
    public final PBInt32Field pageTotal = PBField.initInt32(0);
}
