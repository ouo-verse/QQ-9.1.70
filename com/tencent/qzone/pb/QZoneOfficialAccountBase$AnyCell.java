package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$AnyCell extends MessageMicro<QZoneOfficialAccountBase$AnyCell> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"cell_type", "cell_data"}, new Object[]{0, ByteStringMicro.EMPTY}, QZoneOfficialAccountBase$AnyCell.class);
    public final PBUInt32Field cell_type = PBField.initUInt32(0);
    public final PBBytesField cell_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
