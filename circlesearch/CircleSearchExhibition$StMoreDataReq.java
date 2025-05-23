package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StMoreDataReq extends MessageMicro<CircleSearchExhibition$StMoreDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ext_info", "type", "query"}, new Object[]{null, 0, ""}, CircleSearchExhibition$StMoreDataReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField query = PBField.initString("");
}
