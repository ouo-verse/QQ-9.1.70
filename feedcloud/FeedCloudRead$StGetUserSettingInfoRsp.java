package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserSettingInfoRsp extends MessageMicro<FeedCloudRead$StGetUserSettingInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"urlInfo", "opmasks", "isPenguinUser"}, new Object[]{null, 0, 0}, FeedCloudRead$StGetUserSettingInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatField<Integer> opmasks = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field isPenguinUser = PBField.initUInt32(0);
}
