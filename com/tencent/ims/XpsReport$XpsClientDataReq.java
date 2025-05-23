package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class XpsReport$XpsClientDataReq extends MessageMicro<XpsReport$XpsClientDataReq> {
    public static final int CCDATA_FIELD_NUMBER = 2;
    public static final int SCENE_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"scene_id", "ccdata"}, new Object[]{0, ByteStringMicro.EMPTY}, XpsReport$XpsClientDataReq.class);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBBytesField ccdata = PBField.initBytes(ByteStringMicro.EMPTY);
}
