package com.tencent.relation.common.qqstranger.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class Security$IegVerifiedCheckRsp extends MessageMicro<Security$IegVerifiedCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"ret_code", "err_msg", "instruction_type", "jump_url", "document_config"}, new Object[]{0, "", 0, "", null}, Security$IegVerifiedCheckRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBEnumField instruction_type = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public Security$DocumentConfig document_config = new Security$DocumentConfig();
}
