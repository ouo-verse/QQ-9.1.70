package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$Cmd0x11d0Response extends MessageMicro<AccountLogic$Cmd0x11d0Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"third_part_info_list"}, new Object[]{null}, AccountLogic$Cmd0x11d0Response.class);
    public final PBRepeatMessageField<AccountLogic$ThirdPartRspInfo> third_part_info_list = PBField.initRepeatMessage(AccountLogic$ThirdPartRspInfo.class);
}
