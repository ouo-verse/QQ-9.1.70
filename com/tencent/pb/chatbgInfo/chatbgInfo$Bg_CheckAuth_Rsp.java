package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class chatbgInfo$Bg_CheckAuth_Rsp extends MessageMicro<chatbgInfo$Bg_CheckAuth_Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"AuthRst", "AuthEffectRst"}, new Object[]{null, null}, chatbgInfo$Bg_CheckAuth_Rsp.class);
    public final PBRepeatMessageField<chatbgInfo$Bg_Auth_Rst> AuthRst = PBField.initRepeatMessage(chatbgInfo$Bg_Auth_Rst.class);
    public final PBRepeatMessageField<chatbgInfo$Bg_Effect_Auth_Rst> AuthEffectRst = PBField.initRepeatMessage(chatbgInfo$Bg_Effect_Auth_Rst.class);
}
