package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StAddPicTagMapReq extends MessageMicro<FeedCloudTagcategorysvr$StAddPicTagMapReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, FeedCloudTagcategorysvr$StAddPicTagMapReq.class);
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$StAddPicTagMapInfo> infos = PBField.initRepeatMessage(FeedCloudTagcategorysvr$StAddPicTagMapInfo.class);
}
