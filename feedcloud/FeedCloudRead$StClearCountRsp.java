package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StClearCountRsp extends MessageMicro<FeedCloudRead$StClearCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "result", "clearCountRspInfos"}, new Object[]{null, null, null}, FeedCloudRead$StClearCountRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
    public final PBRepeatMessageField<FeedCloudRead$StClearCountRspInfo> clearCountRspInfos = PBField.initRepeatMessage(FeedCloudRead$StClearCountRspInfo.class);
}
