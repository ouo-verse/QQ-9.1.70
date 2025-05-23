package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$RecentGame extends MessageMicro<VMBasicInfo$RecentGame> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"app_version", "timestamp"}, new Object[]{"", 0L}, VMBasicInfo$RecentGame.class);
    public final PBStringField app_version = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
}
