package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetGCRealAppInfoReq extends MessageMicro<VMBasicInfo$GetGCRealAppInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"src", "app_id"}, new Object[]{0, ""}, VMBasicInfo$GetGCRealAppInfoReq.class);
    public final PBEnumField src = PBField.initEnum(0);
    public final PBStringField app_id = PBField.initString("");
}
