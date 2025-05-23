package NS_MINI_AD;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class MiniAppAd$StBatchGetAppPlayingFriRsp extends MessageMicro<MiniAppAd$StBatchGetAppPlayingFriRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecAppPlayingFri"}, new Object[]{null, null}, MiniAppAd$StBatchGetAppPlayingFriRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<MiniAppAd$StAppPlayingFriList> vecAppPlayingFri = PBField.initRepeatMessage(MiniAppAd$StAppPlayingFriList.class);
}
