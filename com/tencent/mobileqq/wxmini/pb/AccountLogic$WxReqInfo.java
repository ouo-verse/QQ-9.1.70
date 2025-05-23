package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$WxReqInfo extends MessageMicro<AccountLogic$WxReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"appid", "code", "union_id", "wx_message_assistant_binding_token", "openid", "wx_func_token"}, new Object[]{"", "", "", "", "", ""}, AccountLogic$WxReqInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField code = PBField.initString("");
    public final PBStringField union_id = PBField.initString("");
    public final PBStringField wx_message_assistant_binding_token = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField wx_func_token = PBField.initString("");
}
