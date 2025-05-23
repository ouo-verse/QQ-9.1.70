package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$RightInfo extends MessageMicro<FeedCloudMeta$RightInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"rightFlag", "tagList", SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0, null, ""}, FeedCloudMeta$RightInfo.class);
    public final PBEnumField rightFlag = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudMeta$RightTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$RightTagInfo.class);
    public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
