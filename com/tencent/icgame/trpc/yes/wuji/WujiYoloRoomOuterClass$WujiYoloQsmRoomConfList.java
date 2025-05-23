package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloQsmRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloQsmRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloQsmRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloQsmRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloQsmRoomConf.class);
}
