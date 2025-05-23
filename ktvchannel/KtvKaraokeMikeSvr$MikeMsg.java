package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$MikeMsg extends MessageMicro<KtvKaraokeMikeSvr$MikeMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_text", "ext_info"}, new Object[]{"", null}, KtvKaraokeMikeSvr$MikeMsg.class);
    public final PBStringField msg_text = PBField.initString("");
    public final PBRepeatMessageField<KtvCommon$KVItem> ext_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
