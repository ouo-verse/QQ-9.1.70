package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* loaded from: classes15.dex */
public final class mobileqq_mp$PublicAccountInfo extends MessageMicro<mobileqq_mp$PublicAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField display_number = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp$ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(mobileqq_mp$ConfigGroupInfo.class);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0);
    public final PBStringField account_uid = PBField.initString("");
    public final PBBoolField is_mute = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 120, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN}, new String[]{"uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new", "account_flag2", "account_uid", "is_mute"}, new Object[]{0, "", "", "", bool, bool, 0, bool, 0, 0, 0, 0L, null, null, 0L, "", bool}, mobileqq_mp$PublicAccountInfo.class);
    }
}
