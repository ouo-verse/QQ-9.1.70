package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetDataMixReq extends MessageMicro<FeedCloudRead$GetDataMixReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uids", "cipher_uids", "fields"}, new Object[]{"", "", 0}, FeedCloudRead$GetDataMixReq.class);
    public final PBRepeatField<String> cipher_uids;
    public final PBRepeatField<Integer> fields;
    public final PBRepeatField<String> uids;

    public FeedCloudRead$GetDataMixReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.uids = PBField.initRepeat(pBStringField);
        this.cipher_uids = PBField.initRepeat(pBStringField);
        this.fields = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    }
}
