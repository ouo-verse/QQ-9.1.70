package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$SsoGetPayInfoReq extends MessageMicro<ExperienceSvipServerPB$SsoGetPayInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"aid", "business_type", "policy_id"}, new Object[]{"", 0, ""}, ExperienceSvipServerPB$SsoGetPayInfoReq.class);
    public final PBStringField aid = PBField.initString("");
    public final PBRepeatField<Integer> business_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField policy_id = PBField.initString("");
}
