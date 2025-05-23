package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$RichText extends MessageMicro<OfficialAssistant$RichText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"title", "pic_url", "description", "jump_url", "footer_text"}, new Object[]{"", "", "", "", ""}, OfficialAssistant$RichText.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField footer_text = PBField.initString("");
}
