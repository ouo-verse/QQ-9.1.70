package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$CheckFeedOwnerRsp extends MessageMicro<FeedCloudRead$CheckFeedOwnerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isOwner"}, new Object[]{Boolean.FALSE}, FeedCloudRead$CheckFeedOwnerRsp.class);
    public final PBBoolField isOwner = PBField.initBool(false);
}
