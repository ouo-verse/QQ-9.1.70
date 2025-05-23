package com.tencent.trpcprotocol.minigame.pc_guide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class GetPCGuideRsp extends MessageMicro<GetPCGuideRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_guide", "bubble_text"}, new Object[]{Boolean.FALSE, ""}, GetPCGuideRsp.class);
    public final PBBoolField show_guide = PBField.initBool(false);
    public final PBStringField bubble_text = PBField.initString("");
}
