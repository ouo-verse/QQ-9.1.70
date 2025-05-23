package com.tencent.trpcprotocol.qqva.ai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DrawCards$GetFeedsEntranceReq extends MessageMicro<DrawCards$GetFeedsEntranceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"robot_uin"}, new Object[]{""}, DrawCards$GetFeedsEntranceReq.class);
    public final PBStringField robot_uin = PBField.initString("");
}
