package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetPublicAccountDetailInfoResponse extends MessageMicro<mobileqq_mp$GetPublicAccountDetailInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__;
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField display_number = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp$ConfigGroupInfo.class);
    public final PBBoolField is_show_share_button = PBField.initBool(false);
    public final PBBoolField is_show_follow_button = PBField.initBool(false);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBStringField config_background_color = PBField.initString("");
    public final PBStringField config_background_img = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(mobileqq_mp$ConfigGroupInfo.class);
    public final PBStringField certified_description = PBField.initString("");
    public final PBStringField unified_account_descrpition = PBField.initString("");
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0);
    public final PBStringField account_uid = PBField.initString("");

    static {
        String[] strArr = {"ret_info", "seqno", "uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "config_group_info", "is_show_share_button", "is_show_follow_button", "follow_type", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_background_color", "config_background_img", "config_group_info_new", IPublicAccountConfigAttr.CERT_DESP, "unified_account_descrpition", "account_flag2", "account_uid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 162, 170, 178, 186, 192, 210}, strArr, new Object[]{null, 0, 0, "", "", "", bool, bool, 0, null, bool, bool, 0, bool, 0, 0, 0, 0L, "", "", null, "", "", 0L, ""}, mobileqq_mp$GetPublicAccountDetailInfoResponse.class);
    }
}
