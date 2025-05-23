package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$MultiImageText extends MessageMicro<OfficialAssistant$MultiImageText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"image_text_lst"}, new Object[]{null}, OfficialAssistant$MultiImageText.class);
    public final PBRepeatMessageField<OfficialAssistant$ImageText> image_text_lst = PBField.initRepeatMessage(OfficialAssistant$ImageText.class);
}
