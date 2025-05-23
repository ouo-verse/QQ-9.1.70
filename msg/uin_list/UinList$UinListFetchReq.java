package msg.uin_list;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UinList$UinListFetchReq extends MessageMicro<UinList$UinListFetchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_store_key"}, new Object[]{ByteStringMicro.EMPTY}, UinList$UinListFetchReq.class);
    public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
