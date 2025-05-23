package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StAddPicTagMapRsp extends MessageMicro<FeedCloudTagcategorysvr$StAddPicTagMapRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"errCode", "msg", "infos"}, new Object[]{0, "", null}, FeedCloudTagcategorysvr$StAddPicTagMapRsp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398474msg = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$StAddPicTagMapInfo> infos = PBField.initRepeatMessage(FeedCloudTagcategorysvr$StAddPicTagMapInfo.class);
}
