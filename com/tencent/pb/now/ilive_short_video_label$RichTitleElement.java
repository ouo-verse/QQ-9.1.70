package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$RichTitleElement extends MessageMicro<ilive_short_video_label$RichTitleElement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "string_text", "string_url"}, new Object[]{0, "", ""}, ilive_short_video_label$RichTitleElement.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField string_text = PBField.initString("");
    public final PBStringField string_url = PBField.initString("");
}
