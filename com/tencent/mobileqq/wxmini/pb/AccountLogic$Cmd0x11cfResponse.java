package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11cfResponse extends MessageMicro<AccountLogic$Cmd0x11cfResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"unbind_result", "profile_sig", "secure_check_url"}, new Object[]{0, "", ""}, AccountLogic$Cmd0x11cfResponse.class);
    public final PBEnumField unbind_result = PBField.initEnum(0);
    public final PBStringField profile_sig = PBField.initString("");
    public final PBStringField secure_check_url = PBField.initString("");
}
