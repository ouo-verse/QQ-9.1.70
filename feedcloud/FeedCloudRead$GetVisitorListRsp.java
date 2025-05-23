package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetVisitorListRsp extends MessageMicro<FeedCloudRead$GetVisitorListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBBoolField is_authed = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudRead$VisitorItem> visitors = PBField.initRepeatMessage(FeedCloudRead$VisitorItem.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField transfer_info = PBField.initString("");

    static {
        String[] strArr = {"ext_info", "is_authed", "visitors", PictureConst.KEY_HAS_MORE, "transfer_info"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, strArr, new Object[]{null, bool, null, bool, ""}, FeedCloudRead$GetVisitorListRsp.class);
    }
}
