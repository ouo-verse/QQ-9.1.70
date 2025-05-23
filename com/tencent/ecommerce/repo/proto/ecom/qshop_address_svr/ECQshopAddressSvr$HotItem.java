package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$HotItem extends MessageMicro<ECQshopAddressSvr$HotItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"province", "city"}, new Object[]{"", ""}, ECQshopAddressSvr$HotItem.class);
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
}
