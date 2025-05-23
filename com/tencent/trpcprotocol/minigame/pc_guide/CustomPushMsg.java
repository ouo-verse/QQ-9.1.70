package com.tencent.trpcprotocol.minigame.pc_guide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class CustomPushMsg extends MessageMicro<CustomPushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "cover"}, new Object[]{"", ""}, CustomPushMsg.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
}
