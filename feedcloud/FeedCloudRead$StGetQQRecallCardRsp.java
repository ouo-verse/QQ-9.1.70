package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetQQRecallCardRsp extends MessageMicro<FeedCloudRead$StGetQQRecallCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cards"}, new Object[]{null}, FeedCloudRead$StGetQQRecallCardRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$StQQRecallCard> cards = PBField.initRepeatMessage(FeedCloudRead$StQQRecallCard.class);
}
