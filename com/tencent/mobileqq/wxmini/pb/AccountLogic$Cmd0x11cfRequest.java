package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11cfRequest extends MessageMicro<AccountLogic$Cmd0x11cfRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34, 42, 48, 56}, new String[]{"profile_sig", "account_type", "third_part_info", "sig_info", "is_been_confirmed", "appid"}, new Object[]{"", 0, null, "", Boolean.FALSE, 0}, AccountLogic$Cmd0x11cfRequest.class);
    public final PBStringField profile_sig = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public AccountLogic$ThirdPartAccountQueryInfo third_part_info = new AccountLogic$ThirdPartAccountQueryInfo();
    public final PBStringField sig_info = PBField.initString("");
    public final PBBoolField is_been_confirmed = PBField.initBool(false);
    public final PBEnumField appid = PBField.initEnum(0);
}
