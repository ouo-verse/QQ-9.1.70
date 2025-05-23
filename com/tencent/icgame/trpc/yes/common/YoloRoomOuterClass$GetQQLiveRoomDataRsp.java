package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$GetQQLiveRoomDataRsp extends MessageMicro<YoloRoomOuterClass$GetQQLiveRoomDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field enter_condition = PBField.initInt32(0);
    public final PBBoolField is_off_voice_to_live_room = PBField.initBool(false);
    public final PBBoolField is_off_enter_condition = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"enter_condition", "is_off_voice_to_live_room", "is_off_enter_condition"}, new Object[]{0, bool, bool}, YoloRoomOuterClass$GetQQLiveRoomDataRsp.class);
    }
}
