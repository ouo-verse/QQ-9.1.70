package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StEditTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StEditTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"editInfos", "delPreEdit"}, new Object[]{null, Boolean.FALSE}, FeedCloudTagbasesvr$StEditTagBaseInfoReq.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StEditTagInfo> editInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr$StEditTagInfo.class);
    public final PBBoolField delPreEdit = PBField.initBool(false);
}
