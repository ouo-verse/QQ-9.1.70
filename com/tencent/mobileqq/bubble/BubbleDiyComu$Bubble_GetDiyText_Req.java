package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BubbleDiyComu$Bubble_GetDiyText_Req extends MessageMicro<BubbleDiyComu$Bubble_GetDiyText_Req> {
    public static final int USER_TEXT_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_text_info"}, new Object[]{null}, BubbleDiyComu$Bubble_GetDiyText_Req.class);
    public final PBRepeatMessageField<BubbleDiyComu$UserTextInfo> user_text_info = PBField.initRepeatMessage(BubbleDiyComu$UserTextInfo.class);
}
