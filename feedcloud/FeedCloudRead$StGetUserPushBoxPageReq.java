package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserPushBoxPageReq extends MessageMicro<FeedCloudRead$StGetUserPushBoxPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"box_list_type", "extInfo", "attach_info", "sort_type"}, new Object[]{0, null, "", 0}, FeedCloudRead$StGetUserPushBoxPageReq.class);
    public final PBInt32Field box_list_type = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField attach_info = PBField.initString("");
    public final PBUInt32Field sort_type = PBField.initUInt32(0);
}
