package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$RoomID extends MessageMicro<SmobaDataOuterClass$RoomID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"roomid", "roomseq", "roomsvrentityid"}, new Object[]{0, 0, 0}, SmobaDataOuterClass$RoomID.class);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt32Field roomseq = PBField.initUInt32(0);
    public final PBUInt32Field roomsvrentityid = PBField.initUInt32(0);
}
