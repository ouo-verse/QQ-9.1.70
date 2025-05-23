package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes35.dex */
public final class AccountLogic$ThirdPartRspInfo extends MessageMicro<AccountLogic$ThirdPartRspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", "wx_info"}, new Object[]{0, null}, AccountLogic$ThirdPartRspInfo.class);
    public final PBEnumField account_type = PBField.initEnum(0);
    public AccountLogic$WxRspInfo wx_info = new AccountLogic$WxRspInfo();
}
