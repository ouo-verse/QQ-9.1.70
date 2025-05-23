package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq extends MessageMicro<FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"feedId", PictureConst.KEY_CATEGORY_ID, "extInfo"}, new Object[]{"", 0, null}, FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBEnumField category_id = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
