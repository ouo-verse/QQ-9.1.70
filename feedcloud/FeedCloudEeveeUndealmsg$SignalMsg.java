package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeUndealmsg$SignalMsg extends MessageMicro<FeedCloudEeveeUndealmsg$SignalMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"signalBuff", "msgid"}, new Object[]{ByteStringMicro.EMPTY, ""}, FeedCloudEeveeUndealmsg$SignalMsg.class);
    public final PBBytesField signalBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField msgid = PBField.initString("");
}
