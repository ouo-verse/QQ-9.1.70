package msg.uin_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UinList$UinListFetchRsp extends MessageMicro<UinList$UinListFetchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_result", "friend_list"}, new Object[]{0, null}, UinList$UinListFetchRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<UinList$C2C> friend_list = PBField.initRepeatMessage(UinList$C2C.class);
}
