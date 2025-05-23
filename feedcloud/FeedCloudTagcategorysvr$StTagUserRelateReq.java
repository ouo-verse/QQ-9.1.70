package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagUserRelateReq extends MessageMicro<FeedCloudTagcategorysvr$StTagUserRelateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uid", SquareJSConst.Params.PARAMS_NUMS, "gpsInfo"}, new Object[]{"", null, null}, FeedCloudTagcategorysvr$StTagUserRelateReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$StTagUserRelateNum> nums = PBField.initRepeatMessage(FeedCloudTagcategorysvr$StTagUserRelateNum.class);
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
}
