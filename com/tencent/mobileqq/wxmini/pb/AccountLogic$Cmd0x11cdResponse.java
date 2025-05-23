package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11cdResponse extends MessageMicro<AccountLogic$Cmd0x11cdResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"binding_state", "third_part_info", "uin_info"}, new Object[]{0, null, null}, AccountLogic$Cmd0x11cdResponse.class);
    public final PBEnumField binding_state = PBField.initEnum(0);
    public AccountLogic$ThirdPartRspInfo third_part_info = new AccountLogic$ThirdPartRspInfo();
    public AccountLogic$UinInfo uin_info = new AccountLogic$UinInfo();
}
