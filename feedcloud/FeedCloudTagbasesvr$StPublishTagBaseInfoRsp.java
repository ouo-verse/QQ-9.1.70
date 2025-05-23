package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StPublishTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StPublishTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"publishResult", "notOkInfo", "publishStatus"}, new Object[]{0, null, 0}, FeedCloudTagbasesvr$StPublishTagBaseInfoRsp.class);
    public final PBEnumField publishResult = PBField.initEnum(0);
    public FeedCloudTagbasesvr$StEditTagInfo notOkInfo = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfo>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"addTag", "delTag", "editTagName", "editTag", "addCategory", "sortTag"}, new Object[]{null, null, null, null, null, null}, FeedCloudTagbasesvr$StEditTagInfo.class);
        public FeedCloudTagbasesvr$StEditTagInfoAddTag addTag = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoAddTag>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoAddTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, FeedCloudTagbasesvr$StEditTagInfoAddTag.class);
            public FeedCloudTagbasesvr$StTagBaseInfo info = new FeedCloudTagbasesvr$StTagBaseInfo();
        };
        public FeedCloudTagbasesvr$StEditTagInfoDelTag delTag = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoDelTag>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoDelTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, FeedCloudTagbasesvr$StEditTagInfoDelTag.class);
            public FeedCloudTagbasesvr$StTagBaseInfo info = new FeedCloudTagbasesvr$StTagBaseInfo();
        };
        public FeedCloudTagbasesvr$StEditTagInfoEditTagName editTagName = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoEditTagName>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoEditTagName
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"oldInfo", "newInfo"}, new Object[]{null, null}, FeedCloudTagbasesvr$StEditTagInfoEditTagName.class);
            public FeedCloudTagbasesvr$StTagBaseInfo oldInfo = new FeedCloudTagbasesvr$StTagBaseInfo();
            public FeedCloudTagbasesvr$StTagBaseInfo newInfo = new FeedCloudTagbasesvr$StTagBaseInfo();
        };
        public FeedCloudTagbasesvr$StEditTagInfoEditTag editTag = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoEditTag>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoEditTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, FeedCloudTagbasesvr$StEditTagInfoEditTag.class);
            public FeedCloudTagbasesvr$StTagBaseInfo info = new FeedCloudTagbasesvr$StTagBaseInfo();
        };
        public FeedCloudTagbasesvr$StEditTagInfoAddCategory addCategory = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoAddCategory>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoAddCategory
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagCategory"}, new Object[]{""}, FeedCloudTagbasesvr$StEditTagInfoAddCategory.class);
            public final PBStringField tagCategory = PBField.initString("");
        };
        public FeedCloudTagbasesvr$StEditTagInfoSortTag sortTag = new MessageMicro<FeedCloudTagbasesvr$StEditTagInfoSortTag>() { // from class: feedcloud.FeedCloudTagbasesvr$StEditTagInfoSortTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tagCategory", "infos"}, new Object[]{"", null}, FeedCloudTagbasesvr$StEditTagInfoSortTag.class);
            public final PBStringField tagCategory = PBField.initString("");
            public final PBRepeatMessageField<FeedCloudTagbasesvr$StTagBaseInfo> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StTagBaseInfo.class);
        };
    };
    public final PBEnumField publishStatus = PBField.initEnum(0);
}
