package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* loaded from: classes2.dex */
public final class clientbusilogic$PublicAccountInfo extends MessageMicro<clientbusilogic$PublicAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
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
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBStringField account_uid = PBField.initString("");
    public final PBBoolField is_mute = PBField.initBool(false);
    public final PBUInt32Field plugin_index = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 120, 160, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288}, new String[]{"name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "account_flag2", "account_type", "account_uid", "is_mute", "plugin_index"}, new Object[]{"", "", "", bool, bool, 0, bool, 0, 0, 0, 0L, 0L, 0, "", bool, 0}, clientbusilogic$PublicAccountInfo.class);
    }
}
