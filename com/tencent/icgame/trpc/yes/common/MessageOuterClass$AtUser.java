package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$AtUser extends MessageMicro<MessageOuterClass$AtUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_id", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "head_url"}, new Object[]{null, "", ""}, MessageOuterClass$AtUser.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField head_url = PBField.initString("");
}
