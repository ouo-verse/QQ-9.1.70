package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetMatchSrcRsp extends MessageMicro<GetMatchSrcRsp> {
    public static final int MasterUinNotExist = 2;
    public static final int Ok = 0;
    public static final int ReqNumberLimitExceeded = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"MatchedInfoList", "Code", "ErrMsg"}, new Object[]{null, 0, ""}, GetMatchSrcRsp.class);
    public final PBRepeatMessageField<MatchedInfo> MatchedInfoList = PBField.initRepeatMessage(MatchedInfo.class);
    public final PBEnumField Code = PBField.initEnum(0);
    public final PBStringField ErrMsg = PBField.initString("");
}
