package msg.uin_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UinList$UinListUploadReq extends MessageMicro<UinList$UinListUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_cmd", "friend_list"}, new Object[]{0, null}, UinList$UinListUploadReq.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<UinList$C2C> friend_list = PBField.initRepeatMessage(UinList$C2C.class);
}
