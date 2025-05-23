package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetSellerAddressListReq extends MessageMicro<ECQshopAddressSvr$GetSellerAddressListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"address_type", ThemeDIYDownloader.HEADER_PAGEINDEX, "page_size"}, new Object[]{0, 0, 0}, ECQshopAddressSvr$GetSellerAddressListReq.class);
    public final PBUInt32Field address_type = PBField.initUInt32(0);
    public final PBUInt32Field page_index = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
}
