package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes38.dex */
public final class Prompt$GetMsgBoxBannerReq extends MessageMicro<Prompt$GetMsgBoxBannerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"gender"}, new Object[]{0}, Prompt$GetMsgBoxBannerReq.class);
    public final PBEnumField gender = PBField.initEnum(0);
}
