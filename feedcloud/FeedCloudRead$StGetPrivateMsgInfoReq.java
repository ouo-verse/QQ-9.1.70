package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.data.SquareJSConst;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPrivateMsgInfoReq extends MessageMicro<FeedCloudRead$StGetPrivateMsgInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{null, 0L}, FeedCloudRead$StGetPrivateMsgInfoReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Long> uinList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
