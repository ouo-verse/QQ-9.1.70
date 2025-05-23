package com.tencent.pb.oac;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* loaded from: classes22.dex */
public final class OACProfilePb$BaseData extends MessageMicro<OACProfilePb$BaseData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField display_number = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField unified_account_descrpition = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBBoolField is_show_follow_button = PBField.initBool(false);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0);
    public final PBUInt64Field account_flag3 = PBField.initUInt64(0);
    public final PBStringField account_uid = PBField.initString("");
    public final PBBoolField is_mute = PBField.initBool(false);

    static {
        int[] iArr = {8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 240, 248, 256, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN};
        String[] strArr = {IPublicAccountBrowser.KEY_PUB_UIN, "name", "display_number", "summary", "unified_account_descrpition", "is_recv_msg", "is_recv_push", "account_type", "follow_type", "is_show_follow_button", "account_flag", "account_flag2", "account_flag3", "account_uid", "is_mute"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0L, "", "", "", "", bool, bool, 0, 0, bool, 0, 0L, 0L, "", bool}, OACProfilePb$BaseData.class);
    }
}
