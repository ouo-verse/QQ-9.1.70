package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$VideoPic extends MessageMicro<ECQqShopDetailSvr$VideoPic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"vid", "url", "type", "duration", "cover"}, new Object[]{"", "", 0, 0L, ""}, ECQqShopDetailSvr$VideoPic.class);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBInt64Field duration = PBField.initInt64(0);
    public final PBStringField cover = PBField.initString("");
}
