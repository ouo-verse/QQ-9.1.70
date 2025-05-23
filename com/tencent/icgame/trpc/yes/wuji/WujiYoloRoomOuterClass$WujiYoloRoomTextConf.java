package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiYoloRoomOuterClass$WujiYoloRoomTextConf extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloRoomTextConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "text"}, new Object[]{0, ""}, WujiYoloRoomOuterClass$WujiYoloRoomTextConf.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
}
