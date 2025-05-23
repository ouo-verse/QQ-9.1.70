package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StTagCategoryAllReq extends MessageMicro<FeedCloudTagcategorysvr$StTagCategoryAllReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"gpsInfo", "reqType"}, new Object[]{null, 0}, FeedCloudTagcategorysvr$StTagCategoryAllReq.class);
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
    public final PBInt32Field reqType = PBField.initInt32(0);
}
