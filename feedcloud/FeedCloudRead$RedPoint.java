package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.IGameCardManager;

/* loaded from: classes28.dex */
public final class FeedCloudRead$RedPoint extends MessageMicro<FeedCloudRead$RedPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82, 90, 98, 104}, new String[]{"profilleModify", "pendantManage", "profille_modify_detail", "pendant_manage_detail", IGameCardManager.VISITOR, "level_benefit_flag"}, new Object[]{0, 0, null, null, null, 0}, FeedCloudRead$RedPoint.class);
    public final PBInt32Field profilleModify = PBField.initInt32(0);
    public final PBInt32Field pendantManage = PBField.initInt32(0);
    public FeedCloudRead$RedPointDetail profille_modify_detail = new MessageMicro<FeedCloudRead$RedPointDetail>() { // from class: feedcloud.FeedCloudRead$RedPointDetail
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"icon", "text"}, new Object[]{"", ""}, FeedCloudRead$RedPointDetail.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
    };
    public FeedCloudRead$RedPointDetail pendant_manage_detail = new MessageMicro<FeedCloudRead$RedPointDetail>() { // from class: feedcloud.FeedCloudRead$RedPointDetail
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"icon", "text"}, new Object[]{"", ""}, FeedCloudRead$RedPointDetail.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
    };
    public FeedCloudRead$VisitorRedPointInfo visitor = new MessageMicro<FeedCloudRead$VisitorRedPointInfo>() { // from class: feedcloud.FeedCloudRead$VisitorRedPointInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"icons"}, new Object[]{""}, FeedCloudRead$VisitorRedPointInfo.class);
        public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public final PBInt32Field level_benefit_flag = PBField.initInt32(0);
}
