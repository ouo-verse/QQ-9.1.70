package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$SendGoodsInfoToChannelReq extends MessageMicro<ECWindowInfoSvr$SendGoodsInfoToChannelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"req_source", "guild_id", "guild_owner"}, new Object[]{0, 0L, 0L}, ECWindowInfoSvr$SendGoodsInfoToChannelReq.class);
    public final PBUInt32Field req_source = PBField.initUInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field guild_owner = PBField.initUInt64(0);
}
