package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppAd$StBatchGetAppPlayingFriReq extends MessageMicro<MiniAppAd$StBatchGetAppPlayingFriReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecAppId"}, new Object[]{null, ""}, MiniAppAd$StBatchGetAppPlayingFriReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> vecAppId = PBField.initRepeat(PBStringField.__repeatHelper__);
}
