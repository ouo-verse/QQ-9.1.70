package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class StaffGiftDrawBean$DrawReq extends MessageMicro<StaffGiftDrawBean$DrawReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"orderNum"}, new Object[]{""}, StaffGiftDrawBean$DrawReq.class);
    public final PBStringField orderNum = PBField.initString("");
}
