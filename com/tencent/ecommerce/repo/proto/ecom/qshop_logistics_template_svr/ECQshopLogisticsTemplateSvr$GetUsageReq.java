package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$GetUsageReq extends MessageMicro<ECQshopLogisticsTemplateSvr$GetUsageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"template_id", ThemeDIYDownloader.HEADER_PAGEINDEX, "page_size"}, new Object[]{0L, 0, 0}, ECQshopLogisticsTemplateSvr$GetUsageReq.class);
    public final PBInt64Field template_id = PBField.initInt64(0);
    public final PBUInt32Field page_index = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
}
