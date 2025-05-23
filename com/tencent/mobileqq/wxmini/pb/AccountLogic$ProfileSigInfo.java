package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes35.dex */
public final class AccountLogic$ProfileSigInfo extends MessageMicro<AccountLogic$ProfileSigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"generate_time", "uin", "operation_type", "sig_check_pass", "sig_type", "third_part_info"}, new Object[]{0L, 0L, 0, Boolean.FALSE, 0, null}, AccountLogic$ProfileSigInfo.class);
    public final PBUInt64Field generate_time = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField operation_type = PBField.initEnum(0);
    public final PBBoolField sig_check_pass = PBField.initBool(false);
    public final PBEnumField sig_type = PBField.initEnum(0);
    public AccountLogic$ThirdPartRspInfo third_part_info = new AccountLogic$ThirdPartRspInfo();
}
