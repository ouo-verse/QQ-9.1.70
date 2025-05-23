package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloCfmRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloCfmRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloCfmRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloCfmRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloCfmRoomConf.class);
}
