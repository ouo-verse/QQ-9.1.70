package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$ModifyQQLiveRoomDataReq extends MessageMicro<YoloRoomOuterClass$ModifyQQLiveRoomDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"live_uid", "enter_condition"}, new Object[]{0L, 0}, YoloRoomOuterClass$ModifyQQLiveRoomDataReq.class);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
    public final PBInt32Field enter_condition = PBField.initInt32(0);
}
