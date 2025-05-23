package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$Service extends MessageMicro<ExperienceSvipServerPB$Service> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"service_type", "offer_id", ReportDataBuilder.KEY_PRODUCT_ID, "qq_product_name"}, new Object[]{"", "", "", ""}, ExperienceSvipServerPB$Service.class);
    public final PBStringField service_type = PBField.initString("");
    public final PBStringField offer_id = PBField.initString("");
    public final PBStringField product_id = PBField.initString("");
    public final PBStringField qq_product_name = PBField.initString("");
}
