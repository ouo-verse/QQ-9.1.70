package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class chatbgInfo$Bg_Effect_Auth_Rst extends MessageMicro<chatbgInfo$Bg_Effect_Auth_Rst> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"effectId", "result"}, new Object[]{0, 0}, chatbgInfo$Bg_Effect_Auth_Rst.class);
    public final PBInt32Field effectId = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
}
