package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StGetPublishTagGuideRsp extends MessageMicro<FeedCloudTagcategorysvr$StGetPublishTagGuideRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"tagGuideScene", "tagGuideInfo"}, new Object[]{0, null}, FeedCloudTagcategorysvr$StGetPublishTagGuideRsp.class);
    public final PBInt32Field tagGuideScene = PBField.initInt32(0);
    public FeedCloudTagcategorysvr$TagGuideInfo tagGuideInfo = new MessageMicro<FeedCloudTagcategorysvr$TagGuideInfo>() { // from class: feedcloud.FeedCloudTagcategorysvr$TagGuideInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"tagName", "tagID", "describe", "icon", "button", "guideTitle", "nature"}, new Object[]{"", "", "", "", "", "", 0}, FeedCloudTagcategorysvr$TagGuideInfo.class);
        public final PBStringField tagName = PBField.initString("");
        public final PBStringField tagID = PBField.initString("");
        public final PBStringField describe = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public final PBStringField button = PBField.initString("");
        public final PBStringField guideTitle = PBField.initString("");
        public final PBInt32Field nature = PBField.initInt32(0);
    };
}
