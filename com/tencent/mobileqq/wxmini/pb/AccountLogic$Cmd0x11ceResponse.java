package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11ceResponse extends MessageMicro<AccountLogic$Cmd0x11ceResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 34, 42}, new String[]{"bind_result", "third_part_info", "profile_sig", "secure_check_url"}, new Object[]{0, null, "", ""}, AccountLogic$Cmd0x11ceResponse.class);
    public final PBEnumField bind_result = PBField.initEnum(0);
    public AccountLogic$ThirdPartRspInfo third_part_info = new AccountLogic$ThirdPartRspInfo();
    public final PBStringField profile_sig = PBField.initString("");
    public final PBStringField secure_check_url = PBField.initString("");
}
