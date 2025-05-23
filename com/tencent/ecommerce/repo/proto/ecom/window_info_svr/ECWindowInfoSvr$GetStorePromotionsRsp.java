package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$GetStorePromotionsRsp extends MessageMicro<ECWindowInfoSvr$GetStorePromotionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"shops", "cookie", "is_end"}, new Object[]{null, ByteStringMicro.EMPTY, 0}, ECWindowInfoSvr$GetStorePromotionsRsp.class);
    public final PBRepeatMessageField<ECWindowInfoSvr$ShowWindowInfo> shops = PBField.initRepeatMessage(ECWindowInfoSvr$ShowWindowInfo.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
}
