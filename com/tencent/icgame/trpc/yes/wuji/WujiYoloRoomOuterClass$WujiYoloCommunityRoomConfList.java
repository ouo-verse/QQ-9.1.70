package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloCommunityRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloCommunityRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloCommunityRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.class);
}
