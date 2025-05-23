package msg.uin_list;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UinList$UinListUploadRsp extends MessageMicro<UinList$UinListUploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"int32_result", "bytes_store_key", "silence_period"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, UinList$UinListUploadRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field silence_period = PBField.initUInt32(0);
}
