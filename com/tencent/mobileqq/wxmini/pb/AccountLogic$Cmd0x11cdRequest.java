package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11cdRequest extends MessageMicro<AccountLogic$Cmd0x11cdRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", "third_part_info"}, new Object[]{0, null}, AccountLogic$Cmd0x11cdRequest.class);
    public final PBEnumField account_type = PBField.initEnum(0);
    public AccountLogic$ThirdPartReqInfo third_part_info = new AccountLogic$ThirdPartReqInfo();
}
