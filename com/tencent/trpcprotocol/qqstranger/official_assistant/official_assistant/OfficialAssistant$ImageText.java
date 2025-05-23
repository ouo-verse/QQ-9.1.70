package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$ImageText extends MessageMicro<OfficialAssistant$ImageText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "pic_url"}, new Object[]{"", ""}, OfficialAssistant$ImageText.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
}
