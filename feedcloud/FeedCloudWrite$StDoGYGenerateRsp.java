package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoGYGenerateRsp extends MessageMicro<FeedCloudWrite$StDoGYGenerateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "infos", ITVKPlayerEventListener.KEY_USER_INFO}, new Object[]{null, null, null}, FeedCloudWrite$StDoGYGenerateRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudWrite$GYContentInfo> infos = PBField.initRepeatMessage(FeedCloudWrite$GYContentInfo.class);
    public FeedCloudWrite$QRCodeUserInfo userInfo = new MessageMicro<FeedCloudWrite$QRCodeUserInfo>() { // from class: feedcloud.FeedCloudWrite$QRCodeUserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"nick", "avatar", "sign"}, new Object[]{"", "", ""}, FeedCloudWrite$QRCodeUserInfo.class);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField avatar = PBField.initString("");
        public final PBStringField sign = PBField.initString("");
    };
}
