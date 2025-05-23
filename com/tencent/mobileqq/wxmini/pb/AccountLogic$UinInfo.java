package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$UinInfo extends MessageMicro<AccountLogic$UinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "head_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME}, new Object[]{0L, "", ByteStringMicro.EMPTY}, AccountLogic$UinInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField head_url = PBField.initString("");
    public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
