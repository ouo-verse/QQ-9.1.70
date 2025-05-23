package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RichTitleElement extends MessageMicro<NowQQLiveHomepageProto$RichTitleElement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "string_text", "string_url"}, new Object[]{0, "", ""}, NowQQLiveHomepageProto$RichTitleElement.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField string_text = PBField.initString("");
    public final PBStringField string_url = PBField.initString("");
}
