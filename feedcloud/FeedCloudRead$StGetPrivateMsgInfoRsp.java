package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPrivateMsgInfoRsp extends MessageMicro<FeedCloudRead$StGetPrivateMsgInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ITVKPlayerEventListener.KEY_USER_INFO}, new Object[]{null}, FeedCloudRead$StGetPrivateMsgInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$PrivateMsgUserInfo> userInfo = PBField.initRepeatMessage(FeedCloudRead$PrivateMsgUserInfo.class);
}
