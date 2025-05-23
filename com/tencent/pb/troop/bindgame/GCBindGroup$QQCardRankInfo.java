package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GCBindGroup$QQCardRankInfo extends MessageMicro<GCBindGroup$QQCardRankInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"summary", "rank"}, new Object[]{"", 0}, GCBindGroup$QQCardRankInfo.class);
    public final PBStringField summary = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
}
