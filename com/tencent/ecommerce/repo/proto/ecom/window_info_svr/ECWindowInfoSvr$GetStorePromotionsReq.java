package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$GetStorePromotionsReq extends MessageMicro<ECWindowInfoSvr$GetStorePromotionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 40}, new String[]{"req_source", "cookie", "scene", "owner_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0L}, ECWindowInfoSvr$GetStorePromotionsReq.class);
    public final PBUInt32Field req_source = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBUInt64Field owner_id = PBField.initUInt64(0);
}
