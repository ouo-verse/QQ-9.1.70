package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StAddPicTagMapInfo extends MessageMicro<FeedCloudTagcategorysvr$StAddPicTagMapInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"picTag", "recomTag", "mapStatus"}, new Object[]{"", "", 0}, FeedCloudTagcategorysvr$StAddPicTagMapInfo.class);
    public final PBStringField picTag = PBField.initString("");
    public final PBStringField recomTag = PBField.initString("");
    public final PBEnumField mapStatus = PBField.initEnum(0);
}
