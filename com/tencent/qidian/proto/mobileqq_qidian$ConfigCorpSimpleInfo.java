package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ConfigCorpSimpleInfo extends MessageMicro<mobileqq_qidian$ConfigCorpSimpleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_corp_name", "str_short_name", "str_detail_desc", "str_click_url"}, new Object[]{"", "", "", ""}, mobileqq_qidian$ConfigCorpSimpleInfo.class);
    public final PBStringField str_corp_name = PBField.initString("");
    public final PBStringField str_short_name = PBField.initString("");
    public final PBStringField str_detail_desc = PBField.initString("");
    public final PBStringField str_click_url = PBField.initString("");
}
