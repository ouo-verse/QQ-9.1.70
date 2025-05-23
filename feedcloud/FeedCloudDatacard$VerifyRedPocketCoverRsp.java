package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$VerifyRedPocketCoverRsp extends MessageMicro<FeedCloudDatacard$VerifyRedPocketCoverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"valid"}, new Object[]{Boolean.FALSE}, FeedCloudDatacard$VerifyRedPocketCoverRsp.class);
    public final PBBoolField valid = PBField.initBool(false);
}
