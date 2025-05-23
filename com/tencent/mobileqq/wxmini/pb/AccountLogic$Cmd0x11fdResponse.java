package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11fdResponse extends MessageMicro<AccountLogic$Cmd0x11fdResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"binding_state_qq", "bind_state_thirdpart", "third_part_info", "uin_info", "profile_sig"}, new Object[]{0, 0, null, null, ""}, AccountLogic$Cmd0x11fdResponse.class);
    public final PBEnumField binding_state_qq = PBField.initEnum(0);
    public final PBEnumField bind_state_thirdpart = PBField.initEnum(0);
    public AccountLogic$ThirdPartRspInfo third_part_info = new AccountLogic$ThirdPartRspInfo();
    public AccountLogic$UinInfo uin_info = new AccountLogic$UinInfo();
    public final PBStringField profile_sig = PBField.initString("");
}
