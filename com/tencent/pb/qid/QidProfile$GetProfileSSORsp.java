package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QidProfile$GetProfileSSORsp extends MessageMicro<QidProfile$GetProfileSSORsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66}, new String[]{"is_set", "pag_url", "pic_url", "bg_url", "main_url", "btn_color", "is_lm_show", "qid"}, new Object[]{0, "", "", "", "", "", 0, ""}, QidProfile$GetProfileSSORsp.class);
    public final PBInt32Field is_set = PBField.initInt32(0);
    public final PBStringField pag_url = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField bg_url = PBField.initString("");
    public final PBStringField main_url = PBField.initString("");
    public final PBStringField btn_color = PBField.initString("");
    public final PBInt32Field is_lm_show = PBField.initInt32(0);
    public final PBStringField qid = PBField.initString("");
}
