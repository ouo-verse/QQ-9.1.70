package com.tencent.icgame.trpc.yes.common;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$GetYoloRoomDataRsp extends MessageMicro<YoloRoomOuterClass$GetYoloRoomDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{PictureConst.KEY_HAS_MORE, "action_list", "online_num", "uid_list"}, new Object[]{0, null, 0, 0L}, YoloRoomOuterClass$GetYoloRoomDataRsp.class);
    public final PBInt32Field has_more = PBField.initInt32(0);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomAction> action_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomAction.class);
    public final PBInt32Field online_num = PBField.initInt32(0);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
