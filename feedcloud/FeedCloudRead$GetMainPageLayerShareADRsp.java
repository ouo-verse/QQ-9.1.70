package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetMainPageLayerShareADRsp extends MessageMicro<FeedCloudRead$GetMainPageLayerShareADRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"items", "attach_info"}, new Object[]{null, ""}, FeedCloudRead$GetMainPageLayerShareADRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$ShareADItem> items = PBField.initRepeatMessage(FeedCloudRead$ShareADItem.class);
    public final PBStringField attach_info = PBField.initString("");
}
