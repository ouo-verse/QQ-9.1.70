package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ExternalInfo extends MessageMicro<mobileqq_qidian$ExternalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122, 128, 136, 144, 154, 160, 170, 178, 186, 194, 202, 208}, new String[]{"uint64_uin", "str_external_nick", "str_external_icon", "str_external_sign", "uint32_external_gender", "uint64_external_country", "uint64_external_province", "uint64_external_city", "uint64_external_district", "str_external_job", "str_external_tel", "str_external_mobile", "str_external_mail", "rpt_msg_pubacc_item", "rpt_msg_group_item", "uint64_master_uin", "uint32_verity", "uint32_entcallshow", "rpt_msg_company_show_case_info", "uint32_videoshow", "str_thirdpart_verity_icon", "str_thirdpart_verity_hover", "str_thirdpart_verity_url", "rpt_msg_pubacc_item_corp", "rpt_msg_group_item_corp", "uint64_external_oidbflag"}, new Object[]{0L, "", "", "", 0, 0L, 0L, 0L, 0L, "", "", "", "", null, null, 0L, 0, 0, null, 0, "", "", "", null, null, 0L}, mobileqq_qidian$ExternalInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBStringField str_external_nick = PBField.initString("");
    public final PBStringField str_external_icon = PBField.initString("");
    public final PBStringField str_external_sign = PBField.initString("");
    public final PBUInt32Field uint32_external_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_external_country = PBField.initUInt64(0);
    public final PBUInt64Field uint64_external_province = PBField.initUInt64(0);
    public final PBUInt64Field uint64_external_city = PBField.initUInt64(0);
    public final PBUInt64Field uint64_external_district = PBField.initUInt64(0);
    public final PBStringField str_external_job = PBField.initString("");
    public final PBStringField str_external_tel = PBField.initString("");
    public final PBStringField str_external_mobile = PBField.initString("");
    public final PBStringField str_external_mail = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_qidian$PubAccItem> rpt_msg_pubacc_item = PBField.initRepeatMessage(mobileqq_qidian$PubAccItem.class);
    public final PBRepeatMessageField<mobileqq_qidian$GroupItem> rpt_msg_group_item = PBField.initRepeatMessage(mobileqq_qidian$GroupItem.class);
    public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_verity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entcallshow = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_qidian$CompanyShowCaseInfo> rpt_msg_company_show_case_info = PBField.initRepeatMessage(mobileqq_qidian$CompanyShowCaseInfo.class);
    public final PBUInt32Field uint32_videoshow = PBField.initUInt32(0);
    public final PBStringField str_thirdpart_verity_icon = PBField.initString("");
    public final PBStringField str_thirdpart_verity_hover = PBField.initString("");
    public final PBStringField str_thirdpart_verity_url = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_qidian$PubAccItem> rpt_msg_pubacc_item_corp = PBField.initRepeatMessage(mobileqq_qidian$PubAccItem.class);
    public final PBRepeatMessageField<mobileqq_qidian$GroupItem> rpt_msg_group_item_corp = PBField.initRepeatMessage(mobileqq_qidian$GroupItem.class);
    public final PBUInt64Field uint64_external_oidbflag = PBField.initUInt64(0);
}
