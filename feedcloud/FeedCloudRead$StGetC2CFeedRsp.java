package feedcloud;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetC2CFeedRsp extends MessageMicro<FeedCloudRead$StGetC2CFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"extInfo", "vecFeed", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "busiRspData", "attchInfo", "share"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY, "", null}, FeedCloudRead$StGetC2CFeedRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field timeInterval = PBField.initUInt32(0);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attchInfo = PBField.initString("");
    public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
}
