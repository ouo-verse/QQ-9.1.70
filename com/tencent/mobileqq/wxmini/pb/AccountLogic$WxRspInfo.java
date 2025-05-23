package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$WxRspInfo extends MessageMicro<AccountLogic$WxRspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"union_id", "openid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "head_img_url", "accsess_token", "appid", "wx_func_token"}, new Object[]{"", "", "", "", "", "", ""}, AccountLogic$WxRspInfo.class);
    public final PBStringField union_id = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField head_img_url = PBField.initString("");
    public final PBStringField accsess_token = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField wx_func_token = PBField.initString("");
}
