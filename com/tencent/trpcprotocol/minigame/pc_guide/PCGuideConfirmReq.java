package com.tencent.trpcprotocol.minigame.pc_guide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class PCGuideConfirmReq extends MessageMicro<PCGuideConfirmReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"appid", "push_msg", "src"}, new Object[]{"", null, 0}, PCGuideConfirmReq.class);
    public final PBStringField appid = PBField.initString("");
    public CustomPushMsg push_msg = new CustomPushMsg();
    public final PBInt32Field src = PBField.initInt32(0);
}
