package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class JDSearch$JdSearchDetail extends MessageMicro<JDSearch$JdSearchDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50}, new String[]{ServiceConst.PARA_SESSION_ID, "errorcode", "errormsg", "jd_sku_item", "jd_more_url", "rectangle"}, new Object[]{"", 0, "", null, "", null}, JDSearch$JdSearchDetail.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<JDSearch$JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch$JdSkuItem.class);
    public final PBStringField jd_more_url = PBField.initString("");
    public JDSearch$Rectangle rectangle = new JDSearch$Rectangle();
}
