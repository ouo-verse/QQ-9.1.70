package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DynamicNickModule extends MessageMicro<DynamicNickModule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"style_type", QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, "style_description", "style_url", "style_id"}, new Object[]{0L, "", "", "", 0}, DynamicNickModule.class);
    public final PBUInt64Field style_type = PBField.initUInt64(0);
    public final PBStringField style_name = PBField.initString("");
    public final PBStringField style_description = PBField.initString("");
    public final PBStringField style_url = PBField.initString("");
    public final PBUInt32Field style_id = PBField.initUInt32(0);
}
