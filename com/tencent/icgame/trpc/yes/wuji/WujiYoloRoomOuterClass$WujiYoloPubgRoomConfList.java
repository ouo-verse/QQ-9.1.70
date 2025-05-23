package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloPubgRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloPubgRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloPubgRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloPubgRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloPubgRoomConf.class);
}
