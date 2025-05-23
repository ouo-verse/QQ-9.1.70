package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class StaffGiftDrawBean$DeliverRsp extends MessageMicro<StaffGiftDrawBean$DeliverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0, ""}, StaffGiftDrawBean$DeliverRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381619msg = PBField.initString("");
}
