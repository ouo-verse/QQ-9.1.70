package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGIMemeOutput extends MessageMicro<FeedCloudSeedsvr$SEAGIMemeOutput> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"jsonData"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudSeedsvr$SEAGIMemeOutput.class);
    public final PBBytesField jsonData = PBField.initBytes(ByteStringMicro.EMPTY);
}
