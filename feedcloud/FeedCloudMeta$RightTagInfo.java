package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$RightTagInfo extends MessageMicro<FeedCloudMeta$RightTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"tagID", "tagName", SquareJSConst.Params.PARAMS_UIN_LIST, "updateTime"}, new Object[]{"", "", "", 0}, FeedCloudMeta$RightTagInfo.class);
    public final PBStringField tagID = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
}
