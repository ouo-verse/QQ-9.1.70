package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class delivery$ContentExt extends MessageMicro<delivery$ContentExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{QAdVrReport.ElementID.AD_TITLE, "ad_cover", "recall_source", "business_type"}, new Object[]{"", "", 0, 0}, delivery$ContentExt.class);
    public final PBStringField ad_title = PBField.initString("");
    public final PBStringField ad_cover = PBField.initString("");
    public final PBUInt32Field recall_source = PBField.initUInt32(0);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
}
