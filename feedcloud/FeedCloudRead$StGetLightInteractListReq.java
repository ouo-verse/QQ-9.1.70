package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetLightInteractListReq extends MessageMicro<FeedCloudRead$StGetLightInteractListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 66}, new String[]{"extInfo", "type", "attachInfo", "id", "hostID", "feedID", "source", "busiTranparent"}, new Object[]{null, 0, "", "", "", "", 0, null}, FeedCloudRead$StGetLightInteractListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField attachInfo = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398471id = PBField.initString("");
    public final PBStringField hostID = PBField.initString("");
    public final PBStringField feedID = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
