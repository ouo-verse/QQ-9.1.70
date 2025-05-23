package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class StaffGiftDrawBean$DeliverReq extends MessageMicro<StaffGiftDrawBean$DeliverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{ByteStringMicro.EMPTY}, StaffGiftDrawBean$DeliverReq.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381618msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
