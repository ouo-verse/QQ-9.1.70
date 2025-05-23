package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11ceRequest extends MessageMicro<AccountLogic$Cmd0x11ceRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34, 42, 48}, new String[]{"profile_sig", "account_type", "third_part_info", "sig_info", "appid"}, new Object[]{"", 0, null, "", 0}, AccountLogic$Cmd0x11ceRequest.class);
    public final PBStringField profile_sig = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public AccountLogic$ThirdPartAccountQueryInfo third_part_info = new AccountLogic$ThirdPartAccountQueryInfo();
    public final PBStringField sig_info = PBField.initString("");
    public final PBEnumField appid = PBField.initEnum(0);
}
