package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$GetListReq extends MessageMicro<ECQshopLogisticsTemplateSvr$GetListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ThemeDIYDownloader.HEADER_PAGEINDEX, "page_size"}, new Object[]{0, 0}, ECQshopLogisticsTemplateSvr$GetListReq.class);
    public final PBUInt32Field page_index = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
}
