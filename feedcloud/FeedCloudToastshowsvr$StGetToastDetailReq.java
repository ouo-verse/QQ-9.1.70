package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StGetToastDetailReq extends MessageMicro<FeedCloudToastshowsvr$StGetToastDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "userId", "toastId", "busiReqData"}, new Object[]{null, "", "", ByteStringMicro.EMPTY}, FeedCloudToastshowsvr$StGetToastDetailReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField toastId = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}
